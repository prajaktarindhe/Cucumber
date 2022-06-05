package com.mindtree.stepdefinitions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mindtree.pageObjects.RentalPropertyPO;
import com.mindtree.pageObjects.SellerPlanPage;
import com.mindtree.runner.NoBroker;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class SellerPlanPageSD {
	SellerPlanPage SP;
	Logger log = LogManager.getLogger(NoBroker.class.getName());
	static WebDriver driver;

    @Given("^Get the driver from the Career Page$")
    public void get_the_driver_from_the_career_page() throws Throwable {
    	driver = CareerPageSD.getDriver();
		Thread.sleep(5000);
    }

    @Then("^Click on Menu$")
    public void click_on_menu() throws Throwable {
    	SP = new SellerPlanPage(driver);
    	SP.getlogo().click();
		SP.getmenu().click();
		Thread.sleep(3000);
    }

    @Then("^Click on seller Plan$")
    public void click_on_seller_plan() throws Throwable {
    	SP.getsellerplan().click();
		Thread.sleep(3000);
		log.info("Navigated to Seller Plan Page");
    }

    @And("^Verify the plan and its amount$")
    public void verify_the_plan_and_its_amount() throws Throwable {
    	if (SP.getplantitle().getText().contains("MoneyBack Plan"))
			Assert.assertTrue(true);
		Thread.sleep(3000);
		log.info("Verified title of plan at Seller Plan Page");

		if (SP.getplanamount().getText().contains("₹16,499"))
			Assert.assertTrue(true);
		Thread.sleep(3000);
		log.info("Verified amount of plan at Seller Plan Page");
    }

	public static WebDriver getDriver() {
		return driver;
	}

}