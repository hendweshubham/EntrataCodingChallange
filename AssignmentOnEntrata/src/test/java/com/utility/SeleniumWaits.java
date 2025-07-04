package com.utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaits {
	private static WebDriverWait wait;
		
    //Wait for the entire page to load completely
    public static void waitForThePageLoad(WebDriver driver, int timeout) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout))
        .until(webDriver -> ((JavascriptExecutor) webDriver)
        .executeScript("return document.readyState").equals("complete"));
    }

    //Wait for the presence of an element
//    public static WebElement waitForPresenceOfElement(WebDriver driver, By locator, int seconds) {
//        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
//        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//    }
    
    //Wait for the visibility of an element
    public static WebElement waitForElementToVisibile(WebDriver driver, WebElement locator, int seconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOf(locator));
    }

 // Wait for the element to be clickable
    public static WebElement waitForElementToClick(WebDriver driver, WebElement locator, int seconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}
