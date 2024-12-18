/**
 *	This class contains all functions required for navigating through the Accounts object.
 * @author M1028261
 *	@since	01/12/2020
 */

package com.philips.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.philips.generic.AutomationConstants;
import com.philips.generic.Utility;

public class AccountsPage extends BasePage {
	@FindBy(xpath = "//*[@title=' create contact from Account']")
	private WebElement CreateContact;

	@FindBy(xpath = "//*[@id='sfm-text-1038-inputEl']")
	private WebElement firstName;

	@FindBy(xpath = "//*[@id='sfm-text-1041-inputEl']")
	private WebElement lastName;

	@FindBy(xpath = "//*[@id='sfm-phone-1034-inputEl']")
	private WebElement businessPhone;

	@FindBy(xpath = "//*[text()='Other Phone']/../preceding-sibling::td/div")
	private WebElement SAPExID;

	@FindBy(xpath = "//*[@id='Account_Tab']/a")
	private WebElement AccountTab;

	@FindBy(xpath = "//*[@id='User_body']/table/tbody/tr[2]/th/div/div/a")
	private WebElement ClickUser;

	@FindBy(xpath = "//*[contains(@id, 'ACCOUNT_NAME')]/a/span")
	private WebElement AccountName;

	@FindBy(xpath = "//button[@class = 'svmx-btn-center' and @data-qtip = 'Save']")
	private WebElement SaveButton;

	@FindBy(xpath = "//iframe[@title='Account_Wizard']")
	private WebElement account_iframe_servicewizard;

	@FindBy(xpath = "//input[@value='Create Contact']")
	private WebElement create_Contact;

	@FindBy(xpath = "//*[text()='First Name:']/../following-sibling::td/input")
	private WebElement acct_cont_fName;

	@FindBy(xpath = "//*[text()='Last Name:']/../following-sibling::td/input")
	private WebElement acct_cont_lastName;

	@FindBy(xpath = "//*[text()='Business Phone:']/../following-sibling::td/input")
	private WebElement acct_cont_phnum;

	@FindBy(xpath = "//*[text()='Language:']/parent::td/following-sibling::td//div[@role='button']")
	private WebElement acct_cont_language;

	@FindBy(xpath = "//input[@value=' New ']")
	private WebElement accountNew;

	@FindBy(xpath = "//select[@id='p3']")
	private WebElement newAccountType;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;

	@FindBy(xpath = "//input[@id='acc2']")
	private WebElement newAccountName;

	@FindBy(xpath = "//*[text()='SAP External ID']//../../following-sibling::td/div/input")
	private WebElement newSAPExternalID;

	@FindBy(xpath = "//*[@id='topButtonRow']/input[@value=' Save ']")
	private WebElement accountSave;

