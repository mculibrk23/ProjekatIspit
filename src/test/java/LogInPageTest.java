import org.apache.commons.logging.Log;
import org.example.LogInPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;

public class LogInPageTest extends BaseTest {

    LogInPage logInPage = new LogInPage(driver);

    @Before
    public void setup() throws Exception {
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void testLogInWithInvalidUserNamePassword() throws InterruptedException {
        logInPage.enterUserName("standard_user3");
        logInPage.enterPassword("secret_sauce3");
        logInPage.clickOnlOgInButton();

        Thread.sleep(5000);
        String desireErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String realErrorMessage = logInPage.getErrorMessage();
        Assert.assertTrue("Ne izlazi dobra poruka za logovanje sa invalid username and password", desireErrorMessage.equals(realErrorMessage));
    }

    @Test
    public void testLogInWithValidUserNamePassword() throws InterruptedException {

        logInPage.enterUserName("standard_user");
        logInPage.enterPassword("secret_sauce");
        logInPage.clickOnlOgInButton();
        Thread.sleep(5000);
        String desiredErrorMessage = "https://www.saucedemo.com/inventory.html";
        String realErrorMessage = driver.getCurrentUrl();
        Assert.assertTrue("User nije ulogovan", desiredErrorMessage.equals(realErrorMessage));
        //driver.quit();
    }

    @Test
    public void testLogInWithInvalidUserNameAndCorrectPassword() throws InterruptedException {
        logInPage.enterUserName("standard_user4");
        logInPage.enterPassword("secret_sauce");
        logInPage.clickOnlOgInButton();
        Thread.sleep(5000);
        String desireErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String realErrorMessage = logInPage.getErrorMessage();
        Assert.assertTrue("Ne izlazi dobra poruka za logovanje sa invalid username and valid password", desireErrorMessage.equals(realErrorMessage));
    }

    @Test
    public void testLogInWithCorrectUserNameAndInCorrectPassword() throws InterruptedException {
        logInPage.enterUserName("standard_user");
        logInPage.enterPassword("secret_sauce6");
        logInPage.clickOnlOgInButton();
        Thread.sleep(5000);
        String desireErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String realErrorMessage = logInPage.getErrorMessage();
        Assert.assertTrue("Ne izlazi dobra poruka za logovanje sa valid username and invalid password", desireErrorMessage.equals(realErrorMessage));
    }

    @Test
    public void testLogInWithEmptyUserNameAndPassword() throws InterruptedException {
        logInPage.enterUserName("");
        logInPage.enterPassword("");
        logInPage.clickOnlOgInButton();
        Thread.sleep(5000);
        String desireErrorMessage = "Epic sadface: Username is required";
        String realErrorMessage = logInPage.getErrorMessage();
        Assert.assertTrue("Ne izlazi dobra poruka za logovanje sa praznim username-om i password-om", desireErrorMessage.equals(realErrorMessage));
    }


}

