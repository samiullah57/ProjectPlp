package com.philips.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.philips.generic.Utility;

public class AssetPage extends BasePage {

	@FindBy(xpath="//input[@title='New Case']")
	private WebElement btn_case;
	
	@FindBy(xpath="//label[text()='Record Type of new record']/../..//select")
	private WebElement select_caserecordType;

	@FindBy(xpath="//input[@title='Continue']")
	private WebElement btn_continue;

	@FindBy(xpath="//a[contains(text(),'Name')]/../../following-sibling::tr//a")
	private WebElement input_contact;

	@FindBy(xpath="//label[text()='Subject']/../../following-sibling::td[1]//input")
	private WebElement input_subject;

	@FindBy(xpath="//label[text()='Description']/../../following-sibling::td[1]//textarea")
	private WebElement input_description;

	@FindBy(xpath="//label[text()='Priority']/../../following-sibling::td[1]//select")
	private WebElement select_priority;

	@FindBy(xpath="//label[text()='Status']/../../following-sibling::td[1]//select")
	private WebElement select_status;
   
	@FindBy(xpath="//label[text()='Event Type']/../following-sibling::td//select")
	private WebElement select_eventtype;

	@FindBy(xpath="//label[text()='Service Type/Event Subtype']/../following-sibling::td//select")
	private WebElement select_servicetype;

	@FindBy(xpath="//input[@title='Save']")
	private WebElement btn_save;
	
	@FindBy(xpath="//input[contains(@value,'Save')]")
	private WebElement btn_save_escalation;

	@FindBy(xpath="//label[contains(text(),'Answer')]/..//select")
	private List<WebElement> select_answers;

	@FindBy(xpath="//input[@value='Save/Submit']")
	private WebElement btn_save_submit;

	@FindBy(xpath="//label[text()='Safety Question Status: ']")
	private WebElement label_submitted;

	@FindBy(xpath="//input[@value='Close']")
	private WebElement btn_close;
	
	@FindBy(xpath="//h3[text()='TW Updates']")
	private WebElement tw_section;

	@FindBy(xpath="(//h3[text()='TW Updates']/ancestor::div[2]//table)[2]//td")
	private WebElement tw_update;
	
	@FindBy(xpath="//table[@class='customLinks']//a[text()='TW Updates']")
	private WebElement tw_update_customLink;
	
	@FindBy(xpath="(//h3[text()='TW Updates']/ancestor::div[2]//table)[2]//a[contains(text(),'TW')]")
	private WebElement tw_update_record;
	
	@FindBy(xpath="//*[text()='System of Record']/following-sibling::td/div")
	private WebElement system_of_record;
	
	@FindBy(xpath="//*[text()='Type']/preceding-sibling::td/div")
	private WebElement tw_status;
	
	@FindBy(xpath="//*[text()='Date Sent to Trackwise']/preceding-sibling::td//img[not(@class='helpOrb')]")
	private WebElement To_Be_Picked_by_Batch;

	@FindBy(xpath="(//span[text()='Corrective Maint - Remote']/ancestor::table/following-sibling::table//img[contains(@src,'green')and@alt='RMSE Entitlement Flag'])")
	private WebElement corrective_maint_remote;

	@FindBy(xpath="(//h3[text()='Search Results']/ancestor::div[2]//input[@type='checkbox'])[1]")
	private WebElement checkbox_queue;

	@FindBy(xpath="//input[@value='Dispatch']")
	private WebElement btn_dispatch;

	@FindBy(xpath="//input[@value='T2 Activities']")
	private WebElement btn_t2activites;

	@FindBy(xpath="//h1[text()='Case Activity']")
	private WebElement case_activity;

	@FindBy(xpath="//input[@value='New Case Activity']")
	private WebElement btn_newcase_activity;

	@FindBy(xpath="//label[text()='Type']/../../..//select")
	private WebElement select_type;

	@FindBy(xpath="//input[@title='Cancel']")
	private WebElement btn_cancel;

	@FindBy(xpath="//input[@title='New Remote Labor']")
	private WebElement btn_new_remote_labour;

	@FindBy(xpath="//label[text()='End Time']/../../..//input")
	private WebElement end_time;

	@FindBy(xpath="//td[contains(@class,'todayDate')]/../following-sibling::tr/td")
	private WebElement calendar_date;

	@FindBy(xpath="//h1[text()='Labor']")
	private WebElement label_labour;

