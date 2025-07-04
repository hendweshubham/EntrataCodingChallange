package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.HomePage;
import com.utility.ExcelLibrary;
import com.utility.KeyReader;
import com.utility.SeleniumWaits;
import com.utility.TakeSnap;

public class HomePageTest extends BaseClass{
	
	private static HomePage home;
	private static ExcelLibrary obj;
	
	@Test (priority=1)
	public void residentSignInTest() {
		log.info("Navigating to Resident SignIn Screen....!");
		test = extent.createTest("Resident SignIn Test");
		
		home = new HomePage(driver);
		
		home.clickOnSignIn();
		log.info("Clicked on Sign In....!");
		
		SeleniumWaits.waitForThePageLoad(driver, 8);
		
		TakeSnap.takeScreenshot(driver, "SignInPage");
		log.info("Navigated on " + driver.getTitle() + "....!");
		
		home.clickOnResidentLogin();
		log.info("Clicked on Resident Login....!");
		
		SeleniumWaits.waitForThePageLoad(driver, 8);
		
		log.info("Navigated on " + driver.getTitle() + "....!");
				
		home.enterEmail(KeyReader.getKey("email"));
		log.info("Entered Email from COnfig file....!");
		
		home.enterPassword(KeyReader.getKey("password"));
		log.info("Entered Password from Config file to Sign In....!");
		
		TakeSnap.takeScreenshot(driver, "Resident Portal");
		
		Assert.assertTrue(driver.getTitle().contains("ResidentPortal"), "Title should have 'ResidentPortal'");
	}
	
	@Test(priority=2)
	public void watchDemoTest() {
		obj = new ExcelLibrary();
		log.info("Navigating to Demo Form Screen....!");
		test = extent.createTest("Watch Demo Test");
		
		home = new HomePage(driver);
		
		home.clickOnDemoButton();
		log.info("Clicked on Watch Demo....!");
		
		SeleniumWaits.waitForThePageLoad(driver, 10);
		
		log.info("Reading Form data using excel file....!");
		home.enterFirstName(obj.readData(KeyReader.getKey("sheetName"), 1, 0));
		log.info("Entered First Name....!");
		
		home.enterLastName(obj.readData(KeyReader.getKey("sheetName"), 1, 1));
		log.info("Entered Last Name....!");
		
		home.enterEmailId(obj.readData(KeyReader.getKey("sheetName"), 1, 2));
		log.info("Entered Email Id....!");
		
		home.enterCompanyName(obj.readData(KeyReader.getKey("sheetName"), 1, 3));
		log.info("Entered Company Name....!");
		
		home.enterPhoneNumber(obj.readData(KeyReader.getKey("sheetName"), 1, 4));
		log.info("Entered Phone Number....!");
		
		home.selectUnits();
		log.info("Managed Units selected from the list....!");
		
		home.enterJobTitle(obj.readData(KeyReader.getKey("sheetName"), 1, 5));
		log.info("Entered Job Title....!");
		
		home.selectWhoYouAre();
		log.info("Resident option is selected from the list....!");
		
		TakeSnap.takeScreenshot(driver, "DemoFormScreen");
		
		Assert.assertTrue(driver.getTitle().contains("Optimize Property Management"), "Title should have 'Optimize Property Management'");
	}

}
