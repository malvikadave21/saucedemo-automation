package com.malvika.tests;

import com.malvika.base.BaseTest;
import com.malvika.pages.LoginPage;
import com.malvika.pages.ProductsPage;
import com.malvika.pages.CartPage;
import com.malvika.pages.CheckoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void testCheckoutInformation() throws InterruptedException {
        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(2000); // 👀 Wait 2 seconds

        // Step 2: Add product to cart
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addProductToCart("Sauce Labs Backpack");
        Thread.sleep(2000); // 👀 Wait to see product added
        productsPage.clickCartIcon();
        Thread.sleep(2000); // 👀 Wait to see cart page open

        // Step 3: Go to cart & click checkout
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();
        Thread.sleep(2000); // 👀 Wait for checkout page

        // Step 4: Fill checkout information
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillCheckoutForm("John", "Doe", "12345");
        Thread.sleep(2000); // 👀 Wait to see overview page load

        // Step 5: Verify overview page opened
        Assert.assertTrue(checkoutPage.isOverviewPageOpened(), "Checkout Overview Page not opened!");
    }
}
