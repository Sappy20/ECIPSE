
package PageObjects;
 
import java.util.List;
 
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
 
public class HomePage extends BasePage{

	WebDriver driver;
 
	

	public HomePage(WebDriver driver) {

		super(driver);

	}

	@FindBy(xpath = "//button[@role=\"menuitem\"]/span/span/span")

	List<WebElement> headers;

	@FindBy(xpath = "(//span[@data-automationid=\"splitbuttonprimary\"])[1]/span/span")

	WebElement beCognizantHeader;

	@FindBy(xpath="//div[@id='O365_MainLink_MePhoto']")

	WebElement myAcc;

	@FindBy(xpath="//div[@id='mectrl_currentAccount_primary']")

	WebElement myName;

	@FindBy(xpath="//div[@id='mectrl_currentAccount_secondary']")

	WebElement myMailId;

	public String headerCheck() {

		System.out.println("Total numbers of headers - "+ headers.size());

		System.out.println("Header tabs names are - ");

		for (int i=0; i<headers.size(); i++) {

			System.out.println(headers.get(i).getText());

		}

		return beCognizantHeader.getText();

	}

	public void clickOnMyAcc() {

		myAcc.click();

	}

	public String getName() {

		return myName.getText();

	}

	public String getMailId() {

		return myMailId.getText();

	}

}
