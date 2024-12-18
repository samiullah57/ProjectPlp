package com.philips.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.http.impl.conn.tsccm.WaitingThread;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.philips.generic.AutomationConstants;
import com.philips.generic.Utility;
import com.philips.stepdefinitions.Hooks;

import cucumber.api.DataTable;

public class WorkOrderPage extends BasePage {
	@FindBy(xpath = "//img[@title='Work Order']")
	private WebElement work_Order_Header;

	@FindBy(xpath = "//span[text()='Open Labor']/..")
	private WebElement link_openLabor;

	@FindBy(xpath = "//iframe[contains(@title,'Service_Order_Wizard')]")
	private WebElement service_Flow_SFM;

	@FindBy(xpath = "//iframe[@title='Service_Order_Wizard']")
	private WebElement iframe_WO_Distributor;

	@FindBy(xpath = "//*[text()='Customer Language']/../preceding-sibling::td/div")
	private WebElement orderStatus;

	@FindBy(xpath = "//input[@value='Initiate Onsite']")
	private WebElement initiate_Onsite_SFM;

	@FindBy(xpath = "//span[contains(text(),'Work Order')]/../following-sibling::td//a")
	private WebElement work_Order;

	@FindBy(xpath = "//input[@value='Add Labor or Parts']")
	private WebElement add_Labor_Parts_SFM;

	@FindBy(xpath = "//input[@value='Update Work Order']")
	private WebElement update_WO_SFM_Distributor;

	@FindBy(xpath = "//*[text()='Technician:']/../following-sibling::td//input")
	private WebElement technician_Distributor;

	@FindBy(xpath = "//*[text()='Part:']/../following-sibling::td//input")
	private WebElement part_distributor;

	@FindBy(xpath = "//*[text()='Order Status:']/../following-sibling::td//input")
	private WebElement order_status_dropdown;

	@FindBy(xpath = "//*[text()='Technician:']/parent::td/following-sibling::td//*[@role='button']")
	private WebElement technician_Searchbtn_Distributor;

	@FindBy(xpath = "//*[text()='Part:']/parent::td/following-sibling::td//*[@role='button']")
	private WebElement part_Searchbtn_Distributor;

	@FindBy(xpath = "//*[text()='Has Medical Software Version Updated?:']/parent::td/following-sibling::td//*[@role='button']")
	private WebElement med_software_version_drpdwn;

	@FindBy(xpath = "//*[text()='Software Version Number:']/../following-sibling::td/input")
	private WebElement software_verion_distributor;

	@FindBy(xpath = "//*[contains(text(),'Philips Legal contacted?')]/../following-sibling::td/input")
	private WebElement philips_Legal_contacted;

	@FindBy(xpath = ".//*[@id='svmx_sfm_delivery_root_container0-info']")
	private WebElement work_Order_Lines_Dialog;

	@FindBy(xpath = "//span[text()='Open Labor']/..")
	private WebElement open_Labor;

	@FindBy(xpath = "//*[@data-qtip='Extended Edit']")
	private WebElement edit_Labor_Parts;

	@FindBy(xpath = "//*[text()='Line Status:']/../following-sibling::*//div[contains(@class,'svmx-form-arrow-trigger')]")
	private WebElement line_Status_DropDown;

	@FindBy(xpath = "//li[text()='Confirmed']")
	private WebElement line_Status_Confirmed;

	@FindBy(xpath = "//li[text()='Work']")
	private WebElement labor_Activity_Type_Work;

	@FindBy(xpath = "//li[text()='Service Consultancy']")
	private WebElement labor_Activity_Type_Serviceconsultancy;

	@FindBy(xpath = "//*[text()='Activity Type:']/../following-sibling::*//div[contains(@class,'svmx-form-arrow-trigger')]")
	private WebElement activity_Type_DropDown;

	@FindBy(xpath = "//li[text()='Work Time']")
	private WebElement activity_Type_Work_Time;

	@FindBy(xpath = "//li[text()='Configuration']")
	private WebElement activity_Type_Configuration;

	@FindBy(xpath = "//*[text()='Labor Activity Type:']/../following-sibling::*//div[contains(@class,'svmx-form-arrow-trigger')]")
	private WebElement labor_Activity_Type_DropDown;

	@FindBy(xpath = "//*[text()='Duration (in Hours):']/../following-sibling::td//input")
	private WebElement labor_Activity_Duration;

	@FindBy(xpath = "//span[text()='Update']")
	private WebElement update_Labor;

	@FindBy(xpath = "//span[text()='Open Parts Returnable']")
	private WebElement openpartsReturnableTab;

	@FindBy(xpath = "//div//img[@data-qtip='Extended Edit']")
	private WebElement editopenParts;

	@FindBy(xpath = "(//label[text()='Part Status:']/../..//input/../..//td[@class='svmx-trigger-cell']//div)")
	private WebElement partstatus;

	@FindBy(xpath = "//li[text()='Consumed']")
	private WebElement consumedvalue;

	@FindBy(xpath = "//label[text()='IP structure is non-available:']/../..//input")
	private WebElement Ipstructurecheckbox;

	@FindBy(xpath = "(//label[text()='Line Status:']/../..//input/../..//td[@class='svmx-trigger-cell']//div)")
	private WebElement linestatusdropdwon;

	@FindBy(xpath = "//li[text()='Confirmed']")
	private WebElement confirmedvalue;

	@FindBy(xpath = "//button//span[@id='sfm-button-1855-btnInnerEl']")
	private WebElement updatebtn;

	@FindBy(xpath = "//label[text()='RML Number:']/../..//input")
	private WebElement RMLNumber;

	@FindBy(xpath = "//span[@class='svmx-btn-icon svmx-sfmd-save-icon']")
	private WebElement saveopenlabor;

	@FindBy(xpath = "(//textarea)[2]")
	private WebElement defectpartinfo;

	@FindBy(xpath = "//label[text()='Defective Serial Number:']/../..//input")
	private WebElement defectiveSerialNumber;

	@FindBy(xpath = "//label[text()='Return Tracking Number:']/../..//input")
	private WebElement trackingNumber;

	@FindBy(xpath = "//label[text()='Defective Part Failure Reason:']/../..//input/../..//td[@class='svmx-trigger-cell']/div")
	private WebElement defectivepartfailureDropddown;

	@FindBy(xpath = "//li[text()='NEW SYSTEM-DEFOA']")
	private WebElement failurevalue;

	@FindBy(xpath = "//label[text()='Defective Part Category:']/../..//input/../..//td[@class='svmx-trigger-cell']/div")
	private WebElement defectpartcategory;

	@FindBy(xpath = "//li[text()='PART DAMAGED']")
	private WebElement defectpartcategoryvalue;

	@FindBy(xpath = "//label[text()='Defective Part Number:']/../..//input")
	private WebElement defectpartnumber;

	@FindBy(xpath = "//span[text()='Case']/parent::td/following-sibling::td/div/a[starts-with(text(),'0')]")
	private WebElement txt_case;

	@FindBy(xpath = "//h3[text()='Work Details (Work Order)']/ancestor::div[contains(@class,'listRelatedObject Custom')]//table[@class='list']/tbody//td[3]")
	private WebElement workOrder_details;

	@FindBy(xpath = "//h3[text()='Work Details (Work Order)']")
	private WebElement link_workOrder;

	@FindBy(xpath = "//*[@data-qtip='Extended Edit']")
	private List<WebElement> edit_labour;

	@FindBy(xpath = "//label[text()='Line Status:']/ancestor::table//td[contains(@id,'ext-gen')]")
	private WebElement lineStatus_dropdown;

	@FindBy(xpath = "//span[text()='Open Parts Non Returnable']")
	private WebElement btn_partsNonreturn;

	@FindBy(xpath = "//label[text()='Force Return:']/ancestor::table//input")
	private WebElement chk_force;

	@FindBy(xpath = "//span[text()='Open Parts Returnable']")
	private WebElement btn_partsreturn;

	@FindBy(xpath = "//label[text()='Part Status:']/ancestor::table//div[@role='button']")
	private WebElement dropdown_forceReturn;

	@FindBy(xpath = "//label[text()='Defective Part Failure Reason:']/ancestor::table//div[@role='button']")
	private WebElement dropdown_defectiveFailure;

	@FindBy(xpath = "//li[text()='DEFECTIVE PART']")
	private WebElement option_defect;

	@FindBy(xpath = "//label[text()='Defective Part Category:']/ancestor::table//div[@role='button']")
	private WebElement dropdown_defectpart;

	@FindBy(xpath = "//li[text()='PART INTERMITTENT FAILURE']")
	private WebElement option_defectpart;

	@FindBy(xpath = "//label[text()='Defective Part Information:']/ancestor::table//textarea")
	private WebElement txt_defectInfo;

	@FindBy(xpath = "//label[text()='RML Number:']/ancestor::table//input")
	private WebElement txt_RML;

	@FindBy(xpath = "//label[text()='Line Status:']/ancestor::table//input")
	private WebElement lineStatus;

	@FindBy(xpath = "//input[@value='Record Tools']")
	private WebElement btn_recordTool;

	@FindBy(xpath = "//label[text()='Debrief System Status Date / Time:']/ancestor::table[starts-with(@class,'svmx')]//button")
	private WebElement btn_time;

	@FindBy(xpath = "//label[text()='Tools Not Required:']/parent::td/following-sibling::td/input")
	private WebElement chk_tool;

	@FindBy(xpath = "//*[@id='SVMXC__Service_Contract__c']")
	public WebElement searchResult;

	@FindBy(xpath = "//td[text()='Labor']/preceding-sibling::th/a")
	private WebElement work_Order_Line_Item;

	@FindBy(xpath = "//*[@class='pageDescription']")
	private WebElement WORK_ORDER_LINE_ITEM;

	@FindBy(xpath = "//span[text()='Integration Status']/../following-sibling::td/div")
	private WebElement INTEGRATION_STATUS;

	@FindBy(xpath = "//span[text()='SAP Accounting Indicator']/../following-sibling::td/div")
	private WebElement SAP_ACCOUNTING_INDICATOR;

	@FindBy(xpath = "//span[text()='SAP Confirmation Number']/../following-sibling::td/div")
	private WebElement SAP_CONFIRMATION_NUMBER;

	@FindBy(xpath = "//span[text()='SAP Confirmation Counter']/../following-sibling::td/div")
	private WebElement SAP_CONFIRMATION_COUNTER;

	@FindBy(xpath = "//span[text()='Line Status']/../following-sibling::td/div")
	private WebElement LINE_STATUS;

	@FindBy(xpath = "//input[@title=' Initiate Travel']")
	private WebElement btn_travelSFM;

	@FindBy(xpath = "//span[text()='Work Order']/parent::td/following-sibling::td//a")
	private WebElement link_WO;

	@FindBy(xpath = "(//label[text()='Start Date and Time:']/ancestor::tbody//td[@class='svmx-trigger-cell'])[2]")
	private WebElement dropdown_hour;

	// Debrif Xpath----------------------

	//@FindBy(xpath = "//*[contains(@value, 'Debrief and Follow Up')][contains(@class, 'enabledbtn')]")
	@FindBy(xpath = "//input[@value='Debrief and Follow Up' and contains(@class,'enabledbtn')]")
	private WebElement debriefAndFollowUp_SFM_button;

	@FindBy(xpath = "//*[contains(text(), 'Debrief System Status:')]//parent::td//parent::tr//input")
	private WebElement debriefSystemStatus_dropdown;

	@FindBy(xpath = "//*[contains(text(), 'Internal Support Status:')]//parent::td//parent::tr//input")
	private WebElement internalSupportStatus_dropdown;

	@FindBy(xpath = "//*[contains(text(), 'Installation Status:')]//parent::td//parent::tr//input")
	private WebElement debrief_InstallationStatus;

	@FindBy(xpath = "//*[contains(text(), 'T&V Status:')]//parent::td//parent::tr//input")
	private WebElement tAndV_Status_dropdown;

	@FindBy(xpath = "//*[contains(text(), 'Is the IB Record Installation Correct?:')]//parent::td//parent::tr//input")
	private WebElement IBRecord_installation;
	// Reported

	@FindBy(xpath = "//*[contains(text(), 'Hazard Category')]//parent::td//parent::tr//input")
	private WebElement hazardCategory_dropdown;

	@FindBy(xpath = "//*[text()='Hazard:']//parent::td//parent::tr//input")
	private WebElement hazard_dropdown;

	@FindBy(xpath = "//*[contains(text(), 'Hazardous Situation:')]//parent::td//parent::tr//input")
	private WebElement input_hazard;

	@FindBy(xpath = "//*[text()='Multiple Hazards:']/../following-sibling::td/input")
	private WebElement multiple_Hazard_checkbox;

	@FindBy(xpath = "//*[text()='Multiple Hazards Data:']/../following-sibling::td/input")
	private WebElement multiple_Hazard_data_checkbox;

	@FindBy(xpath = "//*[text()='Clinical Usage:']//parent::td//parent::tr//input")
	private WebElement clinicalUsage_dropdown;

	@FindBy(xpath = "//*[text()='Risk Profile:']//parent::td//parent::tr//input")
	private WebElement risk_profile;


	@FindBy(xpath = "//*[text()='Potential Safety Issue related to?:']//parent::td//parent::tr//input")
	private WebElement potential_safety_dropdwn;

	@FindBy(xpath = "//*[text()='Type:']//parent::td//parent::tr//input")
	private WebElement activity_type;

	@FindBy(xpath = "//*[text()='Customer reported the issue externally:']//parent::td//parent::tr//input")
	private WebElement cust_reported_externally;

	@FindBy(xpath = "//*[text()='Has action been taken?:']//parent::td//parent::tr//input")
	private WebElement has_action_taken;

	@FindBy(xpath = "//span[text()='Work Activity']/..")
	private WebElement Work_Activity;

	@FindBy(xpath = "//span[text()='Activities']")
	private WebElement activities;

	@FindBy(xpath = "//span[text()='Parts Consumed']")
	private WebElement parts_consumed;

	@FindBy(xpath = "//span[@class='svmx-btn-icon svmx-sfmd-next-icon']/..")
	private WebElement btn_down;

	@FindBy(xpath = "//label[text()='Description:']/parent::td/following-sibling::td/textarea")
	private WebElement txt_description;

	@FindBy(xpath = "//*[text()='Requested Qty:']/../following-sibling::td//input")
	private WebElement requested_Qty;

	@FindBy(xpath = "//*[text()='Serial Number:']/../following-sibling::td//textarea")
	private WebElement serial_num_distributor;

	@FindBy(xpath = "//span[contains(text(), 'Work Activity')]/..")
	private WebElement workActivity;

	@FindBy(xpath = "//span[contains(text(), 'Regulatory Questions')]/..")
	private WebElement RegulatoryQues;

	@FindBy(xpath = "(//tr[@class='svmx-grid-header-row'])[3]/..//img[@data-qtip='Extended Edit']")
	private WebElement btn_editHeader;

	@FindBy(xpath = "//label[text()='Answer1:']/parent::td/following-sibling::td//input")
	private WebElement txt_ans1;

	@FindBy(xpath = "//label[text()='Answer2:']/parent::td/following-sibling::td//input")
	private WebElement txt_ans2;

	@FindBy(xpath = "//input[@value='Complete Work Order']")
	private WebElement btn_complete_WO;

	@FindBy(xpath = "//*[text()='Send Service Report For:']/../following-sibling::td//div[contains(@class,'unselectable')]")
	private WebElement service_report_dropdown;

	@FindBy(xpath = "//*[text()='Send Service Report For:']/../following-sibling::td//input")
	private WebElement send_service_report;

