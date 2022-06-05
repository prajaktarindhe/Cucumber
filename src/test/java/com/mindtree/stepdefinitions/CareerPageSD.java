package com.mindtree.stepdefinitions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mindtree.pageObjects.BuyingPropertyPO;
import com.mindtree.pageObjects.CareersPage;
import com.mindtree.runner.NoBroker;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class CareerPageSD {
	CareersPage CP;
	Logger log = LogManager.getLogger(NoBroker.class.getName());
	static WebDriver driver;

	@Given("^Get the driver from Painting Page$")
	public void get_the_driver_from_painting_page() throws Throwable {
		driver = PaintingSD.getDriver();
		Thread.sleep(5000);
	}

	@Then("^Click on the Menu$")
	public void click_on_the_menu() throws Throwable {
		CP = new CareersPage(driver);
		CP.getlogo().click();
		Thread.sleep(3000);
		CP.getmenu().click();
		Thread.sleep(3000);
	}

	@Then("^Click on Career$")
	public void click_on_career() throws Throwable {
		Thread.sleep(4000);
		CP.getcareers().click();
		Thread.sleep(3000);
		log.info("Navigated to Careers Page");
	}

	@And("^Verify the Title$")
	public void verify_the_title() throws Throwable {
		if (CP.gettitle().getText().contains("Careers at NoBroker"))
			Assert.assertTrue(true);
		Thread.sleep(3000);
		log.info("Verified title of Careers Page");

	}

	public static WebDriver getDriver() {
		return driver;
	}

}