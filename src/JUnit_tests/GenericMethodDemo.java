package JUnit_tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import UsefulMethods.GenericMethods;

public class GenericMethodDemo {
	private WebDriver wd;
	private String baseURL;
	private UsefulMethods.GenericMethods gm;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");
		wd = new FirefoxDriver();
		baseURL = "https://letskodeit.teachable.com/p/practice";
		
		//Provide method
		gm = new GenericMethods(wd);
		
		//Manage window commands
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	
	@Test
	public void test() {
		wd.get(baseURL);
		WebElement element = gm.getElement("name", "id");
		element.sendKeys("test");
		
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		wd.quit();
	}

}
