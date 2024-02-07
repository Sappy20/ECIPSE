
package utilities;
 
import java.io.File;

import java.io.IOException;
 
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
 
public class ScreenShotClass 
{

	WebDriver driver;

	public ScreenShotClass(WebDriver d)
	{

		this.driver = d;

	}

	public void takeScreenShot(String s) {

		TakesScreenshot ts  = (TakesScreenshot)driver;

		File srFile = ts.getScreenshotAs(OutputType.FILE);

		File trgFile = new File(System.getProperty("user.dir")+"\\screenshot\\sShot"+s+".png");

		try 
		{

			FileUtils.copyFile(srFile, trgFile);

		} 
		catch (Exception e) 
		{

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

}
