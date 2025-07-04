package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.ProductPage;
import com.utility.SeleniumWaits;
import com.utility.TakeSnap;

public class ProductPageTest extends BaseClass{
	
	private static ProductPage prod;

	@Test
	public void navigateToBillPayTest() {
		log.info("Navigating to BillPay Screen....!");
		test = extent.createTest("BillPay Navigation Test");
		
		prod = new ProductPage(driver);
		
		prod.clickOnBillPay();
		log.info("Clicked on BillPay....!");
		
		SeleniumWaits.waitForThePageLoad(driver, 10);
		
		prod.clickOnPlayButton();
		log.info("Clicked on Video Play Button....!");
		
		//waiting for the video to play for few seconds
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		TakeSnap.takeScreenshot(driver, "BillPayTest");
		
		log.info("Navigated on " + driver.getTitle() + "....!");
		Assert.assertTrue(driver.getTitle().contains("Bill Pay"), "Title should have 'Bill Pay'");
	}
	
}
