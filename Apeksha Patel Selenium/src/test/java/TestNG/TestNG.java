package TestNG;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG {
	
	public static WebDriver driver;
	

	@BeforeSuite
	public void beforesuite()
	{
		System.out.println("i am before suite");
	}
	@BeforeClass
	public void beforecalss()
	{
		System.out.println("i am before class");
	}
	@BeforeTest()
	public void beforetest()
	{
		System.out.println("i am before test");
	}
	@BeforeMethod()
	public void beforemethod()
	{
		System.out.println("i am before method");
	}
	@Test (priority = -1)
	public void testpriority()
	{
		System.out.println("i am number -1");
	}
	
	@Test (priority = 1)
	public void testpriority1()
	{
		System.out.println("i am number 1");
	}
	@Test (dependsOnMethods = "testpriority1")
	public void helper()
	{
		System.out.println("i am helper");
	}
	@Test (enabled = true)
	public void include_exclude()
	{
		System.out.println("i am excluded");
	}
	
	@Test (dataProvider = "login")
	public void dataprovidermethod(String Email, String password)
	{
		System.out.println(Email);
		System.out.println(password);
		
		driver = new ChromeDriver();
		WebElement emailaddress = driver.findElement(By.id(""));
		WebElement enterpassword = driver.findElement(By.id(""));
		
		emailaddress.sendKeys(Email);
		enterpassword.sendKeys(password);
		
		
		
	}
	
	@DataProvider
	public Object[][] login()
	{
		Object data[][] = new Object[3][2];
		
//		1st data set
		data[0][0] = "positiveemailaddress";
		data[0][1] = "positivepassword";
		
//		2nd data set
		data[1][0] = "negetiveemailaddress";
		data[1][1] = "positivepassword";
		
//		3rd data set
		data[2][0] = "positiveemailaddress";
		data[2][1] = "negetivepassword";
		
		return data;
	}
}
