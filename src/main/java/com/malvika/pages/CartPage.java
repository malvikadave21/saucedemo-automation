package com.malvika.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By cartItemName = By.className("inventory_item_name");
    private By checkoutButton = By.id("checkout");
    private By checkoutPageTitle = By.xpath("//span[text()='Checkout: Your Information']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getProductNameInCart() {
        WebElement productElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cartItemName));
        return productElement.getText();
    }

    public boolean isProductInCart(String expectedProductName) {
        String actualProduct = getProductNameInCart();
        return actualProduct.equalsIgnoreCase(expectedProductName);
    }

    // ✅ ADD THIS METHOD
    public void clickCheckout() {
        WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        checkoutBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutPageTitle));
    }

    public boolean isCheckoutPageOpened() {
        wait.until(ExpectedConditions.urlContains("checkout-step-one"));
        return driver.getCurrentUrl().contains("checkout-step-one");
    }
}
