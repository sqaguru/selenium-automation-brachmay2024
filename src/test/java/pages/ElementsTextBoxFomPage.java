package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ElementsTextBoxFomPage {
	WebDriver driver;

	public ElementsTextBoxFomPage(WebDriver driver) {
		this.driver = driver;
	}

	By btnButtons = By.xpath("//span[text()='Buttons']");

	By txtUserName = By.id("name-input");

	By txtEmail = By.id("email-input");

	By txtPassword = By.id("password-input");

	By txtAddress = By.id("address");

	By btnSubmit = By.id("submit-btn");

	By lblUserName = By.id("form-data-name");

	By lblEmail = By.id("form-data-email");

	By lblPassword = By.id("form-data-password");

	By lblAddress = By.id("form-data-address");

	By lnkSubmitAnotherResponse = By.xpath("(//button[text()='Submit another response'])[1]");

	public void clickSubmitButton() {
		driver.findElement(btnSubmit).click();
	}

	public void typeUserName(String userName) {
		driver.findElement(txtUserName).sendKeys(userName);
	}

	public void typeEmail(String email) {
		driver.findElement(txtEmail).sendKeys(email);
	}

	public void typePassword(String password) {
		driver.findElement(txtPassword).sendKeys(password);
	}

	public void typeAddress(String address) {
		driver.findElement(txtAddress).sendKeys(address);
	}

	public void verifyEmailSubmitted(String expectedEmail) {

		String actualEmail = driver.findElement(lblEmail).getText();

		Assert.assertEquals(actualEmail, expectedEmail, "Verifying email submmited");

	}

	public void verifyUserNameSubmitted(String expectedUserName) {

		String actualUserName = driver.findElement(lblUserName).getText();

		Assert.assertEquals(actualUserName, expectedUserName, "Verifying User Name submmited");

	}

	public void verifyPasswordSubmitted(String expectedPassword) {

		String actualPassword = driver.findElement(lblPassword).getText();

		Assert.assertEquals(actualPassword, expectedPassword, "Verifying Password submmited");

	}

	public void verifyAddressSubmitted(String expectedAddress) {

		String actualAddress = driver.findElement(lblAddress).getText();

		Assert.assertEquals(actualAddress, expectedAddress, "Verifying Address submmited");

	}

	public void verifySubmitAnotherResponseLink() {
		driver.findElement(lnkSubmitAnotherResponse).isDisplayed();
	}

}
