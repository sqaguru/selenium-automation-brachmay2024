package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GenericLibrary {
	WebDriver driver;

	public GenericLibrary(WebDriver driver) {
		this.driver = driver;
	}

	public void contextClick(WebElement button) {

		Actions action = new Actions(driver);

		action.contextClick(button).build().perform();

	}
}
