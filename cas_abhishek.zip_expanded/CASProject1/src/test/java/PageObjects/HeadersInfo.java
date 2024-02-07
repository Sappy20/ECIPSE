
package PageObjects;
 
import java.util.ArrayList;

import java.util.List;
 
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.FindBy;
 
public class HeadersInfo extends BasePage{
 
	public HeadersInfo(WebDriver d) {

		// TODO Auto-generated constructor stub

		super(d);

	}

	@FindBy(xpath = "//button[@name=\"Company\"]//span//span//span")

	WebElement companyHeader;

	@FindBy(xpath = "//li[@role='presentation']//span")

	List<WebElement> companyHeaderOptions;

	@FindBy(xpath = "//button[@name='Service Lines']//span//span//span")

	WebElement serviceLine;

	@FindBy(xpath = "//li[@role='presentation']//span")

	List<WebElement> serviceLineOptions;

	@FindBy(xpath = "//button[@name='Sales Resources']//span//span//span")

	WebElement salesResources;

	@FindBy(xpath = "//li[@role='presentation']//span")

	List<WebElement> salesResourcesOptions;

	@FindBy(xpath = "//button[@name='Markets and Countries']//span//span//span")

	WebElement marketCountries;

	@FindBy(xpath = "//li[@role='presentation']//span")

	List<WebElement> marketCountriesOptions;

	@FindBy(xpath = "//button[@name='Corporate Functions']//span//span//span")

	WebElement corporateFunctions;

	@FindBy(xpath = "//li[@role='presentation']//span")

	List<WebElement> corporateFunctionsOptions;

	@FindBy(xpath = "(//li[@role='presentation']//span)[3]")

	WebElement legalCorporateAffairs;

	@FindBy(xpath = "//span[contains(text(),'Ethics and Compliance')]")

	WebElement ethicsCompliance;

	@FindBy(xpath = "//button[@name='People']//span//span//span")

	WebElement people;

	@FindBy(xpath = "//li[@role='presentation']//span")

	List<WebElement> peopleOptions;


//	public void allHeaders() {

//		

//	}

	public List<String> companyHeaderInfo() {

		companyHeader.click();

		List<String> optionsText = new ArrayList<String>();

		System.out.println("Componenets of Company Header are - ");

		for (int i=0; i<companyHeaderOptions.size(); i++) {

			String s = companyHeaderOptions.get(i).getText();

			optionsText.add(s);

			System.out.println(s);

		}

		return optionsText;

	}

	public List<String> serviceLineInfo() {

		serviceLine.click();

		List<String> optionsText = new ArrayList<String>();

		System.out.println("Componenets of Service Line Header are - ");

		for (int i=0; i<serviceLineOptions.size(); i++) {

			String s = serviceLineOptions.get(i).getText();

			optionsText.add(s);

			System.out.println(s);

		}

		return optionsText;

	}

	public List<String> salesResourcesInfo() {

		salesResources.click();

		List<String> optionsText = new ArrayList<String>();

		System.out.println("Componenets of Sales & Resources Header are - ");

		for (int i=0; i<salesResourcesOptions.size(); i++) {

			String s = salesResourcesOptions.get(i).getText();

			optionsText.add(s);

			System.out.println(s);

		}

		return optionsText;

	}

	public List<String> marketCountriesInfo() {

		marketCountries.click();

		List<String> optionsText = new ArrayList<String>();

		System.out.println("Componenets of Markets & Countries Header are - ");

		for (int i=0; i<marketCountriesOptions.size(); i++) {

			String s = salesResourcesOptions.get(i).getText();

			optionsText.add(s);

			System.out.println(s);

		}

		return optionsText;

	}

	public List<String> corporateFunctionsInfo() {

		corporateFunctions.click();

		List<String> optionsText = new ArrayList<String>();

		System.out.println("Componenets of Corporate Functions Header are - ");

		for (int i=0; i<corporateFunctionsOptions.size(); i++) {

			String s = corporateFunctionsOptions.get(i).getText();

			optionsText.add(s);

			System.out.println(s);

		}

		return optionsText;

	}

	public List<String> peopleInfo() {

		people.click();

		List<String> optionsText = new ArrayList<String>();

		System.out.println("Componenets of People Header are - ");

		for (int i=0; i<peopleOptions.size(); i++) {

			String s = peopleOptions.get(i).getText();

			optionsText.add(s);

			System.out.println(s);

		}

		return optionsText;

	}

	public void ethicsCompliance() {

		corporateFunctions.click();

		Actions act = new Actions(driver);

		act.moveToElement(legalCorporateAffairs).perform();

		try {

			Thread.sleep(2000);

		} catch (InterruptedException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		ethicsCompliance.click();

		try {

			Thread.sleep(5000);

		} catch (InterruptedException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

}
