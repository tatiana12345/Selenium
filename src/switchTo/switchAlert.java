package switchTo;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class switchAlert {
	
	WebDriver wd;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");
		wd = new FirefoxDriver();
		baseURL="https://letskodeit.teachable.com/p/practice";
		
		//window manage
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.get(baseURL);
		//WebElement input = wd.findElement(By.id("name"));
		
	}
	
	@Test
	public void test1() throws InterruptedException {
		Thread.sleep(1000);
		
		//input field
		WebElement input = wd.findElement(By.id("name"));
		input.sendKeys("testing");
		
		//Alert button
		WebElement alertB = wd.findElement(By.id("alertbtn"));
		alertB.click();
		
		//Create Alert (alert - is a class imported from selenium.com)
		Thread.sleep(2000);
		Alert alert = wd.switchTo().alert();
		
		//accept alert 
		alert.accept();
		
		
	}

	@Test
	public void test2() throws InterruptedException {
		Thread.sleep(1000);
		//input field
		WebElement input = wd.findElement(By.id("name"));
		input.sendKeys("testing");
		
		//Alert button
		WebElement confirm = wd.findElement(By.id("confirmbtn"));
		confirm.click();
		
		//Create Alert (alert - is a class imported from selenium.com)
		Thread.sleep(2000);
		Alert alert = wd.switchTo().alert();
		
		//dismiss alert 
		alert.dismiss();
		
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		wd.quit();
	}
}
