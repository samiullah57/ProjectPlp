package com.philips.pages;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.philips.generic.AutomationConstants;
import com.philips.generic.Utility;
import com.philips.stepdefinitions.Hooks;

public class ServiceMaxCaseDetailsPage extends BasePage {
	@FindBy(xpath = "//span[text()='Escalation Originated Work order']/../..//img[@title='Not Checked']")
	WebElement escalationOriginatedWO;

	WorkOrderPage woPage;
	public static String WO1;
	public static String WO2;
	public static String WO3;
	public static String Escalatecaserecord;

	public ServiceMaxCaseDetailsPage(WebDriver driver) {
		super(driver);
		woPage = new WorkOrderPage(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@value = 'Create Work Order(Remote Clinical)']")
	private WebElement RemoteClinical;

	@FindBy(xpath = "//span[text()='Product']/../..//a")
	WebElement productlink;

	@FindBy(xpath = "//span[text()='Business Unit']/../..//td[@class='dataCol col02']")
	WebElement BUtext;

	@FindBy(xpath = "//span[text()='Business Group']/../..//td[@class='dataCol col02']")
	WebElement BGtext;

	@FindBy(xpath = "//input[@value='Escalate Case']")
	WebElement Escalatecase;

	@FindBy(xpath = "//label[text()='Escalation Title:']/../..//textarea")
	WebElement escalationTitle;

	@FindBy(xpath = ".//*[@id='ext-gen1166']")
	WebElement escalation_categorydropdown;

	@FindBy(xpath = "//li[text()='Clinical']")
	WebElement clinicalvalue;

	@FindBy(xpath = "//input[@value='Cancel Escalation']")
	WebElement cancelEscalation;

	@FindBy(xpath = "//span[text()='Escalation Status']/../..//div[text()='New']")
	WebElement Escalationstatus;

	@FindBy(xpath = "//span[text()='Case Escalated']/../..//img[@title='Checked']")
	WebElement caseEscalatedcheckbox;

	@FindBy(xpath = "//span[text()='Unassigned Escalation']/../..//img[@title='Checked']")
	WebElement unassignedEscalation;

	@FindBy(xpath = "//span[text()='Escalation Initiator']/../..//a")
	WebElement escalationInitiator;

	@FindBy(xpath = "(//span[text()='Escalation Owner']/../..//div)[2]")
	WebElement escalationOwner;

	@FindBy(xpath = "//input[@value='Accept Escalation']")
	private WebElement AcceptEC;

	@FindBy(xpath = "//span[@class='svmx-btn-icon svmx-sfmd-save-icon']")
	private WebElement saveAcceptEC;

	@FindBy(xpath = "//input[@value='Create New Action Request for L2/L3']")
	private WebElement createNewAction;

	@FindBy(xpath = "//label[text()='Action Title:']/../..//input")
	private WebElement actiontitle;

	@FindBy(xpath = "//label[text()='Action Description:']/../..//textarea")
	private WebElement actiondesc;

	@FindBy(xpath = "//label[text()='Action Due Date:']/../..//input")
	private WebElement actionDueDate;

	@FindBy(xpath = "//label[text()='Action Owner:']/../..//span[@class='svmx-btn-icon svmx_lookup_icon']")
	private WebElement actionOwnerlookup;

	@FindBy(xpath = "//label[text()='Action Owner Role:']/../..//div[contains(@class,'svmx-trigger-index-0 svmx-form-trigger')]")
	private WebElement actionOwnerRole;

	@FindBy(xpath = "//li[text()='L2-Clinical']")
	private WebElement L2Clinical;

	@FindBy(xpath = "//input[@value='Accept Action Request']")
	private WebElement acceptActionRequest;

	@FindBy(xpath = "//iframe[@title='Case_Line_Wizard']")
	private WebElement caselineframe;

	@FindBy(xpath = "//input[@value='Manage Action Request']")
	private WebElement manageActionRequest;

	@FindBy(xpath = "//input[@value='Close Action Request']")
	private WebElement closeActionRequest;

	@FindBy(xpath = "//label[text()='Response Description:']/../..//textarea")
	private WebElement responseDescription;

	@FindBy(xpath = "//span[@class='svmx-btn-icon svmx-sfmd-add-line-icon']")
	private WebElement plusiconofDate;

	@FindBy(xpath = "//div[text()='End Date Time']")
	private WebElement enddatetimehead;

	@FindBy(xpath = "(//div[@class='svmx-grid-cell-inner '])[3]")
	private WebElement endDateTimeinput;

	@FindBy(xpath = "//input[contains(@class,'svmx-field-default-form-focus')]")
	private WebElement inputfields;

	@FindBy(xpath = "(//td[@class='svmx-trigger-cell'])[17]")
	private WebElement subjectdropdown;

	@FindBy(xpath = "//li[text()='Administration']")
	private WebElement administrationvalue;

	@FindBy(xpath = "//input[@value='Debrief and Follow Up']")
	private WebElement DebriefandFollowup;

	@FindBy(xpath = "//input[@value='Debrief and Follow up']")
	private WebElement debriefFollow;

	@FindBy(xpath = "//input[@value='Complete Work Order']")
	private WebElement completeWO;

	@FindBy(xpath = "//span[text()='Order Status']/../..//td[@class='dataCol col02 inlineEditWrite']")
	private WebElement orderstatus;

	@FindBy(xpath = "//select/option[text()='Fixed']")
	private WebElement fixedstatus;

	@FindBy(xpath = "//input[@value='PSF Safety Form']")
	private WebElement PSFform;

	@FindBy(xpath = "(//button[@class='ui-datepicker-trigger'])[1]")
	private WebElement dateofOccurence;

	@FindBy(xpath = "(//button[@class='ui-datepicker-trigger'])[2]")
	private WebElement dateofIncident;

	@FindBy(xpath = "//a[text()='24']")
	private WebElement day;

	@FindBy(xpath = "(//b[contains(text(),'Potential safety')]/..//select)[1]")
	private WebElement potentialsafety;

	@FindBy(xpath = "(//b[contains(text(),'Potential safety')]/..//select)[1]/option[text()='Other']")
	private WebElement potentialsafetyvalue;

	@FindBy(xpath = "(//b[contains(text(),'Potential safety')]/..//select)[2]")
	private WebElement userinvolved;

	@FindBy(xpath = "(//b[contains(text(),'Potential safety')]/..//select)[2]/option[text()='Unknown']")
	private WebElement unknownvalue;

	@FindBy(xpath = "(//b[contains(text(),'Procedure outcome')]/../..//input)[19]")
	private WebElement procedureoutcome;

	@FindBy(xpath = "(//b[contains(text(),'Potential safety')]/..//select)[11]")
	private WebElement actionreqd;

	@FindBy(xpath = "(//b[contains(text(),'Potential safety')]/..//select)[10]")
	private WebElement issuereported;

	@FindBy(xpath = "//input[@value='Update Escalation Details']")
	private WebElement updateEscalationDetails;

	@FindBy(xpath = "//label[text()='Action Plan Summary:']/../..//textarea")
	private WebElement actionPlansummary;

	@FindBy(xpath = "//input[@value='Cancel Escalation']")
	private WebElement cancelesc;

	@FindBy(xpath = "//label[text()='Closed Case Comment:']/../..//textarea")
	private WebElement closedcasecomments;

	@FindBy(xpath = "//span[text()='Case Escalated']/../..//img[@alt='Not Checked']")
	private WebElement caseEscalateduncheckbox;

	@FindBy(xpath = "//span[text()='Escalation Status']/../..//div[text()='Canceled']")
	private WebElement esccancelledStatus;

	@FindBy(xpath = "//td[text()='Case Record Type']/../..//div[text()='Closed Support Escalation']")
	private WebElement caseRecordtypeafterCancelesc;

	@FindBy(xpath = "//input[@value='Create Remote Service Work Order']")
	WebElement create_Remote_workOrder;
	
	@FindBy(xpath = "//input[@value='Business Complete']")
	WebElement business_complete_sfm;

	@FindBy(xpath = "//input[@value='Initiate Remote Service']")
	WebElement initiateRemoveService;

	@FindBy(xpath = "//*[@data-qtip='Save']")
	WebElement saveRemoteservice;

	@FindBy(xpath = "//*[text()='Details']/..")
	WebElement caseDetails;

	@FindBy(xpath = "//*[contains(text(), 'Bench Status Tracker Number:')]")
	private WebElement bench_Status_TrackerNumber_Head;

	@FindBy(xpath = "//*[contains(text(), 'BST')]")
	private WebElement bench_Status_TrackerNumber_Value;

	@FindBy(xpath = "//*[contains(@value,'Step 1: Update Tracking/Courier Number')][contains(@class,'svmxbtn')]")
	private WebElement Step1_Update_TrackingOrCourier_Number_Button;

	@FindBy(xpath = "//span[@id='sfm-button-1057-btnIconEl']")
	private WebElement update_TrackingoRCourier_No_SaveButton;

	@FindBy(xpath = "//*[@id='sfm-textarea-1030-inputEl']")
	private WebElement incoming_BenchTracking_Field;

	@FindBy(xpath = "//*[@class='pageTitleIcon']")
	private WebElement page_Title_Icon;

	@FindBy(xpath = "//*[@class='pageDescription']")
	private WebElement case_No;

	@FindBy(xpath = "//*[contains(text(), 'BST')]")
	private WebElement bst_Link;

	@FindBy(xpath = ".//input[@id='phSearchInput']")
	private WebElement globalSearchBox;

	@FindBy(xpath = ".//input[@id='phSearchButton']")
	private WebElement globalSearchButton;

	@FindBy(xpath = "//*[contains(text(), 'Incoming Bench Tracking & Courier Number')]//parent::tr//td[contains(@class, 'inlineEditWrite')]//div")
	private WebElement incomingBenchTrackingCourierNumber_Value;

	@FindBy(xpath = "//*[contains(@value,'Step 2: Set Status To Decontamination Complete')][contains(@class,'svmxbtn')]")
	private WebElement Step2_Set_Status_To_Decontamination_Complete_Button;

	@FindBy(xpath = "//*[contains(text(), 'Decontamination Complete')][@class='svmx-grid-cell-inner ']")
	private WebElement benchRepairStatus_FieldValue;

	@FindBy(xpath = "//*[contains(text(), 'Feed')][@class='optionLabel']")
	private WebElement toggleTo_Feed;

	@FindBy(xpath = "//*[contains(text(), 'Details')][@class='optionLabel']")
	private WebElement toggleTo_Details;

	@FindBy(xpath = "//*[contains(@value, 'Safety Question')][contains(@class, 'svmxbtn')]")
	private WebElement safetyQuestion_Button;

	@FindBy(xpath = ".//*[@data-qtip='Save']")
	private WebElement esmx_SafetyQstn_Save_Button;

	@FindBy(xpath = "//*[text()= 'Save']")
	private WebElement SafetyQstn_TransactionManager_Save_Button;

	@FindBy(xpath = "//*[contains(text(), 'Ans1:')]//parent::td//parent::tr//input")
	private WebElement ans1_InputField;

	@FindBy(xpath = "//*[contains(text(), 'Ans2:')]//parent::td//parent::tr//input")
	private WebElement ans2_InputField;

	@FindBy(xpath = "//*[contains(text(), 'Request Bench Assessment')]//parent::tr//td[@class='dataCol inlineEditWrite']")
	private WebElement request_Bench_Assessment_Image;
	// *[contains(text(), 'Request Bench
	// Assessment')]//parent::tr//td[@class='dataCol inlineEditWrite']//img

	@FindBy(xpath = "//*[contains(text(), 'Request Bench Assessment')]//parent::tr//td[contains(@class, 'dataCol inlineEditWrite')]//input")
	private WebElement request_Bench_Assessment_CheckBox;

	@FindBy(xpath = "//input[@name='inlineEditSave']")
	private WebElement caseDetil_InLine_SaveButton;

	@FindBy(xpath = "//*[contains(@value, 'Create Local Bench Work Order')]")
	private WebElement createLocalBenchWorkOrder_Button;

	@FindBy(xpath = "//*[contains(text(), 'Work Order Number:')]//parent::li//span[@class='rspropertyvalue']")
	private WebElement workOrderNumber_Label;

	@FindBy(xpath = "//*[contains(text(), 'Work Order Number:')]//parent::li//span[@class='rspropertyvalue']")
	private WebElement workOrderNumber_Value;
	
	

	@FindBy(xpath = "//*[@class='rstitle']/*")
	private WebElement workOrderNumber_Link;

	// anusha
	@FindBy(xpath = "//iframe[@title='ESMX_Case_Wizard_Lite']")
	private WebElement manage_WorkOrder_Frame;

	@FindBy(xpath = "//input[@value='Request a Quote']")
	private WebElement requestAQuoteSFM;

	@FindBy(xpath = "//*[contains(@title, 'Used for execution of case specific actions')]//input[@value='Send to Back Office']")
	private WebElement sendto_backoffice;

	@FindBy(xpath = "//span[text()='Case Number']/following-sibling::span/span")
	private WebElement case_Number;

	@FindBy(xpath = "//*[text()='[View Hierarchy]']/..")
	private WebElement case_Number_Distributor;
	// Souvik
	@FindBy(xpath = "//*[text()='Contact ID:']/parent::td/following-sibling::td//*[@role='button']")
	private WebElement contactID_SearchBtn;

	@FindBy(xpath = "//*[text()='Installed Product:']/parent::td/following-sibling::td//*[@role='button']")
	private WebElement installedProduct_SearchBtn;

	@FindBy(xpath = "//*[contains(text(), 'Limit search')]/preceding-sibling::input[@type='button']")
	private WebElement searchWindow_filter_checkBox;

	@FindBy(xpath = "//button[@data-qtip= 'search']")
	private WebElement searchWindow_search_button;

	@FindBy(xpath = "//input[contains(@id, 'svmx-picklist')]")
	private WebElement searchWindow_picklist;

	@FindBy(xpath = "(//input[@placeholder= 'Quick Find'])[3]")
	private WebElement searchWindow_quickFind;

	@FindBy(xpath = "//button/*[text()='Select']")
	private WebElement select_button;

	@FindBy(xpath = "//*[contains(text(), 'Submit:')]/../following-sibling::td/*")
	private WebElement submit_SafetyQuestion_checkBox;

	@FindBy(xpath = "//iframe[@name='0660L000001TnE6']")
	private WebElement caseDetailsPage_SFM_frame;

	@FindBy(xpath = "(//table//input[contains(@value, 'Request a Quote')])[1]")
	private WebElement requestQuote_SFM_button;

	@FindBy(xpath = "//input[@value= 'New quote request']")
	private WebElement newQuoteRequest_radioButton;

	@FindBy(xpath = "//label[contains(text(), 'Quote request description')]/../..//textarea")
	private WebElement quoteRequestdescription_textarea;

	@FindBy(xpath = "//label[contains(text(), 'Status')]/../..//select")
	private WebElement status_Quotes_dropdown;

	@FindBy(xpath = "//*[contains(text(),  'Terms and Conditions')]/../..//span[@class='lookupInput']/*")
	private WebElement termsAandConditions_Quotes_textarea;

	@FindBy(xpath = "//input[@name= 'rad']")
	private WebElement newWorkOrder_Quotes_radiobutton;

	@FindBy(xpath = "(//input[@value='Save'])[2]")
	private WebElement SAVE_Quotes_button;

	@FindBy(xpath = "(//input[@value= 'New'])[1]")
	private WebElement new_partsTab_Quotes_button;

	@FindBy(xpath = "(//input[@value= 'New'])[2]")
	private WebElement new_laborTab_Quotes_button;

	@FindBy(xpath = "//a[text()= 'Delete']")
	private WebElement delete_parts_Quotes_button;

	@FindBy(xpath = "//td[text()= 'Labor']")
	private WebElement laborTAB_Quotes_button;

	@FindBy(xpath = "//input[@value= 'Get Price/VAT']")
	private WebElement getPriceOrVat_button;

	@FindBy(xpath = "(//*[contains(text(), 'Success')])[2]")
	private List<WebElement> getPriceOrVat_successMessage1;

	@FindBy(xpath = "(//*[contains(text(), 'The Case is covered by ')])[2]")
	private WebElement getPriceOrVat_successMessage2;

	@FindBy(xpath = "//input[@value='Pull Discounts From Contract ']")
	private WebElement PullDiscountsFromContract_button;

	@FindBy(xpath = "(//input[@value='Done'])[2]")
	private WebElement done_QuotesSFM_button;

	@FindBy(xpath = "//img[@class='pageTitleIcon'][@title= 'Service Quote']")
	private WebElement serviceQuote_pageTitleIcon;

	@FindBy(xpath = "//*[@class='pageDescription']")
	private WebElement created_QuoteNumber;

	@FindBy(xpath = "//*[@class= 'pbTitle']//*[text()= 'Attachments']")
	private WebElement attachmentTable_header;

	@FindBy(xpath = "//option[text()= 'Distance']/..")
	private WebElement typeOfMeasure_Labor_dropdown;

	@FindBy(xpath = "(//option[text()= 'Distance']/../../../../following-sibling::td/*)[1]")
	private WebElement kmMile_textbox;

	@FindBy(xpath = "(//*[contains(text(), 'Error:')])[1]")
	private List<WebElement> errorHeader;

	@FindBy(xpath = "(//*[contains(text(), 'Error:')]/../..)[1]")
	private WebElement errorMessage1;

	@FindBy(xpath = "//*[text()= 'Total Net Prices']/following-sibling::td/*")
	private WebElement totalNetPrice_ServiceQuote;

	@FindBy(xpath = "//*[text()= 'Total Gross Price']/../following-sibling::td/*")
	private WebElement totalGrossPrice_ServiceQuote;

	@FindBy(xpath = "//*[text()= 'PSA Flag:']/../following-sibling::td/*")
	private WebElement PSAFlag_checkbox;

	@FindBy(xpath = "//*[@value= 'Create Remote Service Work Order']")
	private WebElement createRemoteServiceWO_SFM_button;

	@FindBy(xpath = "//*[@id= 'sfm-button-1090-btnIconEl']")
	private WebElement createRemoteServiceWO_SFM_saveBotton;

	@FindBy(xpath = "//*[@id='sfm-button-1056-btnIconEl']")
	private WebElement decontaminaion_SaveButton;

	@FindBy(xpath = "//*[contains(@value, 'Update Bench Repair Case')][contains(@class, 'svmxbtn')]")
	private WebElement update_BenchRepair_Case_Button;

	@FindBy(xpath = "//*[@id='sfm-button-1113-btnIconEl']")
	private WebElement update_BenchRepair_Case_SaveButton;

	@FindBy(xpath = "//*[contains(text(), 'Installed Product:')]//parent::td//parent::tr//td[contains(@class, 'svmx-form-item-body svmx-box-layout-ct')]//input[contains(@id, 'svmx-text')]")
	private WebElement install_Product_InputField;

	@FindBy(xpath = "//*[contains(text(), 'Contact ID')]//parent::td//parent::tr//td[@class='svmx-form-item-body ']//input[contains(@id, 'svmx-text')]")
	private WebElement contact_Id_InputField;

	@FindBy(xpath = "//*[contains(text(), 'Description:')]//parent::td//parent::tr//td[@class='svmx-form-item-body ']/*")
	private WebElement update_BRC_Description_InputField;

	@FindBy(xpath = "//span[text()='Acknowledge Training Compliance Gap']/../following-sibling::td/div")
	private WebElement Acknowledge;

	@FindBy(xpath = "//span[text()='Acknowledge Training Compliance Gap']/../following-sibling::td/div/input")
	private WebElement Ack_checkbox;
	
	
	@FindBy(xpath = "//input[@name='file uploader']")
	public WebElement file_Upload_IMU;
	
	@FindBy(xpath = "//button[text()='Process IMU CSV File']")
	public WebElement process_IMU_CSV_button;
//	
//	@FindBy(xpath = "//div[@title='Action']/../preceding-sibling::td//input")
//	public WebElement select_all_IMU_Records;
	
	@FindBy(xpath = "//input[@value='Add/Edit PM T&M Case Lines']")
	public WebElement add_caselines_SFM;
	
	
	@FindBy(xpath = "//*[text()='Preventive Maintanence']/preceding-sibling::th/a")
	public List<WebElement> caseLines_numbers;
	
	@FindBy(xpath = "//*[text()='T&M IP']/following-sibling::td/div/img")
	public WebElement tandm_IP_field;

	@FindBy(xpath = "//input[@name='ids']")
	public List<WebElement> select_all_IMU_Records;
	
	@FindBy(xpath = "//input[@title='Create/Update Case']")
	public WebElement create_IMU_Case;
	
	@FindBy(xpath = "//*[text()='Edit']/ancestor::td/following-sibling::td//*[contains(text(),'IMU-')]")
	public List<WebElement> record_numbers_IMU;
	
	@FindBy(xpath = "//td[text()='Country']/preceding-sibling::td//div")
	public WebElement trackwise_status_IMU;

	
	@FindBy(xpath = "//*[text()='Follow-up action']/../preceding-sibling::td//div")
	public WebElement reason_for_incompletion;

	public static String BU;
	public static String Bg;
	private String benchStatusTrackerNumber = "";
	private String caseNo = "";
	private String workOrderNo1 = "";

	public void clickonProduct() {
		click("Product Link", productlink);
	}

	public void verifyvaluesofBusinessgropuAndUnit() {
		try {
			if (BUtext.getText() != null) {
				BU = BUtext.getText();
				logReport("INFO", "Business unit is not empty");

			}
		} catch (Exception e) {
			logReport("INFO", "Business unit is empty");
		}
		try {
			if (BGtext.getText() != null) {
				Bg = BGtext.getText();
				logReport("INFO", "Business group is not empty");
			}
		} catch (Exception e) {
			logReport("INFO", "Business group is empty");
		}
		// driver.navigate().back();
	}

	public void craete_A_case(String eventtype, String subeventype, String answer) {
		waitTill("10");
		waitForElement(installed_product_custom_Action_frame, "installed_product_custom_Action_frame");
		embedScreenShotInreport();
		//Hima
		if(eventtype.matches("Installation")) {
			check_SalesOrder();
		}		
		try {
			driver.switchTo().frame(installed_product_custom_Action_frame);
		} catch (Exception e) {
			driver.switchTo()
					.frame(driver.findElement(By.xpath("//iframe[contains(@title,'ESMX_Installed_Product_Wizard_Lite')]")));
		}
		waitTill("5");
		clickEvent(create_Case_SFM);
		waitLoadingSpinnerToDisappear();
		//waitForElement(creat_Case_dialog, "creat_Case_dialog");

		waitTill("15");
		/*
		driver.findElement(By.xpath("//*[text()='Contact ID:']/parent::td/following-sibling::td//*[@role='button']"))
				.click();
		waitLoadingSpinnerToDisappear();
		waitTill("10");
		driver.findElement(By.xpath("//span[text()='Full Name']/../../../../../following-sibling::div//tr/td/div"))
				.click();
		waitTill("5");
		click("select_Contact_id_fullname", select_Contact_id_fullname);
		waitTill("5");
		*/
		//Hima
		driver.findElement(By.xpath("//label[contains(text(),'Contact ID')]/following-sibling::div//input")).click();
		waitLoadingSpinnerToDisappear();
		waitTill("5");
		driver.findElement(By.xpath("//label[contains(text(),'Contact ID')]/following-sibling::div//div/ul/li/a")).click();
		waitTill("3");
		if (verifyElementPresent("Event Type", eventType_dropdown)) {
			click("eventType_dropdown", eventType_dropdown);
			WebElement Et = driver.findElement(By.xpath("//li/a/span/span[text()='" + eventtype + "']"));
			click("Eventype", Et);
			click("eventSubType_dropdown", eventSubType_dropdown);
			WebElement SubEt = driver.findElement(By.xpath("//label[text()='Service Type/Event Subtype']/..//li/a/span/span[text()='" + subeventype + "']"));
			click("subevent type", SubEt);
			click("priority_Dropdown", priority_Dropdown);
			click("priority_Value", priority_Value);
			embedScreenShotInreport();
		}
		if (verifyElementPresent("event_Date", event_Date)) {
			click("debriefSystemStatusDateOrTime_button", debriefSystemStatusDateOrTime_button);
			enter("Customer Country", customer_Country, "SK");
			pressEnter();
		}
		if(eventtype.matches("Proactive Monitoring")) {
			click("case_source_Dropdown", case_source_Dropdown);
			click("case_source_value", case_source_value);
			waitTill("2");
		}
		enter("Subject", subject, "Test");
		enter("description", description, "Test Data");
		embedScreenShotInreport();
		waitTill("2");
		driver.findElement(By.xpath("//label[text()='Description']")).click();
		waitTill("2");
		//Hima
		if(verifyElementPresent("safety_question",safetyQuestion_Dropdown)) {
			scrollByViewOfElement(safetyQuestion_Dropdown);
			click("safetyQuestion_dropdown", safetyQuestion_Dropdown);
			driver.findElement(By.xpath("//li/a/span/span[text()='" +answer+ "']")).click();
			if(answer.matches("Yes")) {
				driver.findElement(By.xpath("//button/span[text()='Save']/ancestor::div[1]/span")).click();
				driver.findElement(By.xpath("//button/span[text()='Ok']")).click();
			}
			waitTill("5");
		}
//		if(verifyElementPresent("eventDate", eventDate)) {
//			click("eventDate", eventDate);
//			driver.findElement(By.xpath("//button[text()='Today']")).click();
//		}
//		if(verifyElementPresent("customerCountry", customerCountry)) {
//			enter("customerCountry", customerCountry, "US");
//			pressEnter();
//		}
		embedScreenShotInreport();
		click("save_case", save_case);
		waitLoadingSpinnerToDisappear();
		waitTill("25");
		if (verifyElementPresent("Case Details", case_Details)) {
			click("Case Details", case_Details);
		}
		if (verifyElementPresent("Case Number Distributor", case_Number_Distributor)) {
			System.out.println("Case Number : " + case_Number_Distributor.getText());
			String caseNumber = (case_Number_Distributor.getText()).substring(0,
					((case_Number_Distributor.getText()).indexOf('[')) - 1);
			System.out.println("caseNumber:" + caseNumber);
			scrollByViewOfElement(case_Number_Distributor);
			embedScreenShotInreport();
			AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("CASE_NUMBER", caseNumber);
		} else {
			AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("CASE_NUMBER", case_Number.getText());
			scrollByViewOfElement(case_Number);
			embedScreenShotInreport();
		}
	}
	public void getWO1() {
		// TODO Auto-generated method stub
		waitTill("10");
		WO1 = driver.getCurrentUrl();
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("WO1", WO1);
		
	}

	public void navigateToWO1() {
		waitTill("30");
		String WO1 = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("WO1");
		driver.get(WO1);
		waitTill("30");
		
		click("case_Details", case_Details);
		embedScreenShotInreport();
	}

	public void getWO2() {
		// TODO Auto-generated method stub
		WO2 = driver.getCurrentUrl();
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("WO2", WO2);
	}

	public void navigateToWO2() {
		// TODO Auto-generated method stub
		waitTill("15");
		String WO2 = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("WO2");
		driver.get(WO2);
		waitTill("15");
	}

	public void getWO3() {
		// TODO Auto-generated method stub
		WO3 = driver.getCurrentUrl();
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("WO3", WO3);
	}

	public void navigateToWO3() {
		// TODO Auto-generated method stub
		waitTill("15");
		String WO3 = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("WO3");
		driver.get(WO3);
		waitTill("15");
	}

	public void verifyEscalationOriginatedWOcheckbox() {
		// TODO Auto-generated method stub
		waitTill("5");
		click("case_Details", case_Details);
		if (verifyElementPresent("Escalation Originated Work order", escalationOriginatedWO)) {
			logReport("INFO", "Escalation Originated Work order checkbox is unchecked");
		} else {
			logReport("INFO", "Escalation Originated Work order checkbox is checked");
		}
	}

	public void click_on_casCreated() {
		// TODO Auto-generated method stub
		waitTill("5");
		click("Case Link", caselink);
		waitTill("5");
		click("case_Details", case_Details);
		waitTill("5");
	}

	public void createEscalatecase() {
		waitTill("15");
		driver.switchTo().frame(manage_WorkOrder_Frame);
		waitTill("10");
		click("Escalation case", Escalatecase);
		waitForElement(escalationTitle, "Escalation Title");
		waitTill("5");
		enter("Escalation title", escalationTitle, "Automation Testing");
		waitTill("5");
		// click("Escalation category dropdown", escalation_categorydropdown);
		driver.findElement(By.xpath("//*[text()='Escalation Category:']/../following-sibling::td//div[@role='button']"))
				.click();
		waitForElement(clinicalvalue, "drop down value");
		waitTill("5");
		click("Clinical Dropdown value", clinicalvalue);
		waitTill("5");
		click("save Escalation case", EscalationcaseSave);
		waitLoadingSpinnerToDisappear();
		waitTill("10");
		try {
			driver.findElement(By.xpath("//span[text()='Save']")).click();
			waitTill("30");
		} catch (Exception e) {
		}
		Escalatecaserecord = driver.getCurrentUrl();
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("Escalatecaserecord", Escalatecaserecord);
	}

	public void verifyEscalatecase() {
		// TODO Auto-generated method stub
		waitTill("30");
		driver.switchTo().frame(manage_WorkOrder_Frame);
		if (verifyElementPresent("Cancel Button of Escalation case", cancelEscalation)) {
			logReport("INFO", "Cancel button is present");
		} else {
			logReport("INFO", "Cancel button is not present");
		}
		driver.switchTo().defaultContent();
		if (verifyElementPresent("Escalationstatus", Escalationstatus)) {
			logReport("INFO", "Escalationstatus is present as New");
		} else {
			logReport("INFO", "Escalationstatus is not present");
		}
		if (verifyElementPresent("caseEscalatedcheckbox", caseEscalatedcheckbox)) {
			logReport("INFO", "caseEscalatedcheckbox is present ");
		} else {
			logReport("INFO", "caseEscalatedcheckbox is not present");
		}
		if (verifyElementPresent("unassignedEscalation", unassignedEscalation)) {
			logReport("INFO", "unassignedEscalation is present ");
		} else {
			logReport("INFO", "unassignedEscalation is not present");
		}
		String escalation_initiator = escalationInitiator.getText();
		if (escalation_initiator.contains("Automation Technician L1")) {
			logReport("INFO", "L1 Technician is present ");
		} else {
			logReport("INFO", "L1 Technician is not present ");
		}
		String escalation_Owner = escalationOwner.getText();
		System.out.println(escalation_Owner);
		if (escalation_Owner == "") {
			logReport("INFO", "Validation fail");
		} else {
			logReport("INFO", "Validation Pass");
		}

	}

	public void verifyBusinessgroupAndUnit() {
		try {
			WebElement Businessunit = driver.findElement(By.xpath("//div[text()='" + BU + "']"));
			WebElement Businessgroup = driver.findElement(By.xpath("//div[text()='" + Bg + "']"));
			verifyElementPresent("BusinessGroup", Businessgroup);
			verifyElementPresent("Business unit", Businessunit);
		} catch (Exception e) {
		}
	}

	public void navigateEscalatecase() {
		// TODO Auto-generated method stub
		waitTill("15");
		String Escalatecaserecord = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("Escalatecaserecord");
		System.out.println("Escalatecaserecord:" + Escalatecaserecord);
		driver.get(Escalatecaserecord);
		waitTill("15");
	}

	public void AcceptEscalatecase() {
		// TODO Auto-generated method stub
		waitTill("30");
		driver.switchTo().frame(manage_WorkOrder_Frame);
		click("Accept Escalation case", AcceptEC);
		waitForElement(saveAcceptEC, "save Accept Escalation case");
		click("saveAcceptEC", saveAcceptEC);
		waitTill("15");
	}

	public void CreateNewAction() {
		waitTill("15");
		driver.switchTo().frame(manage_WorkOrder_Frame);
		click("Create New Action", createNewAction);
		waitForElement(actiontitle, "Action title");
		waitTill("5");
		enter("Action title", actiontitle, "Automation Testing");
		waitTill("5");
		enter("Action Description", actiondesc, "Automation Testing");
		waitTill("5");
		String endDatevalue = endDatevalue("MM/dd/yyyy", 0, 0, 0);
		enter("Action Due Date", actionDueDate, endDatevalue);
		waitTill("5");
		click("Action owner look up", actionOwnerlookup);
		waitLoadingSpinnerToDisappear();
		waitForElement(contact_ID_fullname, "Action owner fullname");
		waitTill("5");
		click("Action owner fullname", contact_ID_fullname);
		waitTill("5");
		click("select_ActionOwner_fullname", select_Contact_id_fullname);
		waitTill("5");
		click("Action owner role", actionOwnerRole);
		waitTill("5");
		click("L2 Clinical", L2Clinical);
		click("save Action new request", EscalationcaseSave);
		waitLoadingSpinnerToDisappear();
		waitTill("10");
		try {
			driver.findElement(By.xpath("//span[text()='Save']")).click();
			waitTill("25");
		} catch (Exception e) {
		}
	}

	public void AcceptActionRequest() {
		waitTill("5");
		click("case_Details", case_Details);
		waitTill("5");
		driver.switchTo().frame(caselineframe);
		click("Accept Action Request Button", acceptActionRequest);
		click("save Action new request", EscalationcaseSave);
		waitLoadingSpinnerToDisappear();
	}

	public void verifyActionRequestEnable() {
		waitTill("5");
		driver.switchTo().frame(caselineframe);
		verifyElementPresent("Manage Action Request", manageActionRequest);
		verifyElementPresent("Close Action Request", closeActionRequest);
		driver.switchTo().defaultContent();
	}

	public void closeActionRequest() {
		waitTill("30");
		waitForElement(caselineframe, "caselineframe");
		System.out
				.println("TANNN:" + driver.findElement(By.xpath("//iframe[@title='Case_Line_Wizard']")).isDisplayed());
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Case_Line_Wizard']")));
		waitTill("5");
		click("Close Action Request", closeActionRequest);
		waitTill("10");
		enter("Response Description", responseDescription, "Automation Testing");
		waitTill("5");
		click("Plus icon", plusiconofDate);
		String endDatevalue = endDatevalue("MM/dd/yyyy", 1, 0, 0);
		String startDatevalue = endDatevalue("MM/dd/yyyy", 0, 0, 0);
		waitTill("5");
		enter("Start date", inputfields, startDatevalue);
		waitTill("5");
		click("End date head", enddatetimehead);
		waitTill("5");
		click("End date input", endDateTimeinput);
		waitTill("15");
		System.out.println("Tan:" + driver.findElements(By.xpath("//input[contains(@id,'svmx-date-')]")).size());
		try {
			enter("end date", inputfields, endDatevalue);
		} catch (Exception e) {
		}
		try {
			List<WebElement> dat = driver.findElements(By.xpath("//input[contains(@id,'svmx-date-')]"));
			driver.findElements(By.xpath("//input[contains(@id,'svmx-date-')]")).get((dat.size()) - 1)
					.sendKeys(endDatevalue);
		} catch (Exception e1) {
		}
		waitTill("5");
		driver.findElement(By.xpath("//td[@data-qtip='L2 Technician']/following-sibling::td/div")).click();
		waitTill("5");
		// click("subject", subject);
		// waitTill("5");
		System.out
				.println("TAn:" + driver.findElement(By.xpath("(//td[@class='svmx-trigger-cell'])[17]")).isDisplayed());
		// click("Subject dropdown", subjectdropdown);
		driver.findElement(By.xpath("(//td[@class='svmx-trigger-cell'])[17]")).click();
		waitTill("5");
		click("Subject dropdown value", administrationvalue);
		waitTill("5");
		click("save Action new request", EscalationcaseSave);
		waitTill("10");
		waitLoadingSpinnerToDisappear();
	}

	public void debriefInstallationcase() {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='ESMX_Service_Order_Wizard_Lite']")));
		if (verifyElementPresent("DebriefandFollowup", DebriefandFollowup)) {
			logReport("INFO", "Debrief and follow up button is enabled");
		} else if (verifyElementPresent("DebriefandFollowup", debriefFollow)) {
			logReport("INFO", "Debrief and follow up button is enabled");
		} else {
			logReport("INFO", "Debrief and follow up button is not enabled");
		}
	}

