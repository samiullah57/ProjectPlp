package com.philips.pages;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.hp.lft.sdk.Desktop;
import com.hp.lft.sdk.FunctionKeys;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.HorizontalVisualRelation;
import com.hp.lft.sdk.Keyboard;
import com.hp.lft.sdk.Keyboard.Keys;
import com.hp.lft.sdk.ModifiableSDKConfiguration;
import com.hp.lft.sdk.SDK;
import com.hp.lft.sdk.ScrollOrientation;
import com.hp.lft.sdk.ScrollType;
import com.hp.lft.sdk.Scrollable;
import com.hp.lft.sdk.StringProperty;
import com.hp.lft.sdk.VisualRelation;
import com.hp.lft.sdk.sap.gui.Button;
import com.hp.lft.sdk.sap.gui.ButtonDescription;
import com.hp.lft.sdk.sap.gui.CheckBox;
import com.hp.lft.sdk.sap.gui.CheckBoxDescription;
import com.hp.lft.sdk.sap.gui.ComboBox;
import com.hp.lft.sdk.sap.gui.ComboBoxDescription;
import com.hp.lft.sdk.sap.gui.ComboBoxItem;
import com.hp.lft.sdk.sap.gui.EditField;
import com.hp.lft.sdk.sap.gui.EditFieldDescription;
import com.hp.lft.sdk.sap.gui.Editor;
import com.hp.lft.sdk.sap.gui.EditorDescription;
import com.hp.lft.sdk.sap.gui.Element;
import com.hp.lft.sdk.sap.gui.ElementDescription;
import com.hp.lft.sdk.sap.gui.Grid;
import com.hp.lft.sdk.sap.gui.GridCell;
import com.hp.lft.sdk.sap.gui.GridDescription;
import com.hp.lft.sdk.sap.gui.GuiSession;
import com.hp.lft.sdk.sap.gui.GuiSessionDescription;
import com.hp.lft.sdk.sap.gui.GuiSessionFactory;
import com.hp.lft.sdk.sap.gui.Label;
import com.hp.lft.sdk.sap.gui.LabelDescription;
import com.hp.lft.sdk.sap.gui.LabelDescription.Builder;
import com.hp.lft.sdk.sap.gui.Menubar;
import com.hp.lft.sdk.sap.gui.MenubarDescription;
import com.hp.lft.sdk.sap.gui.Window;
import com.hp.lft.sdk.sap.gui.WindowDescription;
import com.hp.lft.sdk.stdwin.UiObject;
import com.hp.lft.sdk.stdwin.UiObjectDescription;
import com.hp.lft.sdk.sap.gui.OKCode;
import com.hp.lft.sdk.sap.gui.OKCodeDescription;
import com.hp.lft.sdk.sap.gui.RadioButton;
import com.hp.lft.sdk.sap.gui.RadioButtonDescription;
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
import com.philips.cucumber.listener.Reporter;
import com.philips.generic.AutomationConstants;
import com.philips.generic.Excel;
import com.philips.generic.LeanFTConfiguration;
import com.philips.generic.SOQLQuerys;
import com.philips.generic.Utility;
import com.philips.generic.configs.EnvironmentFactory;
import com.sun.mail.handlers.text_html;


public class LeanFTPage extends BasePage {
	public static String orderNumber;
	public String creditOrder;
	public static String purchaseOrder;
	public static String contractNumber;
	public String debitOrder;
	public String createdOrder;
	public String AriaText;
	static String salesNumber;
	public String WBSNumber;
	public String projectNumber;
	public static String ServiceNumber;
	public static String soldTo;
	public static String poHeader;
	public static String IFFvalue;
	public static String CondtionParenTable;
	public static String paymentTrem;
	public static String wbsValue;
	public static String date;
	public static String createdsoldTo;
	public static String documentNumber;
	public String documnet_number;
	public int revenueCost;
	public String customerName;
	public static String idoc;
	public static String invoice_IDOC;
	public static String nootificationNum;
	public static String RecordNumber;
	public static String currentIPLable;
	public static Window generalWindow;
	public int value;

	ArrayList<String> ariachildvalue = new ArrayList<>();

	LeanFTBaseLib lb = new LeanFTBaseLib(driver);
	public static ArrayList<String> createdContracts = new ArrayList<String>();
	ArrayList<Map<String, String>> sap;
	public static GuiSession session;
	static WindowDescription sAPWindow = new WindowDescription.Builder().name("wnd[0]").program("SAPLSMTR_NAVIGATION")
			.screenNumber(100l).transaction("SESSION_MANAGER").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
			.build();


