package com.philips.pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.philips.generic.AutomationConstants;
import com.philips.generic.SOQLQuerys;

import junit.framework.Assert;

public class CreateQuotePage extends BasePage
{

	@FindBy(xpath = "//img[@alt = 'Configure Products']")
	WebElement btn_configureProducts;

	@FindBy(xpath="//a/span[text()='Opportunities']")
	public WebElement opportunity_tab;

	@FindBy(xpath="//a[@title='Test Opportunity']")
	public  WebElement opportunity;

	@FindBy(xpath="//div[text()='Opportunity']/../../../following-sibling::div//a[contains(@title,'more actions')]")
	public WebElement moreaction_dropdown;  

	@FindBy(xpath="//a[@title='Create Quote/Proposal']")
	public WebElement createquote_dropdown;

	@FindBy(xpath="//label[contains(text(),'Record Type of new record')]/following-sibling::select")
	public WebElement select_recordtype;



	@FindBy(xpath="//span[text()='Partner Function Accounts']/../../..//iframe")
	public WebElement frame_quotecreationpage;

	@FindBy(xpath="//div[@class='oneAlohaPage']//iframe")
	public WebElement frame_createQuote;

	@FindBy(xpath="//iframe[@title='accessibility title']")
	public List<WebElement> frame_parentFunctionSection;


	@FindBy(xpath="//span[text()='Partner Function Accounts']/ancestor::div[1]//iframe")
	public WebElement  partnerFuncitonAccountsSection;

	@FindBy(xpath="//input[@value='Continue']")
	public WebElement btn_continue;

	@FindBy(xpath="//span[text()='Quote Number']/../following-sibling::div//lightning-formatted-text")
	public WebElement quotenumber;


	@FindBy(xpath="//strong[contains(text(),'Sold To Account')]/..//a")
	public WebElement verify_soldtoaccount;

	@FindBy(xpath="//strong[contains(text(),'Ship To Account')]/..//a")
	public WebElement verify_shiptoaccount;

	@FindBy(xpath="//strong[contains(text(),'Bill To Account')]/..//a")
	public WebElement verify_billtoaccount;

	@FindBy(xpath="//strong[contains(text(),'Sold To Account Type')]/following-sibling::span")
	public WebElement verify_soldtoaccount_type;

	@FindBy(xpath="//strong[contains(text(),'Opportunity')]/following-sibling::a")
	public WebElement verify_opportunity;

	@FindBy(xpath="//span[text()='Proposal Name']/../following-sibling::div//lightning-formatted-text")
	public WebElement verify_proposal_name;

	@FindBy(xpath="//span[text()='Record Type']/../following-sibling::div//div[contains(@class,'recordTypeName')]/span")
	public WebElement verify_recordtype;

	@FindBy(xpath="//span[text()='Golden Opportunity ID']/../following-sibling::div//lightning-formatted-text")
	public WebElement verify_golden_opportunityid;

	@FindBy(xpath="//span[text()='Sold To MP1 Account']/../following-sibling::div//lightning-formatted-text")
	public WebElement verify_soldto_mp1_account;

	@FindBy(xpath="//span[text()='Ship To MP1 Account']/../following-sibling::div//lightning-formatted-text")
	public WebElement verify_shipto_mp1_account;

	@FindBy(xpath="//span[text()='Quote Type']/../..//lightning-formatted-text")
	private WebElement quoteType;

	@FindBy(xpath="//span[text()='Bill To MP1 Account']/../following-sibling::div//lightning-formatted-text")
	public WebElement verify_billto_mp1_account;

	@FindBy(xpath="//span[text()='Customer Address']/../following-sibling::div//lightning-formatted-rich-text/span")
	public WebElement verify_address;

	@FindBy(xpath="//span[text()='Approval Stage']/../following-sibling::div//lightning-formatted-text")
	public WebElement verify_approvalstage;

	@FindBy(xpath="//span[text()='Country']/../following-sibling::div//lightning-formatted-text")
	public WebElement verify_country;

	@FindBy(xpath="//span[text()='Market']/../following-sibling::div//lightning-formatted-text")
	public WebElement verify_market;

	@FindBy(xpath="//span[text()='Currency']/../following-sibling::div//lightning-formatted-text")
	public WebElement verify_currency;

	@FindBy(xpath="//span[text()='Country code']/../following-sibling::div//lightning-formatted-text")
	public WebElement verify_countrycode;

	@FindBy(xpath="//span[text()='Quote Type']/../following-sibling::div//lightning-formatted-text")
	public WebElement verify_quotetype;


	@FindBy(xpath="//img[@alt='Configure Products']")
	public WebElement btn_configure_products;

	@FindBy(xpath="//img[@alt='My Approvals']")
	public WebElement btn_myApprovals;

	@FindBy(xpath="//td[text()='All Approvals']")
	public WebElement tab_allApprovals;

	@FindBy(xpath="//span[text()='Approval Status:']/following-sibling::span[1]/span")
	public WebElement approval_stauts;


	@FindBy(xpath="((//th//div[text()='Status']/ancestor::table)[3]//td)[2]")
	public WebElement steplabelcontains;

	@FindBy(xpath="((//th//div[text()='Status']/ancestor::table)[3]//td)[11]")
	public WebElement SteplabelPricecontains;		

	@FindBy(xpath="	((//th//div[text()='Status']/ancestor::table)[3]//td)[15]")
	public WebElement AssignedtoPricingapprover;			

	@FindBy(xpath="((//th//div[text()='Status']/ancestor::table)[3]//td)[5]")
	public WebElement statuscontains;


	@FindBy(xpath="((//th//div[text()='Status']/ancestor::table)[3]//td)[6]")
	public WebElement assignedtocontains;

	@FindBy(xpath="	((//th//div[text()='Status']/ancestor::table)[3]//td)[9]")
	public WebElement approvalhistory;

	@FindBy(xpath="((//th//div[text()='Status']/ancestor::table)[4]//td)[2]")
	public WebElement steplabelcontains1;


	@FindBy(xpath="((//th//div[text()='Status']/ancestor::table)[4]//td)[5]")
	public WebElement statuscontains1;


