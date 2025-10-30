package com.malvika.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By pageTitle = By.className("title");
    private By firstProductAddToCart = By.xpath("(//button[contains(text(),'Add to cart')])[1]");
    private By cartIcon = By.className("shopping_cart_link");
    private By cartPageTitle = By.xpath("//span[text()='Your Cart']");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ✅ Get the title of the page
    public String getPageTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).getText();
    }

    // ✅ Used in ProductsTest.java
    public void addFirstProductToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(firstProductAddToCart)).click();
    }

    // ✅ Used in ProductsTest.java
    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();

        // ✅ Wait for URL or cart title (whichever comes first)
        try {
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.urlContains("cart.html"),
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Your Cart')]"))
            ));
        } catch (Exception e) {
            System.out.println("⚠️ Cart page took too long to load. Current URL: " + driver.getCurrentUrl());
        }
    }

    // ✅ Used in CartTest.java
    public void addProductToCart(String productName) {
        String formattedName = productName.toLowerCase().replace(" ", "-");
        By addToCartButton = By.id("add-to-cart-" + formattedName);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    // ✅ Used in CartTest.java
    public void clickCartIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartPageTitle));
    }
}
