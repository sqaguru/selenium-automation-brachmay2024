package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementsCheckboxFomPage {
	WebDriver driver;

	public ElementsCheckboxFomPage(WebDriver driver) {
		this.driver = driver;
	}

	By checkboxPanel = By.id("panel2d-header");
	By btnSubmit = By.xpath("(//button[@id='submit-btn'])[2]");

	By lnkSubmitAnotherResponse = By.xpath("(//button[text()='Submit another response'])[2]");

	public void clickOnCheckboxPanel() {
		driver.findElement(checkboxPanel).click();
	}

	public void clickOnCheckbox(String checkboxName) {
		driver.findElement(By.xpath("//label[@id='" + checkboxName + "']//input")).click();
	}

	public void verifyCheckboxResponseItem(String expectedItem) {
		driver.findElement(By.xpath("//p[text()='" + expectedItem + "']")).isDisplayed();
	}

	public void verifySubmitAnotherResponseLink() {
		driver.findElement(lnkSubmitAnotherResponse).isDisplayed();
	}

	public void clickSubmitButton() {

		driver.findElement(btnSubmit).click();
	}
}
