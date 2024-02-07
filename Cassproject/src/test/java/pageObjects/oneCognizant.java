package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class oneCognizant extends Common_method{

	public oneCognizant(WebDriver driver) {
		super(driver);
		
	}
		@FindBy(xpath="//i[@class='userProfileMenu']")
		WebElement hamburger_menu  ;
		
		@FindBy(xpath="(//div[@class='quickActionAppText valign-wrapper'])[1]")
		WebElement SubmitTimesheet  ;
	
		@FindBy(xpath="(//div[@class='hotAppText valign-wrapper'])[1]")
		WebElement TruTime  ;
		
		@FindBy(xpath="(//div[@class='hotAppText valign-wrapper'])[4]")
		WebElement MediAssist  ;
		
		@FindBy(xpath="(//div[@class='hotAppText valign-wrapper'])[7]")
		WebElement Outreach ;
		
		@FindBy(xpath="(//div[@class='quickActionAppText valign-wrapper'])[9]")
		WebElement Associate_Profile  ;
		
		@FindBy(id="oneC_searchAutoComplete")
		WebElement searchbar ;
		
		@FindBy(xpath="(//div[@class='appsResultText'])[1]")
		WebElement outreach_btn  ;
		public void Outreach()
		{
			searchbar.click();
			searchbar.sendKeys("Outreach");
			outreach_btn.click();
		}
		
		
}