	@FindBy(xpath = "//input[@value='Signed Customer Service Report']")
	private WebElement singned_customer_report;

	@FindBy(xpath = "//input[@value='Finalize']")
	private WebElement finalize_singned_customer_report;

	@FindBy(xpath = "//button/span[text()='Open Parts Returnable']")
	private WebElement btn_parts_returnable;

	@FindBy(xpath = "//td[text()='Labor']/..//th/a")
	private WebElement line_number_labour;

	@FindBy(xpath = "//td[text()='Parts']/..//th/a")
	private WebElement line_number_Parts;

	@FindBy(xpath = "//span[text()='Is Billable']/../..//img[@title='Not Checked']")
	private WebElement checkbox_isbillable;

	@FindBy(xpath = "//span[text()='SAP Accounting Indicator']/../following-sibling::td[1]/div")
	private WebElement SAP_Account_Indicator;

	@FindBy(xpath = "//*[text()='FCO Device Status']/preceding-sibling::td/div")
	private WebElement deliveryMethodWO;

	@FindBy(xpath = "//input[@value='Initiate Work Order']")
	private WebElement initiateWorkOrder;

	@FindBy(xpath = "//input[@value='Debrief & Complete Work Order']")
	private WebElement debrief_CompleteWO;

	@FindBy(xpath = "//*[text()='Q&R Debrief Status:']/../following-sibling::td//td[2]/div")
	private WebElement QRDebrief_Status_dropdown;

	@FindBy(xpath = "//*[text()='Q&R Debrief Sub Status:']/../following-sibling::td//td[2]/div")
	private WebElement QRDebrief_SubStatus_dropdown;

	@FindBy(xpath = "//li[contains(text(),'Customer')]")
	private List<WebElement> QRDebrief_Status;

	@FindBy(xpath = "//li[contains(text(),'diligence')]")
	private List<WebElement> QRDebrief_SubStatus;

	@FindBy(xpath = "//input[@value='Sync IP and Parts count']")
	private WebElement syncIP_PartsCount_SFM;

	@FindBy(xpath = "//input[@value='Complete FCO Parts WorkOrder']")
	private WebElement complete_Parts_WO_SFM;

	@FindBy(xpath = "//*[text()='Customer Case Reference Number']/preceding-sibling::td/div")
	private WebElement serviceType;

	@FindBy(xpath = "//*[text()='SAP SWO Number']")
	private WebElement sapSwoNumber;

	@FindBy(xpath = "//label[text()='Date FSN/CIL Sent:']/parent::td/following-sibling::td//input")
	private WebElement Date_FSN;

	@FindBy(xpath = "//label[text()='Customer responded:']/parent::td/following-sibling::td//td/div[@role='button']")
	private WebElement CustomerrespondedBTN;

	@FindBy(xpath = "//label[text()='Date Customer Responded:']/parent::td/following-sibling::td//input")
	private WebElement DateCustomerResponded;

	@FindBy(xpath = "//label[text()='Sender:']/parent::td/following-sibling::td/input")
	private WebElement Sender;

	@FindBy(xpath = "//label[text()='Method:']/parent::td/following-sibling::td//td/div[@role='button']")
	private WebElement methodBTN;

	@FindBy(xpath = "//span[@id='sfm-button-1089-btnIconEl']")
	private WebElement save_Due_Dilligence;

	@FindBy(xpath = "//div[contains(text(),'Due Diligence : Please enter data in all required fields (marked in red)')]")
	private WebElement due_Dilligence_Error;

	@FindBy(xpath = "//label[text()='Status:']/parent::td/following-sibling::td//td/div[@role='button']")
	private WebElement StatusBTN;

	@FindBy(xpath = "//span[text()='Error Details']")
	private WebElement due_dilligence_errrs;

	@FindBy(xpath = "//*[@data-qtip='Delete']")
	private List<WebElement> delete_Due_Dilligence;

	@FindBy(xpath = "//div[text()='ES-Agito']/../..//input")
	public WebElement select_Technician1;

	@FindBy(xpath = "//*[text()='State']/../preceding-sibling::td/div")
	private WebElement aso_work_order_page;

	@FindBy(xpath = "//a[contains(text(), 'BST-')]")
	private WebElement benchStatusTrackerNo_WOPage_Value;

	@FindBy(xpath = "//*[contains(@value, 'Initiate Bench Repair')][@class='svmxbtn smallbtn enabledbtn']")
	private WebElement initiateBenchRepair_Button;

	@FindBy(xpath = "//*[@class='dataCol col02 inlineEditLock']//a[contains(text(), 'WO')]")
	private WebElement workOrder_Value_Link;

	@FindBy(xpath = "//*[text()= 'Follow Up Required']//parent::tr//th//a")
	private WebElement followUpRequired_ActivityNumber;

	@FindBy(xpath = "//*[contains(text(), 'Work Order Bench Status')]//parent::tr//td[contains(@class, 'dataCol col02 inlineEdit')]/*")
	private WebElement workOrderBenchStatus_Value;

	@FindBy(xpath = "//*[@value= 'Initiate Remote Service']")
	private WebElement initiateRemoteService_SFM_button;

	@FindBy(xpath = "//*[@id= 'sfm-button-1070-btnIconEl']")
	private WebElement InitiateRemoteWithLabor_saveButton;

	@FindBy(xpath = "//*[text()= 'Work Detail']/../h2")
	private WebElement workDetails_number;

	@FindBy(xpath = "(//*[text()= 'Work Detail'])[1]")
	private WebElement workDetails_pageHeader;

	@FindBy(xpath = "//*[@data-qtip='Diagnostic performed by Engineer']/following-sibling::*/div")
	private WebElement dignosis;

	@FindBy(xpath = "//*[@data-qtip='Save']")
	private WebElement debrif_Save_button;

	@FindBy(xpath = "//*[text()='Hazardous Situation:']//parent::td//parent::tr//input")
	private WebElement hazard_Situation;

	@FindBy(xpath = "//li[text()='Travel']")
	private WebElement labor_Activity_Type_Travel;

	@FindBy(xpath = "//li[text()='Service Consultancy']")
	private WebElement labor_Activity_Type_Service;

	@FindBy(xpath = "//li[text()='Client Service Management']")
	private WebElement labor_Activity_Type;

	@FindBy(xpath = "//input[@value='Debrief and Follow Up']")
	private WebElement debriefAndFollowup;

	@FindBy(xpath = "//li[text()='Installation performed, Device fully functional']")
	private WebElement installation_Support;

	@FindBy(xpath = "//*[@class= 'svmx-grid-row']//td[contains(@class, 'svmx-grid-cell svmx-grid-cell-gridcolumn-1229')]")
	private WebElement followUpActivity_RecommendedFollowUpActivity_editLocked;

	@FindBy(xpath = "//div[text()='Service Type']/ancestor::div/following-sibling::div//input")
	private List<WebElement> followUpActivity_ServiceType;

	@FindBy(xpath = "//div[text()='Bench Repair']/../following-sibling::td[1]")
	private WebElement followUpActivity_RecommendedFollowUpActivity;

	@FindBy(xpath = "//div[text()='Bench Repair']/../following-sibling::td[10]")
	private WebElement followUpActivity_followUPPriority;

	@FindBy(xpath = "//td[@class='svmx-form-item-body svmx-box-layout-ct']//textarea")
	private WebElement followUpActivity_RecommendedFollowUpActivity_textarea;

	@FindBy(xpath = "//input[contains(@id,'sfm-picklistcelleditor')]")
	private List<WebElement> followUpActivity_followupPriority_input;

	@FindBy(xpath = "//*[@class= 'svmx-grid-row']//td[contains(@class, ' svmx-grid-cell svmx-grid-cell-gridcolumn-1238   ')]")
	private WebElement followUpActivity_FollowUpPriority_editLocked;

	@FindBy(xpath = "sfm-picklistcelleditor-1183-inputEl")
	private WebElement followUpActivity_FollowUpPriority_textarea;

	@FindBy(xpath = "//*[@class= 'svmx-grid-row svmx-grid-row-alt']//td[contains(@class, 'svmx-grid-cell svmx-grid-cell-gridcolumn-1156')]")
	private WebElement workActivity_Description_editLocked;

	@FindBy(xpath = "//*[text()='Description:']/../following-sibling::td/textarea")
	private WebElement workActivity_Description_textarea;

	@FindBy(xpath = "//*[contains(text(), 'Follow Up Activity')]")
	private WebElement followUpActivity_tab;

	@FindBy(xpath = "(//*[@data-qtip='Add a row'])[2]")
	private WebElement addRow_FollowUpActivity;

	@FindBy(xpath = "//*[text()='Work Orders']")
	public WebElement work_order;

	@FindBy(xpath = "(//Span[text()= 'Case']/../following-sibling::td/div/a)[1]")
	public WebElement Case_Value;

	@FindBy(xpath = "//td[@class='actionColumn']/following-sibling::th/a[contains(text(),'WO-')]")
	public List<WebElement> work_order_list;

	@FindBy(xpath = "//span[text()='Acknowledge Training Compliance Gap']/../following-sibling::td/div")
	private WebElement Acknowledge;

	@FindBy(xpath = "//span[text()='Acknowledge Training Compliance Gap']/../following-sibling::td/div/input")
	private WebElement Ack_checkbox;

	@FindBy(xpath = "//*[text()= 'Work Order Number']//parent::tr//parent::tbody//tr[contains(@class, 'dataRow')]//th/*")
	private WebElement workOrderNumber_ActionPage;

	@FindBy(xpath = "//*[@value = 'Parts Ordering']")
	private WebElement PartsOrdering;

	@FindBy(xpath = "//*[text()= 'Product Search']")
	private WebElement partsOrdering_SFM_header;

	@FindBy(xpath = "//*[@id='Search']//input[@tabindex='1']")
	private WebElement productCode_searchBox;

	@FindBy(xpath = "//*[@id='Search']//input[@value='Search']")
	private WebElement productCode_SearchButton;

	@FindBy(xpath = "//img[@title='Click To Add Parts']")
	private WebElement addParts_partsOrderingPage_button;

	@FindBy(xpath = "//*[text()= ' Success: Components Added Succesfully to SWO! Success: ASO Created Successfully']")
	private WebElement ASO_Created_successMessage;

	@FindBy(xpath = "//*[@value = 'Get Entitlement']")
	private WebElement GetEntitlement;

	@FindBy(xpath = "//*[@value = 'GATP Simulation']")
	private WebElement GATPSimulation;

	@FindBy(xpath = "//*[@value = 'Transfer To SAP']")
	private WebElement TransferToSAP;

	@FindBy(xpath = "//*[text() = 'Back to work order']")
	private WebElement BacktoWO;

	@FindBy(xpath = "//*[text()= 'Back to work order']")
	private WebElement backToWorkOrderPage_link;

	@FindBy(xpath = "(//h3[text()= 'Parts Order Lines']/../../../../../..//*[@class='pbBody']//tr[contains(@class, 'first')]/td)[8]")
	private WebElement asoNumber_partsOrderLine_value;

	@FindBy(xpath = "(//h3[text()= 'Parts Order Lines']/../../../../../..//*[@class='pbBody']//tr[contains(@class, 'first')]/td)[9]")
	private WebElement asoNumber_partsOrderLine_item;

	@FindBy(xpath = "//*[text()='Custom Links']")
	private WebElement customLink;

	@FindBy(xpath = "//a[text()='IP Change Requests']")
	private WebElement ip_Change_Req;

	@FindBy(xpath = "//a[@title='IP Change Request: Change Request Number - Click to sort ascending']/../../following-sibling::tr//a")
	private WebElement IP_CHANGE_NUM;

	@FindBy(xpath = "//h3[text()='Approval History']")
	private WebElement approva_History;

	@FindBy(xpath = "//*[text()='Approve / Reject']")
	private WebElement approveBTN;

	@FindBy(xpath = "//input[@title='Approve']")
	private WebElement approve;

	@FindBy(xpath = "//span[text()='New Location']/../following-sibling::td/a")
	private WebElement new_Loc;

	@FindBy(xpath = "//span[text()='New Location Account Nr']/../following-sibling::td")
	private WebElement new_Loc_nr;

	@FindBy(xpath = "//span[text()='Installed Product']/../following-sibling::td//a")
	private WebElement install_Prd;

	@FindBy(xpath = "//span[text()='Location']/../following-sibling::td/div")
	private WebElement ip_Location;

	@FindBy(xpath = "//span[text()='Location']/../following-sibling::td/div/following-sibling::div//input[4]")
	private WebElement Ip_Loc_Change;

	@FindBy(xpath = "//span[text()='Location']/../following-sibling::td/div/following-sibling::div//a")
	private WebElement Ip_Loc_Change_search;

	@FindBy(xpath = "//input[@title='Save']")
	private WebElement save_IP_Change_Loc;

	@FindBy(xpath = "//*[contains(@value, 'Record Tools')][@type='button']")
	private WebElement recordTools_SFM_button;

	@FindBy(xpath = "//*[@class= 'svmx-form-field svmx-form-checkbox']")
	private WebElement toolsNotRequired_CheckBox;

	@FindBy(xpath = "//*[@class='svmx-btn-icon svmx-sfmd-save-icon']")
	private WebElement recordTools_Save_button;

	@FindBy(xpath = "//input[@value='Complete Work Order']")
	public WebElement CompleteWorkOrder_SFMbutton;

	@FindBy(xpath = "//iframe[@title='ESMX_Case_Wizard_Lite']")
	private WebElement case_Flow_SFM;

	@FindBy(xpath = "//input[@value='Update the Bench Repair Status']")
	private WebElement update_Bench_Status;

	@FindBy(xpath = "//input[contains(@id,'sfm-picklistcelleditor-')]")
	private WebElement update_Bench_Status_dropdwn;

	@FindBy(xpath = "(//a[contains(text(), 'Create Non WO Events')])[1]")
	public WebElement CreateNonWOEvents;

	// Create Non Work Order Events Screen
	@FindBy(xpath = "//img[@title = 'Assigned To Lookup (New Window)']")
	public WebElement AssignedToLookup;

	@FindBy(xpath = "//*[@id = 'evt1']")
	public WebElement AssignedToSearch;

	@FindBy(xpath = "//*[@id='lkenhmdSEARCH_ALL']")
	public WebElement AllFields;

	@FindBy(xpath = "//*[@id='User_body']/table/tbody/tr[2]/th/a")
	public WebElement UserName;

	@FindBy(xpath = "//*[@value = ' Go! ']")
	public WebElement Go;

	@FindBy(xpath = "//*[@id = 'IsRecurrence']")
	public WebElement Recurrence;

	@FindBy(xpath = "//a[contains(text(), 'Calculate Latest Date')]")
	public WebElement CalcLatestDate;

	@FindBy(xpath = "(//a[contains(text(), 'View')])[1]")
	public WebElement ViewNonWOEvents;

	@FindBy(xpath = "//td[text()='Follow Up Required']/../th/a")
	public WebElement activity_followupWO;

	@FindBy(xpath = "//*[text()='Work Order Number']/../following-sibling::tr//a[contains(text(),'WO-')]")
	public WebElement activity_followupWOText;

	@FindBy(xpath = "(//*[text() = 'Labor'])[1]/preceding-sibling::th")
	private WebElement WorkDetailLabor1;

	@FindBy(xpath = "//*[@value = 'Change Order Status to In Process']")
	private WebElement ChangeOrderStatusSFM;

	@FindBy(xpath = "//*[text()='Street']/../preceding-sibling::td/div")
	private WebElement fcoParts_value;

