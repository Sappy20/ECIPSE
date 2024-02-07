package TestCases;

import org.testng.annotations.Test;

import PageObjects.LOAN_Calculator_LoanTenureCalculator;

public class UI_CheckForLoanTennureCalc extends UI_CheckForLoanEMICalc{
	
	// TESTS for 3rd PAGE
	
	@Test(priority=37,groups= {"sanity"})
	public void do_setsLoan_Amount() throws InterruptedException
	{
		logger.info("***** Working on the THIRD type Calculator  *******");
		logger.info("***** LOAN Tenure Calculator TESTING  *******");
		
		LOAN_Calculator_LoanTenureCalculator  ui_Tenure = new LOAN_Calculator_LoanTenureCalculator(driver);
		
		logger.info("***** _______________________________ *******");
		logger.info("***** Providing the LOAN Amount in the inputbox *******");
		
		// getting data from properties file
		
		String LoanAmount=p.getProperty("Loan_Amount");
		ui_Tenure.setsLoan_Amount(LoanAmount);
		logger.info("***** ______________________________ *******");
		ui_Tenure.Loan_amt_Validation();
		logger.info("***** Validating the result shown in the inputbox *******");
		
	}
	
	@Test(priority=38,groups= {"sanity"})
	public void do_setsEMI_Amount()
	{
		logger.info("*****  *******");
		logger.info("***** Providing the EMI Amount in the inputbox  *******");
		LOAN_Calculator_LoanTenureCalculator  ui_Tenure = new LOAN_Calculator_LoanTenureCalculator(driver);
		
		 String EMIAmt =p.getProperty("EMI");
		ui_Tenure.setsEMI_Amount(EMIAmt);
		
		logger.info("***** _______________________________ *******");
		ui_Tenure.EMI_Amt_Validation();
		logger.info("***** Validating the Amountnstores in the inputbox  *******");
		
	}
	
	@Test(priority=39,groups= {"sanity"})
	public void do_setsLoan_AmountInterest_RATE()
	{
		logger.info("*****  __________________________________ *******");
		LOAN_Calculator_LoanTenureCalculator  ui_Tenure = new LOAN_Calculator_LoanTenureCalculator(driver);
		
		logger.info("*****  Providing  the Interest Rate  to the inputbox  *******");
		
		String RATE =p.getProperty("INTEREST_rate");
		ui_Tenure.setsLoan_AmountInterest_RATE(RATE);
		
		logger.info("***** _______________________________ *******");
		ui_Tenure.Loan_Interest();
		logger.info("***** Returning the interest rate value inside that inutbox  *******");
		logger.info("***** _____________________________ *******");
	}
	
	@Test(priority=40,groups= {"sanity"})
	public void do_setsFees_AND_Charges_Amount()
	{

		LOAN_Calculator_LoanTenureCalculator  ui_Tenure = new LOAN_Calculator_LoanTenureCalculator(driver);
		
		logger.info("***** Providing the FEES and CHARGES required for applying for  LOAN  *******");
		// Using properties file
		String feesANDCharges =p.getProperty("Fees&Charges");
		ui_Tenure.setsFees_AND_Charges_Amount(feesANDCharges);
		
		logger.info("***** __________________________ *******");
		logger.info("***** Returning the Value stored in the inputbox *******");
		ui_Tenure.Loan_Fees();
		logger.info("***** _____________________________ *******");
		
	}
	
	@Test(priority=41,groups= {"smoke","sanity"})
	public void do_NavigateToNextPAGE()
	{

		LOAN_Calculator_LoanTenureCalculator  ui_Tenure = new LOAN_Calculator_LoanTenureCalculator(driver);
		
		logger.info("***** Navigate to next Type of Calculator by clicking on the link *******");
		logger.info("***** Clicking on the INTEREST CALCULATOR *******");
		ui_Tenure.NavigateToNextPAGE();
		logger.info("***** ___________________________________ *******");
		logger.info("***** INTEREST CALCULATOR page is opened  *******");
		logger.info("***** =========================================================== *******");
		
	}
	

}
