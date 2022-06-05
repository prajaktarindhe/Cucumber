package com.mindtree.stepdefinitions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mindtree.pageObjects.CorporateInquiryHomeServicesPage;
import com.mindtree.pageObjects.CorporateInquiryPackersMoversPage;
import com.mindtree.runner.NoBroker;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class CorporatePackerMoverSD {
	CorporateInquiryPackersMoversPage CP;
	Logger log = LogManager.getLogger(NoBroker.class.getName());
	static WebDriver driver;

	@Given("^Get the driver from the HomeService Page$")
	public void get_the_driver_from_the_homeservice_page() throws Throwable {
		driver = CorporateHomeSeviceSD.getDriver();
		Thread.sleep(5000);
	}

	@Then("^Click on Packer and Movers$")
	public void click_on_packer_and_movers() throws Throwable {
    	CP = new CorporateInquiryPackersMoversPage(driver);
		CP.getpackers_movers().click();
		Thread.sleep(3000);
		log.info("Clicked on the Packers and movers option");
	}

	@And("^Verify the title$")
	public void verify_the_title() throws Throwable {
		if (CP.gettitle().getText().contains("Packers & Movers"))
			Assert.assertTrue(true);
		Thread.sleep(3000);
		log.info("Verified title at Packers and Movers Page");

	}

}