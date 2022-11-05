package com.testinium.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.testinium.pages.ShoppingCartPage;

public class ShoppingCartPageTest extends LoginPageTest {
    static ShoppingCartPage shoppingCartPage;

    @BeforeAll
    public static void initializeShoppingCartPageTest() {
        shoppingCartPage = new ShoppingCartPage();
    }

    @Test
    public void shoppingCartPageTest() {
        shoppingCartPage.navigateToShoppingCart();
        shoppingCartPage.increaseItemQuantity();
        shoppingCartPage.updateItemQuantity();
        shoppingCartPage.checkoutPage();
        shoppingCartPage.addAddress();
        shoppingCartPage.skipShipping();
        shoppingCartPage.addCreditCardAndCheckOut();
    }
}
