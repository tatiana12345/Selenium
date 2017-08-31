package Screenshot_test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Screenshot {
	WebDriver wd;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");
		wd = new FirefoxDriver();
		baseURL = "https://www.expedia.com/";
		
		//manage window
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void test() {
		wd.get(baseURL);
		
		//Assign web elements to all elements:
		WebElement fly_tab = wd.findElement(By.id("tab-flight-tab-hp"));
		WebElement flight_origin = wd.findElement(By.id("flight-origin-hp-flight"));
		WebElement flight_destination = wd.findElement(By.id("flight-destination-hp-flight"));
		WebElement depatrure_date = wd.findElement(By.id("flight-departing-hp-flight"));
		WebElement return_date = wd.findElement(By.id("flight-returning-hp-flight"));
		WebElement search = wd.findElement(By.xpath("//form[@id='gcw-flights-form-hp-flight']//span[@class='btn-label'][text()='Search']"));
		
		//Send data to elements
		fly_tab.click();
		flight_origin.sendKeys("New York");
		depatrure_date.sendKeys("10/20/2017");
		return_date.clear();
		return_date.sendKeys("10/27/2017");
		flight_destination.sendKeys("New York");
		search.click();
		
	}
	
	public static String getRandomString (int length){
	     StringBuilder sb = new StringBuilder();
	     String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
         for (int i=0; i< length; i++){
        	 int index = (int) (Math.random() * characters.length());
        	 sb.append(characters.charAt(index));
	}
		return sb.toString();	
	}

	@After
	public void tearDown() throws Exception {
		String fileName = getRandomString(10) + ".png";
		String directory = "/Users/tatianakesler/Desktop/test123/screenshot";
		
		//import File from java.io.file***
		File sourceFile = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + fileName));
	}

}
