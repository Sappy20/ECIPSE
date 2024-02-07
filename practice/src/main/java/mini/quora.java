package mini;

import java.util.Scanner;
import java.time.Duration;
import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

/*
 * 
 * Launch the browser and open the quora site using the given URL
Search for the Topic “Testing” 
Select the first option that appears in the search suggestion  
Verify if the text “Results for testing” is displayed in the result page
Click on “sign In” link
In the prompt, click on “Sign up with email” link
Verify if the “Sign Up” button is disabled
Enter an invalid mail In Email field (ex: abc@abc)
Verify and capture the respective error message shown
Close the Browser 

*/
 

public class quora {

	public static String link_web;
	public static int links ;
	public static WebElement element;
	public static WebDriver driver ;
	public static void main(String[] args) {
		WebDriver driver=null;
		System.out.println("Choose your browser \n");
		System.out.println("Press 1 for ChromeBrowser \n Press 2 for EdgeBrowser ");
		Scanner input = new Scanner(System.in);
		int  choice = input.nextInt();
		input.close();
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
			System.out.println("Invalid choice");
		}
		driver.get("https://www.quora.com/profile/Quora");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@placeholder='Search for questions, people, and topics']")).sendKeys("Testing");
		driver.findElement(By.xpath("//div[@class='q-box puppeteer_test_selector_result'][2]")).click();
      
		WebElement logo = driver.findElement(By.xpath("//*[contains(text(),'Continue reading')]"));
		System.out.println(logo.isDisplayed());
		
		driver.findElement(By.xpath("//*[contains(text(),'Sign In')]")).click();
		WebElement signUp=driver.findElement(By.xpath("//*[contains(text(),'Sign up with email')]"));
		signUp.click();
		if(signUp.isEnabled())
		{
			System.out.println("SignUP button is Enabled");
		}
		else
		{
			System.out.println("SignUP button is Disabled");
		}
		driver.findElement(By.id("profile-name")).sendKeys("Sappy"); // name
		
		driver.findElement(By.xpath("//input[@placeholder='Your email']")).sendKeys("abc@abc");  // email
		String error_message=driver.findElement(By.xpath("//*[contains(text(),'The email address you entered is not valid.')]")).getText();
		String exp_message="The email address you entered is not valid.";
		Assert.assertEquals(error_message,exp_message,"Validation Failed");
		
		driver.quit();
	}
}