	public void completeworkorder() {

		if (verifyElementPresent("complete word order", completeWO)) {
			click("complete work order", completeWO);
			click("save", EscalationcaseSave);
			waitTill("15");
			waitLoadingSpinnerToDisappear();
		}
	}

	public void changeorderstatus() {
		waitTill("5");
		doubleClick("order status", orderstatus);
		waitTill("5");
		click("status dropdown", selectstatus);
		waitTill("5");
		click("fixed value", fixedstatus);
		waitTill("5");
		click("savedits", savedits);
		waitLoadingSpinnerToDisappear();
		waitTill("15");
	}

	public void submitPSF_Form() {
		// TODO Auto-generated method stub
		waitTill("15");
		try {
			driver.switchTo().frame(manage_WorkOrder_Frame);
			click("PSF Form", PSFform);
			switchToTab(1);
			click("dateofOccurence", dateofOccurence);
			click("day", day);
			click("dateofIncident", dateofIncident);
			click("day", day);
			click("potentialsafety", potentialsafety);
			click("potentialsafetyvalue", potentialsafetyvalue);
			click("userinvolved", userinvolved);
			click("unknownvalue", unknownvalue);
			enter("procedureoutcome", procedureoutcome, "Automation Testing");
			click("actionreqd", actionreqd);
			waitTill("5");
			click("unknownvalue", unknownvalue);
			click("issuereported", issuereported);
			waitTill("5");
			click("unknownvalue", unknownvalue);
			click("save", save_submit);
			waitTill("10");
			driver.close();
			switchToTab(0);
		} catch (Exception e) {
		}
	}

