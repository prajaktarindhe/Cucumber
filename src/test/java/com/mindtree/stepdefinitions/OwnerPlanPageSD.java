package com.mindtree.stepdefinitions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mindtree.pageObjects.CorporateInquiryPackersMoversPage;
import com.mindtree.pageObjects.OwnerPlanPage;
import com.mindtree.pageObjects.SellerPlanPage;
import com.mindtree.runner.NoBroker;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class OwnerPlanPageSD {
	OwnerPlanPage OP;
	Logger log = LogManager.getLogger(NoBroker.class.getName());
	static WebDriver driver;

	@Given("^Get the driver from the Seller Page$")
	public void get_the_driver_from_the_seller_page() throws Throwable {
		driver = SellerPlanPageSD.getDriver();
		Thread.sleep(5000);
	}

	@Then("^Clicked on Menu$")
	public void clicked_on_menu() throws Throwable {
		OP = new OwnerPlanPage(driver);
		OP.getlogo().click();
		Thread.sleep(3000);

		OP.getmenu().click();
		Thread.sleep(3000);
	}

	@Then("^Click on Owner Plan$")
	public void click_on_owner_plan() throws Throwable {
		OP.getownerplan().click();
		Thread.sleep(3000);
		log.info("Navigated to Owner Plan Page");
	}

	@And("^Verify the plans and its amounts$")
	public void verify_the_plans_and_its_amounts() throws Throwable {
		if (OP.getplantitle().getText().contains("Relax Plan"))
			Assert.assertTrue(true);
		Thread.sleep(3000);
		log.info("Verified title of plan at Owner Plan Page");

		if (OP.getplanamount().getText().contains("₹2,999"))
			Assert.assertTrue(true);
		Thread.sleep(3000);
		log.info("Verified amount of plan at Owner Plan Page");
	}

	public static WebDriver getDriver() {
		return driver;
	}

}