package com.mindtree.stepdefinitions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.mindtree.pageObjects.CommercialPropertyPO;
import com.mindtree.pageObjects.HomePagePO;
import com.mindtree.runner.NoBroker;
import com.mindtree.utility.ReadPropertyFile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class CommercialPropertySD {
	CommercialPropertyPO cp;
	Logger log = LogManager.getLogger(NoBroker.class.getName());
	static WebDriver driver;
	ReadPropertyFile rp = null;

    @Given("^Get the driver from RentalProperty Page$")
    public void get_the_driver_from_rentalproperty_page() throws Throwable {
    	driver = RentalPropertySD.getDriver();
		Thread.sleep(5000);
    	
    }

    @Then("^Click on Commercial$")
    public void click_on_commercial() throws Throwable {
    	cp = new CommercialPropertyPO(driver);
    	HomePagePO hp = new HomePagePO(driver);
		hp.geHome().click();
		cp.getCommercial().click();
    }

    @Then("^Entered the Locality as \"([^\"]*)\"$")
    public void entered_the_locality_as_something(String locality) throws Throwable {
    	cp.getLocality().sendKeys(locality);
		log.info("Locality has been set to " + locality);
		Thread.sleep(3000);
    }

    @Then("^pressed Enter button$")
    public void press_enter_button() throws Throwable {
    	cp.getLocality().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
    }

    @And("^pressed down button$")
    public void press_down_button() throws Throwable {
    	cp.getLocality().sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(4000);
    }

    @And("^Clicked on Search$")
    public void clicked_on_search() throws Throwable {
    	cp.getSearch().click();
		log.info("Commercial Properties in Tipu Sultan Banglore are visible");
		Thread.sleep(4000);
    }
    
    public static WebDriver getDriver() {
		return driver;
	}

}