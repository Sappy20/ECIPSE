package TestCases;

import org.testng.annotations.Test;
import java.io.IOException;

import PageObjects.Google_Home;
import TestBase.BaseClass;

public class GoogleHome_Test extends BaseClass{
	Google_Home gh;
	//SoftAssert so= new SoftAssert();
	
	@Test(priority=1,groups={"smoke","sanity","regression","master"})
	public void search_action() throws InterruptedException, IOException
	{
		logger.info("***** Initiating a serach input to the Google searchbox *******");
		Google_Home gh =new Google_Home(driver);
		gh.search_input();
		//    so.assertTrue(false);
		
	}
	@Test(priority=2,groups={"smoke","sanity","regression","master"})
	public void search()
	{
		logger.info("***** _________________________________ *******");
		logger.info("***** Clicking on Google Search button that appears after some input is provided to searchbar *******");
		Google_Home gh=new Google_Home(driver);
		gh.initiate_search();
		
	}
	@Test(priority=3,groups={"smoke","sanity","regression","master"})
	public void open_webpage() throws InterruptedException, IOException
	{
		logger.info("***** ____________________________________ *******");
		logger.info("***** Website on which we will test is opened *******");
		Google_Home gh=new Google_Home(driver);
		gh.open_website();
		logger.info("*****  *******");
		logger.info("***** ================================================ *******");
		
	}
	
	
	

}