	@FindBy(xpath = "//input[@value='Remote Service WorkSpot']")
	private WebElement remote_service_workspot;

	public String caseNumber;
	HybrisPage hybrisPage;
	RswPage rswPage;

	public WorkOrderPage(WebDriver driver) {
		super(driver);
		hybrisPage = new HybrisPage(driver);
		rswPage = new RswPage(driver);
	}

	public void initiate_Onsite_SFM() {
		waitTill("6");
		waitForElement(work_Order_Header, "work_Order_Header");
		click("case_Details", detailsTab);
		driver.navigate().refresh();
		waitTill("10");
		waitForElement(service_Flow_SFM, "service_Flow_SFM");
		embedScreenShotInreport();
		driver.switchTo().frame(service_Flow_SFM);
		embedScreenShotInreport();
		waitForElement(initiate_Onsite_SFM, "initiate_Onsite_SFM");
		click("initiate_Onsite_SFM", initiate_Onsite_SFM);
		waitTill("5");
		waitForElement(work_Order, "work_Order");
		click("work_Order", work_Order);
	}

	public void add_Labor_And_Parts() {
		driver.switchTo().defaultContent();
		waitTill("3");
		click("Details", case_Details);
		waitTill("3");
		waitForElement(work_Order_Header, "work_Order_Header");
		waitForElement(service_Flow_SFM, "service_Flow_SFM");
		waitTill("10");
		driver.switchTo().frame(service_Flow_SFM);
		waitForElement(add_Labor_Parts_SFM, "add_Labor_Parts_SFM");
		waitForElement(add_Labor_Parts_SFM, "add_Labor_Parts_SFM");
		embedScreenShotInreport();
		waitTill("3");
		try {
		click("add_Labor_Parts_SFM", add_Labor_Parts_SFM);
		waitForElement(work_Order_Lines_Dialog, "work_Order_Lines_Dialog");
		}catch(Exception e) {
			logReport("INFO","Exception in waitForElement::add_Labor_Parts_SFM");
			waitTill("100");
		}
		waitTill("5");
		clickEvent(open_Labor);
		waitTill("5");
		clickEvent(edit_Labor_Parts);
		waitTill("5");
		clickEvent(line_Status_DropDown);
		waitTill("5");
		clickEvent(line_Status_Confirmed);
		waitTill("5");
		click("labor_Activity_Type_DropDown", labor_Activity_Type_DropDown);
		waitTill("5");
		if (verifyElementPresent("Service consultancy", labor_Activity_Type_Serviceconsultancy)) {
			embedScreenShotInreport();
			clickEvent(labor_Activity_Type_Serviceconsultancy);
			waitTill("3");
			click("activity_Type_DropDown", activity_Type_DropDown);
			waitTill("3");
			clickEvent(activity_Type_Configuration);
			waitTill("3");

		} else {
			clickEvent(labor_Activity_Type_Work);
			waitTill("3");
			click("activity_Type_DropDown", activity_Type_DropDown);
			waitTill("3");
			clickEvent(activity_Type_Work_Time);
			waitTill("3");
		}

		enter("Enter Duration", labor_Activity_Duration, "1");
		embedScreenShotInreport();
		waitTill("3");
		clickEvent(update_Labor);
		waitTill("5");
		click("Save Work Order Lines", saveopenlabor);
		logReport("INFO", "Add Laibor Or Partes - SFM - done");
		waitTill("3");
	}

	public void openPartsReturnable(String pc) {
		waitForElement(work_Order_Header, "work_Order_Header");
		waitForElement(service_Flow_SFM, "service_Flow_SFM");
		driver.switchTo().frame(service_Flow_SFM);
		/*
		 * waitForElement(initiate_Onsite_SFM,"initiate_Onsite_SFM");
		 * click("initiate_Onsite_SFM",initiate_Onsite_SFM);
		 */
		waitForElement(add_Labor_Parts_SFM, "add_Labor_Parts_SFM");
		embedScreenShotInreport();
		waitTill("3");
		try {
		click("add_Labor_Parts_SFM", add_Labor_Parts_SFM);
		}catch(Exception e) {
			logReport("INFO","Exception in waitForElement::add_Labor_Parts_SFM TAN");
			waitTill("100");
		}
		waitForElement(work_Order_Lines_Dialog, "work_Order_Lines_Dialog");
		waitTill("3");
		clickEvent(openpartsReturnableTab);
		embedScreenShotInreport();
		waitTill("3");
		clickEvent(editopenParts);
		waitTill("3");
		clickEvent(partstatus);
		waitTill("3");
		clickEvent(consumedvalue);
		waitTill("3");
		clickEvent(Ipstructurecheckbox);
		waitTill("3");
		clickEvent(linestatusdropdwon);
		waitTill("3");
		clickEvent(confirmedvalue);
		waitTill("3");
		enter("RMLNumber", RMLNumber, "R353002135");
		embedScreenShotInreport();
		int i = Utility.randomNumber(9);
		String s = Integer.toString(i);
		enter("defectiveSerialNumber", defectiveSerialNumber, s);
		waitTill("3");
		enter("trackingNumber", trackingNumber, s);
		embedScreenShotInreport();
		waitTill("3");
		enter("defectpartnumber", defectpartnumber, pc);
		waitTill("3");
		enter("defectpartinfo", defectpartinfo, "Test");
		waitTill("3");
		click("defectivepartfailureDropddown", defectivepartfailureDropddown);
		embedScreenShotInreport();
		waitTill("3");
		clickEvent(failurevalue);
		waitTill("3");
		clickEvent(defectpartcategory);
		embedScreenShotInreport();
		waitTill("3");
		clickEvent(defectpartcategoryvalue);
		waitTill("3");
		clickEvent(update_Labor);
		waitTill("10");
		embedScreenShotInreport();
		clickEvent(saveopenlabor);
		waitTill("10");
		embedScreenShotInreport();
	}

	public void searchworkorder() {
		waitForElement(globalSearchBox, AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("WORK_ORDER_NUMBER"));
		waitTill("5");
		enter("search", globalSearchBox,
				AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("WORK_ORDER_NUMBER"));
		waitTill("5");
		click("globalSearchButton", globalSearchButton);
		waitTill("5");
		waitForElement(searchResult, "search Result");
		embedScreenShotInreport();
		driver.findElement(By.xpath("//*[text()='Edit']/..//following-sibling::th//a[text()='"
				+ AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("WORK_ORDER_NUMBER") + "']")).click();

		if(verifyElementPresent("case details", case_Details)) {
			click("Case details", case_Details);
		}
	}

	public void open_Work_OrderLine_Item() {
		waitForElement(work_Order_Line_Item, "work_Order_Line_Item");
		try {
			AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("SAP SWO Number",
					driver.findElement(By.xpath("//span[text()='SAP SWO Number']/../following-sibling::td[1]/div"))
					.getText());
		} catch (Exception e) {

		}
		scrollByViewOfElement(work_Order_Line_Item);
		clickEvent(work_Order_Line_Item);
		waitForElement(WORK_ORDER_LINE_ITEM, "Work Order Line Item");
		waitTill("5");
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("WORK_ORDER_LINE_ITEM",
				WORK_ORDER_LINE_ITEM.getText());
		driver.navigate().refresh();
		waitTill("5");
		if (!INTEGRATION_STATUS.getText().isEmpty() || !SAP_ACCOUNTING_INDICATOR.getText().isEmpty()) {
			AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("INTEGRATION_STATUS",
					INTEGRATION_STATUS.getText());
			AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("SAP_ACCOUNTING_INDICATOR",
					SAP_ACCOUNTING_INDICATOR.getText());
			AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("SAP_CONFIRMATION_NUMBER",
					SAP_CONFIRMATION_NUMBER.getText());
			AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("SAP_CONFIRMATION_COUNTER",
					SAP_CONFIRMATION_COUNTER.getText());
			AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("LINE_STATUS", LINE_STATUS.getText());
		}
		if (!INTEGRATION_STATUS.getText().isEmpty() || !SAP_ACCOUNTING_INDICATOR.getText().isEmpty()) {
			driver.navigate().refresh();
			waitTill("5");
			waitForElement(WORK_ORDER_LINE_ITEM, "Work Order Line Item");
			AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("INTEGRATION_STATUS",
					INTEGRATION_STATUS.getText());
			AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("SAP_ACCOUNTING_INDICATOR",
					SAP_ACCOUNTING_INDICATOR.getText());
			AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("SAP_CONFIRMATION_NUMBER",
					SAP_CONFIRMATION_NUMBER.getText());
			AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("SAP_CONFIRMATION_COUNTER",
					SAP_CONFIRMATION_COUNTER.getText());
			AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("LINE_STATUS", LINE_STATUS.getText());
		}
		System.out.println(AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("SAP SWO Number"));
		System.out.println(AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("INTEGRATION_STATUS"));
		System.out.println(AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("SAP_ACCOUNTING_INDICATOR"));
		System.out.println(AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("SAP_CONFIRMATION_NUMBER"));
		System.out.println(AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("SAP_CONFIRMATION_COUNTER"));
		loadServiceMaxData();
	}

	public void loadServiceMaxData() {
	}

	public void getCase() {
		waitForElement(txt_case, "case value");
		caseNumber = txt_case.getText();
		logReport("INFO", "The work order created case number is " + caseNumber);
	}

	public void verify_WorkOrderSAp() {
		waitTill("5");
		scrollByViewOfElement(link_workOrder);
		BaseLib.embedScreenShotInreportWithRobot();
		waitTill("5");
		for (int i = 0; i < 5; i++) {
			if (verifyElementPresent("Work order", workOrder_details)) {
				logReport("INFO", "The work order delivered in SAP is reflected");
				break;
			} else {
				driver.navigate().refresh();
				logReport("INFO", "The work order delivered in SAP is not yet reflected");
				waitTill("6");
			}
		}

	}

	public void selectLabourDeliver(String value) {
		waitTill("5");
		waitForElement(work_Order_Header, "work_Order_Header");
		waitForElement(service_Flow_SFM, "service_Flow_SFM");
		driver.switchTo().frame(service_Flow_SFM);
		waitForElement(add_Labor_Parts_SFM, "add_Labor_Parts_SFM");
		click("add_Labor_Parts_SFM", add_Labor_Parts_SFM);
		waitForElement(work_Order_Lines_Dialog, "work_Order_Lines_Dialog");
		embedScreenShotInreport();
		clickEvent(edit_labour.get(0));
		waitTill("5");
		waitForElement(lineStatus_dropdown, "Drop down");
		clickEvent(lineStatus_dropdown);
		waitTill("5");
		try {
			driver.findElement(By.xpath("//li[text()='" + value + "']"));
		} catch (Exception e) {
			waitTill("3");
			driver.findElement(By.xpath("//label[text()='Line Status:']/ancestor::table//td[contains(@id,'ext-gen')]"))
			.click();
			waitTill("3");
			driver.findElement(By.xpath("//li[text()='" + value + "']")).click();
			;
		}
		embedScreenShotInreport();
		try {
			click("Line status", status);
		} catch (Exception e) {
		}
		waitForElement(updateButton, "Update button");
		click("Update", updateButton);
		waitForElement(saveopenlabor, "Save");
		embedScreenShotInreport();
		click("Save", saveopenlabor);

	}

	public void opne_Partsnonreturnable() {
		waitForElement(work_Order_Header, "work_Order_Header");
		waitForElement(service_Flow_SFM, "service_Flow_SFM");
		driver.switchTo().frame(service_Flow_SFM);
		waitForElement(add_Labor_Parts_SFM, "add_Labor_Parts_SFM");
		click("add_Labor_Parts_SFM", add_Labor_Parts_SFM);
		waitForElement(work_Order_Lines_Dialog, "work_Order_Lines_Dialog");
		embedScreenShotInreport();
		clickEvent(btn_partsNonreturn);
		clickEvent(edit_labour.get(0));
		waitTill("5");
		waitForElement(chk_force, "force return");
		embedScreenShotInreport();
		click("force return", chk_force);
		waitForElement(updateButton, "Update button");
		click("Update", updateButton);
		waitForElement(recordTools_Save_button, "Save");
		embedScreenShotInreport();
		click("Save", recordTools_Save_button);

	}

	public void parts_Returnable(String value, String rmlNum) {
		waitForElement(work_Order_Header, "work_Order_Header");
		waitForElement(service_Flow_SFM, "service_Flow_SFM");
		driver.switchTo().frame(service_Flow_SFM);
		waitForElement(add_Labor_Parts_SFM, "add_Labor_Parts_SFM");
		click("add_Labor_Parts_SFM", add_Labor_Parts_SFM);
		waitForElement(work_Order_Lines_Dialog, "work_Order_Lines_Dialog");
		clickEvent(btn_partsreturn);
		embedScreenShotInreport();
		clickEvent(edit_labour.get(0));
		waitTill("5");
		waitForElement(dropdown_forceReturn, "Force return");
		click("Force return", dropdown_forceReturn);
		embedScreenShotInreport();
		waitTill("5");
		WebElement force = driver.findElement(By.xpath("//li[text()='" + value + "']"));
		click("force return", force);
		waitForElement(dropdown_defectiveFailure, "Defective failure reason");
		click("Defective failure reason", dropdown_defectiveFailure);
		waitTill("5");
		embedScreenShotInreport();
		click("defective failure", option_defect);
		waitForElement(dropdown_defectpart, "defectPart");
		click("defectPart", dropdown_defectpart);
		waitTill("5");
		click("dfect part", option_defectpart);
		waitForElement(txt_defectInfo, "Defect info");
		embedScreenShotInreport();
		enter("Information", txt_defectInfo, "Automation");
		waitForElement(txt_RML, "RML number");
		enter("RML number", txt_RML, rmlNum);
		waitForElement(lineStatus, "Line status");
		enter("Line status", lineStatus, "Confirmed");
		waitForElement(updateButton, "Update button");
		click("Update", updateButton);
		embedScreenShotInreport();
		waitForElement(recordTools_Save_button, "Save");
		click("Save", recordTools_Save_button);
		embedScreenShotInreport();
	}

	public void recordTool() {
		waitForElement(work_Order_Header, "work_Order_Header");
		waitForElement(service_Flow_SFM, "service_Flow_SFM");
		driver.switchTo().frame(service_Flow_SFM);
		waitForElement(btn_recordTool, "Record tool");
		click("Record tool", btn_recordTool);
		waitDottedSpinnerToDisappear();
		waitForElement(chk_tool, "Tool check box");
		click("Tool check box", chk_tool);
		waitForElement(recordTools_Save_button, "save");
		embedScreenShotInreport();
		click("save", recordTools_Save_button);
	}

	public void initiateTravelSFM() {
		waitAndswitchToRequiredFrame(service_order_frame);
		waitTill("5");
		waitForElement(btn_travelSFM, "Inititale Travel");
		click("Inititale Travel", btn_travelSFM);
		waitDottedSpinnerToDisappear();
		click("WO", link_WO);
		embedScreenShotInreport();
	}

