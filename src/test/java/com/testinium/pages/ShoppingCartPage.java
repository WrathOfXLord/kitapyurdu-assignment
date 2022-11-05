package com.testinium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends LoginPage {
    public ShoppingCartPage() {
        super();
    }

    public void increaseItemQuantity() {
        WebElement element = driverMethods.findElement(By.xpath("//form[@class='js-cart-update-product']/input[@type='text']"));
        driverMethods.waitForSeconds(1.5);
        int value = Integer.parseInt(element.getAttribute("value"));
        element.clear();
        driverMethods.waitForSeconds(0.5);
        element.sendKeys(String.valueOf(++value));        
    }

    public void updateItemQuantity() {
        driverMethods.clickElement(By.xpath("//form[@class='js-cart-update-product']/i[@title='Güncelle']"));
        driverMethods.waitForSeconds(2);
    }

    public void checkoutPage() {
        driverMethods.clickElementJS(By.cssSelector("td>.button.red"));
        logger.info("Navigating to checkout page.");
        driverMethods.waitForSeconds(3);
    }

    public void addAddress() {
        
        driverMethods.clickElement(By.xpath("//div[@id='shipping-tabs']/a[@href='#tab-shipping-new-adress']"));
        driverMethods.waitForSeconds(1);
        driverMethods.findElement(By.id("address-firstname-companyname")).sendKeys("Ali");;
        driverMethods.waitForSeconds(1);
        driverMethods.findElement(By.id("address-lastname-title")).sendKeys("Özel");;
        driverMethods.waitForSeconds(1);
        driverMethods.selectByText(By.id("address-country-id"), "Türkiye");
        driverMethods.waitForSeconds(1);
        driverMethods.selectByText(By.id("address-zone-id"), "İstanbul");
        driverMethods.waitForSeconds(1);
        driverMethods.selectByText(By.id("address-county-id"), "FATİH");
        driverMethods.waitForSeconds(1);
        driverMethods.findElement(By.id("address-address-text")).sendKeys("Samatya");;
        driverMethods.waitForSeconds(1);
        driverMethods.findElement(By.id("address-mobile-telephone")).sendKeys("5386807707");;
        driverMethods.waitForSeconds(1);
        logger.info("Address fields filled.");

        driverMethods.clickElement(By.id("button-checkout-continue"));
        driverMethods.waitForSeconds(5.5);
    }

    public void clickContinue() {
        driverMethods.clickElement(By.id("button-checkout-continue"));
    }

    public void skipShipping() {
        clickContinue();
        logger.info("Continuing with default shipping.");
        driverMethods.waitForSeconds(5.5);
    }

    public void addCreditCardAndCheckOut() {
        driverMethods.findElement(By.id("credit-card-owner")).sendKeys("Ali Özel");
        driverMethods.waitForSeconds(1);
        driverMethods.findElement(By.id("credit_card_number_1")).sendKeys("1111");
        driverMethods.waitForSeconds(0.5);
        driverMethods.findElement(By.id("credit_card_number_2")).sendKeys("1111");
        driverMethods.waitForSeconds(0.5);
        driverMethods.findElement(By.id("credit_card_number_3")).sendKeys("1111");
        driverMethods.waitForSeconds(0.5);
        driverMethods.findElement(By.id("credit_card_number_4")).sendKeys("1111");
        driverMethods.waitForSeconds(0.5);
        driverMethods.selectByText(By.id("credit-card-expire-date-month"), "01");
        driverMethods.waitForSeconds(0.5);
        driverMethods.selectByText(By.id("credit-card-expire-date-year"), "2027");
        driverMethods.waitForSeconds(0.5);
        driverMethods.findElement(By.id("credit-card-security-code")).sendKeys("111");
        logger.info("Card information fields filled.");
        driverMethods.waitForSeconds(0.5);
        clickContinue();
    }

    

}
