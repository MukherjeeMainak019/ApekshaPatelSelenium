package Apeksha_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectClass {

	public static void main(String[] args) throws InterruptedException {
	
		//select[@name = 'country']
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		
		driver.manage().window().maximize();
	
		WebElement element = driver.findElement(By.xpath("//select[@name = 'country']"));
		
		//Select Class = static dropdown
		
		Select select = new Select(element);
		
		select.selectByIndex(6);
		Thread.sleep(2000);
		
		select.selectByValue("ITALY");
		Thread.sleep(2000);
		
		select.selectByVisibleText("VIETNAM");
		Thread.sleep(2000);
		
		driver.quit();
	}

}