	@FindBy(xpath="((//th//div[text()='Status']/ancestor::table)[4]//td)[6]")
	public WebElement assignedtocontains1;

	@FindBy(xpath="((//th//div[text()='Status']/ancestor::table)[5]//td)[2]")
	public WebElement steplabelcontains2;


	@FindBy(xpath="((//th//div[text()='Status']/ancestor::table)[5]//td)[5]")
	public WebElement statuscontains2;


	@FindBy(xpath="((//th//div[text()='Status']/ancestor::table)[5]//td)[6]")
	public WebElement assignedtocontains2;


	@FindBy(xpath="//input[@value='Approve']")
	public WebElement btn_Approve;

	@FindBy(xpath="//textarea[@id='idMyApprovalsPage:idApproveForm:idApproveComment']")
	public WebElement input_approvecomments;

	@FindBy(xpath="//textarea[contains(@id,'ApproveComment')]/..//input[@value='Save']")
	public WebElement btn_savecomments;


	@FindBy(xpath="//div[text()='Quote/Proposal']/..//lightning-formatted-text")
	WebElement quoteName;

	@FindBy(xpath="//img[@alt='Create Agreement with Line Items']")
	WebElement btn_createAgreementwithLineItems;

	@FindBy(xpath="//div[text()='Creating Agreement, please wait...']")
	WebElement spinner_createAgreement;

	//Agreement Page

	@FindBy(xpath="//div[@class='slds-grid slds-wrap']//iframe")
	WebElement frame_agreementPage;

	@FindBy(xpath="//a[contains(@href,'AgreementLineItems')]//span[text()='View All']")
	WebElement link_ViewallAgreements;

	@FindBy(xpath="//div[contains(@class,'test-listViewManager')]//td[2]//a")
	List<WebElement> productNames;

	@FindBy(xpath="//span[text()='Status Category']/../..//button")
	WebElement icon_editStatus;

	@FindBy(xpath="//span[text()='Status Category']/../..//lightning-formatted-text")
	WebElement agreement_status;

	@FindBy(xpath="//label[text()='Status Category']/./..//input")
	WebElement dropdown_stauts;

	@FindBy(xpath="//lightning-base-combobox-item//span[@title='In Authoring']")
	WebElement status_Inauthoring;

	@FindBy(xpath="//lightning-button//button[@title='Save']")
	WebElement btn_save;

	@FindBy(xpath="//span[text()='Related Quote/Proposal']/../..//a")
	WebElement quoteId;

	@FindBy(xpath="//span[text()='Quote Type']/../..//button")
	WebElement icon_editQuoteType;

	@FindBy(xpath="//label[text()='Quote Type']/..//input")
	WebElement dropdown_QuoteType;

	@FindBy(xpath="//span[text()='CFD Language Change']/../..//a")
	WebElement link_changeLanguage;

	@FindBy(xpath="//div[text()='CFD Language']/../../../..//select")
	WebElement dropdown_Language;

	@FindBy(xpath="//button[contains(text(),'Next')]")
	WebElement btn_next;

	@FindBy(xpath="//span[text()='Generate CFD']/../..//img")
	WebElement btn_generateCFD;

	@FindBy(xpath="//span[text()='Primary Contact']/../following-sibling::div//a")
	public WebElement primaryContatct;

	@FindBy(xpath="//button[@name='Edit']/..")
	public WebElement quote_edit_button;

	@FindBy(xpath="(//span[text()='Close Quote']/../following-sibling::div//img[@alt='Close Quote'])[2]")
	public WebElement close_quote_button;

	@FindBy(xpath="//input[@value='Close']")
	public WebElement close_button;

	@FindBy(xpath="//table[@class='detailList']//select")
	public WebElement reason_for_closure_dropdown;

	@FindBy(xpath="//iframe[@title='accessibility title']")
	public WebElement frame_close_quote_reason;

	@FindBy(xpath="//div[text()='Closed']")
	public WebElement quote_closed_status;

	@FindBy(xpath="//div[text()='C']")
	public WebElement quote_closed_status_color;

	@FindBy(xpath="(//span[text()='Quote Status']/../../..//iframe)[3]")
	public WebElement frame_quote_status;

	@FindBy(xpath="//button[text()='Clone' and  @class='slds-button slds-button_neutral']")
	private WebElement clone_link;

	@FindBy(xpath="//div[text()='Draft']")
	public WebElement quote_draft_status;

	@FindBy(xpath="//div[text()='D']")
	public WebElement quote_draft_status_color;

	@FindBy(xpath="//a/img[@alt='Close Quote']")
	public WebElement close_quote_link;

	@FindBy(xpath="//span[text()='Best Contract Selected']/../..//input")
	WebElement checkbox_bestContractSelected;

	@FindBy(xpath="//span[text()='Primary Contact']/ancestor::div[3]//span[contains(@class,'inline-edit-trigger-icon')]")
	WebElement primarycontact_edit;

	@FindBy(xpath="//label[text()='Primary Contact']/ancestor::div[1]//input")
	WebElement search_contact;


	@FindBy(xpath="//span[text()='Sales Org']/../../..")
	WebElement salesorg;

	@FindBy(xpath="//span[text()='Sales Deal']/../../..")
	WebElement salesdeal;

	@FindBy(xpath="//span[text()='Currency']/../../..")
	WebElement currency;


	@FindBy(xpath="//span[text()='Agreement Group Name']/../../..")
	WebElement Agreement_group_name;

	@FindBy(xpath="//span[text()='Agreement Group Id']/../../..")
	WebElement agreementid;


	@FindBy(xpath="//span[text()='Condition Type']/../../..")
	WebElement conditiontype;

	@FindBy(xpath="//span[text()='Material Number']/../../..")
	WebElement Materialnumber;


	@FindBy(xpath="//span[text()='Variant']/../../..")
	WebElement Variant;


	@FindBy(xpath="//span[text()='BU']/../../..")
	WebElement BU;


	@FindBy(xpath="//span[text()='MAG']/../../..")
	WebElement MAG;


	@FindBy(xpath="//span[text()='AG']/../../..")
	WebElement AG;


	@FindBy(xpath="//span[text()='MPG']/../../..")
	WebElement MPG;


	@FindBy(xpath="//span[text()='MG3']/../../..")
	WebElement MG3;


