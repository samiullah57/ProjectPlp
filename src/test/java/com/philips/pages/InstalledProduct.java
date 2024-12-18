package com.philips.pages;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.Keyboard;
import com.philips.generic.AutomationConstants;
import com.philips.generic.Excel;
import com.philips.generic.SOQLQuerys;
import com.philips.generic.Utility;
import com.philips.stepdefinitions.Hooks;

import cucumber.runtime.CucumberException;
import junit.framework.Assert;

public class InstalledProduct extends BasePage{

	public static String locationNumber;
	public static String itemNumber;
	public static String product;

	public static String FLURL = null;
	public String UpdatedFL = null;

	@FindBy(xpath = "//label[text()='Functional Location Name']/../following-sibling::td[1]//input")
	public WebElement edit_FLName;

	@FindBy(xpath = "//label[text()='SAP External ID']/../following-sibling::td[1]//input")
	public WebElement edit_FLSAP_Ext;

	@FindBy(xpath = "//label[text()='View:']/..//select")
	public WebElement FilterSelect;

	@FindBy(xpath = "//a[text()='Edit']")
	public WebElement FilterEditLink;

	@FindBy(xpath = "//label[text()='View:']/..//select")
	public WebElement firstFilterSeleciton;

	@FindBy(xpath = "//option[@selected = 'selected' and text()='IP Staging Name']/ancestor::tr[1]/td[4]/input")
	public WebElement IPStageNameChange;

	@FindBy(xpath = "//option[@selected = 'selected' and text()='Top Level']/ancestor::tr[1]/td[4]/input")
	public WebElement TopLevelChange;

	@FindBy(xpath = "//input[@id = 'allBox']")
	public WebElement allCheckbox;

	@FindBy(xpath = "//input[@value = 'Process IP']")
	public WebElement ProcessIPButton;

	@FindBy(xpath = "//img[@class='checkImg']")
	public WebElement fourceUpdateField;

	@FindBy(xpath = "//td[text()='Force Update']/..//input")
	public WebElement FourceUpdateCheckbox;

	@FindBy(xpath =".//*[@id='SVMXC__Installed_Product__c']")
	private WebElement searchResult;

	@FindBy(xpath="//*[text()='Installed Product Detail']")
	private WebElement installedProduct_Page;

	//	@FindBy(xpath="//*[text()='Service Provider Account']/parent::td/following-sibling::td/a")
	//	private WebElement serviceProviderAcc;

	@FindBy(xpath="//iframe[contains(@title,'Installed_Product_Wizard')]")
	private WebElement IP_Frame;

	@FindBy(xpath = "//input[@value='View Entitlement']")
	private WebElement view_entitlement;

	@FindBy(xpath = "//label[text()='Warranty:']/../..//input")
	private WebElement input_warranty;

	@FindBy(xpath = "//label[text()='Service/Maintenance Contract:']/../..//input")
	private WebElement input_servicemaintenancecontract;

	@FindBy(xpath = "//span[text()='Is Entitlement Performed']/../following-sibling::td//img[@title='Checked']")
	private WebElement checkbox_entitlement;

	@FindBy(xpath = "//span[text()='Billing Type']/../following-sibling::td/div")
	private WebElement bill_type;

	@FindBy(xpath = "//span[text()='Override Cost Center']/../following-sibling::td[1]//div")
	private WebElement verify_CostCenter;

	//	
	//	@FindBy(xpath="//iframe")
	//	List<WebElement>list_frmaes;
	//
	//	@FindBy(xpath="//input[@value='Create Case']")
	//	private WebElement create_Case_SFM;
	//
	//	@FindBy(xpath=".//*[@id='svmx_sfm_delivery_root_container0-info']")
	//	private WebElement creat_Case_dialog;
	//
	//	@FindBy(xpath="//*[text()='Contact ID:']/parent::td/following-sibling::td//input")
	//	private WebElement contactID_Searchinput;
	//
	//	@FindBy(xpath="//*[text()='Contact ID:']/parent::td/following-sibling::td//*[@role='button']")
	//	private WebElement contactID_SearchBtn;
	//
	//	@FindBy(xpath="//span[text()='Full Name']/../../../../../following-sibling::div//tr/td/div")
	//	private WebElement contact_ID_fullname;
	//
	//	@FindBy(xpath="//span[text()='Select']")
	//	private WebElement select_Contact_id_fullname;
	//
	//	@FindBy(xpath="//*[text()='Event Type:']/parent::td/following-sibling::td//*[@role='button']")
	//	private WebElement eventType_dropdown;
	//
	//	@FindBy(xpath="//*[text()='Service Type/Event Subtype:']/parent::td/following-sibling::td//*[@role='button']")
	//	private WebElement eventSubType_dropdown;
	//
	//	@FindBy(xpath="//*[text()='Priority:']/parent::td/following-sibling::td//*[@role='button']")
	//	private WebElement priority_Dropdown;
	//
	//	@FindBy(xpath="//li[text()='1-Critical Need']")
	//	private WebElement priority_Value;
	//
	//	@FindBy(xpath="//*[text()='Subject:']/parent::td/following-sibling::td/input")
	//	private WebElement subject;
	//
	//	@FindBy(xpath="//*[text()='Description:']/parent::td/following-sibling::td/textarea")
	//	private WebElement desc;
	//
	//	@FindBy(xpath="//button[@data-qtip='Save']")
	//	private WebElement save_case;
	//
	//	@FindBy(xpath="//span[text()='Case Number']/following-sibling::span/span")
	//	private WebElement case_Number;
	//
	//	/********************************************************************************************************************************************
	//	 * @author M1028261 This section contains elements and variables recorded by
	//	 *         M1028261
	//	 */
	//	// Installed Product screen
	//	@FindBy(xpath = "//span[text() = 'Location']/ancestor::td[@class = 'labelCol']/following-sibling::td//a")
	//	private WebElement Location;
	//
	@FindBy(xpath = "//*[@class = 'linklet']/span[text() = 'Product Warranty']")
	private WebElement ProductWarranty;

	@FindBy(xpath = "(//th/a[contains(text(), 'WN-')]/ancestor::th/following-sibling::td[@class = ' dataCell  DateElement'])[1]")
	private WebElement WarrantyStartDate;

	@FindBy(xpath = "(//th/a[contains(text(), 'WN-')]/ancestor::th/following-sibling::td[@class = ' dataCell  DateElement'])[2]")
	private WebElement WarrantyEndDate;

	@FindBy(xpath = "//a[contains(@title, 'Edit - Record 1 - WN-')]")
	private WebElement EditProductWarranty;

	@FindBy(xpath = "//*[@title = 'Checked']/ancestor::td/preceding-sibling::td/*[contains(text(), 'CON')]")
	private WebElement ServiceContractNumber;
	//
	//	// Product Warranty Page
	//	@FindBy(xpath = "//label[text() = 'Bench Repair Services Covered']//ancestor::td/following-sibling::td/input")
	//	private WebElement BenchRepairServicesCovered;
	//
	//	// Contract Header
	//	@FindBy(xpath = "//*[@class = 'allTabsArrow']")
	//	private WebElement AllTabs;
	//
	//	@FindBy(xpath = "//*[text() = 'Contract Headers']")
	//	private WebElement ContractHeaders;
	//
	//	@FindBy(xpath = "//*[@value = ' New ']")
	//	private WebElement New;
	//
	//	@FindBy(xpath = "//*[@id = 'CF00NE0000005mxV8']")
	//	private WebElement Account;
	//
	//	@FindBy(xpath = "//*[@alt = 'Account Lookup (New Window)']")
	//	private WebElement AccountLookup;
	//
	//	@FindBy(xpath = "//a[@href = '#']")
	//	private WebElement AccountName;
	//
	//	@FindBy(xpath = "//*[@id = 'CF00NE0000005mxVF']")
	//	private WebElement CH_LocationInfo;
	//
	//	@FindBy(xpath = "//*[@alt = 'Location Lookup (New Window)']")
	//	private WebElement LocationLookup;
	//
	//	@FindBy(xpath = "//*[@id = '00NE0000005mxVT']")
	//	private WebElement StartDate;
	//
	//	@FindBy(xpath = "//*[@id = '00NE0000005mxVC']")
	//	private WebElement EndDate;
	//
	//	@FindBy(xpath = "(//*[@title = 'Save'])[1]")
	//	private WebElement Save;
	//
	//	@FindBy(xpath = "//h2[contains(text(), 'CH-')]")
	//	private WebElement ContractHeader;
	//
	//	// Service Contract Screen
	//	@FindBy(xpath = "//*[text() = 'Contract Header']/ancestor::td/following-sibling::td//a[contains(text(), 'CH')]")
	//	private WebElement ContractHeaderNumber;
	//
	//	@FindBy(xpath = "//*[@value = 'Create Risk Sharing Model']")
	//	private WebElement CreateRSM;
	//
	//	// Create Risk Sharing Model Screen
	//	@FindBy(xpath = "//*[text() = 'Threshold Quantity:']/ancestor::td/following-sibling::td//input")
	//	private WebElement ThresholdQuantity;

	@FindBy(xpath = "//*[text() = 'Included Services:']/ancestor::td/following-sibling::td//input")
	private WebElement IncludedServices;

	//	@FindBy(xpath = "//*[text() = 'Incident Work Time']")
	//	private WebElement IncidentWorkTime;

	@FindBy(xpath = "//*[text() = 'Travel Time']")
	private WebElement TravelTime;

