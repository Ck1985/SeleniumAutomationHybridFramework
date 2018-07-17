package appModules;

import pageObjects.BasePage;
import pageObjects.CheckOutPage;
import pageObjects.ConfirmationPage;

import org.testng.Reporter;

import appModules.*;

public class Verification_Action {
	private static String CheckoutName;
	private static String CheckoutPrice;
	private static String ConfirmationName;
	private static String ConfirmationPrice;
	
	public static void execute() throws Exception {
		CheckoutName = CheckOut_Action.productName;
		CheckoutPrice = CheckOut_Action.productPrice;
		ConfirmationName = Confirmation_Action.productName;
		ConfirmationPrice = Confirmation_Action.productPrice;
		
		if (CheckoutName.equalsIgnoreCase(ConfirmationName) && CheckoutPrice.equalsIgnoreCase(ConfirmationPrice)) {
			Reporter.log("Final Verification Product Name is Passed");
			BasePage.bResult = true;
		} else {
			Reporter.log("Final verification Product Name is Failed");
			BasePage.bResult = false;
		}
	}
}
