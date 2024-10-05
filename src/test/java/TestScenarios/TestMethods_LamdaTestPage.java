package TestScenarios;

import Objects.GoogleSearchPage;
import Objects.ToolsQAPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.CommonMethods;

public class TestMethods_ToolsQAPage {
    WebDriver driver;
    CommonMethods commonMethods = new CommonMethods();

    @BeforeTest
    public void beforeTest() {
        driver = commonMethods.openChrome("https://demoqa.com/browser-windows", driver);
    }

    @Test
    public void openChildWindow() {
        ToolsQAPage toolsPage = new ToolsQAPage(driver);
        toolsPage.clickWindowButton();
        commonMethods.handleWindow(driver, toolsPage.handleWebElement());

    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
