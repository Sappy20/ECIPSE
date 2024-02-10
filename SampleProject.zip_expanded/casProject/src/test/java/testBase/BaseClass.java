package testBase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public WebDriver driver;
	public Logger logger;
	
	@BeforeClass
	@Parameters({"os", "browser"})
	public void setup(String os, String br) throws InterruptedException 
	{
		//loading log4j2 file
		logger = LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase())
		{
		case "chrome": driver = new ChromeDriver(); break;
		case "edge": driver = new EdgeDriver(); break; 
		default: System.out.println("No matching browser!");
									return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	
	public String randomString()
	{
		String randomAlphabets = RandomStringUtils.randomAlphabetic(5);
		return randomAlphabets;
	}
	
	public String randomNumber()
	{
		String randomNum = RandomStringUtils.randomNumeric(1);
		return randomNum;
	}
	
	
	public String randomAlphaNumeric()
	{
		String str = RandomStringUtils.randomAlphabetic(3);
		String num = RandomStringUtils.randomNumeric(3);
		return (str+"@"+num);
	}
	
	
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
	

}