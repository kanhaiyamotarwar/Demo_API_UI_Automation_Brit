package Utils;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

FrameworkUtils util;
     public WebDriver driver;
     

    
	 public WebDriver initilizeDriver() throws IOException
	{
		util =new FrameworkUtils();
		String BroeserName=util.readpropertiesfile("browser");
		if(BroeserName.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
		}
		if(BroeserName.equalsIgnoreCase("FireFox"))
		{
			driver=new FirefoxDriver();
		}
		if(BroeserName.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		driver.get(util.readpropertiesfile("url"));
		return driver;
	}
	
	
	
}
