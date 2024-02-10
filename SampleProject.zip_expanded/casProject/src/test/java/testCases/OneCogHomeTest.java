package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.OneCogHome;

public class OneCogHomeTest extends BeCogHomeTest {

	
	@Test(priority=7)
	public void searchOutreachTest() throws InterruptedException
	{
		logger.info("**** Search for OutReach in the searchbox ****");
		OneCogHome oC = new OneCogHome(driver);
		oC.searchOutreach();
	}
	
	@Test(priority=8)
	public void outreachVisibilityTest() throws IOException
	{
		OneCogHome oC = new OneCogHome(driver);
		logger.info("****Validating if OutReach is shown or not ****");
		Assert.assertEquals(oC.outreachVisibility(), true);
	}
	

	

	
	
}
