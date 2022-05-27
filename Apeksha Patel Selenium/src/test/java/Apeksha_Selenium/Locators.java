package Apeksha_Selenium;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
	
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.aircanada.com/us/en/aco/home.html");
		
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		WebElement flight_passes = driver.findElement(By.xpath("(//div[@class = 'abc-ripple-wrapper'])[8]"));
		
		WebElement search = driver.findElement(By.cssSelector("input[type='search']"));
		
		search.click();
		
		search.sendKeys("abc");
		
		String value = flight_passes.getText();
		
		System.out.println(value);
		
		flight_passes.click();
		
		
		

	}

}

//To locate UI elements in a webpage we need to use LOCATORS
//Type of locators - id, css, xpath, classname, linktext, partiallinktext
//CSS syntax = tagname[attribute = 'value']
//xpath syntax = //tagname[@attribute = 'value']