	//	@FindBy(xpath = "//*[text() = 'RSM Start Date:']/ancestor::td/following-sibling::td//input")
	//	private WebElement RSMStartDate;
	//
	//	@FindBy(xpath = "//*[text() = 'RSM End Date:']/ancestor::td/following-sibling::td//input")
	//	private WebElement RSMEndDate;
	//
	//	@FindBy(xpath = "//td/*[contains(text(), 'RSM-')]")
	//	private WebElement RSMNumber;
	//
	//	// Manage Risk Sharing Model
	//	@FindBy(xpath = "//*[@value = 'Manage Risk Sharing Model']")
	//	private WebElement ManageRSM;
	//
	//	@FindBy(xpath = "//button[@data-qtip = 'Add a row']")
	//	private WebElement AddRow;
	//
	//	@FindBy(xpath = "(//td[contains(@data-qtip, 'RSM-')]/preceding-sibling::td)[2]/div")
	//	private WebElement ServiceContractEdit;
	//
	//	@FindBy(xpath = "(//td[@role = 'presentation']/input)[5]")
	//	private WebElement ServiceContract;
	//
	//	@FindBy(xpath = "(//td[@role = 'presentation']/input)[5]//ancestor::table/following-sibling::div//button")
	//	private WebElement ServiceContractSearch;
	//
	//	@FindBy(xpath = "//*[text() = 'Primary']")
	//	private WebElement SelectContract;
	//
	//	@FindBy(xpath = "//button/*[text() = 'Select']")
	//	private WebElement Select;
	//	
	//	@FindBy(xpath = "//*[text() = 'Threshold Quantity:']/ancestor::td/following-sibling::td//input")
	//	private WebElement TQty;
	//	
	//	@FindBy(xpath = ".//*[@id='sfm-button-1052-btnIconEl']")
	//	private WebElement save_safety_Questionaire;
	//
	//	@FindBy(xpath = "//td/input[contains(@value,'Create Onsite Work Order')]")
	//	public WebElement create_Onsite_Workorder_SFM;
	//
	//	@FindBy(xpath = ".//*[@id='sfm-number-1044-inputEl']")
	//	private WebElement planned_labor_hour;
	//
	//	@FindBy(xpath = ".//*[@id='sfm-button-1096-btnEl']")
	//	private WebElement save_WorkOrder;
	//	
	//	// Risk Sharing Model screen
	//	@FindBy(xpath = "//table[@class = 'detailList']//*[text() = 'Threshold Quantity']/ancestor::td/following-sibling::td")
	//	private WebElement ThresholdQty;
	//	
	//	@FindBy(xpath = "(//table[@class = 'detailList']//*[text() = 'Planned Quantity'])/ancestor::td/following-sibling::td")
	//	private WebElement PlannedQuantity;
	//	
	//	@FindBy(xpath = "//table[@class = 'detailList']//*[text() = 'Remaining Planned Quantity']/ancestor::td/following-sibling::td")
	//	private WebElement RemainingPlannedQuantity;
	//
	//	// Variables
	//	private String AccountID;
	//	private String WarrantyStart;
	//	private String WarrantyEnd;
	//
	//	/********************************************************************************************************************************************/
	//
	//	/*********************M1052147*************************************/
	@FindBy(xpath="//a[contains(@title,'Edit')]/parent::td/following-sibling::th/a")
	//a[contains(@title,'Edit')]/ancestor::div[@id='SVMXC__Installed_Product__c_body']//tr[2]//th/a")
	WebElement txt_IP;

	@FindBy(xpath="//div[@class='inlineEditRequiredDiv']/..")
	private WebElement btn_editStatus;

	@FindBy(xpath="//span[text()='Status' and @class='helpButton']/../following-sibling::td//select")
	private WebElement dropdown_Status;

	@FindBy(xpath="//span[text()='Location' and @class='helpButton']/parent::td/following-sibling::td[1]")
	private WebElement txt_location;

	@FindBy(xpath="//a[contains(@title,'Location Lookup')]")
	private WebElement lookup_new;

	@FindBy(xpath="//a[@title='Location Lookup (New Window)']/preceding-sibling::input[@type='text']")
	private WebElement lookup_new_input;
	//	
	//	@FindBy(xpath="//input[@id='lksrch']")
	//	private WebElement search_location;
	//	
	//	@FindBy(xpath="//input[@id='lkenhmdSEARCH_ALL']")
	//	private WebElement search_all;
	//	
	//	@FindBy(xpath="//frame[@title='Search']")
	//	private WebElement frame_search;
	//	
	//	@FindBy(xpath="//frame[@title='Results']")
	//	private WebElement frame_Results;
	//	
	//	@FindBy(xpath="//input[@title='Go!']")
	//	private WebElement btn_go;
	//	
	//	@FindBy(xpath="(//tr[contains(@class,'dataRow even')]//a)[1]")
	//	private WebElement location_value;

	@FindBy(xpath="//span[text()='Account' and @class='helpButton']/parent::td/following-sibling::td[1]")
	private WebElement txt_account;
	//	
	@FindBy(xpath="//span[text()='Location Account Nr']/parent::td/following-sibling::td[1]/div")
	private WebElement txt_locationNumber;

	@FindBy(xpath="//span[text()='Functional Location']/parent::td/following-sibling::td[1]/div")
	private WebElement txt_functionalNumber;

	@FindBy(xpath="//input[@title=' Customer Information']")
	private WebElement btn_customerInfo;

	@FindBy(xpath="(//table[contains(@class,'svmx-field svmx-form-item svmx-column')])[1]")
	private WebElement txt_accountText;

	@FindBy(xpath="//span[text()='Functional Location']/parent::td/following-sibling::td[1]")
	private WebElement txt_functionalLocation;

	@FindBy(xpath="//span[text()='Functional Location']/parent::td/following-sibling::td[1]//input[@type='text']")
	private WebElement functionalLocation;

	@FindBy(xpath="//tbody[contains(@id,'treeview-')]")
	private WebElement child_Records;

	@FindBy(xpath="//iframe[@title='IPRD_IBTree']")
	private WebElement frame_treeview;
	//	
	@FindBy(xpath="//h3[text()='Customer Information']")
	private WebElement label_customer;

	@FindBy(xpath="//span[text()='Vendor Warranty Start Date']/parent::td/following-sibling::td/div")
	private WebElement vendor_startdate;

	@FindBy(xpath="//span[text()='Vendor Warranty Start Date']/parent::td/following-sibling::td/div//input")
	private WebElement date_vendor;

	@FindBy(xpath="//span[text()='Vendor Warranty Duration']/parent::td/following-sibling::td[1]/div")
	private WebElement vendor_duration;


	@FindBy(xpath="//span[text()='Vendor Warranty Duration']/parent::td/following-sibling::td[1]/div//input")
	private WebElement edit_vendor_duration;


	@FindBy(xpath="//span[text()='Contact Name']/parent::td/following-sibling::td[1]/div")
	private WebElement vendor_contactName;

	@FindBy(xpath="//span[text()='Contact Name']/parent::td/following-sibling::td[1]/div//input")
	private WebElement txt_vendor_contactName;



	@FindBy(xpath="//h3[text()='Installed Product']")
	private WebElement tab_installedProducts;

	@FindBy(xpath="//span[text()='Installed Product']/parent::td/following-sibling::td//a")
	private WebElement link_ip;

	@FindBy(xpath="//label[text()='Sales Order Number:']/ancestor::table[contains(@class,'svmx-field svmx-form-item')]")
	private WebElement txt_salesOrder;

	@FindBy(xpath="//label[text()='Sales Order Item Number:']/ancestor::table[contains(@class,'svmx-field svmx-form-item')]")
	private WebElement txt_salesItemnum;


	@FindBy(xpath="//label[text()='SAP Sales Document ID:']/ancestor::table[contains(@class,'svmx-field svmx-form-item')]")
	private WebElement txt_salesDoc;

	@FindBy(xpath="//span[text()='SAP SWO Number']/parent::td/following-sibling::td[1]/div")
	private WebElement txt_sapSalesOrder;

	@FindBy(xpath="//span[text()='Order Status']/parent::td/following-sibling::td[1]/div")
	private WebElement txt_Orderstatus;

	@FindBy(xpath="(//a[contains(@title,'Edit')]/parent::td/following-sibling::th/following-sibling::td/a)[1]")
	private WebElement link_IPproduct;

	@FindBy(xpath="//span[text()='Logistics Handling Group']/parent::td/following-sibling::td")
	private WebElement ip_group;

	@FindBy(xpath="//td[text()='Product Code']/following-sibling::td[1]")
	private WebElement productNum;

	@FindBy(xpath = "//td/*[contains(text(), 'RSM-')]")
	public WebElement RSMNumber;

	@FindBy(xpath = "//*[@value = 'Manage Risk Sharing Model']")
	public WebElement ManageRSM;

	@FindBy(xpath = "//*[text() = 'Threshold Quantity:']/ancestor::td/following-sibling::td//input")
	public WebElement TQty;

	@FindBy(xpath = "//label[text()='Sales Org:']/../..//input")
	private WebElement input_salesorg;

