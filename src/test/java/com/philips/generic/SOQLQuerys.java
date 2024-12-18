package com.philips.generic;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
//
//import com.sforce.soap.M2MCaseService.ReqParamForCase;
//import com.sforce.soap.M2MCaseService.SoapConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.SaveResult;
import com.sforce.soap.enterprise.sobject.Account;
import com.sforce.soap.enterprise.sobject.Account_to_Account_Partner_Junction__c;
import com.sforce.soap.enterprise.sobject.Contact;
import com.sforce.soap.enterprise.sobject.ESMX_IP_Staging__c;
import com.sforce.soap.enterprise.sobject.Event;
import com.sforce.soap.enterprise.sobject.Functional_Location__c;
import com.sforce.soap.enterprise.sobject.Product2;
import com.sforce.soap.enterprise.sobject.SObject;
import com.sforce.soap.enterprise.sobject.SVMXC__Installed_Product__c;
import com.sforce.soap.enterprise.sobject.SVMXC__PM_Plan__c;
import com.sforce.ws.ConnectionException;

public class SOQLQuerys {
	public static String SOQLQuoteID = null;
	public static String SOQLOpportunityID = null;
	public static String SOQLProductID = null;
	private static QueryResult queryResults;
	private static List<Product2> Product2_BusinessGroup = new ArrayList<Product2>();
	public static String SOQL_QUERY_BUSINESS_GROUP = "SELECT Business_Group__c,Name, Id, ESMX_Business_Group__c FROM Product2 Where ESMX_Business_Group__c ='MA-Monitoring & Analytics' OR ESMX_Business_Group__c ='TC-Therapeutic Care' Limit 150";
	public static String SOQL_QUERY_INSTALLED_PRODUCT = "SELECT Name, Id, SVMXC__Product__c, SVMXC__Product_Name__c, ESMX_Service_Provider__c , ESMX_IP_Description__c FROM SVMXC__Installed_Product__c Where ESMX_Service_Provider__c='Third Party Contractor' AND SVMXC__Product__c=";
	public static String SOQL_QUERY_PREVENTATIVE_MAINTENANCE_PLAN = "Select Id, Name, SVMXC__Status__c,ESMX_PM_Type__c, SVMXC__Service_Contract__c From SVMXC__PM_Plan__c Where SVMXC__Status__c='Active' AND SVMXC__Service_Contract__c !=''";

	public static String formatNumber(String value) {
		Double number = Double.parseDouble(value);
		NumberFormat usFormat = NumberFormat.getNumberInstance(Locale.US);
		DecimalFormat decimalFormat = (DecimalFormat) usFormat;
		decimalFormat.applyPattern("0.00");
		decimalFormat.setGroupingUsed(true);
		decimalFormat.setGroupingSize(3);
		return decimalFormat.format(number);
	}

	public static void getBusinessGroupRecord() throws Exception {

		LoginComponent.login();
		EnterpriseConnection connection = LoginComponent.getConnection();
		queryResults = connection.query(SOQL_QUERY_BUSINESS_GROUP);
		connection.logout();
		if (queryResults != null && queryResults.getSize() > 0) {
			for(int i=0;i<queryResults.getSize();i++) {

				Product2 result = (Product2) queryResults.getRecords()[i];
				Product2_BusinessGroup.add(result);
			}
		} else {
			System.out.println("Query didn't give any results");
		}

	}
	public static void getInstalledProduct() throws Exception {
		getBusinessGroupRecord();
		LoginComponent.login();
		EnterpriseConnection connection = LoginComponent.getConnection();
		for(int i=0;i<Product2_BusinessGroup.size();i++) {
			String Query = SOQL_QUERY_INSTALLED_PRODUCT+"'"+Product2_BusinessGroup.get(i).getId()+"'";
			queryResults = connection.query(Query);
		}
		connection.logout();
		if (queryResults != null && queryResults.getSize() > 0) {
			for(int i=0;i<queryResults.getSize();i++) {

				SVMXC__Installed_Product__c result = (SVMXC__Installed_Product__c) queryResults.getRecords()[i];

			}
		} else {
			System.out.println("Query didn't give any results");
		}
	}
	public static void getPreventiveMaintenancePlans() throws Exception {

		LoginComponent.login();
		EnterpriseConnection connection = LoginComponent.getConnection();
		queryResults = connection.query(SOQL_QUERY_PREVENTATIVE_MAINTENANCE_PLAN);
		connection.logout();
		if (queryResults != null && queryResults.getSize() > 0) {
			for(int i=0;i<queryResults.getSize();i++) {

				SVMXC__PM_Plan__c result = (SVMXC__PM_Plan__c) queryResults.getRecords()[i];

			}
		} else {
			System.out.println("Query didn't give any results");
		}
	}

