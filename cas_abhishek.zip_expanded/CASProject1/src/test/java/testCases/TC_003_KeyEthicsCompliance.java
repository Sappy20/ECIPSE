
package testCases;
 
import java.io.IOException;

import java.util.List;
 
import org.testng.Assert;

import org.testng.annotations.Test;
 
import PageObjects.EthicsAndCompliance;

import utilities.ExcelUtilities;
import utilities.ScreenShotClass;


 
public class TC_003_KeyEthicsCompliance extends TC_002_HeadersInfo{

	EthicsAndCompliance ec;

	ScreenShotClass ssc;

	List<String> g;

	@Test(dependsOnMethods = "getHeadersInfo")

	public void screenShot() {

		ssc=new ScreenShotClass(driver);

		ssc.takeScreenShot("1st");

	}

	@Test(priority = 3)

	public void titleCheck() {

		ec = new EthicsAndCompliance(driver);

		String st = ec.title();

		Assert.assertEquals(st, "Ethics & Compliance");

	}

	@Test(priority = 4)

	public void keyEthicsCheck() {

		ec = new EthicsAndCompliance(driver);

		Assert.assertTrue(ec.keyEthicsAndCompliance());

	}

	@Test(dependsOnMethods = "keyEthicsCheck")

	public void keyEthicsComponenetsPrint() {

		 g =ec.keyEthicsComponents();

		ssc.takeScreenShot("2nd");

	}

	@Test(priority = 6)

	public void dataWrite() {



		ExcelUtilities eu = new ExcelUtilities();

		try {

			eu.createRows(a,b,c,d,e,f,g);

			eu.collectHeadersInfo(a,b,c,d,e,f,g);

		} catch (IOException e1) {

			// TODO Auto-generated catch block

			e1.printStackTrace();

		}

	}

}
