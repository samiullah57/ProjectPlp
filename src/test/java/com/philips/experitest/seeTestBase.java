package com.philips.experitest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.Message;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.philips.generic.AutomationConstants;
import com.philips.generic.EmailUtils;
import com.philips.generic.Utility;
import com.philips.generic.configs.EnvironmentFactory;
import com.philips.pages.BaseLib;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class seeTestBase {
	//public static final String ACCESSKEY = EnvironmentFactory.getSeeTestConfig("AccessKey");
	public static IOSDriver<IOSElement> stDriver = null;
	public DesiredCapabilities dc = new DesiredCapabilities();
	public static String loggedinUserName = "";
	public static String UserName = "";
	public static String password = null;
	private boolean flag = true;
	private boolean sync_flag = true;

	public IOSDriver<IOSElement> accessDevice(String device) throws MalformedURLException 
	{
		//System.out.println("ACCESSKEY:"+ACCESSKEY);
		switch (device) 
		{
		case "iPhone":
			dc.setCapability("testName", "Quick Start iOS Native Demo");
			dc.setCapability("accessKey", "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51Ijo0NTAzMCwieHAucCI6MSwieHAubSI6MTYzMDA1MDMxMjc2NSwiZXhwIjoxOTQ1NDEwMzE0LCJpc3MiOiJjb20uZXhwZXJpdGVzdCJ9.EzX571gbyxCwAZHDVMafW7RjGLKpqocKvWW8Dtrs6-s");
			dc.setCapability("deviceQuery", "@os='ios' and @category='PHONE'");
			dc.setCapability(MobileCapabilityType.APP, "cloud:com.servicemaxinc.fsa");
			dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.servicemaxinc.fsa");
			dc.setCapability("appVersion", "6");
			break;
		case "iPad":
			dc.setCapability("testName", "Quick Start iOS Native Demo");
			dc.setCapability("accessKey","eyJhbGciOiJIUzI1NiJ9.eyJ4cC51Ijo0NTAzMCwieHAucCI6MSwieHAubSI6MTYzMDA1MDMxMjc2NSwiZXhwIjoxOTQ1NDEwMzE0LCJpc3MiOiJjb20uZXhwZXJpdGVzdCJ9.EzX571gbyxCwAZHDVMafW7RjGLKpqocKvWW8Dtrs6-s");
			dc.setCapability("deviceQuery", "@os='ios' and @category='TABLET'");
			dc.setCapability(MobileCapabilityType.APP, "cloud:com.servicemaxinc.fsa");
			dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.servicemaxinc.fsa");
			dc.setCapability("appVersion", "6");
			break;
		}
		stDriver = new IOSDriver<>(new URL("https://philips.experitest.com/wd/hub"), dc);  
		stDriver.rotate(ScreenOrientation.PORTRAIT);
		return stDriver;
	}


	public void loginfsa(String userRole) throws InterruptedException
	{
		waitForDeviceToInteract(20000);
		switch (userRole) 
		{
		case "Admin":
			loggedinUserName = EnvironmentFactory.getConfigValue("Admin User");
			UserName = EnvironmentFactory.getConfigValue("Admin");
			password = Utility.decode(EnvironmentFactory.getConfigValue("AdminPassword"));
			break;
		case "ITOpAdmin":
			loggedinUserName = EnvironmentFactory.getConfigValue("ITOpAdmin User");
			UserName = EnvironmentFactory.getConfigValue("ITOpAdmin");
			password = Utility.decode(EnvironmentFactory.getConfigValue("ITOpAdminPassword"));
			break;
		case "MasterDataAdmin":
			loggedinUserName = EnvironmentFactory.getConfigValue("MasterDataAdmin User");
			UserName = EnvironmentFactory.getConfigValue("MasterDataAdmin");
			password = Utility.decode(EnvironmentFactory.getConfigValue("MasterDataAdminPassword"));
			break;
		case "ServiceAgent":
			loggedinUserName = EnvironmentFactory.getConfigValue("ServiceAgent User");
			UserName = EnvironmentFactory.getConfigValue("ServiceAgent");
			password = Utility.decode(EnvironmentFactory.getConfigValue("ServiceAgentPassword"));
			break;
		case "ServiceTechnician":
			loggedinUserName = EnvironmentFactory.getConfigValue("ServiceTechnician User");
			UserName = EnvironmentFactory.getConfigValue("ServiceTechnician");
			password = Utility.decode(EnvironmentFactory.getConfigValue("ServiceTechnicianPassword"));
			break;
		case "Quote Admin":
			loggedinUserName = EnvironmentFactory.getConfigValue("Quote Admin");
			UserName = EnvironmentFactory.getConfigValue("QuoteAdmin");
			password = Utility.decode(EnvironmentFactory.getConfigValue("QuoteAdminPwd"));
			break;
		case "ServiceAgentNew":
			loggedinUserName = EnvironmentFactory.getConfigValue("ServiceAgentNew User");
			UserName = EnvironmentFactory.getConfigValue("ServiceAgentNew");
			password = Utility.decode(EnvironmentFactory.getConfigValue("ServiceAgentNewPassword"));
			break;
		case "ASPTechnician":
			loggedinUserName = EnvironmentFactory.getConfigValue("ASP Technician");
			UserName = EnvironmentFactory.getConfigValue("ASPTechnician");
			password = Utility.decode(EnvironmentFactory.getConfigValue("ASPTechnicianPassword"));
			break;
		}


		try
		{

			stDriver.findElement(By.xpath("//*[@id='SIGN IN WITH SALESFORCE']")).click();
			waitForDeviceToInteract(5000);
			stDriver.findElement(By.xpath("//*[@id='username']")).sendKeys(UserName);
			waitForDeviceToInteract(5000);
			stDriver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
			waitForDeviceToInteract(5000);
			stDriver.findElement(By.xpath("//*[@id='Login']")).click();
			waitForDeviceToInteract(5000);
			BaseLib.logReport("INFO", "Loggedin to " + "Device");
			Utility.CaptureScreenShotWithTestStepNameUsingRobotClass();
		}catch(Exception e)
		{
			waitForDeviceToInteract(20000);
			System.out.println("Already Loggedin");

		}
		try {
			waitForDeviceToInteract(5000);
			stDriver.findElement(By.xpath("//*[@id='Finish']")).click();
			waitForDeviceToInteract(5000);
		}catch(Exception e) {}

	}
	public void clickonExploreButton() throws InterruptedException {
		try{
			mClick(stDriver.findElement(By.xpath("//*[@id='Explore, tab, 2 of 5']")),"+ Explore");
			waitForDeviceToInteract(5000);
		}catch(Exception e) {
			mClick(stDriver.findElement(By.xpath("//*[@id='Explore, tab, 2 of 5']")),"+ Explore");
			waitForDeviceToInteract(5000);
		}
	}

	public void verify_Searches_AndExlore() throws InterruptedException {

		waitForDeviceToInteract(5000);
		System.out.println("Account Search Displayed:"+stDriver.findElement(By.xpath("//*[@id='09 - Account Search']")).isDisplayed());
		System.out.println("Installed Product Search Displayed:"+stDriver.findElement(By.xpath("//*[@id='04 - Installed Product Search']")).isDisplayed());
		System.out.println("Work Orders assigned to me Displayed:"+stDriver.findElement(By.xpath("//*[@id='01 - Work Orders assigned to me']")).isDisplayed());
		System.out.println("Serial Number Search Displayed:"+stDriver.findElement(By.xpath("//*[@id='03 - Serial Number Search']")).isDisplayed());
		System.out.println("SWO Number Search Displayed:"+stDriver.findElement(By.xpath("//*[@id='10 - SWO Number Search']")).isDisplayed());
		System.out.println("Parts assigned to me Displayed:"+stDriver.findElement(By.xpath("//*[@id='02 - Parts assigned to me']")).isDisplayed());
		BaseLib.logReport("INFO", "clicked on Explore Properties Displayed");
		BaseLib.embedScreenShotInreportWithRobot();
	}
	public void clickonInProgressWorkOrder() throws InterruptedException {

		try {
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='01 - Work Orders assigned to me']")),"+ Work Orders assigned to me");
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Work Orders - In Process']")),"+ Clicked Work Orders Inprocess ");
		}catch(Exception e) {}
		waitForDeviceToInteract(5000);
		String workOrd = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("WORK_ORDER_NUMBER");
		//String workOrd = "WO-02552925";
		try {
			while(!stDriver.findElement(By.xpath("//*[@id='"+workOrd+"']")).isDisplayed()){
				swipeScreen("UP");
			}
			mClick(stDriver.findElement(By.xpath("//*[@id='"+workOrd+"']")),"+ Clicked Work Order");
			waitForDeviceToInteract(3000);
		}catch(Exception e) {

		}
		try {
			swipeScreen("UP");
			while(!stDriver.findElement(By.xpath("//*[@id='"+workOrd+"']")).isDisplayed()){
				swipeScreen("UP");
			}
			waitForDeviceToInteract(5000);
			mClick(stDriver.findElement(By.xpath("//*[@id='"+workOrd+"']")),"+ Clicked Work Order");
		}catch(Exception e) {}
	}
	public void FCO_WO_InProgress() throws InterruptedException {
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='01 - Work Orders assigned to me']")),"+ Work Orders assigned to me");
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Work Orders - In Process']")),"+ Clicked Work Orders Inprocess ");
		waitForDeviceToInteract(5000);
		String workOrd = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("WORK_ORDER_NUMBER");
		//String workOrd = "WO-02552925";
		try {
			waitForDeviceToInteract(5000);
			List<IOSElement> mobileEle = stDriver.findElements(By.xpath("//*[@id=' Search Work Order Number']//*[@class='UIAView']"));
			mClick(mobileEle.get(mobileEle.size()-1),"+ Search filter");
			waitForDeviceToInteract(5000);
			mClick(stDriver.findElement(By.xpath("//*[@id='Include Online Results']//*[@text='0']")),"+ Clicked include Online Search ");
			waitForDeviceToInteract(5000);
			mClick(stDriver.findElement(By.xpath("//*[@id='Apply']//*[@id='Apply']")),"+ Clicked Apply");
			waitForDeviceToInteract(30000);
			try {
				stDriver.findElement(By.xpath("//*[@id='In progress']"));
				waitForDeviceToInteract(3000);
			}catch(Exception e) {}
			try {
				while(stDriver.findElement(By.xpath("//*[@id='In progress']")).isDisplayed()) {
					waitForDeviceToInteract(5000);
				}
			}catch(Exception e) {}

			stDriver.findElement(By.xpath("//*[@placeholder='Search Work Order Number']")).sendKeys(workOrd);
			waitForDeviceToInteract(5000);
			mClick(stDriver.findElement(By.xpath("//*[@id='Return']")),"+ Clicked Return");
			waitForDeviceToInteract(5000);
			try {
				while(stDriver.findElement(By.xpath("//*[@id='In progress']")).isDisplayed()) {
					waitForDeviceToInteract(5000);
				}
			}catch(Exception e) {}
			waitForDeviceToInteract(5000);
			mClick(stDriver.findElement(By.xpath("//*[@id='"+workOrd+"']")),"+ Clicked Work Order");
			waitForDeviceToInteract(10000);
		}catch(Exception e) {}
	}
	public void confi_Sync() throws InterruptedException {
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='More, tab, 5 of 5']")),"+ Clicked More Tab");
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Sync']")),"+ Clicked Sync");
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Run Data Purge Run Data Purge']/preceding-sibling::*")),"+ Clicked Conf Sync");
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@text='Perform Config Sync']")),"+ Clicked Conf Sync");
		waitForDeviceToInteract(30000);
		try {
			while(stDriver.findElement(By.xpath("//*[@id='Configuration sync in progress']")).isDisplayed()) {
				waitForDeviceToInteract(5000);
			}
		}catch(Exception e) {}

	}
	public void sync() throws InterruptedException {
		try {
			waitForDeviceToInteract(3000);
			mClick(stDriver.findElement(By.xpath("//*[@id='Calendar, tab, 1 of 5']")),"+ Clicked Work Order");
			waitForDeviceToInteract(3000);
		}catch(Exception e) {}
		List<IOSElement> eles = stDriver.findElements(By.xpath("//*[@XCElementType='XCUIElementTypeOther' and @class='UIAView' and @knownSuperClass='UIView' and @hidden='false' and @enabled='true' and @visible='true' and @onScreen='true' and @top='true']"));
		for(int i=0;i<eles.size();i++) {
			if(eles.get(i).getText().equalsIgnoreCase("S M T W T F S")) {

				try {
					eles.get(i-1).click();
					break;
				}catch(Exception e) {}
			}
		}
		BaseLib.embedScreenShotInreportWithRobot();
		waitForDeviceToInteract(5000);

		while(flag) {

			while(sync_flag) {
				try {
					mClick(stDriver.findElements(By.xpath("//*[@id='Sync Now' and @text='Sync Now' and @class='UIAView' and @XCElementType='XCUIElementTypeOther']")).get(1),"+ Clicked Sync Button");
					sync_flag = false;
					waitForDeviceToInteract(30000);
				}catch(Exception e) {

				}
			}
			try {
				System.err.println("Sync Buton Disp:"+stDriver.findElements(By.xpath("//*[@id='Sync Now' and @text='Sync Now' and @class='UIAView' and @XCElementType='XCUIElementTypeOther']")).get(1).isDisplayed());
				if(stDriver.findElements(By.xpath("//*[@id='Sync Now' and @text='Sync Now' and @class='UIAView' and @XCElementType='XCUIElementTypeOther']")).get(1).isDisplayed()) {
					flag = false;
				}
			}catch(Exception e) {}
			waitForDeviceToInteract(5000);
		}
		flag = true;
		sync_flag = true;
		clickonExploreButton();
		Utility.CaptureScreenShotWithTestStepNameUsingRobotClass();
		waitForDeviceToInteract(5000);
	}

	public void actionBtn() {
		List<IOSElement> eles = stDriver.findElements(By.xpath("//*[@XCElementType='XCUIElementTypeOther' and @class='UIAView' and @knownSuperClass='UIView' and @hidden='false' and @enabled='true' and @visible='true' and @onScreen='true' and @top='true']"));
		for(int i=0;i<eles.size();i++) {
			if(eles.get(i).getText().equalsIgnoreCase("Calendar, tab, 1 of 5 Explore, tab, 2 of 5 Recents, tab, 3 of 5 Timesheets, tab, 4 of 5 More, tab, 5 of 5")) {

				try {
					eles.get(i-1).click();
				}catch(Exception e) {}
			}
		}
		BaseLib.embedScreenShotInreportWithRobot();
	}
	public void backBtn() {

		List<IOSElement> eles = stDriver.findElements(By.xpath("//*[@class='UIAView' and @onScreen='true' and @top='true' and @visible='true' and @hidden='false' and @enabled='true' and @knownSuperClass='UIView' and @XCElementType='XCUIElementTypeOther']"));
		for(int i=0;i<eles.size();i++) {
			if(eles.get(i).getText().equalsIgnoreCase("ESMX View Work Details WL-")) {
				try {
					eles.get(i-1).click();
				}catch(Exception e) {eles.get(i-2).click();}
			}
		}
	}
	public void initiateTravel() throws InterruptedException {

		waitForDeviceToInteract(5000);
		actionBtn();
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Initiate Travel']")),"+ Clicked Initiate Travel Button");
		BaseLib.embedScreenShotInreportWithRobot();
		waitForDeviceToInteract(50000);
	}
	public void receiveParts() throws InterruptedException {
		waitForDeviceToInteract(5000);
		actionBtn();
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Receive Parts']")),"+ Clicked Receive Parts Button");
		BaseLib.embedScreenShotInreportWithRobot();
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='PARTS SHIPPED']")),"+ Clicked parts shipped Button");
		BaseLib.embedScreenShotInreportWithRobot();
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@text='SHIPPED' and @class='UIAStaticText']")),"+ Clicked Shipped Button");
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@text='Line Status Shipped' and ./*[@text='Line Status']]//*[@id='Shipped']")),"+ Clicked Line Status Button");
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Delivered']")),"+ Clicked Line Status Delivered");
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Save']")),"+ Clicked Save");
		waitForDeviceToInteract(3000);
		BaseLib.embedScreenShotInreportWithRobot();
		mClick(stDriver.findElement(By.xpath("//*[@id='Save']")),"+ Clicked Save");
		waitForDeviceToInteract(3000);
		try {
			mClick(stDriver.findElement(By.xpath("//*[@id='Dismiss']")),"+ Clicked Dismiss Button");
			waitForDeviceToInteract(5000);
			mClick(stDriver.findElement(By.xpath("//*[@id='Save']")),"+ Clicked Save");
			waitForDeviceToInteract(5000);
		}catch(Exception e) {
			try {
				mClick(stDriver.findElement(By.xpath("//*[@id='Save']")),"+ Clicked Save");
				waitForDeviceToInteract(5000);
			}catch(Exception e1) {}
		}
	}
	public void InitiateOnsite() throws InterruptedException {

		waitForDeviceToInteract(5000);
		actionBtn();
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Initiate Onsite']")),"+ Clicked Initiate Onsite Button");
		BaseLib.embedScreenShotInreportWithRobot();
		waitForDeviceToInteract(50000);
	}
	public void addLabor() throws InterruptedException {
		waitForDeviceToInteract(5000);
		actionBtn();
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Add Labor or Parts']")),"+ Clicked Add Labor and Parts Tab");
		waitForDeviceToInteract(3000);
		BaseLib.embedScreenShotInreportWithRobot();
		mClick(stDriver.findElement(By.xpath("//*[@id='OPEN LABOR']")),"+ Clicked Open Labor Tab");
		waitForDeviceToInteract(3000);
		BaseLib.embedScreenShotInreportWithRobot();
		mClick(stDriver.findElement(By.xpath("//*[@id='Labor Activity Type: Travel']")),"+ Clicked Labor Activity Tab");
		waitForDeviceToInteract(3000);
		List<IOSElement> eles = stDriver.findElements(By.xpath("//*[contains(@id,'Start Date and Time ')]//*[@class='UIAStaticText']"));
		for(int i=0;i<eles.size();i++) {
			if(eles.get(i).getText().equalsIgnoreCase("Start Date and Time")) {
				try {
					eles.get(i+1).click();
					break;
				}catch(Exception e) {}
			}
		}
		waitForDeviceToInteract(30000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Done']")),"+ Clicked Done");
		waitForDeviceToInteract(10000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Line Status Open']")),"+ Clicked Line Status Open ");
		waitForDeviceToInteract(10000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Confirmed']")),"+ Clicked Confirmed");
		waitForDeviceToInteract(30000);
		BaseLib.embedScreenShotInreportWithRobot();
		waitForDeviceToInteract(3000);
		stDriver.findElement(By.xpath("//*[@id='Duration (in Hours)']//*[@class='UIATextField']")).sendKeys("0.01");

		waitForDeviceToInteract(3000); 
		mClick(stDriver.findElement(By.xpath("//*[@id='Save']")),"+ Clicked Save");
		waitForDeviceToInteract(30000);
		try {
			waitForDeviceToInteract(3000);
			mClick(stDriver.findElement(By.xpath("//*[@id='Save']")),"+ Clicked Save");
			waitForDeviceToInteract(3000);
		}catch(Exception e) {}


	}
	public void labor_Activity_Type() throws InterruptedException {

		try {
			waitForDeviceToInteract(5000);
			actionBtn();
			waitForDeviceToInteract(5000);
			mClick(stDriver.findElement(By.xpath("//*[@id='Add Labor or Parts']")),"+ Clicked Add Labor and Parts Tab");
			waitForDeviceToInteract(3000);
			mClick(stDriver.findElement(By.xpath("//*[@id='OPEN LABOR']")),"+ Clicked Open Labor Tab");
			waitForDeviceToInteract(3000);
			BaseLib.embedScreenShotInreportWithRobot();
		}catch(Exception e) {}
		waitForDeviceToInteract(30000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Labor Activity Type: [Labor Activity Type]']")),"+ Clicked Labor Activity Type");
		waitForDeviceToInteract(30000);
		BaseLib.embedScreenShotInreportWithRobot();
		List<IOSElement> eless = stDriver.findElements(By.xpath("//*[contains(@id,'Start Date and Time ')]//*[@class='UIAStaticText']"));
		for(int i=0;i<eless.size();i++) {
			if(eless.get(i).getText().equalsIgnoreCase("Start Date and Time")) {
				try {
					eless.get(i+1).click();
					break;
				}catch(Exception e) {}
			}
		}
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Done']")),"+ Clicked Done");
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Line Status Open']")),"+ Clicked Line Status Open");
		waitForDeviceToInteract(30000);

		mClick(stDriver.findElement(By.xpath("//*[@id='Confirmed']")),"+ Clicked Confirmed");
		waitForDeviceToInteract(3000);
		BaseLib.embedScreenShotInreportWithRobot();
		mClick(stDriver.findElement(By.xpath("//*[@id='Labor Activity Type --None--']")),"+ Clicked Labor Activity Type");
		waitForDeviceToInteract(30000);

		mClick(stDriver.findElement(By.xpath("//*[@id='Work']")),"+ Clicked Work");
		waitForDeviceToInteract(30000);

		mClick(stDriver.findElement(By.xpath("//*[@id='Activity Type --None--']")),"+ Clicked Activity Type");
		waitForDeviceToInteract(30000);
		BaseLib.embedScreenShotInreportWithRobot();
		mClick(stDriver.findElement(By.xpath("//*[@id='Work Time']")),"+ Clicked Work Time");

		waitForDeviceToInteract(30000);
		stDriver.findElement(By.xpath("//*[@id='Duration (in Hours)']//*[@class='UIATextField']")).sendKeys("0.01");;
		BaseLib.embedScreenShotInreportWithRobot();
		waitForDeviceToInteract(30000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Save']")),"+ Clicked Save");
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Save']")),"+ Clicked Save");
		waitForDeviceToInteract(5000);
		try {
			mClick(stDriver.findElement(By.xpath("//*[@id='Save']")),"+ Clicked Save");
			waitForDeviceToInteract(5000);
		}catch(Exception e) {}
	}
	public void consumePart() throws InterruptedException {

		waitForDeviceToInteract(5000);
		actionBtn();
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Add Labor or Parts']")),"+ Clicked Add Labor and Parts Tab");
		waitForDeviceToInteract(3000);
		BaseLib.embedScreenShotInreportWithRobot();
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='OPEN LABOR']")),"+ Clicked Open Labor Tab");
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='OPEN PARTS RETURNABLE']")),"+ Clicked OPEN PARTS RETURNABLE Tab");
		waitForDeviceToInteract(5000);     
		BaseLib.embedScreenShotInreportWithRobot();
		mClick(stDriver.findElement(By.xpath("//*[@text='Part Number: "+BaseLib.TEST_DATA.get(0).get("Parts")+"' and @class='UIAStaticText']")),"+ Clicked Open Button");
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Part Status --None--']//*[@id='--None--']")),"+ Clicked Line Status Button");
		waitForDeviceToInteract(3000);        
		mClick(stDriver.findElement(By.xpath("//*[@id='Consumed']")),"+ Clicked Part Status Consumed");
		waitForDeviceToInteract(3000);
		BaseLib.embedScreenShotInreportWithRobot();
		stDriver.findElement(By.xpath("//*[@id='Defective Part Number']//*[@class='UIATextField']")).sendKeys(BaseLib.TEST_DATA.get(0).get("Defective Part Number"));
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Return']")),"+ Clicked Return");
		waitForDeviceToInteract(3000);
		{
			try {
				while(!stDriver.findElement(By.xpath("//*[@value='IP structure is non-available No']")).isDisplayed()){
					swipeScreen("UP");
				}
				mClick(stDriver.findElement(By.xpath("//*[@value='IP structure is non-available No']//*[@text='0']")),"+ Clicked IP structure is non-available");
				waitForDeviceToInteract(3000);
			}catch(Exception e) {}
		}
		BaseLib.embedScreenShotInreportWithRobot();
		{
			while(!stDriver.findElement(By.xpath("//*[@id='Defective Serial Number']")).isDisplayed()){
				swipeScreen("UP");
			}
			stDriver.findElement(By.xpath("//*[@id='Defective Serial Number']//*[@class='UIATextField']")).sendKeys(BaseLib.TEST_DATA.get(0).get("Defective Serial Number"));
			waitForDeviceToInteract(3000);
			mClick(stDriver.findElement(By.xpath("//*[@id='Return']")),"+ Clicked Return");
			waitForDeviceToInteract(3000);
		}
		BaseLib.embedScreenShotInreportWithRobot();
		{
			while(!stDriver.findElement(By.xpath("//*[@id='Defective Part Failure Reason']")).isDisplayed()){
				swipeScreen("UP");
			}
			mClick(stDriver.findElement(By.xpath("//*[@id='Defective Part Failure Reason --None--']//*[@id='--None--']")),"+ Clicked DDefective Part Failure Reason Button");
			waitForDeviceToInteract(3000);
			mClick(stDriver.findElement(By.xpath("//*[@id='DEFECTIVE PART']")),"+ Clicked DEFECTIVE part");
			waitForDeviceToInteract(3000);
		}
		BaseLib.embedScreenShotInreportWithRobot();
		{
			while(!stDriver.findElement(By.xpath("//*[@id='Defective Part Category']")).isDisplayed()) {
				swipeScreen("UP");
			}
			mClick(stDriver.findElement(By.xpath("//*[@id='Defective Part Category --None--']//*[@id='--None--']")),"+ Clicked Defective Part Category Button");
			waitForDeviceToInteract(3000);
			mClick(stDriver.findElement(By.xpath("//*[@id='PART INTERMITTENT FAILURE']")),"+ Clicked PART FAILED");
			waitForDeviceToInteract(3000);
		}
		{
			while(!stDriver.findElement(By.xpath("//*[@id='RML Number']")).isDisplayed()) {
				swipeScreen("UP");
			}
			stDriver.findElement(By.xpath("//*[@id='RML Number']//*[@class='UIATextField']")).sendKeys(BaseLib.TEST_DATA.get(0).get("RML Number"));
			waitForDeviceToInteract(3000);
			mClick(stDriver.findElement(By.xpath("//*[@id='Return']")),"+ Clicked Return");
			waitForDeviceToInteract(3000);
		}
		{
			while(!stDriver.findElement(By.xpath("//*[@id='Return Tracking Number']")).isDisplayed()) {
				swipeScreen("UP");
			}
			stDriver.findElement(By.xpath("//*[@id='Return Tracking Number']//*[@class='UIATextField']")).sendKeys(BaseLib.TEST_DATA.get(0).get("Return Tracking Number"));
			waitForDeviceToInteract(3000);
			mClick(stDriver.findElement(By.xpath("//*[@id='Return']")),"+ Clicked Return");
			waitForDeviceToInteract(3000);
		}
		{
			while(!stDriver.findElement(By.xpath("//*[@id='Line Status']")).isDisplayed()) {
				swipeScreen("UP");
			}
			mClick(stDriver.findElement(By.xpath("//*[@text='Line Status Open' and ./*[@text='Line Status']]//*[@id='Open']")),"+ Clicked Line Status Button");
			waitForDeviceToInteract(3000);
			mClick(stDriver.findElement(By.xpath("//*[@id='Confirmed']")),"+ Clicked Line Status Confirmed");
			waitForDeviceToInteract(3000);
			BaseLib.embedScreenShotInreportWithRobot();
		}
		{
			while(!stDriver.findElement(By.xpath("//*[@id='Defective Part Information']")).isDisplayed()) {
				swipeScreen("DOWN");
			}
			stDriver.findElement(By.xpath("//*[@id='Defective Part Information']//*[@knownSuperClass='UITextView']")).sendKeys("Test");
			waitForDeviceToInteract(5000);
		}

		mClick(stDriver.findElement(By.xpath("//*[@id='Save']")),"Save Button");
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Save']")),"Save Button");
		waitForDeviceToInteract(10000);
	}
	public void addRecordTool() throws InterruptedException {
		waitForDeviceToInteract(5000);
		actionBtn();
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Record Tools']")),"+ Clicked Record Tools");
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='TOOLS']")),"+ Clicked Tools Tab");
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Add Tools']")),"+ Clicked Add Tools");
		BaseLib.embedScreenShotInreportWithRobot();
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Tools Lookup']")),"+ Clicked Tools Lookup");
		waitForDeviceToInteract(5000);
		System.out.println("Record Tool :"+BaseLib.TEST_DATA.get(0).get("Record Tool"));
		stDriver.findElement(By.xpath("//*[@text='Search Serial/Asset Number, Model Number, Device Description, Service Team, Tool Code, Tool Owner, Member Name' and @knownSuperClass='UITextField']")).sendKeys(BaseLib.TEST_DATA.get(0).get("Record Tool"));
		waitForDeviceToInteract(30000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Filter']")),"+ Clicked Filter Lookup");
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Include Online Results']//*[@class='UIASwitch']")),"+ Clicked Include Online");
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElements(By.xpath("//*[@id='See results' and @text='See results']")).get(1),"+ Clicked search Online");
		BaseLib.embedScreenShotInreportWithRobot();
		waitForDeviceToInteract(30000);
		mClick(stDriver.findElement(By.xpath("//*[@id='EPIQ CVx Ultrasound system']")),"+ Clicked Include Online");
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Add' and @text='Add']")),"+ Clicked Add");
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Save']")),"Save Button");
		waitForDeviceToInteract(3000);
	}
	public void debriefAndFollow() throws InterruptedException {
		waitForDeviceToInteract(5000);
		actionBtn();
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Debrief and Follow up']")),"+ Clicked Debrief and Follow up");
		BaseLib.embedScreenShotInreportWithRobot();
		waitForDeviceToInteract(5000);
		{
			while(!stDriver.findElement(By.xpath("//*[@id='Debrief System Status Date / Time*']")).isDisplayed()){
				swipeScreen("UP");
			}
			mClick(stDriver.findElement(By.xpath("//*[@id='Debrief System Status* --None--']//*[@id='--None--']")),"+ Clicked Debrief System");
			waitForDeviceToInteract(3000);
			mClick(stDriver.findElement(By.xpath("//*[@id='The system meets the specification for the performed service and is returned to use']")),"+ Clicked System Status");
			waitForDeviceToInteract(4000);
		}
		{
			while(!stDriver.findElement(By.xpath("//*[@id='Debrief System Status Date / Time*']//*[@class='UIAStaticText']")).isDisplayed()){
				swipeScreen("UP");
			}
			mClick(stDriver.findElements(By.xpath("//*[@id='Debrief System Status Date / Time*']//*[@class='UIAStaticText']")).get(1),"+ Clicked Debrief System Status ");
			waitForDeviceToInteract(4000);
			mClick(stDriver.findElement(By.xpath("//*[@id='Done']")),"+ Clicked Done");
			waitForDeviceToInteract(3000);
		}
		BaseLib.embedScreenShotInreportWithRobot();
		{
			//swipeScreen("UP");
			while(!stDriver.findElement(By.xpath("//*[@id='T&V Status* --None--']")).isDisplayed()){
				swipeScreen("UP");
			}
			waitForDeviceToInteract(3000);
			mClick(stDriver.findElement(By.xpath("//*[@id='T&V Status* --None--']")),"+ Clicked T&V Status");
			waitForDeviceToInteract(3000);
			mClick(stDriver.findElement(By.xpath("//*[@id='Reported']")),"+ Clicked Reported ");
			waitForDeviceToInteract(3000);
		}
		BaseLib.embedScreenShotInreportWithRobot();
		{
//			while(!stDriver.findElement(By.xpath("//*[@id='Unable to Determine']")).isDisplayed()){
//				swipeScreen("UP");
//			}
//			mClick(stDriver.findElement(By.xpath("//*[@id='Unable to Determine No']//*[@text='0']")),"+ Clicked Unable to Determine");
//			waitForDeviceToInteract(3000);
		}
		{
			while(!stDriver.findElement(By.xpath("//*[@id='Hazard Category --None--']//*[@id='--None--']")).isDisplayed()){
				swipeScreen("UP");
			}
			mClick(stDriver.findElement(By.xpath("//*[@id='Hazard Category --None--']//*[@id='--None--']")),"+ Clicked Hazardous Category");
			waitForDeviceToInteract(5000);
			mClick(stDriver.findElement(By.xpath("//*[@id='Energy-Mechanical']")),"+ Clicked No Hazardous Situation");
			waitForDeviceToInteract(3000);
		}
		try{
			mClick(stDriver.findElements(By.xpath("//*[@id='Errors prevented this record from being saved. You must correct all errors to save. Section tabs containing errors have been marked ']//*[@id='']")).get(1),"+ Close Error");
			waitForDeviceToInteract(3000);
		}catch(Exception e){ }
		{
			while(!stDriver.findElement(By.xpath("//*[@id='Hazard --None--']//*[@id='--None--']")).isDisplayed()){
				swipeScreen("UP");
			}
			try {
				mClick(stDriver.findElement(By.xpath("//*[@id='Hazard --None--']//*[@id='--None--']")),"+ Clicked Hazardous Situation");
				waitForDeviceToInteract(5000);
				mClick(stDriver.findElement(By.xpath("//*[@id='Moving parts (manual)']")),"+ Clicked No Hazardous Situation");
				waitForDeviceToInteract(5000);
			}catch(Exception e) {
				swipeScreen("UP");
				mClick(stDriver.findElement(By.xpath("//*[@id='Hazard --None--']//*[@id='--None--']")),"+ Clicked Hazardous Situation");
				waitForDeviceToInteract(5000);
				mClick(stDriver.findElement(By.xpath("//*[@id='Moving parts (manual)']")),"+ Clicked No Hazardous Situation");
				waitForDeviceToInteract(5000);
			}
		}
		BaseLib.embedScreenShotInreportWithRobot();
		{
			while(!stDriver.findElement(By.xpath("//*[@id='Hazardous Situation* --None--']")).isDisplayed()){
				swipeScreen("UP");
			}
			try {
				waitForDeviceToInteract(5000);
				mClick(stDriver.findElement(By.xpath("//*[@id='Hazardous Situation* --None--']//*[@id='--None--']")),"+ Clicked Hazardous Situation");
				waitForDeviceToInteract(5000);
				mClick(stDriver.findElement(By.xpath("//*[@id='Patient Exposure to (HAZARD) Outside Clinical Use']")),"+ Clicked No Hazardous Situation");
				waitForDeviceToInteract(5000);
			}catch(Exception e) {
				swipeScreen("UP");
				waitForDeviceToInteract(5000);
				mClick(stDriver.findElement(By.xpath("//*[@id='Hazardous Situation* --None--']//*[@id='--None--']")),"+ Clicked Hazardous Situation");
				waitForDeviceToInteract(5000);
				mClick(stDriver.findElement(By.xpath("//*[@id='Patient Exposure to (HAZARD) Outside Clinical Use']")),"+ Clicked No Hazardous Situation");
				waitForDeviceToInteract(5000);
			}
		}
		BaseLib.embedScreenShotInreportWithRobot();
		waitForDeviceToInteract(10000);
		try{
			mClick(stDriver.findElement(By.xpath("//*[@id='Errors prevented this record from being saved. You must correct all errors to save. Section tabs containing errors have been marked ']//*[@id='']//*[@id='']")),"+ Clicked close");
		}catch(Exception e) {}
		{
			while(!stDriver.findElement(By.xpath("//*[@id='Clinical Usage --None--']//*[@id='--None--']")).isDisplayed()){
				swipeScreen("UP");
			}
			waitForDeviceToInteract(3000);
			mClick(stDriver.findElement(By.xpath("//*[@id='Clinical Usage --None--']//*[@id='--None--']")),"+ Clicked Clinical Usage");
			waitForDeviceToInteract(3000);
			mClick(stDriver.findElement(By.xpath("//*[@text='Unknown' and @id='Unknown']")),"+ Clicked Unknown");
			waitForDeviceToInteract(3000);
		}
		BaseLib.embedScreenShotInreportWithRobot();
		try {
			mClick(stDriver.findElement(By.xpath("//*[@id='Save']")),"Save Button");
			waitForDeviceToInteract(5000);
		}catch(Exception e) {
			mClick(stDriver.findElement(By.xpath("//*[@id='Dismiss']")),"+ Clicked Dismiss Button");
			waitForDeviceToInteract(3000);
			mClick(stDriver.findElement(By.xpath("//*[@id='Save']")),"Save Button");
			waitForDeviceToInteract(5000);
		}
	}
	public void workActivity() throws InterruptedException {
		
		try {
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='WORK ACTIVITY']")),"+ Clicked WORK ACTIVITY");
		BaseLib.embedScreenShotInreportWithRobot();
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Type: Resolution']")),"+ Clicked Problem Resolution");
		waitForDeviceToInteract(5000);
		stDriver.findElement(By.xpath("//*[@id='Description*']//*[@knownSuperClass='UITextView']")).sendKeys("Test");
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Save']")),"+ Clicked Save");
		waitForDeviceToInteract(5000);
		BaseLib.embedScreenShotInreportWithRobot();
		mClick(stDriver.findElement(By.xpath("//*[@id='Save']")),"+ Clicked Save");
		waitForDeviceToInteract(5000);
		}catch(Exception e) {
			mClick(stDriver.findElement(By.xpath("//*[@id='Save']")),"+ Clicked Save");
			waitForDeviceToInteract(5000);
		}
		diagnosedByEnginner();
	}
	public void diagnosedByEnginner() throws InterruptedException {
		try {
		mClick(stDriver.findElements(By.xpath("//*[@id='Errors prevented this record from being saved. You must correct all errors to save. Section tabs containing errors have been marked ']//*[@id='']")).get(1),"+ Close Error");
		waitForDeviceToInteract(3000);
		}catch(Exception e) {}
		try {
			waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Type: Diagnostic performed by Engineer']")),"+ Clicked  Diagnostic performed by Engineer");
		waitForDeviceToInteract(3000);
		stDriver.findElement(By.xpath("//*[@id='Description*']//*[@knownSuperClass='UITextView']")).sendKeys("Test");
		BaseLib.embedScreenShotInreportWithRobot();
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Save']")),"+ Clicked Save");
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Save']")),"+ Clicked Save");
		waitForDeviceToInteract(5000);
		}catch(Exception e) {}
	}
	public void syncData() throws InterruptedException {
		try {
			waitForDeviceToInteract(3000);
			mClick(stDriver.findElement(By.xpath("//*[@id='More, tab, 5 of 5']")),"+ Clicked More Tab");
			waitForDeviceToInteract(3000);
			mClick(stDriver.findElement(By.xpath("//*[@id='Sync']")),"+ Clicked Sync ");
			waitForDeviceToInteract(3000);
			mClick(stDriver.findElement(By.xpath("//*[contains(@id,'Run Configuration Sync Last successful sync: ')]")),"+ Clicked Sync Data ACTIVITY");
			waitForDeviceToInteract(3000);
			mClick(stDriver.findElement(By.xpath("//*[@id='Perform Config Sync']")),"+ Clicked Perform Sync");
		}catch(Exception e) {}
	}
	public void unsigned_Report() throws InterruptedException {

		waitForDeviceToInteract(5000);
		actionBtn();
		waitForDeviceToInteract(30000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Unsigned Customer Service Report']")),"+ Clicked UnSigned Customer Service Report");
		waitForDeviceToInteract(30000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Finalize' and @class='UIAView']")),"+ Clicked Finalize");
		waitForDeviceToInteract(8000);
	}
	public void complet_WO() throws InterruptedException {
		waitForDeviceToInteract(5000);
		actionBtn();
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Complete Work Order']")),"+ Clicked Complete Work Order");
		BaseLib.embedScreenShotInreportWithRobot();
		waitForDeviceToInteract(5000);
		{
			waitForDeviceToInteract(3000);
			while(!stDriver.findElement(By.xpath("//*[@id='Send Service Report For*']")).isDisplayed()) {
				swipeScreen("UP");
			}
		}
//		waitForDeviceToInteract(3000);
//		try {
//		mClick(stDriver.findElement(By.xpath("//*[@id='Send Service Report For --None--']//*[@id='--None--']")),"+ Clicked Service Report");
//		waitForDeviceToInteract(3000);
//		}catch(Exception e) {
//			mClick(stDriver.findElement(By.xpath("//*[@id='Send Service Report For* WO CSR']")),"+ Clicked Service Report");
//			
//		}
//		
//		waitForDeviceToInteract(3000);
//		mClick(stDriver.findElement(By.xpath("//*[@id='WO CSR']")),"+ Clicked WO CSR");
		waitForDeviceToInteract(5000);
		try {
			mClick(stDriver.findElements(By.xpath("//*[@id='Errors prevented this record from being saved. You must correct all errors to save. Section tabs containing errors have been marked ']//*[@id='']")).get(1),"+ Close Error");
			waitForDeviceToInteract(3000);
			}catch(Exception e) {}
		{
			swipeScreen("UP");
			waitForDeviceToInteract(3000);
			while(!stDriver.findElement(By.xpath("//*[@id='Email Service Report']")).isDisplayed()) {
				swipeScreen("UP");
			}
		}
		BaseLib.embedScreenShotInreportWithRobot();
		stDriver.findElement(By.xpath("//*[@id='Email Service Report']//*[@class='UIATextField']")).sendKeys(BaseLib.TEST_DATA.get(0).get("Email Service Report"));
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='SERVICE REPORT CONTACTS']")),"+ Clicked SERVICE REPORT CONTACTS");
		waitForDeviceToInteract(3000);  
		mClick(stDriver.findElement(By.xpath("//*[@id='Add Service Report Contacts']")),"+ Clicked Add");
		waitForDeviceToInteract(3000); 
		mClick(stDriver.findElement(By.xpath("//*[@id='Contact Lookup']")),"+ Clicked Contact lookup");
		waitForDeviceToInteract(10000);
		stDriver.findElement(By.xpath("//*[@id='Search Full Name, Email, Business Phone, Mobile Phone, Account ID']")).sendKeys(BaseLib.TEST_DATA.get(0).get("Contact"));
		waitForDeviceToInteract(15000);
		try {
			mClick(stDriver.findElement(By.xpath("//*[@id='Add']")),"+ Clicked Filter");
			waitForDeviceToInteract(10000); 
			mClick(stDriver.findElement(By.xpath("//*[@id='Include Online Results']//*[@text='0']")),"+ Clicked Filter");
			waitForDeviceToInteract(5000);
			mClick(stDriver.findElement(By.xpath("//*[@id='See results']//*[@id='See results']")),"+ Clicked Search results");
			waitForDeviceToInteract(30000); 
		}catch(Exception e) {}
		mClick(stDriver.findElement(By.xpath("//*[@id='"+BaseLib.TEST_DATA.get(0).get("Contact")+"']")),"+ Clicked Contact ");
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Add']")),"+ Clicked Add ");
		waitForDeviceToInteract(5000);
		BaseLib.embedScreenShotInreportWithRobot();
		mClick(stDriver.findElement(By.xpath("//*[@id='OVERVIEW']")),"+ Clicked OVERVIEW");
		waitForDeviceToInteract(3000); 
		clickonSaveButton();
		waitForDeviceToInteract(5000);
		try {
			mClick(stDriver.findElement(By.xpath("//*[@id='Errors prevented this record from being saved. You must correct all errors to save. Section tabs containing errors have been marked ']//*[@id='']//*[@id='']")),"+ Clicked Dismiss Button");
			waitForDeviceToInteract(3000);
		}catch(Exception e) {}
		try {
			mClick(stDriver.findElement(By.xpath("//*[@id='Dismiss']")),"+ Clicked Dismiss Button");
			waitForDeviceToInteract(5000);
			mClick(stDriver.findElement(By.xpath("//*[@id='Save']")),"+ Clicked Save");
			waitForDeviceToInteract(5000);
			BaseLib.embedScreenShotInreportWithRobot();
		}catch(Exception e) {
			try {
				mClick(stDriver.findElement(By.xpath("//*[@id='Save']")),"+ Clicked Save");
				waitForDeviceToInteract(10000);
			}catch(Exception e1) {}
		}
	}
	public static void scroll(IOSElement element, int times)
	{
		for(int i=0; i<times; i++)
		{
			try
			{
				Map<String, Object> args = new HashMap<>();
				args.put("direction", "down");
				stDriver.executeScript("mobile: scroll", args);
				waitForDeviceToInteract(5000);
				element.isDisplayed();
				System.out.println("SCRoll time:"+i);
				break;


			}
			catch(Exception e)
			{
				System.out.println("Scroll again");
			}
		}
	}
	public static void scrollup(IOSElement element, int times)
	{
		for(int i=0; i<times; i++)
		{
			try
			{
				Map<String, Object> args = new HashMap<>();
				args.put("direction", "up");
				stDriver.executeScript("mobile: scroll", args);
				waitForDeviceToInteract(5000);
				element.isDisplayed();
				System.out.println("SCRoll time:"+i);
				break;
			}
			catch(Exception e)
			{
				System.out.println("Scroll again");
			}
		}
	}
	public void swipeScreen(String dir) {
		System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions

		// Animation default time:
		//  - Android: 300 ms
		//  - iOS: 200 ms
		// final value depends on your app and could be greater
		final int ANIMATION_TIME = 2000; // ms

		final int PRESS_TIME = 1000; // ms

		int edgeBorder = 10; // better avoid edges
		PointOption pointOptionStart, pointOptionEnd = null;

		// init screen variables
		Dimension dims = stDriver.manage().window().getSize();

		// init start point = center of screen
		pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

		switch (dir) {
		case "DOWN": // center of footer
			pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
			break;
		case "UP": // center of header
			pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
			break;
		case "LEFT": // center of left side
			pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
			break;
		case "RIGHT": // center of right side
			pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
			break;
		default:

		}

		// execute swipe using TouchAction
		try {
			new TouchAction(stDriver)
			.press(pointOptionStart)
			// a bit more reliable when we add small wait
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
			.moveTo(pointOptionEnd)
			.release().perform();
		} catch (Exception e) {
			System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
			return;
		}

		// always allow swipe action to complete
		try {
			Thread.sleep(ANIMATION_TIME);
		} catch (InterruptedException e) {
			// ignore
		}
	}
	public void signature() throws InterruptedException {
		waitForDeviceToInteract(5000);
		Actions action = new Actions(stDriver);
		action.clickAndHold();
		action.build();
		Map<String, Object> args = new HashMap<>();
		args.put("direction", "right");
		stDriver.executeScript("mobile: scroll", args);
		waitForDeviceToInteract(3000);
		action.release().perform();
	}
	public void clickonPlusButton()
	{
		mClick(stDriver.findElement(By.xpath("(//*[@text='S M T W T F S' and ./parent::*[@text='S M T W T F S' and ./parent::*[@text='S M T W T F S' and ./parent::*[@text='S M T W T F S']]]]/*[@class='UIAView'])[14]")),"+ Icon");
	}

	public void enterSubject()
	{
		mEnter(stDriver.findElement(By.xpath("//*[@knownSuperClass='UITextField']")),"Subject", "Test Subject");
	}

	public void enterDescription()
	{
		mEnter(stDriver.findElement(By.xpath("//*[@XCElementType='XCUIElementTypeTextView']")),"Description", "Test Description");
	}

	public void clickonSaveButton()
	{
		mClick(stDriver.findElement(By.xpath("//*[@id='Save']")), "Save Button");
	}

	public void createEventSeeTest()
	{
		clickonPlusButton();
		enterSubject();
		enterDescription();
		clickonSaveButton();

	}

	public void tearDown() {
		Utility.CaptureScreenShotWithTestStepNameUsingRobotClass();
		try {
			stDriver.quit();
		}catch(Exception e) {}
	}

	public void mClick(IOSElement ele, String message)
	{
		ele.click();
		BaseLib.logReport("INFO", "clicked on " + message);
	}

	public void mEnter(IOSElement ele, String message, String value)
	{
		ele.sendKeys(value);
		BaseLib.logReport("INFO", "Entered " + message);
	}
	public static void waitForDeviceToInteract(long milsec) throws InterruptedException {
		Thread.sleep(milsec);
	}
	public void verify_CSR_Mail()  throws Exception {
		waitForDeviceToInteract(5000);
		EmailUtils emailUtils = new EmailUtils("r2rmeenanandish@gmail.com",
				"Mindtree@1a", "smtp.gmail.com", EmailUtils.EmailFolder.INBOX); Message email
				= emailUtils.getMessagesBySubject("Non Customer Event Approved", true, 5)[0];
				System.out.println("email:" + email.getSubject());
				String body =EmailUtils.getMessageContent(email);
				String str= body.substring(body.indexOf(" https") + 1, body.indexOf("Thank"));
				System.out.println(str);

				BaseLib.logReport("INFO", "CSR Email Verified");
	}
	public void sync_Ipad() throws InterruptedException {
		try {
			waitForDeviceToInteract(5000);
			mClick(stDriver.findElement(By.xpath("//*[@id='Calendar, tab, 1 of 5']")),"+ Clicked Work Order");
			waitForDeviceToInteract(3000);
		}catch(Exception e) {}
		List<IOSElement> eles = stDriver.findElements(By.xpath("//*[@XCElementType='XCUIElementTypeOther' and @class='UIAView' and @knownSuperClass='UIView' and @hidden='false' and @enabled='true' and @visible='true' and @onScreen='true' and @top='true']"));
		for(int i=0;i<eles.size();i++) {
			if(eles.get(i).getText().equalsIgnoreCase("SUN MON TUE WED THU FRI SAT")) {

				try {
					eles.get(i-2).click();
					break;
				}catch(Exception e) {}
			}
		}
		waitForDeviceToInteract(5000);

		while(flag) {

			while(sync_flag) {
				try {
					mClick(stDriver.findElements(By.xpath("//*[@id='Sync Now' and @text='Sync Now' and @class='UIAView' and @XCElementType='XCUIElementTypeOther']")).get(1),"+ Clicked Sync Button");
					sync_flag = false;
					waitForDeviceToInteract(60000);
				}catch(Exception e) {

				}
			}
			try {
				if(stDriver.findElements(By.xpath("//*[@id='Sync Now' and @text='Sync Now' and @class='UIAView' and @XCElementType='XCUIElementTypeOther']")).get(1).isDisplayed()) {
					flag = false;
				}
			}catch(Exception e) {}
			waitForDeviceToInteract(5000);
		}
		flag = true;
		sync_flag = true;
		clickonExploreButton();
		Utility.CaptureScreenShotWithTestStepNameUsingRobotClass();
		waitForDeviceToInteract(5000);
	}
	public void explore_pro_WO_IPad() throws InterruptedException {
		String workOrd = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("WORK_ORDER_NUMBER");
		//String workOrd = "WO-02552925";
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='"+workOrd+"']")),"+ Clicked Work Order");
		waitForDeviceToInteract(5000);
	}
	public void mark_FCO_Kit_Delivered() throws InterruptedException {
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='ACTIVITIES']")),"+ Clicked ACTIVITIES");
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='PARTS']")),"+ Clicked Parts");
		waitForDeviceToInteract(5000);
		String FCO_Part1 = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("FCO_Part1");
		//String FCO_Part1 = "459800952481";

		mClick(stDriver.findElement(By.xpath("//*[@id='"+FCO_Part1+"']")),"+ Clicked Parts");
		waitForDeviceToInteract(5000);
		actionBtn();
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Mark Delivered']")),"+ Clicked Mark Delivered");
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Save']")),"+ Clicked Save");
		waitForDeviceToInteract(5000);
	}
	public void fco_labor_Activity_Type() throws InterruptedException{
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='LABOR']")),"+ Clicked Labor");
		waitForDeviceToInteract(5000);
		try {
			labor_Activity_Type();
		}catch(Exception e) {}
	}
	public void mark_FCO_Kit_LineStatus() throws InterruptedException {
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='ACTIVITIES']")),"+ Clicked ACTIVITIES");
		waitForDeviceToInteract(3000);
		fco_labor_Activity_Type();
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='PARTS']")),"+ Clicked PARTS");
		waitForDeviceToInteract(5000);
		String FCO_Part1 = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("FCO_Part1");
		//String FCO_Part1 = "459801229061";
		mClick(stDriver.findElement(By.xpath("//*[@id='"+FCO_Part1+"']")),"+ Clicked Parts");
		waitForDeviceToInteract(5000);
		actionBtn();
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='View/Edit Lines']")),"+ Clicked View/Edit Lines");
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='OPEN']")),"+ Clicked OPEN");
		waitForDeviceToInteract(5000);
		List<IOSElement> ChildItems = stDriver.findElements(By.xpath("//*[@id='OPEN' and @class='UIAStaticText']"));
		mark_Child_Status(ChildItems.get(0));
	}
	public void mark_Child_Status(IOSElement ele) throws InterruptedException {
		waitForDeviceToInteract(3000);
		mClick(ele,"+ Clicked Child");
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@label='Line Status Open']//*[@label='Open']")),"+ Clicked Line Status");
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@label='Confirmed']")),"+ Clicked Line Status");
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@label='Part Status --None--']//*[@label='--None--']")),"+ Clicked Part Status");
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@label='Unused']")),"+ Clicked Part Status");
		waitForDeviceToInteract(3000);

		{	
			swipeScreen("UP");
			while(!stDriver.findElement(By.xpath("//*[@id='Defective Part Failure Reason --None--']")).isDisplayed()){
				swipeScreen("UP");
			}
			mClick(stDriver.findElement(By.xpath("//*[@id='Defective Part Failure Reason --None--']//*[@id='--None--']")),"+ Clicked Part Failure reason ");
			waitForDeviceToInteract(3000);
			mClick(stDriver.findElement(By.xpath("//*[@id='GOOD-SEALED']")),"+ Clicked Good");
			waitForDeviceToInteract(3000);

		}
		{
			while(!stDriver.findElement(By.xpath("//*[@id='RML Number']")).isDisplayed()){
				swipeScreen("UP");
			}
			waitForDeviceToInteract(3000);
			stDriver.findElement(By.xpath("//*[@id='RML Number']//*[@class='UIATextField']")).sendKeys(AutomationConstants.RML_List[Utility.randomNumber(100)]);
			waitForDeviceToInteract(3000);
		}
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Save']")),"+ Clicked Save");
		waitForDeviceToInteract(3000);
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Save']")),"+ Clicked Save");
		waitForDeviceToInteract(3000);
	}
	public void mark_All_Child_Status(IOSElement ele) throws InterruptedException {
		waitForDeviceToInteract(3000);
		mClick(ele,"+ Clicked Child");
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@label='Line Status Open']//*[@label='Open']")),"+ Clicked Line Status");
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@label='Confirmed']")),"+ Clicked Line Status");
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@label='Part Status --None--']//*[@label='--None--']")),"+ Clicked Part Status");
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@label='Unused']")),"+ Clicked Part Status");
		waitForDeviceToInteract(3000);

		{	
			swipeScreen("UP");
			while(!stDriver.findElement(By.xpath("//*[@id='Defective Part Failure Reason --None--']")).isDisplayed()){
				swipeScreen("UP");
			}
			mClick(stDriver.findElement(By.xpath("//*[@id='Defective Part Failure Reason --None--']//*[@id='--None--']")),"+ Clicked Part Failure reason ");
			waitForDeviceToInteract(3000);
			mClick(stDriver.findElement(By.xpath("//*[@id='GOOD-SEALED']")),"+ Clicked Good");
			waitForDeviceToInteract(3000);

		}
		{
			while(!stDriver.findElement(By.xpath("//*[@id='RML Number']")).isDisplayed()){
				swipeScreen("UP");
			}
			waitForDeviceToInteract(3000);
			stDriver.findElement(By.xpath("//*[@id='RML Number']//*[@class='UIATextField']")).sendKeys(AutomationConstants.RML_List[Utility.randomNumber(100)]);
			waitForDeviceToInteract(3000);
		}
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Save']")),"+ Clicked Save");
		waitForDeviceToInteract(3000);
	}
	public void mark_All_FCO_Kit_LineStatus() throws InterruptedException {
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='ACTIVITIES']")),"+ Clicked ACTIVITIES");
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='PARTS']")),"+ Clicked Parts");
		waitForDeviceToInteract(5000);
		String FCO_Part1 = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("FCO_Part1");
		//String FCO_Part1 = "459801229061";
		mClick(stDriver.findElement(By.xpath("//*[@id='"+FCO_Part1+"']")),"+ Clicked Parts");
		waitForDeviceToInteract(5000);
		actionBtn();
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='View/Edit Lines']")),"+ Clicked View/Edit Lines");
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='OPEN']")),"+ Clicked OPEN");
		waitForDeviceToInteract(5000);
		List<IOSElement> ChildItems = stDriver.findElements(By.xpath("//*[@id='OPEN' and @class='UIAStaticText']"));
		for(IOSElement ele :ChildItems ) {
			mark_All_Child_Status(ele);
		}
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Save']")),"+ Clicked Save");
		waitForDeviceToInteract(3000);
	}
	public void mark_FCO_Kit_Complete() throws InterruptedException {

		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='ACTIVITIES']")),"+ Clicked Complete KIT");
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='PARTS']")),"+ Clicked Parts");
		waitForDeviceToInteract(5000);
		String FCO_Part1 = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("FCO_Part1");
		//String FCO_Part1 = "459801229061";
		mClick(stDriver.findElement(By.xpath("//*[@id='"+FCO_Part1+"']")),"+ Clicked Parts");
		waitForDeviceToInteract(5000);
		actionBtn();
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Complete KIT']")),"+ Clicked Complete KIT");
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Part Status --None--']//*[@id='--None--']")),"+ Clicked Parts status");
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Unused']")),"+ Clicked Parts status unused");
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Save']")),"+ Clicked Save");
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Errors prevented this record from being saved. You must correct all errors to save. Section tabs containing errors have been marked ']//*[@id='']")),"+ Clicked Save");
		waitForDeviceToInteract(3000);
		stDriver.findElement(By.xpath("//*[@id='Cannot mark the KIT as Unused. All Lines should be in Completed State and all KIT ITEMS should be in Unused Status to make KIT as Unused.']")).isDisplayed();
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Save']/preceding-sibling::*")),"+ Clicked Close");
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Discard Changes']")),"+ Clicked Discard");
		waitForDeviceToInteract(5000);
	}
	public void mark_FCO_Kit_Complete_Success() throws InterruptedException {

		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='ACTIVITIES']")),"+ Clicked ACTIVITIES");
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='PARTS']")),"+ Clicked Parts");
		waitForDeviceToInteract(5000);
		String FCO_Part1 = AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.get("FCO_Part1");
		//String FCO_Part1 = "459801229061";
		mClick(stDriver.findElement(By.xpath("//*[@id='"+FCO_Part1+"']")),"+ Clicked Parts");
		waitForDeviceToInteract(5000);
		actionBtn();
		waitForDeviceToInteract(5000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Complete KIT']")),"+ Clicked Complete KIT");
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Part Status --None--']//*[@id='--None--']")),"+ Clicked Parts status");
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Unused']")),"+ Clicked Parts status unused");
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Line Status Open']//*[@id='Open']")),"+ Clicked Line Staus");
		waitForDeviceToInteract(3000);
		mClick(stDriver.findElement(By.xpath("//*[@id='Confirmed']")),"+ Clicked Line Staus");
		waitForDeviceToInteract(3000);
		{	
			swipeScreen("UP");
			while(!stDriver.findElement(By.xpath("//*[@id='Defective Part Failure Reason --None--']")).isDisplayed()){
				swipeScreen("UP");
			}
			mClick(stDriver.findElement(By.xpath("//*[@id='Defective Part Failure Reason --None--']//*[@id='--None--']")),"+ Clicked Part Failure reason ");
			waitForDeviceToInteract(3000);
			mClick(stDriver.findElement(By.xpath("//*[@id='GOOD-SEALED']")),"+ Clicked Good");
			waitForDeviceToInteract(3000);

		}
		{
			while(!stDriver.findElement(By.xpath("//*[@id='RML Number']//*[@class='UIAStaticText']")).isDisplayed()){
				swipeScreen("UP");
			}
			waitForDeviceToInteract(3000);
			waitForDeviceToInteract(3000);
		}
		mClick(stDriver.findElement(By.xpath("//*[@id='Save']")),"+ Clicked Save");
		waitForDeviceToInteract(3000);
	}
}