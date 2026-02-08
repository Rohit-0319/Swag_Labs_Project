package com.SwagLabs.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	protected static ExtentReports extent;

	public static ExtentReports getReport() {
		if (extent == null) {
			
			 // 1. Configure the Report (UI)
			ExtentSparkReporter reporter = new ExtentSparkReporter(
					System.getProperty("user.dir") + "/reports/ExtentReport.html");
			reporter.config().setDocumentTitle("Test Execution Report");
			reporter.config().setReportName("Functional Testing");
			reporter.config().setTheme(Theme.DARK);
			
			  // 2. Attach Reporter to ExtentReports
			extent = new ExtentReports();
			extent.attachReporter(reporter);

			// 3. Add System Info
			extent.setSystemInfo("Computer Name", "localhost");
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("Tester Name", "Rohit");
			extent.setSystemInfo("OS", "Windows 11");
			extent.setSystemInfo("Browser", "Chrome");

		}
		return extent;
	}

}
