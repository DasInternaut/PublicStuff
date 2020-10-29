package com.concentrix.testing.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.interactions.Action;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import com.concentrix.testing.demo.actor.Actor;
import com.concentrix.testing.demo.calculator.Calculator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {
	
	Calculator calculator;
	Integer result;
	boolean isInitialised = false;
	Actor user = new Actor();
	static WebDriver driver;
	int counter = 0;

	private void setInitialised() {
		driver = user.getDriver();
		isInitialised = true;
	}
	
	@Given("I have a calculator")
	public void i_have_a_calculator() {
	    // Write code here that turns the phrase above into concrete actions
	    calculator = new Calculator();
	    counter++;
	    System.out.println("-------------- Counter = " + counter);
	}

	@When("I add {int} and {int}")
	public void i_add_and(Integer a, Integer b) {
	    result = calculator.add(a,b);
	    counter++;
	    System.out.println("-------------- Counter = " + counter);
	}

	@Then("I should get {int}")
	public void i_should_get(Integer expectedResult) {
	    counter++;
	    System.out.println("-------------- Counter = " + counter);
	    assertThat(result).isEqualTo(expectedResult);
	}
	
	@Given("I have a web browser")
	public void i_have_a_web_browser() {
	    if (!isInitialised) {
	    	setInitialised();
	    }
	}

	@Given("I've navigated to {string}")
	public void i_ve_navigated_to(String url) {
	    //driver.get(url);
	    counter++;
	    System.out.println("-------------- Counter = " + counter);
		user.navigateURL(url);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//user.navigateURL(url);
	}

	@When("I click {string}")
	public void i_click(String string) {
	    counter++;
	    System.out.println("-------------- Counter = " + counter);
		assertTrue(user.clickOnSomething(string));
		//driver.findElement(By.xpath("//*[@id=\"orb-nav-links\"]/ul/li[2]/a")).click();
	}

	@Then("I'm taken to the {string} page")
	public void i_m_taken_to_the_page(String string) {
	    // Write code here that turns the phrase above into concrete actions
//		assertTrue(user.checkLocation(string));
	    counter++;
	    System.out.println("-------------- Counter = " + counter);
		assertTrue(user.amIhere(string));
	}
	
	@Then("I'm taken to the BBC News page")
	public void i_m_taken_to_the_BBC_News_page() {
		//Very basic stuff - the BBC News Page now nags you to sign in.  
		//A quick hack to dismiss that goes here.
	    //driver.findElement(By.xpath("//*[@id=\"sign_in\"]/div/button")).click();
	    counter++;
	    System.out.println("-------------- Counter = " + counter);
		assertTrue(user.amIhere("BBC News"));
	}

	@Given("I'm at the {string} page")
	public void i_m_at_the_page(String string) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println ("\n1.  Passing \"" + string + "\" to amIhere\n");
	    counter++;
	    System.out.println("-------------- Counter = " + counter);
	    assertTrue(user.amIhere(string));
	}
	
	@Given("I enter {string} into the {string} field")
	public void i_enter_into_the_field(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    counter++;
	    System.out.println("-------------- Counter = " + counter);
	    assertTrue(user.enterSomeText(string2, string));
	}

	@Then("I see {string}")
	public void i_see(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    counter++;
	    System.out.println("-------------- Counter = " + counter);
	    assertTrue(user.lookForSomeText(string));
	}
	
}
