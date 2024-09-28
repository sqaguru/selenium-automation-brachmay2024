package testcases;

import framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ElementsTablePage;
import pages.HomePage;

public class ElementsTableTest extends BaseTest {
	// XRAYT-18
	@Test
	public void deleteAndVerifyTableRecordTest() {
		setJiraTestKey("XRAYT-18");

		getExtentTest().info("Test execution started");

		HomePage homePage = new HomePage(getDriver());

		homePage.navigateToElementPage();

		ElementsTablePage elementsTablePage = new ElementsTablePage(getDriver());
		elementsTablePage.clickOnTablePanel();

		String textBeforeDeleteAction = elementsTablePage.getFirstRowText();
		elementsTablePage.clickFirstRowDeleteButton();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		String textAfterDeleteAction = elementsTablePage.getFirstRowText();

		Assert.assertNotEquals(textBeforeDeleteAction, textAfterDeleteAction,
				"Verify first name should not present at first row");

		getExtentTest().pass("Form submission and verification successful");
	}

	// @Test
	public void failTest() {
		setJiraTestKey("temp");

		getExtentTest().info("Test execution started");

		HomePage homePage = new HomePage(getDriver());

		homePage.navigateToElementPage();

		ElementsTablePage elementsTablePage = new ElementsTablePage(getDriver());
		elementsTablePage.clickOnTablePanel();

		Assert.assertNotEquals("AA", "AAa", "this test should fail");

		System.out.println("test001");
		System.out.println(jiraXrayApiToken);

		getExtentTest().pass("Form submission and verification successful");
	}
}
