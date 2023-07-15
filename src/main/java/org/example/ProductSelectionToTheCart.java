package org.example;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

import java.util.List;

public class ProductSelectionToTheCart {

    public WebDriver driver;

    public By sauceLabsBoltTShirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");

    public By sauceLabsFleeceJacket = By.id("add-to-cart-sauce-labs-fleece-jacket");

    public By cart = By.id("shopping_cart_container");

    public ProductSelectionToTheCart(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnAddToCart() {
        driver.findElement(sauceLabsBoltTShirt).click();
    }

    public void clickOnAddToCart2() {
        driver.findElement(sauceLabsFleeceJacket).click();
    }

    public void clickOnTheCart() {
        driver.findElement(cart).click();
    }

    public List<String> cartContents() {

        List<WebElement> cartItemsWeb = driver.findElements(By.className("inventory_item_name"));

        List<String> cartItems = new ArrayList<>();

        for (WebElement cartElement : cartItemsWeb) {
            cartItems.add(cartElement.getText());
        }

        return cartItems;
    }


}
