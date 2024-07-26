package seleniumtests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTest {

	@Test()
	public static void test1() {
		Reporter.log("starting the test1()", true);
	}

	@Test(dependsOnMethods = "test1")
	public static void loginTest() {
		Reporter.log("login to application test", true);

		String expectedTitle = "DemoQA";
		String actualTitle = "DemoQA1";

		Assert.assertEquals(actualTitle, expectedTitle, "verify application title");

		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}

	}

	@Test(dependsOnMethods = "loginTest", alwaysRun = true /* soft dependency */)
	public static void createATicketTest() {
		Reporter.log("create a ticket test", true);
	}
}
