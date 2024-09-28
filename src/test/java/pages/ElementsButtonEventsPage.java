package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ElementsButtonEventsPage {
	WebDriver driver;

	public ElementsButtonEventsPage(WebDriver driver) {
		this.driver = driver;
	}

	By btnClick = By.id("click-btn");
	By btnDoubleClick = By.id("double-click-btn");
	By btnRightClick = By.id("right-click-btn");

	By btnSubmit = By.id("submit-btn");

	By lblClickCount = By.xpath("//div[@id='click-event-count']//span");

	By lblDoubleClickCount = By.xpath("//div[@id='double-click-event-count']//span");

	By lblRightClickCount = By.xpath("//div[@id='right-click-event-count']//span");

	By lnkSubmitAnotherResponse = By.xpath("(//button[text()='Submit another response'])[1]");
	By buttonsPanel = By.xpath("(//div[@id='panel3d-header'])[3]");

	public void clickOnButtonsPanel() {
		driver.findElement(buttonsPanel).click();
	}

	public void clickOnClickButton() {
		driver.findElement(btnClick).click();
	}

	public void clickOnDoubleClickButton() {
		WebElement clickElm = driver.findElement(btnDoubleClick);
		Actions act = new Actions(driver);
		act.doubleClick(clickElm).perform();
	}

	public void clickOnRightClickButton() {
		WebElement clickElm = driver.findElement(btnRightClick);
		Actions act = new Actions(driver);
		act.contextClick(clickElm).perform();
	}

	public void verifyClickCount(String expectedCount) {
		String actualCount = driver.findElement(lblClickCount).getText();
		Assert.assertEquals(actualCount, expectedCount, "Verifying Click event counts");
	}

	public void verifyDoubleClickCount(String expectedCount) {
		String actualCount = driver.findElement(lblDoubleClickCount).getText();
		Assert.assertEquals(actualCount, expectedCount, "Verifying Double Click event counts");
	}

	public void verifyRightClickCount(String expectedCount) {
		String actualCount = driver.findElement(lblRightClickCount).getText();
		Assert.assertEquals(actualCount, expectedCount, "Verifying Right Click event counts");
	}

	public void verifySubmitAnotherResponseLink() {
		driver.findElement(lnkSubmitAnotherResponse).isDisplayed();
	}

}
