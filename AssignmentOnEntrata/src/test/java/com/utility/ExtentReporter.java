package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	private static ExtentReports extent;
	
	public static ExtentReports getExtentReports() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Entrata Assignment Report");
            spark.config().setReportName("Entrata Assignment Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }

}
