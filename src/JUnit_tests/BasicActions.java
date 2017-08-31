package JUnit_tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicActions {

	WebDriver wd;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		
		//Firefox driver should be set in method
		System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");
		
		wd = new FirefoxDriver();
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		baseURL = "https://letskodeit.teachable.com/p/practice";
	}
	
	@Test
	public void test() throws InterruptedException {
		wd.get(baseURL);
		wd.findElement(By.xpath("//div[@id='navbar']//a[contains(text(),'Login')]")).click();
		System.out.println("Clicked LOGIN");
		
		wd.findElement(By.id("user_email")).clear();
		wd.findElement(By.id("user_email")).sendKeys("test@email.com");
		System.out.println("typed in login");
		
		wd.findElement(By.id("user_password")).clear();
		wd.findElement(By.id("user_password")).sendKeys("test");
		System.out.println("typed in password");
		Thread.sleep(2000);
		
		wd.findElement(By.id("user_email")).clear();
		wd.findElement(By.id("user_password")).clear();
		System.out.println("Cleared the fields");
		
	}

	@After
	public void tearDown() throws Exception {
		wd.quit();
	}

}
