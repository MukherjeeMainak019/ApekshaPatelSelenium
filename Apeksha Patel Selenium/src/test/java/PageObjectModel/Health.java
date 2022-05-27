package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Health {

	public static WebDriver driver;
	
	public Health(WebDriver driver) {
			
		this.driver = driver;
		}
	
	
	@FindBy(xpath="//h1[contains (text(), 'Everyday Health')]") 
	public WebElement everyday_health;
}
