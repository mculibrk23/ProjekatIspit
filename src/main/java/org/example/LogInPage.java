package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {

    public WebDriver driver;

    public By userNameInputField = By.id("user-name");

    public By passwordInputField = By.id("password");

    public By logInButton = By.id("login-button");

    public By errorMessage2 = By.xpath("//h3[@data-test='error']");


    public By errorMessage = By.xpath("* [text()='Epic sadface: Username and password do not match any user in this service'])");

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserName(String textToEnterToUserNameInputField) {
        driver.findElement(userNameInputField).sendKeys(textToEnterToUserNameInputField);
    }

    public void enterPassword(String textToEnterPasswordInputField) {
        driver.findElement(passwordInputField).sendKeys(textToEnterPasswordInputField);
    }

    public void clickOnlOgInButton() {
        driver.findElement(logInButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage2).getText();
    }
}




