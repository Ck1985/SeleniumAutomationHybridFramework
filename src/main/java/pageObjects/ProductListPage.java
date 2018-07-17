package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class ProductListPage extends BasePage {
	private static WebElement element, view;
	private static By elementLoc;
	
	public ProductListPage(WebDriver driver) {
		super(driver);
	}
	
	private static String getAttributeView() throws Exception {
		view = null;
		try {
			WebElement grid = driver.findElement(By.xpath("//*[@id='default_products_page_container']/div/div/a[@title='Grid View']"));
			WebElement list = driver.findElement(By.xpath("//*[@id='default_products_page_container']/div/div/a[@title='Default View']"));
			if (grid.getAttribute("class").equals("grid active")) {
				view = grid;
			} else if (list.getAttribute("class").equals("default active")) {
				view = list;
			}
		} catch (Exception ex) {
			throw (ex);
		}
		
		return view.getAttribute("class");		
	}
	
	public static class Product_1 {
		public static String productName;
		public static WebElement txtProductName() throws Exception {
			element = null;
			try {
				if (getAttributeView().equals("grid active")) {
					element = driver.findElement(By.xpath("//*[@class='product_grid_item product_view_40']/div[4]/h2/a"));
				} else if (getAttributeView().equals("default active")) {
					element = driver.findElement(By.xpath("//*[@id='default_products_page_container']/div[4]/div[2]/h2/a"));
				}
				Log.info("Product name is found for Product_1");
			} catch (Exception ex) {
				Log.error("Product name is not found for Product_1");
				throw (ex);
			}
			
			return element;
		}
		
		public static WebElement txtProductPrice() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.xpath("//*[@class='product_grid_item product_view_40']/div[2]/div/p[2]/span"));
				Log.info("Product Price is found for Product_1");
			} catch (Exception ex) {
				Log.error("Product Price is not found for Product_1");
				throw (ex);
			}
			
			return element;
		}
		
		public static WebElement imgProduct() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.xpath("//*[@class='product_grid_item product_view_40']/div/a"));
				Log.info("Product image is found for Product_1");
			} catch (Exception ex) {
				Log.error("Product image is not found for Product_1");
				throw (ex);
			}
			return element;
		}
		
		public static WebElement btnAddToCart() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.xpath("//*[@name='product_40']/div/div/span/input"));
				Log.info("AddToCart Button is found for Product_1");
			} catch (Exception ex) {
				Log.error("AddToCart Buttong is not found for Product_1");
				throw (ex);
			}
			
			return element;
		}
		
		public static WebElement alertAddToCart() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.cssSelector("form[name='product_40']>div>div>div:nth-of-type(2)>p"));
				Log.info("Alert AddToCart is found for Product 1");
			} catch (Exception ex) {
				Log.error("Alert AddToCart is not found for Product 1");
				throw (ex);
			}
			
			return element;
		}
		
		public static By alertAddToCartLoc() throws Exception {
			elementLoc = null;
			try {
				elementLoc = By.cssSelector("form[name='product_40']>div>div>div:nth-of-type(2)>p");
				Log.info("Alert AddToCart Location is found for Product 1");
			} catch (Exception ex) {
				Log.error("Alert AddToCart Location is not found for Product 1");
				throw (ex);
			}
			
			return elementLoc;
		}
	}
	
	public static class Product_2 {
		public static String productName;
		public static WebElement imgProduct() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.xpath("//*[@class='product_grid_item product_view_89']/div/a"));
				Log.info("Product image is found for Product_2");
			} catch (Exception ex) {
				Log.error("Product image is not found ofr Product_2");
				throw (ex);
			}
			
			return element;
		}
		
		public static WebElement txtProductName() throws Exception {
			element = null;
			try {
				if (getAttributeView().equals("grid active")) {
					element = driver.findElement(By.xpath("//*[@class='product_grid_item product_view_89']/div[4]/h2/a"));
				} else if (getAttributeView().equals("default active")) {
					element = driver.findElement(By.xpath("//*[@id='default_products_page_container']/div[4]/div[2]/h2/a"));
				}
				Log.info("Product name is found for Product_2");
			} catch (Exception ex) {
				Log.error("Product name is not found for Product_2");
				throw (ex);
			}
			
			return element;
		}
		
		public static String getProductName() throws Exception {
			return txtProductName().getText();
		}
		
		public static WebElement txtProductPrice() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.xpath("//*[@class='product_grid_item product_view_89']/div[2]/div/p[2]/span"));
				Log.info("Product Price is found for Product_2");
			} catch (Exception ex) {
				Log.error("Product Price is not found for Product_2");
				throw (ex);
			}
			
			return element;
		}
		
		public static WebElement btnAddToCart() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.xpath("//*[@name='product_89']/div/div/span/input"));
				Log.info("AddToCart button is found for Product_2");
			} catch (Exception ex) {
				Log.error("AddToCart Button is not found for Product_2");
				throw (ex);
			}
			
			return element;
		}
		
		public static WebElement alertAddToCart() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.cssSelector("form[name='product_89']>div>div>div:nth-of-type(2)>p"));
				Log.info("Alert AddToCart is found for Product 2");
			} catch (Exception ex) {
				Log.error("Alert AddToCart is not found for Product 2");
				throw (ex);
			}
			
			return element;
		}
		
		public static By alertAddToCartLoc() throws Exception {
			elementLoc = null;
			try {
				elementLoc = By.cssSelector("form[name='product_89']>div>div>div:nth-of-type(2)>p");
				Log.info("Alert AddToCart Location is found for Product 2");
			} catch (Exception ex) {
				Log.error("Alert AddToCart Location is not found for Product 2");
				throw (ex);
			}
			
			return elementLoc;
		}
	}
	
	public static class IconGoToCart {
		public static WebElement btn_GoToCart() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.xpath("//*[@id='header_cart']"));
				Log.info("GoToCart button is found ProductList Page");
			} catch (Exception ex) {
				Log.error("GoToCart button is not found on ProductList Page");
				throw (ex);
			}
			
			return element;
		}
		
		public static By btn_GoToCartLoc() throws Exception {
			elementLoc = null;
			try {
				elementLoc = By.xpath("//*[@id='header_cart']");
				Log.info("GoToCart button Location is found ProductList Page");
			} catch (Exception ex) {
				Log.error("GoToCart button Location is not found on ProductList Page");
				throw (ex);
			}
			
			return elementLoc;
		}
	}
}
