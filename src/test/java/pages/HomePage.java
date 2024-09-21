package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// By btnElements =
	// By.id("//h5[text()='Elements']/parent::div/preceding-sibling::div[1]/*[name()='svg']");

	By btnElements = By.id("Elements");

	public void navigateToElementPage() {
		driver.findElement(btnElements).click();
	}
}
