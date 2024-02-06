package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LOAN_Calculator_LoanTenureCalculator extends BasePage{

	public LOAN_Calculator_LoanTenureCalculator(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	// 3  RD PAGE
	
	// PAGE HEADING
			@FindBy(xpath="//div[@class='page-header']/h1")
			WebElement PageHeading  ;

			// DASHBOARD HEADINGS FOR DIFFERENT CALCULATORS 
			@FindBy(xpath="//div[@id='loancalculatordashboard']/ul/li")
			WebElement EMICalculator_LOGO  ;

			
			@FindBy(xpath="//li[@id='loan-amount-calc']")
			WebElement  LoanAmount_CALCULATOR_LOGO ;

			
			@FindBy(xpath="//li[@id='loan-tenure-calc']")
			WebElement  Loan_Tennure_CALCULATOR_LOGO ;

			
			@FindBy(xpath="//li[@id='interest-rate-calc']")
			WebElement InterestRateCalculator_LOGO  ;
			
			
			// WebElements for Loan Tenure Calculator checking
			
			// LOAN Amount
			
			@FindBy(xpath="//input[@id='loanamount']")
			WebElement LOAN_amt_inputbox ;						//  inputbox
			
			@FindBy(xpath="//div[@id='loanamountslider']")
			WebElement LOAN_amt_slider ;				 		 //slider
			
			// EMI AMT
			
			@FindBy(xpath="//input[@id='loanemi']")
			WebElement EMI_Amt_Inputbox ;					// inputbox
			
			@FindBy(xpath="//div[@id='loanemislider']")
			WebElement EMI_Amt_Slider ;   					  //slider
			
			
			// INTEREST Rate 
			
			@FindBy(xpath="//input[@id='loaninterest']")
			WebElement InterestRate_Inputbox ;				// inputbox
			
			
			@FindBy(xpath="//div[@id='loaninterestslider']")
			WebElement InterestRate_slider ;   		 //slider
			
			// FEES AND CHARGES
			
			@FindBy(xpath="//input[@id='loanfees']")
			WebElement FeesAndCharges_Inputbox ;			// inputbox
			
			@FindBy(xpath="//div[@id='loanfeesslider']")
			WebElement FeesAndCharges_Slider  ;				// slider
			
			
			// ACTION METHODS
			
			public void setsLoan_Amount(String LoanAmount) throws InterruptedException
			{
				Thread.sleep(3000);
				fluentWait(LOAN_amt_inputbox);
				
				// since sendKeys not working directly we are using CtrlA to set data permanently 
				 LOAN_amt_inputbox.sendKeys(Keys.CONTROL +"a");
				LOAN_amt_inputbox.sendKeys(LoanAmount);
			}
			
			public String Loan_amt_Validation()
			{
				
				return LOAN_amt_inputbox.getAttribute("value");
				
			}
			
			public void setsEMI_Amount(String EMIAmt)
			{
				fluentWait(EMI_Amt_Inputbox);
				// since sendKeys not working directly we are using CtrlA to set data permanently 
				EMI_Amt_Inputbox.sendKeys(Keys.CONTROL +"a");
				EMI_Amt_Inputbox.sendKeys(EMIAmt);
				
				
			}
			public String EMI_Amt_Validation()
			{
				
				return EMI_Amt_Inputbox.getAttribute("value");
			}
			
			public void setsLoan_AmountInterest_RATE(String RATE)
			{
				fluentWait(InterestRate_Inputbox);
				// since sendKeys not working directly we are using CtrlA to set data permanently 
				InterestRate_Inputbox.sendKeys(Keys.CONTROL +"a");
				InterestRate_Inputbox.sendKeys(RATE);
			}
			public String Loan_Interest()
			{
				
				return InterestRate_Inputbox.getAttribute("value");
			}
			
			public void setsFees_AND_Charges_Amount(String feesANDCharges)
			{
				fluentWait(FeesAndCharges_Inputbox);
				// since sendKeys not working directly we are using CtrlA to set data permanently 
				FeesAndCharges_Inputbox.sendKeys(Keys.CONTROL +"a");
				FeesAndCharges_Inputbox.sendKeys(feesANDCharges);
			}
			
			public String Loan_Fees()
			{
				
				return FeesAndCharges_Inputbox.getAttribute("value");
			}
			
			// create methods for storing attribute values for validation and returning the final result
			
			public void NavigateToNextPAGE()
			{
				// navigating to the next or 4TH PAGE
				 InterestRateCalculator_LOGO.click();	
				
			}
}
