package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import reports.ExtentManager;
import util.CommonMethods;

import java.io.IOException;
import java.time.Duration;

public class TestBaseClass {

    // Using ThreadLocal to store WebDriver instance for each thread (test case)
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeSuite
    public void beforeSuite() throws IOException {
        ExtentManager.setExtent();
    }
    @BeforeMethod
    public void setUp() {
        //driver = commonMethods.openChrome("https://www.google.cocm/", driver);
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());  // Create WebDriver instance for this thread
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        // Close and clean up the WebDriver instance
        getDriver().quit();
        driver.remove();
    }

    public WebDriver getDriver() {
        // Return the driver for the current thread
        return driver.get();
    }

    @AfterSuite
    public void afterSuite() {
        ExtentManager.endReport();
    }
}