	public void add_Labor_And_PartswithoutOverlap() {

		waitForElement(work_Order_Header, "work_Order_Header");
		waitForElement(service_Flow_SFM, "service_Flow_SFM");
		driver.switchTo().frame(service_Flow_SFM);
		waitForElement(add_Labor_Parts_SFM, "add_Labor_Parts_SFM");
		embedScreenShotInreport();
		click("add_Labor_Parts_SFM", add_Labor_Parts_SFM);
		waitForElement(work_Order_Lines_Dialog, "work_Order_Lines_Dialog");
		embedScreenShotInreport();
		clickEvent(open_Labor);
		clickEvent(edit_labour.get(1));
		waitTill("5");
		embedScreenShotInreport();
		clickEvent(line_Status_DropDown);
		clickEvent(line_Status_Confirmed);
		click("labor_Activity_Type_DropDown", labor_Activity_Type_DropDown);
		if (verifyElementPresent("Service consultancy", labor_Activity_Type_Serviceconsultancy)) {
			embedScreenShotInreport();
			clickEvent(labor_Activity_Type_Serviceconsultancy);
			click("activity_Type_DropDown", activity_Type_DropDown);
			clickEvent(activity_Type_Configuration);
			embedScreenShotInreport();

		} else {
			clickEvent(labor_Activity_Type_Work);
			click("activity_Type_DropDown", activity_Type_DropDown);
			clickEvent(activity_Type_Work_Time);
			embedScreenShotInreport();
		}

		// click("hour dropdown", dropdown_hour);
		// WebElement hour = driver.findElement(By.xpath("//li[contains(text(),'" + i +
		// "')]"));
		// click("hour", hour);
		enter("Enter Duration", labor_Activity_Duration, "0.5");

		// click("Next", nextButton1);
		// clickEvent(line_Status_DropDown);
		// clickEvent(line_Status_Confirmed);
		// click("labor_Activity_Type_DropDown", labor_Activity_Type_DropDown);
		// clickEvent(labor_Activity_Type_Work);
		// click("activity_Type_DropDown", activity_Type_DropDown);
		// clickEvent(activity_Type_Work_Time);
		// click("hour dropdown", dropdown_hour);
		// i = i + 1;
		// if (i > 12) {
		// i = 1;
		// }
		// WebElement hour1 = driver.findElement(By.xpath("//li[contains(text(),'" + i +
		// "')]"));
		// click("hour", hour1);
		// enter("Enter Duration", labor_Activity_Duration, "1");
		clickEvent(update_Labor);
		waitTill("5");
		embedScreenShotInreport();
		click("Save Work Order Lines", saveopenlabor);
		logReport("INFO", "Add Laibor Or Partes - SFM - done");
	}

	public void debrief_and_FollowUp() {
		waitTill("5");

		waitForElement(work_Order_Header, "work_Order_Header");
		waitForElement(service_Flow_SFM, "service_Flow_SFM");
		driver.switchTo().frame(service_Flow_SFM);

		waitForElement(debriefAndFollowUp_SFM_button, "Debrief and Follow Up SFM");
		embedScreenShotInreport();
		click("Debrief and Follow Up SFM", debriefAndFollowUp_SFM_button);
		if (verifyElementPresent("debrief_InstallationStatus", debrief_InstallationStatus)) {
			enter("Installation Status", debrief_InstallationStatus, "Installation performed, Device fully functional");
			pressEnter();
			embedScreenShotInreport();
			enter("T&V Status", tAndV_Status_dropdown, "Reported");
			pressEnter();
			scrollByViewOfElement(tAndV_Status_dropdown);
			embedScreenShotInreport();
			click("debriefSystemStatusDateOrTime_button", debriefSystemStatusDateOrTime_button);
			waitForElement(btn_time, "time");
			click("time", btn_time);
			waitTill("5");
			embedScreenShotInreport();
			enter("IB_Record_Installation", IBRecord_installation, "Yes");
			pressEnter();
			embedScreenShotInreport();
		} else if (verifyElementPresent("internalSupportStatus_dropdown", internalSupportStatus_dropdown)) {
			enter("Internal Support Status", internalSupportStatus_dropdown, "Internal Support Work Order Completed");
			pressEnter();
			scrollByViewOfElement(debriefSystemStatusDateOrTime_button);
			embedScreenShotInreport();
			click("debriefSystemStatusDateOrTime_button", debriefSystemStatusDateOrTime_button);
			enter("T&V Status", tAndV_Status_dropdown, "Reported");
			pressEnter();
			embedScreenShotInreport();
		}

		else {
			enter("Debrief System Status", debriefSystemStatus_dropdown,
					"The system fully meets specification and returned to use");
			pressEnter();
			scrollByViewOfElement(hazardCategory_dropdown);
			waitTill("5");
			embedScreenShotInreport();
			enter("Hazard Category", hazardCategory_dropdown, "Biological and Chemical");
			pressEnter();
			enter("Hazard situation", input_hazard, "Patient Exposure to (HAZARD) During Clinical Use");
			pressEnter();
			enter("Hazard", hazard_dropdown, "Biocompatibility / Toxicity of chemical constituents, etc.");
			pressEnter();
			enter("Clinical Usage", clinicalUsage_dropdown, "In Use");
			pressEnter();
			waitTill("5");
			scrollByViewOfElement(clinicalUsage_dropdown);
			embedScreenShotInreport();
			enter("T&V Status", tAndV_Status_dropdown, "Reported");
			pressEnter();
			click("debriefSystemStatusDateOrTime_button", debriefSystemStatusDateOrTime_button);
			waitForElement(btn_time, "time");
			click("time", btn_time);
			waitTill("5");
			embedScreenShotInreport();
			waitForElement(Work_Activity, "Work activity");
			click("Work activity", Work_Activity);
			embedScreenShotInreport();
			waitForElement(edit_labour.get(0), "laour");
			click("labour", edit_labour.get(0));
			waitForElement(btn_down, "next");
			click("next", btn_down);
			waitForElement(txt_description, "Desctiption");
			enter("Desctiption", txt_description, "Automation");
			scrollByViewOfElement(txt_description);
			embedScreenShotInreport();
			waitForElement(updateButton, "Update button");
			embedScreenShotInreport();
			click("Update", updateButton);
			waitForElement(RegulatoryQues, "Regulatory");
			click("Regulatory", RegulatoryQues);
			if (verifyElementPresent("btn_editHeader", btn_editHeader)) {
				waitForElement(btn_editHeader, "edit");
				clickEvent(btn_editHeader);
				waitForElement(txt_ans1, "Answer 1");
				enter("Answer", txt_ans1, "No");
				waitForElement(txt_ans2, "Answer 1");
				enter("Answer", txt_ans2, "No");
				scrollByViewOfElement(txt_ans2);
				embedScreenShotInreport();
				waitForElement(updateButton, "Update button");
				click("Update", updateButton);
			}

		}
		waitForElement(recordTools_Save_button, "Save");
		click("Save", recordTools_Save_button);
		waitDottedSpinnerToDisappear();
		embedScreenShotInreport();
	}

	@FindBy(xpath = "//a[text()='Case Number']/ancestor::table[@class='list']//th[@scope='row']/a")
	private WebElement link_case;

	@FindBy(xpath = "//input[@value='Create Case Activity']")
	private WebElement btn_case;

	@FindBy(xpath = "(//table[@class='svmx-form-trigger-wrap'])[4]//td[@class='svmx-trigger-cell']/div")
	private WebElement btn_typeDropdown;

	@FindBy(xpath = "//div[@class='svmx-boundlist-list-ct']//li")
	List<WebElement> dropDown_list;

	@FindBy(xpath = "//span[@class='svmx-btn-icon svmx-sfmd-add-line-icon']/parent::button")
	private WebElement btn_newValue;

	@FindBy(xpath = "//label[text()='Type:']/parent::td/following-sibling::td/table//td[2]/div")
	private WebElement dropdownType;

	@FindBy(xpath = "//label[text()='Type:']/parent::td/following-sibling::td/table//td[1]//input")
	private WebElement input_type;

	@FindBy(xpath = "//label[text()='PHI Data:']/parent::td/following-sibling::td/textarea")
	private WebElement txt_phiData;

	@FindBy(xpath = "(//*[@data-qtip='Extended Edit'])[3]")
	private WebElement btn_edittype;

	@FindBy(xpath = "//h3[text()='Case Activities']")
	private WebElement link_caseActivities;

	@FindBy(xpath = "//h3[text()='Case Activities']/ancestor::div[starts-with(@class,'bPageBlock')]//table[@class='list']/tbody/tr[starts-with(@class,'dataRow')]")
	List<WebElement> list_caseActivities;

	@FindBy(xpath = "//h3[text()='Case Activities']/ancestor::div[starts-with(@class,'bPageBlock')]//table[@class='list']/tbody/tr[starts-with(@class,'dataRow')]/td/a[text()='Edit']")
	List<WebElement> list_EditActivities;

	@FindBy(xpath = "//span[text()='PHI Data']/parent::td/following-sibling::td[1]")
	private WebElement txt_phi;

	@FindBy(xpath = "//*[@title='Work Order']/ancestor::div[@class='pbHeader']")
	private WebElement FCO_WorkOrder_Header;

	@FindBy(xpath = "//*[text()='Work Order Number']/parent::tr/following-sibling::tr/th/a")
	private WebElement FCO_WorkOrder;

	@FindBy(xpath = "//input[@value='Initiate Work Order']")
	private WebElement initiate_Onsite_WorkOrder;

	@FindBy(xpath = "//input[@value='Create/Manage Due Diligence']")
	private WebElement Manage_Due_Diligence;

	@FindBy(xpath = "//input[@value='Cancel CAL/DAL Work Order']")
	private WebElement Cancel_CAL_Work_Order;

	@FindBy(xpath = "//*[text()='Bench Status Tracker Number']/parent::tr/following-sibling::tr/th/a")
	private WebElement bench_Status_Tracker;

	@FindBy(xpath = "//span[text()='Attempt']/parent::td/following-sibling::td/div")
	private WebElement attempt;

	@FindBy(xpath = "//input[@value='New Note']")
	private WebElement new_Note;

	@FindBy(xpath = "//input[@value='Attach File']")
	private WebElement attach_File;

	@FindBy(xpath = "//div[@id='svmx_sfm_delivery_root_container0']")
	private WebElement due_Dilligence_Dialog;



	@FindBy(xpath = "//label[text()='Attempt:']/parent::td/following-sibling::td//td/div[@role='button']")
	private WebElement attempts_BTN;

	@FindBy(xpath = "//span[text()='Automation Technician']")
	public WebElement service_Technician;

	// @FindBy(xpath = "//div[text()='Italy Service Team']/../..//input")
	// public WebElement select_Technician;

	@FindBy(xpath = "//div[text()='ES-CCHI']/../preceding-sibling::div//input")
	public WebElement select_Technician;

	// @FindBy(xpath = "//div[text()='Italy Service
	// Team']/../..//input[@type='radio']")
	// public WebElement owner;

	@FindBy(xpath = "//div[text()='ES-CCHI']/../..//input[@type='radio']")
	public WebElement owner;

	@FindBy(xpath = "//h3[text()='Case Activities']/ancestor::div[starts-with(@class,'bPageBlock')]//table[@class='list']/tbody/tr//th[text()='Safety Questions']")
	private WebElement txt_questions;

	@FindBy(xpath = "//h3[text()='Case Activities']/ancestor::div[starts-with(@class,'bPageBlock')]//table[@class='list']/tbody/tr[4]/td[3]/a")
	private WebElement link_safety_CA;

	@FindBy(xpath = "//td[@id='topButtonRow']//input[@title='Edit']")
	private WebElement btn_CAEdit;

	@FindBy(xpath = "//td[@id='topButtonRow']//input[@title='Save']")
	private WebElement btn_saveCA;

	@FindBy(xpath = "//td[text()='Case']/parent::tr//a")
	private WebElement link_caseCA;

	@FindBy(xpath = "//input[@value='Capture Escalation Stakeholders Info']")
	private WebElement btn_escalation;

	@FindBy(xpath = "//label[text()='Case Activity Status']/parent::span/../..//select")
	private WebElement dropDown_status;

	@FindBy(xpath = "//label[text()='Source:']/parent::td/following-sibling::td//input")
	private WebElement txt_source;

	@FindBy(xpath = "//label[text()='Type:']/parent::td/following-sibling::td//input")
	private WebElement txt_type;

	@FindBy(xpath = "//label[text()='Description:']/parent::td/following-sibling::td//textarea")
	private WebElement txt_descriptionphone;

	@FindBy(xpath = "//*[text()= 'Dependent?']/preceding-sibling::td/div")
	private WebElement sapSwoNumber_value;

	@FindBy(xpath = "//*[text()= 'Country']/../preceding-sibling::td/div")
	private WebElement sapSwoNumber_RemoteWO;

	@FindBy(xpath = "//*[@value='Initiate SWO']")
	private WebElement initiateSWO_SFM_button;

	public void navigateTocase() {
		waitTill("5");
		globalSearch("0116626387");
		waitForElement(link_case, "case value");
		click("case value", link_case);
	}

	public void select_caseActivity() {
		waitForElement(manage_WorkOrder_Frame, "frame");
		waitAndswitchToRequiredFrame(manage_WorkOrder_Frame);
		waitForElement(btn_case, "Case activity");
		click("Case activity", btn_case);
		waitDottedSpinnerToDisappear();
		embedScreenShotInreport();
	}

	public void verifyType_update() {
		waitForElement(btn_newValue, "new value");
		click("new value", btn_newValue);
		waitForElement(edit_labour.get(0), "Edit");
		click("Edit", edit_labour.get(0));
		waitForElement(dropdownType, "Type dropdown");
		embedScreenShotInreport();
		click("Type dropdown", dropdownType);
		for (int i = 0; i < dropDown_list.size(); i++) {
			verifyElementPresent("Type list", dropDown_list.get(i));
		}
		pressEnter();
		enterNext_stepAction();
		enter_InternalRemarks();
		enter_Customercomment();
		waitForElement(recordTools_Save_button, "Save");
		click("Save", recordTools_Save_button);
		try {
			waitForElement(btn_nextType, "next");
			click("Next", btn_nextType);
			waitForElement(saveButton3, "Save");
			click("Save", saveButton3);
		} catch (Exception e) {

		}
		waitDottedSpinnerToDisappear();
		embedScreenShotInreport();
	}

	public void enterNext_stepAction() {
		waitForElement(input_type, "TYpe");
		enter("Type value", input_type, "Next Step Action");
		pressEnter();
		waitForElement(txt_description, "Description");
		enter("Description", txt_description, "Automation Test");
		waitForElement(txt_phiData, "Description");
		enter("Description", txt_phiData, "test");
		waitForElement(updateButton, "Update button");
		embedScreenShotInreport();
		click("Update", updateButton);
	}

	public void enter_InternalRemarks() {
		waitForElement(btn_newValue, "new value");
		click("new value", btn_newValue);
		waitForElement(edit_Labor_Parts, "Edit");
		click("Edit", edit_Labor_Parts);
		waitForElement(input_type, "TYpe");
		enter("Type value", input_type, "Internal Remarks");
		pressEnter();
		waitForElement(txt_description, "Description");
		enter("Description", txt_description, "Automation Test");
		waitForElement(txt_phiData, "Description");
		enter("Description", txt_phiData, "test");
		waitForElement(updateButton, "Update button");
		embedScreenShotInreport();
		click("Update", updateButton);
	}

	public void enter_Customercomment() {
		waitForElement(btn_newValue, "new value");
		click("new value", btn_newValue);
		waitForElement(btn_edittype, "Edit");
		click("Edit", btn_edittype);
		waitForElement(input_type, "TYpe");
		enter("Type value", input_type, "Customer comment");
		pressEnter();
		waitForElement(txt_description, "Description");
		enter("Description", txt_description, "Automation Test");
		waitForElement(txt_phiData, "Description");
		enter("Description", txt_phiData, "test");
		embedScreenShotInreport();
		waitForElement(updateButton, "Update button");
		click("Update", updateButton);
	}

