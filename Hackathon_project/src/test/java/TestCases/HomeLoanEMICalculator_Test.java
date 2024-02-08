package TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import PageObjects.HomeLoanEMICalculator;


public class HomeLoanEMICalculator_Test extends EMI_CalculatorHomePage_TEST {
	
	  
	@Test(priority=7,groups= {"sanity","master"})
	public void HomeLoan_Validation() throws IOException, InterruptedException
	{
		logger.info("***** Validating the Page through Page heading validation *******");
		logger.info("***** ___________________________ *******");
		HomeLoanEMICalculator HomeEMI= new HomeLoanEMICalculator(driver);
		try {
		HomeEMI.validateHomeLoanEmiCalculator();
		Assert.assertTrue(HomeEMI.validateHomeLoanEmiCalculator());
		}
		catch(Exception e) 
		{
			HomeEMI.handleAdvertisement();
			HomeEMI.validateHomeLoanEmiCalculator();
		}
	}
	
	
	
	@Test(priority=9,groups= {"sanity","master"})
	public void setHomeValue_InCalculator()
	{
		logger.info("***** Input value to HOME VALUE(HV) Input box in page *******");
		HomeLoanEMICalculator HomeEMI= new HomeLoanEMICalculator(driver);
		
		
		
		logger.info("***** _________________________________ *******");
		
		// Calling String value from properties file 
		String homeValueAmount = p.getProperty("homeValue");
		
		HomeEMI.setHomeValue_InputBox(homeValueAmount);
		
		logger.info("*****  *******");
	}
	
	@Test(priority=10,groups= {"sanity","master"})
	public void setDownPayment_InCalculator() throws IOException
	{
		logger.info("***** ___Input value to Margin OR Down Payment(DP) Inputbox present in webpage ____ *******");
		HomeLoanEMICalculator HomeEMI= new HomeLoanEMICalculator(driver);
		
		// String downpayment  in PERCENTAGE
		
		String downPayment =p.getProperty("downPaymentPercentage");
		logger.info("***** ______________________________ *******");
		HomeEMI.setdownPayment(downPayment);
		
		
		// converting the above data into rupees
		logger.info("***** Converting  The downpayment from PERCENTAGE to RUPEES  *******");
		HomeEMI.clickOnDownPaymentRupeesButton();
		
		logger.info("***** ____________________________________ *******");
		// returning the value obtained upon calculation
		HomeEMI.getDownPaymentAmount();
		logger.info("***** Returning the value that is being input to the inputbox  *******");
	}
	
	
	@Test(priority=11,groups= {"sanity","master"})
	public void setting_LoanInsurance_Amount() throws IOException
	{
		logger.info("***** _________________________ *******");
		HomeLoanEMICalculator HomeEMI= new HomeLoanEMICalculator(driver);
		
		//temporary testing data being acquired from Properties file
		
		String loanInsuranceAmount  =p.getProperty("loanInsurance");
		HomeEMI.setLoanInsurance(loanInsuranceAmount);
		logger.info("***** Input data to LOAN INSURANCE (LI) inputbox *******");
	}
	
	@Test(priority=12,groups= {"sanity","master"})
	public void Loan_Amt_Validation()
	{
		logger.info("***** ____________________________ *******");
		HomeLoanEMICalculator HomeEMI= new HomeLoanEMICalculator(driver);
		HomeEMI.getLoanAmount();
		logger.info("***** Returning the values from the inputbox that is stored in a String *******");
	}
	
	@Test(priority=13,groups= {"sanity","master"})
	public void set_Interest_Rate() throws InterruptedException, IOException
	{
		logger.info("***** ________________________________ *******");
		HomeLoanEMICalculator HomeEMI= new HomeLoanEMICalculator(driver);
		
		String interestRate= p.getProperty("homeLoanInterestRate");
		HomeEMI.setInteresrRate(interestRate);
		logger.info("***** Providing the Interest Rate in percentage in the inputbox *******");
	}
	
	@Test(priority=14,groups= {"sanity","master"})
	public void Setting_Loan_Duration() throws IOException, InterruptedException
	{
		logger.info("***** ______________________  *******");
		
		HomeLoanEMICalculator HomeEMI= new HomeLoanEMICalculator(driver);
		
		String loanTenure =p.getProperty("loanTenureInYear");
		HomeEMI.setLoanTenure(loanTenure);
		logger.info("***** Providing the Duration or Tenure for which the Loan is being applied *******");
		
		HomeEMI.clickOnLoanTenureMonthsButton();
		logger.info("***** ______________________ *******");
		logger.info("*****  Converting the tenure from YEARS to MONTHS *******");
		HomeEMI.getLoanTenureInMonths();
		logger.info("***** ___________________________ *******");
		
	}
	
	@Test(priority=15,groups= {"sanity","master"})
	public void Loan_charges_set() throws InterruptedException, IOException
	{
		
		logger.info("***** Setting the Loan Fees and Charges required for processing the LOAN  *******");
		HomeLoanEMICalculator HomeEMI= new HomeLoanEMICalculator(driver);
		
		//Setting Loan give out charges as a percentage of the Loan Amount
		
		String loanCharges =p.getProperty("loanChargesPercentage");
		logger.info("***** __________________________________ *******");
		HomeEMI.setLoanCharges(loanCharges);
		// converting the data into rupees
		HomeEMI.clickOnLoanChargesRupeesButton();
		logger.info("***** Converting the input data from PERCENTAGE to RUPEES by clicking on the rupees button on the webpage  *******");
	}
	
	
	@Test(priority=16,groups= {"sanity","master"})
	public void Loan_StartMonthAndYear_calenderOperations()
	{
		logger.info("***** ___________________________  *******");
		HomeLoanEMICalculator HomeEMI= new HomeLoanEMICalculator(driver);
		HomeEMI.clickOnLoanStartMonthAndYear();
		
		// validating if date picker is visible
		logger.info("***** Validating if DatePicker  is present on the page *******");
		HomeEMI.validateDatePicker();
		
		// Asserting the validation
		Assert.assertTrue(HomeEMI.validateDatePicker());
	
	}
	
