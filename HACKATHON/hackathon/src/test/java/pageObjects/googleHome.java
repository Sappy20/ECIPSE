package pageObjects;

import org.openqa.selenium.WebDriver;

public class googleHome extends BasePage {

	public googleHome(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy()
	WebElement searchbox_input;
	
	@FindBy()
	WebElement google_image;

	
	@FindBy()
	WebElement search_start;


}
