package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class CommonMethods {
    protected static WebDriver driver;

    public WebDriver openChrome(String url, WebDriver driver) {
        this.driver = driver;
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        return driver;
    }

    public int findFramesCount(WebDriver driver) {
        return driver.findElements(By.tagName("iframe")).size();
    }

    public void switchToDefault(WebDriver driver) {
        driver.switchTo().defaultContent();
    }


    public void switchFrameByIndex(WebDriver driver, int frameIndex) {
        driver.switchTo().frame(frameIndex);
    }

    public void switchFrameByID(WebDriver driver, String frameId) {
        driver.switchTo().frame(frameId);
    }

    public void switchFrameByWebElement(WebDriver driver, By frameElement) {
        WebElement frameToSwitch = driver.findElement(frameElement);
        driver.switchTo().frame(frameToSwitch);
    }


    public void handleWindow(WebDriver driver, By sampleHeading) {
        //Get handles of the windows
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                WebElement text = driver.findElement(sampleHeading);
                System.out.println("Heading of child window is " + text.getText());
            }
        }
        driver.switchTo().defaultContent();//  Switch back to the main page if there are multiple windows open
        // (Above method switches the control to main web page regardless of the number of frames within the web page)
        System.out.println("Window Title" + driver.getTitle());
        // driver.switchTo().frame(mainWindowHandle);//  Switch back to the main window which is the parent window.
        //(Above method switches the control to parent frame of current frame)
        /*Example
        Lets understand it:

        main body
        {
            frame1
            {
                frame2
                frame3(we are here currently)
            }
        }
        Now using driver.switchTo().defaultContent();
        will pass the control to main body

        And using driver.switchTo().parentFrame();
        will pass the control to frame1 .
         */
    }
}
