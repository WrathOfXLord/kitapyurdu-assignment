package com.testinium.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.testinium.methods.DriverMethods;

public class PageBase {
    DriverMethods driverMethods;
    public static Logger logger;

    static {
        logger = LogManager.getLogger(PageBase.class);
    }

    public PageBase() {
        driverMethods = new DriverMethods();
    }

    public void navigateToHomePage() {
        driverMethods.clickElement(By.cssSelector(".logo-text>a"));
        logger.info("Redirecting to home page.");
        driverMethods.waitForSeconds(2);
    }
    
    public void navigateToFavorites() {
        driverMethods.scrollToElement(By.xpath("//a[text()='Listelerim']"));
        driverMethods.waitForSeconds(2);
        driverMethods.clickElement(By.xpath("//a[text()='Favorilerim']"));
        logger.info("Navigating to favourites.");
        driverMethods.waitForSeconds(2);
    }

    public void navigateToLoginScreen() {
        driverMethods.clickElement(By.cssSelector(".login>a"));
        logger.info("Redirecting to login page.");
        driverMethods.waitForSeconds(4.5);
    }

    public void navigateToPointsCatalog() {
        driverMethods.clickElement(By.cssSelector(".lvl1catalog>a"));
        logger.info("Redirecting to points catalog.");
        driverMethods.waitForSeconds(2);
    }
}
