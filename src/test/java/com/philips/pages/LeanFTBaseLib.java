package com.philips.pages;

import static java.time.Duration.ofMillis;


import com.aventstack.extentreports.ExtentTest;
import com.hp.lft.sdk.Description;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.ModifiableSDKConfiguration;
import com.hp.lft.sdk.SDK;
import com.hp.lft.sdk.sap.gui.Button;
import com.hp.lft.sdk.sap.gui.ButtonDescription;
import com.hp.lft.sdk.sap.gui.ComponentType;
import com.hp.lft.sdk.sap.gui.EditField;
import com.hp.lft.sdk.sap.gui.EditFieldDescription;
import com.hp.lft.sdk.sap.gui.GuiSession;
import com.hp.lft.sdk.sap.gui.GuiSessionDescription;
import com.hp.lft.sdk.sap.gui.GuiSessionFactory;
import com.hp.lft.sdk.sap.gui.Menubar;
import com.hp.lft.sdk.sap.gui.MenubarDescription;
import com.hp.lft.sdk.sap.gui.OKCode;
import com.hp.lft.sdk.sap.gui.OKCodeDescription;
import com.hp.lft.sdk.sap.gui.SapFunctionKey;
import com.hp.lft.sdk.sap.gui.StatusBar;
import com.hp.lft.sdk.sap.gui.StatusBarDescription;
import com.hp.lft.sdk.sap.gui.TabControl;
import com.hp.lft.sdk.sap.gui.TabControlDescription;
import com.hp.lft.sdk.sap.gui.Table;
import com.hp.lft.sdk.sap.gui.TableCell;
import com.hp.lft.sdk.sap.gui.TableDescription;
import com.hp.lft.sdk.sap.gui.TableRow;
import com.hp.lft.sdk.sap.gui.ToolBar;
import com.hp.lft.sdk.sap.gui.ToolBarDescription;
import com.hp.lft.sdk.sap.gui.TreeView;
import com.hp.lft.sdk.sap.gui.TreeViewDescription;
import com.hp.lft.sdk.sap.gui.Window;
import com.hp.lft.sdk.sap.gui.WindowDescription;
import com.philips.cucumber.listener.Reporter;
import com.philips.generic.AutomationConstants;
import com.philips.generic.Excel;
import com.philips.generic.Utility;
import com.philips.generic.configs.EnvironmentFactory;
import com.sun.java.swing.plaf.windows.resources.windows;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;


