package com.philips.generic;

import java.util.HashMap;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	private static BrowserFactory instance = null;
	ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	private BrowserFactory() {

	}

	public static BrowserFactory getInstance() {
		if(instance == null) {
			return instance = new BrowserFactory();
		}
		return instance;
	}

	public WebDriver getDriverInstance() 
	{
		 if(AutomationConstants.Browser.equalsIgnoreCase("Chrome"))
	        {
	            System.setProperty("webdriver.chrome.driver", AutomationConstants.chromeDriverPath);
	            System.setProperty("webdriver.chrome.driver",AutomationConstants.chromeDriverPath);
	            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
	            chromePrefs.put("plugins.always_open_pdf_externally", true);
	            chromePrefs.put("profile.default_content_settings.popups", 0);
	            chromePrefs.put("download.default_directory", AutomationConstants.DownloadsFolder);
	            ChromeOptions options = new ChromeOptions();
	            options.setExperimentalOption("prefs", chromePrefs);
	            options.addArguments("--window-size=1920,1080");
	            options.addArguments("--disable-web-security");
	            webDriver.set(new ChromeDriver(options));
	            return webDriver.get();
	        }
		else
		{
			System.setProperty("webdriver.chrome.driver", AutomationConstants.chromeDriverPath);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080","--ignore-certificate-errors");  
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
			webDriver.set(new ChromeDriver(options));
			return webDriver.get();
		}
	}
}
