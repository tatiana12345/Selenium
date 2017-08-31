package actions;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class mouseHover {
	WebDriver wd;
	String baseURL;
	JavascriptExecutor jse;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");
		
		wd = new FirefoxDriver();
		jse = (JavascriptExecutor)wd;
		baseURL = "https://letskodeit.teachable.com/pages/practice";
		
		//manage window
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.get(baseURL);
		
	}

	@Test  
	
	//////////does not work in all browsers!!!!
	
	public void MouseHoverActions() throws InterruptedException {
		//Scroll to the mouse hover button
		jse.executeAsyncScript("window.scrollBy(0,600)");
		
		Thread.sleep(4000);
		
		//Create webelement for mouse hover button (main element)
		WebElement mainElement = wd.findElement(By.id("mousehover"));
		
		//Create Action for hovering
		Actions action = new Actions(wd);
		
		//move to element
		action.moveToElement(mainElement).perform();
		Thread.sleep(2000);
		
		///Create webelement for menu item under mouse hover button (sub-element element)
		WebElement subelement = wd.findElement(By.xpath("//div[@class='mouse-hover-content']//a[text()='Top']"));
//		subelement.click();
		action.moveToElement(subelement).click().perform();
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		wd.quit();
	}
}
