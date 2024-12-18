package com.philips.generic;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.philips.generic.configs.EnvironmentFactory;
import com.philips.stepdefinitions.Hooks;

import cucumber.api.Scenario;


public class Utility implements AutomationConstants
{
	//Method used to decript the passwords
	public static String decode(String passwordToHash)
	{
		return StringUtils.newStringUtf8(org.apache.commons.codec.binary.Base64.decodeBase64(passwordToHash));
	}


	public String getTestName(Scenario scenario)
	{
		String testName = scenario.getName();
		return testName.substring(0,testName.indexOf(':'));
		
	}
	
	//Get PDF Details
	public static String getPDFDetails(String path) throws IOException
	{
		FileInputStream file = new FileInputStream(path);
		PDDocument doc = PDDocument.load(file);
		PDFTextStripper objstrp = new PDFTextStripper();
		String pdfcontent = objstrp.getText(doc);
		doc.close();
		file.close();
		return pdfcontent;
	}
	
	public static void clearDirectory(String path)
	{
		try 
		{
			FileUtils.cleanDirectory(new File(path));
		} 
		catch (IOException e) 
		{
			
		} 
		
		
	}
	
	/**
	 * Method to read the excel data
	 * 
	 * @param File and Sheetname
	 * @return List of SFDC ids in the excel
	 */

	public static String createFile(String folderlePath) throws Exception
	{
		String resultPath=null;
		java.util.Date date= new java.util.Date();
		resultPath=folderlePath+"Results_"+date.toString().replace(":", "_");        
		boolean file=new File(resultPath).mkdir();        
		return resultPath;
	}

	//Method used to lanuch the application
	/*public static WebDriver LaunchApplication(WebDriver driver)
	{

		if(AutomationConstants.Browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", AutomationConstants.chromeDriverPath);
			ChromeOptions options=new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
			driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Long.parseLong(AutomationConstants.TimeOut),TimeUnit.SECONDS);
			driver.manage().window().maximize();

		}
		else if(AutomationConstants.Browser.equalsIgnoreCase("BrowserStack"))
		{
			String username = "srinivasg2";
			String accessKey = "mRtFniFzspte46XVfLjj";
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("os", "Windows");
			capabilities.setCapability("os_version", "10");
			capabilities.setCapability("browser", "chrome");
			capabilities.setCapability("browser_version", "72.0");
			capabilities.setCapability("resolution", "1920x1080");

			try {
				driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.browserstack.com/wd/hub"), capabilities);
				System.out.println("Connection Established");
			} catch (MalformedURLException e) {

				e.printStackTrace();
			}
		}
		else if(AutomationConstants.Browser.equalsIgnoreCase("Android"))
		{
			try {
				driver = getAndroidDriver("real1", driver);
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			} catch (MalformedURLException e) {

				e.printStackTrace();
				System.out.println("Unable to launch mobile app");
			}
		}
		else if(AutomationConstants.Browser.equalsIgnoreCase("ChromeHeadless"))
		{

			//System.out.println(AutomationConstants.chromeDriverPath);
			System.setProperty("webdriver.chrome.driver", AutomationConstants.chromeDriverPath);
			ChromeOptions options = new ChromeOptions();  
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
			options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080","--ignore-certificate-errors");  
			driver = new ChromeDriver(options); 
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Long.parseLong(AutomationConstants.TimeOut),TimeUnit.SECONDS);
		}

		return driver;
	}*/

	public static void logoutsalesforce(WebDriver driver)
	{

		driver.findElement(By.id("userNavLabel")).click();
		driver.findElement(By.xpath("//a[@title='Logout']")).click();
		System.out.println("Loggedout successfully");

	}

	/*@SuppressWarnings("unchecked")
	public static  AndroidDriver<AndroidElement> getAndroidDriver(String device, WebDriver driver) throws MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		if(device.equals("real"))
		{
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "9885b6444e4556364d");
		}
		else
		{
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Demo");
		}
		capabilities.setCapability(MobileCapabilityType.APP, AutomationConstants.appAndroid);
		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("resetKeyboard", true);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "com.salesforce.*");
		capabilities.setCapability("appActivity","com.salesforce.chatter.Chatter");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		return (AndroidDriver<AndroidElement>) driver;
	}*/

	//Method used to login to the application
	public static void loginToApp(WebDriver driver)
	{
		if(driver.findElement(By.id("logo")).isDisplayed())
		{
			String un=EnvironmentFactory.getConfigValue("userName");
			String encryptedPW=EnvironmentFactory.getConfigValue("password");
			driver.findElement(By.id("username")).sendKeys(un);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			driver.findElement(By.id("password")).sendKeys(Utility.decode(encryptedPW));
			driver.findElement(By.id("Login")).click();
		}
	}


