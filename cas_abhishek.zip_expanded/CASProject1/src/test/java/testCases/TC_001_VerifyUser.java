
package testCases;
 
import org.testng.Assert;

import org.testng.annotations.Test;
 
import PageObjects.HomePage;

import testBase.BaseClass;
 
 
public class TC_001_VerifyUser extends BaseClass {
 
	@Test(priority = 1)

	public void userVerify() {

		//driver = new ChromeDriver();

		HomePage hv = new HomePage(driver);

		hv.headerCheck();

		hv.clickOnMyAcc();

		try {

			Thread.sleep(3000);

		} catch (InterruptedException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		String nameCheck =  hv.getName();

		String mailCheck = hv.getMailId();

		Assert.assertEquals("Mukherjee, Abhishek (Cognizant)", nameCheck);

		Assert.assertEquals("2303498@cognizant.com", mailCheck);

		System.out.println("User's name and mail id is - " + nameCheck+" "+mailCheck);

	}

}
