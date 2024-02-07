package testBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass 

{
   public WebDriver driver;
   
   @BeforeClass
   public void setUp()
   {
	   driver = new ChromeDriver();
	   
	   driver.manage().window().maximize();
	   driver.get("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx");
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	   	   
   }
   
    @AfterClass
    public void tearDown()
    {
    	// driver.quit();
    }
}
