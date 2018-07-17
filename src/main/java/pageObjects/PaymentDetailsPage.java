package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class PaymentDetailsPage extends BasePage {
	private static WebElement element;
	
	public PaymentDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	public static WebElement txtFirstName() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@class='wpsc_checkout_forms']/div/table[1]/tbody/tr[2]/td[2]/input"));
			Log.info("TextBox FirstName is found on Payment Details Page");
		} catch (Exception ex) {
			Log.error("TextBox FirstName is not found on Payment Details Page");
			throw (ex);
		}
		
		return element;
	}
	
	public static WebElement txtLastName() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@class='wpsc_checkout_forms']/div/table[1]/tbody/tr[3]/td[2]/input"));
			Log.info("TextBox LastName is found on Payment Details Page");
		} catch (Exception ex) {
			Log.error("TextBox LastName is not found on Payment Details Page");
			throw (ex);
		}
		
		return element;
	}
	
	public static WebElement txtAddress() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@class='wpsc_checkout_forms']/div/table[1]/tbody/tr[4]/td[2]/textarea"));
			Log.info("TextBox Address is found on Payment Details Page");
		} catch (Exception ex) {
			Log.error("TextBox Address is not found on Payment Details Page");
			throw (ex);
		}
		
		return element;
	}
	
	public static WebElement txtCity() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@class='wpsc_checkout_forms']/div/table[1]/tbody/tr[5]/td[2]/input"));
			Log.info("TextBox City is found on Payment Details Page");
		} catch (Exception ex) {
			Log.error("TextBox City is not found on Payment Details Page");
			throw (ex);
		}
		
		return element;
	}
	
	public static WebElement txtUndefined() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@class='wpsc_checkout_forms']/div/table[1]/tbody/tr[6]/td[2]/input"));
			Log.info("TextBox Undefined is found on Payment Details Page");
		} catch (Exception ex) {
			Log.error("TextBox Undefined is not found on Payment Details Page");
			throw (ex);
		}
		
		return element;
	}
	
	public static WebElement dropDownCountry() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@id='uniform-wpsc_checkout_form_7']/select"));
			Log.info("Dropdown Country is found on Payment Details Page");
		} catch (Exception ex) {
			Log.error("Dropdown Country is not found on Payment Details Page");
			throw (ex);
		}
		
		return element;
	}
	
	public static List<WebElement> findListOptions() {
		List<WebElement> listOptions = driver.findElements(By.xpath("//*[@id='region_country_form_7']/div/select//option"));
		return listOptions;
	}
	
	public static WebElement txtPhone() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@class='wpsc_checkout_forms']/div/table[1]/tbody/tr[8]/td[2]/input"));
			Log.info("TextBox Phone is found on Payment Details Page");
		} catch (Exception ex) {
			Log.error("TextBox Phone is not found on Payment Details Page");
			throw (ex);
		}
		
		return element;
	}
	
	public static WebElement checkbox_SameAsBillingAddress() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@class='wpsc_checkout_forms']/div/table[2]/tbody/tr[2]/td/input"));
			Log.info("Checkbox SameAsBilling is found on Payment Details Page");
		} catch (Exception ex) {
			Log.error("Checkbox SameAsBilling is not found on Payment Details Page");
			throw (ex);
		}
		
		return element;
	}
	
	public static WebElement btnPurchase() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//*[@class='input-button-buy']/span/input"));
			Log.info("Purchase button is found on Payment Details Page");
		} catch (Exception ex) {
			Log.error("Purchase button is not found on Payment Details Page");
			throw (ex);
		}
		
		return element;
	}
}
