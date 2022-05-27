package Apeksha_Selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Parent_ChildWindow {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.goibibo.com/flights/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("(//p[contains (text(), 'Get up to 25% OFF')])[2]")).click();
		
		Set<String> window = driver.getWindowHandles(); // parent and child session ids are recorded
		
		Iterator<String> it = window.iterator();
		
		String parentwindow = it.next();
		
		String childwindow = it.next();
		
		driver.switchTo().window(childwindow);
		
		System.out.println(driver.findElement(By.xpath("//*[@id=\"top-content\"]/div/div[2]/section/div/table/tbody/tr[2]/td[2]")).getText());
		
		driver.switchTo().window(parentwindow);
		
		System.out.println(driver.findElement(By.xpath("(//p[contains (text(), 'Get up to 25% OFF')])[2]")).getText());
		
	}

}
