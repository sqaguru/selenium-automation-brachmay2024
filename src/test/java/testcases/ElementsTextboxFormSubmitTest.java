package testcases;

import org.testng.annotations.Test;

import framework.BaseTest;
import pages.ElementsTextBoxFomPage;
import pages.HomePage;

public class ElementsTextboxFormSubmitTest extends BaseTest {

	// XRAYT-19
	@Test
	public void verifyTexBoxFormSubmitTest() {
		setJiraTestKey("XRAYT-19");

		getExtentTest().info("Test execution started");

		HomePage homePage = new HomePage(getDriver());

		homePage.navigateToElementPage();

		ElementsTextBoxFomPage elementsTextBoxFomPage = new ElementsTextBoxFomPage(getDriver());

		String DataUserName = "Santosh";
		String DataEmail = "santosh@sqaguru.co.in";
		String DataPassword = "santosh123";

		elementsTextBoxFomPage.typeUserName(DataUserName);

		elementsTextBoxFomPage.typePassword(DataPassword);

		elementsTextBoxFomPage.typeEmail(DataEmail);

		elementsTextBoxFomPage.clickSubmitButton();

		elementsTextBoxFomPage.verifyUserNameSubmitted(DataUserName);

		elementsTextBoxFomPage.verifyEmailSubmitted(DataEmail);

		elementsTextBoxFomPage.verifyPasswordSubmitted(DataPassword);

		elementsTextBoxFomPage.verifySubmitAnotherResponseLink();
		getExtentTest().pass("Form submission and verification successful");

		System.out.println("test002");
		System.out.println(jiraXrayApiToken);
	}
}
