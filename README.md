# AssignmentOnEntrata....!
This project is a **Selenium Test Automation framework** built in **Java** to test the functionality of **Entrata** application.
It is designed to demonstrate automated UI testing using TestNG, **data-driven testing using Excel** (Apache POI), and generate detailed test reports with ExtentReports.

# Project Structure....!
- **Base classes** – Set up browser configuration, logging.
- **utilities** - reusable methods such as SeleniumWaits, takescreenshot, KeyReader etc.
- **POM Pages** - contains objects of relevent pages.
- **ExcelLibrary** - has methods to read data from excel file.
- **Test data** – Stored in an Excel file and configuration (`.properties`) file.
- **Reports** – Generated using ExtentReports for better test visibility.
- **Screenshots** - has all the screenshots taken at each page.
- **test-output/** – TestNG automatically generates reports in this directory after each test run.

# Test Coverage....!
Automated test cases validating different aspects of the application's UI and behavior.
1. Resident SignIn Test - **residentSignInTest()** - Validates that the navigation is as expected to redirected page title.
2. BillPay Navigation Test - **navigateToBillPayTest()** - Verifies that on the "Products" menu, selecting "Bill Pay" redirects to the correct page and checks for the expected page title.
3. Watch Demo Test - **watchDemoTest()** - Clicks on the "Watch Demo" button, waits for the demo form to load, and data is being read through excel file. Although the form isn't submitted, all field interactions are validated.

# Tech Stack & Dependencies....!
- **Java** - as a programming language - version 17.0.2
- **Maven** - as a Build tool - version 3.8.6
- **Selenium WebDriver** - to interact with web application - version 4.33.0
- **TestNG** - to manage all the tests and suits - version 7.11.0
- **Apache POI** – for reading Excel data - version 5.2.3
- **ExtentReports** – for generating test execution reports - version 5.1.2
- **log4j2** - for logging all the execution steps - version 2.24.3

All dependencies are managed via Maven in `pom.xml`.

# Execute tests using TestNG....!
- Open testng.xml file -> right click and run as TestNG Suite.
