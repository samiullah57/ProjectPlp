package com.philips.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.philips.cucumber.listener.Reporter;
import com.philips.generic.AutomationConstants;
import com.philips.generic.Utility;
import com.philips.generic.configs.EnvironmentFactory;


public abstract class BaseLib
{
	public WebDriver driver;
	public ExtentTest testReport;
	public static  String loggedinUserName = "";
	public static  String UserName = "";
	public static  String password = "";
	public static ArrayList<Map<String, String>> TestData;
	public static String sapSalesnum;
	public static List<Map<String,String>> TEST_DATA = new ArrayList<Map<String,String>>();

	static Logger log = Logger.getLogger("BaseLib");

	public BaseLib(WebDriver driver)
	{
		this.driver=driver;
	}

	public void zoomOut(int level) {
		Robot robot;
		try {
			robot = new Robot();
			for(int i=0;i<level;i++) {
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_MINUS);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_MINUS);
				logReport("INFO", "Pressed Zoom Out");
				waitTill("5");
			}
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	public void unchecked(WebElement CheckBox) {
		if (!CheckBox.isSelected()) {
			logReport("INFO", "Checkbox is unchecked.");
		} else {
			logReport("ERROR", "Checkbox is checked.");
		}
	}


	public void clickRightArrow(int count) {

		try {
			Robot robot = new Robot();
			for(int i=0;i<count;i++) {
				robot.keyPress(KeyEvent.VK_RIGHT);
				robot.keyRelease(KeyEvent.VK_RIGHT);
				logReport("INFO", "Pressed right Arrow");
			}
		} catch (AWTException e) {
			logReport("WARNING", "Could not Press Tab");
		}
	}

	public void zoomIn(int level) {

		Robot robot;
		try {
			robot = new Robot();
			for(int i=0;i<level;i++) {
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_ADD);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_ADD);
				logReport("INFO", "Pressed Zoom In");
			}
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//Method to deselect all the Checkboxes
	public void deSelectAllCheckBoxes(List<WebElement> allCheckBox)
	{
		for(WebElement chkBox:allCheckBox)
		{
			if(chkBox.isSelected())
			{
				chkBox.click();
			}
			else
			{
				logReport("INFO","CheckBox is Already DeSelected");
			}
		}
		logReport("INFO","All the CheckBoxs are DeSelected");
	}

	//Method to select all the checkboxes
	public  void selectAllCheckBoxes(List<WebElement> allCheckBox)
	{
		for(WebElement chkBox:allCheckBox)
		{
			if(chkBox.isSelected())
			{
				logReport("INFO","CheckBox is Already Selected");
			}
			else
			{
				chkBox.click();

			}
		}

		logReport("INFO","All the CheckBoxs are Selected");
	}

	//Method to select CheckBox
	public  void selectCheckBoxe(WebElement CheckBox)
	{
		if(CheckBox.isSelected())
		{
			logReport("INFO","CheckBox is Already Selected");
		}
		else
		{
			CheckBox.click();

		}
	}

	//Method to DeSelect CheckBox
	public  void deSelectCheckBoxe(WebElement CheckBox)
	{
		if(CheckBox.isSelected())
		{
			CheckBox.click();
		}
		else
		{
			logReport("INFO","CheckBox is Already DeSelected");
		}
	}

	//Verify that Element is disabled
	public  boolean verifyElementDisabled(WebElement element)
	{
		if(element.isEnabled())
		{
			logReport("FAIL","Specified Element is Not Disabled");
		}
		else
		{
			logReport("PASS","Specified Element is Disabled");
		}
		return false;
	}

	//Verify that element is Enabled
	public  boolean verifyElementEnabled(WebElement element)
	{
		if(element.isEnabled())
		{
			return true;

		}

		return false;

	}

	//Verify element is present in listbox
	public  void VerifyListBoxContent(WebElement listBox,String content)
	{
		String[] allOptions = content.split(",");
		for(String option:allOptions)
		{	
			boolean present = Utility.isOptionPresentinListBox(listBox,option);
			if(present)
			{
				logReport("PASS","Specified Option is Present:"+option);
			}
			else
			{
				logReport("FAIL","Specified Option is Not Present:"+option);
			}
		}
	}

	//Verify the Selected Option
	public  void verifySelectedOption(WebElement listBox,String option)
	{
		String actualSelected=new Select(listBox).getFirstSelectedOption().getText();
		logReport("INFO","Selected option is:"+actualSelected);
		logReport("INFO","Expected option to be Selected is:"+option);
		if(actualSelected.equals(option))
		{
			logReport("PASS","Specified Option is Selected");
		}
		else
		{
			logReport("FAIL","Specified Option is Not Selected");
		}
	}

	//Verify the sorting order of Listbox
	public  void verifyListBoxIsSorted(WebElement listBox)
	{

		if(Utility.isListBoxSorted(listBox))
		{
			logReport("PASS","ListBox is Sorted");
		}
		else
		{
			logReport("FAIL","ListBox is Not Sorted");
		}
	}

