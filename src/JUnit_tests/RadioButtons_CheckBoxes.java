package JUnit_tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioButtons_CheckBoxes {
	
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
		//Click radio buttons
		WebElement bmwRB = wd.findElement(By.id("bmwradio"));
		bmwRB.click();
		System.out.println("clicked BMW radiobutton");
		Thread.sleep(2000);
		WebElement benzRB = wd.findElement(By.id("benzradio"));
		benzRB.click();
		System.out.println("clicked BENZ radiobutton");
		
		//Click checkboxes
		WebElement bmwCB = wd.findElement(By.id("bmwcheck"));
		bmwCB.click();
		System.out.println("selected BMW Checkbox");
		
		WebElement benzCB = wd.findElement(By.id("benzcheck"));
		benzCB.click();
		System.out.println("selected BENZ Checkbox");
		
		//For text fields there is a property type = boolean
		
		System.out.println("BMW Radio button is selected - " + bmwRB.isSelected());
		System.out.println("Benz Radio button is selected - " + benzRB.isSelected());
		System.out.println("BMW Checkbox is selected - " + bmwCB.isSelected());
		System.out.println("Benz Checkbox is selected - " + bmwCB.isSelected());
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		wd.quit();
	}

}