	public void updateEscalationDetails() {
		waitTill("30");
		driver.switchTo().frame(manage_WorkOrder_Frame);
		waitTill("5");
		click("update Escalation details", updateEscalationDetails);
		waitTill("5");
		enter("Action Plan summary", actionPlansummary, "Test Automation");
		waitTill("5");
		click("save", EscalationcaseSave);
		waitTill("5");
		if (verifyElementPresent("save popup", Save)) {
			click("save", Save);
		}
		waitLoadingSpinnerToDisappear();
		waitTill("10");
	}

	public void cancelEsc() {
		waitTill("10");
		driver.switchTo().frame(manage_WorkOrder_Frame);
		waitTill("5");
		click("cancel Escalation details", cancelesc);
		waitTill("6");
		enter("closedcasecomments", closedcasecomments, "Test automation");
		click("save", EscalationcaseSave);
		waitTill("10");
		if (verifyElementPresent("save popup", Save)) {
			click("save", Save);
		}
		waitLoadingSpinnerToDisappear();
		waitTill("10");
	}

	public void verifyFieldsafterCancellationESc() {
		// TODO Auto-generated method stub
		if (verifyElementPresent("case Escalated checkbox", caseEscalateduncheckbox)) {
			logReport("Info", "Case Escalated checkbox is unchecked: validation Pass");
		} else {
			logReport("Info", "Case Escalated checkbox is checked: validation fail");
		}
		if (verifyElementPresent("Escalatedstatus", esccancelledStatus)) {
			logReport("Info", "Case Escalated status cancelled: validation Pass");
		} else {
			logReport("Info", "Case Escalated status is not cancelled: validation fail");
		}
		if (verifyElementPresent("case Record Type", caseRecordtypeafterCancelesc)) {
			logReport("Info", "Case Record Type is Closed Support Escalation : validation Pass");
		} else {
			logReport("Info", "Case Record Type is not Closed Support Escalation : validation Fail");
		}
	}

