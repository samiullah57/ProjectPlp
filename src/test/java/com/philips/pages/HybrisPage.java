package com.philips.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.philips.generic.AutomationConstants;
import com.philips.generic.Utility;
import com.philips.stepdefinitions.Hooks;

public class HybrisPage extends BasePage {
	
	@FindBy(xpath = "//*[contains(text(),'Select from address book') and @type='button']")
	private WebElement select_address_book;
	
	@FindBy(xpath = "//*[contains(@class,'ph-shippingaddress__notselected')]/span")
	private List<WebElement> address_items;
	
	@FindBy(xpath = "//button[text()='Proceed to payment']")
	private WebElement proceed_payment_btn;
	
	@FindBy(xpath = "//input[@id='PurchaseOrderNumber']")
	private WebElement po_number;
	
	@FindBy(xpath = "//input[@name='termsCheck']")
	private WebElement terms_check;
	
	@FindBy(xpath = "//button[text()='Complete purchase']")
	private WebElement complete_purchase;
	
	@FindBy(xpath = "//a[text()='View your order']")
	private WebElement view_order;
	
	@FindBy(xpath = "//div[contains(@class,'orderhistory_paneltitle ph-orderhistory_border')]/div[contains(@class,'orderhistory_title ')]")
	private WebElement order_number;
	
	@FindBy(xpath = "//*[@id='reorderForm']//a[text()='Return to Partner Portal ']")
	private WebElement return_to_partner_portal;
	
	@FindBy(xpath = "//*[@id='fcoCheck_bottom']")
	private WebElement fcoParts_Checkbox;
	
	@FindBy(xpath = "//*[@id='fcoCheck_bottom']/../following-sibling::div/button[contains(@class,'orderbtn')]")
	private WebElement proceed_to_cart;

	@FindBy(xpath = "//iframe[@title='TrustArc Cookie Consent Manager']")
	private WebElement iframe_welcome_page;

	@FindBy(xpath = "//a[text()='Accept all']")
	private WebElement accept_all;
	
	@FindBy(xpath = "//div[contains(@id,'LoadedContent')]//button[text()='Acknowledge & continue']")
	private WebElement important_notice;
	
	@FindBy(xpath = "//*[contains(text(),'Checkout')]")
	private WebElement check_out;
	
	@FindBy(xpath = "//button[@id='orderReasonBtn']")
	private WebElement check_out_orderPage;
	
	@FindBy(xpath = "//div[@id='nav_main']//span//a[text()='Spare Parts']")
	private WebElement Spare_parts;
	
	@FindBy(xpath = "//input[contains(@id,'serialNumber')]")
	private List<WebElement> serial_numbers;

	@FindBy(xpath = "//input[contains(@id,'productCode')]")
	private List<WebElement> product_code;
	
	@FindBy(xpath = "//input[contains(@id,'productCode')]")
	private WebElement product_codes;
	
	@FindBy(xpath = "//input[contains(@id,'quantity')]")
	private List<WebElement> quantity;
	
	@FindBy(xpath = "//input[contains(@id,'quantity')]")
	private WebElement quantity1;
	
	@FindBy(xpath = "//*[text()=' Add to cart']")
	private WebElement add_to_cart_button;
	
	@FindBy(xpath = "//*[@id='SPSOrderReasonForm']//a[@class='selectBox ph-label__thirty text ph-checkInputValue ph-forminput ph-m-0 selectBox-dropdown']")
	private WebElement order_type;
	
	@FindBy(xpath = "//a[text()='Equipment Warranty']")
	private WebElement equipment_Warranty;
	
	@FindBy(xpath = "//a[text()='PMS CS Contract']")
	private WebElement PMS_CS_Contract;
	
	@FindBy(xpath = "//a[text()='TIBA Service Contract']")
	private WebElement tiba_service_contract;
	
	@FindBy(id = "systemnumber")
	private WebElement serialnumber_input;
	
	@FindBy(xpath = "//button[@id='tofetchIPSerial']")
	private WebElement fetchIP_button;
	@FindBy(xpath = "//span[@class='ph-checkmark']")
	private WebElement account_payment;
	
	@FindBy(xpath = "//button[text()='Acknowledge & continue']")
	private WebElement Acknowledge_button;
	
