package TestScenarios;

import Objects.LamdaTestPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.CommonMethods;
import util.DropDownCommonMethods;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestMethods_LamdaTestPage {
    WebDriver driver;
    DropDownCommonMethods dropDownCommonMethods = new DropDownCommonMethods();
    CommonMethods commonMethods = new CommonMethods();
    LamdaTestPage lamdaTestPage;

    @BeforeTest
    public void beforeTest() {
        driver = commonMethods.openChrome("https://www.lambdatest.com/selenium-playground/select-dropdown-demo", driver);
    }

    @Test(priority = 0)
    public void selectSingleDropDownValue() {
        lamdaTestPage = new LamdaTestPage(driver);
        //Explicit wait to wait for select dropdown to appear before executing next command
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(lamdaTestPage.returnSingleSelect()));
        dropDownCommonMethods.selectByIndex(lamdaTestPage.returnSingleSelect(), 1);
        System.out.println("Selected Value :" + dropDownCommonMethods.getFirstSelectedText(lamdaTestPage.returnSingleSelect()));
        dropDownCommonMethods.selectByValue(lamdaTestPage.returnSingleSelect(), "Monday");
        System.out.println("Selected Value :" + dropDownCommonMethods.getFirstSelectedText(lamdaTestPage.returnSingleSelect()));
        dropDownCommonMethods.selectByVisibleText(lamdaTestPage.returnSingleSelect(), "Tuesday");
        System.out.println("Selected Value :" + dropDownCommonMethods.getFirstSelectedText(lamdaTestPage.returnSingleSelect()));
    }

    @Test(description = "Select 2nd last value from dropdown list when list count is dynamic", priority = 1)
    public void selectSecondLastValue() {
        int optionsCount = dropDownCommonMethods.getAllOptionsCountDropDown(lamdaTestPage.returnSingleSelect());
        dropDownCommonMethods.selectByIndex(lamdaTestPage.returnSingleSelect(), optionsCount - 2);
        System.out.println("Selected Value :" + dropDownCommonMethods.getFirstSelectedText(lamdaTestPage.returnSingleSelect()));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(dropDownCommonMethods.getSelectedOptionsDropDown(lamdaTestPage.returnSingleSelect()).contains("Monday"));
        softAssert.assertTrue(dropDownCommonMethods.getSelectedOptionsDropDown(lamdaTestPage.returnSingleSelect()).contains("Friday"));
        softAssert.assertAll();
    }
    @Test(priority = 0)
    public void selectMultipleDropDownValue() {
        lamdaTestPage = new LamdaTestPage(driver);
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(lamdaTestPage.returnMultiSelect()));
        dropDownCommonMethods.selectByIndex(lamdaTestPage.returnMultiSelect(), 1);
        dropDownCommonMethods.selectByValue(lamdaTestPage.returnMultiSelect(), "Ohio");
        dropDownCommonMethods.selectByVisibleText(lamdaTestPage.returnMultiSelect(), "California");
        System.out.println("All selected values :" + dropDownCommonMethods.getSelectedOptionsDropDown(lamdaTestPage.returnMultiSelect()));
        Assert.assertTrue(dropDownCommonMethods.getSelectedOptionsDropDown(lamdaTestPage.returnMultiSelect()).contains("California"));
        dropDownCommonMethods.deselectValueFromDropDown(lamdaTestPage.returnMultiSelect());
        System.out.println("All selected values :" + dropDownCommonMethods.getSelectedOptionsDropDown(lamdaTestPage.returnMultiSelect()));

    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