	public void create_Remote_Workorder(String hours) {
		waitForElement(create_Remote_workOrder, "create_Remote_workOrder");
		waitTill("5");
		driver.switchTo().frame(manage_WorkOrder_Frame);
		click("create_Remote_workOrder", create_Remote_workOrder);

		click("save_WorkOrder", EscalationcaseSave);
		waitLoadingSpinnerToDisappear();
		waitForElement(work_order_header, "waitForElement");
		click("case_Details", case_Details);
		waitForElement(workorder_Number, "workorder_Number");
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("WORK_ORDER_NUMBER", workorder_Number.getText());
	}

	public void initiateRemoteServie() {
//		waitTill("15");
//		driver.get("https://philipsb2bsc--emsmq3.my.salesforce.com/a3d2i000000gYqJAAU");
		waitTill("10");
		try {
			System.out.println("TAN:" + driver
					.findElement(By
							.xpath("//span[text()='Acknowledge Training Compliance Gap']/../following-sibling::td/div"))
					.isDisplayed());
			waitTill("5");
			scrollByViewOfElement(driver.findElement(
					By.xpath("//span[text()='Acknowledge Training Compliance Gap']/../following-sibling::td/div")));
			hover(Acknowledge);
			doubleClick(Acknowledge);
			waitTill("5");
			click("Ack_checkbox", Ack_checkbox);
			waitTill("5");
			driver.findElement(By.xpath("//input[@title='Save']")).click();
			waitTill("15");
		} catch (Exception e) {
		}
		driver.switchTo().frame(OrderWizframe);
		click("Initiate Remote Service", initiateRemoveService);
		waitTill("5");
		click("Save Remote service", saveRemoteservice);
		waitTill("10");
	}

