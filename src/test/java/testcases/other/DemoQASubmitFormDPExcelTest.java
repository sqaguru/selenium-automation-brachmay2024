package testcases.other;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testcases.Listener;

public class DemoQASubmitFormDPExcelTest extends BasePage {

	@Test(dataProvider = "testDataExcel")
	// @Parameters({ "userName", "email", "currentAddress", "permanentAddress" })
	public void demoSubmitFormTest(HashMap<String, String> testDataMaps2) throws InterruptedException {
		Listener listener = new Listener();

		EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<WebDriver>(listener);

		driver = decorator.decorate(driver);

		driver.get("https://demoqa.com/text-box");// navigate url

		String pageTitle = driver.getTitle();

		System.out.println("pageTitle: " + pageTitle);

		WebElement userNameTextBox = driver.findElement(By.id("userName"));

		String userNameAutoCompleteAttribute = userNameTextBox.getAttribute("autocomplete");
		System.out.println("userNameAutoCompleteAttribute: " + userNameAutoCompleteAttribute);

		String placeholderAttribute = userNameTextBox.getAttribute("placeholder");
		System.out.println("placeholderAttribute: " + placeholderAttribute);

		String typeAttribute = userNameTextBox.getAttribute("type");
		System.out.println("typeAttribute: " + typeAttribute);

		userNameTextBox.isDisplayed();// it will verify if the element is displayed or not.

		userNameTextBox.isEnabled();// will verify if the element is enabled

		userNameTextBox.sendKeys(testDataMaps2.get("Full_Name"));// find an element and type text

		driver.findElement(By.id("userEmail")).sendKeys(testDataMaps2.get("Email"));// find user email element and
		// type text
		driver.findElement(By.id("currentAddress")).sendKeys(testDataMaps2.get("Temporary_Address"));

		driver.findElement(By.id("permanentAddress")).sendKeys("Hyderabad");// not recommended

		Thread.sleep(2000);

		driver.findElement(By.id("submit")).click();// entering the form

		Thread.sleep(2000);

		// ############### verify user name text ###############

		driver.findElement(By.id("name")).isDisplayed();// validating the message has prompted

		// #################################### verify text passed
		// ###########################################
		System.out.println("test passed successfully");

	}

	@DataProvider(name = "testDataExcel")
	public Object[] getExcelData() throws IOException {

		Object[] object = getExcelData2("testdata");
		return object;
	}

	@DataProvider(name = "testDataExcel2")
	public Object[] getExcelData2() throws IOException {

		Object[] object = getExcelData2("testdata2");
		return object;
	}

	@DataProvider(name = "testDataExcel3")
	public Object[] getExcelData3() throws IOException {

		Object[] object = getExcelData2("testdata");
		return object;
	}

	@DataProvider(name = "testDataExcel4")
	public Object[] getExcelData4() throws IOException {

		Object[] object = getExcelData2("testdata2");
		return object;
	}

	public Object[] getExcelData2(String sheetName) throws IOException {

		System.out.println("reading excel data..");

		FileInputStream fileInputStream = new FileInputStream(
				"D:\\techaxisgroup\\batch202405\\selenium-automation-maven-2024may-ws\\selenium_automation_maven_may24\\src\\test\\resources\\testdata\\TestData.xls");

		try (HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream)) {
			HSSFSheet sheetTestData = workbook.getSheet(sheetName);// reading a specific sheet of workbook

			int totalRows = sheetTestData.getPhysicalNumberOfRows();

			Object[] object = new Object[totalRows - 1];

			System.out.println("totalRows: " + totalRows);

			int totalColumns = sheetTestData.getRow(0).getPhysicalNumberOfCells();

			System.out.println("total columns: " + totalColumns);

			for (int rowCounter = 1; rowCounter < totalRows; rowCounter++) {
				HashMap<String, String> testData = new HashMap<String, String>();

				HSSFRow testDataHeaderRow = sheetTestData.getRow(0);
				HSSFRow testDataRow = sheetTestData.getRow(rowCounter);
				for (int columnCounter = 0; columnCounter < totalColumns; columnCounter++) {
					String cellHeaderData = testDataHeaderRow.getCell(columnCounter).getStringCellValue();
					String cellTestData = testDataRow.getCell(columnCounter).getStringCellValue();
					testData.put(cellHeaderData, cellTestData);
					System.out.println("cell header: " + cellHeaderData + "\ncell data: " + cellTestData);
				}
				object[rowCounter - 1] = testData;
			}
			return object;
		}
	}
}