	@FindBy(xpath="//label[text()='Customer Symptom Code']/../../..//select")
	private WebElement cus_symp_code;
	
	@FindBy(xpath="//label[text()='Engineer Failure Code']/../../..//select")
	private WebElement eng_fail_code;

	@FindBy(xpath="//label[text()='Repair Activity Code']/../../..//select")
	private WebElement rep_act_code;

	@FindBy(xpath="//label[text()='Attempted to Use RSN']/../../following-sibling::td//select")
	private WebElement attemp_use_rsn;

	@FindBy(xpath="//h1[text()='Case']/..//h2")
	private WebElement label_case;

	@FindBy(xpath="//img[contains(@title,'Contact Name Lookup')]")
	private WebElement btn_search_contact;
	
	@FindBy(xpath="//frame[@title='Results']")
	private WebElement frame;

	@FindBy(xpath="//input[@title='New Escalation']")
	private WebElement btn_new_escalation;

	@FindBy(xpath="//label[text()='Current Device Status']/../../..//select")
	private WebElement select_devicestatus;

	@FindBy(xpath="//label[text()='Escalation Category']/../../..//select")
	private WebElement select_escalationcategory;

	@FindBy(xpath="//input[@value='Filter']")
	private WebElement btn_filter;
	
	@FindBy(xpath="(//input[@type='checkbox'])[1]")
	private WebElement checkbox;

	@FindBy(xpath="//input[@value='Escalate']")
	private WebElement btn_escalate;

	@FindBy(xpath="//img[contains(@title,'Implementor Lookup')]")
	private WebElement icon_search_implementor;

	@FindBy(xpath="//input[@title='New Action Plan']")
	private WebElement btn_actionplan;

	@FindBy(xpath="//label[text()='Quick Select']/../../..//select")
	private WebElement select_quickselct;

	@FindBy(xpath="//label[text()='Title']/../following-sibling::td//input")
	private WebElement input_title;

	@FindBy(xpath="//iframe[contains(@title,'Rich Text')]")
	private WebElement frame_description;

	@FindBy(xpath="//body")
	private WebElement body_description;

	@FindBy(xpath="//h1[text()='Action Plan and Response']")
	private WebElement label_acitonplan_response;

	@FindBy(xpath="//input[@value='Submit']")
	private WebElement btn_submit;

	@FindBy(xpath="//input[@value='Create Response']")
	private WebElement btn_createResponse;

	@FindBy(xpath="//label[text()='BU Status']/../../..//select")
	private WebElement select_bustatus;

	@FindBy(xpath="//label[text()='Monitoring Reason']/ancestor::tr[1]//textarea")
	private WebElement input_monitorreason;

	@FindBy(xpath="//span[text()='Monitoring Due Date']/../following-sibling::td[1]//div")
	private WebElement monitor_due_date;

	@FindBy(xpath="//label[text()='Release Date']/../../..//a")
	private WebElement link_releasedate;

	@FindBy(xpath="//label[text()='Expected Fix Date']/../../..//input")
	private WebElement input_expected_fix_date;

	@FindBy(xpath="//*[text()='Expected Fix Date']/../../following-sibling::td//a")
	private WebElement fix_date;
	
	@FindBy(xpath="//*[text()='Expected Fix Reminder Date']/../../following-sibling::td//a")
	private WebElement fix_date_reminder;

	@FindBy(xpath="//label[text()='Workaround Due Date']/../../following-sibling::td//a[contains(@href,'Date')]")
	private WebElement link_workaround_duedate;

	@FindBy(xpath="//label[text()='WorkAround Reason/Description']/../../following-sibling::td[1]//input")
	private WebElement input_workaround_reason;

	@FindBy(xpath="//label[text()='Rejection Situation']/../../..//select")
	private WebElement select_rejection;

	@FindBy(xpath="//label[text()='Customer Contact Preference']/../../following-sibling::td[1]//select")
	private WebElement select_customer_contactpreference;

	@FindBy(xpath="//iframe[contains(@src,'SearchResults')]")
	private WebElement asset_frame;

	@FindBy(xpath="//iframe[contains(@src,'https://philipsb2b') and not(contains(@name,'history'))]")
	private WebElement frame_assetpage;

	@FindBy(xpath="//iframe[contains(@src,'servlet')]")
	private WebElement case_frame;

	@FindBy(xpath="//li/a[contains(@title,'Details') and contains(@onClick,'Entity')]")
	private WebElement icon_details;


