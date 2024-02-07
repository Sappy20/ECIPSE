
package samplesampl1;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class dynamicDropdowns {
 
	public static void main(String[] args) {
		String from_location_expected="Bangalore";
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Trainings for Freshers\\Drivers\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver_used = new ChromeDriver();
		driver_used.navigate().to("https://www.redbus.in/");
		WebElement from_place=driver_used.findElement(By.xpath("//input[@id='src']"));
		from_place.click();
		from_place.sendKeys(from_location_expected);
		List<WebElement> from_placeList=driver_used.findElements(By.xpath("//ul[@class='sc-dnqmqq eFEVtU']/li/div/text[1]"));
		for(WebElement place:from_placeList) {
			driver_used.manage().timeouts().implicitlyWait(500,TimeUnit.MILLISECONDS);
			System.out.println(place.getText());
		}
		
		
		
		
	}
 
}