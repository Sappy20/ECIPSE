package mini;
import java.time.Duration;
import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
public class project 
{
	
	public static String link_web;
	public static int links ;
	public static WebElement element;
	public static WebDriver driver ;
	
	
	public static void main(String[] args) throws InterruptedException
	{
		
		//System.setProperty("webdriver.chrome.driver","C:\\chromedriver-win64\\chromedriver.exe"); 
		
		
		WebDriver driver =null ;
		System.out.println("Choose Your Browser ");
		System.out.println(" 1 for Chromebrowser \n 2 for Edgebrowser ");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt(); 
		input.close();
		
		
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
		
		 driver.get("https://www.rediff.com");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().window().maximize();
		 
		// Click on "Create Account" link and Validating if the Parent webpage is opening properly
			 driver.findElement(By.xpath("//a[contains(text(),'Create Account')]")).click();
			 String at= driver.getTitle();
			 String et ="Rediffmail Free Unlimited Storage";
			 if(at.equalsIgnoreCase(et))
			 {
				 System.out.println("Page Validated");
			 }
			 else 
			 {
				 System.out.println("Page Validation Unsuccessfull");
			 }
			 
			 
			// Find the total number of links in “Create Rediffmail account” webpage and print the links.
			 List<WebElement> links =  driver.findElements(By.tagName("a"));
			 System.out.println("Total number of links is : \n "+ links.size());
			 System.out.println("\n The Links are: \n");
				for (int i = 0; i < links.size(); i++) {
					System.out.println(i + 1 + " : " + links.get(i).getAttribute("href"));
					}
				
		for(WebElement e:links) 
		
		{
			System.out.println(e.getText());
		}
		
		 driver.findElement(By.xpath("//a[contains(text(),'terms and conditions')]")).click();
		 System.out.println("\n The title of this child window is : \n"+driver.getTitle());
		
		 
		//Get the title of the child window
		Set<String> handles = driver.getWindowHandles();
		 //System.out.println(handles);
		 List <String> winHandles = new ArrayList<String>(handles);
		 String parentwin = winHandles.get(0);
		 String childwin = winHandles.get(1);
		 driver.switchTo().window(childwin);
		 
		 String act_Title = "";
		 act_Title = driver.getTitle();
		 String exp_Title = "Rediffmail: Terms and Conditions";
		
		 // Validating Parent window and Child window
		Assert.assertEquals(act_Title, exp_Title,"Webpage validation Unsuccesfull");
	
		 
		 if(act_Title.equalsIgnoreCase(exp_Title))
		 {
			 System.out.println("\n Webpage Validated Successfully");
		 }
		 else {
			 System.out.println("\n Webpage Validation Failed");
		 }
		
		 Thread.sleep(1000);
		
		 //switching to parent window and closing the child window
		 driver.switchTo().window(parentwin);
		 Thread.sleep(2000);
		 
		 driver.quit();
	}


}

