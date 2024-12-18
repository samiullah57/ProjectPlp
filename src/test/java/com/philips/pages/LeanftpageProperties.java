package com.philips.pages;


import org.openqa.selenium.WebDriver;

import com.hp.lft.sdk.sap.gui.Button;
import com.hp.lft.sdk.sap.gui.ButtonDescription;
import com.hp.lft.sdk.sap.gui.EditFieldDescription;
import com.hp.lft.sdk.sap.gui.ElementDescription;
import com.hp.lft.sdk.sap.gui.GridDescription;
import com.hp.lft.sdk.sap.gui.GuiSession;
import com.hp.lft.sdk.sap.gui.GuiSessionDescription;
import com.hp.lft.sdk.sap.gui.LabelDescription;
import com.hp.lft.sdk.sap.gui.MenubarDescription;
import com.hp.lft.sdk.sap.gui.OKCodeDescription;
import com.hp.lft.sdk.sap.gui.TabControlDescription;
import com.hp.lft.sdk.sap.gui.Table;
import com.hp.lft.sdk.sap.gui.TableDescription;
import com.hp.lft.sdk.sap.gui.ToolBarDescription;
import com.hp.lft.sdk.sap.gui.TreeViewDescription;
import com.hp.lft.sdk.sap.gui.Window;
import com.hp.lft.sdk.sap.gui.WindowDescription;
import com.hp.lft.sdk.stdwin.Dialog;
import com.hp.lft.sdk.stdwin.DialogDescription;

public class LeanftpageProperties extends BaseLib{