	@FindBy(xpath = "//*[@class='ph-equip-successmessage ph-text-success']")
	private WebElement equip_Sucessmessage;
	
	@FindBy(xpath="//button[@id='orderReasonBtn']")
	private WebElement Checkout_orderreasonpage;
	
	@FindBy(xpath="//*[@class='ph-equip-successmessage ph-text-success']")
	private WebElement success_msg;
	
	@FindBy(xpath="//*[@class='ph-ipLuperrormessageEquip ph-text-danger']")
	private WebElement error_msg;
	
	@FindBy(xpath="//*[@class='ph-sucessforContract ph-text-success']")
	private WebElement success_msg1;
	
	@FindBy(xpath="//*[@class='ph-errorforContract ph-text-danger']")
	private WebElement error_msg1;
	
@FindBy(id="systemdescription")
private WebElement des;



@FindBy(id="sixnc")
private WebElement pCode;


@FindBy(xpath="//a[text()='PMS CS Contract']")
private WebElement cont;





@FindBy(id="tofetchContract")
private WebElement submitco;


@FindBy(id="sapContractNumber")
private WebElement co;

@FindBy(id="equipmentserialnumber")
private WebElement Ip;

Actions action = new Actions(driver);
JavascriptExecutor executor = (JavascriptExecutor)driver;

	public void PartsorderHybris() throws AWTException {
		
		
		click("Click on Spare Parts",Spare_parts);
		driver.navigate().refresh();
		waitTill("2");
		enter("Product code",product_codes, "453563277411");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		enter("Quantity", quantity1,"1");
		embedScreenShotInreport();
		click("Add to cart", add_to_cart_button);
		waitTill("5");
		click("Acknowledge and Continue",Acknowledge_button);
		waitTill("5");
		scrollByCordinates(0,200);
		click("Checkout",check_out);
		embedScreenShotInreport();
		scrollByCordinates(0,300);
		click("Order Type",order_type);
		order_type.click();
		
	/*	click("Click on Checkout",Checkout_orderreasonpage);
		
		click("Proceed To Payment", proceed_payment_btn);
		waitTill("4");
		click("PO", po_number);
		driver.findElement(By.xpath("//input[@id='PurchaseOrderNumber']")).sendKeys(Integer.toString(Utility.randomNumberNDigits("4")));
		pressEnter();*/
		
	}
	
	
	public void TS9(ArrayList<String> ipDetails) throws AWTException{
		waitTill("5");
		driver.navigate().back();
		PartsorderHybris();
		scrollByCordinates(0,300);
		waitTill("3");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		click("contract",cont);
		click("contract",cont);
		scrollByCordinates(0,100);
		waitTill("2");
		co.click();
		co.sendKeys(ipDetails.get(0));
		submitco.click();
		embedScreenShotInreport();
		verifyTextContains(error_msg1, "Sucess message is present");
	}
	public void TS8(ArrayList<String> ipDetails) throws AWTException{
		
		waitTill("5");
		driver.navigate().back();
		PartsorderHybris();
		scrollByCordinates(0,200);
		waitTill("3");

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		click("contract",cont);
		click("contract",cont);
		scrollByCordinates(0,200);
		waitTill("2");
		co.click();
		co.sendKeys(ipDetails.get(0));
		submitco.click();
		embedScreenShotInreport();
		verifyTextContains(success_msg1, "Sucess message is present");
		
	}
	public void TS7(ArrayList<String> ipDetails) throws AWTException{
		waitTill("5");
		driver.navigate().back();
		PartsorderHybris();
		equipment_Warranty.click();		
		click("Equipment Warranty",equipment_Warranty);
		waitTill("5");
		scrollByCordinates(0,300);
		
		waitTill("2");
		serialnumber_input.click();
		serialnumber_input.sendKeys(ipDetails.get(0));
		pCode.sendKeys(ipDetails.get(1));
		click("Click on Fetch IP", fetchIP_button);
		embedScreenShotInreport();
		//serialnumber_input.click();
		//serialnumber_input.sendKeys(":DE94546461");
		pCode.clear();
		pCode.sendKeys(ipDetails.get(2));
		click("Click on Fetch IP", fetchIP_button);

		verifyTextContains(error_msg, "Sucess message is present");
		
		
	}
	public void TS6(ArrayList<String> ipDetails) throws AWTException{
		
		waitTill("5");
		driver.navigate().back();
		PartsorderHybris();
		equipment_Warranty.click();		
		click("Equipment Warranty",equipment_Warranty);
		waitTill("5");
		scrollByCordinates(0,300);
		
		waitTill("2");
		serialnumber_input.click(); 
		serialnumber_input.sendKeys(ipDetails.get(0));
		des.sendKeys(ipDetails.get(1));
		click("Click on Fetch IP", fetchIP_button);
		embedScreenShotInreport();
		verifyTextContains(success_msg, "Sucess message is present");
	}
	public void TS5(ArrayList<String> ipDetails) throws AWTException{
		
		waitTill("5");
		driver.navigate().back();
		PartsorderHybris();
		equipment_Warranty.click();		
		click("Equipment Warranty",equipment_Warranty);
		waitTill("5");
		scrollByCordinates(0,300);
		
		waitTill("2");
		scrollByCordinates(0,300);
		serialnumber_input.click();
		serialnumber_input.sendKeys(ipDetails.get(0));
		 waitTill("2");
			click("Click on Fetch IP", fetchIP_button);
			verifyTextContains(error_msg, "Sucess message is present");
	}
	public void TS4(ArrayList<String> ipDetails) throws AWTException{
		
		waitTill("5");
		driver.navigate().back();
		PartsorderHybris();
		equipment_Warranty.click();		
		click("Equipment Warranty",equipment_Warranty);
		waitTill("5");
		scrollByCordinates(0,300);
		
		waitTill("2");
		serialnumber_input.click();
		serialnumber_input.sendKeys(ipDetails.get(0));
		
		Ip.click();
		Ip.sendKeys(ipDetails.get(1));
		 waitTill("2");
			click("Click on Fetch IP", fetchIP_button);
			verifyTextContains(error_msg, "Sucess message is present");
	}
	
