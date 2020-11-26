// This is the junit runner with a difference from your normal
// common or garden runner as it runs cucumber with Serenity.
// A normal junit/Cucumber version of the same code is nicely
// commented out below. 

// Serenity is a test results reporting package popular in the
// Agile space.

package com.concentrix.testing.demo;

import org.junit.runner.RunWith;
//import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity; 


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
 features = "src/test/resources/com/concentrix/testing/demo/GloriousSunshine.feature"
 ,glue={"com/concentrix/testing/demo/stepdefs"}
 ,dryRun = false

// If you're going through this starting with Calculator.feature, then
// it should be obvious that feature is pointing right back at that.
// The glue, on the other hand, points at the package containing the 
// Java code that glues the Gherkkin to the framework.  

		 
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