	@FindBy(xpath="//span[text()='Case']/../..//a")
	private WebElement caselink;
	
	@FindBy(xpath="//span[text()='Primary Case']/../..//a")
	private WebElement primary_case;

	@FindBy(xpath="//label[text()='Customer Temperature']/../../following-sibling::td[1]//select")
	private WebElement select_customertemperature;

	@FindBy(xpath="//span[text()='Status']/../following-sibling::td[1]/div")
	private WebElement case_status;

	@FindBy(xpath="//td[text()='Case Owner']/..//a[contains(text(),'[Change]')]")
	private WebElement link_changecaseowner;

	@FindBy(xpath="//input[@title='Owner name']")
	private WebElement input_caseOwner;

	@FindBy(xpath="//a[@title='Owner name']//img")
	private WebElement icon_searchOwner;

	@FindBy(xpath="//label[text()='ITIL Process']/ancestor::tr//td[2]//select")
	private WebElement itil_process;
	
	@FindBy(xpath="//*[text()='Status']/../../preceding-sibling::td//select")
	private WebElement current_device_status;
	
	@FindBy(xpath="//*[text()='Escalation Category']/../../following-sibling::td//select")
	private WebElement escalation_category;
	
	@FindBy(xpath="//*[text()='Status']/../../following-sibling::td//select")
	private WebElement escalation_status;
	
	@FindBy(xpath="//*[text()='Next Action Due Date Case']/../../preceding-sibling::td//span[@class='dateFormat']/a")
	private WebElement problem_occurance;
	
	
	
	@FindBy(xpath="//*[text()='Next Action Due Date Case']/../../following-sibling::td//span[@class='dateFormat']/a")
	private WebElement next_action_due_date;
	
	@FindBy(xpath="//*[text()='Software Release']/../../following-sibling::td//input")
	private WebElement software_release;
	
	@FindBy(xpath="//*[text()='Problem Description']/../../following-sibling::td//textarea")
	private WebElement problem_description;
	
	@FindBy(xpath="//*[text()='Previous Actions']/../../following-sibling::td//textarea")
	private WebElement previous_action;
	
	@FindBy(xpath="//*[text()='Replaced Parts']/../../following-sibling::td//textarea")
	private WebElement replaced_parts;
	
	@FindBy(xpath="//h3[text()='TW Updates History']")
	private WebElement tw_updates_history;

	@FindBy(xpath="//*[@id='cas7']")
	private WebElement case_status_value;
	
	@FindBy(xpath="//*[@id='cas7_ileinner']")
	private WebElement status_dclk_icon;
	
	@FindBy(xpath="//*[@id='head_01BE0000003NbQ9_ep']")
	private WebElement sap_rsn_info;
	
	@FindBy(xpath="//*[@id='00NE0000001qBgE_ilecell']")
	private WebElement cust_symptom_code_hover;
	
//	@FindBy(xpath="//*[@id=\"00NE0000001qBgE\"]")
//	private WebElement cust_symptom_code_dclk;
	
	@FindBy(xpath="//select[@id='00NE0000001qBgE']")
	private WebElement cust_symptom_code;
	
	@FindBy(xpath="//span[text()='Engineer Failure Code']/../../td[2]/div")
	private WebElement eng_failure_code_hover;
	
	@FindBy(xpath="//*[@id='00NE0000001qBgN']")
	private WebElement eng_failure_code;
	
	@FindBy(xpath="//*[@id=\'00NE0000001qBiu_ilecell\']")
	private WebElement repair_activity_code;
	
	@FindBy(xpath="//*[@id='00NE0000001qBiu']")
	private WebElement instructed_customer_code;

	@FindBy(xpath="//*[@id='InlineEditDialog_buttons']/input[1]")
	private WebElement ok_button;
	
	@FindBy(xpath="//*[@id='topButtonRow']/input[1]")
	private WebElement top_save_button;
	
	@FindBy(xpath="//*[@id='ep']/div[2]/div[3]/table/tbody/tr[4]/td[4]")
	private WebElement duration_button;

	private static String caseNumber;

	private static String escalationURl;

	public static String caseURl;
	public AssetPage(WebDriver driver) {
		super(driver);
	}
	
	

