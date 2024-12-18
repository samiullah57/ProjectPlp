package com.philips.pages;


import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.HashMap;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.philips.generic.AutomationConstants;
import com.philips.generic.Utility;
import com.sforce.soap.enterprise.AssignmentRuleHeader_element;

import freemarker.template.utility.CaptureOutput;
import cucumber.api.DataTable;
import cucumber.runtime.CucumberException;

/**
 * This class represents Service or Maintains contract Page
 * 
 * @author M1048601
 *
 */
public class EventPage extends BasePage {


	@FindBy(xpath = "//li[@id='home_Tab']")
	private WebElement homeTab;

	//	@FindBy(xpath = "//*[@id='createNewButton']")
	//	private WebElement createNewButton;
	//
	//	@FindBy(xpath = "//div[@id='createNewMenu']//a[text()='Event']")
	//	private WebElement createNewEvent;
	//	
	//	@FindBy(xpath = "//label[text()='Record Type of new record']/../..//select")
	//	private WebElement eventRecordType;
	//	
	//	@FindBy(xpath="//option[text()='ESMX Non Customer Type']")
	//	private WebElement recordtypevalue;
	//	
	//	@FindBy(xpath = "//label[text()='Assigned To']/../..//span[@class='lookupInput']//input")
	//	private WebElement assignto;
	//	
	//	@FindBy(xpath = "//input[@id='EndDateTime']")
	//	private WebElement endDate;
	//	
	//	@FindBy(xpath = "//input[@id='StartDateTime']")
	//	private WebElement startDate;
	//	
	//	@FindBy(xpath = "//label[text()='Subject']/../../..//Select")
	//	private WebElement subject;
	//	
	//	@FindBy(xpath = "//label[text()='Description']/../..//textarea")
	//	private WebElement Description;

	@FindBy(xpath="//a[text()='Account Assignment']")
	private WebElement accountAssignment;

	@FindBy(xpath="//input[@title='New']")
	private WebElement newbtn;

	@FindBy(xpath="//label[text()='Record Type of new record']/../..//select")
	private WebElement Assignmentrecordtype;

	@FindBy(xpath="//label[text()='Group Name']/../..//input")
	private WebElement groupname;

	@FindBy(xpath="//label[text()='Group Type']/../..//select")
	private WebElement grouptype;

	@FindBy(xpath="//label[text()='Parent']/../..//span[@class='lookupInput']//input")
	private WebElement parentfield;

	@FindBy(xpath="//img[@title='Parent Lookup (New Window)']")
	private WebElement parentlookup;

	@FindBy(xpath="//h2[@class='pageDescription']")
	private WebElement createdGroupId;

	@FindBy(xpath="//label[text()='Country']/../..//select")
	private WebElement countryfield;

	@FindBy(xpath="//input[@title='Add Child']")
	private WebElement addchild;

	@FindBy(xpath="//img[@title='Account Lookup (New Window)']")
	private WebElement accountlookup;

	@FindBy(xpath="//label[text()='Account']/../..//span[@class='lookupInput']//input")
	private WebElement accountName;

	@FindBy(xpath="//input[@class=' uiInput uiInputCheckbox uiInput--default uiInput--checkbox']")
	private WebElement checkbox_portal;

	@FindBy(xpath="//button[text()='Add Super Group/Group']")
	private WebElement addsupergrp;

	@FindBy(xpath="(//input[@placeholder='Type here...'])[2]")
	private WebElement searchgrp;

	@FindBy(xpath="(//button[text()='Search'])[2]")
	private WebElement searchbtn_grp;

	@FindBy(xpath="//input[@class='uiInput uiInputCheckbox uiInput--default uiInput--checkbox']")
	private WebElement grpcheckbox;

	@FindBy(xpath="//button[text()='Add']")
	private WebElement addbtn;

	//@FindBy(xpath="//button[text()='Save']")
	//private WebElement save;
	//
	@FindBy(xpath="//span[text()='Home']")
	private WebElement hometab;

	@FindBy(xpath="//span[text()='Locations']")
	private WebElement locationtab;

	@FindBy(xpath="//span[text()='Account']")
	private WebElement Accounttab;

	@FindBy(xpath="//span[text()='Cases']")
	private WebElement casestab;

	@FindBy(xpath="//span[text()='Installed Products']")
	private WebElement IPtab;


	@FindBy(xpath="//span[text()='Documents']")
	private WebElement documenttab;

	@FindBy(xpath="//button[text()='Reports']")
	private WebElement reportstab;

	@FindBy(xpath="//button[text()='More']")
	private WebElement Morebtn;

	@FindBy(xpath="//button[text()='Go to Calendar']")
	private WebElement calender;

	@FindBy(xpath="//span[text()='Contract And Warranty']")
	private WebElement contractandWarrantyab;


	@FindBy(xpath="//button[text()='Request Support']")
	private WebElement requestSupportbtn;

	@FindBy(xpath="//a[text()='Systems Down and/or Requiring Emergency Support']")
	private WebElement sys1;

	@FindBy(xpath="//a[text()='Systems Partial Down / Suffering Intermittent Problems']")
	private WebElement sys2;

	@FindBy(xpath="//a[text()='Systems with minor Problems']")
	private WebElement sys3;

	@FindBy(xpath="//a[text()='Systems without Problems']")
	private WebElement sys4;

	@FindBy(xpath="//a[text()='Created in last 30 days']")
	private WebElement servicecases30days;

	@FindBy(xpath="//a[text()='Closed in last 30 days']")
	private WebElement servicecasescloseddays;

	@FindBy(xpath="//a[text()='Currently Open']")
	private WebElement servicecasesopen;
	//
	@FindBy(xpath="//span[text()='Report a Malfunction / Problem with a Product']")
	private WebElement reportMalfunction;

	@FindBy(xpath="//span[text()='Request a Supplementary Service']")
	private WebElement reportaSupplymentary;

	@FindBy(xpath="//span[text()='Parts Order for Repair']")
	private WebElement partsorderofrepair;

	@FindBy(xpath="//span[text()='Installed Product']")
	private WebElement IPcol;

	@FindBy(xpath="//span[text()='Product Name']")
	private WebElement PNcol;

	@FindBy(xpath="//span[text()='Modality']")
	private WebElement Modalitycol;

	@FindBy(xpath="//span[text()='Ship to']")
	private WebElement shiptocol;

	@FindBy(xpath="//span[text()='UDI']")
	private WebElement UDIcol;


	@FindBy(xpath="//span[text()='Account Name']")
	private WebElement AccountNamecol;

	@FindBy(xpath="//span[text()='Custom IP Name']")
	private WebElement customIPcol;

	@FindBy(xpath="//span[text()='Serial Number']")
	private WebElement SNcol;

	@FindBy(xpath="//span[text()='Tech ID']")
	private WebElement TechIDcol;

	@FindBy(xpath="//span[text()='Room/Department']")
	private WebElement Roomdeptcol;

	@FindBy(xpath="//span[text()='Customer Inventory Number']")
	private WebElement customerInventoryNumcol;

	@FindBy(xpath="//span[text()='Contract']")
	private WebElement contractcol;

	@FindBy(xpath="//span[text()='Expiration Status']")
	private WebElement ExpirationStatuscol;

	@FindBy(xpath="//span[text()='SLCP']")
	private WebElement SLCPcol;

	@FindBy(xpath="//button[text()='Export']")
	private WebElement exportbtn;

	@FindBy(xpath="//button[text()='Update IP Info']")
	private WebElement updateIPInfobtn;

	@FindBy(xpath="//button[text()='Clear Filter']")
	private WebElement clearfilterbtn;

	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement enterip;

	@FindBy(xpath="//button[text()='Generate EOL Mail']")
	private WebElement generateEOLMail;

	@FindBy(xpath="//span[text()='EOL Mail Sent Successfully']")
	private WebElement confirmationmsgforemail;

	@FindBy(xpath="//a[@class='uiOutputURL']")
	private WebElement accountlink;

