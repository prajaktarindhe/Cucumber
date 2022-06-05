package com.mindtree.stepdefinitions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.mindtree.reusableComponent.WebDriverHelper;
import com.mindtree.runner.NoBroker;
import com.mindtree.utility.ReadPropertyFile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class HomePageSD {
	
	Logger log = LogManager.getLogger(NoBroker.class.getName());

	static WebDriver driver = null;
	ReadPropertyFile rp = null;
	
	@Given("Open the Browser")
	public void open_the_browser() throws Exception {
		driver = WebDriverHelper.initializeDriver();
		log.info("Browser opened successfully");
	}

	@Then("^Hit the url$")
	public void hit_the_url() throws Throwable {
//		rp = new ReadPropertyFile();
		//driver.get(rp.getUrl());
		driver.get("https://www.nobroker.in/");
		driver.manage().window().maximize();
		log.info("url hited");
		Thread.sleep(3000);
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

}