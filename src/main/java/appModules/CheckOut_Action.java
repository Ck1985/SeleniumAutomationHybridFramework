package appModules;

import org.testng.Reporter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.CheckOutPage;
import pageObjects.BasePage;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import pageObjects.ProductListPage;

public class CheckOut_Action {
	static String productName;
	static String productPrice;
	private static String productNameExpected;
	
	public static void execute(int testCaseRow) throws Exception {
		productName = CheckOutPage.txtProductName().getText();
		productPrice = CheckOutPage.txtProductPrice().getText();
		System.out.println(productName);
		System.out.println(productPrice);
		
		String productNumberExpected = ExcelUtils.getCellDataExcel(testCaseRow, Constant.INDEXCOLPRODUCTNUMBER);	
		System.out.println(productNumberExpected);
		
		if (productNumberExpected.equalsIgnoreCase("Product 1")) {
			
		} else if (productNumberExpected.equalsIgnoreCase("Product 2")) {
			productNameExpected = ProductSelection_Action.productName;
			System.out.println(productNameExpected);
		}
			
		if (productName.equals("") || productPrice.equals("")) {
			Reporter.log("Product Name is null so Verification is Failed on CheckOut Page");
			Log.error("Product Name is null so Verification is Failed on CheckOut Page");
			BasePage.bResult = false;
		} else if (!productName.equalsIgnoreCase(productNameExpected)) {
			Reporter.log("Product Name is not match so that Verification is Failed on Checkout Page");
			Log.error("Product Name is not match so that Verification is Failed on Checkout Page");
			BasePage.bResult = false;
		} else {
			Reporter.log("Verification is Passed on Checkout Page");
			Log.info("Verification is Passed on Checkout Page");
			BasePage.bResult = true;
		}
		
		CheckOutPage.btnContinue().click();
		Log.info("Action is performed on button continue");
	}
}
