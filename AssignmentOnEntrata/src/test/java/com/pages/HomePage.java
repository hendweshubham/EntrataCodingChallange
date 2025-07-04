package com.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.utility.SeleniumWaits;

public class HomePage {
	
	private WebDriver driver;
	public static final Logger log = LogManager.getLogger(HomePage.class);
	
	@FindBy(xpath="//*[@class='button is-secondary is-nav w-button']") private WebElement signIn;
	@FindBy(xpath="//div[@class='button_text' and text()='Resident Login']") private WebElement residentLogin;
	@FindBy(xpath="(//input[@type='email'])[1]") private WebElement email;
	@FindBy(xpath="(//*[@type='password'])[1]") private WebElement password;
	@FindBy(xpath="//*[text()='Watch demo']") private WebElement demoButton;
	
	//Elements on Demo screen are listed below......!
	@FindBy(xpath="//*[@id='FirstName']") private WebElement firstName;
	@FindBy(xpath="//*[@id='LastName']") private WebElement lastName;
	@FindBy(xpath="//*[@id='Email']") private WebElement emailId;
	@FindBy(xpath="//*[@id='Company']") private WebElement companyName;
	@FindBy(xpath="//*[@id='Phone']") private WebElement phoneNumber;
	@FindBy(xpath="//*[@id='Unit_Count__c']") private WebElement managedUnit;
	@FindBy(xpath="//*[@id='Title']") private WebElement jobTitle;
	@FindBy(xpath="//*[@id='demoRequest']") private WebElement options;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSignIn() {
		SeleniumWaits.waitForElementToVisibile(driver, signIn, 10).click();		
	}
	
	public void clickOnResidentLogin() {
		SeleniumWaits.waitForElementToVisibile(driver, residentLogin, 10).click();
	}
	
	public void enterEmail(String mail) {
		SeleniumWaits.waitForElementToVisibile(driver, email, 10).sendKeys(mail);
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickOnDemoButton() {
		SeleniumWaits.waitForElementToVisibile(driver, demoButton, 10).click();
	}
	
	public void enterFirstName(String fName) {
		SeleniumWaits.waitForElementToVisibile(driver, firstName, 5).sendKeys(fName);
	}
	
	public void enterLastName(String lName) {
		SeleniumWaits.waitForElementToVisibile(driver, lastName, 5).sendKeys(lName);
	}
	
	public void enterEmailId(String email) {
		SeleniumWaits.waitForElementToVisibile(driver, emailId, 5).sendKeys(email);
	}
	
	public void enterCompanyName(String company) {
		SeleniumWaits.waitForElementToVisibile(driver, companyName, 5).sendKeys(company);
	}
	
	public void enterPhoneNumber(String phone) {
		SeleniumWaits.waitForElementToVisibile(driver, phoneNumber, 5).sendKeys(phone);
	}
	
	public void selectUnits() {
		Select sel = new Select(SeleniumWaits.waitForElementToVisibile(driver, managedUnit, 5));
		sel.selectByValue("1 - 100");
	}
	
	public void enterJobTitle(String jobRole) {
		SeleniumWaits.waitForElementToVisibile(driver, jobTitle, 5).sendKeys(jobRole);
	}
	
	public void selectWhoYouAre() {
		Select sel = new Select(SeleniumWaits.waitForElementToVisibile(driver, options, 5));
		sel.selectByValue("a Resident");
	}

}
