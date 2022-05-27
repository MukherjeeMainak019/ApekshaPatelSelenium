package Listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listener extends BaseClass implements ITestListener{

	String testcasename = null;
	
	ExtentReports extent = ExtentReportsutils.reportobject();
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		
		testcasename = result.getMethod().getMethodName();
		
		System.out.println(testcasename + " execution has started");
		
		test = extent.createTest(testcasename);
		
		
		
	}

	public void onTestSuccess(ITestResult result) {
		
		testcasename = result.getMethod().getMethodName();
		
		System.out.println(testcasename + " execution is successful");
		
		try 
		{
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} 
		catch (Exception e) {
		}
		
		try 
		{
			Screenshotutils.takescreenshot(driver, testcasename);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		try 
		{
			test.addScreenCaptureFromPath(Screenshotutils.takescreenshot(driver, testcasename), testcasename);
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
		test.log(Status.PASS, testcasename);
		
	}

	public void onTestFailure(ITestResult result) {
		
		testcasename = result.getMethod().getMethodName();
		
		System.out.println(testcasename + " execution has failed");
		
		try 
		{
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} 
		catch (Exception e) {
		}
		
		try 
		{
			Screenshotutils.takescreenshot(driver, testcasename);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		try 
		{
			test.addScreenCaptureFromPath(Screenshotutils.takescreenshot(driver, testcasename), testcasename);
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
//		test.log(Status.FAIL, result.getThrowable());
		
		test.fail(result.getThrowable());
		
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
	
	}

	public void onFinish(ITestContext context) {
		
		extent.flush();
		
	}

}