	public void robortClassPressTAB(int count)
	{
		try{
			Robot robot=new Robot();
			for(int i=0; i<count; i++)
			{
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);
				waitTill("5");	
				//logReport("INFO", "Press Tab");

			}
		}
		catch(Exception e)
		{
			//logReport("WARNING", "Could not Press Tab");
			e.printStackTrace();
		}
	}

	public void scrollToElement(List<WebElement> element,WebElement elementToClick)
	{
		int count =0;
		while(count < 15)
		{							
			if(element.size()>0)
			{
				break;
			} 
			else 
			{
				if(count == 0) 
				{
					click("Previous Element", elementToClick);
				}
				robortClassPressTAB(2);	
			}
			count++;
		}
	}
	/*s*/


	//Press Enter key using Robort Class
	public  void pressEnter()
	{
		logReport("INFO", "Pressing ENTER");
		try{
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		}
		catch(Exception e)
		{
			logReport("WARNING", "Could not Press ENTER");
			e.printStackTrace();
		}
	}

	//Save the file using Robort Class
	//Handeling download popup using Robort Class
	public  void selectSaveOnPopUp()
	{
		logReport("INFO","Pressing ALT+S");
		try{
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_ALT);
			r.keyPress(KeyEvent.VK_S);
			r.keyRelease(KeyEvent.VK_ALT);
			logReport("PASS","Saved the document");
		}
		catch(Exception e)
		{
			logReport("WARNING","Could not Select Save");
			e.printStackTrace();
		}
	}

	//Wait untill Duration in seconds
	public static  void waitTill(String durationInSecond)
	{
		try{
			long n=(long)Double.parseDouble(durationInSecond);
			Thread.sleep(n*1000);
		}
		catch(Exception e)
		{
			logReport("WARNING","Could not Wait");
			e.printStackTrace();
		}
	}

	//Mouse over on the element
	public  void hover(WebElement element)
	{
		logReport("INFO","Moving mouse on the element");
		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public  void verifyBooleanStatus(String avalue, String evalue)
	{
		if(avalue.equalsIgnoreCase(evalue))
		{	
			logReport("PASS","Verified using getText: Actual :"+avalue+" Expected :"+evalue);
		}
		else
		{
			logReport("FAIL","Actual text "+avalue+" DO NOT contains Expected text "+evalue);
			Assert.fail();
		}
	}

	public void verifyMessageContains(String avalue,String evalue)
	{
		System.out.println(avalue+"  "+evalue);
		if(evalue.contains(avalue))
		{	
			logReport("PASS","Verified using getText; Actual text contains Expected text");
		}
		else
		{
			logReport("FAIL","Actual text DO NOT contains Expected text");
		}
	}
	
	public void verifyMessageNotContains(String avalue, String evalue) {
		System.out.println("avalue:"+avalue);
		System.out.println("evalue:"+evalue);
		if (!(evalue.contains(avalue))) {
			logReport("PASS", "Verified using getText; Actual text DO NOT contain Expected text");
		} else {
			logReport("FAIL", "Actual text contains Expected text");
		}
	}

	public void verifyIsDisplayed(WebElement element,String Label)
	{
		if(element.isDisplayed())
		{	
			logReport("PASS",Label+" is Displayed");
		}
		else
		{
			logReport("FAIL",Label+" is not Displayed");
		}
	}

	public void verifyIsNotDisplayed(WebElement element,String Label)
	{

		try
		{
			if(element.isDisplayed())
			{	
				logReport("Fail",Label+" Should Not  be Displayed");
			}

		}
		catch (NoSuchElementException e) {
			logReport("Pass",Label+" is not Displayed");
		}
	}

	//VerifyMobileTextContains
	public  void verifyMobileTextContains(WebElement element,String eText)
	{


		String text_getText=element.getText();
		if(text_getText.contains(eText))
		{	
			logReport("PASS","Verified using Text "+ text_getText +" contains "+ eText);
		}
		else
		{
			logReport("FAIL","Actual text"+text_getText+" DO NOT contains Expected text "+eText);
		}
	}

	//Verify the Text Contains
	public  boolean verifyTextContains(WebElement element,String eText)
	{
		String text_getText=element.getText();
		String text_innerHTML=element.getAttribute("innerHTML");
		String text_title=element.getAttribute("title");
		String text_textContent=element.getAttribute("textContent");
		//logReport("INFO","Expected text is:"+eText);
		//logReport("INFO", "getText:"+text_getText);
		scrollByViewOfElement(element);
		Utility.highlightElement(driver,element);
		boolean status = true;

		//logReport("INFO","innerHTML:"+text_innerHTML);
		//logReport("INFO", "textContent:"+text_textContent);
		if(text_getText.contains(eText))
		{	
			logReport("PASS","Verified using Text "+ text_getText +" contains "+ eText);
		}
		else if(text_innerHTML.contains(eText))
		{	
			logReport("PASS","Verified using innerHTML" + text_getText +" contains "+ eText);
		}
		else if(text_textContent.contains(eText))
		{	
			logReport("PASS","Verified using textContent "+text_getText+" contains "+eText);
		} else if(text_title.contains(eText)) {
			logReport("PASS","Verified using textContent "+text_getText+" contains "+eText);
		}
		else
		{
			logReport("FAIL","Actual text "+text_getText+" DO NOT contains Expected text "+eText);
			status = false;
		}

		return status;
	}

	//Verify the Element Colour
	public  void verifyElementColor(WebElement element,String eHexColor)
	{

		String strRGB=element.getCssValue("color");
		logReport("INFO","RGB is:"+strRGB);
		String hex=Utility.convertRGBtoHex(strRGB);

		String msg1="<span style='color:"+eHexColor+";'>Expected color</span>";
		logReport("INFO","HTML colour "+msg1);

		String msg2="<span style='color:"+hex+";'>Actual color</span>";
		logReport("INFO","HTML colour "+msg2);

		if(hex.equals(eHexColor))
		{
			logReport("PASS","Element color is matching");
		}
		else
		{
			logReport("FAIL","Element color is not matching");
		}
	}

	//Handeling file upload popup
	public  void selectFileToUpload(WebElement element,String filePath)
	{
		String absoluteFilePath=new File(filePath).getAbsolutePath();
		logReport("INFO","absoluteFilePath:"+absoluteFilePath);
		element.sendKeys(absoluteFilePath);
	}

	//Enter a value into Field
	public String enter(String fieldLable, WebElement element,String input)
	{
		clear(fieldLable, element);
		waitTill("5");
		//scrollByViewOfElement(element);
		element.sendKeys(input);
		logReport("PASS", fieldLable+" entered ");
		return input;
	}

	public String enterTextToMobile(String fieldLable, WebElement element,String input)
	{

		element.sendKeys(input);
		logReport("PASS", fieldLable+" entered ");
		return input;
	}
	public  void clear(String fieldLable, WebElement element)
	{
		element.clear();
		//logReport("PASS", fieldLable+" cleared ");
	}

	public  void Jsclick(String fieldLable, WebElement element){
		try
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();",element);
		}
		catch (Exception e) {
			waitForElement(element, fieldLable);
			element.click();										
		}
		logReport("PASS", "Click on "+fieldLable);
	}

	//Click on Element
	public  void click(String fieldLable, WebElement element){
		try
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();",element);
			waitTill("2");

		}
		catch (Exception e) {
			waitForElement(element,fieldLable );
			element.click();
		}
		logReport("PASS", "Click on "+fieldLable);
	}

	public  void doubleClick(String fieldLable, WebElement element){
		try
		{
			waitForElement(element,fieldLable );
			Actions act = new Actions(driver);
			act.doubleClick(element).perform();
			logReport("PASS", "Click on "+fieldLable);
		}
		catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();",element);
			logReport("PASS", "Click on "+fieldLable);

		}

	}

	/*	public void tap(String fieldLabel,WebElement element)
	{
		try
		{
			TouchAction action=new TouchAction((AndroidDriver<AndroidElement>)driver);
			action.tap(tapOptions().withElement(element(element))).perform();
			logReport("PASS", "Tap on "+fieldLabel);
		}catch (Exception e) {
			logReport("Fail To", "Tap on "+fieldLabel);
		}

	}*/

	/*public void tapwithCoordinates(int x,int y)
	{
		TouchAction touchAction = new TouchAction((AndroidDriver<AndroidElement>)driver);
		touchAction.tap(new PointOption().withCoordinates(x, y)).perform();
	}*/

	//Select lookup Value
	public void selectLookupValue(String fieldName, WebElement element, String lookupValue) throws InterruptedException
	{
		String basePage = driver.getWindowHandle();
		element.click();
		Thread.sleep(5000);
		Set<String> handles = driver.getWindowHandles(); // get all window handles
		for(String s : handles)
		{
			String windowHandle = s;
			driver.switchTo().window(windowHandle);
			if(driver.getTitle().contains("Search "));
			break;
		}

		WebElement searchFrameName = driver.findElement(By.id("searchFrame"));
		WebElement resultsFrameName = driver.findElement(By.id("resultsFrame"));
		driver.switchTo().frame(searchFrameName);
		driver.findElement(By.xpath("//input[@id='lksrch']")).sendKeys(lookupValue);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(resultsFrameName);
		String locater = "//a[contains(text(),'"+lookupValue+"')]";
		WebElement searchElement = driver.findElement(By.xpath(locater));
		if(searchElement.isDisplayed())
		{
			searchElement.click();
			logReport("PASS", " Selected Lookup Value "+lookupValue);
			driver.switchTo().defaultContent();
		}
		else
		{
			logReport("FAIL", " No Matching Lookup Value "+lookupValue);
		}


		/*Iterator<String> iterator = handles.iterator();
	    while (iterator.hasNext())
	    {
	    	driver.switchTo().window(iterator.next());
	        if(driver.getTitle().contains("Search "))
	        {
	        	driver.switchTo().window(iterator.next());
	        }
	        	WebElement searchFrameName = driver.findElement(By.id("searchFrame"));
	        	WebElement resultsFrameName = driver.findElement(By.id("resultsFrame"));
	        	driver.switchTo().frame(searchFrameName);
	        	driver.findElement(By.xpath("//input[@id='lksrch']")).sendKeys(lookupValue);
	        	driver.findElement(By.xpath("//input[@type='submit']")).click();
	        	driver.switchTo().defaultContent();
	        	driver.switchTo().frame(resultsFrameName);
	        	String locater = "//a[contains(text(),'"+lookupValue+"')]";
	        	WebElement searchElement = driver.findElement(By.xpath(locater));
	        	if(searchElement.isDisplayed())
	        	{
	        		searchElement.click();
	        		logReport("PASS", " Selected Lookup Value "+lookupValue);
	        		driver.switchTo().defaultContent();
	        	}
	        	else
	        	{
	        		logReport("FAIL", " No Matching Lookup Value "+lookupValue);
	        	}
	        	break;
	        }
		 */	    driver.switchTo().window(basePage);
	}

	//Verify Element Present
	public boolean verifyElementPresent(String fieldLable, WebElement element){
		boolean elementPresent=false;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		try{
			elementPresent=element.isDisplayed();
			if(elementPresent)
			{
				Utility.highlightElement(driver,element);
				logReport("PASS", fieldLable+" is present and Displayed");
				elementPresent = true;
			}
			else
			{
				logReport("ERROR", fieldLable+" is Not Present or Not Displayed");
			}
		}
		catch(Exception e)
		{
			logReport("ERROR","Element is Not Present or Not Displayed");
			//Assert.fail();
		}
		return elementPresent;

	}

	public boolean verifyElementPresentOnPage(String fieldLable, WebElement element){
		boolean elementPresent=false;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		try{
			elementPresent=element.isDisplayed();
			if(elementPresent)
			{
				Utility.highlightElement(driver,element);
				logReport("PASS", fieldLable+" is present and Displayed");
				elementPresent = true;
			}
			else
			{
				logReport("ERROR", fieldLable+" is Not Present or Not Displayed");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			logReport("ERROR",fieldLable+ "is Not Present or Not Displayed");
			Assert.fail();
		}
		return elementPresent;

	}

	public String getID()
	{
		String url=driver.getCurrentUrl();
		String id=url.substring(27);
		return id;
	}

	//Verify Element Not Present
	public  boolean verifyElementNotPresent(String label,WebElement element){
		boolean elementPresent=false;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		try{
			//int j = element.getSize();
			
			
			elementPresent=element.isDisplayed();
			if(elementPresent)
			{
				Utility.highlightElement(driver,element);
				logReport("FAIL",label+" Element is Present and Displayed");
				Assert.fail();
			}
			else
			{
				elementPresent = true;
				logReport("PASS",label+" Element is Not Present or Not Displayed");
			}
		}
		catch(Exception e)
		{
			logReport("PASS","Element is Not Present or Not Displayed-Catch");
		}
		System.out.println("elementPresent:"+elementPresent);
		return elementPresent;
	}

	//Wait till new page loads after navigation
	public void waitTill_NewPage_LoadsTitle(WebDriver driver, String expectedPage)
	{
		WebDriverWait wait = new WebDriverWait(driver,90);
		if(expectedPage.equalsIgnoreCase("Home"))
		{
			wait.until(ExpectedConditions.titleContains("Salesforce -"));
			logReport("PASS","Accessed Home Page");
		}

		if(expectedPage.equalsIgnoreCase("Campaigns"))
		{
			wait.until(ExpectedConditions.titleContains("Campaigns: Home ~ Salesforce -"));
			logReport("PASS","Accessed Campaigns Module");
		}
		if(expectedPage.equalsIgnoreCase("Leads"))
		{
			wait.until(ExpectedConditions.titleContains("Leads: Home ~ Salesforce -"));
			logReport("PASS","Accessed Leads Module");
		}
		if(expectedPage.equalsIgnoreCase("Accounts"))
		{
			wait.until(ExpectedConditions.titleContains("Accounts: Home ~ Salesforce -"));
			logReport("PASS","Accessed Accounts Module");
		}

		if(expectedPage.equalsIgnoreCase("Contacts"))
		{	
			wait.until(ExpectedConditions.titleContains("Contacts: Home ~ Salesforce -"));
			logReport("PASS","Accessed Contacts Module");
		}

		if(expectedPage.equalsIgnoreCase("Cases"))
		{	
			wait.until(ExpectedConditions.titleContains("Defect Management: Home ~ Salesforce -"));
			logReport("PASS","Accessed Defect Management Module");
		}

		if(expectedPage.equalsIgnoreCase("Opportunities"))
		{
			wait.until(ExpectedConditions.titleContains("Opportunities: Home ~ Salesforce -"));
			logReport("PASS","Accessed Opportunities Module");
		}

		if(expectedPage.equalsIgnoreCase("Dashboard"))
		{
			wait.until(ExpectedConditions.titleContains("Dashboard: Marketing Dashboard ~ Salesforce -"));
			logReport("PASS","Accessed Dashboard Module");
		}
	}

	public static void logReport(String status, String message)
	{	
		Reporter.addStepLog(Utility.getFormatedDateTime()+message);
		log.info(Utility.getFormatedDateTime()+" : "+message);
	}

	public WebElement waitForElement(WebElement element, String name)
	{

		try {


			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.isDisplayed();
			logReport("INFO","Waited for "+name);



		} catch (Exception e) {
			logReport("INFO","Exception in waitForElement::"+name);

		}

		//logReport("INFO","AfterWaitForElement::"+name);
		return element;
	}

	public void waitAndswitchToFrame(String title)
	{
		//driver.switchTo().defaultContent();
		try {
			WebDriverWait wait = new WebDriverWait(driver,80);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@title='"+title+"']")));
			logReport("INFO","Switched to frame");
		} catch (Exception e) {
			logReport("INFO","Unable to switch to Frame");

		}

		//logReport("INFO","AfterWaitForElement::"+name);
	}

	public void waitAndswitchToFrame(WebElement frame)
	{
		//driver.switchTo().defaultContent();
		try {
			WebDriverWait wait = new WebDriverWait(driver,80);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
			logReport("INFO","Switched to frame");

		} catch (Exception e) {
			logReport("INFO","Unable to switch to Frame");

		}

		//logReport("INFO","AfterWaitForElement::"+name);
	}

	public void waitAndswitchToRequiredFrame(WebElement frame)
	{
		//driver.switchTo().defaultContent();
		try {
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
			logReport("INFO","Switched to frame");

		} catch (Exception e) {
			logReport("INFO","Unable to switch to Frame");

		}

		//logReport("INFO","AfterWaitForElement::"+name);
	}

	public void switchToTab(int tabsize) 
	{
		waitToLodadTab(tabsize);
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		System.out.println("tabs Size"+ tabs.size());
		waitTill("5");
		driver.switchTo().window(tabs.get(tabsize));
		logReport("INFO", "Switched to Tab");
		waitTill("5");
	}

	public void closeAllTabs() //closes all tabs excepts current tab 
	{
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		for(int i=0;i<tabs.size()-1;i++) {
			driver.switchTo().window(tabs.get(i));
			driver.close();
		}
		driver.switchTo().window(tabs.get(tabs.size()-1));

	}

	public void waitToLodadTab(int tabsize) {
		int count=0;
		while(count<5) {
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			if(tabs.size()>tabsize) {
				break;
			} else {
				waitTill("5");
				count++;
			}
		}

	}

	public void waitForElementToEnable(WebElement element)
	{

		try {


			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.isEnabled();
			logReport("INFO","Waited for Element TO enable");



		} catch (Exception e) {
			logReport("INFO","Exception in waitForElement::");

		}
	}



	public boolean mobileFrames(WebElement element)
	{

		int size = driver.findElements(By.className("android.widget.FrameLayout")).size();
		for(int i=0; i<=size; i++)
		{
			driver.switchTo().frame(i);
			try
			{
				element.click();
			}
			catch (Exception e) {
				driver.switchTo().defaultContent();
			}
		}
		return false;
	}


	public WebElement frames(WebElement element)
	{
		int size = driver.findElements(By.tagName("iframe")).size();

		for(int i=0; i<=size; i++){
			driver.switchTo().frame(i);
			try
			{
				if(element.isDisplayed())
				{
					return element;

				}
			}
			catch (Exception e) {
				// TODO: handle exception
			}


		}
		driver.switchTo().defaultContent();
		return null;
	}

	public String selectRandomValue(WebElement element, String elementName) 
	{
		String selectedvalue = "";
		waitForElement(element, elementName);
		if(element.isEnabled())
		{
			Select dropDown = new Select(element);
			List<WebElement> dropDownValues = dropDown.getOptions();
			int activitySize = dropDownValues.size();
			if(dropDownValues.size()==1)
			{
				logReport("FAIL", "Drop down doesnot contain values");
			}
			else
			{
				Random rand = new Random();
				int actName = rand.nextInt(activitySize);
				if (actName == 0) actName = 1;
				selectedvalue = dropDownValues.get(actName).getText();

				dropDown.selectByVisibleText(selectedvalue);
				logReport("PASS","Selected value is : "+selectedvalue);
				return selectedvalue;
			}
		}
		return selectedvalue;
	}

	public String selectbyValue(WebElement element, String value, String elementName) 
	{

		waitForElement(element, elementName);
		if(element.isEnabled())
		{
			Select dropDown = new Select(element);
			dropDown.selectByVisibleText(value);
			logReport("PASS","Selected value is : "+value);
			return value;
		}
		return value;
	}

	public void switchtoframe(List<WebElement> frames,WebElement element) 
	{
		for(int i=0; i<frames.size(); i++)
		{
			driver.switchTo().defaultContent();
			try
			{
				driver.switchTo().frame(i);
				element.isDisplayed();
				logReport("Info","Switched to frame");
				break;
			}
			catch(Exception e)
			{

			}
		}
	}
	public String getSelectedValue(WebElement element)
	{
		Select select = new Select(element);
		WebElement option = select.getFirstSelectedOption();
		String SelectedText = option.getText();
		return SelectedText;
	}

	public String selectRandomValueFromNonselectMenu(List<WebElement> elements)
	{
		while(true)
		{
			int number=Utility.randomNumber(elements.size());
			if(elements.get(number).getText().contains("--None--"))
			{
				continue;
			}
			else
			{
				WebElement e=elements.get(number);
				elements.get(number).click();

				logReport("Pass","Selected values is"+e.getText());
				return e.getText();

			}
		}
	}

	public String currentDateValue(String dateFormat) {
		Date dnow=new Date();
		SimpleDateFormat requiredFormat=new SimpleDateFormat(dateFormat);
		String actualDate=requiredFormat.format(dnow);
		return actualDate;
	}



	public String endDatevalue(String format,int numOfDays,int numOfMonth,int numOfYear ) {
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		cal.add(Calendar.YEAR,numOfYear); // to get previous year add -1
		cal.add(Calendar.MONTH, numOfMonth);
		cal.add(Calendar.DAY_OF_YEAR, numOfDays);
		Date nextYear = cal.getTime();
		SimpleDateFormat ft=new SimpleDateFormat(format);
		String dd=ft.format(nextYear);
		System.out.println(dd);
		return dd;
	}

	public void waitSpinnerToDisappear()
	{

		By element = By.xpath("//div[@class='spinner-location']");
		int attempt = 0;

		while(attempt<3) {

			long start=System.currentTimeMillis();
			try {
				Wait wait = new FluentWait(driver)

						.withTimeout(5,TimeUnit.SECONDS)

						.pollingEvery(1, TimeUnit.SECONDS)

						.ignoring(Exception.class)
						.ignoring(StaleElementReferenceException.class);


				wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
				break;
			} catch (Exception e) {
				logReport("INFO", "Spinner is disappeared");
			}
			attempt++;
			long end=System.currentTimeMillis();
			long duration=end-start;
			duration=duration/1000;
			logReport("INFO", "duration of spinner = "+duration+"secs");
		}

	}

	public void waitDottedSpinnerToDisappear()
	{
		By element = By.xpath("//div[@ng-show='grid.isServerActionInProgress()']");
		int attempt = 0;

		while(attempt<3) {

			long start=System.currentTimeMillis();
			try {
				Wait wait = new FluentWait(driver)

						.withTimeout(5,TimeUnit.SECONDS)

						.pollingEvery(1, TimeUnit.SECONDS)

						.ignoring(Exception.class)
						.ignoring(StaleElementReferenceException.class);


				wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
				break;
			} catch (Exception e) {
				logReport("INFO", "Spinner is disappeared");
			}
			attempt++;
			long end=System.currentTimeMillis();
			long duration=end-start;
			duration=duration/1000;
			logReport("INFO", "duration of spinner = "+duration+"secs");
		}

	}


	public void waitUntilElementisDisplayed(WebElement element)
	{

		int attempt = 0;
		while(attempt<2) {
			long start=System.currentTimeMillis();
			try {
				Wait wait = new FluentWait(driver)

						.withTimeout(20, TimeUnit.SECONDS)

						.pollingEvery(1, TimeUnit.SECONDS)

						.ignoring(StaleElementReferenceException.class).ignoring(WebDriverException.class);
				wait.until(ExpectedConditions.visibilityOf(element));
			} catch (Exception e) {

			}
			attempt++;
			long end=System.currentTimeMillis();
			long duration=end-start;
			duration=duration/1000;
			logReport("INFO", "Waiting for = "+duration+"secs");
		}

	}

	public void waitElementToDisappear(WebElement element)
	{

		int attempt = 0;

		while(attempt<3) {

			long start=System.currentTimeMillis();
			try {
				Wait wait = new FluentWait(driver)

						.withTimeout(5,TimeUnit.SECONDS)

						.pollingEvery(1, TimeUnit.SECONDS)

						.ignoring(Exception.class)
						.ignoring(StaleElementReferenceException.class);


				wait.until(ExpectedConditions.invisibilityOf(element));
				logReport("INFO", "Element is disappeared");
				break;
			} catch (Exception e) {
			}
			attempt++;
			long end=System.currentTimeMillis();
			long duration=end-start;
			duration=duration/1000;
		}

	}





	public void waitforAlert()
	{
		for(int i=0; i<5; i++)
		{
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 2);
				wait.until(ExpectedConditions.alertIsPresent());
				break;
			}
			catch(Exception e)
			{
				System.out.println("Alert not present in iteration "+i);
			}
		}
	}

	public String getAlertMessage()
	{
		waitforAlert();
		Alert alert = driver.switchTo().alert();
		// Get the text of the alert or prompt
		String msg=alert.getText().trim();  
		System.out.println(msg);
		alert.accept();
		return msg;
	}
	public void scrollByViewOfElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void scrollByCordinates(int x,int y) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy("+x+","+y+")");
	}

	public void HybrisenterCredentials(String user, WebDriver driver) {
		driver.manage().deleteAllCookies();
		switch (user) {
		case "HybrisAgent User":
			loggedinUserName = EnvironmentFactory.getConfigValue("HybrisAgent User");
			UserName = EnvironmentFactory.getConfigValue("HybrisAgentUserID");
			password = Utility.decode(EnvironmentFactory.getConfigValue("HybrisAgentUserPassword"));
			break;
		}
		}

	//Method used to login to the application
	public void enterCredentials(String userRole, WebDriver driver) {
		driver.manage().deleteAllCookies();
		driver.get(AutomationConstants.URL);
		switch (userRole) {
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
			password = EnvironmentFactory.getConfigValue("ServiceAgentPassword");
			//password = Utility.decode(EnvironmentFactory.getConfigValue("ServiceAgentPassword"));
			break;
		case "ResourcePlanner":
			loggedinUserName = EnvironmentFactory.getConfigValue("ResourcePlannerUser");
			UserName = EnvironmentFactory.getConfigValue("PlannerUsername");
			password = EnvironmentFactory.getConfigValue("PlannerPassword");
			break;	
		case "OneEmsAgent":
			loggedinUserName = EnvironmentFactory.getConfigValue("OneEmsUser");
			UserName = EnvironmentFactory.getConfigValue("OneEmsUsername");
			password = EnvironmentFactory.getConfigValue("OneEmsPassword");
			break;
		case "AgentUser":
			loggedinUserName = EnvironmentFactory.getConfigValue("Agent User");
			UserName = EnvironmentFactory.getConfigValue("AgentUserID");
			password = Utility.decode(EnvironmentFactory.getConfigValue("AgentUserPassword"));
			break;
		case "AgentNonEvent":
			loggedinUserName = EnvironmentFactory.getConfigValue("Agent Non Event");
			UserName = EnvironmentFactory.getConfigValue("AgentNonEventID");
			password = Utility.decode(EnvironmentFactory.getConfigValue("AgentNonEventPassword"));
			break;
		case "CSPServiceAgent":
			loggedinUserName = EnvironmentFactory.getConfigValue("CSP ServiceAgent User");
			UserName = EnvironmentFactory.getConfigValue("CSPServiceAgent");
			password = Utility.decode(EnvironmentFactory.getConfigValue("CSPServiceAgentPassword"));
			break;
		case "ServiceTechnician":
			loggedinUserName = EnvironmentFactory.getConfigValue("ServiceTechnician User");
			UserName = EnvironmentFactory.getConfigValue("ServiceTechnician");
			password = Utility.decode(EnvironmentFactory.getConfigValue("ServiceTechnicianPassword"));
			break;

		case "CustomAgent":
			loggedinUserName = EnvironmentFactory.getConfigValue("Custom Agent User");
			UserName = EnvironmentFactory.getConfigValue("CustomAgent");
			password = EnvironmentFactory.getConfigValue("CustomAgentPassword");
			break;
		case "CustomRSE":
			loggedinUserName = EnvironmentFactory.getConfigValue("Custom RSE User");
			UserName = EnvironmentFactory.getConfigValue("CustomRSE");
			password = EnvironmentFactory.getConfigValue("CustomRSEPassword");
			break;
			
		case "CustomRSEL1":
			loggedinUserName = EnvironmentFactory.getConfigValue("Custom RSE L1");
			UserName = EnvironmentFactory.getConfigValue("CustomRSEL1");
			password = Utility.decode(EnvironmentFactory.getConfigValue("CustomRSEPasswordL1"));
			break;
			
		case "CustomRSEL2":
			loggedinUserName = EnvironmentFactory.getConfigValue("Custom RSE L2");
			UserName = EnvironmentFactory.getConfigValue("CustomRSEL2");
			password = Utility.decode(EnvironmentFactory.getConfigValue("CustomRSEPasswordL2"));
			break;
			
		case "CustomRSEL3":
			loggedinUserName = EnvironmentFactory.getConfigValue("Custom RSE L3");
			UserName = EnvironmentFactory.getConfigValue("CustomRSEL3");
			password = Utility.decode(EnvironmentFactory.getConfigValue("CustomRSEPasswordL3"));
			break;
			
		case "CustomHISSGen":
			loggedinUserName = EnvironmentFactory.getConfigValue("Custom HISS Gen");
			UserName = EnvironmentFactory.getConfigValue("CustomHIss");
			password = Utility.decode(EnvironmentFactory.getConfigValue("CustomHISSPassword"));
			break;
			
		case "CustomHISSL1":
			loggedinUserName = EnvironmentFactory.getConfigValue("Custom HISS L1");
			UserName = EnvironmentFactory.getConfigValue("CustomHISSL1");
			password = Utility.decode(EnvironmentFactory.getConfigValue("CustomHISSPasswordL1"));
			break;
			
		case "CustomHISSL2":
			loggedinUserName = EnvironmentFactory.getConfigValue("Custom HISS L2");
			UserName = EnvironmentFactory.getConfigValue("CustomHISSL2");
			password = Utility.decode(EnvironmentFactory.getConfigValue("CustomHISSPasswordL2"));
			break;
			
		case "CustomHISSL3":
			loggedinUserName = EnvironmentFactory.getConfigValue("Custom HISS L3");
			UserName = EnvironmentFactory.getConfigValue("CustomHISSL3");
			password = Utility.decode(EnvironmentFactory.getConfigValue("CustomHISSPasswordL3"));
			break;
        case "Meena1serviceuser":
            //loggedinUserName = EnvironmentFactory.getConfigValue("Automation ServiceTechnician");
            UserName = EnvironmentFactory.getConfigValue("Meena1serviceuser");
            password = Utility.decode(EnvironmentFactory.getConfigValue("Meena1Servicepwd"));
            break;
         
        case "BGPersonneluser":
            //loggedinUserName = EnvironmentFactory.getConfigValue("Automation ServiceTechnician");
            UserName = EnvironmentFactory.getConfigValue("BGPersonneluser");
            password = Utility.decode(EnvironmentFactory.getConfigValue("BGPersonnelPwd"));
            break;

        case "EIMUser":
			loggedinUserName = EnvironmentFactory.getConfigValue("EIM User");
			UserName = EnvironmentFactory.getConfigValue("EIMUserID");
			password = Utility.decode(EnvironmentFactory.getConfigValue("EIMUserPassword"));
			break;
			
		case "EIMHR":
			loggedinUserName = EnvironmentFactory.getConfigValue("EIM HR");
			UserName = EnvironmentFactory.getConfigValue("EIMHRID");
			password = Utility.decode(EnvironmentFactory.getConfigValue("EIMHRPassword"));
			break;
			
		case "EIMCustomer":
			loggedinUserName = EnvironmentFactory.getConfigValue("EIM Customer");
			UserName = EnvironmentFactory.getConfigValue("EIMCustomerID");
			password = Utility.decode(EnvironmentFactory.getConfigValue("EIMCustomerPassword"));
			break;
			
		case "EIMVendor":
			loggedinUserName = EnvironmentFactory.getConfigValue("EIM Vendor");
			UserName = EnvironmentFactory.getConfigValue("EIMVendorID");
			password = Utility.decode(EnvironmentFactory.getConfigValue("EIMVendorPassword"));
			break;
			
		case "BGFCO":
			loggedinUserName = EnvironmentFactory.getConfigValue("BG FCO");
			UserName = EnvironmentFactory.getConfigValue("BGFCOID");
			password = Utility.decode(EnvironmentFactory.getConfigValue("BGFCOPassword"));
			break;
			
		case "Distributor user":
			loggedinUserName = EnvironmentFactory.getConfigValue("Distributor user");
			UserName = EnvironmentFactory.getConfigValue("DistributorUserID");
			password = Utility.decode(EnvironmentFactory.getConfigValue("DistributorUserPassword"));
			break;
	
		case "L1 Technician":
			loggedinUserName = EnvironmentFactory.getConfigValue("L1 Technician User");
			UserName = EnvironmentFactory.getConfigValue("L1Technician");
			password = Utility.decode(EnvironmentFactory.getConfigValue("L1TechnicianPassword"));
			break;
			
		case "L2 Technician":
			loggedinUserName = EnvironmentFactory.getConfigValue("L2Technician User");
			UserName = EnvironmentFactory.getConfigValue("L2Technician");
			password = Utility.decode(EnvironmentFactory.getConfigValue("L2TechnicianPassword"));
			break;
			
		case "ServiceTechnician2":
			loggedinUserName = EnvironmentFactory.getConfigValue("ServiceTechnicianUser2");
			UserName = EnvironmentFactory.getConfigValue("ServiceTechnician2");
			password = Utility.decode(EnvironmentFactory.getConfigValue("ServiceTechnicianPassword2"));
			break;
			
		case "R2Rautomationtech": //loggedinUserName =
			EnvironmentFactory.getConfigValue("Automation ServiceTechnician"); 
			UserName =EnvironmentFactory.getConfigValue("R2RuserName");
			password =Utility.decode(EnvironmentFactory.getConfigValue("R2Rpassword"));
			break;
			
		case "ServiceFCOAdmin":
			loggedinUserName = EnvironmentFactory.getConfigValue("ServiceFCOAdmin User");
			UserName = EnvironmentFactory.getConfigValue("ServiceFCOAdmin");
			password = Utility.decode(EnvironmentFactory.getConfigValue("ServiceFCOAdminPassword"));
			break;

		case "ServiceFCOAdmin2":
			loggedinUserName = EnvironmentFactory.getConfigValue("ServiceFCOAdmin User");
			UserName = EnvironmentFactory.getConfigValue("ServiceFCOAdmin2");
			password = Utility.decode(EnvironmentFactory.getConfigValue("ServiceFCOAdmin2Password"));
			break;
			
		case "ServiceAgent User":
			//loggedinUserName = EnvironmentFactory.getConfigValue("Automation ServiceTechnician");
			UserName = EnvironmentFactory.getConfigValue("ServiceAgent");
			password = Utility.decode(EnvironmentFactory.getConfigValue("ServiceAgentPassword"));
			break;
			
		case "ServiceAgentNew User":
			//loggedinUserName = EnvironmentFactory.getConfigValue("Automation ServiceTechnician");
			UserName = EnvironmentFactory.getConfigValue("serviceAgentUser");
			password = Utility.decode(EnvironmentFactory.getConfigValue("ServiceAgentPassword"));
			break;
			
		case "ServiceManager User":
			//loggedinUserName = EnvironmentFactory.getConfigValue("Automation ServiceTechnician");
			UserName = EnvironmentFactory.getConfigValue("serviceManager");
			password = Utility.decode(EnvironmentFactory.getConfigValue("ServiceManagerpassword"));
			break;
			
		case "SM1 User":
			//loggedinUserName = EnvironmentFactory.getConfigValue("Automation ServiceTechnician");
			UserName = EnvironmentFactory.getConfigValue("SM1User");
			password = Utility.decode(EnvironmentFactory.getConfigValue("SM1password"));
			break;
			
		case "Skserviceuser":
			//loggedinUserName = EnvironmentFactory.getConfigValue("Automation ServiceTechnician");
			UserName = EnvironmentFactory.getConfigValue("Skserviceuser");
			password = Utility.decode(EnvironmentFactory.getConfigValue("SKpassword"));
			break;
			
		case "Sweetyserviceuser":
			//loggedinUserName = EnvironmentFactory.getConfigValue("Automation ServiceTechnician");
			UserName = EnvironmentFactory.getConfigValue("Sweetyserviceuser");
			password = Utility.decode(EnvironmentFactory.getConfigValue("Sweetypassword"));
			break;
			
		case "Meenaserviceuser":
			//loggedinUserName = EnvironmentFactory.getConfigValue("Automation ServiceTechnician");
			UserName = EnvironmentFactory.getConfigValue("Meenaserviceuser");
			password = Utility.decode(EnvironmentFactory.getConfigValue("MeenaServicepwd"));
			break;
			
		case "R2Rautomationtech1":
			//loggedinUserName = EnvironmentFactory.getConfigValue("Automation ServiceTechnician");
			UserName = EnvironmentFactory.getConfigValue("R2RAgentuserName");
			password = Utility.decode(EnvironmentFactory.getConfigValue("R2RAgentpassword"));
			break;

		case "SeeTestUser1":
			UserName = EnvironmentFactory.getSeeTestConfig("SeeTestUser1");
			password = Utility.decode(EnvironmentFactory.getSeeTestConfig("SeeTestUser1Password"));
			driver.get(AutomationConstants.SeeTestURL);
			break;

		case "Quote Admin":
			loggedinUserName = EnvironmentFactory.getConfigValue("Quote Admin");
			UserName = EnvironmentFactory.getConfigValue("QuoteAdmin");
			password = EnvironmentFactory.getConfigValue("QuoteAdminPwd");
			break;
		case "ServiceAgentNew":
			loggedinUserName = EnvironmentFactory.getConfigValue("ServiceAgentNew User");
			UserName = EnvironmentFactory.getConfigValue("ServiceAgentNew");
			password = Utility.decode(EnvironmentFactory.getConfigValue("ServiceAgentNewPassword"));
			break;
		case "SuperServiceTechnician":
			loggedinUserName = EnvironmentFactory.getConfigValue("SuperServiceTechnician User");
			UserName = EnvironmentFactory.getConfigValue("SuperServiceTechnician");
			password = Utility.decode(EnvironmentFactory.getConfigValue("SuperServiceTechnicianPassword"));
			break;
		case "L1Technician":
			loggedinUserName = EnvironmentFactory.getConfigValue("L1Technician User");
			UserName = EnvironmentFactory.getConfigValue("L1Technician");
			password = Utility.decode(EnvironmentFactory.getConfigValue("L1TechnicianPassword"));
			break;
		case "ServiceTechnician User":
			loggedinUserName = EnvironmentFactory.getConfigValue("Automation ServiceTechnician");
			UserName = EnvironmentFactory.getConfigValue("ServiceTechnician");
			password = Utility.decode(EnvironmentFactory.getConfigValue("ServiceTechnicianPassword"));
			break;

		case "ServiceTechnician1 User":
			//loggedinUserName = EnvironmentFactory.getConfigValue("Automation ServiceTechnician");
			UserName = EnvironmentFactory.getConfigValue("ServiceTechnician1");
			password = Utility.decode(EnvironmentFactory.getConfigValue("ServiceTechnicianPassword"));
			break;
		case "Quote Admin User":
			//loggedinUserName = EnvironmentFactory.getConfigValue("Automation ServiceTechnician");
			UserName = EnvironmentFactory.getConfigValue("QuoteAdminUser");
			password = Utility.decode(EnvironmentFactory.getConfigValue("QuoteAdminUserPassword"));
			break;
			
		case "AutomationAgentUser":
			loggedinUserName = EnvironmentFactory.getConfigValue("Automation Agent User");
			UserName = EnvironmentFactory.getConfigValue("automationagentuserID");
			password = Utility.decode(EnvironmentFactory.getConfigValue("automationagentuserPWD"));
			break;
			
		case "AutomationTechnicianUser":
			loggedinUserName = EnvironmentFactory.getConfigValue("Automation Technician User");
			UserName = EnvironmentFactory.getConfigValue("AutomationTechnicianUserID");
			password = Utility.decode(EnvironmentFactory.getConfigValue("AutomationTechnicianUserPWD"));
			break;
			
		case "CSPortalUser":
			loggedinUserName = EnvironmentFactory.getConfigValue("Portal User");
			UserName = EnvironmentFactory.getConfigValue("PortalUser");
			password = Utility.decode(EnvironmentFactory.getConfigValue("PortalPassword"));
			driver.get(AutomationConstants.CS_PORTAL_URL);
			break;
		}
		try {
		WebElement USERNAME = driver.findElement(By.id("username"));
		WebElement PASSWORD = driver.findElement(By.id("password"));
		waitForElement(USERNAME, "UserName field");
		enter("User Name ", USERNAME, UserName);
		enter("Password ", PASSWORD, password);
		}catch(Exception e) {
			try {
			login_to_CSPortal(UserName,password);
			}catch(Exception e1) {}
		}
		waitTill("3");
		new BasePage(driver).embedScreenShotInreport();
		try {
			click("Login Button", driver.findElement(By.id("Login")));
		} catch (NoSuchElementException e) {
			try {
			click("Login Button", driver.findElement(By.name("login")));
			}catch(Exception e1) {}
		}
		try {
			WebElement alreadyLoogedIn = driver.findElement(By.xpath("//span[text()='You are already logged in!']"));
			waitForElement(alreadyLoogedIn, "User Already Logged In");
			driver.findElement(By.xpath("//input[@class='btn FlowFinishBtn']")).click();
		} catch (Exception e) {
		}
		
	}
	public void login_to_CSPortal(String UserName,String Password){
		waitTill("3");
		driver.findElement(By.xpath("//input[@id='CP_Login:theForm:username']")).sendKeys(UserName);
		waitTill("3");
		driver.findElement(By.xpath("//input[@id='CP_Login:theForm:password']")).sendKeys(Password);
		waitTill("3");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		waitTill("5");
	}

	/*public void enterAndroidMobileCredentials(String userRole, WebDriver driver) 
	{

		switch (userRole) 
		{
		case "InsideSales":
			loggedinUserName = EnvironmentFactory.getConfigValue("InsideSalesUserName");
			UserName = EnvironmentFactory.getConfigValue("InsideSalesUser");
			password = Utility.decode(EnvironmentFactory.getConfigValue("InsideSalesPassword"));
			break;
		}
		driver.findElement(By.id("com.salesforce.chatter:id/mi_accept")).click();
		driver.findElement(By.className("android.widget.ImageButton")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Change Server']")).click();
		driver.findElements(By.className("android.widget.RadioButton")).get(1).click();
		driver.findElement(MobileBy.AndroidUIAutomator("text(\"Apply\")")).click();
		driver.findElement(By.id("username")).sendKeys(UserName);
		waitTill("5");
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Login")).click();
		waitTill("5");
		driver.findElement(By.id("com.salesforce.chatter:id/sf__passcode_title")).sendKeys("1234\n");
		waitTill("5");
		driver.findElement(By.id("com.salesforce.chatter:id/sf__passcode_title")).sendKeys("1234\n");
		waitForacitvity(".screen.OnboardScreen");
		for(int i=0;i<4;i++)
		{
			horizontalSwipeByPercentage(0.6, 0.1, 0.1);
			waitTill("5");
		}
		driver.findElement(MobileBy.id("close-tour")).click();
		waitTill("5");


	}
	 */
	/*	public void horizontalSwipeByPercentage (double startPercentage, double endPercentage, double anchorPercentage) {
		Dimension size = driver.manage().window().getSize();
		System.out.println(size.toString());
		int anchor = (int) (size.height * anchorPercentage);
		System.out.println("Achor "+anchor);
		int startPoint = (int) (size.width * startPercentage);
		System.out.println("Start "+startPoint);
		int endPoint = (int) (size.width * endPercentage);
		System.out.println("End point "+endPoint);

		new TouchAction((PerformsTouchActions) driver)
		.press(point(startPoint, anchor))
		.waitAction(waitOptions(ofMillis(500)))
		.moveTo(point(endPoint, anchor))
		.release().perform();
	}*/

	/*public  void verticalSwipeBottomToTop() {



		Dimension size = driver.manage().window().getSize();

		int starty = (int) (size.height *0.60);

		int endy = (int) (size.height * 0.20);


		int startx = (int) (size.width/2);
		System.out.println("Start "+startx);



		new TouchAction((PerformsTouchActions) driver)
		.press(point(startx, starty))
		.waitAction(waitOptions(ofMillis(500)))
		.moveTo(point(startx, endy))
		.release().perform();

	}

	public void verticalSwipeTopToBottom()
	{
		Dimension size = driver.manage().window().getSize();
		System.out.println(size.toString());
		int starty = (int) (size.height *0.60);
		System.out.println("Achor "+starty);
		int endy = (int) (size.height * 0.20);
		System.out.println("End point "+endy);

		int startx = (int) (size.width/2);
		System.out.println("Start "+startx);



		new TouchAction((PerformsTouchActions) driver)
		.press(point(startx, endy))
		.waitAction(waitOptions(ofMillis(500)))
		.moveTo(point(startx, starty))
		.release().perform();

	}
	 */

	public void checkElementisDisplayed(WebElement element,String Label)
	{
		waitForElement(element, Label);
		if(element.isDisplayed())
		{
			logReport("PASS","Displayed element ::"+Label);
		}
		else
		{
			logReport("FAIL","Not Displayed element ::"+Label);
		}
	}


	public void checkSearchResult(WebElement element,String eText) {
		String text_getText=element.getText();
		String text_innerHTML=element.getAttribute("innerHTML");
		String text_textContent=element.getAttribute("textContent");
		//logReport("INFO","Expected text is:"+eText);
		//logReport("INFO", "getText:"+text_getText);
		Utility.highlightElement(driver,element);

		//logReport("INFO","innerHTML:"+text_innerHTML);
		//logReport("INFO", "textContent:"+text_textContent);
		if(text_getText.contains(eText))
		{	
			logReport("PASS","Verified using getText; Actual searchResult matches Expected searchResult");
		}
		else if(text_innerHTML.contains(eText))
		{	
			logReport("PASS","Verified using innerHTML; Actual searchResult matches Expected searchResult");
		}
		else if(text_textContent.contains(eText))
		{	
			logReport("PASS","Verified using textContent; Actual searchResult matches Expected searchResult");
		}
		else
		{
			logReport("FAIL","Actual searchResult DO NOT matchSearchResult");
		}

	}

	public void checkDiscountIsAppliedForAllProducts(WebElement element, String eText) {
		String text_getText=element.getAttribute("value");
		String text_innerHTML=element.getAttribute("innerHTML");
		String text_textContent=element.getAttribute("textContent");
		logReport("INFO","Expected text is:"+eText);
		logReport("INFO", "getText:"+text_getText);
		Utility.highlightElement(driver,element);

		//logReport("INFO","innerHTML:"+text_innerHTML);
		//logReport("INFO", "textContent:"+text_textContent);
		if(text_getText.contains(eText))
		{	
			logReport("PASS","Verified using getText; Discount is applied for product");
		}
		else if(text_innerHTML.contains(eText))
		{	
			logReport("PASS","Verified using innerHTML; Discount is applied for product");
		}
		else if(text_textContent.contains(eText))
		{	
			logReport("PASS","Verified using textContent; Discount is applied for product");
		}
		else
		{
			logReport("FAIL","Discount is Not applied for product");
		}

	}

	public void verifyOrderProducts(List<WebElement> ordered_products, String[] orderedProductsArticleNumbers2) {
		int i,j;
		for(j=0;j<orderedProductsArticleNumbers2.length;j++)
		{
			logReport("INFO","Expected text is:"+orderedProductsArticleNumbers2[j]);
			for(i=0;i<ordered_products.size();i++)
			{
				String text_getText=ordered_products.get(i).getText();
				String text_innerHTML=ordered_products.get(i).getAttribute("innerHTML");
				String text_textContent=ordered_products.get(i).getAttribute("textContent");
				Utility.highlightElement(driver,ordered_products.get(i));




				//logReport("INFO","innerHTML:"+text_innerHTML);
				//logReport("INFO", "textContent:"+text_textContent);
				if(text_getText.contains(orderedProductsArticleNumbers2[j]))
				{	
					logReport("PASS","Verified using getText; Proudct with Article Number "+ordered_products.get(i).getText()+" is present");
					break;
				}
				else if(text_innerHTML.contains(orderedProductsArticleNumbers2[j]))
				{	
					logReport("PASS","Verified using innerHTML;  Proudct with Article Number "+ordered_products.get(i).getText()+" is present");
					break;
				}
				else if(text_textContent.contains(orderedProductsArticleNumbers2[j]))
				{	
					logReport("PASS","Verified using textContent;  Proudct with Article Number "+ordered_products.get(i).getText()+" is present");
					break;
				}

			}
			if(i==ordered_products.size())
			{
				logReport("FAIL"," Proudct with Article Number "+ordered_products.get(i).getText()+" is Not present");

			}
		}

	}

	public void addScreenshoot(String Screenshotlog)
	{
		String pImage=Utility.getPageScreenShot(driver,AutomationConstants.screenShotsFolderPath);
		try {
			Reporter.addScreenCaptureFromPath(pImage+Utility.getFormatedDateTime()+".jpg", "Screenshotlog");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public String selectValueFromMobileDropdown(List<WebElement> elements,String value)
	{

		for(int i=0;i<elements.size();i++)
		{
			if(elements.get(i).getText().contains(value))
			{
				String type=elements.get(i).getText();
				click(elements.get(i).getText(),elements.get(i));
				return type;
			}

		}
		return null;
	}

	public String selectRandomValueFromMobile(List<WebElement> elements)
	{
		for(int i=0;i<elements.size();i++)
		{
			if(!elements.get(i).getText().contains("--None--"))
			{
				String value=elements.get(i).getText();
				click(elements.get(i).getText(), elements.get(i));
				return value;
			}
		}

		return null;
	}

	/*public void waitForacitvity(String activity) {
		AndroidDriver<AndroidElement> ad=(AndroidDriver<AndroidElement>) driver;
		int i=0;
		while(i<5)
		{
			try{
				long n=(long)Double.parseDouble("3");
				Thread.sleep(n*1000);
				//logReport("INFO","Waiting for "+durationInSecond+" seconds ");
				if(ad.currentActivity().equals(activity))
				{
					break;
				}
				else
				{
					i++;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

		}*/



	public void waitProgressbarToDisapper(WebElement progressbar) {
		waitTill("5");
		try
		{
			while(true) 
			{
				String width = Integer.toString(progressbar.getSize().getWidth());
				if(width.equals("0"))
				{
					break;
				}
			}
		}
		catch (Exception e)
		{

		}
	}


	public void readPDFTest1(String pdfcontent, Map<String, String> pdfdetails) throws IOException 
	{
		int count =0;
		try {
			while(count<3) {
				for (Map.Entry<String, String> entry : pdfdetails.entrySet())
				{
					if (pdfcontent.contains(entry.getValue())) 
					{

						logReport("INFO","Heading with the Serial number : " + entry.getValue() + " 	Present");
						logReport("INFO","Table of contents are present in the PDF "+entry.getValue());
					}
					else {
						logReport("INFO", "Unable to find the :"+entry.getValue()+" Validation fail");
						Assert.fail();
					}
				}
				break;
			}
		} catch (Exception e) {
			count++;
			waitTill("6");
		}


	}
	//for german
	public void verify_table_of_content(String path) throws IOException {
		// TODO Auto-generated method stub
		Map<String, String> pdfdetails = new HashMap<String, String>();





		pdfdetails.put("g_e_s", "1. Gesamtübersicht");
		pdfdetails.put("z_u_s", "2. Zusammenfassung");
		pdfdetails.put("a_n_g", "3. Angebotsübersicht");
		pdfdetails.put("a_n_g_1", "4. Angebotsbeschreibung");
		pdfdetails.put("k_o_n_&_z_a_h", "5. Konditionen und Zahlungsbedingungen");
		pdfdetails.put("g_e_s_&_l_i_e", "6. Leasingangebot / Bereitstellung");
		pdfdetails.put("g_e_s_&_l_i_e", "7. Geschäfts- und Lieferkonditionen");



		readPDFTest1(path, pdfdetails);


	}


	public void verify_table_of_contents_for_Country_Belgium(String path) throws IOException
	{
		Map<String, String> pdfdetails = new HashMap<String, String>();
		pdfdetails.put("table_content1", "1. Financieel overzicht ");
		pdfdetails.put("table_content2", "2. uw investering");
		pdfdetails.put("table_content3", "3. Offerte overzicht");
		pdfdetails.put("table_content4", "4. Offerte details");
		pdfdetails.put("table_content5", "5. Voorwaarden en Condities");
		pdfdetails.put("table_content6", "6. Statement of Work of samenvatting van de werkzaamheden");
		pdfdetails.put("table_content7", "7. Financiering");
		pdfdetails.put("table_content8", "8. Voorlopige details van het terugkerende facturatieplan");
		pdfdetails.put("table_content9", "9. Algemene Philips voorwaarden");
		pdfdetails.put("table_content10", "10. Bijlage");


		readPDFTest1(path, pdfdetails);
	}


	//french
	public void verify_tables_of_content(String path) throws IOException 
	{
		// TODO Auto-generated method stub
		Map<String, String> pdfdetails = new HashMap<String, String>();
		pdfdetails.put("a_p_f", "1. Aperçu financier");
		pdfdetails.put("a_d_l_o", "2. Aperçu de l'offre");
		pdfdetails.put("d_d_l_o", "3. Détails de l'offre");
		pdfdetails.put("c_g_d_v", "4. Conditions générales de vente");
		pdfdetails.put("d_d_p_d_f_r_p", "5. Détails du plan de facturation récurrente préliminaire");
		pdfdetails.put("c_g_d_p", "6. Conditions générales de Philips");
		pdfdetails.put("c_d_s_t_e_c", "7. Contrat de service Termes et conditions");


		readPDFTest1(path, pdfdetails);

	}
	//canada
	public void verify_table_of_contents(String pdfpath) throws IOException {
		// TODO Auto-generated method stub
		Map<String, String> pdfdetails = new HashMap<String, String>();
		pdfdetails.put("table_content1", "1. Financial Overview");
		pdfdetails.put("table_content2", "2. Quote Summary");
		pdfdetails.put("table_content3", "3. Offer Overview");
		pdfdetails.put("table_content4", "4. Offer Detail");
		pdfdetails.put("table_content5", "5. Local Sales Terms and Conditions");
		pdfdetails.put("table_content6", "6. Leasing");
		pdfdetails.put("table_content7", "7. Signature Page");
		pdfdetails.put("table_content8", "8. Philips Standard Terms and Conditions");
		pdfdetails.put("table_content9", "9. Appendix");


		readPDFTest1(pdfpath, pdfdetails);


	}
	//Ireland
	public void verify_table_of_contents_Ireland(String path) throws IOException {
		// TODO Auto-generated method stub
		Map<String, String> pdfdetails = new HashMap<String, String>();
		pdfdetails.put("table_content1", "1. Financial overview");
		pdfdetails.put("table_content2", "2. Quote summary");
		pdfdetails.put("table_content3", "3. Offer overview");
		pdfdetails.put("table_content4", "4. Offer Detail");
		pdfdetails.put("table_content5", "5. Contract(s) overview ");
		pdfdetails.put("table_content6", "6. Financing Solutions");
		pdfdetails.put("table_content7", "7. Terms and Conditions");
		pdfdetails.put("table_content8", "8. Appendix");

		readPDFTest1(path, pdfdetails);

	}
	//britain
	public void verify_table_of_contents_britain(String path) throws IOException {
		// TODO Auto-generated method stub
		Map<String, String> pdfdetails = new HashMap<String, String>();
		pdfdetails.put("table_content1", "1. Financial overview");
		pdfdetails.put("table_content2", "2. Quote summary");
		pdfdetails.put("table_content3", "3. Offer overview");
		pdfdetails.put("table_content4", "4. Offer Detail");
		pdfdetails.put("table_content5", "5. Contract(s) overview ");
		pdfdetails.put("table_content6", "6. Financing Solutions ");
		pdfdetails.put("table_content7", "7. Terms and Conditions");
		pdfdetails.put("table_content8", "8. Appendix");
		readPDFTest1(path, pdfdetails);
	}
	//for english
	public void verify_table_of_contents_for_english(String pdfpath) throws IOException {
		// TODO Auto-generated method stub
		Map<String, String> pdfdetails = new HashMap<String, String>();
		if(AutomationConstants.sandbox.equals("uat"))
		{
			pdfdetails.put("table_content1", "1. Financial Overview");
			pdfdetails.put("table_content2", "2. Quote Summary ");
			pdfdetails.put("table_content3", "3. Offer Overview ");
			pdfdetails.put("table_content4", "4. Offer Detail ");
			pdfdetails.put("table_content5", "5. Local Sales Terms and Conditions ");
			pdfdetails.put("table_content6", "6. Leasing");
			pdfdetails.put("table_content7", "7. Signature Page ");
			pdfdetails.put("table_content9", "8. Appendix");
		}
		else
		{
			pdfdetails.put("table_content1", "1. Financial Overview");
			pdfdetails.put("table_content2", "2. Quote Summary ");
			pdfdetails.put("table_content3", "3. Offer Overview ");
			pdfdetails.put("table_content4", "4. Offer Detail ");
			pdfdetails.put("table_content5", "5. Local Sales Terms and Conditions ");
			pdfdetails.put("table_content6", "6. Leasing");
			pdfdetails.put("table_content7", "7. Signature Page ");
			pdfdetails.put("table_content8", "8. Philips Standard Terms and Conditions");
			pdfdetails.put("table_content9", "9. Appendix");
		}
		readPDFTest1(pdfpath, pdfdetails);


	}
	public void verify_table_of_contents_France(String path) throws IOException {
		// TODO Auto-generated method stub
		Map<String, String> pdfdetails = new HashMap<String, String>();
		pdfdetails.put("table_content1", "1. Proposition financière ");
		pdfdetails.put("table_content2", "2. Synthèse du devis ");
		pdfdetails.put("table_content3", "3. Contenu du devis ");
		pdfdetails.put("table_content4", "4. Détails du devis");
		pdfdetails.put("table_content5", "5. Conditions de facturation");
		pdfdetails.put("table_content6", "6. Offre de location");
		pdfdetails.put("table_content7", "7. Page de la signature ");
		pdfdetails.put("table_content8", "8. Conditions générales de vente");
		pdfdetails.put("table_content9", "9. Annexes ");



		readPDFTest1(path, pdfdetails);



	}
	public void verify_table_of_contents_spain(String path) throws IOException {
		// TODO Auto-generated method stub
		Map<String, String> pdfdetails = new HashMap<String, String>();
		pdfdetails.put("table_content1", "1. Resumen Económico ");
		pdfdetails.put("table_content2", "2. Resumen de la Oferta ");
		pdfdetails.put("table_content3", "3. Opciones incluidas ");
		pdfdetails.put("table_content4", "4. Detalles de la Oferta ");
		pdfdetails.put("table_content5", "5. Términos y Condiciones particulares de venta ");
		pdfdetails.put("table_content6", "6. Leasing ");
		pdfdetails.put("table_content7", "7. Propuesta Económica de Equipamiento ");
		pdfdetails.put("table_content8", "8. Términos y Condiciones generales de Venta y Licencia de Software ");
		pdfdetails.put("table_content9", "9. Apéndice ");



		readPDFTest1(path, pdfdetails);

	}
	public void verify_table_of_contents_netherland(String path) {
		Map<String, String> pdfdetails = new HashMap<String, String>();
		pdfdetails.put("table_content1", "1. Financieel overzicht");
		pdfdetails.put("table_content2", "2. Offerte overzicht");
		pdfdetails.put("table_content3", "3. Offerte details");
		pdfdetails.put("table_content4", "4. Voorwaarden en Condities");

	}


	public void verify_table_of_contents_Sweden(String path) throws IOException {
		Map<String, String> pdfdetails = new HashMap<String, String>();
		pdfdetails.put("table_content1", "1. Finansiell översikt");
		pdfdetails.put("table_content2", "2. Offertsammanställning");
		pdfdetails.put("table_content3", "3. Offererad konfiguration");
		pdfdetails.put("table_content4", "4. Produktinformation");
		pdfdetails.put("table_content5", "5. Leverans- och betalningsvillkor");
		pdfdetails.put("table_content6", "6. Leasing");
		pdfdetails.put("table_content7", "7. Leverans- och betalningsvillkor");
		pdfdetails.put("table_content8", "8. Bilaga (or)");

		readPDFTest1(path, pdfdetails);

	}

	public void verify_table_of_contents_Denmark(String path) throws IOException {
		Map<String, String> pdfdetails = new HashMap<String, String>();
		pdfdetails.put("table_content1", "1. Prisoversigt");
		pdfdetails.put("table_content2", "2. Konfiguration");
		pdfdetails.put("table_content3", "3. Tilbudsoversigt");
		pdfdetails.put("table_content4", "4. Tilbudsdetaljer");
		pdfdetails.put("table_content5", "5. Salgs- og leveringsbetingelser");
		pdfdetails.put("table_content6", "6. Leasing");
		pdfdetails.put("table_content7", "7. Philips standard salgs- og leveringsbetingelser");
		pdfdetails.put("table_content8", "8. Bilag");

		readPDFTest1(path, pdfdetails);

	}

	public void verify_table_of_contents_Norway(String path) throws IOException {
		Map<String, String> pdfdetails = new HashMap<String, String>();
		pdfdetails.put("table_content1", "1. Prisoversikt");
		pdfdetails.put("table_content2", "2. Konfigurasjon");
		pdfdetails.put("table_content3", "3. Tilbudsoversikt");
		pdfdetails.put("table_content4", "4. Tilbudsdetaljer");
		pdfdetails.put("table_content5", "5. Salgs- og leveringsbetingelser");
		pdfdetails.put("table_content6", "6. Leasing");
		pdfdetails.put("table_content7", "7. Philips standard salgs- og leveringsbetingelser");
		pdfdetails.put("table_content8", "8. Vedlegg");

		readPDFTest1(path, pdfdetails);

	}

	public void verify_table_of_contents_Finland(String path) throws IOException {
		Map<String, String> pdfdetails = new HashMap<String, String>();
		pdfdetails.put("table_content1", "1. Hintayhteenveto");
		pdfdetails.put("table_content2", "2. Tuoteyhteenveto");
		pdfdetails.put("table_content3", "3. Tarjouksen tiedot");
		pdfdetails.put("table_content4", "4. Tarjouksen tarkemmat tiedot");
		pdfdetails.put("table_content5", "5. Kaupalliset ehdot");
		pdfdetails.put("table_content6", "6. Leasing");
		pdfdetails.put("table_content7", "7. Yleiset ehdot");
		pdfdetails.put("table_content8", "8. Liiteet");

		readPDFTest1(path, pdfdetails);

	}

	public void verify_table_of_contents_switzerland(String path) throws IOException {
		Map<String, String> pdfdetails = new HashMap<String, String>();
		pdfdetails.put("table_content1", "1. Gesamtübersicht");
		pdfdetails.put("table_content2", "2. Zusammenfassung");
		pdfdetails.put("table_content3", "3. Angebotsübersicht");
		pdfdetails.put("table_content4", "4. Offer Details");
		pdfdetails.put("table_content5", "5. Konditionen und Zahlungsbedingungen");
		pdfdetails.put("table_content6", "6. Leasingangebot / Bereitstellung");
		pdfdetails.put("table_content7", "7. Geschäfts- und Lieferkonditionen");
		pdfdetails.put("table_content8", "8. Anhang");

		readPDFTest1(path, pdfdetails);

	}
	public void verify_table_of_contents_Austria(String path) throws IOException {
		Map<String, String> pdfdetails = new HashMap<String, String>();
		pdfdetails.put("table_content1", "1. Financial overview");
		pdfdetails.put("table_content2", "2. Quote summary");
		pdfdetails.put("table_content3", "3. Offer overview");
		pdfdetails.put("table_content4", "4. Offer Details");
		pdfdetails.put("table_content5", "5. Contract(s) overview");
		pdfdetails.put("table_content6", "6. Financing Solutions");
		pdfdetails.put("table_content7", "7. Philips Standard Terms and Conditions");
		pdfdetails.put("table_content8", "8. Appendix");

		readPDFTest1(path, pdfdetails);

	}
	public void verify_table_of_contents_Austria_German(String path) throws IOException {
		Map<String, String> pdfdetails = new HashMap<String, String>();
		pdfdetails.put("table_content1", "1. Gesamtübersicht");
		pdfdetails.put("table_content2", "2. Zusammenfassung");
		pdfdetails.put("table_content3", "3. Angebotsübersicht");
		pdfdetails.put("table_content4", "4. Angebotsbeschreibung");
		pdfdetails.put("table_content5", "5. Konditionen und Zahlungsbedingungen");
		pdfdetails.put("table_content6", "6. Leasingangebot / Bereitstellung");
		pdfdetails.put("table_content7", "7. Geschäfts- und Lieferkonditionen");
		pdfdetails.put("table_content8", "8. Anhang");

		readPDFTest1(path, pdfdetails);

	}
	public void verify_table_of_contents_Italy(String path) throws IOException {
		Map<String, String> pdfdetails = new HashMap<String, String>();
		pdfdetails.put("table_content1", "1. Dettaglio Economico");
		pdfdetails.put("table_content2", "2. Riepilogo Offerta");
		pdfdetails.put("table_content3", "3. Riepilogo Offerta");
		pdfdetails.put("table_content4", "4. Descrizione Analitica dell'Offerta");
		pdfdetails.put("table_content5", "5. Condizioni di fornitura");
		pdfdetails.put("table_content6", "6. Leasing");
		pdfdetails.put("table_content7", "7. Condizioni di fornitura Philips Standard");
		pdfdetails.put("table_content8", "8. Indice");
		readPDFTest1(path, pdfdetails);

	}
	public void verify_table_of_contents_Portugal(String path) throws IOException {
		Map<String, String> pdfdetails = new HashMap<String, String>();
		pdfdetails.put("table_content1", "1. Resumo Económico");
		pdfdetails.put("table_content2", "2. Resumo da Proposta");
		pdfdetails.put("table_content3", "3. Opções incluídas");
		pdfdetails.put("table_content4", "4. Detalhe do Produto");
		pdfdetails.put("table_content5", "5. Termos e Condições particulares de venda");
		pdfdetails.put("table_content6", "6. Leasing");
		pdfdetails.put("table_content7", "7. Página de Assinatura");
		pdfdetails.put("table_content8", "8. Condições Específicas da Proposta, Termos e Condições Gerais de Venda e Licenciamento de Software");
		pdfdetails.put("table_content6", "9. Anexo");

		readPDFTest1(path, pdfdetails);

	}
	public void verify_table_of_contents_Luxembourg(String path) throws IOException {
		Map<String, String> pdfdetails = new HashMap<String, String>();
		pdfdetails.put("table_content1", "1. Aperçu financier");
		pdfdetails.put("table_content2", "2. Résumé du devis");
		pdfdetails.put("table_content3", "3. Aperçu de l'offre");
		pdfdetails.put("table_content4", "4. Détails de l'offre");
		pdfdetails.put("table_content5", "5. Conditions générales de vente");
		pdfdetails.put("table_content6", "6. Énoncé de travail");
		pdfdetails.put("table_content7", "7. Location");
		pdfdetails.put("table_content8", "8. Détails du plan de facturation récurrente préliminaire");
		pdfdetails.put("table_content6", "9. Conditions générales de Philips");
		pdfdetails.put("table_content7", "7. Contrat de service Termes et conditions");
		pdfdetails.put("table_content8", "8. Appendice");
		readPDFTest1(path, pdfdetails);

	}

	public void verify_table_of_contents_canada_french(String pdfpath) throws IOException {
		Map<String, String> pdfdetails = new HashMap<String, String>();
		if(AutomationConstants.sandbox.equals("uat"))
		{
			pdfdetails.put("table_content1", "1. Aperçu financier");
			pdfdetails.put("table_content2", "2. Résumé du devis");
			pdfdetails.put("table_content3", "3. Aperçu de l'offre");
			pdfdetails.put("table_content4", "4. détail de l'offre");
			pdfdetails.put("table_content5", "5. Conditions de vente locales");
			pdfdetails.put("table_content6", "6. Location");
			pdfdetails.put("table_content7", "7. page de signature");
			pdfdetails.put("table_content8", "8. Conditions générales Philips");
			pdfdetails.put("table_content9", "9. Garantie");
			pdfdetails.put("table_content10", "10. Appendice");

		}
		else
		{
			pdfdetails.put("table_content1", "1. Aperçu financier");
			pdfdetails.put("table_content2", "2. Résumé du devis");
			pdfdetails.put("table_content3", "3. Aperçu de l'offre");
			pdfdetails.put("table_content4", "4. détail de l'offre");
			pdfdetails.put("table_content6", "6. Location");
			pdfdetails.put("table_content7", "7. page de signature");
			pdfdetails.put("table_content8", "8. Appendice");
		}
		readPDFTest1(pdfpath, pdfdetails);

	}

	public void waitTillDataPopulates(WebElement element, String value) {

		int count = 0;
		while (count < 5) {
			if (element.getAttribute("title").equals(value) || element.getText().equals(value)) {
				break;
			} else {
				count++;
				waitTill("5");
			}
		}

	}

	public String formatNumber(Double number) {
		NumberFormat usFormat = NumberFormat.getNumberInstance(Locale.US);
		DecimalFormat decimalFormat = (DecimalFormat) usFormat;
		decimalFormat.applyPattern("0.00");
		decimalFormat.setGroupingUsed(true);
		decimalFormat.setGroupingSize(3);

		return decimalFormat.format(number);
	}

	public WebElement waitforElementEnable(WebElement element, String name)
	{

		try {
			int count =0;
			while(count>5)
			{
				if(element.isEnabled())
				{
					logReport("INFO","Waited for "+name+" enable");
					break;
				}
				else
				{
					waitTill("5");
				}
			}

		} catch (Exception e) {
			logReport("INFO","Exception in waitForElement :"+name);

		}

		//logReport("INFO","AfterWaitForElement::"+name);
		return element;
	}

	public void embedScreenShotInreport() {
		try {

			Reporter.addScreenCaptureFromPath(Utility.getPageScreenShot(driver), "Passed");
		} catch (IOException e) {}
	}
	public static void embedScreenShotInreportWithRobot() {
		try {
			Reporter.addScreenCaptureFromPath(Utility.CaptureScreenShotWithTestStepNameUsingRobotClass(), "Passed");
		} catch (IOException e) {}
	}

	public void clickEvent(WebElement element) {
		waitForElement(element, "Element");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void waitLoadingSpinnerToDisappear() {
		By element = By.xpath("//div[contains(@id,'_svmx_cmp_load_mask_')]");
		int attempt = 0;

		while (attempt < 3) {

			long start = System.currentTimeMillis();
			try {
				Wait wait = new FluentWait(driver)

						.withTimeout(Duration.ofSeconds(5))

						.pollingEvery(Duration.ofSeconds(1))

						.ignoring(Exception.class).ignoring(StaleElementReferenceException.class);

				wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
				break;
			} catch (Exception e) {
				logReport("INFO", "Spinner is disappeared");
			}
			attempt++;
			long end = System.currentTimeMillis();
			long duration = end - start;
			duration = duration / 1000;
			logReport("INFO", "duration of spinner = " + duration + "secs");
		}
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} // try
		catch (NoAlertPresentException Ex) {
			return false;
		} // catch
	} 
	
	
	public boolean isChecked(WebElement element) {
		boolean selected = false;
		
		selected=element.isSelected();
		if(selected)
		{
			logReport("PASS", element+" is Checked");
			
		}
		else
		{
			logReport("ERROR", element+" is Not checked");
		}
	
		System.out.println("Is element selected :"+selected);
	return selected;
	} 

	public void dragDrop(WebElement ele1, WebElement ele2) {
		try {
			Actions act = new Actions(driver);
			act.dragAndDrop(ele1, ele2).build().perform();
			waitTill("5");
		} catch (Exception e) {
			int x = ele1.getLocation().x;
			int y = ele2.getLocation().y;

			Actions actions = new Actions(driver);
			actions.moveToElement(ele1).clickAndHold(ele1).moveByOffset(x, y).moveToElement(ele2).moveByOffset(x, y)
			.release().build().perform();
		}
	}

	public static String removeLeadingZeros(String str)
	{
		// Regex to remove leading
		// zeros from a string
		String regex = "^0+(?!$)";
		str = str.replaceAll(regex, "");

		return str;
	}

	public void switchToTab() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabs.size() - 1));
		logReport("INFO", "Switched to Tab");
	}

	public void SwitchtoFramesByID(String id) {
		try {
			waitTill("5");
			driver.switchTo().frame(id);
			System.out.println("Switched to frames");
			logReport("INFO", "Switched to frame");
		} catch (NoSuchElementException n) {
			driver.navigate().refresh();
			logReport("INFO", "Reloading Page");
			System.out.println("Reloading page");
		} catch (Exception e) {
			logReport("INFO", "Unable to switch to Frame");
			System.out.println("Did NOT switch to frames");
		}
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
		logReport("INFO", "page Refreshed");
	}
	public void WebComboBox(String fieldXPath, String Value, String ValueXpath) {
		driver.findElement(By.xpath(fieldXPath)).clear();
		driver.findElement(By.xpath(fieldXPath)).sendKeys(Value);
		try {
			driver.findElement(By.xpath(ValueXpath)).click();
		} catch (Exception e) {

		}
	}

	public void WebListbyName(String fieldName, String Value) {
		Select field = new Select(driver.findElement(By.name(fieldName)));
		field.selectByVisibleText(Value);
	}
	
	public void WebListbyXpath(String fieldXpath, String Value) {
		Select field = new Select(driver.findElement(By.xpath(fieldXpath)));
		field.selectByVisibleText(Value);
	}
	public void WebEditbyName(String fieldName, String Value) {
		WebElement textbox = driver.findElement(By.name(fieldName));
		clear(fieldName, textbox);
		textbox.sendKeys(Value);
	}

	public void doubleClick(WebElement ele) {
		try {
			waitForElement(ele, "ele");
			Actions a = new Actions(driver);
			a.moveToElement(ele).doubleClick().build().perform();
			waitTill("5");
		} catch (Exception e) {

		}
	}

	public void selectFromDropDown(WebElement element, String value, String elementName) {
		waitForElement(element, elementName);
		if (element.isEnabled()) {
			Select dropDown = new Select(element);
			dropDown.selectByVisibleText(value);
			logReport("PASS", "Selected value is : " + value);
		}
	}

	public boolean isAttributePresent(WebElement element, String attribute) {
		boolean result = false;
		try {
			String value = element.getAttribute(attribute);
			if (value != null){
				result = true;
			}
		} catch (Exception e) {
			System.out.println(attribute+" Attribute not present:"+e);
		}

		return result;
	}

	public String getUniquename(String name) {
		String username = name + Utility.getFormatedDateTime();
		return username;
	}

	public void dragAndDrop(WebElement ele1,WebElement ele2,WebElement ele3) {

		try {
			waitTill("5");



			int x1 = ele1.getLocation().x;
			int y1 = ele1.getLocation().y;
			int x3 = ele3.getLocation().x;

			Actions actions = new Actions(driver);
			actions.moveByOffset((x1+x3+x1)/2, y1).clickAndHold()
			// clickAndHold(ele1)
			.moveToElement(ele2)
			// .moveByOffset(x2,y2)
			.release().build().perform();



			} catch (Exception e) {
			}

	}
	
	public boolean verifyElementTobePresent(String fieldLable, WebElement element) {
		boolean elementPresent = false;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		try {
			elementPresent = element.isDisplayed();
			if (elementPresent) {
				Utility.highlightElement(driver, element);
				logReport("PASS", fieldLable + " is present and Displayed");
			} else {
				logReport("ERROR", fieldLable + " is Not Present or Not Displayed");
				Assert.fail();
			}
		} catch (Exception e) {
			logReport("ERROR", "Element is Not Present or Not Displayed");
			Assert.fail();
		}
		return elementPresent;

	}
	
	public boolean waitUntil(long start, long waitDuration) {
		long duration = 0;
		long end = System.currentTimeMillis();
		duration = end - start;
		duration = duration / 1000;
		if (duration > waitDuration) {
			return true;
		}
		return false;
	}
	
	public void verifyIsEditable(WebElement element, WebElement elementInput, String textEdit) {
		String evalue = element.getText();
		doubleClick(element);
		elementInput.sendKeys(textEdit);
		String avalue = elementInput.getText();
		
		if (!avalue.equalsIgnoreCase(evalue)) {
			logReport("PASS", element + " is editable ");
		} else {
			logReport("FAIL", element + " is not editable ");
			Assert.fail();
		}
		
	}
	
	public void verifyIsNotEditable(WebElement element, WebElement elementInput, String textEdit) {
		doubleClick(element);
		verifyElementNotPresent("Expected Element", elementInput);
	}
	
	public void verifyBooleanNotStatus(String avalue, String evalue) {
		if (!(avalue.equalsIgnoreCase(evalue))) {
			logReport("PASS", "Verified using getText; Actual text " + avalue + " DO NOT contain Expected text " + evalue);
		} else {
			logReport("FAIL", "Actual text " + avalue + " contains Expected text " + evalue);
			Assert.fail();
		}
	}
	
	public void pressTab() {
		logReport("INFO", "Pressing TAB");
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
		} catch (Exception e) {
			logReport("WARNING", "Could not Press TAB");
			e.printStackTrace();
		}
	}
	
	public void highlightElement(WebDriver driver, WebElement element, String highlightDuration) {
		String presentColor = element.getCssValue("backgroundColor");
		String newCoclor = "rgb(255,255,0)";

		((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor='" + newCoclor + "'", element);
		waitTill(highlightDuration);
		((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor='" + presentColor + "'",
				element);
	}
	
	public void WebListbyID(String fieldID, String Value) {
		Select field = new Select(driver.findElement(By.id(fieldID)));
		field.selectByVisibleText(Value);
	}
	
	public void robortClassPressBackSpace(int count) {
		logReport("INFO", "Pressing Backspace "+count+" times");
		for (int i = 0; i < count; i++) {
			try {
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_BACK_SPACE);
				robot.keyRelease(KeyEvent.VK_BACK_SPACE);
				waitTill("5");

			} catch (Exception e) {
				logReport("WARNING", "Could not Press ENTER");
				e.printStackTrace();
			}
		}
	}
	
	public void sendKey(String value){
		Actions a= new Actions(driver);
		a.sendKeys(value).build().perform();

	}
	public void doubleClick(WebElement element, String fieldLable) {

		Actions actions = new Actions(driver);
		waitForElement(element, "Element");

		actions.doubleClick(element).build().perform();
		waitTill("3");
		logReport("INFO", "Double clicked on" + fieldLable);
	}
}