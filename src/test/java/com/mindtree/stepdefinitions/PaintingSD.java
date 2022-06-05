package com.mindtree.stepdefinitions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import com.mindtree.pageObjects.HomePagePO;
import com.mindtree.pageObjects.OwnerPlanPage;
import com.mindtree.pageObjects.PaintingPagePO;
import com.mindtree.runner.NoBroker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class PaintingSD {
	PaintingPagePO pp;
	Logger log = LogManager.getLogger(NoBroker.class.getName());
	static WebDriver driver;

    @Given("^Get the driver form the AvoidBroker Page$")
    public void get_the_driver_form_the_avoidbroker_page() throws Throwable {
    	driver = AvoidBrokerSD.getDriver();
		Thread.sleep(5000);
    }

    @Then("^Clicks on Menu$")
    public void clicks_on_menu() throws Throwable {
		pp = new PaintingPagePO(driver);
    	HomePagePO hp = new HomePagePO(driver);
		hp.geHome().click();
		pp.getMenu().click();
		Thread.sleep(4000);
    }

    @Then("^Click on Painting and Cleaning$")
    public void click_on_painting_and_cleaning() throws Throwable {
    	pp.getPainting().click();
		Thread.sleep(3000);
		pp.getCity().click();
		pp.getCleaning().click();

    }

    @Then("^verify the titles$")
    public void verify_the_titles() throws Throwable {
    	if (pp.getTitle().getText().contains("Best Home Cleaning")) {
			log.info("Painting and cleaning page is showing");
		}
    }
    
    public static WebDriver getDriver() {
		return driver;
	}

}