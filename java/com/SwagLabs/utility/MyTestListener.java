package com.SwagLabs.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.SwagLabs.Base.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyTestListener implements ITestListener {

	private static ExtentReports extent = ExtentManager.getReport();
	// Using ThreadLocal to support parallel execution
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

//	@Override
//	public void onTestStart(ITestResult result) {
//	    ExtentTest extentTest =
//	        extent.createTest(result.getMethod().getMethodName());
//
//	    test.set(extentTest);
//
//	    test.get().info("Test Started: " + result.getMethod().getMethodName());
//	}

	@Override
	public void onTestStart(ITestResult result) {

		String testName = result.getMethod().getMethodName();


		ExtentTest extentTest = extent.createTest(testName);
		test.set(extentTest);

		test.get().info("Test Started: " + testName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.get().log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());

		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.get().log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());

		test.get().log(Status.FAIL, result.getThrowable());

		// 🔥 Screenshot logic
		Object testClass = result.getInstance();
		BaseClass base = (BaseClass) testClass;

		String screenshotPath = base.captureScreenshot(result.getMethod().getMethodName());

		try {
			test.get().addScreenCaptureFromPath(screenshotPath);
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.get().log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}