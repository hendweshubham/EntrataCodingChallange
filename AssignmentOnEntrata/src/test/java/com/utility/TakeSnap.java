package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeSnap {
	
	private static final Logger log = LogManager.getLogger(TakeSnap.class);

	public static void takeScreenshot(WebDriver driver, String testname) {
		try {
			Date d = new Date();
			String replaceDate = d.toString();
			String timestamp = replaceDate.replace(":", ";");
		
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest = new File(System.getProperty("user.dir")+"//src//test//resources//screenshots "+testname+" "+timestamp+".jpg");
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			log.error("Failed to take screenshot", e);
		}
	}
}