	public LeanftpageProperties(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
	static WindowDescription sAPWindow = new WindowDescription.Builder().name("wnd[0]").program("SAPLSMTR_NAVIGATION")
			.screenNumber(100l).transaction("SESSION_MANAGER").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
			.build();

	static WindowDescription SWOSearchWindow = new WindowDescription.Builder().name("wnd[0]").program("SAPLCOIH")
			.screenNumber(101l).transaction("IW33").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static OKCodeDescription oKCode = new OKCodeDescription.Builder()
			.type(com.hp.lft.sdk.sap.gui.ComponentType.OK_CODE_FIELD).build();

	static GuiSessionDescription cnsession = new GuiSessionDescription.Builder().name("ses[1]").build();

	static WindowDescription cnWindow = new WindowDescription.Builder().name("wnd[0]").program("SAPMC29C")
			.screenNumber(100l).transaction("CC03").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static WindowDescription cnheaderwindow = new WindowDescription.Builder().name("wnd[0]").program("SAPMC29C")
			.screenNumber(10l).transaction("CC03").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static ButtonDescription objectsbtn = new ButtonDescription.Builder().name("btn[7]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();

	static WindowDescription parentbomwindow = new WindowDescription.Builder().name("wnd[0]").program("SAPMC29C")
			.screenNumber(2000l).transaction("CC03").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static TableDescription parentparttable = new TableDescription.Builder().name("SAPMC29CTCO")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build();

	static WindowDescription childPartwindow = new WindowDescription.Builder().name("wnd[0]").program("SAPLCSDI")
			.screenNumber(2150l).transaction("CS02").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static TableDescription childparttable = new TableDescription.Builder().name("SAPLCSDITCMAT")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build();

	static WindowDescription designatorwindow = new WindowDescription.Builder().name("wnd[0]").program("SAPLCSDI")
			.screenNumber(192l).transaction("CS02").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static TableDescription designatortable = new TableDescription.Builder().name("SAPLCSDITCUPS")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build();

	static ButtonDescription backbutton = new ButtonDescription.Builder().name("btn[3]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();

	static TabControlDescription tabdocument = new TabControlDescription.Builder().name("TS_ITOV")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build();

	static TableDescription doctable = new TableDescription.Builder().name("SAPLCSDITCDOK")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build();

	static EditFieldDescription orderEditField = new EditFieldDescription.Builder().name("CAUFVD-AUFNR")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();

	static WindowDescription operationsOV = new WindowDescription.Builder().program("SAPLCOIH").screenNumber(3000l)
			.transaction("IW33").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static TabControlDescription operationstab = new TabControlDescription.Builder().name("TS_1100")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build();

	static EditFieldDescription SAPSWONumber = new EditFieldDescription.Builder().name("CAUFVD-AUFNR")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();

	static TableDescription operationsTable = new TableDescription.Builder().name("SAPLCOVGTCTRL_3010")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build();

	static ButtonDescription enhancmentButton = new ButtonDescription.Builder().name("BTN_VGD5")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();

	static TableDescription tablefirstrow = new TableDescription.Builder().name("SAPLCOVGTCTRL_3010")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build();

	static ButtonDescription backButton = new ButtonDescription.Builder().name("btn[3]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();

	static ButtonDescription settlementButton = new ButtonDescription.Builder().name("btn[30]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();

	static WindowDescription settlementWindow = new WindowDescription.Builder().name("wnd[0]").program("SAPLKOBS")
			.screenNumber(130l).transaction("IW33").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static TableDescription settlementTable = new TableDescription.Builder().name("SAPLKOBSTC_RULES")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build();

	static MenubarDescription completionConfirmation = new MenubarDescription.Builder()
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MENUBAR).build();

	static WindowDescription confirmationWindow = new WindowDescription.Builder().name("wnd[0]").program("SAPLCORU")
			.screenNumber(3200l).transaction("IW43").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static EditFieldDescription acctgIndicatorEditField = new EditFieldDescription.Builder().name("AFRUD-BEMOT")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();

	static EditFieldDescription confirmationEditField = new EditFieldDescription.Builder().name("AFVGD-RUECK")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();

	static WindowDescription contractscreenWindow = new WindowDescription.Builder().name("wnd[0]").program("SAPMV45A")
			.screenNumber(102l).transaction("VA43").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static EditFieldDescription contractEditField = new EditFieldDescription.Builder().name("VBAK-VBELN")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();

	static WindowDescription rrserviceWindow = new WindowDescription.Builder().name("wnd[0]").program("SAPMV45A")
			.screenNumber(4001l).transaction("VA43").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static WindowDescription rrservicedataWindow = new WindowDescription.Builder().name("wnd[0]").program("SAPMV45A")
			.screenNumber(4002l).transaction("VA43").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static EditFieldDescription salesAreaDataEditField = new EditFieldDescription.Builder().name("VBAK-VKORG")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	/**
	 * This Holds configuration required to interact with SAP Application
	 */
	static WindowDescription ASOSearchWindow = new WindowDescription.Builder().name("wnd[0]").program("SAPMV45A")
			.screenNumber(102l).transaction("VA03").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static EditFieldDescription ASOOrderEditField = new EditFieldDescription.Builder().name("VBAK-VBELN")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();

	static WindowDescription ASO_Single_Parts_Overview_Window = new WindowDescription.Builder().program("SAPMV45A")
			.screenNumber(4001l).transaction("VA03").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static TabControlDescription ASO_Item_Overview_Tab = new TabControlDescription.Builder()
			.name("TAXI_TABSTRIP_OVERVIEW").type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build();

	static TableDescription ASO_Item_Overview_Table = new TableDescription.Builder().name("SAPMV45ATCTRL_U_ERF_AUFTRAG")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build();

	static WindowDescription ASO_Single_Parts_Delivery_Overview_Window = new WindowDescription.Builder().name("wnd[0]").program("SAPMV50A").screenNumber(1000l).transaction("VL01N")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static TabControlDescription ASO_Delivery_Picking_Tab = new TabControlDescription.Builder().name("TAXI_TABSTRIP_OVERVIEW")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build();

	static TableDescription ASO_Delivery_Picking_Table = new TableDescription.Builder().name("SAPMV50ATC_LIPS_PICK")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build();

	static ButtonDescription packShiftButton = new ButtonDescription.Builder().name("btn[18]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();

	static WindowDescription ASO_Delivery_Packing_Overview_Window = new WindowDescription.Builder().name("wnd[0]").program("SAPLV51G")
			.screenNumber(6000l).transaction("VL01N").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();


	static TableDescription ASO_Deleivery_Packing_Table= new TableDescription.Builder().name("SAPLV51GTC_HU_001")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build();

	static WindowDescription ASO_Delivery_Handling_Overview_Window = new WindowDescription.Builder().name("wnd[0]")
			.program("SAPLV51G").screenNumber(6100l).transaction("VL01N")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static EditFieldDescription identificationEditField = new EditFieldDescription.Builder().name("VEKP-EXIDV2")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();

	static WindowDescription ASO_Serialize_Overview_Window = new WindowDescription.Builder().name("wnd[1]").program("SAPLIPW1").screenNumber(300l).transaction("VL01N").type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW).build();

	static TableDescription ASO_Serialize_Table = new TableDescription.Builder().name("SAPLIPW1TC_SERIAL_NUMBERS").type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build();

	static ButtonDescription serializeButton = new ButtonDescription.Builder().name("btn[7]").type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();

	static ButtonDescription continueEnterButton = new ButtonDescription.Builder().name("btn[0]").type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();

	static TableDescription ASO_Delivery_Packing_Table= new TableDescription.Builder().name("SAPLV51GTC_HU_002")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build();

	static ButtonDescription packButton = new ButtonDescription.Builder().name("%#AUTOTEXT001").type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();

	static ButtonDescription saveButton = new ButtonDescription.Builder().name("btn[11]").type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();

	static WindowDescription ASO_Outbound_Delivery_Window = new WindowDescription.Builder().name("wnd[0]")
			.program("SAPMV50A").screenNumber(4001l).transaction("VL01N")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static WindowDescription ASODeliveryWindow = new WindowDescription.Builder()
			.name("wnd[0]")
			.program("SAPMV50A")
			.screenNumber(4004l)
			.transaction("VL02N")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static EditFieldDescription ASODeliveryEditField = new EditFieldDescription.Builder().name("LIKP-VBELN")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();

	static WindowDescription ASO_PostGoodsIssue_Overview_Window = new WindowDescription.Builder()
			.name("wnd[0]")
			.program("SAPMV50A")
			.screenNumber(1000l)
			.transaction("VL02N")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static ButtonDescription postGoodsIssueButton = new ButtonDescription.Builder()
			.name("btn[20]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();

	static ButtonDescription headButton = new ButtonDescription.Builder().name("BT_HEAD")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();

	static WindowDescription HeaderData_Overview_Window = new WindowDescription.Builder().name("wnd[0]").program("SAPMV45A")
			.screenNumber(4002l).transaction("VA03").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static TabControlDescription Header_Data_Table= new TabControlDescription.Builder().name("TAXI_TABSTRIP_HEAD")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build();

	static WindowDescription HeaderData_Conditions_Overview_Window = new WindowDescription.Builder().name("wnd[0]").program("SAPMV45A")
			.screenNumber(5002l).transaction("VA03").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static TabControlDescription Header_Data_Condition_Table= new TabControlDescription.Builder().name("SAPLV69ATCTRL_KONDITIONEN")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build();

	static TabControlDescription DMR_Item_Overview_Table= new TabControlDescription.Builder().name("SAPMV45ATCTRL_U_ERF_GUTLAST").type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build();

	static EditFieldDescription DMR_Item_Overview_EditField = new EditFieldDescription.Builder().name("KOMP-NETWR")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();

	static EditFieldDescription DMR_Item_Overview_Tax_EditField = new EditFieldDescription.Builder().name("KOMP-MWSBP")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();

	static TabControlDescription DMR_Partners_Table= new TabControlDescription.Builder().name("SAPLV09CGV_TC_PARTNER_OVERVIEW").type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build();

	static WindowDescription Material_Document_Overview_Window = new WindowDescription.Builder().name("wnd[0]")
			.program("SAPMM07M").screenNumber(460l).transaction("MB03")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static EditFieldDescription Material_Document_Overview_EditField = new EditFieldDescription.Builder().name("RM07M-MBLNR")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();

	static EditFieldDescription Material_Document_Year_EditField = new EditFieldDescription.Builder().name("RM07M-MJAHR")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();

	static WindowDescription Accounting_Document_Overview_Window = new WindowDescription.Builder().name("wnd[0]")
			.program("SAPMM07M").screenNumber(420l).transaction("MB03")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static ButtonDescription accountingDocButton = new ButtonDescription.Builder().name("btn[7]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();

	static EditFieldDescription docNum = new EditFieldDescription.Builder().index(0).name("MSEG-BWART").type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();

	static WindowDescription Accounting_Document_Window = new WindowDescription.Builder().name("wnd[1]")
			.program("SAPLRWCL").screenNumber(200l).transaction("MB03")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW).build();

	static GridDescription docTable = new GridDescription.Builder().name("shell")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_GRID_VIEW).build();

	static WindowDescription FISLLocalActualWindow = new WindowDescription.Builder().name("wnd[0]").program("SAPMSSY0").screenNumber(120l).transaction("GD23").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static LabelDescription FISLLocalActualLabel = new LabelDescription.Builder().relativeId("wnd[0]/usr/lbl[12,7]").type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build();

	static WindowDescription  displayMaterialDocument = new WindowDescription.Builder().name("wnd[0]").program("SAPLMIGO").screenNumber(1l).transaction("GD23").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static TabControlDescription TabControlDescription = new TabControlDescription.Builder().name("TS_GOITEM").type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build();

	static EditFieldDescription storLocEditField = new EditFieldDescription.Builder()
			.name("GODYNPRO-LGORT").type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();

	static WindowDescription equipment_Overview_window = new WindowDescription.Builder()
			.name("wnd[0]")
			.program("SAPMIEQ0")
			.screenNumber(100l)
			.transaction("IE03")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static EditFieldDescription equipment_Num = new EditFieldDescription.Builder()
			.name("RM63E-EQUNR")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();

	static WindowDescription equipment_Overview_window2  = new WindowDescription.Builder()
			.name("wnd[0]")
			.program("SAPMIEQ0")
			.screenNumber(101l)
			.transaction("IE03")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static TabControlDescription structure_Tab2 = new TabControlDescription.Builder()
			.name("TABSTRIP")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build();

	static EditFieldDescription funct_LOC = new EditFieldDescription.Builder()
			.name("ITOB-TPLNR")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();

	static EditFieldDescription superrod = new EditFieldDescription.Builder().name("ITOB-HEQUI")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();

	static WindowDescription functional_Location_Window  = new WindowDescription.Builder()
			.name("wnd[0]")
			.program("SAPMILO0")
			.screenNumber(1110l)
			.transaction("IL03")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static EditFieldDescription  functionalLocEdit= new EditFieldDescription.Builder()
			.name("IFLO-TPLNR")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();

	static TableDescription Sales_Item_Material_Aso_Item = new TableDescription.Builder().name("SAPMV45ATCTRL_U_ERF_AUFTRAG")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build();

	static WindowDescription ItemData_Overview_Window = new WindowDescription.Builder().name("wnd[0]").program("SAPMV45A")
			.screenNumber(4003l).transaction("VA03").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static TableDescription deliveryLocaTable = new TableDescription.Builder().name("SAPLV09CGV_TC_PARTNER_OVERVIEW")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build();

	static ButtonDescription itemButton = new ButtonDescription.Builder().name("BT_ITEM")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();

	static TabControlDescription taxi_structure_Tab = new TabControlDescription.Builder()
			.name("TAXI_TABSTRIP_ITEM")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build();

	static WindowDescription ASOSalesOrderWindow = new WindowDescription.Builder().name("wnd[0]").program("SAPMV45A")
			.screenNumber(102l).transaction("VA02").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static EditFieldDescription ASOSalesOrderEditField = new EditFieldDescription.Builder().name("VBAK-VBELN")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();

	static WindowDescription ASOSingleSalesOrderWindow = new WindowDescription.Builder().name("wnd[0]").program("SAPMV45A")
			.screenNumber(4001l).transaction("VA02").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static ButtonDescription flowButton = new ButtonDescription.Builder().name("btn[5]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();

	static WindowDescription DocumentFlowWindow = new WindowDescription.Builder().name("wnd[0]").program("SAPLDOCUMENT_FLOW_ALV")
			.screenNumber(100l).transaction("VA02").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static ToolBarDescription toolbar = new ToolBarDescription.Builder().name("shell[0]").type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_TOOL_BAR).build();

	static WindowDescription singlePartsDialog = new WindowDescription.Builder()
			.name("wnd[1]")
			.program("SAPLSKBH")
			.screenNumber(840l)
			.transaction("VA02")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW).build();

	static EditFieldDescription editFi = new EditFieldDescription.Builder()
			.name("LVC_S_SEA-STRING")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();


	static TreeViewDescription treeDoc = new TreeViewDescription.Builder()
			.name("shell[1]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_TREE).build();

	static ButtonDescription clsButton = new ButtonDescription.Builder().name("btn[12]").type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();

	static WindowDescription lineItemWindow= new WindowDescription.Builder()
			.name("wnd[0]")
			.program("SAPMV50A")
			.screenNumber(1000l)
			.transaction("VL03N")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();	

	static TableDescription lineIteble = new TableDescription.Builder()
			.name("SAPMV50ATC_LIPS_OVER")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build();

	static WindowDescription outputDeliveryWindow= new WindowDescription.Builder()
			.name("wnd[0]")
			.program("SAPDV70A")
			.screenNumber(100l)
			.transaction("VL03N")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static TableDescription deliverTabl = new TableDescription.Builder()
			.name("SAPDV70ATC_NAST3")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build();

	static ButtonDescription processButton = new ButtonDescription.Builder().name("btn[26]").type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();

	static WindowDescription deliveryWindow = new WindowDescription.Builder()
			.name("wnd[1]")
			.program("SAPMSSY0")
			.screenNumber(120l)
			.transaction("VL03N")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW).build();

	static LabelDescription process = new LabelDescription.Builder()
			.relativeId("wnd[1]/usr/lbl[6,9]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build();

	static ElementDescription precc = new ElementDescription.Builder()
			.name("usr")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.USER_AREA).build();

	static WindowDescription blueRoom = new WindowDescription.Builder()
			.name("wnd[0]")
			.program("SAPMZV_RETURN_REV")
			.screenNumber(9000l)
			.transaction("ZVBLUEROOM")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static EditFieldDescription delVal = new EditFieldDescription.Builder()
			.name("GF_LIFEX")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();

	static ButtonDescription sercButton = new ButtonDescription.Builder().name("btn[2]").type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();

	static WindowDescription Outbound_Delivery_Win= new WindowDescription.Builder()
			.name("wnd[0]")
			.program("SAPMZV_RETURN_REV")
			.screenNumber(9000l)
			.transaction("ZVBLUEROOM")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static WindowDescription Delivery_Change_Win= new WindowDescription.Builder()
			.name("wnd[0]")
			.program("SAPMV50A")
			.screenNumber(1000l)
			.transaction("VL02N")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static WindowDescription serial_Number_Window =  new WindowDescription.Builder()
			.name("wnd[1]")
			.program("SAPLIPW1")
			.screenNumber(300l)
			.transaction("VL02N")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW).build();

	static TableDescription SERIAL_NUMBERS = new TableDescription.Builder()
			.name("SAPLIPW1TC_SERIAL_NUMBERS")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build();

	static WindowDescription outboundDeliveryWin= new WindowDescription.Builder()
			.name("wnd[0]")
			.program("SAPMV50A")
			.screenNumber(4004l)
			.transaction("VL02N")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static WindowDescription ProgramCorrectionWindow = new WindowDescription.Builder()
			.name("wnd[0]")
			.program("SAPLWBABAP")
			.screenNumber(100l)
			.transaction("SE38")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static EditFieldDescription pgmEdit = new EditFieldDescription.Builder()
			.name("RS38M-PROGRAMM")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();

	static WindowDescription ZR_CS_BLUEROOM_CORRECTIONS = new WindowDescription.Builder()
			.name("wnd[0]")
			.program("ZR_CS_BLUEROOM_CORRECTIONS")
			.screenNumber(1000l)
			.transaction("SE38")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static EditFieldDescription docDate = new EditFieldDescription.Builder()
			.name("S_CPUDT-LOW")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();

	static EditFieldDescription docYear = new EditFieldDescription.Builder()
			.name("P_MJAHR")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();

	static EditFieldDescription docType = new EditFieldDescription.Builder()
			.name("P_BLART")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();

	static WindowDescription TechnicalInformation = new WindowDescription.Builder()
			.name("wnd[0]")
			.program("SAPLSBAL_DISPLAY")
			.screenNumber(100l)
			.transaction("VL01N")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static GridDescription TechnicalInformationdocTable = new GridDescription.Builder().name("shell")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_GRID_VIEW).build();

	static WindowDescription reqDelivDateEditFieldWin = new WindowDescription.Builder()
			.name("wnd[0]")
			.program("SAPMV45A")
			.screenNumber(4001l)
			.transaction("VA03")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static EditFieldDescription reqDelivDateEditField = new EditFieldDescription.Builder()
			.name("RV45A-KETDAT")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();

	static WindowDescription selectionDate_Window = new WindowDescription.Builder()
			.name("wnd[0]")
			.program("SAPMV50A")
			.screenNumber(4001l)
			.transaction("VL01N")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static EditFieldDescription selectionDate = new EditFieldDescription.Builder()
			.name("LV50C-DATBI")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();

	static EditFieldDescription txt_DEProfile=new EditFieldDescription.Builder().name("TCATST-VARIANT").type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static  EditFieldDescription txt_personalNumber=new EditFieldDescription.Builder().name("CATSFIELDS-PERNR").type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription date_keyDate=new EditFieldDescription.Builder().name("CATSFIELDS-INPUTDATE").type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static ButtonDescription btn_execute=new ButtonDescription.Builder().name("btn[6]").type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static EditFieldDescription table_name=new EditFieldDescription.Builder().name("GD-TAB").type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static ButtonDescription btn_testExecute = new ButtonDescription.Builder().name("btn[8]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();

	static WindowDescription SAPSWO_Win = new WindowDescription.Builder()
			.name("wnd[0]")
			.program("SAPLCOIH")
			.screenNumber(101l)
			.transaction("IW33")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static EditFieldDescription SAPSWO_EditFieldDescription = new EditFieldDescription.Builder()
			.name("CAUFVD-AUFNR")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();

	static WindowDescription Component_Window = new WindowDescription.Builder()
			.name("wnd[0]")
			.program("SAPLCOIH")
			.screenNumber(3000l)
			.transaction("IW33")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static TabControlDescription Component_Table = new TabControlDescription.Builder()
			.name("TS_1100")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build();
	static TableDescription Component_Tables= new TableDescription.Builder()
			.name("SAPLCOMKTCTRL_3020")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build();
	static TableDescription partner_Tables= new TableDescription.Builder()
			.name("SAPLIPARTCTRL_0200")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build();
	
	static ButtonDescription statusBTN= new ButtonDescription.Builder()
	.name("btn[44]")
	.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	
	static WindowDescription status_Window = new WindowDescription.Builder()
	.name("wnd[0]")
	.program("SAPMSSY0")
	.screenNumber(120l)
	.transaction("IW33")
	.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();
	
	static LabelDescription ASO_ITEML = new LabelDescription.Builder()
	.relativeId("wnd[0]/usr/lbl[21,0]")
	.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build();
	
	
}
