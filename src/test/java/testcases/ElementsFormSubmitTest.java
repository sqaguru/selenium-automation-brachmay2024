package testcases;

import org.testng.annotations.Test;

import framework.BaseTest;
import pages.ElementsPage;
import pages.HomePage;

public class ElementsFormSubmitTest extends BaseTest {

	@Test
	public void verifyFormSubmitTest() {

		HomePage homePage = new HomePage(driver);

		homePage.navigateToElementPage();

		ElementsPage elementsPage = new ElementsPage(driver);

		String DataUserName = "Santosh";
		String DataEmail = "santosh@sqaguru.co.in";
		String DataPassword = "santosh123";

		elementsPage.typeUserName(DataUserName);

		elementsPage.typePassword(DataPassword);

		elementsPage.typeEmail(DataEmail);

		elementsPage.clickSubmitButton();

		elementsPage.verifyUserNameSubmitted(DataUserName);

		elementsPage.verifyEmailSubmitted(DataEmail);

		elementsPage.verifyPasswordSubmitted(DataPassword);

		elementsPage.verifySubmitAnotherResponseLink();
	}

}
