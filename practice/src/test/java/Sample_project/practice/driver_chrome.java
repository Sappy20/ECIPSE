package Sample_project.practice;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;

public class driver_chrome {
public static void main(String args[]) throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver-win64\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://webapps.tekstac.com/MultipleWindow/");
	//driver.findElement(By.xpath("/html/body/div/div/form/table/tbody/tr[3]/td[2]/input")).sendKeys("ABC");
	driver.findElement(By.xpath("//a[contains(text(),'Click to calculate EMI')]")).click();
	String parent_window=driver.getWindowHandle();
	 
	Set<String>child_window=driver.getWindowHandles();
	
	Iterator<String> I1= child_window.iterator();
	 
	while(I1.hasNext())
	{
	 
	String child_window_1=I1.next();
	 
	 
	if(!parent_window.equals(child_window_1))
	{
	driver.switchTo().window(child_window_1);
	 
	System.out.println(driver.switchTo().window(child_window_1).getTitle());
	driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("ABC");
	
	
	 driver.findElement(By.xpath("//input[@id='year']")).sendKeys("5");
	 Thread.sleep(5000);
	driver.close();
	}
	
	
}
}
}
