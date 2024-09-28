package testcases.other;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwitchToFramesTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String browserName = "firefox";
		WebDriver driver;
		if (browserName.equals("firefox")) {

			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();// launching browser
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://demoqa.com/frames");// navigate url

		String pageTitle = driver.getTitle();

		System.out.println("pageTitle: " + pageTitle);

		waitForFrame(driver);

		// driver.switchTo().frame("frame1");

		String frame1Header = driver.findElement(By.tagName("h1")).getText();

		System.out.println("frame1Header: " + frame1Header);

		driver.switchTo().defaultContent();

		driver.switchTo().frame("frame2");

		String frame2Header = driver.findElement(By.tagName("h1")).getText();

		System.out.println("frame2Header: " + frame2Header);

		driver.switchTo().defaultContent();

		// #################################### verify text passed
		// ###########################################
		System.out.println("test passed successfully");

	}

	public static void waitForFrame(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));// explicit wait define

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("frame1")));// usage of explicit wait
	}

}
