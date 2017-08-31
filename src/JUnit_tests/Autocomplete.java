package JUnit_tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Autocomplete {
	WebDriver wd;
	String baseURL1;
	String baseURL2;
	String baseURL3;

	// @test1
	// String for "matching result" //String for search text
	String searchText = "New York/Newark, NJ - EWR";
	String patrtialText = "New York";

	// @test2
	// String for "matching result" //String for search text
	String expectedMatch = "Orlando(MCO), Orlando Intl [Florida], US";
	String SearchText = "Orl";

	// @test3
	// String for "matching result" //String for search text
	String searchText1 = "Milano, Italy - Milano Malpensa [MXP]";
	String searchText2 = "Mil";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");

		wd = new FirefoxDriver();
		baseURL1 = "https://www.southwest.com/";
		baseURL2 = "https://www.cheapflightsfares.com/";
		baseURL3 = "http://www.flighthub.com/";

		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void test1() throws InterruptedException {
		wd.get(baseURL1);

		// Create Webelement for the textbox + send keys
		WebElement text = wd.findElement(By.id("air-city-departure"));
		text.sendKeys(patrtialText);

		// Create list-webelement for search results
		WebElement element = wd.findElement(By.id("air-city-departure-menu"));

		// Catch=save all elements with tag "li" from the search results (line
		// above)
		List<WebElement> results = element.findElements(By.tagName("li"));

		// Get the size of elements
		int size = results.size();

		// Print out the size of the list
		System.out.println("The size of the list is: " + size);

		// Loop: Get the text of results and print those out
		for (int i = 0; i < size; i++) {
			System.out.println(results.get(i).getText());
		}

		Thread.sleep(3000);
		// Create new webelement to check if there is expected result in the
		// list
		for (WebElement result : results) {

			// See if results are matching, click result if there is matching
			// one, print out "matching result clicked"
			if (result.getText().equals(searchText)) {
				result.click();
				System.out.println("Matching result clicked");
			}
		}

	}

	@Test
	public void test2() throws InterruptedException {
		wd.get(baseURL2);

		// Create Webelement for the textbox + send keys
		WebElement origin = wd.findElement(By.id("froCity"));
		origin.sendKeys(SearchText);

		// Create list-webelement for search results
		WebElement sResList = wd.findElement(By.id("ui-id-1"));

		// In list of webelements, Catch=save all elements with tag "li" from
		// the search results (line above)
		List<WebElement> searchResults = sResList.findElements(By.className("ui-menu-item"));

		// INT: Get the size of elements
		int size = searchResults.size();

		// Print out the size of the list
		System.out.println(size + " Search results found");

		// Loop: Get the text of results and print those out
		for (int i = 0; i < size; i++) {
			System.out.println("Search options found: " + searchResults.get(i).getText());
		}

		Thread.sleep(3000);

		// Create new webelement to check if there is expected result in the
		// list
		for (WebElement match : searchResults) {
			// Loop: See if results are matching, click result if there is
			// matching one
			if (match.getText().equals(expectedMatch)) {
				match.click();

				// Print out "matching result clicked"
				System.out.println("Matching result found and clicked");
			}
		}
	}

	@Test
	public void test3() throws InterruptedException {

		wd.get(baseURL3);
		//WebElement for one way button
		WebElement flights = wd.findElement(By.id("radio-2")); //div[@class='us-trip-box'][position()=2]"));
		flights.click();
		
		Thread.sleep(2000);
		
		// Create Webelement for the textbox + send keys
		WebElement searchField = wd.findElement(By.cssSelector("div.hp-search-city-full:nth-child(1) > div:nth-child(2) > input:nth-child(2)")); //label[contains(text(), 'Departure Airport')]//following-sibling::input[@rel='1']")); 
		searchField.clear();
		searchField.sendKeys(searchText2);

		Thread.sleep(2000);

		// Create list-webelement for search results //results
		WebElement result1 = wd.findElement(By.id("ui-id-1"));

		// In list of webelements, Catch=save all elements with tag "li" from
		// the search results (line above)
		List<WebElement> result2 = result1.findElements(By.tagName("li"));

		// INT: Get the size of elements
		int size = result2.size();

		// Print out the size of the list
		System.out.println(size + "Results found in search");

		// Loop: Get the text of results and print those out
		for (int i = 0; i < size; i++) {
			System.out.println("Search options found: " + result2.get(i).getText());
		}
		Thread.sleep(2000);
		
		// Create new webelement to check if there is expected result in the list
		for (WebElement matchingResult : result2) {
			// Loop: See if results are matching, click result if there is
			// matching one
			if (matchingResult.getText().equals(searchText1)) {
				matchingResult.click();
				// Print out "matching result clicked"
				System.out.println("Matching result clicked: " + matchingResult);
			}

		}
	}

	@After

	public void tearDown() throws Exception {
		Thread.sleep(2000);
		wd.quit();
	}

}
