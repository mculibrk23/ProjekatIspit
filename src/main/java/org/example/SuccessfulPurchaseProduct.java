package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessfulPurchaseProduct {
    public WebDriver driver;

    public By sauceLabsBackPack = By.id("add-to-cart-sauce-labs-backpack");

    public By cart = By.id("shopping_cart_container");

    public By checkout = By.id("checkout");

    public By firstNameInputField = By.id("first-name");

    public By lastNameInputField = By.id("last-name");

    public By zipCodeInputField = By.id("postal-code");

    public By continueButton = By.id("continue");

    public By finishButton = By.id("finish");

    public By errorMessage = By.id("back-to-products");

    public SuccessfulPurchaseProduct(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnAddToCart() {
        driver.findElement(sauceLabsBackPack).click();
    }

    public void clickOnTheCart() {
        driver.findElement(cart).click();
    }

    public void clickOnCheckout() {
        driver.findElement(checkout).click();
    }

    public void enterFirstName(String textToEnterFirstNameToInputField) {
        driver.findElement(firstNameInputField).sendKeys(textToEnterFirstNameToInputField);
    }

    public void enterLastName(String textToEnterLastNameToInputField) {
        driver.findElement(lastNameInputField).sendKeys(textToEnterLastNameToInputField);
        ;
    }

    public void enterZipCode(Integer numberToEnterZipCodeToInputField) {
        driver.findElement(zipCodeInputField).sendKeys(numberToEnterZipCodeToInputField.toString());
    }

    public void clickOnContinue() {
        driver.findElement(continueButton).click();
    }

    public void clickOnFinish() {
        driver.findElement(finishButton).click();
    }


}