	public void clickSFM(String clickSFM, String type) {
		switch (type) {
		case "Case":
			if (clickSFM.equals("Send to Back Office")) {
				if (sendto_backoffice.isEnabled()) {
					waitTill("5");
					// driver.switchTo().frame(manage_WorkOrder_Frame);
					click("sendto_backoffice", sendto_backoffice);
					waitTill("5");
				}
			} else if (clickSFM.equals("Request a Quote")) {
				AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("CASE_NUMBER", case_Number.getText());
				AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CASE_NUMBER");
				waitTill("5");
				waitForElement(manage_WorkOrder_Frame, "manage_WorkOrder_Frame");
				driver.switchTo().frame(manage_WorkOrder_Frame);
				click("requestAQuoteSFM", requestAQuoteSFM);
			}
			break;
		}

	}

	public boolean verifySFM(String sfm, String type) {
		boolean flag = false;
		waitTill("5");
		switch (type) {
		case "Case":
			driver.switchTo().frame(manage_WorkOrder_Frame);
			if (requestAQuoteSFM.isEnabled()) {
				flag = true;
			}
			break;
		}
		return flag;

	}

	public boolean verifyCaseOwner(String expectedCaseOwner) {
		boolean flag = false;
		String caseOwner = driver.findElement(
				By.xpath("//*[contains(text(),'Contact Name')]/../following-sibling::tr//a[contains(text(),'"
						+ expectedCaseOwner + "')]"))
				.getText();
		if (caseOwner.equals(expectedCaseOwner)) {
			flag = true;
		}
		return flag;
	}

	@FindBy(xpath = "//*[text()='FCO Delivery Method']/../following-sibling::td/div")
	private WebElement deliveryMethodCase;

	public void verifyFCOInfoCase(String caseNumber, String wO) {
		switch (caseNumber) {
		case "Case1":
			search_GlobalsearchBox(TestData.get(0).get("Case1"));
			click("Case1", driver.findElement(
					By.xpath(".//div[@id='Case_body']//a[contains(text(),'" + TestData.get(0).get("Case1") + "')]")));
			click("Details", caseDetails);
			verifyBooleanStatus(deliveryMethodCase.getText(), TestData.get(0).get("Delivery Method"));
			woPage.verifyFCOInfoWO(TestData.get(0).get("WO1"), "WO1");
			// Change the delivery method of WO1 to Onsite
			String FCO_HEADER = TestData.get(0).get("FCONumber");
			search_GlobalsearchBox(FCO_HEADER);
			click("Click", driver.findElement(By.xpath("//td[text()='" + FCO_HEADER + "']/preceding-sibling::th/a")));
			doubleClick("fcoDeliveryMethod", fcoDeliveryMethod);
			selectbyValue(fcoDeliveryMethodInput, "Onsite", "Delivery Method");
			doubleClick("cascadeFields", cascadeFields);
			click("Cascade Fields to Case & WO", cascadeFieldsInput);
			click("Save", saveTopButton);
			waitTill("5");
			click("Cascade Changes", cascadeChanges);
			waitTill("5");
			driver.switchTo().alert().accept();
			waitTill("5");
			driver.switchTo().alert().accept();
			waitTill("5");
			break;
		case "Case2":
			search_GlobalsearchBox(TestData.get(0).get("Case2"));
			click("Case2", driver.findElement(
					By.xpath(".//div[@id='Case_body']//a[contains(text(),'" + TestData.get(0).get("Case2") + "')]")));
			verifyBooleanNotStatus(deliveryMethodCase.getText(), TestData.get(0).get("Delivery Method"));
			woPage.verifyFCOInfoWO(TestData.get(0).get("WO2"), "WO2");
			break;
		case "Case3":
			search_GlobalsearchBox(TestData.get(0).get("Case3"));
			click("Case3", driver.findElement(
					By.xpath(".//div[@id='Case_body']//a[contains(text(),'" + TestData.get(0).get("Case3") + "')]")));
			verifyBooleanNotStatus(deliveryMethodCase.getText(), TestData.get(0).get("Delivery Method"));
			woPage.verifyFCOInfoWO(TestData.get(0).get("WO3"), "WO3");
			break;

		}

	}

	public void set_BenchStatusTrackerNumber() {
		waitForElement(bench_Status_TrackerNumber_Value, "Bench Status Tracker Number");
		benchStatusTrackerNumber = bench_Status_TrackerNumber_Value.getText();
		AutomationConstants.RUN_TIME_TEMP_DATA.put("BST_NO", benchStatusTrackerNumber);
		logReport("INFO", "Bench Status Tracker Number: " + benchStatusTrackerNumber);
	}

	public void set_CaseNo() {
		waitForElement(case_No, "Case No");
		caseNo = case_No.getText();
		AutomationConstants.RUN_TIME_TEMP_DATA.put("CASE_NO", caseNo);
		logReport("INFO", "Case Number: " + caseNo);
	}

