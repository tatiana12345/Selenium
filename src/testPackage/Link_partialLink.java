package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Link_partialLink {

	public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");
		
		WebDriver wd= new FirefoxDriver();
		wd.get("https://letskodeit.teachable.com/p/practice");
		wd.findElement(By.linkText("Let's Kode It")).click();
		wd.navigate().back();
		
		Thread.sleep(2000);
		wd.findElement(By.partialLinkText("Login")).click();
		


	}

}
