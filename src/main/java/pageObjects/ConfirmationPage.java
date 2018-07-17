package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class ConfirmationPage extends BasePage {
	private static WebElement element;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
	}
	
	public static WebElement txtProductName() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//table[@class='wpsc-purchase-log-transaction-results']/tbody/tr/td[1]"));
			Log.info("Product Name is found on Confirmation page");
		} catch (Exception ex) {
			Log.error("Product Name is not found on Confirmation page");
			throw (ex);
		}
		
		return element;
	}
	
	public static WebElement txtProductPrice() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//table[@class='wpsc-purchase-log-transaction-results']/tbody/tr/td[2]"));
			Log.info("Product price is found on confirmation page");
		} catch (Exception ex) {
			Log.error("Product price is not found on Confirmation page");
			throw (ex);
		}
		
		return element;
	}
}
