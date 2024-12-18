package com.philips.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerServicePage extends BasePage{

	@FindBy(xpath = "//a[@title='Account']")
	public WebElement home_Tab;
	
	@FindBy(xpath = "//a[@title='Locations']")
	public WebElement location_Tab;
	
	@FindBy(xpath = "//a[@title='Account']")
	public WebElement account_Tab;
	
	@FindBy(xpath = "//a[@title='Installed Products']")
	public WebElement installedProduct_Tab;
	
	@FindBy(xpath = "//a[@title='Cases']")
	public WebElement cases_Tab;
	
	@FindBy(xpath="//*[text()='Reports']")
	public WebElement reports_tab;
	
	@FindBy(xpath="//*[text()='Standard Reports']")
	public WebElement standard_report;
	
	@FindBy(xpath="//*[text()='PRS Reports']")
	public WebElement PRSreport;
	
	@FindBy(xpath = "//span[text()='Tanveer Automation']")
	public WebElement logout_drop;

	@FindBy(xpath = "//a[text()='Logout']")
	public WebElement logout;
	
	public CustomerServicePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void verifyPage(){
		waitTill("5");
		click("home_Tab", home_Tab);
		waitTill("5");
		embedScreenShotInreport();
		waitTill("5");
		click("location_Tab", location_Tab);
		waitTill("5");
		embedScreenShotInreport();
		waitTill("5");
		click("account_Tab", account_Tab);
		waitTill("5");
		embedScreenShotInreport();
		waitTill("5");
		click("installedProduct_Tab", installedProduct_Tab);
		waitTill("5");
		embedScreenShotInreport();
		waitTill("5");
		click("cases_Tab", cases_Tab);
		waitTill("5");
		embedScreenShotInreport();
	}
	public void verifyReports(){
		waitTill("5");
		click("reports_tab", reports_tab);
		waitTill("5");
		embedScreenShotInreport();
		waitTill("5");
		click("standard_report", standard_report);
		waitTill("5");
		embedScreenShotInreport();
		waitTill("5");
		click("reports_tab", reports_tab);
		waitTill("5");
		embedScreenShotInreport();
		waitTill("5");
		click("PRSreport", PRSreport);
		waitTill("5");
		embedScreenShotInreport();
	}
	public void logout_CSPortal(){
		waitTill("5");
		embedScreenShotInreport();
		click("logout_dro", logout_drop);
		waitTill("3");
		click("logout_dro", logout);
	}
}
