package testcases.other;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActionTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();// launching browser

		driver.get("https://demoqa.com/text-box");// navigate url

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		String pageTitle = driver.getTitle();

		System.out.println("pageTitle: " + pageTitle);

		WebElement userNameTextBox = driver.findElement(By.id("userName"));

		userNameTextBox.isDisplayed();// it will verify if the element is displayed or not.

		userNameTextBox.isEnabled();// will verify if the element is enabled

		userNameTextBox.sendKeys("Santosh Kumar");// find an element and type text

		driver.findElement(By.id("userEmail")).sendKeys("santoshkumar@techaxisgroup.com");// find user email element and
																							// type text
		driver.findElement(By.id("currentAddress")).sendKeys("Pune, India");

		WebElement weCurrentAddress = driver.findElement(By.id("currentAddress"));

		Actions action = new Actions(driver);

		Thread.sleep(2000);//not related to driver browser application - pause for 2 seconds -> Java Command 

		action.click(weCurrentAddress).keyDown(Keys.CONTROL).keyDown("A").keyDown(Keys.BACK_SPACE).build().perform();

		Thread.sleep(2000);

		driver.findElement(By.id("currentAddress")).sendKeys("Hyderabad, India");

		Thread.sleep(2000);

		action.click(weCurrentAddress).keyDown(Keys.CONTROL).keyDown("A").keyDown(Keys.CONTROL).keyDown("C").build()
				.perform();

		WebElement wePermanentAddress = driver.findElement(By.id("permanentAddress"));

		action.click(wePermanentAddress).keyDown(Keys.CONTROL).keyDown("V").build().perform();

		// #################################### verify text passed
		// ###########################################
		System.out.println("test passed successfully");

	}

}
