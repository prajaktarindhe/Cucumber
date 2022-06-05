package com.mindtree.reusableComponent;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.mindtree.utility.ReadPropertyFile;
import com.relevantcodes.extentreports.ExtentReports;

public class WebDriverHelper {

	static ReadPropertyFile rp = null;
	static WebDriver driver = null;
	
	

	public static WebDriver initializeDriver() throws Exception {

		rp = new ReadPropertyFile();
		System.out.println(rp.getDriverPath());
		if (rp.getBrowser().equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");			
			System.setProperty("webdriver.chrome.driver", rp.getDriverPath());

			driver = new ChromeDriver(options);
		} else if (rp.getBrowser().equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", rp.getDriverPath());

			driver = new InternetExplorerDriver();
		} else if (rp.getBrowser().equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", rp.getDriverPath());

			driver = new FirefoxDriver();

		}

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		return driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	
}