	@FindBy(xpath="//span[text()='Value']/../../..")
	WebElement Value;


	@FindBy(xpath="//span[text()='Valid On']/../../..")
	WebElement Valid_on;


	@FindBy(xpath="//span[text()='Valid From']/../../..")
	WebElement Valid_from;


	@FindBy(xpath="//span[text()='Valid To']/../../..")
	WebElement valid_to;

	@FindBy(xpath="//span[text()='Deletion Indicator']/../../..")
	WebElement indicator;


	@FindBy(xpath="//span[text()='Item Flag']/../../..")
	WebElement flag;


	@FindBy(xpath="//span[text()='Status']/../../..")
	WebElement Status;


	@FindBy(xpath="//span[text()='Error Description']/../../..")
	WebElement Error;


	@FindBy(xpath="//span[text()='Price List Item']/../../..")
	WebElement pricelist;


	@FindBy(xpath="//span[text()='Agreement Line Item']/../../..")
	WebElement lineitem;


	@FindBy(xpath="//span[text()='Agreement']/../../..")
	WebElement agreement;

	@FindBy(xpath="//span[text()='External Id']/../../..")
	WebElement Externalid;

	@FindBy(xpath="//span[text()='Agreement Line Item']/../../..")
	WebElement Agrrement_line_item;

	@FindBy(xpath="//span[text()='Type']/../../..")
	WebElement type;

	@FindBy(xpath="//span[text()='Agreement']/../../..")
	WebElement Agreement;

	@FindBy(xpath="//span[text()='SAP Agreement Reference']/../../..")
	WebElement SAPAgreement;

	@FindBy(xpath="//span[text()='Product Id of Bundle']/../../..")
	WebElement Product_Bundle;

	@FindBy(xpath="//span[text()='Option Id of Option']/../../..")
	WebElement Option_Id;

	@FindBy(xpath="//span[text()='Hierarchy']/../../..")
	WebElement Hierarchy;

	@FindBy(xpath="//span[text()='Tier 1 Discount']/../../..")
	WebElement Tier1;

	@FindBy(xpath="//span[text()='Tier 2 Discount']/../../..")
	WebElement Tier2;

	@FindBy(xpath="//span[text()='Tier 3 Discount']/../../..")
	WebElement Tier3;

	@FindBy(xpath="//span[text()='Tier 4 Discount']/../../..")
	WebElement Tier4;

	@FindBy(xpath="//span[text()='Action']/../../..")
	WebElement Action;

	@FindBy(xpath="//input[@class='filter-box input']")
	WebElement quickfind;

	@FindBy(xpath="//div[@title='Permission Sets']")
	WebElement Permission_set;

	@FindBy(xpath="//iframe[@title='Permission Sets ~ Salesforce - Unlimited Edition']")
	WebElement frame;

	@FindBy(xpath="//span[text()='Apttus CLM Contract Manager']")
	WebElement Contractmanager;

	@FindBy(xpath="//span[text()='Apttus CLM Contract Specialist']")
	WebElement Contractspecialist;

	@FindBy(xpath="//span[text()='Apttus Custom Program Admin']")
	WebElement customprogram;



	@FindBy(xpath="(//div[@class='headerTrigger  tooltip-trigger uiTooltip'])[2]")
	WebElement setting_symbol;

	@FindBy(xpath="//li[@id='related_setup_app_home']")
	WebElement setup;

	@FindBy(xpath="//span[text()='Object Manager']")
	WebElement ObjectManager;

	@FindBy(xpath="//h1/span[text()='Object Manager']")
	WebElement Objectmanager_header;

	@FindBy(xpath="//input[@class='slds-input input']")
	WebElement SearchField;

	@FindBy(xpath="//a[text()='APTS Sales Deal Condition']")
	WebElement Salesdeal_Link;

	@FindBy(xpath="//a[text()='Fields & Relationships']")
	WebElement Fields;

	@FindBy(xpath="//input[@class='slds-input input']")
	WebElement quickFind;


	public static String quoteid;
	public static HashMap<String, String> opportunitydetails;
	public static HashMap<String, String> accountdetails;
	public static String opportunityUsedToCreateQuote;
	public static String urlQuoteToApprove;
	public static String soldToAccount;
	public static String shipToAccount;
	public static String billToAccount;
	public static String country;
	public static List<String> contactdetails;
	public static boolean bestcontractselected;
	public CreateQuotePage(WebDriver driver) {
		super(driver);
	}




	

	public void selectOpportuntiyFromGlobalSearch(String opportunity) {
		golbalSearch(opportunity,"Opportunities");

	}

	public void verifyAccountDetails() 
	{	
		driver.switchTo().defaultContent();
		waitAndswitchToRequiredFrame(frame_quotecreationpage);
		waitForElement(verify_soldtoaccount, "Sold To Account");
		verifyTextContains(verify_soldtoaccount, accountdetails.get("Account Name"));
		verifyTextContains(verify_shiptoaccount, accountdetails.get("Account Name"));
		verifyTextContains(verify_billtoaccount, accountdetails.get("Account Name"));
		verifyTextContains(verify_soldtoaccount_type, accountdetails.get("Account Type"));
		driver.switchTo().defaultContent();
		verifyTextContains(verify_soldto_mp1_account, accountdetails.get("CPQ MP1 Customer ID"));
		verifyTextContains(verify_shipto_mp1_account, accountdetails.get("CPQ MP1 Customer ID"));
		verifyTextContains(verify_billto_mp1_account, accountdetails.get("CPQ MP1 Customer ID"));


		/*There is some formating issue in address hence need to look into it
		verifyBooleanStatus(verify_address.getText().replaceAll(",", ""), accountdetails.get("Customer Address").replaceAll(",",""));
		 */

		verifyTextContains(verify_country,accountdetails.get("Country"));
		verifyTextContains(verify_market, accountdetails.get("Market"));
	}

