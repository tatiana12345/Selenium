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

public class Expedia_Calendar {
	WebDriver wd;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");
		
		wd = new FirefoxDriver();
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		baseURL = "https://www.expedia.com/";
	}
	
	@Test
	public void test1() throws InterruptedException {
		wd.get(baseURL);
		
		//Assign webelement to "flights tab" + Click the Flights tab
		WebElement flight = wd.findElement(By.id("tab-flight-tab-hp"));
		flight.click();
		
		Thread.sleep(2000);
		
		//Assign webelement to departing field + click departing field
		WebElement departing = wd.findElement(By.id("flight-departing-hp-flight"));
		departing.click();
		
		//Find the date to be selected + click the date
		WebElement date = wd.findElement(By.xpath(
				"//td[@class='datepicker-day-number'][position()=1]/button[text()='30']"));
		date.click();
	}
	@Test
	public void test2() throws InterruptedException{
		wd.get(baseURL);
		//Assign webelement to "flights tab" + Click the Flights tab
		WebElement flight = wd.findElement(By.id("tab-flight-tab-hp"));
		flight.click();
		
		//Assign webelement to departing field + click departing field
		WebElement depating = wd.findElement(By.id("flight-departing-hp-flight"));
		depating.click();
		
		Thread.sleep(2000);
		
		//Select the calendar
		WebElement calMonth = wd.findElement(By.xpath(
				"//td[@class='datepicker-day-number'][position()=1]"));
		
		//WebElement list for all dates in the calendar
		List<WebElement> allValidDates = calMonth.findElements(By.tagName("a"));
		for (WebElement date : allValidDates){
			if (date.getText().equals("31")){
				date.click();
				break;
			}
		}
	
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		wd.quit();
	}
}
