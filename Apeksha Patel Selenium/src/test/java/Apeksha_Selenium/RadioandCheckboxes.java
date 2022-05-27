package Apeksha_Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioandCheckboxes {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.spicejet.com/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
	System.out.println(driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-zso239'])[2]")).isSelected());
	
	driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-zso239'])[2]")).click();
	
	Thread.sleep(3000);
	
	System.out.println(driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-zso239'])[2]")).isSelected());
	
	driver.quit();
	
		

	}

}