	public void VerifyOpportunityDetails() {
		waitAndswitchToRequiredFrame(frame_quotecreationpage);
		verifyTextContains(verify_opportunity, opportunitydetails.get("Opportunity Name"));
		driver.switchTo().defaultContent();
		verifyTextContains(verify_proposal_name, opportunitydetails.get("Opportunity Name"));
		verifyTextContains(verify_recordtype, "Standard Quote");
		verifyTextContains(verify_golden_opportunityid, opportunitydetails.get("Golden Opportunity ID"));
		verifyTextContains(verify_approvalstage, "Draft");
		verifyTextContains(verify_currency, opportunitydetails.get("Opportunity Currency"));
	}

	public void approveQuote() {
		waitTill("15");
		driver.get(urlQuoteToApprove);
		waitForElement(quoteName, "Waiting for Quote to load");
		click("My Approvals", btn_myApprovals);
		waitTill("5");
		waitAndswitchToFrame("My Approvals"); 	//title of frame tab issue
		waitForElement(approval_stauts, "Approval status");
		if(!approval_stauts.getText().equalsIgnoreCase("Approved")) 
		{
			waitForElement(tab_allApprovals, "All Approvals");
			click("All Approvals", tab_allApprovals);
			click("Approve", btn_Approve);
			enter("Comments", input_approvecomments, "Automation testing");
			click("Save", btn_savecomments);
			waitTill("5");//increased to load the status
			waitForElement(approval_stauts, "Approval status");
			waitTillDataPopulates(approval_stauts,"Approved");
			verifyTextContains(approval_stauts, "Approved");
		}
		else
		{
			logReport("INFO", "Quote is Approved");
		}
	}

	public void rejectQuote() {
		waitTill("15");
		driver.get(urlQuoteToApprove);
		waitForElement(quoteName, "Waiting for Quote to load");
		click("My Approvals", btn_myApprovals);
		waitTill("5");
		switchToTab(2); //tab issue
		waitAndswitchToFrame("My Approvals"); 	//title of frame
		waitForElement(approval_stauts, "Approval status");
		if(!approval_stauts.getText().equalsIgnoreCase("Approved")) 
		{
			waitForElement(tab_allApprovals, "All Approvals");
			click("All Approvals", tab_allApprovals);

		}
	}
	public void verifyapproveQuote() {
		waitTill("15");
		driver.get(urlQuoteToApprove);
		waitForElement(quoteName, "Waiting for Quote to load");
		click("My Approvals", btn_myApprovals);
		waitTill("5");
		//switchToTab(2); //tab issue
		waitAndswitchToFrame("My Approvals"); 	//title of frame
		waitForElement(approval_stauts, "Approval status");
		if(!approval_stauts.getText().equalsIgnoreCase("Approved")) 
		{
			waitForElement(tab_allApprovals, "All Approvals");
			click("All Approvals", tab_allApprovals);
			verifyApprovalPreviewPage();
			click("Approve", btn_Approve);
			enter("Comments", input_approvecomments, "Automation testing");
			click("Save", btn_savecomments);
			waitTill("5");//increased to load the status
			waitForElement(approval_stauts, "Approval status");

			//verifyTextContains(approval_stauts, "Approved"); since it contains Approved text contains will not work
		}
		else
		{
			logReport("INFO", "Quote is not Approved");
		}


	}
	public void verifyapprovedstatus(){
		waitTill("15");
		driver.get(urlQuoteToApprove);
		waitForElement(quoteName, "Waiting for Quote to load");
		click("My Approvals", btn_myApprovals);
		waitTill("6");
		//switchToTab(2); //tab issue
		waitAndswitchToFrame("My Approvals"); 	//title of frame
		waitForElement(approval_stauts, "Approval status");
		if(!approval_stauts.getText().equalsIgnoreCase("Approved")) 
		{
			waitForElement(tab_allApprovals, "All Approvals");
			click("All Approvals", tab_allApprovals);
			verifyApprovalPreviewPage();
			click("Approve", btn_Approve);
			enter("Comments", input_approvecomments, "Automation testing");
			click("Save", btn_savecomments);
			waitTill("5");//increased to load the status
			waitForElement(approval_stauts, "Approval status");
			verifyApprrovedPreviewPage();
			//verifyTextContains(approval_stauts, "Approved"); since it contains Approved text contains will not work
		}
		else
		{
			logReport("INFO", "Quote is not Approved");
		}

	}
	public void verifyPricingapprovalstatus(){
		waitTill("15");
		driver.get(urlQuoteToApprove);
		waitForElement(quoteName, "Waiting for Quote to load");
		click("My Approvals", btn_myApprovals);
		waitTill("5");
		//closeAllTabs();
		//switchToTab(1); //tab issue
		waitAndswitchToFrame("My Approvals"); 	//title of frame
		waitForElement(approval_stauts, "Approval status");
		if(!approval_stauts.getText().equalsIgnoreCase("Approved")) 
		{
			waitForElement(tab_allApprovals, "All Approvals");
			click("All Approvals", tab_allApprovals);
			verifyPricingApproval();

			click("Approve", btn_Approve);
			enter("Comments", input_approvecomments, "Automation testing");
			click("Save", btn_savecomments);
			waitTill("5");//increased to load the status
			waitForElement(approval_stauts, "Approval status");
			waitTillDataPopulates(approval_stauts,"Approved");
			verifyTextContains(approval_stauts, "Approved");

		}
		else
		{
			logReport("INFO", "Quote is Approved");
		}
	}