	public void clickOnAsset(String assetNumber) {
		if(loggedinUserName.contains("HISS")) {
		waitAndswitchToRequiredFrame(asset_frame);
		}
		WebElement Asset = driver.findElement(By.xpath("//a[text()='Asset']/ancestor::tbody[1]//a[text()='"+assetNumber+"']"));
		click("Asset ", Asset);
		embedScreenShotInreport();
	}
	
	public void clickOnEsca(String caseNumber) {
		if(loggedinUserName.contains("HISS")) {
		waitAndswitchToRequiredFrame(asset_frame);
		}
		WebElement case1 = driver.findElement(By.xpath("//a[text()='Case Number']/ancestor::tbody//a[text()='"+caseNumber+"']"));
		click("Case ", case1);
	}
	
	public void clickNewCase() {
		if(loggedinUserName.contains("HISS")) {
			
			driver.switchTo().defaultContent();
			frames(btn_case);
			}
		click("New Case", btn_case);
		driver.switchTo().defaultContent();
	}
	
	public void selectCaseRecordType(String value) {
		if(loggedinUserName.contains("HISS")) {
			driver.switchTo().defaultContent();
		frames(select_caserecordType);
		}
		waitForElement( select_caserecordType,"record type");
		selectbyValue(select_caserecordType, value, "case record type");
		click("continue", btn_continue);
		driver.switchTo().defaultContent();
	}
	
	public void enterCaseDetails(String eventType) {
		if(loggedinUserName.contains("HISS")) {
			waitAndswitchToRequiredFrame(case_frame);
			}
		if(eventType.equals("Case - Escalated")) {
			selectbyValue(current_device_status, "Down", "current_device_status");
			selectbyValue(escalation_category, "Technical", "escalation_category");
			selectRandomValue(select_priority, "Priority");
			enter("Subject", input_subject, "Automation Test"+Utility.getFormatedDateTime());
			addInput();
			if(loggedinUserName.contains("HISS")) {
				waitAndswitchToRequiredFrame(case_frame);
				}
		}
		
		else if(eventType.equals("Case - SubCase")) {
			waitTill("5");
			click("problem occurance", problem_occurance);
			click("Next Action Due Date Case", next_action_due_date);
			enter("Software Release", software_release, "1");
			selectRandomValue(select_priority, "Priority");
			enter("Problem Description", problem_description, "Problem Description123");
			enter("Previous Actions", previous_action, "Previous Actions123");
			enter("Replaced Parts", replaced_parts, "Replaced Parts123");
			
		}
		
		else {
			addInput();
			if(loggedinUserName.contains("HISS")) {
				waitAndswitchToRequiredFrame(case_frame);
				}
		enter("Subject", input_subject, "Automation Test"+Utility.getFormatedDateTime());
		enter("Description", input_description, "Automation Test"+Utility.getFormatedDateTime());
		selectRandomValue(select_priority, "Priority");
		selectbyValue(select_status, "New", "Status");
		selectbyValue(select_eventtype, eventType, "Event Type");
		if(eventType.equals("Direct Sales")) {
			selectbyValue(select_servicetype, "Parts Only", "Service Type");
		}
		else {
		selectbyValue(select_servicetype, "Remote Service", "Service Type");
		}
		if(verifyElementPresent("Customer COntact Preference", select_customer_contactpreference)) {
		selectbyValue(select_customer_contactpreference, "Email", "Customer COntact Preference");
		}
		}
		click("Save", btn_save);
		waitForElement(label_case, "Case");
		caseURl = driver.getCurrentUrl();
		if(loggedinUserName.contains("HISS")) {
			click("Details", icon_details);
			}
		embedScreenShotInreport();
	}
	
	public void addInput() {
		waitForElement(input_contact, "Contact");
		click("Contact", btn_search_contact);
		switchToTab(1);
		waitAndswitchToRequiredFrame(frame);
		click("Contact", input_contact);
		switchToTab(0);
		driver.switchTo().defaultContent();
		
	}
	
	public void clickSave() {
		click("Save", btn_save);
	}
	public void openCaseCreated() {
		System.out.println(caseURl);
		waitTill("10");
		driver.get(caseURl);
		waitForElement(label_case, "Case");
		waitTill("5");
		embedScreenShotInreport();
	}
	public void clickOn(String btnname) {
		waitTill("5");
		try {
		WebElement btn= driver.findElement(By.xpath("//h2[text()='Case Detail']/../following-sibling::td//input[contains(@value,'"+btnname+"')]"));
		click(btnname, btn);
		}catch(Exception e) {
			try {
			click("btn_save", btn_save);
			}catch(Exception e1) {}
		}
		waitTill("5");
		try {
			driver.switchTo().alert().accept();
		}catch(Exception e) {}
		waitTill("5");
		embedScreenShotInreport();
	}
	
