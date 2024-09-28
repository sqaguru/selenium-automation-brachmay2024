package testcases;

import framework.BaseTest;
import org.testng.annotations.Test;
import pages.ElementsButtonEventsPage;
import pages.HomePage;

public class ElementsButtonEventsTest extends BaseTest{

	// XRAYT-10
	@Test
	public void verifyClickButtonTest() {
		setJiraTestKey("XRAYT-10");

		getExtentTest().info("Test execution started");

		HomePage homePage = new HomePage(getDriver());

		homePage.navigateToElementPage();

		ElementsButtonEventsPage elementsButtonEventsPage = new ElementsButtonEventsPage(getDriver());
		elementsButtonEventsPage.clickOnButtonsPanel();

		elementsButtonEventsPage.clickOnClickButton();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        elementsButtonEventsPage.verifyClickCount("1");

		elementsButtonEventsPage.clickOnClickButton();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		elementsButtonEventsPage.verifyClickCount("2");

		elementsButtonEventsPage.clickOnClickButton();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		elementsButtonEventsPage.verifyClickCount("3");

		elementsButtonEventsPage.verifySubmitAnotherResponseLink();

		getExtentTest().pass("Form submission and verification successful");
	}

	// XRAYT-11
	@Test
	public void verifyDoubleClickButtonTest() {
		setJiraTestKey("XRAYT-11");

		getExtentTest().info("Test execution started");

		HomePage homePage = new HomePage(getDriver());

		homePage.navigateToElementPage();

		ElementsButtonEventsPage elementsButtonEventsPage = new ElementsButtonEventsPage(getDriver());
		elementsButtonEventsPage.clickOnButtonsPanel();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		elementsButtonEventsPage.clickOnDoubleClickButton();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		elementsButtonEventsPage.verifyDoubleClickCount("1");

		elementsButtonEventsPage.clickOnDoubleClickButton();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		elementsButtonEventsPage.verifyDoubleClickCount("2");

		elementsButtonEventsPage.clickOnDoubleClickButton();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		elementsButtonEventsPage.verifyDoubleClickCount("3");

		elementsButtonEventsPage.verifySubmitAnotherResponseLink();

		getExtentTest().pass("Form submission and verification successful");
	}

	// XRAYT-12
	@Test
	public void verifyRightClickButtonTest() {
		setJiraTestKey("XRAYT-12");

		getExtentTest().info("Test execution started");

		HomePage homePage = new HomePage(getDriver());

		homePage.navigateToElementPage();

		ElementsButtonEventsPage elementsButtonEventsPage = new ElementsButtonEventsPage(getDriver());
		elementsButtonEventsPage.clickOnButtonsPanel();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		elementsButtonEventsPage.clickOnRightClickButton();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		elementsButtonEventsPage.verifyRightClickCount("1");

		elementsButtonEventsPage.clickOnRightClickButton();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		elementsButtonEventsPage.verifyRightClickCount("2");

		elementsButtonEventsPage.clickOnRightClickButton();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		elementsButtonEventsPage.verifyRightClickCount("3");

		elementsButtonEventsPage.verifySubmitAnotherResponseLink();

		getExtentTest().pass("Form submission and verification successful");
	}
}
