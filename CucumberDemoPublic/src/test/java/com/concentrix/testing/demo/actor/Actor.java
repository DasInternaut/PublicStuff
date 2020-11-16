//Prototype Actor Class

package com.concentrix.testing.demo.actor;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actor {

	protected Map <String, String> elements = new HashMap<String, String>();
	protected Map <String, String> locationCriteria = new HashMap<String, String>();
	static WebDriver driver;
	private static String OS = System.getProperty("os.name").toLowerCase();
	static String driverLocation = "/home/ivbbuild/bin/chromedriver";
	
	public WebDriver getDriver () {
		System.setProperty("webdriver.chrome.driver", driverLocation);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-web-security");
		options.addArguments("--allow-running-insecure-content");
		options.addArguments("disable-infobars");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
			        
		capabilities.setCapability("chrome.binary","./src//lib//chromedriver");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		
		driver = new ChromeDriver(capabilities);
        
        //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        setElements();
        this.driver = driver;
		return driver;
	}

	private WebDriver getFireFox() {
		System.out.println("The OS is " + OS);
		if (isMac()) {
			// System.setProperty("webdriver.gecko.driver", "/Users/Shared/ivbbuild/bin/geckodriver");
			System.setProperty("webdriver.gecko.driver", "/Users/jasonhindle/bin/geckodriver");
			// System.setProperty("webdriver.firefox.bin","/Applications/Firefox.app/Contents/MacOS/firefox-bin");	                
			driver = new FirefoxDriver();
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    setElements();
		    this.driver=driver;
		    return driver;
		}

		if (isUnix()) {
			System.setProperty("webdriver.gecko.driver", "/home/ivbbuild/bin/geckodriver");
			// System.setProperty("webdriver.firefox.bin","/Applications/Firefox.app/Contents/MacOS/firefox-bin");	                
			driver = new FirefoxDriver();
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    setElements();
		    this.driver=driver;
		    return driver;
		}
		
		//Now this is nasty.  I should probably raise my own exception in this instance
		//but hey ho, it's muy code and it's not meant to be any of oven, microwave or
		//production ready.

		return null;
	}
	
	private WebDriver getChrome() {
		System.out.println("The OS is " + OS);
		if (isMac()) {
			System.setProperty("webdriver.chrome.driver", "/Users/Shared/ivbbuild/bin/chromedriver");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            setElements();
            this.driver=driver;
            return driver;
		}

		if (isUnix()) {
			System.setProperty("webdriver.gecko.driver", "/home/ivbbuild/bin/chromedriver");
			driver = new ChromeDriver();
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    setElements();
		    this.driver=driver;
		    return driver;
		}
		
		//Now this is nasty.  I should probably raise my own exception in this instance
		//but hey ho, it's muy code and it's not meant to be any of oven, microwave or
		//production ready.

		return null;
	}
	
	
	public WebDriver getDriver (String browser) {
		
		switch (browser) {
		case "Chrome": {
			return getChrome();
		}
		case "Firefox": {
			return getFireFox();
		}
		}
		
		System.setProperty("webdriver.chrome.driver", driverLocation);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-web-security");
		options.addArguments("--allow-running-insecure-content");
		options.addArguments("disable-infobars");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
			        
		capabilities.setCapability("chrome.binary","./src//lib//chromedriver");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		
		driver = new ChromeDriver(capabilities);
        
        //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        setElements();
        this.driver = driver;
		return driver;
	}
	
	//driver.findElement(By.cssSelector("a[href*='/prepaid/weboam/barred/']")).click();
	
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

	public static boolean isWindows() {

        return (OS.indexOf("win") >= 0);

    }

    public static boolean isMac() {

        return (OS.indexOf("mac") >= 0);

    }

    public static boolean isUnix() {

        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
        
    }

    public static boolean isSolaris() {

        return (OS.indexOf("sunos") >= 0);

    }
}