	public void verifyCaseActivities() {
		waitTill("5");
		scrollByViewOfElement(link_caseActivities);
		for (int i = 0; i < list_caseActivities.size(); i++) {
			verifyElementPresent("Created activities", list_caseActivities.get(i));
		}
		embedScreenShotInreport();
	}

	public void verifyPHI() {
		for (int i = 0; i < list_EditActivities.size(); i++) {
			click("Edit activity", list_EditActivities.get(i));
			waitTill("5");
			waitForElement(txt_phi, "PHI");
			if (txt_phi.getText().contains("***")) {
				logReport("PASS", "PHI data is encripted");
			} else {
				logReport("FAIL", "PHI data is  not encripted");
			}
			waitForElement(cancelButton, "Cancel");
			embedScreenShotInreport();
			click("Cancel", cancelButton);
			break;
		}
	}

	public void selectCase(String value) {
		waitTill("5");
		globalSearch(value);
		waitForElement(link_case, "case value");
		click("case value", link_case);
	}

	public void verify_caseActivitydiabled() {
		waitForElement(manage_WorkOrder_Frame, "frame");
		waitAndswitchToRequiredFrame(manage_WorkOrder_Frame);
		waitForElement(btn_case, "Case activity");
		if (btn_case.getAttribute("disabled").equalsIgnoreCase("true")) {
			logReport("PASS", "The case activity SFM is diabled");
		} else {
			logReport("FAIL", "The case activity SFM is not diabled");
		}
	}

	public void verifySafetyQuestions() {
		waitTill("5");
		scrollByViewOfElement(link_caseActivities);
		waitForElement(txt_questions, "Safety questions");
		if (verifyElementPresent("Safety questions", txt_questions)) {
			logReport("PASS", "The safety questions is present");
		} else {
			logReport("FAIL", "The safety questions is not present");
		}
	}

	public void verify_safetyQuestionCA() {
		waitForElement(link_safety_CA, "CA");
		click("CA", link_safety_CA);
		waitForElement(btn_CAEdit, "Edit");
		click("Edit", btn_CAEdit);
		waitTill("5");
		embedScreenShotInreport();
		selectbyValue(dropDown_status, "Picked Up", "Picked Up");
		waitForElement(btn_saveCA, "Save");
		embedScreenShotInreport();
		click("Save", btn_saveCA);
		waitForElement(link_caseCA, "case link");
		click("case link", link_caseCA);
	}

	public void escalationUpdate() {
		waitForElement(manage_WorkOrder_Frame, "frame");
		waitAndswitchToRequiredFrame(manage_WorkOrder_Frame);
		waitForElement(btn_escalation, "escalation");
		click("escalation", btn_escalation);
		waitForElement(btn_newValue, "new value");
		embedScreenShotInreport();
		click("new value", btn_newValue);
		waitForElement(btn_edittype, "Edit");
		click("Edit", btn_edittype);
		waitForElement(txt_source, "Source");
		enter("Source", txt_source, "Phone");
		pressEnter();
		waitForElement(txt_type, "Source");
		embedScreenShotInreport();
		enter("Source", txt_type, "Next Step Action");
		pressEnter();
		enter("description", txt_descriptionphone, "Automation");
		waitForElement(updateButton, "Update button");
		embedScreenShotInreport();
		click("Update", updateButton);
		waitForElement(saveTypeButton, "Save");
		try {
			click("Save", saveTypeButton);
		} catch (Exception e) {
			click("Save", save_Work_Order_Lines);
		}
		waitDottedSpinnerToDisappear();
		embedScreenShotInreport();
	}

	public void complete_WO() {
		waitAndswitchToRequiredFrame(service_Flow_SFM);
		waitForElement(btn_complete_WO, "Completed WO");
		click("Completed WO", btn_complete_WO);
		waitDottedSpinnerToDisappear();
		pressEnter();
		click("service_report_dropdown", service_report_dropdown);
		click("Customer does not require CSR/ANR/PSR",driver.findElement(By.xpath("//li[text()='Customer does not require CSR/ANR/PSR']")));


		waitForElement(save_Work_Order_Lines, "Save");
		embedScreenShotInreport();
		click("Save", save_Work_Order_Lines);
		waitDottedSpinnerToDisappear();
	}

	private void updateSoftwareInstalled() {
		// TODO Auto-generated method stub

	}

	public void verifyIsBillableBlank(String pc) {
		if (pc.contains("Labour")) {
			click("Work LineItem", line_number_labour);

		} else {
			click("Work LineItem", line_number_Parts);
		}
		verifyElementTobePresent("Is billable Blank", checkbox_isbillable);
		waitForElement(SAP_Account_Indicator, "SAP Account Indicator");
		verifyBooleanStatus(SAP_Account_Indicator.getText(), "55");
		embedScreenShotInreport();
	}

	public void verifyFCOInfoWO(String woNumber, String wo) {
		search_GlobalsearchBox(woNumber);
		click("WorkOrder", driver.findElement(By.xpath(".//a[contains(text(),'" + woNumber + "')]")));
		click("Details", detailsTab);
		switch (wo) {
		case "WO1":
			System.out.println("Delivery Method WO1:" + deliveryMethodWO.getText());
			verifyBooleanStatus(deliveryMethodWO.getText(), TestData.get(0).get("Delivery Method"));
			break;
		case "WO2":
			System.out.println("Delivery Method WO2:" + deliveryMethodWO.getText());
			verifyBooleanNotStatus(deliveryMethodWO.getText(), TestData.get(0).get("Delivery Method"));
			break;
		case "WO3":
			System.out.println("Delivery Method WO3:" + deliveryMethodWO.getText());
			verifyBooleanNotStatus(deliveryMethodWO.getText(), TestData.get(0).get("Delivery Method"));
			break;

		}

	}

	public void verifyCALDALWO() {
		String FCO_HEADER = TestData.get(0).get("FCONumber");
		search_GlobalsearchBox(FCO_HEADER);
		click("Click", driver.findElement(By.xpath("//td[text()='" + FCO_HEADER + "']/preceding-sibling::th/a")));
		waitForElement(FCO_Created_Text, "FCO_Created_Text");

		click("CAL_Cases", CAL_Cases.get(0));
		waitTill("5");
		click("Case Details", case_Details);
		click("CALDAL_WO", CALDAL_CaseWOs.get(0));
		waitTill("5");
		click("Case Details", case_Details);
		verifyMessageNotContains(orderStatus.getText(), "New");
		driver.switchTo().frame(service_Flow_SFM);
		waitForElement(initiateWorkOrder, "initiateWorkOrder");
		verifyElementEnabled(initiateWorkOrder);
		click("initiateWorkOrder", initiateWorkOrder);
		waitTill("5");
		verifyMessageNotContains(orderStatus.getText(), "In Process");
		driver.switchTo().frame(service_Flow_SFM);
		verifyElementEnabled(debrief_CompleteWO);
		click("debrief_CompleteWO", debrief_CompleteWO);
		waitTill("5");
		click("QRDebrief_Status_dropdown", QRDebrief_Status_dropdown);
		click("QRDebrief_Status1", QRDebrief_Status.get(0));
		click("QRDebrief_SubStatus_dropdown", QRDebrief_SubStatus_dropdown);
		if (QRDebrief_SubStatus.size() == 0) {
			logReport("PASS", "Q&R Sub Status DO NOT have any expected values");
		}
		// verifyElementNotPresent("QRDebrief_SubStatus1", QRDebrief_SubStatus.get(0));
		click("QRDebrief_Status_dropdown", QRDebrief_Status_dropdown);
		click("QRDebrief_Status1", QRDebrief_Status.get(1));
		click("QRDebrief_SubStatus_dropdown", QRDebrief_SubStatus_dropdown);
		System.out.println("QRDebrief_SubStatus size:" + QRDebrief_SubStatus.size());
		ArrayList<String> subStatusValue = new ArrayList<String>();
		ArrayList<String> expectedSubStatus = new ArrayList<String>();
		expectedSubStatus.add(
				"FSN/CIL and/or accompanying labeling/documentation delivered but no response from Customer following due diligence");
		expectedSubStatus.add(
				"FSN/CIL and/or accompanying labeling/documentation not delivered and no response from Customer following due diligence");
		for (int i = 0; i < QRDebrief_SubStatus.size(); i++) {

			subStatusValue.add(QRDebrief_SubStatus.get(i).getText());
		}
		if (expectedSubStatus.equals(subStatusValue)) {
			logReport("PASS", "Q&R Sub Status has expected values");
		} else {
			logReport("FAIL", "Q&R Sub Status DO NOT have expected values");
		}
		click("QRDebrief_SubStatus2", QRDebrief_SubStatus.get(0));
		click("Save", Save);
		waitTill("5");
		verifyElementNotPresent("ServiceType", serviceType);
		verifyElementNotPresent("SAP SWO Number", sapSwoNumber);

	}

	public void verify_FCO_WorkOrder_Line_Item() {

		waitTill("10");
		waitForElement(FCO_WorkOrder_Header, "FCO_WorkOrder_Header");
		scrollByViewOfElement(FCO_WorkOrder_Header);
		waitForElement(FCO_WorkOrder, "FCO_WorkOrder");
		waitTill("5");
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("FCO_WORKORDER_NUMBER", FCO_WorkOrder.getText());
		clickEvent(FCO_WorkOrder);
		waitForElement(detailsTab, "detailsTab");
		click("detailsTab", detailsTab);
		waitForElement(service_Flow_SFM, "service_Flow_SFM");
		driver.switchTo().frame(service_Flow_SFM);
		embedScreenShotInreport();
		waitTill("5");
		logReport("INFO", "initiate_Onsite_WorkOrder");
		logReport("INFO", "Manage_Due_Diligence");
		logReport("INFO", "Cancel_CAL_Work_Order");
		driver.switchTo().defaultContent();
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("FCO_WORKORDER_NUMBER_URL", driver.getCurrentUrl());
		waitTill("5");
	}

	public void add_Multiple_Due_Diligence() {
		waitForElement(service_Flow_SFM, "service_Flow_SFM");
		driver.switchTo().frame(service_Flow_SFM);
		clickEvent(Manage_Due_Diligence);
		embedScreenShotInreport();
		waitForElement(due_Dilligence_Dialog, "due_Dilligence_Dialog");
		click("addRow", addRow.get(0));
		click("extended_Edit", extended_Edit.get(1));
		waitForElement(attempts_BTN, "attempts_BTN");
		click("attempts_BTN", attempts_BTN);
		driver.findElement(By.xpath("//li[text()='2']")).click();
		enter("Date", Date_FSN, "12/04/2020");
		embedScreenShotInreport();
		click("methodBTN", methodBTN);
		driver.findElement(By.xpath("//li[text()='Courier']")).click();
		enter("Sender", Sender, "Tester");
		click("CustomerrespondedBTN", CustomerrespondedBTN);
		driver.findElement(By.xpath("//li[text()='Yes']")).click();
		enter("DateCustomerResponded", DateCustomerResponded, "12/04/2020");
		embedScreenShotInreport();
		click("statusBTN", StatusBTN);
		driver.findElement(By.xpath("//li[text()='Closed']")).click();
		click("update", updateButton);
		embedScreenShotInreport();
		click("save_Due_Dilligence", save_Due_Dilligence);
		waitTill("5");
		embedScreenShotInreport();
		Assert.assertTrue(due_dilligence_errrs.isDisplayed());
		click("delete_Due_Dilligence", delete_Due_Dilligence.get(0));
	}

	public void dispatch_WorkOrder_Technician() {
		waitTill("5");
		if (sapSwoNumber_value == null) {
			initiateSWO_SFM();
		}
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
		System.out.println("SERVICE MAX CONSOLE:" + driver.getCurrentUrl());
		System.out.println("SERVICE MAX CONSOLE:" + driver.getTitle());
		// waitForElement(service_Team_eExpand,"waitForElement");
		// clickEvent(service_Team_eExpand);
		String workOrder = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("WORK_ORDER_NUMBER");
		String xpath = "//*[text()='" + workOrder + "']";
		waitTill("5");

		// System.out.println("CONTRACT_HEADER_SAP_EXTERNAL_ID:"
		// +
		// AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CONTRACT_HEADER_SAP_EXTERNAL_ID"));
		// System.out.println(
		// "SAP_EXTERNAL_ID:" +
		// AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("SAP_EXTERNAL_ID"));
		// System.out.println("SAP_INTEGRATION_STATUS:"
		// +
		// AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("SAP_INTEGRATION_STATUS"));
		// System.out.println(
		// "CONTRACT_NUMBER:" +
		// AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CONTRACT_NUMBER"));
		// System.out.println(
		// "CONTRACT_HEADER:" +
		// AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CONTRACT_HEADER"));
		// System.out
		// .println("SAP_SALES_ORG:" +
		// AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("SAP_SALES_ORG"));
		// System.out.println("INSTALLED_PRODUCT_ID:"
		// +
		// AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("INSTALLED_PRODUCT_ID"));
		// System.out.println("PLANT:" +
		// AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("PLANT"));
		// System.out.println("CASE_NUMBER:" +
		// AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CASE_NUMBER"));
		// System.out.println(
		// "WORK_ORDER_NUMBER:" +
		// AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("WORK_ORDER_NUMBER"));

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
		// click("field_updates",field_updates);
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
	}

	public void initiateSWO_SFM() {
		waitForElement(work_Order_Header, "work_Order_Header");
		click("case_Details", detailsTab);
		waitForElement(service_Flow_SFM, "service_Flow_SFM");
		driver.switchTo().frame(service_Flow_SFM);

		click("Initiate SWO SFM", initiateSWO_SFM_button);
		waitForElement(work_Order_Header, "work_Order_Header");
		waitTill("15");
		driver.navigate().refresh();

		AutomationConstants.RUN_TIME_TEMP_DATA.put("SAP_SWO_Number", sapSwoNumber_value.getText());
		logReport("INFO", "SAP SWO Number: *****" + sapSwoNumber_value.getText() + "*****");

	}

