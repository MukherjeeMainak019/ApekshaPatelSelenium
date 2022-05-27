package TestNGRunner;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjectModel.Health;
import PageObjectModel.HomePage;
import PageObjectModel.PharmacyPage;
import PageObjectModel.RefillPage;
import Utilily.Screenshot_utils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Runner extends Screenshot_utils{
	
	public static WebDriver driver;
	
	
	static HomePage homepage;
	static PharmacyPage pharmacypage;
	static RefillPage refillpage;
	static Health health;
	
	static String expected_pharmacy_url ="https://www.rexall.ca/pharmacy";
	static String exptected_prescription_refill_text = "Prescription Refill";
	static String expected_health_page_text = "Everyday Healt";
	
	@BeforeTest
	public void browser_launch()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.rexall.ca/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(5000));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
	
@Test
	public static void BPV2_1000_001() throws IOException
	{
		
		homepage = new HomePage(driver);
		homepage.search().sendKeys("covid");
		screencapture(driver, "search");
	}
@Test
public static void BPV2_1000_002()
{
	homepage = new HomePage(driver);
	homepage.pharmacy().click();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(30000));
	String actual_pharmacy_url = driver.getCurrentUrl();
	AssertJUnit.assertEquals(actual_pharmacy_url, expected_pharmacy_url);
	
}
@Test
public static void BPV2_1000_003()
{
	homepage = new HomePage(driver);
	homepage.pharmacy().click();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(30000));
	pharmacypage = new PharmacyPage(driver);
	pharmacypage.refill_prescription().click();
	refillpage = new RefillPage(driver);
	String actual_prescription_refill_text= refillpage.prescription_refill().getText();
	AssertJUnit.assertEquals(actual_prescription_refill_text, exptected_prescription_refill_text);
}
@Test
public static void BPV2_1000_004() throws IOException
{
	homepage = new HomePage(driver);
	homepage.health().click();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(30000));
	health = new Health(driver);
	PageFactory.initElements(driver, health);//extra line add karna hai, when using Page Factory
	String actual_health_page_text= health.everyday_health.getText();
	screencapture(driver, "everyday_health");
	AssertJUnit.assertEquals(actual_health_page_text, expected_health_page_text);
	}
}

