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

- **Apache-Log4j**
- Version: 2.22.1
- Purpose: To keep track of what happens in the software applications
 

- **Driver Setup**
- Purpose: Enables interaction browser and work with web browser without setting up file path for each browser in the SELENIUM version 4 and onwards .


## Automation Test Flow
 
1. **Open Google Home Page**

- Navigate to Google home page  .

2.** Search for EMICalculator Website **

- In the google home searchbar input emicalculator.net  .
-Click on Google Search button to initiate the search process  .
-Click on the 1st website that appears .

3.** Verify all LOAN Calculator sections with sliders **

-Check if all sections named as "Home Loan" , "Car Loan" , "Personal Loan" is working .
-Navigate to the Car Loan section 
-Input values to the calculator using sliders through automation script.

4.** Navigate to another page inside that website for further validation **

- Click on the CALCULATORS dropdown visible at the top right corner .
-Click on Home Loan EMI Calculator link .

5.** Working on the Home Loan Calculator Page  **

-Input all data to calculate the results .
- Store the displayed table in an excel table .

6.** Click on the Dropdown button  **

-After the dropdown appears click on LOAN Calculator.
-Check if all functions are working properly or not .


## How to Run the Tests
 
1. **Open Eclipse IDE:**
- Launch Eclipse IDE on your machine.
 
2. **Update Maven Project:**
- Right-click on the project in the Project Explorer.
- Choose `Maven` -> `Update Project`.
- Click `OK` to update dependencies.
 
3. **Run Test Suite:**
- Locate the test suite file (e.g., `src/test/java/TestSuite.java`).
- Right-click on the file and choose `Run As` -> `TestNG Suite`.
 
4.  **View Reports:**
- After execution, open the `test-output` folder.
- Find the Extent Report HTML file (`index.html`) for detailed test reports.
 


## Author Information
**SAPTARSHI  ROY**


## Disclaimer
 
 
This project is intended for educational and testing purposes only. The authors are not responsible for any unauthorized use or modification of the code. Use at your own risk.

 