package seleniumtests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelReader {

	public static void main(String[] args) throws IOException {
		getExcelTestData();
	}

	private static void getExcelTestData() throws IOException {
		System.out.println("reading excel data..");

		FileInputStream fileInputStream = new FileInputStream(
				"D:\\techaxisgroup\\demomay2024\\test-automation-may24-ws\\test_automation_amazon\\resources\\testdata\\TestData.xls");

		HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);// excel reader class - type .xls

		HSSFSheet sheetTestData = workbook.getSheet("testdata");// reading a specific sheet of workbook

		int totalRows = sheetTestData.getPhysicalNumberOfRows();

		System.out.println("totalRows: " + totalRows);

		int totalColumns = sheetTestData.getRow(0).getPhysicalNumberOfCells();

		System.out.println("total columns: " + totalColumns);

		for (int rowCounter = 1; rowCounter < totalRows; rowCounter++) {
			HSSFRow testDataHeaderRow = sheetTestData.getRow(0);
			HSSFRow testDataRow = sheetTestData.getRow(rowCounter);
			for (int columnCounter = 0; columnCounter < totalColumns; columnCounter++) {
				String cellHeaderData = testDataHeaderRow.getCell(columnCounter).getStringCellValue();
				String cellTestData = testDataRow.getCell(columnCounter).getStringCellValue();

				System.out.println("cell header: " + cellHeaderData + "\ncell data: " + cellTestData);
			}
		}
	}

}