	public void verifyApprrovedPreviewPage(){
		String modifiedDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String stepcontains=steplabelcontains.getText();
		String status_contains=statuscontains.getText();
		String assignedto_contains=assignedtocontains.getText();
		String approval_history=approvalhistory.getText();
		System.out.println(approval_history);
		if(status_contains.equals("Approved")){

			logReport("INFO", "Steplabel : "+stepcontains+"");
			logReport("INFO", "Status : "+status_contains+"");
			logReport("INFO", "Assignedto : "+assignedto_contains+"");
			logReport("INFO: VALIDATION PASS", "APPROVED SUCCESSFULLY");

		}
		else{
			logReport("INFO", "data not present in the preview page");
			Assert.fail();
		}

		if(approval_history.contains("Approved with comments - Approval User")){
			if(approval_history.contains("Approver comments - Automation testing")){
				if(approval_history.contains(modifiedDate)){

					logReport("INFO: VALIDATION PASS", "Approved preview page contains the Approval history:" +approval_history+"");
				}
			}
		}
		else{
			logReport("INFO", "VALIDATION FAILS");
			Assert.fail();
		}



	}
	public void verifyPricingApproval() {
		// TODO Auto-generated method stub
		String stepcontains=steplabelcontains.getText();
		String status_contains=statuscontains.getText();
		String sc=SteplabelPricecontains.getText();
		String assignedto_contains=assignedtocontains.getText();
		String at=AssignedtoPricingapprover.getText();
		verifyTextContains(steplabelcontains, "Line Manager");
		if(verifyTextContains(steplabelcontains, "Line Manager")){
			if(verifyTextContains(SteplabelPricecontains,"Pricing Approver")){
				if(at.equals("Apttus USA TPA1 Finance ULS")){

					logReport("INFO", "Steplabel : "+sc+"");
					logReport("INFO", "Status : "+status_contains+"");
					logReport("INFO", "Assignedto : "+at+"");
					logReport("INFO", "VERIFICATION DONE SUCCESSFULLY BEFORE APPROVED");

				}
			}
		}
		else{
			logReport("INFO", "data not present in the preview page");
			Assert.fail();
		}

	}
	public void verifyApprovalPreviewPage() {
		// TODO Auto-generated method stub
		String stepcontains=steplabelcontains.getText();
		String status_contains=statuscontains.getText();
		String assignedto_contains=assignedtocontains.getText();
		if(status_contains.equals("Assigned")){
			//if(assignedto_contains.equals("Apttus USA Demo")){

			logReport("INFO", "Steplabel : "+stepcontains+"");
			logReport("INFO", "Status : "+status_contains+"");
			logReport("INFO", "Assignedto : "+assignedto_contains+"");
			logReport("INFO", "VERIFICATION DONE SUCCESSFULLY BEFORE APPROVED");

		}

		else{
			logReport("INFO", "data not present in the preview page");

		}

	}

	public void verifyapprovalPreviewPage() {
		waitTill("15");
		driver.get(urlQuoteToApprove);
		waitForElement(quoteName, "Waiting for Quote to load");
		click("My Approvals", btn_myApprovals);
		waitTill("5");
		//switchToTab(2); //tab issue
		waitAndswitchToFrame("My Approvals"); 	//title of frame
		waitForElement(approval_stauts, "Approval status");
		if(!approval_stauts.getText().equalsIgnoreCase("Approved")) 
		{
			waitForElement(tab_allApprovals, "All Approvals");
			click("All Approvals", tab_allApprovals);
			verifyApprovalsPreviewPage_UAT();
			//verifyApprovalsPreviewPage_SIT();
			click("Approve", btn_Approve);
			enter("Comments", input_approvecomments, "Automation testing");
			click("Save", btn_savecomments);
			waitTill("5");//increased to load the status
			waitForElement(approval_stauts, "Approval status");
			//verifyTextContains(approval_stauts, "Approved"); since it contains Approved text contains will not work
		}
		else
		{
			logReport("INFO", "Quote is not Approved");
		}


	}
	public void verifySteplabel_AssignedTo() {
		waitTill("15");
		driver.get(urlQuoteToApprove);
		waitForElement(quoteName, "Waiting for Quote to load");
		click("My Approvals", btn_myApprovals);
		waitTill("5");
		//switchToTab(2); //tab issue
		waitAndswitchToFrame("My Approvals"); 	//title of frame
		waitForElement(approval_stauts, "Approval status");
		if(!approval_stauts.getText().equalsIgnoreCase("Approved")) 
		{

			waitForElement(tab_allApprovals, "All Approvals");
			click("All Approvals", tab_allApprovals);
			verify_steplabel_and_assignedto();
			click("Approve", btn_Approve);
			enter("Comments", input_approvecomments, "Automation testing");
			click("Save", btn_savecomments);
			waitTill("5");//increased to load the status
			waitForElement(approval_stauts, "Approval status");
			waitTillDataPopulates(approval_stauts,"Approved");
			verifyTextContains(approval_stauts, "Approved");


		}
		else
		{
			logReport("INFO", "Quote is Approved");
		}
	}
	public void verify_steplabel_and_assignedto(){
		String sl=steplabelcontains.getText();
		String at=assignedtocontains.getText();
		System.out.println(sl);
		System.out.println(at);
		if(sl.equals("Payment Term change")){
			//if(at.equals("US90_Finance")){

			logReport("INFO", "Steplabel : "+sl+"");
			logReport("INFO", "Assignedto : "+at+"");
			logReport("INFO:Validation PASS", "VERIFICATION DONE SUCCESSFULLY");
		}
		else{
			logReport("INFO:" ,"Validation FAIL");
		}
	}
	//		else{
	//			logReport("INFO:" ,"Validation FAIL");
	//	Assert.fail();
	//		}


