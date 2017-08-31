package JUnit_tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class baseicweb {
	
	WebDriver wd;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		//Firefox driver should be set in method
		System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");
		
		wd = new FirefoxDriver();
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		baseURL = "http://google.com";
		wd.get(baseURL);
	}
	
	@Test
	public void test() {
		WebElement e1 = wd.findElement(By.id("gs_htif0"));
		System.out.println("E1 is enabled? " + e1.isEnabled());
		
		if (e1.isEnabled() == true) {
			e1.sendKeys("letskodeit");
		}
		else{
			System.out.println("Element 1 is disabled");
		}
		
		WebElement e2 = wd.findElement(By.id("gs_taif0"));
		System.out.println("E2 is enabled? " + e2.isEnabled());
		
		if (e2.isEnabled() == true) {
			e2.sendKeys("letskodeit");
		}
		else{
			System.out.println("Element 2 is disabled");
		}
		
		WebElement e3 = wd.findElement(By.id("lst-ib"));
		System.out.println("E3 is enabled? " + e3.isEnabled());
		
		if (e3.isEnabled() == true) {
			e3.sendKeys("letskodeit");
			System.out.println("Keys sent! to E3");
		}
		else{
			System.out.println("Element 3 is disabled");
		}
		
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		wd.quit();
	}

}
