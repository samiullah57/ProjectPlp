package com.philips.stepdefinitions;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.philips.generic.AutomationConstants;
import com.philips.pages.BaseLib;
import com.philips.pages.BasePage;
import com.philips.pages.LeanFTPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LeanFTSteps {

	public  WebDriver driver;
	public BasePage bp;
	public LeanFTPage leanftpage;


	public LeanFTSteps() 
	{
		driver = Hooks.driverInstances.get(String.valueOf(Thread.currentThread().getId()));
		bp = new BasePage(driver);
		leanftpage = new LeanFTPage(driver);
	}

	@Given("^I choose to login to SAP system$")
	public void i_choose_to_login_to_sap_system() throws Throwable {
		leanftpage.launchSAP();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^I choose to close SAP Application$")
	public void user_close_sap_application() throws Throwable {
		BaseLib.embedScreenShotInreportWithRobot();
		LeanFTPage.closeSAP();
	}

	@When("^User access the SalesOrder \"([^\"]*)\" Tab$")
	public void User_access_theTab(String TabName) throws GeneralLeanFtException
	{  
		leanftpage.accessSOTab(TabName);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^User access the Meterial \"([^\"]*)\" Tab$")
	public void User_access_theMeterialTab(String TabName) throws GeneralLeanFtException
	{  
		leanftpage.accessMeterialTab(TabName);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^User verify the Price Details$")
	public void User_verifythePriceDetails() throws Exception
	{
		//	leanftpage.verifyPricingDetails();  
	}
	@And("^I choose to enter FM value\"([^\"]*)\"$")
	public void i_choose_to_enter_fm_value(String fmcode) throws Throwable {
		leanftpage.enterFM(fmcode);
		BaseLib.embedScreenShotInreportWithRobot();
	}


	@And("^I choose to select Test Data Directory$")
	public void i_choose_to_select_test_data_directory() throws Throwable {
		leanftpage.selectTestData();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^I choose to find the vaiant\"([^\"]*)\"$")
	public void i_choose_to_find_the_vaiant(String variantvalue) throws Throwable {
		leanftpage.searchVariant(variantvalue);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to select sales Orgainsation\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
	public void i_choose_to_select_sales_orgainsation(String ordertype, String organisation, String channel, String division) throws Throwable {
		leanftpage.enterOrderdetails(ordertype, organisation, division, channel);
		BaseLib.embedScreenShotInreportWithRobot();
	}


	@And("^I choose to Enter Billing and shipping as\"([^\"]*)\"\"([^\"]*)\"$")
	public void i_choose_to_enter_billing_and_shipping_as(String billing, String shipping) throws Throwable {
		leanftpage.enterBillingvalues(billing, shipping);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_choose_to_enter_and_(String soldto, String shipto) throws Throwable {
		leanftpage.enterShipToSoldTo(soldto, shipto);
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@And("^I choose to enter Material value\"([^\"]*)\"$")
	public void i_choose_to_enter_material_value(String material) throws Throwable {
		leanftpage.enterMaterialNumber(material);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to save the Sales order$")
	public void i_choose_to_save_the_sales_order() throws Throwable {
		leanftpage.saveSalesOrder();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^I choose to renter T code as\"([^\"]*)\"$")
	public void i_choose_to_renter_t_code_as(String code) throws Throwable {
		leanftpage.renterTcode(code);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to Enter created order Number$")
	public void i_choose_to_enter_created_order_number() throws Throwable {
		leanftpage.EnterOrder();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to select the added Material$")
	public void i_choose_to_select_the_added_material() throws Throwable {
		leanftpage.select_Material();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify Condition values$")
	public void i_choose_to_verify_condition_values() throws Throwable {
		leanftpage.verifyCondtions();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to validate Sales deals values$")
	public void i_choose_to_validate_sales_deals_values() throws Throwable {
		leanftpage.verifySalesDeals();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify MaterialValues$")
	public void i_choose_to_verify_materialvalues() throws Throwable {
		leanftpage.verifyVariantMaterial();
		//verifyMaterial();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to Execute the variant$")
	public void i_choose_to_execute_the_variant() throws Throwable {
		leanftpage.verifyExecute();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to Enter Table Name as\"([^\"]*)\"$")
	public void i_choose_to_enter_table_name_as(String tname) throws Throwable {
		leanftpage.enterTableDetails(tname);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to enter Date and CreatedBY as\"([^\"]*)\"$")
	public void i_choose_to_enter_date_and_createdby_as(String name) throws Throwable {
		leanftpage.enterDateCreatedBY(name);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to validate all contracts created by\"([^\"]*)\"$")
	public void i_choose_to_validate_all_contracts_created_by(String name) throws Throwable {
		leanftpage.veriftcreatedContracts(name);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to validate the Contract Value$")
	public void i_choose_to_validate_the_contract_value() throws Throwable {
		leanftpage.validateContractTable();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to Enter the Contract Number created in Above step$")
	public void i_choose_to_enter_the_contract_number_created_in_above_step() throws Throwable {
		leanftpage.enterContractNumber();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose get IFF value from Agreement\"([^\"]*)\"$")
	public void i_choose_get_iff_value_from_agreementsomething(String agreementname) throws Throwable {
		leanftpage.enterAgreementNumber(agreementname);
		leanftpage.getIFFvalue(agreementname);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to select added Material$")
	public void i_choose_to_select_added_material() throws Throwable {
		leanftpage.enterValuePrice();
		leanftpage.selectMaterail();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to select display OrderMaterial$")
	public void i_choose_to_select_display_ordermaterial() throws Throwable {
		leanftpage.selectdisplayOrderMaterial();
		BaseLib.embedScreenShotInreportWithRobot();
	}


	@Then("^I choose to verify the IFF value\"([^\"]*)\"and\"([^\"]*)\"$")
	public void i_choose_to_verify_the_iff_value(String industrialfundfee, String name) throws Throwable {
		leanftpage.verifyIFFValue(industrialfundfee, name);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to select the condition table$")
	public void i_choose_to_select_the_condition_table() throws Throwable {
		leanftpage.selectCondtionTab();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@And("^I choose to enter process and Billing value as\"([^\"]*)\"$")
	public void i_choose_to_enter_process_and_billing_value_as(String billing) throws Throwable {
		leanftpage.enterProcessBilling(billing);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify condition Record for\"([^\"]*)\"and\"([^\"]*)\"$")
	public void i_choose_to_verify_condition_record_for(String yat, String tabname) throws Throwable {
		leanftpage.veriyYATCondition(yat, tabname);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify sales deal value\"([^\"]*)\"$")
	public void i_choose_to_verify_sales_deal_value(String agreementname) throws Throwable {
		leanftpage.verifySalesDeal(agreementname);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to select condition record$")
	public void i_choose_to_select_condition_record() throws Throwable {
		leanftpage.selectConditionRec();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to slect COndition Record$")
	public void i_choose_to_slect_condition_record() throws Throwable {
		leanftpage.selectConditionRec();
		BaseLib.embedScreenShotInreportWithRobot();
	}


	@And("^I choose to enter Sales Deal value\"([^\"]*)\"$")
	public void i_choose_to_enter_sales_deal_value(String salesData) throws Throwable {
		leanftpage.enterSalesDeal(salesData);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose enter sales details and Save\"([^\"]*)\"$")
	public void i_choose_enter_sales_details_and_savesomething(String salesdata) throws Throwable {
		leanftpage.enterMandatoryDetails(salesdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to get the created Sales order Number$")
	public void i_choose_to_get_the_created_sales_order_number() throws Throwable {
		leanftpage.getcreatedSalesNumber();
		BaseLib.embedScreenShotInreportWithRobot();
	}


	@Then("^I choose edit the IFF value and Save\"([^\"]*)\"$")
	public void i_choose_edit_the_iff_value_and_save(String salesdata) throws Throwable {
		leanftpage.editIFFSave(salesdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to enter created Sales Deal Number$")
	public void i_choose_to_enter_created_sales_deal_number() throws Throwable {
		leanftpage.enterSalesDeal();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify the sales Order$")
	public void i_choose_to_verify_the_sales_order() throws Throwable {
		leanftpage.verifysalesOrder();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to enter Agreement values\"([^\"]*)\"$")
	public void i_choose_to_enter_agreement_value(String salesdata) throws Throwable {
		leanftpage.enterSalesNumber(salesdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to validate sales deal in order\"([^\"]*)\"$")
	public void i_choose_to_validate_sales_deal_in_ordersomething(String salesdata) throws Throwable {
		leanftpage.verifykonaTable(salesdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to enter salesorganisation Data\"([^\"]*)\"$")
	public void i_choose_to_enter_salesorganisation_data(String salesorganisation) throws Throwable {
		leanftpage.enterSalesOrganisation(salesorganisation);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify the Billing type values$")
	public void i_choose_to_verify_the_billing_type_values() throws Throwable {
		leanftpage.verifyBillingValues();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to select tableName as\"([^\"]*)\"$")
	public void i_choose_to_select_tablename_as(String conditiontable) throws Throwable {
		leanftpage.selectTestFunctionTableValues(conditiontable);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify the condition values$")
	public void i_choose_to_verify_the_condition_values() throws Throwable {
		leanftpage.verifyCondtionValues();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify the Promo values$")
	public void i_choose_to_verify_the_promo_values() throws Throwable {
		leanftpage.verifyPromo();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose verify Billing values$")
	public void i_choose_verify_billing_values() throws Throwable {
		leanftpage.verifyBillingvalues();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify Contract date$")
	public void i_choose_to_verify_contract_date() throws Throwable {
		leanftpage.verifyContractDate();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@And("^I choose to select the tab\"([^\"]*)\"$")
	public void i_choose_to_select_the_tab(String scheduleTab) throws Throwable {
		leanftpage.selectTab(scheduleTab);
		BaseLib.embedScreenShotInreportWithRobot();
	}


	@Then("^I choose to save the Order$")
	public void i_choose_to_save_the_order() throws Throwable {
		leanftpage.saveOrder();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to change the value for\"([^\"]*)\"and save$")
	public void i_choose_to_change_the_value_forand_save(String payment) throws Throwable {
		leanftpage.changePaymnetTerm(payment);
		leanftpage.slectPaymentTerm();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to select Ananylsis$")
	public void i_choose_to_select_ananylsis() throws Throwable {
		leanftpage.selectAnalysisButton();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to select Sales Deal pricing table$")
	public void i_choose_to_select_sales_deal_pricing_table() throws Throwable {
		leanftpage.selectSalesDealValue();
		BaseLib.embedScreenShotInreportWithRobot();
	}


	@And("^I choose to Enter contractNumber\"([^\"]*)\"$")
	public void i_choose_to_enter_contractnumber(String ApttusData) throws Throwable {
		leanftpage.enterApttusContractNumber(ApttusData);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify WBS value$")
	public void i_choose_to_verify_wbs_value() throws Throwable {
		leanftpage.verifyWBSValue();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to select the required tab\"([^\"]*)\"$")
	public void i_choose_to_select_the_required_tab(String apttusdata) throws Throwable {
		leanftpage.selectOrderTab(apttusdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to Enter order Number\"([^\"]*)\"$")
	public void i_choose_to_enter_order_number(String apttusdata) throws Throwable {
		leanftpage.enteroder(apttusdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify the Z bracket in schedule\"([^\"]*)\"$")
	public void i_choose_to_verify_the_z_bracket_in_schedule(String apttusdata) throws Throwable {
		leanftpage.verifySchedule(apttusdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}


	@Then("^I chhose to verify sales Documnet Number\"([^\"]*)\"$")
	public void i_chhose_to_verify_sales_documnet_number(String apttusdata) throws Throwable {
		leanftpage.verifySalesdoc(apttusdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to select scheduleTab\"([^\"]*)\"$")
	public void i_choose_to_select_scheduletab(String scheduletab) throws Throwable {
		leanftpage.SelectScheduleTab(scheduletab);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to select additionalTab\"([^\"]*)\"$")
	public void i_choose_to_select_additionaltab(String additionaltab) throws Throwable {
		leanftpage.selectAdditional(additionaltab);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to select Display document flow$")
	public void i_choose_to_select_display_document_flow() throws Throwable {
		leanftpage.selectDocumentflow();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify Display document flow$")
	public void i_choose_to_verify_display_document_flow() throws Throwable {
		leanftpage.verifyldocumnet();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to select the contract type as\"([^\"]*)\"$")
	public void i_choose_to_select_the_contract_type_as(String contacttype) throws Throwable {
		leanftpage.selectContractType(contacttype);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to Execute the selected Variant$")
	public void i_choose_to_execute_the_selected_variant() throws Throwable {
		leanftpage.executeSelectedContract();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose validate purchase order type with\"([^\"]*)\"$")
	public void i_choose_validate_purchase_order_type_withsomething(String varinatvalue) throws Throwable {
		leanftpage.verifyPurchaseOrderValue(varinatvalue);
		BaseLib.embedScreenShotInreportWithRobot();
	}


	@Then("^I choose verify first Line item\"([^\"]*)\"$")
	public void i_choose_verify_first_line_item(String apttusdata) throws Throwable {
		leanftpage.verifyFirstlineItem(apttusdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify SalesDeal Description as\"([^\"]*)\"$")
	public void i_choose_to_verify_salesdeal_description_as(String salesdata) throws Throwable {
		leanftpage.verifySalesDescription(salesdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify Description in table as\"([^\"]*)\"$")
	public void i_choose_to_verify_description_in_table_as(String salesdata) throws Throwable {
		leanftpage.verifyTerminationdescription(salesdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to enter SalesAgreementNumber\"([^\"]*)\"$")
	public void I_choose_to_enter_salesagreementnumber(String salesdata) throws Throwable {
		leanftpage.enterAgreementNumberinTable(salesdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to enter the program name\"([^\"]*)\"$")
	public void i_choose_to_enter_the_program_name(String name) throws Throwable {
		leanftpage.enterProgramName(name);
		BaseLib.embedScreenShotInreportWithRobot();
	}


	@Then("^I choose to verify the Sales deal Validaity Dates$")
	public void i_choose_to_verify_the_sales_deal_validaity_dates() throws Throwable {
		leanftpage.verifyDates();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to Sales Deal value in Edit\"([^\"]*)\"$")
	public void i_choose_to_sales_deal_value_in_edit(String salesdata) throws Throwable {
		leanftpage.edit_salesDeal(salesdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^I choose to select Conditions$")
	public void i_choose_to_select_Conditions() throws Throwable {
		leanftpage.selectCondtions();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to delete the condition$")
	public void i_choose_to_delete_the_condition() throws Throwable {
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to select the value to delete from conditions\"([^\"]*)\"$")
	public void i_choose_to_select_the_value_to_delete_from_conditions(String sealsdata) throws Throwable {
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to enter order details as\"([^\"]*)\"$")
	public void i_choose_to_enter_order_details_as(String apttusdata) throws Throwable {
		leanftpage.enterValues(apttusdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to select Create with reference$")
	public void i_choose_to_select_create_with_reference() throws Throwable {
		leanftpage.selectCreateReference();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to slect create reference tab\"([^\"]*)\"$")
	public void i_choose_to_slect_create_reference_tab(String apttusdata) throws Throwable {
		leanftpage.selectTabforrefernece(apttusdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}


	@And("^I choose to enter Reference contract Number as\"([^\"]*)\"$")
	public void i_choose_to_enter_reference_contract_number_as(String apttusdata) throws Throwable {
		leanftpage.entercontract_copy(apttusdata);
		leanftpage.selectCOntinue();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to enter Item category as\"([^\"]*)\"$")
	public void i_choose_to_enter_item_category_as(String apttusdata) throws Throwable {
		leanftpage.enterItemCategory(apttusdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify Profit center in Table$")
	public void i_choose_to_verify_profit_center_in_table() throws Throwable {
		leanftpage.verifyProfitCenter();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to select Materials from the list$")
	public void i_choose_to_select_materials_from_the_list() throws Throwable {
		leanftpage.selectreferenceValues();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to enter PODetails$")
	public void i_choose_to_enter_podetails() throws Throwable {
		leanftpage.enetrPoDeails();
		BaseLib.embedScreenShotInreportWithRobot();
	}


	@Then("^I choose to verify the Materials$")
	public void i_choose_to_verify_the_materials() throws Throwable {
		leanftpage.conditionValues();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify Member synced\"([^\"]*)\"$")
	public void i_choose_to_verify_member_synced(String salesdata) throws Throwable {
		leanftpage.verifyTableMaterial(salesdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to select Material as\"([^\"]*)\"$")
	public void i_choose_to_select_material_as(String transname) throws Throwable {
		leanftpage.selectMaterial(transname);
		BaseLib.embedScreenShotInreportWithRobot();
	}


	@Then("^I choose to set the FNBL status\"([^\"]*)\"$")
	public void i_choose_to_set_the_fnbl_status(String apttusdata) throws Throwable {
		leanftpage.saveWBS(apttusdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to get WBS Value$")
	public void i_choose_to_get_wbs_value() throws Throwable {
		leanftpage.getWBSValue();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to Enter WBS Value$")
	public void i_choose_to_enter_wbs_value() throws Throwable {
		leanftpage.enterWBSValue();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to navigate to Billing section$")
	public void i_choose_to_navigate_to_billing_section() throws Throwable {
		leanftpage.selectEnter();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to Enter required details on contract page\"([^\"]*)\"$")
	public void i_choose_to_enter_required_details_on_contract_page(String apttusdata) throws Throwable {
		leanftpage.enterContractDetails(apttusdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to Enter list of Materials to ZCQ contract\"([^\"]*)\"$")
	public void i_choose_to_enter_list_of_materials_to_zcq_contract(String apttusdata) throws Throwable {
		leanftpage.enterZCQmaterials(apttusdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to enter highvoltage values to ZCQ contract\"([^\"]*)\"$")
	public void i_choose_to_enter_highvoltage_values_to_zcq_contract(String apptusdata) throws Throwable {
		leanftpage.enterHighvoltageValues(apptusdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify the Item Category\"([^\"]*)\"$")
	public void i_choose_to_verify_the_item_category(String ApttusData) throws Throwable {
		leanftpage.verifyItemCategory(ApttusData);
		leanftpage.getSoldToNumber();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to select Header doc$")
	public void i_choose_to_select_header_doc() throws Throwable {
		leanftpage.selectHeaderDoc();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to select tab\"([^\"]*)\"and\"([^\"]*)\"$")
	public void i_choose_to_select_taband(String tabs, String tabname) throws Throwable {
		leanftpage.selectTabs(tabs, tabname);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify ship to value in PartnersTab\"([^\"]*)\"$")
	public void i_choose_to_verify_ship_to_value_in_partnerstab(String apttusdata) throws Throwable {
		leanftpage.verifyPartnersValues(apttusdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify PricingProcedure value\"([^\"]*)\"$")
	public void i_choose_to_verify_pricingprocedure_value(String apttusdata) throws Throwable {
		leanftpage.verifyPrcingProcedure(apttusdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}


	@Then("^I choose to enter Acceptance Date$")
	public void i_choose_to_enter_acceptance_date() throws Throwable {
		leanftpage.enterAcceptanceDate();
		BaseLib.embedScreenShotInreportWithRobot();
	}


	@Then("^I choose to verify Object status\"([^\"]*)\"$")
	public void i_choose_to_verify_object_status(String apttusdata) throws Throwable {
		leanftpage.verifyObjectStatus(apttusdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to select the Material\"([^\"]*)\"$")
	public void i_choose_to_select_the_material(String apttusdata) throws Throwable {
		leanftpage.selectAddedMaterial(apttusdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify Schedule lines\"([^\"]*)\"$")
	public void i_choose_to_verify_schedule_lines(String tabs) throws Throwable {
		leanftpage.verifySceduleLines(tabs);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to select line Item\"([^\"]*)\"and\"([^\"]*)\"$")
	public void i_choose_to_select_line_itemand(String apttusdata, String itemcategory) throws Throwable {
		leanftpage.selectLineItem(apttusdata, itemcategory);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to enter Parnters Data\"([^\"]*)\"$")
	public void i_choose_to_enter_parnters_data(String apttusdata) throws Throwable {
		leanftpage.enterParntersData(apttusdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose navigate back to OrderPage$")
	public void i_choose_navigate_back_to_orderpage() throws Throwable {
		leanftpage.naviagetBack();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to select value from MenuBar\"([^\"]*)\"$")
	public void i_choose_to_select_value_from_menubar(String apttusdata) throws Throwable {
		leanftpage.selectMenuBar(apttusdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}


	@Then("^I choose to verify status as Completed$")
	public void i_choose_to_verify_status_as_completed() throws Throwable {
		leanftpage.getStatusBarValue();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to save the created Order$")
	public void i_choose_to_save_the_created_order() throws Throwable {
		leanftpage.SaveOrder();
		BaseLib.embedScreenShotInreportWithRobot();
	}


	@And("^I choose to select the above created order$")
	public void i_choose_to_select_the_above_created_order() throws Throwable {
		leanftpage.selectCreatedOrder();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to Verify updated Acceptance date$")
	public void i_choose_to_verify_updated_acceptance_date() throws Throwable {
		leanftpage.verifyAcceptanceDate();
		BaseLib.embedScreenShotInreportWithRobot();
	}


	@And("^I choose to add bundle material\"([^\"]*)\"$")
	public void i_choose_to_add_bundle_material(String apttuddata) throws Throwable {
		leanftpage.addMaterial(apttuddata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to save the updated order$")
	public void i_choose_to_save_the_updated_order() throws Throwable {
		leanftpage.updatedOrder();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to select newly added line Item\"([^\"]*)\"$")
	public void i_choose_to_select_newly_added_line_itemsomething(String apttusdata) throws Throwable {
		leanftpage.selectNewLineItem(apttusdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify WBS value for all the line items$")
	public void i_choose_to_verify_wbs_value_for_all_the_line_items() throws Throwable {
		leanftpage.verifyWBSValues();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to select WBS value$")
	public void i_choose_to_select_wbs_value() throws Throwable {
		leanftpage.SelectWBSValue();
		BaseLib.embedScreenShotInreportWithRobot();
	}


	@Then("^I choose to verify Result Analysis Key$")
	public void i_choose_to_verify_result_analysis_key() throws Throwable {
		leanftpage.verifyResultkey();   
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify status of the released documnet\"([^\"]*)\"$")
	public void i_choose_to_verify_status_of_the_released_documnet(String apttusdata) throws Throwable {
		leanftpage.verifyDocument(apttusdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}


	@And("^I choose to Enter Order Number in Sales Document$")
	public void i_choose_to_enter_order_number_in_sales_document() throws Throwable {
		leanftpage.enterSalesDoc();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to release and Save the Sales document$")
	public void i_choose_to_release_and_save_the_sales_document() throws Throwable {
		leanftpage.selectReleaseSave();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to Save and Verify the status of project$")
	public void i_choose_to_save_and_verify_the_status_of_project() throws Throwable {
		leanftpage.saveandVerifyProject();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to select Project and select WBS value$")
	public void i_choose_to_select_project_and_select_wbs_value() throws Throwable {
		leanftpage.enterWBSElement();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to release the project$")
	public void i_choose_to_release_the_project() throws Throwable {
		leanftpage.selectProjectRelease();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify System status$")
	public void i_choose_to_verify_system_status() throws Throwable {
		leanftpage.verifySystemStatus();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to Enter project description Number$")
	public void i_choose_to_enter_project_description_number() throws Throwable {
		leanftpage.enterProjDescription();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify assignment table$")
	public void i_choose_to_verify_assignment_table() throws Throwable {
		leanftpage.verifyAssignments();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to get generated service Number$")
	public void i_choose_to_get_generated_service_number() throws Throwable {
		leanftpage.getSreviceNumber();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to Enter material value\"([^\"]*)\"$")
	public void i_choose_to_enter_material_valuesomething(String apttusdata) throws Throwable {
		leanftpage.enterMaterial(apttusdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to select view and class type$")
	public void i_choose_to_select_view_and_class_type() throws Throwable {
		leanftpage.selectView();
		leanftpage.selectClassType();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to select Aria Replication\"([^\"]*)\"$")
	public void i_choose_to_select_aria_replication(String apttusdata) throws Throwable {
		leanftpage.selectAriaReplication(apttusdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify Aria application content$")
	public void i_choose_to_verify_aria_application_content() throws Throwable {
		leanftpage.getAriaApplication();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify Aira plan data in Aria Replication$")
	public void i_choose_to_verify_aira_plan_data_in_aria_replication() throws Throwable {
		leanftpage.verifyAriaData();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify Aria child data in Aria Replication$")
	public void i_choose_to_verify_aria_child_data_in_aria_replication() throws Throwable {
		leanftpage.verifyAriaData();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to add the Main Project Member value$")
	public void i_choose_to_add_the_main_project_member_value() throws Throwable {
		leanftpage.setMprojectMemberValue();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify Acceptance date missing message and Save$")
	public void i_choose_to_verify_acceptance_date_missing_message_and_save() throws Throwable {
		leanftpage.verifyAcceptanceDateErrorAndSave();
		BaseLib.embedScreenShotInreportWithRobot();
	}


	@Then("^I choose to verify the H1 Site missing message and Save$")
	public void i_choose_to_verify_the_h1_site_missing_message_and_save() throws Throwable {
		leanftpage.verifyAcceptanceDateErrorAndSave();
		BaseLib.embedScreenShotInreportWithRobot();
	}


	@And("^I choose to add partner function as\"([^\"]*)\"$")
	public void i_choose_to_add_partner_function_as(String apttusdata) throws Throwable {
		leanftpage.enterPartnerFunction(apttusdata);   
		BaseLib.embedScreenShotInreportWithRobot();
	}


	@And("^I choose to add the missing data to complete log$")
	public void i_choose_to_add_the_missing_data_to_complete_log() throws Throwable {
		leanftpage.completeData();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to Enter Filed length\"([^\"]*)\"$")
	public void i_choose_to_enter_filed_length(String name) throws Throwable {
		leanftpage.enterFildName(name);
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@Then("^I choose to Execute the table$")
	public void i_choose_to_execute_the_table() throws Throwable {
		leanftpage.selectExecute();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify the table$")
	public void i_choose_to_verify_the_table() throws Throwable {
		leanftpage.verifyTable();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to enter package value and Execute$")
	public void i_choose_to_enter_package_value_and_execute() throws Throwable {
		leanftpage.enterpackageValue();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to select the variant type as\"([^\"]*)\"$")
	public void i_choose_to_select_the_variant_type_as(String varname) throws Throwable {
		leanftpage.selectVariant(varname);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to Enter required details on contract page\"([^\"]*)\" and day as\"([^\"]*)\"$")
	public void i_choose_to_enter_required_details_on_contract_page_and_day_as(String apttusdata, int day) throws Throwable {
		leanftpage.PODateChanges(apttusdata, day);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to Enter required details on contract page\"([^\"]*)\" and PODate as Null$")
	public void i_choose_to_enter_required_details_on_contract_page_and_podate_as_null(String apttusdata) throws Throwable {
		leanftpage.null_PODATE(apttusdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}


	@And("^I choose to veriy the contract missing date message and Save$")
	public void i_choose_to_veriy_the_contract_missing_date_message_and_save() throws Throwable {
		leanftpage.verifyAcceptanceDateErrorAndSave();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to select PO date as Null$")
	public void i_choose_to_select_po_date_as_null() throws Throwable {

	}

	@And("^I choose to select Display document for verification$")
	public void i_choose_to_select_display_document_for_verification() throws Throwable {
		leanftpage.documentFlowVerification();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify PO date$")
	public void i_choose_to_verify_PO_date() throws Throwable {
		leanftpage.verifyPODate();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify line item$")
	public void i_choose_to_verify_line_item() throws Throwable {

	}

	@Then("^I choose to verify Item Category\"([^\"]*)\"$")
	public void i_choose_to_verify_Item_Category(String ApttusData) throws Throwable {
		leanftpage.verifydocumentCategory(ApttusData);
		BaseLib.embedScreenShotInreportWithRobot();
	}


	@Then("^I choose to verfy Additional data values\"([^\"]*)\"$")
	public void i_choose_to_verfy_additional_data_values(String apttusdata) throws Throwable {
		leanftpage.verifyadditionalData(apttusdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify Condition group Value$")
	public void i_choose_to_verify_condition_group_value() throws Throwable {
		leanftpage.verifyConditionGroup();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to remove the data added in uploaded file$")
	public void i_choose_to_remove_the_data_added_in_uploaded_file() throws Throwable {

	}
	@And("^I choose to Enter Target Value\"([^\"]*)\"$")
	public void i_choose_to_enter_target_value(String testdata) throws Throwable {
		leanftpage.enterTarget(testdata);
		leanftpage.continueMaterials();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to Enter Order quantity as\"([^\"]*)\"$")
	public void i_choose_to_enter_order_quantity_as(String testdata) throws Throwable {
		leanftpage.enterOrder(testdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to change the Billing plan for contract periodic year$")
	public void i_choose_to_change_the_billing_plan_for_contract_periodic_year() throws Throwable {
		leanftpage.changePeriodicYr();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^I choose to navigate back to main Page table\"([^\"]*)\"$")
	public void i_choose_to_navigate_back_to_main_page_table(String tablename) throws Throwable {
		leanftpage.naviagtetomainPage(tablename);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to select the Project row$")
	public void i_choose_to_select_the_project_row() throws Throwable {
		leanftpage.selectProjectmanager();
		BaseLib.embedScreenShotInreportWithRobot();

	}

	@Then("^I choose to Enter Project Manager details\"([^\"]*)\"$")
	public void i_choose_to_enter_project_manager_detailss(String testdata) throws Throwable {
		leanftpage.enterManagerDetails(testdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to Enter contractDetails as\"([^\"]*)\"$")
	public void i_choose_to_enter_contractdetails_as(String testdata) throws Throwable {
		leanftpage.enterOrderDetails(testdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to Enter Contract Number and create Reference$")
	public void i_choose_to_enter_contract_number_and_create_reference() throws Throwable {
		leanftpage.enterRefContract();
		BaseLib.embedScreenShotInreportWithRobot();

	}

	@Then("^I choose add the Target Value$")
	public void i_choose_add_the_target_value() throws Throwable {
		leanftpage.enterTagetValue();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to add new Material\"([^\"]*)\"$")
	public void i_choose_to_add_new_materialsomething(String testdata) throws Throwable {
		leanftpage.addNewMaterial(testdata);
		BaseLib.embedScreenShotInreportWithRobot();

	}

	@Then("^I choose to verify the conditions$")
	public void i_choose_to_verify_the_conditions() throws Throwable {
		leanftpage.verifyConditions();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to add the route values$")
	public void i_choose_to_add_the_route_values() throws Throwable {
		leanftpage.addRouteValue();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to change ItemCategory for line Item\"([^\"]*)\"and\"([^\"]*)\"$")
	public void i_choose_to_change_itemcategory_for_line_itemand(String testdata, String itemValue) throws Throwable {
		leanftpage.changeItemCategory(testdata, itemValue);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to Save the Contract$")
	public void i_choose_to_save_the_contract() throws Throwable {
		leanftpage.SavePopup();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to Enter program execute details\"([^\"]*)\"$")
	public void i_choose_to_enter_program_execute_details(String testdata) throws Throwable {
		leanftpage.enterProgramvalues(testdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to Enter the SettlementWBS values$")
	public void i_choose_to_enter_the_settlementwbs_values() throws Throwable {
		leanftpage.enterSetlementWBS();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify Process values$")
	public void i_choose_to_verify_process_values() throws Throwable {
		leanftpage.verifyProcessedValues();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify cat and percentage value from\"([^\"]*)\"as\"([^\"]*)\"$")
	public void i_choose_to_verify_cat_and_percentage_value_fromas(String distributiontable, String testdata) throws Throwable {
		leanftpage.verifyDistributionValues(distributiontable, testdata);
		BaseLib.embedScreenShotInreportWithRobot();

	}

	@And("^I choose to select all WBS values as\"([^\"]*)\"$")
	public void i_choose_to_select_all_wbs_values_as(String wbstable) throws Throwable {
		leanftpage.selectWBSValues(wbstable);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify Plan values$")
	public void i_choose_to_verify_plan_values() throws Throwable {
		leanftpage.verifyWBSObject();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to select logical PSJ and Execute$")
	public void i_choose_to_select_logical_psj_and_execute() throws Throwable {
		leanftpage.select_logicalPSI();
		leanftpage.execute_PMselection();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to make block value empty$")
	public void i_choose_to_make_block_value_empty() throws Throwable {
		leanftpage.enterBlockValue();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to save the Billing document$")
	public void i_choose_to_save_the_billing_document() throws Throwable {
		leanftpage.saveBillingDoc();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to Enter the details\"([^\"]*)\"$")
	public void i_choose_to_enter_the_details(String testdata) throws Throwable {
		leanftpage.enterpSCONdetails(testdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to assign Equipments to Contract$")
	public void i_choose_to_assign_equipments_to_contract() throws Throwable {
		leanftpage.assignEquipmentTocontract();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to select the material value row\"([^\"]*)\"$")
	public void i_choose_to_select_the_material_value_row(String testdata) throws Throwable {
		leanftpage.Material(testdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify Equipment in Contract$")
	public void i_choose_to_verify_equipment_in_contract() throws Throwable {
		leanftpage.verifyequipmentInContract();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to unassign Equipment to the Contract$")
	public void i_choose_to_unassign_equipment_to_the_contract() throws Throwable {
		leanftpage.un_assignEquipmentTocontract();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to add route and value and Acceptance date$")
	public void i_choose_to_add_route_and_value_and_acceptance_date() throws Throwable {
		leanftpage.enterAceeptance_route();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify Addocunting document Amount value$")
	public void i_choose_to_verify_addocunting_document_amount_value() throws Throwable {
		leanftpage.verifyAccountingDocumnet();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to verify documents$")
	public void i_choose_to_verify_documents() throws Throwable {
		leanftpage.verifycreatedDocuments();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to enter Accounting details\"([^\"]*)\"$")
	public void i_choose_to_enter_accounting_details(String testdata) throws Throwable {
		leanftpage.enterAccountData(testdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to apply collective processing$")
	public void i_choose_to_apply_collective_processing() throws Throwable {
		leanftpage.updateCollectiveProcessing();
		BaseLib.embedScreenShotInreportWithRobot();
	}


	@And("^I choose to enter revenue recogintion data\"([^\"]*)\"$")
	public void i_choose_to_enter_revenue_recogintion_data(String testdata) throws Throwable {
		leanftpage.enterRevenue(testdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify Revenue cost and cuurency values$")
	public void i_choose_to_verify_revenue_cost_and_cuurency_values() throws Throwable {
		leanftpage.displayRevenue();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to Enter sales document Number$")
	public void i_choose_to_enter_sales_document_number() throws Throwable {
		leanftpage.enterSalesDocumnet();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify Revenue amount$")
	public void i_choose_to_verify_Revenue_amount() throws Throwable {
		leanftpage.verify_currencyValueinTable();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify Execute type$")
	public void i_choose_to_verify_execute_type() throws Throwable {
		leanftpage.verifyExecute_type();
		BaseLib.embedScreenShotInreportWithRobot();
	}


	@And("^I choose to add special characters to customer Name\"([^\"]*)\"and\"([^\"]*)\"$")
	public void i_choose_to_add_special_characters_to_customer_nameand(String apttusdata, String specialchar) throws Throwable {
		leanftpage.addspecial_ChartoCustomer(apttusdata, specialchar);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to reset customer name to default\"([^\"]*)\"$")
	public void i_choose_to_reset_customer_name_to_defaultsomething(String apttusdata) throws Throwable {
		leanftpage.setCustomerName_default(apttusdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to get the order Number$")
	public void i_choose_to_get_the_order_number() throws Throwable {
		leanftpage.getorderNumber();
	}


	@And("^I choose set Billing block as\"([^\"]*)\"$")
	public void i_choose_set_billing_block_as(String combobox) throws Throwable {
		leanftpage.selectBillingBlock(combobox);
	}

	@Then("^I choose to verify GL Account number$")
	public void i_choose_to_verify_gl_account_number() throws Throwable {
		leanftpage.verify_GLAccountNum();
	}

	@And("^I choose to enter document number and copy materials$")
	public void i_choose_to_enter_document_number_and_copy_materials() throws Throwable {
		leanftpage.selectbillingContractDetails();
	}

	@And("^I choose to select order value as\"([^\"]*)\"from\"([^\"]*)\"$")
	public void i_choose_to_select_order_value_asfrom(String value, String options) throws Throwable {
		leanftpage.orderreasonName(value, options);
	}

	@Then("^I choose to save the credit order$")
	public void i_choose_to_save_the_credit_order() throws Throwable {
		leanftpage.saveCredit();
	}

	@Then("^I choose to get screenshot of all the documents$")
	public void i_choose_to_get_screenshot_of_all_the_documents() throws Throwable {
		leanftpage.get_screenshot();
	}

	@And("^I choose to enter Contract dates$")
	public void i_choose_to_enter_contract_dates() throws Throwable {
		leanftpage.contractDates();
	}

	@Then("^I choose to save the reference contract$")
	public void i_choose_to_save_the_reference_contract() throws Throwable {
		leanftpage.save_Contract();
	}

	@And("^I choose to verify and Save created contract$")
	public void i_choose_to_verify_and_save_created_contract() throws Throwable {
		leanftpage.enterbillingValue_Save();
	}

	@And("^I choose to verify credit debit contract details and Save$")
	public void i_choose_to_verify_credit_debit_contract_details_and_save() throws Throwable {
		leanftpage.verify_credit_debit();
	}

	@And("^I choose to enter created reference contract$")
	public void i_choose_to_enter_created_reference_contract() throws Throwable {
		leanftpage.enter_referenceContract();
	}

	@And("^I choose to Enter Reference contract in Sales Document$")
	public void i_choose_to_enter_reference_contract_in_sales_document() throws Throwable {
		leanftpage.enterReferenceDoc();
	}


	@And("^I choose to select Display Document$")
	public void i_choose_to_select_display_document() throws Throwable {
		leanftpage.selectDisplayDocument();
	}

	@Then("^I choose to Enter new Condition\"([^\"]*)\"and\"([^\"]*)\"$")
	public void i_choose_to_enter_new_conditionand(String conditionname, String amount) throws Throwable {
		leanftpage.enterQuantity(conditionname, amount);   
	}

	@And("^I choose to Enter output device name\"([^\"]*)\"$")
	public void i_choose_to_enter_output_device_name(String device) throws Throwable {
		leanftpage.enterDevicename_Save(device);
	}

	@Then("^I choose to verify program status$")
	public void i_choose_to_verify_program_status() throws Throwable {
		leanftpage.verifyprogramStatus();
	}

	@And("^I choose to enter Program name as\"([^\"]*)\"and Execute$")
	public void i_choose_to_enter_program_name_asand_execute(String program1) throws Throwable {
		leanftpage.enterprogram_Name(program1);
	}

	@And("^I choose to enter program document details$")
	public void i_choose_to_enter_program_document_details() throws Throwable {
		leanftpage.enterProgram_documentDetails();
	}

	@Then("^I choose to verify message and contract Numer$")
	public void i_choose_to_verify_message_and_contract_numer() throws Throwable {
		leanftpage.verify_Contract_Sales();
	}

	@Then("^I choose to get Sales document Number$")
	public void i_choose_to_get_sales_document_number() throws Throwable {
		leanftpage.getSalescreatedNumber();
	}

	@And("^I choose to create Spool requests$")
	public void i_choose_to_create_spool_requests() throws Throwable {
		// leanftpage.create_SpoolRequest();
		leanftpage.create_SpoolRequest();
	}

	@Then("^I choose to verify above created sales document$")
	public void i_choose_to_verify_above_created_sales_document() throws Throwable {
		leanftpage.verifysalesDoc();
	}

	@And("^I choose to continue with exist contract$")
	public void i_choose_to_continue_with_exist_contract() throws Throwable {
		leanftpage.leanFtEnter();
	}

	@Then("^I choose to set Customer group value as\"([^\"]*)\"$")
	public void i_choose_to_set_customer_group_value_as(String testdata) throws Throwable {
		leanftpage.setCommercialGroup(testdata);
	}

	@And("^I choose to select Purchase order$")
	public void i_choose_to_select_purchase_order() throws Throwable {
		leanftpage.selectPurchaseOrder();
	}

	@Then("^I choose to verify Vendor value\"([^\"]*)\"$")
	public void i_choose_to_verify_vendor_valuesomething(String testdata) throws Throwable {
		leanftpage.verify_Vendor(testdata);
	}

	@And("^I choose to get IDOC value$")
	public void i_choose_to_get_idoc_value() throws Throwable {
		leanftpage.get_Idoc();
	}


	@Then("^I choose to verify IDOC value$")
	public void i_choose_to_verify_idoc_value() throws Throwable {
		leanftpage.verifyIDOC();
	}

	@Given("^I choose to login to SAP system\"([^\"]*)\"and client\"([^\"]*)\"$")
	public void i_choose_to_login_to_sap_systemand_client(String mbq, String client) throws Throwable {
		leanftpage.launchSAP(mbq, client);
	}


	@And("^I choose to remove Materials$")
	public void i_choose_to_remove_materials() throws Throwable {
		leanftpage.remove_materials();
	}

	@And("^I choose to select material from\"([^\"]*)\"and\"([^\"]*)\"$")
	public void i_choose_to_select_material_fromand(String tablename, String materialvalue) throws Throwable {
		leanftpage.activate_Material(tablename, materialvalue);
	}

	@And("^I choose to add the telephone number$")
	public void i_choose_to_add_the_telephone_number() throws Throwable {
		leanftpage.enter_Telephone();
	}

	@Then("^I choose to get the purchase order value$")
	public void i_choose_to_get_the_purchase_order_value() throws Throwable {
		leanftpage.get_purchaseOrder_Number();
	}

	@Then("^I choose to verify status$")
	public void i_choose_to_verify_status() throws Throwable {
		leanftpage.status();
	}

	@And("^I choose to enter purchase order value$")
	public void i_choose_to_enter_purchase_order_value() throws Throwable {
		leanftpage.enter_purchaseNumber();
	}

	@And("^I choose to get sales number$")
	public void i_choose_to_get_sales_number() throws Throwable {
		leanftpage.verify_getPO_sales();
	}

	@Then("^I choose to verify contract Information$")
	public void i_choose_to_verify_contract_information() throws Throwable {
		leanftpage.verifyCOntract_Info();
	}

	@Then("^I choose to verify Amount\"([^\"]*)\"$")
	public void i_choose_to_verify_amount(String testdata) throws Throwable {
		leanftpage.verifyconditions_AMount(testdata);
	}

	@And("^I choose to add the required data$")
	public void i_choose_to_add_the_required_data() throws Throwable {
		leanftpage.add_additionalData_B_values();
	}

	@Then("^I choose to Save$")
	public void i_choose_to_save() throws Throwable {
		leanftpage.save();
	}


	@Then("^I choose to get Invoice IDOC$")
	public void i_choose_to_get_invoice_idoc() throws Throwable {
		leanftpage.get_InvoiceIDOC();
	}

	@And("^I choose to enter Equipment\"([^\"]*)\"$")
	public void i_choose_to_enter_equipment(String testdata1) throws Throwable {
		leanftpage.addEquipment(testdata1);
	}

	@When("^I choose to create process notification\"([^\"]*)\"$")
	public void i_choose_to_create_process_notification(String testData1) throws Throwable {
		leanftpage.create_processNotify(testData1);
		leanftpage.release_completeNotification();
	}

	@Then("^I choose to save equipment order$")
	public void i_choose_to_save_equipment_order() throws Throwable {
		leanftpage.saveEquipmentOrder();
	}

	@Then("^I choose to verify notification value$")
	public void i_choose_to_verify_notification_value() throws Throwable {
		leanftpage.verify_notification();
	}

	@Then("^I choose to add work details and Save\"([^\"]*)\"$")
	public void i_choose_to_add_work_details_and_save(String testdata1) throws Throwable {
		leanftpage.enter_workDetails_Save(testdata1);
	}

	@Then("^I choose to verify labour cost$")
	public void i_choose_to_verify_labour_cost() throws Throwable {
		leanftpage.verfiyCost();
	}

	@Then("^I choose to set User status and Save\"([^\"]*)\"$")
	public void i_choose_to_set_user_status_and_save(String testdata1) throws Throwable {
		leanftpage.setUser_Status_Save(testdata1);
	}

	@Then("^I choose to verify the protocal message$")
	public void i_choose_to_verify_the_protocal_message() throws Throwable {
		leanftpage.enter_ZUCO_order();
	}

	@And("^I choose to enter document value\"([^\"]*)\"$")
	public void i_choose_to_enter_document_value(String testdata1) throws Throwable {
		leanftpage.enter_document(testdata1);
	}

	@Then("^I choose to verify zuco order$")
	public void i_choose_to_verify_zuco_order() throws Throwable {
		leanftpage.verifydocument();
	}

	@Then("^I choose to verify the wbs values\"([^\"]*)\"$")
	public void i_choose_to_verify_the_wbs_values(String testdata1) throws Throwable {
		leanftpage.verifyWBS(testdata1);
	}

	@Then("^I choose to verify POC value$")
	public void i_choose_to_verify_poc_value() throws Throwable {
		leanftpage.verifyPOC();
	}

	@And("^I choose to add WBS data$")
	public void i_choose_to_add_wbs_data() throws Throwable {
		leanftpage.verifyWBS();
	}


	@Then("^I choose to enter function Module \"([^\"]*)\" and execute$")
	public void i_choose_to_enter_function_module(String functionModuleid) throws Throwable {
		leanftpage.enterFunctionModule(functionModuleid);
	}

	@And("^I choose to click on Test data Directory$")
	public void i_choose_to_click_on_Test_data_directory() throws Throwable {
		leanftpage.click_on_TestDataDirectory();
	}

	@And("^I choose to select the entries$")
	public void i_choose_to_select_the_entries() throws Throwable {
		leanftpage.selectEntries();
	}


	@Then("^I choose to create salesdeal by changing its name \"([^\"]*)\"$")
	public void i_choose_to_create_sales_deal(String newsalesdeal) throws Throwable {
		leanftpage.createsalesdeal(newsalesdeal);
	}

	@Then("^I choose to create salesdeal by changing its name \"([^\"]*)\" and find variant \"([^\"]*)\"$")
	public void i_choose_to_create_sales_deal_and_final_variant(String newsalesdeal,String value) throws Throwable {
		leanftpage.salesdealcreationandchangevalue(newsalesdeal,value);
	}

	@And("^I choose to execute$")
	public void i_choose_to_execute() throws Throwable {
		leanftpage.execute();
	}

	@And("^I choose to change contract Type$")
	public void i_choose_to_change_contracttype() throws Throwable {
		leanftpage.changecontractType();
	}

	@Then("^I choose to search saledeal that created \"([^\"]*)\" and click on Environment changes$")
	public void i_choose_to_search_salesdeal_that_created_and_click_on_environmet_changes(String salesdeal) throws Throwable {
		leanftpage.entersalesdealsearch(salesdeal);
	}

	@And("^I choose to validate the contract old and new value$")
	public void i_choose_to_validate_contracttype() throws Throwable {
		leanftpage.verifychanges();
	}


	@And("^I choose to select Display document for verification\"([^\"]*)\"$")
	public void i_choose_to_select_display_document_for_verification(String name) throws Throwable {
		leanftpage.documentFlowVerification(name);
	}

	@And("^I choose to select the document\"([^\"]*)\"$")
	public void i_choose_to_select_the_document(String contractnum) throws Throwable {
		leanftpage.selectDocument(contractnum);
	}

	@Then("^I choose enter required sales details and Save\"([^\"]*)\"\"([^\"]*)\"$")
	public void i_choose_enter_required_sales_details_and_savesomething(String salesdata,String agreement) throws Throwable {
		leanftpage.enterRequiredSalesdealDetails(salesdata,agreement);
	}

	@And("^I choose to select Agreement display$")
	public void i_choose_to_select_agreement_display() throws Throwable {
		leanftpage.selectAgreementDisplay();
	}

	@Then("^I choose to verify the created sales data\"([^\"]*)\"$")
	public void i_choose_to_verify_created_salesdata(String value) throws Throwable {
		leanftpage.verifycreatedsalesdata(value);
	}


	@And("^I choose to select Agreement change option$")
	public void i_choose_to_select_agreement_change() throws Throwable {
		leanftpage.selectAgreementChange();
	}


	@Then("^I choose to update the sales deal values\"([^\"]*)\"\"([^\"]*)\"$")
	public void i_choose_to_update_sales_deal_values(String behaviour, String terms) throws Throwable {
		leanftpage.updateSalesDealValues(behaviour,terms);
	}

	@Then("^I choose to verify the updated sales data\"([^\"]*)\"\"([^\"]*)\"$")
	public void i_choose_to_verify_updated_sales_deal_values(String behaviour, String terms) throws Throwable {
		//leanftpage.selctenvironmentchnage();
		leanftpage.verifyUpdatesalesdata(behaviour,terms);
	}

	@And("^I choose to reneter the sales deal details and save the record \"([^\"]*)\"$")
	public void i_choose_to_renter_sales_deal_detaisl(String agreementname) throws Throwable {
		leanftpage.ReenteSalesdealDetails(agreementname);
	}


	@And("^I choose to enter reference equipment Number \"([^\"]*)\"$")
	public void i_choose_to_enter_reference_equipment_Number(String refequ) throws Throwable {
		leanftpage.enterReferanceEquipmentNo(refequ);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to sync equipment to smax$")
	public void i_choose_to_sync_equipment_to_smax() throws Throwable {
		leanftpage.syncIPtoSMAX();
	}


	@Then("^I choose to enter Serial Number$")
	public void i_choose_to_enter_Serial_Number() throws Throwable {
		leanftpage.enterSerialNumber();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to read all the SAP data required for Tc \"([^\"]*)\"$")
	public void i_choose_to_read_all_the_SAP_data_required_for_Tc(String TCNumber) throws Throwable {
		leanftpage.readTestDataforSAP(TCNumber);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to save the updated the record$")
	public void i_choose_to_save_the_updated_the_record() throws Throwable {
		leanftpage.saveRecord();
	}

	@And("^I choose navigate back to previousPage$")
	public void i_choose_navigate_back_to_previousPage() throws Throwable {
		leanftpage.naviagetBack();
		BaseLib.embedScreenShotInreportWithRobot();

	}

	@And("^I choose to verify Created IP stage is \"([^\"]*)\" in SMAX for \"([^\"]*)\"$")
	public void i_choose_to_verify_Created_IP_stage_is(String stage, String equipment) throws Throwable {
		leanftpage.IPStageinSMAX(stage, equipment);
		BaseLib.embedScreenShotInreportWithRobot();
	}


	@When("^I choose to enters SAP Order nubmer \"([^\"]*)\"$")
	public void user_enters_SAPOrderNumber(String order) throws Throwable {
		leanftpage.enter_SAPOrderNumber(order);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^I choose to click on Header details icon$")
	public void click_on_header_details_icon() throws GeneralLeanFtException {
		leanftpage.click_on_HeaderDetailsIcon();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^I choose to Verify the field sales area data with values \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
	public void verify_sales_area_data(String SA1,String SA2,String SA3) throws Throwable {
		leanftpage.VerifySalesareaData(SA1,SA2,SA3);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^I choose to verify the field customer group \"([^\"]*)\" and SalesOffice under Sales tab are populated$")
	public void verify_customer_group_and_salesoffice(String Customergrp) throws Throwable {
		leanftpage.VerifycustomerGroup_and_salesoffice(Customergrp);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^I choose to verify that Business Area is populated$")
	public void verify_BusinessArea() throws GeneralLeanFtException {
		leanftpage.verifyBusinessArea();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^I choose to verify that Business Area should be null$")
	public void verify_BusinessArea_null() throws GeneralLeanFtException {
		leanftpage.verifyBusinessAreashouldNull();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^I choose to verify the field customer group$")
	public void verify_CG() throws GeneralLeanFtException {
		leanftpage.verifyCG();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^I choose to enter the Table name\"([^\"]*)\"$")
	public void enter_tablename(String Tablename) throws Exception {
		leanftpage.enterTablename(Tablename);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^I choose to enter the salesorg \"([^\"]*)\" , DistrChannel \"([^\"]*)\" and Customergrp \"([^\"]*)\"$")
	public void enter_salesorg_distrchannel(String SA1,String SA2,String Cg) throws Throwable {
		leanftpage.enter_salesorg_Distrchannel_customergrp(SA1,SA2,Cg);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^I choose to click on execute icon$")
	public void choose_to_click_on_execute_icon() throws GeneralLeanFtException {
		leanftpage.executeicon();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^I choose to Verify there is a column Business Area and Customer Group$")
	public void choose_to_verify_column_BA_and_CG() throws GeneralLeanFtException {
		leanftpage.Verifycolumns_BA_and_CG();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@And("^I choose to select AccAssignemnt tab\"([^\"]*)\"and\"([^\"]*)\"$")
	public void i_choose_to_select_Account_Assignmenttab(String tabs, String tabname) throws Throwable {
		leanftpage.select_Tabs(tabs, tabname);
	}

	@When("^I choose to select the row and click on choose icon \"([^\"]*)\"$")
	public void choose_to_select_row_and_choose_icon(String table) throws Exception {
		leanftpage.selectrow_chooseicon(table);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^I choose to Verify the value of Plant Service and Service Org$")
	public void choose_to_verify_plantservice_serviceorg() throws Exception {
		leanftpage.verifyplantservice_serviceorg();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to enter tablename \"([^\"]*)\" in general table display page$")
	public void i_choose_to_enter_tablename_in_general_table_display_page(String TN) throws Throwable {
		leanftpage.entertablenameinGeneraltabledisplayPage(TN);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to enter Document Number \"([^\"]*)\"$")
	public void i_choose_to_enter_documentNumber(String SO) throws Throwable {
		leanftpage.enterdocumentNumber(SO);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to verify Plantservice and serviceorg in this general Table with \"([^\"]*)\"$")
	public void i_choose_to_verify_Plantservice_and_serviceorg_in_generaltable(String SA) throws Throwable {
		leanftpage.verifyPlantservice_and_Serviceorg(SA);
		BaseLib.embedScreenShotInreportWithRobot();
	}



	@Then("^I choose to verify status value as\"([^\"]*)\"$")
	public void i_choose_to_verify_status_value_as(String status) throws Throwable {
		leanftpage.verifyStatus(status);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to Enter Equipment number\"([^\"]*)\"$")
	public void i_choose_to_enter_equipment_numbersomething(String ip) throws Throwable {
		leanftpage.enterIPNumber(ip);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify Functional location$")
	public void i_choose_to_verify_functional_location() throws Throwable {
		leanftpage.verify_functionalLocation();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify Sold TO and Ship To values$")
	public void i_choose_to_verify_sold_to_and_ship_to_values() throws Throwable {
		leanftpage.verifyAccountIP();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify Functional as null$")
	public void i_choose_to_verify_functional_as_null() throws Throwable {
		leanftpage.verifyFunctional_null();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to upload the PC\"([^\"]*)\"$")
	public void i_choose_to_upload_the_pc(String workcenter) throws Throwable {
		leanftpage.savePC(workcenter);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to Enter Functioanl Location\"([^\"]*)\"$")
	public void i_choose_to_enter_functioanl_location(String function) throws Throwable {
		leanftpage.enter_Functional(function);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to select above created IP$")
	public void i_choose_to_select_above_created_ip() throws Throwable {
		leanftpage.sapCreatedIP();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify child record$")
	public void i_choose_to_verify_child_record() throws Throwable {
		leanftpage.verify_childRecords();
		BaseLib.embedScreenShotInreportWithRobot();
	}


	@Then("^I choose to deliver the order$")
	public void i_choose_to_deliver_order() throws Throwable {
		leanftpage.dliverorder();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to pack the order$")
	public void i_choose_to_pack_order() throws Throwable {
		leanftpage.clickonpackorder();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to do single part delivery$")
	public void i_choose_to_do_singlepartdelivery() throws Throwable {
		leanftpage.singlepartdelivery();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to Process Outbound Delivery$")
	public void i_choose_to_do_outboundDelivery() throws Throwable {
		leanftpage.ProcessingofHandling();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to add Serial Number$")
	public void i_choose_to_add_serial_number() throws Throwable {
		leanftpage.enterserialNumber();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to click on Post Good Issue$")
	public void i_choose_to_click_onPGI() throws Throwable {
		leanftpage.clickonPGI();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^I choose to enter ASO Number$")
	public void i_choose_to_enter_aso_number() throws Throwable {
		leanftpage.enter_ASONumberInSAP();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify whether the delivery has saved$")
	public void i_choose_to_verify_delivery_has_saved() throws Throwable {
		leanftpage.clickonPGI();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to get ASO Number$")
	public void i_choose_to_get_ASO_Number() throws Throwable {
		leanftpage.getASONumber();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify sales document\"([^\"]*)\"$")
	public void i_choose_to_verify_sales_document(String salesdoc) throws Throwable {
		leanftpage.verifySWO(salesdoc);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^User enters SAPSWO nubmer gererated in servicemax$")
	public void User_enters_SAPSWO_number() throws Exception {
		//leanftpage.serviceMaxdata();
		leanftpage.SearchSAPSWO();  
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^User access Operations Tab$")
	public void user_access_Operations_Tab() throws Throwable {
		leanftpage.clickonOperationsTab();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^User Verifies the values present in Operations Tab$")
	public void user_Verifies_the_values_present_in_Operations_Tab() throws Throwable {
		leanftpage.verifiOperationsTablevalues();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^User Clicks on Enhancement Button$")
	public void user_Clicks_on_Enhancement_Button() throws Throwable {
		leanftpage.clickEnhancementbutton();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^User Verifies Enhanceent Details$")
	public void user_Verifies_Enhanceent_Details() throws Throwable {
		LeanFTPage.verifyenhancemnetvalues();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^User click on Back Button$")
	public void user_click_on_Back_Button() throws Throwable {
		leanftpage.clickBackbutton();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^User Access Settlement Tab$")
	public void user_Access_Settlement_Tab() throws Throwable {
		leanftpage.verifySettlementTable();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^User Verifies Settlement Details$")
	public void user_Verifies_Settlement_Details() throws Throwable {
		leanftpage.verifySettlementTablevalues();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^Users click on Back button in Settlements page$")
	public void users_click_on_Back_button_in_Settlements_page() throws Throwable {
		leanftpage.clicksetellmentBackbutton();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^User access Confirmation Page$")
	public void user_access_Confirmation_Page() throws Throwable {
		leanftpage.accessConfirmationPae();
		BaseLib.embedScreenShotInreportWithRobot();

	}

	@When("^user verifies Confirmation Page Details$")
	public void user_verifies_Confirmation_Page_Details() throws Throwable {
		leanftpage.verifyconfirmationValues();
		BaseLib.embedScreenShotInreportWithRobot();

	}

	@When("^user Access Main SAP Page$")
	public void user_Access_Main_SAP_Page() throws Throwable {
		LeanFTPage.navigatetoMainwindow();
		BaseLib.embedScreenShotInreportWithRobot();

	}

	@When("^User Enters Tcode \"([^\"]*)\"$")
	public void user_Enters_Tcode(String arg1) throws Throwable {
		LeanFTPage.sapenterTAcode_I2M(arg1);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^User Search contract bar$")
	public void user_Search_contract_bar() throws Throwable {
		leanftpage.Searchcontractnbr();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^User Access Sales Details page$")
	public void user_Access_Sales_Details_page() throws Throwable {
		leanftpage.salesPage();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^User Verifes Sales details$")
	public void user_Verifes_Sales_details() throws Throwable {
		LeanFTPage.verifySalesareadata();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose Enter SWO created in above step$")
	public void i_choose_enter_swo_created_in_above_step() throws Throwable {
		leanftpage.enter_sapSWO();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to get SAP SWO Number$")
	public void i_choose_to_get_SAP_SWO_Number() throws Throwable {
		leanftpage.getSAPSWONumber();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to enter SWO Number$")
	public void i_choose_toenter_SWO_Number() throws Throwable {
		leanftpage.enterSWO();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to navigate to Goods Movements$")
	public void i_choose_to_navigate_to_good_movements() throws Throwable {
		leanftpage.navigateToGoodsmovemnets();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to validate MovementType and Batch$")
	public void i_choose_validate_movementType_and_batch() throws Throwable {
		leanftpage.validateMovementTypeandBatch();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify the Valuation from Confirmed and Returned Parts$")
	public void i_choose_to_get_valuation_from_ConfirmedReturned_parts() throws Throwable {
		leanftpage.getValuationFromparts();
		BaseLib.embedScreenShotInreportWithRobot();

	}


	@Then("^I choose to verify SAP Integration status$")
	public void i_choose_to_verify_SAP_Integration_status() throws Throwable {
		leanftpage.SAPIntegrationstatus();
		BaseLib.embedScreenShotInreportWithRobot();
	}



	@Then("^I choose Search contract$")
	public void i_choose_to_search_contract() throws Throwable {
		leanftpage.Searchcontract();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify the Netvalue with Total Contract Price$")
	public void i_choose_to_verify_netvalue_with_TCP() throws Throwable {
		leanftpage.getNetvalueandverify();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to update\"([^\"]*)\"and\"([^\"]*)\"values$")
	public void i_choose_to_updatesomethingandsomethingvalues(String packing, String identification) throws Throwable {
		leanftpage.add_packing_idebtification(packing, identification);
		BaseLib.embedScreenShotInreportWithRobot();
	}


	@Then("^I choose to save the Delivery$")
	public void i_choose_to_save_the_delivery() throws Throwable {
		leanftpage.save_delivery();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to select PGI for above created document$")
	public void i_choose_to_select_pgi_for_above_created_document() throws Throwable {
		leanftpage.add_document_PGI();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify contact details created in SMAX$")
	public void i_choose_to_verify_contact_details_created_in_SMAX() throws Throwable {
		leanftpage.verifyContactDetails();
		BaseLib.embedScreenShotInreportWithRobot();

	}

	@Then("^I choose to verify Account Indicator$")
	public void i_choose_verify_account_indication_headerpage() throws Throwable {
		leanftpage.verifyAcctIndicatorAcctpage();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify account Indicator on Planner Actual comparision page$")
	public void i_choose_verify_account_indication_planned_actual_page() throws Throwable {
		leanftpage.verifyAcctIndicatorPlannedActualComparision();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@Given("^I Choose to Start LeanFT Run time engine$")
	public void User_Starts_LeanFTRuntime_engine() throws Exception {
		//LeanFTPage.leanftruntimeengineStart();
		//BaseLib.embedScreenShotInreportWithRobot();
	}
	@Given("^I Choose to launche to SAP application$")
	public void User_launches_to_I2MSAP_Application() throws Exception {

		LeanFTPage.leanftInvoke();
		LeanFTPage.sapLaunch();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to enter \"([^\"]*)\" T Code in the I2M SAP application$")
	public void User_enters_TCode_inthe_SAP_application(String TAcode)
			throws InterruptedException, GeneralLeanFtException {
		LeanFTPage.sapenterTAcode_I2M(TAcode);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^I Choose to Search \"([^\"]*)\" in Order Field$")
	public void User_enters_SAPSWO_number(String orderField) throws Exception {
	
		leanftpage.SearchSAPSWO(orderField);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^I Choose to Click \"([^\"]*)\" Tab of \"([^\"]*)\" Window$")
	public void user_access_Operations_Tab(String tab,String win) throws Throwable {
		leanftpage.clickonItemOveriviewTab(tab,win);
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Select ASO Item$")
	public void select_ASO_Item() throws Throwable {
		leanftpage.select_ASO_Item();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Select \"([^\"]*)\" Menu Item$")
	public void select_Sales_Document_Deliver(String menu) throws Throwable {
		leanftpage.select_Sales_Document_Deliver(menu);
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Update Picking Quantity$")
	public void update_Picking_Quantity_And_Serialize() throws Throwable {
		leanftpage.update_Picking_Quantity();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Pack ASO Delivery Items$")
	public void pack_ASO_Delivery_Items() throws Throwable {
		leanftpage.pack_ASO_Delivery_Items();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Update Packing Materials$")
	public void update_Packing_Materials() throws Throwable {
		leanftpage.update_Packing_Materials();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to update Identification in ASO Delivery Handling$")
	public void update_Identification_in_ASO_Delivery_Handling() throws Throwable {
		leanftpage.update_Identification_in_ASO_Delivery_Handling();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Click on Back Menu Bar$")
	public void click_Back_Button() throws Throwable {
		leanftpage.click_Back_Button();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Pack each ASO Delivery Items$")
	public void pack_ASO_Delivery_Items_For() throws Throwable {
		leanftpage.pack_ASO_Delivery_Items_For();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to enter \"([^\"]*)\" Delivery in the SAP application$")
	public void User_enters_TCode_SAP_application(String TAcode)
			throws InterruptedException, GeneralLeanFtException {
		leanftpage.outbound_Delivery_OKCode(TAcode);
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Post ASO Goods Issues$")
	public void post_Goods_Issues() throws Throwable {
		leanftpage.post_Goods_Issues();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Verify ASO Item Net Value$")
	public void verify_ASO_Item_Net_Value() throws Throwable {
		leanftpage.verify_ASO_Item_Net_Value();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Click on Header Button$")
	public void click_Header_Button() throws Throwable {
		leanftpage.click_Header_Button();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Verify Conditions Header Data$")
	public void verify_Conditions_Header_Data() throws Throwable {
		leanftpage.verify_Conditions_Header_Data();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Verify Partners Header Data$")
	public void verify_Partners_Header_Data() throws Throwable {
		leanftpage.verify_Partners_Header_Data();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to enter Material Document Number \"([^\"]*)\" And Material Document Year \"([^\"]*)\"$")
	public void enter_Material_Document_Number(String matCo, String mateYear)
			throws InterruptedException, GeneralLeanFtException {
		leanftpage.enter_Material_Document_Number(matCo,mateYear);
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Verify Material Document Details$")
	public void verify_Material_Document_Details() throws Throwable {
		leanftpage.verify_Material_Document_Details();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Click on Accounting Document And Verify details$")
	public void verify_Accounting_Details() throws Throwable {
		leanftpage.verify_Accounting_Details();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Open \"([^\"]*)\" From \"([^\"]*)\" Tab of \"([^\"]*)\" Window$")
	public void open_Item_Material_SalesTab(String item, String sales,String win)
			throws InterruptedException, GeneralLeanFtException {
		leanftpage.open_Item_Material_SalesTab(item,sales,win);
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Verify Delivery Location$")
	public void verify_Delivery_Location() throws Throwable {
		leanftpage.verify_Delivery_Location();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	// Closing SAP Application
	@When("^I Choose to enter IP4 in Equipment Search Box$")
	public void search_IP4_Equipment() throws Throwable {
		leanftpage.enter_IP_Equipment();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Verify Function Equipment and Superrod Equipment$")
	public void verify_Function_Equipment() throws Throwable {
		leanftpage.verify_Function_Equipment();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Enter Functional Location$")
	public void enter_Function_Location() throws Throwable {
		leanftpage.enter_Function_Loc();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Verify Functional Location$")
	public void verify_Function_Location() throws Throwable {
		leanftpage.verify_Function_Location();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Click Display document flow icon$")
	public void click_Display_document_flow_icon() throws Throwable {
		leanftpage.click_Display_document_flow_icon();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Single Part Delivery and Click Display Document$")
	public void Click_Display_Document() throws Throwable {
		leanftpage.Click_Display_Document();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Select Line Item$")
	public void select_Line_Itemt() throws Throwable {
		leanftpage.select_Line_Itemt();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Click on Processing Log And Note Delivery Number$")
	public void click_Processing_Log() throws Throwable {
		leanftpage.click_Processing_Log();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Search Delivery Number$")
	public void Search_Delivery_Number() throws Throwable {
		leanftpage.Search_Delivery_Number();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to enter \"([^\"]*)\" Outbound Delivery in the SAP application$")
	public void Search_Outbound_Delivery(String tcode) throws Throwable {
		leanftpage.Search_Outbound_Delivery(tcode);
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Enter Delivery Number in OutBound Delivery Field$")
	public void Delivery_Number_in_OutBound_Delivery() throws Throwable {
		leanftpage.Delivery_Number_in_OutBound_Delivery();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Select the line item and Enter the serial number$")
	public void select_lineitem_andEnter_serial() throws Throwable {
		leanftpage.select_LineItem_and_Enter_serial_Number();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to enter \"([^\"]*)\" and Verify Part information screen$")
	public void verify_Part_information(String tcode) throws Throwable {
		leanftpage.verify_Part_information(tcode);
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Search \"([^\"]*)\" And execute Program correction$")
	public void execute_Blueroom_Correction(String tcode) throws Throwable {
		leanftpage.execute_Blueroom_Correction(tcode);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify Activity Type and Activity Code\"([^\"]*)\"$")
	public void i_choose_to_verify_activity_type_and_activity_codesomething(String testdata) throws Throwable {
		leanftpage.verifyActCodeAndAttCode(testdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to Enter the required data as\"([^\"]*)\"$")
	public void i_choose_to_enter_the_required_data_assomething(String testdata) throws Throwable {
		leanftpage.entercatsData(testdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to Enter table name as\"([^\"]*)\"$")
	public void i_choose_to_enter_table_name_assomething(String table) throws Throwable {
		leanftpage.enterTname(table);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to Enter created date\"([^\"]*)\"$")
	public void i_choose_to_enter_created_datesomething(String testdata) throws Throwable {
		leanftpage.enterCreatedDate(testdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose to Enter personal Number\"([^\"]*)\"$")
	public void i_choose_to_enter_personal_numbersomething(String testdata) throws Throwable {
		leanftpage.enterPersonalID(testdata);
		leanftpage.selectCreateReference();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@Then("^I choose to verify Activity Type and Activity Code in CATs table\"([^\"]*)\"$")
	public void i_choose_to_verify_activity_type_and_activity_code_in_cats_table(String testdata) throws Throwable {
		leanftpage.verifyActCodeAndActType(testdata);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^Login to SAP system$")
	public void login_to_sap_system() throws Throwable {
		leanftpage.launchSAP();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@When("^User enters T Code in SAP application as\"([^\"]*)\"$")
	public void user_enters_t_code_in_sap_application_as(String tcode) throws Throwable {
		leanftpage.enter_Tcode(tcode);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	@And("^I choose switch back to login$")
	public void i_choose_switch_back_to_login() throws Throwable {
		leanftpage.switchToFM();
		BaseLib.embedScreenShotInreportWithRobot();
	}      
	@When("^I Choose to enter \"([^\"]*)\" in search menu bar$")
	public void search_Bar(String TAcode)
			throws InterruptedException, GeneralLeanFtException {
		LeanFTPage.search_Bar(TAcode);
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to enter SAP SWO Number$")
	public void enter_SAP_SWO()
			throws InterruptedException, GeneralLeanFtException {
		
		leanftpage.enter_SAP_SWO();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Verify Material Only WorkOrder in SAP$")
	public void verify_WO_SAP()
			throws InterruptedException, GeneralLeanFtException {
		leanftpage.verify_WO_SAP();
		BaseLib.embedScreenShotInreportWithRobot();
	}
	@When("^I Choose to Verify Status bar$")
	public void status() throws Throwable {
		leanftpage.status();
		BaseLib.embedScreenShotInreportWithRobot();

	}@When("^I Choose to Verify SAP Document$")
	public void sap_Document() throws Throwable {
		leanftpage.sap_Document();
		BaseLib.embedScreenShotInreportWithRobot();
	}
}
