package TestCases;

import org.testng.annotations.Test;

import PageObjects.LOAN_Calculator_InterestRateCalculator;

public class UI_CheckForInterestRATECalc extends UI_CheckForLoanTennureCalc {

	// Tests For 4TH PAGE
	
	@Test(priority=42,groups= {"sanity"})
	public void do_settingLoan_Amount()
	{

		LOAN_Calculator_InterestRateCalculator  ui_Interest = new LOAN_Calculator_InterestRateCalculator(driver);
		
		logger.info("***** Working on the 4th Type of CALCULATOR *******");
		logger.info("****** INTEREST CALCULATOR page is opened  ******");
		logger.info("***** ______________________________ *******");
		
		logger.info("***** Providing the LOAN amount in the inputbox   *******");
		
		String LoanAmounts =p.getProperty("LOAN_AMOUNT");
		ui_Interest.settingLoan_Amount(LoanAmounts);
		logger.info("***** Validating the value stored in the inputbox  *******");
		ui_Interest.LOAN_amt_Validation();
		logger.info("***** _____________________________________ *******");
		
	}
	
	@Test(priority=43,groups= {"sanity"})
	public void do_settingEMI_Amount()
	{

		LOAN_Calculator_InterestRateCalculator  ui_Interest = new LOAN_Calculator_InterestRateCalculator(driver);
		
		logger.info("***** Providing the EMI Amount in the inputbox  *******");
		
		String EMI_Amount =p.getProperty("EMI_interestCalculator");
		ui_Interest.settingEMI_Amount(EMI_Amount);
		
		logger.info("***** Validating the value stored in the inputbox  *******");
		ui_Interest.EMI_amt_Validation();
		logger.info("***** ____________________________________________ *******");
		
	}
	
	@Test(priority=44,groups= {"sanity"})
	public void do_setingLoan_Tennure()
	{

		LOAN_Calculator_InterestRateCalculator  ui_Interest = new LOAN_Calculator_InterestRateCalculator(driver);
		
		logger.info("***** Providing the years for which the LOAN is applied for  *******");
		
		String YEARS =p.getProperty("Loan_TENNURE");
		ui_Interest.setingLoan_Tennure(YEARS);
		
		logger.info("***** Validation of value inside the inputbox  *******");
		ui_Interest.TENURE_Validation();
		logger.info("***** __________________________________________ *******");
	}
	
	@Test(priority=45,groups= {"sanity"})
	public void do_setingLoan_FeesAndCharges()
	{
		logger.info("*****  *******");
		LOAN_Calculator_InterestRateCalculator  ui_Interest = new LOAN_Calculator_InterestRateCalculator(driver);
		
		logger.info("***** Providing the amount for FEES and CHARGES inside the inputbox  *******");
		
		String FeesAndCharges =p.getProperty("FEES_Charges");
		ui_Interest.setingLoan_FeesAndCharges(FeesAndCharges);
		logger.info("***** Validating the  value inside the unputbox  *******");
		ui_Interest.CHARGES_amt_Validation();
		logger.info("***** _____________________________________ *******");
	}
	
	@Test(priority=46,groups= {"smoke","sanity"})
	public void do_validation_Result()
	{

		LOAN_Calculator_InterestRateCalculator  ui_Interest = new LOAN_Calculator_InterestRateCalculator(driver);
		
		logger.info("***** The final outcome is stored and validated after the calculation  *******");
		ui_Interest.validation_Result();
		
		logger.info("*****  AUTOMATION COMPLETED *******");
		logger.info("*****     ===================================================== *******");
		logger.info("***** _______________________________________________________________ *******");
		
	}
	
	
	
	
	
	
	
	
}
