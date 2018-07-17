package appModules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pageObjects.PaymentDetailsPage;
import utility.Log;
import utility.Constant;
import utility.ExcelUtils;
import pageObjects.BasePage;
import utility.Utils;

import org.testng.Reporter;

public class PaymentDetails_Action {
	public static void execute(int testCaseRow) throws Exception {
		WebElement element = null;
		try {
			String firstName = ExcelUtils.getCellDataExcel(testCaseRow, Constant.INDEXCOLFIRSTNAME);
			element = PaymentDetailsPage.txtFirstName();
			utility.Utils.waitElementFirstName();
			element.clear();
			element.sendKeys(firstName);
			Log.info("FirstName data has just inputed into textbox Firstname");
			String lastName = ExcelUtils.getCellDataExcel(testCaseRow, Constant.INDEXCOLLASTNAME);
			element = PaymentDetailsPage.txtLastName();
			element.clear();
			element.sendKeys(lastName);
			Log.info("LastName data has just inputed into textbox LastName");
			String address = ExcelUtils.getCellDataExcel(testCaseRow, Constant.INDEXCOLADDRESS);
			element = PaymentDetailsPage.txtAddress();
			element.clear();
			element.sendKeys(address);
			Log.info("Address data has just inputed into textbox Address");
			String city = ExcelUtils.getCellDataExcel(testCaseRow, Constant.INDEXCOLCITY);
			element = PaymentDetailsPage.txtCity();
			element.clear();
			element.sendKeys(city);
			Log.info("City data has just inputed into textbox City");
			String undefined = "anonmous.vn1985 Undefined";
			element = PaymentDetailsPage.txtUndefined();
			element.clear();
			element.sendKeys(undefined);
			String country = ExcelUtils.getCellDataExcel(testCaseRow, Constant.INDEXCOLCOUNTRY);
			/*element = PaymentDetailsPage.dropDownCountry();
			element.click();
			List<WebElement> listOptions = PaymentDetailsPage.findListOptions();
			for (WebElement option : listOptions) {
				if(option.getText().equalsIgnoreCase("Denmark")) {
					option.click();
					break;
				}
			}*/
			// Or Using Select:
			utility.Utils.selectOptionCountry().selectByVisibleText(country);
			String phone = ExcelUtils.getCellDataExcel(testCaseRow, Constant.INDEXCOLPHONE);
			element = PaymentDetailsPage.txtPhone();
			element.clear();
			element.sendKeys(phone);
			element = PaymentDetailsPage.checkbox_SameAsBillingAddress();
			utility.Utils.waitSameAsBilling();
			if (!element.isSelected()) {
				element.click();
			}
			element = PaymentDetailsPage.btnPurchase();
			element.click();
			Log.info("Click Action is performed on Purchase button");
			Reporter.log("Purchasion is successful performed on Payment Details Page");
		} catch (Exception ex) {
			throw (ex);
		}
	}
}
