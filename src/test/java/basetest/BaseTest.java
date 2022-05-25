package basetest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    static WebDriver driver;
    static Actions as;

    @BeforeMethod
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        as = new Actions(driver);

        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
        System.out.println(browserName);
        String os = cap.getPlatform().toString();
        System.out.println(os);
        String v = cap.getVersion().toString();
        System.out.println(v);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/droppable/");
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static Actions getAs() {
        return as;
    }

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }
}
