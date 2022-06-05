package com.mindtree.stepdefinitions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.mindtree.pageObjects.HomePagePO;
import com.mindtree.pageObjects.PaintingPagePO;
import com.mindtree.pageObjects.RentalPropertyPO;
import com.mindtree.runner.NoBroker;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class RentalPropertySD {
	
	public RentalPropertyPO rp;
	static WebDriver driver;
	Logger log = LogManager.getLogger(NoBroker.class.getName());


    @Given("^Get the driver from BuyProperty Page$")
    public void get_the_driver_from_buyproperty_page() throws Throwable {
    	driver = BuyPropertySD.getDriver();
		Thread.sleep(5000);
    }

    @Then("^Click on Rent$")
    public void click_on_rent() throws Throwable {
    	rp = new RentalPropertyPO(driver);
		HomePagePO hp = new HomePagePO(driver);
		hp.geHome().click();
		rp.getRent().click();


    }

    @Then("^Enter the Locality as \"([^\"]*)\"$")
    public void enter_the_locality_as_something(String locality) throws Throwable {
    	rp.getLocality().sendKeys(locality);
		Thread.sleep(4000);
		log.info("Locality has been set to " + locality);

    }

    @Then("^press Enter button$")
    public void press_enter_button() throws Throwable {
    	rp.getLocality().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
    }

    @And("^press down button$")
    public void press_down_button() throws Throwable {
    	rp.getLocality().sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(4000);
    }

    @And("^Click on Search$")
    public void click_on_search() throws Throwable {
    	rp.getSearch().click();
		log.info("Buying Properties in MG Road Banglore are visible");
		Thread.sleep(4000);
    }
    
    public static WebDriver getDriver() {
		return driver;
	}

}