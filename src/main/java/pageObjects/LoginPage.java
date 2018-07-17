package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
	private static WebElement element;
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public static WebElement txt_Username() throws Exception {
		try {
			element = driver.findElement(By.id("log"));
		} catch (Exception ex) {
			throw (ex);
		}
		
		return element;
	}
	
	public static WebElement txt_Password() throws Exception {
		try {
			element = driver.findElement(By.id("pwd"));
		} catch (Exception ex) {
			throw (ex);
		}
		
		return element;
	}
	
	public static WebElement btn_Login() throws Exception {
		try {
			element = driver.findElement(By.id("login"));
		} catch (Exception ex) {
			throw (ex);
		}
		return element;
	}
}