	public static String sapSyncStatus(String EquipmentName) throws Exception {

		String status = null;
		int count = 0;
		LoginComponent.login();
		EnterpriseConnection connection = LoginComponent.getConnection();
		Thread.sleep(3000);
		queryResults = connection.query("SELECT Name,ESMX_Status__c FROM ESMX_IP_Staging__c WHERE Name = '"+EquipmentName+"'");
		connection.logout();

		if (queryResults != null && queryResults.getSize() > 0) {
			for(int i=0;i<queryResults.getSize();i++) {

				ESMX_IP_Staging__c result = (ESMX_IP_Staging__c) queryResults.getRecords()[i];
				status = result.getESMX_Status__c().toString();
			}
		} else {
			System.out.println("Query didn't give any results");
			count = count++;
			if(count<3)
			{
			SOQLQuerys.sapSyncStatus(EquipmentName);
			}
		}
		return status;
	}

	public static void getQuoteValues() throws Exception{
		LoginComponent.login();
		EnterpriseConnection connection = LoginComponent.getConnection();
		queryResults = connection.query(SOQL_QUERY_PREVENTATIVE_MAINTENANCE_PLAN);
	}

	public static String getFunctionalLocID(String name) throws Exception 
	{
		String FNID = null;
		LoginComponent.login();
		EnterpriseConnection connection = LoginComponent.getConnection();
		queryResults = connection.query("SELECT Id FROM Functional_Location__c WHERE Name = '"+name+"'");
		connection.logout();

		if (queryResults != null && queryResults.getSize() > 0) {
			Functional_Location__c result = (Functional_Location__c) queryResults.getRecords()[0];
				FNID = result.getId().toString();
			}
	return FNID;	
	}
	