	public void update_TrackingOrCourier_Number() {
		waitTill("50"); // To create a difference between
		driver.switchTo().frame("0660L000001TnE6");
		waitTill("5");
		waitForElement(Step1_Update_TrackingOrCourier_Number_Button, "Step 1: Update Tracking/Courier Number");
		waitTill("5");
		click("Step 1: Update Tracking/Courier Number", Step1_Update_TrackingOrCourier_Number_Button);
		waitTill("5");
		waitForElement(update_TrackingoRCourier_No_SaveButton, "Save");
		waitTill("5");
		enter("Incoming Bench Tracking & Courier Number", incoming_BenchTracking_Field,
				"IBTCN_" + Utility.randomNumber(4));
		click("Save", update_TrackingoRCourier_No_SaveButton);

		waitUntilElementisDisplayed(page_Title_Icon);
		waitTill("5");
		set_CaseNo();

		logReport("INFO", "Tracking Courier No Updated Suiccessfully");
	}

	public void completeDecontamination() {
		waitTill("45");
		driver.switchTo().frame("0660L000001TnE6");
		waitForElement(Step2_Set_Status_To_Decontamination_Complete_Button,
				"Step 2: Set Status To Decontamination Complete");

		click("Step 2: Set Status To Decontamination Complet", Step2_Set_Status_To_Decontamination_Complete_Button);

		waitForElement(decontaminaion_SaveButton, "Save BUtton");

		Assert.assertTrue(this.verify_BenchRepairStatus("Decontamination Complete"));

		waitTill("10");

		click("Save", decontaminaion_SaveButton);

		logReport("INFO", "Decontamination Done ");
	}

	/**
	 * @param installProduct
	 * @param contactId
	 */
	public void update_BenchRepairCase(String installProduct, String contactId) {
		waitTill("5"); // To create a difference between
		driver.switchTo().frame("0660L000001TnE6");
		waitTill("5");
		waitForElement(update_BenchRepair_Case_Button, "Update Bench Repair Case");
		waitTill("5");
		click("Update Bench Repair Case", update_BenchRepair_Case_Button);
		waitTill("5");
		waitForElement(update_BenchRepair_Case_SaveButton, "Save");
		waitTill("5");
		enter("Install Product No", install_Product_InputField, installProduct);
		click("Search Installed Product", installedProduct_SearchBtn);
		waitTill("5");
		waitLoadingSpinnerToDisappear();
		waitTill("5");
		click("Uncheck Filter", searchWindow_filter_checkBox);
		// enter("Install Product", searchWindow_quickFind, installProduct);
		waitTill("5");
		click("Search", searchWindow_search_button);
		waitLoadingSpinnerToDisappear();
		waitTill("5");
		driver.findElement(
				By.xpath("//div[@class='svmx-grid-cell-inner '][contains(text(), '" + installProduct + "')]")).click();
		click("Select Button", select_button);
		waitTill("5");
		enter("Contact Id Details", contact_Id_InputField, contactId);
		click("Search Contact Id", contactID_SearchBtn);
		waitLoadingSpinnerToDisappear();
		click("Uncheck Filter", searchWindow_filter_checkBox);
		// enter("Contact Id", searchWindow_quickFind, contactId);
		click("Search", searchWindow_search_button);
		waitDottedSpinnerToDisappear();
		waitLoadingSpinnerToDisappear();
		waitTill("30");
		waitLoadingSpinnerToDisappear();
		driver.findElement(By.xpath("//span[text()='Full Name']/../../../../../following-sibling::div//tr/td/div")).click();
		//driver.findElement(By.xpath("(//*[text()='"+contactId+"'])[1]")).click();
		click("Select Button", select_button);

		enter("Description", update_BRC_Description_InputField, "Test Description");
		click("Save", update_BenchRepair_Case_SaveButton);

		waitTill("6");
		try {
			click("Save", update_BenchRepair_Case_SaveButton);
		} catch (Exception e) {
			logReport("INFO", "Already Saved");
		}
	}

	public boolean verify_BenchRepairStatus(String status) {
		boolean flag;

		if (benchRepairStatus_FieldValue.getText().equalsIgnoreCase(status))
			flag = true;
		else
			flag = false;

		return flag;
	}

	public void verify_incomingBenchTrackingCourierNumber_Population() {

		waitForElement(incomingBenchTrackingCourierNumber_Value, "Bench Tracking & Courier Number");
		scrollByViewOfElement(incomingBenchTrackingCourierNumber_Value);

		Assert.assertTrue(incomingBenchTrackingCourierNumber_Value.isDisplayed(),
				"Incoming Bench Tracking & Courier Number is not Populated");

		logReport("PASS", "Incoming Bench Tracking Courier Number Verified Successfully");
	}

	public void answer_SafetyQuestion_ManageWO(String noOfQuestion) {
		waitTill("6");
		driver.switchTo().frame("0660L000001TnE6");

		waitForElement(safetyQuestion_Button, "Safety Question Tab");
		click("Safety Question Tab", safetyQuestion_Button);

		waitForElement(esmx_SafetyQstn_Save_Button, "Save");

		enter("Ans1", ans1_InputField, "No");
		pressEnter();

		try {
			if (noOfQuestion.equalsIgnoreCase("2")) {
				enter("Ans2", ans2_InputField, "No");
				pressEnter();
			}
		} catch (Exception e) {
		}
		try {
			if (driver.findElements(By.xpath("//*[contains(text(), 'Submit:')]/../following-sibling::td/*"))
					.size() != 0)
				click("Submit CheckBox", submit_SafetyQuestion_checkBox);

			waitTill("5");
		} catch (Exception e) {
		}
		waitTill("5");
		click("Save", esmx_SafetyQstn_Save_Button);
		logReport("INFO", "Safety Question Answered");
	}

	public void answer_SafetyQuestion_withPSAchecked(String noOfQuestion) {
		waitTill("6");
		driver.switchTo().frame("0660L000001TnE6");

		waitForElement(safetyQuestion_Button, "Safety Question Tab");
		click("Safety Question Tab", safetyQuestion_Button);

		waitForElement(esmx_SafetyQstn_Save_Button, "Save");

		enter("Ans1", ans1_InputField, "Yes");
		pressEnter();

		if (noOfQuestion.equalsIgnoreCase("2")) {
			enter("Ans2", ans2_InputField, "Yes");
			pressEnter();
		}

		click("PSA Flag", PSAFlag_checkbox);
		if (driver.findElements(By.xpath("//*[contains(text(), 'Submit:')]/../following-sibling::td/*")).size() != 0)
			click("Submit CheckBox", submit_SafetyQuestion_checkBox);

		waitTill("5");
		click("Save", esmx_SafetyQstn_Save_Button);

		waitForElement(SafetyQstn_TransactionManager_Save_Button, "Save Alart");
		click("Save Alart", SafetyQstn_TransactionManager_Save_Button);

		waitTill("5");

		logReport("INFO", "Safety Question Answered");
	}

	public void select_Request_Bench_Assessment() {

		if (verifyElementPresent("caseDetail", case_Details)) {
			click("caseDetails", case_Details);
		}

		waitForElement(request_Bench_Assessment_Image, "Request Bench Assessment");
		scrollByViewOfElement(request_Bench_Assessment_Image);
		waitTill("5");
		// click("Select Request Bench Assessment", request_Bench_Assessment_Image);
		doubleClick("Select Request Bench Assessment", request_Bench_Assessment_Image);
		waitTill("5");
		pressEnter();

		waitForElement(request_Bench_Assessment_CheckBox, "Bench Assessment CheckBox");
		selectCheckBoxe(request_Bench_Assessment_CheckBox);
		waitTill("5");
		scrollByViewOfElement(caseDetil_InLine_SaveButton);
		click("Save", caseDetil_InLine_SaveButton);

		logReport("INFO", " Request Bench Assessment CheckBox Selected");
	}

	public void create_Loact_Bench_WorkOrder() {
		waitTill("6");
		driver.switchTo().frame("0660L000001TnE6");
		waitTill("5");
		waitForElement(createLocalBenchWorkOrder_Button, "Create Local Bench Work Order");
		click("Create Local Bench Work Order", createLocalBenchWorkOrder_Button);
		waitTill("5");
		set_WorkOrderNumber1();
		logReport("INFO", "Loact_Bench_WorkOrder Created Successfully: *****" + workOrderNo1 + "*****");
	}

	public void set_WorkOrderNumber1() {
		waitForElement(workOrderNumber_Label, "Work Order Number");
		workOrderNo1 = workOrderNumber_Value.getText();
		AutomationConstants.RUN_TIME_TEMP_DATA.put("WO1", workOrderNo1);
	}

	public void create_RemoteService_WorkOrder() {
		waitTill("6");
		driver.switchTo().frame("0660L000001TnE6");
		waitTill("5");
		waitForElement(createRemoteServiceWO_SFM_button, "Create Remote Service Workorder");
		click("Create Remote Service Workorder", createRemoteServiceWO_SFM_button);

		waitForElement(createRemoteServiceWO_SFM_saveBotton, "Save Button");
		click("Save Button", createRemoteServiceWO_SFM_saveBotton);
		waitTill("5");
//		if(verifyElementPresent("case details", case_Details)) {
//			click("Case Details", case_Details);
//		}
		waitTill("10");
		waitForElement(workOrderNumber_Label, "Work Order Number");
		String woNumber = driver.findElement(By.xpath("//span[text()='Work Order Number:']/following-sibling::span")).getText();
		workOrderNo1 = workOrderNumber_Value.getText();
		waitTill("5");
		AutomationConstants.RUN_TIME_TEMP_DATA.put("WorkOrder_No", workOrderNumber_Value.getText());
		AutomationConstants.RUN_TIME_TEMP_DATA.put("WO1", workOrderNo1);
		
		System.out.println("woNumber:"+woNumber);
		logReport("INFO",
				"Remote Service Workorder Created Successfully: *****" + workOrderNumber_Value.getText() + "*****");
	}

