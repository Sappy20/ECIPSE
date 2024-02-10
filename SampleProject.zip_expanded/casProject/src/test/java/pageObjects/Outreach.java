package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import testBase.BaseClass;

public class Outreach extends BasePage {

	public Outreach(WebDriver driver) {
		super(driver);
		
	}
	
	//locators
	@FindBy(id="appFrame") WebElement eventFrame;
	@FindBy(xpath="//div[@class='row sectiondiv']") WebElement divEvents;
	@FindBy(xpath="//div[@class='title_event']") List <WebElement> eventsEle;
	@FindBy(xpath="//span[@class='vieweventDrop']") WebElement searchEventEle;
	@FindBy(xpath="(//span[@class='filter-option pull-left'])[2]") WebElement eventTypeEle;
	@FindBy(xpath="//span[contains(text(),'Education')]") WebElement educationEle;
	@FindBy(xpath="//button[@data-id='jsonWeekType']") WebElement dayEle;
	@FindBy(xpath="//span[contains(text(),'Weekday')]") WebElement weekdayEle;

	@FindBy(xpath="(//tbody)[1]") WebElement calenderEle;
	@FindBy(xpath="//td[@class='disabled day']") List<WebElement> disabledDateEle;
	@FindBy(xpath="//input[@id='fromDate']") WebElement fromDayEle;
	@FindBy(xpath="//input[@id='toDate']") WebElement toDayEle;
	@FindBy(xpath="//button[@id='eventsHomeSearchBtn']") WebElement searchButtonEle;
	@FindBy(xpath="//button[@id='Viewallsearch']") WebElement searchButton2Ele;
	
	@FindBy(xpath="//div[@class='card_eventscroll marginleft0']/div[1]/div") List<WebElement> availEventsEle; //default (//div[@id='divsearchevents']/div/div/div)[1]
	
	@FindBy(xpath="//span[@class='text']") List <WebElement> citiesEle;
	
	
	@FindBy(xpath="//div[@id='divsearchevents']") WebElement NoeventsEle;
	
	
	@FindBy(xpath="(//a[@class='nav-link dropdown-toggle'])[1]") WebElement EvenetsHeaderEle;
	@FindBy(xpath="//a[contains(text(),'Upcoming Events')]") WebElement upcomingEventsEle;
	
	@FindBy(xpath="(//a[@class='nav-link dropdown-toggle'])[2]") WebElement donateHeaderEle;
	@FindBy(xpath="(//div[@class='dropdown-menu'])[2]/a") List<WebElement> donateDropEle;
	
	@FindBy(xpath=("(//a[@class='nav-link dropdown-toggle'])[3]")) WebElement exploreHeaderEle;
	@FindBy(xpath="(//div[@class='dropdown-menu'])[3]/a") List<WebElement> exploreDropEle;
	
	@FindBy(xpath=("(//a[@class='nav-link dropdown-toggle'])[4]")) WebElement readMoreHeaderEle;
	@FindBy(xpath="(//div[@class='dropdown-menu'])[4]/a") List<WebElement> readMoreDropEle;
	
	@FindBy(xpath="//li[@class='nav-item']/a") WebElement myVolunteeringHeaderEle;
	@FindBy(id="txtVolunteered") WebElement volunteeredHrsEle;
	@FindBy(id="txtActivities") WebElement acParticipatedEle;
	
	@FindBy(id="divcurrentGoals") WebElement GoalsEle;
	@FindBy(xpath="(//li[@class='myGoal'])[1]") WebElement myGoalsEle;
	@FindBy(xpath="(//li[@class='myGoal'])[2]") WebElement pastGoalsEle;
	
	@FindBy(id="divvolteer") WebElement VtaroundMeEle;
	@FindBy(xpath="//div[@class='col-lg-8 col-md-8 profilevoltextdiv']/div") List<WebElement> appNamesEle;
	
	
	//screenshot elements
	@FindBy(xpath="//div[@class='row margin0 sectionfpadding']") WebElement EventsBasedOnInterest;
	
	
	//scroll to element
	@FindBy(xpath="//div[@id='EVNT00096669']") WebElement scrollToSportsEvent;
	
	
	//action methods
	
	
	public void events() throws IOException, InterruptedException
	{
		driver.switchTo().frame(eventFrame);
		fluentWait(divEvents);
		screenShot("EventsPage");
		try{
		for(WebElement event:eventsEle)
		{
			System.out.println(event.getText());
		}
			}
		catch(Exception e)
		{
			System.out.println("No events found!");
		}

	}
	
	
	
	
	
	public String eventType() throws InterruptedException
	{
		searchEventEle.click();
		Thread.sleep(2000);
		eventTypeEle.click();
		educationEle.click();
		String educationStr = educationEle.getText();
		return educationStr;
		
	}
	
