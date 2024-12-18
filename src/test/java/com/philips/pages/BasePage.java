 package com.philips.pages;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.http.ParseException;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.philips.generic.AutomationConstants;
import com.philips.generic.CSVFileReader;
import com.philips.generic.Excel;
import com.philips.generic.SOQLQuerys;
import com.philips.generic.Utility;
import com.philips.generic.configs.EnvironmentFactory;
import com.philips.stepdefinitions.Hooks;

/**
 * @author M1049287
 *
 */
public class BasePage extends BaseLib {

	@FindBy(xpath = "//input[@value='New quote request']")
	public WebElement quote_Request;

	@FindBy(xpath = "//input[@value='New quote request']")
	public WebElement quote_Request_radio_btn;

	@FindBy(xpath = ".//input[@id='phSearchInput']")
	public WebElement globalSearchBox;

	@FindBy(xpath = ".//input[@id='phSearchButton']")
	public WebElement globalSearchButton;

	@FindBy(xpath = "//input[@value='Search']")
	public WebElement serachButton;

	@FindBy(xpath = "//div[contains(text(),'Success:')]")
	public WebElement successmessage;

	@FindBy(xpath = "//*[text()='Next']")
	public WebElement nextButton;

	@FindBy(xpath = "//span[contains(@class,'next-icon')]")
	public WebElement nextButton1;

	@FindBy(xpath = "//span[contains(text(),'Thank you')]")
	public WebElement confirmationmsgforcontact;

	@FindBy(xpath = "//span[text()='Account']/../..//a")
	public WebElement accountlink;

	@FindBy(xpath = "//span[text()='Location']/../..//a")
	public WebElement locationLink;

	@FindBy(xpath = "//button[text()='Submit']")
	public WebElement submitButton;

	@FindBy(xpath = "//button[contains(text(),'X')]")
	public WebElement crossicon;

	@FindBy(xpath = "//*[@type='button' and @title='Edit']")
	protected WebElement editButton;

	@FindBy(xpath = "//span[text()='Update']")
	public WebElement updateButton;

	@FindBy(xpath = "//*[@title='Cancel']")
	public WebElement cancelButton;

	@FindBy(xpath = "//button[text()='Cancel']")
	public WebElement cancelButton_Text;

	@FindBy(xpath = "//*[@data-qtip='Cancel']")
	public WebElement cancelButton_dataqtip;

	@FindBy(xpath = "//*[text()='Cancel']/parent::button[@data-qtip='Cancel']")
	public WebElement cancelButton_extended_edit;

	@FindBy(xpath = "//button[@title='Save']")
	protected WebElement saveButton;

	@FindBy(xpath = "//*[@value='Save']")
	public WebElement saveButton1;

	@FindBy(xpath = "//td[@id='topButtonRow']/input[@value=' Save ']")
	public WebElement saveButton2;

	@FindBy(xpath = "//span[text()='Save']/parent::button")
	public WebElement saveButton3;

	@FindBy(xpath = "//button[text()='Save']")
	public WebElement saveButton_Text;

	@FindBy(xpath = "//span[text()='Save']/parent::button")
	public WebElement saveTypeButton;

	@FindBy(xpath = "//span[text()='Next']/parent::button")
	public WebElement btn_nextType;

	@FindBy(xpath = "//*[@class='svmx-btn-icon svmx-sfmd-save-icon']")
	public WebElement recordTools_Save_button;

	@FindBy(xpath = "//button[@data-qtip='Save']")
	public WebElement save_Work_Order_Lines;

	@FindBy(xpath = "//a[text()='Logout']")
	protected WebElement LogoutLink;

	@FindBy(xpath = "//*[@title='Save']")
	public WebElement Save;

	@FindBy(xpath = ".//*[@id='sfm-button-1096-btnEl']")
	public WebElement save_WorkOrder;

	@FindBy(xpath = "//span[@class='svmx-btn-icon svmx-sfmd-save-icon']")
	public WebElement saveopenlabor;

	@FindBy(xpath = "//button[@data-qtip='Save']")
	public WebElement save_case;

	@FindBy(xpath = "//*[text()='Sales Org:']/parent::td/following-sibling::td//*[@role='button']")
	public WebElement sales_dropdwn;

	@FindBy(xpath = "//span[text()='Details']")
	public WebElement Details;

	@FindBy(xpath = "//span[@class='svmx-btn-icon svmx-sfmd-save-icon']")
	public WebElement EscalationcaseSave;

	@FindBy(xpath = "//input[@value=' Save ']")
	public WebElement savedits;

	@FindBy(xpath = "//input[@value='Save/Submit']")
	public WebElement save_submit;

	@FindBy(xpath = "//select")
	public WebElement selectstatus;

	@FindBy(xpath = "//a[text()='Related']")
	WebElement tab_related;

	@FindBy(xpath = "//input[@title=' System Information']")
	public WebElement systemInfoButton;

	@FindBy(xpath = "//div[contains(@class,'slds-grid slds-wrap slds-col slds-size')]//a[text()='Details']")
	private WebElement tab_details;

	@FindBy(xpath = "(//a[text()='Related'])[2]")
	WebElement tab_related1;

	@FindBy(xpath = "//div[contains(@class,'slds-global-header')]//input[contains(@placeholder,'Search')]")
	WebElement globalSearch;

	@FindBy(xpath = "//div[contains(@class,'slds-global-header')]//input[@id='input-5']")
	WebElement filter_Search;

	@FindBy(xpath = "//div[@class='inputSpinner slds-is-absolute']")
	WebElement spinner_golbalSearch;

	@FindBy(xpath = "//div[@id='dropdown-element-5']//lightning-base-combobox-formatted-text")
	WebElement search_type;

	@FindBy(xpath = "//div[@role='navigation']/one-app-launcher-header")
	WebElement app_Exchange;

	@FindBy(xpath = "//one-app-launcher-search-bar//input")
	WebElement appExchangeSearchBox;

	@FindBy(xpath = "//one-app-launcher-menu/div[@role='combobox']")
	WebElement appExchangeSearchResult;

	@FindBy(xpath = "//iframe[contains(@title,'Installed_Product_Wizard')]")
	public WebElement installed_product_custom_Action_frame;

	@FindBy(xpath = "//input[@value='Create Case']")
	public WebElement create_Case_SFM;

	@FindBy(xpath = ".//*[@id='svmx_sfm_delivery_root_container0-info']")
	public WebElement creat_Case_dialog;

	@FindBy(xpath = "//*[text()='Contact ID:']/parent::td/following-sibling::td//input")
	public WebElement contactID_Searchinput;

	@FindBy(xpath = "//*[text()='Contact ID:']/parent::td/following-sibling::td//*[@role='button']")
	public WebElement contactID_SearchBtn;

	@FindBy(xpath = "//*[text()='Partner Account:']/parent::td/following-sibling::td//*[@role='button']")
	public WebElement partnerAccount_SearchBtn;

	@FindBy(xpath = "//span[text()='Full Name']/../../../../../following-sibling::div//tr/td/div")
	public WebElement contact_ID_fullname;

	@FindBy(xpath = "//*[text()='Contact ID:']/../following-sibling::td//input")
	public WebElement contactID_Input;

	@FindBy(xpath = "//span[text()='Select']")
	public WebElement select_Contact_id_fullname;

	@FindBy(xpath = "//*[text()='Event Type:']/parent::td/following-sibling::td//*[@role='button']")
	public WebElement eventType_dropdown;

	@FindBy(xpath = "//*[text()='Service Type/Event Subtype:']/parent::td/following-sibling::td//*[@role='button']")
	public WebElement eventSubType_dropdown;

	@FindBy(xpath = "//*[text()='Priority:']/parent::td/following-sibling::td//*[@role='button']")
	public WebElement priority_Dropdown;

	@FindBy(xpath = "//*[text()='Subject:']/parent::td/following-sibling::td/input")
	public WebElement subject;

	@FindBy(xpath = "//*[text()='Description:']/parent::td/following-sibling::td/textarea")
	public WebElement desc;
	
	@FindBy(xpath = "//label[text()='Answer']/following-sibling::div/div/div/div/input")
	public WebElement safetyQuestion_Dropdown;

	@FindBy(xpath = "//label[text()='Description:']/../..//textarea")
	public WebElement description;

	@FindBy(xpath = "//span[text()='Details']")
	public WebElement case_Details;

	@FindBy(xpath = "//*[text()='Site']/../following-sibling::td/div")
	public WebElement site_case;

	@FindBy(xpath = "//*[text()='Site']/../following-sibling::td/div//input[@type='text']")
	public WebElement site_case_Input;

	@FindBy(xpath = "//iframe[@title='ESMX_Case_Wizard_Lite']")
	public WebElement manage_WorkOrder_Frame;

	@FindBy(xpath = "//*[@data-qtip='Extended Edit']")
	protected List<WebElement> extended_Edit;

	@FindBy(xpath = "//input[@value='Safety Question' or @value='Safety Questions']")
	public WebElement safety_Questions;

	@FindBy(xpath = ".//*[@id='svmx_sfm_delivery_root_container0-info']")
	public WebElement safety_Questionair_Dialog;

	@FindBy(xpath = "//label[contains(text(),'Ans')]/../following-sibling::td//td")
	public List<WebElement> ans_Dropdown;

	@FindBy(xpath = "//button[@data-qtip='Save']")
	public WebElement save_safety_Questionaire;

	@FindBy(xpath = "//iframe[@title='ESMX_Service_Order_Wizard_Lite']")
	public WebElement service_order_frame;

	@FindBy(xpath = "//input[@value='Dispatch Technician']")
	public WebElement dispatch_Technician_SFM;

	//Hima
		@FindBy(xpath = "//li/a/span/span[text()='5-Scheduled Activity']")
		public WebElement priority_Value;
		//Hima
		@FindBy(xpath = "//*[text()='Case Source']/following-sibling::div/div/div/div/input")
		public WebElement case_source_Dropdown;
		//Hima
		@FindBy(xpath = "//li/a/span/span[text()='Manual Proactive Monitoring']")
		public WebElement case_source_value;

	@FindBy(xpath = "//span[text()='Expand Tree Branch']/..")
	public List<WebElement> expand_Service_Team1;

	@FindBy(xpath = "//span[@title='Manage Multiple Assignments']")
	public WebElement manage_Schedule;

	@FindBy(xpath = "//span[text()='Expand Tree Branch']")
	public List<WebElement> expand_Service_Team;

	@FindBy(xpath = "//*[text()='Field Updates']")
	public WebElement field_Updates;

	@FindBy(xpath = "//*[text()='Dispatch Console']")
	public WebElement dispatch_Console;

	@FindBy(xpath = "//span[@title='Unscheduled']")
	public WebElement schedule_Status_dropdown;

	@FindBy(xpath = "//span[@title='Dispatched']")
	public WebElement schedule_status_dispatched;

	@FindBy(xpath = "//*[text()='Event Status']/../../following-sibling::div//input")
	public WebElement event_Status_dropDown;

	@FindBy(xpath = "//*[text()='Scheduled Duration']/../../../following-sibling::div//span[@title='Confirmed']")
	public WebElement event_Status_Confirmed;

	@FindBy(xpath = "//span[text()='Done']")
	public WebElement done_Dispatch_Console;

	@FindBy(xpath = "//span[text()='Schedule']")
	public WebElement schedule_btn;

	@FindBy(xpath = "//span[text()='Details']")
	public WebElement detailsTab;

	@FindBy(xpath = "//span[text()='Case']/../..//a")
	public WebElement caselink;

	@FindBy(xpath = "//*[text()='Work Order']")
	public WebElement work_order_header;

	@FindBy(xpath = "//td/input[contains(@value,'Create Onsite Work Order')]")
	public WebElement create_Onsite_Workorder_SFM;

	@FindBy(xpath = "//*[text()='Planned Labor Hours:']/../following-sibling::td//input")
	public WebElement planned_labor_hour;

	@FindBy(xpath = "//input[@value='Initiate SWO']")
	public WebElement initiate_SWO;

	@FindBy(xpath = "//span[text()='SAP SWO Number']/../following-sibling::td/div")
	public WebElement SAP_SWO_Number;

	@FindBy(xpath = "//*[text()='Work Order']/following-sibling::*[@class='pageDescription']")
	public WebElement workorder_Number;

	@FindBy(xpath = "//iframe[@title='ESMX_Service_Order_Wizard_Lite']")
	public WebElement OrderWizframe;

	@FindBy(xpath = "//input[contains(@placeholder,'Search')]")
	WebElement globalsearch;

	@FindBy(xpath = "(//input[contains(@placeholder,'Search')])[1]")
	WebElement globalsearch1;

	@FindBy(xpath = "//div[contains(@class,'Search')]//input[@type='button']")
	WebElement btn_Search;

	@FindBy(xpath = "//img[@alt='All Tabs']")
	public WebElement alltabs;

	@FindBy(xpath = "//a[text()='CS Portal User Assignment']")
	public WebElement CSPortal;

	@FindBy(xpath = "//input[@placeholder='Type here...']")
	public WebElement searchportal;

	@FindBy(xpath = "//button[text()='Search']")
	public WebElement searchbtn;

	@FindBy(xpath = "//input[@id='CP_Login:theForm:username']")
	public WebElement portalUserName;

	@FindBy(xpath = "//input[@id='CP_Login:theForm:password']")
	public WebElement portalUserPassword;

	@FindBy(xpath = "//input[@value='Login']")
	public WebElement portalLogin;

	@FindBy(xpath = "//span[text()='You are already logged in!']")
	public WebElement alreadyLoogedIn;

	@FindBy(xpath = "//*[@value='Done']")
	public WebElement done;

	@FindBy(xpath = "//button[@data-qtip='Save']")
	public WebElement btn_save;

	@FindBy(xpath = "//span[@class= 'svmx-btn-icon svmx-sfmd-save-icon']")
	public WebElement manualRenewal_serviceContract_saveButton;

	@FindBy(xpath = "//span[@id='userNavLabel']")
	public WebElement userMenu;

	@FindBy(xpath = "//a[@title='My Settings']")
	public WebElement my_Settings;

	@FindBy(xpath = ".//*[@id='PersonalInfo_font']")
	public WebElement personal_Info;

	@FindBy(xpath = ".//span[@id='AdvancedUserDetails_font']")
	public WebElement advanced_User_details;

	@FindBy(xpath = ".//*[text()='Profile']/following-sibling::*//a")
	public WebElement profile;

	@FindBy(xpath = "//a[@title='Logout']")
	public WebElement logout;

	@FindBy(xpath = "(//div[contains(@class,'sd_primary')])[1]//div[@class='x-tab-tabmenu-right']")
	public WebElement primary_tab;

	@FindBy(xpath = "//span[text()='Close all primary tabs']")
	public WebElement close_primarytabs;

	@FindBy(xpath = "//button[contains(text(),'Don') and contains(text(),'Save')]")
	public WebElement btn_dontsave;

	@FindBy(xpath = "//input[@id='phSearchButton']")
	public WebElement btn_globalSearch;

	@FindBy(xpath = "//input[@placeholder='Search...']")
	public WebElement lookup_search;

	@FindBy(xpath = "//frame[@id='searchFrame']")
	public WebElement lookup_searchframe;

	@FindBy(xpath = "//span[text()='Details']")
	public WebElement detailstab;

	@FindBy(xpath = "//*[@value='OK']")
	public WebElement okButton;

	@FindBy(xpath = "//input[@title='Go!']")
	public WebElement viewGoButton;

	@FindBy(xpath = "//a[contains(text(), 'Create New')]")
	public WebElement CreateNewView;

	@FindBy(xpath = "//a[contains(text(), 'Edit')]")
	public WebElement EditView;

	@FindBy(xpath = "//*[@id='fname']")
	public WebElement ViewName;

	@FindBy(xpath = "//*[@id='devname']")
	public WebElement ViewUniqueName;

	@FindBy(xpath = "//select[@name='fcf']")
	public WebElement View;

	@FindBy(xpath = "//*[@title='New']")
	protected WebElement newButton;

	@FindBy(xpath = "(//input[@placeholder='Quick Find'])[2]")
	public WebElement quickFind;

	@FindBy(xpath = "//span[@class='svmx-btn-icon svmx-sfmd-search-icon ']")
	public WebElement searchButton;

	@FindBy(xpath = "//span[text()='Status' and @class='helpButton']/../following-sibling::td")
	public WebElement txt_status;

	@FindBy(xpath = "//span[text()='Customer Language']/../preceding-sibling::td/div")
	public WebElement order_status;

	@FindBy(xpath = "//td[text()='Quote Number']/following-sibling::td/div")
	public WebElement Quote_Number;

	@FindBy(xpath = "//*[text()='Quote Number']/../following-sibling::tr//a[contains(text(),'Q-')]")
	public WebElement Quote_Number_Case;

	@FindBy(xpath = "//input[@value='Done']")
	public WebElement done_Quote;

	@FindBy(xpath = "//a[text()='Delete']")
	public List<WebElement> deleteButtonList;

	@FindBy(xpath = "//*[text()='Permission Set Assignments'][@class='listTitle']")
	public WebElement profile_PermissionSet_Link;

	@FindBy(xpath = "//*[text()='Permission Set Group Assignments'][@class='listTitle']")
	public WebElement profile_PermissionSetGroup_Link;

	@FindBy(xpath = "//*[text()='Assigned Territories'][@class='listTitle']")
	public WebElement assigned_territory;

	@FindBy(xpath = "//a[text()='Technician/Equipment']")
	private WebElement objectTechnician;

	@FindBy(xpath = "//a[text()='Vendors']")
	public WebElement objectVendors;

	@FindBy(xpath = "//a[text()='Incident Mass Uploads']")
	public WebElement objectIncident_Mass_Upload;

	@FindBy(xpath = "//a[@title='Contacts Tab']")
	public WebElement contact_Tab;

	@FindBy(xpath = "//a[contains(text(),'Home')]")
	public WebElement homeTab;

	@FindBy(xpath = "//span[text()='Proceed']")
	public WebElement proceedButton;

	@FindBy(xpath = "//select[@id='p3']")
	public WebElement newRecordType;

	@FindBy(xpath = "//span[@class='svmx-btn-inner' and text()='Select']")
	public WebElement smaxlookupSelectButton;

	@FindBy(xpath = "//input[@value='Continue']")
	public WebElement continueButton;

	@FindBy(xpath = "//input[@id='Name']")
	private WebElement vendorName;

	@FindBy(xpath = "//*[text()='SAP External ID']/../../following-sibling::td//input")
	private WebElement vendorExternalID;

	@FindBy(xpath = "//*[text()='SAP Currency']/../../following-sibling::td//select")
	private WebElement vendorSAPCurrency;

	@FindBy(xpath = "//*[text()='Purchase Organization']/../../following-sibling::td//select")
	private WebElement vendorPurchaseOrganization;

	@FindBy(xpath = "//*[text()='Purchasing Group']/../../following-sibling::td//select")
	private WebElement vendorPuchaseGroup;

	@FindBy(xpath = "//*[text()='Phone Number']/../../preceding-sibling::td//input")
	private WebElement vendorStreet;

	@FindBy(xpath = "//*[text()='Email']/../../preceding-sibling::td//input")
	private WebElement vendorCity;

	@FindBy(xpath = "//*[text()='Country']/../../following-sibling::td//select")
	private WebElement vendorCountry;

	@FindBy(xpath = "//*[@id='topButtonRow']//input[@title = 'Save']")
	protected WebElement saveTopButton;

	@FindBy(xpath = "//td[contains(@id,'CreatedBy')]")
	private WebElement createdBy;

	@FindBy(xpath = "//div[@class='congrats']")
	public WebElement congrats;

	@FindBy(xpath = "//div[@class='congrats']/parent::div/following-sibling::div//a")
	public WebElement ok;

	@FindBy(xpath = "//span[contains(text(),'Field Change Orders')]")
	public WebElement FCO_Created_Text;

	@FindBy(xpath = "//input[@value='Create CAL Work Orders']")
	public WebElement createWorkOrders;

	@FindBy(xpath = "//span[text()='FCO Global Due Date']/parent::td/following-sibling::td/div")
	public WebElement FCO_Global_Due_Date;

	@FindBy(xpath = "//span[text()='FCO Global Due Date']/parent::td/following-sibling::td//input")
	public WebElement FCO_Global_Due_Date_Select;

	@FindBy(xpath = "//td[text()='Field Change Order Name']/following-sibling::*/div")
	public WebElement FCO_Name;

	@FindBy(xpath = "//input[@title='Create CAL Case']/parent::td/preceding-sibling::td/*[text()='CAL']")
	public WebElement FCO_Record_Id;

	@FindBy(xpath = "//span[text()='FCO Lifecycle Status']/parent::td/following-sibling::td/div")
	public WebElement FCO_Lifecycle_Status;

	@FindBy(xpath = "//span[text()='FCO Lifecycle Status']/parent::td/following-sibling::td/div//select")
	public WebElement FCO_Lifecycle_status_Select;

	@FindBy(xpath = "//span[text()='FCO Release Date']/parent::td/following-sibling::td/div")
	public WebElement FCO_Release_Date;

	@FindBy(xpath = "//span[text()='FCO Release Date']/parent::td/following-sibling::td//input")
	public WebElement FCO_Release_Date_Select;

	@FindBy(xpath = "//span[text()='Delivery Method']/parent::td/following-sibling::td/div")
	public WebElement Delivery_Method;

	@FindBy(xpath = "//span[text()='Delivery Method']/parent::td/following-sibling::td/div//select")
	public WebElement Delivery_Method_Select;

	@FindBy(xpath = "//input[@title='Save']")
	public WebElement save_FCO;

	@FindBy(xpath = "//span[text()='Which Field Change Order field in your file do you want to match against to set the FCO Header - UAL lookup field?']/parent::div/following-sibling::div/select")
	public WebElement FCO_UAL_LookupField;

	@FindBy(xpath = "//div[@class='error-block']/parent::div/following-sibling::div//a")
	public WebElement errorOK;

	@FindBy(xpath = "The matching field you chose (UniqueIdentifier) is not mapped and is required for an Update and Insert operation.")
	public WebElement errorText;

	@FindBy(xpath = "//span[text()='Match by:']/parent::div/following-sibling::div/select")
	public WebElement match_By;

	@FindBy(xpath = "//*[@title='Create UAL Case']")
	private WebElement createUALCase_button;

	@FindBy(xpath = "//*[@title='Create UAL Work Orders']")
	private WebElement createUALWorkOrder_button;

	@FindBy(xpath = "(//*[text()='0116440392'])[1]")
	private WebElement createdUALcase_1stLine;

	@FindBy(xpath = "(//*[text()= 'Case Number'])[1]")
	private WebElement caseDetailsPage_header;

