package JUnit_tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import UsefulMethods.GenericMethods;

public class ElementListDemo {
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
		//Create path to list of elements and identify locator and type ("locator", "type")
		List<WebElement> ElementList = gm.getElementList("//meta[contains(@name,'twitter')]", "xpath");
		 
		//create integer to get store the size of found in the list elements
		int size = ElementList.size();
		System.out.println("Element list size: " + size);
		
		//Create path to list of elements and identify locator and type ("locator", "type")
				List<WebElement> ElementList2 = gm.getElementList("container", "classname");
				 
				//create integer to get store the size of found in the list elements
				int size2 = ElementList2.size();
				System.out.println("Element list size: " + size2);
		
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		wd.quit();
	}

}
