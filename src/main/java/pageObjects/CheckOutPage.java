package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class CheckOutPage extends BasePage{
	private static WebElement element;
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
	}
	
	public static WebElement txtProductName() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@id='checkout_page_container']/div/table/tbody/tr[2]/td[2]/a"));
			Log.info("Product Name is found on CheckOut Page");
		} catch (Exception ex) {
			Log.error("Product Name is not found on CheckOut Page");
			throw (ex);
		}
		return element;
	}
	
	public static WebElement txtProductPrice() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@id='checkout_page_container']/div/table/tbody/tr[2]/td[4]/span"));
			Log.info("Product Price is found on CheckOut page");
		} catch (Exception ex) {
			Log.error("Product Price is not found on CheckOut page");
			throw (ex);
		}
		
		return element;
	}
	
	public static WebElement btnContinue() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@id='checkout_page_container']/div/a/span"));
			Log.info("Continue button is found on CheckOut page");
		} catch (Exception ex) {
			Log.error("Continue button is not found on CheckOut page");
			throw (ex);
		}
		
		return element;
	}
}
