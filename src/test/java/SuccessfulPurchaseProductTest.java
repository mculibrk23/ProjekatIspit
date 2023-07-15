import org.example.LogInPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.example.SuccessfulPurchaseProduct;
import org.example.LogInPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SuccessfulPurchaseProductTest extends BaseTest {

    SuccessfulPurchaseProduct successfulPurchaseProduct = new SuccessfulPurchaseProduct(driver);
    LogInPage logInPage = new LogInPage(driver);


    @Before
    public void setup() throws Exception {
        driver.get("https://www.saucedemo.com/");
        logInPage.enterUserName("standard_user");
        logInPage.enterPassword("secret_sauce");
        logInPage.clickOnlOgInButton();
    }


    @Test
    public void testSuccessfulProductPurchase() throws InterruptedException {

        successfulPurchaseProduct.clickOnAddToCart();

        successfulPurchaseProduct.clickOnTheCart();

        successfulPurchaseProduct.clickOnCheckout();

        successfulPurchaseProduct.enterFirstName("Milica");

        successfulPurchaseProduct.enterLastName("Culibrk");

        successfulPurchaseProduct.enterZipCode(11090);

        successfulPurchaseProduct.clickOnContinue();

        successfulPurchaseProduct.clickOnFinish();

        String desiredErrorMessage = "https://www.saucedemo.com/checkout-complete.html";

        String realErrorMessage = driver.getCurrentUrl();

        Assert.assertTrue("Kupovina nije uspesna!", desiredErrorMessage.equals(realErrorMessage));


    }

}