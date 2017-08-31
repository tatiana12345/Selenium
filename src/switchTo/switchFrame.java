package switchTo;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class switchFrame {
	WebDriver wd;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");
		wd = new FirefoxDriver();
		baseURL = "https://letskodeit.teachable.com/p/practice";
		
		//manage window:
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.get(baseURL);
	}

	@Test
	public void test() throws InterruptedException {
		Thread.sleep(3000);
		//switch the frame by name
//		wd.switchTo().frame("iframe-name");
		
		//switch to frame by ID
//		wd.switchTo().frame("courses-iframe");
		
		//switch to frame by number USE INT (0 - is the 1st frame)
		wd.switchTo().frame(0);
		
		WebElement searchBox =wd.findElement(By.id("search-courses"));
		searchBox.sendKeys("python");
		
		wd.switchTo().defaultContent();
		Thread.sleep(5000);
		
		wd.findElement(By.id("name")).sendKeys("test successful");
		
		
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		wd.quit();
	}

}
