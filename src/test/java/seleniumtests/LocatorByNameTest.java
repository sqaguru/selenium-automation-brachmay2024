package seleniumtests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorByNameTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--headless");

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://google.com/");// navigate url

		driver.manage().window().maximize();// maximize browser
		Thread.sleep(5000);
		// driver.manage().window().minimize();

		String pageTitle = driver.getTitle();

		System.out.println("pageTitle : " + pageTitle);

		GenericUtility.captureScreenshot(driver, "PageTitle");

		driver.findElement(By.name("q")).sendKeys("Selenium Web Driver");

		driver.findElement(By.name("q")).submit();

		pageTitle = driver.getTitle();

		GenericUtility.captureScreenshot(driver, "PageSearchResult");

		Thread.sleep(5000);

		System.out.println("pageTitle on search : " + pageTitle);

		String runningUrl = driver.getCurrentUrl();

		System.out.println("runningUrl: " + runningUrl);

		driver.navigate().back();//

		GenericUtility.captureScreenshot(driver, "PageNavBack");

		Thread.sleep(5000);

		driver.navigate().forward();

		GenericUtility.captureScreenshot(driver, "PageNavForward");

		Thread.sleep(5000);

		driver.navigate().refresh();// reload the page

		driver.quit();// closing all the browser windows opened by selenium

	}

}
