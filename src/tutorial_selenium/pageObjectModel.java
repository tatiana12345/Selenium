package tutorial_selenium;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import page_classes.SearchPage;

public class pageObjectModel {
	private WebDriver wd;
	private String baseURL;
	

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");
		
		wd = new FirefoxDriver();
		baseURL = "https://www.expedia.com/";
		
		
		//manage window
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() {
		wd.get(baseURL);
		SearchPage.navigateToFlightsTab(wd);
		SearchPage.fillOriginTextBox(wd, "New York");
		SearchPage.fillDestinationTextBox(wd, "Chicago");
		SearchPage.fillDepartureDate(wd,"12/25/2017");
		SearchPage.fillReturnDate(wd, "12/30/2017");
		SearchPage.clickSearchButton(wd);
		
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(7000);
		wd.quit();

	}

}
