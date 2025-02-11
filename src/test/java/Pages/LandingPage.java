package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.CommonMethods;



public class LandingPage extends CommonMethods{

	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	//WebElement Button_search_icon=driver.findElement(By.xpath("//button[@aria-label='Search button']"));
	//WebElement TextArea_Search_Field=driver.findElement(By.xpath("//input[@name='k']"));
	
	@FindBy(xpath="//button[@aria-label='Search button']")
	WebElement Button_search_icon;
	
	@FindBy(xpath="//input[@name='k']")
	WebElement TextArea_Search_Field;
	
	@FindBy(xpath="//div[@class='result']/a")
	List<WebElement>  SearchBoxSuggestions;
	
	
	
	
	public void clickOnSearchIcon() throws InterruptedException
	{
		WaitMethod();
		Button_search_icon.click();
	}
	
	public void EnterDataToSearchWebElement(String data)
	{
		TextArea_Search_Field.sendKeys(data);
	}
	
	public List<String> validateSearcSuggestions()
	{
		List<String> searchSuggestions= new ArrayList<String>();
		for(WebElement e:SearchBoxSuggestions)
		{
			searchSuggestions.add(e.getText());
			
		}
		
		return searchSuggestions;
	}
}
