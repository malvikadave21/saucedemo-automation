package com.malvika.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutOverviewPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By finishButton = By.id("finish");
    private By completeHeader = By.className("complete-header"); // Appears after finishing order

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ✅ Click Finish button
    public void clickFinish() {
        wait.until(ExpectedConditions.elementToBeClickable(finishButton)).click();
    }

    // ✅ Verify order complete
    public boolean isOrderComplete() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(completeHeader));
        return driver.getCurrentUrl().contains("checkout-complete");
    }
}
