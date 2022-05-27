package Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsutils extends BaseClass{
	
	public static ExtentReports extent;
	
	public static ExtentReports reportobject()
	{
		String path = System.getProperty("user.dir")+"/report/report.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Apeksha Selenium");
		reporter.config().setDocumentTitle("Extent Report Learning");
		
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Apeksha");
		return extent;
		

}
}
