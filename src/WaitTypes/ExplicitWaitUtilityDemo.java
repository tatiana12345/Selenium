package WaitTypes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ExplicitWaitUtilityDemo {
	private WebDriver wd;
	private String baseURL;
	WaitTypes wt;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");
		
		wd = new FirefoxDriver();
		baseURL = "https://letskodeit.teachable.com/p/practice";
		wt = new WaitTypes(wd);
		wd.manage().window().maximize();
		
	}

	@Test
	public void test() {
		wd.get(baseURL);
		WebElement loginLink = wd.findElement(By.linkText("Login"));
		loginLink.click();
		
		WebElement emailField = wt.waitForElement(By.id("user_email"), 3);
		emailField.sendKeys("test");
		
		wt.clickWhenReady(By.name("commit"), 3);
	
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		wd.quit();
	}
}
