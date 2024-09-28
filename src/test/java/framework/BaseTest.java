package framework;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import java.nio.file.Files;
import reports.ExtentManager;
import utils.XRayAPI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {
	WebDriver originalDriver;
	public static  String jiraXrayApiToken;
	public static  String  testExecutionKey;
	public String jiraTestCaseKey;

//	protected WebDriver driver;

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

//	public ExtentTest test;
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	static String reportFolder = ExtentManager.reportFolder;

	protected static ExtentReports extent = ExtentManager.getInstance();
	//	public String reportFolder {
//		return  System.getProperty("user.dir") + File.separator + "test-result";
//	}

	private void setupDriver() {
		Reporter.log("before class execution", true);
		// launchBrowser("chrome");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		Listener listener = new Listener();
		originalDriver = new ChromeDriver(options);
//		driver = originalDriver;
		EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<WebDriver>(listener);
		originalDriver = decorator.decorate(originalDriver);
		originalDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.set(originalDriver);
		// originalDriver = new ChromeDriver();
	}
	@BeforeClass
	public void beforeClass() {

//		setupDriver();
//		Reporter.log("before class execution", true);
//		// launchBrowser("chrome");
//		ChromeOptions options = new ChromeOptions();
////		options.addArguments("--headless");
//		Listener listener = new Listener();
//		originalDriver = new ChromeDriver(options);
////		driver = originalDriver;
//		EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<WebDriver>(listener);
//		originalDriver = decorator.decorate(originalDriver);
//		originalDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//
//		driver.set(originalDriver);
//		// originalDriver = new ChromeDriver();
	}

	@BeforeMethod
	public void beforeMethod(ITestResult result) {
		Reporter.log("executing before method block", true);

		setupDriver();

		// Initialize ExtentTest before every test method
//		test = extent.createTest("Test Name: " + getClass().getSimpleName());
		ExtentTest extentTest = listeners.TestListener.getTest();
		test.set(extentTest);

//		// launchBrowser("chrome");
//		ChromeOptions options = new ChromeOptions();
////		options.addArguments("--headless");
//
//		originalDriver = new ChromeDriver(options);
//		// originalDriver = new ChromeDriver();



//		Listener listener = new Listener();

//		EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<WebDriver>(listener);
//		WebDriver newDriver = decorator.decorate(originalDriver);
//		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.set(newDriver);

//		if(getDriver() == null) {
//			setupDriver();
//		}

		getDriver().get("https://qademoapp.sqaguru.co.in/");
		getDriver().manage().window().maximize();

	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (getDriver() != null) {
			getDriver().quit(); // Quit the WebDriver
//			driver.remove(); // Remove the WebDriver from ThreadLocal
		} else {
			Reporter.log("Driver was not initialized!", true);
		}
	}
//	@AfterMethod
//	public void afterMethod(ITestResult result) {
//		Reporter.log("executing after method block", true);
//		// Get the current ExtentTest for the thread
//		ExtentTest extentTest = test.get();
//
//		if (result.getStatus() == ITestResult.FAILURE) {
//			String screenshotPath = captureScreenshot(result.getName());
//			extentTest.log(Status.FAIL, "Test Failed: " + result.getName());
//			extentTest.fail(result.getThrowable()).addScreenCaptureFromPath(screenshotPath);
//		} else if (result.getStatus() == ITestResult.SUCCESS) {
//			extentTest.log(Status.PASS, "Test Passed: " + result.getName());
//		} else if (result.getStatus() == ITestResult.SKIP) {
//			extentTest.log(Status.SKIP, "Test Skipped: " + result.getName());
//		}
//		Reporter.log("Closing browser.", true);
//
//		test.remove();
//
////		if (getDriver() != null) {
////			getDriver().close();
////		} else {
////			Reporter.log("Driver was not initialized!", true);
////		}
////		driver.close();
//	}

	@AfterClass
	public void afterClass() {

		Reporter.log("After class mechanism", true);

		if (getDriver() != null) {
			getDriver().quit(); // Quit the WebDriver
			driver.remove(); // Remove the WebDriver from ThreadLocal
		} else {
			Reporter.log("Driver was not initialized!", true);
		}
	}

	@BeforeSuite
	public void beforeSuite() {

		Reporter.log("before suite execution", true);
		try {
			jiraXrayApiToken = XRayAPI.getXrayApiToken(System.getenv("JIRA_XRAY_CLIENT_ID"),System.getenv("JIRA_XRAY_CLIENT_SECRET"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    // create test execution	

		String username = System.getenv("JIRA_USERNAME");
		String password = System.getenv("JIRA_PASSWORD");

		String projectKey = "XRAYT";
		String summary = "Test execution summary " + getCurrentDateTimeString();
		String description = "Test execution description 4";
		// Call the createTestExecution function
		try {
			testExecutionKey = XRayAPI.createTestExecution(username, password, projectKey, summary, description);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	@AfterClass
	public void afterSuite() {
		Reporter.log("after suite execution", true);

		System.out.println("after suite logic");

	}

	@BeforeGroups(groups = "SMOKE")
	public void beforeGroups() {
		Reporter.log("before groups test methods", true);
	}

	@AfterGroups(groups = "SMOKE")
	public void afterGroups() {
		Reporter.log("after groups test methods", true);
	}

//	public void launchBrowser(String browserName) {
//
//		if (browserName.contains("chrome")) {
//			// WebDriverManager.chromedriver().setup();
//			originalDriver = new ChromeDriver();
//		} else if (browserName.contains("edge")) {
//			// WebDriverManager.edgedriver().setup();
//			originalDriver = new EdgeDriver();
//
//		} else if (browserName.contains("firefox")) {
//			originalDriver = new FirefoxDriver();
//
//		} else {
//			originalDriver = null;
//		}
//
//		Listener listener = new Listener();
//
//		EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<WebDriver>(listener);
//
//		driver = decorator.decorate(originalDriver);
//
//		getDriver().manage().window().maximize();// maximize the browser
//
//		getDriver().manage().timeouts().implicitlyWait(Duration.ofMinutes(30));// implicit wait, applies for all statements
//		// going forward
//
//	}

	@BeforeTest
	public void beforeTest() {
		
		
		
		Reporter.log("About to begin test execution", true);
	}

	@AfterTest
	public void afterTest() {
		Reporter.log("test execution completed", true);
		

	}

	public void waitForElementVisibility(WebElement element) {
		// explicit wait

		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofMinutes(1));

		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForAlertIsPresent() {
		// explicit wait

		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofMinutes(1));

		wait.until(ExpectedConditions.alertIsPresent());
	}

	protected void fluentWaitForElementAttribute(WebElement element, String attribute, String attributeValue) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(getDriver()).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		fluentWait.until(ExpectedConditions.attributeToBe(element, attribute, attributeValue));

	}

	protected void waitForPageToLoad() throws InterruptedException {
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		// wait for page to load completely
		while (!js.executeScript("return document.readyState").toString().equals("complete")) {
			Thread.sleep(1000);
		}
	}

	// private static void captureScreenShot(WebDriver driver, String destinationFileName) throws IOException {
	// 	File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	// 	Files.copy(sourceFile, new File(reportFolder + File.separator + destinationFileName + ".PNG"));

	// }

	// // Method to capture a screenshot
	// public String captureScreenshot(String screenshotName) {
	// 	TakesScreenshot ts = (TakesScreenshot) driver;
	// 	File source = ts.getScreenshotAs(OutputType.FILE);
	// 	String screenshotFileName = screenshotName + "_" + getCurrentDateTimeString() + ".png";
	// 	String dest = reportFolder + File.separator + "" +  screenshotFileName;

	// 	File destination = new File(dest);
	// 	try {
	// 		FileHandler.copy(source, destination);
	// 	} catch (IOException e) {
	// 		e.printStackTrace();
	// 	}
	// 	return screenshotFileName;
	// }

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

	public static String getCurrentDateTimeString() {
		// Get the current date and time
		LocalDateTime now = LocalDateTime.now();

		// Define the date-time format: ddMMyyyyHHmmssSSS (with milliseconds)
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmssSSS");

		// Format the current date and time with milliseconds
		String formattedDateTime = now.format(formatter);

		return formattedDateTime;
	}

	// Getter method for ExtentTest
	public ExtentTest getExtentTest() {
		return listeners.TestListener.getTest();
		// return test.get();
	}

	public WebDriver getDriver() {
		return driver.get();
	}

	public void setJiraTestKey(String jiraTestCaseKey) {
		// return driver.get();
		this.jiraTestCaseKey = jiraTestCaseKey;
		System.out.println("updating jira status: EXECUTING");
		try {
            XRayAPI.updateTestResult(jiraXrayApiToken, testExecutionKey, jiraTestCaseKey, "EXECUTING");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
}
