import org.example.LogInPage;
import org.example.ProductSelectionToTheCart;
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


public class ProductSelectionToTheCartTest extends BaseTest {

    ProductSelectionToTheCart productSelectionToTheCart = new ProductSelectionToTheCart(driver);
    LogInPage logInPage = new LogInPage(driver);

    @BeforeClass
    public static void setup() throws Exception {
        driver.get("https://www.saucedemo.com/");
    }


    @Test
    public void testProductSelectionToTheCart() throws InterruptedException {

        logInPage.enterUserName("standard_user");
        logInPage.enterPassword("secret_sauce");
        logInPage.clickOnlOgInButton();
        productSelectionToTheCart.clickOnAddToCart();
        productSelectionToTheCart.clickOnAddToCart2();
        productSelectionToTheCart.clickOnTheCart();
        List<String> items = productSelectionToTheCart.cartContents();
        String desiredProduct1 = "Sauce Labs Bolt T-Shirt";
        String desiredProduct2 = "Sauce Labs Fleece Jacket";
        Assert.assertTrue("Cart inventory doesnt match with products you picked!", items.contains(desiredProduct1) && items.contains(desiredProduct2));


    }
}