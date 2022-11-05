package com.testinium.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.testinium.pages.ProductPage;

public class ProductPageTest extends LoginPageTest {
    static ProductPage productPage;
    static final String keyword = "Oyuncak";
    @BeforeAll
    public static void initializeProductPage() {
        productPage = new ProductPage();
    }

    @Test
    public void searchKeywordTest() {
        productPage.searchKeyword(keyword);
        // index starts from 1, locates 7th element
        productPage.locateAndScrollNthProduct(7);
        // 
        productPage.selectNProducts(4); 
        productPage.navigateToHomePage();     
    }

}