	public void goTo_benchStatusTrackerPage_from_CaseDetailsPage() {

		waitForElement(bst_Link, "BST-Link");
		scrollByViewOfElement(bst_Link);
		click("BST-Link", bst_Link);
	}

	public void toggle_between_FeedAndDetails_CaseDetailsPage(String FeedOrDetails) {

		waitForElement(toggleTo_Details, "Details Tab");
		if (FeedOrDetails.equalsIgnoreCase("Feed"))
			click("Feed", toggleTo_Feed);

		else
			click("Details", toggleTo_Details);
	}

	public String get_BenchStatusTrackerNumber() {
		// benchStatusTrackerNumber= bench_Status_TrackerNumber_Value.getText();
		return benchStatusTrackerNumber;
	}

	public String get_Case_No() {
		// caseNo=case_No.getText();
		return caseNo;
	}

	public String get_WorkOrderNo1() {
		return workOrderNo1;
	}

		public void requestAQuote_SFM(String status) {
		waitForElement(caseDetailsPage_SFM_frame, "Frame");
		driver.switchTo().frame(caseDetailsPage_SFM_frame);
		waitForElement(requestQuote_SFM_button, "Request A Quote");
		click("Request A Quote", requestQuote_SFM_button);

		click("New Quote Request", newQuoteRequest_radioButton);
		waitLoadingSpinnerToDisappear();
		enter("Quote Request Description", quoteRequestdescription_textarea, "Test Quote");
		selectFromDropDown(status_Quotes_dropdown, status, "Status");
		waitLoadingSpinnerToDisappear();
		enter("Terms and Condition", termsAandConditions_Quotes_textarea, "Spain Terms & Conditions Spanish");
		waitLoadingSpinnerToDisappear();
		scrollByViewOfElement(newWorkOrder_Quotes_radiobutton);
		waitTill("5");
		click("New Work Order", newWorkOrder_Quotes_radiobutton);
		waitLoadingSpinnerToDisappear();
		waitTill("5");
	}

	public void add_Parts_Quotes_SFM() {
		logReport("INFO", "Adding Parts");
		waitForElement(new_partsTab_Quotes_button, "New Button");
		click("New", new_partsTab_Quotes_button);
		waitLoadingSpinnerToDisappear();
		waitTill("5");
		try {
			if (delete_parts_Quotes_button.isDisplayed()) {
				robortClassPressTAB(3);

				sendKey("453563074511");
				robortClassPressTAB(1);
				waitLoadingSpinnerToDisappear();
				logReport("PASS", "New PARTS Added Successfully");
			} else {
				logReport("FAIL", "Fail to add new PARTS");
				Assert.fail("Fail to add new PARTS");
			}
		} catch (Exception e) {
			waitTill("5");
			click("New", new_partsTab_Quotes_button);
			waitTill("5");
			driver.findElement(By.xpath("//a[@title='Part Lookup (New Window)']/preceding-sibling::input"))
					.sendKeys("452230032863");
			waitTill("5");
			driver.findElement(By.xpath("//a[@title='Part Lookup (New Window)']")).click();
			waitTill("5");
		}

		add_Labour_Quotes_SFM();
	}

	// Souvik
	public void add_Labour_Quotes_SFM() {
		logReport("INFO", "Adding Labor");
		waitForElement(laborTAB_Quotes_button, "Labor TAB");
		click("Labour TAB", laborTAB_Quotes_button);
		waitForElement(new_laborTab_Quotes_button, "New Button");

		click("New", new_laborTab_Quotes_button);
		waitLoadingSpinnerToDisappear();
		driver.findElement(By.xpath("(//*[contains(@class, 'dataRow even first')]//td[text()='1'])[2]")).click();
		robortClassPressTAB(4);
		sendKey("Travel");
		waitTill("5");
		waitForElement(typeOfMeasure_Labor_dropdown, "Type of Measure Dropdown");
		selectFromDropDown(typeOfMeasure_Labor_dropdown, "Distance", "Type of Measure Dropdown");
		waitTill("6");
		driver.findElement(By.xpath("(//*[contains(@class, 'dataRow even first')]//td[text()='1'])[2]")).click();
		robortClassPressTAB(6);
		sendKey("2");
		waitTill("5");
		robortClassPressTAB(1);
		sendKey("WD NH Reg – Regular Labour,Weekdays,Normal Working Hours");

		click("New", new_laborTab_Quotes_button);
		waitLoadingSpinnerToDisappear();
		driver.findElement(By.xpath("//*[contains(@class, 'dataRow odd last')]//td[text()='2']")).click();
		robortClassPressTAB(4);
		sendKey("On Site");
		robortClassPressTAB(1);
		sendKey("WD NH Reg – Regular Labour,Weekdays,Normal Working Hours");
		logReport("INFO", "Onsite Labor Added");

		click("New", new_laborTab_Quotes_button);
		waitLoadingSpinnerToDisappear();
		waitTill("5");
		driver.findElement(By.xpath("//*[contains(@class, 'dataRow even last')]//td[text()='3']")).click();
		robortClassPressTAB(4);
		sendKey("Remote");
		robortClassPressTAB(1);
		sendKey("WD NH Reg – Regular Labour,Weekdays,Normal Working Hours");
		logReport("INFO", "Remote Labor Added");
		waitTill("15");
	}

	// Souvik
	public void getPriceOrVat_QuotesSFM() {
		waitForElement(getPriceOrVat_button, "Get Price/VAT Button");
		click("Get Price/VAT Button", getPriceOrVat_button);
		waitLoadingSpinnerToDisappear();
		// waitForElement(getPriceOrVat_successMessage1, "Success Message");
		if (getPriceOrVat_successMessage1.size() > 0) {
			logReport("PASS", "Quote saved and prices are fetched as set in the SAP for the lines added");
		} /*
			 * else { logReport("FAIL", "Issue in getting VAt or Price");
			 * Assert.fail("Issue in getting VAt or Price"); }
			 */
	}

	public void pullDiscountsFromContract_QuotesSFM() {
		waitForElement(PullDiscountsFromContract_button, "pull Discounts From Contract Button");
		click("pull Discounts From Contract Button", PullDiscountsFromContract_button);
		waitLoadingSpinnerToDisappear();
		if (getPriceOrVat_successMessage1.size() > 0) {
			logReport("PASS", "Discount Pulled Successfully");

		} else if (errorHeader.size() > 0) {
			logReport("FAIL", "Error Message: " + errorMessage1.getText());
			Assert.fail("Error Encountered");
		}
	}

	public void complete_QuoteCreation() {
		// TODO Auto-generated method stub
		waitForElement(done_Quote, "Done Button");
		click("Done Button", done_QuotesSFM_button);

		waitForElement(serviceQuote_pageTitleIcon, "Service Quote Page Header Image");
		if (serviceQuote_pageTitleIcon.isDisplayed()) {
			AutomationConstants.RUN_TIME_TEMP_DATA.put("QUOTE_NUMBER", created_QuoteNumber.getText());
			logReport("INFO", "Quote Created Successfully");
			logReport("INFO", "Quote Number: *****" + created_QuoteNumber.getText() + " *****");
		} else {
			logReport("FAIL", "Quote Creatin Failed");
			Assert.fail("Quote Creatin Failed");
		}

		logReport("INFO", "Total Net Price: " + totalNetPrice_ServiceQuote.getText());
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("Total_Net_Price",
				totalNetPrice_ServiceQuote.getText());
		logReport("INFO", "Total Gross Price: " + totalGrossPrice_ServiceQuote.getText());
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("Total_Gross_Price",
				totalGrossPrice_ServiceQuote.getText());
	}

	public void verifyPDF_in_attachmentSection() {
		waitForElement(caseDetailsPage_SFM_frame, "Frame");
		scrollByViewOfElement(attachmentTable_header);

		// List<WebElement>
		// pdfLinks=driver.findElements(By.xpath("//*[contains(text(),
		// 'English_Quote_Q-00280621.pdf')]"));
		List<WebElement> pdfLinks = driver.findElements(By.xpath("//*[contains(text(), 'English_Quote_"
				+ AutomationConstants.RUN_TIME_TEMP_DATA.get("Service_Quote") + ".pdf')]"));

		if (pdfLinks.size() > 0) {
			// WebElement
			// pdfLink=driver.findElement(By.xpath("(//*[contains(text(),
			// 'English_Quote_Q-00280621.pdf')])[1]"));
			// highlightElement(driver, pdfLink, "3");
			logReport("INFO", "PDF Listed in Case Attachment");
		} else {
			Assert.fail("PDF Not Listed in Case Attachments");
		}

	}

	public void check_SO_WBS() {
		waitTill("10");
		waitForElement(installed_product_custom_Action_frame, "installed_product_custom_Action_frame");
		waitTill("30");
		try {
			driver.switchTo().frame(installed_product_custom_Action_frame);
		} catch (Exception e) {
			driver.switchTo()
					.frame(driver.findElement(By.xpath("//iframe[@title='ESMX_Installed_Product_Wizard_Lite']")));
		}
		waitTill("5");
		clickEvent(Check_SalesOrder_SFM);
		waitLoadingSpinnerToDisappear();
		
	}

