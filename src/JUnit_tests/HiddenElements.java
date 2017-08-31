package JUnit_tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HiddenElements {
	
	WebDriver wd;
	String baseURL1;
	String baseURL2;

	@Before
	public void setUp() throws Exception {

        System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");
        wd = new FirefoxDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        baseURL1="https://letskodeit.teachable.com/p/practice";
        baseURL2= "https://www.expedia.com/";
	}
	
	@Test
	public void test_LKI() throws InterruptedException {
		wd.get(baseURL1);
		
		//Create webelement and verify if element is displayed + print out the result
		WebElement textBox = wd.findElement(By.id("displayed-text"));
		System.out.println("Text box is displayed " + textBox.isDisplayed());
		
		Thread.sleep(3000);
		
		//Create webelement for "hide button"-> click the button -> print out the result for text box visibility
		WebElement hideButton = wd.findElement(By.id("hide-textbox"));
		hideButton.click();
		System.out.println("Clicked hide button");
		System.out.println("Text box is displayed " + textBox.isDisplayed());
		
		Thread.sleep(3000);
		
		//Create webelement for show button-> click the button -> print out the result for text box visibility
		WebElement showButton = wd.findElement(By.id("show-textbox"));
		showButton.click();
		System.out.println("Clicked show button");
		System.out.println("Text box is displayed " + textBox.isDisplayed());
	}
	
	@Test
	public void expedia() {
		wd.get(baseURL2);
		
		//Create webelement for "child" drop down + print out visibility result
		WebElement ChildDD = wd.findElement(By.id("package-1-age-select-1-hp-package"));
		System.out.println("child drop down is displayed: " + ChildDD.isDisplayed());
	}

	
	
	
	@After
	public void tearDown() throws Exception {
		
		Thread.sleep(3000);
		wd.quit();
	}
}
