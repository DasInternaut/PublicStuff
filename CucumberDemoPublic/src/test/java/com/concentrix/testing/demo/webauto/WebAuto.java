package com.concentrix.testing.demo.webauto;

//The WebAuto class serves two distinct purposes.
//1. On request it will provided an instance of the required
//   driver type or throw a runtime error if an unsupportd
//   type is requested.
//2. Various helper utilities for Selenium. 

import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Action;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class WebAuto {
 
    static WebDriver driver; 

//Get the relevant environmet variables.  In this case used to set the
//locations of chromedriver and geckodriver.  Can also be used for things
//like config locations, logging locatons and so on.

    private static String chrome = System.getenv("BIN") + "/chromedriver";
    private static String gecko = System.getenv("BIN") + "/geckodriver";
    private static String OS = System.getProperty("os.name").toLowerCase();

//The code in this constructor, and the methods it calls, below, is how we
//determine the OS.  Since I worked out how to get the environment, the
//end result (the OS property) is no longer used...

    public WebAuto () {

        if (isMac()) {
            OS = "Mac";
        }

        if (isUnix()) {
            OS = "Linux";
        }

        if (isSolaris()) {
            OS = "Solaris";
        }

        if (isWindows()) {
            OS = "Windows";
        }

        System.out.println("The operating system is: " + OS);

    }

    public WebDriver getDriver (String browser) {

        switch(browser) {
            case "Chrome": {

                return getChrome();

            }
            case "Firefox": {

                return getFirefox();

            }

            default: {
                System.out.println("Runtime error.  Unsupported browser requested: " + browser);
                System.out.println("Allowable values are Chrome and Firefox");
                throw new RuntimeException ("Runtime error: Unknown browser");
            }


        }
    }

//The process of getting a Chrome driver is far simpler than my earlier days with this technology.

    private WebDriver getChrome() {
        System.setProperty("webdriver.chrome.driver", chrome);
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            return driver;
    }

    private WebDriver getFirefox() {
			System.setProperty("webdriver.gecko.driver", gecko);
			driver = new FirefoxDriver();
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    return driver;
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