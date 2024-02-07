package pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Outreach extends Common_method{
	public Logger logger;

	public Outreach(WebDriver driver) {
		super(driver);
		
	}
// write all methods along with elements for this page to be performed	
@FindBy(xpath="(//a[@class='nav-link dropdown-toggle'])[1]")
WebElement events  ;


@FindBy(xpath="//input[@placeholder='Search Events']")
WebElement events_searchbox  ;

@FindBy(xpath="//div[contains(text(),'Event Based on your Interests')]")
WebElement events_based_on_interests  ;  //for assertion whether page is opened

@FindBy(xpath="(//span[@class='filter-option pull-left'])[1]")
WebElement location_drp ;

@FindBy(xpath="(//span[@class='filter-option pull-left'])[2]")
WebElement Event_Type ;

@FindBy(xpath="(//span[@class='filter-option pull-left'])[3]")
WebElement Day_Type ;

@FindBy(id="eventsHomeSearchBtn")
WebElement search_btn ;

//Action methods

public void location()
{
	location_drp.click();
}
public void event()
{
	logger.info("*****Validating 1C portal link is displayed or not*****");
	Event_Type.click();
	
}
public void Daytype()
{
	logger.info("*****Validating 1C portal link is displayed or not*****");
	Day_Type.click();
}
public void search()
{
	search_btn.click();	
}



}
