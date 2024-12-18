package com.philips.stepdefinitions;

import java.awt.AWTException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.philips.generic.AutomationConstants;
import com.philips.generic.Utility;
import com.philips.pages.AccountsPage;
import com.philips.pages.BaseLib;
import com.philips.pages.BasePage;
import com.philips.pages.ContactPage;
import com.philips.pages.CreateQuotePage;
import com.philips.pages.CustomerServicePage;
import com.philips.pages.EventPage;
import com.philips.pages.HybrisPage;
import com.philips.pages.InstalledProduct;
import com.philips.pages.LeanFTPage;
import com.philips.pages.LocationPage;
import com.philips.pages.RswPage;
import com.philips.pages.ServiceContractPage;
import com.philips.pages.ServiceMaxBenchStatusTrackerPage;
import com.philips.pages.ServiceMaxCaseDetailsPage;
import com.philips.pages.ServiceMaxFCOPage;
import com.philips.pages.ServiceQuotePage;
import com.philips.pages.WorkOrderPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepdefs {

	public WebDriver driver;
	private BasePage basePage;
	private ServiceMaxCaseDetailsPage serviceMaxCaseDetailsPage;
	private ServiceContractPage serviceContractPage;
	private WorkOrderPage serviceMaxWorkOrderPage;
	private EventPage eventPage;
	private InstalledProduct installedProduct;
	private AccountsPage accountsPage;
	private LocationPage locationPage;
	private ServiceQuotePage serviceQuotePage;
	private ContactPage contactPage;
	private WorkOrderPage workOrderPage;
	private ServiceMaxBenchStatusTrackerPage serviceMaxBenchStatusTrackerPage;
	private HybrisPage hybrisPage;

	private CustomerServicePage customerServicePage;
	private RswPage rswPage;

	public MyStepdefs() {
		driver = Hooks.driverInstances.get(String.valueOf(Thread.currentThread().getId()));
		basePage = new BasePage(driver);
		serviceMaxCaseDetailsPage = new ServiceMaxCaseDetailsPage(driver);
		serviceContractPage = new ServiceContractPage(driver);
		serviceMaxWorkOrderPage = new WorkOrderPage(driver);
		installedProduct = new InstalledProduct(driver);
		accountsPage = new AccountsPage(driver);
		serviceQuotePage = new ServiceQuotePage(driver);
		workOrderPage = new WorkOrderPage(driver);
		serviceMaxBenchStatusTrackerPage = new ServiceMaxBenchStatusTrackerPage(driver);
		contactPage = new ContactPage(driver);
		eventPage = new EventPage(driver);

		hybrisPage = new HybrisPage(driver);

		locationPage = new LocationPage(driver);
		customerServicePage= new CustomerServicePage(driver);
		rswPage = new RswPage(driver);
	}


	@Given("^I choose to navigate to valid Installed Product$")
	public void I_choose_to_navigate_to_valid_Installed_product() {
		driver.get("https://philipsb2bsc--emsmq3.my.salesforce.com/a2W0L000008JH4K");
		// select installed product from global search or in actual way as of now hitted
		// url
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to launch salesforce application successfully$")
	public void i_launch_to_salesforce_application_successfully() throws InterruptedException {

		basePage.salesforceLogin();
		basePage.embedScreenShotInreport();
	}

	@When("^I choose to login by entering User credentials \"([^\"]*)\"$")
	public void i_enter_credentials_for_user(String userRole) throws InterruptedException {
		basePage.enterCredentials(userRole, driver);
		basePage.embedScreenShotInreport();
	}

	@When("^I choose to click on Configure Product Button$")
	public void click_on_Configure_Product_Button() {
		CreateQuotePage configProduct = new CreateQuotePage(driver);
		configProduct.clickConfigureProduct();
		basePage.embedScreenShotInreport();
	}

	@When("^I choose to Select bundled Product with\"([^\"]*)\" and Configure Product$")
	public void select_bundled_Product_with_and_Configure_Product(String productCode) throws Throwable {
		CreateQuotePage configProduct = new CreateQuotePage(driver);
		configProduct.AddBundeledProducts(productCode);
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to click on GoTo Price Button$")
	public void i_choose_to_click_on_GoTo_Price_Button() throws Throwable {
		CreateQuotePage configProduct = new CreateQuotePage(driver);
		configProduct.clickOnGoToPricing();
		basePage.embedScreenShotInreport();
	}

	@When("^I choose to click on Save on Cart page$")
	public void click_on_Save_on_Cart_page() throws Throwable {
		CreateQuotePage configProduct = new CreateQuotePage(driver);
		configProduct.clickOnEditQuote();
		basePage.embedScreenShotInreport();
	}

	@Then("^Verify that I choose to logout of the application$")
	public void verify_that_I_choose_to_logout_of_the_application() {

	}

	// New Step Definations
	@Given("^I launch ServiceMax application successfully$")
	public void launchApplication() throws InterruptedException {
		basePage.salesforceLogin();
		basePage.embedScreenShotInreport();
	}
//sami
	@Given("^I launch demo crm application successfully$")
	public void launchGoogle() throws InterruptedException {
		basePage.crmHomePage();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();;
		BaseLib.waitTill("10");
		List<WebElement> alltags = driver.findElements(By.tagName("a"));
		int LinkSize = alltags.size();
		System.out.println(LinkSize);
		for(int i=0;i<alltags.size();i++) {
		System.out.println( "All links" + " = " + alltags.get(i).getAttribute("href"));
		System.out.println( "All Text" + " = " +alltags.get(i).getText());
		}
		
		basePage.embedScreenShotInreport();
	}
	
	@Given("^I launch demo asx application successfully for to test webtable$")
	public void i_launch_demo_asx_application_successfully_for_to_test_webtable() throws Throwable {
		basePage.asxHomePage();
		basePage.asxCookiesAccept();
		driver.findElement(By.xpath("//*[@id=\"pnProductNavContents\"]/h5[2]")).click();;
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"home_top_five\"]/div/div[1]/div/div[1]/table/tr"));
		int rowsize = rows.size();
		System.out.println("Total No of Rows" + " " + rowsize);
		//dd
		List<WebElement> columns = driver.findElements(By.xpath("//*[@id=\"home_top_five\"]/div/div[1]/div/div[1]/table/tr[1]/th"));
		int columnsize = columns.size();
		System.out.println("Total No of Columns" + " " + columnsize);
		for(int i = 2; i<rowsize; i++) {
			for(int j = 1; j<columnsize; j++) {
				System.out.println((driver.findElement(By.xpath("//*[@id=\"home_top_five\"]/div/div[1]/div/div[1]/table/tr[" + i + "]/td[" + j + "]"))).getText()+ "  ");	
			}
			System.out.println();
			}
		}
		
	
	@Given("^I launch Informatica application successfully$")
	public void launch_Informatica() throws InterruptedException {
		basePage.informaticaLogin();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to enter credentials for \"([^\"]*)\"$")
	public void enterCredentials(String userRole) {
		basePage.enterCredentials(userRole, driver);
		try {
			WebElement ChangePasswordCancel = driver.findElement(By.xpath("//button[@id='cancel-button']"));
			if(ChangePasswordCancel.isDisplayed()) {
				ChangePasswordCancel.click();
			}			
		}catch (Exception e) {
		}
		basePage.embedScreenShotInreport();

	}

	@When("^I Choose to close all tasks$")
	public void closeAllTasks() {
		System.out.println("Close Tasks");
		basePage.closeAllTasks();

	}

	@Given("^I choose to click on Product on IP page$")
	public void I_choose_to_click_on_product() {
		serviceMaxCaseDetailsPage.clickonProduct();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to verify values of BG and BU on Product Page$")
	public void I_choose_to_verify_BG_BU_on_product_page() {
		serviceMaxCaseDetailsPage.verifyvaluesofBusinessgropuAndUnit();
		basePage.embedScreenShotInreport();
	}

	@When("I choose to create a case of eventType is \"([^\"]*)\" and sub eventType is \"([^\"]*)\"")
	public void I_choose_to_create_a_case(String eventtype, String subeventype) {
		serviceMaxCaseDetailsPage.craete_A_case(eventtype, subeventype);
		basePage.embedScreenShotInreport();
	}

	@When("I choose to check the Sales order Type or WBS")
	public void I_choose_to_check_the_SO_WBS() {
		serviceMaxCaseDetailsPage.check_SO_WBS();
		basePage.embedScreenShotInreport();
	}


	@When("I Choose to Open Case and create safety questionnaire \"([^\"]*)\"")
	public void create_Safety_Questionaire(String yesOrNo) {
		serviceContractPage.create_Safety_Questionaire(yesOrNo);
		basePage.embedScreenShotInreport();
	}

	/*
	 * @When("I Choose to Dispatch Work Order to Technician \"([^\"]*)\"$") public
	 * void dispatch_WorkOrder_Technician(String tech) {
	 * serviceContractPage.dispatch_WorkOrder(tech);
	 * basePage.embedScreenShotInreport(); }
	 */

	@When("I choose to get the WO1")
	public void I_choose_to_get_WO1() {
		serviceMaxCaseDetailsPage.getWO1();
		basePage.embedScreenShotInreport();
	}

	@When("I choose to navigate to WO1")
	public void I_choose_to_navigate_to_WO1() {
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("WO1","https://philipsb2bsc--emsmq3.my.salesforce.com/a3d770000000zZz?srPos=0&srKp=a3d");
		serviceMaxCaseDetailsPage.navigateToWO1();
		basePage.embedScreenShotInreport();
	}

	@When("I choose to verify the Escalation Originated Work order should be unchecked")
	public void I_choose_to_verify_Escalation_originated_work_order() {
		serviceMaxCaseDetailsPage.verifyEscalationOriginatedWOcheckbox();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Initiate Onsite SFM$")
	public void initiate_Onsite_SFM() {
		serviceMaxWorkOrderPage = new WorkOrderPage(driver);
		serviceMaxWorkOrderPage.initiate_Onsite_SFM();
		basePage.embedScreenShotInreport();
	}
	
	@When("^I add WO$")
	public void add_wo() {
		
			AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("WORK_ORDER_NUMBER","WO-04664810");
			AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("CASE_NUMBER","0118613737");
		
	}

	@When("I choose to click on Case created")
	public void I_choose_to_click_on_case_created() {
		serviceMaxCaseDetailsPage.click_on_casCreated();
		basePage.embedScreenShotInreport();
	}

	@When("I choose to create a Escalation case")
	public void I_choose_to_create_a_Escalation_case() {
		serviceMaxCaseDetailsPage.createEscalatecase();
		basePage.embedScreenShotInreport();
	}

	@When("I choose to verify Escalate case created")
	public void I_choose_to_verify_Escalate_case_created() {
		serviceMaxCaseDetailsPage.verifyEscalatecase();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to verify Business group and Business unit$")
	public void I_choose_to_verify_BG_BU() {
		serviceMaxCaseDetailsPage.verifyBusinessgroupAndUnit();
		basePage.embedScreenShotInreport();
	}

	@When("I choose to get the WO2")
	public void I_choose_to_get_WO2() {
		serviceMaxCaseDetailsPage.getWO2();
		basePage.embedScreenShotInreport();
	}

	@When("I choose to navigate to WO2")
	public void I_choose_to_navigate_to_WO2() {
		serviceMaxCaseDetailsPage.navigateToWO2();
		basePage.embedScreenShotInreport();
	}

	@When("I choose to get the WO3")
	public void I_choose_to_get_WO3() {
		serviceMaxCaseDetailsPage.getWO3();
		basePage.embedScreenShotInreport();
	}

	@When("I choose to navigate to WO3")
	public void I_choose_to_navigate_to_WO3() {
		serviceMaxCaseDetailsPage.navigateToWO3();
		basePage.embedScreenShotInreport();
	}

	@When("I choose to navigate to Escalate case created")
	public void I_choose_to_navigate_to_Escalate_case() {
		serviceMaxCaseDetailsPage.navigateEscalatecase();
		basePage.embedScreenShotInreport();
	}

	@When("I choose to Accept Escalate case")
	public void I_choose_to_Accept_Escalate_case() {
		serviceMaxCaseDetailsPage.AcceptEscalatecase();
		basePage.embedScreenShotInreport();
	}

	@When("I choose to create a New Action Request for L2-L3")
	public void I_choose_to_create_a_New_Action_Request() {
		serviceMaxCaseDetailsPage.CreateNewAction();
		basePage.embedScreenShotInreport();
	}

	@When("I choose to Accept Action Request")
	public void I_choose_to_Accept_Action_Request() {
		serviceMaxCaseDetailsPage.AcceptActionRequest();
		basePage.embedScreenShotInreport();
	}

	@When("I choose to verify the Action Request buttons are enabled")
	public void I_choose_to_verify_Action_Request_buttons() {
		serviceMaxCaseDetailsPage.verifyActionRequestEnable();
		basePage.embedScreenShotInreport();
	}

	@Then("^I Choose to verify profile for Logged on user \"([^\"]*)\"$")
	public void verify_profile_For_logged_user(String userRole) {
		basePage.verify_profile_For_logged_user(userRole);
		basePage.embedScreenShotInreport();
	}

	@When("I choose to close Action Request")
	public void I_choose_to_close_Action_Request() {
		serviceMaxCaseDetailsPage.closeActionRequest();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to add Labor and Parts$")
	public void add_Labor_And_Parts() {
		serviceMaxWorkOrderPage.add_Labor_And_Parts();
		basePage.embedScreenShotInreport();
	}

	@When("I choose to create Debrief and follow up")
	public void I_choose_to_create_Debrief_and_followup() {
		serviceMaxCaseDetailsPage.debriefInstallationcase();
		basePage.embedScreenShotInreport();
	}

	@When("I choose to complete work order")
	public void I_choose_to_complete_Work_order() {
		serviceMaxCaseDetailsPage.completeworkorder();
		basePage.embedScreenShotInreport();
	}

	@When("I choose to change the status order to Fixed")
	public void I_choose_to_change_the_status_of_order_to_fixed() {
		serviceMaxCaseDetailsPage.changeorderstatus();
		basePage.embedScreenShotInreport();
	}

	@When("I choose to submit PSF Safety form")
	public void I_choose_to_submit_PSF_Safety_form() {
		serviceMaxCaseDetailsPage.submitPSF_Form();
		basePage.embedScreenShotInreport();
	}

	@When("I choose to update Escalation Details")
	public void I_choose_to_update_Escalation_Details() {
		serviceMaxCaseDetailsPage.updateEscalationDetails();
		basePage.embedScreenShotInreport();
	}

	@When("I choose to Cancel Escalation")
	public void I_choose_to_cancel_Escalation() {
		serviceMaxCaseDetailsPage.cancelEsc();
		basePage.embedScreenShotInreport();
	}

	@When("I choose to verify fields after Escalation Cancel")
	public void I_choose_to_verify_fields_after_cancel_Escalation() {
		serviceMaxCaseDetailsPage.verifyFieldsafterCancellationESc();
		basePage.embedScreenShotInreport();
	}

	@When("I Choose to Create Onsite Work Order SFM for \"([^\"]*)\" hours")
	public void create_Onsite_Workorder(String hours) {
		serviceContractPage.create_Onsite_Workorder(hours);
		basePage.embedScreenShotInreport();

	}

	@When("I Choose to Initiate SWO$")
	public void initiate_SWO() {
		serviceContractPage.initiate_SWO();
		basePage.embedScreenShotInreport();
	}



	@When("I Choose to Create Remote Work Order SFM$")
	public void I_choose_to_create_Remote_work_order_SFM() {
		serviceMaxCaseDetailsPage.create_Remote_Workorder("2");
		basePage.embedScreenShotInreport();
	}

	@When("I choose to Initiate Remote Service")
	public void I_choose_to_Initiate_remote_service() {
		serviceMaxCaseDetailsPage.initiateRemoteServie();
		basePage.embedScreenShotInreport();
	}

	/*
	 * @Then("^I choose to dispatch work item to Technician\"([^\"]*)\"$") public
	 * void i_choose_to_dispatch_work_item_to_technician(String technician) {
	 * serviceContractPage.selectServiceTeam(technician);
	 * basePage.embedScreenShotInreport(); }
	 */

	@Given("^I launch Salesforce application successfully$")
	public void salesforcelaunchApplication() throws InterruptedException {
		basePage.salesforceLogin();
		basePage.embedScreenShotInreport();
	}

	@When("I choose to click on All Tabs")
	public void I_choose_to_click_on_AllTabs() {
		basePage.clickonAllTabs();
		basePage.embedScreenShotInreport();
	}

	@When("I choose to click on CS Portal User Assignment")
	public void I_choose_to_click_on_CS_PortalUser_Assignment() {
		eventPage.clickonCSPortalUserAssignment();
		basePage.embedScreenShotInreport();
	}

	@When("I choose to search portal with \"([^\"]*)\"$")
	public void I_choose_to_search_portal(String portal) {
		eventPage.searchPortal(portal);
		basePage.embedScreenShotInreport();
	}

	@When("I choose to select Exclude/Include IP button and Include \"([^\"]*)\"$")
	public void I_choose_to_select_Exclude_Include_IP_and_Include_IP(String IP) {
		eventPage.IncludeIP(IP);
		basePage.embedScreenShotInreport();
	}

	@When("I choose to Add Super Group")
	public void I_choose_to_addsupergroup() {
		eventPage.Addsupergrp();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to verify the Tabs present on Portal$")
	public void verifyTabs() {
		eventPage.verifyPortalTabs();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to verify Calendar on Homepage$")
	public void verifycalendar() {
		eventPage.verifyCalendar();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to verify Request Support button$")
	public void verifyRequestSupportbtn() {
		eventPage.verifyRequestSupport_btn();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to verify Number of Systems$")
	public void verify_Number_of_system() {
		eventPage.verifyNumberofSystem();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to verify the Service cases updates$")
	public void verify_Servicecases() {
		eventPage.verifyServiceCases();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to click on \"([^\"]*)\"$")
	public void click_on_tab(String tab) {
		eventPage.clickonTab(tab);
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to verify columns and buttons on InstalledProduct Page$")
	public void verify_columns_on_IPPage() {
		eventPage.verifyColumnsonIPpage();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to click on Update Ip Info button$")
	public void click_on_update_Ip_Info_button() {
		eventPage.clickupdateIPinfobtn();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to verify the buttons after navigate UpdateIpinfo Page$")
	public void verify_buttons_on_update_Ip_InfoPage() {
		eventPage.verifybtnsonUpdateInfoIpPage();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to mass update$")
	public void mass_update() {
		eventPage.massupdate();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to search for IP with \"([^\"]*)\"$")
	public void enter_IP(String Ip) {
		eventPage.enterIP(Ip);
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to click on Generate EOL Mail$")
	public void click_on_generate_EOL_Mail() {
		eventPage.generateEOLMail();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to verify Product Details$")
	public void verify_Product_Details() {
		eventPage.verifyProductDetails();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to Add or change IP Details$")
	public void add_or_change_IP_Details() {
		eventPage.add_changeIPDetails();
		basePage.embedScreenShotInreport();
	}

	@When("I choose to click on Account Assignment")
	public void I_choose_to_click_on_Account_Assignment() {
		eventPage.clickonAccountAssignment();
		basePage.embedScreenShotInreport();
	}

	@When("I choose to create a Assignment with a \"([^\"]*)\"$")
	public void I_choose_to_create_a_Assignment(String recordtype) {
		eventPage.createAssignment(recordtype);
		basePage.embedScreenShotInreport();
	}

	@When("I choose to create a Group with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void I_choose_to_create_a_group(String grouptype, String country) {
		EventPage ep = new EventPage(driver);
		ep.creategroup(grouptype, country);
		basePage.embedScreenShotInreport();
	}

	@When("I choose to click on Add Child")
	public void I_choose_to_click_on_Add_Child() {
		eventPage.clickonaddchild();
		basePage.embedScreenShotInreport();
	}

	@When("I choose to add New Account Assignment with \"([^\"]*)\"$")
	public void I_choose_to_add_New_Account(String Accountname) {
		eventPage.addAccount(Accountname);
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to enter credentials in servicemax Application for \"([^\"]*)\"$")
	public void enterCredentialsServicemax(String userRole) {
		eventPage.enterServicemaxCredentials(userRole, driver);
		basePage.embedScreenShotInreport();
	}

	@Given("^I launch ServicePortal application successfully$")
	public void servicelaunchApplication() {
		eventPage.servicePortalLogin();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to click on Export button$")
	public void click_on_export_button() {
		eventPage.clickonExportbtn();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to select the columns and submit$")
	public void choose_to_select_column_checkbox() throws AWTException {
		eventPage.selectcolumncheckbox();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to verify whether file is downloaded successfully$")
	public void choose_to_verify_whether_file_is_downloaded_successfully() throws IOException {
		eventPage.verifyFiledownloadedSuccessfully();
		basePage.embedScreenShotInreport();

	}

	@Given("^I choose to click on Planned Visit Tab and verify fields$")
	public void choose_to_click_on_Planned_visit_tab() {
		eventPage.PlannedVisitTab();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to click on SLCP Tab$")
	public void choose_to_click_on_SLCP_tab() {
		eventPage.SLCPTab();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to verify fields under SLCP Tab$")
	public void choose_to_verify_fields_under_SLCP_Tab() {
		eventPage.verifySLCPTab();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to click on Request Support Btn with value \"([^\"]*)\"$")
	public void choose_to_click_on_Request_support_btn_with_dropdown_value(String value) {
		eventPage.clickRSButtonwithvalue(value);
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to select create a case$")
	public void i_choose_to_select_create_a_case() throws Throwable {
		eventPage.clickCreateCaseButton();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to verify auto Populated fields$")
	public void choose_to_verify_auto_populated_fields() {
		eventPage.verifyautoPopulatedfields();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to click on priority dropdown and validate values$")
	public void choose_to_click_on_priority_drpdown_and_validate_values() {
		eventPage.clickonPriorityandValidatevalues();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to click on Select an IP to create case button$")
	public void choose_to_click_on_select_IP_to_create_case_btn() {
		eventPage.clickoncreateACase();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to click on any IP$")
	public void choose_to_click_on_any_IP() {
		eventPage.clickonAnyIP();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to select no for given question$")
	public void choose_to_select_no_for_given_question() {
		eventPage.selectnoforQuestion();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to select Type of Service \"([^\"]*)\"$")
	public void choose_to_select_typeof_service(String typeofservice) {
		eventPage.selectTypeofService(typeofservice);
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to verify fields in Contact Information section$")
	public void choose_to_verify_fields_in_contact_infrormation_section() {
		eventPage.verifyFieldsinContactInfoSection();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to verify Manage Additional Contact button$")
	public void choose_to_verify_Manage_additional_contact_btn() {
		eventPage.verifymanageAdditionalcontactbtn();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to select mandatory fields to create a case$")
	public void choose_to_select_mandatory_fields_to_create_a_case() {
		eventPage.entercasedetails();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to verify fields under Case Details Section$")
	public void choose_to_verify_fields_under_case_details_section() {
		eventPage.verifyfieldsUnderCaseDetailsSection();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to verify fields under Installed Product Section$")
	public void choose_to_verify_fields_under_IP_section() {
		eventPage.verifyfieldsUnderIPSectiononCasePage();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to click on Add Case Activity button$")
	public void choose_to_click_on_Add_case_activity_btn() {
		eventPage.clickAddCaseActivitybtn();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to enter mandatory fields to create activity$")
	public void choose_to_enter_mandatory_fields_to_create_activity() {
		eventPage.createCaseActivity();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose verify PHI Checkbox is selected or not$")
	public void choose_to_verify_PHI_checkbox_is_selected_or_not() {
		eventPage.verifyPHICheckbox();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to search casenumber in globalsearch$")
	public void choose_to_search_caseNumber() {
		eventPage.searchCaseNumber();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to verify Fields under Account List View$")
	public void choose_to_verify_fields_under_Accountlistview() {
		eventPage.verifyAccountfields();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to select an Account$")
	public void choose_to_select_an_account() {
		eventPage.selectAccount();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to validate Related Items$")
	public void choose_to_verify_Related_items() {
		eventPage.validateRelatedItem();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to validate Related Tabs For Account$")
	public void choose_to_verify_Related_Tabs_for_Account() {
		eventPage.validateRelatedTabForAccounts();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to select the Priority \"([^\"]*)\"$")
	public void choose_to_select_Priority(String type) {
		eventPage.selectPriority(type);
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to validate fields Under LocationTab$")
	public void choose_to_verify_fields_under_Location_Tab() {
		eventPage.validateLocationfields();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to select an Location \"([^\"]*)\"$")
	public void choose_to_select_Location(String Location) {
		eventPage.selectLocation(Location);
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to validate fields under Location Details Page$")
	public void choose_to_verify_fields_under_Location_Details_Page() {
		eventPage.verifyLocationLabel();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to validate Related Tabs$")
	public void choose_to_verify_Related_Tabs() {
		eventPage.validateRelatedTab();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to verify Fields under Contract Page$")
	public void choose_to_verify_fields_under_Contract_Details_Page() {
		eventPage.validateContractsfields();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to select a Contract$")
	public void choose_to_select_a_contract() {
		eventPage.selectContract();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to validate labels on ContractPage$")
	public void choose_to_validate_labels_on_contractPage() {
		eventPage.validatelabelsonContractPage();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to select \"([^\"]*)\" from More dropdown$")
	public void choose_to_select_from_More_dropdown(String contactus) {
		eventPage.selectMoredropdown(contactus);
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to click on contact customer service button$")
	public void choose_to_click_on_contact_customer_service_button() {
		eventPage.clickon_contactCustomerservicebtn();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to click on Next button$")
	public void choose_to_click_on_next_button() {
		eventPage.nextbtn();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to click on submit button$")
	public void choose_to_click_on_submit_button() {
		eventPage.submitbtn();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose click on Profile \"([^\"]*)\" and select \"([^\"]*)\"$")
	public void choose_to_click_on_Profile_name(String profilename, String myprofile) {
		eventPage.ClickonProfileName(profilename, myprofile);
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to validate fields present on My profile details Page$")
	public void choose_to_validate_fields_present_on_my_profile_details_page() {
		eventPage.validateFieldsunderMyprofiledetailsPage();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to verify Change Password Fields$")
	public void choose_to_verify_change_password_fields() {
		eventPage.validatechangePasswordfields();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to search in Global search of Portal with \"([^\"]*)\"$")
	public void choose_to_search_in_global_search_of_portal_with_accountname(String AccName) {
		eventPage.portalGlobalsearch(AccName);
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to verify filter under case tab$")
	public void choose_to_verify_filter_under_case_tab() {
		eventPage.validatecasesfilter();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to verify fields Under case tab$")
	public void choose_to_verify_fields_under_case_tab() {
		eventPage.validatecasesfields();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to validate the fields under DocumentsTab$")
	public void choose_to_verify_fields_under_document_tab() {
		eventPage.validatefieldsUnderDocumentTab();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to fill the Mandatory fields under DocumentTab with \"([^\"]*)\"$")
	public void choose_to_fill_the_mandatory_fileds_under_document_tab(String accountName) {
		eventPage.fillfieldsUnderDocumentTab(accountName);
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to select checkboxes and download a file$")
	public void choose_to_select_checkbox_and_download() {
		eventPage.downloadfile();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to select a \"([^\"]*)\" have a file more than 10MB and download$")
	public void choose_to_select_a_case_more_than_10mb(String casenumber) {
		eventPage.selectcaseNumbermorethan10MB(casenumber);
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to verify the error of download$")
	public void choose_to_verify_the_error_of_download() {
		eventPage.error_download();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to select the \"([^\"]*)\" from Reports dropdown$")
	public void choose_to_select_report_drop_value(String value) {
		eventPage.selectReportdropdown(value);
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to select All Folders$")
	public void choose_to_select_All_folders() {
		eventPage.selectAllFolders();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to select a Record$")
	public void choose_to_select_a_record() {
		eventPage.select_a_record();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to verify the columns of the record$")
	public void choose_to_verify_columns_of_a_record() {
		eventPage.verifyRecordcolumns();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to get contract Details Page the created \"([^\"]*)\"$")
	public void i_choose_to_get_contractdetailpage(String sheetname) throws Throwable {
		ServiceContractPage sp = new ServiceContractPage(driver);
		sp.getContractHeaderurl(sheetname);
	}

	@Then("^I choose to Active the PM Plan$")
	public void i_choose_to_active_PM_plan() throws Throwable {
		ServiceContractPage sp = new ServiceContractPage(driver);
		sp.activePMPLan();
	}

	@When("^I Choose to Search \"([^\"]*)\" using global search box$")
	public void I_Choose_to_Search_using_global_search_box(String contract) {
		basePage.search_GlobalsearchBox(contract);
		basePage.embedScreenShotInreport();
	}

	@When("I Choose to Open \"([^\"]*)\" Installed Product Detail page and verify Account$")
	public void verifyAccount(String InstalledIP) {
		installedProduct.open_Record_Verify_Data(InstalledIP);
	}

	@Given("^I choose to complete Parts Ordering with \"([^\"]*)\"$")
	public void choose_to_complete_parts_ordering(String PO) {
		eventPage.partsordering(PO);
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to receive the Parts$")
	public void i_choose_to_receiveparts() throws Throwable {
		serviceContractPage.Receivepart();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to confirm open labors Returnable \"([^\"]*)\"$")
	public void confirm_open_labor_returnable(String pc) {
		serviceMaxWorkOrderPage.openPartsReturnable(pc);
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to click on Account$")
	public void i_choose_to_click_on_account() throws Throwable {
		basePage.clickonAccount();
	}

	@Then("^I choose to Create New Contract Header$")
	public void i_choose_to_create_new_contract_header() throws Throwable {
		serviceContractPage.createNewContractHeader();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to Create Contract with \"([^\"]*)\"$")
	public void i_choose_to_create_contract(String bp) throws Throwable {
		serviceContractPage.createContract(bp);
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to enter Total and SAP Contract price \"([^\"]*)\" \"([^\"]*)\"$")
	public void i_choose_to_enter_total_and_SAP_contract_price(String tcp, String scp) throws Throwable {
		serviceContractPage.editcontractprice(tcp, scp);
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to Edit Coverage with \"([^\"]*)\"$")
	public void i_choose_to_edit_coverage(String ip) throws Throwable {
		serviceContractPage.editcoverage(ip);
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify Billing Plan Type and Inadvance$")
	public void i_choose_to_verify_billingplan_and_inadavnce() throws Throwable {
		serviceContractPage.verifyBillingplanandInAdvance();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify the date rule error when Billing plan type is Periodic and date rules are empty$")
	public void i_choose_to_verify_date_rule_error_when_billingplan_type_is_periodic_and_date_rules_are_empty()
			throws Throwable {
		serviceContractPage.verifyBillingplanPeriodicError();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to change the Billing Plan Type to Milestone and verify the Error of date rule$")
	public void i_choose_to_verify_date_rule_error_when_billingplan_type_is_milestone_and_date_rules_are_empty()
			throws Throwable {
		serviceContractPage.changebillingplantypenadVerify();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to click on Send To SAP$")
	public void i_choose_to_click_on_send_to_SAP() throws Throwable {
		serviceContractPage.sendtoSAP();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to create New Billing plan Line$")
	public void i_choose_to_create_new_billing_plan_line() throws Throwable {
		serviceContractPage.newnewBillingplanline();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to click on Active contract$")
	public void i_choose_to_click_on_active_contract() throws Throwable {
		serviceContractPage.activeContract();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to change the Contract by updating SAP Condition Price$")
	public void i_choose_to_change_contract() throws Throwable {
		serviceContractPage.changecontract();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify whether Work order and cases got created under PMPlan$")
	public void i_choose_to_verify_WO_and_cases() throws Throwable {
		serviceContractPage.PMPlanWO_cases();
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to create new case with\"([^\"]*)\"and\"([^\"]*)\"and\"([^\"]*)\" with contact \"([^\"]*)\"$")
	public void i_choose_to_create_new_case_withandand_with_contact(String eventype, String prioritytype, String ip,
			String contact) throws Throwable {
		serviceContractPage.createCase(eventype, prioritytype, ip, contact);
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify the PSE should unchecked on case detailpage$")
	public void i_choose_to_verify_PSE() throws Throwable {
		serviceContractPage.verifyPSEchecbox();
		basePage.embedScreenShotInreport();
	}

	@Then("^I Choose to Open Case Detail Page$")
	public void i_choose_to_open_case_detail_page() throws Throwable {
		serviceContractPage.casedetailspage();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify the Service Maintenance Contarct Field should not get populated with value$")
	public void i_choose_to_verify_service_contract_field_should_not_get_populated_with_value() throws Throwable {
		serviceContractPage.servicecontractnotPopulated();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to Request Quote$")
	public void i_choose_to_request_quote() throws Throwable {
		serviceContractPage.requestQuote();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to add Labors$")
	public void i_choose_to_add_labors() throws Throwable {
		serviceContractPage.addlabor();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to Edit the quote and make status to draft$")
	public void i_choose_to_make_status_to_draft() throws Throwable {
		serviceContractPage.editquote();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to Release quote$")
	public void i_choose_to_release_quote() throws Throwable {
		serviceContractPage.releasequote();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to Accept quote$")
	public void i_choose_to_accept_quote() throws Throwable {
		serviceContractPage.acceptquote();
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to Create Remote work order$")
	public void i_choose_to_create_remote_work_order() throws Throwable {
		serviceContractPage.create_Remote_Workorder();
		basePage.embedScreenShotInreport();
	}

	@When("I Choose to Open \"([^\"]*)\" Service Maintenance Contract Detail page and verify SAP External ID for \"([^\"]*)\"$")
	public void open_Record_Verify_Data(String contract, String userRole) {
		serviceContractPage.open_Record_Verify_Data(contract, userRole);
		basePage.embedScreenShotInreport();
	}

	@Then("^I Choose to log out of the application$")
	public void logOut() {
		basePage.embedScreenShotInreport();
		basePage.logOut();
	}

	@Then("^I Choose to verify the values in Included services section$")
	public void i_choose_to_verify_values_in_Included_services_section() throws Throwable {
		installedProduct.verifyincludedservicessection();
		basePage.embedScreenShotInreport();
	}

	@When("I Choose to Verify whether a record with Installed Product is displayed$")
	public void verify_Record_with_Installed_Product() {
		serviceContractPage.verify_Installed_product();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to get the values from installed product$")
	public void i_choose_to_get_values_from_ip() throws Throwable {
		installedProduct.getipvalues();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Search Work Order using global search box$")
	public void search_work_order_using_globalsearch() {
		serviceMaxWorkOrderPage.searchworkorder();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to open Work Order Line items and save record$")
	public void open_Work_OrderLine_Item() {
		serviceMaxWorkOrderPage.open_Work_OrderLine_Item();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to get the warranty and the template$")
	public void i_choose_to_get_warranty_and_template() throws Throwable {
		installedProduct.selectwarranty_template();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify the task template and execution value$")
	public void i_choose_to_verify_tasktemplate_and_executiontype() throws Throwable {
		installedProduct.verifytasktemplate();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to navigate back to ip$")
	public void i_choose_to_navigate_toip() throws Throwable {
		installedProduct.navigatetoipurl();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to create new applicable product$")
	public void i_choose_to_create_new_applicable_product() throws Throwable {
		installedProduct.createNewapplicableproduct();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose get the url details and save$")
	public void i_choose_to_get_url_details() throws Throwable {
		installedProduct.getUrldetails();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify the ip status date installed$")
	public void i_choose_to_verify_ipstatus_dateinstalled() throws Throwable {
		installedProduct.verifyipstatus();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to select the product from ip$")
	public void i_choose_to_select_product_fromip() throws Throwable {
		installedProduct.selectproduct();
		basePage.embedScreenShotInreport();
	}

	@Then("^I Choose to open PM plan in preventive maintenance list$")
	public void i_choose_to_open_pmplan() throws Throwable {
		installedProduct.verifyandopenpmplan();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to select the first record from WO Schedule$")
	public void i_choose_to_select_firsr_wo_record() throws Throwable {
		installedProduct.selectfirstworecord();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify the values displaying correctly$")
	public void i_choose_to_verify_values_displaying_correctly() throws Throwable {
		installedProduct.verifypivaluesinpmplan();
		basePage.embedScreenShotInreport();
	}

	@Then("I choose to fetch the url from sheet \"([^\"]*)\"$")
	public void I_choose_to_fetch_the_url_from_sheet(String sheetName) {
		installedProduct.fetchAgreementUrlfromSheet(sheetName);
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to navigate to productwarranty form ip \"([^\"]*)\"$")
	public void i_choose_to_navigate_to_product_warranty(String sheet) throws Throwable {
		installedProduct.navigatetoproductwarranty(sheet);
		basePage.embedScreenShotInreport();
	}

	@Then("^I Choose to verify PM plan start date and the fields$")
	public void i_choose_to_verify_plan_startdate_fields() throws Throwable {
		installedProduct.verifypmplanfields();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to navigate to account from PM plan$")
	public void i_choose_to_navigate_account_from_pmplan() throws Throwable {
		installedProduct.navigatetoaccount();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to navigate back to PM plan$")
	public void i_choose_to_navigate_back_to_pmplan() throws Throwable {
		installedProduct.navigatetourl();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to select the created contacted in above step$")
	public void i_choose_to_select_created_contacted() throws Throwable {
		installedProduct.selectcontactinpmplan();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify schedule and maintenance coverages$")
	public void i_choose_to_verify_schedule_maintenance_coverages() throws Throwable {
		installedProduct.verifyscheduleandmiantenance();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to open the template from global search$")
	public void i_choose_to__open_pmtemplate_frm_globalsearch() throws Throwable {
		installedProduct.opentemplateingloablsearc();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to select Manage Preventive Maintainance PM Template$")
	public void i_choose_to__select_manage_PM_template() throws Throwable {
		installedProduct.managePMTemplatewizard();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify PM frequency and grace field editable$")
	public void i_choose_to__verify_fields_are_editable() throws Throwable {
		installedProduct.managePMTemplatewizard();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify PM Frequency corresponding grace period$")
	public void i_choose_to__verify_PMFrequency_graceperiod_values() throws Throwable {
		installedProduct.verifypmfreqandgraceperiod();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to update due date with past and save$")
	public void i_choose_to_update_duedate_with_past() throws Throwable {
		installedProduct.updateduedatepast();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify the updated values displaying$")
	public void i_choose_to_verify_updated_dates() throws Throwable {
		installedProduct.verifyupdateddatevalues();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to slect the record from PM schedule definition$")
	public void i_choose_to_select_record_in_pmschedule_definition() throws Throwable {
		installedProduct.selectPMScheduleDefrecord();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify values updated from PM schedule$")
	public void i_choose_to_verify_values_updated_frm_pmschedule() throws Throwable {
		installedProduct.verifyPMScheduleDefValues();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to select the first record from PM Schedule$")
	public void i_choose_to_select_firsr_record() throws Throwable {
		installedProduct.selectfirstschedulerecord();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to navigate to productwarranty$")
	public void i_choose_to_navigate_back_to_productwarranty() throws Throwable {
		installedProduct.navigatetourl();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to update due date with future and save$")
	public void i_choose_to_update_duedate_with_future() throws Throwable {
		installedProduct.updateduedatefuture();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify the validation error message$")
	public void i_choose_to_verify_validation_error_messgae() throws Throwable {
		installedProduct.verifyvalidationforfuturedate();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify the PM plan status is blank$")
	public void i_choose_to_verify_pm_plan_status() throws Throwable {
		installedProduct.verifypmstatus();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to click PM proposal in PM plan$")
	public void i_choose_to_click_pmproposal_PM_plan() throws Throwable {
		installedProduct.clickCreatePMProposal();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to enter mandatory details and submit$")
	public void i_choose_to_enter_mandatory_details() throws Throwable {
		installedProduct.enter_detailspmproposal();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify CFD generated in notes section$")
	public void i_choose_to_verify_cfd_generated() throws Throwable {
		installedProduct.verifyvalidationforfuturedate();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to Activate PM plan on PM plan page$")
	public void i_choose_to_activate_pmplan() throws Throwable {
		installedProduct.activatePMPlan();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify the status is changed to active$")
	public void i_choose_to_verify_status_changedto_active() throws Throwable {
		installedProduct.verifyactivestatus();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to create contact and save from account$")
	public void i_choose_to_create_contact_from_account() throws Throwable {
		accountsPage.createcontact_foraccount();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify PM Schedule is created$")
	public void i_choose_to_verify_pmschedule_and_create() throws Throwable {
		installedProduct.verifypmschedule();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to update \"([^\"]*)\" Name for Staging$")
	public void i_choose_to_update_Name_for_Staging(String arg1) throws Throwable {
		installedProduct.updateFunctionalLocation(arg1);
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to Rewoke \"([^\"]*)\" Name for Processing$")
	public void i_choose_to_Rewoke_Name_for_Processing(String arg1) throws Throwable {
		installedProduct.revokeFunctionalLocation(arg1);
		basePage.embedScreenShotInreport();
	}

	@When("^I choose to access \"([^\"]*)\" tab$")
	public void choose_to_access_tab(String value) 
	{
		//LeanFTPage.stagerecords();
		basePage.accessTab(value);
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to update the \"([^\"]*)\" Filter details$")
	public void i_choose_to_update_the_Filter_details(String arg1) throws Throwable {
		installedProduct.updateFilterDetails(arg1);
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to perform force update for \"([^\"]*)\"$")
	public void i_choose_to_perform_force_update_for(String arg1) throws Throwable {
		installedProduct.forceUpdate(arg1);
		if(arg1.equals("Equipment1"))
		{
			installedProduct.selectrowIteminListview();
		}
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to select all IPs and click process IP$")
	public void i_choose_to_select_all_IPs_and_click_process_IP() throws Throwable {
		installedProduct.processIPs();
		basePage.embedScreenShotInreport();
	}

	@Given("^I choose to verify \"([^\"]*)\" Details after IP Processing$")
	public void i_choose_to_verify_Details_after_IP_Processing(String arg1) throws Throwable {
		installedProduct.VerifyProcessesedIP(arg1);
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to select the IP$")
	public void i_choose_to_select_the_ip() throws Throwable {
		installedProduct.select_IP();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to update\"([^\"]*)\"\"([^\"]*)\"and\"([^\"]*)\"$")
	public void i_choose_to_update(String status, String location, String account) throws Throwable {
		installedProduct.update_IP(status, location, account);
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to get Account Number$")
	public void i_choose_to_get_account_number() throws Throwable {
		installedProduct.getAccountNumber();
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to select view customer Information$")
	public void i_choose_to_select_view_customer_information() throws Throwable {
		installedProduct.select_customerInfo();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify the equipment created in SAP$")
	public void i_choose_to_verify_the_equipment_created_in_sap() throws Throwable {
		installedProduct.select_SAPIP();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify Ip child records$")
	public void i_choose_to_verify_ip_child_records() throws Throwable {
		installedProduct.verify_childRecords();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to update Vendor details and Save$")
	public void i_choose_to_update_vendor_details_and_save() throws Throwable {
		installedProduct.updateVendor_details();
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to select Installation product$")
	public void i_choose_to_select_installation_product() throws Throwable {
		installedProduct.products_link();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify Sales order Number\"([^\"]*)\"$")
	public void i_choose_to_verify_sales_order_number(String salesorder) throws Throwable {
		installedProduct.verify_salesOrder(salesorder);
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify Salesdocument ID\"([^\"]*)\"$")
	public void i_choose_to_verify_salesdocument_id(String salesdoc) throws Throwable {
		installedProduct.verifySales_documentID(salesdoc);
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to select System Information$")
	public void i_choose_to_select_system_information() throws Throwable {
		installedProduct.select_systemInfo();
		basePage.embedScreenShotInreport();
	}

	@When("I Choose to Create \"([^\"]*)\" Work Order SFM$")
	public void create_Workorder(String woType) {
		workOrderPage.create_Workorder(woType, "2");
		basePage.embedScreenShotInreport();
	}

	@When("I choose to verify WO updates$")
	public void update_and_verify_Workorder() {
		workOrderPage.verifyWOUpdate();
		basePage.embedScreenShotInreport();
	}

	@When("I Choose to Create Clinical Onsite Work Order SFM$")
	public void create_Clinical_Onsite_Workorder() {
		serviceContractPage.create_Clinical_Onsite_Workorder("2");
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify the swo and Order status$")
	public void i_choose_to_verify_the_swo_and_order_status() throws Throwable {
		installedProduct.swo_orderStatus();
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to select check sales types$")
	public void i_choose_to_select_check_sales_types() throws Throwable {
		installedProduct.select_checksalesOrder();
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to get the URL$")
	public void i_choose_to_get_the_url() throws Throwable {
		installedProduct.getURL();
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to access above URL$")
	public void i_choose_to_access_above_url() throws Throwable {
		installedProduct.accessURL();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Create Onsite Work Order with Indenet Installation$")
	public void i_choose_to_create_onsite_work_order_with_indenet_installation() throws Throwable {
		installedProduct.createWorkorderIndenet();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify the Error$")
	public void i_choose_to_verify_the_error() throws Throwable {
		installedProduct.verify_error();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to enter\"([^\"]*)\"and save$")
	public void i_choose_to_entersomethingand_save(String salesdoc) throws Throwable {
		installedProduct.enterSalesNumber(salesdoc);
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Create Onsite Work Order with Indent and\"([^\"]*)\"$")
	public void i_choose_to_create_onsite_work_order_with_indent_and(String salesdoc) throws Throwable {
		installedProduct.onsite_salesdoc(salesdoc);
		basePage.embedScreenShotInreport();
	}

	@When("I Choose to Create Onsite Work Order SFM$")
	public void create_Onsite_Workorder() {
		serviceContractPage.create_Onsite_Workorder("2");
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify Product is ZSID$")
	public void i_choose_to_verify_product_is_zsid() throws Throwable {
		installedProduct.select_IPproduct();
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to create new case with\"([^\"]*)\"and\"([^\"]*)\"and contact\"([^\"]*)\"$")
	public void i_choose_to_create_new_case_withandand_contact(String eventype, String prioritytype, String contact)
			throws Throwable {
		serviceContractPage.createCasewithContact(eventype, prioritytype, contact);
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to get Case number$")
	public void i_choose_to_get_case_number() throws Throwable {
		serviceMaxWorkOrderPage.getCase();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to add Parts and verify$")
	public void i_choose_to_add_parts_and_verify() throws Throwable {
		serviceContractPage.select_partsordering();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify SAP SWO$")
	public void i_choose_to_verify_sap_swo() throws Throwable {
		serviceContractPage.verify_SAPswo();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify SAP document shipped to Work order$")
	public void i_choose_to_verify_sap_document_shipped_to_work_order() throws Throwable {
		serviceMaxWorkOrderPage.verify_WorkOrderSAp();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose Labour parts to\"([^\"]*)\"$")
	public void i_choose_labour_parts_to(String deliver) throws Throwable {
		serviceMaxWorkOrderPage.selectLabourDeliver(deliver);
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to open parts for non returnable$")
	public void i_choose_to_open_parts_for_non_returnable() throws Throwable {
		serviceMaxWorkOrderPage.opne_Partsnonreturnable();
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to open parts returnable\"([^\"]*)\"and\"([^\"]*)\"$")
	public void i_choose_to_open_parts_returnableand(String consume, String rml) throws Throwable {
		serviceMaxWorkOrderPage.parts_Returnable(consume, rml);
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to select Record tool as not required$")
	public void i_choose_to_select_record_tool_as_not_required() throws Throwable {
		serviceMaxWorkOrderPage.recordTool();
		basePage.embedScreenShotInreport();
	}

	@When("^I choose to Initiate Travel SFM$")
	public void i_choose_to_initiate_travel_sfm() throws Throwable {
		serviceMaxWorkOrderPage.initiateTravelSFM();
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to add Labour without Overlap$")
	public void i_choose_to_add_labour_without_overlap() throws Throwable {
		serviceMaxWorkOrderPage.add_Labor_And_PartswithoutOverlap();
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to Debrief work oder and follow up$")
	public void i_choose_to_debrief_work_oder_and_follow_up() throws Throwable {
		serviceMaxWorkOrderPage.debrief_and_FollowUp();
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to navigate to case Number$")
	public void i_choose_to_navigate_to_case_number() throws Throwable {
		serviceMaxWorkOrderPage.navigateTocase();
		basePage.embedScreenShotInreport();
	}

	@And("^I choose select Create case activity$")
	public void i_choose_select_create_case_activity() throws Throwable {
		serviceMaxWorkOrderPage.select_caseActivity();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify Type values and Update$")
	public void i_choose_to_verify_type_values_and_update() throws Throwable {
		serviceMaxWorkOrderPage.verifyType_update();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify the created Case Activites$")
	public void i_choose_to_verify_the_created_case_activites() throws Throwable {
		serviceMaxWorkOrderPage.verifyCaseActivities();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify encripted PHI data$")
	public void i_choose_to_verify_encripted_phi_data() throws Throwable {
		serviceMaxWorkOrderPage.verifyPHI();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify Create case acitvity is disabled$")
	public void i_choose_to_verify_create_case_acitvity_is_disabled() throws Throwable {
		serviceMaxWorkOrderPage.verify_caseActivitydiabled();
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to select case\"([^\"]*)\"$")
	public void i_choose_to_select_case(String casevalue) throws Throwable {
		serviceMaxWorkOrderPage.selectCase(casevalue);
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to get the above created Work order$")
	public void i_choose_to_get_the_above_created_work_order() throws Throwable {
		serviceContractPage.searchWorkOrder();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to get created Work order Number\"([^\"]*)\"\"([^\"]*)\"$")
	public void i_choose_to_get_created_work_order_number(String testdata, String technicianuser) throws Throwable {
		serviceContractPage.setcreatedWorkOrder(testdata, technicianuser);
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to select the WorkLine created in above work order$")
	public void i_choose_to_select_the_workline_created_in_above_work_order() throws Throwable {
		serviceContractPage.selectWorkLine();
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to get the created Work order\"([^\"]*)\"\"([^\"]*)\"$")
	public void i_choose_to_get_the_created_work_order(String testdata, int worow) throws Throwable {
		serviceContractPage.getCreatedWorkOrder(testdata, worow);
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to cancel work line and Save$")
	public void i_choose_to_cancel_work_line_and_save() throws Throwable {
		serviceContractPage.cancelWorkLine();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify the status$")
	public void i_choose_to_verify_the_status() throws Throwable {
		serviceContractPage.verifyStatus();
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to navigate to Time sheet page$")
	public void i_choose_to_navigate_to_time_sheet_page() throws Throwable {
		serviceContractPage.gotoTimeSheet();
		serviceContractPage.selecttimeSheetLInk();
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to select Timesheet$")
	public void i_choose_to_select_timesheet() throws Throwable {
		serviceContractPage.selectTimeSheet();
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to select required time sheet\"([^\"]*)\"$")
	public void i_choose_to_select_required_time_sheet(String status) throws Throwable {
		serviceContractPage.selecttimelinkbyStatus(status);
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify above deleted work line$")
	public void i_choose_to_verify_above_deleted_work_line() throws Throwable {
		serviceContractPage.verifyCancelledworkline();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify SAP responses on Timesheet$")
	public void i_choose_to_verify_sap_responses_on_timesheet() throws Throwable {
		serviceContractPage.verifySAPErrorandMessage();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to delete Functional location and Save$")
	public void i_choose_to_delete_functional_location_and_save() throws Throwable {
		installedProduct.delete_FunctionLocation();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to add Functional location and Save$")
	public void i_choose_to_add_functional_location_and_save() throws Throwable {
		installedProduct.add_FunctionalLocation();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify Safety question$")
	public void i_choose_to_verify_safety_question() throws Throwable {
		serviceMaxWorkOrderPage.verifySafetyQuestions();
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to update CA to pickedUP$")
	public void i_choose_to_update_ca_to_pickedup() throws Throwable {
		serviceMaxWorkOrderPage.verify_safetyQuestionCA();
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to Escalate stakeholder Info$")
	public void i_choose_to_escalate_stakeholder_info() throws Throwable {
		serviceMaxWorkOrderPage.escalationUpdate();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to veify WO is in Ready to Fix state$")
	public void i_choose_to_veify_wo_is_in_ready_to_fix_state() throws Throwable {
		installedProduct.verify_WOStatus();
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to generate \"([^\"]*)\" customer service report$")
	public void i_choose_to_generate_customer_service_report(String reportType) throws Throwable {
		serviceMaxWorkOrderPage.generate_report(reportType);
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to complete the Work order$")
	public void i_choose_to_complete_the_work_order() throws Throwable {
		serviceMaxWorkOrderPage.complete_WO();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to update WO as Fixed$")
	public void i_choose_to_update_wo_as_fixed() throws Throwable {
		installedProduct.updaeWO();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to get the work line details\"([^\"]*)\"$")
	public void i_choose_to_get_the_work_line_detailssomething(String workdata) throws Throwable {
		serviceContractPage.getworkListNumber(workdata);
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to select Non Work order link$")
	public void i_choose_to_select_non_work_order_link() throws Throwable {
		serviceContractPage.selectNonWorkOrder();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to create Non work order\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
	public void i_choose_to_create_non_work_order(String country, String event, String subject, String technician)
			throws Throwable {

		serviceContractPage.createAndSaveNonWO(country, event, subject, technician);
		basePage.embedScreenShotInreport();
		serviceContractPage.closeTab();
	}

	@And("^I choose to get the created Non work order link\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
	public void i_choose_to_get_the_created_non_work_order_link(String nontestdata, String subject,
			String technicianuser) throws Throwable {
		serviceContractPage.getcreatedNonworkOrderUrl(nontestdata, subject, technicianuser);
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to select Manage Daily hours$")
	public void i_choose_to_select_manage_daily_hours() throws Throwable {
		serviceContractPage.selecttimedailysheet();
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to Enter the time and save\"([^\"]*)\"\"([^\"]*)\"$")
	public void i_choose_to_enter_the_time_and_save(String activity, String duration) throws Throwable {
		serviceContractPage.Entermoretime(activity, duration);
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to select icon Under SFM$")
	public void i_choose_to_select_icon_under_sfm() throws Throwable {
		serviceContractPage.selectplusIcon();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to submit the Time sheet$")
	public void i_choose_to_submit_the_time_sheet() throws Throwable {
		serviceContractPage.submitTimesheet();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify Eligible for CATS checkbox$")
	public void i_choose_to_verify_eligible_for_cats_checkbox() throws Throwable {
		serviceContractPage.verifyCATScheckbox();
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to navigate for Timesheet Object$")
	public void i_choose_to_navigate_for_timesheet_object() throws Throwable {
		serviceContractPage.navigatetoTimeSheet();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify the timesheets available$")
	public void i_choose_to_verify_the_timesheets_available() throws Throwable {
		serviceContractPage.listOfTimesheets();
		basePage.embedScreenShotInreport();
	}

	@And("^I choose get the Timesheet Number$")
	public void i_choose_get_the_timesheet_number() throws Throwable {
		serviceContractPage.get_TimesheetNumer();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify permission set and profile$")
	public void i_choose_to_verify_permission_set_and_profile() throws Throwable {
		serviceContractPage.verifyProfileandPermission();
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to navigate for Advanced user details$")
	public void i_choose_to_navigate_for_advanced_user_details() throws Throwable {
		serviceContractPage.selectUseradvanced();
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to navigate back to Home page$")
	public void i_choose_to_navigate_back_to_home_page() throws Throwable {
		serviceContractPage.navigateHome();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify Overlap checkbox$")
	public void i_choose_to_verify_overlap_checkbox() throws Throwable {
		serviceContractPage.overlapcheckboxunchecked();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify work details are present with non overlap$")
	public void i_choose_to_verify_work_details_are_present_with_non_overlap() throws Throwable {
		serviceContractPage.verifyworkDetails();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify error message$")
	public void i_choose_to_verify_error_message() throws Throwable {
		serviceContractPage.verifyErrorText();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify the Subject dropdown values$")
	public void i_choose_to_verify_the_subject_dropdown_values() throws Throwable {
		serviceContractPage.verifySubjectvalues();
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to get the created Non work order Number\"([^\"]*)\"\"([^\"]*)\"$")
	public void i_choose_to_get_the_created_non_work_order_number(String testdata, int row) throws Throwable {
		serviceContractPage.getNonworkorder(testdata, row);
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose change the event to\"([^\"]*)\"$")
	public void i_choose_change_the_event_to(String newevent) throws Throwable {
		serviceContractPage.changeEvent(newevent);
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify the details displayed in Non work order page$")
	public void i_choose_to_verify_the_details_displayed_in_non_work_order_page() throws Throwable {
		serviceContractPage.verifyNonworkorderDetails();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify Sataus and Delegate manager feild and update the Timesheet$")
	public void i_choose_to_verify_sataus_and_delegate_manager_feild_and_update_the_timesheet() throws Throwable {
		serviceContractPage.editAndSaveTimeSheet();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify technican name in Timesheet\"([^\"]*)\"$")
	public void i_choose_to_verify_technican_name_in_timesheet(String Technician) throws Throwable {
		serviceContractPage.verifyTimeTechnician(Technician);
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify the Timesheet of serviceManager is not available$")
	public void i_choose_to_verify_the_timesheet_of_servicemanager_is_not_available() throws Throwable {
		serviceContractPage.verifyTimeSheet();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify Delegate manager field before changing value$")
	public void i_choose_to_verify_delegate_manager_field_before_changing_value() throws Throwable {
		serviceContractPage.verifyDelegateManagerinuserDetails();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose set the Delegate Manager Name as\"([^\"]*)\"$")
	public void i_choose_set_the_delegate_manager_name_as(String TechnicianUser) throws Throwable {
		serviceContractPage.changeDelegateManager(TechnicianUser);
		basePage.embedScreenShotInreport();
	}





	@When("I Choose to create Case of Event Type \"([^\"]*)\" and Event Sub Type \"([^\"]*)\" on Installed Product")
	public void create_Case(String event, String subType) {
		serviceMaxCaseDetailsPage.craete_A_case(event, subType);
		basePage.embedScreenShotInreport();
	}

	@Then("^I verify \"([^\"]*)\" on \"([^\"]*)\" Page$")
	public void i_verify_on_Page(String sfm, String type) {
		Assert.assertTrue(serviceMaxCaseDetailsPage.verifySFM(sfm, type));
	}

	@When("^I Choose to click on SFM \"([^\"]*)\" on \"([^\"]*)\" Page$")
	public void i_Choose_to_click_on_SFM_on_Page(String clickSFM, String type) {
		serviceMaxCaseDetailsPage.clickSFM(clickSFM, type);
		basePage.embedScreenShotInreport();
	}

	@Then("^I verify that case owner is changed to \"([^\"]*)\"$")
	public void i_verify_that_case_owner_is_changed_to(String expectedCaseOwner) {
		serviceMaxCaseDetailsPage.verifyCaseOwner(expectedCaseOwner);
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Request a Quote SFM \"([^\"]*)\"$")
	public void open_Request_Quote(String status) {
		serviceContractPage.open_Request_Quote(status);
		basePage.embedScreenShotInreport();
	}
	
	@When("^I Choose \"([^\"]*)\" from search list$")
	public void i_Choose_from_search_list(String arg1) {
	basePage.selectFromSearchlist(arg1);

	}

	@When("^I Choose to open the Quote created from Case$")
	public void open_Quote_created() {
		serviceContractPage.open_Quote();
		basePage.embedScreenShotInreport();
	}

	@Then("^I verify the line and quote prices$")
	public void i_verify_the_line_and_quote_prices() {
		Assert.assertTrue(serviceQuotePage.verifyPrice());
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to verify quote update as \"([^\"]*)\"$")
	public void i_Choose_to_verify_quote_update_as(String user) {
		serviceContractPage.verifyQuoteStatus(user);
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Release Quote SFM$")
	public void open_Release_Quote() {
		serviceQuotePage.open_Release_Quote();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify Quote status as \"([^\"]*)\"$")
	public void i_choose_to_verify_Quote_status(String expectedStatus) {
		BaseLib.waitTill("10");
		driver.navigate().refresh();
		driver.navigate().refresh();
		BaseLib.waitTill("15");
		String status = serviceQuotePage.verifyQuoteStatus();
		System.out.println("status:" + serviceQuotePage.verifyQuoteStatus());
		if (!(serviceQuotePage.verifyQuoteStatus()).equals(expectedStatus)) {
			if (serviceQuotePage.checkQuoteStatus(status).equals(expectedStatus)) {
				Assert.assertTrue(serviceQuotePage.checkQuoteStatus(status).equals(expectedStatus));
			} else if (serviceQuotePage.checkQuoteStatus(status).equals("Internally Approved")) {
				System.out.println("Internally Approved : No Quote lines present for approval");
			}

		} else {
			Assert.assertTrue(status.equals(expectedStatus));
		}
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Generate Quote PDF SFM$")
	public void generate_Quote() {
		serviceQuotePage.generate_Quote_PDF();
		basePage.embedScreenShotInreport();
	}

	@When("^I choose to approve quote line items$")
	public void i_choose_to_approve_quote_line_items() {
		serviceQuotePage.approveQuoteLines();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Approve Quote$")
	public void i_Choose_to_Approve_Quote() {
		serviceQuotePage.approveQuote();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Accept Quote$")
	public void i_Choose_to_Accept_Quote() {
		serviceQuotePage.accept_Quote();
		basePage.embedScreenShotInreport();
	}

	@Then("^I verify Debit Memo Integration Status \"([^\"]*)\"$")
	public void i_verify_Debit_Memo_Integration_Status(String dmrStatus) {
		System.out.println("dmr status:" + serviceQuotePage.verifyDebitMemo());
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Amend Quote$")
	public void i_Choose_to_Amend_Quote() {
		serviceQuotePage.amend_Quote();
		basePage.embedScreenShotInreport();
	}

	@When("^I choose to verify Partners$")
	public void i_choose_to_verify_Partners() {
		System.out.println("Partner verification");
		serviceQuotePage.getPartnerDetails();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose too verify profile Permission Sets$")
	public void i_choose_too_verify_profile_Permission_Sets() {
		basePage.hoverTo_PermissionSet();
		basePage.embedScreenShotInreport();
	}

	@When("^I click on Accounts Tab$")
	public void i_click_on_Accounts_Tab() throws Throwable {
		accountsPage.clickOnAccountTab();
		basePage.embedScreenShotInreport();
	}

	@When("^I choose to create new Account$")
	public void i_choose_to_create_new_Account() throws Throwable {
		accountsPage.create_Account_from_Tab();
		basePage.embedScreenShotInreport();
	}

	@Then("^I Choose to verify that New Button is not displayed$")
	public void i_Choose_to_verify_that_New_Button_is_not_displayed() throws Throwable {
		accountsPage.verifyNewButton();
		basePage.embedScreenShotInreport();
	}

	@Then("^I click on object \"([^\"]*)\"$")
	public void i_click_on_object(String objectName) throws Throwable {
		basePage.clickOnObject(objectName);
		basePage.embedScreenShotInreport();
	}

	@Then("^I Choose to select listview option \"([^\"]*)\"$")
	public void i_Choose_to_select_listview_option(String listviewName) throws Throwable {
		basePage.selectListviewOption(listviewName);
		basePage.embedScreenShotInreport();
	}

	@Then("^I Choose to create records using IMU SCV file$")
	public void i_Choose_to_create_records_using_IMU() throws Throwable {
		serviceMaxCaseDetailsPage.createRecordsusingIMUfile();
		basePage.embedScreenShotInreport();
	}

	@Then("^I Choose to verify the IMU records created$")
	public void i_Choose_to_verify_IMU_records(DataTable SearchCriteria) throws Throwable {

		List<List<String>> data = SearchCriteria.raw();
		String[] FieldName = new String[data.size()];
		String[] Operator = new String[data.size()];
		String[] Value = new String[data.size()];
		for (int i = 0; i < data.size(); i++) {
			FieldName[i] = data.get(i).get(0);
			Operator[i] = data.get(i).get(1);
			Value[i] = data.get(i).get(2);
		}

		serviceMaxCaseDetailsPage.verifyIMURecordsCreated(FieldName, Operator, Value);
		basePage.embedScreenShotInreport();
	}

	@Then("^I Choose to Create Case on IMU records$")
	public void i_Choose_to_Create_Case_on_IMU_records() throws Throwable {

		serviceMaxCaseDetailsPage.createCaseOnIMURecords();
		basePage.embedScreenShotInreport();
	}

	@Then("^I Choose to verify the Trackwise Status on IMU \"([^\"]*)\" \"([^\"]*)\"$")
	public void i_Choose_to_verify_Trackwise_Status_on_IMU_records(String recordNo, String expStatus) throws Throwable {

		serviceMaxCaseDetailsPage.verifyTrackwiseStatus_IMURecords(recordNo, expStatus);
		basePage.embedScreenShotInreport();
	}


	@When("^I choose to create \"([^\"]*)\" record$")
	public void i_choose_to_create_record(String recordType) throws Throwable {
		basePage.createRecord(recordType);
		basePage.embedScreenShotInreport();
	}
	
	@When("^I choose to search for Account using Search Criteria$")
	public void SearchForAccount(DataTable SearchCriteria) {
		List<List<String>> data = SearchCriteria.raw();
		String[] FieldName = new String[data.size()];
		String[] Operator = new String[data.size()];
		String[] Value = new String[data.size()];
		for (int i = 0; i < data.size(); i++) {
			FieldName[i] = data.get(i).get(0);
			Operator[i] = data.get(i).get(1);
			Value[i] = data.get(i).get(2);
		}
		accountsPage.SearchForAccount(FieldName, Operator, Value);
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to Create Contact from Account$")
	public void CreateContactfromAccount() {
		accountsPage.CreateContactfromAccount();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify the Integration status \"([^\"]*)\" and SAP external ID$")
	public void i_choose_to_verify_the_Integration_status_and_SAP_external_ID(String integrationStatus)
			throws Throwable {
		contactPage.verifyIntegrationStatus(integrationStatus);
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify Conflict flag$")
	public void i_choose_to_verify_conflict_flag() throws Throwable {
		serviceContractPage.verifyConflictFlag();
		basePage.embedScreenShotInreport();
	}

	@And("^I choose to create new case with Account \"([^\"]*)\"and\"([^\"]*)\"and\"([^\"]*)\"and\"([^\"]*)\"$")
	public void i_choose_to_create_new_case_Account(String account, String eventype, String prioritytype, String ip)
			throws Throwable {
		serviceContractPage.createCasFromAccount(account, eventype, prioritytype, ip);
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify OverRide Cost Center is autopopulated$")
	public void i_choose_to_verify_cost_center_autopopulated() throws Throwable {
		installedProduct.verifyCostcenterPopulated();
		basePage.embedScreenShotInreport();
	}

	@Then("^I Chosse to verify SFMs are Enabled$")
	public void i_choose_to_verify_SFM_Fields() throws Throwable {
		InstalledProduct ip = new InstalledProduct(driver);
		ip.verifySFMFields();
		basePage.embedScreenShotInreport();
	}

	@Then("^I chosse to verify Entitlement is true and bill type blank$")
	public void i_choose_to_verify_entitlementandbill() throws Throwable {
		installedProduct.verifyEntitleMentBillType();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify warranty and maintenance contract is blank$")
	public void i_choose_to_verify_warranty() throws Throwable {
		InstalledProduct ip = new InstalledProduct(driver);
		ip.verifyWarranty();
		basePage.embedScreenShotInreport();
	}

	@When("^I choose to verify Is billable is blank for \"([^\"]*)\"$")
	public void verifyIsBillableisBlank(String pc) {
		WorkOrderPage wp = new WorkOrderPage(driver);
		wp.verifyIsBillableBlank(pc);
		basePage.embedScreenShotInreport();
	}

	@When("I Choose to View System Information$")
	public void veiw_sys_information() {
		serviceContractPage.viewSystemInformation();
		basePage.embedScreenShotInreport();
	}

	@When("I Choose to Load Data \"([^\"]*)\"$")
	public void loadTestData(String sheet) {
		BasePage.loadTestData(sheet);
	}

	@When("^I Choose to Import FCO data to ServiceMax$")
	public void Import_FCO_data_ServiceMax() {
		basePage.Import_FCO_data_ServiceMax();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Import UAL data to ServiceMax$")
	public void Import_UAL_data_ServiceMax() {
		basePage.Import_FCO_UAL_data_ServiceMax();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Verify FCO data import to ServiceMax$")
	public void verify_Import_FCO_data_ServiceMax() {
		basePage.verify_Import_FCO_data_ServiceMax();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Save and Update FCO Header Details$")
	public void save_FCO_Header_Details() {
		basePage.save_Update_FCO_Header_Details();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Create \"([^\"]*)\" Case and verify case type$")
	public void I_Choose_to_Create_Case_and_verify_case_type(String recordType) {
		basePage.create_CAL_DAL_case(recordType);
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify fields on FCO Headers$")
	public void i_choose_to_verify_fields_on_FCO_Headers() throws Throwable {
		basePage.verifyFCOHeaderFields();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to cascade change on FCO Header$")
	public void i_choose_to_cascade_change_on_FCO_Header() throws Throwable {
		basePage.cascadeFields();
		basePage.embedScreenShotInreport();
	}

	@Then("^I verify changes in \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_verify_changes_in_and(String caseNumber, String WO) throws Throwable {
		serviceMaxCaseDetailsPage.verifyFCOInfoCase(caseNumber, WO);
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to verify CAL/DAL WOs$")
	public void I_Choose_to_verify_CALDAL_WOs() {
		serviceMaxWorkOrderPage.verifyCALDALWO();
		basePage.embedScreenShotInreport();
	}

	@Then("^I Choose to open Data Import Wizard \"([^\"]*)\"$")
	public void open_Data_Import_Wizard(String userRole) {
		basePage.open_Data_Import_Wizard(userRole);
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to create CALorDAL from UAL$")
	public void I_Choose_to_create_CALorDAL_from_UAL() {
		basePage.create_cal_dal();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Create \"([^\"]*)\" WO and verify WO type$")
	public void I_Choose_to_Create_WO_and_verify_WO_type(String recordType) {
		basePage.create_CAL_DAL_WO(recordType);
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to capture \"([^\"]*)\" WOs \"([^\"]*)\"$")
	public void I_Choose_to_capture_WOs(String recordType, String typeOfWO) {
		workOrderPage.capture_WO(recordType, typeOfWO);
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to verify parts WO created$")
	public void I_Choose_to_verify_parts_WOs() {
		workOrderPage.verify_parts_WO();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to complete Q&R WO$")
	public void I_Choose_to_complete_QR_WOs() {
		workOrderPage.completeQRWO();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Open Case From Service Quote Detail Page$")
	public void open_case_Number() {
		serviceQuotePage.open_case_Number();
		basePage.embedScreenShotInreport();
	}

	@When("^I create Material Only work order$")
	public void i_create_Material_Only_work_order() {
		// Write code here that turns the phrase above into concrete actions
		basePage.createMaterialOnlyWorkOrder();
		basePage.embedScreenShotInreport();
	}

	@When("^I intiate service$")
	public void i_intiate_service() {
		// Write code here that turns the phrase above into concrete actions
		basePage.InitiateService();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Open \"([^\"]*)\" the above record$")
	public void open_Elements(String element) {
		basePage.Open_Element(element);
		basePage.embedScreenShotInreport();
	}

	@When("I Choose to Cancel Case and Verify status \"([^\"]*)\"$")
	public void Cancel_Case_Verify_error(String stat) {
		serviceContractPage.Cancel_Case_Verify_error(stat);
	}

	@When("I Choose to Complete Case and Verify status \"([^\"]*)\"$")
	public void Complete_Case_Verify_error(String status) {
		serviceContractPage.Complete_Case(status);
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Change Status to Sent \"([^\"]*)\"$")
	public void Change_Status_Sent(String sta) {
		serviceQuotePage.Change_Status_Sent_SFM(sta);
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Reject Quote SFM$")
	public void reject_Quote() {
		serviceQuotePage.reject_Quote();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Update FCO Record Details to FCO Header \"([^\"]*)\" File$")
	public void save_FCO_Header_Details_File(String recordType) {
		basePage.save_FCO_Header_Details_File(recordType);
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Import FCO CAL data to ServiceMax$")
	public void Import_FCO_CAL_data_ServiceMax() {
		basePage.Import_FCO_CAL_data_ServiceMax();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Verify FCO CAL data import to ServiceMax$")
	public void verify_Import_FCO_CAL_data_ServiceMax() {
		basePage.verify_Import_FCO_CAL_data_ServiceMax();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Create FCO Case$")
	public void create_FCO_Case() {
		basePage.create_FCO_Case();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Create FCO Work Orders$")
	public void create_FCO_Work_Orders() {
		basePage.create_FCO_Work_Orders();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Open Case And Verify FCO Work Orders$")
	public void verify_FCO_Work_Orders() {
		basePage.verify_FCO_Work_Orders();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Initiate FCO Work Order And Create Due Diligence$")
	public void Initiate_FCO_Work_Order() {
		basePage.Initiate_FCO_Work_Order();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Add Multiple Due Diligence And Verify Status$")
	public void add_Multiple_Due_Diligence() {
		serviceMaxWorkOrderPage.add_Multiple_Due_Diligence();
		basePage.embedScreenShotInreport();
	}

	@When("I Choose to create Case on Active Contact With \"([^\"]*)\" And \"([^\"]*)\" And \"([^\"]*)\" And \"([^\"]*)\" And \"([^\"]*)\" And \"([^\"]*)\"$")
	public void create_Case(String productType, String EventType, String Priority, String CaseOrigin, String CaseSource,
			String SalesOrg) {
		contactPage.create_case(productType, EventType, Priority, CaseOrigin, CaseSource, SalesOrg);
		basePage.embedScreenShotInreport();
	}

	/*
	 * @When("I Choose to Dispatch Work Order to a Technician") public void
	 * dispatch_WorkOrder_Technician() {
	 * serviceMaxWorkOrderPage.dispatch_WorkOrder_Technician();
	 * basePage.embedScreenShotInreport(); }
	 */

	@When("I Choose to Change Installed Product \"([^\"]*)\"$")
	public void change_Installed_Product(String InstalledIP) {
		serviceContractPage.change_Installed_Product(InstalledIP);
		basePage.embedScreenShotInreport();
	}

	@When("I Choose to Create IP Relocation Change \"([^\"]*)\" And \"([^\"]*)\" And \"([^\"]*)\"$")
	public void create_IP_Relocation_Change(String newLoc, String instalIP, String salesorg) {
		serviceContractPage.create_IP_Relocation_Change(newLoc, instalIP, salesorg);
		basePage.embedScreenShotInreport();
	}

	@When("I Choose to Search IP Change Request using global search box And Approve$")
	public void search_IP_Change_Request() {

		serviceContractPage.search_IP_Change_Request_Approve();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Search WorkOrder \"([^\"]*)\" using global search box$")
	public void search_WorkOrder_usingGlobalSearchBox(String woNumber) {
		String WO = null;
		switch(woNumber) {

		case "WorkOrder1":
			WO = AutomationConstants.RUN_TIME_TEMP_DATA.get("WO1");
			break;
		case "WorkOrder2":

			WO = AutomationConstants.RUN_TIME_TEMP_DATA.get("WO2");
			break;
		}

		basePage.search_GlobalsearchBox(WO);
		basePage.embedScreenShotInreport();
	}

	@When("I Choose to Create Contact using Record Type \"([^\"]*)\" And Account \"([^\"]*)\"$")
	public void create_Contact(String record, String acc) {
		contactPage.create_Contact(record, acc);
		basePage.embedScreenShotInreport();
	}

	@When("^I choose to request part in Hybris$")
	public void i_choose_to_request_part_in_Hybris(DataTable productCodes) throws Throwable {
		List<List<String>> data = productCodes.raw();
		ArrayList<String> products = new ArrayList<String>();
		for (int i = 0; i < data.size(); i++) {
			products.add(data.get(i).get(0));
			products.add(data.get(i).get(1));
		}
		workOrderPage.requestPartInHybris(products);
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Create Parts on FCO$")
	public void i_choose_to_Create_Parts_on_FCO(DataTable productCodes) throws Throwable {
		List<List<String>> data = productCodes.raw();
		ArrayList<String> products = new ArrayList<String>();
		ArrayList<String> product_quantity = new ArrayList<String>();
		for (int i = 0; i < data.size(); i++) {
			products.add(data.get(i).get(0));
			product_quantity.add(data.get(i).get(1));
		}
		workOrderPage.requestPartInFCO(products,product_quantity);
		basePage.embedScreenShotInreport();
	}

	@When("^I Chosse to Edit the created parts$")
	public void i_choose_to_edit_created_Parts_on_FCO(DataTable productCodes) throws Throwable {
		List<List<String>> data = productCodes.raw();
		ArrayList<String> products_edited = new ArrayList<String>();
		ArrayList<String> product_quantity_edited = new ArrayList<String>();
		for (int i = 0; i < data.size(); i++) {
			products_edited.add(data.get(i).get(0));
			product_quantity_edited.add(data.get(i).get(1));
		}
		workOrderPage.editRequestedPartInFCO(products_edited,product_quantity_edited);
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to create Parts WO on created parts$")
	public void i_choose_to_create_parts_wo_on_createdparts() throws Throwable {

		workOrderPage.createPartsWO();
		basePage.embedScreenShotInreport();
	}

	@When("I choose to verify ASO number on WO Page$")
	public void verifyASOinWOPage() {
		workOrderPage.verifyASOFromHybris();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to click on Open parts$")
	public void i_Choose_to_click_on_Open_parts() {
		basePage.Open_Parts();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to click on Open parts Non returnable \"([^\"]*)\"$")
	public void i_Choose_to_click_on_Open_parts_Non_returnable(String rml) {
		basePage.Open_Parts_Nonreturnable(rml);
		basePage.embedScreenShotInreport();
	}

	@When("^I Send the WO \"([^\"]*)\" to SAP$")
	public void i_Send_the_WO_to_SAP(String element) {
		basePage.SAP_Verification(element);
		basePage.embedScreenShotInreport();
	}

	@Then("^I Choose to Create Bench Receipt$")
	public void i_Choose_to_Create_Bench_Receipt() {
		basePage.click_Create_Bench_Receipt();
		basePage.embedScreenShotInreport();
	}


	@When("^I Choose to verify Bench Repair Status \"(.*)\"$")
	public void i_Choose_to_verify_Bench_Repair_Status(String status) {

		basePage.verify_Bench_Repair_Status(status);
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to capture Bench Status Tracker Number$")
	public void i_Choose_to_capture_Bench_Status_Tracker_Number() {
		serviceMaxCaseDetailsPage.set_BenchStatusTrackerNumber();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Update Tracking/Courier number SFM$")
	public void i_Choose_to_Update_Tracking_Courier_number_SFM() {
		serviceMaxCaseDetailsPage.update_TrackingOrCourier_Number();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to capture Case Number$")
	public void i_Choose_to_capture_Case_Number() {
		serviceMaxCaseDetailsPage.set_CaseNo();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Navigate to Bench Status Tracker Page from Case Details Page$")
	public void navigateTo_BenchStatusTrackerPage_from_CaseDetailsPage() {
		serviceMaxCaseDetailsPage.goTo_benchStatusTrackerPage_from_CaseDetailsPage();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Navigate to Bench Status Tracker Page from Work Order Page$")
	public void navigateTo_BenchStatusTrackerPage_from_WorkOrderPage() {
		serviceMaxWorkOrderPage.goTo_benchStatusTrackerPage_from_WorkOrderPage();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to verify Bench Repair Status from Bench Status Tracker Page \"([^\"]*)\"$")
	public void i_Choose_to_verify_Bench_Repair_Status_from_Bench_Status_Tracker_Page(String status) {
		serviceMaxBenchStatusTrackerPage.verify_Bench_Repair_Status(status);
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to verify Tracking and Courier Number from Case Details Page$")
	public void i_Choose_to_verify_Tracking_and_Courier_Number_from_Case_Details_Page() {
		serviceMaxBenchStatusTrackerPage.goTo_CaseDetails_Page();
		serviceMaxCaseDetailsPage.verify_incomingBenchTrackingCourierNumber_Population();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Verify the Equipment Received Status Time$")
	public void i_Choose_to_Verify_the_Equipment_Received_Status_Time() {
		serviceMaxCaseDetailsPage.goTo_benchStatusTrackerPage_from_CaseDetailsPage();
		serviceMaxBenchStatusTrackerPage.verify_equipmentReceivedStatusTime_Population();
		basePage.embedScreenShotInreport();

	}


	@When("^I Choose to complete Decontamination$")
	public void i_Choose_to_complete_Decontamination() {
		serviceMaxBenchStatusTrackerPage.goTo_CaseDetails_Page();
		serviceMaxCaseDetailsPage.completeDecontamination();
		basePage.embedScreenShotInreport();
	}

	@When("^I choose to verify Decontamination Complete Status Time$")
	public void i_choose_to_verify_Decontamination_Complete_Status_Time() {
		serviceMaxCaseDetailsPage.goTo_benchStatusTrackerPage_from_CaseDetailsPage();
		serviceMaxBenchStatusTrackerPage.verify_DecontaminationCompleteStatusTime_Population();
		basePage.embedScreenShotInreport();
	}

	@When("^I choose to Update Bench Repair Case \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_choose_to_Update_Bench_Repair_Case(String installedProduct, String contactId) {
		serviceMaxBenchStatusTrackerPage.goTo_CaseDetails_Page();
		serviceMaxCaseDetailsPage.update_BenchRepairCase(installedProduct, contactId);
		basePage.embedScreenShotInreport();
	}

	@When("^I choose to Update Bench Repair Case 'InstalledProduct' and 'ContactId'$")
	public void i_choose_to_Update_Bench_Repair_Case_InstalledProduct_and_ContactId() {
		serviceMaxBenchStatusTrackerPage.goTo_CaseDetails_Page();
		String installedProduct= BaseLib.TestData.get(0).get("InstalledProduct");
		String contactId= BaseLib.TestData.get(0).get("ContactId");
		serviceMaxCaseDetailsPage.update_BenchRepairCase(installedProduct, contactId);
		basePage.embedScreenShotInreport();
	}

	@When("^I choose to answer the Safety Questions \"([^\"]*)\"$")
	public void i_choose_to_answer_the_Safety_Questions(String noOfQuestions) {
		serviceMaxCaseDetailsPage.toggle_between_FeedAndDetails_CaseDetailsPage("Details");
		serviceMaxCaseDetailsPage.answer_SafetyQuestion_ManageWO(noOfQuestions);
		basePage.embedScreenShotInreport();
	}

	@When("^I choose to Enable Request Bench Assessment$")
	public void i_choose_to_Enable_Request_Bench_Assessment() {
		serviceMaxCaseDetailsPage.select_Request_Bench_Assessment();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Create 'Remote Service Workorder'$")
	public void i_Choose_to_Create_Remote_Service_Workorder() {
		serviceMaxCaseDetailsPage.create_RemoteService_WorkOrder();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Open WorkOrder \"([^\"]*)\" from the search result$")
	public void open_WorkOrder_from_theSearchResult(String woNumber) {
		String workOrder = "";

		if(woNumber.equalsIgnoreCase("WorkOrder1")){
			workOrder = AutomationConstants.RUN_TIME_TEMP_DATA.get("WO1");

		} else if (woNumber.equalsIgnoreCase("WorkOrder2")) {

			workOrder = AutomationConstants.RUN_TIME_TEMP_DATA.get("WO2");
		} else if (woNumber.equalsIgnoreCase("WorkOrder")) {
			if(AutomationConstants.RUN_TIME_TEMP_DATA.get("WorkOrder_No")==null) {
				workOrder=AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("WORK_ORDER_NUMBER");
			}else
				workOrder=AutomationConstants.RUN_TIME_TEMP_DATA.get("WorkOrder_No");
		}else if(woNumber.equalsIgnoreCase("WorkOrder3")) {
			if(AutomationConstants.RUN_TIME_TEMP_DATA.get("WO3")==null) {
				workOrder=AutomationConstants.RUN_TIME_TEMP_DATA.get("WO1");
			}else
				workOrder=AutomationConstants.RUN_TIME_TEMP_DATA.get("WO3");
		}


		basePage.open_workOrder_from_GlobalSearchResult(workOrder);
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Initiate Bench Repair$")
	public void initiate_Bench_Repair() {
		serviceMaxWorkOrderPage.initiateBenchRepair();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to 'Initiate Remote Service' SFM$")
	public void i_Choose_to_Initate_Remote_Service_SFM() {
		serviceMaxWorkOrderPage.initiateRemoteWorkorder_SMF();
		basePage.embedScreenShotInreport();
	}


	@When("^I CHoose to Debrief and Follow up and \"([^\"]*)\"$")
	public void i_CHoose_to_Debrief_and_Follow_up_and(String action) {
		serviceMaxWorkOrderPage.debrief_and_FollowUp_SFM(action);
		basePage.embedScreenShotInreport();
	}

	@When("^I CHoose to Capture Work Order Number \"([^\"]*)\"$")
	public void i_CHoose_to_Capture_Work_Order_Number(String arg1) {
		serviceMaxWorkOrderPage.captureFollowUpWO();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to capture Work Order Number \"(.*)\"$")
	public void i_Choose_to_capture_WorkOrder_Number(String wo) {
		if (wo.equalsIgnoreCase("WO1"))
			serviceMaxCaseDetailsPage.set_WorkOrderNumber1();
		else if (wo.equalsIgnoreCase("WO2")) {
			serviceMaxWorkOrderPage.goTo_FollowUpRequired_ActivityPage();
			serviceMaxWorkOrderPage.set_WorkOrderNumber2();
		}
		else if (wo.equalsIgnoreCase("WO3")) {
			serviceMaxWorkOrderPage.set_WorkOrderNumber3();
		}
		basePage.embedScreenShotInreport();
	}

	
	@When("^I Choose to verify Work Order Bench status as \"([^\"]*)\"$")
	public void i_Choose_to_verify_Work_Order_Bench_status_as(String woBenchStatus) {
		serviceMaxWorkOrderPage.verify_WorkOrderBenchStatus(woBenchStatus);
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to 'Initiate SWO' SFM and capture SWO Number$")
	public void i_Choose_to_Initiate_SWO_SFM_and_capture_SWO_Number() {
		serviceMaxWorkOrderPage.initiateSWO_SFM();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to 'Parts Ordering' SFM \"([^\"]*)\"$")
	public void i_Choose_to_Parts_Ordering_SFM_and_Order_FCO_Kit(String part) {
		serviceMaxWorkOrderPage.partsOrdering_SFM_orderFCOKit(part);
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to capture 'ASO number'$")
	public void i_Choose_to_capture_ASO_number() {
		serviceMaxWorkOrderPage.capture_ASO_from_PartsOrderLine();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Approve IP Change Request and update Location$")
	public void approve_IP_Change_Request() {
		serviceMaxWorkOrderPage.approve_IP_Change_Request();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to opt for Tools not Required Checkbox in Record Tools SFM$")
	public void i_Choose_to_opt_for_Tools_not_Required_Checkbox_in_Record_Tools_SFM() {
		serviceMaxWorkOrderPage.record_Tools_SFM("Check Tools not required checkbox");
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Complete the WorkOrder SFM$")
	public void i_Choose_to_Complete_the_WorkOrder_using_SFM() {
		serviceMaxWorkOrderPage.completeWorkOrder_SFM();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Update the Bench Repair Status$")
	public void update_Bench_Repaire_status() {
		serviceMaxWorkOrderPage.update_Bench_Repaire_status();
		basePage.embedScreenShotInreport();
	}


	@When("^I Choose to Verify one to one FCO UAL data import to ServiceMax$")
	public void verify_Import_1to1_FCO_CAL_data_ServiceMax() {
		basePage.verify_Import_1to1_FCO_UAL_data_ServiceMax();
		basePage.embedScreenShotInreport();
	}
	@When("^I Choose to Create FCO UAL Case$")
	public void create_FCO_UAL_Case() {
		basePage.create_FCO_UAL_Case();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Create FCO UAL Work Orders$")
	public void create_FCO_UAL_Work_Orders() {
		basePage.create_FCO_UAL_Work_Orders();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Open Case And Verify FCO UAL Work Orders$")
	public void verify_FCO_UAL_Work_Orders() {
		basePage.verify_FCO_UAL_Work_Orders();
		basePage.embedScreenShotInreport();
	}
	@When("^I Choose to Initiate SWO FCO UAL Work Orders$")
	public void Initiate_SWO_FCO_UAL() {
		serviceMaxWorkOrderPage.initiateSWO_SFM_FCO();
		basePage.embedScreenShotInreport();
	}

	@Then("^I Choose to Verify FCO Kit Header work detail$")
	public void Verify_FCO_Kit_Header_work_detail() {
		serviceMaxWorkOrderPage.Verify_FCO_Kit_Header_work_detail();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to 'Parts Ordering' SFM and Order FCO Kit$")
	public void i_Choose_to_Parts_Ordering_SFM_and_Order_FCO_Kit() {
		serviceMaxWorkOrderPage.partsOrdering_SFM_orderFCOKit();
		basePage.embedScreenShotInreport();
	}

	@When("^I create incident Case for the quote \"([^\"]*)\"$")
	public void i_create_incident_Case_for_the_quote(String arg) {
		// Write code here that turns the phrase above into concrete actions
		basePage.createIncidentCase(arg);
		basePage.embedScreenShotInreport();
	}

	@When("^I click WorkLineNumberlink$")
	public void i_click_WorkLineNumberlink() {
		// Write code here that turns the phrase above into concrete actions
		basePage.worklineNumber();
		basePage.embedScreenShotInreport();
	}
	@When("^I click the Pending Return$")
	public void i_click_the_Pending_Return() {
		// Write code here that turns the phrase above into concrete actions
		basePage.pendingReturn();
		basePage.embedScreenShotInreport();
	}

	@When("^I click the \"([^\"]*)\"$")
	public void i_click_the(String Workorderno) {
		// Write code here that turns the phrase above into concrete actions
		basePage.click_Workorder_link(Workorderno);
		basePage.embedScreenShotInreport();
	}
	@When("^I Choose to Import \"([^\"]*)\" FCO data to ServiceMax$")
	public void Import_1to1FCO_data_ServiceMax(String path) {
		basePage.Import_1to1FCO_data_ServiceMax(path);
		basePage.embedScreenShotInreport();
	}
	@When("^I Choose to Verify \"([^\"]*)\" FCO data import to ServiceMax$")
	public void verify_Import_FCO_1to1_data_ServiceMax(String path) {
		basePage.verify_Import_FCO_1to1_data_ServiceMax(path);
		basePage.embedScreenShotInreport();
	}
	@When("^I Choose to Update \"([^\"]*)\" FCO Record Details to FCO Header UAL File$")
	public void save_1to1_FCO_Header_Details_CAL_File(String path) {
		basePage.save_1to1_FCO_Header_Details_UAL_File(path);
		basePage.embedScreenShotInreport();
	}
	@When("^I Choose to Import \"([^\"]*)\" FCO UAL data to ServiceMax$")
	public void Import_1to1_FCO_CAL_data_ServiceMax(String path) {
		basePage.Import_1to1_FCO_UAL_data_ServiceMax(path);
		basePage.embedScreenShotInreport();
	}
	/*
	 * @Then("^Dispatch Workorder to Technican\\.$") public void
	 * dispatch_Workorder_to_Technican() throws Throwable { // Write code here that
	 * turns the phrase above into concrete actions basePage.dispatchTechnican();
	 * basePage.embedScreenShotInreport(); }
	 */

	@When("^I Choose to create Case on Unknown Product$")
	public void CreateCaseonUnknownProduct(DataTable CaseDetails) {
		serviceContractPage.CreateCaseonUnknownProduct(CaseDetails);
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify details in Case Details page for TC \"([^\"]*)\"$")
	public void VerifyCaseDetails(String TC) {
		serviceContractPage.VerifyCaseDetails(TC);
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to create New Commitment from Case$")
	public void CreateNewCommitment(DataTable CommDetails) {
		serviceContractPage.NewCommitment(CommDetails);
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to edit Case Details$")
	public void EditCaseDetails() {
		serviceContractPage.EditCaseDetails();
		basePage.embedScreenShotInreport();
	}


	@When("^Create a incident case Cone on IPone and then create a quote in draft status with line items for labor,travel and part with \"([^\"]*)\"$")
	public void create_a_incident_case(String arg1) throws Throwable {
		basePage.createIncidentandQuote(arg1);
		basePage.embedScreenShotInreport();
	}
	@When("^Click on Release Quote SFM and verify Quote line items are Lthree is Auto Approvedwith$")
	public void click_on_Approvedwith()
	{
		basePage.releaseQuoteOne();
		basePage.embedScreenShotInreport();
	}
	@When("^Verify Quote status is Pending Quote Approval with$")
	public void verify_Quote_status_is_Pending_Quote_Approval_with() {
		// Write code here that turns the phrase above into concrete actions
		basePage.pendingQuoteApproval();
		basePage.embedScreenShotInreport();
	}
	@When("^Click on Accept Quote SFM$")
	public void click_on_Accept_Quote_SFM() {
		// Write code here that turns the phrase above into concrete actions
		basePage.quoteAccept();
		basePage.embedScreenShotInreport();
	}
	@When("^Approve quote$")
	public void approve_quote() {
		// Write code here that turns the phrase above into concrete actions
		basePage.quoteApproval();
		basePage.embedScreenShotInreport();
	}
	@When("^Verify Quote status is Internally Approved for the$")
	public void verify_Quote_status_is_Internally_Approved_for_the() {
		// Write code here that turns the phrase above into concrete actions
		basePage.internallyApproved();
		basePage.embedScreenShotInreport();
	}
	@When("^Verify that line items in Quote QThree are Routed to Default Queue$")
	public void verify_that_line_items_in_Quote_QThree_are_Routed_to_Default_Queue() {
		// Write code here that turns the phrase above into concrete actions
		basePage.createThirdQuote();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to create Non WO Events$")
	public void CreateNonWOEvent(DataTable NonWODetails) {
		workOrderPage.CreateNonWOEvent(NonWODetails);
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to verify the creation of the Non WO Events from Calendar$")
	public void VerifyNonWOEvent(DataTable SearchCriteria) {
		List<List<String>> data = SearchCriteria.raw();
		String[] FieldName = new String[data.size()];
		String[] Operator = new String[data.size()];
		String[] Value = new String[data.size()];
		for (int i = 0; i < data.size(); i++) {
			FieldName[i] = data.get(i).get(0);
			Operator[i] = data.get(i).get(1);
			Value[i] = data.get(i).get(2);
			if (Value[i].equals("SYSDATE")) {
				SimpleDateFormat gmtDateFormat = new SimpleDateFormat("MM/dd/yyyy");
				gmtDateFormat.setTimeZone(TimeZone.getTimeZone("EST"));
				// Current Date Time in GMT
				Value[i] = gmtDateFormat.format(new Date());
			}
		}
		workOrderPage.DC_ViewNonWOEvents(FieldName, Operator, Value);
	}
	@When("I choose to Perform Salesorder Check$")
	public void sales_Order_Check() {
		serviceMaxCaseDetailsPage.perform_SalesOrder_Check();
		basePage.embedScreenShotInreport();
	}

	@When("I Choose to Open \"([^\"]*)\" Service Maintenance Contract$")
	public void open_Service_Maintenance_Contract(String contract) {
		String openItem = "";
		if (contract.equalsIgnoreCase("AutoRenual_RenewedContract"))
			openItem = AutomationConstants.RUN_TIME_TEMP_DATA.get("AutoRenual_RenewedContract");
		else
			openItem = contract;

		serviceContractPage.open_Service_Maintenance_Contract(openItem);
		basePage.embedScreenShotInreport();
	}

	@When("^I choose to 'Update Part Discount' to \"([^\"]*)\" percent$")
	public void i_choose_to_Update_Part_Discount_to_percent(String discountPercent) {
		serviceContractPage.update_PartDiscount(discountPercent);
		basePage.embedScreenShotInreport();
	}
	@When("^I choose to 'Labor Discount' to \"([^\"]*)\" percent$")
	public void i_choose_to_Labor_Discount_to_percent(String discountPercent) {
		serviceContractPage.update_LaborDiscount(discountPercent);
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to 'Request a Quote' SFM and change the 'Status' as \"([^\"]*)\"$")
	public void i_Choose_to_Request_a_Quote_SFM_and_chage_the_status_as(String status) {
		serviceMaxCaseDetailsPage.requestAQuote_SFM(status);
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to add 'Labour' & 'Parts'$")
	public void i_Choose_to_add_Labour_Parts() {
		serviceMaxCaseDetailsPage.add_Parts_Quotes_SFM();
		// serviceMaxCaseDetailsPage.add_Labour_Quotes_SFM();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to check 'Get Price and Vat'$")
	public void i_Choose_to_check_Get_Price_and_Vat() {
		serviceMaxCaseDetailsPage.getPriceOrVat_QuotesSFM();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to 'Pull Discounts From Contract'$")
	public void i_Choose_to_Pull_Discounts_From_Contract() {
		serviceMaxCaseDetailsPage.pullDiscountsFromContract_QuotesSFM();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to complte Quote creation$")
	public void i_Choose_to_complte_Quote_creation() {
		serviceMaxCaseDetailsPage.complete_QuoteCreation();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to verify the value of \"([^\"]*)\" in Service Quotes Page$")
	public void i_Choose_to_verify_the_value_of(String fieldName) {

		switch (fieldName) {
		case "Total Covered by Contract":
			serviceQuotePage.validateFieldValue(fieldName);
			break;

		case "Total price before Discount and VAT":
			serviceQuotePage.validateFieldValue(fieldName);
			break;

		case "Total VAT 1 and VAT 2 and VAT 1 rate and VAT 2 rate":
			serviceQuotePage.validateFieldValue(fieldName);
			break;

		case "Total Discount percentage and Total discount":
			serviceQuotePage.validateFieldValue(fieldName);
			break;

		case "Total Net Price":
			serviceQuotePage.validateFieldValue(fieldName);
			break;

		case "Total Gross Price":
			serviceQuotePage.validateFieldValue(fieldName);
			break;

		default:
			System.out.println("No Key match found");
			break;
		}
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Verify Quote PDF is created or not$")
	public void i_Choose_to_Verify_Quote_PDF_is_created_or_not() {
		serviceMaxCaseDetailsPage.verifyPDF_in_attachmentSection();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to 'Reset Contract Discount'$")
	public void i_Choose_to_Reset_Contract_Discount() {
		serviceQuotePage.resetContractDiscount();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Uncheck All the line items and validate 'Negative Manual Discount'$")
	public void i_Choose_to_Uncheck_All_the_line_items_and_validate_Negative_Manual_Discount() {
		serviceQuotePage.validate_NegativeManualDiscount();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to 'Reduce the Discount' and vaidate 'Quote save' message$")
	public void i_Choose_to_Reduce_the_Discount_and_vaidate_Quote_save_message() {
		serviceQuotePage.validate_ManualDiscount_on_lineItem();
		basePage.embedScreenShotInreport();
	}
	@When("^I Choose to click on Add labour and parts$")
	public void i_Choose_to_click_on_Add_labour_and_parts() throws Throwable {
		basePage.Add_Labour_Parts();
		basePage.embedScreenShotInreport();
	}
	@Then("^I Choose to Note Account related data$")
	public void note_data_Account() {
		serviceContractPage.note_data_Account();
		basePage.embedScreenShotInreport();
	}
	@When("I Choose to create Case of Event Type \"([^\"]*)\" and Event Sub Type \"([^\"]*)\"$")
	public void create_Case_IP(String event, String subType) throws Throwable {
		installedProduct.createCase(event, subType);
		basePage.embedScreenShotInreport();
	}
	@When("I Choose to Add Parts \"([^\"]*)\"$")
	public void add_Parts(String parts) throws Throwable {

		serviceContractPage.addParts(parts);
		basePage.embedScreenShotInreport();
	}
	@When("^I create Parts Only work order$")
	public void i_create_Parts_Only_work_order() {
		// Write code here that turns the phrase above into concrete actions
		basePage.createPartsOnlyWorkOrder();
		basePage.embedScreenShotInreport();
	}
	@When("^I Choose to Confirm Delivery$")
	public void confirm_Del() {
		serviceMaxWorkOrderPage.confirm_Delivery();
		basePage.embedScreenShotInreport();
	}
	@When("^I Choose to Create Onsite WorkOrder SFM$")
	public void i_Choose_to_Create_Onsite_WorkOrder_SFM() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		serviceContractPage.create_Onsite_Workorder("2");
		basePage.embedScreenShotInreport();
	}
	@When("^I Choose to add Parts Ordering SFM \"([^\"]*)\"$")
	public void i_Choose_to_add_Parts_Ordering_SFM(String arg1) throws Throwable {
		basePage.partsOrdering(arg1);
		basePage.embedScreenShotInreport();
	}
	@When("^I choose to work with \"([^\"]*)\" \"([^\"]*)\"$")
	public void StoreIPValue(String Type, String IPNumber) {
		installedProduct.StoreValue(Type, IPNumber);
		basePage.embedScreenShotInreport();
	}
	@Then("^I choose to get the following numbers from IP page$")
	public void getNumbers(List<String> getValueof) {
		installedProduct.getValuesof(getValueof);
		basePage.embedScreenShotInreport();
	}
	@When("^I choose to select Create Local Bench WorkOrder$")
	public void i_choose_to_select_Create_Local_Bench_WorkOrder() {
		serviceMaxCaseDetailsPage.create_Loact_Bench_WorkOrder();
		basePage.embedScreenShotInreport();
	}
	@When("^I Choose to Search \"([^\"]*)\" Work Order using global search box$")
	public void search_WorkOrder_global_SearchBox(String WOType) {
		basePage.search_WorkOrder_global_SearchBox(WOType);
		basePage.embedScreenShotInreport();
	}
	@Then("^I choose to verify details on the Labor Work Detail Line$")
	public void VerifyLaborWorkDetail(DataTable SearchCriteria) {
		List<List<String>> data = SearchCriteria.raw();
		String[] FieldName = new String[data.size()];
		String[] Value = new String[data.size()];
		for (int i = 0; i < data.size(); i++) {
			FieldName[i] = data.get(i).get(0);
			Value[i] = data.get(i).get(1);
			if (Value[i].contains("<RiskSharingModelNumber>")) {
				Value[i] = Value[i].replace("<RiskSharingModelNumber>", AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("RSM_NUMBER"));
			}
		}
		serviceMaxWorkOrderPage.VerifyWDLine(FieldName, Value);
		basePage.embedScreenShotInreport();
	}
	@Then("^I choose to verify status of Work Order is \"([^\"]*)\"$")
	public void VerifyWOStatus(String status) {
		serviceMaxWorkOrderPage.VerifyWOStatus(status);
		basePage.embedScreenShotInreport();
	}
	@Then("^I choose to Manage Risk Sharing Model$")
	public void ManageRiskSharingModel() {
		installedProduct.ManageRiskSharingModel();
		basePage.embedScreenShotInreport();
	}
	@Then("^I choose to click on Change Order Status to In Process SFM$")
	public void ChangeOrderStatustoInProcess() {
		serviceMaxWorkOrderPage.ChangeOrderStatustoInProcess();
		basePage.embedScreenShotInreport();
	}
	@Then("^I choose to verify details in the Parts Order Line screen for \"([^\"]*)\"$")
	public void VerifyPartsOrderLine(String PartType) {
		serviceMaxWorkOrderPage.VerifyPartsOrderLine(PartType);
		basePage.embedScreenShotInreport();
	}
	@When("^I click the Intiate Travel$")
	public void i_click_the_Intiate_Travel() {
		// Write code here that turns the phrase above into concrete actions
		basePage.intiateTravel();
		basePage.embedScreenShotInreport();
	}
	@When("^I Choose to verify the 'Follow up work Identified Status Time' is populated as to \"([^\"]*)\"$")
	public void i_Choose_to_verify_the_Follow_up_work_Identified_Status_Time_is_populated_as_to(String arg1) {
		serviceMaxBenchStatusTrackerPage.verify_FollowupWorkIdentifiedStatusTime(arg1);
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to verify the 'Ready for Diagnosis Status Time' is updated to 'System Time'\\.$")
	public void i_Choose_to_verify_the_Ready_for_Diagnosis_Status_Time_is_updated_to_System_Time() {
		serviceMaxBenchStatusTrackerPage.verify_ReadyforDiagnosisStatusTime();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to verify 'Engineer Diagnosing/Repairing Age'$")
	public void i_Choose_to_verify_Engineer_Diagnosing_Repairing_Age() {
		serviceMaxBenchStatusTrackerPage.verify_EngineerDiagnosingRepairingAge();
		basePage.embedScreenShotInreport();
	}
	@Then("I Choose to Dispatch WO Using Service Board \"([^\"]*)\"")
	public void dispatch_WorkOrder_To_Technician_ServiceBoard(String tech) throws Throwable {
		
		serviceContractPage.dispatch_WorkOrder_Technician_ServiceBoard(tech);
		basePage.embedScreenShotInreport();
	}
	@When("^Search WorkorderOne mentioned in test setupNine and verify that work detail line of type Part is created in Shipped status$")
	public void search_WorkorderOne_mentioned_in_test_setupNine_and_verify_that_work_detail_line_of_type_Part_is_created_in_Shipped_status() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		basePage.shippedStatus();
		basePage.embedScreenShotInreport();
	}
	// SOuvik
	@When("^I Choose to verify \"([^\"]*)\" polulation$")
	public void i_Choose_to_verify_polulation(String fieldName) {

		switch (fieldName) {

		case "Customer Purchase Order Number":
			serviceContractPage.verify_CustomerPurchaseOrderNumber_population();
			break;

		case "Customer Facing Notes":
			serviceContractPage.verify_CustomerFacingNotes_population();
			break;

		case "Account Promo Code":
			serviceContractPage.verify_AccountPromoCode_population();
			break;

		case "Customer Experience Note":
			serviceContractPage.verify_CustomerExperienceNote_population();
			break;

		case "Freeze Auto PM creation":
			serviceContractPage.verify_FreezeAutoPMcreation_population();
			break;

		case "Billing Plan Lines":
			serviceContractPage.verify_BillingPlanLines_population();
			break;

		case "Covered Products":
			serviceContractPage.verify_CoveredProducts_population("7");
			break;

		case "SAP SWO Number":
			serviceMaxWorkOrderPage.verify_SapSwoNumber_population();
			break;

		}
		basePage.embedScreenShotInreport();
	}
	@When("^I Choose to verify available options for Activation Type$")
	public void i_Choose_to_verify_available_options_for_Activation_Type() {
		serviceContractPage.verify_OptionsFor_ActivationType();
		basePage.embedScreenShotInreport();
	}
	@When("^I CHoose to verify \"([^\"]*)\" is populated as \"([^\"]*)\"$")
	public void i_CHoose_to_verify_is_populated_as(String fieldName, String valueToBeVerified) {

		switch (fieldName) {

		case "Renewal Type":
			serviceContractPage.verify_RenewalType(valueToBeVerified);
			break;

		case "Renewed from":
			serviceContractPage.verify_RenewedFrom(valueToBeVerified);
			break;

		case "Activation Type":
			serviceContractPage.verify_ActivationType(valueToBeVerified);
			break;

		case "Renewal Term":
			serviceContractPage.verify_RenewalTerm(valueToBeVerified);
			break;

		case "RenewalDate HelperText":
			serviceContractPage.verify_RenewalDate_HelperText(valueToBeVerified);
			break;

		case "SAP Integration Status":
			serviceContractPage.verify_SapIntegrationStatus(valueToBeVerified);
			break;

		case "Active Flag":
			serviceContractPage.verify_ActiveFlag(valueToBeVerified);
			break;

		case "Location based FCO":
			new ServiceMaxFCOPage(driver).verify_LocationBasedFCO(valueToBeVerified);
			break;

		}
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to update \"([^\"]*)\" field as \"([^\"]*)\"$")
	public void i_Choose_to_update_field_as(String fieldName, String valueToBePopulated) {

		switch (fieldName) {

		case "Renewal Type":
			serviceContractPage.update_RenewalType(valueToBePopulated);
			break;

		case "Activation Type":
			serviceContractPage.update_ActivationType(valueToBePopulated);
			break;

		case "Renewal Term":
			serviceContractPage.update_RenewalTerm(valueToBePopulated);
			break;

		case "Renewal Date":
			serviceContractPage.upadate_RenewalDate(valueToBePopulated);
			break;

		case "Contract Start Date and End Date":
			serviceContractPage.upadate_Contract_StartAndEnddate(valueToBePopulated);
			break;
		}
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Renew Service Contract$")
	public void i_Choose_to_Renew_Service_Contract() {
		serviceContractPage.renewServiceContract_Sfm();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Open Biling Line and Update \"([^\"]*)\"$")
	public void i_Choose_to_Open_Biling_Line_and_Update(String arg1) {
		serviceContractPage.updateBillingLineStartAndEndDate();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Verify 'Auto Renewal Step' field present or not$")
	public void i_Choose_to_Verify_Auto_Renewal_Step_field_present_or_not() {
		serviceContractPage.verify_AutoRenewalStep();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Verify only Covered Product \"([^\"]*)\" from \"([^\"]*)\" is Covered in Renewed Contract$")
	public void i_Choose_to_Verify_only_Covered_Product_from_is_Covered_in_Renewed_Contract(String installedProduct,
			String contractNo) {
		serviceContractPage.validate_numberOfCoveredProduct_in_RenewedContract(2, installedProduct);
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose 'Send to SAP' SFM$")
	public void i_Choose_Send_to_SAP_SFM() {
		serviceContractPage.sendToSAP_SFM();
		basePage.embedScreenShotInreport();
	}
	@When("^I Choose to 'Activate Contract'SFM$")
	public void i_Choose_to_Activate_Contract_SFMt() {
		serviceContractPage.activateContract_SFM();
		basePage.embedScreenShotInreport();
	}
	@When("^I Choose to Open 'Renewal History' and verify Renewed Contract Number \"([^\"]*)\" is visible in the report$")
	public void i_Choose_to_Open_Renewal_History_and_verify_Renewed_Contract_Number_is_visible_in_the_report(
			String arg1) {
		serviceContractPage.renewedContractNumber_visiblity_in_the_report(arg1);
		basePage.embedScreenShotInreport();
	}
	@When("^I Choose to Open 'Renewal History' and verify and Capture the renewed number \"([^\"]*)\"$")
	public void i_Choose_to_Open_Renewal_History_and_verify_and_Capture_the_renewed_number(String arg1) {
		serviceContractPage.verifyAndCapture_renewedContractNumber(arg1);
		basePage.embedScreenShotInreport();
	}
	@Then("^I choose to verify details in RSM page$")
	public void VerifyDetailsinRSM() {
		Utility.getPageScreenShot(driver);
	}

	@When("^I Choose to perform case closure using Business Complete SFM$")
	public void i_Choose_to_perform_Business_Complete() {
		serviceMaxCaseDetailsPage.caseClosure();
		basePage.embedScreenShotInreport();
	}

	@Then("^I Choose to verify Reason for incompletion \"([^\"]*)\"$")
	public void i_Choose_to_verify_reason_for_incompletion(String expResult) {
		serviceMaxCaseDetailsPage.verifyReasonIncompletion(expResult);
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to update site on the case with \"([^\"]*)\"$")
	public void update_site_on_case(String ip) {
		serviceContractPage.updateSiteOncase(ip);
		basePage.embedScreenShotInreport();
	}
	@When("^I Choose to verify quotes on case in \"([^\"]*)\" status$")
	public void i_Choose_to_verify_quotes_on_case_in_status(String quoteStatus) throws Throwable {
		serviceContractPage.verifyQuotesonCase(quoteStatus);
		basePage.embedScreenShotInreport();
	}
	@Given("^I launch CS Portal application successfully$")
	public void launch_CSPortal_Application() throws InterruptedException {
		basePage.csPortalLogin();
		basePage.embedScreenShotInreport();
	}
	@When("^I Choose to Verify Account OneEMS Portal Page$")
	public void verify_Account_Assignment() throws Throwable {
		customerServicePage.verifyPage();
		basePage.embedScreenShotInreport();
	}
	@When("^I Choose to Verify Reports OneEMS Portal Page$")
	public void verify_Report() throws Throwable {
		customerServicePage.verifyReports();
		basePage.embedScreenShotInreport();
	}
	@When("^I Logout off CS Portal successfully$")
	public void logout_CSPortal() throws Throwable {
		customerServicePage.logout_CSPortal();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to perform Sync IP and Parts Count$")
	public void i_Choose_to_perform_Sync_IP_PartsCount() throws Throwable {
		workOrderPage.performSyncIP();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to Complete FCO Parts WO$")
	public void i_Choose_to_Complete_FCO_Parts_WO() throws Throwable {
		workOrderPage.completePartsWO();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to capture test data details$")
	public void i_Choose_to_capture_location_detail(DataTable testData) throws Throwable {
		List<List<String>> data = testData.raw();
		ArrayList<String> ip = new ArrayList<String>();
		ArrayList<String> product_code = new ArrayList<String>();
		ArrayList<String> serial_number = new ArrayList<String>();
		ArrayList<String> functional_location = new ArrayList<String>();
		ArrayList<String> location = new ArrayList<String>();
		for (int i = 0; i < data.size(); i++) {
			ip.add(data.get(i).get(0));
			product_code.add(data.get(i).get(1));
			serial_number.add(data.get(i).get(2));
			functional_location.add(data.get(i).get(3));
			location.add(data.get(i).get(4));

			AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("IP"+(i+1), ip.get(i));
			AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("PRODUCTCODE"+(i+1), product_code.get(i));
			AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("SERIALNUM"+(i+1), serial_number.get(i));
			AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("FUNLOC"+(i+1), functional_location.get(i));
			AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("LOCATION", location.get(i));


		}
		System.out.println("IP1:"+AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("IP1"));
		System.out.println("IP2:"+AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("IP2"));

		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to create TM Case and Caselines$")
	public void i_Choose_to_create_TMCase_Caselines() throws Throwable {
		locationPage.createTMCase();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to add CaseLines in the TM Case created$")
	public void i_Choose_to_add_CaseLines() throws Throwable {
		serviceMaxCaseDetailsPage.addCaseLines();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to verify Caseline Checkbox$")
	public void i_Choose_to_verify_CaseLine_Checkbox() throws Throwable {
		serviceMaxCaseDetailsPage.verifyCaselineCheckbox();

		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to verify error message when creating TM Case with PM History$")
	public void i_Choose_to_verify_error_message_creating_TMCase() throws Throwable {
		locationPage.verifyTMCaseWithPMHistory();

		basePage.embedScreenShotInreport();
	}

	@Then("^I Choose to get the contract Start Date$")
	public void i_Choose_to_get_the_contract_start_date() throws Throwable {
		serviceContractPage.getContractStartDate();
		
		basePage.embedScreenShotInreport();
	}
	
	@Then("^I Choose to open preventive maintenance plan with \"([^\"]*)\"$")
	public void open_PM_plan(String element) {
		basePage.Open_PMPlan(element);
		basePage.embedScreenShotInreport();
	}
	
	@And("^I verify PM plan start date with contract start date$")
	public void verify_pm_start_date_with_contract_start_date() throws Throwable {
		serviceContractPage.verifyPMStartDateWithContractStartDate();
		basePage.embedScreenShotInreport();
	}
	
	@When("^I Choose to Open WorkOrder \"([^\"]*)\" from Work Orders list$")
	public void i_Choose_to_open_workOrder(String DebriefedWorkorder) throws Throwable {
		serviceContractPage.openWorkOrderFromPMPlans(DebriefedWorkorder);
		
		basePage.embedScreenShotInreport();
	}
	
	@Then("^I Choose to Enter details in Contract Renewal section$")
	public void enter_details_in_contract_renewal() throws Throwable {
		serviceContractPage.update_RenewalType("Manual Renewal");
		serviceContractPage.update_RenewalTerm("12");
		basePage.embedScreenShotInreport();
	}
	
	@Then("^I verify 'Last Delivered PM Sequence' field is equal to Debrief Date of WO1$")
	public void verify_last_delivered_PM_with_debrief_date() throws Throwable {
		serviceContractPage.last_delivered_PM_equal_to_debrief_date();
		basePage.embedScreenShotInreport();
	}
	
	@And("^I verify 'Last Delivered PM Date' field is equal to 'Service Activity' of WO1$")
	public void verify_last_delivered_PM_with_service_activity() throws Throwable {
		serviceContractPage.last_delivered_PM_equal_to_service_activity();
		basePage.embedScreenShotInreport();
	}
	
	@Then("^I Choose to enter details in IP detail page$")
	public void enter_details_in_IP_detail_page() throws Throwable {
		installedProduct.enter_details_in_IP_detail_page();
		basePage.embedScreenShotInreport();
	}
		
	@And("^I Choose to verify Warranty Term details under Product warranty section$")
	public void i_Choose_to_verify_warranty_term_details() throws Throwable {
		installedProduct.selectWarrantyAndVerifyDetails();
		
		basePage.embedScreenShotInreport();
	}
	



	@When("^I choose to select new quote request$")
	public void i_choose_to_select_new_quote_request() throws Throwable {
	basePage.select_NewQuoteRequest();
	}



	@When("^I choose to enter mandatory fields of quote page$")
	public void i_choose_to_enter_mandatory_fields_of_quote_page() throws Throwable {
	basePage.enterDetails_QuotePage();
	}



	@When("^I Choose to select new work order$")
	public void i_Choose_to_select_new_work_order() throws Throwable {
		basePage.select_NewWorkOrder();
	}



	@When("^I choose to fill labor details$")
	public void i_choose_to_fill_labor_details() throws Throwable {
	basePage.enter_LaborDetails();
	}



	@When("^I choose to fill Parts details$")
	public void i_choose_to_fill_Parts_details() throws Throwable {
	basePage.enter_PartDetails();
	}



	@Then("^I choose to click on Get Price$")
	public void i_choose_to_click_on_Get_Price() throws Throwable {
		basePage.click_GetPrice();
	}



	@Then("^I choose to click on Pull discounts$")
	public void i_choose_to_click_on_Pull_discounts() throws Throwable {
	basePage.click_PullDiscount();
	}



	@Then("^I choose to validate the calculations$")
	public void I_choose_to_validate_the_calculations() throws Throwable {
		basePage.calculations();
	}



	@When("^I choose to release quote$")
	public void I_choos_to_release_quote() throws Throwable {
	basePage.release_Quote();
	}
	
	@When("^I Choose to Initiate Travel SFM$")
	public void initiate_Travel_SFM() {
		serviceMaxWorkOrderPage = new WorkOrderPage(driver);
		serviceMaxWorkOrderPage.initiate_Travel_SFM();
		basePage.embedScreenShotInreport();
	}
	
	@When("^I Choose to Receive parts SFM$")
	public void receive_Parts_SFM() {
		serviceMaxWorkOrderPage = new WorkOrderPage(driver);
		serviceMaxWorkOrderPage.receive_Parts_SFM();
		basePage.embedScreenShotInreport();
	}
	
	@Then("^I choose to create new applicable product \"([^\"]*)\" in Warranty Terms$")
	public void i_choose_to_create_new_applicable_product_in_warranty_terms(String productCode) throws Throwable {
		installedProduct.createNewapplicableproductinWarrantyterms(productCode);
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to transfer and verify WO details to RSW$")
	public void i_Choose_to_transfer_WO_in_RSW() {
		serviceMaxWorkOrderPage.transferAndVerifyInRSW();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to enter field values in RSW$")
	public void i_Choose_to_enter_fields_in_RSW() {
		rswPage.enterFieldsInRSW();
		basePage.embedScreenShotInreport();
	}

	@When("^I Choose to publish service report to Smax from RSW$")
	public void i_Choose_to_publish_service_report_in_RSW() {
		rswPage.publishServiceReporttoSmax();
		basePage.embedScreenShotInreport();
	}
	
	@When("^I Choose to verify Potential Safety Fields and WO Fix$")
	public void i_Choose_to_verify_potenstial_safety_field() {
		workOrderPage.verifyPSFields();
		basePage.embedScreenShotInreport();
	}
	
	@When("^I Choose to Launch Hybris Application successfully$")
	public void i_Choose_to_Launch_Hybris_Application_successfully() throws Throwable {
		basePage.HybrisLogin();
		basePage.embedScreenShotInreport();
	}

	@Then("^I choose to enter  credentials for Hybris application for \"([^\"]*)\">$")
	public void i_choose_to_enter_credentials_for_Hybris_application_for(String user) throws Throwable {
		basePage.enterHybrisCredentials(user, driver);
		basePage.embedScreenShotInreport();
	}


	@When("^I Choose to Search   Serial number for the account in Hybris order page$")
	public void i_Choose_to_Search_Serial_number_for_the_account_in_Hybris_order_page(DataTable ipDetails) throws Throwable {
		//hybrisPage.PartsorderHybris();

		List<List<String>> data = ipDetails.raw();
		ArrayList<String> details = new ArrayList<String>();
		for (int i = 0; i < data.size(); i++) {
			details.add(data.get(i).get(0));
			details.add(data.get(i).get(1));
		}
		hybrisPage.TS1(details);
		basePage.embedScreenShotInreport(); 


	}


	@When("^I choose to Search with the Serial Number and Product Description for the  Account in Hybris Order Page$")
	public void i_choose_to_Search_with_the_Serial_Number_and_Product_Description_for_the_Account_in_Hybris_Order_Page(DataTable ipDetails) throws Throwable {
		List<List<String>> data = ipDetails.raw();
		ArrayList<String> details = new ArrayList<String>();
		for (int i = 0; i < data.size(); i++) {
			details.add(data.get(i).get(0));
			details.add(data.get(i).get(1));
			details.add(data.get(i).get(2));
		}
		hybrisPage.TS2(details);
		basePage.embedScreenShotInreport(); 

	}

	@When("^I Choose to Search serial number and Product Code for the  Account in Hybris Order Page$")
	public void i_Choose_to_Search_serial_number_and_Product_Code_for_the_Account_in_Hybris_Order_Page(DataTable ipDetails) throws Throwable {
		List<List<String>> data = ipDetails.raw();
		ArrayList<String> details = new ArrayList<String>();
		for (int i = 0; i < data.size(); i++) {
			details.add(data.get(i).get(0));
			details.add(data.get(i).get(1));
			details.add(data.get(i).get(2));
		}
		hybrisPage.TS3(details);
		basePage.embedScreenShotInreport(); 
	}

	@When("^I choose to Search Serial number that is not unique which fetch more than (\\d+) IP  in Hybris Order page$")
	public void i_choose_to_Search_Serial_number_that_is_not_unique_which_fetch_more_than_IP_in_Hybris_Order_page(int arg1,DataTable ipDetails) throws Throwable {
		List<List<String>> data = ipDetails.raw();
		ArrayList<String> details = new ArrayList<String>();
		for (int i = 0; i < data.size(); i++) {
			details.add(data.get(i).get(0));
			details.add(data.get(i).get(1));
		}
		hybrisPage.TS4(details);
		basePage.embedScreenShotInreport(); 
	}

	@When("^I choose to Search  IP that is other than Type as system and note down the same serial number  from Hybris Order Page$")
	public void i_choose_to_Search_IP_that_is_other_than_Type_as_system_and_note_down_the_same_serial_number_from_Hybris_Order_Page(DataTable ipDetails) throws Throwable {
		List<List<String>> data = ipDetails.raw();
		ArrayList<String> details = new ArrayList<String>();
		for (int i = 0; i < data.size(); i++) {
			details.add(data.get(i).get(0));

		}
		hybrisPage.TS5(details);
		basePage.embedScreenShotInreport(); 
	}

	//	Mayuri
	@When("^I Choose to open \"([^\"]*)\"$")
	public void i_Choose_to_open(String arg1) throws Throwable {
		basePage.open_Case(arg1);
	}

	@When("^I Choose to navigate to details page$")
	public void I_Choose_to_navigat_to_details_page() throws Throwable {
		basePage.navigate_DetailsPage();
	}


	@When("^I Choose to click on SFW Section button \"([^\"]*)\"$")
	public void I_Choose_to_click_on_SFW_Section_button(String arg1) throws Throwable {
		basePage.SFW_Section_Button(arg1);
	}

	@When("^I choose to search with full serial number \\+ substring of product number in Hybris Order Page$")
	public void i_choose_to_search_with_full_serial_number_substring_of_product_number_in_Hybris_Order_Page(DataTable ipDetails) throws Throwable {
		List<List<String>> data = ipDetails.raw();
		ArrayList<String> details = new ArrayList<String>();
		for (int i = 0; i < data.size(); i++) {
			details.add(data.get(i).get(0));
			details.add(data.get(i).get(1));
		}
		hybrisPage.TS6(details);
		basePage.embedScreenShotInreport(); 
	}

	@When("^I choose to search  full Serial number and incorrect  product number in Hybris Order page$")
	public void i_choose_to_search_full_Serial_number_and_incorrect_product_number_in_Hybris_Order_page(DataTable ipDetails) throws Throwable {
		List<List<String>> data = ipDetails.raw();
		ArrayList<String> details = new ArrayList<String>();
		for (int i = 0; i < data.size(); i++) {
			details.add(data.get(i).get(0));
			details.add(data.get(i).get(1));
			details.add(data.get(i).get(2));
		}
		hybrisPage.TS7(details);
		basePage.embedScreenShotInreport(); 
	}


	@When("^I choose to search  Contract number for the account$")
	public void i_choose_to_search_Contract_number_for_the_account(DataTable ipDetails) throws Throwable {

		List<List<String>> data = ipDetails.raw();
		ArrayList<String> details = new ArrayList<String>();
		for (int i = 0; i < data.size(); i++) {
			details.add(data.get(i).get(0));

		}
		hybrisPage.TS8(details);
		basePage.embedScreenShotInreport();
	}

	@When("^I choose to search for another Contract_number for the account$")
	public void i_choose_to_search_for_another_Contract_number_for_the_account(DataTable ipDetails) throws Throwable {
		List<List<String>> data = ipDetails.raw();
		ArrayList<String> details = new ArrayList<String>();
		for (int i = 0; i < data.size(); i++) {
			details.add(data.get(i).get(0));

		}
		hybrisPage.TS9(details);
		basePage.embedScreenShotInreport(); 
	}

	@When("^I Choose to execute accounts workflow$")
	public void i_Choose_to_execute_accounts_workflow() throws Throwable {
		basePage.account_Workflow();
	}

	@When("^I Choose to execute contact workflow$")
	public void i_Choose_to_execute_contact_workflow() throws Throwable {
		basePage.contact_Workflow();
	}

	@When("^I Choose to execute Account Partner workflow$")
	public void i_Choose_to_execute_Account_Partner_workflow() throws Throwable {
		basePage.partner_Workflow();
	}

	@When("^I Choose to access accounts report$")
	public void i_Choose_to_access_accounts_report() throws Throwable {
		basePage.account_reports();
	}

	@Then("^I Choose to validate accounts report$")
	public void i_Choose_to_validate_accounts_report() throws Throwable {
		basePage.validate_accounts_report();
	}

	@When("^I Choose to access contact report$")
	public void i_Choose_to_access_contact_report() throws Throwable {
		basePage.contact_reports();
	}

	@Then("^I Choose to validate contact report$")
	public void i_Choose_to_validate_contact_report() throws Throwable {
		basePage.validate_contacts_report();
	}

	@When("^I Choose to access account partner report$")
	public void i_Choose_to_access_account_partner_report() throws Throwable {
		basePage.partner_reports();
	}

	@Then("^I Choose to validate account partner report$")
	public void i_Choose_to_validate_account_partner_report() throws Throwable {
		basePage.validate_account_partner_report();
	}

	@Given("^I choose to reprocess the IP")
	public void i_reporcess_the_IP()
	{
		driver.get("https://philipsb2bsc--emsmq3.my.salesforce.com/a9D/o");
		installedProduct.processIPs();
		basePage.embedScreenShotInreport();	
	}

}


