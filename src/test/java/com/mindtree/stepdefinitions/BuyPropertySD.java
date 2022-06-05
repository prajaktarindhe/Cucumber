package com.mindtree.stepdefinitions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.mindtree.pageObjects.BuyingPropertyPO;
import com.mindtree.pageObjects.HomePagePO;
import com.mindtree.runner.NoBroker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class BuyPropertySD {
	public BuyingPropertyPO bp;
	static WebDriver driver;
	Logger log = LogManager.getLogger(NoBroker.class.getName());

	@Given("^Getting the driver from HomePage$")
	public void getting_the_driver_from_homepage() throws Throwable {
		driver = HomePageSD.getDriver();
		Thread.sleep(5000);
	}

	@Then("^Click on Buy$")
	public void click_on_buy() throws Throwable {
		bp = new BuyingPropertyPO(driver);
		bp.getBuy().click();
		Thread.sleep(4000);
	}

	@Then("Enter the as Locality as {string}")
	public void enter_the_as_locality_as(String locality) throws Throwable {
		bp.getLocality().sendKeys("locality");
		Thread.sleep(4000);
		log.info("Locality has been set to " + locality);

	}

	@Then("^press the Enter button$")
	public void press_the_enter_button() throws Throwable {
		bp.getLocality().sendKeys(Keys.ENTER);
		Thread.sleep(2000);

	}

	@And("^press the down button$")
	public void press_the_down_button() throws Throwable {
		bp.getLocality().sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(3000);
	}

	@And("^Clicks on Search button$")
	public void clicks_on_search_button() throws Throwable {
		bp.getSearch().click();
		log.info("Buying Properties in White Field Banglore are visible");
		Thread.sleep(4000);
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

}