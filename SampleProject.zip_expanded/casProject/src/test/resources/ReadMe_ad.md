## Project Overview
 
This Selenium automation testing project focuses on automating tasks related to the Be.Cognizant portal. The primary objectives include capturing user information, navigating through the portal, verifying the presence of specific elements, and finding out what events are happening between two specific dates. The project uses various dependencies and libraries to facilitate automation.
 
## Project Structure
 
### 1. Maven Repository
 
- **Maven Version**: 3.12.1
 
### 2. Dependencies
  
- **TestNG**
- Version: 7.8.0
- Purpose: Framework for test automation that allows for parallel execution and flexible test configuration.
 
- **Extent Report**
- Version: 5.1.1
- Purpose: Generates interactive and detailed HTML reports to enhance test result analysis.
 
- **Selenium**
- Version: 4.15.0
- Purpose: Enables interaction with web elements, navigation, and form submission in the browser.

 
## Automation Test Flow
 
1. **Open Be.Cognizant Page**
- Navigate to the Be.Cognizant portal.
 
2. **Capture User Info**
- Click on the profile.
- Capture user information.
- Print and take screenshots.
 
3. **Checking if OneCognizant is visible**
- Click on One Cognizant.
- Switch Driver to One Cognizant Tab 
 
4. **Search For Outreach**
- Verify the presence of "Outreach"
- Click on "Outreach"
- Verify navigation to the correct Outreach page.
 
5. **Handle the Event Search for default location**
- Fill in the Event search form.
- Verify that the previous dates are disabled.
- Search for events for default location.
- Take screenshots of all events.
 
6. **Handle the Event Search for random location**
- Fill in the Event search form.
- Search for events for random location.
- Take screenshots of all events.
 
7. ** Print the dropdown elements.**
- Do it for Events, My Volunteering, Donate, Explore and Read More.
- Take Screenshots of each drop down elements.

 
8. **Navigate to My Voleentering**
- Get the 'Volunteered' data.
- Get 'Activities participated' data.
- Take Screenshots.
 
9. **Click on Goals**
- Print the information displayed under 'My goals'.
- Print the information displayed under 'Past goals'.
- Take Screenshots.
 
10. **Click on 'Volunteers around me'**
- Print all the apps name.
- Take Screenshot of all the apps.
 
 
## How to Run the Tests
 
1. **Open Eclipse IDE:**
- Launch Eclipse IDE on your machine.
 
2. **Import Project:**
- Select `File` -> `Import` from the menu.
- Choose `Existing Maven Projects` and click `Next`.
- Browse to the directory where you cloned the repository and select the project.
 
3. **Update Maven Project:**
- Right-click on the project in the Project Explorer.
- Choose `Maven` -> `Update Project`.
- Click `OK` to update dependencies.
 
4. **Run Test Suite:**
- Locate the test suite file (e.g., `src/test/java/TestSuite.java`).
- Right-click on the file and choose `Run As` -> `TestNG Suite`.
 
6. **View Reports:**
- After execution, open the `test-output` folder.
- Find the Extent Report HTML file (`index.html`) for detailed test reports.
 
## Author Information
 
- **Arif Iqbal**
- **Rajat Pandey**
- **Saptarshi Roy**
- **Suman Paul**
 
## Disclaimer
 
This project is intended for educational and testing purposes only. The authors are not responsible for any unauthorized use or modification of the code. Use at your own risk.