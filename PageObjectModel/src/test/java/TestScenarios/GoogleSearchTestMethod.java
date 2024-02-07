package TestScenarios;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Objects.Facebookpage;
import Objects.GoogleSearchPage;

//Common methods file for running and compiling all the page object classes

public class GoogleSearchTestMethod {
WebDriver driver;
GoogleSearchPage objectrepo;
// created a global variable for easier access
@BeforeTest
	public void beforeTest()
	{
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    
	driver.get("https://www.google.com/");
	
	try
	{
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src =ts.getScreenshotAs(OutputType.FILE);
	File trg = new File("C:\\Users\\2303447\\eclipse-workspace\\PageObjectModel\\screenshot");
	FileUtils.copyFile(src, trg);
	}
	catch(Exception e)
	{
		System.out.println("Exceptions caught"+ e.getMessage());
	}
			
	}

//after writing all these after and before methods we need to write the test methods
@Test(priority=0)
public void SearchOperation()
{
	try
	{
	GoogleSearchPage page = new GoogleSearchPage(driver);
	//we created method for searching and send data to that element
	//we are here just calling that method to search for the string data mentioned 
	page.searchgoogle("facebook");//we can search for anything here by passing to the string	
	Thread.sleep(2000);
	}
	catch(Exception e)
	{
		System.out.println("Exceptions caught"+e.getMessage());
	}
	
}
@Test(priority=1)
public void VerifAccessFacebook()
{
	//but we can only use it like here if we have already once created a proper object 
	objectrepo= new GoogleSearchPage(driver);
	objectrepo.ClickFacebook();
	//calling the method
}
@Test(priority=2)
public void VerifyLogin()
{
Facebookpage fb = new Facebookpage(driver);
try
{
// creating the object for facebook page object class to call all the methods as they are stored there
fb.EnterUserName();
fb.EnterPassword();

Thread.sleep(2000);

fb.VerifyingLogin();

	Thread.sleep(2000);
	}
catch(Exception e)
{
System.out.println("Exceptions Caught"+ e.getMessage());	
}
}




@AfterTest
public void aftertest() throws InterruptedException
{
	Thread.sleep(2000);
	driver.quit();
	}

}
