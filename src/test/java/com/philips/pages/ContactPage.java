package com.philips.pages;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.philips.generic.AutomationConstants;

import junit.framework.Assert;

public class ContactPage extends BasePage {

	@FindBy(xpath = "//iframe[@title='Contact_Wizard']")
	private WebElement contact_Frame;

	@FindBy(xpath = "//*[text()='Actions On Contacts']")
	private WebElement contact_Detail;

	@FindBy(xpath = "//input[@value='Create Case']")
	private WebElement create_Case;

	@FindBy(xpath = "//div[@id='svmx_sfm_delivery_root_container0_header']")
	private WebElement create_Case_Dialog;

	@FindBy(xpath = "//label[text()='Unknown Installed Product:']/parent::td/following-sibling::td/input")
	private WebElement unknownInstalledPRoduct;

	@FindBy(xpath = "//label[text()='Unknown Product Type:']/parent::td/following-sibling::td//div[@role='button']")
	private WebElement unknownProductType;

	@FindBy(xpath = "//label[text()='Event Type:']/parent::td/following-sibling::td//div[@role='button']")
	private WebElement eventTypeBTN;

	@FindBy(xpath = "//label[text()='Priority:']/parent::td/following-sibling::td//div[@role='button']")
	private WebElement priorityBTN;

	@FindBy(xpath = "//label[text()='Case Origin:']/parent::td/following-sibling::td//div[@role='button']")
	private WebElement case_Origin;

	@FindBy(xpath = "//label[text()='Case Source:']/parent::td/following-sibling::td//div[@role='button']")
	private WebElement case_Source;

	@FindBy(xpath = "//label[text()='Sales Org:']/parent::td/following-sibling::td//div[@role='button']")
	private WebElement sales_Org;

	@FindBy(xpath = "//label[text()='Subject:']/parent::td/following-sibling::td/input")
	private WebElement subject;

	@FindBy(xpath = "//label[text()='Description:']/parent::td/following-sibling::td/textarea")
	private WebElement description;

	@FindBy(xpath = "//*[@data-qtip='Save']")
	private WebElement save_Case;

	@FindBy(xpath = "//input[@name='new']")
	private WebElement new_Contact;

	@FindBy(xpath = "//select[@id='p3']")
	private WebElement recordType;

	@FindBy(xpath = "//input[@title='Continue']")
	private WebElement continueBTN;

	@FindBy(xpath = "//*[text()='Account Name']/parent::td/following-sibling::td//span/input")
	private WebElement account_Name_Search;

	@FindBy(xpath = "//a[@title='Account Name Lookup (New Window)']")
	private WebElement account_Search_BTN;

	@FindBy(xpath = "//frame[@title='Results']")
	private WebElement resultsFrame;

	@FindBy(xpath = "//*[text()='Last Name']/parent::td/following-sibling::td//input")
	private WebElement lastName;

	@FindBy(xpath = "//span[@id='Contact.Phone-_help']/parent::td/following-sibling::td//input")
	private WebElement phone;

	@FindBy(xpath = "//input[@title='Save']")
	private WebElement saveBTN;

	@FindBy(xpath = "//span[text()='Error Details']")
	private WebElement caseCreationError;

	@FindBy(xpath = "//span[text()='Case Number']/following-sibling::span/span")
	private WebElement case_Number;

	@FindBy(xpath = "//input[@value='Create Contract']")
	private WebElement ch_createContract;

	@FindBy(xpath = "//label[text()='Service Plan:']/../..//input")
	private WebElement servicePlan;

	@FindBy(xpath = "//label[text()='Plan Type:']/../..//input")
	private WebElement planType;

	@FindBy(xpath = "//label[text()='Billing Schedule:']/../..//input")
	private WebElement BillingSchedule;

	@FindBy(xpath = "//label[text()='Service Plan:']/../..//span[@class='svmx-btn-icon svmx_lookup_icon']")
	private WebElement servicePlanLookup;

