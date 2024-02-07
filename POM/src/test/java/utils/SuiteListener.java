package utils;
// for any test that fails we can store screenshots and reports here 

import java.io.File;

import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
//implementing 2 interfaces in suite listener 
public class SuiteListener implements ITestListener , IAnnotationTransformer{

	public void onTestFailure(ITestResult result)
	{
		String filename= System.getProperty("user.dir")+File.separator+"screenshots"+File.separator+result.getName();
	File file =(TakesScreenshot)BaseTest.driver)
	}
}
