package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PharmacyPage {
	public static WebDriver driver;
	
	public PharmacyPage(WebDriver driver) {
			
		this.driver = driver;
		}
	
	By refill_prescription = By.xpath("(//a[@href='https://www.rexall.ca/refill/'])[3]");
	
	
	public WebElement refill_prescription()
	{
	  return driver.findElement(refill_prescription);
		}

}
