package actions;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class sliderActions {
	WebDriver wd;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");

		wd = new FirefoxDriver();
		baseURL = "http://jqueryui.com/slider/";
		
		//manage window
				wd.manage().window().maximize();
				wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {
		wd.get(baseURL);
		wd.switchTo().frame(0);
		Thread.sleep(2000);
		
		//create web element for the slider
		WebElement element = wd.findElement(By.xpath("//div[@id='slider']/span"));
		
		//Use Actions
		Actions action = new Actions(wd);
		action.dragAndDropBy(element, 100, 0).perform();
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		wd.quit();
		
	}

}