	@FindBy(xpath="//button[text()='Mass Update']")
	private WebElement massupdatebtn;

	@FindBy(xpath="(//span[@class='slds-checkbox--faux'])[2]")
	private WebElement checkbox1;

	@FindBy(xpath="(//span[@class='slds-checkbox--faux'])[3]")
	private WebElement checkbox2;

	@FindBy(xpath="(//span[text()='Custom IP Name']/../../..//th[@class='slds-is-sortable slds-text-title--caps']/../..//input)[1]")
	private WebElement customeipname_sample1;

	@FindBy(xpath="//label[text()='Number']")
	private WebElement numberfield;

	@FindBy(xpath="//label[text()='Serial Number']")
	private WebElement SNfield;

	@FindBy(xpath="//label[text()='Account']")
	private WebElement Accfield;

	@FindBy(xpath="//label[text()='Product Name']")
	private WebElement prodnumberfield;

	@FindBy(xpath="//label[text()='Tech ID']")
	private WebElement TechIdfield;

	@FindBy(xpath="//label[text()='Location']")
	private WebElement locfield;

	@FindBy(xpath="//label[text()='System End of Life']")
	private WebElement SEOLfield;

	@FindBy(xpath="//label[text()='Modality']")
	private WebElement modalityfield;

	@FindBy(xpath="//label[text()='Customer Inventory Number']")
	private WebElement CInumberfield;

	@FindBy(xpath="//label[text()='Entitled']")
	private WebElement Entitledfield;

	@FindBy(xpath="//label[text()='Product']")
	private WebElement Productfield;

	@FindBy(xpath="//button[text()='Add/Change IP Detail']")
	private WebElement addchangebtn;

	@FindBy(xpath="//label[text()='Custom IP Name']/../..//textarea")
	private WebElement customIPName;

	@FindBy(xpath="//label[text()='Room/Department']/../..//textarea")
	private WebElement roomdeptName;

	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement columcheckboxs;

	@FindBy(xpath="//span[text()='Priority']/../..//select")
	private WebElement prioritydropdown;

	@FindBy(xpath="//option[text()='2-System Down']")
	private WebElement system2down;

	@FindBy(xpath="//option[text()='3-System Restricted']")
	private WebElement system3restricted;

	@FindBy(xpath="//option[text()='4-Intermittent Problem']")
	private WebElement intermittentprob;

	@FindBy(xpath="//option[text()='5-Scheduled Activity']")
	private WebElement scheduleactivity;

	@FindBy(xpath="//a[@class='links uiOutputURL']")
	private WebElement clickonanyIP;


	@FindBy(xpath="//button[text()='Select an IP to Create Case']")
	private WebElement selectIPtoCreatecasebtn;

	@FindBy(xpath="//input[@value='No']")
	private WebElement novalue;

	@FindBy(xpath="//span[text()='Type of Service']/../..//select")
	private WebElement Typeofservice;

	@FindBy(xpath="//span[text()='Contact Name']/../..//input")
	private WebElement contactname;

	@FindBy(xpath="//span[text()='Phone']/../..//input")
	private WebElement phone;

	@FindBy(xpath="//span[text()='Email']/../..//input")
	private WebElement Email;

	@FindBy(xpath="//laebl[text()='Callback Number']/../..//input")
	private WebElement callbackNumber;

	@FindBy(xpath="//span[text()='Same as Phone?']/../..//input[@type='checkbox']")
	private WebElement sameaspHone;
	
	@FindBy(xpath="//*[text()='Callback Number']/following-sibling::div/input")
	private WebElement callback_number;

	@FindBy(xpath="//button[text()='Manage additional contacts']")
	private WebElement manageAdditionalcontactsbtn;

	@FindBy(xpath="//label[text()='Subject']/../..//textarea")
	private WebElement subjectfield;

	@FindBy(xpath="(//label[text()='Description']/../..//textarea)[2]")
	private WebElement description;

	@FindBy(xpath="(//label[text()='Description']/../..//textarea)[1]")
	private WebElement description1;
	
	@FindBy(xpath="(//label[text()='Parts Order Reason']/../..//textarea)[2]")
	private WebElement partsOrderReason;

	@FindBy(xpath="(//label[text()='Patient Health Information']/../..//textarea)")
	private WebElement patienthealthInfo;

	@FindBy(xpath="//span[text()='Upload File from Case Detail Page']")
	private WebElement uploadfilefield;

	@FindBy(xpath="//button[text()='Create Case']")
	private WebElement Createcasebtn;

	@FindBy(xpath="//label[text()='Case Number']")
	private WebElement caseNumber;

	@FindBy(xpath="//label[text()='Status']")
	private WebElement status;

	@FindBy(xpath="//label[text()='Subject']")
	private WebElement Subject;

	@FindBy(xpath="//label[text()='Customer Contact']")
	private WebElement customercontact;

	@FindBy(xpath="//label[text()='Description']")
	private WebElement verifyDescription;

	@FindBy(xpath="//label[text()='Priority']")
	private WebElement Priority;

	@FindBy(xpath="//label[text()='Start Date']")
	private WebElement StartDate;

	@FindBy(xpath="//label[text()='PHI Data']")
	private WebElement PHIData;

	@FindBy(xpath="//a[@data-label='Case Activities']")
	private WebElement caseactivitiestab;

	@FindBy(xpath="//a[@data-label='Case Tracking']")
	private WebElement casetrackingtab;

	@FindBy(xpath="//a[@data-label='File Upload']")
	private WebElement fileuploadtab;

	@FindBy(xpath="//label[text()='Installed Product']/../..//a")
	private WebElement IPprod;

	@FindBy(xpath="//button[text()='Add Case Activity']")
	private WebElement addcaseactivitybtn;

	@FindBy(xpath="(//label[text()='Description']/../..//textarea)")
	private WebElement Desfield;

	@FindBy(xpath="//label[text()='PHI Data']/../..//img[@alt='True']")
	private WebElement PHIDatacheckbox;

	@FindBy(xpath="(//label[text()='Case Number']/../..//span)[1]")
	private WebElement getcaseNumber;

	@FindBy(xpath="//span[text()='Account Number']")
	private WebElement AccountNumcol;

	@FindBy(xpath="//span[text()='Street']")
	private WebElement Streetcol;

	@FindBy(xpath="//span[text()='City']")
	private WebElement Citycol;

	@FindBy(xpath="//span[text()='Postal Code']")
	private WebElement Postalcodecol;

	@FindBy(xpath="//span[text()='State/Province']")
	private WebElement stateProvincecol;

	@FindBy(xpath="//span[text()='Country']")
	private WebElement countrycol;

	@FindBy(xpath="//a[text()='Planned Visits']")
	private WebElement plannedvisittab;

	@FindBy(xpath="//a[text()='SLCP']")
	private WebElement SLCPtab;

	@FindBy(xpath="//th[text()='Case Number']")
	private WebElement caseNumber_PV;

	@FindBy(xpath="//th[text()='Subject']")
	private WebElement Subject_PV;

	@FindBy(xpath="//th[text()='Event Type']")
	private WebElement EventType_PV;

	@FindBy(xpath="//th[text()='Priority']")
	private WebElement Priority_PV;

	@FindBy(xpath="//th[text()='Scheduled Start']")
	private WebElement Schedulestart_PV;

	@FindBy(xpath="//th[text()='Scheduled Duration']")
	private WebElement Scheduleduration_PV;

	@FindBy(xpath="//th[text()='Name of FSE(s)']")
	private WebElement NameofFSE;

	@FindBy(xpath="//label[text()='Hardware Installed Product']")
	private WebElement HardwareInstalledProd;

	@FindBy(xpath="//label[text()='Software Installed Product']")
	private WebElement SoftwareInstalledProduct;

	@FindBy(xpath="//label[text()='Hardware IP Description']")
	private WebElement HardwareIPDescription;

	@FindBy(xpath="//label[text()='Software IP Description']")
	private WebElement softwareIPDescription;

