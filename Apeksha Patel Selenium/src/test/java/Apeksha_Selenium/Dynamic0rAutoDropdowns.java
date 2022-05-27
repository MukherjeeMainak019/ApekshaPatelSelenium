package Apeksha_Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dynamic0rAutoDropdowns {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.goibibo.com/flights/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//p[@class='sc-iJKOTD iipKRx fswWidgetPlaceholder'])[1]")).click();
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Delhi");
		
		List<WebElement> elements = driver.findElements(By.xpath("//ul[@id='autoSuggest-list']//li"));
		
		
		for(WebElement ele :elements)
		{
			String expected = "Jaipur";
			String actual = ele.getText();
			if(actual.contains(expected))
			{
				ele.click();
			}
		}
	}
}
