import org.example.LogInPage;
import org.example.SummationOfPrices;
import org.junit.Assert;
import org.junit.BeforeClass;
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

public class SummationOfPricesTest extends BaseTest {

    SummationOfPrices summationOfPrices = new SummationOfPrices(driver);

    LogInPage logInPage = new LogInPage(driver);


    @BeforeClass
    public static void setup() throws Exception {
        driver.get("https://www.saucedemo.com/");
    }


    @Test
    public void testSummationOfPrices() throws InterruptedException {
        logInPage.enterUserName("standard_user");
        logInPage.enterPassword("secret_sauce");
        logInPage.clickOnlOgInButton();
        summationOfPrices.clickOnAddToCart();
        summationOfPrices.clickOnAddToCart2();
        summationOfPrices.clickOnAddToCart3();
        summationOfPrices.clickOnTheCart();
        summationOfPrices.clickOnCheckout();
        summationOfPrices.enterFirstName("Milica");
        summationOfPrices.enterLastName("Culibrk");
        summationOfPrices.enterZipCode(11090);
        summationOfPrices.clickOnContinue();

        float siteCalculatePrice =  summationOfPrices.getTotalPrice();
        float desiredPrice = summationOfPrices.calculatePrices();

        Assert.assertTrue("Price wasnt calculated correctly!", desiredPrice == siteCalculatePrice);

    }

}