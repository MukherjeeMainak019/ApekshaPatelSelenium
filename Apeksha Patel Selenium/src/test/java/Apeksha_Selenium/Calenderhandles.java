package Apeksha_Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calenderhandles {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.nanakflights.com/");
		driver.manage().window().maximize();
		
		
		String expected_year = "2023";
		String expected_month = "March";
		String expected_date = "15";
		
		WebElement Depdate = driver.findElement(By.id("DepDate"));
		Depdate.click();
		
//		String actual_year = driver.findElement(By.xpath("(//span[@class='ui-datepicker-year'])[1]")).getText();
//		WebElement next = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));
		
//		YEAR
		while(true)
		{
			String actual_year = driver.findElement(By.xpath("(//span[@class='ui-datepicker-year'])[1]")).getText();
			
			if(actual_year.equals(expected_year))
			{
				break;
			}
			else
			{
				WebElement next = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));
				next.click();
			}
		}
		
//		MONTH
		while(true)
		{
			String actual_month = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]")).getText();
			
			if(actual_month.equals(expected_month))
			{
				break;
			}
			else
			{
				WebElement next = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));
				next.click();
			}
		}
//		DATES
		
		List<WebElement> date_value = driver.findElements(By.xpath("(//table[@class='ui-datepicker-calendar'])[1]//tbody//tr//td"));

		for(WebElement ele:date_value)
		{
			String actual_date = ele.getText();
			if(actual_date.equals(expected_date))
			{
				ele.click();
				break;
			}
		}
	}

}
