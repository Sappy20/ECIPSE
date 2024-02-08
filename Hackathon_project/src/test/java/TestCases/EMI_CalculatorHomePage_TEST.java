package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObjects.EMI_Calculator;

public class EMI_CalculatorHomePage_TEST extends GoogleHome_Test{
	
	@Test(priority=4,groups= {"smoke","sanity","master"})
	public void clickONCarloan() throws IOException
	{
		logger.info("*****  *******");
		logger.info("***** Click on CarLoan icon in the opening page to evaluate and also check UI  *******");
	EMI_Calculator emC = new EMI_Calculator(driver);
	logger.info("*****________________________________  *******");
	logger.info("***** All data are provided here through properties files  *******");
	emC.carloan_click();
	logger.info("*****  ______________________________*******");
	}
	
	@Test(priority=5,groups={"sanity","master"})
	public void refreshPage()
	{
		logger.info("***** Refreshing the page to reset all DATA *******");
		EMI_Calculator emC = new EMI_Calculator(driver);
		emC.page_reload();
		logger.info("***** _______________________________ *******");
		
	}
	
	@Test(priority=6,groups= {"smoke","sanity","master"})
	public void load_EMICalculator_LINK() throws InterruptedException, IOException
	{
		logger.info("***** Clicking on the 'CALCULATORS ' text to show the dropdown and navigate to Calculator Main Page  *******");
		logger.info("***** __________________________________ *******");
		EMI_Calculator emC = new EMI_Calculator(driver);
	emC.goToCalculator();
	System.out.println("\n");
	logger.info("***** =================================================  *******");
	}
}
