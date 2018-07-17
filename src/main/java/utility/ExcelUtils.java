package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;

import utility.Log;

public class ExcelUtils {	
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFRow row;
	private static XSSFCell cell;
	
	public static void setExcelFile(String excelPath, String excelFileName, String sheetName) throws FileNotFoundException, IOException {
		try {
			FileInputStream inputStream = new FileInputStream(excelPath + "\\" + excelFileName);
			workbook = new XSSFWorkbook(inputStream);
			sheet = workbook.getSheet(sheetName);
			Log.info("Excel sheet opened");
		} catch (FileNotFoundException ex) {
			throw (ex);
		} catch (IOException ex2) {
			throw (ex2);
		}
	}
	
	public static String getCellDataExcel(int numRow, int numCol) throws Exception {
		try {
			String resultData = null;
			row = sheet.getRow(numRow);
			cell = row.getCell(numCol);
			resultData = cell.getStringCellValue();
			return resultData;
		} catch (Exception ex) {
			return "";
		}
	}
	
	@SuppressWarnings({ "static-access", "deprecation" })
	public static void setCellDataExcel(String result, int colNum, int rowNum) throws Exception {
		try {
			row = sheet.getRow(rowNum);
			cell = row.getCell(colNum, row.RETURN_BLANK_AS_NULL);
			if (cell == null) {
				cell = row.createCell(colNum);
				cell.setCellValue(result);
			} else {
				cell.setCellValue(result);
			}
			
			FileOutputStream outputStream = new FileOutputStream(Constant.EXCELPATH + "\\" + Constant.EXCELFILENAME);
			workbook.write(outputStream);
			outputStream.flush();
			outputStream.close();
		} catch (Exception ex) {
			throw (ex);
		}
	}
	
	public static int getContainsRow(String testCaseName, int indexColTestCaseName) throws Exception {
		int indexTestCase = 0, totalRowInExcelFile = 0;
		
		try {
			totalRowInExcelFile = getRowUsed() + 1;
			for (int i = 0; i < totalRowInExcelFile; i++) {
				if (getCellDataExcel(i, indexColTestCaseName).equals(testCaseName)) {
					indexTestCase = i;
					break;
				}
			}
			return indexTestCase;
		} catch (Exception ex) {
			Log.error("Class ExcelUtils | Method getContainsRow | Exception desc: " + ex.getMessage());
			throw (ex);
		}
	}
	
	public static int getRowUsed() throws Exception {
		try {
			int rowUsed = sheet.getLastRowNum();
			Log.info("Total row used is: " + rowUsed);
			return rowUsed;
		} catch (Exception ex) {
			Log.error("Class ExcelUtils | Method getRowUsed | Exception desc: " + ex.getMessage());
			System.out.println(ex.getMessage());
			throw (ex);
		}
	}
}