	@FindBy(xpath="//label[text()='Hardware Serial Number']")
	private WebElement Hardwareserialnum;

	@FindBy(xpath="//label[text()='Hardware Material Number']")
	private WebElement HardwareMatNum;

	@FindBy(xpath="//label[text()='Software Material Number']")
	private WebElement softwareMatNum;

	@FindBy(xpath="//label[text()='Last Activation Date and Time']")
	private WebElement lastactivation;

	@FindBy(xpath="//label[text()='Software Version Number']")
	private WebElement softwareVersionNum;

	@FindBy(xpath="//label[text()='Options']")
	private WebElement Options;

	@FindBy(xpath="//label[text()='Software Install Entitle']")
	private WebElement softwareInstallEntitle;

	@FindBy(xpath="//label[text()='Software Install Remain']")
	private WebElement softwareinstallremain;

	@FindBy(xpath="//label[text()='Technical Capabilities']")
	private WebElement technicalcapbilities;

	@FindBy(xpath="//label[text()='Global Types']")
	private WebElement GlobalTypes;

	@FindBy(xpath="//span[text()='Location Name']")
	private WebElement LocationName;

	@FindBy(xpath="(//span[text()='Product Modality'])[2]")
	private WebElement ProductModality;

	@FindBy(xpath="//button[text()='Remote Access Audit Data']")
	private WebElement remoteAccessAuditDate;

	@FindBy(xpath="//button[text()='Create User']")
	private WebElement CreateUsertbtn;


	@FindBy(xpath="//span[text()='Contract Header']")
	private WebElement Contractheader;

	@FindBy(xpath="//span[text()='Contract']")
	private WebElement Contract;

	@FindBy(xpath="//span[text()='Customer PO #']")
	private WebElement ContractPO;

	@FindBy(xpath="//span[text()='Service Plan']")
	private WebElement servieplan;

	@FindBy(xpath="//span[text()='Start Date']")
	private WebElement startdate;

	@FindBy(xpath="//span[text()='End Date']")
	private WebElement end_Date;

	@FindBy(xpath="//span[text()='Location']")
	private WebElement Location;

	@FindBy(xpath="//span[text()='Expiration Status']")
	private WebElement expiationStatus;

	@FindBy(xpath="//a[contains(text(),'CON')]")
	private WebElement selectcontract;

	@FindBy(xpath="//label[text()='Contract Header']")
	private WebElement Contractheaderlabel;

	@FindBy(xpath="//span[text()='Contract']")
	private WebElement Contractlabel;

	@FindBy(xpath="//label[text()='Customer PO #']")
	private WebElement ContractPOlabel;

	@FindBy(xpath="//label[text()='Service Plan']")
	private WebElement servieplanlabel;

	@FindBy(xpath="//span[text()='Location']")
	private WebElement Locationlabel;

	@FindBy(xpath="//label[text()='Location Name']")
	private WebElement LN;

	@FindBy(xpath="//label[text()='Account Number']")
	private WebElement AccountNumber;

	@FindBy(xpath="//label[text()='Street']")
	private WebElement Streetlabel;

	@FindBy(xpath="//label[text()='City']")
	private WebElement Citylabel;

	@FindBy(xpath="//label[text()='Country']")
	private WebElement Countrylabel;

	@FindBy(xpath="//label[text()='Postal Code']")
	private WebElement Postalcodelabel;

	@FindBy(xpath="//a[text()='Cases']")
	private WebElement cases_tab;

	@FindBy(xpath="//a[text()='Installed Products']")
	private WebElement IP_tab;

	@FindBy(xpath="//a[text()='Warranties']")
	private WebElement Warranties;

	@FindBy(xpath="//a[text()='Documents']")
	private WebElement Documentstab;

	@FindBy(xpath="//a[text()='Entitlements']")
	private WebElement Entitlementstab;

	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactstab;

	@FindBy(xpath="//a[text()='Contracts']")
	private WebElement contractstab;

	@FindBy(xpath="//button[text()='Contact Customer Service']")
	private WebElement ContactCustomerService;

	@FindBy(xpath="//span[text()='Priority']")
	private WebElement prioritylabel;

	@FindBy(xpath="//span[text()='Case Number']")
	private WebElement CaseNumber_label;

	@FindBy(xpath="//span[text()='Subject']")
	private WebElement Subjectlabel;

	@FindBy(xpath="//span[text()='Status']")
	private WebElement Statuslabel;

	@FindBy(xpath="//span[text()='Event Type']")
	private WebElement eventType;

	@FindBy(xpath="//span[text()='Start Date']")
	private WebElement start_Date;


	@FindBy(xpath="//label[text()='Title']/../..//input")
	private WebElement title;

	@FindBy(xpath="//label[text()='First Name']/../..//input")
	private WebElement FirstName;

	@FindBy(xpath="//label[text()='Last Name']/../..//input")
	private WebElement Lastname;

	@FindBy(xpath="//label[text()='Email']/../..//input")
	private WebElement profileEmail;

	@FindBy(xpath="//label[text()='Phone']/../..//input")
	private WebElement Phone;

	@FindBy(xpath="//label[text()='Extension']/../..//input")
	private WebElement Extension;

	@FindBy(xpath="//label[text()='Mobile Phone']/../..//input")
	private WebElement MobilePhone;


	@FindBy(xpath="//span[text()='Language']/../..//select")
	private WebElement Language;

	@FindBy(xpath="//span[text()='Locale']/../..//select")
	private WebElement Locale;

	@FindBy(xpath="//span[text()='Time Zone']/../..//select")
	private WebElement TimeZone;

	@FindBy(xpath="//label[text()='Portal Authorizations']/../..//input")
	private WebElement PortalAuthorizations;

	@FindBy(xpath="//label[text()='End of Life Subscription']/..//span[@class='slds-checkbox_faux']")
	private WebElement endofLife;

	@FindBy(xpath="//label[text()='EOL Subscription Number of Months']/../..//select")
	private WebElement EOLsubscription;

	@FindBy(xpath="//button[text()='Change Password']")
	private WebElement changepasswordbtn;

	@FindBy(xpath="//span[text()='Old Password']/../../..//input")
	private WebElement oldpassword;

	@FindBy(xpath="//span[text()='New Password']/../../..//input")
	private WebElement newpassword;

	@FindBy(xpath="//input[@class='search-field input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input']")
	private WebElement portalglobalserch;

	@FindBy(xpath="//button[text()='Reports']")
	private WebElement reportTab;

	@FindBy(xpath="//a[@title='All Folders']")
	private WebElement allfolders;

	@FindBy(xpath="//button[text()='All Cases']")
	private WebElement allcases;

	@FindBy(xpath="//button[text()='Open Cases']")
	private WebElement opencases;

	@FindBy(xpath="//button[text()='History']")
	private WebElement History;

	@FindBy(xpath="//button[text()='Planned']")
	private WebElement Planned;

	@FindBy(xpath="//button[text()='Clear Filter']")
	private WebElement ClearFilter;

	@FindBy(xpath="//button[text()='Closed Before ']")
	private WebElement ClosedBefore;

	@FindBy(xpath="//span[text()='Document Type']/../..//select")
	private WebElement documenttype;

	@FindBy(xpath="//span[text()='Event Type']/../..//select")
	private WebElement EventType;

	@FindBy(xpath="//span[text()='Select Object']/../..//select")
	private WebElement SelectObject;

	@FindBy(xpath="//label[text()='Created Date']/../..//input")
	private WebElement createdDate;

	@FindBy(xpath="//label[text()='Modality']/../..//input")
	private WebElement Modality;

	@FindBy(xpath="//button[text()='Apply Filters']")
	private WebElement ApplyFilters;

	@FindBy(xpath="//button[text()='Clear']")
	private WebElement Clear;

	@FindBy(xpath="//option[text()='Customer Service Report / Action Notification Report (FCO)']")
	private WebElement servicereportoptn;

