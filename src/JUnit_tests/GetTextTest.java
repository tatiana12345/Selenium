package JUnit_tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetTextTest {
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
		WebElement window = wd.findElement(By.id("openwindow"));
		String WinText = window.getText();
		
		System.out.println("The txt of selected element is: " + WinText);
		
		WebElement tab = wd.findElement(By.id("opentab"));
		String tabText = tab.getText();
		
		System.out.println("The text of the tab is: " + tabText);
		
		WebElement table1 = wd.findElement(By.xpath("//table[@id='product']//tr[1]/th[1]"));
		String tableText = table1.getText();
		
		System.out.println("The text of selected table header is: " + tableText);
		
		WebElement titleOf =wd.findElement(By.xpath("//div[@class='cen-right-align']/fieldset/legend"));
		String titleText = titleOf.getText();
		
		System.out.println("The title of selected section is: " + titleText);
		
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		wd.quit();
	
	}
}
