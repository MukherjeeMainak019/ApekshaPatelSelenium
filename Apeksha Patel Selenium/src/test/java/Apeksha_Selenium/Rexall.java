package Apeksha_Selenium;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rexall {
	
	public static WebDriver driver;
	
	@Test //annotation
	public void actions_keydown() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.rexall.ca/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(5000));
		driver.manage().window().maximize();
		Actions actions = new Actions(driver);
		WebElement search = driver.findElement(By.id("header-search-input"));
		search.click();
		actions.moveToElement(search).keyDown(Keys.SHIFT).sendKeys("covid").build().perform();
		screencapture(driver, "actions_keydown");
		driver.close();
	}
	
	@Test
	public void actions_contextclick() throws IOException
	{
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.rexall.ca/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(5000));
		driver.manage().window().maximize();
		Actions actions = new Actions(driver);
		WebElement search = driver.findElement(By.id("header-search-input"));
		search.click();
		actions.moveToElement(search).keyDown(Keys.SHIFT).sendKeys("covid").build().perform();	
		actions.moveToElement(search).contextClick(search).build().perform();
		screencapture(driver, "actions_contextclick");
		driver.close();
		
	}
		
	@Test
	public void Frames() throws IOException
	{
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(5000));
		driver.manage().window().maximize();
		
		Actions actions = new Actions(driver);
		
		WebElement frames = driver.findElement(By.xpath("//iframe[@class = 'demo-frame']")); // find the frames
		driver.switchTo().frame(frames); // get inside the frame
		
		WebElement drop = driver.findElement(By.id("droppable")); //get locators form inside the frames after switching to after
		WebElement drag = driver.findElement(By.id("draggable")); //get locators form inside the frames after switching to after
		
		actions.moveToElement(drag).dragAndDrop(drag, drop).build().perform(); // perform task on frames
		driver.switchTo().defaultContent(); // getoutside of frame
		
		WebElement text = driver.findElement(By.xpath("//a[@href = 'http://jqueryui.com/draggable/']"));
		System.out.println(text.getText());
		
		
	}
	
		
//		WebElement pharmacy= driver.findElement(By.xpath("(//a[@href='https://www.rexall.ca/pharmacy/'])[3]"));
//		actions.moveToElement(pharmacy).build().perform();
//		
//		WebElement refill_prescription = driver.findElement(By.xpath("(//a[contains (text(), 'Refill Prescriptions')])[2]"));
//		System.out.println(refill_prescription.getText());
//		refill_prescription.click();
//		
//		
//		WebElement Option1 = driver.findElement(By.xpath("//span[contains (text(), 'Refill Prescription using')]"));
//		System.out.println(Option1.getText());
//		
//		driver.findElement(By.xpath("//a[@class='tp-main-link']")).click();
		
		
	
	public static void screencapture(WebDriver driver, String testcasename) throws IOException
	{
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // selenium ne screenshot liye
		
		File dest = new File("/Users/mainakmukherjee/Eclipse/Eclipse Workspace/Apeksha_Selenium/Screenshot/" + testcasename+ ".png");
		
		FileUtils.copyFile(src, dest);
		
	}

}
