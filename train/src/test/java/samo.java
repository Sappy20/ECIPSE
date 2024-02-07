
public class samo {

}



package pageObjects;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
public class BasePage {

	WebDriver driver;
	WebElement scrElement;
	String ss;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void screenShot(String ss) throws IOException
	{
		// Taking screenshot for a WebElement
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File("C:\\Users\\2303447\\eclipse-workspace\\hackathon\\screenshots\\"+ss+".png");
		FileUtils.copyFile(src,trg);
	}
	
  public void scroll(WebElement toThisElement)
  {
	 // scrolling to a WebElement by calling this method
	  Actions act=new Actions(driver);
	  act.scrollToElement(toThisElement);
	  
  }
  public void scrollToButtom()
  {
	  
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
  }
  
  public void explicitWait(WebElement elementLocated)
  {
	WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
	mywait.until(ExpectedConditions.visibilityOf(elementLocated));
	  
  }
	
  public void fluentWait(WebElement fwElement)
  {
	  //basic syntax of fluentwait
	  
	 FluentWait mywait1=new FluentWait(driver);
	 mywait1.withTimeout(Duration.ofSeconds(10));
	 mywait1.pollingEvery(Duration.ofSeconds(1));
	 mywait1.ignoring(NoSuchElementException.class);
	 
	 //fluentwait to work on webelemnt 
	 mywait1.until(ExpectedConditions.visibilityOf(fwElement));
	  
  }
}