	public void verifyExpiration_onPreviewPage() {
		waitTill("15");
		driver.get(urlQuoteToApprove);
		waitForElement(quoteName, "Waiting for Quote to load");
		click("My Approvals", btn_myApprovals);
		waitTill("5");
		//switchToTab(2); //tab issue
		waitAndswitchToFrame("My Approvals"); 	//title of frame
		waitForElement(approval_stauts, "Approval status");

		if(!approval_stauts.getText().equalsIgnoreCase("Approved")) 
		{
			waitForElement(tab_allApprovals, "All Approvals");
			click("All Approvals", tab_allApprovals);
			verify_steplabel_and_assignedto1();
			click("Approve", btn_Approve);
			enter("Comments", input_approvecomments, "Automation testing");
			click("Save", btn_savecomments);
			waitTill("5");//increased to load the status
			//verifyTextContains(approval_stauts, "Approved");

			waitForElement(approval_stauts, "Approval status");
		}
		else
		{
			logReport("INFO", "Quote is Approved");
		}
	}
	public void verify_steplabel_and_assignedto1(){
		String sl=steplabelcontains.getText();
		String at=assignedtocontains.getText();
		System.out.println(sl);
		System.out.println(at);
		if(sl.equals("Exceed Quote validity")){
			//if(at.equals("Apttus USA Quote Header Finance")){

			logReport("INFO", "Steplabel : "+sl+"");
			logReport("INFO", "Assignedto : "+at+"");
			logReport("INFO:Validation PASS", "VERIFICATION DONE SUCCESSFULLY");
		}
		//			else{
		//				logReport("INFO:" ,"Validation FAIL");
		//				Assert.fail();
		//			}
		//		}
		else{
			logReport("INFO:" ,"Validation FAIL");
		}

	}
	public void verifyApprovalsPreviewPage_UAT() {
		// TODO Auto-generated method stub
		String stepcontains=steplabelcontains.getText();
		String status_contains=statuscontains.getText();
		String assignedto_contains=assignedtocontains.getText();
		String stepcontains1=steplabelcontains1.getText();
		String status_contains1=statuscontains1.getText();
		String assignedto_contains1=assignedtocontains1.getText();
		String stepcontains2=steplabelcontains2.getText();
		String status_contains2=statuscontains2.getText();
		String assignedto_contains2=assignedtocontains2.getText();

		if(status_contains.equals("Assigned")){
			{
				logReport("INFO", "Steplabel : "+stepcontains+"for the SPOO  product");
				logReport("INFO", "Status : "+status_contains+"for the SPOO  product");
				logReport("INFO", "Assignedto : "+assignedto_contains+"for the SPOO  product");
				logReport("INFO", "VERIFICATION DONE SUCCESSFULLY FOR SP00405_RE");

			}
		}
		else{
			logReport("INFO", "validation");

		}

	}
	public void verifyApprovalsPreviewPage_SIT() {
		// TODO Auto-generated method stub
		String stepcontains=steplabelcontains.getText();
		String status_contains=statuscontains.getText();
		String assignedto_contains=assignedtocontains.getText();
		String stepcontains1=steplabelcontains1.getText();
		String status_contains1=statuscontains1.getText();
		String assignedto_contains1=assignedtocontains1.getText();
		String stepcontains2=steplabelcontains2.getText();
		String status_contains2=statuscontains2.getText();
		System.out.println(status_contains2);
		String assignedto_contains2=assignedtocontains2.getText();
		if(status_contains.equals("Assigned")){
			if(assignedto_contains.equals("Apttus USA Trade-in MATC")){

				logReport("INFO", "Steplabel : "+stepcontains+"for the SPOO DEMO product");
				logReport("INFO", "Status : "+status_contains+"for the SPOO DEMO product");
				logReport("INFO", "Assignedto : "+assignedto_contains+"for the SPOO DEMO product");
				logReport("INFO", "VERIFICATION DONE SUCCESSFULLY FOR SP00404_PO");

			}
		}
		else{
			logReport("INFO", "validation");
			Assert.fail();
		}
		if(status_contains1.equals("Assigned")){
			if(assignedto_contains1.equals("Apttus USA Trade-in IGT")){

				logReport("INFO", "Steplabel : "+stepcontains1+" for the SPOO RETURN  TRADE IN product");
				logReport("INFO", "Status : "+status_contains1+"for the SPOO RETURN  TRADE IN product");
				logReport("INFO", "Assignedto : "+assignedto_contains1+"for the SPOO RETURN  TRADE IN product");
				logReport("INFO", "VERIFICATION DONE SUCCESSFULLY FOR SP00401_PO");

			}
		}
		else{
			logReport("INFO", "validation fail");
			Assert.fail();
		}

		if(status_contains2.equals("Assigned")){
			if(assignedto_contains2.equals("Apttus USA Trade-in PD")){

				logReport("INFO", "Steplabel : "+stepcontains2+"for the SPOO PO TRADE IN product");
				logReport("INFO", "Status : "+status_contains2+"for the SPOO PO TRADE IN product");
				logReport("INFO", "Assignedto : "+assignedto_contains2+"for the SPOO PO TRADE IN product");
				logReport("INFO", "VERIFICATION DONE SUCCESSFULLY  FOR SP00407_PO");
			}

		}
		else{
			logReport("INFO", "validation fail");
			Assert.fail();
		}


	}

	public void openQuoteFromCPQSITUser() {
		waitTill("15");
		driver.get(urlQuoteToApprove);
		waitForElement(quoteName, "Waiting for Quote to load");

	}


	public void verifyCreateAgreementswithlineitemsIsDisplayed() {
		checkElementisDisplayed(btn_createAgreementwithLineItems, "Create Agreement with Line items button");
	}

	public void createAgreementWithLineItemsDisplayed(String agreementtype) {
		click("Create Agreement with Line items", btn_createAgreementwithLineItems);
		waitForElement(frame_createQuote, "Frame");
		waitAndswitchToRequiredFrame(frame_createQuote);
		selectbyValue(select_recordtype, agreementtype, "Record Type of new record");
		click("Continue", btn_continue);
		waitTill("5");
		waitForElement(spinner_createAgreement, "Spinner");
		driver.switchTo().defaultContent();
	}

	public void verifyAgreementStatus(String status) {
		waitForElement(icon_editStatus, "Edit Status Icon");
		click("Edit Status", icon_editStatus);
		scrollByViewOfElement(dropdown_stauts);
		click("Status Category", dropdown_stauts);
		click("In Authoring", status_Inauthoring);
		click("Save", btn_save);
		waitForElement(agreement_status, "Update Status");
		verifyTextContains(agreement_status, status);

	}


	public void verifyQuoteLineItems() {

		verifyTextContains(quoteId, quoteid);
		/*waitForElement(frame_createQuote, "Frame");
		driver.switchTo().frame(frame_agreementPage);
		verifyTextContains(verify_soldtoaccount, soldToAccount);
		verifyTextContains(verify_shiptoaccount, shipToAccount);
		verifyTextContains(verify_billtoaccount,billToAccount);
		driver.switchTo().defaultContent();*/
	}

	public void veirfyAgreementLineItems() 
	{
		
	}




	public void changeQuoteType(String quotetype) {
		scrollByViewOfElement(icon_editQuoteType);
		click("Edit Quote Type Icon", icon_editQuoteType);
		int count =0;
		while(count<5) {
			try {
				if(verifyElementPresent("Edit Quote Type", icon_editQuoteType)) {
					click("Edit Quote Type Icon", icon_editQuoteType);
				}
				click("Quote Type Drop down", dropdown_QuoteType);
				waitTill("5");
				WebElement quoteType = driver.findElement(By.xpath("//label[text()='Quote Type']/following-sibling::div//span[contains(@title,'"+quotetype+"')]"));
				click("Select Quote Type", quoteType);
				break;
			}catch (Exception e) {
				count++;
			}
		}
	}




