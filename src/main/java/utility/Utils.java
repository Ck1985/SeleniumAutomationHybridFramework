package utility;

import java.util.concurrent.TimeUnit;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

import utility.ExcelUtils;
import utility.Constant;
import pageObjects.*;

public class Utils {
	public static WebDriver driver = null;
	public static Actions action = null;
	
	public static WebDriver chooseBrowser(int testCaseRow) throws Exception {
		String browserName = null;
		
		try {
		browserName = ExcelUtils.getCellDataExcel(testCaseRow, Constant.INDEXCOLBROWSER);
		configBrowser(browserName);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Constant.URL);
		} catch (Exception ex) {
			throw (ex);
		}
		
		return driver;
	}
	
	private static void configBrowser(String browserName) {
		if (browserName.equals("Chrome")) {
			System.setProperty(Constant.configChrome, Constant.driverChrome);
			driver = new ChromeDriver();
		} else if (browserName.equals("Firefox")) {
			System.setProperty(Constant.configFirefox, Constant.driverFirefox);
			FirefoxOptions option = new FirefoxOptions();
			option.setBinary("C:\\Program Files\\Firefox Nightly\\firefox.exe");
			driver = new FirefoxDriver(option);
		} else {
			System.setProperty(Constant.configIE, Constant.driverIE);
			driver = new InternetExplorerDriver();
		}
	}
	
	public static void waitElementByLoc(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	public static void waitElementFirstName() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='wpsc_checkout_forms']/div/table[1]/tbody/tr[2]/td[2]/input")));
	}
	
	public static void waitSameAsBilling() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shippingSameBilling")));
	}
	
	public static void waitPurchase() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit")));
	}
	
	public static void waitAlertVisible(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	public static String getNameClass(String source) {
		String result = null;
		int indexAt = source.indexOf("@");
		result = source.substring(0,indexAt);
		indexAt = result.indexOf(".");
		result = result.substring(indexAt + 1);
		return result;
	}
	
	public static void mouseHoverAction(int testCaseRow) throws Exception {
		action = new Actions(driver);
		try {
			String productType = utility.ExcelUtils.getCellDataExcel(testCaseRow, Constant.INDEXCOLPRODUCTTYPE);
			if (productType.equalsIgnoreCase("Accessories")) {
				action.moveToElement(HomePage.TopMenu.ProductCategory.productMenu()).moveToElement(HomePage.TopMenu.ProductCategory.accessories());
				Log.info("Product Category Accessories is selected from Top Menu");
			} else if (productType.equalsIgnoreCase("iMacs")) {
				action.moveToElement(HomePage.TopMenu.ProductCategory.productMenu()).moveToElement(HomePage.TopMenu.ProductCategory.iMacs());
				Log.info("Product category iMacs is selected from Top Menu");
			} else if (productType.equalsIgnoreCase("iPads")) {
				action.moveToElement(HomePage.TopMenu.ProductCategory.productMenu()).moveToElement(HomePage.TopMenu.ProductCategory.iPads());
				Log.info("Product Category iPads is selected from Top Menu");
			} else if (productType.equalsIgnoreCase("iPhones")) {
				action.moveToElement(HomePage.TopMenu.ProductCategory.productMenu()).moveToElement(HomePage.TopMenu.ProductCategory.iPhones());
				Log.info("Product category iphones is selected from Top Menu");
			} else if (productType.equalsIgnoreCase("iPods")) {
				action.moveToElement(HomePage.TopMenu.ProductCategory.productMenu()).moveToElement(HomePage.TopMenu.ProductCategory.iPods());
				Log.info("Product category iPods is selected from Top Menu");
			} else if (productType.equalsIgnoreCase("MacBooks")) {
				action.moveToElement(HomePage.TopMenu.ProductCategory.productMenu()).moveToElement(HomePage.TopMenu.ProductCategory.macBooks());
				Log.info("Product category Macbooks is selected from Top Menu");
			} else {
				Log.warn("Excel value for this Product Category is blank");
			}
		} catch (Exception ex) {
			throw (ex);
		}
		
	}
	
	public static void clickGoToCart() throws Exception {
		WebElement element;
		try {
			element = driver.findElement(By.xpath("//*[@id='header_cart']"));
			Actions action = new Actions(driver);
			action.moveToElement(element).click().build().perform();
		} catch (Exception ex) {
			throw (ex);
		}
	}
	
	public static void clickPurchase() throws Exception {
		WebElement element;
		try {
			element = driver.findElement(By.xpath("//*[@class='input-button-buy']/span/input"));
			Actions action = new Actions(driver);
			action.moveToElement(element).click().build().perform();
		} catch (Exception ex) {
			throw (ex);
		}
	}
	
	public static Select selectOptionCountry() throws Exception {
		Select select = new Select(PaymentDetailsPage.dropDownCountry());
		return select;
	}
	
	public static void takeScreenShot(WebDriver driver, String testCaseName) throws Exception {
		try {
			TakesScreenshot scrShot = (TakesScreenshot)driver;
			File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(Constant.SCREENSHOTPATH + testCaseName + ".jpg"));
		} catch (Exception ex) {
			Log.error("Class Utils | Method takeScreenshot | Exception has occupied while capture screenshot: " + ex.getMessage());
		}
	}
}
