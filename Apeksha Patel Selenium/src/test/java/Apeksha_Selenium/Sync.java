package Apeksha_Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sync {

	public static void main(String[] args) {
		
		
//		We implement wait techniques to bring the WebElements and Selenium in sync
		
//		Implicit wait
		
//		Syntax:
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		
		
//		Explicit Wait
		
		WebElement element = driver.findElement(By.xpath("//select[@name = 'country']"));
		
		WebDriverWait expwait = new WebDriverWait(driver, Duration.ofMillis(10000));
	
		expwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name = 'country']")));
		
		expwait.until(ExpectedConditions.visibilityOf(element));
		
//		Fluent Wait
		
		Wait<WebDriver> fluwait = new FluentWait<WebDriver>(driver).pollingEvery(Duration.ofSeconds(2)).withTimeout(Duration.ofSeconds(10));
		
		

	}

}
