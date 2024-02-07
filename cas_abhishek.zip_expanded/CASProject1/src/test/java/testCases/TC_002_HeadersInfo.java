
package testCases;
 
import java.util.List;
 
import org.testng.annotations.Test;
 
import PageObjects.HeadersInfo;
 
public class TC_002_HeadersInfo extends TC_001_VerifyUser {

	HeadersInfo hi;

	List<String> a;

	List<String> b;

	List<String> c;

	List<String> d;

	List<String> e;

	List<String> f;

	@Test(priority = 2)

	public void getHeadersInfo() {

		hi = new HeadersInfo(driver);

		a = hi.companyHeaderInfo();

		b = hi.serviceLineInfo();

		c = hi.salesResourcesInfo();

		d = hi.marketCountriesInfo();

		e = hi.corporateFunctionsInfo();

		f = hi.peopleInfo();

		hi.ethicsCompliance();

	}

}
