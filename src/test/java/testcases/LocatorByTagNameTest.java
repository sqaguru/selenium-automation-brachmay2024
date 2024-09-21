package testcases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorByTagNameTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();// launching browser

		driver.get("https://demoqa.com/links");// navigate url

		String pageTitle = driver.getTitle();

		System.out.println("pageTitle : " + pageTitle);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		waitForPageToLoad(driver);
		driver.findElement(By.linkText("Bad Request")).click();

		Thread.sleep(2000);

		waitForPageToLoad(driver);

		driver.findElement(By.partialLinkText("Bad")).click();

		int totalLink = driver.findElements(By.tagName("a")).size();

		System.out.println("total links: " + totalLink);

		driver.navigate().back();

		driver.manage().window().maximize();

	}

	public static void waitForPageToLoad(WebDriver driver) throws InterruptedException {
		JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) driver);

		for (int secondCounter = 0; secondCounter < 20; secondCounter++) {
			if (javascriptExecutor.executeScript("return document.readyState").toString().equals("complete")) {
				break;
			} else {
				Thread.sleep(1000);
			}
		}

	}

}
