import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class RunTest {
//    WebDriver driver;
//
//    @BeforeMethod
//    public void setup() {
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("start-maximized");
//        driver = new ChromeDriver(chromeOptions);
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }
//
//    @Test
//    public void chouldOpenGoogle() {
//        driver.get("https://google.com");
//    }
//}
