package com.woovin.listenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.woovin.generic.webdriverutility.UtilityClassObject;


public class ListImpClass implements ITestListener, ISuiteListener {
	public ExtentReports report;
	public ExtentSparkReporter spark;
	public static ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report configuration");
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		// spark report Config
		spark = new ExtentSparkReporter("./AdvancedReport/report_"+time+".html");
		spark.config().setDocumentTitle("Woovin Test Suite Results");
		spark.config().setReportName("Woovin Report");
		spark.config().setTheme(Theme.DARK);
		// add env info
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "windows-11");
		report.setSystemInfo("BROWSER", "CHROME-115");
	}
	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(
	            result.getMethod().getMethodName());

	    UtilityClassObject.setTest(test);

	    System.out.println("ExtentTest initialized: "
	            + (UtilityClassObject.getTest() != null));

	    UtilityClassObject.getTest().log(
	            Status.INFO,
	            result.getMethod().getMethodName() + " STARTED");
	    System.out.println("LISTENER STARTED: "
	            + result.getMethod().getMethodName());
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("========" + result.getMethod().getMethodName() + "===END====");
		UtilityClassObject.getTest().log(Status.PASS, result.getMethod().getMethodName() + "===COMPLETED====");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
	    TakesScreenshot ts =(TakesScreenshot) UtilityClassObject.getDriver();
	    String base64Screenshot =ts.getScreenshotAs(OutputType.BASE64);
	    UtilityClassObject.getTest().addScreenCaptureFromBase64String(base64Screenshot, testName);
	    UtilityClassObject.getTest().log(Status.FAIL,testName + " FAILED: " + result.getThrowable());
	    UtilityClassObject.getTest().log(Status.PASS, result.getMethod().getMethodName() + "Screenshot attached to Base64 report");
	}
	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		report.flush();
	}

}