	//Method used to highlight the Element
	public static void highlightElement(WebDriver driver,WebElement element)
	{
		String presentColor=element.getCssValue("backgroundColor");
		String newCoclor="rgb(255,255,0)";

		for(int i=1;i<=3;i++)
		{
			((JavascriptExecutor)driver).executeScript("arguments[0].style.backgroundColor='"+newCoclor+"'",element);
			((JavascriptExecutor)driver).executeScript("arguments[0].style.backgroundColor='"+presentColor+"'",element);
		}
	}

	//Verify that the value is present in dropdown list vf
	public static boolean isOptionPresentinListBox(WebElement listBox,String option)
	{
		List<WebElement> optionElement = listBox.findElements(By.xpath("./option[text()='"+option+"']"));
		if(optionElement.size()==0){
			return false;}
		else{
			return true;
		}
	}

	//Verify that the Listbox is sorted or not
	public static boolean isListBoxSorted(WebElement listBox)
	{
		List<WebElement> allOptions = new Select(listBox).getOptions();
		ArrayList<String> allText=new ArrayList<String>();
		for(WebElement option:allOptions)
		{
			allText.add(option.getText());
		}
		ArrayList<String> allTextSorted=new ArrayList<String>(allText);
		Collections.sort(allTextSorted);
		for(int i=0;i<allText.size();i++)
		{
			if(allText.get(i).equals(allTextSorted.get(i))){
				System.out.println(allText.get(i)+"<-->"+allTextSorted.get(i));
			}
			else
			{
				System.err.println(allText.get(i)+"<-->"+allTextSorted.get(i));
			}
		}
		return allText.equals(allTextSorted);
	}

	//Get Color to highlight a webElement.
	public static String convertRGBtoHex(String strRGB)
	{
		String hex="";
		List<Integer> rgb=new ArrayList<Integer>();
		Pattern p = Pattern.compile("[0-9]+");
		Matcher m = p.matcher(strRGB);
		while(m.find())
		{
			int v=Integer.parseInt(m.group());
			rgb.add(v);
		}

		int red=rgb.get(0);
		int green=rgb.get(1);
		int blue=rgb.get(2);
		hex = String.format("#%02x%02x%02x",red, green,blue);
		return hex; 
	}

	//Get Current Date and time
	public static String getFormatedDateTime()
	{
		SimpleDateFormat sd = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		return sd.format(new Date());
	}

	//Get Current Date in SFDC Date format
	public static String getSFDCDateFormated()
	{
		SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
		return sd.format(new Date());
	}

	//Get Screenshot
	public static String getPageScreenShot(WebDriver driver,String imageFolderPath)
	{
String imagePath=AutomationConstants.screenShotsFolderPath+ imageFolderPath+Utility.getFormatedDateTime()+".png";
		
		EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
		try{
			FileUtils.copyFile(edriver.getScreenshotAs(OutputType.FILE),new File(imagePath));
		}
		catch(Exception e)
		{
			System.out.println("Unable to capture Screenshot");
		}
		return imagePath;
	}

	//Get Croped Image
	public static String cropImage(String imagePath,int x,int y,int width,int height,String OutputImgFolder)
	{
		String newImagePath=OutputImgFolder+"/"+getFormatedDateTime()+".png";
		try{
			BufferedImage originalImgage = ImageIO.read(new File(imagePath));
			BufferedImage subImgage = originalImgage.getSubimage(x,y,width,height);
			ImageIO.write(subImgage,"png", new File(newImagePath));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return newImagePath;
	}

	//Compare two images
	public static boolean compareImage( String actualImage,String expectedImage) {        
		try {
			DataBuffer eImg = ImageIO.read(new File(expectedImage)).getData().getDataBuffer();
			int sizeA = eImg.getSize();         
			DataBuffer aImg = ImageIO.read(new File(actualImage)).getData().getDataBuffer();
			int sizeB = aImg.getSize();
			if(sizeA != sizeB) return false;
			for(int i=0; i<sizeA; i++) 
				if(eImg.getElem(i) != aImg.getElem(i)) return false;
		} 
		catch (Exception e){return  false;}
		return true;
	}

	public static int randomNumber(int limit)
	{
		Random randomgenator=new Random();
		int n=randomgenator.nextInt(limit);
		return n;
	}
	
	public static int randomNumberNDigits(String numberOfDigits)
	{
		Random randomgenator=new Random();
		int resRandom = 0;
		switch(numberOfDigits) {
		case "2":
			 resRandom = randomgenator.nextInt((99 - 10) + 1) + 10;
			break;
		case "3":
			 resRandom = randomgenator.nextInt((999 - 100) + 1) + 10;
			break;
		case "4":
			resRandom = randomgenator.nextInt((9999 - 100) + 1) + 10;
			break;
		}
	    
		return resRandom;
	}

	public static String currentTimePlusTwoHrs()
	{

		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.HOUR_OF_DAY,2);
		Date afterTwohours = cal.getTime();
		SimpleDateFormat simpDate;
		simpDate = new SimpleDateFormat("h:00 a");
		simpDate.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		String time=simpDate.format(afterTwohours);
		return time;
	}

