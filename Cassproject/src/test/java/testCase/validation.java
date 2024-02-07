
package testCase;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pageObjects.beCognizant;
import testBases.Baseclass;


public class validation extends Baseclass{
	public Logger logger;
	


	WebDriver driver;
	
	//Validate if 1C profile is displayed

	@Test(priority = 2)
   public void open_1C_portalTest() throws InterruptedException
   {
		logger.info("*****Validating 1C portal link is working or not*****");
	   beCognizant bf = new beCognizant(driver) ;
	   bf.open_1C_portal();
	   
	    }
	@Test(priority = 1)
	public void portal_display()
	{
		logger.info("****Check 1c portal****");
		beCognizant  cg = new beCognizant(driver);
		if(cg.OneC_portal())
		{
			logger.info("*****Validating 1C portal link is displayed or not*****");
			Assert.assertTrue(true);;
		}
		
		else
		{
			Assert.fail();
		}
		
		//Assert.assertTrue(cg.OneC_portal());
			
	}
}
