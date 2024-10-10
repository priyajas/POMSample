package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pojo.TestData;
import reports.ExtentManager;
import util.CommonMethods;
import util.ExcelUtil;
import util.JsonDataReader;

import java.io.IOException;
import java.time.Duration;

public class TestBaseClass extends ExcelUtil {

    // Using ThreadLocal to store WebDriver instance for each thread (test case)
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected static String[][] testData;
    // Initialize the JsonDataReader with the path to the JSON file
    JsonDataReader jsonDataReader = new JsonDataReader("C:\\Users\\Priya\\IdeaProjects\\POMDemoSample\\src\\test\\java\\testdata\\jsontestdata.json");
    // Get the TestData object from the JsonDataReader
    TestData jsonTestData = jsonDataReader.getTestData();
    // Read values from the TestData object
    String browser = jsonTestData.getBrowser();
    String url = jsonTestData.getUrl();
    String username = jsonTestData.getCredentials().getUsername();
    String password = jsonTestData.getCredentials().getPassword();

    static {
        String filePath = "C:\\Users\\Priya\\IdeaProjects\\POMDemoSample\\src\\test\\java\\testdata\\testdata.xlsx";
        String sheetName = "UserDetail";

        try {
            // Read Excel data and store it in the static 2D array
            testData = ExcelUtil.readExcelData(filePath, sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Optional: Static utility method to get data from a specific cell (row, column)
    protected static String getData(int row, int column) {
        return testData[row][column];
    }

    @BeforeSuite
    public void beforeSuite() throws IOException {
        ExtentManager.setExtent();
    }

    @BeforeMethod
    public void setUp() {
        //driver = commonMethods.openChrome("https://www.google.cocm/", driver);
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());  // Create WebDriver instance for this thread
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println(browser +  url+  username+  password);
    }

    @AfterMethod
    public void tearDown() {
        // Close and clean up the WebDriver instance
        getDriver().quit();
        driver.remove();
    }

    public WebDriver getDriver() {
        // Return the driver for the current thread
        return driver.get();
    }

    @AfterSuite
    public void afterSuite() {
        ExtentManager.endReport();
    }
}
