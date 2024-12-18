package com.philips.stepdefinitions;

import java.net.MalformedURLException;

import com.philips.experitest.seeTestBase;
import com.philips.generic.AutomationConstants;
import com.philips.pages.BaseLib;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ServiceMaxGoAppStepDefinition {

	public seeTestBase stBase;

	public ServiceMaxGoAppStepDefinition() {
		stBase = new seeTestBase();
	}

	@When("^I Choose to enter credentials for \"([^\"]*)\" in mobile device$")
	public void i_Choose_to_enter_credentials_for_in_mobile_device(String arg1) throws Throwable {
		stBase.loginfsa(arg1);
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I choose to Click Explore and verify properties$")
	public void explore_pro() throws InterruptedException {
		stBase.clickonExploreButton();  
		stBase.verify_Searches_AndExlore();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	
	@When("^I Choose to Open WorkOrder$")
	public void open_WO() throws InterruptedException {
		stBase.clickonInProgressWorkOrder();  
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Open FCO WorkOrder$")
	public void open_FCO_WO() throws InterruptedException {
		stBase.FCO_WO_InProgress();  
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Perform Initiate Travel Action$")
	public void initiate_Travel() throws InterruptedException {
		stBase.initiateTravel();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Click Explore$")
	public void clickExlopre() throws InterruptedException {
		stBase.clickonExploreButton();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I choose to Click Explore and open WorkOrder$")
	public void explore_pro_WO() throws InterruptedException {
		stBase.clickonExploreButton();  
		stBase.clickonInProgressWorkOrder();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Perform Receive Parts Action and update Line Status$")
	public void receiveParts() throws InterruptedException {
		stBase.receiveParts();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^I Choose to Perform Initiate Onsite Action$")
	public void Initiate_Onsite() throws InterruptedException {
		stBase.InitiateOnsite();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Add Labor$")
	public void addLabor() throws InterruptedException {
		stBase.addLabor();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Update labor Activity Type$")
	public void labor_Activity_Type() throws InterruptedException {
		stBase.labor_Activity_Type();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Consume Parts$")
	public void consumeParts() throws InterruptedException {
		stBase.consumePart();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Report part consumption$")
	public void partConsumption() throws InterruptedException {
		stBase.consumePart();
		BaseLib.embedScreenShotInreportWithRobot();
	} 
	@When("^I Choose to Add Record Tools$")
	public void addReocrd() throws InterruptedException {
		stBase.addRecordTool();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Debrief and Follow up$")
	public void debriefAndFollow() throws InterruptedException {
		stBase.debriefAndFollow();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Update Work Activity$")
	public void workActivity() throws InterruptedException {
		stBase.workActivity();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Sync Data$")
	public void SyncData() throws InterruptedException {
		stBase.sync();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Config Sync Data$")
	public void confi_Sync() throws InterruptedException {
		stBase.confi_Sync();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Perform Unsigned Customer Report$")
	public void cust_Sign() throws InterruptedException {
		stBase.unsigned_Report();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose To Complete Work Order$")
	public void complet_WO() throws InterruptedException {
		stBase.complet_WO();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Verify that the CSR email is received$")
	public void verify_CSR() throws Exception {
		stBase.verify_CSR_Mail();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^I choose to create a Non-Customer Interactive Time$")
	public void i_choose_to_create_a_Non_Customer_Interactive_Time() throws Throwable {
		stBase.clickonExploreButton();   
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^I choose to enter Subject in Mobile device$")
	public void i_choose_to_enter_Subject_in_Mobile_device() throws Throwable {
		stBase.enterSubject();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^I choose to enter description in Mobile device$")
	public void i_choose_to_enter_description_in_Mobile_device() throws Throwable {
		stBase.enterDescription();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^I choose to click on Save button in Mobile device$")
	public void i_choose_to_click_on_Save_button_in_Mobile_device() throws Throwable {
		stBase.clickonSaveButton();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^I choose to open the \"([^\"]*)\" device$")
	public void openDevice(String device) throws MalformedURLException {
		stBase.accessDevice(device);
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@Then("I Choose to Close App")
	public void closeApp() {
		BaseLib.embedScreenShotInreportWithRobot();
		stBase.tearDown();
	}
	@When("^I Choose to Sync IPad Data$")
	public void SyncData_Ipad() throws InterruptedException {
		stBase.sync_Ipad();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I choose to Click Explore and open WorkOrder in IPad$")
	public void explore_pro_WO_IPad() throws InterruptedException {
		stBase.explore_pro_WO_IPad();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Mark FCO Kit Delivered$")
	public void mark_FCO_Kit_Delivered() throws InterruptedException {
		stBase.mark_FCO_Kit_Delivered();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Mark FCO Kit Line staus and Part Status$")
	public void mark_FCO_Kit_LineStatus() throws InterruptedException {
		stBase.mark_FCO_Kit_LineStatus();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Mark FCO Kit Complete and verify error$")
	public void mark_FCO_Kit_Complete() throws InterruptedException {
		stBase.mark_FCO_Kit_Complete();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Mark All FCO Kit Line staus and Part Status$")
	public void mark_All_FCO_Kit_LineStatus() throws InterruptedException {
		stBase.mark_All_FCO_Kit_LineStatus();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Mark FCO Kit Complete$")
	public void mark_FCO_Kit_Complete_success() throws InterruptedException {
		stBase.mark_FCO_Kit_Complete_Success();
		BaseLib.embedScreenShotInreportWithRobot();
	}
}
