package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HYRTutorialsPage {
    WebDriver driver;
    By emailFollowingSibling = By.xpath("//label[text()='Email']/following-sibling::input[1]");
    By formDivParentSample = By.xpath("//label[text()='Email']/parent::div");
    By firstNameChildSample = By.xpath("//div[@class='container']/child::input[1]");
    By checkBoxPrecedingSiblingSample = By.xpath("//td[text()='Maria Anders']/preceding-sibling::td/child::input");


    public HYRTutorialsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(emailFollowingSibling).sendKeys(email);
    }

    public void enterFirstName(String name) {
        driver.findElement(firstNameChildSample).sendKeys(name);
    }

    public void clickCheckbox() {
        driver.findElement(checkBoxPrecedingSiblingSample).click();
    }

}
