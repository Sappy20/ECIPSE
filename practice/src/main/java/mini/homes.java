package mini;
import java.time.Duration;
import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class homes {
	public static String link_web;
	public static int links ;
	public static WebElement element;
	public static WebDriver driver ;
	public static void main(String[] args) {
		WebDriver driver = null;
		System.out.println("Enter your choice");
		System.out.println("\n Press 1 for ChromeBrowser \n Press 2 for EdgeBrowser");
 Scanner input = new Scanner(System.in);
		int choice= input.nextInt();
		if(choice==1) 
		{
			driver= new ChromeDriver();
		}
		if(choice==2)
		{
			driver= new EdgeDriver();
		}
		
		driver.get("https://ishahomes.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		Alert alertwindow=driver.switchTo().alert();
//			alertwindow.dismiss();
			driver.findElement(By.xpath("//a[contains(text(),'Completed Projects')]")).click();
		
			
			
			driver.quit();
	}

}
