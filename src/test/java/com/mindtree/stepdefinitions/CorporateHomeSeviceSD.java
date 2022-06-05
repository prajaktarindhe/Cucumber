package com.mindtree.stepdefinitions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.mindtree.pageObjects.CommercialPropertyPO;
import com.mindtree.pageObjects.CorporateInquiryHomeServicesPage;
import com.mindtree.runner.NoBroker;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class CorporateHomeSeviceSD {
	CorporateInquiryHomeServicesPage CH;
	Logger log = LogManager.getLogger(NoBroker.class.getName());
	static WebDriver driver;

	@Given("^Get the driver from the Owner Page$")
	public void get_the_driver_from_the_owner_page() throws Throwable {
		driver = OwnerPlanPageSD.getDriver();
		Thread.sleep(5000);
	}

	@Then("^Click on Menu bar$")
	public void click_on_menu_bar() throws Throwable {
    	CH = new CorporateInquiryHomeServicesPage(driver);
		CH.getlogo().click();
		Thread.sleep(3000);
		CH.getmenu().click();
		Thread.sleep(3000);
	}

	@Then("^Click on Corporate Inquiry$")
	public void click_on_corporate_inquiry() throws Throwable {
		CH.getcorporate_inquiry().click();
		Thread.sleep(3000);
		log.info("Navigated to Corportae Inquiry Page");
	}

	@And("^Click on Home Services$")
	public void click_on_home_services() throws Throwable {
		CH.gethome_service().click();
		Thread.sleep(3000);
		log.info("Clicked on the home services option");
		Thread.sleep(3000);
	}

	public static WebDriver getDriver() {
		return driver;
	}

}