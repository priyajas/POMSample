package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LamdaTestPage {
    WebDriver driver;
    By singleSelect = By.id("select-demo");
    By multiSelect = By.id("multi-select");

    public LamdaTestPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement returnSingleSelect() {
       return driver.findElement(singleSelect);
    }
    public WebElement returnMultiSelect() {
        return driver.findElement(multiSelect);
    }


}
