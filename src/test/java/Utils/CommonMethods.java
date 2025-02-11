package Utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {

	WebDriver driver;
	
	public CommonMethods(WebDriver driver) {
		this.driver=driver;
	}

	
	public void waitforElement(WebElement locator)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(locator));
	}
	
	public static void WaitMethod() throws InterruptedException
	{
		Thread.sleep(7000);
	}
}
