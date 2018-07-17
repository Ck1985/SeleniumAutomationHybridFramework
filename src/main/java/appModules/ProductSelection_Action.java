package appModules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
import utility.Utils;
import utility.Constant;
import utility.ExcelUtils;
import pageObjects.ProductListPage;

public class ProductSelection_Action {
	public static String productName;
	public static void productCategory(int testCaseRow) throws Exception {
		try {
			Utils.mouseHoverAction(testCaseRow);
			Utils.action.click().build().perform();
			Log.info("Click Action is performed on Product Type");
		} catch (Exception ex) {
			throw (ex);
		}
	}
	
	public static void productNumber(int testCaseRow) throws Exception {
		String productNumber = null;
		productName = null;
		try {
			productNumber = ExcelUtils.getCellDataExcel(testCaseRow, Constant.INDEXCOLPRODUCTNUMBER);
			if (productNumber.equalsIgnoreCase("Product 1")) {
				ProductListPage.Product_1.btnAddToCart().click();
				utility.Utils.waitAlertVisible(ProductListPage.Product_1.alertAddToCartLoc());
				Log.info("Product 1 is selected from ProductList Page");
			} else if (productNumber.equalsIgnoreCase("Product 2")) {
				productName = ProductListPage.Product_2.getProductName();
				ProductListPage.Product_2.btnAddToCart().click();
				utility.Utils.waitAlertVisible(ProductListPage.Product_2.alertAddToCartLoc());
				Log.info("Product 2 is selected from ProductList Page");
			} else if (productNumber.equalsIgnoreCase("")) {
				Log.warn("Excel value for Product Number is blank");
			}			
			Log.info("Alert AddToCart has just surfaced, now we go to Cart.");
			utility.Utils.clickGoToCart();
			Thread.sleep(3000);
			ProductListPage.IconGoToCart.btn_GoToCart().click();
			Log.info("Click Action has just performed on Gotocart button");
		} catch (Exception ex) {
			throw (ex);
		}
	}
}