	@FindBy(xpath = "//th[text()= 'Work Order Number']/../following-sibling::tr/th[@scope='row']/a")
	private WebElement workOrderNumber_data;
	@FindBy(xpath = "//*[text()='Number Of Working Hours']/preceding-sibling::td/div")
	private WebElement fcoLifecycleStatus;

	@FindBy(xpath = "//*[text()='Number Of Engineers']/../preceding-sibling::td/div")
	private WebElement fcoNumber;

	@FindBy(xpath = "//*[text()='Number Of Engineers']/../preceding-sibling::td/div/input")
	private WebElement fcoNumberInput;

	@FindBy(xpath = "//*[text()='FCO Global Due Date']/../following-sibling::td/div/input")
	private WebElement fcoGlobalDueDateInput;

	@FindBy(xpath = "//*[text()='FCO UAL Author']/../following-sibling::td/div")
	private WebElement fcoUALAuthor;

	@FindBy(xpath = "//*[text()='FCO UAL Author']/../following-sibling::td/div/input")
	private WebElement fcoUALAuthorInput;

	@FindBy(xpath = "//*[text()='FCO Title']/../following-sibling::td/div")
	private WebElement fcoTitle;

	@FindBy(xpath = "//*[text()='FCO Title']/../following-sibling::td/div/input")
	private WebElement fcoTitleInput;

	@FindBy(xpath = "//*[text()='Delivery Method']/../following-sibling::td/div")
	protected WebElement fcoDeliveryMethod;

	@FindBy(xpath = "//*[text()='Delivery Method']/../following-sibling::td/div//select")
	protected WebElement fcoDeliveryMethodInput;

	@FindBy(xpath = "//*[text()='Cascade Fields to Case & WO']/../preceding-sibling::td/div/input")
	private WebElement fcoBGInput;

	@FindBy(xpath = "//*[text()='Cascade No of Engineers']/../preceding-sibling::td/div")
	private WebElement fcoBU;

	@FindBy(xpath = "//*[text()='Cascade No of Engineers']/../preceding-sibling::td/div/input")
	private WebElement fcoBUInput;

	@FindBy(xpath = "//*[text()='Cascade No of Working Hours']/../preceding-sibling::td/div")
	private WebElement fcoReleaseDate;

	@FindBy(xpath = "//*[text()='Cascade No of Working Hours']/../preceding-sibling::td/div/input")
	private WebElement fcoReleaseDateInput;

	@FindBy(xpath = "//*[text()='FCO Global Due Date']/../following-sibling::td/div")
	private WebElement fcoGlobalDueDate;

	@FindBy(xpath = "//*[text()='Cascade Fields to Case & WO']/../following-sibling::td/div")
	protected WebElement cascadeFields;

	@FindBy(xpath = "//*[text()='Cascade Fields to Case & WO']/../following-sibling::td/div/input")
	protected WebElement cascadeFieldsInput;

	@FindBy(xpath = "//*[@id='topButtonRow']/input[@value='Cascade Changes']")
	protected WebElement cascadeChanges;

	@FindBy(xpath = "//*[text()='Cascade Fields to Case & WO']/../preceding-sibling::td/div")
	private WebElement fcoBG;

	@FindBy(xpath = "//*[@id='topButtonRow']//input[@value='Create CAL/DAL']")
	public WebElement createCALDAL;

	@FindBy(xpath = "//input[@value='Create UAL Work Orders']")
	private WebElement createUALWO;

	@FindBy(xpath = "//*[@title='Field Change Order']/following-sibling::*[text()='UAL']/ancestor::div[@class='pbHeader']/following-sibling::div//a/parent::th/following-sibling::td/*[@title='Checked']")
	public List<WebElement> UAL_WOs;

	@FindBy(xpath = "//*[@title='Field Change Order']/following-sibling::*[text()='CAL']/ancestor::div[@class='pbHeader']/following-sibling::div//a")
	private List<WebElement> calRecords;

	@FindBy(xpath = "//*[@title='Field Change Order']/following-sibling::*[text()='CAL']/ancestor::div[@class='pbHeader']/following-sibling::div//a/parent::th/following-sibling::td/*[@title='Checked']")
	public List<WebElement> CAL_WOs;

	@FindBy(xpath = "//*[@title='Field Change Order']/following-sibling::*[text()='DAL']/ancestor::div[@class='pbHeader']/following-sibling::div//a/parent::th/following-sibling::td/*[@title='Checked']")
	public List<WebElement> DAL_WOs;

	@FindBy(xpath = "//*[text()='Work Order Number']/../following-sibling::tr//a[not(contains(text(),'Edit'))]")
	public List<WebElement> CALDAL_CaseWOs;

	@FindBy(xpath = "//input[@value='Create Material Only Work Order']")
	private WebElement createMaterialWorkOrder;

	@FindBy(xpath = "//input[@value='Initiate Service']")
	private WebElement InitiateService;

	@FindBy(xpath = "//iframe[@title='ESMX_Service_Order_Wizard_Lite']")
	private WebElement InitiateServiceFrameWork;

	@FindBy(xpath = "//input[@value='Create CAL Case']")
	public WebElement createCase;

	@FindBy(xpath = "//*[@title='Field Change Order']/following-sibling::*[text()='CAL']/ancestor::div[@class='pbHeader']/following-sibling::div//a/parent::th/following-sibling::td/a")
	public WebElement FCO_Case;

	@FindBy(xpath = "//*[@title='Field Change Order']/following-sibling::*[text()='CAL']/ancestor::div[@class='pbHeader']/following-sibling::div//a/parent::th/following-sibling::td/*[@title='Checked']")
	public WebElement isFCO_Work_Order_Created;

	@FindBy(xpath = "//*[@data-qtip='Add a row']")
	public List<WebElement> addRow;

	@FindBy(xpath = "//button[@data-qtip='Quick Save']")
	protected WebElement quickSave;

	@FindBy(xpath = "//span[text()='Product Name']/../../../../../following-sibling::div//tr/td/div")
	public WebElement product_select;

	@FindBy(xpath = "//td/input[contains(@value,'Direct Online Parts Order')]")
	public WebElement direct_online_parts_order;

	@FindBy(xpath = "//td/input[contains(@value,'Create Work Order')]")
	public WebElement create_WO_Distributor;

	@FindBy(xpath = "//span[contains(text(), 'Open Parts Returnable')]//parent::button//parent::em//parent::div")
	public WebElement OpenPartsReturnable;

	@FindBy(xpath = "//span[contains(text(), 'Open Parts Non Returnable')]//parent::button//parent::em//parent::div")
	public WebElement OpenPartsNonReturnable;

	@FindBy(xpath = "//label[contains(text(), 'Line Status')]//following::div[2]")
	public WebElement lineStatusDropdown;

	@FindBy(xpath = "//label[contains(text(), 'Part Status:')]//following::td[3]")
	public WebElement PartStatusDropdown;

	@FindBy(xpath = "//label[contains(text(), 'Defective Part Failure Reason:')]//following::td[3]")
	public WebElement Defectivepart;

	////////// Parts page elements

	@FindBy(xpath = "//label[text()='Tracking Number:']//following::input[1]")
	public WebElement TrackingNumber;

	@FindBy(xpath = "//label[text()='Defective Part Number:']//following::input[1]")
	public WebElement DefectivePartNumber;

	@FindBy(xpath = "//label[text()='Defective Serial Number:']//following::input[1]")
	public WebElement DefectiveSerialNumber;

	@FindBy(xpath = "//label[text()='Defective Batch Control Number:']//following::input[1]")
	public WebElement DefectiveBatchControlNumber;

	@FindBy(xpath = "//label[text()='Defective Part UDI:']//following::input[1]")
	public WebElement DefectivePartUDI;

	@FindBy(xpath = "//label[text()='Select:']//following::input[1]")
	public WebElement Select;

	@FindBy(xpath = "//label[text()='Defective Part Information:']//following::textarea[1]")
	public WebElement DefectivePartInformation;

	@FindBy(xpath = "//label[text()='RML Number:']//following::input[1]")
	public WebElement RMLNumber;

	@FindBy(xpath = "//label[text()='Return Tracking Number:']//following::input[1]")
	public WebElement ReturnTrackingNumber;

	@FindBy(xpath = "//label[text()='Tools Indicator:']//following::input[1]")
	public WebElement ToolsIndicator;

	@FindBy(xpath = "//label[text()='IP structure is non-available:']//following::input[1]")
	public WebElement IPstructure;
	//////////// save button in add labor and parts
	@FindBy(xpath = "//span[@id='sfm-button-1693-btnIconEl']")
	public WebElement SaveLabor;

	@FindBy(xpath = "//*[text()='Phone Extension']/preceding-sibling::td/div")
	public WebElement contact_Name;

	@FindBy(xpath = "//iframe[@title='Case_Wizard']")
	public WebElement case_wizard_iframe;

	@FindBy(xpath = "//td/input[contains(@value,'Create Work Order(Onsite Clinical)')]")
	public WebElement create_Clinical_Onsite_Workorder_SFM;

	@FindBy(xpath = "//div[@class='svmx-sfmd-error-cmp-error-detail']")
	protected WebElement txt_error;

	@FindBy(xpath = "//*[text()='Event Date:']")
	public WebElement event_Date;

	@FindBy(xpath = "//*[@class= 'svmx-btn-icon svmx-sfmd-current-datetime-icon']")
	protected WebElement debriefSystemStatusDateOrTime_button;

	@FindBy(xpath = "//*[text()='Customer Country:']//parent::td//parent::tr//input")
	protected WebElement customer_Country;

	@FindBy(xpath = "//span[text()='Acknowledge Training Compliance Gap']/../following-sibling::td/div")
	private WebElement Acknowledge;

	@FindBy(xpath = "//span[text()='Acknowledge Training Compliance Gap']/../following-sibling::td/div/input")
	private WebElement Ack_checkbox;

	@FindBy(xpath = "//*[contains(text(), 'Feed')][@class='optionLabel']")
	private WebElement toggleTo_Feed;

	@FindBy(xpath = "//*[contains(text(), 'Details')][@class='optionLabel']")
	private WebElement toggleTo_Details;

	@FindBy(xpath = "//input[@value='Create UAL Work Orders']")
	public WebElement createUALWorkOrders;

	@FindBy(xpath = "//*[@title='Field Change Order']/following-sibling::*[text()='UAL']/ancestor::div[@class='pbHeader']/following-sibling::div//a/parent::th/following-sibling::td/a")
	public WebElement FCO_UAL_Case;

	@FindBy(xpath = "//span[text()='Case Number']/following-sibling::span/span")
	public WebElement case_Number;

	@FindBy(xpath = "//span[text()='Work Order']//following::a[1]")
	public WebElement workOrderLink;

	@FindBy(xpath = "//span[text()='Part Status']//following::div[1]")
	private WebElement consumedParts;

	@FindBy(xpath = "//h3[text()='Work Details (Work Order)']//following::a[3]")
	public WebElement lineNumber;

	@FindBy(xpath = "//h3[text()='Parts Order Lines']//following::td[10]")
	private WebElement asoNo;

	@FindBy(xpath = "//h3[text()='Work Details (Work Order)']//following::td[5]")
	public WebElement shipped;

	@FindBy(xpath = "//input[@value='Manage Pending Returns']")
	public WebElement managePendingReturns;

	@FindBy(xpath = "//span[text()='Completed Requests']")
	public WebElement CompletedRequests;

	@FindBy(xpath = "//*[@data-qtip='Extended Edit']")
	public WebElement edit_Labor_Parts;

	@FindBy(xpath = "//*[text()='Line Status:']/../following-sibling::*//div[contains(@class,'svmx-form-arrow-trigger')]")
	public WebElement line_Status_DropDown;

	@FindBy(xpath = "//span[text()='Work Details (Work Order)']")
	public WebElement workDetails;

	@FindBy(xpath = "//*[@id='SVMXC__Service_Order__c_body']/table/tbody/tr[2]/th/a")
	public WebElement work_Order_Number;

	@FindBy(xpath = "//a[text()='Next']")
	public WebElement nextBTN;

	@FindBy(xpath = "//span[text()='Which Installed Product field in your file do you want to match against to set the UAL Installed Product lookup field?']/parent::div/following-sibling::div/select")
	public List<WebElement> FCO_UAL_installedProdtField;

	@FindBy(xpath = "//input[@placeholder ='Quick Find']")
	public WebElement QuickFind;

	@FindBy(xpath = "//div[text()='ES-Agito']/../..//input")
	public WebElement select_Technician1;

	@FindBy(xpath = "//div[text()='ES-Agito']/../..//input[@type='radio']")
	public WebElement owner1;

	@FindBy(xpath = "//input[@value='Request a Quote']")
	public WebElement requestAQuoteSFM;

	@FindBy(xpath = "//input[@value='New quote request']")
	public WebElement newQuoteRequest;

	@FindBy(xpath = "//div[@class='requiredBlock']/following-sibling::textarea[contains(@id,'Quote:Description')]")
	public WebElement quoteRequestDesc;

	@FindBy(xpath = "//div[@class='requiredBlock']/following-sibling::select[contains(@id,'Quote:ServiceQuote')]")
	public WebElement serviceQuoteStatus;

	@FindBy(xpath = "//div[@class='requiredBlock']/following-sibling::select[contains(@id,'Quote:Draft')]")
	public WebElement serviceQuoteStatus_1;

	@FindBy(xpath = "//a[@title='Terms and Conditions Lookup (New Window)']/preceding-sibling::input")
	public WebElement termsAndConditions;

	@FindBy(xpath = "//a[@title='Terms and Conditions Lookup (New Window)']")
	public WebElement search_TermsAndConditions;

	@FindBy(xpath = "//frame[@title='Results']")
	public WebElement termsANDCOnditionFrame;

	@FindBy(xpath = "//a[text()='Show all results']")
	public WebElement showAllResults;

	@FindBy(xpath = "//div[@id='ESMX_Term_and_Condition__c_body']//th[@scope='row']/a")
	public WebElement selectTermsAndCon;

	@FindBy(xpath = "//td[text()='Parts']")
	public WebElement addParts;

	@FindBy(xpath = "//label[text()='Submit:']/parent::td/following-sibling::td/input")
	public WebElement submit;

	@FindBy(xpath = "//a[@title='Part Lookup (New Window)']")
	public List<WebElement> partSearch1;

	@FindBy(xpath = "//a[@title='Part Lookup (New Window)']/preceding-sibling::input")
	public List<WebElement> partText;

	@FindBy(xpath = "//a[@title='Part Lookup (New Window)']/parent::span/../following-sibling::td/select")
	public List<WebElement> DiscountType1;

	@FindBy(xpath = "//a[@title='Part Lookup (New Window)']/parent::span/../following-sibling::td/select/../following-sibling::td/input")
	public List<WebElement> DiscountText;

	@FindBy(xpath = "//a[@title='Part Lookup (New Window)']/parent::span/../following-sibling::td/div[@class='requiredInput']/select")
	public List<WebElement> DiscountReason;

	@FindBy(xpath = "//input[@value='New']")
	public WebElement newParts;

	@FindBy(xpath = "//td[text()='Labor']")
	public WebElement addLaborBTN;

	@FindBy(xpath = "//input[@value='New']")
	public List<WebElement> newLaborButton;

	@FindBy(xpath = "//select[contains(@id,'lstLabor')]")
	public List<WebElement> laborActivityCode;

	@FindBy(xpath = "//input[contains(@id,'lstLabor')]")
	public List<WebElement> DiscountLabour;

	@FindBy(xpath = "//input[@value='Get Price/VAT']")
	public WebElement getVAT;

	@FindBy(xpath = "//select[contains(@id,'lstLabor')]/../../../../../preceding-sibling::input")
	public WebElement newLaborButton2;

	@FindBy(xpath = "//input[@value='Save']")
	public WebElement save_Quote;

	@FindBy(xpath = "//iframe[contains(@title,'Quote_Wizard')]")
	public WebElement Quote_Wizard;

	@FindBy(xpath = "//input[@value='Release Quote']")
	public WebElement release_Quote_SFM;

	@FindBy(xpath = "//input[@value='Generate PDF']")
	public WebElement generate_PDF_SFM;

	@FindBy(xpath = "//input[@value='Return']")
	public WebElement returnPDF;

	@FindBy(xpath = "//input[@value='Approve Credit']")
	public WebElement ApproveCredit;

	@FindBy(xpath = "//div[text()='Pending Credit Approval' or text()='Released' ]")
	public WebElement Creditapproval;

	@FindBy(xpath = "//span[text()='Quote Items']")
	public WebElement quoteItemsClick;

	@FindBy(xpath = "//input[@title=' Approve Quote Item']")
	public WebElement AproveQuote;

	@FindBy(xpath = "//*[@class='pShowMore']/a[1]")
	public WebElement showMore;

	@FindBy(xpath = "//*[text()='Pending - Local']/preceding-sibling::td/a[contains(@title,'Edit - Record ')]/../following-sibling::th/a")
	public List<WebElement> pending_Quot;

	@FindBy(xpath = "//*[@id='SVMXC__Service_Contract__c']")
	public WebElement searchResult;

	@FindBy(xpath = "//iframe[@title ='ESMX_Quote_Item_Wizard']")
	public WebElement iframeQuote;

	@FindBy(xpath = "//span[text()='Status']/../following-sibling::td/div")
	public WebElement QuStatus;

	@FindBy(xpath = "//input[@value='Accept Quote']")
	public WebElement accept_SFM;

	@FindBy(xpath = "//*[@id='sfm-text-1030-inputEl']")
	public WebElement Customer_Purchase_Order_Number;

	@FindBy(xpath = "//*[@id='sfm-button-1044-btnIconEl']")
	public WebElement save_Accept_Quote;

	@FindBy(xpath = "//input[@value='Approve Quote']")
	private WebElement quoteApproval;

	@FindBy(xpath = "//span[text()='Status']/parent::td/following-sibling::td/div")
	public WebElement status;

	@FindBy(xpath = "//*[text()='Installed Product:']/../following-sibling::td//input")
	public WebElement ip_caseLines;

	@FindBy(xpath = "//select[@id ='j_id0:form2:Quote:ServiceQuote:j_id72']")
	public WebElement bussinessGroupDropDown;

	@FindBy(xpath = "//input[@value='Check SalesOrder Type/WBS']")
	public WebElement Check_SalesOrder_SFM;

	@FindBy(xpath = "//span[contains(text(),'Details')]")
	public WebElement Details_Tab;

	@FindBy(xpath = "//caption[contains(text(),'Step 2 – Document Work')]//following::input[2]")
	public WebElement AddLaborParts;

	@FindBy(xpath = "//a[text()='X']")
	public List<WebElement> allTasks;

	@FindBy(xpath = "//input[@value='Create Parts Supply Only Work Order']")
	public WebElement createPartsOnlyWorkOrder1;

	@FindBy(xpath = "//*[text()='Site:']/../following-sibling::td//input")
	public WebElement site_input;

	@FindBy(xpath = "//*[text()='Site:']/../following-sibling::td//button")
	public WebElement site_SearchBtn;

	@FindBy(xpath = "//span[text()='Location Name']/../../../../../following-sibling::div//tr/td/div")
	public WebElement site_fullname;

	@FindBy(xpath = "//input[@value='Exact Match']/parent::td/following-sibling::td")
	private WebElement search_IP_BTN;

	@FindBy(xpath = "//input[@value='Exact Match']/ancestor::table/following-sibling::table//input")
	private WebElement quickFind_IP;

	@FindBy(xpath = "//*[contains(text(),'Limit search to Account: ')]/preceding-sibling::input")
	private WebElement limitSearch;

	@FindBy(xpath = "//input[@value='Exact Match']/ancestor::table/following-sibling::div//*[@role='button']")
	private WebElement quickFindBTN;

	@FindBy(xpath = "//input[@value='Confirm Delivery']")
	public WebElement confirmDelivery;

	@FindBy(xpath = "//button[@data-qtip='Save']")
	public WebElement saveWO;

	@FindBy(xpath = "//input[@value='Parts Ordering']")
	private WebElement PartsOrdering;

	@FindBy(xpath = "//input[@id='j_id0:FormId:Partssearchsection:ProdCode1']")
	private WebElement partCodeEntering;

	@FindBy(xpath = "//img[@title='Click To Add Parts']")
	private WebElement addPart;

	@FindBy(xpath = "//input[@value='Search']")
	private WebElement partOrderingSearch;

	@FindBy(xpath = "//input[@value='Get Entitlement']")
	private WebElement GetEntitlement;

	@FindBy(xpath = "//input[@value='GATP Simulation']")
	private WebElement GATPSimulation;

	@FindBy(xpath = "//input[@value='Transfer To SAP']")
	private WebElement TransferToSAP;

	@FindBy(xpath = "//a[text()='Back to work order']")
	private WebElement backtoworkorder;

	@FindBy(xpath = "//td/*[@title='Parts Order Line']")
	public WebElement part;

	@FindBy(xpath = "//*[text()='Aso Item Number']/../following-sibling::tr/td")
	public List<WebElement> ASO;

	@FindBy(xpath = "//*[text() = 'Contract Header']/ancestor::td/following-sibling::td//a[contains(text(), 'CH')]")
	public WebElement ContractHeaderNumber;

	@FindBy(xpath = "//*[@title='Work Order']")
	public WebElement work_Order_Result;

	@FindBy(xpath = "//img[@title='Work Order']")
	public WebElement work_Order_Header;

	@FindBy(xpath = "//iframe[@title='ESMX_Service_Order_Wizard_Lite']")
	public WebElement service_Flow_SFM;

	@FindBy(xpath = "//input[@value='Initiate Onsite']")
	public WebElement initiate_Onsite_SFM;

	@FindBy(xpath = "//input[@value='Initiate Travel']")
	public WebElement initiate_Travel_SFM;

	@FindBy(xpath = "//span[contains(text(),'Work Order')]/../following-sibling::td//a")
	public WebElement work_Order;

	@FindBy(xpath = "//input[contains(@name,'ESMX_Customer_Purchase_Order_Number__c')]")
	public WebElement enterponumber_lightning;

	@FindBy(xpath = "//span[text()='Automation Technician']")
	public WebElement service_Technician;

	@FindBy(xpath = "//div[text()='ES-CCHI']/../preceding-sibling::div//input")
	public WebElement select_Technician;

	@FindBy(xpath = "//div[text()='ES-CCHI']/../..//input[@type='radio']")
	public WebElement owner;

	@FindBy(xpath = "//input[@title='Upload IMU File']")
	public WebElement uploadIMUFile;

	@FindBy(xpath = "//*[text()='Product']/../../following-sibling::td//span/input")
	public WebElement product_input;

