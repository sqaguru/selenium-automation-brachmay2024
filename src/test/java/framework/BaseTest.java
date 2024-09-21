package framework;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
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

import com.google.common.io.Files;

public class BaseTest {
	WebDriver originalDriver;
	protected WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		Reporter.log("before class execution", true);
	}

	@BeforeMethod
	public void beforeMethod() {
		Reporter.log("executing before method block", true);
		// launchBrowser("chrome");
		originalDriver = new ChromeDriver();

		originalDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		originalDriver.get("https://qademoapp.sqaguru.co.in/");

		Listener listener = new Listener();

		EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<WebDriver>(listener);

		driver = decorator.decorate(originalDriver);

		driver.manage().window().maximize();

	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
		Reporter.log("Closing browser.", true);
	}

	@BeforeClass
	public void afterClass() {
		Reporter.log("after class execution", true);
	}

	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("before suite execution", true);
	}

	@AfterClass
	public void afterSuite() {
		Reporter.log("after suite execution", true);
	}

	@BeforeGroups(groups = "SMOKE")
	public void beforeGroups() {
		Reporter.log("before groups test methods", true);
	}

	@AfterGroups(groups = "SMOKE")
	public void afterGroups() {
		Reporter.log("after groups test methods", true);
	}

	public void launchBrowser(String browserName) {

		if (browserName.contains("chrome")) {
			// WebDriverManager.chromedriver().setup();
			originalDriver = new ChromeDriver();
		} else if (browserName.contains("edge")) {
			// WebDriverManager.edgedriver().setup();
			originalDriver = new EdgeDriver();

		} else if (browserName.contains("firefox")) {
			originalDriver = new FirefoxDriver();

		} else {
			originalDriver = null;
		}

		Listener listener = new Listener();

		EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<WebDriver>(listener);

		driver = decorator.decorate(originalDriver);

		driver.manage().window().maximize();// maximize the browser

		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(30));// implicit wait, applies for all statements
		// going forward

	}

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

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForAlertIsPresent() {
		// explicit wait

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		wait.until(ExpectedConditions.alertIsPresent());
	}

	protected void fluentWaitForElementAttribute(WebElement element, String attribute, String attributeValue) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMinutes(1))
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

	private static void captureScreenShot(WebDriver driver, String destinationFileName) throws IOException {
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Files.copy(sourceFile, new File(
				"D:\\techaxisgroup\\demoapr2024\\training-batch-april24-workspace\\linkedin_test_automation\\resources\\screeenshots\\"
						+ destinationFileName + ".PNG"));

	}
}
