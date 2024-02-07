package bharu;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import mini.DriverSetup;

import org.openqa.selenium.*;
public class Slider
  {
	static String baseUrl ="http://webapps.tekstac.com/OnlineShopping/fashion.html";
	public static WebDriver driver;
	public static String productInfo,quantityInfo,priceInfo;

	public WebDriver createDriver()
	{
		driver = DriverSetup.getWebDriver();
		driver.get(baseUrl);
		return driver;
		
		
	}
		public void implDragnDrop() 
		{
		WebElement source1= driver.findElement(By.id("Shirts"));
		WebElement target = driver.findElement(By.id("droppable"));
					Actions buider = new Actions(driver);
		}
  }
