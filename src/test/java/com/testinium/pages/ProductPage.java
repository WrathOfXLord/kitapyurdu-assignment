package com.testinium.pages;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductPage extends PageBase {

    public void selectSortingType(String filter) {
        driverMethods.selectByText(By.cssSelector(".sort>select"), filter);
        driverMethods.waitForSeconds(2);
    }
    
    public void searchKeyword(String keyword) {
        driverMethods.sendKeys(By.id("search-input"), keyword);
        logger.info(String.format("Searching for %s.", keyword));
        driverMethods.waitForSeconds(2);
        driverMethods.clickElement(By.cssSelector(".common-sprite.button-search"));
        driverMethods.waitForSeconds(3);
    }

    public void locateAndScrollNthProduct(int index) {
        driverMethods.scrollToElement(driverMethods.getElementAt(By.cssSelector(".grid_7>div.name"), index));
        logger.info(String.format("Element %d has been located", index));
        driverMethods.waitForSeconds(2);
    }

    public void selectNProducts(int count) {
        List<WebElement> eList = driverMethods.findElements(By.cssSelector(".hover-menu>a.add-to-favorites"));
        int size = eList.size();
        
        for(int index = 0, at = 0; index < size; ++index) {
            if(!eList.get(index).isDisplayed()) {
               continue; 
            }
            driverMethods.clickElementJS(eList.get(index));
            driverMethods.waitForSeconds(0.5);
            Assertions.assertTrue(driverMethods.isElementVisible(By.id("swal2-title")), "The product could not be added to favourites !");
            logger.info("Assertion Passed: The product was added to favourites.");
            driverMethods.waitForSeconds(1.5);
            ++at;
            logger.info(String.format("Element %d added.", index + 1));

            if(at == 3) {
                String id = eList.get(index).getAttribute("onclick")
                                                 .replace("addToFavorites(", "")
                                                 .replace(");", "");
                try {
                    FileWriter file = new FileWriter("id.txt");
                    file.write(id);
                    file.close();
                    logger.info(String.format("Product %s saved.", id));
                } catch (IOException e) {
                    logger.error("Error while saving the product id !");
                }
            }
            else if(at == 4) 
                break;
        }
        driverMethods.waitForSeconds(2);
    }

    public ProductPage() {
        super();
    }
}
