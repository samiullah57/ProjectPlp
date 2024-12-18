
package com.philips.stepdefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.philips.cucumber.listener.Reporter;
import com.philips.generic.AutomationConstants;
import com.philips.generic.AzureIntegrationAPIs;
import com.philips.generic.BrowserFactory;
import com.philips.generic.SOQLQuerys;
import com.philips.generic.Utility;
import com.philips.pages.LeanFTPage;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks
{
	public static String scenarioName;
	public static String testcaseNumber;
	static Logger log = Logger.getLogger("BaseLib");
	public static HashMap<String, WebDriver> driverInstances = new HashMap<String, WebDriver>();
	@Before
	public void beforemethod(Scenario scenario) throws Exception {
		//if(!driverInstances.containsKey(String.valueOf(Thread.currentThread().getId()))) 
		{
			String temp = scenario.getName();
			System.out.println(temp);
			testcaseNumber = temp.substring(0,temp.indexOf(':'));
			BrowserFactory obj = BrowserFactory.getInstance();
			driverInstances.put(String.valueOf(Thread.currentThread().getId()), obj.getDriverInstance());
			driverInstances.get(String.valueOf(Thread.currentThread().getId())).manage().deleteAllCookies();
			driverInstances.get(String.valueOf(Thread.currentThread().getId())).manage().timeouts().implicitlyWait(Long.parseLong(AutomationConstants.TimeOut),TimeUnit.SECONDS);
			driverInstances.get(String.valueOf(Thread.currentThread().getId())).manage().window().maximize();
			//Reporter.addScenarioLog(scenario.getName());
			log.info(Utility.getFormatedDateTime()+" : "+scenario.getName());
		}	
	}


	@After
	public void embedScreenshot(Scenario scenario)throws IOException
	{ 
		String testName = scenario.getName();
		if(scenario.isFailed())
		{
			Reporter.addScreenCaptureFromPath(Utility.getPageScreenShot(driverInstances.get(String.valueOf(Thread.currentThread().getId()))), "Failed");
			if(AutomationConstants.UpdateAzureTMT.equalsIgnoreCase("Yes"))
			{
				AzureIntegrationAPIs.UpdateResults(testName.substring(0,testName.indexOf(':')), "Failed");
			}	
		}
		else
		{
			Reporter.addScreenCaptureFromPath(Utility.getPageScreenShot(driverInstances.get(String.valueOf(Thread.currentThread().getId()))), "Passed");
			if(AutomationConstants.UpdateAzureTMT.equalsIgnoreCase("Yes"))
			{
				AzureIntegrationAPIs.UpdateResults(testName.substring(0,testName.indexOf(':')), "Passed");
			}
		}

		driverInstances.get(String.valueOf(Thread.currentThread().getId())).quit();
		LeanFTPage.closeSAP();

	}

}
