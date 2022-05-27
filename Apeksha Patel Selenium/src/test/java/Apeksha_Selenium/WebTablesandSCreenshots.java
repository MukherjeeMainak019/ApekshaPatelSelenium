package Apeksha_Selenium;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTablesandSCreenshots {

	public static WebDriver driver;
	
	
	public static void screenshots() throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // driver took the screencapture
		
		File destination = new File("/Users/mainakmukherjee/Eclipse/Eclipse Workspace/Apeksha_Selenium/Screenshot/screenshot.png"); // created a local folder
		
		FileUtils.copyFile(source, destination);
	}
	
	
	
	public static void main(String[] args) throws IOException {
		
//WebTables
// HTML DOM value: <table><tbody><td><tr>
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.nanakflights.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		
		driver.findElement(By.id("DepDate")).click();
		
		screenshots();
		
		List<WebElement> days = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr/td"));
		
		for(WebElement ele: days)
		{
			System.out.println(ele.getText());
		}
	}

}