	@FindBy(xpath="//option[text()='Test and Inspection Results']")
	private WebElement TestandInspectionResultsoptn;

	@FindBy(xpath="//option[text()='Quotations']")
	private WebElement Quotationsoptn;

	@FindBy(xpath="//option[text()='Incident']")
	private WebElement Incident;

	@FindBy(xpath="//option[text()='Predictive / Preventative Maintenance']")
	private WebElement prdectivemaintainence;

	@FindBy(xpath="//option[text()='Installation']")
	private WebElement Installation;

	@FindBy(xpath="//option[text()='Field Change Order']")
	private WebElement FieldChangeOrder;

	@FindBy(xpath="//option[text()='Customer Support']")
	private WebElement CustomerSupport;

	@FindBy(xpath="//option[text()='Supplementary Services']")
	private WebElement SupplementaryServices;

	@FindBy(xpath="//option[text()='Parts Supply Only']")
	private WebElement PartsSupplyOnly;

	@FindBy(xpath="//option[text()='Proactive Monitoring']")
	private WebElement ProactiveMonitoring;

	@FindBy(xpath="//option[text()='Contracts']")
	private WebElement Contracts;

	@FindBy(xpath="//option[text()='Installed Product']")
	private WebElement InstalledProduct;

	@FindBy(xpath="//option[text()='Account']")
	private WebElement Account;

	@FindBy(xpath="//option[text()='Warranty']")
	private WebElement Warranty;

	@FindBy(xpath="//option[text()='Location']")
	private WebElement Locationoptn;

	@FindBy(xpath="//span[text()='Today']")
	private WebElement Today;

	@FindBy(xpath="//span[text()='Last 7 Days']")
	private WebElement Last7Days;

	@FindBy(xpath="//span[text()='Last 30 Days']")
	private WebElement Last30Days;

	@FindBy(xpath="//span[text()='Last 12 Months']")
	private WebElement Last12Months;

	@FindBy(xpath="//span[text()='Last Year']")
	private WebElement LastYear;

	@FindBy(xpath="//span[text()='Year to Date']")
	private WebElement YeartoDate;

	@FindBy(xpath="//button[text()='CS Portal Public Folder']")
	private WebElement csportalFolder;

	@FindBy(xpath="//button[text()='Installed Products - Customer references']")
	private WebElement IPBtn;

	@FindBy(xpath="(//span[text()='Installed Product: Installed Product ID'])[2]")
	private WebElement IPID;


	@FindBy(xpath="(//span[text()='TechIdentNo.'])[2]")
	private WebElement TechIdentNo;

	@FindBy(xpath="(//span[text()='IP Customer Description'])[2]")
	private WebElement IPCustomerdes;

	@FindBy(xpath="(//span[text()='Customer Inventory #'])[2]")
	private WebElement CustomerInventory;

	@FindBy(xpath="(//span[text()='Room/Dept'])[2]")
	private WebElement Room_Dept;


	@FindBy(xpath="//iframe[@class='isView reportsReportBuilder']")
	private WebElement frame;

	@FindBy(xpath="//span[contains(text(),'Please change your selection accordingly')]")
	private WebElement downloaderror;

	@FindBy(xpath="//button[text()='Exclude/Include IP']")
	private WebElement Exclude_Include_btn;


	@FindBy(xpath="//button[text()='Include']")
	private WebElement Include_btn;

	@FindBy(xpath="//input[@placeholder='Enter IP number']")
	private WebElement IPenterfield;


	@FindBy(xpath="//a[contains(text(),'0116')]/../preceding-sibling::td//input")
	private WebElement checkbox;

	@FindBy(xpath="//button[text()='Download']")
	private WebElement downloadbtn;

	@FindBy(xpath="//input[@placeholder='Search Accounts...']")
	private WebElement searchAcc;
	
	
	@FindBy(xpath="//button[text()='Select Records']")
	private WebElement selectRecordsButton;
	
		@FindBy(xpath="//input[@title=' Parts Ordering']")
		private WebElement partsorderinglink;
		
		@FindBy(xpath="//input[contains(@name,'ProdCode1')]")
		private WebElement productcodeinput;
		
	
		
		@FindBy(xpath="//a//img[@title='Click To Add Parts']")
	    private WebElement clickaddicon;
		
	//	@FindBy(xpath="//td[contains(text(),'ZSPS')]")
	//	private WebElement zrep;
	//	
		@FindBy(xpath="//input[@value='Get Entitlement']")
		private WebElement getEntitlement;
		
		@FindBy(xpath="//input[@value='GATP Simulation']")
	    private WebElement GATPsimulation;
		
		@FindBy(xpath="//input[@value='Transfer To SAP']")
		private WebElement transfertoSAP;
		
		@FindBy(xpath="//div[text()='Transferred to SAP']")
		private WebElement TransferSAPsuccessmsg;
		
	//	@FindBy(xpath="//input[@value='Receive Parts']")
	//	private WebElement receivepartslink;
		
		@FindBy(xpath="//iframe[@title='ESMX_Service_Order_Wizard_Lite']")
		private WebElement ESMXFrame;
		


	public static String SuperGN;
	public static String ID;
	public static String parentgroup;
	public static String childgroup;
	public static String ChildGN;
	public static String CaseNumber;


	public EventPage(WebDriver driver) {
		super(driver);
	}

	//	public void clickonHome()
	//	{
	//		click("Home Tab", homeTab);
	//		
	//	}
	//	
	//	public void createNewEvent(String subject2){
	//		waitForElement(createNewButton, "create new Button");
	//		click("Create New Event", createNewButton);
	//		click("createNewEvent", createNewEvent);
	//		waitForElement(eventRecordType, "eventRecordType");
	//		click("eventRecordType", eventRecordType);
	//		click("recordtypevalue", recordtypevalue);
	//		click("continue button", continueButton);
	//		waitForElement(subject, "subject");
	//		click("subject", subject);
	//		  WebElement subjectvalue=driver.findElement(By.xpath("//option[text()='"+subject2+"']"));
	//		click("subject value", subjectvalue);
	//		enter("description", Description,"Testing");
	//		String startdate=Datevalue("M/d/YYYY", 0, 1, 0);
	//		enter("startdate", startDate, startdate);
	//		String enddate=Datevalue("M/d/YYYY", 0, 1, 0);	 
	//		enter("endDate", endDate, enddate);	 
	//		click("save", save_eventtype);
	//		waitTill("5");
	//		WebElement record=driver.findElement(By.xpath("//li[contains(text(),'"+startdate+"')]"));
	//		if(verifyElementPresent("record", record)){
	//			WebElement subjectrecord=driver.findElement(By.xpath("//a[contains(text(),'"+subject2+"')]"));
	//			verifyElementPresent("subjectrecord", subjectrecord);
	//			logReport("INFO", "Event got created");
	//		}
	//	}

	public void clickonAccountAssignment() {
		// TODO Auto-generated method stub
		click("Account Assignments", accountAssignment);
	}

	public void createAssignment(String recordtype) {
		// TODO Auto-generated method stub
		click("New button", newbtn);
		click("Assignment Record type",Assignmentrecordtype);
		WebElement type=driver.findElement(By.xpath("//select//option[text()='"+recordtype+"']"));
		click("recordtype", type);
		click("continue button", continueButton);
	}

	public void creategroup(String grouptype,String country) {
		// TODO Auto-generated method stub
		switch(grouptype){
		case "Super":
			SuperGN="AutomationTest"+Utility.getFormatedDateTime();
			enter("Group name",groupname,SuperGN);
			WebElement stype=driver.findElement(By.xpath("//select//option[text()='"+grouptype+"']"));
			click("grouptype", stype);
			waitTill("5");
			click("save", Save);
			waitSpinnerToDisappear();
			ID=createdGroupId.getText();
			parentgroup=driver.getCurrentUrl();
			break;
		case "Group":
			ChildGN="AutomationTest"+Utility.getFormatedDateTime();
			enter("Group name",groupname,ChildGN);
			WebElement type=driver.findElement(By.xpath("//select//option[text()='"+grouptype+"']"));
			click("grouptype", type);
			enter("Parent Field", parentfield, ID);
			click("country field", countryfield);
			WebElement countrytype=driver.findElement(By.xpath("//select//option[text()='"+country+"']"));
			click("countrytype", countrytype);
			click("save", Save);
			waitSpinnerToDisappear();
			childgroup=driver.getCurrentUrl();
			break;
		}
	}

