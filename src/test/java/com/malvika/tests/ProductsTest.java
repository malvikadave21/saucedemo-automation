package com.malvika.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.malvika.base.BaseTest;
import com.malvika.pages.LoginPage;
import com.malvika.pages.ProductsPage;

public class ProductsTest extends BaseTest {
    @Test
    public void testAddProductToCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.getPageTitle(), "Products");

        productsPage.addFirstProductToCart();
        productsPage.openCart();

        // ✅ Now it will wait until the cart page is visible
        Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"), "Cart page not opened!");
    }
}
