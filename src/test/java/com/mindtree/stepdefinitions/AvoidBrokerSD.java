package com.mindtree.stepdefinitions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.mindtree.pageObjects.AvoidBrokerPO;
import com.mindtree.pageObjects.HomePagePO;
import com.mindtree.runner.NoBroker;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class AvoidBrokerSD {
	
	AvoidBrokerPO ab;
	Logger log = LogManager.getLogger(NoBroker.class.getName());
	static WebDriver driver;

    @Given("^Get the driver from CommercialProperty Page$")
    public void get_the_driver_from_commercialproperty_page() throws Throwable {
    	driver = CommercialPropertySD.getDriver();
		Thread.sleep(5000);
    }

    @Then("^Click on AvoidBroker$")
    public void click_on_avoidbroker() throws Throwable {
    	ab = new AvoidBrokerPO(driver);
    	HomePagePO hp = new HomePagePO(driver);
		hp.geHome().click();
		Thread.sleep(3000);
		ab.getBroker().click();
    }

    @And("^Verifies the title$")
    public void verify_the_title() throws Throwable {
    	if (ab.getTitle().getText().contains("Benefits of NoBroker.in")) {
			log.info("Avoid Broker Page has been showned up");
		}
    }

	public static WebDriver getDriver() {
		return driver;
	}

}