	@Test(priority=17,groups= {"sanity","master"})
	public void LoanStartMonthAndYear_setting()
	{
		logger.info("***** __________________________________ *******");
		HomeLoanEMICalculator HomeEMI= new HomeLoanEMICalculator(driver);
		
		logger.info("***** Setting the DATE to Mar, 2024  *******");
		
		// String year,String month = 2024 , march    here
		HomeEMI.setLoanStartMonthAndYear("2024","Mar");
		logger.info("***** ____________________________ *******");
	}

	
	@Test(priority=18,groups= {"sanity","master"})
	public void setting_OneTimeExpenses() throws InterruptedException, IOException
	{
		logger.info("***** Providing the One Time Expenses in percentage format *******");
		HomeLoanEMICalculator HomeEMI= new HomeLoanEMICalculator(driver);
		
		String oneTimeExpenses =p.getProperty("oneTimeExpensesPercentage");   
		HomeEMI.setOneTimeExpenses(oneTimeExpenses);
		
		logger.info("***** __________________________________________ *******");
		logger.info("***** Converting the percentage value into Rupees format by clicking on the rupees converter button *******");
		HomeEMI.clickOnOneTimeExpensesRupeesButton();
		
		// returns value calculated in rupees 
		HomeEMI.getOneTimeExpensesInRupees();
		logger.info("***** Returning the string that stored the final data outcome in the inputbox for One Time Expenses *******");
	}

	
	@Test(priority=19,groups= {"sanity","master"})
	public void  propertyTaxesperyear() throws InterruptedException, IOException
	{
		logger.info("***** _________________________________________ *******");
		HomeLoanEMICalculator HomeEMI= new HomeLoanEMICalculator(driver);
		
		logger.info("*****  *******");
		
		 String taxesPerYear =p.getProperty("propertyTaxes/yearPercentage");
		HomeEMI.setPropertyTaxesPeryear(taxesPerYear);
		logger.info("***** Setting Property Taxes to 0.25%  Per Year in the  'Taxes per year' inputbox  *******");
		
		// converts to rupees format
		HomeEMI.clickOnPropertyTaxesPerYearRupeesButton();
		logger.info("***** ___________________________________________________ *******");
		logger.info("***** Converting the percentage value to Rupees format *******");
		
		// returns value in rupees 
		HomeEMI.getPropertyTaxesPerYearInRupees();
		logger.info("***** _________________________________ *******");
		logger.info("***** Returning the String that stored the final value in rupees format after calculation in the inputbox *******");
		logger.info("***** _________________________________ *******");
	}

	
	@Test(priority=20,groups= {"sanity","master"})
	public void HomeInsurancePerYear_setting() throws InterruptedException, IOException 
	{
		logger.info("***** Setting the values for Home Insurance Per Year inside the corresponding inputbox *******");
		HomeLoanEMICalculator HomeEMI= new HomeLoanEMICalculator(driver);
		
		// getting data from config.properties file
		String homeInsurance=p.getProperty("homeInsurance/yesrPercentage");
		HomeEMI.setHomeInsurancePerYear(homeInsurance);
		
		logger.info("***** _____________________________ *******");
		logger.info("***** Clicking on the Rupees convertor button available on the webpage *******");
		// convert to rupees 
		HomeEMI.clickOnHomeInsurancePerYearRupeesButton();
		
		
		logger.info("***** _____________________________ *******");
		// return value in rupees
		HomeEMI.getHomeInsurancePerYearInRupees();
		logger.info("***** Returning the String that stored the final value in rupees from the inputbox *******");
		logger.info("***** _____________________________ *******");
	}

	
	@Test(priority=21,groups= {"sanity","master"})
	public void SettingMaintenanceExpenses() throws IOException
	{
		
		logger.info("***** Providing the value foe Maintenance Expenses Per Month inputbox  *******");
		HomeLoanEMICalculator HomeEMI= new HomeLoanEMICalculator(driver);
		
		String MaintenanceExpenses =p.getProperty("maintenanceExpenses/month");
		HomeEMI.setMaintenanceExpensesPerMonth(MaintenanceExpenses);
		
		logger.info("***** _____________________________________  *******");
	}

	
	@Test(priority=22,groups= {"sanity","master"})
	public void implementing_ExcelMethods_toStoreData() throws InterruptedException, IOException
	{
		
		logger.info("***** Reading the data into a EXCEL SHEET *******");
		HomeLoanEMICalculator HomeEMI= new HomeLoanEMICalculator(driver);
		HomeEMI.readData();
		logger.info("***** _______________________________  *******");
	}

	@Test(priority=23,groups= {"smoke","sanity","master"})
	public void Navigation_toNextPage() throws InterruptedException
	{
		logger.info("***** Go to the next Page by clicking on the Calculators Dropdown *******");
		logger.info("*****  *******");
		logger.info("***** Click on the HLOAN CALCULATORS link showed in the dropdown  *******");
		logger.info("***** ________________________________ *******");
		
		logger.info("***** Navigated to the Loan Calculators Page for UI Testing  *******");
		HomeLoanEMICalculator HomeEMI= new HomeLoanEMICalculator(driver);
		HomeEMI.GoToLoanCalculator_Page();
		logger.info("***** ==================================================  *******");
	}

}
