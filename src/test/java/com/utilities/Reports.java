package com.utilities;

import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;




public class Reports extends TestListenerAdapter  {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
     public void onStart(ITestContext context) {
    	 
		htmlReporter = new ExtentHtmlReporter("extent-report.html");
		//htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		htmlReporter.config().setDocumentTitle("HybridFramework Project");
		htmlReporter.config().setReportName("Automation Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Local");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Browser", "Firefox");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester", "Arif");

}
    public void onTestSuccess(ITestResult result) {
    	test = extent.createTest(result.getName());
    	test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		
		
	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
    	test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		
    	String screenshotpath = System.getProperty("user.dir")+"/Screenshots/"+result.getName()+".png";
    	
    	File file = new File(screenshotpath);
    	if(file.exists()) {
    	try {
			test.fail("Screenshot is below :"+test.addScreenCaptureFromPath(screenshotpath));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	}
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
    	test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
		
	}


	public void onFinish(ITestContext context) {
		extent.flush();
		
	}


	
	

}
