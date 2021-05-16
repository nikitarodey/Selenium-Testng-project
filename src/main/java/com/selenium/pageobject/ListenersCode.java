package com.selenium.pageobject;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersCode implements ITestListener {

	public void onTestSuccess(ITestResult result) {

		System.out.println("Test Case Passed : " + result.getMethod());
		
        
		try {
			BlazeDemo.takeScreenshot(result, "passed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public void onTestFailure(ITestResult result) {

		System.out.println("Test Case Failed : " + result.getMethod());

		try {
			BlazeDemo.takeScreenshot(result, "failed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {

		System.out.println("Test Case Skipped : " + result.getMethod().getDescription());
	}

}