	public void verifyWOUpdate() {
		// click("case_Details", detailsTab);
		waitForElement(iframe_WO_Distributor, "iframe_WO_Distributor");
		waitTill("10");
		driver.switchTo().frame(iframe_WO_Distributor);
		click("Update Work Order", update_WO_SFM_Distributor);
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("CONTACT_NAME", "AccountFN0 AccountLN0");
		enter("Technician", technician_Distributor,
				AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CONTACT_NAME"));
		click("Technician search Button", technician_Searchbtn_Distributor);
		waitLoadingSpinnerToDisappear();
		waitForElement(contact_ID_fullname, "contact_ID_fullname");
		click("contact_ID_fullname", contact_ID_fullname);
		waitTill("5");
		click("select_Contact_id_fullname", select_Contact_id_fullname);
		waitTill("5");
		click("Medical Software Version Updated?", med_software_version_drpdwn);
		driver.findElement(By.xpath("//li[text()='Yes']")).click();
		enter("Software Version Number", software_verion_distributor, "1.2");
		enter("philips_Legal_contacted", philips_Legal_contacted, "No");
		enter("Customer Reported Issue Externally", cust_reported_externally, "No");
		pressEnter();
		enter("Has action been taken?", has_action_taken, "No");
		pressEnter();

		enter("Hazard Category", hazardCategory_dropdown, "Biological and Chemical");
		pressEnter();
		enter("Hazard", hazard_dropdown, "Biocompatibility / Toxicity of chemical constituents, etc.");
		pressEnter();
		enter("Hazard situation", input_hazard, "Patient Exposure to (HAZARD) During Clinical Use");
		pressEnter();
		click("multiple_Hazard_checkbox", multiple_Hazard_checkbox);
		enter("multiple_Hazard_data_checkbox", multiple_Hazard_data_checkbox, "Operational");
		enter("Clinical Usage", clinicalUsage_dropdown, "In Clinical Use");
		pressEnter();
		click("quickSave", quickSave);

		System.out.println("Error Message: " + txt_error.getText());
		verifyMessageContains(txt_error.getText(), "Required field is blank: Potential Safety Issue related to?");
		embedScreenShotInreport();
		enter("Potential Safety Issue related to?", potential_safety_dropdwn, "Other");
		pressEnter();

		click("quickSave", quickSave);
		System.out.println("Error Message: " + txt_error.getText());
		verifyMessageContains(txt_error.getText(),
				"Please check that you have added an Activity with type ‘Problem Description by Engineer’. Please return to the work order and update.");
		embedScreenShotInreport();

		waitForElement(activities, "Activities");
		click("activities", activities);

		click("Add a row", addRow.get(0));
		// waitForElement(edit_labour.get(0), "laour");
		// click("labour", edit_labour.get(0));
		waitTill("5");
		WebElement ele1 = driver.findElement(By.xpath(
				"//*[@data-qtip='Activity Number']/ancestor::div[contains(@id,'headercontainer')]/following-sibling::div//table//td[2]"));
		click("type", ele1);
		waitTill("5");
		WebElement ele2 = driver.findElement(By.xpath("//input[contains(@id,'sfm-picklistcelleditor')]"));
		enter("Type", ele2, "Resolution");
		pressEnter();
		waitTill("5");
		WebElement ele3 = driver.findElement(By.xpath(
				"//*[@data-qtip='Activity Number']/ancestor::div[contains(@id,'headercontainer')]/following-sibling::div//table//td[3]"));
		click("des", ele3);
		waitTill("5");
		WebElement ele4 = driver.findElement(By.xpath("//textarea[contains(@id,'sfm-textarea')]"));
		enter("Desc", ele4, "Test");
		pressEnter();

		// enter("Type:", activity_type, "Resolution");
		// pressEnter();
		// waitTill("5");
		// waitForElement(txt_description, "Desctiption");
		// enter("Desctiption", txt_description, "Facility issue fixed by the hospital,
		// performed testing, system in spec and fully operational");
		// waitTill("10");
		// waitForElement(updateButton, "Update button");
		// driver.findElement(By.xpath("//span[text()='Update']")).click();
		// clickEvent(updateButton);
		// click("Update", updateButton);
		waitTill("5");
		click("quickSave", quickSave);

		click("Add a row", addRow.get(0));
		waitForElement(edit_labour.get(1), "laour");
		click("labour", edit_labour.get(1));
		enter("Type:", activity_type, "Problem Description by Engineer");
		pressEnter();
		waitTill("6");
		waitForElement(txt_description, "Desctiption");
		enter("Desctiption", txt_description, "Facility Power Issue");
		waitTill("15");
		// waitForElement(updateButton, "Update button");
		driver.findElement(By.xpath("//span[text()='Update']")).click();
		// click("Update", updateButton);
		// click("quickSave",quickSave);
		waitTill("5");
		System.out.println("Error Message: " + txt_error.getText());
		verifyMessageContains(txt_error.getText(),
				"Please check that you have added an Activity with type ‘Resolution’ or ‘Diagnostics Performed by Engineer’. Please return to the work order and update.");
		waitTill("5");
		embedScreenShotInreport();

		// click("save_Work_Order_Lines",save_Work_Order_Lines);

		waitForElement(parts_consumed, "parts_consumed");
		click("parts_consumed", parts_consumed);
		waitTill("6");
		click("Add a row", addRow.get(1));
		waitTill("5");
		waitForElement(edit_labour.get(2), "laour");
		click("labour", edit_labour.get(2));
		enter("Part", part_distributor, "1.5 MHU (Non-DFS) X-Ray Tube (GS1584)");
		click("Part search Button", part_Searchbtn_Distributor);
		waitLoadingSpinnerToDisappear();
		waitForElement(product_select, "product_select");
		click("product_select", product_select);
		waitTill("5");
		click("select_Contact_id_fullname", select_Contact_id_fullname);
		waitTill("5");
		enter("Requested Qty:", requested_Qty, "1");
		enter("Serial Number:", serial_num_distributor, "XYZABC");
		waitForElement(updateButton, "Update button");
		click("Update", updateButton);
		enter("Order Status:", order_status_dropdown, "Fixed");
		pressEnter();
		click("save_Work_Order_Lines", save_Work_Order_Lines);
		waitForElement(update_WO_SFM_Distributor, "update_WO_SFM_Distributor");

	}

	public void create_Workorder(String woType, String hours) {
		waitForElement(work_order_header, "waitForElement");
		if (verifyElementPresent("case_Details", case_Details)) {
			click("case_Details", case_Details);
		}
		waitTill("5");

		switch (woType) {
		case "Onsite":
			driver.switchTo().frame(manage_WorkOrder_Frame);
			click("create_Onsite_Workorder_SFM", create_Onsite_Workorder_SFM);
			waitForElement(safety_Questionair_Dialog, "safety_Questionair_Dialog");
			waitTill("5");
			enter("planned_labor_hour", planned_labor_hour, hours);
			break;
		case "Clinical Onsite":
			driver.switchTo().frame(manage_WorkOrder_Frame);
			click("create_Clinical_Onsite_Workorder_SFM", create_Clinical_Onsite_Workorder_SFM);
			waitForElement(safety_Questionair_Dialog, "safety_Questionair_Dialog");
			waitTill("5");
			enter("planned_labor_hour", planned_labor_hour, hours);
			break;
		case "Distributor WO":
			waitForElement(case_wizard_iframe, "case_wizard_iframe");
			driver.switchTo().frame(case_wizard_iframe);
			click("create_WO_Distributor", create_WO_Distributor);
			waitTill("5");
			break;
		}
		click("btn_save", btn_save);
		waitLoadingSpinnerToDisappear();
		waitForElement(work_order_header, "waitForElement");
		if (verifyElementPresent("case_Details", case_Details)) {
			click("case_Details", case_Details);
		}
		waitForElement(workorder_Number, "workorder_Number");
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("WORK_ORDER_NUMBER", workorder_Number.getText());
		waitTill("10");
	}

	public void requestPartInHybris(ArrayList<String> products) {

		waitForElement(iframe_WO_Distributor, "iframe_WO_Distributor");
		driver.switchTo().frame(iframe_WO_Distributor);
		click("direct_online_parts_order", direct_online_parts_order);
		waitTill("5");
		hybrisPage.orderPart(products);
	}

	public void verifyASOFromHybris() {
		driver.navigate().refresh();
		waitTill("60");
		driver.navigate().refresh();
		driver.navigate().refresh();
		driver.navigate().refresh();
		verifyMessageContains(AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("HYBRIS_ORDER_NUMBER"),
				aso_work_order_page.getText());
		Assert.assertTrue(aso_work_order_page.getText()
				.equalsIgnoreCase(AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("HYBRIS_ORDER_NUMBER")));
		waitForElement(iframe_WO_Distributor, "iframe_WO_Distributor");
		embedScreenShotInreport();

	}

	public void goTo_benchStatusTrackerPage_from_WorkOrderPage() {
		waitForElement(benchStatusTrackerNo_WOPage_Value, "BST-Value-Link");
		scrollByViewOfElement(benchStatusTrackerNo_WOPage_Value);
		click("BST-Value-Link", benchStatusTrackerNo_WOPage_Value);
	}

	public void initiateBenchRepair() {
		waitTill("6");
		click("Case Details", case_Details);

		driver.switchTo().frame("0660L000001TnEB");

		click("Initiate Bench Repair", initiateBenchRepair_Button);
		waitTill("5");
		try {
			waitForElement(workOrder_Value_Link, "Load Work Details Page");
			click("Work Order Link", workOrder_Value_Link);
			waitForElement(workOrderBenchStatus_Value, "Work Order Bench Status");
			waitTill("5");
			click("Save", save_Work_Order_Lines);
			waitTill("5");
		} catch (Exception e) {
			click("Save", save_Work_Order_Lines);
			waitTill("5");
		}
		try {
			waitForElement(workOrder_Value_Link, "Load Work Details Page");
			click("Work Order Link", workOrder_Value_Link);
			waitForElement(workOrderBenchStatus_Value, "Work Order Bench Status");
			waitTill("5");
			click("Save", Save);
			waitTill("5");
			driver.findElement(By.xpath("//*[text()='Work Order']/../following-sibling::td//a")).click();
			waitTill("5");
		} catch (Exception e) {
		}
	}

	public void initiateRemoteWorkorder_SMF() {
		waitTill("5");

		SwitchtoFramesByID("0660L000001TnEB");
		waitTill("5");
		click("Initiate Remote Service-SFM", initiateRemoteService_SFM_button);
		waitForElement(save_Work_Order_Lines, "Save Button");
		waitTill("5");
		click("Save Button", save_Work_Order_Lines);
		waitForElement(workDetails_pageHeader, "Workdetails Page Header");

		logReport("PASS", "Remote Workorder Initiated Successfully");

		AutomationConstants.RUN_TIME_TEMP_DATA.put("WorkDetails_No", workDetails_number.getText());
		logReport("INFO", "Work Detail: *****" + workDetails_number.getText() + "*****");

		try {
			waitTill("5");
			driver.findElement(By.xpath(".//a[text()='" + AutomationConstants.RUN_TIME_TEMP_DATA.get("WO1") + "']"))
			.click();
			waitTill("5");
		} catch (Exception e) {

		}
		while (sapSwoNumber_RemoteWO.getText() == null) {
			driver.navigate().refresh();
		}
		System.out.println("SWO Number - " + sapSwoNumber_RemoteWO.getText());

	}

	public void debrief_and_FollowUp_SFM(String action) {
		// Create FollowUp Activity
		waitTill("5");

		if (action.equalsIgnoreCase("Create Follow up Activity")) {
			waitForElement(work_Order_Header, "work_Order_Header");
			waitForElement(service_Flow_SFM, "service_Flow_SFM");
			waitTill("5");
			driver.switchTo().frame(service_Flow_SFM);

			waitForElement(debriefAndFollowUp_SFM_button, "Debrief and Follow Up SFM");
			click("Debrief and Follow Up SFM", debriefAndFollowUp_SFM_button);

			waitForElement(debrif_Save_button, "Save Button");
			waitTill("5");
			enter("Debrief System Status", debriefSystemStatus_dropdown,
					"The system meets the specification for the performed service and is returned to use");
			pressEnter();
			enter("T&V Status", tAndV_Status_dropdown, "Reported");
			pressEnter();
			click("debriefSystemStatusDateOrTime_button", debriefSystemStatusDateOrTime_button);

			waitTill("5");
			scrollByViewOfElement(hazardCategory_dropdown);
			waitTill("5");
			enter("Hazard Category", hazardCategory_dropdown, "Biological and Chemical");
			pressEnter();
			enter("Hazard", hazard_dropdown, "Biocompatibility / Toxicity of chemical constituents, etc.");
			pressEnter();
			waitTill("5");

			enter("Hazard", hazard_Situation, "No Hazardous Situation");
			pressEnter();
			// enter("Risk Profile", riskProfile_dropdown, "Coronary");
			// pressEnter();
			enter("Clinical Usage", clinicalUsage_dropdown, "In Use");
			pressEnter();
			waitTill("5");

			// click("Customer Function", driver.findElement(By.xpath("//*[contains(text(),
			// 'Customer Function')]")));
			waitForElement(workActivity, "workActivity");
			click("workActivity", workActivity);
			waitForElement(extended_Edit.get(1), "edit");
			clickEvent(extended_Edit.get(1));
			waitForElement(workActivity_Description_textarea, "workActivity_Description_textarea");
			enter("workActivity_Description_textarea", workActivity_Description_textarea, "Test");
			waitForElement(updateButton, "Update button");
			click("Update", updateButton);

			click("Follow Up Activity", followUpActivity_tab);
			waitTill("5");
			click("Add Row", addRow_FollowUpActivity);
			String TC = Hooks.testcaseNumber;
			switch(TC) {
			case "1497151":
				waitTill("6");
				enter("Service Type", followUpActivity_ServiceType.get(1), "Onsite Service");
				waitTill("5");
				driver.findElement(By.xpath(".//*[text()='Onsite Service']")).click();
				pressEnter();
				click("Service Type",
						driver.findElement(By.xpath("//*[contains(@class,'header') and text()='Service Type']")));
				click("Follow Up Activity",
						driver.findElement(By.xpath("//*[contains(text(), 'Follow Up Activity')]")));
				waitTill("5");
				//					driver.findElement(By.xpath("//div[text()='Onsite Service']/../following-sibling::td[1]")).click();
				//					enter("Recommended Follow Up Activity", followUpActivity_RecommendedFollowUpActivity_textarea,
				//							"RT Follow Up 1");
				pressEnter();
				waitTill("6");
				driver.findElement(By.xpath("//div[text()='Onsite Service']/../following-sibling::td[7]")).click();
				waitTill("6");
				driver.findElement(By.xpath("//input[@id='sfm-picklistcelleditor-1177-inputEl']")).click();
				waitTill("3");
				driver.findElement(By.xpath("//*[text()='1']")).click();
				waitTill("6");
				//driver.findElement(By.xpath("//div[text()='Onsite Service']/../following-sibling::td[10]")).click();
				pressEnter();
				click("Follow Up Priority Click", followUpActivity_followUPPriority);
				waitTill("6");
				enter("Follow Up Priority", followUpActivity_followupPriority_input.get(1), "1");
				waitTill("6");
				click("Follow Up priority", driver.findElement(By.xpath("//li[text()='1-Critical Need']")));
				waitTill("6");
				click("Service Type",
						driver.findElement(By.xpath("//*[contains(@class,'header') and text()='Service Type']")));
				pressEnter();
				waitTill("3");
				driver.findElements(By.xpath(".//img[@data-qtip='Extended Edit']")).get(driver.findElements(By.xpath(".//img[@data-qtip='Extended Edit']")).size()).click();
				waitTill("3");
				for(WebElement ele:driver.findElements(By.xpath(".//label[contains(text(),'Answer')]/../following-sibling::td/table//input"))) {
					ele.sendKeys("No");
					waitTill("3");
				}
				break;
			default:
				try {
					waitTill("6");
					enter("Service Type", followUpActivity_ServiceType.get(1), "Bench Repair");
					waitTill("30");
					pressEnter();
					pressEnter();
					click("Service Type",
							driver.findElement(By.xpath("//*[contains(@class,'header') and text()='Service Type']")));
					click("Follow Up Activity",
							driver.findElement(By.xpath("//*[contains(text(), 'Follow Up Activity')]")));
					waitTill("6");
					// pressTab();
					click("Recommended Follow Up Activity Click", followUpActivity_RecommendedFollowUpActivity);
					enter("Recommended Follow Up Activity", followUpActivity_RecommendedFollowUpActivity_textarea,
							"RT Follow Up 1");
					pressEnter();
					click("Follow Up Priority Click", followUpActivity_followUPPriority);
					waitTill("6");
					enter("Follow Up Priority", followUpActivity_followupPriority_input.get(1), "1");
					waitTill("6");
					click("Follow Up priority", driver.findElement(By.xpath("//li[text()='1-Critical Need']")));
					waitTill("6");
					click("Service Type",
							driver.findElement(By.xpath("//*[contains(@class,'header') and text()='Service Type']")));
					pressEnter();

					driver.findElements(By
							.xpath("//*[@data-qtip='1-Critical Need']/following-sibling::*//div[contains(@class,'unchecked')]"))
					.get(0).click();
					waitTill("5");
					waitForElement(RegulatoryQues, "Regulatory");
					click("Regulatory", RegulatoryQues);
					if (verifyElementPresent("txt_ans1", txt_ans1)) {
						waitForElement(extended_Edit.get(3), "edit");
						clickEvent(extended_Edit.get(3));
						waitForElement(txt_ans1, "Answer 1");
						enter("Answer", txt_ans1, "Non");
						waitForElement(txt_ans2, "Answer 2");
						enter("Answer", txt_ans2, "Non");
						waitForElement(updateButton, "Update button");
						click("Update", updateButton);
					}
				} catch (Exception e) {
				}
				break;
			}

			waitTill("6");


			click("Save", debrif_Save_button);
			waitForElement(work_Order_Header, "Work Order Header Image");
			waitTill("5");
		}
		logReport("PASS", "Debrief done Successfully");
	}

	public void goTo_FollowUpRequired_ActivityPage() {
		waitTill("5");
		click("Details", case_Details);
		waitForElement(work_Order_Header, "Work Order Header Image");
		click("Activities", activities);
		waitForElement(followUpRequired_ActivityNumber, "Activities Table Load");
		click("Follow Up Required", followUpRequired_ActivityNumber);
		logReport("INFO", "Nevigated to Activity Page");
	}

	public void set_WorkOrderNumber3() {
		waitTill("5");
		click("Case_Value", Case_Value);
		waitTill("5");
		click("detailsTab", detailsTab);
		scrollByViewOfElement(work_order);
		waitTill("5");
		waitForElement(work_order_list.get(0), "work_order_list");
		System.out.println("WORKKKKK:" + work_order_list.get(0));
		AutomationConstants.RUN_TIME_TEMP_DATA.put("WO3", work_order_list.get(0).getText());
		click("Work order 3", work_order_list.get(0));
		waitTill("5");
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
	}

	public void set_WorkOrderNumber2() {
		String workOrderNo2 = workOrderNumber_ActionPage.getText();
		AutomationConstants.RUN_TIME_TEMP_DATA.put("WO2", workOrderNo2);
		logReport("INFO", "Work Order2 No: *****" + workOrderNo2 + " *****");
	}

	public void verify_WorkOrderBenchStatus(String status) {
		click("Details", case_Details);
		waitForElement(workOrderBenchStatus_Value, "Work Order Bench Status");
		// scrollByViewOfElement(workOrderBenchStatus_Value);

		try {
			verifyMessageContains(workOrderBenchStatus_Value.getText(), status);
			logReport("PASS",
					"Work Order Bench Status Validated Successfully: " + workOrderBenchStatus_Value.getText());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logReport("FAIL", e.getMessage());
		}
	}

	public void partsOrdering_SFM_orderFCOKit(String part) {
		driver.navigate().refresh();
		waitTill("30");
		waitForElement(work_Order_Header, "work_Order_Header");
		waitForElement(service_Flow_SFM, "service_Flow_SFM");
		driver.switchTo().frame(service_Flow_SFM);
		click("Parts Ordering SFM", PartsOrdering);
		waitForElement(partsOrdering_SFM_header, "Parts Ordering Page");
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("FCO_Part1", part);
		waitTill("6");
		enter("Product Code", productCode_searchBox, part);
		click("Product Search", productCode_SearchButton);
		waitTill("30");
		waitforElementEnable(productCode_SearchButton, "");
		click("Add Parts", addParts_partsOrderingPage_button);
		waitTill("30");
		waitforElementEnable(productCode_SearchButton, "");
		click("Get Entitlement", GetEntitlement);
		waitTill("30");
		waitforElementEnable(GATPSimulation, "GATP Simulation");
		click("GATP Simulation", GATPSimulation);
		waitforElementEnable(TransferToSAP, "Transfer To SAP");
		waitTill("30");
		click("Transfer To Sap", TransferToSAP);
		waitTill("30");
		waitForElement(ASO_Created_successMessage, "ASO Success Message");
		click("Back To WorkOrder", backToWorkOrderPage_link);
		waitForElement(work_Order_Header, "Work Order Page Header");
	}

	public void capture_ASO_from_PartsOrderLine() {
		// TODO Auto-generated method stub
		waitForElement(work_Order_Header, "work_Order_Header");
		waitTill("6");
		driver.navigate().refresh();
		waitTill("6");
		if (asoNumber_partsOrderLine_value.isDisplayed()) {
			AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("ASO_ITEM1",
					asoNumber_partsOrderLine_value.getText());
			AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("ASO_ITEM2",
					asoNumber_partsOrderLine_item.getText());

		} else {
			waitTill("6");
			driver.navigate().refresh();
			waitTill("6");
			AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("ASO_ITEM1",
					asoNumber_partsOrderLine_value.getText());
			AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("ASO_ITEM2",
					asoNumber_partsOrderLine_item.getText());

		}
	}

	public void approve_IP_Change_Request() {
		waitTill("5");
		click("Case_Value", Case_Value);
		waitTill("5");
		click("detailsTab", detailsTab);
		scrollByViewOfElement(customLink);
		waitForElement(ip_Change_Req, "ip_Change_Req");
		String parent = driver.getWindowHandle();
		click("ip_Change_Req", ip_Change_Req);
		waitTill("5");
		for (String win : driver.getWindowHandles()) {
			if (!win.equalsIgnoreCase(parent)) {
				driver.switchTo().window(win);
			}
		}
		waitForElement(IP_CHANGE_NUM, "IP_CHANGE_NUM");
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("IP_CHANGE_NUM", IP_CHANGE_NUM.getText());
		click("IP_CHANGE_NUM", IP_CHANGE_NUM);
		waitTill("5");
		waitForElement(approva_History, "approva_History");
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("New_Location", new_Loc.getText());
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("New_Location_NR", new_Loc_nr.getText());
		scrollByViewOfElement(approva_History);
		click("approveBTN", approveBTN);
		waitForElement(approve, "approve");
		waitTill("5");
		click("approve", approve);
		waitTill("5");
		driver.close();
		waitTill("5");
		driver.switchTo().window(parent);
		driver.navigate().refresh();
		waitForElement(install_Prd, "install_Prd");
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("Installed_product", install_Prd.getText());
		click("install_Prd", install_Prd);
		waitTill("5");

		hover(ip_Location);
		doubleClick(ip_Location);
		enter("Ip_Loc_Change", Ip_Loc_Change,
				AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("New_Location"));
		click("Ip_Loc_Change_search", Ip_Loc_Change_search);
		waitTill("5");
		waitForElement(
				driver.findElement(By.xpath("//a[text()='"
						+ AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("New_Location") + "']")),
				"approve");
		click("Ip_Loc_Change_search", driver.findElement(By.xpath(
				"//a[text()='" + AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("New_Location") + "']")));
		waitTill("5");
		click("save_IP_Change_Loc", save_IP_Change_Loc);
	}

	public void record_Tools_SFM(String action) {


		if (action.equalsIgnoreCase("Check Tools not required checkbox")) {
			waitForElement(work_Order_Header, "work_Order_Header");
			waitForElement(service_Flow_SFM, "service_Flow_SFM");
			driver.switchTo().frame(service_Flow_SFM);

			waitForElement(recordTools_SFM_button, "Record Tools SFM");
			click("Record Tools SFM", recordTools_SFM_button);

			waitForElement(toolsNotRequired_CheckBox, "Tools Not Required");
			waitTill("5");
			click("Tools Not Required", toolsNotRequired_CheckBox);
			waitTill("5");
			click("Save", recordTools_Save_button);
		}
	}

	public void completeWorkOrder_SFM() {

		waitForElement(work_Order_Header, "work_Order_Header");
		waitForElement(service_Flow_SFM, "service_Flow_SFM");
		driver.switchTo().frame(service_Flow_SFM);
		waitForElement(CompleteWorkOrder_SFMbutton, "Complete Work Order");

		click("Complete Work Order", CompleteWorkOrder_SFMbutton);

		waitTill("5");
		click("Save Complete Work Order", Save);
		waitForElement(work_Order_Header, "work_Order_Header");
		logReport("PASS", "Work Order Complted");
	}

	public void update_Bench_Repaire_status() {

		waitTill("5");
		click("Case_Value", Case_Value);
		waitTill("5");
		click("detailsTab", detailsTab);
		waitTill("5");
		waitForElement(work_Order_Header, "work_Order_Header");
		waitForElement(case_Flow_SFM, "case_Flow_SFM");
		driver.switchTo().frame(case_Flow_SFM);
		waitForElement(update_Bench_Status, "update_Bench_Status");

		click("update_Bench_Status", update_Bench_Status);
		waitTill("4");
		waitForElement(update_Bench_Status_dropdwn, "update_Bench_Status_dropdwn");
		hover(update_Bench_Status_dropdwn);
		try {
			doubleClick(update_Bench_Status_dropdwn);
			waitTill("5");
			enter("update_Bench_Status_dropdwn", update_Bench_Status_dropdwn, "Repair Complete and Equipment Shipped");

		} catch (Exception e) {
			doubleClick(update_Bench_Status_dropdwn);
			waitTill("5");
			enter("update_Bench_Status_dropdwn", update_Bench_Status_dropdwn, "Repair Complete and Equipment Shipped");

		}
		waitTill("5");
		click("Save", Save);
		waitTill("5");
	}

	public void initiateSWO_SFM_FCO() {
		waitTill("30");
		String url = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("FCO_WORKORDER_NUMBER_URL",
				driver.getCurrentUrl());
		waitTill("10");
		driver.get(url);
		waitTill("15");
		try {
			driver.findElement(By.xpath("//*[text()='Details']")).click();
		} catch (Exception e) {
		}
		waitTill("10");
		waitForElement(service_Flow_SFM, "service_Flow_SFM");
		driver.switchTo().frame(service_Flow_SFM);
		click("Initiate SWO SFM", initiateSWO_SFM_button);
		waitForElement(work_Order_Header, "work_Order_Header");
		waitTill("15");
		driver.navigate().refresh();
		waitTill("6");
		embedScreenShotInreport();
	}

	public void Verify_FCO_Kit_Header_work_detail() {

		String workOrder = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("FCO_WORKORDER_NUMBER");
		search_GlobalsearchBox(workOrder);
		driver.findElement(By.xpath(
				"//a[text()='Work Order Number']/../../following-sibling::*//a[contains(text(),'" + workOrder + "')]"))
		.click();
		waitTill("5");
		click("detailsTab", detailsTab);
		scrollByViewOfElement(driver.findElement(By.xpath("//*[@title='Work Detail']")));
		waitTill("5");
		embedScreenShotInreport();
		driver.findElement(By.xpath("//*[@title='Work Detail']/ancestor::form//a[contains(text(),'WL-')]")).click();
		waitTill("5");
		logReport("INFO", "SAP_ACCOUNTING_INDICATOR : " + SAP_ACCOUNTING_INDICATOR.getText());
		logReport("INFO", "INTEGRATION_STATUS : " + INTEGRATION_STATUS.getText());
		embedScreenShotInreport();
	}

	public void partsOrdering_SFM_orderFCOKit() {
		driver.navigate().refresh();
		waitTill("15");
		waitForElement(work_Order_Header, "work_Order_Header");
		waitForElement(service_Flow_SFM, "service_Flow_SFM");
		driver.switchTo().frame(service_Flow_SFM);
		click("Parts Ordering SFM", PartsOrdering);

		waitForElement(partsOrdering_SFM_header, "Parts Ordering Page");
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("FCO_Part1", "459801229061");
		waitTill("15");
		enter("Product Code", productCode_searchBox, "459801229061");
		click("Product Search", productCode_SearchButton);
		waitforElementEnable(productCode_SearchButton, "");
		waitTill("15");
		click("Add Parts", addParts_partsOrderingPage_button);
		embedScreenShotInreport();
		waitforElementEnable(productCode_SearchButton, "");
		waitTill("15");
		click("Get Entitlement", GetEntitlement);
		waitTill("15");
		waitforElementEnable(GATPSimulation, "GATP Simulation");
		click("GATP Simulation", GATPSimulation);
		waitforElementEnable(TransferToSAP, "Transfer To SAP");
		waitTill("15");
		click("Transfer To Sap", TransferToSAP);
		waitTill("100");
		embedScreenShotInreport();
		waitForElement(ASO_Created_successMessage, "ASO Success Message");
		click("Back To WorkOrder", backToWorkOrderPage_link);
		waitForElement(work_Order_Header, "Work Order Page Header");
	}

	public void CreateNonWOEvent(DataTable EventDetails) {
		List<List<String>> data = EventDetails.raw();
		try {
			for (int row = 0; row < data.size(); row++) {
				String oldTab = driver.getWindowHandle();
				String userName = GetUserDetails(data.get(row).get(0));
				click("Create Non WO Events", CreateNonWOEvents);
				ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
				newTab.remove(oldTab);
				driver.switchTo().window(newTab.get(0));
				WebListbyID("00NE0000005mxTS", data.get(row).get(1));
				WebListbyXpath("//*[text()='Country']/../../following-sibling::td//select", "Other");
				enter("Assigned To", AssignedToSearch, userName);
				String mainWindow = driver.getWindowHandle();
				click("Assigned To Lookup", AssignedToLookup);
				Set t = driver.getWindowHandles();
				Iterator j = t.iterator();
				try {
					while (j.hasNext()) {
						String popupHandler = j.next().toString();
						if (!popupHandler.contains(mainWindow) && !popupHandler.contains(oldTab)) {
							driver.switchTo().window(popupHandler);
							SwitchtoFramesByID("searchFrame");
							click("All Fields Radio Button", AllFields);
							click("Go", Go);
							driver.switchTo().defaultContent();
							waitTill("5");
							SwitchtoFramesByID("resultsFrame");
							click("Full Name", UserName);
							driver.switchTo().window(mainWindow);
							driver.switchTo().defaultContent();
						}
					}
				} catch (Exception e) {
				}
				waitTill("5");
				WebListbyID("00NE0000005mxTR", data.get(row).get(2));
				if (data.get(row).get(3).equals("Yes")) {
					click("Recurring Series of Events", Recurrence);
					click("Calculate Latest Date", CalcLatestDate);
					waitTill("5");
				}
				click("Save", Save);
				waitTill("5");
				driver.close();
				driver.switchTo().window(oldTab);
				waitTill("5");
			}
		} catch (Exception e) {

		}
	}

	public void DC_ViewNonWOEvents(String[] FieldName, String[] Operator, String[] Value) {
		click("View Non WO Events", ViewNonWOEvents);
		String mainWindow = driver.getWindowHandle();
		waitTill("15");
		Set s = driver.getWindowHandles();
		Iterator i = s.iterator();
		try {
			while (i.hasNext()) {
				String popupHandle = i.next().toString();
				if (!popupHandle.contains(mainWindow)) {
					driver.switchTo().window(popupHandle);
					waitTill("5");
					CreateView(FieldName, Operator, Value);
					waitTill("5");
					// Take screenshot of screen
					Utility.getPageScreenShot(driver, "NWOEvents");
					driver.close();
					driver.switchTo().window(mainWindow);
				}
			}
		} catch (Exception e) {
		}
	}

	public void captureFollowUpWO() {

		waitTill("6");
		click("Details Tab", case_Details);
		click("Follow up WO Activity ", activity_followupWO);
		System.out.println("Follow up WO is : " + activity_followupWOText.getText());
		AutomationConstants.RUN_TIME_TEMP_DATA.put("WO2", activity_followupWOText.getText());

	}

	public void confirm_Delivery() {
		waitTill("5");
		try {
			driver.switchTo().frame(manage_WorkOrder_Frame);
		} catch (Exception e) {
			waitTill("5");
			driver.switchTo().frame(service_order_frame);
		}

		waitTill("5");
		waitForElementToEnable(confirmDelivery);
		try {
			click("confirmDelivery", confirmDelivery);
			waitTill("6");
			click("debrif_Save_button", debrif_Save_button);
			waitTill("6");
		} catch (Exception e) {
		}
	}

	public void VerifyWDLine(String[] FieldName, String[] Value) {
		String ValueinField = null;
		waitTill("5");
		click("Work Detail Line", WorkDetailLabor1);
		waitTill("5");
		for (String f : FieldName) {
			if (f.equals("Is Billable"))
				ValueinField = driver
				.findElement(By.xpath(
						"(//*[text() = '" + FieldName + "']/ancestor::td/following-sibling::td)[1]/div/img"))
				.getAttribute("title");
			else if (f.equals("Associate Coverage ID")) {
				String s = driver
						.findElement(By
								.xpath("(//*[text() = '" + FieldName + "']/ancestor::td/following-sibling::td)[1]/div"))
						.getText();
				ValueinField = s.split("--")[0];
			} else
				ValueinField = driver
				.findElement(By
						.xpath("(//*[text() = '" + FieldName + "']/ancestor::td/following-sibling::td)[1]/div"))
				.getText();
		}

		if (ValueinField.equals(Value)) {
			System.out.println("The Work Detail Line has been created as expected.");
			logReport("Pass", "The Work Detail Line has been created as expected.");
		} else {
			System.out.println("The Work Detail Line has NOT been created as expected.");
			logReport("Fail", "The Work Detail Line has NOT been created as expected.");
		}
	}

	public void VerifyWOStatus(String status) {
		waitTill("5");
		String OrderStatus = driver
				.findElement(By.xpath("//*[text() = 'Order Status']/ancestor::td/following-sibling::td[1]/div"))
				.getText();
		if (OrderStatus.equals("Finished")) {
			logReport("Pass", "Status successfully verified");
		}
	}

	public void ChangeOrderStatustoInProcess() {
		waitTill("5");
		SwitchtoFramesByID("066E0000001hAQh");
		click("Change Order Status to In Process", ChangeOrderStatusSFM);
		waitTill("6");
		driver.switchTo().defaultContent();
	}

	public void VerifyPartsOrderLine(String PartType) {
		waitTill("5");
		click("Parts Order Line",
				driver.findElement(
						By.xpath("//*[text() = '" + AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get(PartType)
						+ "']/preceding-sibling::th/a[contains(text(), 'LN-')]")));
		waitTill("5");
	}

	public void generate_report(String reportType) {

		waitAndswitchToRequiredFrame(service_Flow_SFM);
		if (reportType.equals("Signed")) {
			waitForElement(singned_customer_report, "singned_customer_report");
			click("singned_customer_report", singned_customer_report);
			waitDottedSpinnerToDisappear();
			waitTill("5");
			if (verifyElementPresent("Finalize Button", finalize_singned_customer_report)) {
				System.out.println("element present");
			}
			click("Finalize", finalize_singned_customer_report);
		}

	}

	public void verify_SapSwoNumber_population() {
		// TODO Auto-generated method stub
		waitForElement(sapSwoNumber_value, "SAP SWO Number");
		highlightElement(driver, sapSwoNumber_value, "1");
		if (sapSwoNumber_value.getText().equals(" ")) {
			logReport("FAIL", "SAP SWO Number is not Populated");
			Assert.fail("SAP SWO Nummber is not Populated");
		} else {
			logReport("PASS", "SAP SWO Number is Populated: *****" + sapSwoNumber_value.getText() + "*****");
			AutomationConstants.RUN_TIME_TEMP_DATA.put("SAP_SWO_Number", sapSwoNumber_value.getText());
		}
	}

	public void accessWorkOrderfromCase() {
		waitForElement(FCO_WorkOrder_Header, "FCO_WorkOrder_Header");
		scrollByViewOfElement(FCO_WorkOrder_Header);
		waitForElement(FCO_WorkOrder, "FCO_WorkOrder");
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("FCO_WORKORDER_NUMBER", FCO_WorkOrder.getText());
		clickEvent(FCO_WorkOrder);
		waitForElement(detailsTab, "detailsTab");
		click("detailsTab", detailsTab);
	}

	public void requestPartInFCO(ArrayList<String> products, ArrayList<String> product_quantity) {

		String parent = driver.getWindowHandle();

		Assert.assertTrue(verifyElementPresent("Create Distributor Parts WO", create_dist_parts_WO));
		scrollByViewOfElement(create_dist_parts_WO);
		embedScreenShotInreport();
		for (int i = 0; i < products.size(); i++) {
			click("Create Parts", create_parts);
			waitTill("3");
			for (String win : driver.getWindowHandles()) {
				if (!win.equalsIgnoreCase(parent)) {
					driver.switchTo().window(win);
				}
			}
			waitForElement(product_input, "Product");
			enter("Product", product_input, products.get(i));
			enter("Product Quantity", product_quantity_input, product_quantity.get(i));
			embedScreenShotInreport();
			click("Save Button", saveTopButton);
			driver.close();
			waitForElement(create_parts, "create_parts");

			driver.switchTo().window(parent);
		}	

		waitTill("10");
		driver.navigate().refresh();
		waitTill("5");

		scrollByViewOfElement(create_dist_parts_WO);
		embedScreenShotInreport();

	}

	public void editRequestedPartInFCO(ArrayList<String> products_edited, ArrayList<String> product_quantity_edited) {


		for (int i = 0; i < products_edited.size(); i++) {
			click("Edit Part", edit_created_parts.get(i));
			waitTill("3");
			waitForElement(product_input, "Product");
			enter("Product Quantity", product_quantity_input, product_quantity_edited.get(i));
			embedScreenShotInreport();
			click("Save Button", saveTopButton);
			waitForElement(create_parts, "create_parts");
		}
		scrollByViewOfElement(create_dist_parts_WO);
		embedScreenShotInreport();

	}

	public void createPartsWO() {

		waitTill("3");
		click("Create Distributor Parts Work Order", create_dist_parts_WO);
		if (isAlertPresent()) {
			driver.switchTo().alert().accept();
		}
		waitTill("20");
		driver.navigate().refresh();
		if(DAL_WOs.size()==(numberOfDALWO+numberOfDALWO)) {
			logReport("PASS", "Parts WO is created");
		}

	}
	public void capture_WO(String recordType, String typeOfWO) {
		waitTill("3");

		switch(recordType) {

		case "DAL":
			click("DAL_Cases", DAL_Cases.get(0));
			waitTill("5");
			driver.navigate().refresh();
			driver.navigate().refresh();
			if(verifyElementPresent("case_Details", case_Details)) {
				click("Case Details", case_Details);
			}
			scrollByViewOfElement(CALDAL_CaseWOs.get(0));
			embedScreenShotInreport();
			if(CALDAL_CaseWOs.size()>=1) {
				for(int i=0;i<CALDAL_CaseWOs.size();i++) {
					AutomationConstants.RUN_TIME_TEMP_DATA.put("WO"+(i+1), CALDAL_CaseWOs.get(i).getText());
				}

			}
			//AutomationConstants.RUN_TIME_TEMP_DATA.put("WO1", CALDAL_CaseWOs.get(0).getText());
			System.out.println("WO2:"+AutomationConstants.RUN_TIME_TEMP_DATA.get("WO2"));

			break;

		}

	}

	public void verify_parts_WO() {
		click("Parts WO", CALDAL_CaseWOs.get(1));

		if(verifyElementPresent("Details Tab", case_Details)) {
			click("Case Details", case_Details);
		}
		waitTill("7");
		embedScreenShotInreport();
		//Assert.assertTrue(verifyElementNotPresent("direct_online_parts_order", direct_online_parts_order));

	}

	public void completeQRWO() {
		if(verifyElementPresent("case_Details", case_Details)){
			click("Case Details", case_Details);
		}

		driver.switchTo().frame(service_Flow_SFM);
		waitForElement(initiateWorkOrder, "initiateWorkOrder");
		embedScreenShotInreport();
		verifyElementEnabled(initiateWorkOrder);
		click("initiateWorkOrder", initiateWorkOrder);
		waitTill("5");
		driver.navigate().refresh();
		waitTill("5");

		driver.switchTo().frame(service_Flow_SFM);
		verifyElementEnabled(debrief_CompleteWO);
		click("debrief_CompleteWO", debrief_CompleteWO);
		waitTill("5");
		click("QRDebrief_Status_dropdown", QRDebrief_Status_dropdown);
		click("QRDebrief_Status1", QRDebrief_Status.get(0));
		click("QRDebrief_SubStatus_dropdown", QRDebrief_SubStatus_dropdown);
		if (QRDebrief_SubStatus.size() == 0) {
			logReport("PASS", "Q&R Sub Status DO NOT have any expected values");
		}
		embedScreenShotInreport();
		click("Save", save_Work_Order_Lines);
		waitTill("5");

	}

	public void performSyncIP() {
		scrollByViewOfElement(fcoParts_value);
		embedScreenShotInreport();
		//Assert.assertTrue(fcoParts_value.getText()==" ");

		driver.switchTo().frame(service_Flow_SFM);
		verifyElementEnabled(syncIP_PartsCount_SFM);
		scrollByViewOfElement(syncIP_PartsCount_SFM);
		embedScreenShotInreport();
		click("syncIP_PartsCount_SFM", syncIP_PartsCount_SFM);
		waitTill("5");


	}

	public void completePartsWO() {
		driver.switchTo().frame(service_Flow_SFM);
		verifyElementEnabled(complete_Parts_WO_SFM);
		scrollByViewOfElement(complete_Parts_WO_SFM);
		embedScreenShotInreport();
		click("complete_Parts_WO_SFM", complete_Parts_WO_SFM);
		waitTill("5");

		embedScreenShotInreport();
		click("Save", save_Work_Order_Lines);
		waitTill("5");

	}

	@FindBy(xpath = "//input[@value='Initiate Travel']")
	private WebElement initiate_Travel_SFM;

	@FindBy(xpath = "//input[@value='Receive Parts']")
	private WebElement receive_Parts_SFM;

	public void initiate_Travel_SFM() {
		waitTill("6");
		waitForElement(work_Order_Header, "work_Order_Header");
		click("case_Details", detailsTab);
		driver.navigate().refresh();
		waitTill("5");
		waitForElement(service_Flow_SFM, "service_Flow_SFM");
		embedScreenShotInreport();
		driver.switchTo().frame(service_Flow_SFM);
		embedScreenShotInreport();
		waitForElement(initiate_Travel_SFM, "initiate_Travel_SFM");
		click("initiate_Travel_SFM", initiate_Travel_SFM);
		waitTill("5");
		waitForElement(work_Order, "work_Order");
		click("work_Order", work_Order);
	}

	public void receive_Parts_SFM() {
		waitTill("6");
		waitForElement(work_Order_Header, "work_Order_Header");
		waitTill("5");
		waitForElement(service_Flow_SFM, "service_Flow_SFM");
		embedScreenShotInreport();
		driver.switchTo().frame(service_Flow_SFM);
		embedScreenShotInreport();
		waitForElement(receive_Parts_SFM, "receive_Parts_SFM");
		click("receive_Parts_SFM", receive_Parts_SFM);
		waitTill("5");
		waitForElement(work_Order, "work_Order");
		click("work_Order", work_Order);
	}

	public void transferAndVerifyInRSW() {
		waitForElement(service_order_frame, "service_order_frame");
		String parent = driver.getWindowHandle();
		driver.switchTo().frame(service_order_frame);
		click("Remote Service Workspot", remote_service_workspot);
		waitTill("5");
		Set<String> windows = driver.getWindowHandles();
		for (String win : windows) {
			if (!win.equals(parent)) {
				driver.switchTo().window(win);
				break;
			}
		}
		embedScreenShotInreport();
		rswPage.verifyFieldsfromSmax();

	}

	public void verifyPSFields() {
		waitForElement(iframe_WO_Distributor, "iframe_WO_Distributor");
		waitTill("10");
		driver.switchTo().frame(iframe_WO_Distributor);
		click("Update Work Order", update_WO_SFM_Distributor);

		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("CONTACT_NAME", "Adam Olas");
		enter("Technician", technician_Distributor,
				AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CONTACT_NAME"));
		verifyElementNotPresent("potential_safety_dropdwn", potential_safety_dropdwn);
		embedScreenShotInreport();

		click("Technician search Button", technician_Searchbtn_Distributor);
		waitLoadingSpinnerToDisappear();
		waitForElement(contact_ID_fullname, "contact_ID_fullname");
		click("contact_ID_fullname", contact_ID_fullname);
		waitTill("5");
		click("select_Contact_id_fullname", select_Contact_id_fullname);
		waitTill("5");
		click("Medical Software Version Updated?", med_software_version_drpdwn);
		driver.findElement(By.xpath("//li[text()='Yes']")).click();
		enter("Software Version Number", software_verion_distributor, "1.2");

		enter("Hazard Category", hazardCategory_dropdown, "Biological and Chemical");
		pressEnter();
		enter("Hazard", hazard_dropdown, "Biocompatibility / Toxicity of chemical constituents, etc.");
		pressEnter();
		enter("Hazard situation", input_hazard, "Patient Exposure to (HAZARD) During Clinical Use");
		pressEnter();
		click("multiple_Hazard_checkbox", multiple_Hazard_checkbox);
		enter("multiple_Hazard_data_checkbox", multiple_Hazard_data_checkbox, "Operational");
		enter("Clinical Usage", clinicalUsage_dropdown, "In Use");
		pressEnter();
		enter("Risk Profile", risk_profile, "Single Risk");
		pressEnter();

		embedScreenShotInreport();

		waitForElement(activities, "Activities");
		click("activities", activities);

		click("Add a row", addRow.get(0));
		waitTill("5");
		WebElement ele1 = driver.findElement(By.xpath(
				"//*[@data-qtip='Activity Number']/ancestor::div[contains(@id,'headercontainer')]/following-sibling::div//table//td[2]"));
		click("type", ele1);
		waitTill("5");
		WebElement ele2 = driver.findElement(By.xpath("//input[contains(@id,'sfm-picklistcelleditor')]"));
		enter("Type", ele2, "Resolution");
		pressEnter();
		waitTill("5");
		WebElement ele3 = driver.findElement(By.xpath(
				"//*[@data-qtip='Activity Number']/ancestor::div[contains(@id,'headercontainer')]/following-sibling::div//table//td[3]"));
		click("des", ele3);
		waitTill("5");
		WebElement ele4 = driver.findElement(By.xpath("//textarea[contains(@id,'sfm-textarea')]"));
		enter("Desc", ele4, "Test");
		pressEnter();


		click("Add a row", addRow.get(0));
		waitForElement(edit_labour.get(1), "laour");
		click("labour", edit_labour.get(1));
		enter("Type:", activity_type, "Problem Description by Engineer");
		pressEnter();
		waitTill("6");
		waitForElement(txt_description, "Desctiption");
		enter("Desctiption", txt_description, "Facility Power Issue");
		waitTill("15");
		driver.findElement(By.xpath("//span[text()='Update']")).click();
		waitTill("5");
		embedScreenShotInreport();

		enter("Order Status:", order_status_dropdown, "Fixed");
		pressEnter();
		click("save_Work_Order_Lines", save_Work_Order_Lines);
		waitForElement(update_WO_SFM_Distributor, "update_WO_SFM_Distributor");
		waitTill("5");
		embedScreenShotInreport();

	}
}