	@FindBy(xpath = "//*[text()='Quantity']/../../following-sibling::td//input")
	public WebElement product_quantity_input;

	@FindBy(xpath = "//span[text()='Permission Set Assignments']")
	public WebElement permissio_Set;
	
	@FindBy(xpath = "//*[text()='Covered Products']/../preceding-sibling::a//span[text()='Preventive Maintenance Plans']")
	public WebElement preventive_maintenance_plan;

	public boolean isRenamed = false;
	public boolean isFCOCALCreated = false;
	public boolean isCALImportSuccess = false;
	public boolean isUALImportSuccess = false;
	public boolean isImportSuccess = false;
	public boolean isFCOCreated = false;
	ArrayList<Map<String, String>> excelval;
	public static String pmurl;
	public static String sfmcurl;
	public String profileType;
	public static String ipurl;
	public static String CreatedWO;
	public static Map<String, String> equipmentNumbers = new HashMap<String, String>();
	public static String functionalNum;
	public static String accountNumber;
	public static String caseUrl;
	public static String url;
	public static String ContractHeader_url;
	public Map<String, String> geturlDetails = new HashMap<>();
	public static List<WebElement> links = null;
	public int numberOfDALWO;

	public BasePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void salesforceLogin() throws InterruptedException {
		String url = AutomationConstants.URL;
		driver.get(url);
	}
	public void crmHomePage() throws InterruptedException {
		String urlgoogle = AutomationConstants.URL;
		driver.get(urlgoogle);
	}
	public void asxHomePage() throws InterruptedException {
			String urlasx= AutomationConstants.URL;
			driver.get(urlasx);
		
	}
	@FindBy(xpath = "//iframe[@title='TrustArc Cookie Consent Manager']")
    private WebElement iframe_welcome_page;
 
    @FindBy(xpath = "//a[text()='Accept all']")
    private WebElement accept_all;
    
	@FindBy(xpath ="//div[@class='ph-headerarent__logindiv ']")
	public WebElement HyrbisLogin_Signup;
	
	@FindBy(xpath = "//input[@id='j_username']")
	public WebElement HybrisUserName;

	@FindBy(xpath = "//input[@id='j_password']")
	public WebElement HybrisUserPassword;

	@FindBy(xpath = "//div[@class='ph-pb-1 ph-action_container']//button[text()='Log in']")
	public WebElement HybrisLogin;

public void HybrisLogin() throws InterruptedException {
		String Hybrisurl = AutomationConstants.Hybris_URL;
		driver.get(Hybrisurl);
	}

public void enterHybrisCredentials(String userRole, WebDriver driver) {
		// TODO Auto-generated method stub
		driver.manage().deleteAllCookies();
		driver.switchTo().frame(iframe_welcome_page);
		click("Accept all", accept_all);
		waitTill("5");
        click("Click on Login", HyrbisLogin_Signup);
        waitTill("5");
		loggedinUserName = EnvironmentFactory.getConfigValue("Hybris User");
		UserName = EnvironmentFactory.getConfigValue("Hybris Username");
		password = Utility.decode(EnvironmentFactory.getConfigValue("HybrisPassword"));
		System.out.println("UserName:"+UserName);
		System.out.println("password:"+password);
		enter("User Name ", HybrisUserName, UserName);
		enter("Password ", HybrisUserPassword, password);
		click("login", HybrisLogin);
		waitTill("6");
	}



	
	public void clickonRelatedTab() {

		waitTill("5");
		click("Related", tab_related);
	}

	public void clickonDetailsTab() {

		waitTill("5");
		click("Details tab", tab_details);
	}

	public void clickonRelatedTab1() {
		click("Related", tab_related1);
	}

	public void golbalSearch(String searchTerm, String type) {

		click("Search Type", filter_Search);
		waitTill("5");
		WebElement searchtype = driver
				.findElement(By.xpath("//div[@id='dropdown-element-5']//ul[1]//span[@title='" + type + "']"));
		click("Search Type", searchtype);
		enter("Global Search", globalSearch, searchTerm);
		waitTill("5");
		// waitElementToDisappear(spinner_golbalSearch);
		WebElement searchResult = driver.findElement(By.xpath("//span[@title='" + searchTerm + "']"));
		waitForElement(searchResult, "Search Results");
		click(type, searchResult);

	}

