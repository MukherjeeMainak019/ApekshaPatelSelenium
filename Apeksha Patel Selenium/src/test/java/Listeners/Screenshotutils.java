package Listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshotutils extends BaseClass{
	
	public static WebDriver driver;
	

	public static  String takescreenshot(WebDriver driver, String testcasename) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String screenshotfilepath = "/Users/mainakmukherjee/Eclipse/Eclipse Workspace/Apeksha_Selenium/Screenshot/" +testcasename+ ".png";
		
		File dest = new File(screenshotfilepath);
		
		FileUtils.copyFile(src, dest);
		
		return screenshotfilepath; 
		
		
		
	}
	

}
