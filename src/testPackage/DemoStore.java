package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoStore {

	public static void main(String[] args) throws InterruptedException {
		//Link, partial text link
		
		System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");
		
		WebDriver wd = new FirefoxDriver();
		String baseURL = "https://accounts.google.com/";
		
		wd.manage().window().maximize();
		wd.get(baseURL);
		
		//Thread.sleep(2000);
		wd.findElement(By.linkText("Create account")).click();
		
		Thread.sleep(2000);
		wd.findElement(By.partialLinkText("Learn")).click();
		
		//wd.navigate().back();

	}

}
