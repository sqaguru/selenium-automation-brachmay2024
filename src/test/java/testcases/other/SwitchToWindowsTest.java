package testcases.other;

import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwitchToWindowsTest {

	public static void main(String[] args) throws InterruptedException {

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Please your browser choice code   \n1.chrome \n2.firefox \n3.edge");

			int browserCode = scanner.nextInt();

			WebDriver driver;
			if (browserCode == 1) {

				driver = new ChromeDriver();// launching browser

			} else if (browserCode == 2) {
				driver = new FirefoxDriver();// launching browser
			} else {
				driver = new EdgeDriver();// launching browser

			}

			driver.get("https://demoqa.com/browser-windows");// navigate url

			Thread.sleep(5000);

			String pageTitle = driver.getTitle();

			System.out.println("pageTitle: " + pageTitle);

			driver.findElement(By.id("tabButton")).click();

			Set<String> windowIds = driver.getWindowHandles();// returns window ids

			String defaultWindowId = driver.getWindowHandle();// returns window id of the currently controlled window

			for (String windowId : windowIds) {
				if (windowId.equals(defaultWindowId)) {
					System.out.println("..");
				} else {
					driver.switchTo().window(windowId);
				}
			}

			System.out.println("Second window title: " + driver.getTitle());

			if (driver.getTitle().equals("This is a sample page")) {
				System.out.println("Second window header validation done : Passed");
			} else {
				System.out.println("Second window header validation done : Failed");
			}

			driver.close();

			driver.switchTo().window(defaultWindowId);

			System.out.println("First window title: " + driver.getTitle());
		}
	}

}
