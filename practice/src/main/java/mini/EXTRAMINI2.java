package mini;
import java.util.concurrent.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class EXTRAMINI2 {
	public static String link_web;
	public static int links ;
	public static WebElement element;
	public static WebDriver driver ;
	

	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	  {
		
	
		WebDriver driver =null;
		System.out.println("Choose Your Browser ");
		System.out.println(" 1 for Chromebrowser \n 2 for Edgebrowser ");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		input.close();
		
		if(choice==1) 
		{
			
			driver = new ChromeDriver();
		}
		else if(choice==2) 
		{  
			
			driver = new EdgeDriver();
			}
		driver.get("http://cookbook.seleniumacademy.com/Config.html");
		String parent_window=driver.getWindowHandle();
		System.out.println(parent_window);
		String act_1 = driver.getTitle();
		String exp_1 = "Build my Car - Configuration";
		Assert.assertEquals(act_1,exp_1,"Webpage validation Failed" );
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 driver.manage().window().maximize();
		 
		//storing all links in a list
		
		
		 driver.findElement(By.xpath("//*[@name='make']")).click();  // selecting dropdown
		    driver.findElement(By.xpath("//input[@value='Diesel']")).click(); //select diesel
		  
		   driver.findElement(By.xpath("//input[@name='parksensor']")).click();  // select parking sensor
		   driver.findElement(By.xpath("//*[contains(text(),\"White\")]")).click(); //select white color
		   
		   
		  driver.findElement(By.xpath("//*[contains(text(),\"Help\")]")).click(); // help button
		 
			 String child_window1= driver.getWindowHandle();
			  System.out.println(child_window1);
		   
		   
		   driver.findElement(By.xpath("//*[contains(text(),\"Online Chat Support\")]")).click(); // online chat support button
		 
		   String child_window2= driver.getWindowHandle();
			  System.out.println(child_window2);
			String Title2=driver.getTitle();
		  System.out.println(Title2);
			
		   driver.findElement(By.xpath("//*[contains(text(),\"Visit Us\")]")).click(); // visit us button
		 
		 String child_window3= driver.getWindowHandle();
		  System.out.println(child_window3);
		 
		  
		  Set<String> windowIDs = driver.getWindowHandles();
			@SuppressWarnings("unchecked")
			ArrayList <String> WindowidList = new ArrayList<String>(windowIDs);
			String parentwindowID = WindowidList.get(0);
			String childwindowID1= WindowidList.get(1);
			String childwindowID2= WindowidList.get(2);
			String childwindowID3= WindowidList.get(3);
			System.out.print("\n" +WindowidList.size());
			
			for (int i = 0; i < WindowidList.size(); i++) {
				System.out.println(i + 1 + " : " + WindowidList.get(i));
				}
			
	for(String e:WindowidList) 
	
	{
		System.out.println(e);
	}
	
	  		
		   
			
			
			driver.switchTo().window(childwindowID1);
			String actTitle=driver.getTitle();

			String expTitle = "Visit Us";
			Assert.assertEquals(actTitle,expTitle,"Webpage validation Failed" );
			
			for(String winID:WindowidList)
			{
			String title=driver.switchTo().window(winID).getTitle();	
			if(title.equals("Visit Us"))
			{
				driver.findElement(By.xpath(exp_1)).click();
				String title0=driver.getTitle();
				System.out.println(title0);
			}
			else
			{
				System.out.println("Page not found");
			}
			
			
		  
			
			}
			try {
		   Thread.sleep(3000);
		   driver.switchTo().window(parentwindowID);
		   driver.quit();
			}
			catch(Exception e)
			{
				 System.out.println("Cant quit windows!");
				 driver.quit(); 
			}
		 
		
	}

	  }