	public void clickonaddchild() {
		// TODO Auto-generated method stub
		click("Add child",addchild);
		waitTill("5");
	}



	public void addAccount(String accountname2) {
		// TODO Auto-generated method stub
		enter("Account Name", accountName, accountname2);
		//click("Account lookup", accountlookup);
		waitTill("5");
		/*switchToTab(1);
		waitTill("5");
		WebElement acc=driver.findElement(By.xpath("//a[text()='"+accountname2+"']"));
		click("Account", acc);
		driver.close();
		switchToTab(0);*/
		click("save", Save);
		waitTill("10");
		waitSpinnerToDisappear();
		driver.get(childgroup);
	}

	public void clickonCSPortalUserAssignment()
	{
		// TODO Auto-generated method stub
		click("CS Portal User Assignment", CSPortal);
	}

	public void searchPortal(String portalname) {
		enter("Search Portal",searchportal, portalname);
		click("search button",searchbtn);
		waitSpinnerToDisappear();
		waitForElement(checkbox_portal, "Portal checkbox");
		click("Portal checkbox", checkbox_portal);
		waitSpinnerToDisappear();
		waitTill("5");
	}
	public void Addsupergrp() {
		click("Add super group", addsupergrp);
		enter("Searchgroup",searchgrp, ChildGN);
		click("search button",searchbtn_grp);
		waitTill("5");
		click("Group checkbox", grpcheckbox);
		click("add", addbtn);
		waitTill("5");
		click("save user assignment", Save);
		try 
		{
			Robot robot2=new Robot();
			robot2.keyPress(KeyEvent.VK_ENTER);
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert is present");
			alert.accept();
			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			waitSpinnerToDisappear();
			try 
			{
				Alert alert1 = driver.switchTo().alert();
				System.out.println("Alert is present");
				alert1.accept();
				Robot robot1=new Robot();
				robot1.keyPress(KeyEvent.VK_ENTER);
			}
			catch(NoAlertPresentException e){
				System.out.println("alert is not present");
			}
		}
		catch(NoAlertPresentException e){
			System.out.println("alert is not present");
		}catch(Exception e) {}
		waitSpinnerToDisappear();
		waitTill("5");
	}


	public void verifyPortalTabs() 
	{
		// TODO Auto-generated method stub
		verifyElementPresent("Home Tab", hometab);
		verifyElementPresent("Locations Tab",locationtab);
		verifyElementPresent("Account Tab", Accounttab);
		verifyElementPresent("Cases Tab", casestab);
		verifyElementPresent("installedproduct Tab", IPtab);
		verifyElementPresent("More button", Morebtn);
		verifyElementPresent("Document Tab", documenttab);
		verifyElementPresent("Contract and Warranty Tab", contractandWarrantyab);
		verifyElementPresent("Reports button", reportstab);
	}

	public void verifyCalendar()
	{
		verifyElementPresent("Calendar on homepage", calender);
	}

	public void verifyRequestSupport_btn() {
		// TODO Auto-generated method stub
		verifyElementPresent("Request support button", requestSupportbtn);
		click("Request support button", requestSupportbtn);
		verifyElementPresent("Report Malfunction", reportMalfunction);
		verifyElementPresent("Report supplymentary", reportaSupplymentary);
		verifyElementPresent("Parts order for repair", partsorderofrepair);
	}

	public void verifyNumberofSystem()
	{
		verifyElementPresent("system 1", sys1);
		verifyElementPresent("system 2", sys2);
		verifyElementPresent("system 3", sys3);
		verifyElementPresent("system 4", sys4);
	}

	public void verifyServiceCases() {
		// TODO Auto-generated method stub
		verifyElementPresent("service cases update", servicecasescloseddays);
		verifyElementPresent("service cases update", servicecases30days);
		verifyElementPresent("service cases update", servicecasesopen);
	}

	public void clickonTab(String tab) {
		WebElement Tab=driver.findElement(By.xpath("//span[text()='"+tab+"']"));
		click(tab+"Tab", Tab);
		waitTill("5");
		driver.navigate().refresh();
	}

	public void verifyColumnsonIPpage() {
		// TODO Auto-generated method stub
		verifyElementPresent("INstalled Product column", IPcol);
		verifyElementPresent("ProductName column", PNcol);
		verifyElementPresent("Modality column", Modalitycol);
		verifyElementPresent("customIP column", customIPcol);
		verifyElementPresent("serial number column", SNcol);
		verifyElementPresent("Tech ID column", TechIDcol);
		verifyElementPresent("Room and department column", Roomdeptcol);
		verifyElementPresent("customer Inventorycolumn", customerInventoryNumcol);
		verifyElementPresent("contract column", contractcol);
		verifyElementPresent("Expiration column", ExpirationStatuscol);
		verifyElementPresent("SLCP column", SLCPcol);
		verifyElementPresent("exportbtn", exportbtn);
		verifyElementPresent("updateIPInfobtn", updateIPInfobtn);
		verifyElementPresent("clearfilterbtn", clearfilterbtn);

	}

	public void enterIP(String ip)  {
		// TODO Auto-generated method stub
		waitTill("5");
		click("enterip", enterip);
		waitTill("5");
		enterip.clear();
		enter("enter ip", enterip, ip);
		WebElement IP=driver.findElement(By.xpath("//a[text()='"+ip+"']"));
		click("IP", IP);
		waitSpinnerToDisappear();
		try 
		{
			Alert alert1 = driver.switchTo().alert();
			System.out.println("Alert is present");
			alert1.accept();
			Robot robot1=new Robot();
			robot1.keyPress(KeyEvent.VK_ENTER);
		}
		catch(NoAlertPresentException e){
			System.out.println("alert is not present");
		}catch(Exception e) {}
	}

	public void generateEOLMail() {
		// TODO Auto-generated method stub
		click("Generate EOL Mail", generateEOLMail);
		waitTill("5");
		verifyElementPresent("confirmation message", confirmationmsgforemail);

	}

	public void clickupdateIPinfobtn() {
		// TODO Auto-generated method stub
		click("updateIPInfobtn", updateIPInfobtn);
	}

	public void verifybtnsonUpdateInfoIpPage() {
		// TODO Auto-generated method stub
		verifyElementPresent("save button", saveButton);
		verifyElementPresent("cancel button", cancelButton);
		verifyElementPresent("Mass update button", massupdatebtn);
	}

	public void massupdate(){
		click("IP Checkbox", checkbox1);
		click("IP Checkbox", checkbox2);
		click("Mass update button", massupdatebtn);
		String customsample= "AutomationTesting"+Utility.getFormatedDateTime();
		enter("custom ip name", customeipname_sample1,customsample);
		pressEnter();
		waitTill("30");
		click("save", saveButton);
		waitSpinnerToDisappear();
		waitTill("5");
		WebElement verifycustomipname=driver.findElement(By.xpath("//div[text()='"+customsample+"']"));
		verifyElementPresent("custom IP ", verifycustomipname);
	}

	public void verifyProductDetails() {
		// TODO Auto-generated method stub
		verifyElementPresent("numberfield", numberfield);
		verifyElementPresent("SNfield", SNfield);
		verifyElementPresent("Accountfield", Accfield);
		verifyElementPresent("prodnumberfield", prodnumberfield);
		verifyElementPresent("TechIdfield", TechIdfield);
		verifyElementPresent("locationfield", locfield);
		verifyElementPresent("SEOLfield", SEOLfield);
		verifyElementPresent("modalityfield", modalityfield);
		verifyElementPresent("CInumberfield", CInumberfield);
		verifyElementPresent("Entitledfield", Entitledfield);
		verifyElementPresent("Productfield", Productfield);
	}