	public void enterQuestionaryAnswers() {
		switchToTab(1);
		waitTill("6");
		for(int i=0;i<3;i++) {
			selectbyValue(select_answers.get(i), "No", "Answers");
		}
		click("Submit", btn_save_submit);
		waitTill("5");
		waitForElement(label_submitted, "Submitted");
		click("close", btn_close);
		switchToTab(0);
	}
	
	public void verifyTWRecordCreated(String recordCreation) {
		waitTill("5");
		driver.navigate().refresh();
		if (recordCreation.equals("Created")) {
			verifyElementTobePresent("TW update", tw_update);
			scrollByViewOfElement(tw_update_record);
			embedScreenShotInreport();
		}
		else if(recordCreation.equals("Not Created")) {
			verifyElementNotPresent("TW Records", tw_update_record);
			scrollByViewOfElement(tw_section);
			embedScreenShotInreport();
		}
		embedScreenShotInreport();
		
	}
	
	public void verifyFlagStatusGreen() {
		waitAndswitchToFrame("ActivityTypeFlags");
		waitForElement(corrective_maint_remote, "Corrective Maint- Remote");
		verifyElementTobePresent("Corrective Maint- Remote", corrective_maint_remote);
		scrollByViewOfElement(corrective_maint_remote);
		embedScreenShotInreport();
		driver.switchTo().defaultContent();
		
		
	}
	
	public void selectQueue() {
		switchToTab(1);
		click("Queue", checkbox_queue);
		waitTill("5");
		click("Dispatch", btn_dispatch);
		waitTill("5");
		waitforAlert();
		verifyBooleanStatus("Case dispatched to the selected Queue!", getAlertMessage());
		switchToTab(0);
	}
	
	public void enterT2Activites() {
		click("T2 Activites", btn_t2activites);
		waitTill("5");
		click("Save", btn_save);
		waitForElement(case_activity, "Case Activity");
		embedScreenShotInreport();
	}
	
	public void verifyPicklistCaseActivity() {
		click("New Case Activity", btn_newcase_activity);
		waitTill("5");
		waitForElement(select_type, "Type");
		Select dropDown = new Select(select_type);
		ArrayList<String> picklistvalues = new ArrayList<>(Arrays.asList("--None--","Problem Reported by Customer", 
				"Description of Problem", 
				"Next Step Action" , 
				"Troubleshooting Action" , 
				"Repair Action" , 
				"Test/Inspection" ,
				"Test Equipment" , 
				"C3 Services" ,
				"OneEMS internal remarks" , 
				"Internal Remarks" , 
				"Customer comment"));
		//System.out.println(picklistvalues);
		List<WebElement> values =dropDown.getOptions();
		for(int i=0;i<values.size();i++) {
			//System.out.println(values.get(i).getText());
			if(picklistvalues.contains(values.get(i).getText()) ){
				logReport("INFO", values.get(i).getText() + " - Present");
			} else {
				logReport("FAIL", values.get(i).getText() + " - Not Present");
				Assert.fail();
			}
		}
		embedScreenShotInreport();
		click("Cancel", btn_cancel);
	}
	
	public void newRemoteLabour() {
		if(loggedinUserName.contains("HISS")) {
			driver.switchTo().defaultContent();
			waitAndswitchToRequiredFrame(case_frame);
			}
		click("New Remote Labour", btn_new_remote_labour);
		if(loggedinUserName.contains("HISS")) {
			waitTill("5");
			driver.switchTo().defaultContent();
			frames(end_time);
		} else {
		switchToTab(1); 
		}
		/*waitForElement(end_time, "EndTime");
		Utility.highlightElement(driver,end_time);
		click("End Time", end_time);
		click("End Time", end_time);*/
		//click("Date", calendar_date);
		waitTill("6");
		driver.findElement(By.xpath("//input[@id='00NE0000001qBlO']")).sendKeys("1");
		click("Save", saveTopButton);
		waitForElement(label_labour, "labour");
		waitTill("5");
		if(!loggedinUserName.contains("HISS")) {
		driver.close();
		switchToTab(0);
		waitTill("5");
		driver.navigate().refresh();
		} else {
			    click("Case", caselink);
				driver.switchTo().defaultContent();
				waitAndswitchToRequiredFrame(case_frame);
		}
	}
	
