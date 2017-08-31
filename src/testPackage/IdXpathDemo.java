package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IdXpathDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");
		
		WebDriver wd = new FirefoxDriver();
		String baseURL = "https://www.google.com";
		
		wd.manage().window().maximize();
		wd.get(baseURL);
		
		wd.findElement(By.id("lst-ib")).sendKeys("letskodeit");
		wd.findElement(By.id("_fZl")).click();
		Thread.sleep(1000);
	//	wd.findElement(By.linkText("Yes, show me")).click();
	//	wd.navigate().back();
		wd.findElement(By.linkText("Lets Kode it")).click();
//		
		Thread.sleep(2000);
		wd.findElement(By.id("DrpDwnMn05bg")).click();
		//wd.quit();

	}

}
