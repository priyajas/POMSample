package TestScenarios;

import Objects.ToolsQAPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.CommonMethods;

public class TestMethods_IFrames {
    WebDriver driver;
    CommonMethods commonMethods = new CommonMethods();

    @BeforeTest
    public void beforeTest() {
        driver = commonMethods.openChrome("https://demoqa.com/frames", driver);
    }

    @Test(priority = 0)
    public void handleFrameByIndex() {
        commonMethods.switchFrameByIndex(driver,0);
        System.out.println(driver.getPageSource());
        commonMethods.switchToDefault(driver);

    }
    @Test(priority = 1)
    public void handleFrameByID() {
        commonMethods.switchFrameByID(driver,"frame1");
        System.out.println(driver.getPageSource());
        commonMethods.switchToDefault(driver);

    }
    @Test(priority = 1)
    public void handleFrameByWebElement() {
        ToolsQAPage toolsQAPage = new ToolsQAPage(driver);
        commonMethods.switchFrameByWebElement(driver,toolsQAPage.findFrameWebElement());
        System.out.println(driver.getPageSource());
        commonMethods.switchToDefault(driver);

    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}

