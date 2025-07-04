package com.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.utility.ExtentReporter;
import com.utility.KeyReader;

@Listeners(ExtentITestListenerClassAdapter.class)
public class BaseClass {
	
	public static WebDriver driver;
	public Logger log = LogManager.getLogger();
	public static ExtentReports extent;
	public static ExtentTest test;
	
	@BeforeSuite
	public void setupReport() {
		extent = ExtentReporter.getExtentReports();
	}
	
	@BeforeTest
	public void launchBrowser() {
		log.info("Reading browser properties....!");
		if(driver==null) {
			if(KeyReader.getKey("browser").equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if(KeyReader.getKey("browser").equalsIgnoreCase("ie")) {
				driver = new InternetExplorerDriver();
			} else if(KeyReader.getKey("browser").equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}
		}
		driver.manage().window().maximize();
		log.info("Browser Launched Successfully....!");
		
	}
	
	@BeforeMethod
	public void openApplicationUrl() {
		log.info("Launching Application url....!");
		driver.get(KeyReader.getKey("url"));
	}
	
	@AfterTest
	public void tearDown() {
		log.info("Closing the browser....!");
		if(driver != null) {
			driver.quit();
		}
		log.info("Browser Closed Successfully....!");
	}
	
	@AfterSuite
	public void tearDownExtent() {
		extent.flush();
	}
}
