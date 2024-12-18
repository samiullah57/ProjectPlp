package com.philips.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.philips.cucumber.listener.Reporter;
import com.philips.generic.AutomationConstants;
import com.philips.generic.Excel;
import com.philips.generic.Utility;

public class ServiceMaxFCOPage extends BasePage {

	public ServiceMaxFCOPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath="//*[@id='00N4W0000074dJJ_chkbox']")
	private WebElement locationBasedFCO_checkBox;
	
	@FindBy(xpath="//*[text()='Field Change Order']")
	private WebElement fco_headerLine;
	
	@FindBy(xpath="//*[@title='Create UAL Case']")
	private WebElement createUALCase_button;

	@FindBy(xpath="//*[@title='Create UAL Work Orders']")
	private WebElement createUALWorkOrder_button;
	
	@FindBy(xpath="(//*[text()='0116440392'])[1]")
	private WebElement createdUALcase_1stLine;
	
		//	(//*[@class='dataRow even first']//a)[3]
	
	@FindBy(xpath="(//*[text()= 'Case Number'])[1]")
	private WebElement caseDetailsPage_header;
	
	@FindBy(xpath="//th[text()= 'Work Order Number']/../following-sibling::tr/th[@scope='row']/a")
	private WebElement workOrderNumber_data;
	
	@FindBy(xpath="//*[text()='Details']")
	private WebElement detailsTab;
	
	@FindBy(xpath="//label[text()='FCO Classification']/ancestor::tr[1]//select")
	private WebElement FCOClassification;
	
	@FindBy(xpath="//label[text()='BG']/ancestor::tr[1]//input")
	private WebElement BG;
	
	@FindBy(xpath="//label[text()='FCO Lifecycle Status']/ancestor::tr[1]//select")
	private WebElement FCOLifecycleStatus;
	
	@FindBy(xpath="//label[text()='Delivery Method']/ancestor::tr[1]//select")
	private WebElement DeliveryMentod;
	
	
	@FindBy(xpath="//label[text()='BU']/ancestor::tr[1]//input")
	private WebElement BU;
	
	@FindBy(xpath="//label[text()='FCO Release Date']/ancestor::tr[1]//input")
	private WebElement FCOReleaseDate;
	
	@FindBy(xpath="//label[text()='FCO Global Due Date']/ancestor::tr[1]//input")
	private WebElement FCOGlobalDueDate;
	
	@FindBy(xpath="//label[text()='FCO UAL Author']/ancestor::tr[1]//input")
	private WebElement FCOUALAuthor;
	
	@FindBy(xpath="//label[text()='FSN']/ancestor::tr[1]//input")
	private WebElement FSN;
	
	@FindBy(xpath="//label[text()='Decision Date']/ancestor::tr[1]//input")
	private WebElement DecisionDate;
	
	@FindBy(xpath="//h2[@class='pageDescription' and contains(text(),'2021')]")
	private WebElement FCORec;
		
	@FindBy(xpath="//label[text()='As-Maintained  Equipment User Status']/ancestor::td[1]/following-sibling::td//input")
	private WebElement asMaintainedEquipmentUserStatus;
		
	@FindBy(xpath="//label[text()='As-Maintained System  Equipment Number']/ancestor::td[1]/following-sibling::td//input")
	private WebElement asMaintainedSystemEquipmentNumber;

	@FindBy(xpath="//label[text()='Maintenance plant']/ancestor::td[1]/following-sibling::td[1]//input")
	private WebElement maintenanceplant;
	
	@FindBy(xpath="//label[text()='FCO Header - UAL']/ancestor::td[1]/following-sibling::td[1]/span/input")
	private WebElement FCOHeaderUAL;
	
	@FindBy(xpath="//label[text()='UniqueIdentifier']/ancestor::td[1]/following-sibling::td//input")
	private WebElement UniqueIdentifier;
	
	@FindBy(xpath="//h3[text()='UAL']/ancestor::div[1]/following-sibling::div//td[4]")
	private WebElement UALCaseNumber;
	
	@FindBy(xpath="//h3[text()='UAL']/ancestor::div[1]/following-sibling::div//td[4]/a")
	private WebElement UALCaseNumberlink;
	
	@FindBy(xpath = "//a[text()='Field Change Orders']")
	public WebElement field_Change_Orders;
	
	@FindBy(xpath = "//a[text()='Add new records']")
	public WebElement add_New_Records;
	
	@FindBy(xpath="//img[@title='All Tabs']")
	protected WebElement allTabsIcon;
	
	public static String UALRecordNumber = null;
	public static String FCORecordNumber = null;
	public static String FCOURL = null;
		
	public void verify_LocationBasedFCO(String valueToBeVerified) {
		waitForElement(fco_headerLine, "FCO Page Header");
		scrollByViewOfElement(locationBasedFCO_checkBox);
		highlightElement(driver, locationBasedFCO_checkBox, "1");
		
		if(locationBasedFCO_checkBox.getAttribute("title").equalsIgnoreCase("Checked"))
			logReport("PASS", "Location Based FCO is Checked");
		else
			Assert.fail("Location Based FCO is not Checked");
	}


	public void createCase_forAllUAL() {
		waitForElement(createUALCase_button, "Create UAL Case Button");
		click("Create UAL Case", createUALCase_button);
		waitTill("2");
		try
		{		
		driver.switchTo().alert().accept();
		}
		catch(Exception e)
		{}
		waitTill("10");
		driver.navigate().refresh();
	}


	public void verify_caseCreated_forAllUAL() 
	{
		
		waitTill("10");
		for(int i=0; i<5; i++)
		{
		try
		{
			if(!UALCaseNumberlink.getText().equals(null))
			{
				break;
			}
			waitTill("10");
		}
		catch(Exception e)
		{
			System.out.println("Case not created");
		}
		}
		
		logReport("PASS", "Case Number generated");
		
	}
	
	public void createUALWorkOrder_forAllUAL() {
		// TODO Auto-generated method stub
		waitForElement(createUALWorkOrder_button, "Create UAL Work Order Button");
		click("Create UAL Work Order", createUALWorkOrder_button);
		waitTill("2");
		driver.switchTo().alert().accept();
		waitTill("5");
		/*driver.switchTo().alert().accept();
		waitTill("5");*/
		driver.navigate().refresh();
	}


	public void capture_WorkOrderNumber()
	{
	waitForElement(createdUALcase_1stLine, "UAL Case");
	click("UAL Case", createdUALcase_1stLine);
	waitForElement(caseDetailsPage_header, "Page Header");
	click("Details", detailsTab);
	waitForElement(workOrderNumber_data, "Work Order Number");
	scrollByViewOfElement(workOrderNumber_data);
	AutomationConstants.RUN_TIME_TEMP_DATA.put("WorkOrder_No", workOrderNumber_data.getText());
	AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("WORK_ORDER_NUMBER", workOrderNumber_data.getText());
	logReport("INFO", "Work Order No:"+workOrderNumber_data.getText());
	
	}
	
	public void createFCA(String recordtype)//FCO Header
	{
		click("All Tabs ", allTabsIcon);
		click("Field Change Order", field_Change_Orders);
		click("New Button", newButton);
		selectbyValue(add_New_Records, recordtype, "Select Record Type");
		click("Continue Button", continueButton);
		selectbyValue(FCOClassification, "Mandatory", "FCO Classificaiton");
		selectbyValue(FCOLifecycleStatus, "Released / In Progress","FCO Life Cycle");
		selectbyValue(DeliveryMentod, "Onsite", "DeliveryMentod");
		enter("FCO Global Due Date", FCOGlobalDueDate, Utility.getSFDCDateFormated());
		enter("FCO Release Date", FCOReleaseDate, Utility.currentDateManupulation(2, 1));
		enter("BG", BG, "IS");
		enter("BU", BU, "IGT");
		enter("FCO UAL Author", FCOUALAuthor, "Manu‚la Voorn");
		enter("Decision Date", DecisionDate, Utility.getSFDCDateFormated());
		click("FSN", FSN);
		click("Save", saveButton);
		verifyElementPresent("FCO Record", FCORec);
		FCORecordNumber = FCORec.getText();
		FCOURL = driver.getCurrentUrl();
		
	}
	
	public void createUAL(String recordtype)
	{
		ArrayList<Map<String, String>> data = Excel.getSheetData(AutomationConstants.DataFilePath, "UAL");
		click("All Tabs ", allTabsIcon);
		click("Field Change Order", field_Change_Orders);
		click("New Button", newButton);
		selectbyValue(add_New_Records, recordtype, "Select Record Type");
		click("Continue Button", continueButton);
		System.out.println(data.get(0).get("Equipment Number").replaceAll("IP_", ""));
		enter("Equipment Number", asMaintainedSystemEquipmentNumber, data.get(0).get("Equipment Number").replaceAll("IP_", ""));
		enter("UserStatus", asMaintainedEquipmentUserStatus, data.get(0).get("User Status"));
		enter("Maintanance Plan", maintenanceplant, data.get(0).get("Maintenance plant"));
		
		enter("FCO Header", FCOHeaderUAL, FCORecordNumber);
		enter("Unique Identifier", UniqueIdentifier, "UAL"+Utility.getFormatedDateTime().replaceAll("_", ""));
		click("Save", saveButton);
		verifyElementPresent("FCO Record", FCORec);
		UALRecordNumber = FCORec.getText();
	}


	public void accessFCORecord() 
	{
		driver.get(FCOURL);
		
	}
	
	public void verify_UAL_FCO_Work_Orders() {
		waitTill("3");
		click("Click Case", UALCaseNumberlink);
		waitForElement(detailsTab, "createWorkOrders");
		click("case_Details", detailsTab);
		waitTill("3");
		new WorkOrderPage(driver).accessWorkOrderfromCase();
		try {
			Reporter.addScreenCaptureFromPath(Utility.getPageScreenShot(driver), "Passed");
		} catch (IOException e) {}
	}
}