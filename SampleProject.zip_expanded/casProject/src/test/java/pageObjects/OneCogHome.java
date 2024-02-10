package pageObjects;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OneCogHome extends BasePage {

	public OneCogHome(WebDriver driver) {
		super(driver);
		
	}
	
	
	//locators
	@FindBy(xpath="//input[@id='oneC_searchAutoComplete']") WebElement searchEle;
	@FindBy(xpath="(//div[@class='appsResultText'])[1]") WebElement OutreachEle;
	
	//screenshot elements
	@FindBy(xpath="//div[@class='col s12 newSearchQueryResultContainer']") WebElement OutreachAppVisibility;

	
	
	
	
	//action methods
	public void searchOutreach() throws InterruptedException
	{
		searchEle.sendKeys("Outreach");
		searchEle.sendKeys(Keys.ENTER);
		
		
	}
	
	public boolean outreachVisibility() throws IOException 
	{
		fluentWait(OutreachEle);
		boolean resBool = OutreachEle.isDisplayed();
		screenShot("OutreachApp");
		if(resBool=true)
		{
		System.out.println("Outreach is displayed!");
		}
		else 
		{
			System.out.println("Outreach is not displayed!");
		}
		try{
			OutreachEle.click();
			}
		catch(Exception e)
		{
			System.out.println("Exception caught"+e.getMessage());	
			
		}

		return resBool;

	}
	

	
}
