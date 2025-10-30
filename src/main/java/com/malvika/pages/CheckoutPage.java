package com.malvika.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By thankYouMessage = By.xpath("//h2[text()='Thank you for your order!']");
    private By overviewTitle = By.xpath("//span[text()='Checkout: Overview']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ✅ Fill checkout form
    public void fillCheckoutForm(String firstName, String lastName, String postalCode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    // ✅ Click Continue button separately (fixes your error)
    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    // ✅ Verify Overview Page is opened
    public boolean isOverviewPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(overviewTitle));
        return driver.getCurrentUrl().contains("checkout-step-two");
    }

    // ✅ Click Finish button
    public void clickFinish() {
        WebElement finishBtn = wait.until(ExpectedConditions.elementToBeClickable(finishButton));
        finishBtn.click();
    }

    // ✅ Verify Thank You page is displayed
    public boolean isThankYouMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(thankYouMessage));
        return driver.findElement(thankYouMessage).isDisplayed();
    }
}