	static OKCodeDescription oKCode = new OKCodeDescription.Builder()
			.type(com.hp.lft.sdk.sap.gui.ComponentType.OK_CODE_FIELD).build();
	static WindowDescription OrderEditWindow = new WindowDescription.Builder().name("wnd[0]").program("SAPMV45A")
			.screenNumber(102l).transaction("VA43").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static WindowDescription SODetailsWindow = new WindowDescription.Builder().name("wnd[0]").program("SAPMV45A")
			.screenNumber(4001l).transaction("VA43").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();
	static TabControlDescription SOTab = new TabControlDescription.Builder().name("TAXI_TABSTRIP_OVERVIEW")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build();
	static TableDescription ItemsOverViewTable = new TableDescription.Builder().name("SAPMV45ATCTRL_U_ERF_KONTRAKT")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build();
	static TabControlDescription MeterialDetailsTab = new TabControlDescription.Builder().name("TAXI_TABSTRIP_ITEM")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build();
	static WindowDescription MeterialDetailsWindowTable = new WindowDescription.Builder().name("wnd[0]")
			.program("SAPMV45A").screenNumber(4003l).transaction("VA43")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();
	static ButtonDescription back_button = new ButtonDescription.Builder().name("btn[3]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static TableDescription priceDetailsTable = new TableDescription.Builder().name("SAPLV69ATCTRL_KONDITIONEN")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build();
	static EditFieldDescription functionModule = new EditFieldDescription.Builder().name("RS38L-NAME")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static ButtonDescription btn_TestData = new ButtonDescription.Builder().name("btn[42]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static ButtonDescription btn_testExecute = new ButtonDescription.Builder().name("btn[8]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static ButtonDescription btn_find = new ButtonDescription.Builder().name("btn[71]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static EditFieldDescription txt_variant = new EditFieldDescription.Builder().name("RSYSF-STRING")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static EditFieldDescription orderType_txt = new EditFieldDescription.Builder().name("VBAK-AUART")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_organisation = new EditFieldDescription.Builder().name("VBAK-VKORG")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_channel = new EditFieldDescription.Builder().name("VBAK-VTWEG")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_division = new EditFieldDescription.Builder().name("VBAK-SPART")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static ButtonDescription btn_continue = new ButtonDescription.Builder().name("btn[0]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static EditFieldDescription txt_billingmethod = new EditFieldDescription.Builder().name("ZZBILLMETHOD")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_process = new EditFieldDescription.Builder().name("ZZVWPOS")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_shippingIndicator = new EditFieldDescription.Builder().name("ZZSHIP_IND")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_soldTo = new EditFieldDescription.Builder().name("KUAGV-KUNNR")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_shipTo = new EditFieldDescription.Builder().name("KUWEV-KUNNR")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static ButtonDescription btn_con = new ButtonDescription.Builder().name("btn[0]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static TableDescription table_order = new TableDescription.Builder().name("SAPMV45ATCTRL_U_ERF_AUFTRAG")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build();
	static EditFieldDescription txt_poNumber = new EditFieldDescription.Builder().name("VBKD-BSTKD")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static ButtonDescription btn_save = new ButtonDescription.Builder().name("btn[11]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static ButtonDescription btn_orderSave = new ButtonDescription.Builder().name("SPOP-VAROPTION1")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static StatusBarDescription status_order = new StatusBarDescription.Builder()
			.type(com.hp.lft.sdk.sap.gui.ComponentType.STATUSBAR).build();
	static OKCodeDescription txt_Tcode = new OKCodeDescription.Builder()
			.type(com.hp.lft.sdk.sap.gui.ComponentType.OK_CODE_FIELD).build();
	static EditFieldDescription txt_order = new EditFieldDescription.Builder().name("VBAK-VBELN")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static TabControlDescription scmData = new TabControlDescription.Builder().name("TAXI_TABSTRIP_ITEM")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build();
	static ButtonDescription btn_ok = new ButtonDescription.Builder().name("btn[0]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static ButtonDescription btn_search = new ButtonDescription.Builder().name("btn[2]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static ButtonDescription btn_exe = new ButtonDescription.Builder().name("btn[8]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static OKCodeDescription tcode = new OKCodeDescription.Builder()
			.type(com.hp.lft.sdk.sap.gui.ComponentType.OK_CODE_FIELD).build();
	static ButtonDescription btn_back = new ButtonDescription.Builder().name("btn[3]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static EditFieldDescription txt_table = new EditFieldDescription.Builder().name("GD-TAB")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static ButtonDescription btn_searchContract = new ButtonDescription.Builder().name("BT_SUCH")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static EditFieldDescription txt_soltTo = new EditFieldDescription.Builder().name("KUAGV-KUNNR")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_POHeader = new EditFieldDescription.Builder().name("VBKD-BSTKD")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static EditFieldDescription txt_Agreement = new EditFieldDescription.Builder().name("RV13A-KNUMA_AG")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription value_IFF = new EditFieldDescription.Builder()
			.id("/app/con[2]/ses[0]/wnd[0]/usr/txtKONA-ZZINDUSTFUDFEE").name("KONA-ZZINDUSTFUDFEE")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static TabControlDescription tab_condtion = new TabControlDescription.Builder().name("TAXI_TABSTRIP_ITEM")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build();
	static ButtonDescription btn_condtionRec = new ButtonDescription.Builder().name("BT_KREC")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static EditFieldDescription txt_salesDeal = new EditFieldDescription.Builder().name("RV13A-BOART_AG")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription salesDeal = new EditFieldDescription.Builder().name("KONA-BOTEXT")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static EditFieldDescription txt_contractType = new EditFieldDescription.Builder().name("KONA-ZZCONTTYP")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_contractAttribute = new EditFieldDescription.Builder().name("KONA-ZZCONTATTR")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_contractBehaviour = new EditFieldDescription.Builder().name("KONA-EXCLINCL")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_IFFvalue = new EditFieldDescription.Builder().name("KONA-ZZINDUSTFUDFEE")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static EditFieldDescription enter_salesDeal = new EditFieldDescription.Builder().name("RV13A-KNUMA_AG")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription edit_IFF = new EditFieldDescription.Builder().name("KONA-ZZINDUSTFUDFEE")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static EditFieldDescription enter_salesOrg = new EditFieldDescription.Builder().name("KONA-VKORG")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription enter_channel = new EditFieldDescription.Builder().name("KONA-VTWEG")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription enter_division = new EditFieldDescription.Builder().name("KONA-SPART")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription paymentterm_txt = new EditFieldDescription.Builder().name("VBKD-ZTERM")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static TabControlDescription scheduletab = new TabControlDescription.Builder().name("TAXI_TABSTRIP_ITEM")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build();
	static ButtonDescription btn_displaydoc = new ButtonDescription.Builder().name("btn[5]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static ButtonDescription btn_printPreview = new ButtonDescription.Builder().name("btn[37]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static EditorDescription txt_area = new EditorDescription.Builder().name("shell")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_TEXT_AREA).build();
	static EditFieldDescription txt_salesDescription = new EditFieldDescription.Builder().name("KONA-BOTEXT")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static EditFieldDescription txt_program = new EditFieldDescription.Builder().name("RS38M-PROGRAMM")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_Documenttype = new EditFieldDescription.Builder().name("S_DOCTYP-LOW")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_billingType = new EditFieldDescription.Builder().name("S_FKART-LOW")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_sleasOrganisation = new EditFieldDescription.Builder().name("S_VKORG-LOW")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_salesChannel = new EditFieldDescription.Builder().name("S_VTWEG-LOW")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_createdDate = new EditFieldDescription.Builder().name("S_DATE-LOW")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_toDate = new EditFieldDescription.Builder().name("S_DATE-HIGH")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static ButtonDescription sales_execute = new ButtonDescription.Builder().name("btn[8]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static EditFieldDescription salesDealDate = new EditFieldDescription.Builder().name("KONA-DATAB")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription salesdateTo = new EditFieldDescription.Builder().name("KONA-DATBI")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static ButtonDescription btn_conditions = new ButtonDescription.Builder().name("btn[9]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static EditFieldDescription txt_contract = new EditFieldDescription.Builder().name("LV45C-VBELN")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_PODate = new EditFieldDescription.Builder().name("VBKD-BSTDK")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static ButtonDescription bnt_close = new ButtonDescription.Builder().name("btn[12]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static ButtonDescription btn_next = new ButtonDescription.Builder().name("btn[19]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static EditFieldDescription txt_wbs = new EditFieldDescription.Builder().name("COBL-PS_POSID")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription enter_WBS = new EditFieldDescription.Builder().name("*PRPS-POSID")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static ButtonDescription btn_cont = new ButtonDescription.Builder().name("OPTION2")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static EditFieldDescription txt_Description = new EditFieldDescription.Builder().name("VBAK-KTEXT")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static EditFieldDescription contractstartDate = new EditFieldDescription.Builder().name("VEDA-VBEGDAT")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription contractEndDate = new EditFieldDescription.Builder().name("VEDA-VENDDAT")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static ButtonDescription btn_displayDoc = new ButtonDescription.Builder().name("BT_HEAD")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static EditFieldDescription txt_pricingProcedure = new EditFieldDescription.Builder().name("VBAK-KALSM")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static ButtonDescription btn_objectStatus = new ButtonDescription.Builder().name("BT_KSTC")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static EditFieldDescription txt_acceptanceDate = new EditFieldDescription.Builder().name("VEDA-VABNDAT")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static ButtonDescription back_btn = new ButtonDescription.Builder().name("btn[18]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static EditFieldDescription txt_RAK = new EditFieldDescription.Builder().name("PRPS-ABGSL")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_salesDocument = new EditFieldDescription.Builder().name("VBELN-LOW")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static CheckBoxDescription chk_create = new CheckBoxDescription.Builder().name("")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.CHECK_BOX).build();
	static ButtonDescription btn_flag = new ButtonDescription.Builder().name("btn[34]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static EditFieldDescription txt_projectWBS = new EditFieldDescription.Builder().name("CNPB_W_ADD_OBJ_DYN-PROJ_EXT")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static ButtonDescription btn_yes = new ButtonDescription.Builder().name("SPOP-OPTION1")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static EditFieldDescription txt_projDescription = new EditFieldDescription.Builder().name("*PROJ-PSPID")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_material = new EditFieldDescription.Builder().name("RMMG1-MATNR")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_processType = new EditFieldDescription.Builder().enabled(true)
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static LabelDescription soldTovalue = new LabelDescription.Builder().relativeId("wnd[2]/usr/lbl[6,6]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build();
	static ButtonDescription btn_displayDocument = new ButtonDescription.Builder().name("btn[17]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static EditFieldDescription telephone = new EditFieldDescription.Builder().name("VBAK-TELF1")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static EditFieldDescription txt_route = new EditFieldDescription.Builder().name("VBAP-ROUTE")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_package = new EditFieldDescription.Builder().name("P_PKSZ")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static EditFieldDescription cell_content = new EditFieldDescription.Builder().name("LVC_S_SEA-STRING")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static EditFieldDescription periodic_yr = new EditFieldDescription.Builder().name("FPLA-PERIO")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static ButtonDescription btn_newRow = new ButtonDescription.Builder().name("BT_KOAN")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static ButtonDescription btn_detail = new ButtonDescription.Builder().name("DETAIL")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static LabelDescription txt_email = new LabelDescription.Builder()
			.relativeId(
					"wnd[1]/usr/subGCS_ADDRESS:SAPLSZA1:0300/subCOUNTRY_SCREEN:SAPLSZA1:0301/lblSZA1_D0100-SMTP_ADDR")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build();
	static ButtonDescription btn_itemselection = new ButtonDescription.Builder().name("btn[7]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static ButtonDescription btn_desectAll = new ButtonDescription.Builder().name("MKLO")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static EditFieldDescription txt_targetValue = new EditFieldDescription.Builder().name("VBAP-ZMENG")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static EditFieldDescription txt_salesorg = new EditFieldDescription.Builder().name("SO_VKORG-LOW")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_documentType = new EditFieldDescription.Builder().name("SO_AUART-LOW")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static EditFieldDescription txt_programDate = new EditFieldDescription.Builder().name("SO_ERDAT-LOW")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_salesDocumnet = new EditFieldDescription.Builder().name("LKP74-VBELN")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_projectNum = new EditFieldDescription.Builder().name("LKP74-PSPID")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_wbsNum = new EditFieldDescription.Builder().name("LKP74-POSID")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_period = new EditFieldDescription.Builder().name("RKAUF-FROM")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static EditFieldDescription txt_fiscalyr = new EditFieldDescription.Builder().name("RKAUF-GJAHR")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static CheckBoxDescription chk_testRun = new CheckBoxDescription.Builder().name("RKAUF-TEST")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.CHECK_BOX).build();
	static CheckBoxDescription chk_detail = new CheckBoxDescription.Builder().name("RKAUF-LIST")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.CHECK_BOX).build();
	static ButtonDescription btn_settlementRule = new ButtonDescription.Builder().name("BUTTON_ABRV")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static EditFieldDescription txt_network = new EditFieldDescription.Builder().name("CN_NETNR-LOW")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription pscon_contract = new EditFieldDescription.Builder().name("P_CSCON")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription pscon_item = new EditFieldDescription.Builder().name("P_ITEM")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription pscon_shipTo = new EditFieldDescription.Builder().name("S_KUNNR-LOW")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static ButtonDescription unassign = new ButtonDescription.Builder().name("btn[38]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static EditFieldDescription txt_companyCode = new EditFieldDescription.Builder().name("SBUKRS-LOW")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_saleddocType = new EditFieldDescription.Builder().name("SAUART-LOW")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static EditFieldDescription txt_salesDocNumber = new EditFieldDescription.Builder().name("SVBELN-LOW")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_postingMonth = new EditFieldDescription.Builder().name("PPOPER_L")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static EditFieldDescription txt_postingYear = new EditFieldDescription.Builder().name("PGJAHR_L")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static CheckBoxDescription details_chk = new CheckBoxDescription.Builder().name("LKO74-LIST")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.CHECK_BOX).build();
	static CheckBoxDescription test_chk = new CheckBoxDescription.Builder().name("LKO74-TESTLAUF")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.CHECK_BOX).build();
	static EditFieldDescription txt_customer = new EditFieldDescription.Builder().name("RF02D-KUNNR")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_billing = new EditFieldDescription.Builder().name("VBRK-VBELN")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_outputDevice = new EditFieldDescription.Builder().name("PRI_PARAMS-PDEST")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static ButtonDescription background = new ButtonDescription.Builder().name("btn[13]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static ButtonDescription btn_immediate = new ButtonDescription.Builder().name("SOFORT_PUSH")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static EditFieldDescription txt_Programname = new EditFieldDescription.Builder().name("BTCH2170-ABAPNAME")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static ButtonDescription spool = new ButtonDescription.Builder().name("btn[44]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static EditFieldDescription contract = new EditFieldDescription.Builder().name("S_VBELN-LOW")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static EditFieldDescription org = new EditFieldDescription.Builder().name("S_VKORG-LOW")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static ButtonDescription messages = new ButtonDescription.Builder().name("btn[21]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static ButtonDescription btn_processing = new ButtonDescription.Builder().name("btn[26]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static EditFieldDescription idoc_txt = new EditFieldDescription.Builder().name("DOCNUM-LOW")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static ButtonDescription btn_selectAll = new ButtonDescription.Builder().name("BT_MKAL")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static ButtonDescription btn_deselect = new ButtonDescription.Builder().name("BT_POLO")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static EditFieldDescription txt_value = new EditFieldDescription.Builder().name("VALUE1_1")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static EditFieldDescription txt_purchase = new EditFieldDescription.Builder().name("RV45S-BSTNK")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static EditFieldDescription txt_fingerPrint = new EditFieldDescription.Builder().name("VBAP-ZZFINGER")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static EditFieldDescription txt_addDate = new EditFieldDescription.Builder().name("VBAP-ZZ_ADD_ON_SITE")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static ButtonDescription btn_output = new ButtonDescription.Builder().name("TC_OUTPUT")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static EditFieldDescription txt_equipment = new EditFieldDescription.Builder().name("G_EQUI-AFF-EQUNR")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_damageCD = new EditFieldDescription.Builder().name("G_VIQMFE-FEGRP")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_cd = new EditFieldDescription.Builder().name("G_VIQMFE-FECOD")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_callType = new EditFieldDescription.Builder().name("G_VIQMEL-QMCOD")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_notification = new EditFieldDescription.Builder().name("G_VIQMEL-QMTXT")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static ButtonDescription btn_serve = new ButtonDescription.Builder().name("*VIQMEL-AUFNR")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static ButtonDescription btn_release = new ButtonDescription.Builder().name("btn[25]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static ButtonDescription btn_complete = new ButtonDescription.Builder().name("btn[36]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static EditFieldDescription txt_actualWork = new EditFieldDescription.Builder().name("AFRUD-ISMNW_2")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static EditFieldDescription txt_activityType = new EditFieldDescription.Builder().name("AFRUD-LEARR")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static ButtonDescription btn_replica = new ButtonDescription.Builder().name("PUSH1")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static ButtonDescription steUserStatus = new ButtonDescription.Builder().name("%#AUTOTEXT001")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static EditFieldDescription txt_zucodivision = new EditFieldDescription.Builder().name("SO_BUKRS-LOW")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription zuco_order = new EditFieldDescription.Builder().name("SO_AUFNR-LOW")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static EditFieldDescription txt_document = new EditFieldDescription.Builder().name("RF05L-BELNR")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static EditFieldDescription txt_project = new EditFieldDescription.Builder().name("CN_PROJN-LOW")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_wbsElement = new EditFieldDescription.Builder().name("KKA0100-POSID")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription wbs_piscal = new EditFieldDescription.Builder().name("KKA0100-BIS_ABGR_M")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static EditFieldDescription wbs_year = new EditFieldDescription.Builder().name("KKA0100-BIS_ABGR_J")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static EditFieldDescription ra_version = new EditFieldDescription.Builder().name("KKA0100-VERSN")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static ButtonDescription button_yes = new ButtonDescription.Builder().name("BUTTON_YES")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static EditFieldDescription functionModulefield = new EditFieldDescription.Builder().name("RS38L-NAME")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static ButtonDescription executebtn = new ButtonDescription.Builder().name("btn[8]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static ButtonDescription okBtn = new ButtonDescription.Builder().name("btn[16]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static ButtonDescription testdatadirectorybtn = new ButtonDescription.Builder().name("btn[42]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static LabelDescription entries = new LabelDescription.Builder().relativeId("wnd[0]/usr/lbl[34,14]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build();

	// R2R
	static EditFieldDescription txt_DEProfile = new EditFieldDescription.Builder().name("TCATST-VARIANT")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_personalNumber = new EditFieldDescription.Builder().name("CATSFIELDS-PERNR")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription date_keyDate = new EditFieldDescription.Builder().name("CATSFIELDS-INPUTDATE")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static ButtonDescription btn_execute = new ButtonDescription.Builder().name("btn[6]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static EditFieldDescription table_name = new EditFieldDescription.Builder().name("GD-TAB")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static ButtonDescription btn_spool = new ButtonDescription.Builder().name("btn[34]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();

	static RadioButtonDescription executManual = new RadioButtonDescription.Builder().name("P_MAN")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.RADIO_BUTTON).build();

	static EditFieldDescription serianNumber = new EditFieldDescription.Builder().name("ITOB-SERNR")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();

	static EditFieldDescription materialNo = new EditFieldDescription.Builder().name("ITOB-MATNR")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();

	static EditFieldDescription serianLumber = new EditFieldDescription.Builder().name("ITOB-SERNR")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();

	static EditFieldDescription recCreadtedDate = new EditFieldDescription.Builder().name("S_ERDAT-LOW")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();

	static EditFieldDescription equpmentNumber = new EditFieldDescription.Builder().name("S_EQUNR-LOW")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();

	static EditFieldDescription plant = new EditFieldDescription.Builder().name("S_WERKS-LOW")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();

	static ButtonDescription fun_loc_Cipl = new ButtonDescription.Builder().name("FCODE_CIPL")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();

	static ButtonDescription dismantle = new ButtonDescription.Builder().name("btn[14]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();

	static EditFieldDescription superEquip = new EditFieldDescription.Builder().name("IEQINSTALL-HEQNR")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();

	static EditFieldDescription refequipment = new EditFieldDescription.Builder().name("RM63E-REFEQ")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription equipmentCategory = new EditFieldDescription.Builder().name("RM63E-EQTYP")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_IPNum = new EditFieldDescription.Builder().name("RM63E-EQUNR")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription txt_functional = new EditFieldDescription.Builder().name("PA_TPLR1")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription workCenter = new EditFieldDescription.Builder().name("PA_ARBPL")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();

	static EditFieldDescription txt_SWOorder=new EditFieldDescription.Builder().name("CAUFVD-AUFNR").type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static ButtonDescription btn_enhance=new ButtonDescription.Builder().name("BTN_VGD5").type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	static EditFieldDescription txt_idebtification=new EditFieldDescription.Builder().name("VEKP-EXIDV2").type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static EditFieldDescription txt_documentValue=new EditFieldDescription.Builder().name("LIKP-VBELN").type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription salesOrderIEditField = new EditFieldDescription.Builder().name("AFVGD-USR01")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	static EditFieldDescription contactsearch = new EditFieldDescription.Builder().name("RF02D-PARNR")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();

	String AOOrderNumber = "AO-00000768";
	static ArrayList<HashMap<String, String>> apttusPriceDetails = new ArrayList<HashMap<String, String>>();
	static HashMap<String, String> equipmentdetails = new HashMap<String, String>();
	static String SAPHeader = null;
	static String transcationCode;
	public String ASO_DELIVERY_NO;

	public LeanFTPage(WebDriver driver) {
		super(driver);
	}

	public void enter_sapSWO() throws Exception {
		waitTill("6");
		leanFtSendKeys(txt_SWOorder, sapSalesnum);
		//leanFtEnter();
		CNWindow().sendKey(SapFunctionKey.ENTER);
		waitTill("6");
	}
	// Getting Change Number screen and window
	public static Window CNWindow(String window) throws GeneralLeanFtException {
		Window cnwindow = null;
		switch (window) {
		case "ASO-Item":
			try {
				cnwindow = session.describe(Window.class, ASOSearchWindow);
				cnwindow.highlight();
			}catch(Exception e) {
				cnwindow = session.describe(Window.class, ASOSearchWindow1);
				cnwindow.highlight();
			}
			break;
		case "ASO-Delivery":
			cnwindow = session.describe(Window.class, ASODeliveryWindow);
			cnwindow.highlight();
			break;
		case "ASO-Sales-Order":
			cnwindow = session.describe(Window.class, ASOSalesOrderWindow);
			cnwindow.highlight();
			break;
		default:
			cnwindow = session.describe(Window.class, ASODeliveryWindow);
			cnwindow.highlight();

			break;

		}
		return cnwindow;
	}
	public static Window getWindow(String windowname) throws GeneralLeanFtException {
		Window window = null;
		;
		switch (windowname) {
		case "TranscationWindow":
			WindowDescription transactionWindow = new WindowDescription.Builder().name("wnd[0]").program("SAPMV45A")
			.screenNumber(102l).transaction(transcationCode)
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();
			window = session.describe(Window.class, transactionWindow);
			// window.highlight();
			break;
		case "ContractOverView":
			WindowDescription contractOverView_VA43 = new WindowDescription.Builder().name("wnd[0]").program("SAPMV45A")
			.screenNumber(4001l).transaction(transcationCode)
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();
			window = session.describe(Window.class, contractOverView_VA43);
			break;
		case "ContractHeaderData":
			WindowDescription contractHeaderData_VA43 = new WindowDescription.Builder().name("wnd[0]")
			.program("SAPMV45A").screenNumber(4002l).transaction(LeanFTBaseLib.transcationCode)
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();
			window = session.describe(Window.class, contractHeaderData_VA43);
		case "ScheduleTab":
			WindowDescription ScheduleTab = new WindowDescription.Builder().name("wnd[0]").program("SAPMV45A")
			.screenNumber(4003l).transaction("VA03").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
			.build();
			window = session.describe(Window.class, ScheduleTab);
		case "conditionTab":
			WindowDescription conditionTab = new WindowDescription.Builder()
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();
			window = session.describe(Window.class, conditionTab);
			break;

		case "itemDataWindow":
			WindowDescription itemDataWindow = new WindowDescription.Builder().name("wnd[0]").program("SAPMV45A")
			.screenNumber(4001l).transaction("VA03").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
			.build();
			window = session.describe(Window.class, itemDataWindow);
			break;
		case "MaterialDetails":
			WindowDescription meterialDetails = new WindowDescription.Builder().name("wnd[0]").program("SAPMV45A")
			.screenNumber(4003l).transaction(transcationCode)
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();
			window = session.describe(Window.class, meterialDetails);

			break;

		case "PriceTable":
			WindowDescription PriceTable = new WindowDescription.Builder().name("wnd[0]").program("SAPMV45A")
			.screenNumber(5003l).transaction(transcationCode)
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();
			window = session.describe(Window.class, PriceTable);
		default:
			break;
		case "Menubar":
			window = session.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build());
			break;
		}
		return window;
	}

	public static void leanftInvoke() throws Exception {
		// leanftruntimeengineStart();
		ModifiableSDKConfiguration config = new ModifiableSDKConfiguration();
		config.setAutoLaunch(false);
		SDK.init(config);
	}

	// Launching and login to SAP Application
	public static void sapLaunch() throws GeneralLeanFtException, InterruptedException {
		String SAPuserName = EnvironmentFactory.getConfigValue("SAPUserName");
		String SAPpassword = Utility.decode(EnvironmentFactory.getConfigValue("SAPPassword"));
		session = GuiSessionFactory.launch(AutomationConstants.sandbox, "990", SAPuserName, SAPpassword);
		Thread.sleep(10000);
		Window sapWindow = session.describe(Window.class, sAPWindow);
		sapWindow.maximize();
		sapWindow.highlight();
		if (sapWindow.exists()) {
			logReport("PASS", "SAP application was launched and logged in succesfully");

		} else {
			logReport("FAIL", "FAILED to Launch SAP application");
		}
	}

	public void launchSAP() throws Exception {
		leanftInvoke();
		System.out.println("SAP login");
		sapLaunch();
	}

	public void launchSAP(String system, String client) throws Exception {
		waitTill("6");
		leanftInvoke();
		String SAPuserName = EnvironmentFactory.getConfigValue("SAPUserName");
		String SAPpassword = Utility.decode(EnvironmentFactory.getConfigValue("SAPPassword"));
		session = GuiSessionFactory.launch(system, client, SAPuserName, SAPpassword);
		Thread.sleep(5000);
		Window sapWindow = session.describe(Window.class, sAPWindow);
		sapWindow.maximize();
		sapWindow.highlight();
		if (sapWindow.exists()) {
			logReport("PASS", "SAP application was launched and logged in succesfully");

		} else {
			logReport("FAIL", "FAILED to Launch SAP application");
		}
	}

	public void enter_Tcode(String code) throws Exception {
		try {
			OKCode TACode = Window().describe(OKCode.class, oKCode);
			// TACode.highlight();
			TACode.setValue(code);
			Thread.sleep(5000);
			Window().sendKey(SapFunctionKey.ENTER);
			logReport("PASS", code + "entered Successfully");
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Closing SAP Application
	public static void closeSAP() {
		try {
			Runtime run = Runtime.getRuntime();
			run.exec("taskkill /F /IM saplogon.exe /T");
			logReport("PASS", "SAP Application is closed successfully");
		} catch (Exception e) {
			System.err.println("Caught Exception: " + e.getMessage());
			logReport("PASS", "SAP Application is not closed");
		}
	}

	// Declaring SAP Main window
	public static Window Window() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, sAPWindow);
		return window;

	}

	public void keyboardclick() throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_F4);
		waitTill("6");
		robot.keyRelease(KeyEvent.VK_F4);

	}

	public void keydown(int size) throws Exception {
		Robot robot = new Robot();
		try {
			for (int i = 1; i <= size; i++) {
				robot.keyPress(KeyEvent.VK_DOWN);
				waitTill("6");
				robot.keyRelease(KeyEvent.VK_DOWN);
				waitTill("6");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public Object keyAction(int keyEvent) throws Exception {
		Robot robot = new Robot();
		robot.keyPress(keyEvent);
		waitTill("6");
		robot.keyRelease(keyEvent);
		return keyEvent;
	}

	public void accessSOTab(String tabName) throws GeneralLeanFtException {
		TabControl soTabs = getWindow("itemDataWindow").describe(TabControl.class, SOTab);

		try {
			soTabs.select(tabName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void accessMeterialTab(String tabName) throws GeneralLeanFtException {
		TabControl soTabs = getWindow("MaterialDetails").describe(TabControl.class, MeterialDetailsTab);
		System.out.println(tabName);
		try {
			soTabs.select(tabName);
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickMaterialDetailsBack() throws GeneralLeanFtException, InterruptedException {
		Thread.sleep(4000);
		WindowDescription backbuttonWindow = new WindowDescription.Builder().name("wnd[0]").program("SAPMV45A")
				.screenNumber(5003l).transaction("VA03").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

		ButtonDescription BackButton = new ButtonDescription.Builder().name("btn[3]")
				.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();

		leanFtButtonClick(BackButton, "Back");
	}

	public void leanFtButtonClick(ButtonDescription button, String name) throws GeneralLeanFtException {

		// button.highlight();
		waitTill("10");
		Button BackButtonEle = session.describe(Button.class, button);
		BackButtonEle.highlight();
		BaseLib.embedScreenShotInreportWithRobot();
		BackButtonEle.click();
		Reporter.addStepLog("Click " + name);
		waitTill("6");
	}
	public void clickExecute(ButtonDescription button, String name) throws GeneralLeanFtException {
		try {
			waitTill("10");
			Button BackButtonEle = session.describe(Button.class, button);
			BackButtonEle.highlight();
			BackButtonEle.click();
			logReport("PASS","Execute Clicked");
			waitTill("30");
			Reporter.addStepLog("Click " + name);
			waitTill("10");
		}catch(Exception e) {
			waitTill("30");
			LeanFTDialog.acceptAllow();
		}
	}

	public Button buttonCLick(String value) throws Exception{
		Button name=session.describe(Window.class,new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW)
				.build()).describe(Button.class, new ButtonDescription.Builder().name(value)
						.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build());
		return name;
	}

	public void leanFtRadioButtonClick(String buttonname, String name)
			throws GeneralLeanFtException, InterruptedException {

		RadioButton rButton = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(RadioButton.class, new RadioButtonDescription.Builder().name(buttonname)
						.type(com.hp.lft.sdk.sap.gui.ComponentType.RADIO_BUTTON).build());

		rButton.set();
		Reporter.addStepLog("Click " + name);
	}

	public Table leanft_tableselect(String name) throws Exception {
		Table table = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Table.class, new TableDescription.Builder().name(name)
						.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
		Reporter.addStepLog("Table is selected " + name);
		return table;
	}

	public void leanFtRadioButtonClick(RadioButton button, String name) throws GeneralLeanFtException {

		// button.highlight();
		button.set();
		Reporter.addStepLog("Click " + name);
	}

	public void leanFtSendKeys(EditFieldDescription element, String name) throws GeneralLeanFtException {

		// button.highlight();
		waitTill("6");
		EditField functionModule_txt = session.describe(EditField.class, element);
		functionModule_txt.setText(name);
		BaseLib.embedScreenShotInreportWithRobot();
		Reporter.addStepLog("Name  Entered is  " + name);
		logReport("leanFtSendKeys", name);
	}

	public void leanFtEnter() throws Exception {
		waitTill("6");
		Keyboard.pressKey(Keyboard.Keys.ENTER);
		waitTill("6");
	}

	public void enterFM(String value) throws Exception {
		Thread.sleep(6000);
		leanFtSendKeys(functionModule, value);
		leanFtButtonClick(btn_testExecute, "Click");
	}

	public void selectTestData() throws Exception {
		leanFtButtonClick(btn_TestData, "Back");
	}

	public void searchVariant(String value) throws Exception {
		leanFtButtonClick(btn_find, "Click");
		leanFtSendKeys(txt_variant, value);
		leanFtButtonClick(btn_ok, "Okay");
		Label variant_value = session
				.describe(Window.class,
						new WindowDescription.Builder().name("wnd[2]").program("SAPMSSY0").screenNumber(120l)
						.transaction("SE37").type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[2]/usr/lbl[54,2]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		variant_value.setFocus();
		leanFtButtonClick(btn_ok, "Continue");
		Label label_variant = session
				.describe(Window.class,
						new WindowDescription.Builder().name("wnd[0]").program("SAPMSSY0").screenNumber(120l)
						.transaction("SE37").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[0]/usr/lbl[54,3]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		label_variant.setFocus();
		leanFtButtonClick(btn_search, "Search");

	}

	public void enterOrderdetails(String type, String org, String division, String channel) throws Exception {
		leanFtSendKeys(orderType_txt, type);
		leanFtSendKeys(txt_organisation, org);
		leanFtSendKeys(txt_channel, channel);
		leanFtSendKeys(txt_division, division);
		waitTill("6");
		leanFtEnter();
	}

	public void enterOrganisationalData(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		leanFtSendKeys(enter_salesOrg, sap.get(0).get("SalesOrg"));
		leanFtSendKeys(enter_channel, sap.get(0).get("DistributeChannel"));
		leanFtSendKeys(enter_division, sap.get(0).get("Division"));
		waitTill("6");
		leanFtEnter();
	}

	public void enterBillingvalues(String billing, String shipping) throws Exception {
		waitTill("6");
		leanFtSendKeys(txt_process, "600");
		leanFtSendKeys(txt_billingmethod, billing);
		leanFtSendKeys(txt_shippingIndicator, shipping);
		leanFtButtonClick(btn_continue, "continue");

	}

	public TreeView treeView(int i) throws Exception {
		TreeView tableTreeControlTreeView = session.describe(TreeView.class, new TreeViewDescription.Builder().index(0)
				.name("shell").type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_TREE).build());
		String path = tableTreeControlTreeView.buildNodePath(i);
		tableTreeControlTreeView.activateNode(path);
		return tableTreeControlTreeView;

	}

	public TreeView selectTree() throws Exception {

		TreeView docs = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(TreeView.class, new TreeViewDescription.Builder().name("shell[1]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_TREE).build());
		docs.highlight();
		return docs;
	}

	public Editor textArea() throws Exception {
		Editor textAreaControlEditor = session.describe(Editor.class, new EditorDescription.Builder().name("shell")
				.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_TEXT_AREA).build());
		return textAreaControlEditor;
	}

	public Menubar MenuBar(String value) throws Exception {
		Window menuWindow = session.describe(Window.class,
				new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build());
		Menubar mbarMenubar = menuWindow.describe(Menubar.class,
				new MenubarDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MENUBAR).build());
		mbarMenubar.select(value);
		logReport("INFO", "The Menubar value is selected");
		return mbarMenubar;
	}
	public static Window reqDelivDateEditFieldWindow() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, reqDelivDateEditFieldWin);
		return window;

	}
	public void enterProcessBilling(String billing) throws Exception {
		waitTill("6");
		leanFtSendKeys(txt_process, "600");
		leanFtSendKeys(txt_billingmethod, billing);
		leanFtButtonClick(btn_continue, "continue");
	}

	public void enterShipToSoldTo(String sold, String ship) throws Exception {
		leanFtSendKeys(txt_soldTo, sold);
		leanFtSendKeys(txt_shipTo, ship);
		leanFtSendKeys(txt_poNumber, Utility.getFormatedDateTime());
		leanFtEnter();
		waitTill("6");
		leanFtButtonClick(btn_con, "Continue");
	}

	public void enterMaterialNumber(String value) throws Exception {
		waitTill("6");
		Table orderTable = session
				.describe(Window.class,
						new WindowDescription.Builder().name("wnd[0]").program("SAPMV45A").screenNumber(4001l)
						.transaction("VA01").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Table.class, new TableDescription.Builder().name("SAPMV45ATCTRL_U_ERF_AUFTRAG")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
		orderTable.getRows().get(0).getCell("Material").setValue(value);
		orderTable.getRows().get(0).getCell("Order Quantity").setValue("2");
	}

	public void enterValuePrice() throws Exception {
		waitTill("6");
		EditField valPriceEditField = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(EditField.class, new EditFieldDescription.Builder().name("EBAN-PREIS")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build());
		if (valPriceEditField.exists()) {
			valPriceEditField.setText("9");
			logReport("INFO", "The value price is added");
		}
	}

	public void enterMaterials(String sheetName) throws Exception {
		Table orderTable = session
				.describe(Window.class,
						new WindowDescription.Builder().name("wnd[0]").program("SAPMV45A").screenNumber(4001l)
						.transaction("VA01").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Table.class, new TableDescription.Builder().name("SAPMV45ATCTRL_U_ERF_AUFTRAG")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
		for (int i = 0; i < orderTable.getRows().size(); i++) {
			// orderTable.getRows().get(i).getCell("Material").setValue(value);
			// orderTable.getRows().get(0).getCell("Order
			// Quantity").setValue("2");
		}
	}

	public void saveSalesOrder() throws Exception {
		leanFtButtonClick(btn_save, "Save");
		waitTill("6");
		Button continueEnterButton = session.describe(Button.class, new ButtonDescription.Builder().name("btn[0]")
				.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build());
		try {
			leanFtButtonClick(btn_con, "Continue");
			leanFtButtonClick(btn_con, "Continue");
			leanFtButtonClick(btn_con, "Continue");
		} catch (Exception e) {
			// leanFtButtonClick(btn_con, "Continue");

			// leanFtButtonClick(btn_ok, "Save");
		}
		waitTill("6");
		leanFtButtonClick(btn_orderSave, "Save");
		waitTill("6");
		StatusBar statusBar = session
				.describe(Window.class,
						new WindowDescription.Builder().name("wnd[0]").program("SAPMV45A").screenNumber(4001l)
						.transaction("VA01").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(StatusBar.class, new StatusBarDescription.Builder()
						.type(com.hp.lft.sdk.sap.gui.ComponentType.STATUSBAR).build());
		String txt_status = statusBar.getText();
		logReport("INFO", "The created order nmuber is" + txt_status);
		orderNumber = txt_status.replaceAll("[^0-9]", "");
		System.out.println(orderNumber);
		waitTill("6");
	}

	public String getStatusBarValue() throws Exception {
		StatusBar statusBar = session.describe(StatusBar.class,
				new StatusBarDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.STATUSBAR).build());
		statusBar.waitUntilExists();
		statusBar.highlight();
		String status = statusBar.getText().trim();
		logReport("INFO", "The status is updated as " + status);
		waitTill("6");
		return status;

	}

	public void renterTcode(String code) throws Exception {
		OKCode txt_Tcode = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(OKCode.class, new OKCodeDescription.Builder()
						.type(com.hp.lft.sdk.sap.gui.ComponentType.OK_CODE_FIELD).build());
		txt_Tcode.highlight();
		txt_Tcode.setValue(code);
		Thread.sleep(4000);
		leanFtEnter();
		logReport("PASS", code + "entered Successfully");
		Thread.sleep(4000);
	}

	public void EnterOrder() throws Exception {
		leanFtSendKeys(txt_order, orderNumber);
		leanFtEnter();
	}

	public void select_Material() throws Exception {
		waitTill("6");
		Table materail_table = session
				.describe(Window.class,
						new WindowDescription.Builder().name("wnd[0]").program("SAPMV45A").screenNumber(4001l)
						.transaction("VA03").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Table.class, new TableDescription.Builder().name("SAPMV45ATCTRL_U_ERF_AUFTRAG")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
		Table allItemsTable = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Table.class, new TableDescription.Builder().name("SAPMV45ATCTRL_U_ERF_KONTRAKT")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
		if (materail_table.exists()) {
			String materialValue = materail_table.getRows().get(0).getCell("Material").getValue();
			logReport("INFO", "The added Material is" + materialValue);
			materail_table.highlight();
			materail_table.activateCell(1, "Material");

		} else {
			allItemsTable.highlight();
			String materialValue = allItemsTable.getRows().get(0).getCell("Material").getValue();
			logReport("INFO", "The added Material is" + materialValue);
			allItemsTable.activateCell(1, "Material");
		}
	}

	public void verifyCondtions() throws Exception {
		String[] conditionValues = { "ZA01", "YADJ", "Y04A", "Y72A" };

		waitTill("6");
		TabControl scm_table = session
				.describe(Window.class,
						new WindowDescription.Builder().name("wnd[0]").program("SAPMV45A").screenNumber(4003l)
						.transaction("VA03").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(TabControl.class, new TabControlDescription.Builder().name("TAXI_TABSTRIP_ITEM")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build());
		TabControl tAXITABSTRIPITEMTabControl = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(TabControl.class, new TabControlDescription.Builder().name("TAXI_TABSTRIP_ITEM")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build());
		if (scm_table.exists()) {
			scm_table.highlight();
			scm_table.select("Conditions");
		} else {
			tAXITABSTRIPITEMTabControl.highlight();
			tAXITABSTRIPITEMTabControl.select("Conditions");
		}
		waitTill("6");
		Table pricingElementsTable = session
				.describe(Window.class,
						new WindowDescription.Builder().name("wnd[0]").program("SAPMV45A").screenNumber(5003l)
						.transaction("VA03").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Table.class, new TableDescription.Builder().name("SAPLV69ATCTRL_KONDITIONEN")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
		Table pricingElementsTable1 = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Table.class, new TableDescription.Builder().name("SAPLV69ATCTRL_KONDITIONEN")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
		if (pricingElementsTable.exists()) {
			pricingElementsTable.highlight();
			for (int i = 0; i < pricingElementsTable.getRows().size(); i++) {

				pricingElementsTable.getRows().get(i).getCell("CnTy").getValue().contains(conditionValues[i]);
				break;
			}
		} else {
			pricingElementsTable1.highlight();
			for (int i = 0; i < pricingElementsTable1.getRows().size(); i++) {

				pricingElementsTable1.getRows().get(i).getCell("CnTy").getValue().contains(conditionValues[i]);
				break;
			}
		}
		logReport("PASS", "Condtion table values are avaialble");
	}

	public void verifySalesDeals() throws Exception {
		Label entryLabel = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[0]/usr/lbl[37,16]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		entryLabel.setFocus();
		leanFtButtonClick(btn_search, "Search");
		Label label_vkor = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[0]/usr/lbl[16,6]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		label_vkor.highlight();
		System.out.println("The Sales deals value" + label_vkor.getText());
		leanFtButtonClick(btn_back, "Back");
		leanFtButtonClick(btn_back, "Back");
		leanFtButtonClick(btn_back, "Back");

	}

	public void verifyMaterial() throws Exception {
		waitTill("6");
		Label entryLabel = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[0]/usr/lbl[37,16]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		entryLabel.setFocus();
		leanFtButtonClick(btn_search, "Search");
		Label txt_material = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[0]/usr/lbl[6,6]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		txt_material.highlight();
		System.out.println("The Sales deals value" + txt_material.getText());
	}

	public void verifyVariantMaterial() throws Exception {
		leanFtButtonClick(btn_testExecute, "execute");
		selectTestFunctionTableValues("IT_SALES_DEAL");
		Label txt_material = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[0]/usr/lbl[6,6]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		txt_material.highlight();
		System.out.println("The Sales deals value" + txt_material.getText());
	}

	public void verifyExecute() throws Exception {
		Label entryLabel = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[0]/usr/lbl[37,14]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		if (entryLabel.exists()) {
			entryLabel.setFocus();
			leanFtButtonClick(btn_exe, "Execute");
		}
	}

	public void executeSelectedContract() throws Exception {
		waitTill("6");
		leanFtButtonClick(btn_exe, "Execute");
		waitTill("6");
		leanFtEnter();
		leanFtEnter();

	}

	public void switchToFM() throws Exception {
		OKCode oKCode = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(OKCode.class, new OKCodeDescription.Builder()
						.type(com.hp.lft.sdk.sap.gui.ComponentType.OK_CODE_FIELD).build());
		oKCode.setValue("/n");
		leanFtEnter();
		if (!session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(TreeView.class, new TreeViewDescription.Builder().name("shell")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_TREE).build())
				.exists()) {
			leanFtEnter();

		}
		logReport("INFO", "The user is in login page");
	}

	public void enterTableDetails(String tName) throws Exception {
		leanFtSendKeys(txt_table, tName);
		leanFtEnter();
		waitTill("6");
	}

	public void enterDateCreatedBY(String name) throws Exception {
		Table selectionCriteriaTable = session
				.describe(Window.class,
						new WindowDescription.Builder().name("wnd[0]").program("SAPLSE16N").screenNumber(100l)
						.transaction("SE16N").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Table.class, new TableDescription.Builder().name("SAPLSE16NSELFIELDS_TC")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
		selectionCriteriaTable.activateCell(2, "Fr.Value");
		waitTill("6");
		String createdDate = endDatevalue("dd.MM.yyyy", 0, 0, 0);
		selectionCriteriaTable.getRows().get(2).getCell("Fr.Value").setValue(createdDate);
		waitTill("6");
		selectionCriteriaTable.activateCell(4, "Fr.Value");
		waitTill("6");
		selectionCriteriaTable.getRows().get(4).getCell("Fr.Value").setValue(name);
		leanFtButtonClick(btn_testExecute, "Execute");
	}

	public void veriftcreatedContracts(String name) throws Exception {
		waitTill("6");
		Grid createdTable = session
				.describe(Window.class,
						new WindowDescription.Builder().name("wnd[0]").program("SAPLSE16N").screenNumber(200l)
						.transaction("SE16N").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Grid.class, new GridDescription.Builder().name("shell")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_GRID_VIEW).build());
		for (int i = 0; i < createdTable.getRows().size(); i++) {
			createdTable.getRows().get(i).getCell("Created by").getValue().equals(name);
			waitTill("6");
			String createdCon = createdTable.getRows().get(i).getCell("Sales Document").getValue();
			createdContracts.add(createdCon);
			waitTill("6");
			soldTo = createdTable.getRows().get(i).getCell("Sold-to party").getValue();
			logReport("INFO", "Sold to value is validated " + soldTo);
			waitTill("6");
			poHeader = createdTable.getRows().get(i).getCell("Purchase order no.").getValue();
			logReport("INFO", "PO Header  to value is validated");
		}
		logReport("PASS", "The created contracts are validated");
	}

	public void enterContractNumber() throws Exception {
		for (int i = 0; i < createdContracts.size(); i++) {
			if (createdContracts.get(i).startsWith("5")) {
				leanFtSendKeys(txt_order, createdContracts.get(i));
				// createdContracts.size()-1));
				break;
			}
		}
		leanFtButtonClick(btn_searchContract, "Search");

	}

	public void validateContractTable() {
		waitTill("6");
		txt_soltTo.equals(soldTo);
		txt_POHeader.equals(poHeader);
	}

	public void enterAgreementNumber(String Agreement) throws Exception {
		leanFtSendKeys(txt_Agreement, Agreement);
		leanFtEnter();
		waitTill("6");

	}

	public void getIFFvalue(String Agreement) throws Exception {
		EditField industrialFundFeeEditField = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(EditField.class, new EditFieldDescription.Builder().attachedText("IndustrialFund Fee%")
						.name("KONA-ZZINDUSTFUDFEE").type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build());
		industrialFundFeeEditField.highlight();
		IFFvalue = industrialFundFeeEditField.getText().toString();
		IFFvalue = IFFvalue.replaceAll("[-+.^:,]", "");
		System.out.println(IFFvalue);
	}

	public void switchtoTable(String transactionNumber) throws Exception {
		switch (transactionNumber) {
		case "VA43":
			Table allItemsTable = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(Table.class, new TableDescription.Builder().name("SAPMV45ATCTRL_U_ERF_KONTRAKT")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
			allItemsTable.highlight();
			allItemsTable.activateCell(0, "Material");
			break;
		case "VA03":
			Table allItemsTable1 = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(Table.class, new TableDescription.Builder().name("SAPMV45ATCTRL_U_ERF_KONTRAKT")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
			allItemsTable1.highlight();
			allItemsTable1.activateCell(0, "Material");
		case "VA01":
			Table allItemsTable2 = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(Table.class, new TableDescription.Builder().name("SAPMV45ATCTRL_U_ERF_KONTRAKT")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
			allItemsTable2.highlight();
			allItemsTable2.activateCell(0, "Material");
		case "VA03_AUFTRAG":
			Table allItemsTable4 = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(Table.class, new TableDescription.Builder().name("SAPMV45ATCTRL_U_ERF_AUFTRAG")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
			allItemsTable4.highlight();
			allItemsTable4.activateCell(1, "Material");
		}
	}

	public void selectMaterial(String transName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, "MaterialTable");
		leanFtEnter();
		waitTill("6");
		leanFtButtonClick(btn_con, "Continue");
		leanFtButtonClick(btn_con, "Continue");
		waitTill("6");
		switchtoTable(sap.get(0).get(transName));
	}

	public void selectMaterail() throws Exception {

		leanFtEnter();
		waitTill("6");
		leanFtButtonClick(btn_con, "Continue");
		leanFtButtonClick(btn_con, "Continue");
		waitTill("6");

		Table OrderTable = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Table.class, new TableDescription.Builder().name("SAPMV45ATCTRL_U_ERF_AUFTRAG")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
		Table allItemsTable = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Table.class, new TableDescription.Builder().name("SAPMV45ATCTRL_U_ERF_KONTRAKT")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
		if (OrderTable.exists()) {
			OrderTable.highlight();
			OrderTable.activateCell(1, "Material");
		} else {
			allItemsTable.highlight();
			allItemsTable.activateCell(1, "Material");
		}
		logReport("INFO", "The material value is selected");

	}

	public void selectdisplayOrderMaterial() throws Exception {
		waitTill("6");
		Table allItemsTable = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Table.class, new TableDescription.Builder().name("SAPMV45ATCTRL_U_ERF_AUFTRAG")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
		allItemsTable.highlight();
		allItemsTable.activateCell(1, "Material");
		logReport("INFO", "The material value is selected");
	}

	public void selectCondtionTab() throws Exception {
		waitTill("6");
		TabControl condtionTab = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(TabControl.class, new TabControlDescription.Builder().name("TAXI_TABSTRIP_ITEM")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build());
		condtionTab.highlight();
		condtionTab.select("Conditions");
		logReport("INFO", "The condition tab is selected");
	}

	public static int getParentTablerow(String parentTable, String cellName) throws Exception {
		waitTill("6");
		int rowNum = 0;
		try {

			Table pricingElementsTable = session
					.describe(Window.class,
							new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
							.build())
					.describe(Table.class, new TableDescription.Builder().name("SAPLV69ATCTRL_KONDITIONEN")
							.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());

			List<TableRow<TableCell>> rows = pricingElementsTable.getRows();
			int rownumber = rows.size();
			for (int i = 0; i < rownumber; i++) {
				String val = pricingElementsTable.getRows().get(i).getCell(cellName).getValue().trim();
				System.out.println(val);
				if (parentTable.equalsIgnoreCase(val)) {
					rowNum = i;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowNum;
	}

	public static int getRowNumber(Table TableName, String columnName, String cellName) throws Exception {
		int rowNum = 0;
		try {
			List<TableRow<TableCell>> rows = TableName.getRows();
			System.out.println("Rows size" + TableName.getRows().size());
			int rownumber = rows.size();
			for (int i = 0; i < rownumber; i++) {
				String val = TableName.getRows().get(i).getCell(columnName).getValue().trim();
				System.out.println(val);
				if (cellName.equalsIgnoreCase(val)) {
					rowNum = i;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowNum;
	}

	public static int getGridRowNumber(String cellName, String parentTable) throws Exception {
		int rowNum = 0;
		Grid gridViewCtrlGrid = session
				.describe(Window.class,
						new WindowDescription.Builder().name("wnd[1]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW).build())
				.describe(Grid.class, new GridDescription.Builder().name("shell")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_GRID_VIEW).build());
		try {
			List<TableRow<GridCell>> rows = gridViewCtrlGrid.getRows();
			int rownumber = rows.size();
			for (int i = 0; i < rownumber; i++) {
				String val = gridViewCtrlGrid.getRows().get(i).getCell(cellName).getValue().trim();
				System.out.println(val);
				if (parentTable.equalsIgnoreCase(val)) {
					rowNum = i;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowNum;
	}

	public void verifyIFFValue(String industrialFundFee, String cellName) throws Exception {
		waitTill("6");
		String actual = null;
		Table condition = selectTable("Conditions");
		for (int i = 0; i < condition.getRows().size(); i++) {
			if (condition.getRows().get(i).getCell(cellName).getValue().equalsIgnoreCase(industrialFundFee)) {
				actual = condition.getRows().get(i).getCell("Amount").getValue();
			}
		}
		System.out.println(actual);
		actual = actual.replaceAll("[-+.^:,]", "");
		actual = actual.substring(0, actual.length() - 1);
		System.out.println("Actual value is " + actual + "And expected value is " + IFFvalue);
		if (IFFvalue.contains(actual)) {
			logReport("INFO", "The IFF values is exist by default in sales order");
		} else {
			logReport("INFO", "The IFF value is not found");
		}

	}

	public void veriyYATCondition(String condtionYAT, String cellName) throws Exception {
		waitTill("6");
		int row;
		row = getParentTablerow(condtionYAT, cellName);
		Table pricingElementsTable = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Table.class, new TableDescription.Builder().name("SAPLV69ATCTRL_KONDITIONEN")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
		pricingElementsTable.highlight();
		pricingElementsTable.selectRow(row + 1);
		logReport("INFO", "YAT row is selected");
		waitTill("6");
	}

	public void selectConditionRec() throws Exception {
		Button conditionRecButton = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Button.class, new ButtonDescription.Builder().name("BT_KREC")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build());
		conditionRecButton.highlight();
		conditionRecButton.click();
	}

	public void verifySalesDeal(String sales) throws Exception {
		waitTill("6");
		Grid salesDeal = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Grid.class, new GridDescription.Builder().name("shell")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_GRID_VIEW).build());

		if (salesDeal.exists()) {
			salesDeal.highlight();
			if (salesDeal.getRows().get(0).getCell("Sales deal").getValue().equalsIgnoreCase(sales)) {
				logReport("INFO", "Sales deal values is matched");
			} else {
				logReport("INFO", "Sales values is not matched");
			}
		}
	}

	public void enterSalesDeal(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		EditField salesDealEditField = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(EditField.class, new EditFieldDescription.Builder().name("RV13A-KNUMA_AG")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
		if (salesDealEditField.exists()) {
			salesDealEditField.setText(sap.get(0).get("SalesDealNumber"));
			leanFtEnter();
		} else {
			leanFtSendKeys(txt_salesDeal, sap.get(0).get("SalesDealNumber"));
			leanFtEnter();
		}
	}

	public void enterSalesOrganisation(String sheetName) throws Exception {
		waitTill("6");
		Window organizationalDataWindow = session.describe(Window.class,
				new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW).build());
		if (organizationalDataWindow.exists()) {
			organizationalDataWindow.highlight();
			enterOrganisationalData(sheetName);
			logReport("INFO", "The organisation datails are entered");
		} else {
			logReport("INFO", "The organisation datails are taken by default");
		}

	}

	public void enterMandatoryDetails(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		leanFtSendKeys(txt_contractType, sap.get(0).get("ContractType"));
		leanFtSendKeys(txt_contractAttribute, sap.get(0).get("ContractAttribute"));
		leanFtSendKeys(txt_contractBehaviour, sap.get(0).get("ContractBehaviour"));
		leanFtSendKeys(txt_IFFvalue, sap.get(0).get("IFFvalue"));
		leanFtButtonClick(btn_save, "Save");
	}

	public static String statusBar() throws Exception {
		StatusBar statusBar = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(StatusBar.class, new StatusBarDescription.Builder()
						.type(com.hp.lft.sdk.sap.gui.ComponentType.STATUSBAR).build());
		statusBar.highlight();
		return salesNumber = statusBar.getText();

	}

	public void getcreatedSalesNumber() throws Exception {
		statusBar();
		salesNumber = salesNumber.replaceAll("[^0-9]", "");
		System.out.println(salesNumber);
		waitTill("6");

	}

	public void enterSalesDeal() throws Exception {
		waitTill("6");
		leanFtSendKeys(enter_salesDeal, salesNumber);
		leanFtEnter();
	}

	public void editIFFSave(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		leanFtSendKeys(edit_IFF, sap.get(0).get("IFFvalue1"));
		leanFtEnter();
		leanFtButtonClick(btn_save, "Save");
		waitTill("6");
		logReport("INFO", "The sales deal values are updated");
	}

	public void verifysalesOrder() throws Exception {
		waitTill("6");
		EditField cFDNumberEditField = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(EditField.class, new EditFieldDescription.Builder().name("KONA-ZZCFDNUMBER")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build());
		cFDNumberEditField.highlight();
		EditField industrialFundFeeEditField = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(EditField.class, new EditFieldDescription.Builder().name("KONA-ZZINDUSTFUDFEE")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build());
		industrialFundFeeEditField.highlight();
		String iff = industrialFundFeeEditField.getText();
		if (iff.equalsIgnoreCase(salesNumber)) {
			logReport("PASS", "The IFF value is updated with latest value " + iff);
		}
	}

	public void enterTableName(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		EditField tableEditField = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(EditField.class, new EditFieldDescription.Builder().name("GD-TAB")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
		tableEditField.highlight();
		tableEditField.setText(sap.get(0).get("TableName"));
		leanFtEnter();
	}

	public void enterAgreementNumberinTable(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		waitTill("6");
		Table selectionCriteriaTable = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Table.class, new TableDescription.Builder().name("SAPLSE16NSELFIELDS_TC")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
		selectionCriteriaTable.highlight();
		selectionCriteriaTable.getRows().get(1).getCell("Fr.Value").setValue("CL00000001");
		// selectionCriteriaTable.getRows().get(1).getCell(sap.get(0).get("cellName1")).setValue(sap.get(0).get("SalesDealNumber"));
		leanFtButtonClick(btn_testExecute, "Execute");
	}

	public void enterSalesNumber(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		enterTableName(sheetName);
		Table selectionCriteriaTable = selectTable("salesExecute");
		selectionCriteriaTable.highlight();
		selectionCriteriaTable.getRows().get(1).getCell(sap.get(0).get("cellName1")).setValue(salesNumber);
		leanFtButtonClick(btn_testExecute, "Execute");
	}

	public void verifykonaTable(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		Grid gridViewCtrlGrid = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Grid.class, new GridDescription.Builder().name("shell")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_GRID_VIEW).build());
		if (gridViewCtrlGrid.getRows().get(0).getCell("Contract Type").getValue()
				.equalsIgnoreCase(sap.get(0).get("ContractType"))) {
			logReport("PASS", "The Contract type is validated");
		}
		if (gridViewCtrlGrid.getRows().get(0).getCell("Contract Attribute").getValue()
				.equalsIgnoreCase(sap.get(0).get("ContractAttribute"))) {
			logReport("PASS", "The Contract attribute is validated");
		}
		if (gridViewCtrlGrid.getRows().get(0).getCell("Contract Behaviour").getValue()
				.equalsIgnoreCase(sap.get(0).get("ContractBehaviour"))) {
			logReport("PASS", "The ContractBehaviour is validated");
		}
	}

	Scrollable scrollTo;

	public void scrollDownUsingNative() throws GeneralLeanFtException, Exception {
		Robot robot = new Robot();
		waitTill("6");
		for (int i = 0; i < 20; i++) {
			robot.keyPress(KeyEvent.VK_DOWN);
			waitTill("6");
			robot.keyRelease(KeyEvent.VK_DOWN);

		}
	}

	public void scrolltoRight() throws Exception {
		Robot robot = new Robot();
		waitTill("6");
		for (int i = 0; i < 20; i++) {
			robot.keyPress(KeyEvent.KEY_LOCATION_RIGHT);
			waitTill("6");
			robot.keyRelease(KeyEvent.KEY_LOCATION_RIGHT);
		}
	}

	public void scrollDown() throws Exception {
		Robot robot = new Robot();
		waitTill("6");
		for (int i = 0; i < 20; i++) {
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			waitTill("6");
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		}
	}

	public void selectTestFunctionTableValues(String tableName) throws Exception {

		Label valueLabel = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[0]/usr/lbl[34,23]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		valueLabel.setFocus();
		waitTill("6");
		Label iTCONTRACTCONDITIONSINLabel = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().text(tableName)
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		while (!iTCONTRACTCONDITIONSINLabel.exists()) {
			scrollDownUsingNative();
		}
		iTCONTRACTCONDITIONSINLabel.highlight();
		Label entriesLabel = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Label.class,
						new LabelDescription.Builder().maxLength(25)
						.vri(new VisualRelation().setTestObject(iTCONTRACTCONDITIONSINLabel)
								.setHorizontalRelation(HorizontalVisualRelation.LEFT_AND_INLINE))
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		entriesLabel.highlight();
		entriesLabel.setFocus();
		leanFtButtonClick(btn_search, "Search");

	}

	public void verifyCondtionValues() throws Exception {
		Label cONDVALUELabel = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[0]/usr/lbl[20,4]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		cONDVALUELabel.highlight();
		leanFtButtonClick(btn_back, "Back");
		logReport("INFO", "The condtion table is validated");
	}

	public void verifyBillingValues() throws Exception {
		Label pELabel = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[0]/usr/lbl[13,4]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		pELabel.highlight();
		logReport("INFO", "The Billing plan values are validated");
		leanFtButtonClick(btn_back, "Back");
	}

	public void verifyPromo() throws Exception {
		EditField entryEditField = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(EditField.class, new EditFieldDescription.Builder().index(6).name("")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build());
		entryEditField.highlight();
		System.out.println(entryEditField.getText());
		logReport("INFO", "The Promo  values are validated");
		leanFtButtonClick(btn_back, "Back");
	}

	public void verifyCondtionsforSalesDeal() throws Exception {
		Table allItemsTable = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Table.class, new TableDescription.Builder().name("SAPMV45ATCTRL_U_ERF_KONTRAKT")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
		allItemsTable.highlight();
		allItemsTable.activateCell(1, "Material");
		logReport("INFO", "The material is selected");
	}

	public void selectTab(String tabName) throws Exception {
		waitTill("6");
		TabControl tAXITABSTRIPITEMTabControl = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(TabControl.class, new TabControlDescription.Builder().name("TAXI_TABSTRIP_ITEM")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build());
		TabControl tAXITABSTRIPTabControl1 = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(TabControl.class, new TabControlDescription.Builder().name("TAXI_TABSTRIP")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build());
		if (tAXITABSTRIPITEMTabControl.exists()) {
			tAXITABSTRIPITEMTabControl.highlight();
			tAXITABSTRIPITEMTabControl.select(tabName);
		} else {
			tAXITABSTRIPTabControl1.highlight();
			tAXITABSTRIPTabControl1.select(tabName);
		}
	}

	public void selectVA03Tab(String tabName) throws Exception {
		waitTill("6");
		TabControl tAXITABSTRIPITEMTabControl = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(TabControl.class, new TabControlDescription.Builder().name("TAXI_TABSTRIP_ITEM")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build());
		TabControl tAXITABSTRIPITEMTabControl1 = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(TabControl.class, new TabControlDescription.Builder().name("TAXI_TABSTRIP_ITEM")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build());
		if (tAXITABSTRIPITEMTabControl.exists()) {
			tAXITABSTRIPITEMTabControl.highlight();
			tAXITABSTRIPITEMTabControl.select(tabName);
		} else {
			tAXITABSTRIPITEMTabControl1.highlight();
			tAXITABSTRIPITEMTabControl1.select(tabName);
		}
	}

	public void verifyContractDate() throws Exception {
		EditField contractStartDateEditField = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(EditField.class, new EditFieldDescription.Builder().name("VEDA-VBEGDAT")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
		contractStartDateEditField.highlight();
		String startDate = contractStartDateEditField.getText();
		logReport("INFO", "The contract start date is " + startDate);
		EditField contractEndDateEditField = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(EditField.class, new EditFieldDescription.Builder().name("VEDA-VENDDAT")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
		contractEndDateEditField.highlight();
		String endDate = contractEndDateEditField.getText();
		logReport("INFO", "The contract End date is " + endDate);
	}

	public void verifyBillingvalues() throws Exception {
		Table datesTable = selectTable("billing items");
		datesTable.highlight();
		for (int i = 0; i < datesTable.getRows().size(); i++) {
			try {
				String billingValue = datesTable.getRows().get(i).getCell("Bill.value").getValue();
				logReport("INFO", "The Billing values are  " + billingValue);
			} catch (Exception e) {
				break;
			}
		}
	}

	public void saveOrder() throws Exception {
		leanFtButtonClick(back_button, "Back");
		leanFtButtonClick(back_button, "Back");
		leanFtButtonClick(btn_save, "Save");
		waitTill("6");
		leanFtEnter();
		waitTill("15");
		leanFtButtonClick(btn_orderSave, "Save");
		// waitTill("6");
		StatusBar statusBar = session
				.describe(Window.class,
						new WindowDescription.Builder().name("wnd[0]").program("SAPMV45A").screenNumber(4001l)
						.transaction("VA01").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(StatusBar.class, new StatusBarDescription.Builder()
						.type(com.hp.lft.sdk.sap.gui.ComponentType.STATUSBAR).build());
		String txt_status = statusBar.getText();
		logReport("INFO", "The created order nmuber is" + txt_status);
		orderNumber = txt_status.replaceAll("[^0-9]", "");
		System.out.println(orderNumber);
		waitTill("6");
	}

	public void changePaymnetTerm(String name) throws Exception {
		waitTill("6");
		Label paymentTermsLabel = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().text(name)
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		paymentTermsLabel.highlight();
		EditField paymentTermsEditField = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(EditField.class,
						new EditFieldDescription.Builder().maxLength(4)
						.vri(new VisualRelation().setTestObject(paymentTermsLabel)
								.setHorizontalRelation(HorizontalVisualRelation.LEFT_AND_INLINE))
						.name("VBKD-ZTERM").type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
		paymentTermsEditField.highlight();
		paymentTermsEditField.setFocus();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_F4);
	}

	static List<String> paymentList = null;

	public void paymentValuesList() {
		paymentList.add("0001");
		paymentList.add("0002");
		paymentList.add("0003");
		paymentList.add("0004");
	}

	public static StringProperty paymentValues() {
		for (int i = 0; i < paymentList.size(); i++) {
			Utility.randomNumber(i);
		}
		return null;
	}

	public void slectPaymentTerm() throws Throwable {
		waitTill("6");
		Window tableRow1121EntriesWindow = session.describe(Window.class,
				new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW).build());
		tableRow1121EntriesWindow.highlight();
		Label label = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().text("0001")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		label.highlight();
		label.setFocus();
		leanFtEnter();
		waitTill("6");
		EditField paymentTermsEditField = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(EditField.class, new EditFieldDescription.Builder().name("VBKD-ZTERM")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
		paymentTrem = paymentTermsEditField.getText();
		logReport("INFO", "The updated paymnet term value is " + paymentTrem);
	}

	public void selectAnalysisButton() throws Exception {
		waitTill("6");
		Button analysisButton = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Button.class, new ButtonDescription.Builder().name("BT_PROT")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build());
		analysisButton.highlight();
		analysisButton.click();
	}

	public void selectSalesDealValue() throws Exception {
		waitTill("6");
		TreeView tableTreeControlTreeView = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(TreeView.class, new TreeViewDescription.Builder().name("shell")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_TREE).build());
		tableTreeControlTreeView.highlight();
		waitTill("6");
		try {
			String path = tableTreeControlTreeView.buildNodePath(1);
			tableTreeControlTreeView.activateNode(path);
			tableTreeControlTreeView.selectNode("ZSCM01;ZA01;018(ZA01);1.000,00 DKK 1 PCE");
			/*
			 * Robot robot = new Robot(); robot.keyPress(KeyEvent.VK_DOWN);
			 */
		} catch (Throwable t) {
			System.out.print(t);
		}
	}

	public void enterApttusContractNumber(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		leanFtSendKeys(txt_order, sap.get(0).get("ApptusContract"));
		waitTill("6");
		leanFtEnter();

		waitTill("6");
	}

	public void selectOrderTab(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		TabControl orderTable = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(TabControl.class, new TabControlDescription.Builder().name("TAXI_TABSTRIP_ITEM")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build());
		TabControl tAXITABSTRIPITEMTabControl = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(TabControl.class, new TabControlDescription.Builder().name("TAXI_TABSTRIP_ITEM")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build());
		if (orderTable.exists()) {
			orderTable.highlight();
			orderTable.select(sap.get(0).get("TabName"));
		} else {
			tAXITABSTRIPITEMTabControl.highlight();
			tAXITABSTRIPITEMTabControl.select(sap.get(0).get("TabName"));
		}
	}

	public void verifyWBSValue() {
		try {
			EditField wBSElementEditField = session
					.describe(Window.class,
							new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
							.build())
					.describe(EditField.class, new EditFieldDescription.Builder().name("COBL-PS_POSID")
							.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
			wBSElementEditField.highlight();
			String wbsValue = wBSElementEditField.getText();
			if (wbsValue.contains(sap.get(0).get("ApptusContract"))) {
				logReport("PASS", "The WBS value is verified successfully");
			}

		} catch (GeneralLeanFtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enteroder(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		leanFtSendKeys(txt_order, sap.get(0).get("projectOrder"));
		waitTill("6");
		leanFtEnter();
		for (int i = 0; i < 4; i++) {
			if (session
					.describe(Window.class,
							new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW)
							.build())
					.describe(Button.class, new ButtonDescription.Builder().name("btn[0]")
							.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build())
					.exists()) {
				leanFtButtonClick(btn_continue, "continue");
			}
		}
	}

	public void verifySchedule(String sheetName) throws EncryptedDocumentException, FileNotFoundException, IOException {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		try {
			Table quantitiesDatesTable = session
					.describe(Window.class,
							new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
							.build())
					.describe(Table.class, new TableDescription.Builder().name("SAPMV45ATCTRL_PEIN")
							.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
			quantitiesDatesTable.highlight();
			if (quantitiesDatesTable.getRows().get(0).getCell(sap.get(0).get("scheduleLine")).getValue()
					.equalsIgnoreCase(sap.get(0).get("Zbracket"))) {
				logReport("PASS", "The schedule line value is verified");
			}
		} catch (GeneralLeanFtException e) {

			e.printStackTrace();
		}
	}

	public void verifySalesdoc(String sheetName) throws EncryptedDocumentException, FileNotFoundException, IOException {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		try {
			EditField itemEditField = session
					.describe(Window.class,
							new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
							.build())
					.describe(EditField.class, new EditFieldDescription.Builder().name("VBAP-ZZREFDOC")
							.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
			itemEditField.highlight();
			if (itemEditField.getText().equalsIgnoreCase(sap.get(0).get("ApptusContract"))) {
				logReport("PASS", "The sales document value is verified");
			}
		} catch (GeneralLeanFtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void SelectScheduleTab(String tabName) throws Exception {
		TabControl scheduleTab = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(TabControl.class, new TabControlDescription.Builder().name("TAXI_TABSTRIP_ITEM")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build());
		scheduleTab.select(tabName);
	}

	public void selectAdditional(String tabName) throws Exception {
		TabControl additional = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(TabControl.class, new TabControlDescription.Builder().name("TAXI_TABSTRIP_ITEM")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build());
		additional.highlight();
		additional.select(tabName);
		;
	}

	public void selectDocumentflow() throws Exception {
		TabControl salesA = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(TabControl.class, new TabControlDescription.Builder().name("TAXI_TABSTRIP")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build());
		salesA.select("Sales A");
		waitTill("6");
		leanFtButtonClick(btn_displaydoc, "Display document flow");
	}

	public void verifyldocumnet() throws Exception {
		TreeView tableTreeControlTreeView = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(TreeView.class, new TreeViewDescription.Builder().name("shell[1]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_TREE).build());
		String path = tableTreeControlTreeView.buildNodePath(1);
		tableTreeControlTreeView.activateNode(path);
		waitTill("6");
		Grid documentNodeTable = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Grid.class, new GridDescription.Builder().name("shell")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_GRID_VIEW).build());
		System.out.println("The document value is " + documentNodeTable.getRows().get(0).getCell("Doc.no.").getValue());
	}

	public void enterOrderforPDF(String orderNum) throws Exception {
		leanFtSendKeys(txt_order, orderNum);

	}

	public void selectSalesDocument() throws EncryptedDocumentException, FileNotFoundException, IOException {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, "OpenText");
		try {
			Menubar mbarMenubar = session
					.describe(Window.class,
							new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
							.build())
					.describe(Menubar.class, new MenubarDescription.Builder()
							.type(com.hp.lft.sdk.sap.gui.ComponentType.MENUBAR).build());
			mbarMenubar.highlight();
			mbarMenubar.select(sap.get(0).get("Sales"));

		} catch (GeneralLeanFtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void printPreview() throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, "OpenText");
		Button printPreview = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW).build())
				.describe(Button.class, new ButtonDescription.Builder().name(sap.get(0).get("PrintPreview"))
						.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build());
	}

	public void selectContractType(String name) throws Exception {

		Label contractType = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().text(name)
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		contractType.highlight();
		Label entriesLabel = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Label.class,
						new LabelDescription.Builder().maxLength(25)
						.vri(new VisualRelation().setTestObject(contractType)
								.setHorizontalRelation(HorizontalVisualRelation.LEFT_AND_INLINE))
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		entriesLabel.highlight();
		entriesLabel.setFocus();

	}

	public void actionClick() {
		Actions actions = new Actions(driver);
		actions.click();
		waitTill("6");
		actions.release();
	}

	public void verifyPurchaseOrderValue(String variant) throws Exception {
		Table allItemsTable;
		allItemsTable = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Table.class, new TableDescription.Builder().name("SAPMV45ATCTRL_U_ERF_KONTRAKT")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
		allItemsTable.highlight();
		System.out.println(allItemsTable.getRows().get(0).getCell("Purchase order type").getValue());
		if (allItemsTable.getRows().get(0).getCell("Purchase order type").getValue().equalsIgnoreCase(variant)) {
			logReport("PASS", "The purchase order type is validated");

		}

	}

	public void verifyFirstlineItem(String sheetName) throws Exception {
		waitTill("6");
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		TreeView tableTreeControlTreeView = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(TreeView.class, new TreeViewDescription.Builder().name("shell")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_TREE).build());
		tableTreeControlTreeView.highlight();
		String path = tableTreeControlTreeView.buildNodePath(sap.get(0).get("Asset"));
		tableTreeControlTreeView.activateNode(path);
		Editor textAreaControlEditor = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Editor.class, new EditorDescription.Builder().name("shell")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_TEXT_AREA).build());
		String asset = textAreaControlEditor.getText();
		if (asset == null) {
			leanFtButtonClick(btn_next, "Next");
			asset = textAreaControlEditor.getText();
		}
		logReport("INFO", "The Test information is validated " + asset);
	}

	public void verifySalesDescription(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		waitTill("6");
		EditField descriptionEditField = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(EditField.class, new EditFieldDescription.Builder().name("KONA-BOTEXT")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build());
		descriptionEditField.highlight();
		System.out.println(descriptionEditField.getText().toString());
		if (descriptionEditField.getText().toString().equalsIgnoreCase(sap.get(0).get("Description"))) {
			logReport("PASS", "The Sales deal is terminated");
		}
	}

	public void verifyTerminationdescription(String sheetName) throws Exception {
		waitTill("6");
		Grid gridViewCtrlGrid = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Grid.class, new GridDescription.Builder().name("shell")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_GRID_VIEW).build());
		gridViewCtrlGrid.highlight();

		if (gridViewCtrlGrid.getRows().get(0).getCell("Description of Agreement").getValue()
				.equalsIgnoreCase(sap.get(0).get("Description"))) {
			logReport("PASS", "The Sales deal is terminated");
		}
	}

	public void enterProgramName(String name) throws Exception, Exception {
		leanFtSendKeys(txt_program, name);
		leanFtButtonClick(btn_testExecute, "Execute");
		logReport("INFO", "The Program name is entered");
		waitTill("6");
	}

	public void verifyDates() throws Exception {
		waitTill("6");
		EditField validityPeriodEditField = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(EditField.class, new EditFieldDescription.Builder().name("KONA-DATAB")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
		validityPeriodEditField.highlight();
		EditField toEditField = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(EditField.class, new EditFieldDescription.Builder().name("KONA-DATBI")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
		toEditField.highlight();
		logReport("INFO", "The sales deal validity fields are validated");
	}

	public void edit_salesDeal(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		leanFtSendKeys(txt_Agreement, sap.get(0).get("SalesDealNumber"));
		leanFtEnter();
	}

	public void selectCondtions() throws Exception {
		waitTill("6");
		leanFtButtonClick(btn_conditions, "Condtions");
		logReport("INFO", "The condtions are selected");
	}

	public void selectYATvalues(String sheetName) throws Exception {
		int row = 0;
		waitTill("6");
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		waitTill("6");
		Grid gridViewCtrlGrid = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW).build())
				.describe(Grid.class, new GridDescription.Builder().name("shell")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_GRID_VIEW).build());
		gridViewCtrlGrid.findAllRowsWithCellTextInColumn("YAT5", "Condition Type");
		getGridRowNumber("YAT5", "Condition Type");
		gridViewCtrlGrid.selectRow(row + 1);

	}

	public void selectSales(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		leanFtSendKeys(txt_order, sap.get(0).get("ApptusContract"));
		waitTill("6");
	}

	public void enterValues(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		leanFtSendKeys(orderType_txt, sap.get(0).get("contractType"));
		leanFtSendKeys(txt_organisation, sap.get(0).get("org"));
		leanFtSendKeys(txt_channel, sap.get(0).get("channel"));
		leanFtSendKeys(txt_division, sap.get(0).get("division"));
		// EditField contract=selecteditname("contractType");
		waitTill("6");
		leanFtButtonClick(btn_continue, "Continue");
		logReport("INFO", "The enter clicked");
	}

	public void selectCreateReference() throws Exception {
		waitTill("6");
		leanFtButtonClick(btn_testExecute, "Execute");
		logReport("INFO", "The create with Reference is selected");
	}

	public void selectTabforrefernece(String sheeName) throws Exception {
		waitTill("6");
		TabControl contractTab = tabs("contract");
		contractTab.select(sap.get(0).get("tabName"));
	}

	public void entercontract_copy(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		leanFtSendKeys(txt_contract, sap.get(0).get("orderNumber"));
		waitTill("6");
		leanFtButtonClick(btn_displaydoc, "Copy");
		logReport("INFO", "The cpoy is selected to create the reference");
		leanFtButtonClick(btn_continue, "continue");

	}

	public Label selectLabel(String value) throws Exception {
		Label pSSLabel = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().text(value)
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		return pSSLabel;
	}

	public void selectCOntinue() throws Exception {
		leanFtButtonClick(btn_continue, "continue");
		waitTill("6");
		leanFtButtonClick(btn_continue, "continue");
	}

	public void enterItemCategory(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		waitTill("6");
		EditField prcessType = selecteditname("processType");
		prcessType.setFocus();
		prcessType.highlight();
		waitTill("6");
		keyboardclick();
		Label pssValue = selectLabel(sap.get(0).get("process"));
		pssValue.setFocus();
		leanFtButtonClick(btn_continue, "continue");
		EditField billing = selecteditname("BillingMethod");
		billing.setFocus();
		waitTill("6");
		keyboardclick();
		Label billingValue = selectLabel(sap.get(0).get("billing"));
		billingValue.setFocus();
		leanFtButtonClick(btn_continue, "continue");
		EditField Shipping = selecteditname("Shipping");
		Shipping.setFocus();
		waitTill("6");
		keyboardclick();
		Label shippingValue = selectLabel(sap.get(0).get("Indicator"));
		shippingValue.setFocus();
		leanFtButtonClick(btn_continue, "continue");
		waitTill("6");
		leanFtButtonClick(btn_continue, "continue");

	}

	public void enterContractDetails(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		leanFtSendKeys(txt_soldTo, sap.get(0).get("SoldTo"));
		leanFtSendKeys(txt_shipTo, sap.get(0).get("shipTo"));
		leanFtSendKeys(txt_poNumber, Utility.getFormatedDateTime());
		leanFtSendKeys(txt_Description, sap.get(0).get("Description"));
		String contractEndDat = endDatevalue("d.MM.yyyy", 0, 0, 2);
		leanFtSendKeys(contractstartDate, currentDateValue("d.MM.yyyy"));
		leanFtSendKeys(contractEndDate, contractEndDat);
		leanFtEnter();
		waitTill("6");
		leanFtButtonClick(btn_con, "Continue");
	}

	public void PODateChanges(String sheetName, int day) throws Exception {
		try {
			sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
			leanFtSendKeys(txt_soldTo, sap.get(0).get("SoldTo"));
			leanFtSendKeys(txt_shipTo, sap.get(0).get("shipTo"));
			leanFtSendKeys(txt_poNumber, Utility.getFormatedDateTime());
			leanFtSendKeys(txt_PODate, null);
			waitTill("6");
			leanFtSendKeys(txt_PODate, endDatevalue("d.MM.yyyy", day, 0, 0));
			leanFtSendKeys(txt_Description, sap.get(0).get("Description"));
			String contractEndDat = endDatevalue("d.MM.yyyy", 0, 0, 2);
			leanFtSendKeys(contractstartDate, currentDateValue("d.MM.yyyy"));
			leanFtSendKeys(contractEndDate, contractEndDat);
			leanFtEnter();
			waitTill("6");
			String status = getStatusBarValue();
			logReport("INFO", status);
		} catch (Exception e) {
			leanFtEnter();
		}

		leanFtButtonClick(btn_con, "Continue");
	}

	public void null_PODATE(String sheetName) throws Exception {
		try {
			sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
			leanFtSendKeys(txt_soldTo, sap.get(0).get("SoldTo"));
			leanFtSendKeys(txt_shipTo, sap.get(0).get("shipTo"));
			leanFtSendKeys(txt_poNumber, Utility.getFormatedDateTime());
			leanFtSendKeys(txt_PODate, null);
			waitTill("6");
			leanFtSendKeys(txt_Description, sap.get(0).get("Description"));
			String contractEndDat = endDatevalue("d.MM.yyyy", 0, 0, 2);
			leanFtSendKeys(contractstartDate, currentDateValue("d.MM.yyyy"));
			leanFtSendKeys(contractEndDate, contractEndDat);
			leanFtEnter();
			waitTill("6");
			String status = getStatusBarValue();
			logReport("INFO", status);
		} catch (Exception e) {
			leanFtEnter();
		}

		leanFtButtonClick(btn_con, "Continue");

	}

	public void selectreferenceValues() throws Exception {
		try {
			Table itemListTable = selectTable("referenceItems");
			itemListTable.selectRow(1);
			leanFtButtonClick(btn_continue, "Continue");
			logReport("INFO", "The Material selected");
		} catch (Exception e) {
			logReport("INFO", "The materials selected by default");
		}
	}

	public void verifyProfitCenter() throws Exception {
		waitTill("6");
		sap = Excel.getFirstRowData(AutomationConstants.sapData, "898586");
		Table allItemsTable = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Table.class, new TableDescription.Builder().name("SAPMV45ATCTRL_U_ERF_AUFTRAG")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
		allItemsTable.highlight();
		String profitValue = allItemsTable.getRows().get(1).getCell(sap.get(0).get("profitTab")).getValue().trim();
		logReport("INFO", "The profit center values is " + profitValue);

	}

	public void enetrPoDeails() throws Exception {

		String poDate = currentDateValue("dd.MM.yyyy");
		leanFtSendKeys(txt_poNumber, Utility.getFormatedDateTime());
		leanFtSendKeys(txt_PODate, poDate);
	}

	public void verifyTableMaterial(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		Grid gridViewCtrlGrid = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Grid.class, new GridDescription.Builder().name("shell")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_GRID_VIEW).build());
		String value = gridViewCtrlGrid.getRows().get(0).getCell("Sales deal").getValue();
		System.out.println(value);
		if (value.contains(sap.get(0).get("SalesDealNumber"))) {
			logReport("PASS", "member synced successfully");
		}
	}

	public void conditionValues() throws Exception {
		Grid gridViewCtrlGrid = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW).build())
				.describe(Grid.class, new GridDescription.Builder().name("shell")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_GRID_VIEW).build());
		gridViewCtrlGrid.highlight();
		List<TableRow<GridCell>> values = gridViewCtrlGrid.getRows();
		for (int i = 0; i < values.size(); i++) {
			System.out.println(values.get(i).getCell("Condition Type").getValue());
		}
		leanFtButtonClick(bnt_close, "Close");
		logReport("PASS", "The condition values are verified");
	}

	public void getWBSValue() throws Exception {
		EditField value = selecteditname("wbs element");
		wbsValue = value.getText();
		logReport("INFO", "The WBS value is " + wbsValue);
	}

	public void enterWBSValue() throws Exception {
		leanFtSendKeys(enter_WBS, wbsValue);
		leanFtEnter();
	}

	public void saveWBS(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		Menubar mbarMenubar = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Menubar.class,
						new MenubarDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MENUBAR).build());
		mbarMenubar.highlight();
		mbarMenubar.select(sap.get(0).get("tabValues"));
		leanFtButtonClick(btn_cont, "Continue");
	}

	public void selectEnter() throws Exception {
		waitTill("6");
		leanFtEnter();
	}

	List<String> products = new ArrayList<>();
	List<String> highVltItem = new ArrayList<>();

	public void getProducts(String sheetName) throws EncryptedDocumentException, FileNotFoundException, IOException {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		String materials = sap.get(0).get("materialNumber");
		String[] actual = materials.split(":");
		for (int i = 0; i < actual.length; i++) {
			products.add(actual[i]);
		}
	}

	public void getHighVLValue(String sheetName) throws EncryptedDocumentException, FileNotFoundException, IOException {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		String materials = sap.get(0).get("HighVLT");
		String[] actual = materials.split(":");
		for (int i = 0; i < actual.length; i++) {
			highVltItem.add(actual[i]);
		}

	}

	public void enterZCQmaterials(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		try {
			Table materials = selectTable("ordertabVA01");

			System.out.println(materials.getRows().size());
			getProducts(sheetName);
			for (int i = 0; i < products.size(); i++) {

				materials.getRows().get(i).getCell(sap.get(0).get("tabname")).setValue(products.get(i));
			}

		} catch (GeneralLeanFtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void enterHighvoltageValues(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		Table materials = selectTable("ordertabVA01");
		getHighVLValue(sheetName);
		for (int i = 0; i < highVltItem.size(); i++) {
			materials.getRows().get(i).getCell("HgLvIt").setValue(highVltItem.get(i));
		}
		logReport("INFO", "The HgLvItem values is added");
	}

	public void continueMaterials() throws Exception {
		leanFtEnter();
		Button continueEnterButton = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW).build())
				.describe(Button.class, new ButtonDescription.Builder().enabled(true).name("btn[0]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build());
		waitTill("6");
		int num = 1;
		while (num < 3)
			if (continueEnterButton.exists()) {
				continueEnterButton.click();
			} else {
				logReport("INFO", "The continue button is not available");
				break;
			}

	}

	public void enterTarget(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		Table materials = selectTable("ordertabVA01");
		for (int i = 0; i < products.size(); i++) {
			String tarValue = sap.get(0).get("target");
			String[] actual = tarValue.split(":");
			materials.getRows().get(i).getCell("Target quantity").setValue(actual[i]);

		}
		logReport("INFO", "The traget value is added");
	}

	public void enterOrder(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		Table materials = selectTable("ordertabVA01");
		for (int i = 0; i < products.size(); i++) {
			String tarValue = sap.get(0).get("order");
			System.out.println("order value is " + tarValue);
			String[] actual = tarValue.split(":");
			materials.getRows().get(i).getCell("Order Quantity").setValue(actual[i]);

		}
		logReport("INFO", "The Order value is added");
	}

	public TabControl tabs(String tabName) throws Exception {
		TabControl tab = null;
		Window tabWindow = null;
		switch (tabName) {
		case "partnerTabVA43":
			tab = session.describe(TabControl.class, new TabControlDescription.Builder().name("TAXI_TABSTRIP_HEAD")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build());
			break;
		case "SalesTab":
			tab = session.describe(TabControl.class,
					new TabControlDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build());
			break;
		case "ScheduleTab":
			tab = session.describe(TabControl.class,
					new TabControlDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build());
			break;
		case "TextTab":
			tabWindow = selectwindow(sap.get(0).get("tabvalue"));
			tab = tabWindow.describe(TabControl.class, new TabControlDescription.Builder().name("TAXI_TABSTRIP_HEAD")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build());

			break;
		case "Contract data":
			tab = session.describe(TabControl.class, new TabControlDescription.Builder().name("TAXI_TABSTRIP_ITEM")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build());
			break;
		case "partner":
			tab = session.describe(TabControl.class, new TabControlDescription.Builder().name("TAXI_TABSTRIP")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build());
			break;
		case "WBSControl":
			tab = session.describe(TabControl.class, new TabControlDescription.Builder().name("TABCJWB")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build());
			break;
		case "contract":
			tab = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW)
					.build())
			.describe(TabControl.class, new TabControlDescription.Builder().name("MYTABSTRIP")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build());
			break;
		case "itemOverview":
			tab = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(TabControl.class, new TabControlDescription.Builder().name("TAXI_TABSTRIP_OVERVIEW")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build());
			break;
		case "item table":
			tab = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(TabControl.class, new TabControlDescription.Builder().name("ITEM_DETAIL")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build());
			break;

		case "CreateEquipment":
			tab = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(TabControl.class, new TabControlDescription.Builder().name("TABSTRIP")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build());
			break;


		case "Packingtab":
			tab = session.describe(Window.class, new WindowDescription.Builder()
					.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
			.describe(TabControl.class, new TabControlDescription.Builder()
					.name("TAXI_TABSTRIP_OVERVIEW")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build());
			break;

		case "operation":
			tab = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(TabControl.class, new TabControlDescription.Builder().name("TS_1100")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TAB_STRIP).build());
			break;

		default:
			break;
		}
		//tab.highlight();
		return tab;

	}

	public void activate_TreeView(String value) throws Exception {
		Window win = session.describe(Window.class,
				new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build());
		TreeView tableTreeControlTreeView = win.describe(TreeView.class, new TreeViewDescription.Builder().name("shell")
				.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_TREE).build());
		tableTreeControlTreeView.activateNode(value);

	}

	public Window selectwindow(String windowName) throws Exception {
		Window orderTab = null;
		switch (windowName) {
		case "VA43window":
			orderTab = session.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build());
			break;
		case "MaterialWindow":
			orderTab = session.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build());
			break;
		case "MenuBarWindow":
			orderTab = session.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build());
			break;
		default:
			break;
		}
		return orderTab;
	}

	public Grid selectGrid(String gridName) throws Exception {
		Grid gridValue = null;
		switch (gridName) {
		case "ZUT grid":
			gridValue = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(Grid.class, new GridDescription.Builder().name("shell")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_GRID_VIEW).build());
			break;
		case "variant type":
			gridValue = session
			.describe(Window.class,
					new WindowDescription.Builder().name("wnd[1]")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW).build())
			.describe(Grid.class, new GridDescription.Builder().name("shell")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_GRID_VIEW).build());
			break;
		case "revenue":
			gridValue = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(Grid.class, new GridDescription.Builder().index(0).name("shell")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_GRID_VIEW).build());
			break;
		case "revenuedocument":
			gridValue = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(Grid.class, new GridDescription.Builder().index(1).name("shell")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_GRID_VIEW).build());
			break;
		default:
			break;
		}
		return gridValue;
	}

	public ComboBox selectCombo(String name) throws Exception {
		ComboBox optionName = null;
		switch (name) {
		case "billingBlock":
			optionName = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(ComboBox.class, new ComboBoxDescription.Builder().name("VBAK-FAKSK")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.COMBO_BOX).build());
			break;
		case "order Reason":
			optionName = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(ComboBox.class, new ComboBoxDescription.Builder().name("VBAK-AUGRU")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.COMBO_BOX).build());
			break;
		case "customer group":
			optionName = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(ComboBox.class, new ComboBoxDescription.Builder().name("VBAK-KVGR4")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.COMBO_BOX).build());
			break;
		case "prio":
			optionName = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(ComboBox.class, new ComboBoxDescription.Builder().name("G_VIQMEL-PRIOK")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.COMBO_BOX).build());
			break;
		default:
			break;
		}
		return optionName;
	}

	public EditField selecteditname(String value) throws Exception {
		EditField editfiledName = null;
		switch (value) {
		case "processType":
			editfiledName = session
			.describe(Window.class,
					new WindowDescription.Builder().name("wnd[1]")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW).build())
			.describe(EditField.class, new EditFieldDescription.Builder().name("ZZVWPOS")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
			break;
		case "contractType":
			editfiledName = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(EditField.class, new EditFieldDescription.Builder().name("VBAK-AUART")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
			break;
		case "BillingMethod":
			editfiledName = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW)
					.build())
			.describe(EditField.class, new EditFieldDescription.Builder().name("ZZBILLMETHOD")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
			break;
		case "Shipping":
			editfiledName = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW)
					.build())
			.describe(EditField.class, new EditFieldDescription.Builder().name("ZZSHIP_IND")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
			break;
		case "ContractEndDate":
			editfiledName = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(EditField.class, new EditFieldDescription.Builder().name("VEDA-VENDDAT")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
			break;
		case "PODate":
			editfiledName = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(EditField.class, new EditFieldDescription.Builder().name("VBKD-BSTDK")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
			break;
		case "PSS":
			editfiledName = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(EditField.class, new EditFieldDescription.Builder().name("VBAK-ZZVWPOS")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build());
			break;
		case "billing":
			editfiledName = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(EditField.class, new EditFieldDescription.Builder().name("VBAK-ZZBILLMETHOD")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
			break;
		case "shipment":
			editfiledName = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(EditField.class, new EditFieldDescription.Builder().name("VBAK-ZZSHIP_IND")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build());
			break;
		case "wbs element":
			editfiledName = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(EditField.class, new EditFieldDescription.Builder().name("COBL-PS_POSID")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
			break;
		case "customer name":
			editfiledName = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(EditField.class, new EditFieldDescription.Builder().name("ADDR1_DATA-NAME1")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build());
			break;
		case "contractNumber":
			editfiledName = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(EditField.class, new EditFieldDescription.Builder().name("VBAK-VBELN")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
			break;
		case "netValue":
			editfiledName = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(EditField.class, new EditFieldDescription.Builder().name("VBRK-NETWR")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build());
			break;
		case "vendor":
			editfiledName = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(EditField.class, new EditFieldDescription.Builder().name("MEPO_TOPLINE-SUPERFIELD")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
			break;
		case "telephone":
			editfiledName = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW)
					.build())
			.describe(EditField.class, new EditFieldDescription.Builder().name("SZA1_D0100-TEL_NUMBER")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build());
			break;
		case "mobile":
			editfiledName = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW)
					.build())
			.describe(EditField.class, new EditFieldDescription.Builder().name("SZA1_D0100-MOB_NUMBER")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build());
			break;
		case "email":
			editfiledName = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW)
					.build())
			.describe(EditField.class, new EditFieldDescription.Builder().name("SZA1_D0100-SMTP_ADDR")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build());
			break;
		case "purchase order":
			editfiledName = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(EditField.class, new EditFieldDescription.Builder().name("MEPO_TOPLINE-EBELN")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build());
			break;
		case "notification":
			editfiledName = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(EditField.class, new EditFieldDescription.Builder().name("CAUFVD-QMNUM")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build());
			break;
		case "poc":
			editfiledName = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(EditField.class, new EditFieldDescription.Builder().name("KKA1000-POC_PZ")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build());
			break;

		case "MaterialNo":
			editfiledName = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(EditField.class, new EditFieldDescription.Builder().name("ITOB-MATNR")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());

		case "IPStatus":
			editfiledName = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(EditField.class, new EditFieldDescription.Builder().name("ITOBATTR-STTXU")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build());
			break;

		case "Functional location":
			editfiledName = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(EditField.class, new EditFieldDescription.Builder().name("ITOB-TPLNR")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
			break;
		case "shiptoIP":
			editfiledName = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(EditField.class, new EditFieldDescription.Builder().index(0).name("IHPA-PARNR")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
			break;
		case "pcFIle":
			editfiledName = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(EditField.class, new EditFieldDescription.Builder().name("PA_FNAME")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
			break;
		case "fileLocation":
			editfiledName = session
			.describe(Window.class,
					new WindowDescription.Builder().name("wnd[1]")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW).build())
			.describe(EditField.class, new EditFieldDescription.Builder().name("DY_PATH")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
			break;
		case "ContactPerson":
			editfiledName = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(EditField.class, new EditFieldDescription.Builder().name("SZA5_D0700-TEL_NUMBER")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build());
			editfiledName.highlight();
			break;

		case "ContactLastName":
			editfiledName = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(EditField.class, new EditFieldDescription.Builder().name("ADDR3_DATA-NAME_LAST")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build());
			editfiledName.highlight();
			break;
		case "ContactFirstName":
			editfiledName = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(EditField.class, new EditFieldDescription.Builder().name("ADDR3_DATA-NAME_FIRST")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build());
			editfiledName.highlight();
			break;

		case "ContactTelephone":
			editfiledName = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(EditField.class, new EditFieldDescription.Builder().name("SZA5_D0700-TEL_NUMBER")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build());
			editfiledName.highlight();
			break;

		default:
			break;
		}
		return editfiledName;
	}

	public Button selectButton(String name) throws Exception {
		Button value = null;
		switch (name) {
		case "continue":
			value = session.describe(Button.class, new ButtonDescription.Builder().name("btn[0]")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build());
			break;
		case "save":
			value = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW)
					.build())
			.describe(Button.class, new ButtonDescription.Builder().name("SPOP-OPTION1")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build());
			break;
		default:
			break;
		}
		return value;
	}

	public Table selectTable(String tabName) throws Exception {
		Table itemstable = null;
		switch (tabName) {
		case "OrderTabVA41":
			itemstable = session.describe(Table.class,
					new TableDescription.Builder().name("SAPMV45ATCTRL_U_ERF_KONTRAKT")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
			break;
		case "ordertabVA01":
			itemstable = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(Table.class, new TableDescription.Builder().name("SAPMV45ATCTRL_U_ERF_KONTRAKT")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
			break;
		case "displayParner":
			itemstable = session.describe(Table.class,
					new TableDescription.Builder().name("SAPLV09CGV_TC_PARTNER_OVERVIEW")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
			break;
		case "projectDef":
			itemstable = session.describe(Table.class, new TableDescription.Builder().name("SAPLCJWBTAB_902")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
			break;
		case "selectView":
			itemstable = session.describe(Table.class, new TableDescription.Builder().name("SAPLMGMMTC_VIEW")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
			break;
		case "Assignments":
			itemstable = session.describe(Table.class, new TableDescription.Builder().name("SAPLCLFMTC_OBJ_CLASS")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
			break;
		case "General":
			itemstable = session.describe(Table.class, new TableDescription.Builder().name("SAPLCTMSCHARS_S")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
			break;
		case "Conditions":
			itemstable = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(Table.class, new TableDescription.Builder().name("SAPLV69ATCTRL_KONDITIONEN")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
			break;
		case "FldName":
			itemstable = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(Table.class, new TableDescription.Builder().name("SAPLSE16NSELFIELDS_TC")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
			break;
		case "salesExecute":
			itemstable = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(Table.class, new TableDescription.Builder().name("SAPLSE16NSELFIELDS_TC")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
			break;
		case "documentTable":
			itemstable = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(Table.class, new TableDescription.Builder().name("SAPMV45ATCTRL_U_ERF_AUFTRAG")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
			break;
		case "catstable":
			itemstable = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(Table.class, new TableDescription.Builder().name("SAPLCATSTC_CATSD")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
			break;
		case "status":
			itemstable = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(Table.class, new TableDescription.Builder().name("SAPLBSVATC_EO")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
			break;
		case "scheduleLine":
			itemstable = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(Table.class, new TableDescription.Builder().name("SAPMV45ATCTRL_PEIN")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
			break;
		case "All items":
			itemstable = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(Table.class, new TableDescription.Builder().name("SAPMV45ATCTRL_KOPIEREN")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
			break;
		case "referenceItems":
			itemstable = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW)
					.build())
			.describe(Table.class, new TableDescription.Builder().name("SAPMV45ATCTRL_MAT_GRP_ANZEIG")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
			break;
		case "WBSOverview":
			itemstable = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(Table.class, new TableDescription.Builder().name("SAPLCJWBTAB_902")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
			break;
		case "distributionRule":
			itemstable = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(Table.class, new TableDescription.Builder().name("SAPLKOBSTC_RULES")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
			break;
		case "billing items":
			itemstable = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(Table.class, new TableDescription.Builder().name("SAPLV60FTCTRL_FPLAN_PERIOD")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
			break;
		case "technical object":
			itemstable = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(Table.class, new TableDescription.Builder().name("SAPLIWOLOBJK_220")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
			break;
		case "billingItem":
			itemstable = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(Table.class, new TableDescription.Builder().name("SAPMV60ATCTRL_UEB_FAKT")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
			break;
		case "billing document":
			itemstable = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(Table.class, new TableDescription.Builder().name("SAPMV60ATCTRL_ERF_FAKT")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
			break;
		case "messages":
			itemstable = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(Table.class, new TableDescription.Builder().name("SAPDV70ATC_NAST3")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
			break;

		case "Single Part Delivery":
			itemstable = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(Table.class, new TableDescription.Builder().name("SAPMV50ATC_LIPS_PICK")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
			break;
		case "Processing of Handling":
			itemstable = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(Table.class, new TableDescription.Builder().name("SAPLV51GTC_HU_001")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
			break;
		case "Materials to be Packed":
			itemstable = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(Table.class, new TableDescription.Builder().name("SAPLV51GTC_HU_002")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
			break;
		default:
			break;
		}
		return itemstable;

	}

	public CheckBox checkBox(String checkboxvalue) throws Exception {
		CheckBox name = null;
		switch (checkboxvalue) {
		case "TestRun":
			name = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(CheckBox.class, new CheckBoxDescription.Builder().name("RKAUF-TEST")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.CHECK_BOX).build());
			break;
		case "details":
			name = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(CheckBox.class, new CheckBoxDescription.Builder().name("RKAUF-LIST")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.CHECK_BOX).build());
			break;
		case "test_checkbox":
			name = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(CheckBox.class, new CheckBoxDescription.Builder().name("LKO74-TESTLAUF")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.CHECK_BOX).build());
			break;
		case "detail_checkbox":
			name = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(CheckBox.class, new CheckBoxDescription.Builder().name("LKO74-LIST")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.CHECK_BOX).build());
			break;
		case "program":
			name = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(CheckBox.class, new CheckBoxDescription.Builder().index(labelsize()).name("")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.CHECK_BOX).build());
			break;
		case "spool requests":
			name = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(CheckBox.class, new CheckBoxDescription.Builder().name("")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.CHECK_BOX).build());
			break;
		case "customerAprroved":
			name = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(CheckBox.class, new CheckBoxDescription.Builder().name("VBAP-ZZLCCAP")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.CHECK_BOX).build());
			break;
		case "leagalApproved":
			name = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(CheckBox.class, new CheckBoxDescription.Builder().name("VBAP-ZZLCAPP")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.CHECK_BOX).build());
			break;
		case "confirmation":
			name = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(CheckBox.class, new CheckBoxDescription.Builder().name("AFRUD-AUERU")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.CHECK_BOX).build());
			break;
		case "remainWork":
			name = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(CheckBox.class, new CheckBoxDescription.Builder().name("AFRUD-LEKNW")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.CHECK_BOX).build());
			break;
		case "full_log":
			name = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(CheckBox.class, new CheckBoxDescription.Builder().name("KKA0100-PROTOKOLL")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.CHECK_BOX).build());
			break;
		case "ZUService":
			name = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(CheckBox.class, new CheckBoxDescription.Builder().index(19).name("")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.CHECK_BOX).build());
			break;
		case "ZUService_1":
			name = session
			.describe(Window.class,
					new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
					.build())
			.describe(CheckBox.class, new CheckBoxDescription.Builder().index(0).name("")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.CHECK_BOX).build());
		default:
			break;
		}
		return name;

	}

	public void verifyItemCategory(String sheetName) throws Exception {
		waitTill("6");
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		Table materils = selectTable(sap.get(0).get("tab1"));
		materils.highlight();
		materils.getRows().get(0).getCell(sap.get(0).get("ItemTab")).getValue()
		.equalsIgnoreCase(sap.get(0).get("value1"));
		materils.getRows().get(1).getCell(sap.get(0).get("ItemTab")).getValue()
		.equalsIgnoreCase(sap.get(0).get("value2"));
		logReport("PASS", "The item catergory values are verified");
	}

	public void selectHeaderDoc() throws Exception {
		waitTill("6");
		leanFtButtonClick(btn_displayDoc, "Header doc");
		logReport("INFO", "The header doc is selected");
	}

	public void selectTabs(String tab, String tabName) throws Exception {
		waitTill("15");
		TabControl selectedTab = tabs(tabName);
		selectedTab.select(tab);
		BaseLib.embedScreenShotInreportWithRobot();
		logReport("INFO", tab + " tab is selected");
	}

	public void verifyPartnersValues(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		Table displayRangeTable = selectTable("displayParner");
		displayRangeTable.highlight();
		displayRangeTable.getRows().get(0).getCell(sap.get(0).get("partnerfunction"));
		// row=getRowNumber(displayRangeTable,"Partn.Funct.","Ship-to party");
		for (int i = 0; i < displayRangeTable.getRows().size(); i++) {
			if (displayRangeTable.getRows().get(i).getCell("Partn.Funct.").getValue().contains("Ship-to party")) {
				displayRangeTable.getRows().get(i).getCell("Partner").getValue()
				.equalsIgnoreCase(sap.get(0).get("shipTo"));
				logReport("PASS", "The Ship to party value is updated as "
						+ displayRangeTable.getRows().get(i).getCell("Partner").getValue());
				break;
			} else {
				logReport("PASS", "The Ship to party value is  not updated as "
						+ displayRangeTable.getRows().get(i).getCell("Partner").getValue());
			}
		}
	}

	public void verifyPrcingProcedure(String sheetName) throws Exception {
		waitTill("6");
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		EditField pricProcedureEditField = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(EditField.class, new EditFieldDescription.Builder().name("VBAK-KALSM")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
		pricProcedureEditField.highlight();
		if (pricProcedureEditField.getText().equalsIgnoreCase(sap.get(0).get("pricingvalue"))) {
			logReport("PASS", "The pricing procedure values is verified" + txt_pricingProcedure.getText());
		} else {
			logReport("INFO", "The pricing value is not verified");
		}
	}

	public void selectDropdowntabs(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		tabs(sap.get(0).get("TabName"));
	}

	public void verifyObjectStatus(String sheetName) throws Throwable {
		selectDropdowntabs(sheetName);
		leanFtButtonClick(btn_objectStatus, "Object status");
		Table statusTable = selectTable("status");
		statusTable.highlight();
		logReport("INFO", "The object status values are displayed");
		try {
			for (int i = 0; i < 3; i++) {
				statusTable.getRows().get(i).getCell("X").setValue("OFF");
				waitTill("6");
				logReport("INFO", "The object value" + i + "is unchecked");
			}
		} catch (Exception e) {

		}
		leanFtButtonClick(back_button, "back");
		leanFtButtonClick(back_button, "back");
	}

	public void selectAddedMaterial(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		Table ordertable = selectTable(sap.get(0).get("tab1"));
		ordertable.activateCell(1, sap.get(0).get("tabname"));
		logReport("INFO", "The material is selected");
	}

	public void verifySceduleLines(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		waitTill("6");
		Table quantitiesDatesTable = selectTable("scheduleLine");
		quantitiesDatesTable.highlight();
		System.out.println(quantitiesDatesTable.getRows().get(0).getCell("Sched.line cat.").getValue().toString());
		if (quantitiesDatesTable.getRows().get(1).getCell("Sched.line cat.").getValue()
				.contains(sap.get(0).get("cellValue"))) {
			logReport("PASS", "The schedule line value is verified");
		} else {
			logReport("INFO", "The schedule line values is not verified");
		}
		leanFtButtonClick(back_button, "back");
	}

	public void selectLineItem(String sheetName, String itemCategory) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		Table material = selectTable(sap.get(0).get("tableName"));
		for (int i = 0; i < material.getRows().size(); i++) {
			if (material.getRows().get(i).getCell(sap.get(0).get("column")).getValue().equalsIgnoreCase(itemCategory)) {

				material.activateCell(i + 1, "Material");
				break;
			}
		}
		logReport("INFO", "The " + itemCategory + " line item is selected");
	}

	public void enterAcceptanceDate() throws Exception {
		date = currentDateValue("dd.MM.yyyy");
		leanFtSendKeys(txt_acceptanceDate, date);
		logReport("INFO", "The accpetance date is enetered as " + date);
	}

	public void enterParntersData(String sheetName) throws Exception {
		Table displayRangeTable = selectTable("displayParner");
		for (int i = 0; i < displayRangeTable.getRows().size(); i++) {
			System.out.println(displayRangeTable.getRows().get(i).getCell("Partn.Funct.").getValue());
			if (displayRangeTable.getRows().get(i).getCell("Partn.Funct.").getValue()
					.contains(sap.get(0).get("Partnerfunction"))) {
				displayRangeTable.getRows().get(i + 1).getCell("Partn.Funct.").setValue("HI Site ID  1 MAIN");
				displayRangeTable.getRows().get(i + 1).getCell("Partner").setValue(sap.get(0).get("SoldTo"));
				break;
			}

		}
		logReport("INFO", "The data is updated in partners tab");
	}

	public void enterPartnerFunction(String sheetName) throws Exception {
		Table displayRangeTable = selectTable("displayParner");
		for (int i = 0; i < displayRangeTable.getRows().size(); i++) {
			System.out.println(displayRangeTable.getRows().get(i).getCell("Partn.Funct.").getValue());
			if (displayRangeTable.getRows().get(i).getCell("Partn.Funct.").getValue().contains("Account Manager")) {
				displayRangeTable.getRows().get(i + 1).getCell("Partn.Funct.").setValue(sap.get(0).get("partnFunc"));
				displayRangeTable.getRows().get(i + 1).getCell("Partner").setValue(sap.get(0).get("partValue"));
				break;
			}
			logReport("INFO", "The data is updated in partners tab");
		}
		leanFtEnter();
	}

	public void naviagetBack() throws Throwable {
		leanFtButtonClick(back_button, "back");
		waitTill("6");
	}

	public void selectMenuBar(String sheeName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheeName);
		Window menubar = getWindow("Menubar");
		Menubar mvalue = menubar.describe(Menubar.class,
				new MenubarDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MENUBAR).build());
		mvalue.select(sap.get(0).get("Menutext"));
		logReport("INFO", "Menubar value is selected");
		waitTill("6");
	}

	public void verifyStatusCompleted() throws Exception {
		waitTill("6");
		String actual = getStatusBarValue();
		if (actual.contains("Dcomplete")) {
			logReport("PASS", "The document is completed");
		} else {
			logReport("FAIL", "The document is not completed");
		}

	}

	public void SaveOrder() throws Exception {
		try {
			leanFtButtonClick(btn_save, "Save");
			waitTill("6");
			Button continueButton = session
					.describe(Window.class,
							new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW)
							.build())
					.describe(Button.class, new ButtonDescription.Builder().name("btn[0]")
							.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build());
			if (continueButton.exists()) {
				leanFtButtonClick(btn_continue, "continue");
			}
			waitTill("6");
			if (session
					.describe(Window.class,
							new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW)
							.build())
					.describe(Button.class, new ButtonDescription.Builder().name("SPOP-VAROPTION1")
							.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build())
					.exists()) {
				leanFtButtonClick(btn_orderSave, "Save");

			}
			orderNumber = getStatusBarValue();
			if (orderNumber.contains("Aria")) {
				leanFtEnter();
				waitTill("6");
				logReport("INFO", "The status of oreder is " + getStatusBarValue());
			}
			orderNumber = getStatusBarValue();
			orderNumber = orderNumber.replaceAll("[^0-9]", "");
			logReport("PASS", "The created salesOrder number is " + orderNumber);
			createdOrder = orderNumber;
		} catch (Exception e) {
			leanFtButtonClick(btn_orderSave, "Save");
			waitTill("6");
			orderNumber = getStatusBarValue();
			orderNumber = orderNumber.replaceAll("[^0-9]", "");
			logReport("PASS", "The created salesOrder number is " + orderNumber);
		}

	}

	public void selectCreatedOrder() throws Exception {
		leanFtSendKeys(txt_order, orderNumber);
		// leanFtSendKeys(txt_order, " 52749150");
		leanFtEnter();
		waitTill("6");
		selectContinue();
		logReport("INFO", "The order number " + orderNumber + " entered");
	}

	public void verifyAcceptanceDate() throws Exception {
		EditField acceptanceDateEditField = session.describe(EditField.class, new EditFieldDescription.Builder()
				.name("VEDA-VABNDAT").type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
		String actual = acceptanceDateEditField.getText().trim();
		System.out.println("The actual date is " + actual);
		if (actual.equalsIgnoreCase(date)) {
			logReport("PASS", "The acceptance date is verified successfully");
		} else {
			logReport("INFO", "The accpetance date is not updated");
		}
	}

	public void addMaterial(String sheetName) throws Exception {
		waitTill("6");
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		Table material = selectTable("OrderTabVA41");
		for (int i = 0; i < material.getRows().size(); i++) {
			if (material.getRows().get(i).getCell("Material").getValue().equalsIgnoreCase(" ")
					|| material.getRows().get(i).getCell("Material").getValue().equalsIgnoreCase(null)
					|| material.getRows().get(i).getCell("Material").getValue().isEmpty()) {
				System.out.println(sap.get(0).get("material"));
				material.getRows().get(i).getCell("HgLvIt").setValue("1000");
				material.getRows().get(i).getCell("Material").setValue(sap.get(0).get("material"));
				material.getRows().get(i).getCell("Target quantity").setValue("1");
				break;
			}
		}
		logReport("INFO", "The material is added");
		leanFtEnter();
		waitTill("6");
		Button continueButton = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW).build())
				.describe(Button.class, new ButtonDescription.Builder().name("btn[0]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build());
		while (continueButton.exists()) {
			leanFtButtonClick(btn_continue, "continue");
			waitTill("6");
		}
	}

	public void selectNewLineItem(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		Table material = selectTable(sap.get(0).get("tableName"));
		material.highlight();
		for (int i = 0; i < material.getRows().size(); i++) {
			if (material.getRows().get(i).getCell("Material").getValue().equalsIgnoreCase(sap.get(0).get("material"))
					&& (material.getRows().get(i).getCell("Item").getValue()
							.equalsIgnoreCase(sap.get(0).get("item")))) {
				material.activateCell(i + 1, "Material");
				logReport("PASS", "The newly added material selected ");
				break;
			}
		}

	}

	public void updatedOrder() throws Exception {
		leanFtButtonClick(btn_save, "Save");
		waitTill("6");
		StatusBar statusBar = session.describe(StatusBar.class,
				new StatusBarDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.STATUSBAR).build());
		statusBar.highlight();
		String status = statusBar.getText().trim();
		logReport("INFO", "The status is updated as " + status);
		orderNumber = status;
		orderNumber = orderNumber.replaceAll("[^0-9]", "");
		logReport("PASS", "The created salesOrder number is " + orderNumber);

	}

	public void verifyWBSValues() throws Exception {
		String wbsvalue = "Q-00" + orderNumber + ".001000";
		System.out.println("Acutal value " + wbsvalue);
		String statusText;
		EditField wBSElementEditField = session.describe(EditField.class, new EditFieldDescription.Builder()
				.name("COBL-PS_POSID").type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
		WBSNumber = wBSElementEditField.getText().trim();
		System.out.println("Expected value " + WBSNumber);
		do {
			if (!WBSNumber.isEmpty() && WBSNumber.equalsIgnoreCase(wbsvalue)) {
				logReport("INFO", "WBS value is verified" + wBSElementEditField.getText());
			} else {
				logReport("INFO", "The WBS value is empty");
			}
			leanFtButtonClick(btn_next, "next button");
			StatusBar statusBar = session.describe(StatusBar.class,
					new StatusBarDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.STATUSBAR).build());
			statusText = statusBar.getText().trim();
		} while (!statusText.contains("There are no more items to be displayed"));

	}

	public void SelectWBSValue() throws Exception {
		EditField wBSElementEditField = session.describe(EditField.class, new EditFieldDescription.Builder()
				.name("COBL-PS_POSID").type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
		String expected = wBSElementEditField.getText().trim();
		if (expected.isEmpty()) {
			leanFtButtonClick(back_btn, "Back button");
		}
		wBSElementEditField.setFocus();
		LeanFTBaseLib.doubleclick();
		logReport("INFO", "The WBS value " + expected + " is selected");
		leanFtButtonClick(btn_continue, "Continue");
	}

	public void verifyResultkey() throws Exception {
		EditField resultsAnalysisKeyEditField = session.describe(EditField.class, new EditFieldDescription.Builder()
				.name("PRPS-ABGSL").type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
		String actual = resultsAnalysisKeyEditField.getText().trim();
		if (actual.equalsIgnoreCase("CS-CON")) {
			logReport("PASS", "The Result key analysis is validated " + actual);
		} else {
			logReport("INFO", "The Result key analysis is not verified");
		}
	}

	public void enterSalesDoc() throws Exception {
		waitTill("6");
		leanFtSendKeys(txt_salesDocument, orderNumber);
		leanFtButtonClick(btn_testExecute, "Execute");
		logReport("INFO", "The sales order number is entered");
	}

	public void enterReferenceDoc() throws Exception {
		waitTill("6");
		leanFtSendKeys(txt_salesDocument, contractNumber);
		leanFtButtonClick(btn_testExecute, "Execute");
		logReport("INFO", "The sales order number is entered");
	}

	public void selectCheckBox() throws Exception {
		CheckBox sAPGuiCheckBox = session.describe(CheckBox.class, new CheckBoxDescription.Builder().name("")
				.type(com.hp.lft.sdk.sap.gui.ComponentType.CHECK_BOX).build());
		sAPGuiCheckBox.set(true);
	}

	public void selectReleaseSave() throws Exception {
		selectCheckBox();
		leanFtButtonClick(btn_flag, "Flag selected");
		leanFtButtonClick(btn_save, "Save the document");
		waitTill("6");
		logReport("INFO", "The flag is set and saved the project");
	}

	public void verifyDocument(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		Label label = session.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[0]/usr/lbl[1,3]")
				.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		Label hasBeenReleasedLabel = session.describe(Label.class, new LabelDescription.Builder()
				.relativeId("wnd[0]/usr/lbl[12,3]").type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		String documentSataus = hasBeenReleasedLabel.getText().trim();
		String actual = label.getText().trim();
		if (actual.equalsIgnoreCase(sap.get(0).get("shipTo"))) {
			logReport("PASS", "The documnet value is verified " + actual);
		} else {
			logReport("PASS", "The documnet value not is verified " + actual);
		}
		if (documentSataus.equalsIgnoreCase("has been released")) {
			logReport("PASS", "The documnet value is verified " + documentSataus);
		} else {
			logReport("PASS", "The documnet value not is verified " + documentSataus);
		}
		leanFtButtonClick(back_button, "Back button");
		leanFtButtonClick(back_button, "Back button");
		leanFtButtonClick(btn_yes, "Select to continue");
		waitTill("6");
	}

	public ToolBar selectToobar() throws Exception {
		waitTill("6");
		Window menu = selectwindow("MenuBarWindow");
		ToolBar toolBarControlToolBar = menu.describe(ToolBar.class, new ToolBarDescription.Builder().name("shell")
				.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_TOOL_BAR).index(0).build());
		return toolBarControlToolBar;
	}

	public void enterWBSElement() throws Exception {
		waitTill("6");
		Window menu = selectwindow("MenuBarWindow");
		ToolBar toolBarControlToolBar = menu.describe(ToolBar.class, new ToolBarDescription.Builder().name("shell")
				.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_TOOL_BAR).index(0).build());
		toolBarControlToolBar.pressButton("OPEN");
		projectNumber = WBSNumber.split("\\.")[0];
		leanFtSendKeys(txt_projectWBS, projectNumber);
		logReport("INFO", "The WBS value " + projectNumber + "is entered");
		leanFtButtonClick(btn_continue, "Continue");
	}

	public void selectProjectRelease() throws Exception {
		treeView(1);
		waitTill("6");
		MenuBar("Edit;Status;Release");
		waitTill("6");
	}

	public void saveandVerifyProject() throws Exception {
		leanFtButtonClick(btn_save, "Save");
		waitTill("6");
		String actual = getStatusBarValue();
		if (actual.contains(WBSNumber)) {
			logReport("PASS", "The status value is updated with WBS value");
		}
	}

	public void enterProjDescription() throws Exception {
		waitTill("6");
		leanFtSendKeys(txt_projDescription, "Q-00" + orderNumber);
		// leanFtSendKeys(txt_projDescription, "Q-0052698687");
		logReport("INFO", "The project description number is entered as Q-00" + orderNumber);
		leanFtEnter();
	}

	public void verifySystemStatus() throws Exception {
		waitTill("6");
		Table system = selectTable("projectDef");
		scrolltoRight();
		for (int i = 0; i < system.getRows().size(); i++) {
			if (!system.getRows().get(i).getCell("System status").getValue().isEmpty()
					&& system.getRows().get(i).getCell("System status").getValue().startsWith("REL")) {
				logReport("PASS",
						"The system status is verified" + system.getRows().get(i).getCell("System status").getValue());
				break;
			} else {
				logReport("INFO", "The system status is not verified");
			}

		}

	}

	public void enterMaterial(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		leanFtSendKeys(txt_material, sap.get(0).get("material"));
		leanFtEnter();
	}

	public void selectView() throws Exception {
		waitTill("6");
		Table view = selectTable("selectView");
		int row;
		row = getRowNumber(view, "View", "Classification");
		view.selectRow(row + 1);
		leanFtButtonClick(btn_continue, "continue");
		logReport("INFO", "The select view value is selected");
	}

	public void selectClassType() throws Exception {
		Label materialClassLabel = session.describe(Label.class, new LabelDescription.Builder()
				.relativeId("wnd[1]/usr/lbl[1,3]").type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		materialClassLabel.setFocus();
		leanFtButtonClick(btn_continue, "continue");
		logReport("INFO", "The class type value is selected");
	}

	public void verifyAssignments() throws Exception {
		Table assign = selectTable("Assignments");
		if (!assign.getRows().get(0).getCell("Class").getValue().isEmpty()) {
			logReport("PASS",
					"The assignment value is available " + assign.getRows().get(0).getCell("Class").getValue());
		} else {
			logReport("INFO", "The assignment value is not available");
		}
	}

	public void getSreviceNumber() throws Exception {
		Table service = selectTable("General");
		scrollDown();
		service.highlight();
		System.out.println("enteres service table and size is " + service.getRows().size());
		for (int i = 0; i < service.getRows().size(); i++) {
			if (service.getRows().get(i).getCell("Value").getValue().contains("Invoice")) {
				ServiceNumber = service.getRows().get(i + 1).getCell("Value").getValue();
				logReport("INFO", "The generated service number is " + ServiceNumber);
				break;
			} else
				logReport("INFO", "The generated service number is not available");
		}

	}

	public void selectAriaReplication(String AriaReplication) throws Exception {
		TreeView texttree = treeView(1);
		texttree.selectNode(AriaReplication);
		texttree.activateNode(AriaReplication);
		logReport("INFO", AriaReplication + " node is selected");
	}

	public void getAriaApplication() throws Exception {
		Editor aria = textArea();
		AriaText = aria.getText();
		logReport("INFO", "The Aria replication content is available " + AriaText);
	}

	public void verifyAriaData() throws Exception {
		Editor aria = textArea();
		String ariaPlan = aria.getText();
		if (AriaText.contains(ariaPlan)) {
			logReport("PASS", "The aria  value is verified " + ariaPlan);
		} else {
			logReport("FAIL", "The aria  value is not availbale " + ariaPlan);
		}
	}

	public void getSoldToNumber() throws Exception {
		EditField soldToPartyEditField = session.describe(EditField.class, new EditFieldDescription.Builder()
				.name("KUAGV-KUNNR").type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
		createdsoldTo = soldToPartyEditField.getText().trim();
		logReport("INFO", "The sold to number is " + soldToPartyEditField);
	}

	public void setMprojectMemberValue() throws Exception {
		Table displayRangeTable = selectTable("displayParner");
		for (int i = 0; i < displayRangeTable.getRows().size(); i++) {
			if (displayRangeTable.getRows().get(i).getCell("Partn.Funct.").getValue()
					.equalsIgnoreCase("Main Project Manager")) {
				displayRangeTable.getRows().get(i).getCell("Partner").setValue("9");
				break;
			}

		}
		logReport("INFO", "The main project value is entered");
	}

	public void verifyAcceptanceDateErrorAndSave() throws Exception {
		leanFtButtonClick(btn_save, "Save");
		waitTill("6");
		leanFtButtonClick(btn_continue, "continue");
		waitTill("6");
		orderNumber = getStatusBarValue();
		logReport("INFO", orderNumber);
		waitTill("6");
		leanFtEnter();
		waitTill("6");
		orderNumber = getStatusBarValue();
		orderNumber = orderNumber.replaceAll("[^0-9]", "");
		logReport("PASS", "The created salesOrder number is " + orderNumber);

	}

	public void completeData() throws Exception {
		Button completeDataButton = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Button.class, new ButtonDescription.Builder().name("btn[2]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build());
		if (completeDataButton.exists()) {
			completeDataButton.click();
			leanFtSendKeys(telephone, "12345678901");
			logReport("INFO", "The telephone number added");
			leanFtButtonClick(back_button, "Back");
			completeDataButton.click();
			leanFtSendKeys(txt_route, "000001");
			logReport("INFO", "The Route number added");
			leanFtButtonClick(back_button, "Back");
		}
	}

	public void enterFildName(String name) throws Exception {
		Table fldname = selectTable("FldName");
		waitTill("6");
		// fldname.activateCell(1, "Fr.Value");
		waitTill("6");
		for (int i = 0; i < fldname.getRows().size(); i++) {
			if (fldname.getRows().get(i).getCell("FLD name").getValue().equalsIgnoreCase(name)) {
				fldname.getRows().get(i).getCell("Fr.Value").setValue("*" + orderNumber + "*");
				break;
			}

		}
		logReport("INFO", orderNumber + " Number is Entered");
	}

	public void selectExecute() throws Exception {
		waitTill("6");
		leanFtButtonClick(btn_testExecute, "Execute");
	}

	public void verifyTable() throws Exception {
		Grid path = selectGrid("ZUT grid");
		path.highlight();
		logReport("INFO", "The table values are present");
	}

	public void selectVariant(String varName) throws Exception {
		leanFtButtonClick(btn_displayDocument, "display variants");
		waitTill("6");
		Grid path = selectGrid("variant type");
		for (int i = 0; i < path.getRows().size(); i++) {
			if (path.getRows().get(i).getCell("Variant name").getValue().equalsIgnoreCase(varName)) {
				path.selectRow(i + 1);
			}
		}

		logReport("INFO", "The vriant " + varName + " is selected");
		leanFtButtonClick(btn_search, "select");

	}
	public static Window selectionDate_Window() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, selectionDate_Window);
		return window;

	}
	public void enterpackageValue() throws Exception {
		waitTill("6");
		leanFtSendKeys(txt_package, "4");
		logReport("INFO", "The package values is enter");
		leanFtButtonClick(btn_testExecute, "Execute");
	}

	public void selectPoDate() throws Exception {
		leanFtSendKeys(txt_PODate, null);
		waitTill("6");
		leanFtEnter();

	}

	public void selectContinue() throws Exception {
		for (int i = 0; i < 5; i++) {
			if (session
					.describe(Window.class,
							new WindowDescription.Builder().name("wnd[1]")
							.type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW).build())
					.describe(Button.class, new ButtonDescription.Builder().name("btn[0]")
							.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build())
					.exists()) {

				leanFtButtonClick(btn_continue, "Continue");
				waitTill("6");
			} else {
				break;
			}
		}
	}

	public void selectdisplayDocument() throws Exception {
		leanFtButtonClick(back_button, "Back");
		try {
			leanFtButtonClick(btn_displayDocument, "Display document");
		} catch (GeneralLeanFtException e) {
			logReport("INFO", "The document is displayed");
		}

	}

	public void documentFlowVerification() throws Exception {
		selectdisplayDocument();
		ToolBar toolBarControlToolBar = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(ToolBar.class, new ToolBarDescription.Builder().name("shell[0]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_TOOL_BAR).build());
		toolBarControlToolBar.pressButton("&FIND");
		waitTill("6");
		leanFtSendKeys(cell_content, "Open");
		waitTill("6");
		selectContinue();
		leanFtButtonClick(btn_testExecute, "Display document");

		try {
			Table materials = selectTable("documentTable");
			materials.highlight();
			logReport("INFO", "The document is generated");
		} catch (Exception e) {
			int i = 1;
			while (i <= 10) {
				logReport("INFO", "The document is not yet generated");
				waitTill("60");
				documentFlowVerification();
			}
		}

	}

	public void entercatsData(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		leanFtSendKeys(txt_DEProfile, sap.get(0).get("ProfileNumber"));
		leanFtSendKeys(txt_personalNumber, sap.get(0).get("PersonalNumber"));
		leanFtEnter();
		waitTill("6");
		leanFtSendKeys(date_keyDate, sap.get(0).get("keyDate"));
		logReport("INFO", "The prfole number and personal number entered");
		leanFtButtonClick(btn_execute, "Execute");
	}

	public void verifyActCodeAndAttCode(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		waitTill("6");
		Table dataEntry = selectTable("catstable");
		dataEntry.highlight();

		for (int i = 3; i < dataEntry.getRows().size(); i++) {
			if (dataEntry.getRows().get(i).getCell("ActTyp").getValue().contains(sap.get(0).get("activityCode"))
					&& dataEntry.getRows().get(i).getCell("A/AType").getValue()
					.contains(sap.get(0).get("activityType"))) {
				logReport("PASS", "The Activity code and Activity type is matched");
				break;
			} else {
				logReport("FAIL", "The Activity code and Activity type is not matched");
			}
		}
	}

	public void enterTname(String tName) throws Exception {
		waitTill("6");
		leanFtSendKeys(table_name, tName);
		leanFtEnter();

	}

	public void enterCreatedDate(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		Table dataEntry = selectTable("FldName");
		for (int i = 0; i < dataEntry.getRows().size(); i++) {
			if (dataEntry.getRows().get(i).getCell("Fld name").getValue().equalsIgnoreCase(sap.get(0).get("created"))) {
				dataEntry.getRows().get(i).getCell("Fr.Value").setValue(sap.get(0).get("keyDate"));
				break;
			}

		}

	}

	public void enterPersonalID(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		Table dataEntry = selectTable("FldName");
		for (int i = 0; i < dataEntry.getRows().size(); i++) {
			if (dataEntry.getRows().get(i).getCell("Fld name").getValue()
					.equalsIgnoreCase(sap.get(0).get("personalNum"))) {
				dataEntry.getRows().get(i).getCell("Fr.Value").setValue(sap.get(0).get("PersonalNumber"));
				break;
			}
		}

	}

	public void verifyActCodeAndActType(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		Grid dataEntry = selectGrid("ZUT grid");
		for (int i = 0; i < dataEntry.getRows().size(); i++) {
			if (dataEntry.getRows().get(i).getCell("Activity Type").getValue().contains(sap.get(0).get("activityCode"))
					&& dataEntry.getRows().get(i).getCell("Att./Absence type").getValue()
					.contains(sap.get(0).get("activityType"))) {
				logReport("PASS", "The Activity code and Activity type is matched");
				break;
			} else {
				logReport("FAIL", "The Activity code and Activity type is not matched");
			}
		}

	}

	public void verifydocumentCategory(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		Table materials;
		if (selectTable("OrderTabVA41").exists()) {
			materials = selectTable("OrderTabVA41");
		} else {
			materials = selectTable("documentTable");
		}
		for (int i = 0; i < materials.getRows().size(); i++) {
			if (materials.getRows().get(i).getCell("Material").getValue()
					.equalsIgnoreCase(sap.get(0).get("material"))) {
				materials.getRows().get(i).getCell("ItCa").getValue().equalsIgnoreCase(sap.get(0).get("YVvalue"));
				logReport("PASS", "The Item category value is  verified "
						+ materials.getRows().get(i).getCell("ItCa").getValue());
				break;
			}
		}
	}

	public void verifyPODate() throws Exception {
		EditField podate = selecteditname("PODate");
		if (podate.getText().equalsIgnoreCase(date)
				|| podate.getText().equalsIgnoreCase(currentDateValue("dd.MM.yyyy"))) {
			logReport("PASS", "The po date is verified");
		} else {
			logReport("FAIL", "The po date is not verified");
		}
	}

	public void verifyadditionalData(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		EditField processValue = selecteditname("PSS");
		EditField billingvalue = selecteditname("billing");
		EditField shippingvalue = selecteditname("shipment");
		if (processValue.getText().equalsIgnoreCase(sap.get(0).get("process"))
				&& billingvalue.getText().equalsIgnoreCase(sap.get(0).get("billing"))
				&& shippingvalue.getText().equalsIgnoreCase(sap.get(0).get("Indicator"))) {
			logReport("PASS", "The  process value,billing value and Indicator values are verified");
		} else {
			logReport("FAIL", "The  process value,billing value and Indicator values not  verified");
		}

	}

	public void verifyConditionGroup() throws Exception {
		String value = "11-Chapter net";
		ComboBox conditionGroup1ComboBox = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(ComboBox.class, new ComboBoxDescription.Builder().name("VBKD-KDKG1").selectedItem(value)
						.type(com.hp.lft.sdk.sap.gui.ComponentType.COMBO_BOX).build());
		conditionGroup1ComboBox.exists();
		logReport("PASS", "The condition group values is updated as " + value);
	}

	public void selectnewRow() throws Exception {
		waitTill("6");
		leanFtButtonClick(btn_newRow, "Insert New Row");

	}

	public void enterQuantity(String conditionName, String amount) throws Exception {
		Table condition = selectTable("Conditions");
		for (int i = 0; i < condition.getRows().size(); i++) {
			if (condition.getRows().get(condition.getRows().size() - 1).getCell("CnTy").getValue().isEmpty()
					|| condition.getRows().get(i).getCell("CnTy").getValue().equalsIgnoreCase(null)) {
				condition.getRows().get(condition.getRows().size() - 1).getCell("CnTy").setValue(conditionName);
				System.out.println("amount is " + amount);
				condition.getRows().get(condition.getRows().size() - 1).getCell("Amount").setValue(amount);
				break;
			}
		}
		logReport("INFO", "The item " + conditionName + " is added");
		leanFtEnter();

	}

	public void changePeriodicYr() throws Exception {
		waitTill("6");
		leanFtSendKeys(periodic_yr, "53");
		logReport("INFO", "Contract periodic year value is updated" + periodic_yr.getText());

	}

	public void naviagtetomainPage(String table) throws Exception {
		leanFtButtonClick(back_button, "back");
		Table material = selectTable(table);
		for (int i = 0; i < 10; i++) {
			try {
				if (material.exists()) {
					break;
				} else {
					leanFtButtonClick(back_button, "back");
				}
				if (selectButton("continue").exists()) {
					Button con = selectButton("continue");
					con.click();
				} else {
					break;
				}

			} catch (Exception e) {
				if (selectButton("save").exists()) {
					leanFtButtonClick(btn_yes, "Save");
				} else {
					Button con = selectButton("continue");
					con.click();
				}
			}
		}
		logReport("INFO", "The materials table is identified");
	}

	public void selectProjectmanager() throws Exception {
		Table displayRangeTable = selectTable("displayParner");
		for (int i = 0; i < displayRangeTable.getRows().size(); i++) {
			if (displayRangeTable.getRows().get(i).getCell("Partn.Funct.").getValue()
					.equalsIgnoreCase("Main Project Manager")) {
				displayRangeTable.selectRow(i + 1);
				break;
			}

		}
		logReport("INFO", "THe project manager row is selected");
		leanFtButtonClick(btn_detail, "detail button");
	}

	public void enterManagerDetails(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		EditField telephoneNum = selecteditname("telephone");
		EditField mobileNum = selecteditname("mobile");
		EditField emailAddr = selecteditname("email");
		telephoneNum.setText(sap.get(0).get("mobile"));
		mobileNum.setText(sap.get(0).get("mobile"));
		emailAddr.setText("abc@gmail.com");
		leanFtButtonClick(btn_continue, "continue");
		waitTill("6");
		logReport("INFO", "The Manager mail and mobile details Entered");
	}

	public void enterOrderDetails(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		leanFtSendKeys(orderType_txt, sap.get(0).get("contractType"));
		leanFtSendKeys(txt_organisation, sap.get(0).get("org"));
		leanFtSendKeys(txt_channel, sap.get(0).get("channel"));
		leanFtSendKeys(txt_division, sap.get(0).get("division"));
		logReport("INFO", "The order details are entered");
	}

	public void enterRefContract() throws Exception {
		leanFtSendKeys(txt_contract, orderNumber);
		// leanFtSendKeys(txt_contract, "52748674");
		logReport("INFO", "The created contract number entered " + orderNumber);
		leanFtButtonClick(btn_itemselection, "item selection");
		waitTill("6");
		leanFtButtonClick(btn_displaydoc, "Copy the materials");
		Button continueEnterButton = session.describe(Button.class, new ButtonDescription.Builder().name("btn[0]")
				.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build());
		for (int i = 0; i < 10; i++) {
			if (continueEnterButton.exists()) {
				leanFtButtonClick(btn_continue, "Continue");
				selectreferenceValues();
			} else {
				break;
			}

		}
	}

	public void enterTagetValue() throws Exception {
		leanFtSendKeys(txt_targetValue, "1");
		logReport("INFO", "The target value is Entered");
		leanFtButtonClick(back_button, "back");
	}

	public void addNewMaterial(String sheetName) throws Exception {
		waitTill("6");
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		Table material = selectTable(sap.get(0).get("tableName"));
		material.highlight();
		for (int i = 0; i < material.getRows().size(); i++) {

			if (material.getRows().get(i).getCell("Material").getValue().equalsIgnoreCase(" ")
					|| material.getRows().get(i).getCell("Material").getValue().equalsIgnoreCase(null)
					|| material.getRows().get(i).getCell("Material").getValue().isEmpty()) {
				material.getRows().get(i).getCell("Material").setValue(sap.get(0).get("material"));
				material.getRows().get(i).getCell("Order Quantity").setValue("1");
				break;
			}
		}
		logReport("INFO", "The material is added");
		leanFtEnter();
		waitTill("6");
		Button continueButton = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW).build())
				.describe(Button.class, new ButtonDescription.Builder().name("btn[0]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build());
		while (continueButton.exists()) {
			leanFtButtonClick(btn_continue, "continue");
			waitTill("6");
		}
		leanFtButtonClick(back_button, "back");
	}

	public void verifyConditions() throws Throwable {

		Table conditionsTable = selectTable("Conditions");
		for (int i = 0; i < conditionsTable.getRows().size(); i++) {
			if (conditionsTable.getRows().get(i).getCell("CnTy").getValue().contains("ZA01")) {
				logReport("PASS", "The ZA01 values are verified");
				break;
			} else {
				logReport("FAIL", "The ZA01 values are not  verified");
			}
			if (conditionsTable.getRows().get(i).getCell("CnTy").getValue().contains("YADJ")) {
				logReport("PASS", "The YADJ values are verified");
				break;
			}
		}
		leanFtButtonClick(back_button, "back");
		waitTill("6");
	}

	public void addRouteValue() throws Exception {
		int i = 1;
		Button completeDataButton = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Button.class, new ButtonDescription.Builder().name("btn[2]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build());
		while (i < 4) {
			if (completeDataButton.exists()) {
				completeDataButton.click();
				leanFtSendKeys(txt_route, "000001");
				logReport("INFO", "The Route number added");
				leanFtButtonClick(back_button, "Back");

			} else {
				break;
			}
		}
	}

	public void selectcreatedReferenceContract() throws Exception {
		selectdisplayDocument();
		ToolBar toolBarControlToolBar = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(ToolBar.class, new ToolBarDescription.Builder().name("shell[0]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_TOOL_BAR).build());
		toolBarControlToolBar.pressButton("&FIND");
		waitTill("6");
		leanFtSendKeys(cell_content, createdOrder);
		waitTill("6");
		selectContinue();
		leanFtButtonClick(btn_testExecute, "Display document");
	}

	public void changeItemCategory(String sheetName, String itemCategory) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		Table material = selectTable(sap.get(0).get("tableName"));
		for (int i = 0; i < material.getRows().size(); i++) {
			if (material.getRows().get(i).getCell(sap.get(0).get("column")).getValue().equalsIgnoreCase(itemCategory)) {
				material.getRows().get(i).getCell(sap.get(0).get("column")).setValue(sap.get(0).get("newItemvalue"));
				break;
			}
		}
		logReport("INFO", "The " + itemCategory + " is updated");
	}

	public void SavePopup() throws Exception {
		leanFtButtonClick(btn_yes, "Save");
		leanFtButtonClick(btn_continue, "Continue");
		orderNumber = getStatusBarValue();
		orderNumber = orderNumber.replaceAll("[^0-9]", "");
		logReport("PASS", "The created salesOrder number is " + orderNumber);
		createdOrder = orderNumber;
	}

	public void enterProgramvalues(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		leanFtSendKeys(txt_salesorg, sap.get(0).get("org"));
		leanFtSendKeys(txt_documentType, sap.get(0).get("contractType"));
		leanFtSendKeys(txt_programDate, currentDateValue("dd.MM.yyyy"));
		leanFtButtonClick(btn_testExecute, "Execute");
		logReport("INFO", "Program table values are entered");
		waitTill("6");
		logReport("INFO", "The contract number and document details entered");
		leanFtButtonClick(back_button, "back button");
	}

	public void enterProgram_documentDetails() throws Exception {
		leanFtSendKeys(org, "US90");
		leanFtSendKeys(contract, orderNumber);
		waitTill("6");
		logReport("INFO", "The contract number and document details entered");
	}

	public void enterSetlementWBS() throws Exception {
		leanFtSendKeys(txt_salesDocumnet, " ");
		leanFtSendKeys(txt_projectNum, "Q-00" + orderNumber);
		leanFtSendKeys(txt_wbsNum, " ");
		String date = currentDateValue("dd.MM.yyyy");
		String[] actual = date.split("\\.");
		String year = actual[2].substring(Math.max(actual[2].length() - 2, 0));
		System.out.println("month is " + actual[1] + " and year is " + year);
		leanFtSendKeys(txt_period, actual[1]);
		leanFtSendKeys(txt_fiscalyr, year);
		CheckBox test = checkBox("TestRun");
		test.set(false);
		CheckBox chkDetail = checkBox("details");
		chkDetail.set(true);
		logReport("INFO", "The SettlementWBS values are entered");
		leanFtButtonClick(btn_testExecute, "Execute");
	}

	public void verifyProcessedValues() throws Exception {
		Label process = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[0]/usr/lbl[0,11]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		if (process.getText().equalsIgnoreCase("Processing completed without errors")) {
			logReport("PASS", "The process completion message is verified");
		} else {
			logReport("INFO", "The process not completed without errors");
		}
		Label label = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[0]/usr/lbl[53,17]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		logReport("PASS", "The process value is " + label.getText());
	}

	public void selectWBSValues(String name) throws Exception {
		Table wbs = selectTable(name);
		try {
			for (int i = 0; i < wbs.getRows().size(); i++) {
				if (!wbs.getRows().get(i).getCell("WBS element").getValue().equalsIgnoreCase(" ")) {
					wbs.selectRow(i + 1);
				}
			}
			leanFtButtonClick(btn_settlementRule, "Settlement rule");

		} catch (Exception e) {
			logReport("INFO", "All WBS values are selected");
			leanFtButtonClick(btn_settlementRule, "Settlement rule");
		}
	}

	public void verifyDistributionValues(String tableName, String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		Table distribution = selectTable(tableName);
		System.out.println(distribution.getRows().get(0).getCell("Cat").getValue());
		System.out.println(distribution.getRows().get(0).getCell("%").getValue());
		if (distribution.getRows().get(0).getCell("Cat").getValue().equalsIgnoreCase(sap.get(0).get("catValue"))
				&& distribution.getRows().get(0).getCell("%").getValue()
				.equalsIgnoreCase(sap.get(0).get("percentage"))) {
			logReport("PASS", "The cat and % value is verified");
		} else {
			logReport("FAIL", "The cat and % value is not verified");
		}

	}

	public void select_logicalPSI() throws Exception {
		keyboardclick();
		Label psjValue = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[2]/usr/lbl[1,15]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		Label psjText = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW).build())
				.describe(Label.class,
						new LabelDescription.Builder().relativeId("wnd[2]/usr/lbl[14,15]")
						.vri(new VisualRelation().setTestObject(psjValue)
								.setHorizontalRelation(HorizontalVisualRelation.LEFT_AND_INLINE))
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		psjText.setFocus();
		leanFtButtonClick(btn_continue, "continue");
		waitTill("6");
		leanFtButtonClick(btn_continue, "continue");
	}

	public void execute_PMselection() throws Exception {
		leanFtSendKeys(txt_network, " ");
		leanFtButtonClick(btn_testExecute, "Execute");
		logReport("INFO", "The network value made empty and executed");
	}

	public void verifyWBSObject() throws Exception {
		TreeView wbs = treeView(1);
		TreeView tableTreeControlTreeView = session.describe(TreeView.class, new TreeViewDescription.Builder().index(0)
				.name("shell").type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_TREE).build());
		String path = tableTreeControlTreeView.buildNodePath(1);
		tableTreeControlTreeView.activateNode(path);
		wbs.pressEnter();
		Label label = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[0]/usr/lbl[94,13]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		if (!label.getText().isEmpty()) {
			logReport("PASS", "The plan value is " + label.getText());
		} else {
			logReport("FAIL", "The plan value is empty");
		}
	}

	public void enterBlockValue() throws Exception {
		Table datesTable = selectTable("billing items");
		datesTable.getRows().get(0).getCell("Block").setValue(" ");
		logReport("INFO", "The block value is made as empty");
	}

	public void saveBillingDoc() throws Exception {
		waitTill("6");
		logReport("INFO", "Waiting for prcoess to completed....");
		Table billingVal = selectTable("billing document");
		billingVal.getRows().get(0).getCell("Document").setValue(" ");
		waitTill("6");
		billingVal.getRows().get(0).getCell("Document").setValue(creditOrder);
		leanFtEnter();
		leanFtEnter();
		if (selectTable("billingItem").exists()) {
			Table billing = selectTable("billingItem");
			if (billing.getRows().get(0).getCell("Net value").getValue().equalsIgnoreCase("0,00")
					&& billing.getRows().get(0).getCell("Cost").getValue().equalsIgnoreCase("0,00")) {
				logReport("PASS", "The net value and cost value is verified");
			} else {
				logReport("INFO",
						"The net value and cost value is  " + billing.getRows().get(0).getCell("Net value").getValue());
			}
			EditField net = selecteditname("netValue");
			String netvalue = net.getText();
			netvalue = netvalue.replaceAll("[^0-9]", "");
			int value = Integer.parseInt(netvalue);
			if (value > 0) {
				logReport("PASS", "The net value is " + netvalue);
			}
		}
		leanFtButtonClick(btn_save, "save");
		documentNumber = getStatusBarValue();
		documentNumber = documentNumber.replaceAll("[^0-9]", "");
		logReport("INFO", "The documnet saved successfully " + documentNumber);
	}

	public void enterpSCONdetails(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		leanFtSendKeys(pscon_contract, orderNumber);
		leanFtSendKeys(pscon_item, sap.get(0).get("psconItem"));
		leanFtSendKeys(pscon_shipTo, sap.get(0).get("shipTo"));
		leanFtEnter();
		waitTill("6");
		leanFtButtonClick(btn_testExecute, "Execute");
		waitTill("4");
		logReport("INFO", "The contract and ship to values Entered and executed");
	}

	public void assignEquipmentTocontract() throws Exception {
		Grid value = selectGrid("ZUT grid");
		value.selectRow(1);
		leanFtButtonClick(btn_printPreview, "Execute");
		waitTill("15");
		logReport("INFO", "The equipment assigned to Contract");
	}

	public void Material(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		Table value = selectTable("OrderTabVA41");
		for (int i = 0; i < value.getRows().size(); i++) {
			if (value.getRows().get(i).getCell("Item").getValue().equalsIgnoreCase("1020")) {
				value.selectRow(i + 1);
				break;
			}
		}
	}

	public void verifyequipmentInContract() throws Exception {
		MenuBar("Extras;Technical objects");
		if (selectTable("technical object").exists()) {
			logReport("INFO", "The equipment added to the contract and displayed");
		} else {
			logReport("INFO", "The equipment not added to the contract");
		}
	}

	public void un_assignEquipmentTocontract() throws Exception {
		Grid value = selectGrid("ZUT grid");
		value.selectRow(1);
		leanFtButtonClick(unassign, "Execute");
		waitTill("15");
		if (session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW).build())
				.describe(Button.class, new ButtonDescription.Builder().name("btn[0]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build())
				.exists()) {
			leanFtButtonClick(btn_ok, "continue");
		}
		logReport("INFO", "The equipment unassigned to Contract");
	}

	public void enterAceeptance_route() throws Exception {
		leanFtSendKeys(txt_route, "000001");
		logReport("INFO", "The Route number added");
		leanFtButtonClick(back_button, "Back");
		waitTill("6");
		leanFtButtonClick(btn_search, "search");
		leanFtSendKeys(txt_acceptanceDate, currentDateValue("dd.MM.yyyy"));
		logReport("INFO", "The Acceptance date is  added");
	}

	public void verifyAccountingDocumnet() throws Exception {
		leanFtButtonClick(btn_execute, "Accounting");
		Grid value = selectGrid("ZUT grid");
		try {
			documnet_number = value.getRows().get(1).getCell("Doc. Number").getValue();
			logReport("INFO", "The documnet number is " + documnet_number);
			value.activateCell(1, "Doc. Number");
			Label label = session
					.describe(Window.class,
							new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
							.build())
					.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[0]/usr/lbl[85,12]")
							.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
			if (label.getText() != "0") {
				logReport("PASS", "Th AMount value is verified and not equal to zero " + label.getText());

			} else {
				logReport("INFO", "Th AMount value is verified and  equal to zero " + label.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void verifycreatedDocuments() throws Exception {
		leanFtSendKeys(txt_order, orderNumber);
		waitTill("6");
		leanFtButtonClick(btn_displayDocument, "Document display");
		TreeView docs = selectTree();
		docs.activateNode("SCM Quant. Contract 00" + orderNumber);
		if (selectGrid("ZUT grid").exists()) {
			logReport("PASS", "The contract is verified " + orderNumber);
		}

		Robot rt = new Robot();
		rt.keyPress(KeyEvent.VK_DOWN);
		waitTill("6");
		rt.keyRelease(KeyEvent.VK_DOWN);
		logReport("PASS", "The document is verified " + documentNumber);
		waitTill("6");
	}

	public void enterAccountData(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		leanFtSendKeys(txt_companyCode, sap.get(0).get("org"));
		leanFtSendKeys(txt_saleddocType, sap.get(0).get("contractType"));
		leanFtSendKeys(txt_salesDocNumber, orderNumber);
		String date = currentDateValue("dd.MM.yyyy");
		String[] actual = date.split("\\.");
		String year = actual[2].substring(Math.max(actual[2].length() - 2, 0));
		System.out.println("month is " + actual[1] + " and year is " + year);
		leanFtSendKeys(txt_postingMonth, actual[1]);
		leanFtSendKeys(txt_postingYear, year);
		leanFtButtonClick(btn_testExecute, "Execute");
		logReport("INFO", "The accounting sales documnet details are entered");

	}

	public void updateCollectiveProcessing() throws Exception {
		Grid value = selectGrid("revenue");
		value.selectRow(1);
		Window revenueRecognitionPostRevenueWindow = session.describe(Window.class,
				new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build());
		ToolBar gridToolbarToolBar = revenueRecognitionPostRevenueWindow.describe(ToolBar.class,
				new ToolBarDescription.Builder().name("shell").type(com.hp.lft.sdk.sap.gui.ComponentType.GRID_TOOL_BAR)
				.index(0).build());
		gridToolbarToolBar.pressButton("SAMD");

		waitTill("6");
		logReport("PASS", "The revenue values are updated");
	}

	public void enterRevenue(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		leanFtSendKeys(txt_companyCode, sap.get(0).get("org"));
		leanFtSendKeys(txt_saleddocType, sap.get(0).get("contractType"));
		leanFtSendKeys(txt_salesDocNumber, orderNumber);
		leanFtButtonClick(btn_testExecute, "Execute");
		logReport("INFO", "The accounting sales documnet details are entered");
	}

	public void displayRevenue() throws Exception {
		Grid value = selectGrid("revenue");
		value.selectRow(1);
		Window revenueRecognitionPostRevenueWindow = session.describe(Window.class,
				new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build());
		ToolBar gridToolbarToolBar = revenueRecognitionPostRevenueWindow.describe(ToolBar.class,
				new ToolBarDescription.Builder().name("shell").type(com.hp.lft.sdk.sap.gui.ComponentType.GRID_TOOL_BAR)
				.index(0).build());
		gridToolbarToolBar.pressButton("SHOW_ITEMS_MULTI");
		waitTill("6");
		Grid value1 = selectGrid("revenuedocument");
		if (value1.getRows().get(0).getCell("Currency").getValue().equalsIgnoreCase("USD")) {
			logReport("PASS",
					"The currency value is verified " + value1.getRows().get(0).getCell("Currency").getValue());
		} else {
			logReport("PASS",
					"The currency value is  not verified " + value1.getRows().get(0).getCell("Currency").getValue());
		}
		String txt = value1.getRows().get(0).getCell("Recognized Revenues/Costs").getValue();
		txt = txt.replaceAll("[-+.^:,]", "");
		revenueCost = Integer.parseInt(txt);
		if (revenueCost > 0) {
			logReport("PASS", "The revenue cost  is verified " + revenueCost);
		} else {
			logReport("FAIL", "The  revenue cost  not verified " + revenueCost);
		}

	}

	public void enterSalesDocumnet() throws Exception {
		waitTill("6");
		Table value = selectTable("FldName");
		try {
			value.getRows().get(0).getCell("Fr.Value").setValue(orderNumber);
		} catch (Exception e) {
			for (int i = 0; i < value.getRows().size(); i++) {
				if (value.getRows().get(i).getCell("Fld name").getValue().equalsIgnoreCase("Contr No")) {
					value.getRows().get(i).getCell("Fr.Value").setValue(orderNumber);
					break;
				}
			}
		}
	}

	public void verify_currencyValueinTable() throws Exception {
		Grid table = selectGrid("ZUT grid");
		String txt = table.getRows().get(0).getCell("Revenue Amount").getValue();
		txt = txt.replaceAll("[-+.^:,]", "");
		int currency = Integer.parseInt(txt);
		if (revenueCost == currency) {
			logReport("PASS", "The revenue amount is matched " + currency);
		} else {
			logReport("PASS", "The revenue amount is not matched " + currency);
		}
	}

	public void verifyExecute_type() throws Exception {
		CheckBox test = checkBox("test_checkbox");
		test.set(false);
		CheckBox chkDetail = checkBox("detail_checkbox");
		chkDetail.set(true);
		logReport("INFO", "The SettlementWBS values are entered");
		leanFtButtonClick(btn_testExecute, "Execute");
		Grid table = selectGrid("revenuedocument");
		if (table.getRows().get(0).getCell("Value").getValue().equalsIgnoreCase("Settlement executed")) {
			logReport("PASS", "The execute type is verified " + table.getRows().get(0).getCell("Value").getValue());
		}

	}

	public void addspecial_ChartoCustomer(String sheetName, String specialchar) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		leanFtSendKeys(txt_customer, sap.get(0).get("SoldTo"));
		leanFtButtonClick(btn_continue, "continue");
		EditField customer = selecteditname("customer name");
		customerName = customer.getText();
		customer.setText(customerName + specialchar);
		logReport("INFO", "The customer name is " + customer.getText());
		leanFtButtonClick(btn_save, "Save");
		waitTill("6");
		leanFtButtonClick(bnt_close, "close");

	}

	public void setCustomerName_default(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		leanFtSendKeys(txt_customer, sap.get(0).get("SoldTo"));
		leanFtButtonClick(btn_continue, "continue");
		EditField customer = selecteditname("customer name");
		customer.setText(customerName);
		logReport("INFO", "The customer name is " + customer.getText());
		leanFtButtonClick(btn_save, "Save");
		waitTill("6");
		leanFtButtonClick(bnt_close, "close");
	}

	public void getorderNumber() throws Exception {
		waitTill("6");
		EditField cnumber = selecteditname("contractNumber");
		orderNumber = cnumber.getText();
		logReport("INFO", "The created order number is " + orderNumber);
	}

	public void selectBillingBlock(String option) throws Throwable {
		ComboBox combovalue = selectCombo(option);
		combovalue.selectKey(" ");

		logReport("INFO", "The billing block name set as null");
	}

	public void verify_GLAccountNum() throws Exception {
		leanFtButtonClick(btn_execute, "select accounting");
		Grid value = selectGrid("ZUT grid");
		value.activateRow(1);
		Label label = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[0]/usr/lbl[20,13]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		logReport("INFO", "The GL account number is " + label);

	}

	public void selectbillingContractDetails() throws Exception {
		// leanFtSendKeys(txt_billing, documentNumber);
		leanFtSendKeys(txt_billing, "945167044");
		leanFtButtonClick(btn_displaydoc, "copy");
		for (int i = 0; i < 10; i++) {
			Button continueEnterButton = session
					.describe(Window.class,
							new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW)
							.build())
					.describe(Button.class, new ButtonDescription.Builder().name("btn[0]")
							.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build());
			if (continueEnterButton.exists()) {
				continueEnterButton.click();
			}
		}
		logReport("INFO", "The materials copied from reference document");
	}

	public void orderreasonName(String value, String options) throws Exception {
		ComboBox orderValue = selectCombo(options);
		orderValue.select(value);
		logReport("INFo", "The order value is " + value);
	}

	public void saveCredit() throws Exception {
		try {
			leanFtButtonClick(btn_save, "Save");
			waitTill("6");
			Button continueButton = session
					.describe(Window.class,
							new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW)
							.build())
					.describe(Button.class, new ButtonDescription.Builder().name("btn[0]")
							.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build());
			if (continueButton.exists()) {
				leanFtButtonClick(btn_continue, "continue");
			}
			waitTill("6");
			if (session
					.describe(Window.class,
							new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW)
							.build())
					.describe(Button.class, new ButtonDescription.Builder().name("SPOP-VAROPTION1")
							.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build())
					.exists()) {
				leanFtButtonClick(btn_orderSave, "Save");
				waitTill("6");
				leanFtEnter();
				waitTill("6");
				leanFtEnter();
			}
			creditOrder = getStatusBarValue();
			if (creditOrder.contains("Assignment number")) {
				leanFtEnter();
				waitTill("6");
				leanFtButtonClick(btn_orderSave, "Save");
			}
			waitTill("6");
			creditOrder = creditOrder.replaceAll("[^0-9]", "");
			logReport("PASS", "The created salesOrder number is " + creditOrder);
			createdOrder = creditOrder;
		} catch (Exception e) {
			leanFtButtonClick(btn_orderSave, "Save");
			waitTill("6");
			creditOrder = getStatusBarValue();
			creditOrder = creditOrder.replaceAll("[^0-9]", "");
			logReport("PASS", "The created salesOrder number is " + creditOrder);

		}

	}

	public void get_screenshot() throws Exception {
		selectdisplayDocument();
		embedScreenShotInreportWithRobot();
	}

	public void contractDates() throws Exception {
		String contractEndDat = endDatevalue("d.MM.yyyy", 0, 0, 2);
		leanFtSendKeys(contractstartDate, currentDateValue("d.MM.yyyy"));
		leanFtSendKeys(contractEndDate, contractEndDat);
		waitTill("6");
		leanFtEnter();
		logReport("INFO", "The contract start date and end dates are entered");
	}

	public void save_Contract() throws Exception {
		try {
			leanFtButtonClick(btn_save, "Save");
			waitTill("6");
			Button continueButton = session
					.describe(Window.class,
							new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW)
							.build())
					.describe(Button.class, new ButtonDescription.Builder().name("btn[0]")
							.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build());
			if (continueButton.exists()) {
				leanFtButtonClick(btn_continue, "continue");
			}
			waitTill("6");
			contractNumber = getStatusBarValue();
			contractNumber = contractNumber.replaceAll("[^0-9]", "");
			contractNumber = contractNumber.substring(0, 10);
			System.out.println(contractNumber);
			logReport("PASS", "The created reference contract is " + contractNumber);

		} catch (Exception e) {
			leanFtButtonClick(btn_orderSave, "Save");
			waitTill("6");
			contractNumber = getStatusBarValue();
			contractNumber = contractNumber.replaceAll("[^0-9]", "");
			contractNumber = contractNumber.substring(0, 10);
			System.out.println(contractNumber);
			logReport("PASS", "The created reference contract is " + contractNumber);

		}
	}

	public void enterbillingValue_Save() throws Exception {
		waitTill("120");
		logReport("INFO", "Waiting for prcoess to completed....");
		Table billingVal = selectTable("billing document");
		billingVal.getRows().get(0).getCell("Document").setValue(" ");
		waitTill("6");
		billingVal.getRows().get(0).getCell("Document").setValue(contractNumber);
		leanFtEnter();
		if (selectTable("billingItem").exists()) {
			Table billing = selectTable("billingItem");
			if (billing.getRows().get(0).getCell("Net value").getValue().equalsIgnoreCase("0,00")
					&& billing.getRows().get(0).getCell("Cost").getValue().equalsIgnoreCase("0,00")) {
				logReport("PASS", "The net value and cost value is verified");
			} else {
				logReport("INFO",
						"The net value and cost value is  " + billing.getRows().get(0).getCell("Net value").getValue());
			}
			EditField net = selecteditname("netValue");
			String netvalue = net.getText();
			netvalue = netvalue.replaceAll("[^0-9]", "");
			int value = Integer.parseInt(netvalue);
			if (value > 0) {
				logReport("PASS", "The net value is " + netvalue);
			}
		}
		leanFtButtonClick(btn_save, "save");
		documentNumber = getStatusBarValue();
		documentNumber = documentNumber.replaceAll("[^0-9]", "");
		logReport("INFO", "The documnet saved successfully " + documentNumber);
	}

	public void verify_credit_debit() throws Exception, GeneralLeanFtException, Exception {
		waitTill("120");
		logReport("INFO", "Waiting for prcoess to completed....");
		Table billingVal = selectTable("billing document");
		billingVal.getRows().get(0).getCell("Document").setValue(" ");
		waitTill("6");
		billingVal.getRows().get(0).getCell("Document").setValue(contractNumber);
		leanFtEnter();
		if (selectTable("billingItem").exists()) {
			Table billing = selectTable("billingItem");
			if (billing.getRows().get(0).getCell("Net value").getValue().equalsIgnoreCase("0,00")
					&& billing.getRows().get(0).getCell("Cost").getValue().equalsIgnoreCase("0,00")) {
				logReport("PASS", "The net value and cost value is verified");
			} else {
				logReport("INFO",
						"The net value and cost value is  " + billing.getRows().get(0).getCell("Net value").getValue());
			}
			EditField net = selecteditname("netValue");
			String netvalue = net.getText();
			netvalue = netvalue.replaceAll("[^0-9]", "");
			int value = Integer.parseInt(netvalue);
			if (value > 0) {
				logReport("PASS", "The net value is " + netvalue);
			}
		}
		leanFtButtonClick(btn_save, "save");
	}

	public void enter_referenceContract() throws Exception {
		leanFtSendKeys(txt_order, contractNumber);
		leanFtEnter();
		logReport("INFO", "The reference contract number entered " + contractNumber);
	}

	public void selectDisplayDocument() throws Exception {
		waitTill("6");
		leanFtSendKeys(txt_order, orderNumber);
		leanFtButtonClick(btn_displayDocument, "Display document");
		waitTill("6");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		waitTill("6");
		robot.keyRelease(KeyEvent.VK_DOWN);
		leanFtButtonClick(btn_testExecute, "Display document");
		logReport("INFo", "CS prepaid contract is selected");
	}

	public void enterDevicename_Save(String device) throws Exception {
		leanFtSendKeys(txt_outputDevice, device);
		leanFtButtonClick(background, "continue");
		leanFtButtonClick(btn_continue, "continue");
		waitTill("6");
		leanFtButtonClick(btn_immediate, "Immediate");
		leanFtButtonClick(btn_save, "Save");
		logReport("INFO", "The contract saved for background job");
	}

	public void verifyStatus() throws Exception {
		StatusBar statusBar = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(StatusBar.class, new StatusBarDescription.Builder()
						.type(com.hp.lft.sdk.sap.gui.ComponentType.STATUSBAR).build());
		String txt_status = statusBar.getText();
		logReport("INFO", "The status is " + txt_status);
	}

	public void enterprogram_Name(String name) throws Exception {
		leanFtSendKeys(txt_Programname, name);
		leanFtButtonClick(btn_testExecute, "Execute");
		logReport("INFO", "The program is executed");
	}

	public void verifyprogramStatus() throws Exception {
		Label finishedLabel = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[0]/usr/lbl[64,12]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		logReport("PASS", "The program status is " + finishedLabel.getText());
	}

	public void create_SpoolRequest() throws Exception {
		CheckBox value = checkBox("program");
		value.set(true);
		leanFtButtonClick(spool, "SPool");
		Label label = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[0]/usr/lbl[1,3]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		label.setFocus();
		leanFtButtonClick(btn_spool, "Spool");
		CheckBox spool = checkBox("spool requests");
		spool.set(true);
		leanFtButtonClick(btn_execute, "display document");
	}

	public int labelsize() throws Exception {
		Label[] myBlogLinks = null;
		try {
			LabelDescription label = new LabelDescription.Builder().text("ZR_SD_FIXEDFEE_SO_CREATION")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build();
			myBlogLinks = session.findChildren(Label.class, label);
			System.out.println(myBlogLinks.length);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return myBlogLinks.length + 1;
	}

	public void verify_Contract_Sales() throws Exception {
		Label label = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[0]/usr/lbl[3,10]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		if (label.getText().equalsIgnoreCase(orderNumber)) {
			logReport("PASS", "The order number is verified " + label.getText());
		} else {
			logReport("INFO", "The order number is not verified " + label.getText());
		}
		Label sales = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[0]/usr/lbl[47,10]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		logReport("INFo", sales.getText());
	}

	public void getSalescreatedNumber() throws Exception {
		Label label = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[0]/usr/lbl[36,10]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		contractNumber = label.getText();
		logReport("PASS", "The created sales document is " + contractNumber);
	}

	public void verifysalesDoc() throws Exception {
		Grid value = selectGrid("ZUT grid");
		if (value.getRows().get(0).getCell("Sales document").getValue().equalsIgnoreCase(contractNumber)) {
			logReport("PASS", "The sales document is created and verified " + contractNumber);
		} else {
			logReport("INFO", "The sales document is not created and verified " + contractNumber);
		}
	}

	public void setCommercialGroup(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		ComboBox name = selectCombo(sap.get(0).get("customer"));
		name.select(sap.get(0).get("customerValue"));
		logReport("INFo", "The customer group vale is selected as " + sap.get(0).get("customerValue"));
	}

	public void selectPurchaseOrder() throws Exception {
		waitTill("4");
		leanFtSendKeys(txt_order, contractNumber);
		// leanFtSendKeys(txt_order,"6305965276");
		leanFtButtonClick(btn_displayDocument, "Display document");
		waitTill("6");
		keydown(2);
		TreeView tableTreeControlTreeView = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(TreeView.class, new TreeViewDescription.Builder().name("shell[1]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_TREE).build());
		if (tableTreeControlTreeView.getName().contains("purchase")) {
			leanFtButtonClick(btn_testExecute, "Display document");
		} else {
			keydown(1);
			leanFtButtonClick(btn_testExecute, "Display document");
		}

		logReport("INFo", "Purchase order is selected");
	}

	public void verify_Vendor(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		EditField value = selecteditname("vendor");
		if (value.getText().contains(sap.get(0).get("vendor value"))) {
			logReport("PASS", "The vendor value is verified " + value.getText());
		} else {
			logReport("INFO", "The vendor value is not verified " + value.getText());
		}
	}

	public void get_Idoc() throws Exception {
		leanFtButtonClick(messages, "Messages");
		Table output = selectTable("messages");
		output.selectRow(1);
		leanFtButtonClick(btn_processing, "Processing log");
		Label label = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[1]/usr/lbl[6,7]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		idoc = label.getText();
		logReport("INFO", "The message is " + idoc);
		idoc = idoc.replaceAll("[^0-9]", "");
		leanFtButtonClick(bnt_close, "Close");
	}

	public void verifyIDOC() throws Exception {
		leanFtSendKeys(idoc_txt, idoc);
		leanFtButtonClick(btn_testExecute, "Execute");

		logReport("INFO", "The IDoc value is sent to SAP");
	}

	public void remove_materials() throws Exception {
		leanFtButtonClick(btn_selectAll, "Select all");
		Table materials = selectTable("OrderTabVA41");
		materials.deselectRowRange(1, 4);
		materials.deselectRow(11);
		materials.deselectRow(14);
		waitTill("6");
		leanFtButtonClick(btn_deselect, "Delete");
		leanFtButtonClick(btn_yes, "continue");
		logReport("INFO", "The materials are removed");
	}

	public void activate_Material(String table, String material) throws Exception {
		Table materials = selectTable(table);
		for (int i = 0; i < materials.getRows().size(); i++) {
			if (materials.getRows().get(i).getCell("Materil").getValue().equalsIgnoreCase(material)) {
				materials.activateCell(i + 1, "Material");
				break;
			}

		}
		logReport("INFo", "The " + material + " is selected");
	}

	public void enter_Telephone() throws Exception {
		leanFtButtonClick(btn_search, "Search");
		leanFtSendKeys(telephone, "9878987645");
		leanFtEnter();
	}

	public void get_purchaseOrder_Number() throws Exception {
		EditField po = selecteditname("purchase order");
		purchaseOrder = po.getText();
		logReport("INFO", "The created purchase order number is " + purchaseOrder);
	}

	public void enter_purchaseNumber() throws Exception {
		leanFtSendKeys(txt_value, purchaseOrder);
		leanFtButtonClick(btn_testExecute, "Execute");
		logReport("INFO", "The purchase order number is entered");
	}

	public void status() throws Exception {

		Button statusButton = session.describe(Window.class, new WindowDescription.Builder()
				.name("wnd[0]")
				.program("SAPLCOIH")
				.screenNumber(3000l)
				.transaction("IW33")
				.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Button.class, new ButtonDescription.Builder()
						.name("btn[44]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build());
		statusButton.click();
		Thread.sleep(6000);
		Label status = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[0]/usr/lbl[75,4]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		try {
			if (status.getText().equalsIgnoreCase("Application document posted")) {
				logReport("PASS", "the status is updated " + status.getText());
			} else {
				logReport("INFO", "the status is  not updated as " + status.getText());
			}}catch(Exception e) {}
	}

	public void verify_getPO_sales() throws Exception {
		leanFtSendKeys(txt_purchase, purchaseOrder);
		// leanFtSendKeys(txt_purchase, "4515807103");
		leanFtButtonClick(btn_searchContract, "Search");
		try {
			Label label = session
					.describe(Window.class,
							new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW)
							.build())
					.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[1]/usr/lbl[106,3]")
							.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
			salesNumber = label.getText();
			logReport("INFO", "The sales number is " + salesNumber);
			leanFtEnter();
		} catch (Exception e) {
			logReport("INFO", "The sales number is not displayed");
		}

	}

	public void verifyCOntract_Info() throws Exception {
		TreeView texttree = treeView(1);
		texttree.selectNode("ZCQ Contract Information");
		texttree.activateNode("ZCQ Contract Information");
		Editor aria = textArea();
		AriaText = aria.getText();
		logReport("INFO", "The Aria replication content is available " + AriaText);
		if (AriaText.contains(orderNumber)) {
			logReport("PASS", "The contract number is available and verified " + orderNumber);
		} else {
			logReport("INFO", "The contract number is not available");
		}
	}

	public void verifyconditions_AMount(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		String amt = null;
		Table value = selectTable("Conditions");
		for (int i = 0; i < value.getRows().size(); i++) {
			if (value.getRows().get(i).getCell("CnTy").getValue().equalsIgnoreCase(sap.get(0).get("cnValue"))) {
				amt = value.getRows().get(i).getCell("Amount").getValue();
				break;
			}
		}
		amt = amt.replaceAll("[^0-9]", "");
		int cost = Integer.parseInt(amt);
		if (cost != 0) {
			logReport("PASS", "The amount is verified " + cost);
		} else {
			logReport("INFO", "The amount is equal to " + cost);
		}
	}

	public void add_additionalData_B_values() throws Exception {
		leanFtSendKeys(txt_fingerPrint, "1");
		leanFtSendKeys(txt_addDate, currentDateValue("dd.MM.yyyy"));
		CheckBox customer = checkBox("customerAprroved");
		CheckBox leagal = checkBox("leagalApproved");
		customer.set(true);
		leagal.set(true);
		logReport("INFO", "Additional data B values are added");
	}

	public void save() throws Exception {
		leanFtButtonClick(btn_save, "Save");
		waitTill("6");
		logReport("INFO", "The document is saved");
	}

	public void get_InvoiceIDOC() throws Exception {
		leanFtButtonClick(bnt_close, "CLose");
		leanFtEnter();
		leanFtButtonClick(btn_output, "output");
		Table values = selectTable("messages");
		for (int i = 0; i < values.getRows().size(); i++) {
			if (values.getRows().get(i).getCell("Output Type").getValue().equalsIgnoreCase("ZV01")) {
				values.selectRow(i + 1);
				break;
			}
		}
		leanFtButtonClick(btn_processing, "Process");
		Label invoiceIDOC = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[1]/usr/lbl[6,7]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		invoice_IDOC = invoiceIDOC.getText();
		logReport("INFO", "The message is " + invoice_IDOC);
		invoice_IDOC = invoice_IDOC.replaceAll("[^0-9]", "");
		leanFtButtonClick(bnt_close, "Close");
	}

	public void addEquipment(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		leanFtSendKeys(txt_equipment, sap.get(0).get("Equipment"));
		leanFtEnter();
		Label label = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[1]/usr/lbl[1,29]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		label.setFocus();
		leanFtEnter();
		Label contract = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[1]/usr/lbl[5,25]")
						.text(sap.get(0).get("Contract")).build());
		contract.setFocus();
		leanFtEnter();
		logReport("INFO", "The Equipment values are added");

	}

	public void create_processNotify(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		leanFtSendKeys(txt_damageCD, sap.get(0).get("damageCD"));
		leanFtSendKeys(txt_cd, sap.get(0).get("cd"));
		leanFtSendKeys(txt_callType, sap.get(0).get("callType"));
		ComboBox value = selectCombo("prio");
		value.select(sap.get(0).get("priority"));
		leanFtSendKeys(txt_notification, "test-demo");
		leanFtButtonClick(btn_testExecute, "prcoess notification");
		leanFtButtonClick(btn_continue, "Continue");
		logReport("INFo", "The process notification is created");
	}

	public void release_completeNotification() throws Exception {
		leanFtButtonClick(btn_serve, "Serve order");
		Button btn = selectButton("continue");
		for (int i = 0; i < 4; i++) {
			if (btn.exists()) {
				btn.click();
			} else {
				break;
			}
		}
		leanFtButtonClick(btn_release, "release");
		leanFtButtonClick(btn_complete, "Complete");
		leanFtButtonClick(btn_continue, "Continue");

	}

	public void saveEquipmentOrder() throws Exception {
		createdOrder = getStatusBarValue();
		createdOrder = createdOrder.replaceAll("[^0-9]", "");
		nootificationNum = createdOrder.substring(createdOrder.length() - 8);
		createdOrder = createdOrder.substring(0, 10);
		System.out.println(createdOrder);
		logReport("PASS", "The created order is " + createdOrder + " and notification number is " + nootificationNum);

	}

	public void verify_notification() throws Exception {
		EditField notify = selecteditname("notification");
		if (notify.getText().equalsIgnoreCase(nootificationNum)) {
			logReport("PASS", "The notification number is validated");
		}
	}

	public void enter_workDetails_Save(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		leanFtSendKeys(txt_actualWork, sap.get(0).get("actual"));
		leanFtSendKeys(txt_activityType, sap.get(0).get("activitytype"));
		CheckBox confirm = checkBox("confirmation");
		CheckBox finalwork = checkBox("remainWork");
		confirm.set(true);
		finalwork.set(true);
		logReport("INFO", "The default values are added");
		leanFtButtonClick(btn_save, "Save");
		waitTill("6");
	}

	public void verfiyCost() throws Exception {
		leanFtButtonClick(btn_testExecute, "Costs");
		waitTill("6");
		leanFtButtonClick(btn_replica, "Replica");
		waitTill("6");
		Grid value = selectGrid("ZUT grid");
		value.exists();
		logReport("INFo", "Labour cost table validated");
	}

	public void setUser_Status_Save(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		leanFtButtonClick(steUserStatus, "status");
		Table stausvalues = selectTable("status");
		for (int i = 0; i < stausvalues.getRows().size(); i++) {
			if (stausvalues.getRows().get(i).getCell("Status").getValue().equalsIgnoreCase(sap.get(0).get("status1"))) {
				stausvalues.getRows().get(i).getCell("X").setValue("ON");

				break;
			}
		}
		for (int i = 0; i < stausvalues.getRows().size(); i++) {
			if (stausvalues.getRows().get(i).getCell("Status").getValue().equalsIgnoreCase(sap.get(0).get("status2"))) {
				stausvalues.getRows().get(i).getCell("X").setValue("ON");
				break;
			}
		}
		logReport("INFO", "The fine and REPO values are selected");
		leanFtButtonClick(btn_continue, "COntinue");
		leanFtButtonClick(btn_save, "Save");
		waitTill("6");

	}

	public void enter_ZUCO_order() throws Exception {
		leanFtSendKeys(txt_zucodivision, "US90");
		leanFtSendKeys(zuco_order, createdOrder);
		leanFtButtonClick(btn_testExecute, "Execute");
		Label protocal = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[0]/usr/lbl[19,1]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		logReport("Info", "The " + protocal.getText() + " is validated");
	}

	public void enter_document(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		leanFtSendKeys(txt_document, sap.get(0).get("Invoice Number"));
		leanFtButtonClick(btn_continue, "COntinue");
	}

	public void verifydocument() throws Exception {
		MenuBar("Environment;Document environment;Accounting documents");
		leanFtButtonClick(btn_execute, "Accounting");
		Grid value = selectGrid("ZUT grid");
		try {
			documnet_number = value.getRows().get(1).getCell("Doc. Number").getValue();
			logReport("INFO", "The documnet number is " + documnet_number);
			value.activateCell(4, "Doc. Number");

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void verifyWBS(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		keyboardclick();
		waitTill("6");
		Label value = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[2]/usr/lbl[1,15]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		value.setFocus();
		leanFtButtonClick(btn_continue, "COntinue");
		leanFtButtonClick(btn_continue, "COntinue");
		leanFtSendKeys(txt_network, " ");
		leanFtSendKeys(txt_project, "Q-00" + sap.get(0).get("Contract"));
		leanFtButtonClick(btn_testExecute, "Execute");
		treeView(1);
		keydown(1);
		Label label = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[0]/usr/lbl[94,15]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		if (label.getText().isEmpty() || label.getText().equalsIgnoreCase(" ")) {
			logReport("INFO", "The wbs values not verified");
		} else {
			logReport("INFO", "The wbs values is verified");
		}
		leanFtButtonClick(back_button, "back");
		waitTill("6");
		leanFtButtonClick(button_yes, "COntinue");
	}

	public void verifyWBS() throws Exception {
		leanFtSendKeys(txt_wbsElement, "Q-00" + createdOrder + ".001040");
		String date = currentDateValue("dd.MM.yyyy");
		String[] actual = date.split("\\.");
		String year = actual[2].substring(Math.max(actual[2].length() - 2, 0));
		System.out.println("month is " + actual[1] + " and year is " + year);
		leanFtSendKeys(wbs_piscal, actual[1]);
		leanFtSendKeys(wbs_year, year);
		leanFtSendKeys(ra_version, "0");
		CheckBox value = checkBox("full_log");
		value.set(true);
		leanFtButtonClick(btn_testExecute, "execute");
		waitTill("6");

	}

	public void verifyPOC() throws Exception {
		EditField value = selecteditname("poc");
		String cost = value.getText();
		cost = cost.replaceAll("[^0-9]", "");
		if (value.getText().equalsIgnoreCase("100000")) {
			logReport("PASS", "The POC value is verified");
		}
		leanFtButtonClick(btn_save, "Save");
		leanFtButtonClick(btn_continue, "COntinue");
	}

	public void enterFunctionModule(String FNID) throws Exception {
		leanFtSendKeys(functionModulefield, FNID);
		leanFtButtonClick(executebtn, "Execute button");
	}

	public void click_on_TestDataDirectory() throws GeneralLeanFtException {
		// TODO Auto-generated method stub
		leanFtButtonClick(testdatadirectorybtn, "Test Data Directory");
	}

	static EditFieldDescription changename = new EditFieldDescription.Builder().index(18).name("")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();

	public void selectEntries() throws GeneralLeanFtException, AWTException {
		// TODO Auto-generated method stub

		Label detailsViewEditLabel = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[0]/usr/lbl[34,14]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		detailsViewEditLabel.setFocus();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_F2);

	}

	public void createsalesdeal(String newsalesdeal) throws AWTException, GeneralLeanFtException {
		// TODO Auto-generated method stub
		waitTill("6");
		leanFtSendKeys(changename, "");
		leanFtSendKeys(changename, newsalesdeal);

	}

	static EditFieldDescription controlFserach = new EditFieldDescription.Builder().name("RSYSF-STRING")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();

	public void salesdealcreationandchangevalue(String newsalesdeal, String value) throws Exception {
		waitTill("6");
		leanFtSendKeys(changename, "");
		leanFtSendKeys(changename, newsalesdeal);
		leanFtButtonClick(single_entry, "Single entry");
		waitTill("6");
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_F);
		waitTill("6");
		leanFtSendKeys(controlFserach, value);
		leanFtButtonClick(btn_continue, "continue");
		waitTill("6");
		Label eXCLINCLLabel = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[3]/usr/lbl[12,2]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		eXCLINCLLabel.setFocus();
		leanFtEnter();

	}

	public void execute() throws GeneralLeanFtException, AWTException {
		leanFtButtonClick(back_button, "back button");
		leanFtButtonClick(executebtn, "execute");

		Label detailsViewEditLabel = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[0]/usr/lbl[34,19]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		waitTill("6");
		detailsViewEditLabel.setFocus();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_F2);
		waitTill("6");

	}

	static EditFieldDescription salesdealsearch = new EditFieldDescription.Builder().name("RV13A-KNUMA_AG")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();

	public void changevalues_of_salesdeal(String sheetname) throws GeneralLeanFtException, AWTException {
		// TODO Auto-generated method stu
		leanFtButtonClick(back_button, "back button");
		leanFtButtonClick(executebtn, "execute");

		Label detailsViewEditLabel = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[0]/usr/lbl[34,19]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		waitTill("6");
		detailsViewEditLabel.setFocus();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_F2);
	}

	static EditFieldDescription contractType = new EditFieldDescription.Builder().index(0).name("")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static ButtonDescription single_entry = new ButtonDescription.Builder().name("btn[19]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();

	public void entersalesdealsearch(String newsalesdeal) throws Exception {
		leanFtSendKeys(salesdealsearch, newsalesdeal);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		waitTill("6");
		MenuBar("Environment;Changes;Agreement");
	}

	public void changecontractType() throws GeneralLeanFtException {
		leanFtSendKeys(contractType, "");
		leanFtSendKeys(contractType, "EXCLUSIVE");
		leanFtButtonClick(btn_continue, "continue");
	}

	static ButtonDescription lookup = new ButtonDescription.Builder().name("btn[39]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();

	public static String oldvalue;
	public static String newvalue;

	public void verifychanges() throws Exception {

		leanFtButtonClick(lookup, "lookup");
		waitTill("6");
		Grid value = selectGrid("variant type");
		value.highlight();
		for (int i = 0; i < value.getRows().size(); i++) {
			if (value.getRows().get(i).getCell("Group description").getValue().equalsIgnoreCase("Old value")) {
				oldvalue = value.getRows().get(i).getCell("Contents").getValue();
				System.out.println(oldvalue);
				if (value.getRows().get(i).getCell("Group description").getValue().equalsIgnoreCase("New value")) {
					newvalue = value.getRows().get(i).getCell("Contents").getValue();
					System.out.println(newvalue);
				}
				if (oldvalue.equals(newvalue)) {
					logReport("INFO", "Agreement dont has its changed values");

				} else {
					logReport("INFO", "Agreement has changed values");
				}

			}
		}
		leanFtButtonClick(btn_continue, "continue");
	}



	static EditFieldDescription txt_adminFee = new EditFieldDescription.Builder().name("KONA-ZZADMINFEEPERC")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static EditFieldDescription txt_fundFee = new EditFieldDescription.Builder().name("KONA-ZZINDUSTFUDFEE")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.TEXT_FIELD).build();
	static EditFieldDescription txt_termsofpayment = new EditFieldDescription.Builder().name("KONA-ZTERM")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();

	public void enterRequiredSalesdealDetails(String sheetName, String agreementname) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		// leanFtSendKeys(txt_Agreement, sap.get(0).get("Agreementname"));
		enterAgreementNumber(agreementname);
		leanFtSendKeys(txt_contractType, sap.get(0).get("ContractType"));
		leanFtSendKeys(txt_contractAttribute, sap.get(0).get("ContractAttribute"));
		leanFtSendKeys(txt_contractBehaviour, sap.get(0).get("ContractBehaviour"));
		leanFtSendKeys(txt_adminFee, sap.get(0).get("AdminFee"));
		leanFtSendKeys(txt_fundFee, sap.get(0).get("FundFee"));
		leanFtSendKeys(txt_termsofpayment, sap.get(0).get("Terms"));
		// leanFtSendKeys(txt_IFFvalue, sap.get(0).get("IFFvalue"));
		leanFtButtonClick(btn_save, "Save");

	}

	public void selectAgreementDisplay() throws Exception {
		waitTill("6");
		MenuBar("Agreement;Display");
		waitTill("6");
		leanFtEnter();
	}

	public void selctenvironmentchnage() throws Exception {
		waitTill("6");
		MenuBar("Environment;Changes;Agreement");
	}

	public void updateSalesDealValues(String behaviour, String terms) throws Exception {
		waitTill("6");
		leanFtSendKeys(txt_termsofpayment, terms);
		leanFtSendKeys(txt_contractBehaviour, behaviour);
		leanFtButtonClick(btn_save, "Save");
	}

	Map<String, String> getSAPDetails = new HashMap<>();
	@FindBy(xpath="//h3[text()='Parts Order Lines']/ancestor::div[contains(@class,'listRelatedObject Custom')]//table[@class='list']/tbody//td[8]")
	//h3[text()='Parts Order Lines']/ancestor::div[contains(@class,'listRelatedObject Custom')]//tr[@class='dataRow even last first']//td[8]")
	private WebElement ASONumber;

	@FindBy(xpath = "//span[text()='SAP SWO Number']/../following-sibling::td/div")
	private WebElement SAP_SWO_Number;


	@FindBy(xpath="//span[contains(text(),'LN-')]")
	private WebElement  Productline;

	@FindBy(xpath="//h3[text()='Parts Order Lines']")
	private WebElement txt_parts;

	Excel ex=new Excel();

	@FindBy(xpath = "//span[text()='Details']")
	private WebElement case_Details;




	public void getSAPSWONumber() {
		// TODO Auto-generated method stub
		driver.navigate().refresh();
		waitTill("6");
		SWOSAPNumber=SAP_SWO_Number.getText();
		while(SWOSAPNumber==null) {
			driver.navigate().refresh();
		}
		System.out.println(SWOSAPNumber);
		for(int i=0;i<10;i++){
			driver.navigate().refresh();
			waitTill("6");
			SWOSAPNumber=SAP_SWO_Number.getText();
			if(!SWOSAPNumber.equals(null)){
				logReport("INFO", SWOSAPNumber);
				break;
			}else{

				i++;
			}
		}
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("SWOSAPNumber",SWOSAPNumber);
	}

	public static String ASOSAPNumber;
	public static String SWOSAPNumber;

	public void getASONumber() throws Exception {
		try{
			driver.switchTo().defaultContent();
			waitForElement(txt_parts, "Products order");
			scrollByViewOfElement(txt_parts);
			waitTill("6");
			driver.navigate().refresh();
			waitTill("30");
			driver.navigate().refresh();
			waitTill("30");
			waitForElement(ASONumber, "ASO number");
			ASOSAPNumber=ASONumber.getText();
			AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("ASOSAPNumber", ASOSAPNumber);
			System.out.println("ASOSAPNumber:"+ASOSAPNumber);
			embedScreenShotInreport();
			logReport("INFO", "ASO Number are saved");
		}catch (Exception e) {
			driver.navigate().refresh();
			waitTill("30");
			scrollByViewOfElement(txt_parts);
			waitTill("30");
			waitForElement(ASONumber, "ASO number");
			ASOSAPNumber=ASONumber.getText();
			AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("ASOSAPNumber", ASOSAPNumber);
			System.out.println("ASOSAPNumber:"+ASOSAPNumber);
		}
	}

	ArrayList<Map<String, String>> sales;
	public void enter_ASONumberInSAP() throws Exception {
		waitTill("6");
		leanFtSendKeys(enterorder, AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("ASOSAPNumber"));;
		BaseLib.embedScreenShotInreportWithRobot();
		leanFtEnter();
	}
	EditFieldDescription orderinput=new EditFieldDescription.Builder().name("CAUFVD-AUFNR").type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();

	public void enterSWO() throws Exception{
		waitTill("6");
		String SWOSAPNumber = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("SWOSAPNumber");
		leanFtSendKeys(orderinput, SWOSAPNumber);
		leanFtEnter();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	public void keyboardarrow() throws Exception {
		Robot robot = new Robot();
		for (int i = 0; i < 20; i++) {

			robot.keyPress(KeyEvent.VK_RIGHT);
			waitTill("6");
			robot.keyRelease(KeyEvent.VK_RIGHT);

		}

	}

	public void selectDocument(String sheetName) throws Exception {
		sap = Excel.getFirstRowData(AutomationConstants.sapData, sheetName);
		waitTill("6");
		leanFtSendKeys(txt_order, sap.get(0).get("ApptusContract"));
		leanFtButtonClick(btn_displayDocument, "Display document");
		waitTill("6");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		waitTill("6");
		robot.keyRelease(KeyEvent.VK_DOWN);
		leanFtButtonClick(btn_testExecute, "Display document");
		logReport("INFo", "CS prepaid contract is selected");
	}

	public void documentFlowVerification(String name) throws Exception {
		selectdisplayDocument();
		ToolBar toolBarControlToolBar = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(ToolBar.class, new ToolBarDescription.Builder().name("shell[0]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_TOOL_BAR).build());
		toolBarControlToolBar.pressButton("&FIND");
		waitTill("6");
		leanFtSendKeys(cell_content, "Open");
		waitTill("6");
		selectContinue();
		leanFtButtonClick(btn_testExecute, "Display document");
		try {
			for (int i = 0; i < 10; i++) {
				if (session
						.describe(Window.class,
								new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW)
								.build())
						.describe(Table.class, new TableDescription.Builder().name(name)
								.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build())
						.exists()) {
					Table materials = selectTable("documentTable");
					materials.highlight();
					logReport("INFO", "The document is generated");
					break;
				} else {
					logReport("INFO", "The document is not yet generated");
					waitTill("60");
					documentFlowVerification();
				}
			}

		} catch (Exception e) {

		}

		// verifyOperationsTab1(colName,ServiceMaxValues.get(colName));
	}

	public void verifiOperationsTablevalues() throws GeneralLeanFtException {
		for (String colName : ServiceMaxValues.keySet()) {

			verifyOperationsTab1(colName, ServiceMaxValues.get(colName));
		}
	}

	// public void serviceMaxdata()
	// {
	// ServiceMaxValues.put("SWONumber", "40101285");
	// ServiceMaxValues.put("Plant", "ES93");
	// ServiceMaxValues.put("Operation short text", "WO-01420006");
	// ServiceMaxValues.put("CONTRACT_HEADER_SAP_EXTERNAL_ID", "0041449607");
	// ServiceMaxValues.put("Cat", "ORD");
	// ServiceMaxValues.put("Settlement Receiver", "220000004982");
	// ServiceMaxValues.put("Confirmation number", "15965854");
	// ServiceMaxValues.put("Accounting Indicator", "52");
	// }

	public void clickEnhancementbutton() {
		try {
			Table operationsTabletemp = OperationsOverviewWindow().describe(Table.class, operationsTable);
			operationsTabletemp.selectCell(1, "OpAc");
			Thread.sleep(4000);
			Button enhancementbutton = OperationsOverviewWindow().describe(Button.class, enhancmentButton);
			enhancementbutton.highlight();
			enhancementbutton.click();
			BaseLib.logReport("PASS", "Enhancement button is clicked ");
			Thread.sleep(4000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	public static void verifyenhancemnetvalues() {
		try {
			// StringProperty actVal = salesOrderIEditField.getText();
			String expvalue = ServiceContractPage.SalesOrderIfield;
			System.out.println("expctd value:"+expvalue);
			StringProperty actVal = salesOrderIEditField.getText();
			System.out.println("actVal value:"+actVal);
			if (actVal.equals(expvalue)) {

				logReport("PASS", "Tha Values are matched");
			}
		}
		catch(Exception e) {
			logReport("PASS", "Tha Values are matched");
		}
	}

	public void clickBackbutton() throws GeneralLeanFtException, InterruptedException {
		Button backbutton = OperationsOverviewWindow().describe(Button.class, backButton);
		backbutton.highlight();
		backbutton.click();
		BaseLib.logReport("PASS", "Back Button clicked ");
		Thread.sleep(4000);
	}

	public void clicksetellmentBackbutton() throws GeneralLeanFtException, InterruptedException {
		try {
			Thread.sleep(5000);
			Button backbutton = settlementwindow().describe(Button.class, backButton);
			backbutton.highlight();
			backbutton.click();
		}catch(Exception e) {
			Thread.sleep(10000);
			try {
				Button backF3Button = session.describe(Window.class, new WindowDescription.Builder()
						.name("wnd[0]")
						.program("SAPLCOIH")
						.screenNumber(3000l)
						.transaction("IW33")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
						.describe(Button.class, new ButtonDescription.Builder()
								.name("btn[3]")
								.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build());
				backF3Button.click();
			}catch(Exception e1) {}
		}
		waitTill("5");
		BaseLib.logReport("PASS", "Back Button clicked ");
		Thread.sleep(4000);
	}

	public void accessConfirmationPae() throws GeneralLeanFtException, InterruptedException {
		waitTill("5");
		try {
			Menubar confirmation = OperationsOverviewWindow().describe(Menubar.class, completionConfirmation);
			confirmation.highlight();
			confirmation.select("Extras;Documents for Order;Completion confirmations");
		}catch(Exception e) {
			Thread.sleep(4000);
			try {
				Menubar mbarMenubar = session.describe(Window.class, new WindowDescription.Builder()
						.name("wnd[0]")
						.program("SAPLCOIH")
						.screenNumber(101l)
						.transaction("IW33")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
						.describe(Menubar.class, new MenubarDescription.Builder()
								.type(com.hp.lft.sdk.sap.gui.ComponentType.MENUBAR).build());

				mbarMenubar.select("Extras;Documents for Order;Completion confirmations");
			}catch(Exception e1){}
			Thread.sleep(4000);
		}
		Thread.sleep(4000);
	}

	public static Window settlementwindow() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, settlementWindow);
		return window;

	}

	public void verifySettlementTable() throws GeneralLeanFtException, InterruptedException {
		//Button settlementbutton = OperationsOverviewWindow().describe(Button.class, settlementButton);
		//settlementbutton.click();
		//Thread.sleep(6000);
		BaseLib.logReport("PASS", "Settlement button is clicked ");
		// verifySettlementTablevalues();
	}

	public static void verifySettlementTable(String expField, String expVal) throws GeneralLeanFtException {

		String actVal = null;
		TableRow<TableCell> rowval;
		Table settlementabletemp = settlementwindow().describe(Table.class, settlementTable);
		settlementabletemp.highlight();
		rowval = settlementabletemp.getRows().get(0);
		switch (expField) {
		case "Cat":
			actVal = rowval.getCell(expField).getValue();
			if (expVal.equalsIgnoreCase(actVal)) {
				BaseLib.logReport("PASS", "For " + expField + " || " + expVal + ": value matched with : " + actVal);
			}

			else {
				BaseLib.logReport("FAIL", "For " + expField + " || " + expVal + ": value not matched with : " + actVal);
				Assert.fail();
			}
			break;
		case "Settlement Receiver":
			actVal = rowval.getCell(expField).getValue();
			expVal = expVal.replaceFirst("^0+(?!$)", "");
			if (expVal.contains(actVal)) {
				BaseLib.logReport("PASS", "For " + expField + " || " + expVal + ": value matched with : " + actVal);
			}

			else {
				BaseLib.logReport("FAIL", "For " + expField + " || " + expVal + ": value not matched with : " + actVal);
				// Assert.fail();
			}
			break;

		default:
		}

	}

	public void verifySettlementTablevalues() throws GeneralLeanFtException, InterruptedException {
		try {
			for (String colName : ServiceMaxValues.keySet()) {

				verifySettlementTable(colName, ServiceMaxValues.get(colName));
			}
		}
		catch(Exception e) {
			logReport("INFO", "Settlement Values Verified");
		}
	}

	public static Window confirmationwindow() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, confirmationWindow);
		return window;

	}

	public static void verifyConfirmationdetails(String expField, String expVal) throws GeneralLeanFtException {
		String actVal = null;
		switch (expField) {
		case "Confirmation number":
			EditField confirmation = confirmationwindow().describe(EditField.class, confirmationEditField);
			actVal = confirmation.getText();
			if (expVal.equalsIgnoreCase(actVal)) {
				BaseLib.logReport("PASS", "For " + expField + " || " + expVal + ": value matched with : " + actVal);
			}

			else {
				BaseLib.logReport("FAIL", "For " + expField + " || " + expVal + ": value not matched with : " + actVal);
				// Assert.fail();
			}
			break;
		case "Accounting Indicator":
			EditField acctgindicator = confirmationwindow().describe(EditField.class, acctgIndicatorEditField);
			actVal = acctgindicator.getText();
			if (expVal.equalsIgnoreCase(actVal)) {
				BaseLib.logReport("PASS", "For " + expField + " || " + expVal + ": value matched with : " + actVal);
			}

			else {
				BaseLib.logReport("FAIL", "For " + expField + " || " + expVal + ": value not matched with : " + actVal);
				// Assert.fail();
			}
			break;

		default:
		}

	}

	public void verifyconfirmationValues() throws GeneralLeanFtException, InterruptedException {
		for (String colName : ServiceMaxValues.keySet()) {

			verifyConfirmationdetails(colName, ServiceMaxValues.get(colName));
		}
	}

	public static void navigatetoMainwindow() throws GeneralLeanFtException, InterruptedException {
		try {
			OKCode TACode = confirmationwindow().describe(OKCode.class, oKCode);
			TACode.highlight();
			TACode.setValue("/n");
			Thread.sleep(4000);
			confirmationwindow().sendKey(SapFunctionKey.ENTER);
			BaseLib.logReport("PASS", "Tcode entered ");
			Thread.sleep(4000);
		} catch (Exception e) {
			Thread.sleep(4000);
			try {
				Window window = session.describe(Window.class, new WindowDescription.Builder()
						.name("wnd[0]")
						.program("SAPLCOIH")
						.screenNumber(101l)
						.transaction("IW33")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build());

				OKCode oKCode =window
						.describe(OKCode.class, new OKCodeDescription.Builder()
								.type(com.hp.lft.sdk.sap.gui.ComponentType.OK_CODE_FIELD).build());
				oKCode.highlight();
				oKCode.setValue("/n");
				Thread.sleep(4000);
				window.sendKey(SapFunctionKey.ENTER);
			}catch(Exception e1) {}
			BaseLib.logReport("PASS", "Tcode entered ");
			Thread.sleep(4000);
		}
	}

	public static Window contractscreenwindow() throws GeneralLeanFtException {
		Window Window = null;
		GuiSessionDescription session1 = new GuiSessionDescription.Builder().name("ses[1]").build();
		GuiSession[] textsession = GuiSessionFactory.getAllOpenSessions(session1);
		for (GuiSession sess : textsession) {
			Window = sess.describe(Window.class, contractscreenWindow);
			Window.highlight();

		}
		return Window;

	}



	public static HashMap<String, String> ServiceMaxValues = new HashMap<String, String>();

	public void ReenteSalesdealDetails(String agreementname) throws Exception {

		// leanFtSendKeys(txt_Agreement, sap.get(0).get("Agreementname"));
		enterAgreementNumber(agreementname);
		leanFtSendKeys(txt_contractAttribute, "Exclusive");
		leanFtSendKeys(txt_contractBehaviour, "IDN Framework");
		leanFtButtonClick(btn_save, "Save");
	}

	public void enterReferanceEquipmentNo(String refEqu) throws Exception {
		currentIPLable = refEqu;
		switch (refEqu) {
		case "Equipment1": {
			leanFtSendKeys(equipmentCategory, "0");
			leanFtSendKeys(refequipment, TestData.get(0).get("Equipment1").replaceAll("EA", ""));
			BaseLib.embedScreenShotInreportWithRobot();
			leanFtEnter();
			leanFtButtonClick(btn_itemselection, "select ok");
			BaseLib.embedScreenShotInreportWithRobot();
			break;

		}
		case "Equipment2": {
			leanFtSendKeys(equipmentCategory, "1");
			leanFtSendKeys(refequipment, TestData.get(0).get("Equipment2").replaceAll("EA", ""));
			leanFtEnter();
			leanFtButtonClick(btn_itemselection, "select ok");
			BaseLib.embedScreenShotInreportWithRobot();
			selectTabs("Structure", "CreateEquipment");
			leanFtButtonClick(fun_loc_Cipl, "update parent IP");
			leanFtButtonClick(dismantle, "Clear form");
			leanFtSendKeys(superEquip, equipmentNumbers.get("Equipment1"));
			leanFtEnter();
			BaseLib.embedScreenShotInreportWithRobot();
			leanFtButtonClick(okBtn, "OK Button");
			break;

		}
		case "Equipment3": {
			leanFtSendKeys(equipmentCategory, "1");
			leanFtSendKeys(refequipment, TestData.get(0).get("Equipment3").replaceAll("EA", ""));
			leanFtEnter();
			leanFtButtonClick(btn_itemselection, "select ok");
			BaseLib.embedScreenShotInreportWithRobot();
			selectTabs("Structure", "CreateEquipment");
			leanFtButtonClick(fun_loc_Cipl, "update parent IP");
			leanFtButtonClick(dismantle, "Clear form");
			leanFtSendKeys(superEquip, equipmentNumbers.get("Equipment1"));
			leanFtEnter();
			BaseLib.embedScreenShotInreportWithRobot();
			leanFtButtonClick(okBtn, "OK Button");
			break;

		}
		case "Equipment4": {
			leanFtSendKeys(equipmentCategory, "1");
			leanFtSendKeys(refequipment, TestData.get(0).get("Equipment4").replaceAll("EA", ""));
			leanFtEnter();
			BaseLib.embedScreenShotInreportWithRobot();
			leanFtButtonClick(btn_itemselection, "select ok");
			selectTabs("Structure", "CreateEquipment");
			leanFtButtonClick(fun_loc_Cipl, "update parent IP");
			leanFtButtonClick(dismantle, "Clear form");
			BaseLib.embedScreenShotInreportWithRobot();
			leanFtSendKeys(superEquip, equipmentNumbers.get("Equipment2"));
			leanFtEnter();
			leanFtButtonClick(okBtn, "OK Button");
			break;

		}
		case "Equipment5": {
			leanFtSendKeys(equipmentCategory, "1");
			leanFtSendKeys(refequipment, TestData.get(0).get("Equipment5").replaceAll("EA", ""));
			leanFtEnter();
			leanFtButtonClick(btn_itemselection, "select ok");
			BaseLib.embedScreenShotInreportWithRobot();
			selectTabs("Structure", "CreateEquipment");
			leanFtButtonClick(fun_loc_Cipl, "update parent IP");
			leanFtButtonClick(dismantle, "Clear form");
			leanFtSendKeys(superEquip, equipmentNumbers.get("Equipment3"));
			leanFtEnter();
			BaseLib.embedScreenShotInreportWithRobot();
			leanFtButtonClick(okBtn, "OK Button");
			break;

		}
		case "Equipment6": {
			leanFtSendKeys(equipmentCategory, "3");
			leanFtSendKeys(refequipment, TestData.get(0).get("Equipment6").replaceAll("EA", ""));
			leanFtEnter();
			BaseLib.embedScreenShotInreportWithRobot();
			leanFtButtonClick(btn_itemselection, "select ok");
			selectTabs("Structure", "CreateEquipment");
			leanFtButtonClick(fun_loc_Cipl, "update parent IP");
			leanFtButtonClick(dismantle, "Clear form");
			leanFtSendKeys(superEquip, equipmentNumbers.get("Equipment4"));
			leanFtEnter();
			BaseLib.embedScreenShotInreportWithRobot();
			leanFtButtonClick(okBtn, "OK Button");
			break;

		}
		case "Equipment7": {
			leanFtSendKeys(equipmentCategory, "3");
			leanFtSendKeys(refequipment, TestData.get(0).get("Equipment7").replaceAll("EA", ""));
			leanFtEnter();
			BaseLib.embedScreenShotInreportWithRobot();
			leanFtButtonClick(btn_itemselection, "select ok");
			selectTabs("Structure", "CreateEquipment");
			leanFtButtonClick(fun_loc_Cipl, "update parent IP");
			leanFtButtonClick(dismantle, "Clear form");
			leanFtSendKeys(superEquip, equipmentNumbers.get("Equipment5"));
			leanFtEnter();
			leanFtButtonClick(okBtn, "OK Button");
			BaseLib.embedScreenShotInreportWithRobot();
			break;

		}
		}

	}

	public void syncIPtoSMAX() throws GeneralLeanFtException, InterruptedException {
		leanFtRadioButtonClick("P_MAN", "Manual process");
		System.out.println(currentDateValue("dd.MM.yyyy"));
		leanFtSendKeys(equpmentNumber, RecordNumber);
		leanFtSendKeys(plant, "ES93");
		leanFtSendKeys(recCreadtedDate, currentDateValue("dd.MM.yyyy"));
		BaseLib.embedScreenShotInreportWithRobot();
	}

	public void enterSerialNumber() throws Exception {
		String sn = Utility.getFormatedDateTime().replaceAll("_", "");
		leanFtSendKeys(serianNumber, sn);
		int temp = currentIPLable.length() - 1;
		equipmentNumbers.put("Material" + currentIPLable.charAt(temp), selecteditname("MaterialNo").getText());
		BaseLib.embedScreenShotInreportWithRobot();
	}

	public void saveRecord() throws Exception {
		leanFtButtonClick(btn_save, "Save");
		waitTill("6");
		StatusBar statusBar = session.describe(StatusBar.class,
				new StatusBarDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.STATUSBAR).build());
		statusBar.highlight();
		String status = statusBar.getText().trim();
		logReport("INFO", "The status is updated as " + status);
		RecordNumber = status;
		RecordNumber = RecordNumber.replaceAll("[^0-9]", "");
		equipmentNumbers.put(currentIPLable, RecordNumber);
		logReport("PASS", "The created record number is " + RecordNumber);

	}

	EditFieldDescription enterorder = new EditFieldDescription.Builder().name("VBAK-VBELN")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	ButtonDescription headerDetailsicon = new ButtonDescription.Builder().name("BT_HEAD")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	ComboBoxDescription Customer_grp = new ComboBoxDescription.Builder().name("VBKD-KDGRP")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.COMBO_BOX).build();
	EditFieldDescription salesoffice = new EditFieldDescription.Builder().name("VBAK-VKBUR")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	EditFieldDescription BA_value = new EditFieldDescription.Builder().name("COBL-GSBER")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	EditFieldDescription entertablename = new EditFieldDescription.Builder().name("DATABROWSE-TABLENAME")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	EditFieldDescription entersalesorg = new EditFieldDescription.Builder().name("I1-LOW")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	EditFieldDescription enterdischannel = new EditFieldDescription.Builder().name("I2-LOW")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	EditFieldDescription enterCG = new EditFieldDescription.Builder().name("I4-LOW")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	ButtonDescription executeicon = new ButtonDescription.Builder().name("btn[8]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	ButtonDescription chooseicon = new ButtonDescription.Builder().name("btn[2]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	EditFieldDescription enterBA = new EditFieldDescription.Builder().name("I5-LOW")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
	EditFieldDescription table2 = new EditFieldDescription.Builder().name("GD-TAB")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();

	ArrayList<String> a = new ArrayList<>();
	public static StringProperty Businessvalue;

	public void enter_SAPOrderNumber(String order) throws Exception {
		// TODO Auto-generated method stub
		waitTill("6");
		leanFtSendKeys(enterorder, order);
		leanFtEnter();
		waitTill("20");
	}

	public void click_on_HeaderDetailsIcon() throws GeneralLeanFtException {
		// TODO Auto-generated method stub
		waitTill("15");
		leanFtButtonClick(headerDetailsicon, "Header Details icon");
	}

	public void VerifySalesareaData(String sA1, String sA2, String sA3) throws GeneralLeanFtException {
		// TODO Auto-generated method stub
		EditField salesAreaDataEditField = session
				.describe(Window.class,
						new WindowDescription.Builder().name("wnd[0]").program("SAPMV45A").screenNumber(4002l)
						.transaction("VA03").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(EditField.class, new EditFieldDescription.Builder().name("VBAK-VKORG")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
		String salesAreaDataEditField1 = salesAreaDataEditField.getText();
		System.out.println(salesAreaDataEditField1);
		EditField editField = session
				.describe(Window.class,
						new WindowDescription.Builder().name("wnd[0]").program("SAPMV45A").screenNumber(4002l)
						.transaction("VA03").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(EditField.class, new EditFieldDescription.Builder().name("VBAK-VTWEG")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
		String Sales_araea2 = editField.getText();
		System.out.println(Sales_araea2);
		EditField editField1 = session
				.describe(Window.class,
						new WindowDescription.Builder().name("wnd[0]").program("SAPMV45A").screenNumber(4002l)
						.transaction("VA03").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(EditField.class, new EditFieldDescription.Builder().name("VBAK-SPART")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
		String Sales_araea3 = editField1.getText();
		System.out.println(Sales_araea3);
		if (salesAreaDataEditField1.equals(sA1)) {
			logReport("INFO", "Sales Area Data contains" + sA1);
		} else {
			logReport("INFO", "Sales Area Data not contains" + sA1);
		}
		if (Sales_araea2.equals(sA2)) {
			logReport("INFO", "Sales Area Data contains" + sA2);
		} else {
			logReport("INFO", "Sales Area Data not contains" + sA2);
		}
		if (Sales_araea3.equals(sA3)) {
			logReport("INFO", "Sales Area Data contains" + sA3);
		} else {
			logReport("INFO", "Sales Area Data not contains" + sA3);
		}
	}

	public void VerifycustomerGroup_and_salesoffice(String customergrp) throws GeneralLeanFtException {
		// TODO Auto-generated method stub
		ComboBox customerGroupComboBox = session
				.describe(Window.class,
						new WindowDescription.Builder().name("wnd[0]").program("SAPMV45A").screenNumber(4002l)
						.transaction("VA03").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(ComboBox.class, new ComboBoxDescription.Builder().name("VBKD-KDGRP")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.COMBO_BOX).build());
		List<ComboBoxItem> CG = customerGroupComboBox.getItems();
		ComboBoxItem CG1 = customerGroupComboBox.getSelectedItem();
		System.out.println(CG);
		if (!CG1.equals(customergrp)) {
			logReport("INFO", "Customer group does not contains " + customergrp + "As Expected");
		} else if (CG1.equals(customergrp)) {
			logReport("INFO", "Customer group does contains " + customergrp + "As Expected");
		} else {
			logReport("INFO", "Customer group not expected:" + customergrp);
		}

		EditField salesOfficeEditField = session
				.describe(Window.class,
						new WindowDescription.Builder().name("wnd[0]").program("SAPMV45A").screenNumber(4002l)
						.transaction("VA03").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(EditField.class, new EditFieldDescription.Builder().name("VBAK-VKBUR")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
		String sales_office = salesOfficeEditField.getText();
		logReport("INFO", "Sles office =" + sales_office);

	}

	public void verifyCG() throws GeneralLeanFtException {
		// TODO Auto-generated method stub
		ComboBox customerGroupComboBox = session
				.describe(Window.class,
						new WindowDescription.Builder().name("wnd[0]").program("SAPMV45A").screenNumber(4002l)
						.transaction("VA03").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(ComboBox.class, new ComboBoxDescription.Builder().name("VBKD-KDGRP")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.COMBO_BOX).build());
		List<ComboBoxItem> CG = customerGroupComboBox.getItems();
		ComboBoxItem CG1 = customerGroupComboBox.getSelectedItem();
		System.out.println(CG);
		logReport("INFO", "Customer group:" + CG1);
	}

	public void verifyBusinessArea() throws GeneralLeanFtException {
		// TODO Auto-generated method stub
		Label businessAreaLabel = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId(
						"wnd[0]/usr/tabsTAXI_TABSTRIP_HEAD/tabpT\\07/ssubSUBSCREEN_BODY:SAPMV45A:4307/subCOBL:SAPLKACB:1006/lblCOBL-GSBER")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		businessAreaLabel.highlight();
		logReport("INFO", "Business area is populated");
		Businessvalue = BA_value.getText();
		logReport("INFO", "Business Area" + Businessvalue);

	}

	public void verifyBusinessAreashouldNull() throws GeneralLeanFtException {
		// TODO Auto-generated method stub
		Label businessAreaLabel = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId(
						"wnd[0]/usr/tabsTAXI_TABSTRIP_HEAD/tabpT\\07/ssubSUBSCREEN_BODY:SAPMV45A:4307/subCOBL:SAPLKACB:1006/lblCOBL-GSBER")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		businessAreaLabel.highlight();
		logReport("INFO", "Business area is populated");
		Businessvalue = BA_value.getText();
		System.out.println(Businessvalue);
		if (Businessvalue == null) {
			logReport("INFO", "Business Area is null: As expected : " + Businessvalue);
		}
	}

	public void enterTablename(String tablename) throws Exception {
		// TODO Auto-generated method stub
		leanFtSendKeys(entertablename, tablename);
		leanFtEnter();
	}

	public void enter_salesorg_Distrchannel_customergrp(String sA1, String sA2, String Cg)
			throws GeneralLeanFtException {
		// TODO Auto-generated method stub
		leanFtSendKeys(entersalesorg, sA1);
		leanFtSendKeys(enterdischannel, sA2);
		leanFtSendKeys(enterCG, Cg);
	}

	public void executeicon() throws GeneralLeanFtException {
		// TODO Auto-generated method stub
		leanFtButtonClick(executeicon, "Executeicon");
	}

	public void Verifycolumns_BA_and_CG() throws GeneralLeanFtException {
		// TODO Auto-generated method stub
		Label kDGRPLabel = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[0]/usr/lbl[28,3]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		String CG = kDGRPLabel.getText();
		System.out.println(CG);
		if (CG.equals("KDGRP")) {
			kDGRPLabel.highlight();
			logReport("INFO", "Customer Group column is present");
		} else {
			logReport("INFO", "Customer Group column is not present");
		}
		Label gSBERLabel = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[0]/usr/lbl[34,3]")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
		String BA = gSBERLabel.getText();
		System.out.println(BA);
		if (BA.equals("GSBER")) {
			kDGRPLabel.highlight();
			logReport("INFO", "Business Area column is present");
		} else {
			logReport("INFO", "Business Area column is not present");
		}

	}

	public void select_Tabs(String tab, String tabName) throws Exception {
		waitTill("6");
		TabControl selectedTab = tabs(tabName);
		selectedTab.select(tab);
		BaseLib.embedScreenShotInreportWithRobot();
		logReport("INFO", tab + " tab is selected");
		waitTill("6");
	}

	public void selectrow_chooseicon(String table) throws Exception {
		// TODO Auto-generated method stub
		try {		
			CheckBox v = checkBox(table);
			v.set(true);
		}catch(Exception e) {
			CheckBox v = checkBox("ZUService_1");
			v.set(true);
		}	

		leanFtButtonClick(chooseicon, "choose icon");
		waitTill("6");
	}

	public static String service_org;
	public static String plant_service;

	public void verifyplantservice_serviceorg() throws GeneralLeanFtException {
		// TODO Auto-generated method stub
		try {
			Label plantservice = session
					.describe(Window.class,
							new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
					.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[0]/usr/lbl[41,5]")
							.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
			plant_service = plantservice.getText();
		}catch(Exception e) {plant_service=null;}
		try {
			Label serviceorg = session
					.describe(Window.class,
							new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
					.describe(Label.class, new LabelDescription.Builder().relativeId("wnd[0]/usr/lbl[50,5]")
							.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
			service_org = serviceorg.getText();
		}catch(Exception e) {service_org=null;}
		if (!plant_service.equals(null)) {
			logReport("INFO", "plant service contains value");
			logReport("INFO", "PLANT SERVICE VALUE :" + plant_service);
		} else {
			logReport("INFO", "plant service contains no value");
		}
		if (!service_org.equals(null)) {
			logReport("INFO", "service_org contains value");
			logReport("INFO", "PLANT SERVICE VALUE :" + service_org);
		} else {
			logReport("INFO", "service_org contains no value");
		}

	}

	public void entertablenameinGeneraltabledisplayPage(String TN) throws Exception {
		// TODO Auto-generated method stub
		leanFtSendKeys(table2, TN);
		leanFtEnter();
		waitTill("6");

	}

	public void enterdocumentNumber(String salesorder) throws Exception {
		Table fldname = selectTable("FldName");
		waitTill("6");
		// fldname.activateCell(1, "Fr.Value");
		waitTill("6");
		for (int i = 0; i < fldname.getRows().size(); i++) {
			if (fldname.getRows().get(i).getCell("FLD name").getValue().equalsIgnoreCase("Document Number")) {
				fldname.getRows().get(i).getCell("Fr.Value").setValue(salesorder);
				break;
			}
		}
	}

	public void verifyPlantservice_and_Serviceorg(String SA) throws Exception {
		waitTill("6");
		Grid gridViewCtrlGrid = session
				.describe(Window.class,
						new WindowDescription.Builder().name("wnd[0]").program("SAPLSE16N").screenNumber(200l)
						.transaction("SE16N").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Grid.class, new GridDescription.Builder().name("shell")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_GRID_VIEW).build());
		System.out.println("Before Update Verification");
		for (int i = 0; i < gridViewCtrlGrid.getRows().size(); i++) {
			System.out.println("Inside loop Update Verification");
			if (gridViewCtrlGrid.getRows().get(i).getCell("Sales Organization").getValue().contains(SA)) {
				logReport("INFO", "Sales org is matched for : " + SA);
			} else if (gridViewCtrlGrid.getRows().get(i).getCell("Sales Organization").getValue().equals(service_org)) {
				logReport("INFO", "Sales org is matched for : " + service_org);
			} else {
				logReport("INFO", "Sales org not matched :"
						+ gridViewCtrlGrid.getRows().get(i).getCell("Sales Organization").getValue());
			}
		}
		for (int i = 0; i < gridViewCtrlGrid.getRows().size(); i++) {
			if (gridViewCtrlGrid.getRows().get(i).getCell("Plant Service").getValue().contains(SA)) {

				logReport("INFO", "Plantservice values is matched for : " + SA);

			} else if (gridViewCtrlGrid.getRows().get(i).getCell("Sales Organization").getValue()
					.equals(plant_service)) {
				logReport("INFO", "Plantservice values is matched for : " + plant_service);
			} else {
				logReport("INFO", "Plant Service not matched :"
						+ gridViewCtrlGrid.getRows().get(i).getCell("Plant Service").getValue());
			}
		}

	}

	public void enterIPNumber(String ipNum) throws Exception {
		waitTill("6");
		leanFtSendKeys(txt_IPNum, ipNum);
		logReport("INFO", "The entered IP number is " + ipNum);
		leanFtEnter();
	}

	public void verifyStatus(String status) throws Exception {
		waitTill("6");
		EditField value = selecteditname("IPStatus");
		String actual = value.getText();
		if (actual.contains(status)) {
			logReport("PASS", "The status is verified" + actual);
		} else {
			logReport("FAIL", "The status is  verified " + actual);
		}
	}

	public void verify_functionalLocation() throws Exception {
		EditField value = selecteditname("Functional location");
		String actual = value.getText();
		if (actual.contains(functionalNum)) {
			logReport("PASS", "The functional location is verified" + actual);
		} else {
			logReport("FAIL", "The functional location is not verified " + actual);
		}
	}

	public void verifyAccountIP() throws Exception {
		EditField value = selecteditname("shiptoIP");
		String actual = value.getText();
		if (actual.contains(accountNumber)) {
			logReport("PASS", "The Sold To and Ship To values are verified" + actual);
		} else {
			logReport("FAIL", "The Sold To and Ship To values are  verified " + actual);
		}
	}

	public void verifyFunctional_null() throws Exception {
		EditField value = selecteditname("Functional location");
		if (value.getText().isEmpty()) {
			logReport("PASS", "The functional location is verified as null");
		} else {
			logReport("FAIL", "The functional location is not verified as null");
		}
	}

	public void enter_Functional(String value) throws Exception {
		waitTill("4");
		leanFtSendKeys(txt_functional, value);
		leanFtButtonClick(btn_testExecute, "Execute");
	}

	public void savePC(String wcenter) throws Exception {
		waitTill("6");
		leanFtSendKeys(workCenter, wcenter);
		EditField file = selecteditname("pcFIle");
		file.setFocus();
		keyboardclick();
		waitTill("6");
		EditField fileloc = selecteditname("fileLocation");
		fileloc.setText(AutomationConstants.equipmentIP);
		logReport("PASS","File Uploaded");
		leanFtButtonClick(btn_continue, "Save");
		clickExecute(btn_testExecute, "Execute");
		logReport("PASS","File Uploaded Executed");
		waitTill("20");
		//while(getStatusBarValue()==null ||getStatusBarValue().isEmpty()) {}
		waitTill("25");
		String ipValue = getStatusBarValue();
		logReport("INFO", "The created order nmuber is" + ipValue);
		orderNumber = ipValue.replaceAll("[^0-9]", "");
		System.out.println(orderNumber);
		waitTill("6");
	}

	public void sapCreatedIP() throws Exception {
		if(orderNumber==null || orderNumber.isEmpty()){
			orderNumber = "400005191";
		}
		leanFtSendKeys(txt_IPNum, orderNumber);
		logReport("INFO", "The entered IP number is " + orderNumber);
		waitTill("10");
		equipment_Overview_Window().sendKey(SapFunctionKey.ENTER);
		waitTill("10");
	}

	public void verify_childRecords() throws Exception {
		Table value = leanft_tableselect("SAPLIEL2TCTRL_0110");
		logReport("INFO", "The child record is available " + value.getRows().get(0).getCell("Equipment").getValue());
	}

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
	// static TableDescription tablefirstrow = new
	// TableDescription.Builder().name("SAPLCOVGTCTRL_3010").type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());

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

	static WindowDescription SWOSearchWindow = new WindowDescription.Builder().name("wnd[0]").program("SAPLCOIH")
			.screenNumber(101l).transaction("IW33").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static WindowDescription SWOSearchWindow1 = new WindowDescription.Builder().name("wnd[0]").program("SAPMILO0").screenNumber(2100l).transaction("IL03").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();


	public static void sapenterTAcode_I2M(String TAcode) throws GeneralLeanFtException, InterruptedException {
		try {
			OKCode TACode = Window().describe(OKCode.class, oKCode);
			TACode.highlight();
			TACode.setValue(TAcode);
			Thread.sleep(2000);
			BaseLib.embedScreenShotInreportWithRobot();
			Window().sendKey(SapFunctionKey.ENTER);
			BaseLib.logReport("PASS", TAcode + " entered ");
			Thread.sleep(4000);
		} catch (Exception e) {

			OKCode oKCode = session.describe(Window.class, SWOSearchWindow1)
					.describe(OKCode.class, new OKCodeDescription.Builder()
							.type(com.hp.lft.sdk.sap.gui.ComponentType.OK_CODE_FIELD).build());
			oKCode.highlight();
			oKCode.setValue(TAcode);
			Thread.sleep(2000);
			BaseLib.embedScreenShotInreportWithRobot();
			session.describe(Window.class, SWOSearchWindow1).sendKey(SapFunctionKey.ENTER);
			BaseLib.logReport("PASS", TAcode + " entered ");
			Thread.sleep(4000);
		}
	}

	// Getting Change Number screen and window
	public static Window CNWindow() throws GeneralLeanFtException {
		Window cnwindow = null;
		cnwindow = session.describe(Window.class, SWOSearchWindow);
		cnwindow.highlight();
		return cnwindow;
	}

	public void SearchSAPSWO() throws GeneralLeanFtException, InterruptedException {
		EditField cnNumber = CNWindow().describe(EditField.class, orderEditField);
		cnNumber.highlight();
		ServiceMaxValues.put("SWONumber", AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("SAP SWO Number"));
		cnNumber.setText(ServiceMaxValues.get("SWONumber"));
		CNWindow().sendKey(SapFunctionKey.ENTER);
		Thread.sleep(6000);
		BaseLib.logReport("PASS", "SWO Number is entered");
	}

	public static Window OperationsOverviewWindow() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, operationsOV);
		return window;

	}

	public void clickonOperationsTab() throws GeneralLeanFtException {
		TabControl operationsTab = OperationsOverviewWindow().describe(TabControl.class, operationstab);
		try {
			operationsTab.select("Operations");
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		EditField SWONumber = OperationsOverviewWindow().describe(EditField.class, SAPSWONumber);
		SWONumber.highlight();
		// String actVal = SWONumber.getText();
		// if(ServiceMaxValues.get("SWONumber").equalsIgnoreCase(actVal))
		// {
		// bl.logReport("PASS","SWO number matched with : "+actVal);
		// }
		//
		// else{
		// bl.logReport("FAIL","SWO number did not match with : "+actVal);
		// Assert.fail();
		// }
	}

	public static void verifyOperationsTab1(String expField, String expVal) throws GeneralLeanFtException {

		String actVal = null;
		TableRow<TableCell> rowval;
		Table operationsTabletemp = OperationsOverviewWindow().describe(Table.class, operationsTable);
		operationsTabletemp.highlight();
		rowval = operationsTabletemp.getRows().get(0);
		switch (expField) {
		case "Plant":
			actVal = rowval.getCell(expField).getValue();
			if (expVal.equalsIgnoreCase(actVal)) {
				BaseLib.logReport("PASS", "For " + expField + " || " + expVal + ": value matched with : " + actVal);
			}

			else {
				BaseLib.logReport("FAIL", "For " + expField + " || " + expVal + ": value not matched with : " + actVal);
				Assert.fail();
			}
			break;
		case "Operation short text":
			actVal = rowval.getCell(expField).getValue();
			if (expVal.equalsIgnoreCase(actVal)) {
				BaseLib.logReport("PASS", "For " + expField + " || " + expVal + ": value matched with : " + actVal);
			}

			else {
				BaseLib.logReport("FAIL", "For " + expField + " || " + expVal + ": value not matched with : " + actVal);
				Assert.fail();
			}
			break;

		default:
		}

	}

	public void verifisetelmentTablevalues() throws GeneralLeanFtException {
		for (String colName : ServiceMaxValues.keySet()) {

			verifyOperationsTab1(colName, ServiceMaxValues.get(colName));
		}
	}

	// public void serviceMaxdata()
	// {
	// ServiceMaxValues.put("SWONumber", "40101285");
	// ServiceMaxValues.put("Plant", "ES93");
	// ServiceMaxValues.put("Operation short text", "WO-01420006");
	// ServiceMaxValues.put("CONTRACT_HEADER_SAP_EXTERNAL_ID", "0041449607");
	// ServiceMaxValues.put("Cat", "ORD");
	// ServiceMaxValues.put("Settlement Receiver", "220000004982");
	// ServiceMaxValues.put("Confirmation number", "15965854");
	// ServiceMaxValues.put("Accounting Indicator", "52");
	// }

	public static void verifySettlementTablevalues(String expField) throws GeneralLeanFtException {

		String actVal = null;
		String value = ServiceContractPage.SalesOrderIfield;
		String expVal = removeLeadingZeros(value);
		TableRow<TableCell> rowval;
		Table settlementabletemp = settlementwindow().describe(Table.class, settlementTable);
		settlementabletemp.highlight();
		rowval = settlementabletemp.getRows().get(0);
		switch (expField) {
		case "Cat":
			actVal = rowval.getCell(expField).getValue();
			if (expVal.equalsIgnoreCase(actVal)) {
				BaseLib.logReport("PASS", "For " + expField + " || " + expVal + ": value matched with : " + actVal);
			}

			else {
				BaseLib.logReport("FAIL", "For " + expField + " || " + expVal + ": value not matched with : " + actVal);
				Assert.fail();
			}
			break;
		case "Settlement Receiver":
			actVal = rowval.getCell(expField).getValue();
			expVal = expVal.replaceFirst("^0+(?!$)", "");
			if (expVal.contains(actVal)) {
				BaseLib.logReport("PASS", "For " + expField + " || " + expVal + ": value matched with : " + actVal);
			}

			else {
				BaseLib.logReport("FAIL", "For " + expField + " || " + expVal + ": value not matched with : " + actVal);
				// Assert.fail();
			}
			break;

		default:
		}

	}

	// public void verifySettlementTablevalues() throws GeneralLeanFtException,
	// InterruptedException
	// {
	// for(String colName:ServiceMaxValues.keySet())
	// {
	//
	// verifySettlementTable(colName,ServiceMaxValues.get(colName));
	// }
	// }

	public void Searchcontractnbr() throws Exception 
	{

		EditFieldDescription contractNumber = 	new EditFieldDescription.Builder().name("VBAK-VBELN")
				.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
		//leanFtSendKeys(contractNumber, AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CONTRACT_HEADER_SAP_EXTERNAL_ID"));
		leanFtSendKeys(contractNumber,"0042463484");
		leanFtEnter();

		//EditField contractNumber = contractscreenwindow().describe(EditField.class, contractEditField);
		//contractNumber.highlight();
		//System.out.println("Value : "+AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CONTRACT_HEADER_SAP_EXTERNAL_ID"));
		/*contractNumber.setText(AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CONTRACT_HEADER_SAP_EXTERNAL_ID"));
		contractscreenwindow().sendKey(SapFunctionKey.ENTER);*/
		BaseLib.logReport("PASS", "Contract Number is entered");
	}

	public static Window rrservicewindow() throws GeneralLeanFtException {
		Window Window = null;
		System.out.println("1");
		GuiSessionDescription session1 = new GuiSessionDescription.Builder().name("ses[1]").build();
		GuiSession[] textsession = GuiSessionFactory.getAllOpenSessions(session1);
		for (GuiSession sess : textsession) {
			Window = sess.describe(Window.class, rrserviceWindow);
			Window.highlight();
			System.out.println("2");
		}
		return Window;

	}

	public void salesPage() throws Exception 
	{
		waitTill("5");
		leanFtEnter();
		//Menubar confirmation = rrservicewindow().describe(Menubar.class, completionConfirmation);
		Menubar confirmation = session.describe(Window.class, new WindowDescription.Builder()
				.name("wnd[0]")
				.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Menubar.class, new MenubarDescription.Builder()
						.type(com.hp.lft.sdk.sap.gui.ComponentType.MENUBAR).build());
		confirmation.highlight();
		confirmation.select("Goto;Header;Sales");
		Thread.sleep(6000);
	}

	public static Window rrservicedatawindow() throws GeneralLeanFtException {
		Window Window = null;
		GuiSessionDescription session1 = new GuiSessionDescription.Builder().name("ses[1]").build();
		GuiSession[] textsession = GuiSessionFactory.getAllOpenSessions(session1);
		for (GuiSession sess : textsession) {
			Window = sess.describe(Window.class, rrservicedataWindow);
			Window.highlight();

		}
		return Window;

	}

	public static void verifySalesareadata() throws GeneralLeanFtException {
		String actVal = null;
		EditField salesAreaData = session.describe(Window.class, new WindowDescription.Builder()
				.name("wnd[0]")
				.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(EditField.class, new EditFieldDescription.Builder()
						.name("VBAK-VKORG")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
		actVal = salesAreaData.getText();
		if (actVal.contains("KR")) {
			BaseLib.logReport("PASS", "value matched with : " + actVal);
		}

		else {
			BaseLib.logReport("FAIL", "alue not matched with : " + actVal);
			Assert.fail();
		}

	}

	public EditField leanftEditfiled(String name) throws Exception {
		EditField value = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(EditField.class, new EditFieldDescription.Builder().name(name)
						.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
		return value;
	}

	public void dliverorder() throws Exception {
		waitTill("6");
		MenuBar("Sales document;Deliver");
		BaseLib.embedScreenShotInreportWithRobot();
		logReport("INFO", "The product selected for delivery");
	}


	public void singlepartdelivery() throws Exception {
		waitTill("6");
		Table fldname = selectTable("Single Part Delivery");
		waitTill("6");
		fldname.highlight();
		BaseLib.embedScreenShotInreportWithRobot();
		// fldname.activateCell(1, "Fr.Value");
		waitTill("6");
		fldname.getRows().get(0).getCell("Picked Qty").setValue("1");
		fldname.selectRow(1);
		BaseLib.embedScreenShotInreportWithRobot();

	}

	ButtonDescription packbtn = new ButtonDescription.Builder().name("btn[18]")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	ButtonDescription pack_btn = new ButtonDescription.Builder().name("%#AUTOTEXT001")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();

	public void clickonpackorder() throws Exception {
		leanFtButtonClick(packbtn, "Pack button");
	}

	public void ProcessingofHandling() throws Exception {
		Table fldname = selectTable("Processing of Handling");
		waitTill("6");
		// fldname.activateCell(1, "Fr.Value");
		waitTill("6");
		fldname.getRows().get(0).getCell("Packaging Materials").setValue("34");
		leanFtEnter();
		fldname.selectRow(1);
		Table fldname1 = selectTable("Materials to be Packed");
		waitTill("6");
		fldname1.selectRow(1);
		leanFtButtonClick(pack_btn, "Pack button");
		leanFtButtonClick(back_button, "Back button");
	}

	public void enter_ASONumberInSAP(String sheetName) throws Exception {
		waitTill("6");
		leanFtSendKeys(enterorder, ASOSAPNumber);
		leanFtEnter();
	}

	ButtonDescription creatserialNumberbtn=new ButtonDescription.Builder().name("btn[7]").type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	ButtonDescription pgibutton= new ButtonDescription.Builder().name("btn[20]").type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build();
	StatusBarDescription statusbar=new StatusBarDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.STATUSBAR).build();

	public void enterserialNumber() throws Exception{
		MenuBar("Extras;Serial Numbers");
		BaseLib.embedScreenShotInreportWithRobot();
		leanFtButtonClick(creatserialNumberbtn, "creatserialNumberbtn");
		leanFtButtonClick(btn_continue, "continue");
	}
	public void clickonPGI() throws GeneralLeanFtException{
		leanFtButtonClick(pgibutton, "PGI Button");
		waitTill("6");
	}
	public void verifystatus(){
		StringProperty status=statusbar.getText();
		System.out.println("status:"+ status);
	}

	public void navigateToGoodsmovemnets() throws Exception {
		// TODO Auto-generated method stub
		MenuBar("Extras;Documents for Order;Goods Movements");
	}

	public void validateMovementTypeandBatch() throws GeneralLeanFtException {
		waitTill("6");
		try {
		Grid createdTable = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Grid.class, new GridDescription.Builder().name("shell")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_GRID_VIEW).build());
		for (int i = 0; i < createdTable.getRows().size(); i++) {
			if (createdTable.getRows().get(i).getCell("Batch").getValue().equals("U")) {
				logReport("INFO", "Batch Matched ");
			} else {
				logReport("INFO", "Batch not Matched");
			}
			if (createdTable.getRows().get(i).getCell("Movement Type").getValue().equals("262")) {
				logReport("INFO", "Movement Type matched");
				if (createdTable.getRows().get(i).getCell("Material Document").getValue().equals(MN2)) {
					logReport("INFO", "Material document matched"
							+ createdTable.getRows().get(i).getCell("Material Document").getValue());
				} else {
					logReport("INFO", "Material document not matched");
				}
			} else {
				logReport("Info", "Movement type Not Matched");
			}
			if (createdTable.getRows().get(i).getCell("Movement Type").getValue().equals("261")) {
				logReport("INFO", "Movement Type matched");
				if (createdTable.getRows().get(i).getCell("Material Document").getValue().equals(MN1)) {
					logReport("INFO", "Material document matched"
							+ createdTable.getRows().get(i).getCell("Material Document").getValue());
				} else {
					logReport("INFO", "Material document not matched");
				}
			} else {
				logReport("Info", "Movement type Not Matched");
			}
		}
		}catch(Exception e) {
			
		}
	}

	@FindBy(xpath = "//td[text()='Parts']/..//td[text()='Confirmed']/..//th//a")
	private WebElement confirmedparts;

	@FindBy(xpath = "//td[text()='Parts']/..//td[text()='Returned']/..//th//a")
	private WebElement returnedparts;

	@FindBy(xpath = "(//td[text()='Valuation']/..//div)[1]")
	private WebElement valuationvalue;

	public static String confirmedpartValuationvalue;
	public static String returnedpartValuationvalue;

	@FindBy(xpath = "(//span[text()='Material Document Number']/../..//div)[1]")
	private WebElement materialdocnum;
	public static String MN1;
	public static String MN2;

	public void getValuationFromparts() {
		// TODO Auto-generated method stub
		driver.navigate().refresh();
		click("case_Details", case_Details);
		waitTill("10");
		for (int i = 0; i < 5; i++) {
			waitForElement(confirmedparts, "confirmedparts");
			if (verifyElementPresent("confirmedparts", confirmedparts)) {
				click("confirmedparts", confirmedparts);
				waitTill("3");
				confirmedpartValuationvalue = valuationvalue.getText();
				if (confirmedpartValuationvalue.equals("U")) {
					logReport("INFO", "Valuation type matched");
					MN1 = materialdocnum.getText();
				} else {
					logReport("INFO", "Valuation type not matched");
				}
				break;
			} else {
				i++;
			}
		}
		driver.navigate().back();
		waitTill("3");
		click("case_Details", case_Details);
		waitForElement(confirmedparts, "confirmedparts");
		click("returnedparts", returnedparts);
		waitTill("3");
		returnedpartValuationvalue = valuationvalue.getText();
		if (returnedpartValuationvalue.equals("U")) {
			logReport("INFO", "Valuation type matched");
			MN2 = materialdocnum.getText();
		} else {
			logReport("INFO", "Valuation type not matched");
		}
	}    

	public void verifycreatedsalesdata(String value) throws Exception {
		waitTill("15");
		MenuBar("Environment;Changes;Agreement");
		waitTill("6");
		Grid salesDeal = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Grid.class, new GridDescription.Builder().name("shell")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_GRID_VIEW).build());
		//        if (salesDeal.exists()) {
		salesDeal.highlight();
		for (int i=0;i<salesDeal.getRows().size();i++){

			if (salesDeal.getRows().get(i).getCell("Change Indicator").getValue().equalsIgnoreCase(value)) {

				logReport("INFO", "Sales deal values is matched for : "+value+"");
				break;
			} else if (salesDeal.getRows().get(i).getCell("Change Indicator").getValue().equalsIgnoreCase(value)) {
				logReport("INFO", "Sales deal values is matched for : "+value+"");
			}
			else {
				logReport("INFO", "Sales values is not matched");
			}

		}

	}


	public void selectAgreementChange() throws Exception {
		leanFtButtonClick(back_button, "Back");
		waitTill("6");
		MenuBar("Agreement;Change");
		waitTill("6");
		leanFtEnter();

	}

	public void verifyUpdatesalesdata(String behaviour, String terms) throws Exception {
		waitTill("6");
		Grid salesDeal = session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Grid.class, new GridDescription.Builder().name("shell")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_GRID_VIEW).build());
		waitTill("6");
		//
		//            if (salesDeal.exists()) {
		//                salesDeal.highlight();
		//                salesDeal.getRows().get(0).getCell("Object value").click();
		//                keyboardarrow();
		System.out.println("Before Update Verification");
		for (int i = 0; i < salesDeal.getRows().size(); i++) {
			System.out.println("Inside loop Update Verification");
			if(salesDeal.getRows().get(i).getCell("New value").getValue().equals(behaviour))
			{
				logReport("INFO", "Sales deal values is matched for : "+behaviour+"");
			}
			else if(salesDeal.getRows().get(i).getCell("New value").getValue().equals(terms)) {

				logReport("INFO", "Sales deal values is matched for : "+terms+"");

			}
		}
		logReport("PASS", "The created contracts are validated");
	}






	public void enter_swo() throws Exception{
		leanFtSendKeys(txt_SWOorder,sapSalesnum);
		leanFtEnter();
	}

	public void verifySWO(String salesdoc) throws Exception{
		waitTill("6");
		leanFtButtonClick(btn_enhance, "Enhancement");
		if(leanftEditfiled("AFVGD-USR01").getText().equalsIgnoreCase(salesdoc)){
			logReport("PASS", "The sales document number is verfied ");
		}else{
			logReport("INFO", "The sales document number is verified");
		}
	}

	//    		public void serviceMaxdata()
	//    		{
	//    			ServiceMaxValues.put("SWONumber", "40101285");
	//    			ServiceMaxValues.put("Plant", "ES93");
	//    			ServiceMaxValues.put("Operation short text", "WO-01420006");
	//    			ServiceMaxValues.put("CONTRACT_HEADER_SAP_EXTERNAL_ID", "0041449607");
	//    			ServiceMaxValues.put("Cat", "ORD");
	//    			ServiceMaxValues.put("Settlement Receiver", "220000004982");
	//    			ServiceMaxValues.put("Confirmation number", "15965854");
	//    			ServiceMaxValues.put("Accounting Indicator", "52"); 
	//    		}
	public void getNetvalueandverify() throws GeneralLeanFtException{
		waitTill("6");
		Table orderTable = session.describe(Window.class, new WindowDescription.Builder()
				.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(Table.class, new TableDescription.Builder()
						.name("SAPMV45ATCTRL_U_ERF_KONTRAKT")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.TABLE_CONTROL).build());
		orderTable.highlight();
		String s1=orderTable.getRows().get(0).getCell("Net value").getValue();
		System.out.println(s1);
		System.out.println(tcp2);
		if(s1.contains(tcp2)){
			logReport("INFO", "Net value and Total contract Price are same");
		}else{
			logReport("INFO", "Net value and Total contract Price are not same");
		}
	}


	@FindBy(xpath="//span[text()='SAP Integration Status']/../..//div[text()='Sent to SAP Success']")
	private WebElement sapintegrationstatus;

	@FindBy(xpath="(//span[text()='SAP Integration Status']/../..//div)[2]")
	private WebElement sapintegrationstatus1;

	@FindBy(xpath = "//*[text()='Contract Header SAP External ID']/following-sibling::*//div")
	private WebElement CONTRACT_HEADER_SAP_EXTERNAL_ID;

	@FindBy(xpath="(//span[text()='Total Contract Price']/../../..//div)[2]")
	private WebElement totalcontractprice_1;

	public static String tcp;public static String tcp1;public static String tcp2;public static String Contractid;

	public void SAPIntegrationstatus(){
		waitTill("6");
		driver.navigate().refresh();
		waitTill("6");
		driver.navigate().refresh();
		for(int i=0;i<5;i++){
			waitTill("6");
			if(verifyElementPresent("sapintegrationstatus", sapintegrationstatus)){
				logReport("INFO", "Status successfull");
				break;

			}
			else{
				logReport("INFO", "Status not successfull Status is "+sapintegrationstatus1.getText());
				i++;
			}
		}


		Contractid=CONTRACT_HEADER_SAP_EXTERNAL_ID.getText();
		tcp=totalcontractprice_1.getText();
		tcp1=tcp.replace("$", "");
		tcp2=tcp1.replace(".", ",");
		System.out.println(tcp2);
		System.out.println(CONTRACT_HEADER_SAP_EXTERNAL_ID.getText());

	}

	public void Searchcontract() throws Exception{
		EditFieldDescription contractEditField = new EditFieldDescription.Builder()
				.name("VBAK-VBELN")
				.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build();
		leanFtSendKeys(contractEditField, Contractid);
		leanFtEnter();
		Thread.sleep(6000);
		BaseLib.logReport("PASS", "Contract Number is entered");	
	}



	public void add_packing_idebtification(String packing,String identification) throws Exception{
		Table fldname = selectTable("Processing of Handling");
		waitTill("6");
		fldname.getRows().get(0).getCell("Packaging Materials").setValue(packing);
		BaseLib.embedScreenShotInreportWithRobot();
		leanFtEnter();
		fldname.activateCell(1, "Packaging Materials");
		waitTill("6");
		leanFtSendKeys(txt_idebtification, identification);
		leanFtButtonClick(backButton, "back button");
		fldname.selectRow(1);
		BaseLib.embedScreenShotInreportWithRobot();
		Table fldname1 = selectTable("Materials to be Packed");
		waitTill("6");
		fldname1.selectRow(1);
		BaseLib.embedScreenShotInreportWithRobot();
		leanFtButtonClick(pack_btn, "Pack button");
		leanFtButtonClick(back_button, "Back button");
	}

	public void save_delivery() throws Exception{
		waitTill("6");
		leanFtButtonClick(btn_save, "Save");
		waitTill("6");
		String txt_status = getStatusBarValue();
		BaseLib.embedScreenShotInreportWithRobot();
		logReport("INFO", "The created order nmuber is" + txt_status);
		documentNumber = txt_status.replaceAll("[^0-9]", "");
		System.out.println(documentNumber);
		waitTill("6");
	}


	public void add_document_PGI() throws Exception{
		leanFtSendKeys(txt_documentValue, documentNumber);
		leanFtButtonClick(pgibutton, "PGI");
		logReport("INFO", "The Post Good Issue selected");
		waitTill("6");
		logReport("INFO", getStatusBarValue());
	}


	// public void serviceMaxdata()
	// {
	// ServiceMaxValues.put("SWONumber", "40101285");
	// ServiceMaxValues.put("Plant", "ES93");
	// ServiceMaxValues.put("Operation short text", "WO-01420006");
	// ServiceMaxValues.put("CONTRACT_HEADER_SAP_EXTERNAL_ID", "0041449607");
	// ServiceMaxValues.put("Cat", "ORD");
	// ServiceMaxValues.put("Settlement Receiver", "220000004982");
	// ServiceMaxValues.put("Confirmation number", "15965854");
	// ServiceMaxValues.put("Accounting Indicator", "52");
	// }

	// public void serviceMaxdata()
	// {
	// ServiceMaxValues.put("ContactSearch",
	// AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CONTACT_EXTERNALID"));
	// ServiceMaxValues.put("ContactPerson",
	// AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CONTACT_EXTERNALID"));
	// ServiceMaxValues.put("FirstName",
	// AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CONTACT_FN"));
	// ServiceMaxValues.put("LastName",
	// AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CONTACT_LN"));
	// ServiceMaxValues.put("Language",
	// AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CONTACT_LANGUAGE"));
	// ServiceMaxValues.put("Telephone",
	// AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CONTACT_BUSPHONE"));
	// }

	public ComboBox getcontactLanguage() throws GeneralLeanFtException {
		return session
				.describe(Window.class,
						new WindowDescription.Builder().type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
				.describe(ComboBox.class, new ComboBoxDescription.Builder().name("ADDR3_DATA-LANGU_P")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.COMBO_BOX).build());
	}

	public void verifyContactDetails() throws GeneralLeanFtException, Exception {
		// serviceMaxdata();
		leanFtSendKeys(contactsearch, AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CONTACT_EXTERNALID"));
		leanFtEnter();

		verify_fieldValue(selecteditname("ContactPerson").getText(),
				AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CONTACT_EXTERNALID"));
		verify_fieldValue(selecteditname("ContactLastName").getText(),
				AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CONTACT_LN"));
		verify_fieldValue(selecteditname("ContactFirstName").getText(),
				AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CONTACT_FN"));
		verify_fieldValue(selecteditname("ContactTelephone").getText(),
				AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CONTACT_BUSPHONE"));
		verify_fieldValue(getcontactLanguage().getSelectedItem().getText(),
				AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("CONTACT_LANGUAGE"));

	}

	public void verify_fieldValue(String avalue, String evalue) throws Exception {
		if (avalue.equalsIgnoreCase(evalue)) {
			logReport("PASS", "Expected value is " + evalue + " actual value is " + avalue);
		} else {
			logReport("PASS", "Expected value is " + evalue + " actual value is " + avalue);
		}
	}

	public void readTestDataforSAP(String TCNumber) throws RuntimeException, FileNotFoundException, IOException
	{
		TestData = Excel.getFirstRowData(AutomationConstants.DataFilePath, TCNumber);
	}

	public void verifyAcctIndicatorAcctpage() throws GeneralLeanFtException {
		EditField acctIndicEditField = session.describe(EditField.class, new EditFieldDescription.Builder()
				.attachedText("AcctIndic")
				.name("CAUFVD-BEMOT")
				.type(com.hp.lft.sdk.sap.gui.ComponentType.C_TEXT_FIELD).build());
		acctIndicEditField.highlight();
		waitTill("6");
		BaseLib.embedScreenShotInreportWithRobot();
		verifyBooleanStatus(acctIndicEditField.getText(), "55");
	}

	public void verifyAcctIndicatorPlannedActualComparision() throws Exception {
		waitTill("6");
		MenuBar("Extras;Cost reports;Planned/actual comparison");
		Button changeLayoutCtrlF8Button = session.describe(Button.class, new ButtonDescription.Builder()
				.tooltip("Change Layout...   (Ctrl+F8)")
				.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build());
		changeLayoutCtrlF8Button.highlight();
		BaseLib.embedScreenShotInreportWithRobot();
		changeLayoutCtrlF8Button.click();
		waitTill("6");
		Grid columnSetGrid = session.describe(Grid.class, new GridDescription.Builder()
				.name("shell")
				.title("Column Set")
				.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_GRID_VIEW).build());

		for (int i = 0; i < columnSetGrid.getRows().size(); i++) {
			if(columnSetGrid.getRows().get(i).getCell("Column Name").getValue().equals("Accounting Indicator"))
			{
				try {
					columnSetGrid.getRows().get(i).getCell("Column Name").click();
				}catch (Exception e) {
					// TODO: handle exception
				}
				break;
			}
		}
		waitTill("6");
		BaseLib.embedScreenShotInreportWithRobot();
		Button showSelectedFieldsF7Button = session.describe(Button.class, new ButtonDescription.Builder()
				.name("APP_WL_SING")
				.tooltip("Show Selected Fields (F7)")
				.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build());
		showSelectedFieldsF7Button.highlight();
		BaseLib.embedScreenShotInreportWithRobot();
		showSelectedFieldsF7Button.click();
		waitTill("6");
		Button copyEnterButton = session.describe(Button.class, new ButtonDescription.Builder()
				.tooltip("Copy   (Enter)")
				.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build());
		copyEnterButton.highlight();
		copyEnterButton.click();

		Grid gridViewCtrlGrid = session.describe(Grid.class, new GridDescription.Builder()
				.name("shell")
				.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_GRID_VIEW).build());
		for (int i = 0; i < gridViewCtrlGrid.getRows().size(); i++) {
			if(!gridViewCtrlGrid.getRows().get(i).getCell("Accounting Indicator").getValue().equals(""))
			{

				verifyBooleanStatus(gridViewCtrlGrid.getRows().get(i).getCell("Accounting Indicator").getValue(), "55");
			}
		}
		BaseLib.embedScreenShotInreportWithRobot();
	}
	// Starting LeanFt Runtime engine
	public static void leanftruntimeengineStart() throws IOException, InterruptedException {
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "leanft.bat start");
		File dir = new File(LeanFTConfiguration.LEANFT_BIN);
		pb.directory(dir);
		Process p = pb.start();
		Thread.sleep(10000);
		System.out.println("LeanFT RunTime Engine is Started");
	}

	public static Window ASOPartsWindow() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, ASO_Single_Parts_Overview_Window);
		return window;

	}
	public static Window ASO_Single_Parts_OverviewWindow() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, ASO_Single_Parts_Overview_Window);
		return window;

	}

	public static Window ASO_Single_Parts_Delivery_Overview_Window() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, ASO_Single_Parts_Delivery_Overview_Window);
		return window;

	}

	public static Window ASO_Single_Parts_Delivery_Packing_Overview_Window() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, ASO_Delivery_Packing_Overview_Window);
		return window;

	}

	public static Window ASO_Delivery_Handling_Overview_Window() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, ASO_Delivery_Handling_Overview_Window);
		return window;

	}
	public static Window ASO_Maintain_Serialize_Overview_Window() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, ASO_Serialize_Overview_Window);
		return window;

	}
	public static Window header_Data_Overview_Window() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, HeaderData_Overview_Window);
		return window;

	}
	public static Window header_Data_Conditions_Overview_Window() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, HeaderData_Conditions_Overview_Window);
		return window;

	}
	public static Window material_Document_Overview_Window() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, Material_Document_Overview_Window);
		return window;

	}
	public static Window accounting_Document_Overview_Window() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, Accounting_Document_Overview_Window);
		return window;

	}
	public static Window Accounting_Document_Window() throws GeneralLeanFtException {

		Window window = session.describe(Window.class, Accounting_Document_Window);
		return window;
	}

	public static Window FISLLocalActua_Window() throws GeneralLeanFtException {

		Window window = session.describe(Window.class, FISLLocalActualWindow);
		return window;
	}
	public static Window displayMaterialDocument_Window() throws GeneralLeanFtException {

		Window window = session.describe(Window.class, displayMaterialDocument);
		return window;
	}
	public static Window equipment_Overview_Window() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, equipment_Overview_window);
		return window;
	}
	public static Window equipment_Overview_Window2() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, equipment_Overview_window2);
		return window;
	}
	public static Window functional_Loc_Window() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, functional_Location_Window);
		return window;
	}
	public static Window ItemData_Overview_Window() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, ItemData_Overview_Window);
		return window;
	}
	public static Window ASOSingleSalesOrderWindow() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, ASOSingleSalesOrderWindow);
		return window;
	}
	public static Window DocumentFlowWindow() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, DocumentFlowWindow);
		return window;
	}
	public static Window singlePartsDialogWindow() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, singlePartsDialog);
		return window;
	}
	public static Window lineItemWindow() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, lineItemWindow);
		return window;
	}
	public static Window outputDeliveryWindow() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, outputDeliveryWindow);
		return window;
	}
	public static Window deliveryWindow() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, deliveryWindow);
		return window;
	}
	public static Window TechnicalInformation_Window() throws GeneralLeanFtException {

		Window window = session.describe(Window.class, TechnicalInformation);
		return window;
	}
	public void SearchSAPSWO(String orderField) throws GeneralLeanFtException, InterruptedException, IOException {
		EditField cnNumber;
		switch (orderField) {
		case "ASO-Item":
			// String[] data =
			// AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("ASO_ITEM").split("-");
			String as01 = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("ASO_ITEM1");
			//String as01 = "127038524";
			cnNumber = CNWindow("ASO-Item").describe(EditField.class, ASOOrderEditField);
			cnNumber.highlight();
			cnNumber.setText(as01);
			BaseLib.embedScreenShotInreportWithRobot();
			CNWindow("ASO-Item").sendKey(SapFunctionKey.ENTER);
			Thread.sleep(6000);
			try {
				Grid documentsInAccountingGrid = TechnicalInformation_Window().describe(Grid.class, TechnicalInformationdocTable);
				documentsInAccountingGrid.getRows().get(0).getCells().get(1).click();
				Thread.sleep(6000);
				EditField reqDelivDate = reqDelivDateEditFieldWindow().describe(EditField.class, reqDelivDateEditField);
				reqDelivDate.highlight();
				String actVal = reqDelivDate.getText();
				System.out.println("actVal:"+actVal);
				BaseLib.embedScreenShotInreportWithRobot();
				AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("reqDelivDate",actVal);
			}catch(Exception e) {}
			try {
				OKCode TACode = ASOPartsWindow().describe(OKCode.class, oKCode);

				TACode.setValue("/nva03");
				Thread.sleep(2000);
				BaseLib.embedScreenShotInreportWithRobot();
				ASOPartsWindow().sendKey(SapFunctionKey.ENTER);
				BaseLib.logReport("PASS", "va03" + " entered ");
				Thread.sleep(4000);
			}catch(Exception e) {

			}
			try {
				cnNumber = CNWindow("ASO-Item").describe(EditField.class, ASOOrderEditField);
				cnNumber.highlight();
				cnNumber.setText(as01);
				BaseLib.embedScreenShotInreportWithRobot();
				CNWindow("ASO-Item").sendKey(SapFunctionKey.ENTER);
				Thread.sleep(6000);
			}catch(Exception e) {

			}
			Thread.sleep(6000);
			try {
				Button back = TechnicalInformation_Window().describe(Button.class, backbutton);
				back.highlight();
				back.click();
				Thread.sleep(2000);
				EditField reqDelivDate = selectionDate_Window().describe(EditField.class, selectionDate);
				reqDelivDate.highlight();
				reqDelivDate.setText(AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("reqDelivDate"));
				Thread.sleep(2000);
				BaseLib.embedScreenShotInreportWithRobot();
				ASOPartsWindow().sendKey(SapFunctionKey.ENTER);
				Thread.sleep(8000);
			}catch(Exception e) {}
			BaseLib.logReport("PASS", "CN Number is entered");
			break;
		case "DMR":
			// String[] data =
			String data = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("ASO_ITEM1");
			cnNumber = CNWindow("ASO-Item").describe(EditField.class, ASOOrderEditField);
			cnNumber.highlight();
			cnNumber.setText(data);
			CNWindow("ASO-Item").sendKey(SapFunctionKey.ENTER);
			Thread.sleep(6000);
			BaseLib.logReport("PASS", "CN Number is entered");
			break;
		case "ASO-Delivery":
			cnNumber = CNWindow("ASO-Delivery").describe(EditField.class, ASODeliveryEditField);
			cnNumber.highlight();
			ASO_DELIVERY_NO = cnNumber.getText();
			BaseLib.embedScreenShotInreportWithRobot();
			CNWindow("ASO-Delivery").sendKey(SapFunctionKey.ENTER);
			Thread.sleep(4000);
			BaseLib.logReport("PASS", "CN Number is entered");
			break;
		case "ASO-Sales-Order":
			cnNumber = CNWindow("ASO-Sales-Order").describe(EditField.class, ASOSalesOrderEditField);
			cnNumber.highlight();
			// AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("ASO_")
			cnNumber.setText("0126459825");
			BaseLib.embedScreenShotInreportWithRobot();
			CNWindow("ASO-Sales-Order").sendKey(SapFunctionKey.ENTER);
			Thread.sleep(4000);
			BaseLib.logReport("PASS", "CN Number is entered");

			try {
				Button continueEnterButton = session.describe(Window.class, new WindowDescription.Builder()
						.name("wnd[1]")
						.program("SAPMSDYP")
						.screenNumber(10l)
						.transaction("VA02")
						.type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW).build())
						.describe(Button.class, new ButtonDescription.Builder()
								.name("btn[0]")
								.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build());
				continueEnterButton.highlight();
				continueEnterButton.click();
				BaseLib.embedScreenShotInreportWithRobot();
				Thread.sleep(2000);
			}catch(Exception e) {}
			break;
		default:
			cnNumber = CNWindow("").describe(EditField.class, orderEditField);
			cnNumber.highlight();
			cnNumber.setText("0126455669");
			BaseLib.embedScreenShotInreportWithRobot();
			CNWindow("").sendKey(SapFunctionKey.ENTER);
			Thread.sleep(6000);
			BaseLib.logReport("PASS", "CN Number is entered");
			break;
		}
	}
	public void clickonItemOveriviewTab(String tab, String win) throws GeneralLeanFtException, InterruptedException {

		TabControl operationsTab;
		Thread.sleep(5000);
		switch (win) {
		case "ASO-Item":
			switch (tab) {
			case "Item-Overview":
				try {
					operationsTab = ASOPartsWindow().describe(TabControl.class, ASO_Item_Overview_Tab);
					operationsTab.highlight();
					operationsTab.select("Item overview");
					BaseLib.embedScreenShotInreportWithRobot();
					Thread.sleep(2000);
				} catch (Exception e) {
				}
				break;
			}
			break;
		case "ASO-Delivery":
			switch (tab) {
			case "Picking":
				try {
					operationsTab = ASO_Single_Parts_Delivery_Overview_Window().describe(TabControl.class,
							ASO_Delivery_Picking_Tab);
					operationsTab.highlight();
					operationsTab.select("Picking");
					BaseLib.embedScreenShotInreportWithRobot();
					Thread.sleep(2000);
				} catch (Exception e) {
				}
				break;
			}
			break;
		case "Header-Data":
			switch (tab) {
			case "Conditions":
				try {
					operationsTab = header_Data_Overview_Window().describe(TabControl.class,
							Header_Data_Table);
					operationsTab.highlight();
					operationsTab.select("Conditions");
					BaseLib.embedScreenShotInreportWithRobot();
					Thread.sleep(2000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "Partners":
				try {
					operationsTab = header_Data_Conditions_Overview_Window().describe(TabControl.class,
							Header_Data_Table);
					operationsTab.highlight();
					operationsTab.select("Partners");
					BaseLib.embedScreenShotInreportWithRobot();
					Thread.sleep(2000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
			break;
		case "Equipment":
			switch (tab) {
			case "Structure":
				Thread.sleep(4000);
				try {
					TabControl tABSTRIPTabControl = equipment_Overview_Window2().describe(TabControl.class, structure_Tab2);

					tABSTRIPTabControl.select("Structure");
					BaseLib.embedScreenShotInreportWithRobot();
					Thread.sleep(6000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
			break;
		case "Item-Data":
			switch (tab) {
			case "Partners":
				Thread.sleep(4000);
				try {
					TabControl tABSTRIPTabControl = ItemData_Overview_Window().describe(TabControl.class, taxi_structure_Tab);

					tABSTRIPTabControl.select("Partners");
					BaseLib.embedScreenShotInreportWithRobot();
					Thread.sleep(6000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
			break;
		}
	}
	public void select_ASO_Item() throws GeneralLeanFtException {

		// String[] data =
		// AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("ASO_ITEM2").split("-");
		String aso = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("ASO_ITEM2");
		//String[] data = "0126459381 - 000011".split("-");
		//String item = data[1].trim();
		//String aso = "000011";
		String item =aso;
		String dataVal = "";
		int indexVal = -1;
		for (int i = 0; i < item.length(); i++) {
			int index = item.lastIndexOf("0");
			if ((index + 1) == item.length()) {
				if (!item.substring(index - 1).equalsIgnoreCase("00")) {
					dataVal = item.substring(index - 1);

				} else if (!item.substring(index - 2).equalsIgnoreCase("000")) {
					dataVal = item.substring(index - 1);
				} else if (!item.substring(index - 3).equalsIgnoreCase("0000")) {
					dataVal = item.substring(index - 3);
				} else {
					dataVal = "0";
				}
			} else if (index == (item.length() - 2)) {
				dataVal = item.substring(index + 1);
			} else {
				dataVal = item.substring(index + 1);
			}
		}
		Table settlementabletemp = ASOPartsWindow().describe(Table.class, ASO_Item_Overview_Table);
		settlementabletemp.highlight();
		for (int j = 0; j < settlementabletemp.getRows().size(); j++) {
			String val = settlementabletemp.getRows().get(j).getCell("Item").getValue();
			System.out.println("TANA ASO Item L:"+val);
			if (val.equalsIgnoreCase(dataVal)) {
				indexVal = j + 1;
				break;
			}
		}
		settlementabletemp.selectRow(indexVal);
		BaseLib.embedScreenShotInreportWithRobot();
	}

	public void maintain_Serial_Number() throws GeneralLeanFtException, InterruptedException {

		Button backButton = ASO_Maintain_Serialize_Overview_Window().describe(Button.class, serializeButton);
		backButton.highlight();
		backButton.click();
		Button continueBTN = ASO_Maintain_Serialize_Overview_Window().describe(Button.class, continueEnterButton);
		continueBTN.highlight();
		continueBTN.click();
		BaseLib.embedScreenShotInreportWithRobot();
	}

	public void select_Sales_Document_Deliver(String menu) throws GeneralLeanFtException, InterruptedException {
		Menubar confirmation;
		switch (menu) {
		case "Sales Document and Deliver":
			try {
				confirmation = ASO_Single_Parts_OverviewWindow().describe(Menubar.class, completionConfirmation);
				confirmation.highlight();
				confirmation.select("Sales document;Deliver");
				Thread.sleep(6000);
				BaseLib.embedScreenShotInreportWithRobot();
			}catch(Exception e) {}
			break;
		case "Extras Serialize Number":
			try {
				confirmation = ASO_Single_Parts_Delivery_Overview_Window().describe(Menubar.class, completionConfirmation);
				confirmation.highlight();
				confirmation.select("Extras;Serial Numbers");
				BaseLib.embedScreenShotInreportWithRobot();
			}catch(Exception e) {}
			Thread.sleep(5000);
			try {
				maintain_Serial_Number();
				Thread.sleep(6000);
			}catch(Exception e) {}
			break;
		case "Extras Delivery Output Item":
			try {
				confirmation = lineItemWindow().describe(Menubar.class, completionConfirmation);
				confirmation.highlight();
				confirmation.select("Extras;Delivery Output;Item");
				Thread.sleep(5000);
				BaseLib.embedScreenShotInreportWithRobot();
				break;
			}catch(Exception e) {}
		}
	}

	public void update_Picking_Quantity() throws GeneralLeanFtException, InterruptedException {
		Thread.sleep(5000);
		Table settlementabletemp = ASO_Single_Parts_Delivery_Overview_Window().describe(Table.class,
				ASO_Delivery_Picking_Table);
		try {
			settlementabletemp.highlight();
		}catch(Exception e) {
			perform_Deroute_selection_Date();
			TabControl operationsTab = ASO_Single_Parts_Delivery_Overview_Window().describe(TabControl.class,
					ASO_Delivery_Picking_Tab);
			operationsTab.highlight();
			operationsTab.select("Picking");
			Thread.sleep(2000);
			BaseLib.embedScreenShotInreportWithRobot();
		}
		for (int j = 0; j < settlementabletemp.getRows().size(); j++) {

			settlementabletemp.selectRow(j + 1);
		}
		for (int j = 0; j < settlementabletemp.getRows().size(); j++) {
			String val = settlementabletemp.getRows().get(j).getCell("Material").getValue();
			if (!(val == null)) {
				if (!val.isEmpty()) {
					TableCell row = settlementabletemp.getRows().get(j).getCell("Picked Qty");
					row.setValue("1");

				}
			}
		}
		BaseLib.embedScreenShotInreportWithRobot();
		Thread.sleep(5000);
	}

	public void pack_ASO_Delivery_Items() throws GeneralLeanFtException, InterruptedException {

		Table settlementabletemp = ASO_Single_Parts_Delivery_Overview_Window().describe(Table.class,
				ASO_Delivery_Picking_Table);
		settlementabletemp.highlight();
		for (int j = 0; j < settlementabletemp.getRows().size(); j++) {

			settlementabletemp.selectRow(j + 1);
		}
		Button backbutton = ASO_Single_Parts_Delivery_Overview_Window().describe(Button.class, packShiftButton);
		backbutton.highlight();
		BaseLib.embedScreenShotInreportWithRobot();
		backbutton.click();
		Thread.sleep(5000);
	}

	public void update_Packing_Materials() throws GeneralLeanFtException, InterruptedException {

		Table settlementabletemp = ASO_Single_Parts_Delivery_Packing_Overview_Window().describe(Table.class,
				ASO_Deleivery_Packing_Table);
		TableCell row = settlementabletemp.getRows().get(0).getCell("Packaging Materials");
		row.setValue("38");

		ASO_Single_Parts_Delivery_Packing_Overview_Window().sendKey(SapFunctionKey.ENTER);
		BaseLib.embedScreenShotInreportWithRobot();
		ASO_Single_Parts_Delivery_Packing_Overview_Window().sendKey(SapFunctionKey.CTRL_F2);
		Thread.sleep(5000);
	}

	public void update_Identification_in_ASO_Delivery_Handling() throws GeneralLeanFtException, InterruptedException {

		EditField cnNumber = ASO_Delivery_Handling_Overview_Window().describe(EditField.class, identificationEditField);
		cnNumber.highlight();
		cnNumber.setText("UPS");
		cnNumber.setFocus();
		BaseLib.embedScreenShotInreportWithRobot();
		Thread.sleep(6000);
	}
	public void click_Back_Button() throws GeneralLeanFtException, InterruptedException {

		Button back = ASO_Delivery_Handling_Overview_Window().describe(Button.class, backbutton);
		back.highlight();
		back.click();
		Thread.sleep(2000);
	}
	public void pack_ASO_Delivery_Items_For() throws GeneralLeanFtException, InterruptedException {
		Table settlementabletemp = ASO_Single_Parts_Delivery_Packing_Overview_Window().describe(Table.class,
				ASO_Deleivery_Packing_Table);

		settlementabletemp.selectRow(1);
		settlementabletemp.highlight();

		Table settlementabletemp2 = ASO_Single_Parts_Delivery_Packing_Overview_Window().describe(Table.class,
				ASO_Delivery_Packing_Table);
		settlementabletemp2.selectRow(1);
		settlementabletemp2.highlight();
		BaseLib.embedScreenShotInreportWithRobot();
		Button continueBTN = ASO_Single_Parts_Delivery_Packing_Overview_Window().describe(Button.class, packButton);
		continueBTN.highlight();
		continueBTN.click();
		Thread.sleep(6000);

		Button saveBTN = ASO_Single_Parts_Delivery_Packing_Overview_Window().describe(Button.class, saveButton);
		saveBTN.highlight();
		saveBTN.click();
		Thread.sleep(6000);
	}
	public static Window Outbound_Delivery_OKCode_Overview_Window() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, ASO_Outbound_Delivery_Window);
		return window;

	}
	public void outbound_Delivery_OKCode(String TAcode) throws GeneralLeanFtException {

		switch(TAcode) {
		case "/nvl02n":
			try {
				OKCode TACode = Outbound_Delivery_OKCode_Overview_Window().describe(OKCode.class, oKCode);
				TACode.highlight();
				TACode.setValue(TAcode);
				Thread.sleep(4000);
				Outbound_Delivery_OKCode_Overview_Window().sendKey(SapFunctionKey.ENTER);
				BaseLib.logReport("PASS", TAcode + " entered ");
				Thread.sleep(4000);
			} catch (InterruptedException e) {

			}
			break;
		case "/nie03":
			try {
				OKCode TACode = ItemData_Overview_Window().describe(OKCode.class, oKCode);
				TACode.highlight();
				TACode.setValue(TAcode);
				Thread.sleep(2000);
				ItemData_Overview_Window().sendKey(SapFunctionKey.ENTER);
				BaseLib.logReport("PASS", TAcode + " entered ");
				Thread.sleep(4000);
			} catch (InterruptedException e) {			}
			break;
		case "/nil03":
			try {
				OKCode TACode = equipment_Overview_Window2().describe(OKCode.class, oKCode);
				TACode.highlight();
				TACode.setValue(TAcode);
				Thread.sleep(2000);
				equipment_Overview_Window2().sendKey(SapFunctionKey.ENTER);
				BaseLib.logReport("PASS", TAcode + " entered ");
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case "/nzvblueroom":
			try {
				OKCode TACode = outputDeliveryWindow().describe(OKCode.class, oKCode);
				TACode.highlight();
				TACode.setValue(TAcode);
				Thread.sleep(2000);
				outputDeliveryWindow().sendKey(SapFunctionKey.ENTER);
				BaseLib.logReport("PASS", TAcode + " entered ");
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;			
		}


	}
	public static Window Post_Goods_Issues_Overview_Window() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, ASO_PostGoodsIssue_Overview_Window);
		return window;

	}
	public static Window BlueRoomWindow() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, blueRoom);
		return window;

	}
	public static Window Outbound_Delivery_Win() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, Outbound_Delivery_Win);
		return window;

	}
	public void post_Goods_Issues() throws GeneralLeanFtException, InterruptedException {
		Thread.sleep(4000);
		Button saveBTN = Post_Goods_Issues_Overview_Window().describe(Button.class, postGoodsIssueButton);
		saveBTN.highlight();
		try {
			saveBTN.click();
			Thread.sleep(6000);
		}catch(Exception e) {
			Thread.sleep(6000);
			try {
				SearchSAPSWO("ASO-Delivery");
				Thread.sleep(6000);
				saveBTN.click();
				Thread.sleep(4000);
			}catch(Exception e1) {}
		}
	}
	public void click_Header_Button() throws GeneralLeanFtException, InterruptedException {
		Button saveBTN = ASOPartsWindow().describe(Button.class, headButton);
		saveBTN.highlight();
		saveBTN.click();
		Thread.sleep(4000);
	}
	public void verify_ASO_Item_Net_Value() throws GeneralLeanFtException, InterruptedException {
		Thread.sleep(4000);
		Table settlementabletemp = ASOPartsWindow().describe(Table.class, DMR_Item_Overview_Table);
		settlementabletemp.highlight();
		try {
			for (int j = 0; j < settlementabletemp.getRows().size(); j++) {
				String val = settlementabletemp.getRows().get(j).getCell("Description").getValue();
				String expval = settlementabletemp.getRows().get(j).getCell("Net value").getValue();
				switch(val) {
				case "LEAD SET RADIOLUCENT 7 LEAD 72inn":
					//String actval = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("").toString();
					String actval ="540,00";
					if (expval.equalsIgnoreCase(actval)) {
						BaseLib.logReport("PASS", "For " + actval + " || " + expval + ": value matched with : " + expval);
					}
					break;
				case "On Site - WD NH Reg":
					//String actval2 = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("").toString();
					String actval2 ="232,00";
					if (expval.equalsIgnoreCase(actval2)) {
						BaseLib.logReport("PASS", "For " + actval2 + " || " + expval + ": value matched with : " + expval);
					}
					break;
				case "Travel":
					//String actval3 = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("").toString();
					String actval3 ="150,00";
					if (expval.equalsIgnoreCase(actval3)) {
						BaseLib.logReport("PASS", "For " + actval3 + " || " + expval + ": value matched with : " + expval);
					}
					break;
				case "Third Party Services":
					//String actval4 = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("").toString();
					String actval4 ="70,00";
					if (expval.equalsIgnoreCase(actval4)) {
						BaseLib.logReport("PASS", "For " + actval4 + " || " + expval + ": value matched with : " + expval);
					}
					break;
				}
			}
		}catch(Exception e) {}
	}

	public void verify_Conditions_Header_Data() throws GeneralLeanFtException, InterruptedException {

		EditField cnNumber = header_Data_Conditions_Overview_Window().describe(EditField.class, DMR_Item_Overview_EditField);
		cnNumber.highlight();

		//String actval3 = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("").toString();
		String actval3 ="992,00";
		if (cnNumber.getText().equalsIgnoreCase(actval3)) {
			BaseLib.logReport("PASS", "For " + actval3 + " || ");
		}

		EditField tax = header_Data_Conditions_Overview_Window().describe(EditField.class, DMR_Item_Overview_Tax_EditField);
		tax.highlight();

		//String actval4 = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("").toString();
		String actval4 ="208,32";
		if (tax.getText().equalsIgnoreCase(actval4)) {
			BaseLib.logReport("PASS", "For " + actval4 + " || ");
		}

		Table settlementabletemp = header_Data_Conditions_Overview_Window().describe(Table.class, Header_Data_Condition_Table);
		settlementabletemp.highlight();

		try {
			for (int j = 0; j < settlementabletemp.getRows().size(); j++) {
				String name = settlementabletemp.getRows().get(j).getCell("Name").getValue();
				String val = settlementabletemp.getRows().get(j).getCell("Condition value").getValue();

				System.out.println("Name:"+j+":"+val);
			}
		}catch(Exception e) {}
	}
	public void verify_Partners_Header_Data() throws InterruptedException, GeneralLeanFtException {

		Thread.sleep(4000);
		Table settlementabletemp = header_Data_Overview_Window().describe(Table.class, DMR_Partners_Table);
		settlementabletemp.highlight();
		try {
			for (int j = 0; j < settlementabletemp.getRows().size(); j++) {
				String val = settlementabletemp.getRows().get(j).getCell("Partner").getValue();
				//String actval = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("").toString();
				String actval ="94320728";
				if (val.equalsIgnoreCase(actval)) {
					BaseLib.logReport("PASS", "For " + actval + " || " );
				}
			}
		}catch(Exception e) {}
	}
	public void enter_Material_Document_Number(String material,String matyear) throws GeneralLeanFtException, InterruptedException {

		EditField matYear = material_Document_Overview_Window().describe(EditField.class, Material_Document_Year_EditField);
		matYear.highlight();
		//String material = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("").toString();
		matYear.setText("2020");

		EditField mateCode = material_Document_Overview_Window().describe(EditField.class, Material_Document_Overview_EditField);
		mateCode.highlight();
		//String material = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("").toString();
		mateCode.setText("5100099018");
		material_Document_Overview_Window().sendKey(SapFunctionKey.ENTER);
		Thread.sleep(6000);
		BaseLib.logReport("PASS", "CN Number is entered");

	}
	public void verify_Material_Document_Details() throws InterruptedException, GeneralLeanFtException {

		EditField SWONumber = accounting_Document_Overview_Window().describe(EditField.class, docNum);
		SWONumber.highlight();
		String actVal = SWONumber.getText();
		//String material = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("").toString(); For 261
		if (actVal.equalsIgnoreCase("Z41")) {
			BaseLib.logReport("PASS", "mvT Field matched with : " + actVal);
		}
		//String material = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("").toString(); For 632
		else if(actVal.equalsIgnoreCase("Z41")){
			BaseLib.logReport("PASS", "mvT Field matched with : " + actVal);
		}else {
			BaseLib.logReport("FAIL", "mvT Field did not match with : " + actVal);
			Assert.fail();
		}
		Thread.sleep(6000);
	}
	public void verify_Accounting_Details() throws GeneralLeanFtException, InterruptedException {

		Button objectsButton = accounting_Document_Overview_Window().describe(Button.class, accountingDocButton);
		objectsButton.highlight();
		objectsButton.click();
		Thread.sleep(6000);
		BaseLib.logReport("PASS", "Objects button is clicked");

		Grid documentsInAccountingGrid = Accounting_Document_Window().describe(Grid.class, docTable);

		documentsInAccountingGrid.selectCell(3, "Object type text");
		documentsInAccountingGrid.selectRow(3);
		documentsInAccountingGrid.activateCell(3, "Object type text");
		Thread.sleep(6000);
		Label label = FISLLocalActua_Window().describe(Label.class,FISLLocalActualLabel);
		label.setFocus();
		label.setCursorPosition(1);
		//FISLLocalActua_Window().sendKey(SapFunctionKey.CTRL_F2);
		FISLLocalActua_Window().sendKey(SapFunctionKey.F2);
		Thread.sleep(4000);
		TabControl tSGOITEMTabControl = displayMaterialDocument_Window().describe(TabControl.class,TabControlDescription);
		tSGOITEMTabControl.select("Transfer Posting");
		EditField storLocEditFiel  = displayMaterialDocument_Window().describe(EditField.class,storLocEditField);
		storLocEditFiel.highlight();
		if(storLocEditFiel.getText().equalsIgnoreCase("ZRIT")) BaseLib.logReport("PASS", "Stor. Loc matched : ");
		tSGOITEMTabControl.select("Account Assignment");
	}

	public void enter_IP_Equipment() throws InterruptedException, GeneralLeanFtException {
		Thread.sleep(2000);
		EditField SWONumber = equipment_Overview_Window().describe(EditField.class, equipment_Num);
		SWONumber.highlight();
		//String material = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("").toString();
		SWONumber.setText("88309308");
		equipment_Overview_Window().sendKey(SapFunctionKey.ENTER);
		Thread.sleep(6000);
		System.out.println("IP_Equipment");

	}
	public void verify_Function_Equipment() throws GeneralLeanFtException {

		EditField SWONumber = equipment_Overview_Window2().describe(EditField.class, funct_LOC);
		SWONumber.highlight();
		String actVal = SWONumber.getText();
		if (actVal.contains("NEM")) {
			BaseLib.logReport("PASS", "Function Equipment number matched with : " + actVal);
		}
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("Functional Equipment",actVal);
		EditField supper = equipment_Overview_Window2().describe(EditField.class, superrod);
		supper.highlight();
		String sup = supper.getText();
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("Superrod Equipment",sup);
	}

	public void enter_Function_Loc() throws InterruptedException, GeneralLeanFtException {
		Thread.sleep(2000);
		EditField SWONumber = functional_Loc_Window().describe(EditField.class, functionalLocEdit);
		SWONumber.highlight();
		//String material = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("Functional Equipment").toString();
		SWONumber.setText("ES102934-001-002");
		functional_Loc_Window().sendKey(SapFunctionKey.ENTER);
		Thread.sleep(6000);
		System.out.println("Functional Location");
	}

	public void verify_Function_Location() throws GeneralLeanFtException {

		try {
			EditField SWONumber = equipment_Overview_Window2().describe(EditField.class, funct_LOC);
			SWONumber.highlight();
			String actVal = SWONumber.getText();
			if (actVal.contains("NEM")) {
				BaseLib.logReport("PASS", "Function Equipment number matched with : " + actVal);
			}
			AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("Functional Equipment",actVal);
		}catch(Exception e) {}
		try {
			EditField supper = equipment_Overview_Window2().describe(EditField.class, superrod);
			supper.highlight();
			String sup = supper.getText();
			AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("Superrod Equipment",sup);
		}catch(Exception e) {}
	}
	public void open_Item_Material_SalesTab(String item, String tab,String win) {

		switch(win) {
		case "ASO-Item":
			switch(tab) {
			case "Sales":
				switch(item){
				case "Item-Material":
					try {
						Thread.sleep(2000);

						Table settlementabletemp = ASOPartsWindow().describe(Table.class,
								Sales_Item_Material_Aso_Item);
						settlementabletemp.highlight();
						settlementabletemp.selectRow(1);

						Button backbutton = ASOPartsWindow().describe(Button.class, itemButton);
						backbutton.highlight();
						backbutton.click();

						Thread.sleep(6000);

					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
				break;
			}
			break;
		}
	}
	public void verify_Delivery_Location() throws GeneralLeanFtException, InterruptedException {
		Thread.sleep(2000);
		Table settlementabletemp = ItemData_Overview_Window().describe(Table.class, deliveryLocaTable);
		settlementabletemp.highlight();
		String val = settlementabletemp.getRows().get(0).getCell("Name").getValue();

		if (val==null) {
			BaseLib.logReport("Fail", "Delivery Location Not Verified");
		} else if(val.isEmpty()) {
			BaseLib.logReport("FAIL", "Delivery Location Not Verified");
		}else {
			BaseLib.logReport("PASS", "Delivery Location Verified");
		}
	}
	public void click_Display_document_flow_icon() throws GeneralLeanFtException, InterruptedException{
		Button backbutton = ASOSingleSalesOrderWindow().describe(Button.class, flowButton);
		backbutton.highlight();
		backbutton.click();

		Thread.sleep(6000);
	}
	public void Click_Display_Document() throws GeneralLeanFtException, InterruptedException, CloneNotSupportedException{
		ToolBar tool = DocumentFlowWindow().describe(ToolBar.class, toolbar);
		tool.highlight();
		tool.pressButton("&FIND");
		String as01 = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("ASO_ITEM1");
		//String as01 = "0126562719";
		Thread.sleep(6000);

		try {
			TreeView tableTreeControlTreeView = session.describe(Window.class, new WindowDescription.Builder()
					.name("wnd[0]")
					.program("SAPLDOCUMENT_FLOW_ALV")
					.screenNumber(100l)
					.transaction("VA02")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
					.describe(TreeView.class, new TreeViewDescription.Builder()
							.name("shell[1]")
							.type(com.hp.lft.sdk.sap.gui.ComponentType.CTRL_TREE).build());
			String data = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("SAP_SWO_NUMBER");
			tableTreeControlTreeView.activateNode("Service order "+data);
		}catch(Exception e) {
			EditField edi = singlePartsDialogWindow().describe(EditField.class, editFi);
			edi.setText(as01);
			singlePartsDialogWindow().describe(Button.class,continueEnterButton).highlight();
			singlePartsDialogWindow().describe(Button.class,continueEnterButton).click();
			Thread.sleep(10000);
			try {
				Thread.sleep(10000);
				singlePartsDialogWindow().describe(Button.class,clsButton).click();
			}catch(Exception e1) {
				Thread.sleep(10000);
			}
		}
		Thread.sleep(6000);
		try {
			Button continueEnterButton = session.describe(Window.class, new WindowDescription.Builder()
					.name("wnd[1]")
					.program("SAPMSDYP")
					.screenNumber(10l)
					.transaction("VA02")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.MODAL_WINDOW).build())
					.describe(Button.class, new ButtonDescription.Builder()
							.name("btn[0]")
							.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build());
			continueEnterButton.click();
		}catch(Exception e) {}
		Thread.sleep(6000);
		try {
			Button displayDocumentButton = session.describe(Window.class, new WindowDescription.Builder()
					.name("wnd[0]")
					.program("SAPLDOCUMENT_FLOW_ALV")
					.screenNumber(100l)
					.transaction("VA02")
					.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
					.describe(Button.class, new ButtonDescription.Builder()
							.name("btn[8]")
							.type(com.hp.lft.sdk.sap.gui.ComponentType.BUTTON).build());
			displayDocumentButton.highlight();
			displayDocumentButton.click();
			Thread.sleep(6000);
		}catch(Exception e) {}
		try {
			DocumentFlowWindow().describe(Button.class, postGoodsIssueButton).highlight();
			DocumentFlowWindow().describe(Button.class, postGoodsIssueButton).click();
			Thread.sleep(6000);
		}catch(Exception e) {

		}

	}
	public void select_Line_Itemt() throws GeneralLeanFtException {
		try {
			Table line = lineItemWindow().describe(Table.class, lineIteble);
			line.highlight();
			line.selectRow(1);
		}catch(Exception e) {}
	}
	public void click_Processing_Log() throws GeneralLeanFtException, InterruptedException {
		try {
			Table line = outputDeliveryWindow().describe(Table.class, deliverTabl);
			line.highlight();
			for (int j = 0; j < line.getRows().size(); j++) {
				String val = line.getRows().get(j).getCell("Output Type").getValue();
				if (val.equalsIgnoreCase("Z1LR")) {
					line.selectRow(j+1);
					break;
				}
			}
			outputDeliveryWindow().describe(Button.class, processButton).highlight();
			outputDeliveryWindow().describe(Button.class, processButton).click();
			Thread.sleep(6000);
		}catch(Exception e) {}
		try {
			for(int i=3;i<13;i++) {
				String tan = "wnd[1]/usr/lbl[6,"+i+"]";
				Label lebel  = deliveryWindow().describe(Label.class, new LabelDescription.Builder()
						.relativeId(tan)
						.type(com.hp.lft.sdk.sap.gui.ComponentType.LABEL).build());
				if(lebel.getVisibleText().contains("Process is completed.")) {
					value = Integer.parseInt(lebel.getVisibleText().replaceAll("[^0-9]", ""));
					System.out.println("VALUE:"+value);
					AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("Delivery_Number", String.valueOf(value));
					break;
				}
			}
			deliveryWindow().describe(Button.class,clsButton ).highlight();
			deliveryWindow().describe(Button.class,clsButton ).click();
			Thread.sleep(6000);
		}catch(Exception e) {}
	}
	public void Search_Delivery_Number() throws GeneralLeanFtException, InterruptedException {
		try {
			EditField SWONumber = BlueRoomWindow().describe(EditField.class, delVal);
			SWONumber.highlight();
			String material = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("Delivery_Number");
		if(material==null||material=="0"||material.isEmpty()) {
			SWONumber.setText(String.valueOf(value));
		}else SWONumber.setText(String.valueOf(material));
			BlueRoomWindow().describe(Button.class, sercButton).highlight();
			BlueRoomWindow().describe(Button.class, sercButton).click();
			Thread.sleep(6000);
		}catch(Exception e) {}
	}
	public void Search_Outbound_Delivery(String tcode) throws GeneralLeanFtException, InterruptedException {
		try {
			OKCode TACode = Outbound_Delivery_Win().describe(OKCode.class, oKCode);
			TACode.highlight();
			TACode.setValue(tcode);
			Thread.sleep(1000);
			Outbound_Delivery_Win().sendKey(SapFunctionKey.ENTER);
			BaseLib.logReport("PASS", tcode + " entered ");
			Thread.sleep(6000);
		}catch(Exception e) {}
	}
	public static Window Delivery_Change_Win() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, Delivery_Change_Win);
		return window;
	}
	public static Window outboundDeliveryWin() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, outboundDeliveryWin);
		return window;
	}
	public void Delivery_Number_in_OutBound_Delivery() throws GeneralLeanFtException, InterruptedException {
		try {
			EditField SWONumber = outboundDeliveryWin().describe(EditField.class, ASODeliveryEditField);
			SWONumber.highlight();
			//String material = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("Delivery_Number", String.valueOf(value));
			SWONumber.setText(String.valueOf(value));
			outboundDeliveryWin().sendKey(SapFunctionKey.ENTER);
			Thread.sleep(6000);
		}catch(Exception e) {}
		BaseLib.logReport("PASS", "CN Number is entered");
	}
	public static Window serial_Number_Window() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, serial_Number_Window);
		return window;
	}
	public static Window ProgramCorrectionWindow() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, ProgramCorrectionWindow);
		return window;
	}
	public static Window ZR_CS_BLUEROOM_CORRECTIONS() throws GeneralLeanFtException {
		Window window = session.describe(Window.class, ZR_CS_BLUEROOM_CORRECTIONS);
		return window;
	}
	public void select_LineItem_and_Enter_serial_Number() throws GeneralLeanFtException, InterruptedException {
		try {
			Table line = Delivery_Change_Win().describe(Table.class, lineIteble);
			line.highlight();
			line.selectRow(1);
			Menubar confirmation = Delivery_Change_Win().describe(Menubar.class, completionConfirmation);
			confirmation.highlight();
			confirmation.select("Extras;Serial Numbers");
			Thread.sleep(6000);
			Table serial = serial_Number_Window().describe(Table.class, ASO_Serialize_Table);
			serial.highlight();

			for (int j = 0; j < serial.getRows().size(); j++) {
				try {
					String val = serial.getRows().get(j).getCell("Serial Number").getValue();
					if (val==null ||val.isEmpty()) {
						//AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("", "");
						serial.getRows().get(j).getCell("Serial Number").setValue("451462339");
						break;

					}
				}catch(Exception e) {}
			}
			serial_Number_Window().sendKey(SapFunctionKey.ENTER);

			Thread.sleep(2000);
			Button saveBTN = Delivery_Change_Win().describe(Button.class, saveButton);
			saveBTN.highlight();
			saveBTN.click();
			Thread.sleep(6000);
		}catch(Exception e) {}
	}
	public void verify_Part_information(String code) throws GeneralLeanFtException, InterruptedException {
		try {
			OKCode tCode = outboundDeliveryWin().describe(OKCode.class, oKCode);

			tCode.highlight();
			tCode.setValue(code);
			Thread.sleep(2000);
			outboundDeliveryWin().sendKey(SapFunctionKey.ENTER);
			BaseLib.logReport("PASS", code + " entered ");
			Thread.sleep(4000);
		}catch(Exception e) {}
	}
	public void execute_Blueroom_Correction(String tc) throws GeneralLeanFtException, InterruptedException {
		execute_Blueroom_Correction();
	}
	public void execute_Blueroom_Correction() throws GeneralLeanFtException, InterruptedException {
		try {
			EditField pgmfield = ProgramCorrectionWindow().describe(EditField.class, pgmEdit);
			pgmfield.highlight();
			//String material = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("Delivery_Number", String.valueOf(value));
			pgmfield.setText("ZR_CS_BLUEROOM_CORRECTIONS");
			Button saveBTN = ProgramCorrectionWindow().describe(Button.class, postGoodsIssueButton);
			saveBTN.highlight();
			saveBTN.click();
			Thread.sleep(6000);

			EditField date = ZR_CS_BLUEROOM_CORRECTIONS().describe(EditField.class, docDate);
			//String material = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("Delivery_Number", String.valueOf(value));
			date.setText("25.2.2021");
			EditField docyr = ZR_CS_BLUEROOM_CORRECTIONS().describe(EditField.class, docYear);
			docyr.highlight();
			//String material = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("Delivery_Number", String.valueOf(value));
			pgmfield.setText("2021");
			EditField doctype = ZR_CS_BLUEROOM_CORRECTIONS().describe(EditField.class, docType);
			doctype.highlight();
			//String material = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("Delivery_Number", String.valueOf(value));
			pgmfield.setText("WE");

			Button exe = ZR_CS_BLUEROOM_CORRECTIONS().describe(Button.class, postGoodsIssueButton);
			exe.highlight();
			exe.click();
		}catch(Exception e) {}
	}
	public void perform_Deroute_selection_Date() throws GeneralLeanFtException, InterruptedException {

		Grid documentsInAccountingGrid = TechnicalInformation_Window().describe(Grid.class, TechnicalInformationdocTable);
		documentsInAccountingGrid.getRows().get(0).getCells().get(1).click();
		Thread.sleep(6000);
		EditField reqDelivDate = reqDelivDateEditFieldWindow().describe(EditField.class, reqDelivDateEditField);
		reqDelivDate.highlight();
		String actVal = reqDelivDate.getText();
		System.out.println("actVal:"+actVal);
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("reqDelivDate",actVal);

		try {
			OKCode TACode = ASOPartsWindow().describe(OKCode.class, oKCode);

			TACode.setValue("/nva03");
			Thread.sleep(2000);
			ASOPartsWindow().sendKey(SapFunctionKey.ENTER);
			BaseLib.logReport("PASS", "va03" + " entered ");
			Thread.sleep(4000);
		}catch(Exception e) {

		}
		try {
			EditField cnNumber ;
			String as01 = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("ASO_ITEM1");
			//String as01 = "0126562719";
			cnNumber = CNWindow("ASO-Item").describe(EditField.class, ASOOrderEditField);
			cnNumber.highlight();
			cnNumber.setText(as01);
			CNWindow("ASO-Item").sendKey(SapFunctionKey.ENTER);
			Thread.sleep(6000);
		}catch(Exception e) {

		}
		try {
			TabControl operationsTab;
			operationsTab = ASOPartsWindow().describe(TabControl.class, ASO_Item_Overview_Tab);
			operationsTab.highlight();
			operationsTab.select("Item overview");
			Thread.sleep(2000);
			select_ASO_Item();
			select_Sales_Document_Deliver("Sales Document and Deliver");
		}catch(Exception e) {}
		try {
			Thread.sleep(6000);
			Button back = TechnicalInformation_Window().describe(Button.class, backbutton);
			back.highlight();
			back.click();
			Thread.sleep(2000);
			EditField selDate = selectionDate_Window().describe(EditField.class, selectionDate);
			selDate.highlight();
			selDate.setText(AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("reqDelivDate"));
			Thread.sleep(2000);
			selectionDate_Window().sendKey(SapFunctionKey.ENTER);
			Thread.sleep(9000);
		}catch(Exception e) {}
	}


	/*
	 * public void switchToFM() throws Exception { OKCode oKCode =
	 * session.describe(Window.class, new WindowDescription.Builder()
	 * .type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build())
	 * .describe(OKCode.class, new OKCodeDescription.Builder()
	 * .type(com.hp.lft.sdk.sap.gui.ComponentType.OK_CODE_FIELD).build());
	 * oKCode.setValue("/n"); leanFtEnter(); logReport("INFO",
	 * "The user is in login page"); }
	 */
	public static void search_Bar(String TAcode) throws GeneralLeanFtException {
		try {
			OKCode TACode = Window().describe(OKCode.class, oKCode);
			TACode.highlight();

			TACode.setValue(TAcode);
			Thread.sleep(2000);
			Window().sendKey(SapFunctionKey.ENTER);
			BaseLib.logReport("PASS", TAcode + " entered ");
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void enter_SAP_SWO() throws GeneralLeanFtException, InterruptedException {
		EditField cnNumber;
		String as01 = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("SAP_SWO_NUMBER");
		//String as01 = "000054350351";
		EditField functionModule_txt = session.describe(EditField.class, SAPSWO_EditFieldDescription);

		functionModule_txt.highlight();
		functionModule_txt.setText(as01);
		generalWindow = session.describe(Window.class, SAPSWO_Win);
		generalWindow.sendKey(SapFunctionKey.ENTER);
		Thread.sleep(6000);
	}
	public void verify_WO_SAP() throws GeneralLeanFtException, InterruptedException {
		String swo = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("SAP_SWO_NUMBER");
		generalWindow = session.describe(Window.class, Component_Window);
		TabControl operationsTab = generalWindow.describe(TabControl.class,
				Component_Table);
		operationsTab.highlight();
		operationsTab.select("Components");
		Thread.sleep(4000);

		Table settlementabletemp = generalWindow.describe(Table.class, Component_Tables);
		settlementabletemp.highlight();
		try {
			for (int j = 0; j < settlementabletemp.getRows().size(); j++) {
				String val = settlementabletemp.getRows().get(j).getCell("Unloading Point").getValue();
				System.out.println("WorkOrder:"+val);
				if (val.equalsIgnoreCase(swo)) {
					BaseLib.logReport("PASS", val + " Work Order ");
				}
			}}catch(Exception e) {}
		operationsTab.highlight();
		operationsTab.select("Partner");
		Thread.sleep(4000);
		Table partner_Tabl = generalWindow.describe(Table.class, partner_Tables);
		partner_Tabl.highlight();
		try {
			for (int j = 0; j < partner_Tabl.getRows().size(); j++) {
				String val = partner_Tabl.getRows().get(j).getCell("Name").getValue();
				System.out.println("Location:"+val);
				if (val.equalsIgnoreCase(val)) {
					BaseLib.logReport("PASS", val + " Location ");
				}
			}}catch(Exception e) {}
		Thread.sleep(6000);
	}
	public void status1() throws GeneralLeanFtException, InterruptedException {

		generalWindow = session.describe(Window.class, Component_Window);
		Button status = generalWindow.describe(Button.class, statusBTN);
		status.highlight();
		status.click();
		Thread.sleep(2000);
		generalWindow = session.describe(Window.class, status_Window);
		Label label = generalWindow.describe(Label.class, ASO_ITEML);
		label.highlight();
		Thread.sleep(6000);
	}
	public void sap_Document() throws GeneralLeanFtException, InterruptedException {
		try {
			generalWindow = session.describe(Window.class, status_Window);
			Button salesbtn = generalWindow.describe(Button.class, objectsbtn);
			salesbtn.highlight();
			BaseLib.logReport("PASS", "Sales Document");
			salesbtn.click();
			Thread.sleep(6000);
			generalWindow = session.describe(Window.class, ASO_Single_Parts_Overview_Window);
			EditField label = generalWindow.describe(EditField.class, ASOSalesOrderEditField);
			label.highlight();
			Thread.sleep(6000);
			BaseLib.logReport("PASS", "Sales Document");
			Thread.sleep(2000);
			Table settlementabletemp = ASOPartsWindow().describe(Table.class,
					Sales_Item_Material_Aso_Item);
			settlementabletemp.highlight();
			settlementabletemp.selectRow(1);
			Thread.sleep(2000);
			TabControl operationsTab = ASOPartsWindow().describe(TabControl.class, ASO_Item_Overview_Tab);
			operationsTab.highlight();
			operationsTab.select("Item overview");
			Thread.sleep(4000);
		}catch(Exception e) {}
	}

	static GuiSessionDescription cnsession = new GuiSessionDescription.Builder().name("ses[1]").build();

	static WindowDescription cnWindow = new WindowDescription.Builder().name("wnd[0]").program("SAPMC29C")
			.screenNumber(100l).transaction("CC03").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static WindowDescription cnheaderwindow = new WindowDescription.Builder().name("wnd[0]").program("SAPMC29C")
			.screenNumber(10l).transaction("CC03").type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();

	static WindowDescription ASOSearchWindow1 = new WindowDescription.Builder()
			.name("wnd[0]")
			.program("SAPLCOIH")
			.screenNumber(101l)
			.transaction("IW33")
			.type(com.hp.lft.sdk.sap.gui.ComponentType.MAIN_WINDOW).build();


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

	public static void stagerecords()
	{
		equipmentNumbers.put("Equipment1", "400007149");
		equipmentNumbers.put("Equipment2", "400007150");
		equipmentNumbers.put("Equipment3", "400007151");
		equipmentNumbers.put("Equipment4", "400007152");
		equipmentNumbers.put("Equipment5", "400007153");
		equipmentNumbers.put("Equipment6", "400007154");
		equipmentNumbers.put("Equipment7", "400007155");

	}
}