	@FindBy(xpath = "//div[@class='svmx-grid-cell-inner ' and text()='Primary']")
	private WebElement PrimaryValue;

	@FindBy(xpath = "//a[text()='Service Board']")
	private WebElement service_Board;

	@FindBy(xpath = "//input[@placeholder='Search Job List']")
	private WebElement search_WO;

	@FindBy(xpath = "//input[@placeholder='Search All Resources']")
	private WebElement search_Service_User;

	@FindBy(xpath = "//li[text()='Create Appointment']")
	public WebElement appointmet_Tab;

	@FindBy(xpath = "//div[@fid='esmx_schedule_status']//px-dropdown")
	public WebElement schedule_status;

	@FindBy(xpath = "//button[text()='Save']")
	public WebElement save_Appointment;
	
	@FindBy(xpath = "//*[text()='Integration Message']/../preceding-sibling::td/div[1]")
	public WebElement integrationStatus;

	@FindBy(xpath = "//*[text()='Integration Message']/../following-sibling::td/div")
	public WebElement integrationMessage;

	@FindBy(xpath = "//*[text()='Other Phone']/../preceding-sibling::td/div")
	public WebElement contact_externalID;

	public ContactPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public void create_Contact(String rec, String acc) {
		waitForElement(contact_Tab, "contact_Tab");
		click("contact_Tab", contact_Tab);
		waitForElement(new_Contact, "new_Contact");
		click("new_Contact", new_Contact);
		waitForElement(recordType, "recordType");
		selectbyValue(recordType, rec, rec);
		click("continueBTN", continueBTN);
		waitForElement(account_Name_Search, "account_Name_Search");
		String parent = driver.getWindowHandle();
		enter("account_Name_Search", account_Name_Search, acc);
		click("account_Search_BTN", account_Search_BTN);
		waitTill("5");
		for (String one : driver.getWindowHandles()) {
			if (!one.equalsIgnoreCase(parent)) {
				driver.switchTo().window(one);
			}
		}
		driver.switchTo().frame(resultsFrame);
		waitForElement(driver.findElement(By.xpath("//a[text()='" + acc + "']")), acc);
		click(acc, driver.findElement(By.xpath("//a[text()='" + acc + "']")));
		driver.switchTo().window(parent);
		String ContactName = getUniquename("Automation");
		enter("Last name", lastName, ContactName);
		waitForElement(phone, "phone");
		enter("Last phone", phone, "08012345");
		embedScreenShotInreport();
		click("Save", saveBTN);
		waitTill("5");
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("CONTACT", ContactName);
	}

	public void createContractfromContractHeader() {
		driver.get("https://philipsb2bsc--emsmq3.my.salesforce.com/a4D4W00000027gtUAA");
		waitTill("5");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Contract_Header_VF_Page']")));
		click("Create Contract", ch_createContract);
		driver.switchTo().defaultContent();
		enter("Service Plan", servicePlan, "Primary");
		click("Service Plan Lookup icon", servicePlanLookup);
		click("Primary Value", PrimaryValue);
		click("Select Button", smaxlookupSelectButton);
		waitTill("5");
		enter("Plan Type", planType, "Billable");
		enter("Billing Schedule", BillingSchedule, "Annual");
		click("Save Button", saveButton);

	}

