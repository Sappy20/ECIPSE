import java.time.Duration;
import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class train_ticket
   {
	public static String link_web;
    
public static void main(String[] args)throws InterruptedException
  {
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver-win64\\chromedriver.exe"); 
	// Launch the browser
	ChromeDriver driver =new ChromeDriver();
	 driver.get("https://www.rediff.com");

   }
