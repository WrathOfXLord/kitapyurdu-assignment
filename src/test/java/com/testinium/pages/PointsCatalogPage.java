package com.testinium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PointsCatalogPage extends LoginPage {
    public PointsCatalogPage() {
        super();
    }

    public void locateAndClickTurkishClassics() {
        driverMethods.clickElement(By.xpath("//img[@title='Puan Kataloğundaki Türk Klasikleri']"));
        logger.info("Locating Turkish classics.");
        driverMethods.waitForSeconds(2);
    }

    public void locateAllBooksDropdown() {
        WebElement element = driverMethods.findElement(By.xpath("//span[text()='Tüm Kitaplar']"));
        logger.info("Locating all books dropdown.");
        driverMethods.waitForSeconds(1);
        driverMethods.scrollToElement(element);
        driverMethods.waitForSeconds(1);
        element.findElement(By.xpath("//*[text()='Hobi']")).click();
        logger.info("Navigating to \"hobi\".");
        driverMethods.waitForSeconds(2);
    }

    public void addToCartRandomProduct() {
        WebElement element = driverMethods.getRandomElement(By.xpath("//a[@class='add-to-cart']"));
        driverMethods.waitForSeconds(1);
        driverMethods.scrollToElementJS(element);
        driverMethods.waitForSeconds(1);
        logger.info("Adding random product into shopping cart.");
        driverMethods.clickElementJS(element);
        driverMethods.waitForSeconds(2);
    }
}
