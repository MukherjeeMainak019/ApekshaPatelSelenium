package Apeksha_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		
//		driver.switchTo( ).alert( ).accept();
		
//		driver.switchTo( ).alert( ).dismiss();
		
//		driver.switchTo().alert().getText();
		
//		driver.switchTo().alert().sendKeys("Text");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/alerts");
		
		driver.manage().window().maximize();
		
		Thread.sleep(3000);

		
		driver.findElement(By.id("alertButton")).click();
		
		System.out.println(driver.switchTo().alert().getText());
		
		driver.switchTo( ).alert( ).accept();
		
		
	}

}
