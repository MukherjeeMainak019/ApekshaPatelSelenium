package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RefillPage {
public static WebDriver driver;
	
	public RefillPage(WebDriver driver) {
			
		this.driver = driver;
		}
	
	By prescription_refill = By.xpath("//h1[contains (text(),'Prescription Refill')]");

	
	public WebElement prescription_refill()
	{
	  return driver.findElement(prescription_refill);
		}
}
