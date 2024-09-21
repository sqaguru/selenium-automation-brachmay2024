package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoQASubmitFormTest extends BasePage {

	@Test(groups = "SMOKE")
	@Parameters({ "userName", "email", "currentAddress", "permanentAddress" })
	public void demoSubmitFormTest(String userName, String email, String currentAddress, String permanentAddress)
			throws InterruptedException {
		Listener listener = new Listener();

		EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<WebDriver>(listener);

		driver = decorator.decorate(driver);

		driver.get("https://demoqa.com/text-box");// navigate url

		String pageTitle = driver.getTitle();

		System.out.println("pageTitle: " + pageTitle);

		WebElement userNameTextBox = driver.findElement(By.id("userName"));

		String userNameAutoCompleteAttribute = userNameTextBox.getAttribute("autocomplete");
		System.out.println("userNameAutoCompleteAttribute: " + userNameAutoCompleteAttribute);

		String placeholderAttribute = userNameTextBox.getAttribute("placeholder");
		System.out.println("placeholderAttribute: " + placeholderAttribute);

		String typeAttribute = userNameTextBox.getAttribute("type");
		System.out.println("typeAttribute: " + typeAttribute);

		userNameTextBox.isDisplayed();// it will verify if the element is displayed or not.

		userNameTextBox.isEnabled();// will verify if the element is enabled

		userNameTextBox.sendKeys(userName);// find an element and type text

		driver.findElement(By.id("userEmail")).sendKeys(email);// find user email element and
																// type text
		driver.findElement(By.id("currentAddress")).sendKeys(currentAddress);

		driver.findElement(By.id("permanentAddresss")).sendKeys(permanentAddress);

		Thread.sleep(2000);

		driver.findElement(By.id("submit")).click();// entering the form

		Thread.sleep(2000);

		// ############### verify user name text ###############

		driver.findElement(By.id("name")).isDisplayed();// validating the message has prompted

		String actualUserName = driver.findElement(By.id("name")).getText();// return me the element text

		String expectedUserName = "Santosh Kumar";

		String[] actualUserNameArray = actualUserName.split(":");

		if (actualUserNameArray[1].equals(expectedUserName)) {
			System.out.println("Actual user '" + actualUserName + "' name is equals to expected user name '"
					+ expectedUserName + "': Test Passed");
		} else {
			System.out.println("Actual user '" + actualUserName + "' name is equals to expected user name '"
					+ expectedUserName + "': Test Failed");
		}
		// ############### verify user email text ###############

		driver.findElement(By.id("email")).isDisplayed();// validating the message has prompted

		String actualEmail = driver.findElement(By.id("email")).getText();// return me the element text

		String expectedEmail = "santoshkumar@techaxisgroup.com";

		String[] actualEmailArray = actualEmail.split(":");

		if (actualEmailArray[1].equals(expectedEmail)) {
			System.out.println("Actual email '" + actualEmail + "' email is equals to expected email  '" + expectedEmail
					+ "': Test Passed");
		} else {
			System.out.println("Actual email '" + actualEmail + "' email is equals to expected email '" + expectedEmail
					+ "': Test Failed");
		}

		// ############### verify current address text ###############
		String actualAddress = driver.findElement(By.cssSelector("#currentAddress.mb-1")).getText();// return me the
																									// element text
		String expectedAddress = "Pune";

		String[] actualAddressArray = actualAddress.split(":");

		if (actualAddressArray[1].equals(expectedAddress)) {
			System.out.println("Actual address '" + actualAddress + "' address is equals to expected email  '"
					+ expectedAddress + "': Test Passed");
		} else {
			System.out.println("Actual address '" + actualAddress + "' address is equals to expected email '"
					+ expectedAddress + "': Test Failed");
		}

		// #################################### verify text passed
		// ###########################################
		System.out.println("test passed successfully");

	}

}