	public void TS3(ArrayList<String> ipDetails) throws AWTException{
		
		waitTill("5");
		driver.navigate().back();
		PartsorderHybris();
		equipment_Warranty.click();		
		click("Equipment Warranty",equipment_Warranty);
		waitTill("5");
		scrollByCordinates(0,300);
		waitTill("5");
		serialnumber_input.click();
		serialnumber_input.sendKeys(ipDetails.get(0));
	//	waitForElement(Ip,"Wait for Ip");
	  //action.moveToElement(Ip);
	//	executor.executeScript("arguments[0].click();", Ip);
	click("Enter Ip", Ip);
	waitTill("1");
		Ip.sendKeys(ipDetails.get(1));
		pCode.sendKeys(ipDetails.get(2));
        waitTill("2");
		click("Click on Fetch IP", fetchIP_button);
		embedScreenShotInreport();
		verifyTextContains(success_msg, "Sucess message is present");
		
	}
	


	
	public void TS2(ArrayList<String> ipDetails) throws AWTException{
		waitTill("5");
		driver.navigate().back();
		PartsorderHybris();
		equipment_Warranty.click();		
		click("Equipment Warranty",equipment_Warranty);
		waitTill("5");
		scrollByCordinates(0,300);
		waitTill("5");
		Actions action = new Actions(driver);
		waitTill("2");
		action.moveToElement(serialnumber_input);
		serialnumber_input.click();
		serialnumber_input.sendKeys(ipDetails.get(0));
		
		Ip.click();
		Ip.sendKeys(ipDetails.get(1));
		des.sendKeys(ipDetails.get(2));
		
		click("Click on Fetch IP", fetchIP_button);
		embedScreenShotInreport();
		verifyTextContains(error_msg, "Sucess message is present");
	}
	
