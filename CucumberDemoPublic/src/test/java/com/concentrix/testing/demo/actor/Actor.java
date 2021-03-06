//Prototype Actor Class

package com.concentrix.testing.demo.actor;

import com.concentrix.testing.demo.webauto.WebAuto;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

//Number of things not needed at this time but may be importatnt as the demo progresses

//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Action;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class Actor {

	protected Map <String, String> elements = new HashMap<String, String>();
	protected Map <String, String> locationCriteria = new HashMap<String, String>();
	static WebDriver driver;
	static String driverLocation = "/home/ivbbuild/bin/chromedriver";
	private static WebAuto autoUtils = new WebAuto();

	public Actor () {
		//Set up element definitions on construction.
		setElements();
	}
		
	public WebDriver getDriver (String browser) {
		driver = autoUtils.getDriver(browser);
		return driver;		
	}

	public boolean SetDriver(String browser) {
		driver = null;
		driver = autoUtils.getDriver(browser);
		if (driver != null) {
			return true;
		}
		return false;
	}
		
	private void setElements() {
		//elements.put("News Link2", "xpath|//*[@id=\\\"orb-nav-links\\\"]/ul/li[2]/a");
		//elements.put("News Link", "xpath|//*[@id=\"orb-nav-links\"]/ul/li[2]/a");

		elements.put("News Link", "css|a[href*='https://www.bbc.co.uk/news']");
		elements.put("Weather Link", "css|a[href*='https://www.bbc.co.uk/weather']");

		//elements.put("Weather Link", "xpath|//*[@id=\"orb-nav-links\"]/ul/li[4]/a");
		elements.put("Post Code Search", "xpath|//*[@id=\"wr-location-search-container\"]/div/div[1]/form/div/input");
		elements.put("Post Code", "xpath|//*[@id=\"ls-c-search__input-label\"]");
		locationCriteria.put("BBC News", "Business");
		locationCriteria.put("Weather","Features");
		locationCriteria.put("Test", "This is a test value");
	}

	public void navigateURL(String url) {
		driver.get(url);
	}

	//Note: I can't stress enough that the approach below, stretched to all locators
	//types and required element methods is going to potentially lead to some huge 
	//case statements.  It's done this way, here, for clarity and because using 
	//polymorthism is going drive a reader to abstraction.  However, polymorphism 
	//is the way to go because the end result (when done well) is typically more
	//robust, maintainable code with less of the kind of decision logic where defects
	//like to hide.
	
	public boolean enterSomeText (String something, String text) {
		String thing = elements.get(something);
		String things[] = thing.split("\\|");
		String locatorMethod = things[0];
		String locator = things[1];
		switch (locatorMethod) {
			case "xpath": {
				try {
					driver.findElement(By.xpath(locator)).sendKeys(text);
					return true;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
			}
			case "name": {
				try {
					driver.findElement(By.name(locator)).sendKeys(text);
					return true;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
			}
		}
		return false;
	}
	
	
	//This one bit of code is why I quickly decided to objectify
	//the various locator methods.
	
	public boolean clickOnSomething (String something) {
		String thing = elements.get(something);
		String things[] = thing.split("\\|");
		String locatorMethod = things[0];
		String locator = things[1];
		switch (locatorMethod) {
			case "xpath": {
				try {
					driver.findElement(By.xpath(locator)).click();
					return true;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
			}
			case "name": {
				try {
					driver.findElement(By.name(locator)).click();
					return true;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
			}
			case "css": {
				try {
					driver.findElement(By.cssSelector(locator)).click();
					return true;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
			}
		}
		return false;
	}
	
	public boolean lookForSomeText (String text) {
		String findExp = "//*[text()[contains(.,'" + text + "')]]";
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		    driver.findElement(By.xpath(findExp));
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    return true;
		} catch (Exception e) {
			System.out.println("Bad bad bad - assertion will fail badly!!!!!");
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Verified text not present");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return false;
		}
	}
	
	public boolean amIhere (String page) {
		if (checkLocation (page)) {
			return true;
		}
		return false;
	}

	public boolean checkLocation(String string) {
		String textToLookFor;
		try {
			textToLookFor = locationCriteria.get(string);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		if (lookForSomeText(textToLookFor)) {
			return true;
		}
		System.out.println("Don't see the text " + string + "Which resolved to " + textToLookFor);
		return false;
	}

	public void exterminate() {
		driver.quit();
	}

	

}
