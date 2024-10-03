package TestScenarios;

import Objects.GoogleSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestMethods_GoogleSearch {
    WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com/");
    }

    @Test
    public void searchTest() {
        GoogleSearchPage gpage = new GoogleSearchPage(driver);
        gpage.acceptPopup();
        gpage.setSearchBox("facebook");

    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
