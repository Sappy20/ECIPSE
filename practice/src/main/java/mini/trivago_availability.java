package mini;





import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class trivago_availability
{
	
	WebDriver driver;	
	String[] details;
	
	// Constructor
	public trivago_availability(WebDriver driver) {
		this.driver = driver;
	}
 
	// Method to open the application
	public void openBrowser() throws InterruptedException{		
		driver.get("https://www.trivago.in/");
		// wait for 10 second
	    Thread.sleep(10000);    
	    
	}
	
	// Method to handle Cookies
	public void handleCookie() {
		WebElement acceptButton = null;
		try {
			WebElement shadowHost = driver.findElement(By.xpath("//div[@id='usercentrics-root']"));
			// Locating the accept button in the cookie popup
		    acceptButton = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot.querySelector(arguments[1]);",shadowHost, "[data-testid='uc-accept-all-button']" );
		} catch (Exception e) {
			System.out.println("Accept button not found in the Shadow DOM for accepting cookie popup");
		}
		// Clicking the accept button
	    if (acceptButton != null) {
	        acceptButton.click();
	    }
	}
 
	// Method to read data from the excel file
	public void readExcel() throws IOException {
		details = ExcelUtility.getExcelData();
	}
	
	// Method to set the destination
	public void setDestination() {
		driver.findElement(By.xpath("//input[@data-testid='search-form-destination']")).sendKeys(details[0]);
		driver.findElement(By.xpath("(//div[@data-testid='ssg-element'])[1]")).click();
	}
	
	// Method to set the check-In date
	public void setCheckInDate() {
		String CheckinYear = details[1].substring(7);
		String CheckinMonth = details[1].substring(3,6);
		String CheckinDay = details[1].substring(0,2);				
		while(true) {
			String CalMonYear =  driver.findElement(By.xpath("(//*[@id='__next']//h3)[2]")).getText(); 
			String curMonth = CalMonYear.substring(0, 3);
			if(curMonth.equals(CheckinMonth) && CalMonYear.endsWith(CheckinYear)) {
				break;
			}else {
				driver.findElement(By.xpath("//button[@data-testid='calendar-button-next']")).click();
			}
		}
		List<WebElement> Checkindays;
		do {
			Checkindays = driver.findElements(By.xpath("//*[@id='__next']//div[1]/div[2]/button/time"));	
		}while(Checkindays.isEmpty());
		for(WebElement d : Checkindays) {
			try {
				if(d.getText().equals(CheckinDay)) {
					d.click();
					break;
				}
			}catch (StaleElementReferenceException e) {
				Checkindays = driver.findElements(By.xpath("//*[@id='__next']//div[1]/div[2]/button/time"));	
			}			
		}
	}
	
	// Method to set the check-Out date
	public void setCheckOutDate() {
		String CheckoutYear = details[2].substring(7);
		String CheckoutMonth = details[2].substring(3,6);
		String CheckoutDay = details[2].substring(0,2);
		while(true) {
			String CalMonYear =  driver.findElement(By.xpath("(//*[@id='__next']//h3)[2]")).getText(); 
			String curMonth = CalMonYear.substring(0, 3);
			if(curMonth.equals(CheckoutMonth) && CalMonYear.endsWith(CheckoutYear)) {
				break;
			}else {
				driver.findElement(By.xpath("//button[@data-testid='calendar-button-next']")).click();
			}
		}		
		List<WebElement> Checkoutdays;
		do {
			Checkoutdays = driver.findElements(By.xpath("//*[@id='__next']//div[1]/div[2]/button/time"));
		}while(Checkoutdays.isEmpty());
		for(WebElement d : Checkoutdays) {
			try {
				if(d.getText().equals(CheckoutDay)) {
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			        wait.until(ExpectedConditions.elementToBeClickable(d));
					d.click();
					break;
				}
			}catch (StaleElementReferenceException e) {
				Checkoutdays = driver.findElements(By.xpath("//*[@id='__next']//div[1]/div[2]/button/time"));
			}			
		}
	}
	
	// Method to set the number of adults
	public void setNoOfAdults() {
		int exp_adults =(int) Double.parseDouble(details[3]);
		while(true) {
			String value = driver.findElement(By.xpath("//input[@data-testid='adults-amount']")).getAttribute("value");
			int act_adults = Integer.parseInt(value);
			if(act_adults>exp_adults) {
				WebElement minusButton = driver.findElement(By.xpath("//button[@data-testid='adults-amount-minus-button']"));
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", minusButton);
 
			}else if(act_adults<exp_adults) {
				driver.findElement(By.xpath("//button[@data-testid='adults-amount-plus-button']")).click();
			}else {
				break;
			}
		}
	}
	
	// Method to set the number of rooms
	public void setNoOfRooms() {
		int exp_rooms = (int)Double.parseDouble(details[4]);
		while(true) {
			String value = driver.findElement(By.xpath("//input[@data-testid='rooms-amount']")).getAttribute("value");
			int act_rooms = Integer.parseInt(value);
			if(act_rooms>exp_rooms) {
				driver.findElement(By.xpath("//button[@data-testid='rooms-amount-minus-button']")).click();
			}else if(act_rooms<exp_rooms) {
				driver.findElement(By.xpath("//button[@data-testid='rooms-amount-plus-button']")).click();
			}else {
				break;
			}
		}
	}
	
	// Method to take screenshot
	public void takeScreenshot(String scName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(System.getProperty("user.dir")+"\\screenshots\\"+scName);
		FileUtils.copyFile(src, trg);
	}
	
	// Method to click apply for searching
	public void clickOnApply() {
		driver.findElement(By.xpath("//button[@data-testid='guest-selector-apply']")).click();
	}
	
	// Method to select Sort By “Rating only”
	public void sortByRating() {
		try {
			WebElement element =  driver.findElement(By.xpath("//*[@id='sorting-selector']"));
			Select select = new Select(element);
			select.selectByVisibleText("Rating only");
		} catch (Exception e) {
			Actions act = new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//button[@name='sorting_selector']"))).perform();
			driver.findElement(By.xpath("//label[contains(text(),'Rating only')]//preceding-sibling::input")).click();
			driver.findElement(By.xpath("//button[@data-testid='filters-popover-apply-button']")).click();
		}
	}
	
	// Method to get the list of hotel rents
	public void showHotelRents() {
		List<WebElement> hotels = driver.findElements(By.xpath("//button[@data-testid='item-name']"));
		List<WebElement> rents = driver.findElements(By.xpath("//p[@data-testid='recommended-price']"));
		System.out.println("-------------------------------------");
		System.out.println("------------ hotel rents ------------");
		System.out.println("-------------------------------------");
		for(int i=0;i<hotels.size();i++) {
			System.out.println(hotels.get(i).getText()+" ---- "+rents.get(i).getText());
		}
	}
	
	// Method to check that ratings are in decreasing order or not
	public void checkRatingOrder() throws IOException {
		List<WebElement> hotels = driver.findElements(By.xpath("//button[@data-testid='item-name']"));
		List<WebElement> ratings = driver.findElements(By.xpath("//span[@itemprop='ratingValue']"));
		System.out.println("---------------------------------------");
		System.out.println("------------ hotel ratings ------------");
		System.out.println("---------------------------------------");
		for(int i=0;i<hotels.size();i++) {
			System.out.println(hotels.get(i).getText()+" ---- "+ratings.get(i).getText());
		}
		System.out.println("-------------------------------------");
		boolean result = true;
		for(int i=0;i<ratings.size()-1;i++){
			double rating1 = Double.parseDouble(ratings.get(i).getText());
			double rating2 = Double.parseDouble(ratings.get(i+1).getText());
			if(rating1<rating2) {
				result=false;
				break;
			}
		}
		System.out.println("Checking whether Ratings are in decreasing order.....");
		if(result) {
			System.out.println("Test passed");
			ExcelUtility.writeExcelData("PASS", 1);
		}else {
			System.out.println("Test failed");
			ExcelUtility.writeExcelData("FAIL", 1);
		}
	}
	
	// Method to check whether first 5 city are from same city(Ex.Mumbai) or not
	public void checkHotelCity() throws IOException {
		boolean result1 = true;
		List<WebElement> infoElements = driver.findElements(By.xpath("//button[@data-testid='distance-label-section']"));
		try {
			for(int i=0;i<5;i++) {
				infoElements.get(i).click();
				WebElement loc = driver.findElement(By.xpath("//span[@itemprop='addressLocaspanty']"));

				if(loc.isDisplayed()) {
					String hotelLoc =  loc.getText().replace(", ", "");

					if(!hotelLoc.equalsIgnoreCase("Mumbai")) {
						result1 = false;
					}
				}
				else {
					continue;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Checking whether first 5 city belongs to specific city searched for .....");
		if(result1) {
			System.out.println("Test passed");
			ExcelUtility.writeExcelData("PASS", 2);
		}
		else {
			System.out.println("Test failed"); 
			ExcelUtility.writeExcelData("FAIL", 2);
		}
	}
	
	// Method to close the browser
	public void closeBrowser() {
		driver.quit();
	}
 
}