	public void TS1(ArrayList<String> ipDetails) throws AWTException{
		//waitTill("15");
		PartsorderHybris();
		//selectRandomValue(equipment_Warranty , "Equipment_warranty"); 
		equipment_Warranty.click();		
		click("Equipment Warranty",equipment_Warranty);
		waitTill("5");
		scrollByCordinates(0,300);
		waitTill("5");
		//action.moveToElement(Ip);
		//executor.executeScript("arguments[0].click();", Ip);
		//sendKey("83246166");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		
		click("click ip" , Ip);
		waitTill("2");
		Ip.sendKeys(ipDetails.get(0));
		serialnumber_input.sendKeys(ipDetails.get(1));
		
		click("Click on Fetch IP", fetchIP_button);		
		waitTill("5");
		embedScreenShotInreport();
		//.textToBePresentInElement(success_msg, "Sucess message is present");
	
		verifyTextContains(success_msg, "Sucess message is present");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	public HybrisPage(WebDriver driver) {
		super(driver);
	}

	public void orderPart(ArrayList<String> productCodes) {
		driver.switchTo().frame(iframe_welcome_page);
		click("Accept all", accept_all);
		waitTill("5");
		
		if(Hooks.testcaseNumber.equals("737463")) {
			embedScreenShotInreport();
//			for(int i=0;i<fcoParts_Checkbox.size();i++) {
			click("fcoParts_Checkbox", fcoParts_Checkbox);
//			}
			embedScreenShotInreport();
			click("proceed_to_cart", proceed_to_cart);
		}
		
		else {
		enter("Product code1", product_code.get(0), productCodes.get(0));
		enter("Quantity", quantity.get(0), "2");
		
		enter("Product code2", product_code.get(1), productCodes.get(1));
		enter("Quantity", quantity.get(1), "2");
		
		embedScreenShotInreport();
		
		click("Add to cart", add_to_cart_button);
		waitTill("5");
		
		}
		
		waitTill("15");
//		if(verifyElementPresent("Acknowledge & Continue", important_notice))
//		{
//			click("Acknowledge & Continue", important_notice);
//		}
		
		
		embedScreenShotInreport();
		click("Checkout", check_out);
		
		
		if(verifyElementPresent("check_out_orderPage", check_out_orderPage)){
		clear("Serial Number", serial_numbers.get(0));
		enter("Serial Number", serial_numbers.get(0), Integer.toString(Utility.randomNumberNDigits("4")));
		
		clear("Quantity", quantity.get(0));
		enter("Quantity", quantity.get(0), "2");
		scrollByViewOfElement(check_out_orderPage);
		embedScreenShotInreport();
		click("Checkout Order Page", check_out_orderPage);
		}
		
		waitTill("5");
		click("Select Shipping Address", select_address_book);
		click("Address Item1", address_items.get(0));
		waitTill("5");
		embedScreenShotInreport();
		click("Proceed To Payment", proceed_payment_btn);
		waitTill("4");
		
		if(verifyElementPresent("Account Payment", account_payment)){
			click("account_payment", account_payment);
		}
		click("PO", po_number);
		//enter("Purchase Order Number", po_number, Integer.toString(Utility.randomNumberNDigits("4")));
		
		driver.findElement(By.xpath("//input[@id='PurchaseOrderNumber']")).sendKeys(Integer.toString(Utility.randomNumberNDigits("4")));
		pressEnter();
		waitTill("15");
		
		click("Terms Check", terms_check);
		waitTill("15");
		click("Complete Purchase", complete_purchase);
		waitTill("10");
		if(verifyElementPresent("PO field", po_number)) {
			click("PO", po_number);
			driver.findElement(By.xpath("//input[@id='PurchaseOrderNumber']")).sendKeys(Integer.toString(Utility.randomNumberNDigits("4")));
			//enter("Purchase Order Number", po_number, Integer.toString(Utility.randomNumberNDigits("4")));
			waitTill("15");
			clickEvent(complete_purchase);
		}
//		System.out.println("Po:"+po_number.getText());
//		if(po_number.getText().isEmpty()) {
//			enter("Purchase Order Number", po_number, Integer.toString(Utility.randomNumberNDigits("4")));
//			pressEnter();
//		}
//		click("Complete Purchase", complete_purchase);
		waitTill("3");
		embedScreenShotInreport();
		click("View your order", view_order);
		waitTill("8");
		embedScreenShotInreport();
		AutomationConstants.SERVICE_MAINTENANCE_CONTRACT_DATA.put("HYBRIS_ORDER_NUMBER", order_number.getText());
		waitForElement(order_number, "order_number");
		scrollByViewOfElement(order_number);
		embedScreenShotInreport();
		click("Return to partner portal", return_to_partner_portal);
		waitForElement(work_order_header, "waitForElement");
		
	}

}