	public void clickSave() {
		click("Save", btn_save);
		waitElementToDisappear(btn_save);
	}




	public void changeCFDLanguage(String language) {

		click("Change CFD Language", link_changeLanguage);
		//switch to frame
		waitAndswitchToRequiredFrame(frame_createQuote);
		selectbyValue(dropdown_Language, language, "CFD Language");
		click("Next", btn_next);
		driver.switchTo().defaultContent();
		waitDottedSpinnerToDisappear();
		waitTill("10");
		verifyTextContains(link_changeLanguage, language);

	}




	public void clickGenerateCFD() {
		waitForElement(btn_generateCFD, "CFD");
		click("Generate CFD", btn_generateCFD);
	}

	public void getContactDetails(String oppDetails) throws IOException 
	{
		selectOpportuntiyFromGlobalSearch(oppDetails);
	}
	public void verifyPrimaryContact() 
	{	
		driver.switchTo().defaultContent();
		waitAndswitchToRequiredFrame(frame_quotecreationpage);
		waitForElement(verify_soldtoaccount, "Sold To Account");
		for(int i=0;i<contactdetails.size();i++) {
			if(contactdetails.get(i).contains(primaryContatct.getText())) {
				break;
			}
		}
	}

	public void verifyQuoteDraftStatus() {
		waitTill("4");
		driver.navigate().refresh();
		waitTill("6");
		waitForElement(frame_quote_status, "Frame");
		driver.switchTo().frame(frame_quote_status);
		waitForElement(quote_draft_status, "Draft");
		verifyTextContains(quote_draft_status, "Draft");
		String color = quote_draft_status_color.getCssValue("color");
		String backcolor = quote_draft_status_color.getCssValue("background-color");
		if(!color.equals(backcolor)){
			logReport("PASS", "Quote status Draft is highlighted!");
		}
		else{

			logReport("FAIL", "Quote status Draft is not highlighted!");
		}
		driver.switchTo().defaultContent();
	}

	public void clickOnEditQuote() {
		click("Edit", quote_edit_button);
	}

	public void clickOnCloseQuote() {
		waitTill("5");
		click("Close Quote", close_quote_button);
	}

	public void enterReasonForQuoteClosure() {
		waitTill("5");
		driver.navigate().refresh();
		waitTill("5");
		driver.switchTo().frame(frame_close_quote_reason);
		selectbyValue(reason_for_closure_dropdown, "No longer required", "Reason for closure dropdown value");
		click("Close", close_button);
		driver.switchTo().defaultContent();
	}

	public void closeQuote() {
		clickOnCloseQuote();
		enterReasonForQuoteClosure();
	}

	public void verifyQuoteCloseStatus() {
		waitTill("4");
		driver.switchTo().frame(frame_quote_status);
		waitForElement(quote_closed_status, "Closed");
		verifyTextContains(quote_closed_status, "Closed");
		String color = quote_closed_status_color.getCssValue("color");
		String backcolor = quote_closed_status_color.getCssValue("background-color");
		if(!color.equals(backcolor)){
			logReport("PASS", "Quote status Closed is highlighted!");
		}
		else{

			logReport("FAIL", "Quote status Closed is not highlighted!");
		}
		driver.switchTo().defaultContent();
	}

	public void clickOnCloneLink() {
		click("Clone link", clone_link);
	}

	public void clickOnCloseQuoteLink() {
		waitForElement(close_quote_link, "Close Quote link");
		click("Close Quote link", close_quote_link);
	}

	public void closeQuoteAfterSubmitForApproval() {
		clickOnCloseQuoteLink();
		enterReasonForQuoteClosure();
	}

	public void closeQuoteAfterDSRStatusChange() {
		clickOnCloseQuoteLink();
		enterReasonForQuoteClosure();
	}




