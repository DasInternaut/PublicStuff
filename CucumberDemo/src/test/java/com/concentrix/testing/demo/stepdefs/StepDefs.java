package com.concentrix.testing.demo.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.concentrix.testing.demo.actor.Actor;
import com.concentrix.testing.demo.calculator.Calculator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {
	
	Calculator calculator;
	Integer result;
	boolean isInitialised = false;
	static Actor user = new Actor();
	static WebDriver driver;

	private void setInitialised() {
		driver = user.getDriver();
		isInitialised = true;
	}
	
	@Given("I have a calculator")
	public void i_have_a_calculator() {
	    // Write code here that turns the phrase above into concrete actions
	    calculator = new Calculator();

	}

	@When("I add {int} and {int}")
	public void i_add_and(Integer a, Integer b) {
	    result = calculator.add(a,b);

	}

	@Then("I should get {int}")
	public void i_should_get(Integer expectedResult) {
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
		assertTrue(user.clickOnSomething(string));
		//driver.findElement(By.xpath("//*[@id=\"orb-nav-links\"]/ul/li[2]/a")).click();
	}

	@Then("I'm taken to the {string} page")
	public void i_m_taken_to_the_page(String string) {
	    // Write code here that turns the phrase above into concrete actions
//		assertTrue(user.checkLocation(string));
		assertTrue(user.amIhere(string));
	}
	
	@Then("I'm taken to the BBC News page")
	public void i_m_taken_to_the_BBC_News_page() {
		//Very basic stuff - the BBC News Page now nags you to sign in.  
		//A quick hack to dismiss that goes here.
	    //driver.findElement(By.xpath("//*[@id=\"sign_in\"]/div/button")).click();
		assertTrue(user.amIhere("BBC News"));
	}

	@Given("I'm at the {string} page")
	public void i_m_at_the_page(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    assertTrue(user.amIhere(string));
	}
	
	@Given("I enter {string} into the {string} field")
	public void i_enter_into_the_field(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    assertTrue(user.enterSomeText(string2, string));
	}

	@Then("I see {string}")
	public void i_see(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    assertTrue(user.lookForSomeText(string));
	}
	
}