	public static HashMap<String, String> getIPDetails(String EquipmentName) throws Exception {
		HashMap<String,String> equipmentdetails =new HashMap<String,String>();
		LoginComponent.login();
		EnterpriseConnection connection = LoginComponent.getConnection();
		Thread.sleep(3000);
		System.out.println("SELECT Name,ESMX_Status__c,ESMX_Type__c, ESMX_Material_Number__c FROM ESMX_IP_Staging__c WHERE Name = '"+EquipmentName+"'");
		//queryResults = connection.query("SELECT Name,ESMX_Status__c,ESMX_Type__c, ESMX_Material_Number__c FROM ESMX_IP_Staging__c WHERE Name = '"+EquipmentName+"'");
		queryResults = connection.query("SELECT Name,ESMX_Status__c,ESMX_Type__c FROM ESMX_IP_Staging__c WHERE Name = '"+EquipmentName+"'");
		connection.logout();

		if (queryResults != null && queryResults.getSize() > 0) {
			for(int i=0;i<queryResults.getSize();i++) {

				ESMX_IP_Staging__c result = (ESMX_IP_Staging__c) queryResults.getRecords()[i];
				equipmentdetails.put("Status", result.getESMX_Status__c().toString());
				equipmentdetails.put("Type",result.getESMX_Type__c().toString());
				//equipmentdetails.put("MaterialNo", result.getESMX_Material_Number__c().toString());
			}
		} else {
			System.out.println("Query didn't give any results");
		}
		return equipmentdetails;
	}
	public static void deleteEventReminder() throws Exception {
		LoginComponent.login();
		EnterpriseConnection connection = LoginComponent.getConnection();
		connection.logout();
	}
	public static void deleteEventRemindersssss() throws Exception {
		LoginComponent.login();
		EnterpriseConnection connection = LoginComponent.getConnection();
		List<String> ids = new ArrayList<String>();
		int count = 10;
		while(count>0) {
			String Query = "SELECT Id FROM Event WHERE IsReminderSet = true AND CreatedById IN ('0052i000002fKL3AAM','0052i000002x4n3AAA','0052i000003bKZyAAM','0052i000003bkkCAAQ','0052i000003cDFRAA2','0052i000003ePhjAAE','0052i000003eQC3AAM','0052i000003qrUHAAY','0052i000003qrUlAAI','0052i000002TMh4AAG','0052i000002TLRZAA4','0052i000002TMAPAA4','0052i000002TMciAAG','0052i000002x4mjAAA','0052i000002wdgzAAA','0052i000002CCQJAA4','0052i000002h8daAAA','0052i000002h8DhAAI','0052i000002gimMAAQ','0052i000002gipBAAQ','0052i000002gitSAAQ','0052i000002giuaAAA','0052i000003qDWlAAM','0052i000002wmOFAAY','0052i000002wmOAAAY','0052i000003bbxzAAA','0052i000002eO1RAAU','0052i000003bc1DAAQ','0052i000003bc34AAA','0052i000002ww3iAAA','0052i000002ww39AAA','0052i000002weALAAY','0052i000003GhRJAA0',"
					+ "'0052i000002fEkzAAE','0052i000002fEkzAAE','0052i000002CCMXAA4','0052i000003H1QGAA0','0052i000003bFCKAA2','0052i000003bFAYAA2','0052i000003bFBlAAM','0052i000003bblAAAQ','0052i000003bbm3AAA','0052i000003bbmhAAA','0052i000003bbnBAAQ','0052i000003bFrJAAU') Limit 100";
			queryResults = connection.query(Query);
			System.err.println("Size:"+queryResults.getSize());
			if (queryResults != null && queryResults.getSize() > 0) {
				for(int i=0;i<queryResults.getSize();i++) {

					Event result = (Event) queryResults.getRecords()[i];
					System.err.println("Event:"+result.getId());
					result.setIsReminderSet(false);
					//result.setSVMXC__SM_Status__c("Canceled");
					ids.add(result.getId());
					SObject[] dt = new SObject[] {result};
					SaveResult[] res = connection.update(dt);
					System.err.println("SaveResult:"+res.length);
				}
			} else {
				System.out.println("Query didn't give any results");
			}
			count=count-1;
		}
		connection.logout();
	}
	
	public static ArrayList<Map<String, String>> GetAccountDetails() throws Exception {
		ArrayList<Map<String, String>> accDetails = new ArrayList<Map<String, String>>();
		LoginComponent.login();
		EnterpriseConnection connection = LoginComponent.getConnection();
		System.out.println(
				"SELECT Account_Name_Ext__c,Name FROM Account WHERE LastModifiedDate > 2021-11-19T00:00:00.000ZAND LastModifiedById = '0050L00000937XhQAI'");
		queryResults = connection.query(
				"SELECT Account_Name_Ext__c,Name FROM Account WHERE LastModifiedDate > 2021-11-19T00:00:00.000ZAND LastModifiedById = '0050L00000937XhQAI'");
		connection.logout();
		if (queryResults != null && queryResults.getSize() > 0) {
			for (int i = 0; i < queryResults.getSize(); i++) {
				HashMap<String, String> accountDetails = new HashMap<String, String>();
				Account result = (Account) queryResults.getRecords()[i];
				try {
					accountDetails.put("Name", result.getName().toString());
					if (result.getAccount_Name_Ext__c().toString() != null) {

						accountDetails.put("Name 2", result.getAccount_Name_Ext__c().toString());
					} else {
						accountDetails.put("Name 2", "");
					}
				} catch (Exception e) {

				}
				accDetails.add(accountDetails);
			}
		} else {
			System.out.println("Query didn't give any results");
		}
		return accDetails;
	}
	