	public void enterCloseCaseDetails() {
		
//		if(loggedinUserName.contains("HISS")) {
//			waitTill("5");
//			driver.switchTo().defaultContent();
//			frames(itil_process);
//			selectbyValue(itil_process,"Service Request", "ItIl PRocess");
//		} else {
			//selectbyValue(attemp_use_rsn,"No", "Customer Symptom Code");
		//}
		doubleClick(status_dclk_icon);
		selectbyValue(case_status_value, "Fixed", "Status");
		scrollByViewOfElement(sap_rsn_info);
		waitTill("5");
		hover(cust_symptom_code_hover);
		doubleClick(cust_symptom_code_hover);
		click("cust_symptom_code_hover", cust_symptom_code_hover);
		//selectRandomValue(cust_symptom_code, "Other Symptom; No Symptom");
		selectbyValue(cust_symptom_code, "Other Symptom; No Symptom", "cust_symptom_code");
		
		hover(eng_failure_code_hover);
		doubleClick(eng_failure_code_hover);
		//waitTill("5");
		//selectbyValue(eng_failure_code, "Incomplete or Incorrect Documentation", "eng_failure_code");
		//doubleClick(repair_activity_code);
		hover(instructed_customer_code);
		selectbyValue(instructed_customer_code, "Instructed Customer", "instructed_customer_code");
	    click("ok_button", ok_button);
	  //---Selecting Engineer Failure code
	  		hover(eng_failure_code_hover);  		
	  		doubleClick(eng_failure_code_hover);
	  	    click("eng_failure_code_hover", eng_failure_code_hover);
	  		selectbyValue(eng_failure_code, "Incomplete or Incorrect Documentation", "eng_failure_code");
	  		//---
	    
	    //save Button
	    hover(top_save_button);
	    click("top_save_button", top_save_button);
		embedScreenShotInreport();
		waitTill("5");
//		selectbyValue(select_status, "Fixed", "Status");
//		selectRandomValue(cus_symp_code, "Customer Symptom Code");
//		selectRandomValue(eng_fail_code, "Engineer Failure Code");
//		selectRandomValue(rep_act_code, "Engineer Failure Code");
//		click("Save", btn_save);
		//waitForElement(label_case, "Case");
		//}
	}



	public void clickNewEscalation() {
		waitTill("5");
		click("New Escalation", btn_new_escalation);
	}



	public void enterescalationDetails() {
		if(loggedinUserName.contains("HISS")) {
			waitTill("5");
			driver.switchTo().defaultContent();
			frames(select_devicestatus);
			}
		selectRandomValue(select_devicestatus, "Current Device Status");
		selectRandomValue(select_escalationcategory, "Escalation Category");
		enter("Description", input_description, "Automation Test"+Utility.getFormatedDateTime());
		click("Save", btn_save_escalation);
		waitForElement(label_case, "Case");
		escalationURl = driver.getCurrentUrl();
		caseNumber =label_case.getText();
	}



	public void routeEscalation(String level) {
		try {
		switchToTab(1);
		WebElement level_radio = driver.findElement(By.xpath("//label[contains(text(),'"+level+"')]/..//input"));
		click(level, level_radio);
		click("Filter", btn_filter);
		click("checkbox", checkbox);
		click("Escalate", btn_escalate);
		waitforAlert();
		verifyBooleanStatus("Escalation has been routed to the selected Queue!", getAlertMessage());
		switchToTab(0);
		}catch(Exception e) {}
		
	}



	public void verifyAlert(String type) { 
		try {
		if(type.contains("Accept")) {
		verifyBooleanStatus("Escalation was successfully assigned.", getAlertMessage());
		} else if(type.contains("Reject")) {
			verifyBooleanStatus("This Escalation is Rejected.", getAlertMessage());
		}
		}catch(Exception e) {}
	}



	public void openEscalationCreated() {
		waitTill("10");
		driver.get(escalationURl);
		waitForElement(label_case, "Case");
		verifyBooleanStatus(caseNumber, label_case.getText());
		waitTill("5");
	}



	public void enterImplementor() {
		click("Implementor Search", icon_search_implementor);
		switchToTab(1);
		waitAndswitchToRequiredFrame(frame);
		try {
			click("Contact", input_contact);
			waitTill("2");
		}catch(Exception e) {}
		switchToTab(0);
		driver.switchTo().defaultContent();
		if(loggedinUserName.contains("HISS")) {
			frames(btn_save);
		}
		click("save", btn_save);
	}