	public static String EndTime(String time) 
	{

		SimpleDateFormat simpDate;
		simpDate = new SimpleDateFormat("h:00 a");
		simpDate.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		Date d;
		String endtime="";
		try {
			d = simpDate.parse(time);
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			cal.add(Calendar.HOUR_OF_DAY,1);
			endtime = simpDate.format(cal.getTime());
		} catch (ParseException e) {

			e.printStackTrace();
		} 
		return endtime;
	}

	public static String ToDay()
	{
		Date date = new Date();
		SimpleDateFormat simpDate;
		simpDate = new SimpleDateFormat("d");
		simpDate.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		String day=simpDate.format(date);
		return day;
	}

	public static String nextDay()
	{
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		TimeZone tz = TimeZone.getTimeZone("America/New_York");
		cal.setTimeZone(tz);
		cal.setTime(now);
		cal.add(Calendar.DAY_OF_YEAR, 1);
		Date tomorrow = cal.getTime();
		SimpleDateFormat simpDate;
		simpDate = new SimpleDateFormat("d");
		String day=simpDate.format(tomorrow);
		return day;
	}

	public static String previousHour()
	{
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.HOUR_OF_DAY,-1);
		Date tomorrow = cal.getTime();
		SimpleDateFormat simpDate;
		simpDate = new SimpleDateFormat("h:00 a");
		simpDate.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		String nextDate=simpDate.format(tomorrow);
		return nextDate;

	}

	public static String Currentdate()
	{
		SimpleDateFormat sd = new SimpleDateFormat("M/d/YYYY");
		sd.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		return sd.format(new Date());
	}

	public static String nextDayDate()
	{
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.DAY_OF_YEAR, 1);
		Date tomorrow = cal.getTime();
		SimpleDateFormat simpDate;
		simpDate = new SimpleDateFormat("M/d/YYYY");
		String nextDate=simpDate.format(tomorrow);
		return nextDate;
	}


	public static String getPageScreenShot(WebDriver driver)
	{
		String imagePath=AutomationConstants.screenShotsFolderPath+ Utility.getFormatedDateTime()+".png";
		
		EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
		try{
			FileUtils.copyFile(edriver.getScreenshotAs(OutputType.FILE),new File(imagePath));
		}
		catch(Exception e)
		{
			System.out.println("Unable to capture Screenshot");
		}
		return imagePath;
	}

	public static int getFiveDigitRandomNumber()
	{
		Random r = new Random( System.currentTimeMillis() );
	    return 10000 + r.nextInt(20000);
	}


	public static String CaptureScreenShotWithTestStepNameUsingRobotClass()
	{
		try{
			Robot robotClassObject = new Robot();
			Rectangle screenSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage tmp = robotClassObject.createScreenCapture(screenSize);
			String imagePath=AutomationConstants.screenShotsFolderPath+ Hooks.scenarioName+"_"+Utility.getFormatedDateTime()+".png";
			ImageIO.write(tmp, "png",new File(imagePath));
			return imagePath;
		}catch(Exception e)
		{
			System.out.println("Some exception occured." + e.getMessage());
			return "";
		}
	}
		public static String currentDateManupulation(int monthsToAdd, int daysToAdd){

			TimeZone timeZone = TimeZone.getTimeZone("US/Eastern");
			String dateFormat = "dd-MMM-yyyy"; //MMMM dd,yyyy G

			Date now = new Date();
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, monthsToAdd);
			cal.add(Calendar.DATE, daysToAdd);

			//Date
			Date futureDate = cal.getTime();
			DateFormat todayDateFormat = new SimpleDateFormat(dateFormat);

			todayDateFormat.setTimeZone(timeZone);
			String strFutureDate = todayDateFormat.format(futureDate);

			return strFutureDate;
		}
}