	public void add_changeIPDetails() {
		// TODO Auto-generated method stub
		click("addchangebtn", addchangebtn);
		String customsample= "AutomationTesting"+Utility.getFormatedDateTime();
		enter("Custom IP Name", customIPName, customsample);
		enter("Room department", roomdeptName, "Testing");
		click("save button", saveButton_Text);
		waitTill("5");
	}

	public void clickonExportbtn() {
		// TODO Auto-generated method stub
		click("exportbtn", exportbtn);
	}

	public void selectcolumncheckbox() throws AWTException {
		// TODO Auto-generated method stub
		click("columcheckboxs", columcheckboxs);
		click("submit", submitButton);
		String filePath="C:/R2RCucumberProject/R2RCucumberBDD/src/test/resources/Downloads";
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit t = Toolkit.getDefaultToolkit();
		java.awt.datatransfer.Clipboard c = t.getSystemClipboard();
		c.setContents(stringSelection, null);
		waitTill("5");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
	}


	public void clickRSButtonwithvalue(String value) {
		// TODO Auto-generated method stub
		click("Request support button", requestSupportbtn);
		WebElement Value=driver.findElement(By.xpath("//span[text()='"+value+"']"));
		click("Report Technical/Cinical Issue",Value);

	}
	public void verifyautoPopulatedfields(){
		verifyElementPresent("INstalled Product column", IPcol);
		verifyElementPresent("ProductName column", PNcol);
		verifyElementPresent("customIP column", customIPcol);
		verifyElementPresent("serial number column", SNcol);
		verifyElementPresent("Tech ID column", TechIDcol);
		verifyElementPresent("customer Inventorycolumn", customerInventoryNumcol);
		verifyElementPresent("Modality column", Modalitycol);
		verifyElementPresent("shipto column", shiptocol);
		verifyElementPresent("UDI column", UDIcol);
		verifyElementPresent("Account name column", AccountNamecol);

	}
	public void clickonPriorityandValidatevalues() {
		// TODO Auto-generated method stub
		
		selectbyValue(prioritydropdown, "2-System Down", "2-System Down");
//		click("Priority dropdown", prioritydropdown);
//		verifyElementPresent("system2down", system2down);
//		verifyElementPresent("system3restricted", system3restricted);
//		verifyElementPresent("intermittentprob", intermittentprob);
//		verifyElementPresent("scheduleactivity", scheduleactivity);
//		waitTill("5");
//		click("system2down", system2down);
		waitTill("5");

	}

	public void clickoncreateACase(){
		click("select an IP to create case", selectIPtoCreatecasebtn);
	}

	public void clickonAnyIP(){
		waitTill("5");
		click("clickonanyIP", clickonanyIP);

	}

	public void selectnoforQuestion() {
		// TODO Auto-generated method stub
		click("novalue", novalue);
		waitSpinnerToDisappear();
	}

	public void selectTypeofService(String typeofservice) {
		// TODO Auto-generated method stub
		click("Type of service", Typeofservice);
		WebElement type=driver.findElement(By.xpath("//option[text()='"+typeofservice+"']"));
		click("type", type);
	}

	public void verifyFieldsinContactInfoSection() {
		// TODO Auto-generated method stub
		verifyElementPresent("contactname", contactname);
		verifyElementPresent("phone", phone);
		verifyElementPresent("Email", Email);
		verifyElementPresent("callbackNumber", callbackNumber);
		click("sameaspHone", sameaspHone);
	}

	public void verifymanageAdditionalcontactbtn() {
		// TODO Auto-generated method stub
		verifyElementPresent("manageAdditionalcontactsbtn", manageAdditionalcontactsbtn);
	}

	public void entercasedetails(){
		enter("subject", subjectfield, "AutomationTesting"+Utility.randomNumber(1000));
		if(verifyElementPresent("description", description)){
			enter("description", description, "AutomationTesting"+Utility.randomNumber(1000));}
		else if(verifyElementPresent("description1", description1)){
			enter("description", description1, "AutomationTesting"+Utility.randomNumber(1000));
		}
		else if(verifyElementPresent("partsOrderReason", partsOrderReason)){
			enter("partsOrderReason", partsOrderReason, "AutomationTesting"+Utility.randomNumber(1000));
		}
		enter("patienthealthInfo", patienthealthInfo,"AutomationTesting"+Utility.randomNumber(1000));
//		waitTill("5");
//		enter("callback_number", callback_number, "1234567");
//		//click("sameaspHone", sameaspHone);
//		waitTill("5");
		verifyElementPresent("uploadfilefield", uploadfilefield);
		click("Createcasebtn", Createcasebtn);
		waitSpinnerToDisappear();
		waitDottedSpinnerToDisappear();
		waitTill("5");
	}

	public void verifyfieldsUnderCaseDetailsSection() {
		// TODO Auto-generated method stub
		verifyElementPresent("caseNumber", caseNumber);
		verifyElementPresent("status", status);
		verifyElementPresent("Subject", Subject);
		verifyElementPresent("customercontact", customercontact);
		verifyElementPresent("verifyDescription", verifyDescription);
		verifyElementPresent("Priority", Priority);
		verifyElementPresent("StartDate", StartDate);
		verifyElementPresent("PHIData", PHIData);
		verifyElementPresent("caseactivitiestab", caseactivitiestab);
		verifyElementPresent("casetrackingtab", casetrackingtab);
		verifyElementPresent("fileuploadtab", fileuploadtab);
	}



	public void verifyfieldsUnderIPSectiononCasePage() {
		// TODO Auto-generated method stub
		verifyElementPresent("modalityfield", modalityfield);
		verifyElementPresent("locationfield", locfield);
		verifyElementPresent("Productfield", Productfield);
	}

	public void clickAddCaseActivitybtn() {
		// TODO Auto-generated method stub
		click("Add Case Activity button", addcaseactivitybtn);
		waitSpinnerToDisappear();
	}
	//            


	public void createCaseActivity() {
		// TODO Auto-generated method stub
		enter("description", Desfield, "AutomationTesting"+Utility.randomNumber(1000));
		enter("patienthealthInfo", patienthealthInfo,"AutomationTesting"+Utility.randomNumber(1000));
		click("save", saveButton_Text);
		waitSpinnerToDisappear();
		waitDottedSpinnerToDisappear();
	}

	public void verifyPHICheckbox() {
		// TODO Auto-generated method stub
		verifyElementPresent("PHI Data checkbox", PHIDatacheckbox);
		CaseNumber=getcaseNumber.getText();
	}

	public void searchCaseNumber() {
		// TODO Auto-generated method stub
		enter("search", globalsearch, CaseNumber);
		click("seatch Button", globalSearchButton);
	}

	public void verifyAccountfields() {
		// TODO Auto-generated method stub
		verifyElementPresent("AccountNamecol", AccountNamecol);
		verifyElementPresent("AccountNumcol", AccountNumcol);
		verifyElementPresent("Streetcol", Streetcol);
		verifyElementPresent("Citycol", Citycol);
		verifyElementPresent("Postalcodecol", Postalcodecol);
		verifyElementPresent("stateProvincecol", stateProvincecol);
		verifyElementPresent("countrycol", countrycol);
	}

	public void PlannedVisitTab() {
		// TODO Auto-generated method stub
		if(verifyElementPresent("Planned visit", plannedvisittab)){
			click("Planned visit tab", plannedvisittab);
			verifyFiledsunderPlannedVisitTab();
		}else{
			logReport("INFO", "No Planned Visit Tab");
		}
	}

