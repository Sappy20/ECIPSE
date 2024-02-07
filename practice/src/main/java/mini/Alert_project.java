package mini;
import java.time.Duration;
import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
public class Alert_project {

	public static String link_web;
	public static int links ;
	public static WebElement element;
	public static WebDriver driver ;
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=null;
		System.out.println("Choose your browser \n");
		System.out.println("Press 1 for ChromeBrowser \n Press 2 for EdgeBrowser \n Any other input is Invalid Choice");
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
		driver.get("https://www.stqatools.com/demo/Alerts.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Thread.sleep(4000);
		driver.findElement(By.xpath("(//button[contains(text(),'Basic Alert')])[2]")).click();
		//managing or handling alerts
		Alert alt = driver.switchTo().alert();

		Thread.sleep(4000);
		alt.accept();
		Thread.sleep(1000);
		WebElement prompt_alert=driver.findElement(By.id("jpalert"));

		prompt_alert.click();
		Thread.sleep(2000);
		alt.sendKeys("hello world");

		alt.accept();
		//navigating to website	
		driver.navigate().to("https://stqatools.com/demo/");
		//clicking on register link
		WebElement register=driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
		register.click();
		//name input
		WebElement name=driver.findElement(By.xpath("//input[@placeholder='Enter your name']"));
		name.click();
		name.sendKeys("Amol");

		Thread.sleep(2000);
		//address input
		WebElement address=driver.findElement(By.xpath("//input[@placeholder='Enter your address']"));
		address.click();
		address.sendKeys("Mumbai");
		Thread.sleep(2000);

		//Selecting gender
		WebElement male_btn = driver.findElement(By.id("male"));
		//	WebElement female_btn = driver.findElement(By.id("female"));

		male_btn.click();
		Thread.sleep(1000);

		//selecting hobby
		//	WebElement reading_chkbox = driver.findElement(By.id("reading"));
		//	
		//	WebElement travelling_chkbox = driver.findElement(By.id("Traveling"));

		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement ele =driver.findElement(By.xpath("//label[@for='hobbies']"));

		js.executeScript("arguments[0].scrollIntoView();", ele);
		WebElement music_chkbox = driver.findElement(By.xpath("//label[@for='music']"));
		music_chkbox.click();
		Thread.sleep(1000);

		//scroll down to the bottom of the page

		WebElement submit_btn=driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
		js.executeScript("arguments[0].scrollIntoView;",submit_btn);

		//use webelementname.click(); method to select the desired one
		/*WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));

	List<WebElement> country_list=mywait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By.xpath("//*[contains(text(),'Select a country')]"))));
	int country_count =country_list.size();
	System.out.println("No of Countries present"+country_count);
	for(WebElement i: country_list) {
		if(i.getText().equalsIgnoreCase("india"))
		{
			i.click();
			break;
		}
	}

	List<WebElement> city_list=mywait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By.xpath("//option[contains(text(),'Select a city')]"))));
	int city_count =city_list.size();
	System.out.println("No of Cities present"+city_count);
	for(WebElement i: city_list) {
		if(i.getText().equalsIgnoreCase("delhi"))
		{
			i.click();
			break;
		}
	}
		 */
		
		
		Thread.sleep(1000);
		//using select tag to select india
		//by changing the string inside VisibleText(); we change the selection from dropdown
		WebElement country_drp=driver.findElement(By.xpath("//select[@id='country']"));
		country_drp.click();
		Select drp_ele= new Select(country_drp);
		drp_ele.selectByVisibleText("India");



		Thread.sleep(2000);
		/*
	List<WebElement> options=drp_ele.getOptions();
	System.out.println("Total number of options \n"+options.size());
	for(int i=1;i<options.size();i++)
	{
		System.out.println(options.get(i).getText());



	}
	//selecting india
	WebElement india=driver.findElement(By.xpath("//option[@value='India'][contains(text(),'India')]"));
	js.executeScript("arguments[0].click()",india);
		 */


		Thread.sleep(2000);
		//by changing the string inside VisibleText(); we change the selection from dropdown
		WebElement city_drp=driver.findElement(By.xpath("//select[@id='city']"));
		city_drp.click();
		Select city_drp_ele= new Select(city_drp);
		city_drp_ele.selectByVisibleText("Delhi");
		
		
		// working on date picker calender
		Thread.sleep(2000);
		WebElement calender_dob=driver.findElement(By.xpath("//input[@id='dob']"));
		// write the date in website and copy that inside this sendKeys string to set the date
		calender_dob.sendKeys("05-12-2000");
		//js.executeScript("arguments[0].click()",calender_dob);
		
		Thread.sleep(2000);
		//clicking on submit button
		submit_btn.click();
		
		//ending test
		Thread.sleep(4000);
		driver.quit();
	}
}
