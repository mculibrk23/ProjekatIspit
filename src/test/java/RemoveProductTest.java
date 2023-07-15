import org.example.LogInPage;
import org.example.RemoveProduct;
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
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RemoveProductTest extends BaseTest {

    RemoveProduct removeProduct = new RemoveProduct(driver);

    LogInPage logInPage = new LogInPage(driver);

    @BeforeClass
    public static void setup() throws Exception {
        driver.get("https://www.saucedemo.com/");
    }


    @Test
    public void testRemoveProduct() throws InterruptedException {
        logInPage.enterUserName("standard_user");
        logInPage.enterPassword("secret_sauce");
        logInPage.clickOnlOgInButton();

        removeProduct.clickOnTheAddToCart();
        removeProduct.clickOnTheAddToCart2();
        removeProduct.clickOnTheCart();

        List<String> original = removeProduct.cartContentsOriginal();
        removeProduct.clickOnTheRemove();
        List<String> afterRemove = removeProduct.cartContentsAfterRemove();

        original.removeAll(afterRemove);
        String desiredProductMissing = "Sauce Labs Onesie";

        Assert.assertTrue("Nije uspesno izbrisan proizvod iz korpe!", original.contains(desiredProductMissing));

    }


}