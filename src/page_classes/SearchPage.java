package page_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import org.openqa.selenium.*;

public class SearchPage {
	
	public static WebElement element = null;
	
	/**
	 * Returns the flight origin text box element
	 * @param wd
	 * @return
	 */
	public static WebElement originTextBox(WebDriver wd){
		element = wd.findElement(By.id("flight-origin-hp-flight"));
		return element;
	}	
	
	public static void fillOriginTextBox(WebDriver wd, String origin){
		element = originTextBox(wd);
		element.sendKeys(origin);
	}
		
	/**
	 * Returns the flight destination text box element
	 * @param wd
	 * @return	
	 */
	public static WebElement destinationTextBox (WebDriver wd){
			element = wd.findElement(By.id("flight-destination-hp-flight"));
			return element;
		}
	
	public static void fillDestinationTextBox (WebDriver wd, String Destination){
		   element = destinationTextBox(wd);
		   element.sendKeys(Destination);
	}
		
		/**
		 * Returns the departure date text box element
		 * @param wd
		 * @return	
		 */
	public static WebElement departureDateTextBox(WebDriver wd){
		   element = wd.findElement(By.id("flight-departing-hp-flight"));
		   return element;
	}
	
	public static void fillDepartureDate(WebDriver wd, String DepartureDate){
		element = departureDateTextBox(wd);
		element.sendKeys(DepartureDate);
	}

		/**
		 * Returns the return date text box element
		 * @param wd
		 * @return	
		 */
	public static WebElement returnDateTextBox(WebDriver wd){
		   element = wd.findElement(By.id("flight-returning-hp-flight"));
		   return element;
	}
	
	public static void fillReturnDate(WebDriver wd, String ReturnDate){
		   element = returnDateTextBox(wd);
		   element.sendKeys(ReturnDate);
	}

		/**
		 * Returns the search button box element
		 * @param wd
		 * @return	
		 */
	public static WebElement searchButton (WebDriver wd){
		element =wd.findElement(By.xpath("//form[@id='gcw-flights-form-hp-flight']//span[text()='Search']"));
		return element;
	}
	
	/**
	 * Click search button
	 * @param wd
	 */
	public static void clickSearchButton(WebDriver wd){
		element = searchButton(wd);
		element.click();
	}
	
	/**
	 * Navigate to flights tab
	 * @param wd
	 */
	
	public static void navigateToFlightsTab(WebDriver wd){
		wd.findElement(By.id("primary-header-home")).click();
		element = wd.findElement(By.id("tab-flight-tab-hp"));
		element.click();
	}
	
	/**
	 * Clicks Hotels tab
	 * @param wd
	 */
	
	public static void ClickHotelTab(WebDriver wd){
		element = wd.findElement(By.id("tab-hotel-tab-hp"));
		element.click();
	}
	/**
	 * Click Bundle Deals
	 * @param wd
	 */
	//primary-header-package
	public static void ClickBundleDeals(WebDriver wd){
		element = wd.findElement(By.id("primary-header-package"));
		element.click();
	}
}	