	public static ArrayList<Map<String, String>> GetContactsDetails() throws Exception {
		ArrayList<Map<String, String>> conDetails = new ArrayList<Map<String, String>>();
		LoginComponent.login();
		EnterpriseConnection connection = LoginComponent.getConnection();
		System.out.println(
				"SELECT FirstName, LastName FROM Contact WHERE LastModifiedDate > 2021-11-19T00:00:00.000Z AND LastModifiedDate < 2021-11-20T00:00:00.000Z AND LastModifiedById = '0050L00000937XhQAI'");
		queryResults = connection.query(
				"SELECT FirstName, LastName FROM Contact WHERE LastModifiedDate > 2021-11-19T00:00:00.000Z AND LastModifiedDate < 2021-11-20T00:00:00.000Z AND LastModifiedById = '0050L00000937XhQAI'");
		connection.logout();
		if (queryResults != null && queryResults.getSize() > 0) {
			for (int i = 0; i < queryResults.getSize(); i++) {
				HashMap<String, String> contactDetails = new HashMap<String, String>();
				Contact result = (Contact) queryResults.getRecords()[i];
				try {
					if (result.getFirstName()!= null) {

						contactDetails.put("FirstName", result.getFirstName().toString());
					} else {
						contactDetails.put("FirstName", "");
					}
					
					
					if (result.getLastName() != null) {

						contactDetails.put("LastName", result.getLastName().toString());
					} else {
						contactDetails.put("LastName", "");

					}
				} catch (Exception e) {

				}
				conDetails.add(contactDetails);

			}
		} else {
			System.out.println("Query didn't give any results");
		}
		return conDetails;
	}

	public static ArrayList<Map<String, String>> GetAccountPartnerDetails() throws Exception {
		ArrayList<Map<String, String>> parDetails = new ArrayList<Map<String, String>>();
		LoginComponent.login();
		EnterpriseConnection connection = LoginComponent.getConnection();
		System.out.println(
				"SELECT Account_SAP_Number__c, CreatedDate FROM Account_to_Account_Partner_Junction__c WHERE LastModifiedDate > 2021-11-19T00:00:00.000Z AND LastModifiedDate < 2021-11-20T00:00:00.000Z AND LastModifiedById = '0050L00000937XhQAI'");
		queryResults = connection.query(
				"SELECT Account_SAP_Number__c,Partner_Description__c FROM Account_to_Account_Partner_Junction__c WHERE LastModifiedDate > 2021-11-19T00:00:00.000Z AND LastModifiedDate < 2021-11-20T00:00:00.000Z AND LastModifiedById = '0050L00000937XhQAI'");
		connection.logout();
		if (queryResults != null && queryResults.getSize() > 0) {
			for (int i = 0; i < queryResults.getSize(); i++) {
				HashMap<String, String> partnerDetails = new HashMap<String, String>();
				Account_to_Account_Partner_Junction__c result = (Account_to_Account_Partner_Junction__c) queryResults.getRecords()[i];
				try {
					if (result.getAccount_SAP_Number__c().toString()!= null) {

						partnerDetails.put("Account_SAP_Number", result.getAccount_SAP_Number__c().toString());
					} else {
						partnerDetails.put("Account_SAP_Number", "");
					}
					
					
					if (result.getPartner_Description__c().toString() != null) {

						partnerDetails.put("Partner_Description__c", result.getPartner_Description__c().toString());
					} else {
						partnerDetails.put("Partner_Description__c", "");
					}
				} catch (Exception e) {

				}
				parDetails.add(partnerDetails);
			}
		} else {
			System.out.println("Query didn't give any results");
		}
		return parDetails;
	
	}

	/*public static void insertcase() throws Exception
	{
		ReqParamForCase x = new ReqParamForCase();
		x.setCaseNotes("Auto123Note");
		x.setCaseTitle("Auto123Title");
		x.setEquipmentNumber("100036211");
		x.setPriority("2-System Down");
		x.setOriginatorLoginName("Automation MasterDataAdmin");
		try
		{                                  
			System.out.println("\nInserting...\n");
			SoapConnection sc = new SoapConnection(LoginComponent.configConnection());
			sc.CreateCase(x);
			System.out.println("Case has been inserted successfully.");

		}
		catch (ConnectionException ce)
		{
			ce.printStackTrace();
		}
	}
*/
	
}