	public void clicNewActionPlan() {
		waitTill("10");
		try {
		driver.switchTo().defaultContent();
		click("New Action Plan", btn_actionplan);
		}catch(Exception e) {}
	}





	public void createActionPlan() {
		try {
		switchToTab(1);
		waitForElement(select_quickselct, "Quick Select");
		Select dropDown = new Select(select_quickselct);
		ArrayList<String> picklistvalues = new ArrayList<>(Arrays.asList("--None--","L1 Owner","L2 Owner","L3 Owner","Pending Action Owner"));
		List<WebElement> values =dropDown.getOptions();
		for(int i=0;i<values.size();i++) {
			if(picklistvalues.contains(values.get(i).getText()) ){
				logReport("INFO", values.get(i).getText() + " - Present");
			} else {
				logReport("FAIL", values.get(i).getText() + " - Not Present");
				Assert.fail();
			}
		}
		selectbyValue(select_quickselct, "L3 Owner", "Quick Select");
		enter("Title", input_title, "Automation Test"+Utility.getFormatedDateTime());
		waitAndswitchToRequiredFrame(frame_description);
		enter("Description", body_description, "Automation Testing"+Utility.getFormatedDateTime());
		driver.switchTo().defaultContent();
		click("Save", btn_save);
		waitForElement(label_acitonplan_response, "Action Plan");
		click("Submit", btn_submit);
		}catch(Exception e) {
			driver.switchTo().defaultContent();
			click("Save", btn_save);	
		}
		waitTill("4");
		
	}



	public void createResponse() {
		try {
		click("Create Response", btn_createResponse);
		driver.close();
		waitTill("5");
		switchToTab(1);
		enter("Title", input_title, "Automation Test"+Utility.getFormatedDateTime());
		waitAndswitchToRequiredFrame(frame_description);
		enter("Description", body_description, "Automation Testing"+Utility.getFormatedDateTime());
		driver.switchTo().defaultContent();
		click("Save", btn_save);
		waitTill("5");
		click("Submit", btn_submit);
		waitTill("4");
		driver.close();
		switchToTab(0);
		}catch(Exception e) {}
		
	}



	public void enterBUStatus() {
		selectbyValue(select_bustatus, "Waiting BU Fix", "BU Status");
		click("Save", btn_save);
		waitForElement(label_case, "Case");
	}



	public void enterStatus(String status) {
		selectbyValue(select_status, status, "Status");
		if(status.contains("Monitoring")) {
		enter("Monitoring Area", input_monitorreason, "Automation"+Utility.getFormatedDateTime());
		click("Save", btn_save);
		waitForElement(label_case, "case");
		waitForElement(monitor_due_date, "Monitor Due Date");
		if(monitor_due_date.getText().length()!=0) {
			logReport("Pass", "Date Populated");
		} else {
			logReport("Fail", "Date Not Populated");
			Assert.fail();
		}
		} else if(status.contains("Workaround")) {
			click("work Around Due Date", link_workaround_duedate);
			enter("WorkAround Reason", input_workaround_reason, "Autmation Testing"+Utility.getFormatedDateTime());
			click("Save", btn_save);
			waitForElement(label_case, "case");
		}
	}
	
	public void enterReleaseDate() {
		click("Release date", link_releasedate);
		click("Save", btn_save);
		waitForElement(label_case, "Case");
	}



	public void enterexpectedFixDate() {
		click("Expected fix date", input_expected_fix_date);
		click("Expected Fix Date", fix_date);
		click("Expected Fix Reminder Date", fix_date_reminder);
		click("Save", btn_save);
		waitForElement(label_case, "Case");
	}



	public void enterCloseEscalationDetails() {
		selectbyValue(select_status, "Closed", "Status");
		click("Save", btn_save_escalation);
	}



	public void enterRejectionSituation() {
		waitTill("8");
		selectbyValue(select_rejection,"Technical malfunction in unreleased product", "Rejection Situation");
		click("Save", btn_save);
		waitForElement(label_case, "Case");
	}



