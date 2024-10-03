package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {
    WebDriver driver;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    By searchBox = By.xpath("//*[@name='q']");
    By popup = By.xpath("//button[contains(text(),'Stay signed out')]");
    By popupFrame = By.name("callout");

    public void setSearchBox(String searchText) {
        driver.findElement(searchBox).sendKeys(searchText);
    }
    public void acceptPopup() {
        if(driver.findElements(popupFrame).size()>0){
            driver.switchTo().frame(driver.findElement(popupFrame));
            driver.findElement(popup).click();
            driver.switchTo().defaultContent();
        }
    }


}
