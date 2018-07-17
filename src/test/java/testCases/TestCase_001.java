package testCases;

import pageObjects.BasePage;

import org.testng.annotations.Test;

import appModules.SignIn_Action;
import appModules.Verification_Action;
import appModules.CheckOut_Action;
import appModules.ProductSelection_Action;
import appModules.PaymentDetails_Action;
import appModules.Confirmation_Action;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import utility.Constant;
import utility.Log;

public class TestCase_001 extends ConfigurationTestCase {
	@BeforeMethod
	public void setupBeforeMethod() throws Exception {
		super.setupBeforeMethod();
		configureDriver(this.toString());
	}
	
	@Test
	public void main() throws Exception {
		try {			
			SignIn_Action.execute(testCaseRow);
			ProductSelection_Action.productCategory(testCaseRow);
			ProductSelection_Action.productNumber(testCaseRow);		
			CheckOut_Action.execute(testCaseRow);			
			PaymentDetails_Action.execute(testCaseRow);
			Confirmation_Action.execute();	
			Verification_Action.execute();
			
			if (BasePage.bResult == true) {
				utility.ExcelUtils.setCellDataExcel("PASSED",Constant.INDEXCOLRESULT, testCaseRow);
			} else {
				throw new Exception ("Testcase is Failed because of Verifiacation");
			}
		} catch (Exception ex) {
			utility.ExcelUtils.setCellDataExcel("FAILED", Constant.INDEXCOLRESULT, testCaseRow);
			utility.Utils.takeScreenShot(driver, utility.Utils.getNameClass(this.toString()));
			Log.error(ex.getMessage());
			throw (ex);
		}
	}
	
	@AfterMethod
	public void setupAfterMethod() {
		super.setupAfterMethod();
	}
}
