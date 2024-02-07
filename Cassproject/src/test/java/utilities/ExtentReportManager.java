package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	
public void onStart(ITestContext Context) {
		
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir","report" ));

		
		sparkReporter.config().setDocumentTitle("opencart Automation Report"); // Title of report
		sparkReporter.config().setReportName("opencart Functional Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("ComputerName", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("TestName", "Sappy");
		extent.setSystemInfo("os", "Windows11");
		extent.setSystemInfo("Browsername", "Chrome");
}
public void onTestSuccess(ITestResult result)
{
	test = extent.createTest(result.getName());
	test.log(Status.PASS,"Test can be passed" + result.getName());
	
}

public void onTestFailure(ITestResult result)
		
{
	test = extent.createTest(result.getName());
	test.log(Status.FAIL,"Test that are failed" + result.getName());
	test.log(Status.FAIL,"Test that are failed because of " + result.getThrowable());
	
	}	
	
public void onTestSkipped(ITestResult result)
{
	test=extent.createTest(result.getName());
	test.log(Status.SKIP,"Test case Skipped is:"+result.getName());
}

public void onFinish(ITestContext context)
{
 extent.flush();	
}
}