	public void addPrimaryContact(String arg1) {
		click("Primary Contact", primarycontact_edit);
		enter("Primary Contact", search_contact, arg1);
		waitTill("5");
		WebElement contact = driver.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='"+arg1+"']"));
		click("Primary Contact", contact);

	}






	public void verify_APTSfields() {
		// TODO Auto-generated method stub
		verifyTextContains(salesorg,"Sales Org");
		verifyTextContains(salesorg, "Text(4)");
		System.out.println("Sales Org Field is present");


		verifyTextContains(salesdeal,"Sales Deal");
		verifyTextContains(salesdeal, "Text(10)");
		System.out.println("Sales Deal Field is present");
		driver.navigate().refresh();
		waitTill("6");

		verifyTextContains(currency,"Currency");
		verifyTextContains(currency, "CurrencyIsoCode");
		System.out.println("Currency Field is present");


		verifyTextContains(Agreement_group_name,"Agreement Group Name");
		verifyTextContains(Agreement_group_name, "Text(80)");
		System.out.println("Agreement Group Name is present");



		verifyTextContains(agreementid,"Agreement Group Id");
		System.out.println("Agreement Group Id Field is present");


		verifyTextContains(conditiontype,"Condition Type");
		verifyTextContains(conditiontype, "Picklist");
		System.out.println("conditiontype Field is present");


		verifyTextContains( Materialnumber,"Material Number");
		verifyTextContains( Materialnumber, "Text(15)");
		System.out.println(" Materialnumber Field is present");


		verifyTextContains(Variant,"Variant");
		verifyTextContains(Variant, "Text(35)");
		System.out.println("Variant Field is present");


		verifyTextContains(BU,"BU");
		verifyTextContains(BU, "Text(4)");
		System.out.println("BU Field is present");


		verifyTextContains(MAG,"MAG");
		verifyTextContains(MAG, "Text(4)");
		System.out.println("MAG Field is present");


		verifyTextContains(AG,"AG");
		verifyTextContains(AG, "Text(4)");
		System.out.println("AG Field is present");


		verifyTextContains(MPG,"MPG");
		verifyTextContains(MPG, "Text(3)");
		System.out.println("MPG Field is present");


		verifyTextContains(MG3,"MG3");
		verifyTextContains(MG3, "Text(3)");
		System.out.println("MG3 Field is present");


		verifyTextContains(Value,"Value");
		verifyTextContains(Value, "Number");
		System.out.println("Value Field is present");


		verifyTextContains(Valid_on,"Valid On");
		verifyTextContains(Valid_on, "Date");
		System.out.println("Valid On Field is present");


		verifyTextContains(Valid_from,"Valid From");
		verifyTextContains(Valid_from, "Date");
		System.out.println("Valid from Field is present");


		verifyTextContains(valid_to,"Valid To");
		verifyTextContains(valid_to, "Date");
		System.out.println("Valid To Field is present");


		verifyTextContains(indicator,"Deletion Indicator");
		verifyTextContains(indicator, "Text(1)");
		System.out.println("indicator Field is present");


		verifyTextContains(flag,"Item Flag");
		verifyTextContains(flag, "Text(1)");
		System.out.println("Item Flag Field is present");


		verifyTextContains(Status,"Status");
		verifyTextContains(Status, "Picklist");
		System.out.println("Status Field is present");


		verifyTextContains(Error,"Error");
		verifyTextContains(Error, "Text(255)");
		System.out.println("Error Field is present");


		verifyTextContains(pricelist,"Price List Item");
		verifyTextContains(pricelist, "Lookup");
		System.out.println("pricelist Field is present");


		verifyTextContains(lineitem,"Line Item");
		verifyTextContains(lineitem, "Lookup");
		System.out.println("lineitem Field is present");


		verifyTextContains(agreement,"Agreement");
		verifyTextContains(agreement, "Lookup");
		System.out.println("Agreement Field is present");


		verifyTextContains(Externalid,"External Id");


	}




	public void verify_SalesDealTempfields() {
		// TODO Auto-generated method stub

		verifyTextContains(Agrrement_line_item,"Agreement");
		verifyTextContains(Agrrement_line_item, "Text");
		System.out.println("Agreement line item Field is present");


		verifyTextContains(type,"Type");
		verifyTextContains(type, "Text");
		System.out.println("type Field is present");
		driver.navigate().refresh();
		waitTill("6");


		verifyTextContains(Agreement,"Agreement");
		verifyTextContains(Agreement, "Text");
		System.out.println("Agreement Field is present");

		verifyTextContains(SAPAgreement,"SAP Agreement");
		verifyTextContains(SAPAgreement, "Text");
		System.out.println("SAPAgreement Field is present");

		verifyTextContains(salesorg,"Sales Org");
		verifyTextContains(salesorg, "Text(4)");
		System.out.println("Sales Org Field is present");

		verifyTextContains(Product_Bundle,"Product Id");
		verifyTextContains(Product_Bundle, "Text");
		System.out.println("Product Id of Bundle Field is present");

		verifyTextContains(	Option_Id,"Option Id");
		verifyTextContains(	Option_Id, "Text");
		System.out.println("Option_Id of Bundle Field is present");

		verifyTextContains(	Hierarchy,"Hierarchy");
		verifyTextContains(	Hierarchy, "Text");
		System.out.println("Hierarchy Field is present");

		verifyTextContains(Tier1	,"Tier");
		verifyTextContains(Tier1, "Percent(16,2)");
		System.out.println("Tier 1 Discount Field is present");

		verifyTextContains(Tier2	,"Tier");
		verifyTextContains(Tier2, "Percent(16,2)");
		System.out.println("Tier 2 Discount Field is present");

		verifyTextContains(Tier3	,"Tier");
		verifyTextContains(Tier3, "Percent(16,2)");
		System.out.println("Tier 3 Discount Field is present");

		verifyTextContains(Tier4	,"Tier");
		verifyTextContains(Tier4, "Percent(16,2)");
		System.out.println("Tier 4 Discount Field is present");

		verifyTextContains(Agreement_group_name,"Agreement Group Name");
		verifyTextContains(Agreement_group_name, "Text");
		System.out.println("Agreement Group Name is present");

		verifyTextContains(agreementid,"Agreement Group Id");
		verifyTextContains(agreementid, "Text");
		System.out.println("Agreement Group Id Field is present");

		verifyTextContains(Action,"Action");
		verifyTextContains(Action, "Text");
		System.out.println("Action Field is present");


	}




	public void qucikfind(String searchitem) {
		// TODO Auto-generated method stub
		enter("quick find",quickfind, searchitem);
		waitTill("5");
		click("permission set", Permission_set);
		waitTill("6");

	}




	public void verify_permissionset_feields() {
		// TODO Auto-generated method stub
		waitAndswitchToRequiredFrame(frame);
		verifyTextContains(Contractmanager, "Apttus CLM Contract Manager");
		verifyTextContains(Contractspecialist, "Apttus CLM Contract Specialist");
		verifyTextContains(customprogram, "Apttus Custom Program Admin");



	}





	public void navigate_to_salesdeal() {
		// TODO Auto-generated method stub
		click("Setting symbol", setting_symbol);
		waitTill("5");
		click("Set Up",setup);
		switchToTab(1);

	}
	public void click_on_objectmanager(){
		waitTill("5");
		waitForElement(ObjectManager, "Object Manager");
		click("Object Manager link", ObjectManager);

	}


	public void Search_for_Deal(String object) {
		// TODO Auto-generated method stub
		enter("Sale Deal Type",SearchField , object);
		waitTill("5");
		WebElement objectlink=driver.findElement(By.xpath("//a[text()='"+object+"']"));
		click("object Link", objectlink);
		waitTill("5");

	}

	public void navigate_to_fields() {
		// TODO Auto-generated method stub
		click("Field & Relationships", Fields);
		waitTill("5");

	}




	public void clickConfigureProduct() {
		waitTill("5");
		waitForElementToEnable(btn_configureProducts);
		waitForElement(btn_configureProducts, "Configure product");
		click("Configure Products", btn_configureProducts);
		waitTill("30");
	}

	public void AddBundeledProducts(String productCode)
	{
	}




	public void clickOnGoToPricing() {
		// TODO Auto-generated method stub
		
	}


}