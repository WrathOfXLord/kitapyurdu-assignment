package com.testinium.pages;

import org.openqa.selenium.By;

public class FavouritesPage extends LoginPage {
    public FavouritesPage() {
        super();
    }
    
    //a[@onclick='removeFromFavorites(133053);']
    public void removeFromFavorites(String id) {
        driverMethods.clickElementJS(By.xpath(String.format("//a[@onclick='removeFromFavorites(%s);']", id)));
        driverMethods.waitForSeconds(2);;
    }
}