	public InstalledProduct(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void open_Record_Verify_Data(String searchCriteria) {
		waitForElement(searchResult,"search Result");
		if(Hooks.testcaseNumber.equals("738148")) {

			driver.findElement(By.xpath(".//*[@id='SVMXC__Installed_Product__c_body']//a[text()='"+BaseLib.TEST_DATA.get(0).get(searchCriteria)+"']")).click();
			waitForElement(installedProduct_Page,"installedProduct_Page");
		}else {
			driver.findElement(By.xpath(".//*[@id='SVMXC__Installed_Product__c_body']//a[text()='"+searchCriteria+"']")).click();
			waitForElement(installedProduct_Page,"installedProduct_Page");

			try {
				AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("IP_LOCATION", locationLink.getText());
				System.out.println("Location on IP :"+AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("IP_LOCATION"));
			}catch(Exception e) {

			}
		}
		new BasePage(driver).embedScreenShotInreport();
		//assertTrue("Service Provider Account Verified", serviceProviderAcc.getText().contains("ASP"));
	}

	//	/**
	//	 * @author M1028261
	//	 * @param IPNumber
	//	 */
	//	public void StoreValue(String Type, String IPNumber) {
	//		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put(Type, IPNumber);
	//	}
	//
	//	/**
	//	 * @author M1028261
	//	 * @param getValueof
	//	 */
	//	public void getValuesof(List<String> getValueof) {
	//		for (String Value : getValueof) {
	//			switch (Value) {
	//			case "Service Contract":
	//				AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("SERVICE_CONTRACT",
	//						ServiceContractNumber.getText());
	//				break;
	//			case "Risk Sharing Model":
	//				click("Service Contract", ServiceContractNumber);
	//				waitTill("5");
	//				click("Contract Header", ContractHeaderNumber);
	//				waitTill("5");
	//				AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("RSM_NUMBER", RSMNumber.getText());
	//				break;
	//			}
	//		}
	//	}
	//
	//	/**
	//	 * @author M1028261 To verify IP details
	//	 * @param IPNumber
	//	 */
	//	public void VerifyIPDetails() {
	//		waitTill("5");
	//		click("IP Number", driver.findElement(By.xpath("//th/a[text() = '"
	//				+ AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("INSTALLED_PRODUCT") + "']")));
	//		waitTill("6");
	//		WarrantyStart = WarrantyStartDate.getText();
	//		WarrantyEnd = WarrantyEndDate.getText();
	//		click("Location", Location);
	//		waitTill("5");
	//		AccountID = driver
	//				.findElement(By
	//						.xpath("//span[text() = 'Account SAP External ID']/ancestor::td[@class = 'labelCol']/following-sibling::td/div"))
	//				.getText();
	//		driver.navigate().back();
	//		waitTill("5");
	//	}
	//
	//	/**
	//	 * @author M1028261 To create new Contract Header
	//	 */
	//	@SuppressWarnings({ "unchecked", "rawtypes" })
	//	public void CreateNewContractHeader() {
	//		click("All Tabs", AllTabs);
	//		waitTill("5");
	//		click("Contract Headers", ContractHeaders);
	//		waitTill("5");
	//		click("New", New);
	//		waitTill("5");
	//
	//		enter("Account", Account, AccountID);
	//		String mainWindow = driver.getWindowHandle();
	//		click("Account Lookup", AccountLookup);
	//		waitTill("5");
	//		@SuppressWarnings("rawtypes")
	//		Set s = driver.getWindowHandles();
	//		@SuppressWarnings("rawtypes")
	//		Iterator i = s.iterator();
	//		try {
	//			while (i.hasNext()) {
	//				String popupHandle = i.next().toString();
	//				if (!popupHandle.contains(mainWindow)) {
	//					driver.switchTo().window(popupHandle);
	//					SwitchtoFramesByID("searchFrame");
	//					click("All Fields Radio Button", AllFields);
	//					click("Go", Go);
	//					driver.switchTo().defaultContent();
	//					waitTill("5");
	//					SwitchtoFramesByID("resultsFrame");
	//					click("Account Name", AccountName);
	//					driver.switchTo().window(mainWindow);
	//				}
	//			}
	//		} catch (CucumberException | NoSuchWindowException e) {
	//		}
	//		s.clear();
	//
	//		enter("Location", CH_LocationInfo, AccountID);
	//		mainWindow = driver.getWindowHandle();
	//		click("Location Lookup", LocationLookup);
	//		waitTill("5");
	//		Set h = driver.getWindowHandles();
	//		i = h.iterator();
	//		try {
	//			while (i.hasNext()) {
	//				String popupHandle = i.next().toString();
	//				if (!popupHandle.contains(mainWindow)) {
	//					driver.switchTo().window(popupHandle);
	//					SwitchtoFramesByID("searchFrame");
	//					click("All Fields Radio Button", AllFields);
	//					click("Go", Go);
	//					driver.switchTo().defaultContent();
	//					waitTill("5");
	//					SwitchtoFramesByID("resultsFrame");
	//					click("Account Name", AccountName);
	//					driver.switchTo().window(mainWindow);
	//				}
	//			}
	//		} catch (CucumberException | NoSuchWindowException e) {
	//		}
	//		enter("Start Date", StartDate, WarrantyStart);
	//		enter("End Date", EndDate, WarrantyEnd);
	//		WebListbyID("00NE0000005mxVO", "ES93");
	//		waitTill("5");
	//		WebListbyID("00NE0000005mxVK", "ES");
	//		click("Save", Save);
	//		waitTill("5");
	//		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("CONTRACT_HEADER", ContractHeader.getText());
	//	}
	//
	//	/**
	//	 * @author M1028261 To edit Warranty details of Installed Product
	//	 */
	//	public void EditProductWarranty() {
	//		click("Edit Product Warranty", EditProductWarranty);
	//		waitTill("5");
	//		List<WebElement> allConditions = driver.findElements(By.xpath(
	//				("//div/h3[text() = 'Conditions']/ancestor::div/following-sibling::div/table[@class = 'detailList'][1]/tbody/tr/td/input[@checked = 'checked']")));
	//		deSelectAllCheckBoxes(allConditions);
	//		selectCheckBoxe(BenchRepairServicesCovered);
	//		click("Save", Save);
	//	}
	//
	//	/**
	//	 * @author M1028261
	//	 */
	//	public void CreateRiskSharingModels() {
	//		click("Contract Header", ContractHeaderNumber);
	//		waitTill("5");
	//		SwitchtoFramesByID("0660L000001TgWU");
	//		click("Create Risk Sharing Model", CreateRSM);
	//		driver.switchTo().defaultContent();
	//		WebComboBox("//*[text() = 'Risk Sharing Model:']/ancestor::td/following-sibling::td//input", "Block of Hours",
	//				"//*[text() = 'Block of Hours']");
	//		waitTill("5");
	//		WebComboBox("//*[text() = 'RSM Sequence:']/ancestor::td/following-sibling::td//input", "Primary",
	//				"//*[text() = 'Primary']");
	//		enter("Threshold Quantity", ThresholdQuantity, "8");
	//		click("Included Services", IncludedServices);
	//		selectCheckBoxe(IncidentWorkTime);
	//		selectCheckBoxe(TravelTime);
	//		enter("RSM Start Date", RSMStartDate, WarrantyStart);
	//		enter("RSM End Date", RSMEndDate, WarrantyEnd);
	//		click("Save RSM", save_case);
	//		waitTill("5");
	//	}
	//
	//	/**
	//	 * @author M1028261
	//	 */
	//	public void ManageRiskSharingModels() {
	//		SwitchtoFramesByID("0660L000001Tgom");
	//		waitTill("5");
	//		click("Manage Risk Sharing Model", ManageRSM);
	//		waitTill("5");
	//		driver.switchTo().defaultContent();
	//		clickEvent(AddRow);
	//		waitTill("5");
	//		clickEvent(ServiceContractEdit);
	//		enter("Service Contract Number", ServiceContract,
	//				AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CONTRACT_NUMBER"));
	//		clickEvent(ServiceContractSearch);
	//		waitTill("5");
	//		clickEvent(SelectContract);
	//		clickEvent(Select);
	//		waitTill("5");
	//		clickEvent(save_case);
	//		waitTill("5");
	//	}
	//	
	//	/**
	//	 * @author M1028261
	//	 */
	//	public void VerifyRSMDetails() {
	//		verifyTextContains(PlannedQuantity, AutomationConstants.SERVICE_CONSULTENCY_CONTRACT_DATA.get("PLANNED_HOURS"));
	//		int TQ = Integer.parseInt(ThresholdQty.getText());
	//		int PQ = Integer.parseInt(PlannedQuantity.getText());
	//		verifyTextContains(RemainingPlannedQuantity, Integer.toString((TQ-PQ)));
	//		Utility.getPageScreenShot(driver, "RSM");
	//	}
	//	
	//	/**
	//	 * @author M1028261
	//	 */
	//	public void ManageRiskSharingModel() {
	//		SwitchtoFramesByID("0660L000001Tgom");
	//		waitTill("5");
	//		click("Manage Risk Sharing Model", ManageRSM);
	//		waitTill("5");
	//		driver.switchTo().defaultContent();
	//		enter("Threshold Quantity", TQty, "10");
	//		clickEvent(save_case);
	//		waitTill("5");
	//	}
	//	
	/**M1052147**/

	public void select_IP(){
		waitTill("25");
		waitForElement(txt_IP, "IP value");
		//click("IP value", txt_IP);
		driver.findElement(By.xpath("//a[contains(@title,'Edit')]/parent::td/following-sibling::th/a")).click();
		waitTill("10");
		embedScreenShotInreport();
	}

	public void update_IP(String status,String location,String account) throws InterruptedException{
		waitTill("5");
		hover(txt_status);
		waitForElement(txt_status, "Edit status");
		doubleClick("Edit status", txt_status);
		selectbyValue(dropdown_Status,status, "Available");
		waitForElement(txt_location, "Location");
		hover(txt_location);
		waitForElement(txt_location, "Edit location");
		doubleClick("Edit location", txt_location);
		waitTill("5");
		//enter("Select location", lookup_new_input, location);
		//selectLookupValue("Select location", lookup_new , location);
		switchToTab(0);
		scrollByViewOfElement(txt_account);
		hover(txt_account);
		waitForElement(txt_account, "Edit location");
		doubleClick("Edit location", txt_account);
		waitTill("5");
		//enter("Select location", lookup_new_input, location);
		//selectLookupValue("Select location", lookup_new , location);
		switchToTab(0);
		try {
			scrollByViewOfElement(btn_save);
			click("Save", btn_save);
		}catch(Exception e) {

			scrollByViewOfElement(save_FCO);
			click("Save", save_FCO);
		}
		waitTill("5");
		driver.navigate().refresh();
		waitTill("5");
		locationNumber=txt_locationNumber.getText();
		functionalNum=txt_functionalNumber.getText();
		logReport("INFO", "The location number is "+locationNumber+"and functional number is "+functionalNum);
	}

	public void select_customerInfo(){
		waitAndswitchToRequiredFrame(IP_Frame);
		waitTill("5");
		click("Customer information", btn_customerInfo);
	}

	public void getAccountNumber(){
		waitForElement(txt_accountText, "Account number");
		accountNumber=txt_accountText.getText();
		logReport("INFO", "The account number is "+accountNumber);
	}

	public void delete_FunctionLocation(){
		scrollByViewOfElement(txt_functionalLocation);
		hover(txt_functionalLocation);
		doubleClick(txt_functionalLocation);
		waitForElement(functionalLocation, "functional location value");
		clear("functional location value", functionalLocation);
		try {
			scrollByViewOfElement(btn_save);
			click("Save", btn_save);
		}catch(Exception e) {
			waitTill("5");
			scrollByViewOfElement(driver.findElement(By.xpath("//input[@title='Save']")));
			waitTill("5");
			click("Save", driver.findElement(By.xpath("//input[@title='Save']")));
		}
		waitTill("6");
		logReport("INFO", "Wait for BHOOMI repsonse for to update in SAP application");
	}

	public void add_FunctionalLocation(){
		scrollByViewOfElement(txt_functionalLocation);
		hover(txt_functionalLocation);
		doubleClick(txt_functionalLocation);
		waitForElement(functionalLocation, "functional location value");
		enter("Functional location", functionalLocation, functionalNum);
		try {
			scrollByViewOfElement(btn_save);
			click("Save", btn_save);
		}catch(Exception e){
			waitTill("5");
			scrollByViewOfElement(driver.findElement(By.xpath("//input[@title='Save']")));
			waitTill("5");
			click("Save", driver.findElement(By.xpath("//input[@title='Save']")));
		}
		waitTill("6");
		logReport("INFO", "Wait for BHOOMI repsonse for to update in SAP application");
	}

	public void select_SAPIP(){
		driver.navigate().refresh();
		waitTill("300");
		boolean flag = true;
		int x=0;
		while(flag&&x<3) {
			driver.findElement(By.xpath(".//input[@id='phSearchInput']")).sendKeys(LeanFTPage.orderNumber);
			waitTill("3");
			driver.findElement(By.xpath(".//input[@id='phSearchButton']")).click();
			waitTill("3");
			try {
				if(driver.findElement(By.xpath("//a[contains(@title,'Edit')]/parent::td/following-sibling::th/a")).isDisplayed()) {
					flag = false;
				}else { x=x+1;
				driver.navigate().refresh();
				waitTill("300");
				}
			}catch(Exception e) {x=x+1;
			driver.navigate().refresh();
			waitTill("300");}
		}

		//search_GlobalsearchBox("88752054");
	}

	public void verify_childRecords(){
		waitTill("20");
		scrollByViewOfElement(driver.findElement(By.xpath("//*[text()='Configuration']")));
		waitTill("10");
		waitAndswitchToRequiredFrame(frame_treeview);
		embedScreenShotInreport();
		try {
			scrollByViewOfElement(child_Records);
			if(verifyElementPresent("Records", child_Records)){
				logReport("INFO", "The child records are available in configuration");
			}}catch(Exception e) {}

	}

	public void updateVendor_details(){
		driver.switchTo().defaultContent();
		scrollByViewOfElement(label_customer);
		waitTill("5");
		hover(vendor_startdate);
		waitTill("5");
		doubleClick(vendor_startdate);
		enter("vendor date", date_vendor, endDatevalue("MM/dd/yyyy", 0, 1, 0));
		hover(vendor_duration);
		waitTill("5");
		doubleClick(vendor_duration);
		waitTill("5");
		clear("vendor duration", edit_vendor_duration);
		enter("vendor duration", edit_vendor_duration, "120");
		scrollByViewOfElement(vendor_contactName);
		hover(vendor_contactName);
		waitTill("5");
		doubleClick(vendor_contactName);
		waitTill("5");
		enter("vendor date",txt_vendor_contactName,"test");
		waitTill("5");
		try {
			click("Save", btn_save);
		}catch(Exception e) {driver.findElement(By.xpath("//input[@title='Save']")).click();}
		waitTill("6");
		embedScreenShotInreport();
	}

	public void products_link()
	{
		waitForElement(detailsTab, "Detals tab");
		if(verifyElementPresent("Detals tab", detailsTab)){
			click("Detals tab", detailsTab);
		}
		scrollByViewOfElement(tab_installedProducts);
		waitForElement(link_ip, "ip");
		click("ip", link_ip);

	}

	public void verify_salesOrder(String sales){
		waitTill("5");
		if(txt_salesOrder.getAttribute("data-qtip").equalsIgnoreCase(sales)){
			logReport("PASS", "The sales order number is verified "+txt_salesOrder.getText());
		}else{
			logReport("FAIL", "The sales order number is not verified");
		}
		itemNumber=txt_salesItemnum.getAttribute("data-qtip");
		System.out.println("Item number is "+itemNumber);
		driver.navigate().back();

	}

	public void select_systemInfo(){
		waitAndswitchToRequiredFrame(IP_Frame);
		click("Customer information", systemInfoButton);
	}

	public void verifySales_documentID(String sales){
		waitForElement(txt_salesDoc, "Sales document");
		if(txt_salesDoc.getAttribute("data-qtip").equalsIgnoreCase(sales)){
			logReport("PASS", "The sales document is verified");
		}
	}

	public void swo_orderStatus(){
		verifyElementPresent("swo value", txt_sapSalesOrder);
		sapSalesnum=txt_sapSalesOrder.getText();
		logReport("INfo", "The created swo value is "+sapSalesnum);
		if(txt_Orderstatus.getText().equalsIgnoreCase("In Process")){
			logReport("PASS", "The order status is verified "+txt_Orderstatus.getText());
		}
	}

	@FindBy(xpath="//label[text()='Indent Installation:']/parent::td/following-sibling::td//input")
	private WebElement chk_indent;

	@FindBy(xpath="//div[@class='svmx-sfmd-error-cmp-error-detail']")
	private WebElement error_msg;

	@FindBy(xpath="//label[text()='Local Sales document Number:']/parent::td/following-sibling::td//input")
	private WebElement txt_sales;

	@FindBy(xpath="//h3[text()='Included Services']")
	WebElement includedservices;

	@FindBy(xpath="//a[text()='Travel Time']")
	WebElement traveltime;

	@FindBy(xpath="//a[text()='Incident Work Time']")
	WebElement incident_worktime;

	@FindBy(xpath="//span[text()='Plant']/..//following-sibling::td")
	WebElement ip_getvalues;

	public String ipplantvalues;

	public void verifyincludedservicessection() {

		scrollByViewOfElement(includedservices);
		verifyElementPresent("Incident Work Time", incident_worktime);
		verifyElementPresent("Travel time", traveltime);

	}

	public void getipvalues() {

		waitForElement(ip_getvalues, "Installed Product Pant value");
		ipplantvalues = ip_getvalues.getText();
	}

	public void select_checksalesOrder(){
		waitTill("15");
		driver.switchTo().frame(installed_product_custom_Action_frame);
		try
		{
			waitForElement(Check_SalesOrder_SFM, "check sales order/WBS");
			click("check sales order/WBS", Check_SalesOrder_SFM);

		}
		catch(Exception e)
		{
			waitTill("10");
			waitForElement(Check_SalesOrder_SFM, "check sales order/WBS");
			click("check sales order/WBS", Check_SalesOrder_SFM);

		}
		waitDottedSpinnerToDisappear();
	}



	public void createWorkorderIndenet(){
		waitForElement(create_Onsite_Workorder_SFM, "create_Onsite_Workorder_SFM");
		waitTill("6");
		driver.switchTo().frame(manage_WorkOrder_Frame);
		waitTill("5");
		click("create_Onsite_Workorder_SFM", create_Onsite_Workorder_SFM);
		waitForElement(planned_labor_hour, "safety_Questionair_Dialog");
		waitTill("4");
		enter("planned_labor_hour", planned_labor_hour, "2");
		waitTill("5");
		waitForElement(chk_indent, "indent Installation");
		waitTill("5");
		click("indent Installation", chk_indent);
		waitTill("5");
		click("save_WorkOrder", save_WorkOrder);
		waitLoadingSpinnerToDisappear();
		waitTill("5");
	}

	public void verify_error(){
		String actual=error_msg.getText();
		if(actual.contains("Please provide Local Sales document Number when indent installation is checked")){
			logReport("PASS", "The error message is validated");
		}else{
			logReport("INFO", "The error message is not matched");
		}

	}

	public void enterSalesNumber(String salesdoc){
		waitForElement(txt_sales, "Sales documnet");
		enter("Sales doc number", txt_sales, salesdoc);
		click("save_WorkOrder", save_WorkOrder);
		waitLoadingSpinnerToDisappear();
	}

	public void onsite_salesdoc(String salesdoc){
		waitForElement(create_Onsite_Workorder_SFM, "create_Onsite_Workorder_SFM");
		waitTill("5");
		driver.switchTo().frame(manage_WorkOrder_Frame);
		click("create_Onsite_Workorder_SFM", create_Onsite_Workorder_SFM);
		waitForElement(planned_labor_hour, "safety_Questionair_Dialog");
		waitTill("5");
		enter("planned_labor_hour", planned_labor_hour, "2");
		waitForElement(chk_indent, "indent Installation");
		click("indent Installation", chk_indent);
		waitForElement(txt_sales, "Sales documnet");
		enter("Sales doc number", txt_sales, salesdoc);
		click("save_WorkOrder", save_WorkOrder);
		waitLoadingSpinnerToDisappear();
	}


	public void select_IPproduct(){
		waitForElement(link_IPproduct, "Ip product");
		click("Ip product", link_IPproduct);
		waitForElement(ip_group, "logistices group");
		if(ip_group.getText().equalsIgnoreCase("ZSID")){
			logReport("PASS", "the product is ZSID");
		}else{
			logReport("FAIL", "Theproduct is not ZSID");
		}
		product=productNum.getText();
		embedScreenShotInreport();
		logReport("INFO", "The product value is "+product);
		driver.navigate().back();
		waitTill("5");
	}

	public static String PMaccountname;
	@FindBy(xpath = "//h3[text()='Preventive Maintenance Plans']")
	private WebElement preventive_maintenance;

	@FindBy(xpath = "//th[text()='PM Plan Name']/../..//following-sibling::tr/th/a")
	private WebElement pm_planname;

	@FindBy(xpath = "//td[text()='Start Date']/..//td[@class='dataCol col02 inlineEditWrite']")
	private WebElement pmplan_startdate;

	@FindBy(xpath = "//td[text()='End Date']/..//td[@class='dataCol col02 inlineEditWrite']")
	private WebElement pmplan_enddate;

	@FindBy(xpath = "//td[text()='PM Plan Template']/..//td[@class='dataCol col02 inlineEditWrite']")
	private WebElement pmplan_templatename;

	@FindBy(xpath = "//span[text()='PM Type']/..//following-sibling::td[@class='dataCol col02 inlineEditLock']")
	private WebElement pmplan_pmtype;

	@FindBy(xpath = "//td[text()='Account']/..//td[@class='dataCol inlineEditWrite']/div/a")
	private WebElement pmplan_account;

	@FindBy(xpath = "//span[text()='Date Installed' and @class='helpButton']/../following-sibling::td")
	private WebElement ip_dateinstalled;

	@FindBy(xpath = "//th[text()='Warranty ID']/parent::tr/following-sibling::tr/th/a")
	private WebElement ip_getproductwarranty;

	@FindBy(xpath = "//span[text()='PM Plan Template']/../..//following-sibling::td/div/a")
	private WebElement pmtempalte_warranty;

	@FindBy(xpath = "//span[text()='Product']/../..//following-sibling::td/div/a")
	private WebElement ip_product;

	@FindBy(xpath = "//*[@class = 'linklet']/span[text() = 'PM Applicable Products']")
	private WebElement ip_pmapplicabprod;

	@FindBy(xpath = "//span[text()='PM Plan Template']/../..//following-sibling::td//a")
	private WebElement warranty_pmplantempl;

	@FindBy(xpath = "//input[@title= 'New PM Applicable Product']")
	private WebElement new_pmapplproduct;

	@FindBy(xpath = "//a[@title='PM Plan Template Lookup (New Window)']")
	private WebElement pmapplicable_lookup;

	@FindBy(xpath = "(//a[contains(text(),'TT-0000')])[1]")
	private WebElement tasktemplate;

	@FindBy(xpath = "//*[text()='PM Type']/../following-sibling::tr//a[not(contains(text(),'TT'))]")
	private List<WebElement> pmschedule_record;

	//*[text()='Record Number']/../following-sibling::tr//a[not(contains(text(),'TT'))]

	@FindBy(xpath = "//*[text()='Sequence']/../following-sibling::tr//a[not(contains(text(),'TT'))]")
	private List<WebElement> pmschedule_template;

	@FindBy(xpath = "//span[text()='Execution Type']/../following-sibling::td")
	private WebElement tt_executiontype;

	@FindBy(xpath = "//th[text()='PM Coverage Number']/..//following-sibling::tr/th")
	private WebElement pm_coveragenumber;

	@FindBy(xpath = "(//span[text()='Start Date']/..//following-sibling::td)[1]")
	private WebElement warranty_startdate;

	@FindBy(xpath = "//td[text()='Account']/..//td/a")
	private WebElement pm_accountlink;

	@FindBy(xpath = "//span[text()='Contact']/../following-sibling::td")
	private WebElement pmplan_contact;

	@FindBy(xpath = "//a[@title='Contact Lookup (New Window)']")
	private WebElement contact_lookup;

	@FindBy(xpath = "//th[text()='Work Order Number']/../following-sibling::tr/th/a")
	private WebElement select_firstrecord;



	@FindBy(xpath = "//h3[text()='Preventative Maintenance Information']")
	private WebElement prevetiveinformation;

	@FindBy(xpath = "//span[text()='Due Date']/../following-sibling::td")
	private WebElement pi_duedate;

	@FindBy(xpath = "//*[text()='Due Date']/../following-sibling::td/div")
	private WebElement pi_duedate_input;

	@FindBy(xpath = "//span[text()='Earliest Proposed Date']/../following-sibling::td")
	private WebElement pi_earliestproposeddate;

	@FindBy(xpath = "//span[text()='Latest Proposed Date']/../following-sibling::td")
	private WebElement pi_latestproposeddate;

	@FindBy(xpath = "//span[text()='Change Reason']/../following-sibling::td")
	private WebElement changereason;

	@FindBy(xpath = "//div[@class='inlineEditCompoundDiv']/textarea")
	private WebElement changereason_textarea;


	@FindBy(xpath = "//td[text()='Execution Type']/following-sibling::td")
	private WebElement pmschedu_executiontype;

	@FindBy(xpath = "//th[text()='Record Number']/../following-sibling::tr/th/a")
	private WebElement pmschedule_def_record;

	@FindBy(xpath = "//*[text()='PM Plan Template']/../preceding-sibling::td//div")
	private WebElement pmschedu_pmtype;

	@FindBy(xpath = "//div[@class='pbError']")
	private WebElement date_error;

	@FindBy(xpath = "(//*[@title = 'Cancel'])[1]")
	private WebElement Cancel;

	@FindBy(xpath = "//iframe[@title='Preventive_Maintenance_Plan_Wizard']")
	private WebElement preventive_maintenance_flow_frame;

	@FindBy(xpath = "//input[@title=' Create PM Proposal']")
	private WebElement create_PMproposal;

	@FindBy(xpath = "//input[@title=' Activate PM Plan']")
	private WebElement activate_PMplan;

	@FindBy(xpath = "//td[@class='svmx-form-item-body ']/textarea")
	private WebElement activate_notes;

	@FindBy(xpath = "//button[@data-qtip='Activate PM Plan']")
	private WebElement activate_save;

	@FindBy(xpath = "//td[text()='Status']/following-sibling::td")
	private WebElement pmplan_status;

	@FindBy(xpath = "//label[text()='Partner Account:']/..//following-sibling::td//td/input")
	private WebElement pmproposal_partneraccount;

	//    @FindBy(xpath = "//button[@id='svmx-button-1038-btnEl']")
	//	private WebElement partner_Acc_dialog;
	//    
	@FindBy(xpath = "//label[text()='WO Schedule Status:']/..//following-sibling::td//td/input")
	private WebElement pmproposal_woschedstatus;

	@FindBy(xpath = "(//div[@class='svmx-grid-row-checker'])[3]")
	private WebElement pmproposal_listvalue;

	@FindBy(xpath = "//*[text()='Unscheduled']/../preceding-sibling::td/div")
	private WebElement woScheduleStatus_unscheduled;

	@FindBy(xpath = "//*[text()='Tentative']/../preceding-sibling::td/div")
	private WebElement woScheduleStatus_tentative;

	@FindBy(xpath = "//button[@data-qtip='Submit']")
	private WebElement pmproposal_submit;

	//    
	@FindBy(xpath = "//input[@title='Go!']")
	private WebElement lookup_gobtn;

	@FindBy(xpath = "//frame[@id='resultsFrame']")
	private WebElement lookup_resultFrame;

	@FindBy(xpath="//th[text()='PM Plan Template Name']/../following-sibling::tr//th/a")
	private WebElement template_link;

	@FindBy(xpath = "//iframe[@title='PM_Plan_Template_Wizard']")
	private WebElement manageprevent_maintenanctemplateframe;

	@FindBy(xpath = "//input[@title=' Manage Preventive Maintenance Plan Template']")
	private WebElement select_managePMtemplate;

	@FindBy(xpath = "//label[text()='PM Frequency:']/..//following-sibling::td//input")
	private WebElement edit_pmfrequency;

	@FindBy(xpath = "//label[text()='Grace Period (in Days):']/..//following-sibling::td//input")
	private WebElement edit_graceperiod;

	@FindBy(xpath = "//button[@data-qtip='Cancel']")
	private WebElement editpm_Cancel;

	@FindBy(xpath="//span[text()='Order Status']/parent::td/following-sibling::td/div//select")
	private WebElement select_status;

	@FindBy(xpath="//td[@id='topButtonRow']//input[@title='Save']")
	private WebElement btn_saveCA;

	public static String productwarranty;
	public static String warrantystartdate;
	public static String PMplantemplate;
	public static String PMScheduleduedate;
	public static String PMScheduleearliestdate;
	public static String PMSchedulelatestdate;
	public static String pmPlanName;
	public static String productModality;
	public static String freezeAutoPMCreation;
	Map<String, String> getUrlDetails = new HashMap<>();


	public void verifyipstatus() {

		verifyElementPresent("IP Status", txt_status);
		String ipstatus = txt_status.getText();
		if(ipstatus.contains("OPER")) {

			String expecteddate = currentDateValue("d/M/yyyy");
			verifyTextContains(ip_dateinstalled, expecteddate);
			logReport("PASS", "IP values for status and date installed are correct");
		}


	}

	public void selectwarranty_template() throws Exception {
		ipurl = driver.getCurrentUrl();
		hover(ProductWarranty);
		productwarranty = ip_getproductwarranty.getText();
		System.out.println(productwarranty);
		clickEvent(ip_getproductwarranty);
		waitTill("5");
		scrollByViewOfElement(warranty_pmplantempl);
		PMplantemplate = warranty_pmplantempl.getText();
		click("CLick PM Plan Template", warranty_pmplantempl);
	}


	public void getUrldetails() throws Exception {

		waitTill("6");
		sfmcurl = driver.getCurrentUrl();
		getUrlDetails.put("SavedUrl",sfmcurl);
		getUrlDetails.put("Warranty",productwarranty);
		logReport("INFO", sfmcurl);
		logReport("INFO", productwarranty);
		Excel.writeAgreementData(AutomationConstants.orderData,getUrlDetails,"438541");
		logReport("INFO", "PM Plan URL details are saved");
	}

	public void verifytasktemplate() {

		waitTill("5");
		scrollByViewOfElement(tasktemplate);
		click("Click First Task Template", tasktemplate);
		waitDottedSpinnerToDisappear();
		verifyElementPresent("Execution Type", tt_executiontype);
		String executiontype = tt_executiontype.getText();
		assertEquals(executiontype, "Onsite Service");
		logReport("PASS", "The Execution type of task template is "+executiontype+" as expected");  		

	}

	public void navigatetoipurl() {
		waitTill("15");
		driver.get(ipurl);
		waitTill("4");
	}

	public void selectproduct() {

		waitTill("4");
		String ipproduct = ip_product.getText();
		clickEvent(ip_product);
		hover(ip_pmapplicabprod);
		clickEvent(ip_pmapplicabprod);
		waitUntilElementisDisplayed(new_pmapplproduct);
		click("Click New PM Applicable Product", new_pmapplproduct);
	}

	public void createNewapplicableproduct() {

		waitForElement(pmapplicable_lookup, "New PM applicable Lookup");
		click("Click PM Plan template Lookup", pmapplicable_lookup);
		switchToTab();
		waitAndswitchToRequiredFrame(lookup_searchframe);
		click("Search filed", lookup_search);
		enter("PM template search", lookup_search, PMplantemplate);
		click("Go button", lookup_gobtn);
		driver.switchTo().defaultContent();
		waitTill("5");
		waitAndswitchToRequiredFrame(lookup_resultFrame);
		waitTill("5");
		waitForElement(template_link, "Select Template");
		click("Select Template link", template_link);
		switchToTab();
		waitForElement(Save, "Save the PM Applicable Product");
		click("Save the PM Applicable Product", Save);

	}

	public void navigatetoproductwarranty(String sheetName) {
		excelval=Excel.getSheetData(AutomationConstants.orderData,sheetName);
		productwarranty=excelval.get(0).get("Warranty");
		waitTill("5");
		waitForElement(globalSearchBox, productwarranty);
		waitTill("5");
		enter("search", globalSearchBox, productwarranty);
		waitTill("5");
		click("globalSearchButton", globalSearchButton);
		waitTill("5");
		waitForElement(searchResult, "search Result");
		driver.findElement(By.xpath(".//*[@id='SVMXC__Warranty__c_body']//a[text()='" + productwarranty + "']"))
		.click();
	}

	public void verifyandopenpmplan() {
		waitTill("5");
		waitForElement(warranty_startdate, "Warranty Start Date");
		warrantystartdate = warranty_startdate.getText();
		sfmcurl = driver.getCurrentUrl();
		scrollByViewOfElement(warranty_pmplantempl);
		PMplantemplate = warranty_pmplantempl.getText();
		scrollByViewOfElement(preventive_maintenance);
		waitForElement(pm_planname, "PM Plan Name");
		if (pm_planname.isDisplayed()) {
			pmPlanName = pm_planname.getText();
			System.out.println(pmPlanName);
		}

		clickEvent(pm_planname);
	}

	public void verifypmplanfields() {
		verifyElementPresent("PM Plan start Date", pmplan_startdate);
		verifyElementPresent("PM Plan End Date", pmplan_enddate);
		verifyElementPresent("PM Plan Template", pmplan_templatename);
		verifyElementPresent("PM Plan PMType", pmplan_pmtype);
		verifyElementPresent("PM Plan End Date", pmplan_enddate);

		sfmcurl = driver.getCurrentUrl();
	}

	public void navigatetoaccount() {

		waitForElement(pmplan_account, "Click Account link");
		PMaccountname = pmplan_account.getText();
		System.out.println("The PM account name is : "+PMaccountname+"");
		click("Click Account link", pmplan_account);
		waitDottedSpinnerToDisappear();
	}

	public void selectcontactinpmplan() {

		waitForElement(pmplan_contact, "Select Contact from PM Plan");
		doubleClick("Select Contact from PM Plan", pmplan_contact);
		clickEvent(contact_lookup);
		switchToTab();
		waitAndswitchToRequiredFrame(lookup_searchframe);
		click("Search filed", lookup_search);
		enter("Contact search", lookup_search, "Automation Test");
		click("Go button", lookup_gobtn);
		driver.switchTo().defaultContent();
		waitTill("5");
		waitAndswitchToRequiredFrame(lookup_resultFrame);
		waitTill("5");
		WebElement contact_link = driver.findElement(By.xpath("//a[text()='Name']/../../following-sibling::tr//th/a"));
		waitForElement(contact_link, "Select Contact");
		click("Select contact link", contact_link);
		switchToTab();
		waitForElement(Save, "Save the contact");
		click("Save the contact", Save);
	}


	public void verifyscheduleandmiantenance(){

		verifyElementPresent("PM Schedule Definition values present", tasktemplate);
		verifyElementPresent("Preventive Maintenance Coverages value present", pm_coveragenumber);

	}

	public void verifypmschedule() {

		if(verifyElementPresent("PM Schedule Record", pmschedule_record.get(1))) {

			logReport("PASS", "PM Schedule and its record section is displaying");
		}
	}

	public void opentemplateingloablsearc() {

		waitTill("5");
		waitForElement(globalSearchBox, PMplantemplate);
		waitTill("5");
		enter("search", globalSearchBox, PMplantemplate);
		waitTill("5");
		click("globalSearchButton", globalSearchButton);
		waitTill("15");
		waitForElement(searchResult, "search Result");
		driver.findElement(By.xpath("//a[text()='" + PMplantemplate + "']"))
		.click();
		waitTill("10");
	}

	public void managePMTemplatewizard() {
		waitForElement(manageprevent_maintenanctemplateframe, "Manage Preventive Maintenance Template Frame");
		driver.switchTo().frame(manageprevent_maintenanctemplateframe);
		click("Manage PM Template", select_managePMtemplate);

		waitLoadingSpinnerToDisappear();

	}

	public void verifypmfreqandgraceperiod() {

		waitForElement(edit_pmfrequency, "Edit PM Frequency");
		click("Edit PM Frequency", edit_pmfrequency);
		enter("PM Frequency", edit_pmfrequency, "1 visit / 18 months");
		pressEnter();
		//WebElement slectfrequency = driver.findElement(By.xpath("//li[text()='1 visit / 18 months']"));
		//click("Select PM Frequency", slectfrequency);
		click("Edit PM Grace Period", edit_graceperiod);
		enter("Grace Period", edit_graceperiod, "30");
		pressEnter();

		//WebElement slectgraceperiod = driver.findElement(By.xpath("//li[text()='30"));
		if (edit_graceperiod.getText().equals("30")) {

			logReport("PASS", "The PM Frequency and corresponding Grace period is matching");
		}
		click("Cancel", editpm_Cancel);

	}
	//    
	//
	//    @FindBy(xpath="//span[text()='Account']/../..//a")
	//    private WebElement accountlink;
	//    
	//
	//    
	//    public void clickonAccount(){
	//    	scrollByCordinates(0, 1000);
	//    	waitForElement(accountlink, "Account link");
	//    	click("Account link", accountlink);
	//    }
	public void navigatetourl() {
		waitTill("15");
		sfmcurl = "https://philipsb2bsc--emsmq3.my.salesforce.com/a2j2i000000b3Xj";
		driver.get(sfmcurl);
		waitTill("10");
	}

	public void selectfirstschedulerecord() {


		//		waitForElement(pmschedule_template.get(0), "Select First record of PM Template");
		//		click("Select First record PM template", pmschedule_template.get(0));
		//		waitSpinnerToDisappear();
		//		waitTill("5");

		waitForElement(pmschedule_record.get(1), "Select First record");
		click("Select First record", pmschedule_record.get(1));
		waitSpinnerToDisappear();
		waitTill("5");

	}


	public void selectfirstworecord() {

		waitForElement(select_firstrecord, "Select First WO record");
		click("Select First WO record", select_firstrecord);
		waitSpinnerToDisappear();
		clickEvent(detailstab);
		waitTill("5");

	}

	public void verifypivaluesinpmplan() {
		waitTill("5");
		if(verifyElementPresent("PM Information", prevetiveinformation)) {
			scrollByViewOfElement(prevetiveinformation);
		}
		verifyElementPresent("Due Date", pi_duedate);
		String duedate = currentDateValue("MM/DD/yyyy");
		verifyTextContains(pi_duedate, duedate);
		verifyElementPresent("Earliest Proposed Date", pi_earliestproposeddate);
		String earlyproposal = endDatevalue("MMM dd, yyyy", -10, 0, 0);
		verifyTextContains(pi_earliestproposeddate, earlyproposal);
		verifyElementPresent("Latest Proposal Date", pi_latestproposeddate);
		String laterproposal = endDatevalue("MMM dd, yyyy", 10, 0, 0);
		verifyTextContains(pi_latestproposeddate, laterproposal);
	}


	public void updateduedatepast() {
		doubleClick("Click Due date", pi_duedate);
		String dueDate = endDatevalue("MM/dd/yyyy", 0, -1, 0);
		//    	click("Click Due date", pi_duedate);
		//clear("Clear Due date", pi_duedate_input);
		doubleClick(pi_duedate_input);
		System.out.println(dueDate);

		waitTill("5");
		enter("Click Due date", driver.findElement(By.xpath("//*[@class='inlineEditDiv']/input")), dueDate);
		//waitTill("5");

		pressEnter();
		//doubleClick("Click Change Reason", changereason);
		//enter("Enter Reason", changereason_textarea, "Automation");
		//click("Click OK", okButton);
		waitForElement(Save, "Save the due date values");
		click("Save the due date values", Save);
	}

	public void verifyupdateddatevalues() {
		PMScheduleduedate = pi_duedate.getText();
		PMScheduleearliestdate=pi_earliestproposeddate.getText();
		PMSchedulelatestdate=pi_latestproposeddate.getText();
		driver.navigate().back();
	}

	public void selectPMScheduleDefrecord() {
		scrollByViewOfElement(pmschedule_def_record);
		waitForElement(pmschedule_def_record, "Select Record from Schedule Definition");
		click("Select Record from Schedule Definition", pmschedule_def_record);
		waitSpinnerToDisappear();

	}

	public void verifyPMScheduleDefValues() {

		verifyTextContains(pi_duedate, PMScheduleduedate);
		verifyTextContains(pi_earliestproposeddate, PMScheduleearliestdate);
		verifyTextContains(pi_latestproposeddate, PMSchedulelatestdate);
		verifyTextContains(pmschedu_executiontype, "Onsite Service");
		verifyTextContains(pmschedu_pmtype, "BG Required PM");
		logReport("PASS", "The values updated in PM schedule updated in PM schedule definition");
		driver.navigate().back();
		waitSpinnerToDisappear();
	}

	public void updateduedatefuture() {
		doubleClick("Click Due date", pi_duedate);
		String dueDate = endDatevalue("MMM dd, yyyy", 0, 1, 1);
		//clear("Clear Due date", pi_duedate_input);
		doubleClick(pi_duedate_input);
		System.out.println(dueDate);
		waitTill("5");
		enter("Click Due date", driver.findElement(By.xpath("//*[@class='inlineEditDiv']/input")), dueDate);
		pressEnter();
		//		doubleClick("Click Change Reason", changereason);
		//		enter("Enter Reason", changereason_textarea, "Automation Future Due date");
		//		click("Click OK", okButton);
		waitForElement(Save, "Save the due date values");
		click("Save the due date values", Save);
	}

	public void verifyvalidationforfuturedate() {

		waitForElement(date_error, "Error on saving Due date with Future");
		String duedateerror = date_error.getText();
		verifyMessageContains(duedateerror, "Due Date for BG Required PMs cannot be greater");
		click("Cancel the changes", Cancel);
		driver.navigate().back();
	}

	public void verifypmstatus() {
		driver.navigate().refresh();
		waitForElement(pmplan_status, "PM Plan Status");
		verifyTextContains(pmplan_status, "");
		verifyElementPresent("PM Schedule Definition values present", tasktemplate);
		verifyElementPresent("Preventive Maintenance Coverages value present", pm_coveragenumber);
	}

	public void clickCreatePMProposal() {


		waitForElement(preventive_maintenance_flow_frame, "Preventive Maintenance Frame");
		driver.navigate().refresh();
		waitTill("5");
		driver.switchTo().frame(preventive_maintenance_flow_frame);
		waitTill("5");
		clickEvent(create_PMproposal);
		waitLoadingSpinnerToDisappear();
	}

	public void enter_detailspmproposal() {
		waitTill("5");
		waitForElement(pmproposal_partneraccount, "Enter Partner Account");
		//click("Enter Partner Account", pmproposal_partneraccount);
		String partnerAccount = "HOSPITAL CLINICO - LA MALVARROSA";
		enter("Enter Partner Account", pmproposal_partneraccount, partnerAccount);//PMaccountname
		click("Partner Account search Id", partnerAccount_SearchBtn);
		waitLoadingSpinnerToDisappear();

		waitTill("6");
		driver.findElement(By.xpath("//div[text()='" + partnerAccount + "']")).click();
		waitTill("5");
		click("select_Contact_id_fullname", select_Contact_id_fullname);
		waitTill("5");

		click("Enter WO Scheduled status", pmproposal_woschedstatus);
		click("WO Schedule Status-Unscheduled", woScheduleStatus_unscheduled);
		click("WO Schedule Status-Tentative", woScheduleStatus_tentative);
		//Jsclick("PM WO Scheduled status value", pmproposal_listvalue);
		click("PM Proposal Submit", pmproposal_submit);
		waitTill("5");
	}

	public void activatePMPlan() {
		waitForElement(preventive_maintenance_flow_frame, "Preventive Maintenance Frame");
		driver.navigate().refresh();
		waitTill("5");
		driver.switchTo().frame(preventive_maintenance_flow_frame);
		waitTill("5");
		clickEvent(activate_PMplan);
		waitLoadingSpinnerToDisappear();
		waitForElement(activate_notes, "Activation Notes");
		click("Activation Notes", activate_notes);
		click("Select Activate Plan", activate_save);
	}

	public void verifyactivestatus() {
		waitTill("5");
		waitForElement(pmplan_status, "PM Plan Status");
		if(pmplan_status.equals("Active")) {
			Assert.assertEquals(pmplan_status, "Active");
		}
	}


	public void updateFilterDetails(String arg1)
	 {

		 driver.get("https://philipsb2bsc--emsmq3.my.salesforce.com/a9D/o");
		waitTill("2");
		switch (arg1) {
		case "Auto IP1": {
			waitForElementToEnable(firstFilterSeleciton);
			selectbyValue(firstFilterSeleciton, arg1, arg1);
			click("edit Link", FilterEditLink);
			enter("IP Staging Name", IPStageNameChange, LeanFTPage.equipmentNumbers.get("Equipment1"));
			// enter("IP Staging Name",IPStageNameChange, "88796559");
			embedScreenShotInreport();
			click("Save Button", Save);
			break;
		}

		case "Auto IP2 and IP3": 
		{
			driver.get("https://philipsb2bsc--emsmq3.my.salesforce.com/a9D/o");
			waitTill("3");
			selectbyValue(FilterSelect, arg1, arg1);
			click("edit Link", FilterEditLink);
			enter("IP Staging Name", TopLevelChange, LeanFTPage.equipmentNumbers.get("Equipment1"));
			embedScreenShotInreport();
			click("Save Button", Save);
			break;
		}
		case "Auto IP4 and IP5": {
			selectbyValue(FilterSelect, arg1, arg1);
			click("edit Link", FilterEditLink);
			enter("IP Staging Name", TopLevelChange, LeanFTPage.equipmentNumbers.get("Equipment1"));
			embedScreenShotInreport();
			click("Save Button", Save);
			break;
		}
		case "Auto IP6 and IP7": {
			selectbyValue(FilterSelect, arg1, arg1);
			click("edit Link", FilterEditLink);
			enter("IP Staging Name", TopLevelChange, LeanFTPage.equipmentNumbers.get("Equipment1"));
			embedScreenShotInreport();
			click("Save Button", Save);
			break;
		}
		}
	}

	public void updateFunctionalLocation(String FLName) throws Exception {

		FLURL = "https://philipsb2bsc--emsmq3.my.salesforce.com/" + SOQLQuerys.getFunctionalLocID(FLName);
		//FLURL = "https://philipsb2bsc--emsmq3.my.salesforce.com/a0h2i00000270vj";
		waitTill("15");
		driver.get(FLURL);
		waitTill("10");
		click("Edit Button", editButton);
		String temp = FLName + currentDateValue("dd-MM-yyyy");
		UpdatedFL = temp.replaceAll("-", "");
		System.out.println(UpdatedFL);
		enter("FL Name", edit_FLName, UpdatedFL);
		enter("FL SAP EXT", edit_FLSAP_Ext, UpdatedFL);
		embedScreenShotInreport();
		click("Save", Save);
		waitTill("10");
	}

	public void revokeFunctionalLocation(String FLName) throws Exception {
		waitTill("15");
		driver.get(FLURL);
		waitTill("10");
		click("Edit Button", editButton);
		enter("FL Name", edit_FLName, FLName);
		enter("FL SAP EXT", edit_FLSAP_Ext, FLName);
		BaseLib.embedScreenShotInreportWithRobot();
		click("Save", Save);
		waitTill("5");
	}

	public void forceUpdate(String arg1) {
		WebElement fu = driver.findElement(
				By.xpath("//span[text()='" + equipmentNumbers.get(arg1) + "']/../../../..//img[@class='checkImg']"));
		// WebElement fu =
		// driver.findElement(By.xpath("//span[text()='88796559']/../../../..//img[@class='checkImg']"));
		doubleClick("ForceUpdate Checkbox", fu);
		click("FU Checkbox", FourceUpdateCheckbox);
		click("Save Button", saveButton1);
		
		waitTill("5");
		WebElement fun = driver.findElement(
				By.xpath("//span[text()='" + equipmentNumbers.get(arg1) + "']/../../../..//input[@class='checkbox']"));
		click("Checkbox", fun);
		//span[text()='400005929'
		embedScreenShotInreport();
	}

	public void processIPs() {
		//click("allCheckbox", allCheckbox);
		click("Process IP", ProcessIPButton);
		waitTill("5");
	}

	public void VerifyProcessesedIP(String arg1) throws Exception
	 {
		HashMap<String, String> ipdetails = SOQLQuerys.getIPDetails(equipmentNumbers.get(arg1));
		if (ipdetails.get("Status").equals("Success")) {
			switch (arg1) {
			case "Equipment1": {
				if (ipdetails.get("Type").equals("0")) {
					logReport("PASS", "Equipment Details are updated in SMAX");
				} else {
					Assert.fail();
				}
				break;
			}
			case "Equipment2": {
				if (ipdetails.get("Type").equals("1")) {
					logReport("PASS", "Equipment Details are updated in SMAX");
				} else {
					Assert.fail();
				}
				break;
			}
			case "Equipment3": {
				if (ipdetails.get("Type").equals("1")) {
					logReport("PASS", "Equipment Details are updated in SMAX");
				} else {
					Assert.fail();
				}
				break;
			}
			case "Equipment4": {
				if (ipdetails.get("Type").equals("1")) {
					logReport("PASS", "Equipment Details are updated in SMAX");
				} else {
					Assert.fail();
				}
				break;
			}
			case "Equipment5": {
				if (ipdetails.get("Type").equals("1")) {
					logReport("PASS", "Equipment Details are updated in SMAX");
				} else {
					Assert.fail();
				}
				break;
			}
			case "Equipment6": {
				if (ipdetails.get("Type").equals("3")) {
					logReport("PASS", "Equipment Details are updated in SMAX");
				} else {
					Assert.fail();
				}
				break;
			}
			case "Equipment7": {
				if (ipdetails.get("Type").equals("3")) {
					logReport("PASS", "Equipment Details are updated in SMAX");
				} else {
					Assert.fail();
				}
				break;
			}
			}
		}
		embedScreenShotInreport();
	}

	public void verify_WOStatus(){
		waitForElement(txt_status, "Status");
		if(txt_status.getText().equalsIgnoreCase("Ready to Fix")){
			logReport("PASS", "The work order status is verified "+txt_status.getText());
		}else{
			logReport("INFO", "The work order status is not verified "+txt_status.getText());
		}
		embedScreenShotInreport();
	}

	public void updaeWO(){
		
		if(verifyElementPresent("Case Details", case_Details))
		{
			click("case_Details", case_Details);
		}
		waitForElement(order_status, "order_status");
		//hover(txt_status);
		doubleClick(order_status);
		waitForElement(select_status, "status dropdown");
		selectbyValue(select_status, "Fixed", "Fixed");
		embedScreenShotInreport();
		click("Save", btn_saveCA);
		waitTill("5");
		waitForElement(order_status, "Status");
		scrollByViewOfElement(order_status);
		embedScreenShotInreport();
		if(order_status.getText().equalsIgnoreCase("Fixed")){
			logReport("PASS", "The work order status is verified "+order_status.getText());
		}else{
			logReport("INFO", "The work order status is not verified "+order_status.getText());
		}

	}

	public void verifyCostcenterPopulated() {
		driver.switchTo().defaultContent();
		waitForElement( verify_CostCenter,"Cost Center");
		//verifyBooleanStatus(verify_CostCenter.getText(), "ES90.17ISR");
		verifyMessageContains(verify_CostCenter.getText(), "ES90.17ISR");
	}

	public void verifySFMFields() {
		click("case_Details", case_Details);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(manage_WorkOrder_Frame);
		String values[] = {"Request a Quote","Create Remote Service Work Order","Create Onsite Work Order","Create Subcontractor Work Order","Create Material Only Work Order","Create Work Order(Remote Clinical)","Create Work Order(Onsite Clinical)","Create Local Bench Work Order"};
		for(int i=0;i<values.length;i++) {
			try {
				WebElement elements= driver.findElement((By.xpath("//input[contains(@value,'"+values[i]+"') and not(@disabled)]")));
				verifyElementTobePresent(values[i], elements);
			}catch (Exception e) {
				logReport("Fail", values[i]);
				Assert.fail();
			}
		}
		embedScreenShotInreport();
		driver.switchTo().defaultContent();
	}

	public void verifyEntitleMentBillType() {
		driver.switchTo().defaultContent();
		waitForElement(checkbox_entitlement,"is Entitlement Performed");
		verifyElementTobePresent("is Entitlement Performed", checkbox_entitlement);
		waitForElement(bill_type, "Bill Type");
		verifyBooleanStatus(bill_type.getText(), " ");
	}

	public void verifyWarranty() 
	{
		waitTill("5");
		driver.switchTo().defaultContent();
		driver.switchTo().frame(manage_WorkOrder_Frame);
		click("View Entitlement", view_entitlement);
		driver.switchTo().defaultContent();
		waitForElement(input_warranty, "Warranty");
		verifyBooleanStatus(input_warranty.getAttribute("value"), "");
		waitForElement(input_servicemaintenancecontract, "Service Maintenance Contract");
		verifyBooleanStatus(input_servicemaintenancecontract.getAttribute("value"), "");
		embedScreenShotInreport();
		click("Cancel", cancelButton_dataqtip);
		click("Proceed", proceedButton);
	} 
	public void createCase(String eventType, String eventSubType) {
		waitTill("5");
		waitForElement(installedProduct_Page, "installedProduct_Page");
		waitForElement(IP_Frame, "IP_Frame");
		try {
			driver.switchTo().frame(IP_Frame);
		}catch(Exception e) {
			try {
				driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Account_Wizard']")));
			}catch(Exception e1) {
				driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='ESMX_Installed_Product_Wizard_Lite']")));
			}
		}
		click("create_Case", create_Case_SFM);
		waitForElement(creat_Case_dialog, "creat_Case_dialog");
		waitTill("5");
		//enter("contactID_Searchinput", contactID_Searchinput, BaseLib.TEST_DATA.get(0).get(con));
		//click("Contact search Id",contactID_SearchBtn);
		driver.findElement(By.xpath("//*[text()='Contact ID:']/parent::td/following-sibling::td//*[@role='button']")).click();
		waitLoadingSpinnerToDisappear();
		waitTill("5");
		waitForElement(contact_ID_fullname, "contact_ID_fullname");
		//click("contact_ID_fullname",contact_ID_fullname);
		driver.findElement(By.xpath("//span[text()='Full Name']/../../../../../following-sibling::div//tr/td/div")).click();
		click("select_Contact_id_fullname",select_Contact_id_fullname);
		click("eventType_dropdown",eventType_dropdown);
		waitTill("5");
		if(Hooks.testcaseNumber=="738148") {
			if(BaseLib.TEST_DATA.get(0).get(eventType).equalsIgnoreCase("Incident")) {
				driver.findElement(By.xpath("//li[text()='"+BaseLib.TEST_DATA.get(0).get(eventType)+"']")).click();
			}
		}else {
			driver.findElement(By.xpath("//li[text()='"+eventType+"']")).click();
		}
		waitTill("5");
		try {
			click("eventSubType_dropdown",eventSubType_dropdown);
			driver.findElement(By.xpath("//li[text()='"+eventSubType+"']")).click();

		}catch(Exception e) {}
		/*}else {
			driver.findElement(By.xpath("//li[text()='"+BaseLib.TEST_DATA.get(0).get(eventType)+"']")).click();
			click("eventSubType_dropdown",eventSubType_dropdown);
			String evn = BaseLib.TEST_DATA.get(0).get(eventSubType);
			waitTill("5");
			List<WebElement> els = driver.findElements(By.xpath("//li[text()='"+evn+"']"));
			for(WebElement el : els) {
				try {
					el.click();
				}catch(Exception e1 ) {}
			}
			//driver.findElement(By.xpath("//li[text()='"+BaseLib.TEST_DATA.get(0).get(eventSubType)+"']")).click();
			//	driver.findElement(By.xpath("//li[text()='"+eventSubType+"']")).click();
		}*/
		//	click("incident",incident);
		waitTill("5");
		click("priority_Dropdown",priority_Dropdown);
		waitTill("5");
		click("priority_Value",priority_Value);
		waitTill("5");
		enter("Subject",subject,"Test");
		waitTill("5");
		enter("description",desc,"Test Data");
		waitTill("5");
		if(Hooks.testcaseNumber.equals("438550")) {
			enter("Sales Org", input_salesorg, "ES93");
			driver.findElement(By.xpath("//li[text()='ES93']")).click();
			waitTill("5");
		}
		new BasePage(driver).embedScreenShotInreport();
		click("save_case",save_case);
		waitLoadingSpinnerToDisappear();
		waitForElement(case_Number, "case_Number");
		waitTill("5");
		logReport("INFO", "Case Created, Case Number: ********** "+case_Number.getText()+" **********");

		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("CASE_NUMBER", case_Number.getText());
		//Souvk
		AutomationConstants.RUN_TIME_TEMP_DATA.put("CASE_NUMBER", case_Number.getText());
		new BasePage(driver).embedScreenShotInreport();
	}
	public void StoreValue(String Type, String IPNumber) {
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put(Type, IPNumber);
	}
	public void getValuesof(List<String> getValueof) {
		for (String Value : getValueof) {
			switch (Value) {
			case "Service Contract":
				AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("SERVICE_CONTRACT",
						ServiceContractNumber.getText());
				break;
			case "Risk Sharing Model":
				click("Service Contract", ServiceContractNumber);
				waitTill("5");
				click("Contract Header", ContractHeaderNumber);
				waitTill("5");
				AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("RSM_NUMBER", RSMNumber.getText());
				break;
			}
		}
	}
	public void ManageRiskSharingModel() {
		SwitchtoFramesByID("0660L000001Tgom");
		waitTill("5");
		click("Manage Risk Sharing Model", ManageRSM);
		waitTill("5");
		driver.switchTo().defaultContent();
		enter("Threshold Quantity", TQty, "10");
		clickEvent(save_case);
		waitTill("5");
	}
	
