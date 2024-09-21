package testcases;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoQASubmitFormDPTest extends BasePage {

	@Test(dataProvider = "testDataMaps2")
	// @Parameters({ "userName", "email", "currentAddress", "permanentAddress" })
	public void demoSubmitFormTest(HashMap<String, String> testDataMaps2) throws InterruptedException {
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

		userNameTextBox.sendKeys(testDataMaps2.get("userName"));// find an element and type text

		driver.findElement(By.id("userEmail")).sendKeys(testDataMaps2.get("email"));// find user email element and
		// type text
		driver.findElement(By.id("currentAddress")).sendKeys(testDataMaps2.get("currAddress"));

		driver.findElement(By.id("permanentAddresss")).sendKeys(testDataMaps2.get("permAddress"));

		Thread.sleep(2000);

		driver.findElement(By.id("submit")).click();// entering the form

		Thread.sleep(2000);

		// ############### verify user name text ###############

		driver.findElement(By.id("name")).isDisplayed();// validating the message has prompted

		// #################################### verify text passed
		// ###########################################
		System.out.println("test passed successfully");

	}

	@DataProvider(name = "testData")
	public String[][] getData() {
		String testData[][] = { { "Santosh Kumar", "santosh@techaxisgroup.com", "Pune", "Hyderabad" },
				{ "Sai", "sai@techaxisgroup.com", "Hyderabad", "Pune" },
				{ "Kshitija", "sai@techaxisgroup.com", "Hyderabad", "Pune" },
				{ "Nazma", "sai@techaxisgroup.com", "Hyderabad", "Pune" } };
		return testData;
	}

	@DataProvider(name = "testDataMaps2")
	public Object[] getData2() {

		Object[] object = new Object[3];

		HashMap<String, String> testData = new HashMap<String, String>();
		testData.put("userName", "Santosh Kumar");
		testData.put("email", "Santosh Kumar");
		testData.put("currAddress", "Pune");
		testData.put("gender", "Male");
		testData.put("permAddress", "Hyderabad");

		HashMap<String, String> testData2 = new HashMap<String, String>();
		testData2.put("userName", "Sai");
		testData2.put("email", "Santosh@techaxis");
		testData2.put("gender", "Male");
		testData2.put("currAddress", "Pune");
		testData2.put("permAddress", "Hyderabad");

		HashMap<String, String> testData3 = new HashMap<String, String>();
		testData3.put("userName", "Sai");
		testData3.put("email", "Santosh@techaxis");
		testData3.put("gender", "Male");
		testData3.put("currAddress", "Pune");
		testData3.put("permAddress", "Hyderabad");

		object[0] = testData;
		object[1] = testData2;
		object[2] = testData3;

		return object;
	}

}
