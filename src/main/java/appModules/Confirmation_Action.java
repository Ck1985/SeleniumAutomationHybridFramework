package appModules;

import pageObjects.BasePage;
import pageObjects.ConfirmationPage;
import org.testng.Reporter;

public class Confirmation_Action {
	static String productName;
	static String productPrice;
	
	public static void execute() throws Exception {
		productName = ConfirmationPage.txtProductName().getText();
		productPrice = ConfirmationPage.txtProductPrice().getText();
		
		if (!productName.equals("")) {
			Reporter.log("Verification Name is Passed on Confirmation page");
			BasePage.bResult = true;
		} else {
			Reporter.log("Verification Name is Failed on Confirmation page");
			BasePage.bResult = false;
		}
		
		if (!productPrice.equals("")) {
			Reporter.log("Verification Price is Passed on Confirmation page");
			BasePage.bResult = true;
		} else {
			Reporter.log("Verification Price is Failed on Confirmation page");
			BasePage.bResult = false;
		}
	}
}
