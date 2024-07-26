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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class SelectDropDownTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();// launching browser

		driver.get("https://demoqa.com/books");// navigate url

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Thread.sleep(5000);

		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		try {

			fluentWait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath("//select[@aria-label='rows per page']"))));

			WebElement dropdown = driver.findElement(By.xpath("//select[@aria-label='rows per page']"));// returning an

			captureScreenshot(driver, "screenshotAfterLaunchPage");
			scrollToElement(driver, dropdown);

			// element
			Select selectPageRowsCount = new Select(dropdown);

			selectPageRowsCount.selectByIndex(1);// select by position or index

			Thread.sleep(2000);

			captureScreenshot(driver, "screenshotAfterIndexSelection");

			selectPageRowsCount.selectByValue("20");// select by value attribute content

			Thread.sleep(2000);

			captureScreenshot(driver, "screenshot03");

			selectPageRowsCount.selectByVisibleText("21 rows");// visible text approach''
		} catch (NoSuchElementException noSuchElementException) {
			captureScreenshot(driver, "screenshotOnError");
		}
	}

	private static void captureScreenshot(WebDriver driver, String fileName) throws IOException {
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Files.copy(sourceFile, new File(
				"D:\\techaxisgroup\\demomay2024\\test-automation-may24-ws\\test_automation_amazon\\resources\\screenshot\\"
						+ fileName + ".PNG"));
	}

	private static void scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;// driver object type-casting to javascript
		// executor
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", element);// scroll the
																						// element
																						// to view

	}

}
