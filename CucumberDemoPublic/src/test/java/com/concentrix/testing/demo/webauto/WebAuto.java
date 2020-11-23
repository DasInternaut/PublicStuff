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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Action;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class WebAuto {
 
    static WebDriver driver;

    public WebDriver getDriver (String OS, String browser) {
        return null;
    }

    private WebDriver chromeNux () {
        return  null;
    }

    private WebDriver chromeMac () {
        return null;
    }

    private WebDriver chromeWin () {
        return null;
    }

    private WebDriver foxNux () {
        return null;
    }

    private WebDriver foxMac () {
        return null;
    }

    private WebDriver foxWin () {
        return null;
    }
        

}