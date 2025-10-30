package com.malvika.tests;

import com.malvika.base.BaseTest;
import com.malvika.pages.LoginPage;
import com.malvika.pages.ProductsPage;
import com.malvika.pages.LogoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test
    public void testLogout() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.getPageTitle(), "Products");

        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.logout();

        Thread.sleep(2000);
        Assert.assertTrue(logoutPage.isLoggedOut(), "❌ Logout failed!");
    }
}
