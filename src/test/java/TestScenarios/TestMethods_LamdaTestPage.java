package TestScenarios;

import Objects.LamdaTestPage;
import Objects.ToolsQAPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.CommonMethods;
import util.DropDownCommonMethods;

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
    }
    @Test(priority = 0)
    public void selectMultipleDropDownValue() {
        lamdaTestPage = new LamdaTestPage(driver);
        dropDownCommonMethods.selectByIndex(lamdaTestPage.returnMultiSelect(), 1);
        dropDownCommonMethods.selectByValue(lamdaTestPage.returnMultiSelect(), "Ohio");
        dropDownCommonMethods.selectByVisibleText(lamdaTestPage.returnMultiSelect(), "California");
        System.out.println("All selected values :" + dropDownCommonMethods.getSelectedOptionsDropDown(lamdaTestPage.returnMultiSelect()));
        dropDownCommonMethods.deselectValueFromDropDown(lamdaTestPage.returnMultiSelect());
        System.out.println("All selected values :" + dropDownCommonMethods.getSelectedOptionsDropDown(lamdaTestPage.returnMultiSelect()));
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
