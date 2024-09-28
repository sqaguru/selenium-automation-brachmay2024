package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentManager {
    private static ExtentReports extent;
    public static String reportFolder = System.getProperty("user.dir") + File.separator + "test-result";

    public synchronized static ExtentReports getInstance() {
        if (extent == null) {
            File testResultDir = new File(reportFolder);
            // If the folder doesn't exist, create it
            if (!testResultDir.exists()) {
                testResultDir.mkdir();
            }

            // Initialize ExtentSparkReporter (HTML report)
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportFolder + File.separator + "extent-report.html");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
        return extent;
    }
}