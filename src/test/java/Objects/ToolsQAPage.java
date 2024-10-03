package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ToolsQAPage {
    WebDriver driver;
    By windowBtn = By.id("windowButton");
    By sampleHeading = By.id("sampleHeading");

    public ToolsQAPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickWindowButton() {
        driver.findElement(windowBtn).click();
    }

    public By handleWebElement() {
        return sampleHeading;
    }
}
