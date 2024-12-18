package com.philips.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.philips.generic.AutomationConstants;
import com.philips.generic.Utility;

public class ServiceMaxBenchStatusTrackerPage extends BasePage {

	@FindBy(xpath = "//a[text()='Create Bench Receipt']")
	public WebElement benchRepairCaseBTN;

	@FindBy(xpath = "//td[@data-qtip='Equipment Received']")
	public WebElement benchRepairStatus;

	@FindBy(xpath="//span[contains(text(), 'Bench Repair Status')]//parent::td[@class='labelCol']//parent::tr//div[@id='00N0L000006wKus_ileinner']")
	private WebElement bench_Repair_Status_Value;

	@FindBy(xpath="//*[contains(text(), 'Case')][@class='helpButton']//parent::td//parent::tr//td[contains(@class, 'inlineEditWrite')]//div//a")
	private WebElement case_Value;

	@FindBy(xpath="//*[contains(text(),'Equipment Received Status Time')]//parent::td//parent::tr//td[contains(@class, 'dataCol col02 inlineEditLock')]/*") //tempXp
	private WebElement equipment_Received_Status_Time_value;

	@FindBy(xpath="//*[contains(text(), 'Decontamination Complete Status Time')]//parent::td//parent::tr//td[contains(@class, 'dataCol col02 inlineEditLock')]/*")
	private WebElement decontamination_Complete_Status_Time_Value;

	@FindBy(xpath="//*[contains(text(), 'Follow up work Identified Status Time')]/../following-sibling::td/*")
	private WebElement followup_work_Identified_Status_Time_Value;

	@FindBy(xpath="//*[contains(text(), 'Ready For Diagnosis Status Time')]/../following-sibling::td/*")
	private WebElement ready_For_Diagnosis_Status_Time_Value;

	@FindBy(xpath="//*[contains(text(), 'Engineer Diagnosing/Repairing Age')]/../following-sibling::td/*")
	private WebElement engineer_DiagnosingRepairing_Age_Value;

	@FindBy(xpath = "//*[@data-qtip='Save']")
	public WebElement createBenchReceipt_SaveButton;

	@FindBy(xpath="//*[@data-qtip='Equipment Received']")
	public WebElement equip_received;

	@FindBy(xpath="//*[text()='Equipment Received Status Time']")
	public WebElement equip_received_Time;

	@FindBy(xpath="//*[@title='Case']/following-sibling::*[@class='pageDescription']")
	public WebElement Bench_Case;

	@FindBy(xpath="//*[text()='Bench Status Tracker Number']/../following-sibling::tr//a")
	public List<WebElement> Bench_Status_Tracker;

	public ServiceMaxBenchStatusTrackerPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void verify_Bench_Repair_Status(String bnchRprStatus){

		waitForElement(bench_Repair_Status_Value, "Bench Repair Status");
		Assert.assertEquals(bench_Repair_Status_Value.getText(), bnchRprStatus);

		logReport("PASS", "Bench Repair Status Verified:"+bnchRprStatus);
	}

	public void verify_equipmentReceivedStatusTime_Population(){

		waitForElement(equipment_Received_Status_Time_value, "Equipment Received Status Time");
		Assert.assertTrue(equipment_Received_Status_Time_value.isDisplayed(), "Equipment Received Status Time is not Populated_");
	}

	public void verify_DecontaminationCompleteStatusTime_Population(){

		waitForElement(decontamination_Complete_Status_Time_Value, "Decontamination Complete Status Time");
		Assert.assertTrue(decontamination_Complete_Status_Time_Value.isDisplayed(), "Decontamination Complete Status Time is not Populated");
	}

	public void click_Create_Bench_Repaire_status() {
		try {
			waitTill("5");
			equip_received.isDisplayed();
			equip_received_Time.isDisplayed();
		}catch(Exception e) {}
		waitTill("5");
		click("createBenchReceipt_SaveButton", createBenchReceipt_SaveButton);
		waitTill("5");
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("BENCH_CASE",Bench_Case.getText());
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("Bench_Status_Tracker_Number",Bench_Status_Tracker.get(1).getText());

	}
	public void create_Bench_Status_Tracker_Number() {
		waitForElement(benchRepairStatus,"benchRepairStatus");
	}

	public void goTo_CaseDetails_Page(){
		click("Case", case_Value);
	}

	public void verify_FollowupWorkIdentifiedStatusTime(String arg1) {
		// TODO Auto-generated method stub
		waitForElement(followup_work_Identified_Status_Time_Value, "Follow up work Identified Status Time");
		if(followup_work_Identified_Status_Time_Value.getText() != null)
			logReport("PASS", "Follow up work Identified Status Time is updated as: "+arg1+" : "+followup_work_Identified_Status_Time_Value.getText());
		else{
			logReport("INFO", "Follow up work Identified Status Time is not updated");
			Assert.fail("Follow up work Identified Status Time is not updated");
		}
	}

	public void verify_ReadyforDiagnosisStatusTime() {
		// TODO Auto-generated method stub
		waitForElement(ready_For_Diagnosis_Status_Time_Value, "Ready For Diagnosis Status Time");
		if(ready_For_Diagnosis_Status_Time_Value.getText() != null)
			logReport("PASS", "Ready For Diagnosis Status Time is updated as System Time: "+ready_For_Diagnosis_Status_Time_Value.getText());
		else{
			logReport("INFO", "Ready For Diagnosis Status Time is not updated");
			Assert.fail("Ready For Diagnosis Status Time is not updated");
		}
	}

	public void verify_EngineerDiagnosingRepairingAge() {
		// TODO Auto-generated method stub
		waitForElement(engineer_DiagnosingRepairing_Age_Value, "Engineer Diagnosing/Repairing Age");
		if(engineer_DiagnosingRepairing_Age_Value.getText() != null)
			logReport("PASS", "Engineer Diagnosing/Repairing Age is calculated accordingly");
		else{
			logReport("INFO", "Engineer Diagnosing/Repairing Age is Not calculated accordingly");
			Assert.fail("Engineer Diagnosing/Repairing Age is Not calculated accordingly");
		}

	}
	public void update_TrackingCourier_number() {

	}
}
