package appModules;

import org.testng.Reporter;

import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utility.Constant;
import utility.ExcelUtils;
import utility.Utils;
import utility.Log;

public class SignIn_Action {
	public static void execute(int testCaseRow) throws Exception {
		String userName = null, password = null;
		
		userName = ExcelUtils.getCellDataExcel(testCaseRow, Constant.INDEXCOLUSERNAME);
		password = ExcelUtils.getCellDataExcel(testCaseRow, Constant.INDEXCOLPASSWORD);
		
		HomePage.lnk_MyAccount().click();
		Log.info("Click action is performed on My Account link");
		LoginPage.txt_Username().sendKeys(userName);
		Log.info(userName + " is entered into Username textbox");
		LoginPage.txt_Password().sendKeys(password);
		Log.info(password + " is entered into Password textbox");
		LoginPage.btn_Login().click();
		Log.info("Click action is performed on Submit button");
		Utils.driver = BasePage.driver;
		Utils.waitElementByLoc(HomePage.lnk_LogOutLoc());
		Reporter.log("Sign in action is successfully performed !");	
	}
}
