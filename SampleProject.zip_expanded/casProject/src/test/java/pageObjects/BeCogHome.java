package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BeCogHome extends BasePage {

	public BeCogHome(WebDriver driver) {
		super(driver);

	}

	//locators
	@FindBy(xpath="//div[@id='O365_MainLink_MePhoto']") WebElement userEle;

	@FindBy(id="mectrl_currentAccount_primary") WebElement userName;

	@FindBy(id="mectrl_currentAccount_secondary") WebElement userEmail;

	@FindBy(xpath="//div[@title='OneCognizant']") WebElement oneCogEle;

	//elements to verify
	@FindBy(xpath="//a[@class='oneC_brandName oneC_brandNameToggle']") WebElement OneCognizantElement;

	//screenshot elements
	@FindBy(xpath="//div[@id='mectrl_main_body']") WebElement userDetails;



	//action methods
	public void userEleClick() throws IOException
	{
		fluentWait(userEle);
		userEle.click();
		//using fluent wait method until the element occurs
		fluentWait(userDetails);

		screenShot("UserDetail");
	}

	public String getUserName() throws InterruptedException
	{
		Thread.sleep(10000);
		String name = userName.getText();
		System.out.println(name);
		return name;

	}

	public String getUserEmail()
	{
		String email = userEmail.getText();
		System.out.println(email);
		return email;


	}


	public boolean visibilityOf1C() throws IOException
	{
		fluentWait(oneCogEle);
		boolean boolRes = oneCogEle.isDisplayed();

		if(boolRes=true)
		{
			System.out.println("OneCognizant is displayed!");
		}
		else
		{
			System.out.println("OneCognizant is not displayed!");
		}
		scroll(oneCogEle);
		screenShot("OneCognizantButton");
		return boolRes ;
	}


	public void clickon1C()
	{
		oneCogEle.click();
	}

	public void swithTo1C() throws IOException
	{
		Set <String> winHandles = driver.getWindowHandles();
		ArrayList<String> listHandles = new ArrayList<String>(winHandles);
		String OneCogHan = listHandles.get(1);
		driver.switchTo().window(OneCogHan);
		driver.navigate().refresh();
		fluentWait(OneCognizantElement);
		screenShot("OneCognizantPage");
	}






}