public class LeanFTBaseLib extends BaseLib
{
//	public static GuiSession session;
	static WindowDescription sAPWindow = new WindowDescription.Builder().name("wnd[0]").program("SAPLSMTR_NAVIGATION").screenNumber(100l).transaction("SESSION_MANAGER").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();
	static WindowDescription SWOSearchWindow = new WindowDescription.Builder().name("wnd[0]").program("SAPLCOIH").screenNumber(101l).transaction("IW33").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();
	static OKCodeDescription oKCode = new OKCodeDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.OK_CODE_FIELD).build();
	static GuiSessionDescription cnsession = new GuiSessionDescription.Builder().name("ses[1]").build();
	static WindowDescription cnWindow = new WindowDescription.Builder().name("wnd[0]").program("SAPMC29C").screenNumber(100l).transaction("CC03").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();
	static WindowDescription cnheaderwindow = new WindowDescription.Builder().name("wnd[0]").program("SAPMC29C").screenNumber(10l).transaction("CC03").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();
	static ButtonDescription objectsbtn = new ButtonDescription.Builder().name("btn[7]").type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static WindowDescription parentbomwindow = new WindowDescription.Builder().name("wnd[0]").program("SAPMC29C").screenNumber(2000l).transaction("CC03").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();
    static TableDescription parentparttable = new TableDescription.Builder().name("SAPMC29CTCO").type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build();
    static WindowDescription childPartwindow = new WindowDescription.Builder().name("wnd[0]").program("SAPLCSDI").screenNumber(2150l).transaction("CS02").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();
    static TableDescription childparttable = new TableDescription.Builder().name("SAPLCSDITCMAT").type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build();
    static WindowDescription designatorwindow = new WindowDescription.Builder().name("wnd[0]").program("SAPLCSDI").screenNumber(192l).transaction("CS02").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();
    static TableDescription designatortable = new TableDescription.Builder().name("SAPLCSDITCUPS").type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build();
    static ButtonDescription backbutton = new ButtonDescription.Builder().name("btn[3]").type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build(); 
    static TabControlDescription tabdocument = new TabControlDescription.Builder().name("TS_ITOV").type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build();
    static TableDescription doctable = new TableDescription.Builder().name("SAPLCSDITCDOK").type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build();
    static EditFieldDescription orderEditField = new EditFieldDescription.Builder().name("CAUFVD-AUFNR").type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
    static WindowDescription operationsOV = new WindowDescription.Builder().program("SAPLCOIH").screenNumber(3000l).transaction("IW33").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();
    static TabControlDescription operationstab = new TabControlDescription.Builder().name("TS_1100").type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build();
    static EditFieldDescription SAPSWONumber = new EditFieldDescription.Builder().name("CAUFVD-AUFNR").type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
    static TableDescription operationsTable = new TableDescription.Builder().name("SAPLCOVGTCTRL_3010").type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build();
    static ButtonDescription enhancmentButton = new ButtonDescription.Builder().name("BTN_VGD5").type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	private static String SAPUserName;
	private static String SAPpassword;
	public static String transcationCode;

	public static GuiSession session;
	
	public LeanFTBaseLib(WebDriver driver)
	{
		super(driver);
		
	}
	
		//	LeanFt Initialization
	public static void leanftInvoke() throws Exception
	{
		//	leanftruntimeengineStart();
		try{
			LeanFTBaseLib.closeSAP();
			Thread.sleep(5000);
		}catch (Exception e) {
			// TODO: handle exception
		}
		ModifiableSDKConfiguration config = new ModifiableSDKConfiguration();
		config.setAutoLaunch(false);
		SDK.init(config);
	}

	//	Starting LeanFt Runtime engine
	public static void leanftruntimeengineStart() throws IOException, InterruptedException{	
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "leanft.bat start");
		File dir = new File("C:/Program Files (x86)/Micro Focus/UFT Developer/bin/");
		pb.directory(dir);
		Process p = pb.start(); 
		Thread.sleep(20000);
		System.out.println("LeanFT RunTime Engine is Started");
	}

	//  Launching and login to SAP Application
	public  void sapLaunch(String user,String client) throws GeneralLeanFtException, InterruptedException{
		switch (user) {
		case "SAPUSER":
			/*SAPUserName = EnvironmentFactory.getSAPConfigValue("SAPUserName1");
			SAPpassword = Utility.decode(EnvironmentFactory.getSAPConfigValue("SAPPassword1"));
			*/break;

		default:
			break;
		}
		//GuiSession session = GuiSessionFactory.launch("MQ2", "990","320101490", "Stronger#2020");
		int count=0;
		while(count<=3)
		try{
		System.out.println(SAPUserName+" "+SAPpassword);
		//session = GuiSessionFactory.launch(AutomationConstants.SAP, client, SAPUserName,SAPpassword);
		logReport("Info","username password Entered");
		Thread.sleep(5000);
//	   Window sapWindow = session.describe(Window.class, sAPWindow);
//	   sapWindow.maximize();
//		sapWindow.highlight();
//		if(sapWindow.exists())
//		{
//			Reporter.addStepLog("SAP application was launched and logged in succesfully");
//			
//		}
//		else{
//			Reporter.addStepLog("FAILED to Launch SAP application");
//		}
		break;
		}catch (Exception e) {
			LeanFTBaseLib.closeSAP();
			Thread.sleep(5000);
			count++;
		}
	}

	//  Declaring SAP Main window	
	public static Window Window() throws GeneralLeanFtException{
		Window window = session.describe(Window.class, sAPWindow);
		return window;

	}

	// Entering TA Code in SAP Application
	public static void sapEnterTAcode(String TAcode) throws GeneralLeanFtException{
		transcationCode = TAcode;
		try {	
			Thread.sleep(5000);
			Window window = session.describe(Window.class, new WindowDescription.Builder().transaction("SESSION_MANAGER").program("SAPLSMTR_NAVIGATION").type(ComponentType.MAIN_WINDOW).name("wnd[0]").build());			OKCode okCode = window.describe(OKCode.class, new OKCodeDescription.Builder().type(ComponentType.OK_CODE_FIELD).build());
			okCode.setValue(TAcode);
			window.sendKey(SapFunctionKey.ENTER);
			Reporter.addStepLog(TAcode+" entered Successfully");
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Getting Change Number screen and window	
	public static Window CNWindow() throws GeneralLeanFtException{
		Window cnwindow = null;
		cnwindow = session.describe(Window.class, SWOSearchWindow);
		cnwindow.highlight();
		return cnwindow;
	}

	//	Declaring CN Header window
	public static Window CNheaderWindow() throws GeneralLeanFtException{
		Window cnheaderWindow = null;
		GuiSessionDescription session1 =  new GuiSessionDescription.Builder().name("ses[1]").build();
		GuiSession[] textsession = GuiSessionFactory.getAllOpenSessions(session1);
		for(GuiSession sess :textsession){
			cnheaderWindow = sess.describe(Window.class, cnheaderwindow);
			cnheaderWindow.highlight();

		}
		return cnheaderWindow;


	}

	//  Clicking object button
	public static void objectButtonclick() throws InterruptedException{
		try {
			Button objectsButton = CNheaderWindow().describe(Button.class, objectsbtn);
			objectsButton.highlight();
			objectsButton.click();
			Thread.sleep(5000);
			Reporter.addStepLog(Utility.getFormatedDateTime()+"Objects button is clicked");	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//	Declaring Parentpart window
	public static Window parentbomWindow() throws GeneralLeanFtException{
		Window parentBomwindow = null;
		GuiSessionDescription session1 =  new GuiSessionDescription.Builder().name("ses[1]").build();
		GuiSession[] textsession = GuiSessionFactory.getAllOpenSessions(session1);
		for(GuiSession sess :textsession){
			parentBomwindow = sess.describe(Window.class, parentbomwindow);
			parentBomwindow.highlight();

		}
		return parentBomwindow;

	}

	//  Validating Parent part details in the table
	public static void verifyParentpartTable() throws GeneralLeanFtException, CloneNotSupportedException, InterruptedException{
		Table parentParttable = parentbomWindow().describe(Table.class, parentparttable);
		int intcount = parentParttable.getRows().size();
		System.out.println(intcount);
		parentParttable.highlight();
		String val = "3000-093-36141    /US9E/1";    
		TableRow<TableCell> row = parentParttable.findRowWithCellTextInColumn(val, "Object");
		String actVal = row.getCell("Object").getValue();
		if(!(actVal==val))
			Reporter.addStepLog(Utility.getFormatedDateTime()+"Parent part details are verified successfully");
		else{
			Reporter.addStepLog(Utility.getFormatedDateTime()+"Expected parent part value not matched with actual value");


		}
	}

	//	Clicking on parent part details
	public static void clickParentpart(){		
		try {
			Table parentParttable = parentbomWindow().describe(Table.class, parentparttable);
			parentParttable.activateCell(1, "Object");
			Thread.sleep(3000);
			Reporter.addStepLog(Utility.getFormatedDateTime()+"Parent part is clicked");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//	Declaring Child parts window
	public static Window childpartWindow() throws GeneralLeanFtException{
		Window childpartwindow = null;
		GuiSessionDescription session1 =  new GuiSessionDescription.Builder().name("ses[1]").build();
		GuiSession[] textsession = GuiSessionFactory.getAllOpenSessions(session1);
		for(GuiSession sess :textsession){
			childpartwindow = sess.describe(Window.class, childPartwindow);
			childpartwindow.highlight();

		}
		return childpartwindow;


	}

	//	Getting row number of child parts
	public static int getrowchildpart(String part){
		Table childParttable;
		String partactVal = null;
		int rowNbr = 0;
		try {
			childParttable = childpartWindow().describe(Table.class, childparttable);
			for(int i=0;i<4;i++){
				TableRow<TableCell> val = childParttable.getRows().get(i);
				partactVal = val.getCell("Component").getValue();
				if(part.equalsIgnoreCase(partactVal)){
					rowNbr=i;
					break;
				}

			}
		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}
		return rowNbr;

	}

	//	Validating child part details
	public static void verifyPartdetails(String partNbr,int row, String expField, String expVal) throws GeneralLeanFtException{
		String actVal = null;
		TableRow<TableCell> rowval;
		Table childParttable = childpartWindow().describe(Table.class, childparttable);
		rowval = childParttable.getRows().get(row);
		switch(expField){
		case "Component":			
			actVal = rowval.getCell(expField).getValue();
			break;
		case "Item":
			actVal = rowval.getCell(expField).getValue();
			break;
		case "Quantity":
			actVal = rowval.getCell(expField).getValue();
			break;
		case "Un":
			actVal = rowval.getCell(expField).getValue();
			break;
		case "Valid From":
			actVal = rowval.getCell(expField).getValue();
			break;
		default:
		}

		if(expVal.equalsIgnoreCase(actVal)){
			Reporter.addStepLog(Utility.getFormatedDateTime()+"For Part: "+partNbr +" -row"+ (row+1) + " || " +expField+" || "+expVal+ ": value matched with : "+actVal);
		}

		else{
			Reporter.addStepLog(Utility.getFormatedDateTime()+"For Part: "+partNbr +" -row"+ (row+1) + " || " +expField+" || "+expVal+ ": value not matched with : "+actVal);
		}

	}

	//	Declaring Reference Designator window
	public static Window refDesignatorWindow() throws GeneralLeanFtException{
		Window designatorWindow = null;
		GuiSessionDescription session1 =  new GuiSessionDescription.Builder().name("ses[1]").build();
		GuiSession[] textsession = GuiSessionFactory.getAllOpenSessions(session1);
		for(GuiSession sess :textsession){
			designatorWindow = sess.describe(Window.class, designatorwindow);
			designatorWindow.highlight();

		}
		return designatorWindow;


	}

	//	Validating Reference Designator details for part
	public static void verifyreferenceDesignator(String partNbr,int row,String expField, String expVal) throws InterruptedException{

		try {
			String actVal = null;
			Table childParttable = childpartWindow().describe(Table.class, childparttable);
			childParttable.activateCell(row, "SIs");
			Thread.sleep(3000);
			Table refDesignatortable = refDesignatorWindow().describe(Table.class, designatortable);
			switch(expField){
			case "Installation Point":
				TableRow<TableCell> rowval = refDesignatortable.findRowWithCellTextInColumn(expVal, expField, row);
				actVal = rowval.getCell(expField).getValue();
				break;
			default:
			}

			if(expVal.equalsIgnoreCase(actVal)){
				Reporter.addStepLog(Utility.getFormatedDateTime()+"Reference designator for Part: "+partNbr +" -row"+row + " || " +expField+" || "+expVal+ ": value matched with : "+actVal);
			}
			else{
				Reporter.addStepLog(Utility.getFormatedDateTime()+"Reference designator for Part: "+partNbr +" -row"+row + " || " +expField+" || "+expVal+ ": value not matched with : "+actVal);
			}

		} catch (GeneralLeanFtException e) {
			e.printStackTrace();
		}
	}

	//	Navigating to Document Window
	public static void navigatetoDocumentwindow(){	  
		try {
			Button backButton = refDesignatorWindow().describe(Button.class, backbutton);
			backButton.highlight();
			backButton.click();
			Thread.sleep(5000);
			Reporter.addStepLog(Utility.getFormatedDateTime()+"Back button is clicked");
			TabControl tabDocument = childpartWindow().describe(TabControl.class, tabdocument);
			tabDocument.select("Document");
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//	Validating Document details
	public static void verifyDocumentdetails(String expField, String expVal){
		try {
			String actVal = null;
			TableRow<TableCell> rowval;
			Table docTable = childpartWindow().describe(Table.class, doctable);
			switch(expField){
			case "ICt":
				rowval = docTable.findRowWithCellTextInColumn(expVal, expField, 5);
				actVal = rowval.getCell(expField).getValue();
				break;
			case "Document":
				rowval = docTable.findRowWithCellTextInColumn(expVal, expField, 5);
				actVal = rowval.getCell(expField).getValue();
				break;
			default:
			}

			if(expVal.equalsIgnoreCase(actVal)){
				Reporter.addStepLog(Utility.getFormatedDateTime()+"Document details for Part: || " +expField+" || "+expVal+ ": value matched with : "+actVal);
			}
			else{
				Reporter.addStepLog(Utility.getFormatedDateTime()+"Document details for Part: || " +expField+" || "+expVal+ ": value not matched with : "+actVal);
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	} 

	//  Closing SAP Application
	public static void closeSAP(){
		try{
			Runtime run = Runtime.getRuntime();
			run.exec("taskkill /F /IM saplogon.exe /T");
			Reporter.addStepLog(Utility.getFormatedDateTime()+"SAP Application is closed successfully");
		}
		catch(Exception e){
			System.err.println("Caught Exception: " + e.getMessage());
			Reporter.addStepLog(Utility.getFormatedDateTime()+"SAP Application is not closed");
		}
	}



	
	public static Window OperationsOverviewWindow() throws GeneralLeanFtException{
		Window window = session.describe(Window.class, operationsOV);
		return window;

	}

	public void clickonOperationsTab() throws GeneralLeanFtException 
	{
		TabControl operationsTab = OperationsOverviewWindow().describe(TabControl.class, operationstab);
		try{
			operationsTab.select("Operations");
			Thread.sleep(4000);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		EditField SWONumber = OperationsOverviewWindow().describe(EditField.class, SAPSWONumber);
		SWONumber.highlight();
//		String actVal = SWONumber.getText();
//		if(ServiceMaxValues.get("SWONumber").equalsIgnoreCase(actVal))
//		{
//			Reporter.addStepLog(Utility.getFormatedDateTime()+"SWO number matched with : "+actVal);
//		}
//
//		else{
//			Reporter.addStepLog(Utility.getFormatedDateTime()+"SWO number did not match with : "+actVal);
//			Assert.fail();
//		}
	}
	public static void verifyOperationsTab1(String expField, String expVal) throws GeneralLeanFtException{

		String actVal = null;
		TableRow<TableCell> rowval;
		Table operationsTabletemp = OperationsOverviewWindow().describe(Table.class, operationsTable);
		operationsTabletemp.highlight();
		rowval = operationsTabletemp.getRows().get(0);
		switch(expField){
		case "Plant":			
			actVal = rowval.getCell(expField).getValue();
			if(expVal.equalsIgnoreCase(actVal)){
				Reporter.addStepLog(Utility.getFormatedDateTime()+"For " +expField+" || "+expVal+ ": value matched with : "+actVal);
			}

			else{
				Reporter.addStepLog(Utility.getFormatedDateTime()+"For " +expField+" || "+expVal+ ": value not matched with : "+actVal);
				Assert.fail();
			}
			break;
		case "Operation short text":
			actVal = rowval.getCell(expField).getValue();
			if(expVal.equalsIgnoreCase(actVal)){
				Reporter.addStepLog(Utility.getFormatedDateTime()+"For " +expField+" || "+expVal+ ": value matched with : "+actVal);
			}

			else{
				Reporter.addStepLog(Utility.getFormatedDateTime()+"For " +expField+" || "+expVal+ ": value not matched with : "+actVal);
				Assert.fail();
			}
			break;

		default:
		}

	}
	
	
	
	public void leanFtEnterText(EditField field,String input,String label) throws GeneralLeanFtException {
		
			field.highlight();
			field.setText(input);
			Reporter.addStepLog(label+" Entered");
		
	}

	public void leantFtPressEnterOnWindow(Window window) throws GeneralLeanFtException {
		window.highlight();
		window.sendKey(SapFunctionKey.ENTER);
		Reporter.addStepLog("Press Enter");
	}
	
	public static void doubleclick() throws Exception{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_F2);
		waitTill("5");
		robot.keyRelease(KeyEvent.VK_F2);
	}
	
	public void scrolldown() throws Exception{
		int i=0;
		while(i<5){
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		waitTill("5");
		robot.keyRelease(KeyEvent.VK_DOWN);
		}
	}
	
	public void toolBar(String value,int i) throws Exception{
		Window projectBuilderWindow = session.describe(Window.class, new WindowDescription.Builder()
				.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build());
		ToolBar toolBarControlToolBar = projectBuilderWindow.describe(ToolBar.class, new ToolBarDescription.Builder()
				.name("shell")
				.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_TOOL_BAR)
				.index(i).build());
		toolBarControlToolBar.pressButton(value);
		logReport("INFO", "The toolbar value "+value+"is selected");
	}
	
	
	
	
	
	

		
	
}