	public void searchEscalationCreated() {
		closePrimaryTabs();
		driver.switchTo().defaultContent();
		globalSearch(caseNumber);
		clickOnEsca(caseNumber);
		waitTill("6");
		driver.navigate().refresh();
		driver.switchTo().defaultContent();
		waitTill("5");
		frames(label_case);
		verifyBooleanStatus(caseNumber, label_case.getText());
	}



	public void changeCustomerTemperature(String color) {
		selectbyValue(select_customertemperature, color, "Customer Temperature");
		click("Save", btn_save);
		waitForElement(label_case, "Case");
		
	}



	public void verifyStatus(String Status) {
		waitForElement(case_status, "Case Status");
		if(case_status.getText().contains(Status)) {
			logReport("Info",  "Status:- "+case_status.getText());
			
		} else {
			logReport("Info", "Status should not be:- "+case_status.getText());
			Assert.fail();
		}
	}



	public void openPrimaryCase() {
		click("Primary Case", primary_case);
		driver.switchTo().defaultContent();
		waitTill("5");
		frames(icon_details);
		click("Details", icon_details);
	}



	public void changeOwner(String owner) {
		click("Case Owner", link_changecaseowner);
		driver.switchTo().defaultContent();
		frames(input_caseOwner);
		enter("Case Owner", input_caseOwner, owner);
		click("search", icon_searchOwner);
		switchToTab(1);
		driver.switchTo().defaultContent();
		waitAndswitchToRequiredFrame(frame);
		click("Contact", input_contact);
		switchToTab(0);
		driver.switchTo().defaultContent();
		frames(input_caseOwner);
		click("Save", btn_save_escalation);
		driver.switchTo().defaultContent();
		frames(icon_details);
	}
	
	public void enterQuestionaryAnswersToCloseCase() {
		switchToTab(1);
		waitTill("6");
		for(int i=0;i<4;i++) {
			selectbyValue(select_answers.get(i), "Unknown", "Answers");
		}
		click("Submit", btn_save_submit);
		waitTill("5");
		waitForElement(label_submitted, "Submitted");
		click("close", btn_close);
		switchToTab(0);
		if(loggedinUserName.contains("HISS")) {
			driver.switchTo().defaultContent();
			frames(icon_details);
		}
	}

	public void verifyTWRecordValues(ArrayList<String> values) {
		click("TW Record", tw_update_record);
		waitTill("5");
		embedScreenShotInreport();
		verifyTextContains(tw_status, values.get(0));
		verifyTextContains(system_of_record, values.get(2));
		String attributeValue = To_Be_Picked_by_Batch.getAttribute("title");
		System.out.println("To_Be_Picked_by_Batch:"+attributeValue);
		verifyBooleanStatus(attributeValue, values.get(1));
		scrollByViewOfElement(tw_updates_history);
		embedScreenShotInreport();
		
	}

	public void verifyHomePage() {
		 String pageTitle = driver.getTitle();
		 if(!pageTitle.contains("Administer : Unlimited Edition")) {
			 click("Set Up", driver.findElement(By.xpath("//a[@title='Setup']")));
			 waitTill("5");
		 }
		 System.out.println("Page Title:"+driver.getTitle());
		
	}
	public void enterCaseDetails() {
		if(loggedinUserName.contains("HISS")) {
			waitAndswitchToRequiredFrame(case_frame);
			}
		waitForElement(input_contact, "Contact");
		click("Contact", btn_search_contact);
		switchToTab(1);
		waitAndswitchToRequiredFrame(frame);
		click("Contact", input_contact);
		switchToTab(0);
		driver.switchTo().defaultContent();
		if(loggedinUserName.contains("HISS")) {
			waitAndswitchToRequiredFrame(case_frame);
			}
		enter("Subject", input_subject, "Automation Test"+Utility.getFormatedDateTime());
		enter("Description", input_description, "Automation Test"+Utility.getFormatedDateTime());
		selectRandomValue(select_priority, "Priority");
		selectbyValue(select_status, "New", "Status");
		selectbyValue(select_eventtype, "Corrective Maintenance", "Event Type");
		selectbyValue(select_servicetype, "Remote Service", "Service Type");
		if(verifyElementPresent("Customer COntact Preference", select_customer_contactpreference)) {
		selectbyValue(select_customer_contactpreference, "Email", "Customer COntact Preference");
		}
		click("Save", btn_save);
		waitForElement(label_case, "Case");
		caseURl = driver.getCurrentUrl();
		if(loggedinUserName.contains("HISS")) {
			click("Details", icon_details);
			}
	}
}
