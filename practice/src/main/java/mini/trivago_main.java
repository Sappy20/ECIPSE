package mini;

import org.openqa.selenium.WebDriver;

public class trivago_main {
 
	public static void main(String[] args) {
		// Creating WebDriver instance
		WebDriver driver = DriverSetup.createDriver();
		// Creating Availability instance
		Availability av = new Availability(driver);
		
			try {
				// Opening the browser
				av.openBrowser();
				
				// handling cookie
				av.handleCookie();
				
				// Reading data from the excel file "data.xlsx"
				av.readExcel();	
				
				// Setting the destination 
				av.setDestination();
				
				// Setting the Check-In date
				av.setCheckInDate();
				
				// Setting the Check-Out date
				av.setCheckOutDate();
				
				// Setting the number of adults
				av.setNoOfAdults();
				
				// Setting the number of rooms
				av.setNoOfRooms();
				
				// Taking screenshot before clicking on the apply button
				av.takeScreenshot("screenshot1.png");			
				
				// Clicking on the apply button
				av.clickOnApply();
				
				// Sorting the results by "Rating Only"
				av.sortByRating();
				
				// Adding a delay for 5 seconds
				Thread.sleep(5000);
				
				// Taking screenshot After sorting
				av.takeScreenshot("screenshot2.png");
				
				// Displaying the list of hotels with rents
				av.showHotelRents();
				
				// Checking whether Hotel ratings are in decreasing order or not
				av.checkRatingOrder();
				
				// Checking whether first 5 hotels belong to a specific city or not
				av.checkHotelCity();
				
				// Closing the browser
				av.closeBrowser();
				
			}catch (Exception e) {
				// Handling Exception
				e.printStackTrace();
			}
	}	
}
 



