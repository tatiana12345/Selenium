package JUnit_tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetAtributeTest {
	WebDriver wd;
	String baseURL;
	

	@Before
	public void setUp() throws Exception {
		 System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");
	       baseURL = "https://letskodeit.teachable.com/p/practice";
	       wd = new FirefoxDriver();
	}

	@Test
	public void test() {
		wd.get(baseURL);
		WebElement att1 = wd.findElement(By.id("name"));
		String attValue = att1.getAttribute("class");
		System.out.println("Attribute 1 value is: " + attValue);
		
		WebElement att2 =wd.findElement(By.id("name"));
		String attValue2 = att2.getAttribute("type");
		System.out.println("Attribute 2 value is: " + attValue2);
		
		WebElement att3 = wd.findElement(By.id("name"));
		String attValue3 = att3.getAttribute("placeholder");
		System.out.println("Attribut 3 value is: " + attValue3);
		
		WebElement att4 = wd.findElement(By.xpath("//a[@class='navbar-brand header-logo']"));
		String attValue4 = att4.getAttribute("href");
		System.out.println("Attribut 4 value is: " + attValue4);
		
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		wd.quit();
	}

}
