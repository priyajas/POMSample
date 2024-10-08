package TestScenarios;

import Objects.GoogleSearchPage;
import config.TestBaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import util.CommonMethods;

public class TestMethods_GoogleSearch extends TestBaseClass {
    WebDriver driver;
    CommonMethods commonMethods = new CommonMethods();
    TestBaseClass baseClass = new TestBaseClass();

    @BeforeMethod
    public void beforeTest() {
        driver = baseClass.getDriver();
        driver.get("https://www.google.com/");
        //driver = commonMethods.openChrome("https://www.google.com/", driver);
    }

    @Test
    public void searchTest() {
        GoogleSearchPage gPage = new GoogleSearchPage(driver);
        gPage.acceptPopup();
        gPage.setSearchBox("facebook");

    }
    @Test
    public void searchTest1() {
        GoogleSearchPage gPage = new GoogleSearchPage(driver);
        gPage.acceptPopup();
        gPage.setSearchBox("facebooksdsf");

    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
