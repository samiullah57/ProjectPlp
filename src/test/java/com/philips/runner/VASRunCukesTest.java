package com.philips.runner;

import java.io.File;
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.PropertyConfigurator;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.philips.cucumber.listener.ExtentProperties;
import com.philips.cucumber.listener.Reporter;
import com.philips.generic.AutomationConstants;
import com.philips.generic.AzureIntegrationAPIs;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * A sample test to demonstrate
 */
@RunWith(Cucumber.class)
@CucumberOptions(


		features = {"C:\\Philips\\R2R_Phase2\\R2RCucumberBDD\\src\\test\\resources\\features\\Pipeline1_Phase1.feature"},
		glue = {"com.philips.stepdefinitions"},
		tags = {"@453845"},
		plugin = {"com.philips.cucumber.listener.ExtentCucumberFormatter:output/report.html"}

		)
public class VASRunCukesTest extends AbstractTestNGCucumberTests
{
	@BeforeSuite
	public void initFramework() throws IOException
	{
		//Utility.clearDirectory(AutomationConstants.screenShotsFolderPath);
		PropertyConfigurator.configure(AutomationConstants.log4jPath);
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		extentProperties.setProjectName("Philips");
		extentProperties.setReportPath("output/myreport.html");
		if(AutomationConstants.UpdateAzureTMT.equalsIgnoreCase("Yes"))
		{
			AzureIntegrationAPIs.fetchTestData();
		}

	}

	@AfterSuite
	public void TearDown() throws ClientProtocolException, IOException
	{      

		Reporter.loadXMLConfig(new File("C:\\Philips\\R2R_Phase2\\R2RCucumberBDD\\src\\test\\resources\\extent-config.xml"));
		//Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("os", "Windows");
		Reporter.setTestRunnerOutput("Philips test runner output message");

		if(AutomationConstants.UpdateAzureTMT.equalsIgnoreCase("Yes"))
		{
			AzureIntegrationAPIs.updateTestRun();
		}
	}
}