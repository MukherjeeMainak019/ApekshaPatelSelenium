package Utilily;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot_utils {
	
	public static WebDriver driver;
	
	public static void screencapture(WebDriver driver, String testcasename) throws IOException
	{
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // selenium ne screenshot liye
		
		File dest = new File("/Users/mainakmukherjee/Eclipse/Eclipse Workspace/Apeksha_Selenium/Screenshot/" + testcasename+ ".png");
		
		FileUtils.copyFile(src, dest);
		
	}

}