	public String clickOnWeekday()
	{
		dayEle.click();
		weekdayEle.click();
		String weekdayStr = weekdayEle.getText();
		return weekdayStr;
	}
	
	
	public void disabledDateVerify() throws IOException
	{
		fromDayEle.click();
		int disDateSize = disabledDateEle.size();
		System.out.println("Disabled date size:"+disDateSize);
		for(int i=1;i==disDateSize;i++)
		{
				
			String disabledDateStr = disabledDateEle.get(i).getAttribute("innerHTML");
			int dateInt = Integer.parseInt(disabledDateStr);
			if(dateInt==disDateSize)
			{
				System.out.println(dateInt+" is disabled");
			}
		}
		
	}
	
	

	
	public void selectDate() throws IOException
	{
		fromDayEle.sendKeys("2024-01-20");
		toDayEle.sendKeys("2024-01-31");
		screenShot("FilterWithDefaultocation");
	}
	
	public void clickOnSearch() throws InterruptedException
	{
		searchButtonEle.click();
		Thread.sleep(3000);

	}
	
	public void defaultLocEvent() throws IOException
	{
		try {
			for(WebElement availEvents:availEventsEle)
			{
				System.out.println("Available event with default location: "+availEvents.getText());
			}
			
		}
			
		catch(Exception e)
		{}
		screenShot("ResultWithDefaultLoc");
	}
	

	
	public void randomLocEvent() throws InterruptedException, IOException
	{
		
		searchEventEle.click();
		//generate random number
		BaseClass baseC=new BaseClass();
		int randomInt = Integer.parseInt(baseC.randomNumber());
		System.out.println("Random number:"+randomInt);
		//select city based on random number
		JavascriptExecutor js = (JavascriptExecutor)driver;
		for(int i=1;i<citiesEle.size();i++)
		{
			if(i==randomInt)
			{
				System.out.println("Random city: "+citiesEle.get(i).getAttribute("innerHTML"));
				
				js.executeScript("arguments[0].click();", citiesEle.get(i));

			}
		}
		toDayEle.sendKeys("2024-01-31"+Keys.ENTER);
		searchButton2Ele.click();
		
		System.out.println("**************Clicked on search with random location*****************");

		
		try {
			for(WebElement availEvents:availEventsEle)
			{
				System.out.println("Available event with random location: "+availEvents.getText());
			}	
		}
			
		catch(Exception e)
		{}
		
		try {
		System.out.println(NoeventsEle.getText());
		}
		catch(Exception e) {}
		screenShot("ResultWithRandomLoc");
		
		
	}
	
	public void eventsHeader() throws IOException
	{
	
		Actions ac = new Actions(driver);
		ac.moveToElement(EvenetsHeaderEle).perform();
		screenShot("UnderEvents");
		
		System.out.println("Under "+EvenetsHeaderEle.getText()+" :");
		System.out.println(upcomingEventsEle.getText());
	}
	
	public void donateHeader() throws IOException
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(donateHeaderEle).perform();
		screenShot("UnderDonate");
		
		System.out.println("Under "+donateHeaderEle.getText()+" :");
		for(WebElement donateDrop :donateDropEle)
		{
			System.out.println(donateDrop.getText());
		}
		
	}
	
	public void exploreHeader() throws IOException
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(exploreHeaderEle).perform();
		screenShot("UnderExplore");
		
		System.out.println("Under "+exploreHeaderEle.getText()+" :");
		for(WebElement exploreDrop :exploreDropEle)
		{
			System.out.println(exploreDrop.getText());
		}

	}
	
	public void readMoreHeader() throws IOException
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(readMoreHeaderEle).perform();
		screenShot("UnderReadmore");
		
		System.out.println("Under "+readMoreHeaderEle.getText()+" :");
		for(WebElement readMoreDrop :readMoreDropEle)
		{
			System.out.println(readMoreDrop.getText());
		}

	}
	
	public void myVolunteerData() throws IOException
	{
		myVolunteeringHeaderEle.click();
		fluentWait(volunteeredHrsEle);
		screenShot("MyVolunteeredData");
		
		System.out.println("Total number of Hours Volunteered: "+volunteeredHrsEle.getText());
		System.out.println("Total number of Activities Participated: "+acParticipatedEle.getText());
	}
	
	public void ClickOnGoals() throws InterruptedException
	{
		GoalsEle.click();
	}
	
	public void myGoalData()
	{
		fluentWait(myGoalsEle);
		System.out.println(myGoalsEle.getText());
	}
	
	public void pastGoalsData() throws IOException
	{
		System.out.println(pastGoalsEle.getText());
		screenShot("GoalsData");
	}
	
	public void clickOnVolunteersAroundMe()
	{
		VtaroundMeEle.click();
		System.out.println(VtaroundMeEle.getText());
	}
	
	public void appsName() throws IOException
	{
		
		System.out.println("Number of apps: "+appNamesEle.size());
		System.out.println("App names:");
		
		for(WebElement appname:appNamesEle)
		{
			
			System.out.println(appname.getAttribute("innerHTML"));
		}
		scrollToBottom();
		screenShot("AllApps");

	}


}
