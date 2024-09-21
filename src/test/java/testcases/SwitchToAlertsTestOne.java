package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwitchToAlertsTestOne {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();// launching browser

		driver.get("https://demoqa.com/alerts");// navigate url

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));// implicit wait

		String pageTitle = driver.getTitle();

		System.out.println("pageTitle: " + pageTitle);

		// Thread.sleep(5000);//hard waits => Should not use

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));// explicit wait define

		wait.until(ExpectedConditions.elementToBeClickable(By.id("confirmButton")));// usage of explicit wait

		driver.findElement(By.id("confirmButton")).click();

		wait.until(ExpectedConditions.alertIsPresent());//

		driver.switchTo().alert().accept();

		String actualResultText = driver.findElement(By.id("confirmResult")).getText();

		String expectedResultText = "You selected Ok";

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