	@FindBy(xpath="//a[@class='calToday']")
	private WebElement todayDate_lnk;
	
	@FindBy(xpath = "//span[text()='Date Installed' and @class='helpButton']")
	private WebElement ip_dateinstalled_lbl;
	
	@FindBy(xpath = "//span[text()='Freeze Auto PM Creation' and @class='helpButton']/../following-sibling::td")
	private WebElement freezeAutoPM;
	
	@FindBy(xpath = "//span[text()='Freeze Auto PM Creation' and @class='helpButton']/../following-sibling::td/div/input")
	private WebElement freezeAutoPM_chkbx;
	
	@FindBy(xpath = "(//span[text()='Product Modality']/..//following-sibling::td/div)[1]")
	private WebElement warranty_productModality;
	
	@FindBy(xpath = "//span[text()='Freeze Auto PM Creation' and @class='helpButton']/../following-sibling::td/div/img")
	private WebElement warranty_freezeAutoPM;
	
	@FindBy(xpath = "//input[@title= 'New Applicable Product']")
	private WebElement new_applproduct;
	
	@FindBy(xpath = "//*[text()= 'Product']/../../following-sibling::td//span/input")
	private WebElement product_field;
	
	public void enter_details_in_IP_detail_page(){
		waitTill("5");
		hover(txt_status);
		waitForElement(txt_status, "Edit status");
		doubleClick("Edit status", txt_status);
		selectbyValue(dropdown_Status, "OPER - Operational", "Operational");
		waitTill("5");
		hover(ip_dateinstalled);
		waitForElement(ip_dateinstalled, "Edit Date Installed");
		doubleClick("Edit Date Installed", ip_dateinstalled);
		click("Select today date", todayDate_lnk);
		click("ip_dateinstalled_lbl", ip_dateinstalled_lbl);
		embedScreenShotInreport();
		waitTill("5");
		scrollByViewOfElement(freezeAutoPM);
		hover(freezeAutoPM);
		waitForElement(freezeAutoPM, "Edit Freeze Auto PM Creation");
		doubleClick("Edit Freeze Auto PM Creation", freezeAutoPM);
		waitTill("2");
		selectCheckBoxe(freezeAutoPM_chkbx);
		embedScreenShotInreport();
		waitTill("5");	
		scrollByViewOfElement(saveTopButton);
		click("Save", saveTopButton);
		waitTill("5");
	}
	
