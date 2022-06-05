package com.mindtree.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.appUIStrore.AvoidBrokerUI;
import com.mindtree.appUIStrore.CorporateInquiryPackersMoversPageUI;

public class AvoidBrokerPO {
	public WebDriver driver;

	public AvoidBrokerPO(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getBroker() {
		List<WebElement> List = driver.findElements(AvoidBrokerUI.broker);
		return List.get(0);
	}

	public WebElement getTitle() {
		return driver.findElement(AvoidBrokerUI.title);
	}

	public WebElement getMenu() {
		return driver.findElement(AvoidBrokerUI.menu);
	}
}