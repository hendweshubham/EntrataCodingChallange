package com.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.SeleniumWaits;

public class ProductPage {
	
	private WebDriver driver;
	public Actions act;
	public static final Logger log = LogManager.getLogger(ProductPage.class);
	
	@FindBy(xpath="//*[text()='Products']") private WebElement productMenu;
	@FindBy(xpath="//*[@class='dropdown_link-heading' and text()='Bill Pay']") private WebElement billPay;
	@FindBy(xpath="(//*[@class='button_text' and text()='Watch a demo'])[1]") private WebElement demoButton;
	@FindBy(xpath="//*[@id='wistia_102.big_play_button_graphic']") private WebElement videoButton;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnBillPay() {
		act = new Actions(driver);
		act.moveToElement(SeleniumWaits.waitForElementToVisibile(driver, productMenu, 10)).build().perform();
		SeleniumWaits.waitForElementToClick(driver, billPay, 10).click();		
	}
	
	public void clickOnDemo() {
		SeleniumWaits.waitForElementToClick(driver, demoButton, 10).click();
	}
	
	public void clickOnPlayButton() {
		SeleniumWaits.waitForElementToVisibile(driver, videoButton, 10).click();
	}

}
