package Screenshot_test;

import java.io.File;
import java.util.Date;
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

public class Screenshot_test2 {
	
	WebDriver wd;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");
		wd = new FirefoxDriver();
		baseURL = "https://www.amazon.com/";
		
		//manage window
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {
		wd.get(baseURL);
		Thread.sleep(2000);
		
//		//assign web elements
		WebElement departments = wd.findElement(By.xpath("//span[@class='nav-line-2'][text()='Departments']"));
		departments.click();
		Thread.sleep(2000);
		
		WebElement baby = wd.findElement(By.xpath("//div[@class='fsdDeptCol']//a[starts-with(@href, '/baby-car')]"));
		baby.click();
		
		WebElement dis_diapers = wd.findElement(By.xpath("//a[contains(text(),'Disposable Diapers')]"));
		dis_diapers.click();
		
		WebElement newborn = wd.findElement(By.xpath("//span[@class='refinementLink'][text()='Newborn (Up to 10 lbs)']"));
		newborn.click();
		Thread.sleep(2000);
		
		WebElement swaddle = wd.findElement(By.xpath("//h2[@data-attribute='Pampers Swaddlers Sensitive Newborn Diapers Size 0, 80 Count']"));
		String diaper_name = swaddle.getText();
		//remove last 3 characters from the string ("...")
		String replaced = diaper_name.substring(0, diaper_name.length()-3);
		swaddle.click();
		Thread.sleep(2000);
		
		WebElement price = wd.findElement(By.xpath("//div[@id='snsPrice']//span[@class='a-size-large a-color-price']"));
		String price_diapers = price.getText();
		System.out.println(replaced + " The Price is:  " + price_diapers);
		
	}

	public static String getRandomString (int length){
		StringBuilder sb = new StringBuilder();
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		for (int i=0; i<length; i++){
			int index = (int) (Math.random() * characters.length());
			sb.append(characters.charAt(index));
			
		}
		return sb.toString();
	}
	
	public static String getDate(){
		Date d = new Date();
		String date = d.toString().replace(":", ".");
		return date;
	}
	
	@After
	public void tearDown() throws Exception {
		String fileName = getRandomString(3) + " " + getDate() + ".png";
		String directory = "/Users/tatianakesler/Desktop/test123/";
		File sourceFile = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File (directory + fileName));
		
		Thread.sleep(2000);
		wd.quit();
	}
}
