package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SocialsFooter {

    public WebDriver driver;

    //Uzimanje socials ikonica po href atributu
    public By socialsList_twitter = By.cssSelector("a[href='https://twitter.com/saucelabs']");

    public By socialsList_facebook = By.cssSelector("a[href='https://www.facebook.com/saucelabs']");

    public By socialsList_linkedin = By.cssSelector("a[href='https://www.linkedin.com/company/sauce-labs/']");

    public SocialsFooter(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnTwitter() {
        driver.findElement(socialsList_twitter).click();
    }

    public void clickOnFacebook() {
        driver.findElement(socialsList_facebook).click();
    }

    public void clickOnLinkedin() {
        driver.findElement(socialsList_linkedin).click();
    }


}
