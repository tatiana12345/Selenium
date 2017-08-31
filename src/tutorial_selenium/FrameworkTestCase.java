package tutorial_selenium;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import page_classes.SearchPageFactory;

public class FrameworkTestCase {
	private WebDriver wd;
	private String baseURL;
	SearchPageFactory searchPage;
	

	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");
		
		wd= new FirefoxDriver();
		baseURL = "https://www.expedia.com/";
		
		searchPage = new SearchPageFactory(wd);
		
		//manage window
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.get(baseURL);
	}

	@Test
	public void test() {
		searchPage.clickFlightTab();
		searchPage.setoriginCity("New York");
		searchPage.setDestiantionCity("Chicago");
		searchPage.clickRoundTrip();
		searchPage.setDepartureDate("12/05/2017");
		searchPage.setReturningDate("12/20/2017");
		searchPage.advancedOptionsCheck();
		searchPage.NonstopChecked();
		searchPage.RefundableFlightChecked();
		searchPage.clickSearchButton();
	
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(7000);
		wd.quit();
	}

}
