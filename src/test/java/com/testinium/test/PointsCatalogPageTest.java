package com.testinium.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.testinium.pages.PointsCatalogPage;
import com.testinium.pages.ProductPage;

public class PointsCatalogPageTest extends LoginPageTest {
    static PointsCatalogPage pointsCatalogPage;
    @BeforeAll
    public static void initializePointsCatalogPage() {
        pointsCatalogPage = new PointsCatalogPage();
    }

    @Test
    public void pointsCatalogPageTest() {
        pointsCatalogPage.navigateToPointsCatalog();
        pointsCatalogPage.locateAndClickTurkishClassics();
        
        ProductPage productPage = new ProductPage();
        productPage.selectSortingType("Yüksek Oylama");   
        pointsCatalogPage.locateAllBooksDropdown(); 
        pointsCatalogPage.addToCartRandomProduct();   
    }
}
