package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ElementsRadioButtonFomPage {
	WebDriver driver;

	public ElementsRadioButtonFomPage(WebDriver driver) {
		this.driver = driver;
	}

	By radioButtonPanel = By.id("panel3d-header");
	By btnSubmit = By.xpath("(//button[@id='submit-btn'])[3]");

	By femaleRadioButton = By.xpath("//label[@id='Female']//input");
	By maleRadioButton = By.xpath("//label[@id='Male']//input");
	By otherRadioButton = By.xpath("//label[@id='Other']//input");

	By lnkSubmitAnotherResponse = By.xpath("(//button[text()='Submit another response'])[3]");
	By submittedGenderValue = By.id("response-gender-value");

	public void clickOnRadioButtonPanel() {
		driver.findElement(radioButtonPanel).click();
	}

	public void clickOnMaleRadioButton() {
		driver.findElement(maleRadioButton).click();
	}

	public void clickOnFemaleRadioButton() {
		driver.findElement(femaleRadioButton).click();
	}

	public void clickOnOtherRadioButton() {
		driver.findElement(otherRadioButton).click();
	}

	public void clickOnSubmitButton() {
		driver.findElement(btnSubmit).click();
	}

	public void verifySubmittedGenderText(String expectedText) {
		String actualText = driver.findElement(submittedGenderValue).getText();

		Assert.assertEquals(actualText, expectedText, "Verifying gender submmited");
	}

	public void verifySubmitAnotherResponseLink() {
		driver.findElement(lnkSubmitAnotherResponse).isDisplayed();
	}
}
