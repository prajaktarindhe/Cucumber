package com.mindtree.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./Features", glue = { "com.mindtree.stepdefinitions" }

)
//public class NoBroker {

public class NoBroker extends AbstractTestNGCucumberTests {

}
