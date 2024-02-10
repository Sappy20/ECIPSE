package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BeCogHome;
import testBase.BaseClass;

public class BeCogHomeTest extends BaseClass{
	
	BeCogHome bCH;
	
	@Test(priority=1)
	public void userEleClickTest() throws InterruptedException, IOException
	{
		BeCogHome bCH = new BeCogHome(driver);
		bCH.userEleClick();
		logger.info("***Clicked on user profile.****");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='mectrl_main_body']")).isEnabled(), true);
		
	}
	
	@Test(priority=2)
	public void getUserNameTest() throws InterruptedException
	{
		BeCogHome bCH = new BeCogHome(driver);
	logger.info("****Validating User Name ****");
		Assert.assertEquals(bCH.getUserName(),"Roy, Saptarshi (Cognizant)");
	}
	
	@Test(priority=3)
	public void getUserEmailTest() throws IOException
	{
		logger.info("***Validating user email *****");
		BeCogHome bCH = new BeCogHome(driver);
		Assert.assertEquals(bCH.getUserEmail(),"2303447@cognizant.com");
	}

	
	@Test(priority=4)
	public void visibilityOf1CTest() throws IOException
	{
		BeCogHome bCH = new BeCogHome(driver);
		logger.info("*** Validating the visibility of OneCognizant link *****");
		Assert.assertEquals(bCH.visibilityOf1C(), true);
	}
	
	@Test(priority=5)
	public void clickon1CTest() throws InterruptedException
	{
		logger.info("****Clicking on OneCognizant link ****");
		BeCogHome bCH = new BeCogHome(driver);
		bCH.clickon1C();
	}
	
	@Test(priority=6)
	public void swithTo1CTest() throws InterruptedException, IOException
	{
		BeCogHome bCH = new BeCogHome(driver);
		logger.info("****Multiple window handling and switching to 1C on other window****");
		bCH.swithTo1C();
		Assert.assertEquals(driver.getTitle(), "OneCognizant");
		Thread.sleep(3000);
	}
	
	
	
	
	
	
	
	
}
