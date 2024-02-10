package testCases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Outreach;

public class OutreachTest extends OneCogHomeTest {

	
	@Test(priority=9)
	public void eventsTest() throws IOException, InterruptedException
	{
		Outreach outR = new Outreach(driver);
		
		System.out.println("******All available Events******");
		outR.events();
		logger.info("****Getting the event titles and store them in strings****");
		String eventsHeader = driver.findElement(By.xpath("//div[@class='sectiontitle']")).getText();
		logger.info("****Validating the events titles ****");
		Assert.assertEquals(eventsHeader, "Event Based on your Interests");
		
	}
	
	@Test(priority=10)
	public void eventTypeTest() throws InterruptedException
	{
		Outreach outR = new Outreach(driver);
		logger.info("**** Validating if event type is Eductaion ****");
		
		Assert.assertEquals(outR.eventType(), "Education");
	}
	
	@Test(priority=11)
	public void clickOnWeekdayTest()
	{
		
		Outreach outR = new Outreach(driver);
		logger.info("****Validating if weekday is selected or not****");
		Assert.assertEquals(outR.clickOnWeekday(), "Weekday");
	}
	
	@Test(priority=12)
	public void disabledDateVerifyTest() throws IOException
	{
		Outreach outR = new Outreach(driver);
		logger.info("**** Verify if the dates that cannot be selected are properly present or not****");
		outR.disabledDateVerify();
	}
	
	
	@Test(priority=13)
	public void selectDateTest() throws IOException 
	{
		logger.info("***Selecting date *****");
		Outreach outR = new Outreach(driver);
		outR.selectDate();
	}
	
	@Test(priority=14)
	public void clickOnSearchTest() throws InterruptedException
	{
		logger.info("**** Click on search to search for events ****");
		Outreach outR = new Outreach(driver);
		outR.clickOnSearch();
		
		String SrEvents = driver.findElement(By.xpath("//div[contains(text(),'Search Events')]")).getText();
		
		logger.info("****Validating is Searc Events is showing or not ****");
		
		Assert.assertEquals(SrEvents, "Search Events");
	}
	
	@Test(priority=15)
	public void defaultLocEventTest() throws IOException
	{
		Outreach outR = new Outreach(driver);
		logger.info("**** Default Location of Event is working or not  ****");
		outR.defaultLocEvent();
	}

	
	@Test(priority=16)
	public void randomLocEventTest() throws InterruptedException, IOException
	{
		Outreach outR = new Outreach(driver);
		
		logger.info("**** Random location of Event selected ****");
		outR.randomLocEvent();
		
	}
	
	@Test(priority=17)
	public void eventsHeaderTest() throws IOException
	{
		Outreach outR = new Outreach(driver);
		outR.eventsHeader();
	}
	
	@Test(priority=18)
	public void donateHeaderTest() throws IOException
	{
		Outreach outR = new Outreach(driver);
		outR.donateHeader();

	}
	
	@Test(priority=19)
	public void exploreHeaderTest() throws IOException
	{
		Outreach outR = new Outreach(driver);
		outR.exploreHeader();
	}
	
	@Test(priority=20)
	public void readMoreHeaderTest() throws IOException
	{
		Outreach outR = new Outreach(driver);
		outR.readMoreHeader();
	}
	@Test(priority=21)
	public void myVolunteerDataTest() throws IOException
	{
		Outreach outR = new Outreach(driver);
		outR.myVolunteerData();
		logger.info("****Validation of my volunteering profile ****");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@class='profileheadtext']")).getText(), "My Volunteering profile");
	}
	
	@Test(priority=22)
	public void ClickOnGoalsTest() throws InterruptedException
	{
		Outreach outR = new Outreach(driver);
		outR.ClickOnGoals();
		logger.info("****Clock on goals option ****");
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'My Goals')]")).getText(), "My Goals");
	}
	
	@Test(priority=23)
	public void myGoalDataTest()
	{
		Outreach outR = new Outreach(driver);
		logger.info("**** Click on my goal data test ****");
		outR.myGoalData();
	}
	
	@Test(priority=24)
	public void pastGoalsDataTest() throws IOException
	{
		Outreach outR = new Outreach(driver);
		logger.info("****Past goals data ****");
		outR.pastGoalsData();
	}
	
	@Test(priority=25)
	public void clickOnVolunteersAroundMeTest()
	{
		Outreach outR = new Outreach(driver);
		logger.info("****Clicking on volunteers around me btn ****");
		outR.clickOnVolunteersAroundMe();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@title='Education']")).getText(), "Education");
	}
	
	@Test(priority=26)
	public void appsNameTest() throws IOException
	{
		
		Outreach outR = new Outreach(driver);
		outR.appsName();
	}
	
	

	
}
