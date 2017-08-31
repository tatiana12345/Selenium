package JUnit_tests;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.Select;

public class DropdownSelect {
	WebDriver wd;
	String baseURL;
	

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");
		
		wd = new FirefoxDriver();
		baseURL = "https://letskodeit.teachable.com/p/practice";
		
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


	@Test
	public void test() throws InterruptedException {
		wd.get(baseURL);
		WebElement element = wd.findElement(By.id("carselect"));
		
		//import org.openqa.selenium.support.ui.Select;
		Select sel = new Select(element);
		
		Thread.sleep(2000);
		
		System.out.println("Select Benz by value");
		sel.selectByValue("benz");
		
		Thread.sleep(2000);
		
		System.out.println("Select Honda by index");
		sel.selectByIndex(2);
		
        Thread.sleep(2000);
		
		System.out.println("Select BMW by visible text");
		sel.selectByVisibleText("BMW");
		
        Thread.sleep(2000);
		
		System.out.println("Print out all options in the DropDown");
		List<WebElement> options = sel.getOptions();
		int size = options.size();
		
		for (int i=0; i<size; i++){
			String optionName = options.get(i).getText();
			System.out.println(optionName);		
		}
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);	
		wd.quit();
	}
}
