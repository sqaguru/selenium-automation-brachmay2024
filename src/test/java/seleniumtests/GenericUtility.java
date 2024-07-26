package seleniumtests;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class GenericUtility {
	static void captureScreenshot(WebDriver driver, String fileName) throws IOException {
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Files.copy(sourceFile, new File(
				"D:\\techaxisgroup\\demomay2024\\test-automation-may24-ws\\test_automation_amazon\\resources\\screenshot\\"
						+ fileName + ".PNG"));
	}
}