	public AccountsPage(WebDriver driver) {
		super(driver);
	}
	/**
	 * @author M1028261 This function is used to Create Contact from an Account.
	 */
	public void CreateContactfromAccount() {
		waitTill("4");
		embedScreenShotInreport();
		SwitchtoFramesByID("066E0000001hAQK");
		waitTill("4");
		embedScreenShotInreport();
		waitForElement(CreateContact, "Create Contact");

		//Utility.highlightElement(driver, CreateContact);

		embedScreenShotInreport();
		click("Create Contact", CreateContact);
		waitTill("5");
		embedScreenShotInreport();
		//driver.switchTo().defaultContent();
		waitTill("10");
		embedScreenShotInreport();
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("CONTACT_FN", "AccountFN"+Utility.randomNumber(3));
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("CONTACT_LN", "AccountLN"+Utility.randomNumber(3));
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("CONTACT_BUSPHONE", Integer.toString(Utility.randomNumber(10)));
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("CONTACT_LANGUAGE", "English");
		//Utility.highlightElement(driver, firstName);
		embedScreenShotInreport();
		enter("First Name", firstName, AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CONTACT_FN"));
		//Utility.highlightElement(driver, lastName);
		embedScreenShotInreport();
		enter("Last Name", lastName, AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CONTACT_LN"));
		//Utility.highlightElement(driver, businessPhone);
		embedScreenShotInreport();
		enter("Business Phone", businessPhone, AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CONTACT_BUSPHONE"));
		WebComboBox("(//input[contains(@id, 'sfm-picklist')])[2]", AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CONTACT_LANGUAGE"),
				"//li[contains(@class, 'svmx-boundlist-item')]");
		//Utility.highlightElement(driver, SaveButton);
		embedScreenShotInreport();
		click("Save", SaveButton);
		waitTill("6");
		refreshPage(driver);
		waitTill("5");
		SwitchtoFramesByID("066E0000001hAQK");
		// Utility.highlightElement(driver, SAPExID);
		// embedScreenShotInreport();
		// verifyIsDisplayed(SAPExID, "SAP External ID");
		// scrollByViewOfElement(SAPExID);
		// embedScreenShotInreport();
		driver.switchTo().defaultContent();
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("CONTACT_NAME", contact_Name.getText());
	}
	/**
	 * @author M1028261 This function is used to create a view to filter out
	 *         Accounts based on given criteria.
	 * @param searchCriteria 
	 */
	public void SearchForAccount(String[] FieldName, String[] Operator, String[] Value) {
		waitTill("5");
		Utility.highlightElement(driver, AccountTab);
		embedScreenShotInreport();
		click("Account Tab", AccountTab);
		waitTill("5");
		CreateView(FieldName, Operator, Value);
		waitTill("5");

		Utility.highlightElement(driver, AccountName);
		embedScreenShotInreport();
		click("Account Name", AccountName);
		embedScreenShotInreport();
	}

	public void createcontact_foraccount() {

		waitForElement(account_iframe_servicewizard, "Account Service Wizard");
		driver.navigate().refresh();
		waitTill("5");
		driver.switchTo().frame(account_iframe_servicewizard);
		waitTill("5");
		clickEvent(create_Contact);
		waitLoadingSpinnerToDisappear();
		waitForElement(creat_Case_dialog, "creat_Case_dialog");
		waitForElement(acct_cont_fName, "Account Contact First name");
		clickEvent(acct_cont_fName);
		enter("First name", acct_cont_fName, "Automation");
		clickEvent(acct_cont_lastName);
		enter("Last name", acct_cont_lastName, "Test1");
		waitForElement(acct_cont_phnum, "Account Phone number");
		enter("Business Phone", acct_cont_phnum, "12345678");
		click("Language dropdown", acct_cont_language);
		WebElement langdrop=driver.findElement(By.xpath("//li[text()='English']"));
		click("language value", langdrop);
		click("save_case", save_case);
		waitLoadingSpinnerToDisappear();
	}


	/*
	 * This function is used to create an Account from Tab
	 */
	public void create_Account_from_Tab() {

		click("Account Tab", AccountTab);
		waitTill("5");
		Utility.highlightElement(driver, AccountTab);
		embedScreenShotInreport();
		click("New Button", newButton);
		//Utility.highlightElement(driver, newButton);
		embedScreenShotInreport();
		selectbyValue(newAccountType, "ServiceMax Account", "ServiceMax Account");
		click("Continue", continueButton);
		//Utility.highlightElement(driver, continueButton);
		embedScreenShotInreport();
		waitTill("5");
		int SAPExternalID = Utility.randomNumber(10);
		enter("Account Name", newAccountName, "TestAcount");
		//Utility.highlightElement(driver, newAccountName);
		embedScreenShotInreport();
		enter("SAPExternalID", newSAPExternalID, Integer.toString(SAPExternalID));
		//Utility.highlightElement(driver, newSAPExternalID);
		embedScreenShotInreport();

	}

	public void clickOnAccountTab() {
		Utility.highlightElement(driver, AccountTab);
		embedScreenShotInreport();
		click("Account Tab", AccountTab);
		waitTill("5");

	}

	public void verifyNewButton() {
		verifyIsNotDisplayed(newButton, "New Button");

	}

}