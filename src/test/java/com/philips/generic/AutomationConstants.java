
package com.philips.generic;

import java.util.HashMap;

/**
 * Title: generic.java
 * Author: M1048601
 * Last updated: M1048601
 * Description: Contains path of all files and config variables involved in the framework design
 *  Mindtree limited 2020
 */

public interface AutomationConstants
{
	//File path
	String projectPath = System.getProperty("user.dir");



	public static final String servicePortalURL="https://emsmq3-philipscustomerservice.cs212.force.com/customerservice/cp_login";
	public static  final String FCOUALDataFilePath=projectPath+"/src/test/resources/TestData/UAL_TestFile.csv";
	public static  final String FCOUALFilePath_737463=projectPath+"/src/test/resources/TestData/UAL_737463.csv";
	public static  final String sapData=projectPath+"/src/test/resources/TestData/SAPTestData.xlsx";
	public static  final String DataFilePath=projectPath+"/src/test/resources/TestData/Data.xlsx";
	public static  final String configpaht=projectPath+"/src/test/resources/config.xml";
	public static  final String log4jPath=projectPath+"/src/test/resources/log4j.properties";
	public static  final String chromeDriverPath= projectPath+"/src/test/resources/driver/chromedriver.exe";
	public static  final String firefoxDriverPath= projectPath+"/driver/geckodriver.exe";
	public static  final String IEDriverPath= projectPath+"/driver/IEDriverServer.exe";	
	public static  final String  ActualImage=projectPath+"/ActualImage";
	public static  final String screenShotsFolderPath= projectPath+"/output/Screenshots/";
	public static  final String screenShotsOnFailureFolderPath= projectPath+"/output/FailureScreenshots/";
	public static  final String appAndroid= projectPath+"/appDir/Salesforce.apk";
	public static  final String DownloadsFolder= projectPath+"\\src\\test\\resources\\Downloads\\";
	public static  final String TestDataFilePath=projectPath+"/src/test/resources/TestData/TestData.xlsm"; 
	public static  final String FCODataFilePath=projectPath+"/src/test/resources/TestData/FCO Header_440278.csv";
	public static  final String IMUFilePatch=projectPath+"/src/test/resources/TestData/IMU.csv";
	public static  final String FCO1to1DataFilePath=projectPath+"/src/test/resources/TestData/FCO_1to1.csv";
	public static  final String FCO1to1UALDataFilePath=projectPath+"/src/test/resources/TestData/UAL_1to1_Test.csv";
	public static  final String FCO1tomanyDataFilePath=projectPath+"/src/test/resources/TestData/FCO_1tomany.csv";
	public static  final String FCO1tomanyUALDataFilePath=projectPath+"/src/test/resources/TestData/UAL_1tomany_Test.csv";
	public static  final String FCOCALDataFilePath=projectPath+"/src/test/resources/TestData/CAL_Load_Test.csv";
	public static  final String equipmentIP=projectPath+"/src/test/resources/TestData/test7.equp";
	public static final String orderData=projectPath+"\\src\\test\\resources\\TestData\\Data.xlsx";
	public static final String SmaxContacts=projectPath+"\\src\\test\\resources\\TestData\\ZUT_ONEEMS_CONT.XLSX";
	public static final String SmaxAccounts=projectPath+"\\src\\test\\resources\\TestData\\ZUT_ONEEMS_CUST.XLSX";
	public static final String SmaxAccountPartner=projectPath+"\\src\\test\\resources\\TestData\\ZUT_ONEEMS_PART.XLSX";
	//config variabels
	public static String sandbox ="MQ3";
	public static String iPadTest = "SeeTest";
	public static  final String Browser = "Chrome";
	public static  final String TimeOut = "20";
	//public static  final String URL = "https://test.salesforce.com"; //"https://philipsb2bsc--emsmq3.my.salesforce.com";
	public static  final String URL = "https://www.sugarcrm.com/au/request-demo/";
	public static  final String Hybris_URL = "https://www.asx.com.au/";
	public static  final String storeFrontURL = "https://tst.homehealth.shop.philips.com";
	public static final String SeeTestURL = "https://philips.experitest.com";
	public static final String UpdateAzureTMT = "No";//Yes, No 
	public static final String AzureSuiteID = "853584";
	public static final String IT_OP_ADMIN = "Custom IT Ops Support";
	public static final String MASTER_DATA_ADMIN_PROFILE = "Custom-ESMX Master Data Admin";
	public static final String SERVICE_AGENT = "Custom - ESMX Agent";
	public static final String SERVICE_TECHNICIAN = "Custom ESMX Service User";
	public static final HashMap<String,String> SERVICE_MAINTENANCE_CONTRACT_DATA = new HashMap<String,String>();
	//Runtime variables
	public static final HashMap<String,String> SERVICE_QUOTE_NUMBER = new HashMap<String,String>();
	public static final HashMap<String,String> SERVICE_CONSULTENCY_CONTRACT_DATA = new HashMap<String,String>();
	public static final HashMap<String,String> RUN_TIME_TEMP_DATA = new HashMap<String,String>();
	public static final String[] RML_List = {"R000000003",			
			"R000000011",
			"R000000029",
			"R000000037",
			"R000000045",
			"R000000052",
			"R000000060",
			"R000000078",
			"R000000086",
			"R000000094",
			"R000000102",
			"R000000110",
			"R000000128",
			"R000000136",
			"R000000144",
			"R000000151",
			"R000000169",
			"R000000177",
			"R000000185",
			"R000000193",
			"R000000201",
			"R000000219",
			"R000000227",
			"R000000235",
			"R000000243",
			"R000000250",
			"R000000268",
			"R000000276",
			"R000000284",
			"R000000292",
			"R000000300",
			"R000000318",
			"R000000326",
			"R000000334",
			"R000000342",
			"R000000359",
			"R000000367",
			"R000000375",
			"R000000383",
			"R000000391",
			"R000000409",
			"R000000417",
			"R000000425",
			"R000000433",
			"R000000441",
			"R000000458",
			"R000000466",
			"R000000474",
			"R000000482",
			"R000000490",
			"R000000508",
			"R000000516",
			"R000000524",
			"R000000532",
			"R000000540",
			"R000000557",
			"R000000565",
			"R000000573",
			"R000000581",
			"R000000599",
			"R000000607",
			"R000000615",
			"R000000623",
			"R000000631",
			"R000000649",
			"R000000656",
			"R000000664",
			"R000000672",
			"R000000680",
			"R000000698",
			"R000000706",
			"R000000714",
			"R000000722",
			"R000000730",
			"R000000748",
			"R000000755",
			"R000000763",
			"R000000771",
			"R000000789",
			"R000000797",
			"R000000805",
			"R000000813",
			"R000000821",
			"R000000839",
			"R000000847",
			"R000000854",
			"R000000862",
			"R000000870",
			"R000000888",
			"R000000896",
			"R000000904",
			"R000000912",
			"R000000920",
			"R000000938",
			"R000000946",
			"R000000953",
			"R000000961",
			"R000000979",
			"R000000987",
	"R000000995"};
	public static  final String CS_PORTAL_URL = "https://emsmq3-philipscustomerservice.cs37.force.com/Service/s/";
}