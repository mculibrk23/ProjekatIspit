package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SummationOfPrices {

    public WebDriver driver;

    public By sauceLabsBackPack = By.id("add-to-cart-sauce-labs-backpack");

    public By sauceLabsBikeLight = By.id("add-to-cart-sauce-labs-bike-light");

    public By sauceLabsBoltTShirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");

    public By cart = By.id("shopping_cart_container");

    public By checkout = By.id("checkout");

    public By firstNameInputField = By.id("first-name");

    public By lastNameInputField = By.id("last-name");

    public By zipCodeInputField = By.id("postal-code");

    public By continueButton = By.id("continue");


    public SummationOfPrices(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnAddToCart() {
        driver.findElement(sauceLabsBackPack).click();
    }

    public void clickOnAddToCart2() {
        driver.findElement(sauceLabsBikeLight).click();
    }

    public void clickOnAddToCart3() {
        driver.findElement(sauceLabsBoltTShirt).click();
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
    }

    public void enterZipCode(Integer numberToEnterZipCodeToInputField) {
        driver.findElement(zipCodeInputField).sendKeys(numberToEnterZipCodeToInputField.toString());
    }

    public void clickOnContinue() {
        driver.findElement(continueButton).click();
    }

    public Float getTotalPrice() {
        float ukupnaCena = 0;
        String cena = driver.findElement(By.className("summary_subtotal_label")).getText().substring(13);
        ukupnaCena = Float.parseFloat(cena);
        System.out.println("Cena sa sajta: " + ukupnaCena);

        return ukupnaCena;
    }

    public Float calculatePrices() {

        List<WebElement> priceList = driver.findElements(By.className("inventory_item_price"));

        float ukupnaCena = 0;

        //Prolazak kroz veb elemente, uzimanje teksta i skidanje "$" znaka, parsiranje u float i dodavanje na ukupnu cenu
        for (WebElement priceElement : priceList) {
            ukupnaCena +=  Float.parseFloat(priceElement.getText().substring(1));
        }
        System.out.println("Cena nasa: " + ukupnaCena);
        return ukupnaCena;
    }


}


