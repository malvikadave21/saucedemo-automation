package com.malvika.tests;

import org.testng.annotations.Test;
import com.malvika.pages.LoginPage;
import com.malvika.base.BaseTest;


public class LoginTest extends BaseTest {
    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
    }
}
