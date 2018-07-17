package testCases;

import org.apache.log4j.xml.DOMConfigurator;

import org.openqa.selenium.WebDriver;

import pageObjects.BasePage;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class ConfigurationTestCase extends BaseTest {
	protected static WebDriver driver;
	protected static int testCaseRow;
	protected static String testCaseName;
	
	protected void setupBeforeMethod() throws Exception {
		DOMConfigurator.configure(Constant.configLog4j);
		ExcelUtils.setExcelFile(Constant.EXCELPATH, Constant.EXCELFILENAME, "Sheet1");			
	}
	protected void setupAfterMethod() {
		Log.endTestCase();
		driver.quit();
	}
	
	protected void configureDriver(String nameClass) throws Exception {
		testCaseName = utility.Utils.getNameClass(nameClass);
		Log.startTestCase(testCaseName);
		testCaseRow = ExcelUtils.getContainsRow(testCaseName, Constant.INDEXCOLTESTCASENAME);
		driver = utility.Utils.chooseBrowser(testCaseRow);
		driver.manage().window().maximize();
		new BasePage(driver);
	}
}
