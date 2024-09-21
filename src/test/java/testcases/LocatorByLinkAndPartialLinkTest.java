package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorByLinkAndPartialLinkTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();// launching browser

		driver.get("https://demoqa.com/buttons");// navigate url

		String pageTitle = driver.getTitle();

		System.out.println("pageTitle : " + pageTitle);

		Thread.sleep(5000);

		List<WebElement> buttonList = driver.findElements(By.tagName("button"));

		System.out.println("total buttons on the page: " + buttonList.size());

		for (WebElement button : buttonList) {
			System.out.println("button text is : " + button.getText());
		}

	}

}
