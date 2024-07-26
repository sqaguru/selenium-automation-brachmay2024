package seleniumtests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class ActionsTest {
	/* test case to test actions classes in selenium */
	@Test
	public static void actionTest() throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();// launching browser

		driver.get("https://demoqa.com/buttons");// navigate url

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Actions action = new Actions(driver);

		WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));

		action.doubleClick(doubleClickButton).build().perform();// double click event operation

		driver.findElement(By.id("doubleClickMessage")).isDisplayed();

		System.out.println("double click performed successfully");

		WebElement rightClickButton = driver.findElement(By.id("rightClickBt"));

		action.contextClick(rightClickButton).build().perform();// right click;

		driver.findElement(By.id("rightClickMessage")).isDisplayed();

	}
}
