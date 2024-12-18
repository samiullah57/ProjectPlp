package com.philips.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.philips.generic.AutomationConstants;

public class LocationPage extends BasePage {
	
	ServiceMaxCaseDetailsPage caseDetailsPage;
	
	public LocationPage(WebDriver driver) {
		super(driver);
		caseDetailsPage = new ServiceMaxCaseDetailsPage(driver);
	}
	
	@FindBy(xpath = "//iframe[contains(@title,'Site_Wizard')]")
	public WebElement site_wizard_iframe;
	
	@FindBy(xpath = "//input[@value='Create T&M Case and CaseLines']")
	public WebElement create_TM_Case_SFM;
	

	public void createTMCase() {
		
		enterFieldValuesInCase();
		click("save_case", save_case);
		waitLoadingSpinnerToDisappear();
		waitTill("25");
		if (verifyElementPresent("Case Details", case_Details)) {
			click("Case Details", case_Details);
		}
		waitForElement(manage_WorkOrder_Frame, "manage_WorkOrder_Frame");
		embedScreenShotInreport();
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("CASE_NUMBER", case_Number.getText());
		scrollByViewOfElement(site_case);
		embedScreenShotInreport();
		
	}
	
	
	public void enterFieldValuesInCase() {
		waitTill("10");
		waitForElement(site_wizard_iframe, "site_wizard_iframe");
		embedScreenShotInreport();
		try {
			driver.switchTo().frame(site_wizard_iframe);
		} catch (Exception e) {
			driver.switchTo()
					.frame(driver.findElement(By.xpath("//iframe[contains(@title,'Site_Wizard')]")));
		}
		waitTill("5");
		clickEvent(create_TM_Case_SFM);
		waitLoadingSpinnerToDisappear();
		waitTill("15");
		enter("Contact name", contactID_Input, "Automation Test Contact");
		waitTill("6");
		driver.findElement(By.xpath("//*[text()='Contact ID:']/parent::td/following-sibling::td//*[@role='button']"))
				.click();
		waitLoadingSpinnerToDisappear();
		waitTill("10");
		waitForElement(contact_ID_fullname, "contact_ID_fullname");
		waitTill("10");
		driver.findElement(By.xpath("//span[text()='Full Name']/../../../../../following-sibling::div//tr/td/div"))
				.click();
		waitTill("5");
		embedScreenShotInreport();
		click("select_Contact_id_fullname", select_Contact_id_fullname);
		waitTill("5");
		click("sales_dropdwn", sales_dropdwn);
		if(AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("FUNLOC1").contains("US")) {
		driver.findElement(By.xpath("//li[text()='US93']")).click();
		}
		else if(AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("FUNLOC1").contains("ES")) {
			driver.findElement(By.xpath("//li[text()='ES93']")).click();
		}
		waitTill("5");
		
		enter("Subject", subject, "Test");
		enter("description", description, "Test Data");
		click("Add Row_CaseLines",addRow.get(0));
		waitTill("3");
		embedScreenShotInreport();
	}

	
	public void verifyTMCaseWithPMHistory() {
		waitTill("3");
		embedScreenShotInreport();
		
		enterFieldValuesInCase();
		
		click("Extended Edit",extended_Edit.get(0));
		
		caseDetailsPage.addipDetails("ip1");
		
		waitTill("3");
		scrollByViewOfElement(addRow.get(0));
		embedScreenShotInreport();
		click("save_case", save_case);
		waitSpinnerToDisappear();
		
		
	}
	

}
