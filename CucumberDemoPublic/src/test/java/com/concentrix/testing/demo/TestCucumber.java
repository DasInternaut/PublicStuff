package com.concentrix.testing.demo;

import org.junit.runner.RunWith;
//import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity; 


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
 features = "src/test/resources/com/concentrix/testing/demo/Calculator.feature"
 ,glue={"com/concentrix/testing/demo/stepdefs"}
// ,monochrome=true
// ,plugin = {"html:target/results/htms/cucumber-html-report", "json:target/results/cucumber-json-report.json", "junit:target/results/Cucumber.xml", "pretty"}		 
 )
 
public class TestCucumber {
 
}

/*
package com.concentrix.testing.demo;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(
 features = "src/test/resources/com/concentrix/testing/demo/Calculator.feature"
 ,glue={"com/concentrix/testing/demo/stepdefs"}
 ,monochrome=true
 ,plugin = {"html:target/results/htms/cucumber-html-report", "json:target/results/cucumber-json-report.json", "junit:target/results/Cucumber.xml", "pretty"}		 
 )
 
public class CucumberTest {
 
}
*/