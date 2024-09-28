package testcases;

import framework.BaseTest;
import org.testng.annotations.Test;
import pages.ElementsRadioButtonFomPage;
import pages.HomePage;

public class ElementsRadioButtonFormTest extends BaseTest {

	// XRAYT-15
	@Test
	public void submitMaleGenderAndVerifyTest() {
		setJiraTestKey("XRAYT-15");

		getExtentTest().info("Test execution started");

		HomePage homePage = new HomePage(getDriver());

		homePage.navigateToElementPage();

		ElementsRadioButtonFomPage elementsRadioBtnFomPage = new ElementsRadioButtonFomPage(getDriver());
		elementsRadioBtnFomPage.clickOnRadioButtonPanel();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		elementsRadioBtnFomPage.clickOnMaleRadioButton();
		elementsRadioBtnFomPage.clickOnSubmitButton();
		elementsRadioBtnFomPage.verifySubmittedGenderText("Male");

		elementsRadioBtnFomPage.verifySubmitAnotherResponseLink();

		getExtentTest().pass("Form submission and verification successful");
	}

	// XRAYT-16
	@Test
	public void submitOtherGenderAndVerifyTest() {
		setJiraTestKey("XRAYT-16");

		getExtentTest().info("Test execution started");

		HomePage homePage = new HomePage(getDriver());

		homePage.navigateToElementPage();

		ElementsRadioButtonFomPage elementsRadioBtnFomPage = new ElementsRadioButtonFomPage(getDriver());
		elementsRadioBtnFomPage.clickOnRadioButtonPanel();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		elementsRadioBtnFomPage.clickOnOtherRadioButton();
		elementsRadioBtnFomPage.clickOnSubmitButton();
		elementsRadioBtnFomPage.verifySubmittedGenderText("Other");

		elementsRadioBtnFomPage.verifySubmitAnotherResponseLink();

		getExtentTest().pass("Form submission and verification successful");
	}

	// XRAYT-17
	@Test
	public void submitFemaleGenderAndVerifyTest() {
		setJiraTestKey("XRAYT-17");

		getExtentTest().info("Test execution started");

		HomePage homePage = new HomePage(getDriver());

		homePage.navigateToElementPage();

		ElementsRadioButtonFomPage elementsRadioBtnFomPage = new ElementsRadioButtonFomPage(getDriver());
		elementsRadioBtnFomPage.clickOnRadioButtonPanel();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		elementsRadioBtnFomPage.clickOnMaleRadioButton();
		elementsRadioBtnFomPage.clickOnFemaleRadioButton();
		elementsRadioBtnFomPage.clickOnSubmitButton();
		elementsRadioBtnFomPage.verifySubmittedGenderText("Female");

		elementsRadioBtnFomPage.verifySubmitAnotherResponseLink();

		getExtentTest().pass("Form submission and verification successful");
	}
}
