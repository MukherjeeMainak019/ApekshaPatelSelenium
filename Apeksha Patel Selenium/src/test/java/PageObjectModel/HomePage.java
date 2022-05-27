package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	public static WebDriver driver;
	
public HomePage(WebDriver driver) {
		
	this.driver = driver;
	}
	
	
	By store_locator = By.xpath("(//span[contains (text(), 'Store Locator')])[1]");
	By search = By.id("header-search-input");
	By pharmacy = By.xpath("(//a[@href='https://www.rexall.ca/pharmacy/'])[3]");
	By health = By.xpath("(//a[@href='https://www.rexall.ca/everyday-health/'])[3]");

	
	public WebElement store_locator()
	{
	  return driver.findElement(store_locator);
		}
	
	public WebElement search()
	{
	  return driver.findElement(search);
		}
	
	public WebElement pharmacy()
	{
	  return driver.findElement(pharmacy);
		}
	
	public WebElement health()
	{
	  return driver.findElement(health);
		}
}

