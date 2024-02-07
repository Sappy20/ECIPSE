package pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class beCognizant extends Common_method{
WebDriver driver;
public Logger logger;
	
	public beCognizant(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//div[contains(text(),'OneCognizant')]") 
	WebElement oneCognizant_link;
	
	@FindBy(id="mectrl_headerPicture") 
	WebElement profile_logo ;
	
	@FindBy(id="mectrl_currentAccount_primary") 
	WebElement profile_name ;
	
	@FindBy(id="mectrl_body_signOut") 
	public WebElement oneC_profile;
	
	@FindBy(xpath="//div[contains(text(),'2303447@cognizant.com')]")
	WebElement cognizant_mail ;
	
	
	
	//action methods
	
	public void open_1C_portal() throws InterruptedException
	{
		logger.info("******Clicking on 1C Link ****");
		oneCognizant_link.click();
		Thread.sleep(5000);
	}
	public  void profile_check()
	{
		logger.info("******Checking if profile is visible ****");
		profile_logo.click();
	}
	public boolean OneC_portal()
	{
		logger.info("******Clicking on 1C profile link to check if its visible ****");
		return oneCognizant_link.isDisplayed();
	}
}
