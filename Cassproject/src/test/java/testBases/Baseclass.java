package testBases;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.*;

@Test
public class Baseclass {
public WebDriver driver;
public Logger logger;	
	@BeforeClass
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx");
		driver.manage().window().maximize();
		
		logger=LogManager.getLogger(this.getClass());
		
	}
	@BeforeMethod
	public void window()
	{
		Set<String> windowhandle_id= driver.getWindowHandles();
		List<String> win_list= new ArrayList(windowhandle_id);
		String parentwindow =win_list.get(0);
				String childwindow =win_list.get(1);
				String ss = driver.switchTo().window(parentwindow).getTitle();
				if(ss.contains("Be.Cognizant") )
				{
					driver.switchTo().window(childwindow);
				}
			
				else {
					driver.switchTo().window(parentwindow);
				}
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
    @BeforeTest
	public String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
   


}
