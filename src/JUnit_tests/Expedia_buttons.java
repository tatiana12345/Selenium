package JUnit_tests;

import java.util.concurrent.TimeUnit;

//import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Expedia_buttons {
	
	WebDriver wd;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		//Firefox driver should be set in method
				System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");
				
				wd = new FirefoxDriver();
				wd.manage().window().maximize();
				wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				baseURL = "https://www.expedia.com/";
	}
	@Test
	public void test1() {
		wd.get(baseURL);
		//assign values to WebElements
		WebElement flights = wd.findElement(By.id("tab-flight-tab-hp")); //(By.xpath("//input[@id="fh-fh-hp-package"])
		WebElement OneWay = wd.findElement(By.id("flight-type-one-way-label-hp-flight")); 
		
		//Click Flights and get title of the button
		flights.click();
		String flights_title = flights.getText();
		
		//Check if element is enabled, if yes - print out "is enabled"
	if (flights.isEnabled() == true){
		System.out.println(flights_title + " - Flights tab Is enabled " + flights.isEnabled());
	}
	else{
		System.out.println(flights_title + " - Flights tab Is disabled " + flights.isDisplayed());
	}
	
	//There is no " is selected" indicator in the code
	
//	//Check if element is enabled, if yes - print out "is selected"
//    if (flights.isSelected() == true){
//	System.out.println(flights_title + " - Flights tab Is selected " + flights.isSelected());
//    }
//    else{
//	System.out.println(flights_title + " - Flights tab Is selected " + flights.isSelected());
//    }

    
	//Click OneWay and get title of the button
		OneWay.click();
		String OneWayTitle = OneWay.getText();
		
		//Check if element is enabled, if yes - print out "is enabled"
		if (OneWay.isEnabled()==true){
			System.out.println(OneWayTitle + " element is enabled " + OneWay.isEnabled());	
		}
		else{
			System.out.println(OneWayTitle + " element is disabled " + flights.isDisplayed());
		}
		//There is no " is selected" indicator in the code
		
//		//Check if element is enabled, if yes - print out "is selected"
//	    if (OneWay.isSelected() == true){
//		System.out.println(flights_title + " - OneWay tab Is selected " + OneWay.isSelected());
//	    }
//	    else{
//		System.out.println(flights_title + " - OneWay tab Is selected " + OneWay.isSelected());
//	    }
	}
	
	
	@Test
	public void test2() {
		//assign values to WebElements
		wd.get(baseURL);
		WebElement BundleDeals = wd.findElement(By.id("tab-package-tab-hp"));
		WebElement FlightHotel = wd.findElement(By.xpath("//span[text()='Flight + Hotel']"));
	
		//Click Bundle deals and get the button title
		BundleDeals.click();
		String BundleDeals_title = BundleDeals.getText();
		
		//Verify if element is enabled, print out the result
		if (BundleDeals.isEnabled() == true){
			System.out.println(BundleDeals_title + " Element Is Enabled " + BundleDeals.isEnabled());
		}
		else{
			System.out.println(BundleDeals_title + " Element Is not Enabled " + BundleDeals.isDisplayed());
		}
		
		//Click Flight Hotels and get the button title
		FlightHotel.click();
		String FlightHotel_title = FlightHotel.getText();
		
		//Verify if element is enabled, print out the result
	if (FlightHotel.isEnabled() == true){
		System.out.println(FlightHotel_title + " Element Is enabled " + FlightHotel.isEnabled());
	}
	else{
		System.out.println(FlightHotel_title + " Element Is disabled " + FlightHotel.isDisplayed());
	}
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		wd.quit();
	}

}
