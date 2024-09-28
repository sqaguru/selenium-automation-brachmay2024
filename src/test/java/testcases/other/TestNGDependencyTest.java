package testcases.other;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNGDependencyTest {
	@Test(priority = 1)
	public static void test1() {
		Reporter.log("starting the test1()", true);
	}

	@Test(priority = 2)
	public static void loginTest() {
		Reporter.log("login to application test", true);
	}

	@Test(priority = 3)
	public static void createATicketTest() {
		Reporter.log("create a ticket test", true);
	}
}
