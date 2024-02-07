package Objects;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage {
	WebDriver driver;
	public GoogleSearchPage(WebDriver driver) {
		this.driver=driver;
		
	}
	By search_box =By.xpath("//textarea[@title='Search']");
	By Search_btn= By.xpath("(//input[@class='gNO89b'][@value='Google Search'])[1]");
	By Facebook_link=By.xpath("(//*[contains(text(),'Facebook - log in or sign up')])[1]");
	
	
public void searchgoogle(String Searchinput)
	{
	try
	{
		driver.findElement(search_box).sendKeys(Searchinput);
		Thread.sleep(3000);
	driver.findElement(Search_btn).click();
	Thread.sleep(1000);
	}
	catch(Exception e)
	{
		System.out.println("Exceptions Caught"+ e.getMessage());
	}
}
	public void ClickFacebook()
	{
		try {
			driver.findElement(Facebook_link).click();
			Thread.sleep(4000);
			//Throws interrupted exception not needed as its inside try catch block
			}
		catch(Exception e)
		{
			//e.getMessage() method reads the message and displays it
			System.out.println("Exceptions Caught"+e.getMessage());
		}
		
	}
	
	
	
}
