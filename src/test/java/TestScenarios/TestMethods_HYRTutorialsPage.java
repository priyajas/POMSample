package TestScenarios;

import Objects.HYRTutorialsPage;
import Objects.ToolsQAPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.CommonMethods;

public class TestMethods_HYRTutorialsPage {
    WebDriver driver;
    CommonMethods commonMethods = new CommonMethods();

    @BeforeTest
    public void beforeTest() {
        driver = commonMethods.openChrome("https://www.hyrtutorials.com/p/add-padding-to-containers.html", driver);
    }

    @Test
    public void testXPathElements() {
        HYRTutorialsPage hyrPage = new HYRTutorialsPage(driver);
        hyrPage.enterEmail("a@b.com");
        hyrPage.enterFirstName("test");
        hyrPage.clickCheckbox();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
