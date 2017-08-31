package switchTo;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class switchWindow {
	WebDriver wd;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");
		wd = new FirefoxDriver();
		baseURL = "https://letskodeit.teachable.com/p/practice";
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() throws InterruptedException {
		wd.get(baseURL);
		
		//Get the handle
		String parentHandle = wd.getWindowHandle();
		System.out.println("Parent Handle: " + parentHandle);
		
		// Find Open Window button
		WebElement openWindow = wd.findElement(By.id("openwindow"));
		openWindow.click();
		
		//Get all handles
		Set <String> handles = wd.getWindowHandles();
		
		//Switch between handles
		for (String handle: handles){
			System.out.println(handle);
			
		//Selects child handle (window) 	
			if (!handle.equals(parentHandle)){
				wd.switchTo().window(handle);
				Thread.sleep(2000);
		//Type in "python" in the search box		
				WebElement searchBox = wd.findElement(By.id("search-courses"));
				searchBox.sendKeys("python");
		//wd.findElement(By.id("search-course-button")).click();
				Thread.sleep(3000);
				wd.close();
				break;
			}
		}
		
		//Switch back to the parent window	
		wd.switchTo().window(parentHandle);
		wd.findElement(By.id("name")).sendKeys("test successful");
		
		
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		wd.quit();
	}
}
