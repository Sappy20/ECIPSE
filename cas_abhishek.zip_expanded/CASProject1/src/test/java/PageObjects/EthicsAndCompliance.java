
package PageObjects;
 
import java.util.ArrayList;

import java.util.List;
 
//import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.FindBy;
 
public class EthicsAndCompliance extends BasePage{

	WebDriver driver;
 
	public EthicsAndCompliance(WebDriver d) 
	{

		// TODO Auto-generated constructor stub

		super(d);

		this.driver = d;

	}

	@FindBy(xpath = "//div[@data-automation-id='gradientBox']")

	WebElement targetBox;

//	@FindBy(xpath = "//span[contains(text(),'Key Ethics & Compliance Focus Areas')]")

//	WebElement keyEthicsElement;

	@FindBy(xpath="(//div[@data-automation-id='captionElement']/span)[1]")

	WebElement keyEthicsElement;

	@FindBy(xpath ="//div[@data-automation-id='tile-card']")

	List<WebElement> components;

	@FindBy(xpath = "//div[@data-automation-id=\"tile-card\"]//div[2]//div/div")

	List<WebElement> componentTexts;

	public String title() {

		return driver.getTitle();

	}

	public boolean keyEthicsAndCompliance() {

		Actions act = new Actions(driver);

//		JavascriptExecutor js = (JavascriptExecutor)driver;

//		js.executeScript("arguments[0].scrollIntoView()", keyEthicsElement);

		targetBox.click();

		try 
		{

			Thread.sleep(2000);

		} 
		
		catch (InterruptedException e)
		{

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		int j = 0;

		while (j<22)
		{

			act.keyDown(Keys.ARROW_DOWN).perform();

			j++;

		}

		if (keyEthicsElement.isDisplayed()) 
		{

			System.out.println(keyEthicsElement.getText());

		}

		return keyEthicsElement.isDisplayed();

	}

	public List<String> keyEthicsComponents()
	
	{

		System.out.println("Total no of componenets are - " + components.size());

		System.out.println("Componenets are - ");

		List<String> texts = new ArrayList<>();

		for (int i=0; i<componentTexts.size(); i++)
		{

			String st = componentTexts.get(i).getText();

			texts.add(st);

			System.out.println(st);

		}

		return texts;

	}

}
