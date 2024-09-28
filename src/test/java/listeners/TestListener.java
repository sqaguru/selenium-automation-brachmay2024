package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import framework.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentManager;
import utils.XRayAPI;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        // Not required to implement
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush(); // Writes everything to the report
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Create a new test in ExtentReports for each test method
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
        // updateTestResultInJira(result, "EXECUTING");
    }

   
    private void updateTestResultInJira(ITestResult result, String status) {
        Object testClass = result.getInstance();
        String jiraXrayApiToken = BaseTest.jiraXrayApiToken;
        String testExecutionKey = BaseTest.testExecutionKey;
        String jiraTestCaseKey = ((BaseTest) testClass).jiraTestCaseKey;
        // Object jiraTestCaseKey =  result.getAttribute("jiraTestCaseKey");
        


        System.out.println("test004");
        System.out.println(jiraXrayApiToken);
        System.out.println(testExecutionKey);
        System.out.println(jiraTestCaseKey);
        try {
            XRayAPI.updateTestResult(jiraXrayApiToken, testExecutionKey, jiraTestCaseKey, status);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");

        System.out.println("updating jira status: PASSED");
        updateTestResultInJira(result, "PASSED");
        // updateTestResult(String token, String testExecutionKey, String testKey, String status)

    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());

        System.out.println("updating jira status: PASSED");
        updateTestResultInJira(result, "FAILED");

        // Capture screenshot
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();
        if (driver != null) {
            String screenshotPath = captureScreenshot(driver, result.getMethod().getMethodName());
            // try {
            test.get().addScreenCaptureFromPath(screenshotPath, "Failure Screenshot");
            // } catch (IOException e) {
            // e.printStackTrace();
            // }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip(result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Not required to implement
    }

    // Method to capture screenshot
    private String captureScreenshot(WebDriver driver, String screenshotName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String screenshotFileName = screenshotName + "_" + getCurrentDateTimeString() + ".png";
        String dest = System.getProperty("user.dir") + "/test-result/screenshots/" + screenshotFileName;
        File destination = new File(dest);
        try {
            // Create screenshots directory if it doesn't exist
            File screenshotDir = new File(System.getProperty("user.dir") + "/test-result/screenshots/");
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs();
            }
            Files.copy(source.toPath(), destination.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ".\\screenshots\\" + screenshotFileName;
    }

    // Getter to access ExtentTest in test classes if needed
    public static ExtentTest getTest() {
        return test.get();
    }

    public static String getCurrentDateTimeString() {
        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();

        // Define the date-time format: ddMMyyyyHHmmssSSS (with milliseconds)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmssSSS");

        // Format the current date and time with milliseconds
        String formattedDateTime = now.format(formatter);

        return formattedDateTime;
    }
}