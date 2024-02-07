package base;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.time.Duration;
import java.util.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.beust.jcommander.Parameters;

import clojure.asm.commons.Method;
import utils.Constants;




public class BaseTest {
	public static WebDriver driver ;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	String result;
	@BeforeTest
	public void beforeTestMethod()
	{
		//Basic ExtentReports format
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+ File.separator+"reports"+File.separator+"SDETADDAE");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		sparkReporter.config().setTheme(Theme.DARK);
		extent.setSystemInfo("HostName","RHEL8");
		extent.setSystemInfo("UserName","root");
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Automation Tests Results by SDET ADDA");

	}

	@BeforeMethod  
	//@Parameters("browser")
	public void beforeMethodMethod(String browser,Method testMethod)
	{
		//parameterizing the test method by adding parameters inside the brackets beside the void method

		//passing the browser for handling
		logger = extent.createTest(testMethod.getName());
		//creating a logger report
		setUpDriver(browser);
		//after setting up browser need to get a url to open
		// taking string url from utils interface file
		driver.get(Constants.url);   
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@AfterMethod
	//in the after method we will be capturing the report 
	//logging everything to extent report
	public void afterMethod(ITestResult result)
	{
		//Write the codes for ontest skip and failure etc all here properly
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName()+"  - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+"  -Test Case Failed", ExtentColor.RED));
		}

	}
	@AfterTest
	public void afterTest()
	{
		extent.flush();

	}



	public void setUpDriver(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("edge"))
		{
			driver= new EdgeDriver();	
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();	
		}
	}
}