	public void selectWarrantyAndVerifyDetails() throws Exception {
		ipurl = driver.getCurrentUrl();
		hover(ProductWarranty);
		waitTill("5");
		productwarranty = ip_getproductwarranty.getText();
		System.out.println(productwarranty);
		scrollByViewOfElement(ip_getproductwarranty);
		clickEvent(ip_getproductwarranty);
		waitTill("5");
		scrollByViewOfElement(warranty_pmplantempl);
		PMplantemplate = warranty_pmplantempl.getText();
		System.out.println("PMplantemplate: "+PMplantemplate);
		waitTill("5");
		productModality = warranty_productModality.getText();
		System.out.println("productModality: " +productModality);
		embedScreenShotInreport();
		waitTill("5");
		freezeAutoPMCreation = warranty_freezeAutoPM.getAttribute("title");
		System.out.println("freezeAutoPMCreation: "+freezeAutoPMCreation);
		embedScreenShotInreport();
		/*if (freezeAutoPMCreation.equalsIgnoreCase("Checked")){
			logReport("PASS", "Freeze Auto PM Creation is checked");
		} else {
			logReport("FAIL", "Freeze Auto PM Creation is not checked");
			Assert.fail();
		}*/
	}
	
	public void createNewapplicableproductinWarrantyterms(String productCode ) {

		waitForElement(new_applproduct, "New applicable product");
		click("Click New Applicable product", new_applproduct);
		waitTill("5");
		click("product_field", product_field);
		enter("Product", product_field, productCode);
		waitTill("3");
		embedScreenShotInreport();
		waitForElement(saveTopButton, "Save the Applicable Product");
		click("Save the Applicable Product", saveTopButton);
		waitTill("10");
	}

	public void selectrowIteminListview()
	{
		WebElement fu = driver.findElement(By.xpath("//td[1]//input[@class='checkbox']"));
		click("Checkbox", fu);

	}
}