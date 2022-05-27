package ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReporting {
	
	ExtentReports extent;
	ExtentTest test;
	
	// ExtentReports and ExtentSparkReporter
	
	@BeforeTest
	public void config()
	{
		String path = System.getProperty("user.dir")+"/report/report.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Apeksha Selenium");
		reporter.config().setDocumentTitle("Extent Report Learning");
		
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Apeksha");
		
		
	}

	@Test
	public void demo() throws InterruptedException
	{
		extent.createTest("demo");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);
		driver.quit();
		
		extent.flush();
	}
	
	@Test
	public void demo1() throws InterruptedException
	{
		test = extent.createTest("demo");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);
		driver.quit();
		test.fail("Failed test Case");
		
		extent.flush();
	}
}
