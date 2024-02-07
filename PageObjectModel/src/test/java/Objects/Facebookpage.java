package Objects;
import org.openqa.selenium.*;
import org.testng.Assert;

public class Facebookpage {
	WebDriver driver;
	
	public Facebookpage(WebDriver driver)
	{
		this.driver= driver;
	}
	//storing WebElements in By  data format
	
	By Username_editbox = By.xpath("//input[@placeholder='Email address or phone number']");
	By password_editbox = By.xpath("//*[@placeholder='Password'][@id='pass']");
	By Login_Btn = By.id("loginbutton");
	
	
	//actions methods
	
	public  void EnterUserName()
	{
		
		try {
			driver.findElement(Username_editbox).clear();
			driver.findElement(Username_editbox).sendKeys("TestUser");
		}
		catch(Exception e)
		{
			System.out.println("Exceptions caught"+e.getMessage());
		}
	}
	public void EnterPassword()
	{
		try {
			//in real time projects when they dont entry then use clear first on the webelement then sendkeys in a different line
			
			driver.findElement(password_editbox).clear();
			driver.findElement(password_editbox).sendKeys("Admin@123");
			Thread.sleep(3000);
			}
		catch(Exception e)
		{
			System.out.println("Exceptions caught"+ e.getMessage());
		}
	}
	public void VerifyingLogin()
	{
		driver.findElement(Login_Btn).click();
		String title=driver.getTitle();
	//Assert.assertEquals(title,"Login page");
	}
	
	

}
