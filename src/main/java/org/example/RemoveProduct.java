package org.example;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RemoveProduct {

    public WebDriver driver;

    public By sauceLabsOnesie = By.id("add-to-cart-sauce-labs-onesie");

    public By testAllTheThings = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");

    public By cart = By.id("shopping_cart_container");

    public By removeSauceLabsOnesie = By.id("remove-sauce-labs-onesie");


    public RemoveProduct(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnTheAddToCart() {
        driver.findElement(sauceLabsOnesie).click();
    }

    public void clickOnTheAddToCart2() {
        driver.findElement(testAllTheThings).click();
    }

    public void clickOnTheCart() {
        driver.findElement(cart).click();
    }

    public void clickOnTheRemove() {
        driver.findElement(removeSauceLabsOnesie).click();
    }

    public List<String> cartContentsOriginal() {

        List<WebElement> cartItemsWeb = driver.findElements(By.className("inventory_item_name"));

        List<String> cartItems = new ArrayList<>();

        for (WebElement cartElement : cartItemsWeb) {
            cartItems.add(cartElement.getText());
        }

        return cartItems;
    }

    public List<String> cartContentsAfterRemove() {

        List<WebElement> cartItemsWeb = driver.findElements(By.className("inventory_item_name"));

        List<String> cartItems = new ArrayList<>();

        for (WebElement cartElement : cartItemsWeb) {
            cartItems.add(cartElement.getText());
        }

        return cartItems;
    }


}