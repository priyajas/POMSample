package reports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.*;

import java.io.IOException;

public class ExtentManager {
    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;

    public static void setExtent() throws IOException {
        sparkReporter = new ExtentSparkReporter(
                System.getProperty("user.dir") + "/src/test/java/test-output/"
                        + "TestExecutionReport"
                        + ".html");
        sparkReporter.loadXMLConfig(System.getProperty("user.dir") +"/src/test/java/reports/extent-config.xml");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    public static void endReport() {
        extent.flush();
    }
}
