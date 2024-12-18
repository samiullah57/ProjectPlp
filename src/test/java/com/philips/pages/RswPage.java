package com.philips.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RswPage extends BasePage {

	public RswPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@uib-tooltip='Create Service Plan']/..")
	private WebElement create_service_plan;

	@FindBy(xpath = "//input[@name='title']")
	private WebElement case_title;

	@FindBy(xpath = "//textarea[@name='problemDescriptionByEngineer']")
	private WebElement prob_desc_by_engineer;

	@FindBy(xpath = "//textarea[@name='diagnosticSteps']")
	private WebElement diagnosticSteps;

	@FindBy(xpath = "//textarea[@name='errorDescription']")
	private WebElement errorDescription_rsw;

	@FindBy(xpath = "//textarea[@name='repairActionInternal']")
	private WebElement repairActionInternal;

	@FindBy(xpath = "//select[@name='casetype']")
	private WebElement serviceType;

	@FindBy(xpath = "//select[@name='issueOften']")
	private WebElement issueOften;

	@FindBy(xpath = "//select[@name='timeEstimated']")
	private WebElement timeEstimated;

	@FindBy(xpath = "//select[@name='followupPriority']")
	private WebElement followupPriority;

	@FindBy(xpath = "//input[@name='contactNum']")
	private WebElement contactNum;

	@FindBy(xpath = "//button[text()='Review Service Plan']")
	private WebElement Review_Service_Plan;

	@FindBy(xpath = "//button[text()='Publish Service Plan']")
	private WebElement Publish_Service_Plan;

	public void enterFieldsInRSW() {
		waitTill("5");
		String parent2 = driver.getWindowHandle();
		click("create_service_plan", create_service_plan);
		waitTill("10");
		Set<String> windowsRsw = driver.getWindowHandles();
		for (String win : windowsRsw) {
			if (!win.equals(parent2)) {
				driver.switchTo().window(win);

				case_title.clear();
				enter("case_title", case_title, "Test RSW");
				enter("prob_desc_by_engineer", prob_desc_by_engineer, "prob_desc_by_engineer entered");
				enter("diagnosticSteps", diagnosticSteps, "diagnosticSteps entered");
				enter("errorDescription_rsw", errorDescription_rsw, "errorDescription_rsw entered");
				enter("repairActionInternal", repairActionInternal, "repairActionInternal entered");
				WebListbyName("casetype", "Onsite Service");
				WebListbyName("timeEstimated", "1");
				WebListbyName("followupPriority", "1-Critical Need");
				click("Review_Service_Plan", Review_Service_Plan);
				embedScreenShotInreport();
				Set<String> windowsRsw2 = driver.getWindowHandles();
				for (String win2 : windowsRsw2) {
					if (!win2.equals(win)) {
						driver.switchTo().window(win2);

						click("Publish_Service_Plan", Publish_Service_Plan);
						driver.switchTo().alert().accept();
						embedScreenShotInreport();
					}
				}
			}
		}
		driver.close();

	}

	public void publishServiceReporttoSmax() {
		// TODO Auto-generated method stub

	}

	public void verifyFieldsfromSmax() {
		// TODO Auto-generated method stub

	}

}