	public void dispatch_WorkOrder_Technician_ServiceBoard() {
		waitTill("6");
		driver.navigate().refresh();
		waitTill("30");
		try {
			driver.findElement(By.xpath("//span[text()='Work Details (Work Order)']/parent::a")).click();
		} catch (Exception e) {
		}
		waitTill("30");
		try {
			if (driver.findElement(By.xpath("//*[text()='Shipped']")).isDisplayed())
				;
		} catch (Exception e) {
			driver.navigate().refresh();
			waitTill("30");
		}
		String parent = driver.getWindowHandle();
		clickEvent(homeTab);
		waitTill("5");
		clickEvent(service_Board);
		waitTill("5");
		Set<String> windows = driver.getWindowHandles();
		for (String win : windows) {
			if (!win.equals(parent)) {
				driver.switchTo().window(win);
				break;
			}
		}
		System.out.println("SERVICE AMX CONSOLE:" + driver.getCurrentUrl());
		System.out.println("SERVICE AMX CONSOLE:" + driver.getTitle());
		// waitForElement(service_Team_eExpand,"waitForElement");
		// clickEvent(service_Team_eExpand);
		String workOrder = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("WORK_ORDER_NUMBER");
		String xpath = "//*[text()='" + workOrder + "']";

		System.out.println("CONTRACT_HEADER_SAP_EXTERNAL_ID:"
				+ AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CONTRACT_HEADER_SAP_EXTERNAL_ID"));
		System.out.println(
				"SAP_EXTERNAL_ID:" + AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("SAP_EXTERNAL_ID"));
		System.out.println("SAP_INTEGRATION_STATUS:"
				+ AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("SAP_INTEGRATION_STATUS"));
		System.out.println(
				"CONTRACT_NUMBER:" + AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CONTRACT_NUMBER"));
		System.out.println(
				"CONTRACT_HEADER:" + AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CONTRACT_HEADER"));
		System.out
				.println("SAP_SALES_ORG:" + AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("SAP_SALES_ORG"));
		System.out.println("INSTALLED_PRODUCT_ID:"
				+ AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("INSTALLED_PRODUCT_ID"));
		System.out.println("PLANT:" + AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("PLANT"));
		System.out.println("CASE_NUMBER:" + AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CASE_NUMBER"));
		System.out.println(
				"WORK_ORDER_NUMBER:" + AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("WORK_ORDER_NUMBER"));

		waitTill("5");
		waitForElement(search_WO, "Dispatch Console");
		enter("Search WO", search_WO, workOrder);
		// enter("Search WO", search_WO, "WO-02302596");
		waitTill("5");
		clickEvent(driver.findElement(By.xpath("//div[text()='" + workOrder + "']")));
		enter("search_Service_User", search_Service_User, BaseLib.TestData.get(0).get("Service Technician"));
		waitTill("5");
		clickEvent(driver
				.findElement(By.xpath("//div[text()='" + BaseLib.TestData.get(0).get("Service Technician") + "']")));
		waitTill("5");
		WebElement ele1 = driver.findElement(By.xpath("//div[text()='" + workOrder + "']/.."));
		WebElement ele3 = driver.findElement(By.xpath("//div[text()='Unscheduled']/.."));

		System.out.println("Cordinates:" + ele1.getLocation().x);
		System.out.println("Cordinates:" + ele1.getLocation().y);
		System.out.println("Cordinates:" + ele3.getLocation().x);
		System.out.println("Cordinates:" + ele3.getLocation().y);
		// WebElement
		// ele1=driver.findElement(By.xpath("//div[@class='card__container']"));
		WebElement ele2 = driver.findElement(By.xpath("//div[@class='dc-gantt__shift-segment']/../.."));
		waitTill("5");
		dragAndDrop(ele1, ele2, ele3);
		waitTill("5");
		// dragDrops();
		// click_Sikuli("Drag_Uns.PNG");
		create_Appointment();
		waitTill("5");

		driver.switchTo().window(parent);
	}

	public void create_Appointment() {

		waitTill("5");
		waitForElement(appointmet_Tab, "waitForElement");
		// clickEvent(schedule_status);
		// WebElement shadowRoot1 = getShadowRootElement(schedule_status);
		// WebElement shadowElement =
		// shadowRoot1.findElement(By.cssSelector("div#label.dropdown-label"));
		// waitTill("5");
		// clickEvent(shadowElement);
		// WebElement root1 =
		// driver.findElement(By.tagName("downloads-manager"));
		WebElement shadow_root1 = getShadowRootElement(schedule_status);
		waitTill("5");
		WebElement root2 = shadow_root1.findElement(By.cssSelector("px-dropdown-trigger#trigger"));
		WebElement shadow_root2 = getShadowRootElement(root2);
		waitTill("5");

		WebElement search_button = shadow_root2.findElement(By.cssSelector("div#label.dropdown-label"));
		// search_button.click();
		clickEvent(search_button);
		waitTill("5");
		selectDispatched();
	}

	public void selectDispatched() {

		WebElement shadow_root1 = getShadowRootElement(schedule_status);
		waitTill("5");
		WebElement root2 = shadow_root1.findElement(By.cssSelector("px-dropdown-content#content"));
		WebElement shadow_root2 = getShadowRootElement(root2);
		waitTill("5");
		// WebElement root3 =
		// shadow_root2.findElement(By.cssSelector("px-dropdown-content#content"));
		// WebElement shadow_root3 = getShadowRootElement(root3);
		waitTill("5");
		WebElement root = shadow_root2.findElement(By.cssSelector("iron-dropdown#dropdown.dropdown"));

		WebElement dispatched = root.findElement(By.cssSelector("span.dropdown-option__item.truncate"));
		// WebElement dispatched =
		// root.findElement(By.xpath("//div[@title='Dispatched']"));
		clickEvent(dispatched);
		waitTill("5");
		clickEvent(save_Appointment);
		waitTill("6");
		try {
			while (driver.findElement(By.xpath("//span[text()='Failed to create Appointment.']")).isDisplayed()) {
				driver.close();
				dispatch_WorkOrder_Technician_ServiceBoard();
			}
		} catch (Exception e) {
		}
	}

	public WebElement getShadowRootElement(WebElement element) {
		WebElement ele = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot",
				element);
		return ele;
	}
	
	public void verifyIntegrationStatus(String integraionStatus) {
		embedScreenShotInreport();
		System.out.println("Contact SAP ExternalID: " + contact_externalID.getText());
		embedScreenShotInreport();
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("CONTACT_EXTERNALID", contact_externalID.getText());
		embedScreenShotInreport();
		verifyTextContains(integrationStatus, integraionStatus);

	}
	
	public void create_case(String productType, String eventType, String priority, String caseOrigin, String casesrc,
			String salesOrg) {

		waitTill("5");
		waitForElement(contact_Detail, "contact_Detail");
		driver.switchTo().frame(contact_Frame);
		embedScreenShotInreport();
		click("create_Case", create_Case);
		waitForElement(create_Case_Dialog, "create_Case_Dialog");
		waitForElement(unknownInstalledPRoduct, "unknownInstalledPRoduct");
		click("unknownInstalledPRoduct", unknownInstalledPRoduct);
		click("unknownProductType", unknownProductType);
		driver.findElement(By.xpath("//li[text()='" + productType + "']")).click();
		waitTill("5");
		waitForElement(eventTypeBTN, "eventType");
		click("eventType", eventTypeBTN);
		driver.findElement(By.xpath("//li[text()='" + eventType + "']")).click();
		click("priorityBTN", priorityBTN);
		driver.findElement(By.xpath("//li[text()='" + priority + "']")).click();
		click("case_Origin", case_Origin);
		driver.findElement(By.xpath("//li[text()='" + caseOrigin + "']")).click();
		waitTill("5");
		click("case_Source", case_Source);
		driver.findElement(By.xpath("//li[text()='" + casesrc + "']")).click();
		waitTill("5");
		click("sales_Org", sales_Org);
		driver.findElement(By.xpath("//li[text()='" + salesOrg + "']")).click();
		waitForElement(subject, "Subject");
		enter("Subject", subject, "Test");
		enter("description", description, "Test Data");
		waitForElement(save_Case, "save_Case");
		click("save_Case", save_Case);
		waitTill("6");
		try {
			waitForElement(caseCreationError, "caseCreationError");
			assertTrue("Case Creation Failed", caseCreationError.isDisplayed());
		} catch (Exception e) {
		}
		waitForElement(detailsTab, "createWorkOrders");
		embedScreenShotInreport();
		click("case_Details", detailsTab);
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("CONTACT_CASE_NUMBER", case_Number.getText());
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("CASE_NUMBER", case_Number.getText());
	}

}
