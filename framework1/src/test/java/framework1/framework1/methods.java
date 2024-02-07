package framework1.framework1;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.*;

public class methods {
	WebDriver driver=null;
	//@Test(priority=0)
	void driverSetup()
	{
	    driver = new ChromeDriver();
		driver.get("https://www.quora.com/profile/Quora");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	//@Test(priority=1)
	void extra()
	{
		driver.findElement(By.xpath("//div[@class='q-text qu-dynamicFontSize--small qu-medium'][contains(text(),'More')]")).click();
		String act = driver.findElement(By.xpath("//div[@class='q-text qu-dynamicFontSize--small qu-color--gray_dark'][contains(text(),'Edits')]")).getText();
	   String exp="Edits";
	   System.out.println(act);
	  Assert.assertEquals(act,exp,"Validation Failed");
	  try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	}
	//@Test(priority=2)
	void search()
	{
		
		driver.findElement(By.xpath("//*[@placeholder='Search for questions, people, and topics']")).sendKeys("Testing");
		driver.findElement(By.xpath("//div[@class='q-box puppeteer_test_selector_result'][2]")).click();
	}
	//@Test(priority=3,dependsOnMethods={"search"})
	void logo()
	{
		WebElement logo = driver.findElement(By.xpath("//*[contains(text(),'Continue reading')]"));
		System.out.println(logo.isDisplayed());
		
	}
	//@Test(priority=4,dependsOnMethods={"logo"})
	void signup()
	{
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
	}
	//@Test(priority=5)
	void dataput()
	{
driver.findElement(By.id("profile-name")).sendKeys("Sappy"); // name
		
		driver.findElement(By.xpath("//input[@placeholder='Your email']")).sendKeys("abc@abc");  // email
		String error_message=driver.findElement(By.xpath("//*[contains(text(),'The email address you entered is not valid.')]")).getText();
		String exp_message="The email address you entered is not valid.";
		AssertJUnit.assertEquals(error_message,exp_message,"Validation Failed");
	}
	
	
	//@Test(priority=6)
	void close()
	{
		driver.quit();
	}

}
