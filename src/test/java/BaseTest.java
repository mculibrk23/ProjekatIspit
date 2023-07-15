import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseTest {
    public static WebDriver driver;


    // Otvara edge
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }


    //Zatvara edge
    @AfterClass
    public static void afterClass() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }

}
