package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BasePage {
	WebDriver driver;

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite logic");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite logic");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("before Test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("after Test");
	}

	@BeforeMethod
	public void beforeMethod() {
		Reporter.log("before method mechanism", true);
	}

	@AfterMethod
	public void afterMethod() {
		Reporter.log("after method mechanism", true);
	}

	@BeforeClass(groups = "SMOKE")
	public void beforeClass() {
		Reporter.log("launching chrome browser");
		driver = new ChromeDriver();// launching browser
	}

	@AfterClass(groups = "SMOKE")
	public void afterClass() {
		Reporter.log("after class mechanism", true);
		driver.quit();
	}

}
