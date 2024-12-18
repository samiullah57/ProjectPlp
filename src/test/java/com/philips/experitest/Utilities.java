package com.philips.experitest;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.philips.generic.AutomationConstants;
import com.philips.generic.configs.EnvironmentFactory;

public class Utilities {
    private static final String ACCESSKEY = EnvironmentFactory.getSeeTestConfig("AccessKey");
    protected static AutomationConstants constant;
    
    String CLOUDURL = constant.SeeTestURL + "/wd/hub/";
    String testName= "Selenium Test on Chrome";
    RemoteWebDriver driver;
  
    public Utilities(WebDriver driver2) {
		// TODO Auto-generated constructor stub
	}


	@BeforeMethod
    public void setUp() throws Exception {
  
        //Set Browser Type
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
  
        //Set Grid capabilities
        dc.setCapability("accessKey", "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51IjozNjY2MSwieHAucCI6MTQyMSwieHAubSI6MTYwODExMzcyNDk2MywiZXhwIjoxOTIzNDczNzI2LCJpc3MiOiJjb20uZXhwZXJpdGVzdCJ9.aoRLP8v4EYuKBe0e27MUoTtN74Ook0t_sFaSvYglANc");
        dc.setCapability("generateReport", true);
        dc.setCapability("testName", testName);
  
        driver = new RemoteWebDriver(new URL(CLOUDURL), dc);
    }
  
  
    @Test
    public void testSeleniumOnChrome() {
        driver.get("https://seetest.io");
  
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Manual']")));
        WebElement manualNavLink = driver.findElement(By.xpath("//*[text()='Manual']"));
        manualNavLink.click();
  
        WebElement automationNavLink = driver.findElement(By.xpath("//*[text()='Automation']"));
        automationNavLink.click();
  
        WebElement webinarFooterLink = driver.findElement(By.xpath("//*[text()='Webinars']"));
  
        webinarFooterLink.click();
  
        String webinarH2TitleText = driver.findElement(By.xpath("//h2[1]")).getText();
  
        System.out.println("The title of the first h2 is: " + webinarH2TitleText);
  
    }
  
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
  
}