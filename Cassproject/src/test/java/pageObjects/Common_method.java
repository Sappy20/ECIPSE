package pageObjects;
import org.openqa.selenium.*;

import java.io.File;
import java.util.*;

import org.openqa.selenium.support.PageFactory;

import groovyjarjarantlr4.v4.runtime.misc.LogManager;
import io.github.selcukes.commons.logging.Logger;

public class Common_method {
	WebDriver driver;
	public Common_method(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	 public void screenshot()
	    {
	   	TakesScreenshot ts = (TakesScreenshot)driver;
	   	File src =ts.getScreenshotAs(OutputType.FILE);
	   	File trg = new File("C:\\Users\\2303447\\eclipse-workspace\\Cassproject\\src\\screenshots");
	    }
}
