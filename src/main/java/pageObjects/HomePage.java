package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class HomePage extends BasePage {
	private static WebElement element = null;
	private static By elementLoc = null;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public static WebElement lnk_MyAccount() throws Exception {
		try {
			element = driver.findElement(By.xpath("//*[@id='account']/a"));
			Log.info("My Account link is found on Home Page");
		} catch (Exception ex) {
			Log.error("My Account link is not found on Home Page");
			throw (ex);
		}
		
		return element;
	}
	
	public static WebElement lnk_LogOut() throws Exception {
		try {
			element = driver.findElement(By.xpath("//*[@id='account_logout']/a"));
			Log.info("Log Out link is found on Home Page");
		} catch (Exception ex) {
			Log.error("Log Out link is not found on Home Page");
			throw (ex);
		}
		
		return element;
	}
	
	public static By lnk_LogOutLoc() throws Exception {
		try {
			elementLoc = By.xpath("//*[@id='account_logout']/a");
			Log.info("Log Out link location is found on Home Page");
		} catch (Exception ex) {
			Log.error("Log Out link location is not found on Home Page");
			throw (ex);
		}
		return elementLoc;
	}
	
	public static class TopMenu {
		public static class ProductCategory {
			private static WebElement subElement;
			
			public static WebElement productMenu() throws Exception {
				try {
					subElement = driver.findElement(By.xpath("//*[@id='menu-item-33']/a"));
					Log.info("Product Menu is found on Home Page");
				} catch (Exception ex) {
					Log.error("Product Menu is not found on Home Page");
					throw (ex);
				}
				
				return subElement;
			}
			
			public static WebElement accessories() throws Exception {
				try {
					subElement = driver.findElement(By.xpath("//*[@id='menu-item-34']/a"));
					Log.info("Accessories is found under Product Category");
				} catch (Exception ex) {
					Log.error("Accessories is not found under Product Category");
					throw (ex);
				}
				
				return subElement;
			}
			
			public static WebElement iMacs() throws Exception {
				try {
					subElement = driver.findElement(By.xpath("//*[@id='menu-item-35']/a"));
					Log.info("iMacs is found under Product Category");
				} catch (Exception ex) {
					Log.error("iMacs is not found under Product Category");
					throw (ex);
				}
				
				return subElement;
			}
			
			public static WebElement iPads() throws Exception {
				try {
					subElement = driver.findElement(By.xpath("//*[@id='menu-item-36']/a"));
					Log.info("iPads is found under Product Category");
				} catch (Exception ex) {
					Log.error("iPads is not found under Product Category");
					throw (ex);
				}
				
				return subElement;
			}
			
			public static WebElement iPhones() throws Exception {
				try {
					subElement = driver.findElement(By.xpath("//*[@id='menu-item-37']/a"));
					Log.info("iPhones is found under Product Category");
				} catch (Exception ex) {
					Log.error("iPhones is not found under Product category");
					throw (ex);
				}
				
				return subElement;
			}
			
			public static WebElement iPods() throws Exception {
				try {
					subElement = driver.findElement(By.xpath("//*[@id='menu-item-38']/a"));
					Log.info("iPods is found under Product category");
				} catch (Exception ex) {
					Log.error("iPods is not found under Product Category");
					throw (ex);
				}
				
				return subElement;
			}
			
			public static WebElement macBooks() throws Exception {
				try {
					subElement = driver.findElement(By.xpath("//*[@id='menu-item-39']/a"));
					Log.info("MacBooks is found under Product category");
				} catch (Exception ex) {
					Log.error("Macbooks is not found under Product category");
					throw (ex);
				}
				
				return subElement;
			}
		}
	}
}
