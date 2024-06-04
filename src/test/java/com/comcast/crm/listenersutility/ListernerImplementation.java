package com.comcast.crm.listenersutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.generic.baseUtility.BaseClass;

import comcastCrm.generic.fileUtility.UtilityClassObject;

public class ListernerImplementation
 implements ITestListener,ISuiteListener {
	
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public  ExtentTest test;
	

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		String Time=new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdavnceReport/reports_"+Time+".html");
		spark.config().setDocumentTitle("Crm test suite results");
		spark.config().setReportName("crm report");
		spark.config().setTheme(Theme.DARK);
		
		//add env information and create test
		 report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Window-10");
		report.setSystemInfo("BROWSER","CHROME-100");
		System.out.println("Report Configuration");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		report.flush();
		System.out.println("Report backUp");
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("=======>"+result.getMethod().getMethodName()+">======start=======");
	 test=  report.createTest(result.getMethod().getMethodName());
	  UtilityClassObject.setTest(test);
	 //test=UtilityClassObject.setTest(test);
	 UtilityClassObject.getTest().log(Status.INFO,result.getMethod().getMethodName()+"===>STARTED====<");

	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("=======>"+result.getMethod().getMethodName()+">======end=======");
		UtilityClassObject.getTest().log(Status.PASS,result.getMethod().getMethodName()+"===>COMPLETED====<");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	String testName=result.getMethod().getMethodName();
	TakesScreenshot ts=(TakesScreenshot)UtilityClassObject.getDriver();
	String filePath=ts.getScreenshotAs(OutputType.BASE64);
	String Time=new Date().toString().replace(" ", "_").replace(":", "_");

	UtilityClassObject.getTest().addScreenCaptureFromBase64String(filePath,testName+"_"+Time);
	UtilityClassObject.getTest().log(Status.FAIL,result.getMethod().getMethodName()+"===>FAILED====<");
	
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	

}
