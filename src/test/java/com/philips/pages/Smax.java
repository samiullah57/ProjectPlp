package com.philips.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Smax extends BasePage {

	public Smax(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "phSearchInput")
	private WebElement global_search;
	
	@FindBy(id="phSearchButton")
	private WebElement search_click;
	
	public void search(){
		global_search.sendKeys("8117523");
		search_click.click();
		//click_ip.click();
	}
	
	@FindBy(linkText="83246166")
	private WebElement click_ip;

	
	
	
	 

}
