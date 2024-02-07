package mini;
import java.time.Duration;
import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

	public class natural_foods {
	
		public static WebDriver driver;
 
 /*
  * Launch any browser  
Go to "http://change2naturalfoods.com/  
Maximize the window  
Locate Login/Register button  
Click Login/Register button  
Enter unregister email id example: jobspari2@gmail.com which is not signed up in this website 
Enter password example:  “abc258” 
Click login button  
Verify error message is displayed for unregistered user  
Get an error message for unregistered email id and print the same in the console  
Close browser 
(Suggested Site: change2naturalfoods.com however you are free to choose any other legitimate site)


  */
 
 
	public static void main(String[] args) {
		
		//handling multiple browser
		
		Scanner sc = new Scanner(System.in);
		int choice;
		// taking input from user
		
		System.out.println("Enter browser you want to search for : ");
		choice=sc.nextInt();
		if(choice==1)
		{
			 driver = new ChromeDriver();
		}
		
		else if(choice==2)
		{
			driver = new EdgeDriver();
		}
					
		else
		{
			System.out.println("Wrong Input given!");
		}
		
		driver.get("http://change2naturalfoods.com/");
		
		//maximize browser
		
		driver.manage().window().maximize();  
		
		//using implicit wait to synchronize code
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
			// using xpath concept to interact with WebElements
		
		WebElement login = driver.findElement(By.xpath("//a[@class='nav-link -before']"));
		login.click();
		//input test data
		
		WebElement email = driver.findElement(By.xpath("//input[@placeholder='Please enter your valid email address']"));
		email.sendKeys("jobspari2@gmail.com");
		
		WebElement pass = driver.findElement(By.xpath("//input[@placeholder='Please Enter Password']"));
		pass.sendKeys("abc258");
		
		WebElement login_comp = driver.findElement(By.xpath("(//*[contains(text(),'Login')])[5]"));
		login_comp.click();
		
		//validation
		
		WebElement alert = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible fade show']"));
		
		String error_message=alert.getText();
		
		String exp="Error: Email or password is incorrect!";
		
		System.out.println(error_message);
		alert.isDisplayed();
		
		driver.quit();
	}

}
