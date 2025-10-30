package com.malvika.tests;

import com.malvika.base.BaseTest;
import com.malvika.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void testProductInCartAndCheckout() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        MenuPage menuPage = new MenuPage(driver); // ✅ if you have this page

        // Step 1: Login
        loginPage.login("standard_user", "secret_sauce");

        // Step 2: Add a product and open cart
        productsPage.addProductToCart("Sauce Labs Backpack");
        Thread.sleep(1000);
        productsPage.openCart();

        // Step 3: Verify product in cart
        Assert.assertTrue(cartPage.isProductInCart("Sauce Labs Backpack"));

        // Step 4: Checkout
        cartPage.clickCheckout();
        checkoutPage.fillCheckoutForm("John", "Doe", "12345");
        Thread.sleep(3000);
        checkoutPage.clickContinue();
        checkoutPage.clickFinish();

        // Step 5: Verify Thank You page
        Assert.assertTrue(checkoutPage.isThankYouMessageDisplayed());

        // ✅ Step 6: Logout (AFTER success)
        menuPage.clickLogout();
    }
}
