package TestScenarios;

import Objects.GoogleSearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.CommonMethods;

public class TestMethods_GoogleSearch {
    WebDriver driver;
    CommonMethods commonMethods = new CommonMethods();

    @BeforeTest
    public void beforeTest() {
        driver = commonMethods.openChrome("https://www.google.com/", driver);
    }

    @Test
    public void searchTest() {
        GoogleSearchPage gPage = new GoogleSearchPage(driver);
        gPage.acceptPopup();
        gPage.setSearchBox("facebook");

    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
