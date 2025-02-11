package StepDefinations;



import java.io.IOException;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;

import Pages.LandingPage;
import Pages.SearchPage;
import Utils.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Search_Function extends BaseClass{
	
	public WebDriver driver;
	LandingPage LandingPage;

	@Given("User is on home page")
	public void user_is_on_home_page() throws IOException {
		
		driver=initilizeDriver();
		
	
	}

	@Given("Search for keyword {string}")
	public void search_for_keyword(String Search_string) throws InterruptedException {
		LandingPage LandingPage= new LandingPage(driver);
		//LandingPage.clickOnSearchIcon();
		LandingPage.EnterDataToSearchWebElement(Search_string);
	}
	

	@Then("Verify result contains text")
	public void verify_result_contains_text_result(List<String> Data) {
		
		SearchPage SearchPage= new SearchPage(driver);
		List<String> SearchResult=SearchPage.validateSearchResult();	
		Data.equals(SearchResult);	
		assertTrue(Data.equals(SearchResult), "Expected and actual search result are different");
	   		
		
	}
	
	@Then("Verify search suggestions")
	public void verify_search_result_suggestions(List<String> SuggestionData) {
		
		LandingPage LandingPage= new LandingPage(driver);
		List<String> SearchSuggestions=LandingPage.validateSearcSuggestions();		
		SuggestionData.equals(SearchSuggestions);
		assertTrue(SuggestionData.equals(SearchSuggestions), "Expected and actual search suggestions are different");
	   		
		
	}
	
	@Then("Click on search icon of landing page")
	public void ClickOn_Search_Icon() throws InterruptedException {
		
		LandingPage LandingPage= new LandingPage(driver);
		LandingPage.clickOnSearchIcon();
		
	}
	
	@Then("Close browser")
	public void Close_browser() throws InterruptedException {
		
		driver.close();
		
	}
	
	
	

}
