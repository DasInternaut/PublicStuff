package com.concentrix.testing.demo;

import static org.junit.Assert.*;
//import org.junit.After;
import org.junit.AfterClass;
//import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import com.concentrix.testing.demo.actor.Actor;

//It turns out that Junit by default expects no interdependence between tests
//and will run each of the methods annotated with @Test in whatever order it
//bloody well pleases. The line below will at least fix it such that we get
//tests run in name order.  I guess my junit tests are a little more granular
//than most.

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JHT3st {

    static Actor user = new Actor();
    static WebDriver driver;

    @BeforeClass
    public static void canIGetABrowser() {
        System.out.println("Inside canIGetABrowser");
        driver = user.getDriver("Firefox");
    }

    @Test
    public void a001canIGetTheBeeb() {
        System.out.println("Inside canIGetTheBeeb");
        user.navigateURL("https://www.bbc.co.uk");
    }

    @Test
    public void a002canIGoToNews() {
        System.out.print("Inside Can I go to news");
        assertTrue(user.clickOnSomething("News Link"));
        assertTrue(user.amIhere("BBC News"));

    }

    @Test
    public void a003canIGoToWeather() {
        System.out.println("Can I go to weather");
        assertTrue(user.clickOnSomething("Weather Link"));
        assertTrue(user.amIhere("Weather"));
    }

    @Test
    public void a004isItGloriouslySunnyInStockport () {
        assertTrue(user.enterSomeText("Post Code", "SK8 4HZ"));
        assertTrue(user.clickOnSomething("Post Code Search"));
        assertTrue(user.lookForSomeText("Glorious Sunshine"));
    }
    

    @AfterClass
    public static void Teardown () {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        driver.quit();
    }    

}
