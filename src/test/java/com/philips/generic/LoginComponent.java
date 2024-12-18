package com.philips.generic;

import java.util.HashMap;
import java.util.Map;

import com.philips.generic.configs.EnvironmentFactory;
import com.sforce.soap.enterprise.Connector;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.ws.ConnectorConfig;

public class LoginComponent
{
	private static EnterpriseConnection connection=null;
	private static String userName=null;
	private static String password=null;

	private static Map<String,String> propertyMap = new HashMap<String, String>();

	/**
	 * Method to set property details from config property sheet
	 * 
	 * @param Map<String,String> configPropertyMap - Data from the config property sheet
	 */
	public static void  setConfigMap(Map<String,String> configPropertyMap)
	{
		propertyMap= configPropertyMap;
	}

	/**
	 * Method to get logged in user username
	 * 
	 * @return String username - Logged in user username
	 */
	public static String getUserName()
	{
		return userName;
	}

	/**
	 * Method to get logged in user password
	 * 
	 * @return String password - Logged in user password
	 */
	public static String getPassword()
	{
		return password;
	}


	/**
	 * Method to login based on the controller user value and environment in config sheet
	 * 
	 * @param Map<String,String> loginMap - Data consisting username,password and token to login
	 */
	public static void 	login() throws Exception
	{
		String securitytoken = "";
		ConnectorConfig config = new ConnectorConfig();

		userName=EnvironmentFactory.getConfigValue("MasterDataAdmin");
		password=Utility.decode(EnvironmentFactory.getConfigValue("MasterDataAdminPassword"));
//		if(AutomationConstants.sandbox.equalsIgnoreCase("sit"))
//		{
//			securitytoken = "EC0LzNjBfRdSzKmbUzhDEsCCr";
//		}
//		else
//		{
//			securitytoken = "Uii4ekbu2U3OMONUtWNQjvBpf";
//		}
		config.setUsername(userName);
		//config.setPassword(password+securitytoken);
		//config.setProxy("185.46.212.97", 9480); 
		config.setPassword(password);
		connection=Connector.newConnection(config);
	}

	/**
	 * Method to logout from the application
	 * 
	 */
	public static void logout() throws Exception
	{
		connection.logout();

	}

	/**
	 * Method to return logged in user connection object
	 * 
	 * @return EnterpriseConnection connection - connection object
	 */
	public static EnterpriseConnection getConnection()
	{
		//System.out.println("Connection Established");
		return connection;
	}

	/**
	 * Method to create map of login component
	 * 
	 */
	public static void clearLoginComponent()
	{
		propertyMap.clear();
	}

	public static ConnectorConfig configConnection()
	{
		ConnectorConfig config = new ConnectorConfig();	
		//userName=EnvironmentFactory.getConfigValue("MasterDataAdmin");
		//password=Utility.decode(EnvironmentFactory.getConfigValue("MasterDataAdminPassword"));
		config.setUsername("sarika_api@mq3.com");
		config.setPassword("Salesforce#123");
		return config;
	}
}