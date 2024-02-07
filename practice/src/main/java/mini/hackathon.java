package mini;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;



import java.time.Duration;
import java.util.*;

public class hackathon {

	public static String link_web;
	public static int links ;
	public static WebElement element;
	public static WebDriver driver ;
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=null;
		System.out.println("Choose your browser \n");
		System.out.println("Press 1 for ChromeBrowser \n Press 2 for EdgeBrowser ");
		Scanner input = new Scanner(System.in);
		int  choice = input.nextInt();
		input.close();
		if(choice==1)
		{
			driver = new ChromeDriver();
		}
		else if(choice==2)
		{
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Invalid choice");
		}
		//managing browser windows
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement google_search_input=driver.findElement(By.id("APjFqb"));
		google_search_input.click();
		Thread.sleep(2000);
		google_search_input.sendKeys("emicalculator.net");
		
		Thread.sleep(2000);
		WebElement g_search_btn= driver.findElement(By.xpath("(//input[@class='gNO89b'][@value='Google Search'])[1]"));
		 g_search_btn.click();
		 
		 Thread.sleep(2000);
		 WebElement calculator_link=driver.findElement(By.xpath("//h3[contains(text(),'EMI Calculator for Home Loan, Car Loan & Personal Loan in ...')]"));
		 calculator_link.click();
		 
		 Thread.sleep(2000);
		 String home_page=driver.getTitle();
		 System.out.println(home_page);
		 
		 Thread.sleep(2000);
		 
		 WebElement carloan_calculator=driver.findElement(By.xpath("//a[contains(text(),'Car Loan')]"));
		 carloan_calculator.click();
		 Thread.sleep(2000);
		 
		 WebElement carloan_amount=driver.findElement(By.xpath("//input[@id='loanamount']"));
		 carloan_amount.clear();
		 Thread.sleep(2000);
	    
		   

		    
		 //carloan_amount.sendKeys("15,00,000");
		//  Thread.sleep(2000);
		/* 
		 WebElement carloan_interest=driver.findElement(By.xpath("//input[@id='loaninterest']"));
		 carloan_interest.clear();
		 Thread.sleep(2000);
		 carloan_interest.sendKeys("9.5");
		 Thread.sleep(2000);
		 
		 WebElement carloan_tennure=driver.findElement(By.xpath("//input[@id='loanterm']"));
		 carloan_tennure.clear();
		 Thread.sleep(2000);
		 carloan_tennure.sendKeys("1");
		 */
		 Actions act = new Actions(driver);
		 WebElement loan_slider=driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]"));
		
		 System.out.println("Location is: "+loan_slider.getLocation());
		// act.doubleClick(loan_slider).perform();
		 Thread.sleep(1000);
	    //  act.dragAndDropBy(loan_slider,580,319).perform();  // original is 121,309
		 
		 WebElement interest_slider=driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
		 System.out.println("Location is: "+interest_slider.getLocation());	
		 
		 WebElement tennure_slider=driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[3]"));
		 System.out.println("Location is: "+tennure_slider.getLocation());
		 
		 
		 // clicking on dropdown
		 WebElement Calculator_link =driver.findElement(By.xpath("//a[@title='Calculators']")); 
		 Calculator_link.click();
		
		 // clicking on the a dropdown option
		 WebElement HomeLoanEMICalculator = driver.findElement(By.xpath("(//a[@href='https://emicalculator.net/home-loan-emi-calculator/'])[1]"));
		 
		 HomeLoanEMICalculator.click();
		 
		 
		 
		 // SELECTING  DATE  PICKER
		 WebElement date_calender= driver.findElement(By.xpath("//input[@id='startmonthyear']"));
		 date_calender.click();
		 
		
		 
		 WebElement Feb_month= driver.findElement(By.xpath("//span[contains(text(),'Feb')]"));
		 Feb_month.click(); 
		 
		 
		 Thread.sleep(5000);
		 driver.quit();
	}

}