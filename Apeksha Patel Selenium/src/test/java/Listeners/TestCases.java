package Listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases extends BaseClass{
	
	public static WebDriver driver;
		
	@BeforeTest()
	public void launchURL()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@AfterTest()
	public void teardown()
	{
		driver.quit();
	}
	
	@Test
	public void demo() throws InterruptedException
	{
		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);
		Assert.assertTrue(true);
		
	}
	
	@Test
	public void demo1() throws InterruptedException
	{
		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);
		String expected = driver.findElement(By.id("glow-ingress-line1")).getText();
		String actual = "Hell";
		Assert.assertEquals(actual, expected);
		
		
	}
	
	

}
