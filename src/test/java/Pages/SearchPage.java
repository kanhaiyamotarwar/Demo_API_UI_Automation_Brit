package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.CommonMethods;


public class SearchPage extends CommonMethods{

	public WebDriver driver;
	
	public SearchPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	//List<WebElement> Search_Result=driver.findElements(By.xpath("//div[@class='s-results']/a"));
	
	@FindBy(xpath="//div[@class='s-results']/a")
	List<WebElement>  Search_Result;
	
	
	
	public List<String> validateSearchResult()
	{
		List<String> searchResultText= new ArrayList<String>();
		for(WebElement e:Search_Result)
		{
			searchResultText.add(e.getText());
			
		}
		
		return searchResultText;
	}
	
}
