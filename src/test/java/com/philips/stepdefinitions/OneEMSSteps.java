package com.philips.stepdefinitions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.philips.pages.AssetPage;
import com.philips.pages.BasePage;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;

public class OneEMSSteps {

	private WebDriver driver;
	private BasePage basepage;
	private AssetPage assetpage;
	
	public OneEMSSteps() {
		driver = Hooks.driverInstances.get(String.valueOf(Thread.currentThread().getId()));
		assetpage = new AssetPage(driver);
		basepage = new BasePage(driver);
	}
	
	@When("^I choose to search the \"([^\"]*)\"$")
	public void i_choose_to_search_the_asset(String value) throws Throwable {
	   basepage.globalSearch(value);
	   basepage.embedScreenShotInreport();
	}
	
	@When("^I Choose to navigate to home page$")
	public void i_choose_to_navigate_to_home_page() throws Throwable {
	  
	   assetpage.verifyHomePage();
	   basepage.embedScreenShotInreport();
	}

	@When("^I choose to open the asset \"([^\"]*)\"$")
	public void i_choose_to_open_the_asset(String asset) throws Throwable {
	    assetpage.clickOnAsset(asset);
	    basepage.embedScreenShotInreport();
	}

	@When("^I choose to click on New Case$")
	public void i_choose_to_click_on_New_Case() throws Throwable {
	    assetpage.clickNewCase();
	    basepage.embedScreenShotInreport();
	}

	@When("^I choose select Case record type \"([^\"]*)\"$")
	public void i_choose_select_Case_record_type(String recordtype) throws Throwable {
	    assetpage.selectCaseRecordType(recordtype);
	    basepage.embedScreenShotInreport();
	}

	@When("^I choose to enter case Details \"([^\"]*)\"$")
	public void i_choose_to_enter_case_Details(String eventType) throws Throwable {
	    assetpage.enterCaseDetails(eventType);
	    basepage.embedScreenShotInreport();
	}
	

	@When("^I choose to click on option \"([^\"]*)\"$")
	public void i_choose_to_click_on_option(String button) throws Throwable {
	    assetpage.clickOn(button);
	    basepage.embedScreenShotInreport();
	}

	@When("^I choose enter questionery Answers$")
	public void i_choose_enter_questionery_Answers() throws Throwable {
	    assetpage.enterQuestionaryAnswers();
	    basepage.embedScreenShotInreport();
	}

	@When("^I Verify TW record is \"([^\"]*)\"$")
	public void i_Verify_TW_record_creation(String recordCreation) throws Throwable {
	    assetpage.verifyTWRecordCreated(recordCreation);
	    basepage.embedScreenShotInreport();
	}
	
	@When("^I verify TW record values$")
	public void i_Verify_TW_record_values(DataTable twValues) throws Throwable {
		List<List<String>> data = twValues.raw();
		ArrayList<String> values = new ArrayList<String>();
		for (int i = 0; i < data.size(); i++) {
			values.add(data.get(i).get(0));
			values.add(data.get(i).get(1));
			values.add(data.get(i).get(2));
		}
	    assetpage.verifyTWRecordValues(values);
	    basepage.embedScreenShotInreport();
	}

	@When("^I choose to verify Corrective Maint- Remote is green$")
	public void i_choose_to_verify_Corrective_Maint_Remote_is_green() throws Throwable {
	    assetpage.verifyFlagStatusGreen();
	    basepage.embedScreenShotInreport();
	}

	@When("^I choose to select Queue and Dispatch$")
	public void i_choose_to_select_Queue_and_Dispatch() throws Throwable {
	    assetpage.selectQueue();
	    basepage.embedScreenShotInreport();
	}

	@When("^I Choose to open the case Created$")
	public void i_Choose_to_open_the_case_Created() throws Throwable {
	    assetpage.openCaseCreated();
	    basepage.embedScreenShotInreport();
	}

	@When("^I choose to enter T(\\d+)Activites$")
	public void i_choose_to_enter_T_Activites(int arg1) throws Throwable {
	    assetpage.enterT2Activites();
	    basepage.embedScreenShotInreport();
	}

	@When("^I Choose to Choose to verify Case Activity Picklist$")
	public void i_Choose_to_Choose_to_verify_Case_Activity_Picklist() throws Throwable {
	    assetpage.verifyPicklistCaseActivity();
	    basepage.embedScreenShotInreport();
	}

	@When("^I Choose to click on NewRemoteLabour$")
	public void i_Choose_to_click_on_NewRemoteLabour() throws Throwable {
	    assetpage.newRemoteLabour();
	    basepage.embedScreenShotInreport();
	}

	@When("^I Choose to enter Close Details$")
	public void i_Choose_to_enter_Close_Details() throws Throwable {
	    assetpage.enterCloseCaseDetails();
	    basepage.embedScreenShotInreport();
	}
	
	@When("^I choose to click on logout$")
	public void i_choose_toclick_logout() throws Throwable {
		 basepage.embedScreenShotInreport();
	    basepage.logOut();
	}
	
