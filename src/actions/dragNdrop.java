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

public class dragNdrop {
	WebDriver wd;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");

		wd = new FirefoxDriver();
		baseURL = "http://jqueryui.com/droppable/";

		//		baseURL = "http://www.dhtmlx.com/docs/products/dhtmlxTree/";
		
		//manage window
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() throws InterruptedException {
		wd.get(baseURL);
		Thread.sleep(2000);
		wd.switchTo().frame(0);
				
		//Assign web elements
		WebElement fromElement = wd.findElement(By.id("draggable"));
		WebElement toElement = wd.findElement(By.id("droppable"));
		
		Actions action = new Actions(wd);
		
		//Drag & drop
		//action.dragAndDrop(fromElement, toElement).build().perform();
		
		//Click and hold, move to element, release, build and perform
		action.clickAndHold(fromElement).moveToElement(toElement).release().build().perform();
		
	}

	@After
	public void tearDown() throws Exception {
	}
}
