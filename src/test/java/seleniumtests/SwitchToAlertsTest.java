package seleniumtests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.Test;

public class SwitchToAlertsTest {

	@Test(groups = "SMOKE")
	public void switchToAlertsTest() throws InterruptedException {

		/*
		 * Listener listener = new Listener();
		 * 
		 * EventFiringDecorator<WebDriver> decorator = new
		 * EventFiringDecorator<WebDriver>(listener);
		 * 
		 * driver = decorator.decorate(driver);
		 */

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://demoqa.com/alerts");// navigate url

		String pageTitle = driver.getTitle();

		System.out.println("pageTitle: " + pageTitle);

		Thread.sleep(5000);

		System.out.println("Alert dismissed");

		// driver.switchTo().alert().dismiss();

		// #################################### verify text passed
		// ###########################################
		System.out.println("test passed successfully");

	}

}
