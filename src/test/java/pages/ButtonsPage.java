package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import framework.GenericLibrary;

public class ButtonsPage {

	WebDriver driver;
	GenericLibrary genericLibrary;
	private final String RIGHT_CLICK_SUCCESS_MESSAGE = "You have done a right click";

	public ButtonsPage(WebDriver driver) {
		this.driver = driver;
		genericLibrary = new GenericLibrary(driver);
	}

	By btnContextClick = By.id("rightClickBtn");

	By lblRightClickSuccessMessage = By.id("rightClickMessage");

	public void contextClickOnRightClickButton() {

		WebElement contextClickButton = driver.findElement(btnContextClick);

		genericLibrary.contextClick(contextClickButton);
	}

	public void verifyLabelOfRightClickSuccess() {
		driver.findElement(lblRightClickSuccessMessage).isDisplayed();
	}

	public void verifyRightClickLabelText() {

		String contextClickPerform = driver.findElement(lblRightClickSuccessMessage).getText();

		Assert.assertEquals(contextClickPerform, RIGHT_CLICK_SUCCESS_MESSAGE,
				"verify label text of You have done a right click");

	}

}
