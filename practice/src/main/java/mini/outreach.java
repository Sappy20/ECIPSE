package mini;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class outreach {

	public static void main(String[] args) throws InterruptedException {
		
WebDriver driver;
driver= new ChromeDriver();
driver.get("https://onecognizant.cognizant.com/Home");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

WebElement searchbar=driver.findElement(By.id("oneC_searchAutoComplete"));
searchbar.click();
searchbar.sendKeys("Outreach");

WebElement outreach_btn=driver.findElement(By.xpath("(//div[@class='appsResultText'])[1]"));
outreach_btn.click();

Thread.sleep(2000);


WebElement frame1= driver.findElement(By.xpath("//iframe[@id='appFrame']"));
driver.switchTo().frame(frame1);
WebElement search_eventsdrp=driver.findElement(By.xpath("//span[@class='vieweventDrop']"));
search_eventsdrp.click();
/*

//Click  on event location dropdown
List<WebElement> location_drp=driver.findElements(By.xpath("(//span[@class='filter-option pull-left'])[1]"));
System.out.println(location_drp.size());


	//click on event type
WebElement Event_Type = driver.findElement(By.xpath("(//span[@class='filter-option pull-left'])[2]"));
Event_Type.click();


// select day type
WebElement Day_Type  = driver.findElement(By.xpath("(//span[@class='filter-option pull-left'])[3]"));
Day_Type.click();

WebElement weekday =driver.findElement(By.xpath("//span[@class='dropdown-item-inner ']//*[contains(text(),' Weekday ')]"));

WebElement weekends =driver.findElement(By.xpath("//span[@class='dropdown-item-inner ']//*[contains(text(),'Weekend')]"));

WebElement  both=driver.findElement(By.xpath("//span[@class='dropdown-item-inner ']//*[contains(text(),' Both ')]"));

WebElement education_eventtype  = driver.findElement(By.xpath("(//*[contains(text(),'Education')])[1]"));

WebElement   = driver.findElement(By.xpath(null));

WebElement   = driver.findElement(By.xpath(null));

*/


driver.findElement(By.xpath("(//span[contains(text(),'Choose')])[1]")).click();
driver.findElement(By.xpath("(//span[contains(text(),'Education')])[1]")).click();
driver.findElement(By.xpath("(//span[contains(text(),'Choose')])[2]")).click();
driver.findElement(By.xpath("(//span[contains(text(),'Weekend')])[1]")).click();

///// Current date
	Date date = Calendar.getInstance().getTime();  
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
	String strDate = dateFormat.format(date);      
	driver.findElement(By.xpath("(//input[@placeholder='YYYY-MM-DD'])[1]")).sendKeys(strDate);
	
	
	//To date is disabled or not
	// to open the date picker
			driver.findElement(By.xpath("//*[@id='toDate']")).click();
	
			String Enable = driver.findElement(By.xpath("(//td[@class='day'])[1]//preceding-sibling::td[1]")).getAttribute("class");
			System.out.println(Enable);
			
			//Searching in outreach
			driver.findElement(By.xpath("(//div[@class='ce-dateicondiv'])[2]")).click();
			driver.findElement(By.xpath("//*[@id='eventsHomeSearchBtn']")).click();
			//Printing the event information
			String before_x = "//*[@id='divsearchevents']/div[";
			String after_x = "]/div[1]/div";
			// list of events present
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='card_eventscroll marginleft0']"));
			int size = list.size();
			for(int i=1;i<=size;i++)
			{
				System.out.println(driver.findElement(By.xpath(before_x + i + after_x)).getText());
			}
			
			List<WebElement> list_loc=driver.findElements(By.xpath("//span[@class='dropdown-item-inner ']"));
			int loc_size= list_loc.size();
			for(int i=1;i<=loc_size;i++)
			{
			
				
			}
driver.quit();
}

}