	public void searchAndLaunchApp(String app) {
		waitForElement(app_Exchange, "app_Exchange");
		click("app_Exchange", app_Exchange);
		waitForElement(appExchangeSearchBox, "appExchangeSearch");
		enter("app Exchange Search", appExchangeSearchBox, app);
		waitForElement(appExchangeSearchResult, "app_Exchange result");

		try {

			String xpath = "//one-app-launcher-menu/div[@role='combobox']//a[@data-label='" + app + "']";
			waitForElement(appExchangeSearchResult, "appExchangeSearch");
			waitForElement(driver.findElement(By.xpath(xpath)), "appExchangeSearchResult");
			JavascriptExecutor executor = (JavascriptExecutor) driver;

			executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(xpath)));
		} catch (Exception e) {

		}
	}

	public void globalSearch(String value) {
		
		
		try {
			enter("Search", globalsearch, value);
			waitTill("5");
			click("Button", btn_Search);
		} catch (Exception e) {
			enter("Search", globalsearch1, value);
			waitTill("5");
			click("Button", btn_Search);
		}
		embedScreenShotInreport();

	}

	public void clickonAllTabs() {
		// TODO Auto-generated method stub
		Utility.highlightElement(driver, alltabs);
		embedScreenShotInreport();
		click("All Tabs", alltabs);
		waitTill("5");
		embedScreenShotInreport();
	}

	public void enterServicemaxCredentials(String userRole, WebDriver driver) {
		// TODO Auto-generated method stub
		driver.manage().deleteAllCookies();

		loggedinUserName = EnvironmentFactory.getConfigValue("Portal User");
		UserName = EnvironmentFactory.getConfigValue("Portal");
		password = Utility.decode(EnvironmentFactory.getConfigValue("PortalPassword"));
		System.out.println("UserName:" + UserName);
		System.out.println("password:" + password);

		// driver.get(AutomationConstants.servicePortalURL);
		enter("User Name ", portalUserName, UserName);
		enter("Password ", portalUserPassword, password);
		click("login", portalLogin);
		try {
			waitForElement(alreadyLoogedIn, "User Already Logged In");
			driver.findElement(By.xpath("//input[@class='btn FlowFinishBtn']")).click();
		} catch (Exception e) {
		}
		// WebElement okbtn =
		// driver.findElement(By.xpath("//button[@title='OK']"));
		// if(verifyElementPresent("Ok button", okbtn)) {
		// click("ok button", okbtn);}
		waitTill("6");

	}

	public void servicePortalLogin() {
		String url = AutomationConstants.servicePortalURL;
		driver.get(url);
		waitTill("5");
	}

	public void IPStageinSMAX(String status, String equ) throws Exception {
		System.out.println(equipmentNumbers);
		String value = SOQLQuerys.sapSyncStatus(equipmentNumbers.get(equ));

		if (value.equalsIgnoreCase(status)) {
			logReport("PASS", "Equipment status is " + value + " expected is " + status);
		} else {
			logReport("FAIL", "Equipment status is " + value + " expected is " + status);
			Assert.fail();
		}

	}

	public void search_GlobalsearchBox(String searchCriteria) {
		switch (searchCriteria) {
		case "AutoRenual_RenewedContract":
			searchCriteria = AutomationConstants.RUN_TIME_TEMP_DATA.get("AutoRenual_RenewedContract");
			break;

		case "Case":
			searchCriteria = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CASE_NUMBER");
			System.out.println(searchCriteria);
			break;

		case "InstalledProduct":
			searchCriteria = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("INSTALLED_PRODUCT");
			System.out.println(searchCriteria);
			break;
			
		case "<WarrantyTerms>":
			searchCriteria = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("Warranty_Terms");
			System.out.println(searchCriteria);
			break;

		case "<RiskSharingModel>":
			searchCriteria = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("RSM_NUMBER");
			System.out.println(searchCriteria);
			break;
		}
		if (Hooks.testcaseNumber.equals("738148")) {
			enter("search", globalSearchBox, BaseLib.TEST_DATA.get(0).get(searchCriteria));
			waitTill("6");
			click("globalSearchButton", globalSearchButton);
			waitTill("10");
		} else {
			waitForElement(globalSearchBox, searchCriteria);
			waitTill("10");
			enter("search", globalSearchBox, searchCriteria);
			waitTill("6");
			click("globalSearchButton", globalSearchButton);
			waitTill("10");
		}
		embedScreenShotInreport();
	}

	public void clickonAccount() {
		scrollByCordinates(0, 1000);
		waitForElement(accountlink, "Account link");
		click("Account link", accountlink);
	}

	public void getCHURL() throws Exception {
		waitTill("5");
		ContractHeader_url = driver.getCurrentUrl();
		System.out.println(ContractHeader_url);
		geturlDetails.put("ContractHeaderURL", ContractHeader_url);
		Excel.writeAgreementData(AutomationConstants.orderData, geturlDetails, "CHURL");
		logReport("INFO", "Url's are saved");
	}

	public void verify_profile_For_logged_user(String userole) {
		waitTill("3");
		click("User Menu", userMenu);
		waitTill("3");
		click("My Settings", my_Settings);
		waitTill("3");
		click("personal_Info", personal_Info);
		waitTill("3");
		click("advanced_User_details", advanced_User_details);
		waitTill("3");
		waitForElement(profile, "profile");
		embedScreenShotInreport();
		profileType = profile.getText();
		addScreenshoot("Screenshotlog");
		switch (userole) {
		case "Master Data Admin":
			if (profileType.contains(AutomationConstants.MASTER_DATA_ADMIN_PROFILE)) {
				logReport("INFO", "The User Profile is" + profileType);
				Assert.assertTrue(true, "The User Profile is" + profileType);
				System.out.println("profileType:" + profileType);
				embedScreenShotInreport();
				hoverTo_PermissionSet();
				embedScreenShotInreport();
				hoverTo_PermissionSet_Group();
				embedScreenShotInreport();
			} else {
				logReport("INFO", "The User Profile is" + profileType);
			}
			break;

		case "Service Agent":
			if (profileType.contains(AutomationConstants.SERVICE_AGENT)) {
				logReport("INFO", "The User Profile is" + profileType);
				Assert.assertTrue(true, "The User Profile is" + profileType);
				System.out.println("profileType:" + profileType);
				embedScreenShotInreport();
				hoverTo_PermissionSet();
				embedScreenShotInreport();
				hoverTo_PermissionSet_Group();
				embedScreenShotInreport();
				hoverTo_ssignedTerritory();
				embedScreenShotInreport();
			} else {
				logReport("INFO", "The User Profile is" + profileType);
			}
			break;

		case "Service Technician":
			if (profileType.contains(AutomationConstants.SERVICE_TECHNICIAN)) {
				logReport("INFO", "The User Profile is" + profileType);
				Assert.assertTrue(true, "The User Profile is" + profileType);
				System.out.println("profileType:" + profileType);
				embedScreenShotInreport();
				hoverTo_PermissionSet();
				embedScreenShotInreport();
				hoverTo_PermissionSet_Group();
				embedScreenShotInreport();
			} else {
				logReport("INFO", "The User Profile is" + profileType);
			}
			break;

		// M1028261 - ITOpsAdmin User
		case "ITOpAdmin":
			if (profileType.contains(AutomationConstants.IT_OP_ADMIN)) {
				logReport("INFO", "The User Profile is" + profileType);
				Assert.assertTrue(true, "The User Profile is" + profileType);
				System.out.println("profileType:" + profileType);
				embedScreenShotInreport();
				hoverTo_PermissionSet();
				embedScreenShotInreport();
				hoverTo_PermissionSet_Group();
				embedScreenShotInreport();
			} else {
				logReport("INFO", "The User Profile is" + profileType);
			}
		}
	}

	public void logOut() {
		closePrimaryTabs();
		waitTill("6");
		try {
			click("User Menu", userMenu);
		} catch (Exception e) {
		}
		try {
			driver.findElement(By.xpath("//span[@id='userNavLabel']")).click();
		} catch (Exception e) {
		}
		try {
			waitTill("5");
			click("Log Out of the application", logout);
		} catch (Exception e) {
		}
		try {
			driver.findElement(By.xpath("//a[@title='Logout']")).click();
		} catch (Exception e) {
		}
		waitTill("5");
	}

	public void closePrimaryTabs() {
		try {
			if (loggedinUserName.contains("HISS")) {
				click("close all tabs", primary_tab);
				click("close all primary tabs", close_primarytabs);
				waitTill("5");
				if (verifyElementPresent("Dont save", btn_dontsave)) {
					click("Dont save", btn_dontsave);
					waitTill("5");
				}
			}

		} catch (Exception e) {

		}

	}

	public void fetchAgreementUrlfromSheet(String sheetName) {
		excelval = Excel.getSheetData(AutomationConstants.orderData, sheetName);
		driver.get(excelval.get(0).get("SavedUrl"));
		pmurl = excelval.get(0).get("SavedUrl");
		waitTill("5");
	}

	public void CreateView(String[] FieldName, String[] Operator, String[] Value) {
		String EnterViewName = FieldName[0] + "Filter";
		waitTill("5");
		if (Utility.isOptionPresentinListBox(View, EnterViewName) == true) {
			WebListbyName("fcf", EnterViewName);
			click("Edit", EditView);
		} else {
			click("Create New View", CreateNewView);
		}
		waitTill("5");
		enter("View Name", ViewName, EnterViewName);

		if (driver.getTitle().equals(ViewUniqueName)) {
			enter("View Unique Name", ViewUniqueName, EnterViewName);
		}
		for (int j = 0; j < FieldName.length; j++) {
			WebListbyName("fcol" + (j + 1), FieldName[j]);
			WebListbyName("fop" + (j + 1), Operator[j]);
			System.out.println(Value[j]);
			String val = GetUserDetails(Value[j]);
			System.out.println(val);
			WebEditbyName("fval" + (j + 1), val);
		}
		embedScreenShotInreport();
		click("Save", Save);
		waitTill("5");
		// SwitchtoFramesByID("available");
		// WebListbyName("fcf", EnterViewName);
		// try {
		// WebElement Go = driver.findElement(By.name("go"));
		// Go.click();
		// } catch (NoSuchElementException e) {
		// log.debug("Unable to locate webelement." + e.toString());
		// }
		// waitTill("5");
		// driver.switchTo().defaultContent();
	}

	public String GetUserDetails(String userType) {
		String[] Users = new String[] { "ITOpAdmin", "ServiceAgent", "MasterDataAdmin", "ServiceTechnician" };
		for (int i = 0; i < Users.length; i++) {
			if (userType.equals(Users[i])) {
				System.out.println(userType + ", " + Users[i]);
				userType = EnvironmentFactory.getConfigValue(userType);
			}
		}
		return userType;
	}

	public void accessTab(String value) {
		try {
			click("All Tabs", alltabs);
			waitTill("5");
			WebElement element = driver.findElement(By.xpath("//img[@title = '" + value + "']"));
			click(value, element);
		} catch (Exception e) {
			System.out.println("User is not in classic view");
			Assert.fail();
		}
	}

	public void getURL() {
		url = driver.getCurrentUrl();
		System.out.println(url);
		logReport("INFO", "The URl is captured");
	}

	public void accessURL() {
		System.out.println(url);
		waitTill("15");
		driver.get(url);
		waitTill("15");
		logReport("INFO", "The url is fecthed");
	}

	public void closeTab() {
		driver.close();
		switchToTab(0);
	}

	public void selectFromSearchlist(String selectSearchItem) {
		switch (selectSearchItem) {
		case "quote":
			//AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("QUOTE_NUMBER","Q-00564064");
			String quoteNumber = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("QUOTE_NUMBER");
			search_GlobalsearchBox(quoteNumber);
			waitTill("15");
			driver.findElement(
					By.xpath(".//div[@id='SVMXC__Quote__c_body']//a[contains(text(), '" + quoteNumber + "')]")).click();

			break;
		case "childquote1":
			String childQuoteNumber1 = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CHILD_QUOTE_NUMBER1");
			search_GlobalsearchBox(childQuoteNumber1);
			waitTill("5");
			driver.findElement(
					By.xpath(".//div[@id='SVMXC__Quote__c_body']//a[contains(text(), '" + childQuoteNumber1 + "')]"))
					.click();

			break;
		case "case":
			String caseNumber = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CASE_NUMBER");
			search_GlobalsearchBox(caseNumber);
			waitTill("5");
			driver.findElement(By.xpath(".//div[@id='Case_body']//a[contains(text(),'" + caseNumber + "')]")).click();
			break;

		case "fco":
			String FCO_HEADER = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("FCO_HEADER");
			search_GlobalsearchBox(FCO_HEADER);
			if (verifyElementPresent("showMore_option", showMore_option)) {
				click("Show More", showMore_option);

			}
			click("Click", driver.findElement(By.xpath("//td[text()='" + FCO_HEADER + "']/preceding-sibling::th/a")));
			waitForElement(FCO_Created_Text, "FCO_Created_Text");
			break;

		case "location":
			String location = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("LOCATION");
			search_GlobalsearchBox(location);
			waitTill("5");
			click("Location", driver.findElement(
					By.xpath(".//div[@id='SVMXC__Site__c_body']//th/a[contains(text(), '" + location + "')]")));
			break;

		case "Work Order":
			String workOrder = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("WORK_ORDER_NUMBER");
			search_GlobalsearchBox(workOrder);
			driver.navigate().refresh();
			waitTill("60");
			click("Work Order", driver.findElement(By.xpath("//*[text()='" + workOrder + "']")));
			waitTill("40");
			click("Details", case_Details);
			break;

		case "Work Order1":
			String wo1 = null;
			if (Hooks.testcaseNumber == "440278") {
				AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("WORK_ORDER_NUMBER",
						TestData.get(0).get("WO1"));
				wo1 = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("WORK_ORDER_NUMBER");
			} else {
				wo1 = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("WORK_ORDER_NUMBER");
			}
			search_GlobalsearchBox(wo1);
			waitTill("5");
			click("Work Order1", driver.findElement(By.xpath("//*[text()='" + wo1 + "']")));
			click("Details", case_Details);
			break;
			
		case "Work Order2":
			AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("WORK_ORDER_NUMBER", TestData.get(0).get("WO2"));
			search_GlobalsearchBox(TestData.get(0).get("WO2"));
			waitTill("5");
			click("Work Order2", driver.findElement(By.xpath("//*[text()='" + TestData.get(0).get("WO2") + "']")));
			click("Details", case_Details);
			break;
			
		case "WarrantyTerms":
			String warrantyTerms = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("Warranty_Terms");
			search_GlobalsearchBox(warrantyTerms);
			waitTill("5");
			click("Warranty Terms", driver.findElement(By.xpath("//*[text()='" + warrantyTerms + "']")));
			break;
			
		default:
			String ip_XPathValue = selectSearchItem;
			search_GlobalsearchBox(ip_XPathValue);
			waitTill("6");
			embedScreenShotInreport();
			driver.findElement(By.xpath(
					".//div[@id='SVMXC__Installed_Product__c_body']//*/a[contains(text(), '" + ip_XPathValue + "')]"))
					.click();
			break;
		}
	}

	public void hoverTo_PermissionSet() {
		waitForElement(profile_PermissionSet_Link, "Dispaly Profile permission Set");
		hover(profile_PermissionSet_Link);
		waitTill("5");
	}

	public void hoverTo_PermissionSet_Group() {
		waitForElement(profile_PermissionSetGroup_Link, "Dispaly Profile permission Set Group");
		hover(profile_PermissionSetGroup_Link);
		waitTill("5");
	}

	public void hoverTo_ssignedTerritory() {

		waitForElement(assigned_territory, "Dispaly Profile permission Set Group");
		hover(assigned_territory);
		waitTill("5");
	}

	public void clickOnObject(String objectName) {
		waitTill("5");
		switch (objectName) {
		case "Technician":
			click("Technician/Equipment", objectTechnician);
			break;
		case "Vendors":
			click("Vendors", objectVendors);
			break;
		case "Incident Mass Uploads":
			scrollByViewOfElement(objectIncident_Mass_Upload);
			embedScreenShotInreport();
			click("Incident Mass Uploads", objectIncident_Mass_Upload);
			break;

		}
	}

	public void createRecord(String recordType) {
		switch (recordType) {
		case "Technician":

			Utility.highlightElement(driver, objectTechnician);
			embedScreenShotInreport();
			click("Technician", objectTechnician);

			Utility.highlightElement(driver, objectTechnician);
			embedScreenShotInreport();
			click("New", newButton);

			Utility.highlightElement(driver, newButton);
			embedScreenShotInreport();
			selectbyValue(newRecordType, "Technician", "Technician");

			embedScreenShotInreport();
			click("Continue", continueButton);
			embedScreenShotInreport();
			break;
		case "Vendor":

			int externalID = Utility.randomNumber(10);

			embedScreenShotInreport();
			click("Technician", objectVendors);

			//Utility.highlightElement(driver, objectTechnician);
			embedScreenShotInreport();
			click("New", newButton);

			//Utility.highlightElement(driver, newButton);
			embedScreenShotInreport();
			enter("Vendor Name", vendorName, "Vendor12");
			//Utility.highlightElement(driver, vendorName);
			embedScreenShotInreport();
			enter("Vendor SAP External ID", vendorExternalID, Integer.toString(externalID));
			embedScreenShotInreport();
			selectRandomValue(vendorSAPCurrency, "SAP Currency");
			//Utility.highlightElement(driver, vendorSAPCurrency);
			embedScreenShotInreport();
			selectRandomValue(vendorPurchaseOrganization, "Purchase Organization");
			//Utility.highlightElement(driver, vendorPurchaseOrganization);
			embedScreenShotInreport();
			selectRandomValue(vendorPuchaseGroup, "Purchase Group");
			//Utility.highlightElement(driver, vendorPuchaseGroup);
			embedScreenShotInreport();
			enter("Vendor Street", vendorStreet, "test123");
			//Utility.highlightElement(driver, vendorCity);
			embedScreenShotInreport();
			enter("Vendor City", vendorCity, "TestCity");
			Utility.highlightElement(driver, vendorCountry);
			embedScreenShotInreport();
			selectRandomValue(vendorCountry, "Vendor Country");
			embedScreenShotInreport();
			click("Save", saveTopButton);
			verifyElementPresent("Created By", createdBy);
			embedScreenShotInreport();
			break;
		}

	}

	public static void loadTestData(String sheet) {
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("SheetName", sheet);

		try {
			System.out.println("Loading Test Data..." + sheet);
			TestData = Excel.getSheetAndData(AutomationConstants.DataFilePath, sheet);
			TEST_DATA = Excel.getSheetAndData(AutomationConstants.DataFilePath, sheet);
		} catch (Exception e) {
		}
		while (TestData.isEmpty()) {
		}
		System.err.println("BaseLib.TEST_DATA:" + BaseLib.TEST_DATA.isEmpty());
	}

	@FindBy(xpath = ".//*[@id='Import_font']")
	public WebElement importBTN;

	@FindBy(xpath = ".//span[@id='DataImporter_font']")
	public WebElement data_Import_Wizard;

	@FindBy(xpath = "//a[text()='Launch Wizard!']")
	public WebElement launchWizard;

	@FindBy(xpath = "//a[text()='Custom objects']")
	public WebElement custom_Objects;

	@FindBy(xpath = "//a[text()='Field Change Orders']")
	public WebElement field_Change_Orders;

	@FindBy(xpath = "//a[text()='Add new records']")
	public WebElement add_New_Records;

	@FindBy(xpath = "//span[text()='Record type']/parent::div/following-sibling::div/select")
	public WebElement FCO_Record_Type;

	@FindBy(xpath = "//span[@class='csvType uiOutputText']")
	public WebElement csv_File;

	@FindBy(xpath = "//div[@class='selectFile']/form/input")
	public WebElement file_Upload;

	@FindBy(xpath = "//span[text()='Edit Field Mapping: Field Change Orders']")
	public WebElement edit_FCO_Fields;

	@FindBy(xpath = "//span[text()='Review your import information and click Start Import.']")
	public WebElement reviewImports;

	@FindBy(xpath = "//a[text()='Start Import']")
	public WebElement startImport;

	@FindBy(xpath = "//input[@value='Create UAL Case']")
	private WebElement createUALCase;

	@FindBy(xpath = "//a[text()='Show More']")
	public WebElement showMore_option;

	@FindBy(xpath = "//*[@title='Field Change Order']/following-sibling::*[text()='UAL']/ancestor::div[@class='pbHeader']/following-sibling::div//a/parent::th/following-sibling::td/a")
	public List<WebElement> UAL_Cases;

	@FindBy(xpath = "//input[@value='Create CAL Case']")
	private WebElement createCALCase;

	@FindBy(xpath = "//input[@value='Create CAL Work Orders']")
	private WebElement createCALWO;

	@FindBy(xpath = "//input[@value='Create DAL Case']")
	private WebElement createDALCase;

	@FindBy(xpath = "//input[@value='Create DAL Work Orders']")
	private WebElement createDALWO;

	@FindBy(xpath = "//*[@title='Field Change Order']/following-sibling::*[text()='CAL']/ancestor::div[@class='pbHeader']/following-sibling::div//a/parent::th/following-sibling::td/a")
	public List<WebElement> CAL_Cases;

	@FindBy(xpath = "//*[@title='Field Change Order']/following-sibling::*[text()='DAL']/ancestor::div[@class='pbHeader']/following-sibling::div//a/parent::th/following-sibling::td/a")
	public List<WebElement> DAL_Cases;

	@FindBy(xpath = "//input[@value='Create Distributor Parts Work Orders']")
	protected WebElement create_dist_parts_WO;

	@FindBy(xpath = "//input[@value='Create Parts']")
	protected WebElement create_parts;

	@FindBy(xpath = "//*[text()='Product']/../following-sibling::tr//a[text()='Edit']")
	protected List<WebElement> edit_created_parts;

	public void open_Data_Import_Wizard(String userole) {
		waitTill("5");
		click("User Menu", userMenu);
		click("Settings", my_Settings);
		click("data_Import_Wizard", importBTN);
		click("data_Import_Wizard", data_Import_Wizard);
		click("launchWizard", launchWizard);
		waitTill("5");
		embedScreenShotInreport();
	}

	public void Import_FCO_data_ServiceMax() {
		click("custom_Objects", custom_Objects);
		click("field_Change_Orders", field_Change_Orders);
		click("add_New_Records", add_New_Records);
		selectbyValue(FCO_Record_Type, "FCO Header", "FCO Header");
		click("csv_File", csv_File);
		embedScreenShotInreport();
		selectFileToUpload(file_Upload, AutomationConstants.FCODataFilePath);
		waitTill("6");
		waitForElement(nextButton, "nextBTN");
		click("nextBTN", nextButton);
		waitForElement(edit_FCO_Fields, "edit_FCO_Fields");
		click("nextBTN", nextButton);
		waitForElement(reviewImports, "reviewImports");
		embedScreenShotInreport();
		click("startImport", startImport);
		waitTill("6");
		if (congrats.getText().contains("your import has started")) {
			click("ok", ok);
			isImportSuccess = true;
		}
		waitTill("60");// Wait for FCO to imported
	}

	public void verify_Import_FCO_data_ServiceMax() {
		long start = System.currentTimeMillis();
		long waitDuration = (long) Double.parseDouble("500");
		List<String[]> FCO_CAL_Data = new ArrayList<String[]>();
		FCO_CAL_Data = CSVFileReader.readDataLineByLine(AutomationConstants.FCODataFilePath);
		String[] one = FCO_CAL_Data.get(1);
		String FCO_HEADER = one[0];
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("FCO_HEADER", FCO_HEADER);
		if (isImportSuccess) {
			while (!isFCOCreated) {
				search_GlobalsearchBox(FCO_HEADER);
				waitForElement(FCO_Created_Text, "FCO_Created_Text");
				try {
					driver.findElement(By.xpath("//td[text()='" + FCO_HEADER + "']/preceding-sibling::th/a")).click();
					isFCOCreated = true;
					waitTill("100");
				} catch (Exception e) {

					if (!waitUntil(start, waitDuration))
						;
				}
			}
		}
	}

	public void save_Update_FCO_Header_Details() {
		waitForElement(FCO_Name, "FCO_Name");
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("FCO_NAME", FCO_Name.getText());
		String[] format = FCO_Record_Id.getAttribute("id").split("_");
		System.out.println("FCO_RECORD_IDFCO_RECORD_ID:" + format[0]);
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("FCO_RECORD_ID", format[0]);
		hover(FCO_Lifecycle_Status);
		doubleClick(FCO_Lifecycle_Status);
		selectbyValue(FCO_Lifecycle_status_Select, "Released / In Progress", "Released / In Progress");
		embedScreenShotInreport();
		waitTill("5");
		hover(FCO_Release_Date);
		doubleClick(FCO_Release_Date);
		enter("FCO_Release_Date_Select", FCO_Release_Date_Select, "12-Mar-2018");
		waitTill("5");
		hover(Delivery_Method);
		doubleClick(Delivery_Method);
		waitTill("5");
		selectbyValue(Delivery_Method_Select, "Onsite", "Onsite");
		waitTill("5");
		embedScreenShotInreport();
		hover(FCO_Global_Due_Date);
		doubleClick(FCO_Global_Due_Date);
		enter("FCO_Global_Due_Date_Select", FCO_Global_Due_Date_Select, "12-Mar-2022");
		waitTill("5");
		click("save_FCO", save_FCO);
		embedScreenShotInreport();
	}

	public void save_FCO_Header_Details_File(String recordType) {

		List<String[]> FCO_Data = new ArrayList<String[]>();
		switch (recordType) {
		case "CAL":
			FCO_Data = CSVFileReader.readDataLineByLine(AutomationConstants.FCOCALDataFilePath);
			break;
		case "UAL":
			if (Hooks.testcaseNumber.equals("737463")) {
				FCO_Data = CSVFileReader.readDataLineByLine(AutomationConstants.FCOUALFilePath_737463);
			} else {

				FCO_Data = CSVFileReader.readDataLineByLine(AutomationConstants.FCOUALDataFilePath);
			}
			break;
		}
		System.out.println("FCO_Data:" + FCO_Data.size());
		System.out.println("FCO Number:" + AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("FCO_HEADER"));
		System.out
				.println("FCO_RECORD_ID:" + AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("FCO_RECORD_ID"));
		for (int i = 1; i < FCO_Data.size(); i++) {
			String[] one = FCO_Data.get(i);
			System.out.println("one.length:" + one.length);
			for (int j = 0; j < one.length; j++) {
				one[(one.length) - 1] = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("FCO_HEADER") + "_"
						+ Utility.randomNumber(50);
				one[(one.length) - 2] = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("FCO_RECORD_ID");
			}
		}
		switch (recordType) {
		case "CAL":
			CSVFileReader.writeDataAtOnce(AutomationConstants.FCOCALDataFilePath, FCO_Data);
			break;
		case "UAL":
			if (Hooks.testcaseNumber.equals("737463")) {
				CSVFileReader.writeDataAtOnce(AutomationConstants.FCOUALFilePath_737463, FCO_Data);
			} else {

				CSVFileReader.writeDataAtOnce(AutomationConstants.FCOUALDataFilePath, FCO_Data);
			}
			CSVFileReader.writeDataAtOnce(AutomationConstants.FCOUALDataFilePath, FCO_Data);
			break;
		}
	}

	public void create_CAL_DAL_case(String recordType) {

		waitForElement(FCO_Created_Text, "FCO_Created_Text");
		switch (recordType) {
		case "UAL":
			String FCO_HEADER = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("FCO_HEADER");
			search_GlobalsearchBox(FCO_HEADER);
			click("Click", driver.findElement(By.xpath("//td[text()='" + FCO_HEADER + "']/preceding-sibling::th/a")));
			waitForElement(FCO_Created_Text, "FCO_Created_Text");
			waitForElement(createUALCase, "createUALCase");
			click("createUALCase", createUALCase);
			waitTill("6");
			if (isAlertPresent()) {
				driver.switchTo().alert().accept();
			}
			boolean isFCOUALCASECreated = false;
			long start3 = System.currentTimeMillis();
			long waitDuration3 = (long) Double.parseDouble("300");
			waitTill("5");
			try {
				while (!isFCOUALCASECreated) {
					driver.navigate().refresh();
					waitTill("5");
					if (UAL_Cases.size() >= 1) {

						isFCOUALCASECreated = true;
					}
					waitTill("100");
				}
			} catch (Exception e) {
				if (!waitUntil(start3, waitDuration3))
					;
			}
			break;
		case "CAL":
			driver.navigate().refresh();
			driver.navigate().refresh();
			click("createCALCase", createCALCase);
			waitTill("6");
			if (isAlertPresent()) {
				driver.switchTo().alert().accept();
			}
			boolean isFCOCALCaseCreated = false;
			long start = System.currentTimeMillis();
			long waitDuration = (long) Double.parseDouble("300");
			waitTill("5");
			try {
				while (!isFCOCALCaseCreated) {
					driver.navigate().refresh();
					waitTill("5");
					if (CAL_Cases.size() >= 1) {

						// AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("FCO_CASE_NUMBER",
						// FCO_Case.getText());
						isFCOCALCaseCreated = true;
					}
					waitTill("200");
				}
			} catch (Exception e) {
				if (!waitUntil(start, waitDuration))
					;
			}

			break;
		case "DAL":
			click("createDALCase", createDALCase);
			waitTill("6");
			embedScreenShotInreport();
			if (isAlertPresent()) {
				driver.switchTo().alert().accept();
			}
			boolean isFCODALCaseCreated = false;
			long start2 = System.currentTimeMillis();
			long waitDuration2 = (long) Double.parseDouble("300");
			waitTill("5");
			try {
				while (!isFCODALCaseCreated) {
					driver.navigate().refresh();
					waitTill("5");
					if (DAL_Cases.size() >= 1) {

						// AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("FCO_CASE_NUMBER",
						// FCO_Case.getText());
						isFCODALCaseCreated = true;
						scrollByViewOfElement(DAL_Cases.get(0));
						embedScreenShotInreport();
					}
					waitTill("200");
				}
			} catch (Exception e) {
				if (!waitUntil(start2, waitDuration2))
					;
			}
			break;
		}
		driver.navigate().refresh();
		driver.navigate().refresh();
	}

	public void createUALWorkOrder_forAllUAL() {
		// TODO Auto-generated method stub
		waitForElement(createUALWorkOrder_button, "Create UAL Work Order Button");
		click("Create UAL Work Order", createUALWorkOrder_button);
		waitTill("5");
		driver.switchTo().alert().accept();
		waitTill("5");
		driver.switchTo().alert().accept();
		waitTill("5");
		driver.navigate().refresh();
	}

	public void capture_WorkOrderNumber() {
		waitForElement(createdUALcase_1stLine, "UAL Case");
		click("UAL Case", createdUALcase_1stLine);
		waitForElement(caseDetailsPage_header, "Page Header");
		click("Details", detailsTab);
		waitForElement(workOrderNumber_data, "Work Order Number");
		scrollByViewOfElement(workOrderNumber_data);
		AutomationConstants.RUN_TIME_TEMP_DATA.put("WorkOrder_No", workOrderNumber_data.getText());
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("WORK_ORDER_NUMBER", workOrderNumber_data.getText());
		logReport("INFO", "Work Order No:" + workOrderNumber_data.getText());
	}

	public void verifyFCOHeaderFields() {
		String FCO_HEADER = TestData.get(0).get("FCONumber");
		search_GlobalsearchBox(FCO_HEADER);
		click("Click on FCO",
				driver.findElement(By.xpath("//td[text()='" + FCO_HEADER + "']/preceding-sibling::th/a")));
		waitForElement(fcoReleaseDate, "fcoReleaseDate");

		// verifyBooleanStatus(fcoLifecycleStatus.getText(), "Pre-Release");
		verifyIsEditable(fcoBG, fcoBGInput, "US");
		verifyIsEditable(fcoBU, fcoBUInput, "US");
		verifyIsEditable(fcoReleaseDate, fcoReleaseDateInput, "01-Jan-2021");
		verifyIsEditable(fcoGlobalDueDate, fcoGlobalDueDateInput, "01-Jan-2021");
		verifyIsEditable(fcoUALAuthor, fcoUALAuthorInput, "TestUser");
		verifyIsNotEditable(fcoTitle, fcoTitleInput, "Update Title");
		verifyIsNotEditable(fcoNumber, fcoNumberInput, "Update FCO Number");
		click("Cancel", cancelButton);

	}

	public void cascadeFields() {
		doubleClick("fcoGlobalDueDate", fcoGlobalDueDate);
		enter("Global Due Date", fcoGlobalDueDateInput, TestData.get(0).get("FCO Global Due Date"));
		doubleClick("fcoDeliveryMethod", fcoDeliveryMethod);
		selectbyValue(fcoDeliveryMethodInput, TestData.get(0).get("Delivery Method"), "Delivery Method");
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
	}

	public void create_cal_dal() {
		String FCO_HEADER = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("FCO_HEADER");
		search_GlobalsearchBox(FCO_HEADER);
		if (verifyElementPresent("showMore_option", showMore_option)) {
			click("Show More", showMore_option);

		}
		click("Click on FCO",
				driver.findElement(By.xpath("//td[text()='" + FCO_HEADER + "']/preceding-sibling::th/a")));
		waitForElement(fcoReleaseDate, "fcoReleaseDate");
		click("Create CAL/DAL", createCALDAL);
		waitTill("6");
		embedScreenShotInreport();
		if (isAlertPresent()) {
			driver.switchTo().alert().accept();
		}
		boolean isCalDalcreated = false;
		long start = System.currentTimeMillis();
		long waitDuration = (long) Double.parseDouble("300");
		waitTill("5");
		try {
			while (!isCalDalcreated) {
				driver.navigate().refresh();
				waitTill("5");

				if (calRecords.size() >= 1) {

					isCalDalcreated = true;
					scrollByViewOfElement(calRecords.get(0));
					embedScreenShotInreport();
				}
				waitTill("100");
			}
		} catch (Exception e) {
			if (!waitUntil(start, waitDuration))
				;
		}

	}

	public void create_CAL_DAL_WO(String recordType) {
		driver.navigate().refresh();
		driver.navigate().refresh();
		switch (recordType) {
		case "UAL":
			waitForElement(createUALWO, "createUALWO");
			click("createUALWO", createUALWO);
			waitTill("6");
			if (isAlertPresent()) {
				driver.switchTo().alert().accept();
			}
			boolean isFCOUALWOCreated = false;
			long start3 = System.currentTimeMillis();
			long waitDuration3 = (long) Double.parseDouble("300");
			waitTill("5");
			try {
				while (!isFCOUALWOCreated) {
					driver.navigate().refresh();
					waitTill("5");
					if (UAL_WOs.size() >= 1) {

						isFCOUALWOCreated = true;
					}
					waitTill("100");
				}
			} catch (Exception e) {
				if (!waitUntil(start3, waitDuration3))
					;
			}
		case "CAL":
			click("createCALWO", createCALWO);
			waitTill("6");
			driver.switchTo().alert().accept();
			boolean isFCOCALWOCreated = false;
			long start = System.currentTimeMillis();
			long waitDuration = (long) Double.parseDouble("300");
			waitTill("5");
			try {
				while (!isFCOCALWOCreated) {
					driver.navigate().refresh();
					waitTill("5");
					if (CAL_WOs.size() >= 1) {

						// AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("FCO_CASE_NUMBER",
						// FCO_Case.getText());
						isFCOCALWOCreated = true;
					}
					waitTill("200");
				}
			} catch (Exception e) {
				if (!waitUntil(start, waitDuration))
					;
			}

			break;
		case "DAL":
			click("createDALWOs", createDALWO);
			waitTill("6");
			if (isAlertPresent()) {
				driver.switchTo().alert().accept();
			}
			boolean isFCODALWOCreated = false;
			long start2 = System.currentTimeMillis();
			long waitDuration2 = (long) Double.parseDouble("300");
			waitTill("5");
			try {
				while (!isFCODALWOCreated) {
					driver.navigate().refresh();
					waitTill("5");
					if (DAL_WOs.size() >= 1) {

						// AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("FCO_CASE_NUMBER",
						// FCO_Case.getText());
						isFCODALWOCreated = true;
						scrollByViewOfElement(DAL_WOs.get(0));
						embedScreenShotInreport();
					}
					waitTill("200");
				}
			} catch (Exception e) {
				if (!waitUntil(start2, waitDuration2))
					;
			}
			break;
		}
		driver.navigate().refresh();
		driver.navigate().refresh();
		numberOfDALWO = DAL_WOs.size();

	}

	public void createMaterialOnlyWorkOrder() {
		// TODO Auto-generated method stub
		waitTill("5");
		driver.navigate().refresh();
		waitTill("30");
		driver.switchTo().frame(manage_WorkOrder_Frame);

		waitTill("5");
		waitForElementToEnable(createMaterialWorkOrder);
		click("createMaterialWorkOrder", createMaterialWorkOrder);
		waitTill("6");
		click("saveWO", save_Work_Order_Lines);
		waitTill("15");
		AutomationConstants.SERVICE_CONSULTENCY_CONTRACT_DATA.put("WORK_ORDER_NUMBER", workorder_Number.getText());
		String WorkOrderNumber = AutomationConstants.SERVICE_CONSULTENCY_CONTRACT_DATA.get("WORK_ORDER_NUMBER");
		System.out.print(WorkOrderNumber);
	}

	public void InitiateService() {
		waitTill("5");
		click("Details", detailstab);
		waitTill("5");
		driver.switchTo().frame(InitiateServiceFrameWork);
		waitTill("5");
		waitForElementToEnable(InitiateService);
		click("InitiateService", InitiateService);
		waitTill("30");
		driver.navigate().refresh();
		waitTill("30");
		driver.navigate().refresh();
		waitTill("30");
	}

	public void Open_Element(String element) {
		waitForElement(searchResult, "search Result");
		waitTill("5");
		driver.findElement(By.xpath("//a[text()='" + element + "']")).click();
		waitTill("5");
	}
	
	public void Open_PMPlan(String element) {
		hover(preventive_maintenance_plan);
		click("click", driver.findElement(By.xpath("//a[contains(text(), '" + element + "')]")));
		waitTill("5");
	}

	public void Import_FCO_CAL_data_ServiceMax() {
		click("custom_Objects", custom_Objects);
		click("field_Change_Orders", field_Change_Orders);
		click("add_New_Records", add_New_Records);
		// selectbyValue(match_By,"UniqueIdentifier (External
		// ID)","UniqueIdentifier (External ID)");
		selectbyValue(FCO_UAL_LookupField, "Salesforce.com ID", "Salesforce.com ID");
		selectbyValue(FCO_Record_Type, "CAL Lines", "CAL Lines");
		click("csv_File", csv_File);
		selectFileToUpload(file_Upload, AutomationConstants.FCOCALDataFilePath);
		waitTill("6");
		embedScreenShotInreport();
		click("nextBTN", nextButton);
		waitForElement(edit_FCO_Fields, "edit_FCO_Fields");
		try {
			waitForElement(errorText, "errorText");
			click("errorOK", errorOK);
		} catch (Exception e) {
		}
		click("nextBTN", nextButton);
		waitForElement(reviewImports, "reviewImports");
		embedScreenShotInreport();
		click("startImport", startImport);
		waitTill("6");
		if (congrats.getText().contains("your import has started")) {
			click("ok", ok);
			isCALImportSuccess = true;
		}
		waitTill("60");// Wait for FCO to imported
	}

	public void Import_FCO_UAL_data_ServiceMax() {
		click("custom_Objects", custom_Objects);
		click("field_Change_Orders", field_Change_Orders);
		click("add_New_Records", add_New_Records);
		selectbyValue(match_By, "UniqueIdentifier (External ID)", "UniqueIdentifier (External ID)");
		selectbyValue(FCO_UAL_LookupField, "Salesforce.com ID", "Salesforce.com ID");
		selectbyValue(FCO_Record_Type, "UAL Lines", "UAL Lines");
		click("csv_File", csv_File);
		embedScreenShotInreport();
		if (Hooks.testcaseNumber.equals("737463")) {
			selectFileToUpload(file_Upload, AutomationConstants.FCOUALFilePath_737463);
		} else {
			selectFileToUpload(file_Upload, AutomationConstants.FCOUALDataFilePath);
		}
		waitTill("6");
		click("nextBTN", nextButton);
		waitForElement(edit_FCO_Fields, "edit_FCO_Fields");
		try {
			waitForElement(errorText, "errorText");
			click("errorOK", errorOK);
		} catch (Exception e) {
		}
		click("nextBTN", nextButton);
		waitForElement(reviewImports, "reviewImports");
		click("startImport", startImport);
		waitTill("6");
		if (congrats.getText().contains("your import has started")) {
			embedScreenShotInreport();
			click("ok", ok);

			isUALImportSuccess = true;
		}
		waitTill("60");// Wait for FCO to imported

	}

	public void verify_Import_FCO_CAL_data_ServiceMax() {
		String FCO_HEADER = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("FCO_HEADER");
		String FCO_NAME = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("FCO_NAME");
		search_GlobalsearchBox(FCO_HEADER);
		click("Click", driver.findElement(By.xpath("//td[text()='" + FCO_HEADER + "']/preceding-sibling::th/a")));
		waitForElement(FCO_Created_Text, "FCO_Created_Text");
		System.out.println("TAN:FCO_HEADER:" + FCO_HEADER);
		System.out.println("TAN:FCO_NAME:" + FCO_NAME);
		long start = System.currentTimeMillis();
		long waitDuration = (long) Double.parseDouble("500");
		System.err.println("isCALImportSuccess:" + isCALImportSuccess);
		System.err.println("isFCOCALCreated:" + isFCOCALCreated);
		int index = 0;
		if (isCALImportSuccess) {
			while (!isFCOCALCreated && index < 3) {
				try {
					waitTill("5");
					if (driver
							.findElement(By
									.xpath("//*[@title='Field Change Order']/following-sibling::*[text()='CAL']/ancestor::div[@class='pbHeader']/following-sibling::div//a"))
							.isDisplayed())
						;

					isFCOCALCreated = true;
					System.err.println("isFCOCALCreated in if call:" + isFCOCALCreated);
					waitTill("100");
					driver.navigate().refresh();
				} catch (Exception e) {
					if (!waitUntil(start, waitDuration)) {
						if (index == 0) {
							index = 1;
						} else if (index == 1) {
							index = 2;
						} else
							index = 3;
					}
				}
			}
		}
	}

	public void create_FCO_Case() {
		waitForElement(createCase, "createCase");
		click("createCase", createCase);
		waitTill("10");
		embedScreenShotInreport();
		driver.switchTo().alert().accept();
		boolean isFCOCASECreated = false;
		long start = System.currentTimeMillis();
		long waitDuration = (long) Double.parseDouble("300");
		waitTill("5");
		try {
			while (!isFCOCASECreated) {
				driver.navigate().refresh();
				waitTill("5");
				if (FCO_Case.isDisplayed()) {

					AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("FCO_CASE_NUMBER", FCO_Case.getText());
					isFCOCASECreated = true;
				}
				waitTill("100");
			}
		} catch (Exception e) {
			if (!waitUntil(start, waitDuration))
				;
		}
	}

	public void create_FCO_Work_Orders() {
		String FCO_HEADER = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("FCO_HEADER");
		search_GlobalsearchBox(FCO_HEADER);
		click("Click", driver.findElement(By.xpath("//td[text()='" + FCO_HEADER + "']/preceding-sibling::th/a")));
		waitForElement(FCO_Created_Text, "FCO_Created_Text");
		waitForElement(createWorkOrders, "createWorkOrders");
		click("createWorkOrders", createWorkOrders);
		waitTill("6");
		embedScreenShotInreport();
		driver.switchTo().alert().accept();
		boolean isFCOCASECreated = false;
		long start = System.currentTimeMillis();
		long waitDuration = (long) Double.parseDouble("300");
		waitTill("5");
		try {
			while (!isFCOCASECreated) {
				driver.navigate().refresh();
				waitTill("5");
				if (isFCO_Work_Order_Created.isDisplayed()) {
					embedScreenShotInreport();
					isFCOCASECreated = true;
				}
				waitTill("100");
			}
		} catch (Exception e) {
			if (!waitUntil(start, waitDuration))
				;
		}
	}

	public void verify_FCO_Work_Orders() {
		waitTill("5");
		click("Click Case", FCO_Case);
		waitForElement(detailsTab, "createWorkOrders");
		click("case_Details", detailsTab);
		embedScreenShotInreport();
		new WorkOrderPage(driver).verify_FCO_WorkOrder_Line_Item();
	}

	public void Initiate_FCO_Work_Order() {
		String FCO_HEADER = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("FCO_HEADER");
		search_GlobalsearchBox(FCO_HEADER);
		click("Click", driver.findElement(By.xpath("//td[text()='" + FCO_HEADER + "']/preceding-sibling::th/a")));
		waitForElement(FCO_Created_Text, "FCO_Created_Text");
		click("Click Case", FCO_Case);
		waitForElement(detailsTab, "createWorkOrders");
		click("case_Details", detailsTab);
		embedScreenShotInreport();
		new WorkOrderPage(driver).Initiate_FCO_Work_Order();
	}

	public void Open_Parts() {
		waitTill("6");
		waitForElement(OpenPartsReturnable, "OpenPartsReturnable");
		OpenPartsReturnable.click();
		System.out.println("Open labour and parts seleced");
		waitTill("5");

		List<WebElement> listwebelement = driver
				.findElements(By.xpath("//table[@class='svmx-grid-table svmx-grid-table-resizer']//following::img"));
		int i = 0;
		for (WebElement Element : listwebelement) {
			i = i + 1;
			System.out.println("i value is = " + i);
			driver.findElement(
					By.xpath("//table[@class='svmx-grid-table svmx-grid-table-resizer']//following::img[" + i + "]"))
					.click();
			waitTill("5");
			PartStatusDropdown.click();
			waitTill("5");
			driver.findElement(By.xpath("//li[contains(text(),'Unused')]")).click(); // li[contains(text(),
			// 'Consumed')]
			waitTill("5");
			lineStatusDropdown.click();
			driver.findElement(By.xpath("//li[contains(text(),'Confirmed')]")).click();
			waitTill("5");
			Defectivepart.click();
			driver.findElement(By.xpath("//li[contains(text(),'GOOD-SEALED')]")).click();
			waitTill("5");
			waitForElement(TrackingNumber, "TrackingNumber");
			TrackingNumber.sendKeys("36373");
			waitForElement(DefectivePartNumber, "DefectivePartNumber");
			DefectivePartNumber.sendKeys("673839");
			waitForElement(DefectiveSerialNumber, "DefectiveSerialNumber");
			DefectiveSerialNumber.sendKeys("747389");
			waitForElement(DefectiveBatchControlNumber, "DefectiveBatchControlNumber");
			DefectiveBatchControlNumber.sendKeys("6472829");
			waitForElement(DefectivePartUDI, "DefectivePartUDI");
			DefectivePartUDI.sendKeys("32426384");
			Select.click();
			waitForElement(DefectivePartInformation, "DefectivePartInformation");
			DefectivePartInformation.sendKeys("this is an test defective part");
			waitForElement(RMLNumber, "RMLNumber");
			RMLNumber.sendKeys("R379740601");
			waitForElement(ReturnTrackingNumber, "ReturnTrackingNumber");
			ReturnTrackingNumber.sendKeys("987654321");
			ToolsIndicator.click();
			IPstructure.click();

			waitTill("5");
			driver.findElement(By.xpath("//span[text()='Update']")).click();

		}
	}

	public void Open_Parts_Nonreturnable(String rml) {
		waitForElement(OpenPartsNonReturnable, "OpenPartsNonReturnable");
		OpenPartsNonReturnable.click();
		System.out.println("Open labour and parts seleced");
		waitTill("6");

		List<WebElement> listwebelements = driver
				.findElements(By.xpath("//table[@class='svmx-grid-table svmx-grid-table-resizer']//following::img"));
		int i = 0;
		for (WebElement Element : listwebelements) {
			i = i + 1;
			if (i == 1) {
				i = i + 1;
				System.out.println("i 2 value is = " + i);
			}
			try {
				driver.findElement(By
						.xpath("//table[@class='svmx-grid-table svmx-grid-table-resizer']//following::img[" + i + "]"))
						.click();
			} catch (Exception e) {
				driver.findElement(
						By.xpath("//table[@class='svmx-grid-table svmx-grid-table-resizer']//following::img")).click();
			}
			waitTill("5");
			PartStatusDropdown.click();
			waitTill("5");
			driver.findElement(By.xpath("//li[contains(text(),'Consumed')]")).click(); // li[contains(text(),
			// 'Consumed')]
			waitTill("5");
			lineStatusDropdown.click();
			driver.findElement(By.xpath("//li[contains(text(),'Confirmed')]")).click();
			waitTill("5");
			Defectivepart.click();
			driver.findElement(By.xpath("//li[contains(text(),'DEFECTIVE PART')]")).click();
			waitTill("5");
			waitForElement(TrackingNumber, "TrackingNumber");
			TrackingNumber.sendKeys("36373");
			waitForElement(DefectivePartInformation, "DefectivePartInformation");
			DefectivePartInformation.sendKeys("this is an test defective part");
			waitForElement(RMLNumber, "RMLNumber");
			RMLNumber.sendKeys(rml);

			waitTill("5");
			driver.findElement(By.xpath("//span[text()='Update']")).click();
			waitTill("5");
		}

		waitForElement(save_Work_Order_Lines, "SaveLabor");
		save_Work_Order_Lines.click();
		waitTill("5");
	}

	public void SAP_Verification(String element) {
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("WO For SAP integration", element);
	}

	@FindBy(xpath = "//a[contains(text(), 'Create Bench Receipt')]")
	public WebElement createBenchReceipt;

	@FindBy(xpath = "//button[@data-qtip='Save']")
	public WebElement create_Bench_Repair_Case_SaveButton;

	@FindBy(xpath = "//*[text()='Bench Status Tracker Number']/../following-sibling::tr/td[contains(@class,'dataCell')]")
	public WebElement bench_Repair_Status;

	@FindBy(xpath = "//*[contains(@class, 'svmx-grid-cell svmx-grid-cell-gridcolumn-1062')]//div[@class='svmx-grid-cell-inner ']")
	public WebElement bench_Repair_Status_Time;

	public void click_Create_Bench_Receipt() {
		click("Home", homeTab);
		click("Create Bench Receipt", createBenchReceipt);
		waitForElement(create_Bench_Repair_Case_SaveButton, "Save");
		new ServiceMaxBenchStatusTrackerPage(driver).click_Create_Bench_Repaire_status();
	}

	public void verify_Bench_Repair_Status(String bnchRprStatus) {
		waitTill("5");
		waitForElement(create_Bench_Repair_Case_SaveButton, "Save");

		scrollByViewOfElement(bench_Repair_Status);
		highlightElement(driver, bench_Repair_Status, "1");
		Assert.assertEquals(bench_Repair_Status.getText(), bnchRprStatus);
		logReport("PASS", "Bench Repair STatus Verified Successfully");
		// click("Save", create_Bench_Repair_Case_SaveButton);
	}

	public void open_workOrder_from_GlobalSearchResult(String str) {
		String workOrderNo_XPathValue = str;
		// waitForElement(workOrder_searchList, "Work Order Search Result");
		waitTill("10");
		try {
			driver.findElement(
					By.xpath("//*[@class= ' dataCell  ']//*[contains(text(), '" + workOrderNo_XPathValue + "')]"))
					.click();
		} catch (Exception e) {
			driver.findElement(By.xpath("//input[@id='secondSearchButton' and @value='Search Again']")).click();
			driver.findElement(By.xpath("//a[text()='" + workOrderNo_XPathValue + "']")).click();
		}
		WorkOrderPage wop = new WorkOrderPage(driver);
		waitTill("5");
		if (verifyElementPresent("Case Details", case_Details)) {
			click("Case details", case_Details);
		}
		try {
			waitTill("5");
			hover(Acknowledge);
			doubleClick(Acknowledge);
			click("Ack_checkbox", Ack_checkbox);
			waitTill("5");
			click("save_FCO", save_FCO);
			waitTill("5");
		} catch (Exception e) {
		}

		embedScreenShotInreport();
	}

	public void toggle_between_FeedAndDetails_WorkOrderPage(String FeedOrDetails) {
		waitForElement(toggleTo_Details, "Details Tab");
		if (FeedOrDetails.equalsIgnoreCase("Feed"))
			click("Feed", toggleTo_Feed);
		else
			click("Details", toggleTo_Details);
	}

	public void verify_FCO_UAL_Work_Orders() {
		waitTill("5");
		click("Click Case", FCO_UAL_Case);
		waitForElement(detailsTab, "createWorkOrders");
		click("case_Details", detailsTab);
		waitTill("5");
		embedScreenShotInreport();
		new WorkOrderPage(driver).verify_FCO_WorkOrder_Line_Item();
	}

	public void createIncidentCase(String arg) {
		waitTill("5");
		driver.findElement(By.xpath(
				"//a[text()='Installed Product ID']/../../following-sibling::*//a[contains(text(),'" + arg + "')]"))
				.click();
		System.out.print("CaseName");
		waitForElement(installed_product_custom_Action_frame, "installed_product_custom_Action_frame");
		driver.navigate().refresh();
		waitTill("5");
		driver.switchTo().frame(installed_product_custom_Action_frame);
		waitTill("5");
		clickEvent(create_Case_SFM);
		waitLoadingSpinnerToDisappear();
		waitForElement(creat_Case_dialog, "creat_Case_dialog");

		click("Contact search Id", contactID_SearchBtn);
		waitLoadingSpinnerToDisappear();
		waitForElement(contact_ID_fullname, "contact_ID_fullname");
		click("contact_ID_fullname", contact_ID_fullname);
		click("select_Contact_id_fullname", select_Contact_id_fullname);
		click("eventType_dropdown", eventType_dropdown);
		// driver.findElement(By.xpath("//li[text()='Supplementary
		// Services']")).click();
		driver.findElement(By.xpath("//li[text()='Incident']")).click();
		waitTill("5");
		// click("eventSubType_dropdown",eventSubType_dropdown);
		// driver.findElement(By.xpath("//li[text()='Service
		// Request']")).click();
		/// driver.findElement(By.xpath("//li[text()='Incident']")).click();

		// selectbyValue(eventSubType_dropdown,"Incident","Incident");
		click("priority_Dropdown", priority_Dropdown);
		click("priority_Value", priority_Value);
		enter("Subject", subject, "Test");
		enter("description", desc, "Test Data");
		click("save_case", save_case);
		waitLoadingSpinnerToDisappear();
		// span[text()='Details']
		click("Details", detailsTab);
		waitTill("5");
		click("case_Details", case_Details);
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("CASE_NUMBER", case_Number.getText());
		waitTill("5");
		driver.switchTo().frame(manage_WorkOrder_Frame);
		click("safety_Questions", safety_Questions);
		waitForElement(safety_Questionair_Dialog, "safety_Questionair_Dialog");
		int index = 1, pointer = 0;
		while (index < ans_Dropdown.size()) {
			ans_Dropdown.get(index).click();
			driver.findElements(By.xpath("//li[text()='No']")).get(pointer).click();
			index = index + 2;
			pointer++;
		}
		// click("submit",submit);
		waitTill("5");
		// click("save_safety_Questionaire",quick_Save_safety_Questionaire);
		// waitTimer("3");
		// driver.findElement(By.xpath("//span[text()='Save']")).click();
		// waitTimer("3");
		click("save_safety_Questionaire", save_safety_Questionaire);
		waitTill("5");
	}

	public boolean worklineNumber() {
		// TODO Auto-generated method stub

		waitTill("5");
		click("case_Details", case_Details);
		click("workDetails", workDetails);
		waitTill("10");
		/*
		 * click("partsOrderLinesEdit",partsOrderLinesEdit); waitTill("5");
		 * clear("Clear Field", datePickerEdit); enter("datePickerEdit",
		 * datePickerEdit, "2/18/2021 3:01 PM"); click("saveEdit",saveEdit);
		 */
		waitTill("15");
		// String b= asoNo.getText();
		// String a= shipped.getText();

		// System.out.print("Status" + a +b);
		while (true) {
			// driver.navigate().refresh();
			String ba = asoNo.getText();
			String aa = shipped.getText();
			// String ca =consumed.getText();
			System.out.print("Status" + aa + ba);

			waitTill("6");

			if (aa.equals("Confirmed")) {

				System.out.print("Confrimed Status inside" + aa);

				// return true;

			}
			click("lineNumber", lineNumber);
			String ca = consumedParts.getText();
			if (ca.equals("Consumed")) {
				System.out.print("Consumed Status inside" + ca);
				click("workOrderLink", workOrderLink);
				return true;
			}
		}

	}

	public void pendingReturn() {
		// TODO Auto-generated method stub

		// click("pendingReturnEdit",pendingReturnEdit);
		driver.switchTo().frame(InitiateServiceFrameWork);
		click("managePendingReturns", managePendingReturns);
		click("edit_Labor_Parts", edit_Labor_Parts);
		clickEvent(line_Status_DropDown);
		clickEvent(cancelButton);
		click("CompletedRequests", CompletedRequests);
		click("edit_Labor_Parts", edit_Labor_Parts);
	}

	public void click_Workorder_link(String Workorderno) {
		System.out.print("W0" + Workorderno);
		waitTill("5");
		try {
		WebElement newWorkorder = driver.findElement(By.xpath("//a[text()='Work Order Number']/../../following-sibling::*//a[text()='"+Workorderno+"']"));
		String Workordersearch = newWorkorder.getText();
		click(Workordersearch, work_Order_Number);
		}catch(Exception e) {
			driver.findElement(By.xpath("//a[text()='Work Order Number']/../../following-sibling::*//a[text()='"+Workorderno+"']")).click();
		}
	}

	public void Import_1to1FCO_data_ServiceMax(String path) {
		waitTill("15");
		click("custom_Objects", custom_Objects);
		waitTill("5");
		click("field_Change_Orders", field_Change_Orders);
		waitTill("5");
		click("add_New_Records", add_New_Records);
		waitTill("5");
		selectbyValue(FCO_Record_Type, "FCO Header", "FCO Header");
		waitTill("5");
		click("csv_File", csv_File);
		if (path.equalsIgnoreCase("one to one")) {
			selectFileToUpload(file_Upload, AutomationConstants.FCO1to1DataFilePath);
		} else {
			selectFileToUpload(file_Upload, AutomationConstants.FCO1tomanyDataFilePath);
		}
		waitTill("6");
		embedScreenShotInreport();
		waitForElement(nextBTN, "nextBTN");
		click("nextBTN", nextBTN);
		waitForElement(edit_FCO_Fields, "edit_FCO_Fields");
		click("nextBTN", nextBTN);
		waitForElement(reviewImports, "reviewImports");
		click("startImport", startImport);
		waitTill("6");
		embedScreenShotInreport();
		if (congrats.getText().contains("your import has started")) {
			click("ok", ok);
			isImportSuccess = true;
		}
		waitTill("60");// Wait for FCO to imported
	}

	public void verify_Import_FCO_1to1_data_ServiceMax(String path) {
		long start = System.currentTimeMillis();
		long waitDuration = (long) Double.parseDouble("500");
		List<String[]> FCO_CAL_Data = new ArrayList<String[]>();
		if (path.equalsIgnoreCase("one to one")) {
			FCO_CAL_Data = CSVFileReader.readDataLineByLine(AutomationConstants.FCO1to1DataFilePath);
		} else {
			FCO_CAL_Data = CSVFileReader.readDataLineByLine(AutomationConstants.FCO1tomanyDataFilePath);
		}
		String[] one = FCO_CAL_Data.get(1);
		String FCO_HEADER = one[0];
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("FCO_HEADER", FCO_HEADER);
		int index = 0;
		if (isImportSuccess) {
			while (!isFCOCreated && index < 3) {
				search_GlobalsearchBox(FCO_HEADER);
				waitForElement(FCO_Created_Text, "FCO_Created_Text");
				try {
					driver.findElement(By.xpath("//td[text()='" + FCO_HEADER + "']/preceding-sibling::th/a")).click();
					isFCOCreated = true;
					waitTill("100");
				} catch (Exception e) {

					if (!waitUntil(start, waitDuration)) {
						if (index == 0) {
							index = 1;
						} else if (index == 1) {
							index = 2;
						} else
							index = 3;
					}

				}
			}
		}
	}

	public void save_1to1_FCO_Header_Details_UAL_File(String path) {

		List<String[]> FCO_CAL_Data = new ArrayList<String[]>();
		if (path.equalsIgnoreCase("one to one")) {
			FCO_CAL_Data = CSVFileReader.readDataLineByLine(AutomationConstants.FCO1to1UALDataFilePath);
		} else {
			FCO_CAL_Data = CSVFileReader.readDataLineByLine(AutomationConstants.FCO1tomanyUALDataFilePath);
		}
		for (int i = 1; i < FCO_CAL_Data.size(); i++) {
			String[] one = FCO_CAL_Data.get(i);
			for (int j = 0; j < one.length; j++) {
				// one[(one.length)-1] =
				// AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("FCO_HEADER")+"_1";
				one[(one.length) - 3] = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("FCO_RECORD_ID");
				one[(one.length) - 2] = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("FCO_HEADER") + "_"
						+ i;
			}
		}

		if (path.equalsIgnoreCase("one to one")) {
			CSVFileReader.writeDataAtOnce(AutomationConstants.FCO1to1UALDataFilePath, FCO_CAL_Data);
		} else {
			CSVFileReader.writeDataAtOnce(AutomationConstants.FCO1tomanyUALDataFilePath, FCO_CAL_Data);
		}
	}

	public void Import_1to1_FCO_UAL_data_ServiceMax(String path) {
		waitTill("15");
		click("custom_Objects", custom_Objects);
		waitTill("15");
		click("field_Change_Orders", field_Change_Orders);
		waitTill("15");
		click("add_New_Records", add_New_Records);
		waitTill("15");
		embedScreenShotInreport();
		selectbyValue(match_By, "UniqueIdentifier (External ID)", "UniqueIdentifier (External ID)");
		waitTill("5");
		selectbyValue(FCO_UAL_LookupField, "Salesforce.com ID", "Salesforce.com ID");
		waitTill("5");
		selectbyValue(FCO_UAL_installedProdtField.get(0), "Salesforce.com ID", "Salesforce.com ID");
		waitTill("5");
		selectbyValue(FCO_UAL_installedProdtField.get(3), "Salesforce.com ID", "Salesforce.com ID");
		waitTill("5");
		selectbyValue(FCO_Record_Type, "UAL Lines", "UAL Lines");
		waitTill("5");
		click("csv_File", csv_File);
		if (path.equalsIgnoreCase("one to one")) {
			selectFileToUpload(file_Upload, AutomationConstants.FCO1to1UALDataFilePath);
		} else {
			selectFileToUpload(file_Upload, AutomationConstants.FCO1tomanyUALDataFilePath);
		}
		waitTill("6");
		embedScreenShotInreport();
		click("nextBTN", nextBTN);
		waitForElement(edit_FCO_Fields, "edit_FCO_Fields");
		try {
			waitForElement(errorText, "errorText");
			click("errorOK", errorOK);
		} catch (Exception e) {
		}
		click("nextBTN", nextBTN);
		waitForElement(reviewImports, "reviewImports");
		click("startImport", startImport);
		waitTill("6");
		embedScreenShotInreport();
		if (congrats.getText().contains("your import has started")) {
			click("ok", ok);
			isCALImportSuccess = true;
		}
		waitTill("60");// Wait for FCO to imported
	}

	public void verify_Import_1to1_FCO_UAL_data_ServiceMax() {
		String FCO_HEADER = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("FCO_HEADER");
		String FCO_NAME = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("FCO_NAME");
		search_GlobalsearchBox(FCO_HEADER);
		click("Click", driver.findElement(By.xpath("//td[text()='" + FCO_HEADER + "']/preceding-sibling::th/a")));
		waitForElement(FCO_Created_Text, "FCO_Created_Text");
		System.out.println("TAN:FCO_HEADER:" + FCO_HEADER);
		System.out.println("TAN:FCO_NAME:" + FCO_NAME);
		long start = System.currentTimeMillis();
		long waitDuration = (long) Double.parseDouble("500");
		int index = 0;
		if (isCALImportSuccess) {
			while (!isFCOCALCreated && index < 3) {
				try {
					waitTill("5");
					if (driver
							.findElement(By
									.xpath("//*[@title='Field Change Order']/following-sibling::*[text()='UAL']/ancestor::div[@class='pbHeader']/following-sibling::div//a"))
							.isDisplayed())
						;

					isFCOCALCreated = true;
					driver.navigate().refresh();
					waitTill("100");
				} catch (Exception e) {
					if (!waitUntil(start, waitDuration)) {
						if (index == 0) {
							index = 1;
						} else if (index == 1) {
							index = 2;
						} else
							index = 3;
					}

				}
			}
		}
	}

	public void create_FCO_UAL_Case() {
		String FCO_HEADER = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("FCO_HEADER");
		search_GlobalsearchBox(FCO_HEADER);
		click("Click", driver.findElement(By.xpath("//td[text()='" + FCO_HEADER + "']/preceding-sibling::th/a")));
		waitForElement(FCO_Created_Text, "FCO_Created_Text");
		waitForElement(createUALCase, "createCase");
		waitTill("10");
		scrollByViewOfElement(createUALCase);
		waitTill("5");
		clickEvent(createUALCase);

		waitTill("5");
		embedScreenShotInreport();
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
		}
		boolean isFCOCASECreated = false;
		long start = System.currentTimeMillis();
		long waitDuration = (long) Double.parseDouble("300");
		waitTill("300");
		try {
			while (!isFCOCASECreated) {
				driver.navigate().refresh();
				waitTill("5");
				if (FCO_Case.isDisplayed()) {

					AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("FCO_CASE_NUMBER", FCO_Case.getText());
					isFCOCASECreated = true;
				}
				waitTill("100");
			}
		} catch (Exception e) {
			if (!waitUntil(start, waitDuration))
				;
		}
	}

	public void create_FCO_UAL_Work_Orders() {
		String FCO_HEADER = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("FCO_HEADER");
		search_GlobalsearchBox(FCO_HEADER);
		click("Click", driver.findElement(By.xpath("//td[text()='" + FCO_HEADER + "']/preceding-sibling::th/a")));
		waitForElement(FCO_Created_Text, "FCO_Created_Text");
		waitTill("5");
		waitForElement(createUALWorkOrders, "createWorkOrders");
		scrollByViewOfElement(createUALWorkOrders);
		clickEvent(createUALWorkOrders);
		waitTill("5");
		embedScreenShotInreport();
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
		}
		boolean isFCOCASECreated = false;
		long start = System.currentTimeMillis();
		long waitDuration = (long) Double.parseDouble("300");
		waitTill("300");
		try {
			while (!isFCOCASECreated) {
				driver.navigate().refresh();
				waitTill("5");
				if (isFCO_Work_Order_Created.isDisplayed()) {

					isFCOCASECreated = true;
				}
				waitTill("100");
			}
		} catch (Exception e) {
			if (!waitUntil(start, waitDuration))
				;
		}
	}

	public void dispatchTechnican() {

		waitTill("5");
		click("case_Details", case_Details);
		String parent = driver.getWindowHandle();
		driver.navigate().refresh();
		waitTill("5");
		waitForElement(service_order_frame, "service_order_frame");
		driver.switchTo().frame(service_order_frame);
		click("dispatch_Technician_SFM", dispatch_Technician_SFM);
		waitTill("4");
		Set<String> windows = driver.getWindowHandles();
		for (String win : windows) {
			if (!win.equals(parent)) {
				driver.switchTo().window(win);
				break;
			}
		}
		System.out.println("SERVICE AMX CONSOLE:" + driver.getCurrentUrl());
		System.out.println("SERVICE AMX CONSOLE:" + driver.getTitle());

		String workOrder = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("WORK_ORDER_NUMBER");
		String xpath = "//*[text()='" + workOrder + "']";

		waitTill("5");
		waitForElement(driver.findElement(By.xpath(xpath)), "Dispatch Console");
		clickEvent(driver.findElement(By.xpath("//*[text()='" + workOrder + "']/following-sibling::button")));
		clickEvent(manage_Schedule);
		waitTill("5");
		for (WebElement ele : expand_Service_Team) {
			clickEvent(ele);
		}
		clickEvent(service_Technician);
		clickEvent(select_Technician);
		clickEvent(owner);
		clickEvent(field_Updates);

		waitForElement(dispatch_Console, "dispatch_Console");
		click("schedule_Status_dropdown", schedule_Status_dropdown);
		click("schedule_Status", schedule_status_dispatched);
		click("event_Status_dropDown", event_Status_dropDown);
		scrollByViewOfElement(event_Status_Confirmed);
		clickEvent(event_Status_Confirmed);
		clickEvent(done_Dispatch_Console);
		click("schedule_btn", schedule_btn);
		try {
			waitForElement(schedule_btn, "schedule_btn");
			click("schedule_btn", schedule_btn);
		} catch (Exception e) {

		}
		waitTill("10");
		for (String win : driver.getWindowHandles()) {
			if (!win.equals(parent)) {
				driver.close();
			}
		}
		driver.switchTo().window(parent);
		driver.navigate().refresh();
		waitTill("10");
	}

	public void createIncidentandQuote(String InstalledProduct) {
		waitTill("10");
		driver.findElement(By.xpath("//a[text()='Installed Product ID']/../../following-sibling::*//a[contains(text(),'"
				+ InstalledProduct + "')]")).click();
		System.out.print("CaseName");
		waitForElement(installed_product_custom_Action_frame, "installed_product_custom_Action_frame");
		driver.navigate().refresh();
		waitTill("15");
		driver.switchTo().frame(installed_product_custom_Action_frame);
		waitTill("5");
		clickEvent(create_Case_SFM);
		waitLoadingSpinnerToDisappear();
		waitForElement(creat_Case_dialog, "creat_Case_dialog");
		waitTill("10");
		// click("Contact search Id", contactID_SearchBtn);
		driver.findElement(By.xpath("//*[text()='Contact ID:']/parent::td/following-sibling::td//*[@role='button']"))
				.click();
		waitLoadingSpinnerToDisappear();
		waitForElement(contact_ID_fullname, "contact_ID_fullname");
		waitTill("5");
		// click("contact_ID_fullname", contact_ID_fullname);
		driver.findElement(By.xpath("//span[text()='Full Name']/../../../../../following-sibling::div//tr/td/div"))
				.click();
		waitTill("5");
		click("select_Contact_id_fullname", select_Contact_id_fullname);
		waitTill("5");
		click("eventType_dropdown", eventType_dropdown);
		waitTill("5");
		driver.findElement(By.xpath("//li[text()='Incident']")).click();
		waitTill("5");
		click("priority_Dropdown", priority_Dropdown);
		waitTill("5");
		click("priority_Value", priority_Value);
		waitTill("5");
		enter("Subject", subject, "Test");
		waitTill("5");
		enter("description", desc, "Test Data");
		waitTill("5");
		click("save_case", save_case);
		waitLoadingSpinnerToDisappear();
		waitTill("15");
		click("Details", Details);
		waitTill("5");
		click("case_Details", case_Details);
		waitTill("5");
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("CASE_NUMBER", case_Number.getText());
		waitTill("10");

		driver.switchTo().frame(manage_WorkOrder_Frame);
		waitTill("5");
		click("safety_Questions", safety_Questions);
		waitForElement(safety_Questionair_Dialog, "safety_Questionair_Dialog");
		int index = 1, pointer = 0;
		while (index < ans_Dropdown.size()) {
			ans_Dropdown.get(index).click();
			driver.findElements(By.xpath("//li[text()='No']")).get(pointer).click();
			index = index + 2;
			pointer++;
		}
		waitTill("5");
		try {
			click("submit", submit);
		} catch (Exception e) {
		}
		waitTill("5");
		try {
			click("save_safety_Questionaire", save_safety_Questionaire);
		} catch (Exception e) {
		}
		waitTill("10");

		click("Details", Details);
		waitForElement(manage_WorkOrder_Frame, "manage_WorkOrder_Frame");
		waitTill("10");
		driver.switchTo().frame(manage_WorkOrder_Frame);
		waitTill("5");
		click("requestAQuoteSFM", requestAQuoteSFM);
		waitForElement(newQuoteRequest, "newQuoteRequest");
		waitTill("5");
		click("newQuoteRequest", newQuoteRequest);
		waitForElement(quoteRequestDesc, "quoteRequestDesc");
		waitTill("5");
		enter("quoteRequestDesc", quoteRequestDesc, "Test Data");
		waitTill("5");
		selectbyValue(serviceQuoteStatus, "Draft", "Draft");
		enter("termsAndConditions", termsAndConditions, "Test");
		String parent = driver.getWindowHandle();
		click("search_TermsAndConditions", search_TermsAndConditions);
		waitTill("5");
		Set<String> winds = driver.getWindowHandles();
		System.out.println("winds:" + winds.size());
		for (String one : winds) {
			if (!one.equalsIgnoreCase(parent)) {
				driver.switchTo().window(one);
				if (verifyElementPresent("termsANDCOnditionFrame", termsANDCOnditionFrame)) {
					driver.switchTo().frame(termsANDCOnditionFrame);
					break;
				}
			}
		}
		click("showAllResults", showAllResults);
		click("selectTermsAndCon", selectTermsAndCon);
		driver.switchTo().window(parent);
		waitTill("5");
		waitForElement(addParts, "addParts");
		click("addParts", addParts);
		waitForElement(newParts, "newParts");
		click("newParts", newParts);
		waitTill("6");

		enter("partText", partText.get(0), "452230032863");
		click("partSearch1", partSearch1.get(0));
		waitTill("15");
		enter("DiscountText", DiscountText.get(0), "60");
		waitTill("30");
		System.out.println("Size():" + DiscountType1.size());
		try {
			selectbyValue(DiscountType1.get(0), "Amount", "Amount");
			waitTill("30");
		} catch (Exception e) {
		}
		try {
			selectbyValue(DiscountType1.get(0), "Amount", "Amount");
			waitTill("30");
		} catch (Exception e) {
		}
		waitTill("30");
		selectbyValue(DiscountReason.get(0), "Philips Convenience", "Philips Convenience");
		waitTill("10");

		waitForElement(addLaborBTN, "addLaborBTN");
		click("addLabor", addLaborBTN);
		waitForElement(newLaborButton.get(1), "newLaborButton");
		click("addNewLabor", newLaborButton.get(1));
		waitTill("6");

		selectbyValue(laborActivityCode.get(0), "On Site", "On Site");
		waitTill("10");
		selectbyValue(laborActivityCode.get(2), "WD NH Reg – Regular Labour,Weekdays,Normal Working Hours",
				"WD NH Reg – Regular Labour,Weekdays,Normal Working Hours");
		try {
			waitTill("30");
			selectbyValue(laborActivityCode.get(3), "Amount", "Amount");
			waitTill("30");
		} catch (Exception e) {
		}
		try {
			waitTill("30");
			selectbyValue(laborActivityCode.get(3), "Amount", "Amount");
			waitTill("30");
		} catch (Exception e) {
		}
		waitTill("15");
		enter("DiscountTypeLabour", DiscountLabour.get(1), "200");
		waitTill("30");
		selectbyValue(laborActivityCode.get(4), "Philips Convenience", "Philips Convenience");
		waitTill("30");

		waitForElement(newLaborButton2, "newLaborButton");
		click("addNewLabor", newLaborButton2);
		waitTill("10");
		selectbyValue(laborActivityCode.get(5), "Remote", "Remote");
		waitTill("10");
		selectbyValue(laborActivityCode.get(7), "WD NH Reg – Regular Labour,Weekdays,Normal Working Hours",
				"WD NH Reg – Regular Labour,Weekdays,Normal Working Hours");
		waitTill("10");
		selectbyValue(laborActivityCode.get(8), "Amount", "Amount");
		waitTill("15");
		selectbyValue(laborActivityCode.get(9), "Philips Convenience", "Philips Convenience");
		waitTill("25");
		enter("DiscountTypeLabour", DiscountLabour.get(4), "100");
		waitTill("25");
		waitForElement(getVAT, "getVAT");
		waitTill("15");
		click("getVAT", getVAT);
		waitTill("10");
		waitForElement(save_Quote, "save_Quote");
		waitTill("15");
		click("save_Quote", save_Quote);
		waitTill("15");
		waitForElement(done_Quote, "done_Quote");
		waitTill("10");
		click("done_Quote", done_Quote);
		waitTill("6");

	}

	public void releaseQuoteOne() {
		waitTill("10");
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("QUOTE_NUMBER", Quote_Number.getText());
		waitForElement(Quote_Wizard, "Quote_Wizard");
		driver.switchTo().frame(Quote_Wizard);

		click("release_Quote", release_Quote_SFM);
		waitTill("25");
		driver.switchTo().frame(Quote_Wizard);
		waitTill("10");
		waitForElement(Quote_Wizard, "Quote_Wizard");
		click("generate_PDF", generate_PDF_SFM);
		waitTill("25");
		try {
			click("returnPDF", returnPDF);
		} catch (Exception e) {
		}
		waitTill("10");

		waitForElement(Quote_Wizard, "Quote_Wizard");
		driver.switchTo().frame(Quote_Wizard);
		waitTill("5");
		click("Approved Credit", ApproveCredit);
		waitTill("10");
		click("quoteItemsClick", quoteItemsClick);
		waitTill("10");
		try {
			click("showMore", showMore);
			waitTill("10");
		} catch (Exception e) {
		}
		List<String> Quotenew = new ArrayList<String>();
		for (WebElement ele : pending_Quot) {
			Quotenew.add(ele.getText());
		}
		System.out.print("QuoteCount" + Quotenew.size());

		for (int i = 0; i < Quotenew.size(); i++) {
			waitTill("5");
			if (i == 0) {
				String Quote3 = driver
						.findElement(By
								.xpath("//*[text()='Pending - Local']/preceding-sibling::td/a[contains(@title,'Edit - Record ')]/../following-sibling::th/a"))
						.getText();
				System.out.print("Quote" + Quote3);
				WebElement quoteLinkClick = driver.findElement(By
						.xpath("//*[text()='Pending - Local']/preceding-sibling::td/a[contains(@title,'Edit - Record ')]/../following-sibling::th/a[text()='"
								+ Quote3 + "']"));
				System.out.print("Quote" + quoteLinkClick);
				click("quoteLinkClick", quoteLinkClick);
				waitTill("5");
			} else {
				search_GlobalsearchBox(Quotenew.get(i));
				waitForElement(searchResult, "search Result");
				waitTill("5");
				driver.findElement(By.xpath("//a[text()='" + Quotenew.get(i) + "']")).click();
			}
			waitTill("25");
			waitForElement(iframeQuote, "iframeQuote");
			driver.switchTo().frame(iframeQuote);
			waitTill("5");
			waitForElement(AproveQuote, "AproveQuote");
			waitTill("5");
			click("ApproveQuote", AproveQuote);
			waitLoadingSpinnerToDisappear();
			waitTill("15");
			try {
				click("showMore", showMore);
				waitTill("5");
			} catch (Exception e) {
			}
		}
	}

	public void pendingQuoteApproval() {
		// TODO Auto-generated method stub
		waitTill("6");
		String qut = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("QUOTE_NUMBER");
		search_GlobalsearchBox(qut);
		waitForElement(searchResult, "search Result");
		waitTill("5");
		driver.findElement(By.xpath("//a[text()='" + qut + "']")).click();
		if (QuStatus.getText().equals("Pending Quote Approval")) {
			System.out.print("Pending Quote Approval");
		}
	}

	public void quoteAccept() {
		waitTill("15");
		String parent = driver.getWindowHandle();
		waitForElement(Quote_Wizard, "Quote_Wizard");
		driver.switchTo().frame(Quote_Wizard);
		waitTill("6");
		waitForElement(accept_SFM, "accept_SFM");
		click("accept_SFM_Clicked", accept_SFM);
		waitTill("30");

		Set<String> winds = driver.getWindowHandles();
		System.out.println("winds:" + winds.size());
		for (String one : winds) {
			if (!one.equalsIgnoreCase(parent)) {
				driver.switchTo().window(one);
				if (verifyElementPresent("enterponumber_lightning", enterponumber_lightning)) {
					break;
				}
			}
		}

		enter("Customer Purchase Order Number:", enterponumber_lightning, "1234");
		waitTill("30");
		click("saveButton", saveButton);
		waitTill("30");
	}

	public void quoteApproval() {
		waitTill("5");
		try {
			driver.switchTo().frame(Quote_Wizard);
			click("quoteApproval", quoteApproval);
		} catch (Exception e) {
		}
		waitTill("5");
		waitForElement(status, "status");
	}

	public void internallyApproved() {
		// TODO Auto-generated method stub
		String quoteNumber = AutomationConstants.SERVICE_CONSULTENCY_CONTRACT_DATA.get("QUOTE_NUMBER");
		System.out.println(quoteNumber);
		String CaseNumber = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CASE_NUMBER");
		System.out.print(CaseNumber);
		search_GlobalsearchBox(CaseNumber);
		waitForElement(searchResult, "search Result");
		waitTill("5");
		driver.findElement(By.xpath("//a[text()='" + CaseNumber + "']")).click();

		waitTill("5");

		waitForElement(case_Details, "case_Details");
		click("case_Details", case_Details);
	}

	public void createThirdQuote() {
		// TODO Auto-generated method stub
		waitTill("10");
		driver.navigate().refresh();
		waitTill("10");
		waitForElement(manage_WorkOrder_Frame, "manage_WorkOrder_Frame");
		driver.switchTo().frame(manage_WorkOrder_Frame);
		waitForElement(requestAQuoteSFM, "requestAQuoteSFM");
		click("requestAQuoteSFM", requestAQuoteSFM);
		waitForElement(newQuoteRequest, "newQuoteRequest");
		waitTill("5");
		click("newQuoteRequest", newQuoteRequest);
		waitForElement(quoteRequestDesc, "quoteRequestDesc");
		waitTill("5");
		enter("quoteRequestDesc", quoteRequestDesc, "Test Data");
		waitTill("5");
		// selectbyValue(serviceQuoteStatus,serviceStatus,serviceStatus);
		selectbyValue(serviceQuoteStatus, "Draft", "Draft");
		waitTill("10");

		selectbyValue(bussinessGroupDropDown, "Default", "Default");
		waitTill("5");
		// selectbyValue(serviceQuoteStatus_1,"Draft","Draft");
		enter("termsAndConditions", termsAndConditions, "Spain");
		String parent = driver.getWindowHandle();
		click("search_TermsAndConditions", search_TermsAndConditions);
		waitTill("6");
		for (String one : driver.getWindowHandles()) {
			if (!one.equalsIgnoreCase(parent)) {
				driver.switchTo().window(one);
				driver.switchTo().frame(termsANDCOnditionFrame);
			}
		}
		waitTill("10");
		click("showAllResults", showAllResults);
		waitTill("5");
		click("selectTermsAndCon", selectTermsAndCon);
		driver.switchTo().window(parent);

		waitForElement(addParts, "addParts");
		click("addParts", addParts);
		waitTill("5");
		waitForElement(newParts, "newParts");
		click("newParts", newParts);
		waitTill("10");
		click("Materials", partSearch1.get(0));
		waitTill("10");
		enter("partText", partText.get(0), "453564203931");
		waitTill("10");
		waitForElement(DiscountText.get(0), "DiscountText");
		enter("DiscountText", DiscountText.get(0), "100");
		waitTill("10");
		waitForElement(DiscountType1.get(0), "DiscountType1");
		selectbyValue(DiscountType1.get(0), "Amount", "Amount");
		waitTill("10");
		waitForElement(DiscountReason.get(0), "DiscountReason");
		selectbyValue(DiscountReason.get(0), "Philips Convenience", "Philips Convenience");
		waitTill("25");

		waitForElement(addLaborBTN, "addLaborBTN");
		click("addLabor", addLaborBTN);
		waitForElement(newLaborButton.get(1), "newLaborButton");
		click("addNewLabor", newLaborButton.get(1));
		waitTill("10");

		selectbyValue(laborActivityCode.get(0), "On Site", "On Site");
		waitTill("25");

		selectbyValue(laborActivityCode.get(2), "WD NH Reg – Regular Labour,Weekdays,Normal Working Hours",
				"WD NH Reg – Regular Labour,Weekdays,Normal Working Hours");

		waitTill("10");
		selectbyValue(laborActivityCode.get(3), "Amount", "Amount");
		waitTill("10");
		enter("DiscountTypeLabour", DiscountLabour.get(1), "200");
		waitTill("10");
		try {
			selectbyValue(laborActivityCode.get(3), "Philips Convenience", "Philips Convenience");
			waitTill("10");
		} catch (Exception e) {
			selectbyValue(laborActivityCode.get(4), "Philips Convenience", "Philips Convenience");
			waitTill("10");
		}
		waitForElement(getVAT, "getVAT");
		click("getVAT", getVAT);
		waitTill("10");
		click("save_Quote", save_Quote);
		waitTill("10");
		waitForElement(done_Quote, "done_Quote");
		click("done_Quote", done_Quote);
		waitTill("10");

	}

	public void Add_Labour_Parts() {
		waitTill("5");
		waitForElement(Details_Tab, "Details_Tab");
		Details_Tab.click();
		waitTill("10");
		driver.switchTo().frame("0660L000001TnEB");
		System.out.println("********We are switched to the iframe*******");
		waitTill("5");
		waitForElement(AddLaborParts, "AddLaborParts");
		AddLaborParts.click();
		waitTill("10");
	}

	public void closeAllTasks() {

		waitTill("5");
		System.out.println("No. of tasks : " + allTasks.size());
		if (allTasks.size() > 0) {

			for (WebElement task : allTasks) {
				click("My Task", task);
				click("Save", Save);
			}
		}

		String parentWindow = driver.getWindowHandle();
		if (driver.getWindowHandles().size() > 1) {
			driver.close();
			driver.switchTo().window(parentWindow);
		}
	}

	public void createPartsOnlyWorkOrder() {
		// TODO Auto-generated method stub
		waitTill("5");
		driver.switchTo().frame(manage_WorkOrder_Frame);

		waitTill("5");
		waitForElementToEnable(createPartsOnlyWorkOrder1);
		click("createPartsOnlyWorkOrder1", createPartsOnlyWorkOrder1);
		waitTill("6");

		enter("site_input", site_input, AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("LOCATION"));
		click("site Search Btn", site_SearchBtn);
		waitLoadingSpinnerToDisappear();
		waitForElement(site_fullname, "site_fullname");
		waitTill("5");
		driver.findElement(By.xpath("//input[@value='Exact Match']/parent::td/following-sibling::td")).click();
		waitTill("5");
		driver.findElement(By.xpath("//li[text()='Contains']")).click();
		enter("quickFind_IP", quickFind_IP, AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("LOCATION"));
		click("limitSearch", limitSearch);
		click("quickFindBTN", quickFindBTN);
		waitLoadingSpinnerToDisappear();
		waitForElement(site_fullname, "site_fullname");
		click("site_fullname", site_fullname);
		click("select_Contact_id_fullname", select_Contact_id_fullname);

		click("saveWO", saveWO);
		waitTill("15");
		AutomationConstants.SERVICE_CONSULTENCY_CONTRACT_DATA.put("WORK_ORDER_NUMBER", workorder_Number.getText());
		String WorkOrderNumber = AutomationConstants.SERVICE_CONSULTENCY_CONTRACT_DATA.get("WORK_ORDER_NUMBER");
		System.out.print(WorkOrderNumber);
	}

	public void partsOrdering(String dat) {
		// TODO Auto-generated method stub
		// String WorkOrderNumber =
		// AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("WORK_ORDER_NUMBER");
		// System.out.println("Workorder"+WorkOrderNumber);
		click("case_Details", case_Details);
		driver.navigate().refresh();
		waitForElementToEnable(InitiateServiceFrameWork);
		driver.switchTo().frame(InitiateServiceFrameWork);
		waitTill("10");
		waitForElementToEnable(PartsOrdering);
		click("PartsOrdering", PartsOrdering);
		waitTill("10");
		new BasePage(driver).embedScreenShotInreport();
		enter("partCodeEntering", partCodeEntering, dat);

		click("partOrderingSearch", partOrderingSearch);
		waitTill("10");
		click("addPart", addPart);
		waitTill("15");
		click("GetEntitlement", GetEntitlement);
		waitTill("30");
		click("GATPSimulation", GATPSimulation);
		waitTill("30");
		new BasePage(driver).embedScreenShotInreport();
		click("TransferToSAP", TransferToSAP);
		waitTill("30");
		click("backtoworkorder", backtoworkorder);
		waitTill("6");
		driver.navigate().refresh();
		waitTill("30");
		scrollByViewOfElement(part);
		waitTill("6");
		driver.navigate().refresh();
		waitTill("30");
		scrollByViewOfElement(part);
		waitTill("5");
		new BasePage(driver).embedScreenShotInreport();
		System.out.println("ASO Num:" + ASO.get(7).getText());
		System.out.println("ASO Item:" + ASO.get(8).getText());
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("ASO_ITEM1", ASO.get(7).getText());
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("ASO_ITEM2", ASO.get(8).getText());
		waitTill("5");

	}

	public void search_WorkOrder_global_SearchBox(String WOType) {
		String workOrder = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get(WOType + "_WORK_ORDER_NUMBER");
		search_GlobalsearchBox(workOrder);
		waitForElement(work_Order_Result, "work_Order_Result");
		driver.findElement(By.xpath(
				"//a[text()='Work Order Number']/../../following-sibling::*//a[contains(text(),'" + workOrder + "')]"))
				.click();
	}

	public void intiateTravel() {

		// TODO Auto-generated method stub

		waitForElement(work_Order_Header, "work_Order_Header");
		waitForElement(service_Flow_SFM, "service_Flow_SFM");
		driver.switchTo().frame(service_Flow_SFM);

		waitForElement(initiate_Onsite_SFM, "initiate_Onsite_SFM");
		click("initiate_Onsite_SFM", initiate_Travel_SFM);
		waitTill("5");
		waitForElement(work_Order, "work_Order");

		clickEvent(work_Order);
		// driver.navigate().back();

		waitForElement(service_Flow_SFM, "service_Flow_SFM");
		driver.switchTo().frame(service_Flow_SFM);
		waitForElement(initiate_Onsite_SFM, "initiate_Onsite_SFM");
		click("initiate_Onsite_SFM", initiate_Onsite_SFM);
		// driver.navigate().back();
		waitTill("5");
		waitForElement(work_Order, "work_Order");
		click("work_Order", work_Order);
	}

	public void shippedStatus() {
		// TODO Auto-generated method stub
		waitTill("5");
		click("case_Details", case_Details);
		click("workDetails", workDetails);
		waitTill("10");
	}

	public void selectListviewOption(String listviewName) {
		WebListbyName("fcf", listviewName);
		if (verifyElementPresent("viewGoButton", viewGoButton)) {
			click("viewGoButton", viewGoButton);
		}

		waitTill("4");
		embedScreenShotInreport();

	}

	public void csPortalLogin() throws InterruptedException {
		String url = AutomationConstants.CS_PORTAL_URL;
		driver.get(url);
	}

	public void hoverTo_PMPlans() {
		waitForElement(preventive_maintenance_plan, "Dispaly Preventive Maintenance Plan");
		hover(preventive_maintenance_plan);
		waitTill("5");
	}
	



	@FindBy(xpath = "//a[@title='Terms and Conditions Lookup (New Window)']")
	public WebElement terms_lookup;

	@FindBy(xpath = "//frame[@id='resultsFrame']")
	private WebElement lookup_resultFrame;

	@FindBy(xpath = "//input[@title='Go!']")
	private WebElement lookup_gobtn;

	@FindBy(xpath = "//a[text()='Austria - Terms and conditions(MA_TC)']")
	private WebElement lookup_first;

	@FindBy(xpath = "//td[text()='New Work Order']/..//span//input")
	private WebElement workOrder_radiobtn;

	@FindBy(xpath = "(//input[@value='New'])[1]")
	private WebElement parts_NewBtn;

	@FindBy(xpath = "//a[@title='Part Lookup (New Window)']")
	private WebElement parts_Lookup;

	@FindBy(xpath = "(//input[@value='New'])[2]")
	private WebElement labour_NewBtn;



	@FindBy(xpath = "//td[text()='Labor']")
	private WebElement labour_tab;



	@FindBy(xpath = "(//div[text()='Labor Activity Code']/../../../following-sibling::tbody//select)[1]")
	private WebElement labour_Activity_Code;

	@FindBy(xpath = "(//div[text()='Labor Activity Code']/../../../following-sibling::tbody//tr[2]//select)[1]")
	private WebElement labour_Activity_Code2;

	@FindBy(xpath = "(//div[text()='Labor Activity Code']/../../../following-sibling::tbody//tr[3]//select)[1]")
	private WebElement labour_Activity_Code3;

	@FindBy(xpath = "(//div[text()='Maintenance Window']/../../../following-sibling::tbody//select)[3]")
	private WebElement maintainance_Window;

	@FindBy(xpath = "(//div[text()='Maintenance Window']/../../../following-sibling::tbody//tr[2]//select)[3]")
	private WebElement maintainance_Window2;

	@FindBy(xpath = "(//div[text()='Maintenance Window']/../../../following-sibling::tbody//tr[3]//select)[3]")
	private WebElement maintainance_Window3;

	@FindBy(xpath = "(//div[text()='Maintenance Window']/../../../following-sibling::tbody//select)[2]")
	private WebElement type_Meaure;

	@FindBy(xpath = "(//div[text()='Maintenance Window']/../../../following-sibling::tbody//tr[2]//select)[2]")
	private WebElement type_Meaure2;

	@FindBy(xpath = "(//div[text()='Maintenance Window']/../../../following-sibling::tbody//tr[3]//select)[2]")
	private WebElement type_Meaure3;

	@FindBy(xpath = "//input[@value='Save']")
	private WebElement save_Btn;

	@FindBy(xpath = "//input[@value='Done']")
	private WebElement done_Btn;



	@FindBy(xpath = "//input[@value='Pull Discounts From Contract ']")
	private WebElement pull_discount_btn;

	@FindBy(xpath = "//input[@value='Get Price/VAT']")
	private WebElement get_price_btn;

	@FindBy(xpath = "//li[contains(text(),'The Case is covered by a Service/Maintenance')]")
	private WebElement validate_msg1;


	@FindBy(xpath = "//th[text()='Unit Price']/../following-sibling::tr[1]//td[6]")
	private WebElement unit_Price1;

	@FindBy(xpath = "//th[text()='Unit Price']/../following-sibling::tr[2]//td[6]")
	private WebElement unit_Price2;

	@FindBy(xpath = "//th[text()='Unit Price']/../following-sibling::tr[3]//td[6]")
	private WebElement unit_Price3;

	@FindBy(xpath = "//th[text()='Unit Price']/../following-sibling::tr[4]//td[6]")
	private WebElement unit_Price4;

	@FindBy(xpath = "//input[@value='Release Quote']")
	private WebElement release_Quote;


	@FindBy(xpath = "//td[text()='Total Price before Discount and Tax']/following-sibling::td//div")
	private WebElement total_Price;














	public void select_NewQuoteRequest() {
	click("New Quote Request", quote_Request_radio_btn);
	waitTill("10");

	}



	public void enterDetails_QuotePage() {
	editpage_EnterComments("Quote request description");
	WebElement e = driver.findElement(By.xpath("//label[text()='Status']/../following-sibling::td//select"));
	selectbyValue(e, "Draft", "Status");
	waitTill("5");



	clickEvent(terms_lookup);
	switchToTab();
	waitAndswitchToRequiredFrame(lookup_searchframe);
	click("Search filed", lookup_search);
	enter("Contact search", lookup_search, "Austria");
	click("Go button", lookup_gobtn);
	driver.switchTo().defaultContent();
	waitTill("5");
	waitAndswitchToRequiredFrame(lookup_resultFrame);
	waitTill("5");
	WebElement showall_results_link = driver.findElement(By.xpath("//a[text()='Show all results']"));
	click("showall_results_link", showall_results_link);
	waitTill("5");
	waitForElement(lookup_first, "Select record");
	click("lookup_first", lookup_first);



	switchToTab();



	}



	public void select_NewWorkOrder() {
	waitForElement(workOrder_radiobtn, "workOrder_radiobtn");
	click("workOrder_radiobtn", workOrder_radiobtn);
	waitTill("5");
	}



	public void enter_LaborDetails() {
	waitTill("5");
	click("labour_tab", labour_tab);
	waitTill("5");
	click("labour_NewBtn", labour_NewBtn);
	waitTill("5");
	click("Labour Actvity Code", labour_Activity_Code);
	selectbyValue(labour_Activity_Code, "On Site", "labour_Activity_Code");

	click("maintainance_Window", maintainance_Window);
	waitTill("5");
	selectbyValue(maintainance_Window, "WD NH Reg – Regular Labour,Weekdays,Normal Working Hours", "maintainance_Window");


	waitTill("5");
	click("labour_NewBtn", labour_NewBtn);
	waitTill("5");
	click("Labour Actvity Code", labour_Activity_Code2);
	selectbyValue(labour_Activity_Code2, "Remote", "labour_Activity_Code2");
	click("maintainance_Window", maintainance_Window2);
	waitTill("5");
	selectbyValue(maintainance_Window2, "WD NH Reg – Regular Labour,Weekdays,Normal Working Hours", "maintainance_Window");

	waitTill("5");
	click("labour_NewBtn", labour_NewBtn);
	waitTill("5");
	click("Labour Actvity Code", labour_Activity_Code3);
	selectbyValue(labour_Activity_Code3, "Travel", "labour_Activity_Code");
	click("type_Meaure", type_Meaure3);
	selectbyValue(type_Meaure3, "Time", "type_Meaure");

	click("maintainance_Window", maintainance_Window3);
	waitTill("5");
	selectbyValue(maintainance_Window3, "WD NH Reg – Regular Labour,Weekdays,Normal Working Hours", "maintainance_Window");
	// waitTill("save_Btn");
	// click("save_Btn", save_Btn);
	// waitTill("save_Btn");


	}



	public void enter_PartDetails() {
	waitTill("5");
	click("parts_NewBtn", parts_NewBtn);
	waitTill("6");
	WebElement e = driver.findElement(By.xpath("//div[text()='Part']/../../../following-sibling::tbody//input[contains(@onchange,'checkZREP')]"));

	click("part no", e);
	waitTill("5");
	enter("2", e, "453561287451");

	click("parts_Lookup", parts_Lookup);

	// switchToTab();




	}



	public void click_GetPrice() {
	waitTill("10");
	click("get price button", get_price_btn);
	waitTill("20");

	verifyElementPresent("validate_msg1", validate_msg1);


	}



	public void click_PullDiscount() {
	waitTill("10");
	click("pull_discount_btn", pull_discount_btn);
	waitTill("20");

	click("Done Button", done_Btn);
	waitTill("5");



	}

	public double calculations() throws ParseException{
	String s1= unit_Price1.getText();
	Double d1 = extractFieldValueFromString(s1);
	System.out.println(d1);


	String s2= unit_Price2.getText();
	Double d2 = extractFieldValueFromString(s2);
	System.out.println(d2);

	String s3= unit_Price3.getText();
	Double d3 = extractFieldValueFromString(s3);
	System.out.println(d3);

	String s4= unit_Price4.getText();
	Double d4 = extractFieldValueFromString(s4);
	System.out.println(d4);


	Double add_all = d1 + d2 + d3 + d4 ;

	System.out.println(add_all);

	String t= total_Price.getText();
	Double d5 = extractFieldValueFromString(t);
	assert_Validation(d5, add_all, "Total Price before Discount and Tax");
	return add_all;









	}

	public void assert_Validation(Double s, Double d, String fieldLabel) {



	if (s.equals(d)) {
	logReport("PASS", fieldLabel + " is displayed correctly");



	} else {
	logReport("FAIL", fieldLabel + " is displayed incorrectly");
	Assert.fail();



	}



	}



	public Double extractFieldValueFromString(String value){
	value = value.substring(1);;
	value = value.replaceAll(",", "");
	return Double.parseDouble(value);

	}



	public void release_Quote() {
	waitAndswitchToFrame("ESMX_Quote_Wizard_Lite");
	waitTill("5");
	click("Relase Quote", release_Quote);
	waitTill("10");

	}

	// Mayuri

	@FindBy(xpath = "//select[@name='DropDownList1']")
	public WebElement env_dropdown;

	@FindBy(xpath = "//select[@name='DropDownList2']")
	public WebElement folderName_dropdown;

	@FindBy(xpath = "//select[@name='DropDownList3']")
	public WebElement workflowName_dropdown;

	@FindBy(xpath = "//input[@value='Execte Workflow']")
	public WebElement execute_Button;

	@FindBy(xpath = "//td[text()='SUCCEEDED']")
	public WebElement succeeded;

	@FindBy(xpath = "//td[text()='Failure']")
	public WebElement failure;

	@FindBy(xpath = "//a[@title='Reports Tab']")
	public WebElement reports_Tab;

	@FindBy(xpath = "//a[@title='Reports Tab - Selected']")
	public WebElement reports_Tab_Selected;

	@FindBy(xpath = "//input[@value='Cancel']")
	public WebElement cancel_Button;

	@FindBy(xpath = "//input[@title='Quick search']")
	public WebElement quick_Search;

	@FindBy(xpath = "//span[text()='Sap to Smax Contacts Report']")
	public WebElement search_Contact_Report;

	@FindBy(xpath = "//span[text()='Sap to Smax accounts Report']/..")
	public WebElement search_Account_Report;

	@FindBy(xpath = "//span[text()='Sap to Smax acc to acc Partner Report']")
	public WebElement search_Partner_Report;

	@FindBy(xpath = "//input[@value='New Report...']")
	public WebElement new_Report;

	@FindBy(xpath = "(//li[@class='x-tree-node']//div//span)[1]")
	public WebElement first_node;

	@FindBy(xpath = "(//span[text()='Show more...'])[1]")
	public WebElement show_More;

	@FindBy(xpath = "//input[@id='quickFindInput']")
	public WebElement quick_find;

	@FindBy(xpath = "//span[text()='Accounts with Contacts']")
	public WebElement account_reporttype;

	@FindBy(xpath = "//span[text()='Accounts to Account Partners Junctions']")
	public WebElement account_partner_reporttype;

	@FindBy(xpath = "//input[@value='Create']")
	public WebElement create_Buttom;

	@FindBy(xpath = "//label[text()='Show']/../../following-sibling::td//input")
	public WebElement show_dropdown;

	@FindBy(xpath = "//div[text()='All accounts']")
	public WebElement all_Accounts;

	@FindBy(xpath = "//div[text()='All accounts to account partners junctions']")
	public WebElement all_Accounts_partner;

	@FindBy(xpath = "//div[text()='All Time']")
	public WebElement all_Time;

	@FindBy(xpath = "//div[text()='Last Modified Date']")
	public WebElement last_Modified_Date;

	@FindBy(xpath = "//div[text()='Account to Account Partner Junction: Last Modified Date']")
	public WebElement account_partner_last_Modified_Date;

	@FindBy(xpath = "//div[text()='Last Modified By: Full Name']")
	public WebElement last_Modified_name;

	@FindBy(xpath = "//div[text()='Account to Account Partner Junction: Last Modified By']")
	public WebElement account_partner_last_Modified_name;

	@FindBy(xpath = "//label[text()='Range']/following-sibling::div//input")
	public WebElement range_dropdown;

	// @FindBy(xpath = "//button[text()='Add']")
	// public WebElement add_Button;

	@FindBy(xpath = "//em[@class='x-btn-split']")
	public WebElement add_Button;

	@FindBy(xpath = "//input[@class='x-form-text x-form-field pc x-form-focus']/following-sibling::img")
	public WebElement input1;

	@FindBy(xpath = "//input[@class='x-form-text x-form-field pc x-form-focus']")
	public WebElement enterinput1;

	@FindBy(xpath = "//input[@class='x-form-text x-form-field pv']")
	public WebElement input2;

	@FindBy(xpath = "//input[@name='pv']")
	public WebElement date_input;

	@FindBy(xpath = "//button[text()='OK']")
	public WebElement ok_Button;

	@FindBy(xpath = "//button[text()='Run Report']")
	public WebElement run_Report_Button;

	@FindBy(xpath = "//input[@value='Customize']")
	public WebElement customize_Button;

	@FindBy(xpath = "//b[text()='Last Modified Date']/../following-sibling::span//a[text()='Edit']")
	public WebElement edit_Button;

	@FindBy(xpath = "//b[text()='Account to Account Partner Junction: Last Modified Date']/../following-sibling::span//a[text()='Edit']")
	public WebElement partner_edit_Button;

	@FindBy(xpath = "//input[@value='Export Details']")
	public WebElement export_Details;

	@FindBy(xpath = "//input[@value='Export']")
	public WebElement export_Button;

	@FindBy(xpath = "//select[@id='enc']")
	public WebElement file_encoding;

	@FindBy(xpath = "//select[@id='xf']")
	public WebElement file_format;

	static ArrayList<Map<String, String>> actualRecords = new ArrayList<Map<String, String>>();
	static ArrayList<Map<String, String>> expectedRecords = new ArrayList<Map<String, String>>();

	public void editpage_Text_Input(String value1, String value2) {
		WebElement textInput = driver
				.findElement(By.xpath("//label[text()='" + value1 + "']/following-sibling::div//input"));
		click(value1, textInput);
		clear(value1, textInput);
		waitTill("3");
		enter(value1, textInput, value2);
		textInput.sendKeys(Keys.TAB);

	}

	public void editpage_SelectDropDown(String value1, String value2) {

		waitTill("5");
		WebElement element1 = driver.findElement(By.xpath("//label[text()='" + value1 + "']/..//input"));
		click(value1, element1);
		waitTill("2");
		WebElement element2 = driver
				.findElement(By.xpath("//label[text()='" + value1 + "']/..//span[@title='" + value2 + "']"));
		click(value2, element2);
	}

	public void differentpage_SelectDropDown(String value1, String value2) {
		waitTill("5");
		WebElement element1 = driver
				.findElement(By.xpath("//span[text()='" + value1 + "']/../following-sibling::div//a"));
		click(value1, element1);
		waitTill("4");
		WebElement element2 = driver.findElement(By.xpath("//a[@title='" + value2 + "']"));
		click(value2, element2);
		// doubleClick(value2, element2);

	}

	public void editpage_RecentDropDown(String value1, String value2) {
		waitTill("5");
		WebElement element1 = driver.findElement(By.xpath("//label[text()='" + value1 + "']/..//input"));
		click(value1, element1);
		waitTill("2");
		WebElement element2 = driver.findElement(By.xpath("//ul[@aria-label='" + value2
				+ "']//li[2]//lightning-base-combobox-item//span[@class='slds-truncate']"));
		click(value2, element2);
	}

	public void editpage_EnterComments(String fieldName) {
		WebElement element1 = driver
				.findElement(By.xpath("//label[text()='" + fieldName + "']/../following-sibling::td//textarea"));
		click(fieldName, element1);
		clear(fieldName, element1);
		enter(fieldName, element1, "Auto Test");
		element1.sendKeys(Keys.TAB);

	}

	public void differentpage_EnterComments(String fieldName) {
		WebElement element1 = driver
				.findElement(By.xpath("//span[text()='" + fieldName + "']/../following-sibling::textarea"));
		click(fieldName, element1);
		clear(fieldName, element1);
		enter(fieldName, element1, "Auto Test" + Utility.getFormatedDateTime());
		element1.sendKeys(Keys.TAB);

	}

	public void editpage_ClickCheckbox(String fieldName) {
		waitTill("4");
		WebElement element22 = driver.findElement(
				By.xpath("//lightning-input//span[text()='" + fieldName + "']/../following-sibling::div//span//input"));
		click(fieldName, element22);
		waitTill("4");
	}

	public void editpage_ClickCheckbox1(String fieldName) {
		waitTill("4");
		WebElement element22 = driver
				.findElement(By.xpath("//span[text()='" + fieldName + "']/../following-sibling::div//span//input"));
		element22.click();
		waitTill("4");
	}

	public void differentpage_ClickCheckbox(String fieldName) {
		waitTill("2");
		WebElement element22 = driver
				.findElement(By.xpath("//span[text()='" + fieldName + "']/../following-sibling::input"));
		click(fieldName, element22);
		waitTill("4");
	}

	public void editpage_EnterCurrentDate(String fieldName) {
		WebElement element22 = driver.findElement(By.xpath("//label[text()='" + fieldName + "']/..//input"));
		click(fieldName, element22);
		clear(fieldName, element22);
		String date = currentDateValue("MM/dd/yyyy");
		enter(fieldName, element22, date);
		element22.sendKeys(Keys.TAB);
	}

	public void editpage_EnterFutureDate(String fieldName) {
		WebElement element22 = driver.findElement(By.xpath("//label[text()='" + fieldName + "']/..//input"));
		click(fieldName, element22);
		clear(fieldName, element22);
		String date = endDatevalue("M/d/yyyy", +8, 0, 0);
		enter(fieldName, element22, date);
		element22.sendKeys(Keys.TAB);
	}

	public void editpage_EnterFutureMonth(String fieldName) {
		WebElement element22 = driver.findElement(By.xpath("//label[text()='" + fieldName + "']/..//input"));
		click(fieldName, element22);
		clear(fieldName, element22);
		String date = endDatevalue("M/d/yyyy", 0, +1, 0);
		enter(fieldName, element22, date);
		element22.sendKeys(Keys.TAB);
	}

	public void differentpage_EnterCurrentDate(String fieldName) {
		WebElement element22 = driver
				.findElement(By.xpath("//label//span[text()='" + fieldName + "']/../following-sibling::div//input"));
		click(fieldName, element22);
		clear(fieldName, element22);
		String date = endDatevalue("M/d/yyyy", +8, 0, 0);
		enter(fieldName, element22, date);
		element22.sendKeys(Keys.TAB);
	}

	public void differentpage_EnterFutureDate(String fieldName) {
		WebElement element22 = driver
				.findElement(By.xpath("//label//span[text()='" + fieldName + "']/../following-sibling::div//input"));
		click(fieldName, element22);
		clear(fieldName, element22);
		String date = endDatevalue("M/d/yyyy", +10, 0, 0);
		enter(fieldName, element22, date);
		element22.sendKeys(Keys.TAB);
	}

	public void editpage_SeletMultiSelectPicklist(String fieldName) {
		waitTill("2");
		WebElement element22 = driver.findElement(By.xpath("//div[text()='" + fieldName + "']/..//ul"));
		click(fieldName, element22);
		waitTill("2");
		WebElement siteSelect1 = driver.findElement(By.xpath("//div[text()='" + fieldName
				+ "']/following-sibling::div/div//span[text()='Available']/following-sibling::div//ul/li[1]/div"));
		click(fieldName, siteSelect1);
		waitTill("2");
		WebElement rightKey1 = driver
				.findElement(By.xpath("//div[text()='" + fieldName + "']/following-sibling::div//button"));
		click("rightKey", rightKey1);
		waitTill("2");
	}

	public void SFW_Section_Button(String button_Name) {
		waitAndswitchToFrame("ESMX_Case_Wizard_Lite");

		WebElement SFW_Button = driver.findElement(
				By.xpath("//input[@class='svmxbtn mediumbtn enabledbtn' and @value='" + button_Name + "' ]"));
		click(button_Name, SFW_Button);
		waitTill("5");

	}

	public void open_Case(String arg1) {

		search_GlobalsearchBox(arg1);
		WebElement case_Search = driver.findElement(By.xpath("//a[@data-seclke='Case' and text()='" + arg1 + "']"));
		click(arg1, case_Search);
		waitTill("5");
	}

	public void navigate_DetailsPage() {
		WebElement details = driver.findElement(By.xpath("//a[@class='optionItem efpDetailsView ']"));
		click("Details Page", details);

	}

	public void select_QuoteRequest() {
		click("quote_Request", quote_Request);
		waitTill("5");
		editpage_EnterComments("Quote request description");

	}

	public void informaticaLogin() {

		driver.get("http://130.147.185.241/InformaticaWorkFlowAutomation/Workflow");
		waitTill("5");

	}
	
	//sami
	public void asxCookiesAccept() {
		waitTill("10");
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
	}

	public void account_Workflow() {
		selectFromDropDown(env_dropdown, "Test", "env_dropdown");
		waitTill("5");

		selectFromDropDown(folderName_dropdown, "INT_O2C_CUST_MP1_SMAX", "folderName_dropdown");
		waitTill("5");

		selectFromDropDown(workflowName_dropdown, "wf_m_SAP_SMAX_Accounts", "workflowName_dropdown");
		waitTill("5");

		click("execute_Button", execute_Button);
		waitTill("60");

		try {
			verifyElementPresent("succeeded", succeeded);

		} catch (Exception e) {
			verifyElementPresent("Failure", failure);
			Assert.fail();
		}

	}

	public void contact_Workflow() {
		selectFromDropDown(env_dropdown, "Test", "env_dropdown");
		waitTill("5");

		selectFromDropDown(folderName_dropdown, "INT_O2C_CUST_MP1_SMAX", "folderName_dropdown");
		waitTill("5");

		selectFromDropDown(workflowName_dropdown, "wf_m_SAP_SMAX_Contact", "workflowName_dropdown");
		waitTill("5");

		click("execute_Button", execute_Button);
		waitTill("60");

		try {
			verifyElementPresent("succeeded", succeeded);

		} catch (Exception e) {
			verifyElementPresent("Failure", failure);
			Assert.fail();
		}

	}

	public void partner_Workflow() {
		selectFromDropDown(env_dropdown, "Test", "env_dropdown");
		waitTill("5");

		selectFromDropDown(folderName_dropdown, "INT_O2C_CUST_MP1_SMAX", "folderName_dropdown");
		waitTill("5");

		selectFromDropDown(workflowName_dropdown, "wf_m_SAP_SMAX_Account_Partner", "workflowName_dropdown");
		waitTill("5");

		click("execute_Button", execute_Button);
		waitTill("60");

		try {
			verifyElementPresent("succeeded", succeeded);

		} catch (Exception e) {
			verifyElementPresent("Failure", failure);
			Assert.fail();
		}

	}

	public void account_reports() {
		waitTill("10");
		click("Reports Tab", reports_Tab);
		waitTill("5");
		try {
			click("quick_Search", quick_Search);
			enter("quick_Search", quick_Search, "Sap to Smax accounts Report");
			waitTill("5");
			click("search_Account_Report", search_Account_Report);
			waitTill("5");
			click("customize_Button", customize_Button);
			waitTill("5");
			click("Edit button", edit_Button);
			click("date_input", date_input);
			// enter("date_input", date_input, "Today");
			enter("date_input", date_input, "11/19/2021");
			click("Ok Button", ok_Button);
			click("run_Report_Button", run_Report_Button);
			Utility.clearDirectory(AutomationConstants.DownloadsFolder);
			click("Export Details Button", export_Details);
			waitTill("5");
			selectFromDropDown(file_encoding, "Unicode", "file_encoding");
			selectFromDropDown(file_format, "Comma Delimited .csv", "file_format");
			waitTill("5");
			click("Export Button", export_Button);
			waitTill("5");
			// FileRenameUtility(AutomationConstants.DownloadsFolder,
			// "Smax_Accounts_Report");
			// waitTill("15");

		} catch (Exception e) {
			click("New Report Button", new_Report);
			waitTill("5");
			click("First Node", first_node);
			click("show_More", show_More);
			waitTill("5");
			click("account_reporttype", account_reporttype);
			waitTill("5");
			click("Create Button", create_Buttom);
			waitTill("5");
			click("show_dropdown", show_dropdown);
			waitTill("2");
			click("all_Accounts", all_Accounts);
			click("range_dropdown", range_dropdown);
			waitTill("2");
			click("all_Time", all_Time);

			try {
				click("add_Button", add_Button);
				waitTill("5");
				verifyElementPresent("input1", input1);
			} catch (Exception e1) {
				click("add_Button", add_Button);
			}

			click("input1", input1);
			waitTill("10");
			click("enterinput1", enterinput1);
			clear("enterinput1", enterinput1);
			enter("input1", enterinput1, "Last Modified Date");
			click("last_Modified_Date", last_Modified_Date);

			click("input2", input2);
			// enter("input1", input2, "Today");
			enter("input1", input2, "11/19/2021");

			click("Ok Button", ok_Button);

			try {
				click("add_Button", add_Button);
				waitTill("5");
				verifyElementPresent("input1", input1);
			} catch (Exception e1) {
				click("add_Button", add_Button);
			}
			click("input1", input1);
			waitTill("10");
			click("enterinput1", enterinput1);
			clear("enterinput1", enterinput1);
			enter("input1", enterinput1, "Last Modified By: Full Name");
			click("last_Modified_Date", last_Modified_name);

			click("input2", input2);
			enter("input1", input2, "System Informatica DataMigration");

			click("Ok Button", ok_Button);

			click("run_Report_Button", run_Report_Button);
			Utility.clearDirectory(AutomationConstants.DownloadsFolder);
			click("Export Details Button", export_Details);
			waitTill("5");

			click("Export Button", export_Button);
			waitTill("5");
			// FileRenameUtility(AutomationConstants.DownloadsFolder,
			// "Smax_Accounts_Report");
			// waitTill("15");

		}
	}

	public void contact_reports() {
		waitTill("10");
		// click("Reports Tab", reports_Tab);
		click("Reports Tab", reports_Tab_Selected);
		waitTill("5");
		try {
			click("quick_Search", quick_Search);
			enter("quick_Search", quick_Search, "Sap to Smax Contacts Report");
			waitTill("5");
			click("search_Account_Report", search_Contact_Report);
			waitTill("5");
			click("customize_Button", customize_Button);
			waitTill("5");
			click("Edit button", edit_Button);
			click("date_input", date_input);
			enter("date_input", date_input, "11/19/2021");
			click("Ok Button", ok_Button);
			click("run_Report_Button", run_Report_Button);
			Utility.clearDirectory(AutomationConstants.DownloadsFolder);
			click("Export Details Button", export_Details);
			click("Export Button", export_Button);
			waitTill("5");
			// FileRenameUtility(AutomationConstants.DownloadsFolder,
			// "Smax_Contacts_Report");
			// waitTill("10");
			click("date_input", date_input);
			// enter("date_input", date_input, "Today");
			enter("date_input", date_input, "11/19/2021");
			click("Ok Button", ok_Button);
			click("run_Report_Button", run_Report_Button);
//			Utility.clearDirectory(AutomationConstants.DownloadsFolder);
//			click("Export Details Button", export_Details);
//			selectFromDropDown(file_encoding, "Unicode", "file_encoding");
//			waitTill("2");
//			selectFromDropDown(file_format, "Comma Delimited .csv", "file_format");
//
//			click("Export Button", export_Button);
//			waitTill("10");
//			FileRenameUtility(AutomationConstants.DownloadsFolder, "Smax_Contacts_Report");
//			waitTill("10");

		} catch (Exception e) {
			click("New Report Button", new_Report);
			waitTill("5");
			click("First Node", first_node);
			click("show_More", show_More);
			waitTill("5");
			click("account_reporttype", account_reporttype);
			waitTill("5");
			click("Create Button", create_Buttom);
			waitTill("5");
			click("show_dropdown", show_dropdown);
			waitTill("2");
			click("all_Accounts", all_Accounts);
			click("range_dropdown", range_dropdown);
			waitTill("2");
			click("all_Time", all_Time);

			try {
				click("add_Button", add_Button);
				waitTill("5");
				verifyElementPresent("input1", input1);
			} catch (Exception e1) {
				click("add_Button", add_Button);
			}

			click("input1", input1);
			waitTill("10");
			click("enterinput1", enterinput1);
			clear("enterinput1", enterinput1);
			enter("input1", enterinput1, "Last Modified Date");
			click("last_Modified_Date", last_Modified_Date);

			click("input2", input2);
			enter("input1", input2, "11/19/2021");

			click("Ok Button", ok_Button);

			try {
				click("add_Button", add_Button);
				waitTill("5");
				verifyElementPresent("input1", input1);
			} catch (Exception e1) {
				click("add_Button", add_Button);
			}
			click("input1", input1);
			waitTill("10");
			click("enterinput1", enterinput1);
			clear("enterinput1", enterinput1);
			enter("input1", enterinput1, "Last Modified By: Full Name");
			click("last_Modified_Date", last_Modified_name);

			click("input2", input2);
			enter("input1", input2, "System Informatica DataMigration");

			click("Ok Button", ok_Button);

			click("run_Report_Button", run_Report_Button);
			Utility.clearDirectory(AutomationConstants.DownloadsFolder);
			click("Export Details Button", export_Details);
			waitTill("2");
			click("Export Button", export_Button);
			waitTill("5");
			// FileRenameUtility(AutomationConstants.DownloadsFolder,
			// "Smax_Contacts_Report");
//			Utility.clearDirectory(AutomationConstants.DownloadsFolder);
//			click("Export Details Button", export_Details);
//			selectFromDropDown(file_encoding, "Unicode", "file_encoding");
//			waitTill("2");
//			selectFromDropDown(file_format, "Comma Delimited .csv", "file_format");
//			waitTill("2");
//			click("Export Button", export_Button);
//			waitTill("10");
//			FileRenameUtility(AutomationConstants.DownloadsFolder, "Smax_Contacts_Report");

		}

	}

	public void partner_reports() {
		waitTill("10");
		click("Reports Tab", reports_Tab_Selected);
		// click("Reports Tab", reports_Tab);
		waitTill("5");
		try {
			click("quick_Search", quick_Search);
			enter("quick_Search", quick_Search, "Sap to Smax acc to acc Partner Report");
			waitTill("5");
			click("search_Partner_Report", search_Partner_Report);
			waitTill("5");
			click("customize_Button", customize_Button);
			waitTill("5");
			click("Edit button", partner_edit_Button);
			click("date_input", date_input);
			enter("date_input", date_input, "11/19/2021");
			click("Ok Button", ok_Button);
			click("run_Report_Button", run_Report_Button);
			Utility.clearDirectory(AutomationConstants.DownloadsFolder);
			click("Export Details Button", export_Details);
			waitTill("2");
			click("Export Button", export_Button);
			// FileRenameUtility(AutomationConstants.DownloadsFolder,
			// "Smax_Partner_Report");
			waitTill("5");

		} catch (Exception e) {
			click("New Report Button", new_Report);
			waitTill("5");
			click("Quick Find", quick_find);
			enter("Quick Find", quick_find, "Accounts to Account Partners Junctions");
			waitTill("5");
			click("account_partner_reporttype", account_partner_reporttype);
			waitTill("5");
			click("Create Button", create_Buttom);
			waitTill("5");
			click("show_dropdown", show_dropdown);
			waitTill("2");
			click("all_Accounts_partner", all_Accounts_partner);
			click("range_dropdown", range_dropdown);
			waitTill("2");
			click("all_Time", all_Time);

			try {
				click("add_Button", add_Button);
				waitTill("5");
				verifyElementPresent("input1", input1);
			} catch (Exception e1) {
				click("add_Button", add_Button);
			}

			click("input1", input1);
			waitTill("10");
			click("enterinput1", enterinput1);
			clear("enterinput1", enterinput1);
			enter("input1", enterinput1, "Account to Account Partner Junction: Last Modified Date");
			click("last_Modified_Date", account_partner_last_Modified_Date);

			click("input2", input2);
			enter("input1", input2, "11/19/2021");

			click("Ok Button", ok_Button);

			try {
				click("add_Button", add_Button);
				waitTill("5");
				verifyElementPresent("input1", input1);
			} catch (Exception e1) {
				click("add_Button", add_Button);
			}
			click("input1", input1);
			waitTill("10");
			click("enterinput1", enterinput1);
			clear("enterinput1", enterinput1);
			enter("input1", enterinput1, "Account to Account Partner Junction: Last Modified By");
			click("account_partner_last_Modified_name", account_partner_last_Modified_name);
			waitTill("3");
			click("input2", input2);
			enter("input2", input2, "System Informatica DataMigration");

			click("Ok Button", ok_Button);

			click("run_Report_Button", run_Report_Button);
			Utility.clearDirectory(AutomationConstants.DownloadsFolder);
			click("Export Details Button", export_Details);
			click("Export Button", export_Button);
			waitTill("5");
		}

	}

	public void validate_accounts_report() {
		waitTill("5");
		System.out.println("Validating report expected");

		expectedRecords = Excel.getSheetData1(AutomationConstants.SmaxAccounts, "Sheet1", 10);
		System.out.println(expectedRecords);
		try {
			System.out.println("Validating report actual");
			actualRecords = SOQLQuerys.GetAccountDetails();
			System.out.println(actualRecords);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		verifyUserDetails();

	}

	public void validate_contacts_report() {
		waitTill("5");
		logReport("Validating report", AutomationConstants.SmaxContacts);
		waitTill("5");
		System.out.println("Validating report expected");

		expectedRecords = Excel.getSheetData1(AutomationConstants.SmaxContacts, "Sheet1", 6);
		System.out.println(expectedRecords);
		try {
			System.out.println("Validating report actual");
			actualRecords = SOQLQuerys.GetContactsDetails();
			System.out.println(actualRecords);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		verifyContactsDetails();
	}

	public void FileRenameUtility(String path, String fileName) {
		File file = new File(path);
		System.out.println("Reading this " + file.toString());

		if (file.isDirectory()) {
			File[] files = file.listFiles();
			List<File> filelist = Arrays.asList(files);
			filelist.forEach(f -> {
				if (!f.isDirectory() && f.getName().startsWith("report")) {
					System.out.println("getAbsolutePath: " + f.getAbsolutePath());
					String temp = f.getName();
					String newName = f.getAbsolutePath().replace(temp, fileName + ".csv");
					try {
						System.out.println("New file name: " + newName);
						f.renameTo(new File(newName));
						isRenamed = true;
					} catch (Exception e) {
						System.out.println("Unable to rename file");
					}
				}
			});

		}
	}

	public static void verifyUserDetails() {
		for (int i = 0; i < expectedRecords.size(); i++) {
			int count = 0;
			if (expectedRecords.get(i).get("Name 3").length() > 0) {
				String temp = expectedRecords.get(i).get("Name 2") + " " + expectedRecords.get(i).get("Name 3") + " "
						+ expectedRecords.get(i).get("Name 4");
				expectedRecords.get(i).replace("Name 2", temp);

			}

			for (int j = 0; j < actualRecords.size(); j++) {
				if (expectedRecords.get(i).get("Name").equals(actualRecords.get(j).get("Name"))) {
					if (expectedRecords.get(i).get("Name 2").length() == 0) {
						logReport("PASS", "Name is " + expectedRecords.get(i).get("Name 2"));
						break;
					}

					else if (expectedRecords.get(i).get("Name 2").equals(actualRecords.get(j).get("Name 2"))) {
						logReport("PASS", "Name is " + expectedRecords.get(i).get("Name 2") + " and actual is "
								+ actualRecords.get(j).get("Name 2"));
						break;
					}
				}
				count++;
				if (count == actualRecords.size()) {
					logReport("FAIL", "unable to find the record with name = " + expectedRecords.get(i).get("Name")
							+ "and Name 2 = " + expectedRecords.get(i).get("Name 2"));
					Assert.fail();
				}
			}
		}
	}
	
	
	public void perform_SalesOrder_Check() {
		waitTill("10");
		waitForElement(installed_product_custom_Action_frame, "installed_product_custom_Action_frame");
		driver.switchTo().frame(installed_product_custom_Action_frame);
		waitTill("5");
		
		click("Check_SalesOrder_SFM", Check_SalesOrder_SFM);
		waitTill("10");
	}

	public static void verifyContactsDetails() {
		for (int i = 0; i < expectedRecords.size(); i++) {
			int count = 0;

			for (int j = 0; j < actualRecords.size(); j++) {
				if (expectedRecords.get(i).get("First Name").equals(actualRecords.get(j).get("FirstName"))) {
					if (expectedRecords.get(i).get("First Name").length() == 0) {
						logReport("PASS", "First Name is " + expectedRecords.get(i).get("First Name"));
						break;
					}

					else if (expectedRecords.get(i).get("Last name").equals(actualRecords.get(j).get("LastName"))) {
						logReport("PASS", "Last Name is " + expectedRecords.get(i).get("Last name") + " and actual is "
								+ actualRecords.get(j).get("LastName"));
						break;
					} else if (expectedRecords.get(i).get("Last name").length() == 0) {
						logReport("PASS", "Last Name is " + expectedRecords.get(i).get("Last name"));
						break;
					}
				}
				count++;
				if (count == actualRecords.size()) {
					logReport("FAIL",
							"unable to find the record with FirstName = " + expectedRecords.get(i).get("First Name")
									+ "and LastName = " + expectedRecords.get(i).get("Last name"));
					Assert.fail();
				}
			}
		}
	}

	public void validate_account_partner_report() {
		waitTill("5");
		logReport("Validating report", AutomationConstants.SmaxAccountPartner);
		waitTill("5");
		System.out.println("Validating report expected");

		expectedRecords = Excel.getSheetData1(AutomationConstants.SmaxAccountPartner, "Sheet1", 6);
		System.out.println(expectedRecords);
		try {
			System.out.println("Validating report actual");
			actualRecords = SOQLQuerys.GetAccountPartnerDetails();
			System.out.println(actualRecords);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		verifyAccountPartnerDetails();
	}

	public static void verifyAccountPartnerDetails() {
		for (int i = 0; i < expectedRecords.size(); i++) {
			int count = 0;

			for (int j = 0; j < actualRecords.size(); j++) {
				if ("00".concat(expectedRecords.get(i).get("Customer"))
						.contains(actualRecords.get(j).get("Account_SAP_Number"))) {
					if (expectedRecords.get(i).get("Description").length() == 0) {
						logReport("PASS", "Description is " + expectedRecords.get(i).get("Description"));
						break;
					}

					else if (expectedRecords.get(i).get("Description")
							.equals(actualRecords.get(j).get("Partner_Description__c"))) {
						logReport("PASS", "Description is " + expectedRecords.get(i).get("Description")
								+ " and actual is " + actualRecords.get(j).get("Partner_Description__c"));
						break;
					}
				}
				count++;
				if (count == actualRecords.size()) {
					logReport("FAIL",
							"unable to find the record with Customer = "
									+ "00".concat(expectedRecords.get(i).get("Customer")) + "and Description = "
									+ expectedRecords.get(i).get("Description"));
					Assert.fail();
				}
			}
		}
	}
}