	public void verifyFiledsunderPlannedVisitTab() {
		// TODO Auto-generated method stub
		verifyElementPresent("caseNumber_PV", caseNumber_PV);
		verifyElementPresent("Subject_PV", Subject_PV);
		verifyElementPresent("EventType_PV", EventType_PV);
		verifyElementPresent("Priority_PV", Priority_PV);
		verifyElementPresent("Schedulestart_PV", Schedulestart_PV);
		verifyElementPresent("Scheduleduration_PV", Scheduleduration_PV);
		verifyElementPresent("NameofFSE", NameofFSE);

	}

	public void verifySLCPTab() {
		// TODO Auto-generated method stub
		verifyElementPresent("HardwareInstalledProd", HardwareInstalledProd);
		verifyElementPresent("SoftwareInstalledProduct", SoftwareInstalledProduct);
		verifyElementPresent("HardwareIPDescription", HardwareIPDescription);
		verifyElementPresent("softwareIPDescription", softwareIPDescription);
		verifyElementPresent("Hardwareserialnumber", Hardwareserialnum);
		verifyElementPresent("HardwareMatNumber", HardwareMatNum);
		verifyElementPresent("softwareMatNumber", softwareMatNum);
		verifyElementPresent("lastactivation", lastactivation);
		verifyElementPresent("softwareVersionNumber", softwareVersionNum);
		verifyElementPresent("Options", Options);
		verifyElementPresent("softwareInstallEntitle", softwareInstallEntitle);
		verifyElementPresent("softwareinstallremain", softwareinstallremain);
		verifyElementPresent("technicalcapbilities", technicalcapbilities);
		verifyElementPresent("GlobalTypes", GlobalTypes);

	}

	public void SLCPTab() {
		// TODO Auto-generated method stub
		click("SLCP tab", SLCPtab);
	}

	public void selectPriority(String type) {
		// TODO Auto-generated method stub
		click("prioritydropdown", prioritydropdown);
		WebElement value=driver.findElement(By.xpath("//option[text()='"+type+"']"));
		click("Priority value", value);
	}

	public void validateLocationfields(){
		verifyElementPresent("LocationName", LocationName);
		verifyElementPresent("AccountNumcol", AccountNumcol);
		verifyElementPresent("Streetcol", Streetcol);
		verifyElementPresent("Citycol", Citycol);
		verifyElementPresent("Postalcodecol", Postalcodecol);
		verifyElementPresent("stateProvincecol", stateProvincecol);
		verifyElementPresent("countrycol", countrycol);
	}



	public void selectLocation(String location) {
		// TODO Auto-generated method stub
		WebElement locationlink=driver.findElement(By.xpath("//a[text()='"+location+"']"));
		click("Location", locationlink);
	}

	public void verifyLocationLabel(){
		verifyElementPresent("LocationName", LN);
		verifyElementPresent("AccountNumber", AccountNumber);
		verifyElementPresent("Street", Streetlabel);
		verifyElementPresent("City", Citylabel);
		verifyElementPresent("Postalcode", Postalcodelabel);
		verifyElementPresent("country", Countrylabel);
	}

	public void validateRelatedItem() {
		// TODO Auto-generated method stub
		verifyElementPresent("Request support button", requestSupportbtn);
		verifyElementPresent("remoteAccessAuditDate", remoteAccessAuditDate);
		verifyElementPresent("CreateUsertbtn", CreateUsertbtn);
	}

	public void validateRelatedTab() {
		// TODO Auto-generated method stub
		verifyElementPresent("cases_tab", cases_tab);
		verifyElementPresent("IP_tab", IP_tab);
		verifyElementPresent("Warranties", Warranties);
		verifyElementPresent("Documentstab", Documentstab);
		verifyElementPresent("Entitlementstab", Entitlementstab);
	}


	public void validateContractsfields() {
		// TODO Auto-generated method stub
		verifyElementPresent("Contractheader", Contractheader);
		verifyElementPresent("Contract", Contract);
		verifyElementPresent("ContractPO", ContractPO);
		verifyElementPresent("servieplan", servieplan);
		verifyElementPresent("startdate", startdate);
		verifyElementPresent("end_Date", end_Date);
		verifyElementPresent("Location", Location);
		verifyElementPresent("expiationStatus", expiationStatus);
	}

	public void selectContract() {
		// TODO Auto-generated method stub
		click("contract", selectcontract);
	}





	public void validatelabelsonContractPage() {
		// TODO Auto-generated method stub
		verifyElementPresent("StartDate", StartDate);
		verifyElementPresent("Contractheaderlabel", Contractheaderlabel);
		verifyElementPresent("Contractlabel", Contractlabel);
		verifyElementPresent("ContractPOlabel", ContractPOlabel);
		verifyElementPresent("servieplanlabel", servieplanlabel);
		verifyElementPresent("Locationlabel", Locationlabel);
	}



	public void selectMoredropdown(String contactus) {
		// TODO Auto-generated method stub
		click("Morebtn", Morebtn);
		waitTill("5");
		WebElement droptab=driver.findElement(By.xpath("//span[text()='"+contactus+"']"));
		click("drop tab", droptab);
		waitTill("5");
	}

	public void clickon_contactCustomerservicebtn() {
		// TODO Auto-generated method stub
		click("ContactCustomerService", ContactCustomerService);
	}

	public void nextbtn() {
		// TODO Auto-generated method stub
		click("Next button", nextButton);
	}
	public void submitbtn(){
		click("submitbtn", submitButton);
		waitSpinnerToDisappear();
		verifyElementPresent("confirmation message", confirmationmsgforcontact);
	}




	public void ClickonProfileName(String profilename, String myprofile) {
		// TODO Auto-generated method stub
		WebElement profile=driver.findElement(By.xpath("//span[text()='"+profilename+"']"));
		click("Profile name", profile);
		WebElement my_profile=driver.findElement(By.xpath("//a[@title='"+myprofile+"']"));
		click("my Profile", my_profile);
	}

	public void validateFieldsunderMyprofiledetailsPage() {
		// TODO Auto-generated method stub
		verifyElementPresent("title", title);
		verifyElementPresent("FirstName", FirstName);
		verifyElementPresent("Lastname", Lastname);
		verifyElementPresent("profileEmail", profileEmail);
		verifyElementPresent("Phone", Phone);
		verifyElementPresent("Extension", Extension);
		verifyElementPresent("MobilePhone", MobilePhone);
		verifyElementPresent("Language", Language);
		verifyElementPresent("Locale", Locale);
		verifyElementPresent("TimeZone", TimeZone);
		verifyElementPresent("PortalAuthorizations", PortalAuthorizations);
		verifyElementPresent("endofLife", endofLife);
		verifyElementPresent("EOLsubscription", EOLsubscription);
	}

	public void validatechangePasswordfields() {
		// TODO Auto-generated method stub
		click("changepasswordbtn", changepasswordbtn);
		waitSpinnerToDisappear();
		verifyElementPresent("Old Password", oldpassword);
		verifyElementPresent("newpassword", newpassword);
		click("cancelbtn", cancelButton_Text);
	}

	public void portalGlobalsearch(String accName) {
		// TODO Auto-generated method stub
		enter("portalglobalserch", portalglobalserch,accName);
		waitTill("15");
		WebElement search=driver.findElement(By.xpath("//button[@title='Search']"));
		click("searchbtn", search);
		pressEnter();
		waitTill("10");
		WebElement acc=driver.findElement(By.xpath("//a[text()='"+accName+"']"));
		verifyElementPresent("Account name", acc);
	}

	public void validatecasesfilter(){
		verifyElementPresent("allcases", allcases);
		verifyElementPresent("opencases", opencases);
		verifyElementPresent("History", History);
		verifyElementPresent("Planned", Planned);
		verifyElementPresent("ClearFilter", ClearFilter);
		verifyElementPresent("ClosedBefore", ClosedBefore);
	}

