package testcases;

import framework.BaseTest;

import org.testng.annotations.Test;
import pages.ElementsCheckboxFomPage;
import pages.HomePage;

public class ElementsCheckboxFormTest extends BaseTest {

	// XRAYT-13
	@Test
	public void verifyCheckboxFormSubmitTest1() {
		setJiraTestKey("XRAYT-13");

		getExtentTest().info("Test execution started");

		HomePage homePage = new HomePage(getDriver());

		homePage.navigateToElementPage();

		ElementsCheckboxFomPage elementsCheckboxFomPage = new ElementsCheckboxFomPage(getDriver());
		elementsCheckboxFomPage.clickOnCheckboxPanel();

		elementsCheckboxFomPage.clickOnCheckbox("Discrete Mathematics");
		elementsCheckboxFomPage.clickOnCheckbox("Foundations of Data Science");
		elementsCheckboxFomPage.clickOnCheckbox("Data Structures");
		elementsCheckboxFomPage.clickOnCheckbox("Database Management Systems");

		elementsCheckboxFomPage.clickSubmitButton();

		elementsCheckboxFomPage.verifyCheckboxResponseItem("Discrete Mathematics");
		elementsCheckboxFomPage.verifyCheckboxResponseItem("Foundations of Data Science");
		elementsCheckboxFomPage.verifyCheckboxResponseItem("Data Structures");
		elementsCheckboxFomPage.verifyCheckboxResponseItem("Database Management Systems");

		elementsCheckboxFomPage.verifySubmitAnotherResponseLink();

		getExtentTest().pass("Form submission and verification successful");

	}

	// XRAYT-14
	@Test
	public void verifyCheckboxFormSubmitTest2() {
		setJiraTestKey("XRAYT-14");

		getExtentTest().info("Test execution started");

		HomePage homePage = new HomePage(getDriver());

		homePage.navigateToElementPage();

		ElementsCheckboxFomPage elementsCheckboxFomPage = new ElementsCheckboxFomPage(getDriver());
		elementsCheckboxFomPage.clickOnCheckboxPanel();

		elementsCheckboxFomPage.clickOnCheckbox("Algorithms");
		elementsCheckboxFomPage.clickOnCheckbox("Computer Architecture");

		elementsCheckboxFomPage.clickSubmitButton();

		elementsCheckboxFomPage.verifyCheckboxResponseItem("Algorithms");
		elementsCheckboxFomPage.verifyCheckboxResponseItem("Computer Architecture");

		elementsCheckboxFomPage.verifySubmitAnotherResponseLink();

		getExtentTest().pass("Form submission and verification successful");
	}
}
