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


public class MultiSelect {
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
		
		WebElement element = wd.findElement(By.id("multiple-select-example"));
		
		//import org.openqa.selenium.support.ui.Select;
		Select sel = new Select(element);
		
		
		Thread.sleep(2000);
		System.out.println("Select Orange by value");
		sel.selectByValue("orange");
		
		Thread.sleep(2000);
		System.out.println("De-Select Orange by value");
		sel.deselectByValue("orange");

	//select 2 options and print those out		
		Thread.sleep(2000);
		System.out.println("Select Peach by Index");
		sel.selectByIndex(2);
		
		Thread.sleep(2000);
		System.out.println("Select Apple by visible text");
		sel.selectByVisibleText("Apple"); 
/////
		System.out.println("Currently selected options: ");
		List<WebElement> Selected_options = sel.getAllSelectedOptions();
		for (WebElement option1 : Selected_options){
			System.out.println(option1.getText());
		}
	
	
		Thread.sleep(2000);
		System.out.println("Print all options");
		
		List<WebElement> selectedOptions = sel.getOptions();
		int size = selectedOptions.size();
//print all options		
		for (int i=0; i<size; i++){
			String optionName = selectedOptions.get(i).getText();
			System.out.println(optionName);
		}
//////		
		Thread.sleep(2000);
		System.out.println("De-select all selected options");
		sel.deselectAll();
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		wd.quit();
	}
}
