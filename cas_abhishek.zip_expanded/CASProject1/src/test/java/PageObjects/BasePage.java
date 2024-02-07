
package PageObjects;
 
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
 
public class BasePage {

	WebDriver driver;

	public BasePage(WebDriver d) {

		// TODO Auto-generated constructor stub

		this.driver = d;

		PageFactory.initElements(driver, this);

	}

}