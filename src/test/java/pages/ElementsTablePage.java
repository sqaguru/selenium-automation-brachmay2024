package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementsTablePage {
	WebDriver driver;

	public ElementsTablePage(WebDriver driver) {
		this.driver = driver;
	}

	By lblFirstRowFirstName = By.xpath("(//tbody//tr//th[@id='first-name'])[1]");
	By firstRowDeleteBtn = By.xpath("(//tbody//tr//td[@id='action']//button)[1]");

	By tablePanel = By.xpath("(//div[@id='panel3d-header'])[2]");

	public void clickOnTablePanel() {
		driver.findElement(tablePanel).click();
	}

	public void clickFirstRowDeleteButton() {
		driver.findElement(firstRowDeleteBtn).click();
	}

	public String getFirstRowText() {
		return driver.findElement(lblFirstRowFirstName).getText();
	}

}
