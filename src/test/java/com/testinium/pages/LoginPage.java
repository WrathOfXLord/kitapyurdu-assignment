package com.testinium.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class LoginPage extends PageBase {
    
    // to change assertion arguments and input fields quickly
    static final String userName = "Ali Fırat Özel";
    static final String email = "alifirato@gmail.com";
    static final String password = "23456Abc";

    public LoginPage() {
        super();
    }

    public void sendLoginInfo() {
        driverMethods.sendKeys(By.id("login-email"), email);
        driverMethods.waitForSeconds(2);
        driverMethods.sendKeys(By.id("login-password"), password);
        driverMethods.waitForSeconds(2);
        // scroll to login button
        driverMethods.scrollToElement(By.cssSelector(".ky-login-btn"));
        logger.info("Sending login info.");
        driverMethods.waitForSeconds(2);
        driverMethods.clickElement(By.cssSelector(".ky-login-btn"));
        logger.info("Waiting for the recaptcha to be solved.");
        // to solve recaptcha puzzle
        driverMethods.waitForSeconds(20);
    }

    public void clickCartButton() {
        driverMethods.findElement(By.id("cart-items")).click();
        driverMethods.waitForSeconds(0.7);
    }

    public void navigateToShoppingCart() {
        clickCartButton();
        driverMethods.findElement(By.id("js-cart")).click();
        driverMethods.waitForSeconds(3);
    }

    public void verifyUserLoggedIn() {
        Assertions.assertEquals(userName, driverMethods.findElement(By.cssSelector(".common-sprite>b")).getText().trim(), "Kullanıcı adları uyuşmuyor");
        logger.info("Logged in. Username: " + userName);
    }
}