	public void validatefieldsUnderDocumentTab() {
		// TODO Auto-generated method stub
		click("documenttype", documenttype);
		verifyElementPresent("servicereportoptn", servicereportoptn);
		verifyElementPresent("TestandInspectionResultsoptn", TestandInspectionResultsoptn);
		verifyElementPresent("Quotationsoptn", Quotationsoptn);
		click("EventType", EventType);
		verifyElementPresent("Incident", Incident);
		verifyElementPresent("prdectivemaintainence", prdectivemaintainence);
		verifyElementPresent("Installation", Installation);
		verifyElementPresent("FieldChangeOrder", FieldChangeOrder);
		verifyElementPresent("CustomerSupport", CustomerSupport);
		verifyElementPresent("SupplementaryServices", SupplementaryServices);
		verifyElementPresent("PartsSupplyOnly", PartsSupplyOnly);
		verifyElementPresent("ProactiveMonitoring", ProactiveMonitoring);
		click("SelectObject", SelectObject);
		verifyElementPresent("Contracts", Contracts);
		verifyElementPresent("InstalledProduct", InstalledProduct);
		verifyElementPresent("Account", Account);
		verifyElementPresent("Warranty", Warranty);
		verifyElementPresent("Locationoptn", Locationoptn);
		click("createdDate", createdDate);
		verifyElementPresent("Today", Today);
		verifyElementPresent("Last7Days", Last7Days);
		verifyElementPresent("Last30Days", Last30Days);
		verifyElementPresent("Last12Months", Last12Months);
		verifyElementPresent("YeartoDate", YeartoDate);
		verifyElementPresent("Modality", Modality);
		verifyElementPresent("ApplyFilters", ApplyFilters);
		verifyElementPresent("Clear", Clear);
	}

	public void selectReportdropdown(String value) {
		// TODO Auto-generated method stub
		click("Report", reportTab);
		WebElement Dropdownvalue=driver.findElement(By.xpath("//a[@title='"+value+"']"));
		click("Report value", Dropdownvalue);
	}


	public void selectAllFolders() {
		// TODO Auto-generated method stub
		click("All Folders", allfolders);
	}



	public void validatecasesfields() {
		// TODO Auto-generated method stub
		verifyElementPresent("Modalitycol", Modalitycol);
		verifyElementPresent("Product Name", PNcol);
		verifyElementPresent("prioritylabel", prioritylabel);
		verifyElementPresent("CaseNumber_label", CaseNumber_label);
		verifyElementPresent("Subjectlabel", Subjectlabel);
		verifyElementPresent("Statuslabel", Statuslabel);
		verifyElementPresent("Location", Location);
		verifyElementPresent("Event Type", eventType);
		verifyElementPresent("start_Date", start_Date);
	}

	public void validateRelatedTabForAccounts() {
		// TODO Auto-generated method stub
		verifyElementPresent("cases_tab", cases_tab);
		verifyElementPresent("IP_tab", IP_tab);
		verifyElementPresent("Warranties", Warranties);
		verifyElementPresent("Documentstab", Documentstab);
		verifyElementPresent("contractstab", contractstab);
		verifyElementPresent("contactstab", contactstab);
	}


	public void select_a_record() {
		// TODO Auto-generated method stub
		click("csportalFolder", csportalFolder);
		waitTill("5");
		click("Installed product record", IPBtn);
		waitDottedSpinnerToDisappear();
	}



	public void verifyRecordcolumns(){
		waitTill("5");
		waitAndswitchToRequiredFrame(frame);
		verifyElementPresent("AccountNamecol", AccountNamecol);
		verifyElementPresent("LocationName", LocationName);
		verifyElementPresent("ProductModality", ProductModality);
		verifyElementPresent("IPID", IPID);
		verifyElementPresent("PNcol", PNcol);
		verifyElementPresent("TechIdentNo", TechIdentNo);
		verifyElementPresent("SNcol", SNcol);
		verifyElementPresent("CustomerInventory", CustomerInventory);
		verifyElementPresent("Room/Dept", Room_Dept);
	}

	public void verifyFiledownloadedSuccessfully() throws IOException {
		// TODO Auto-generated method stub
		String filepath = AutomationConstants.DownloadsFolder + "ExportData.csv";
		if(filepath.endsWith("csv")){
			logReport("INFO", "File downloaded successfully");
		}
		else{
			logReport("INFO", "File not downloaded successfully");
		}
	}	

	public void selectAccount() {
		// TODO Auto-generated method stub
		click("accountlink", accountlink);
		waitSpinnerToDisappear();
	}

	public void fillfieldsUnderDocumentTab(String acc) {
		// TODO Auto-generated method stub
		//click("documenttype", documenttype);
		//click("servicereportoptn", servicereportoptn);
		selectbyValue(EventType, "Incident", "Incident");
		selectbyValue(SelectObject, "Account", "Account");
		
//		click("EventType", EventType);
//		click("Incident", Incident);
//		click("SelectObject", SelectObject);
//		click("Account", Account);
		waitTill("5");
		click("selectRecordsButton", selectRecordsButton);
		//enter("search account", searchAcc, acc);
		WebElement Acc=driver.findElement(By.xpath("//a[text()='A.O. PAPA GIOVANNI XXIII']/../preceding-sibling::th/input"));
		
		//WebElement Acc=driver.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='"+acc+"']"));
		click("Account", Acc);
		click("Confirm", driver.findElement(By.xpath("//button[text()='Confirm']")));
		click("ApplyFilters", ApplyFilters);

	}
	public void downloadfile() {
		// TODO Auto-generated method stub
		Utility.clearDirectory(AutomationConstants.DownloadsFolder);
		click("select checkbox", checkbox);
		click("downloadbtn", downloadbtn);
		logReport("INFO", "File got downloaded successfully");
	}

	public void selectcaseNumbermorethan10MB(String casenumber2) {
		// TODO Auto-generated method stub
		WebElement caseNumber_checkbox=driver.findElement(By.xpath("//a[text()='"+casenumber2+"']/../..//input"));
		click("checkbox", caseNumber_checkbox);
	}

	public void error_download() {
		// TODO Auto-generated method stub
		verifyElementPresent("downloaderror", downloaderror);
	}


	public void IncludeIP(String iP) {
		// TODO Auto-generated method stub
		click("Exclude include button", Exclude_Include_btn);
		enter("IP enter Field", IPenterfield, iP);
		click("searchbtn", searchbtn_grp);
		waitSpinnerToDisappear();
		WebElement ip=driver.findElement(By.xpath("//div[text()='"+iP+"']/../..//input"));
		click("IP checkbox", ip);
		waitTill("5");
		click("Include_btn", Include_btn);
		try 
		{
			Alert alert1 = driver.switchTo().alert();
			System.out.println("Alert is present");
			alert1.accept();
			Robot robot1=new Robot();
			robot1.keyPress(KeyEvent.VK_ENTER);
		}
		catch(NoAlertPresentException e){
			System.out.println("alert is not present");
		}catch(Exception e) {}
		waitSpinnerToDisappear();
	}

		public void partsordering(String pO) {
			// TODO Auto-generated method stub
			
			waitTill("5");
			
			driver.switchTo().frame(ESMXFrame);
			click("partsorderinglink", partsorderinglink);
			waitForElement(productcodeinput, " Product code input");
			enter("Product code input", productcodeinput, pO);
			click("search button", serachButton);
			waitSpinnerToDisappear();
		    waitForElement(clickaddicon,"clickaddicon");
		    click("clickaddicon", clickaddicon);
		    waitSpinnerToDisappear();
		    embedScreenShotInreport();
		    waitTill("5");
				click("click on getEntitlement", getEntitlement);
				waitSpinnerToDisappear();
				click("GATPsimulation", GATPsimulation);
				waitSpinnerToDisappear();
				verifyElementPresent("success message", successmessage);
				embedScreenShotInreport();
				click("transfertoSAP", transfertoSAP);
				waitSpinnerToDisappear();
				verifyElementPresent("TransferSAPsuccessmsg", TransferSAPsuccessmsg);
				embedScreenShotInreport();
			
			
		}

		public void clickCreateCaseButton() {
			WebElement createCase = driver.findElement(By.xpath("//button[text()='Create Case']"));
			click("Create Case", createCase);
			
		}
}