	public void caseClosure() {
		waitTill("3");
		if(verifyElementPresent("Case Details", case_Details))
		{
			click("case_Details", case_Details);
		}
		
		waitForElement(business_complete_sfm, "business_complete_sfm");
		waitTill("5");
		driver.switchTo().frame(manage_WorkOrder_Frame);
		click("business_complete_sfm", business_complete_sfm);
		waitTill("5");
		click("save_Work_Order_Lines", save_Work_Order_Lines);
		waitSpinnerToDisappear();
		//scrollByViewOfElement(case_Number);
		//embedScreenShotInreport();
		
	}

	public void createRecordsusingIMUfile() {
		
		String parent = driver.getWindowHandle();
		click("uploadIMUFile", uploadIMUFile);
		waitTill("3");
		
		Set<String> windows = driver.getWindowHandles();
		System.out.println("No. of windows:"+windows.size());
		for (String win : windows) {
			if (!win.equals(parent)) {
				driver.switchTo().window(win);
			}
		}
		waitTill("6");
		//click("File upload", driver.findElement(By.cssSelector("lightning-primitive-icon")));
		//click("file_Upload_IMU", file_Upload_IMU);
		selectFileToUpload(file_Upload_IMU, AutomationConstants.IMUFilePatch);
		waitTill("6");
		embedScreenShotInreport();
		click("Process IMU CSV File", process_IMU_CSV_button);
		waitTill("6");
		driver.switchTo().defaultContent();
		
	}

	public void verifyIMURecordsCreated(String[] FieldName, String[] Operator, String[] Value) {
			waitTill("5");
			CreateView(FieldName, Operator, Value);
			waitTill("5");
			embedScreenShotInreport();
			AutomationConstants.RUN_TIME_TEMP_DATA.put("IMU RECORD1", record_numbers_IMU.get(0).getText());
			AutomationConstants.RUN_TIME_TEMP_DATA.put("IMU RECORD2", record_numbers_IMU.get(1).getText());
			AutomationConstants.RUN_TIME_TEMP_DATA.put("IMU RECORD SIZE", String.valueOf(record_numbers_IMU.size()));
	}

	public void createCaseOnIMURecords() {
		waitTill("3");
		selectAllCheckBoxes(select_all_IMU_Records);
		waitTill("4");
		embedScreenShotInreport();
		click("Create IMU Case", create_IMU_Case);
		waitTill("6");
		embedScreenShotInreport();
		//driver.switchTo().alert().accept();
		waitTill("3");
		
	}

	public void verifyTrackwiseStatus_IMURecords(String recordNo, String expStatus) {
		System.out.println("Size:"+AutomationConstants.RUN_TIME_TEMP_DATA.get("IMU RECORD SIZE"));
		switch(recordNo) {
		case "Record2":
			click("Record", record_numbers_IMU.get(0));
			waitTill("3");
			embedScreenShotInreport();
			scrollByViewOfElement(trackwise_status_IMU);
			embedScreenShotInreport();
			Assert.assertTrue(trackwise_status_IMU.getText().equalsIgnoreCase(expStatus));
			break;
		case "Record1":
			click("Record", record_numbers_IMU.get(1));
			waitTill("3");
			embedScreenShotInreport();
			scrollByViewOfElement(trackwise_status_IMU);
			embedScreenShotInreport();
			Assert.assertTrue(trackwise_status_IMU.getText().equalsIgnoreCase(expStatus));
			break;
		
		
		}
		driver.navigate().back();
		waitTill("3");
		
//		for(int i =0; i<2; i++) {
//		//for(int i=0; i<record_numbers_IMU.size(); i++) {
//			//if(record_numbers_IMU.get(i).getText().equals(AutomationConstants.RUN_TIME_TEMP_DATA.get("IMU RECORD1")) || record_numbers_IMU.get(i).getText().equals(AutomationConstants.RUN_TIME_TEMP_DATA.get("IMU RECORD2"))){
//				//j++;
//				click("Record", record_numbers_IMU.get(i));
//				waitTill("3");
//				embedScreenShotInreport();
//				scrollByViewOfElement(trackwise_status_IMU);
//				embedScreenShotInreport();
//				System.out.println("trackwise_status_IMU.getText():"+trackwise_status_IMU.getText());
//				System.out.println("Expect:"+expStatus);
//				waitTill("10");
//				String actVal = trackwise_status_IMU.getText();
//				//Assert.assertTrue(trackwise_status_IMU.getText().contains(expStatus));
//				if (actVal.equalsIgnoreCase(expStatus)) {
//					System.out.println("Pass");
//					Assert.assertTrue(trackwise_status_IMU.getText().equalsIgnoreCase(expStatus));
//				}
//				driver.navigate().back();
//				waitTill("5");
//			}
//			
//			if(String.valueOf(j) == AutomationConstants.RUN_TIME_TEMP_DATA.get("IMU RECORD SIZE")) 
//				break;
//		}
		
	}

	public void verifyReasonIncompletion(String expectedResult) {
	waitTill("6");
	driver.navigate().refresh();
	waitTill("6");
	
	if (verifyElementPresent("Reason for Incompletion", reason_for_incompletion)) {
		scrollByViewOfElement(reason_for_incompletion);
		embedScreenShotInreport();
		Assert.assertTrue(verifyElementPresent("Reason for Incompletion", reason_for_incompletion));
		System.out.println("Actual Result : "+reason_for_incompletion.getText());
		System.out.println("Expected Result : "+expectedResult);
		Assert.assertTrue(reason_for_incompletion.getText().contains(expectedResult));
	}
	
		
	}
	
	
	public void addCaseLines() {
		waitTill("10");
		waitForElement(manage_WorkOrder_Frame, "manage_WorkOrder_Frame");
		embedScreenShotInreport();
		try {
			driver.switchTo().frame(manage_WorkOrder_Frame);
		} catch (Exception e) {
			driver.switchTo()
					.frame(driver.findElement(By.xpath("//iframe[@title='ESMX_Case_Wizard_Lite']")));
		}
		waitTill("10");
		clickEvent(add_caselines_SFM);
		waitLoadingSpinnerToDisappear();
		waitTill("15");
		
		click("Extended Edit",extended_Edit.get(0));
		
		enter("Product Code", ip_caseLines, AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("PRODUCTCODE1"));
		driver.findElement(By.xpath("//*[text()='Installed Product:']/parent::td/following-sibling::td//*[@role='button']")).click();
		waitTill("10");
		embedScreenShotInreport();
		click("Cancel", cancelButton_extended_edit);
		
		enter("Serial Number", ip_caseLines, AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("SERIALNUM1"));
		driver.findElement(By.xpath("//*[text()='Installed Product:']/parent::td/following-sibling::td//*[@role='button']")).click();
		waitTill("10");
		embedScreenShotInreport();
		click("Cancel", cancelButton_extended_edit);
		
		enter("Functional Location", ip_caseLines, AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("FUNLOC1"));
		driver.findElement(By.xpath("//*[text()='Installed Product:']/parent::td/following-sibling::td//*[@role='button']")).click();
		waitTill("10");
		embedScreenShotInreport();
		click("Cancel", cancelButton_extended_edit);
		
		addipDetails("ip1");
		
		click("Add Row", addRow.get(0));
		click("Extended Edit",extended_Edit.get(1));
		
		addipDetails("ip2");
		waitTill("3");
		scrollByViewOfElement(addRow.get(0));
		embedScreenShotInreport();
		click("save_case", save_case);
		waitLoadingSpinnerToDisappear();
		waitTill("25");
		if (verifyElementPresent("Case Details", case_Details)) {
			click("Case Details", case_Details);
		}
	}
	
	public void addipDetails(String ipValue) {
		switch(ipValue) {
		case "ip1":
			enter("Installed Product", ip_caseLines, AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("IP1"));
			
			break;
		case "ip2":
			enter("Installed Product", ip_caseLines, AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("IP2"));
			break;
		}
		driver.findElement(By.xpath("//*[text()='Installed Product:']/parent::td/following-sibling::td//*[@role='button']")).click();
		waitTill("10");
		embedScreenShotInreport();
		driver.findElement(By.xpath("//span[text()='Installed Product ID']/../../../../../following-sibling::div//tr/td/div"))
				.click();
		waitTill("5");
		click("select_Contact_id_fullname", select_Contact_id_fullname);
		waitTill("5");
		click("updateButton", updateButton);
	}

	public void verifyCaselineCheckbox() {
		scrollByViewOfElement(caseLines_numbers.get(0));
		embedScreenShotInreport();
		
		click("caseLines_number", caseLines_numbers.get(0));
		waitTill("5");
		
		System.out.println("T&M IP :"+tandm_IP_field.getAttribute("title"));
		Assert.assertTrue(tandm_IP_field.getAttribute("title").equalsIgnoreCase("Checked"));
		
		Utility.highlightElement(driver, tandm_IP_field);
		embedScreenShotInreport();
		
		
		
	}
	
	@FindBy(xpath="//input[@value='Check SalesOrder Type/WBS']")
	public WebElement check_SalesOrder_Type_WBS;
	//Hima
		public void check_SalesOrder() {
			try {
				driver.switchTo().frame(installed_product_custom_Action_frame);
			} catch (Exception e) {
				driver.switchTo()
						.frame(driver.findElement(By.xpath("//iframe[contains(@title,'ESMX_Installed_Product_Wizard_Lite')]")));
			}
			waitTill("5");
			clickEvent(check_SalesOrder_Type_WBS);
			waitTill("20");
		}
	
	

}
