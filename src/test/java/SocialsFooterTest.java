import org.example.LogInPage;
import org.example.SocialsFooter;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Set;

public class SocialsFooterTest extends BaseTest {


    SocialsFooter socialsFooter = new SocialsFooter(driver);
    LogInPage logInPage = new LogInPage(driver);

    @BeforeClass
    public static void setup() throws Exception {
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void testClickFacebook() throws InterruptedException {

        logInPage.enterUserName("standard_user");
        logInPage.enterPassword("secret_sauce");
        logInPage.clickOnlOgInButton();

        socialsFooter.clickOnFacebook();


        //Pocetni tab u browseru
        String originalWindowHandle = driver.getWindowHandle();

        //Uzima sve otvorene tabove
        Set<String> windowHandles = driver.getWindowHandles();

        //Prolazi kroz sve tabove
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(originalWindowHandle)) {
                //Ako nije isti kao originalni tab prelazi na nov
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        String desiredURL = "https://www.facebook.com/saucelabs";
        String realURL = driver.getCurrentUrl();

        try {
            Assert.assertTrue("Korisnik je odveden na pogresan link", desiredURL.equals(realURL));
        } catch (AssertionError e) {
            System.out.println("Assertion failed: " + e.getMessage());
        }

        //Zatvaranje novog taba
        driver.close();
        //Vracanje na originalni tab
        driver.switchTo().window(originalWindowHandle);

    }

    @Test
    public void testClickLinkedin() throws InterruptedException {

        socialsFooter.clickOnLinkedin();

        String originalWindowHandle = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(originalWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        String desiredURL = "https://www.linkedin.com/";
        String realURL = driver.getCurrentUrl();

        try {
            Assert.assertTrue("Korisnik je odveden na pogresan link", realURL.startsWith(desiredURL));
        } catch (AssertionError e) {
            System.out.println("Assertion failed: " + e.getMessage());
        }

        driver.close();
        driver.switchTo().window(originalWindowHandle);
    }

    @Test
    public void testClickTwitter() throws InterruptedException {

        socialsFooter.clickOnTwitter();

        String originalWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(originalWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        String desiredURL = "https://twitter.com/i/flow/login?redirect_after_login=%2Fsaucelabs";
        String realURL = driver.getCurrentUrl();
        try {
            Assert.assertTrue("Korisnik je odveden na pogresan link", desiredURL.equals(realURL));
        } catch (AssertionError e) {
            System.out.println("Assertion failed: " + e.getMessage());
        }

        driver.close();
        driver.switchTo().window(originalWindowHandle);

    }
}
