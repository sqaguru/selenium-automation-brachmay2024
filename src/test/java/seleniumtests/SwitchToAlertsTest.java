package seleniumtests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.Test;

public class SwitchToAlertsTest extends BaseTest {

	@Test(groups = "SMOKE")
	public void switchToAlertsTest() throws InterruptedException {

		Listener listener = new Listener();

		EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<WebDriver>(listener);

		driver = decorator.decorate(driver);

		driver.get("https://demoqa.com/alerts");// navigate url

		String pageTitle = driver.getTitle();

		System.out.println("pageTitle: " + pageTitle);

		Thread.sleep(5000);

		driver.findElement(By.id("alertButton")).click();

		Thread.sleep(3000);

		Alert alert = driver.switchTo().alert();

		String alertMessage = alert.getText();

		String expectedAlertTitle = "You clicked a button.";

		if (expectedAlertTitle.equals(alertMessage)) {
			System.out.println("Alert Message Test Passed");
		} else {
			System.out.println("Alert Message Test Failed");
		}

		System.out.println("alertMessage: " + alertMessage);

		alert.dismiss();

		System.out.println("Alert dismissed");

		// driver.switchTo().alert().dismiss();

		// #################################### verify text passed
		// ###########################################
		System.out.println("test passed successfully");

	}

}
