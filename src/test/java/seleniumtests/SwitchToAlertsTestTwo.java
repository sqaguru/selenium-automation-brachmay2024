package seleniumtests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToAlertsTestTwo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();// launching browser

		driver.get("https://demoqa.com/alerts");// navigate url

		String pageTitle = driver.getTitle();

		System.out.println("pageTitle: " + pageTitle);

		Thread.sleep(5000);

		driver.findElement(By.id("confirmButton")).click();

		driver.switchTo().alert().sendKeys("Santosh");
		
		driver.switchTo().alert().accept();

		String actualResultText = driver.findElement(By.id("confirmResult")).getText();

		String expectedResultText = "You selected Cancel";

		if (expectedResultText.equals(actualResultText)) {
			System.out.println("Alert accept confirm text validation passed ");
			System.out.println("Expected Result: " + expectedResultText);
			System.out.println("Actual Result: " + actualResultText);
		} else {
			System.out.println("Alert accept confirm text validation Failed ");
			System.out.println("Expected Result: " + expectedResultText);
			System.out.println("Actual Result: " + actualResultText);
		}

	}

}