	@When("^I choose to click on New Escalation$")
	public void i_choose_click_new_Escalation() throws Throwable {
	    assetpage.clickNewEscalation();
	    basepage.embedScreenShotInreport();
	}
	
	@When("^I choose to enter escalation details$")
	public void i_choose_to_enter_escalation_Details() throws Throwable {
	    assetpage.enterescalationDetails();
	    basepage.embedScreenShotInreport();
	}
	
	@When("^I choose to route Escalation to \"([^\"]*)\"$")
	public void i_choose_to_route_escalation(String level) throws Throwable {
	    assetpage.routeEscalation(level);
	    basepage.embedScreenShotInreport();
	}
	
	@When("^I choose to verify the Alert \"([^\"]*)\"$")
	public void i_choose_to_verify_alert(String type) throws Throwable {
	    assetpage.verifyAlert(type);
	    basepage.embedScreenShotInreport();
	}
	
	@When("^I Choose to open the Escalation Created$")
	public void i_Choose_to_open_the_escalation_Created() throws Throwable {
	    assetpage.openEscalationCreated();
	    basepage.embedScreenShotInreport();
	}
	
	@When("^I choose to verify email \"([^\"]*)\"$")
	public void i_choose_to_verify_email(String button) throws Throwable {
		 basepage.embedScreenShotInreport();
	}
	
	@When("^I choose to enter Implementor$")
	public void i_choose_to_enter_implementor() throws Throwable {
	    assetpage.enterImplementor();
	    basepage.embedScreenShotInreport();
	}
	
	@When("^I choose to click on New Action Plan$")
	public void i_choose_to_click_New_action() throws Throwable {
	    assetpage.clicNewActionPlan();
	    basepage.embedScreenShotInreport();
	}
	
	@When("^I choose to create New Action Plan$")
	public void i_choose_to_verify_quick_select_picklistvaues() throws Throwable {
	    assetpage.createActionPlan();
	    basepage.embedScreenShotInreport();
	}
	
	@When("^I choose to create Response on  Action Plan$")
	public void i_choose_to_create_response() throws Throwable {
	    assetpage.createResponse();
	    basepage.embedScreenShotInreport();
	}
	
	@When("^I choose to enter BU Status$")
	public void i_choose_to_enter_BU_Status() throws Throwable {
	    assetpage.enterBUStatus();
	    basepage.embedScreenShotInreport();
	}
	
	@When("^I choose to change the status to \"([^\"]*)\"$")
	public void i_choose_to_change_status(String status) throws Throwable {
	    assetpage.enterStatus(status);
	    basepage.embedScreenShotInreport();
	}
	
	@When("^I choose to enter Expected fix date$")
	public void i_choose_to_enter_expected_fix_date() throws Throwable {
	    assetpage.enterexpectedFixDate();
	    basepage.embedScreenShotInreport();
	}
	
	@When("^I choose to enter release Date$")
	public void i_choose_to_enter_release_date() throws Throwable {
	    assetpage.enterReleaseDate();
	    basepage.embedScreenShotInreport();
	}
	
	@When("^I Choose to enter EscalationClose Details$")
	public void i_Choose_to_enter_Close_escalation_Details() throws Throwable {
	    assetpage.enterCloseEscalationDetails();
	    basepage.embedScreenShotInreport();
	}
	
	@When("^I choose to enter rejection situation$")
	public void i_Choose_to_enter_rejection_situation() throws Throwable {
	    assetpage.enterRejectionSituation();
	    basepage.embedScreenShotInreport();
	}
	
	@When("^I choose to search open the escalation Created case$")
	public void i_Choose_to_open_escalation_created() throws Throwable {
	    assetpage.searchEscalationCreated();
	    basepage.embedScreenShotInreport();
	}
	
	@When("^I choose to change customer temperature to \"([^\"]*)\"$")
	public void i_choose_to_change_color_temperature(String color) throws Throwable {
	    assetpage.changeCustomerTemperature(color);
	    basepage.embedScreenShotInreport();
	}
	
	
	@When("^I choose to verify case status \"([^\"]*)\"$")
	public void i_choose_to_verify_status(String status) throws Throwable {
	    assetpage.verifyStatus(status);
	    basepage.embedScreenShotInreport();
	}
	
	@When("^I choose to open primary case$")
	public void i_choose_to_open_primary_case() throws Throwable {
	    assetpage.openPrimaryCase();
	    basepage.embedScreenShotInreport();
	}
	
	@When("^I choose to change case owner to \"([^\"]*)\"$")
	public void i_choose_to_change_owner(String owner) throws Throwable {
	    assetpage.changeOwner(owner);
	    basepage.embedScreenShotInreport();
	}
	
	@When("^I choose enter questionery Answers for closing the case$")
	public void i_choose_enter_questionery_Answers_to_close_case() throws Throwable {
	    assetpage.enterQuestionaryAnswersToCloseCase();
	    basepage.embedScreenShotInreport();
	}
	
	@When("^I choose to enter case Details$")
	public void i_choose_to_enter_case_Details() throws Throwable {
	    assetpage.enterCaseDetails();
	    basepage.embedScreenShotInreport();
	}

}
