package mini;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.*;

public class extramini {
	public static String link_web;
	public static int links ;
	public static WebElement element;
	public static WebDriver driver ;
	 
	public WebDriver setupDriver()
	{
		
		WebDriver driver =null;
		System.out.println("Choose Your Browser ");
		System.out.println(" 1 for Chromebrowser \n 2 for Edgebrowser ");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		input.close();
		
			/*
		  * Click on Help button, one browser window should open. 
			Click on Online Chat Support button, so that one browser window should open. 
			Click on Visit Us button, so that one browser window should open. 
			Get the collection of all browser windows opened. 
			Find the browser window having title “Visit Us”
			
			 */
		
		// options for multiple browser
		if(choice==1) 
		{
			// 1 for Chrome Browser
			driver = new ChromeDriver();
		}
		else if(choice==2) 
		{  
			// 2 for Edge Browser
			driver = new EdgeDriver();
			}
		driver.get("http://cookbook.seleniumacademy.com/Config.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().window().maximize();
		 return driver;
	}
	public void setElements()
	{
    driver.findElement(By.xpath("//*[@name='make']")).click();  // selecting dropdown
    driver.findElement(By.xpath("//input[@value='Diesel']")).click(); //select diesel
  
   driver.findElement(By.xpath("//input[@name='parksensor']")).click();  // select parking sensor
   
  driver.findElement(By.xpath("//*[contains(text(),\"Help\")]")).click(); // help button
  // driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/button[1]")).click();
	}
	
	
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		extramini hand = new extramini();
		hand.setupDriver();
		hand.setElements();
		
		driver.quit();
	}

}
