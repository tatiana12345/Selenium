package CSStest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CSS1 {

	public static void main(String[] args) throws InterruptedException {
		// lecture 64
		System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");
		
		WebDriver wd= new FirefoxDriver();
		String baseURL="https://www.amazon.com/";
		
		wd.get(baseURL);
		
		//click "the easter shop"
		Thread.sleep(2000);
		boolean isPresent = wd.findElements(By.cssSelector("a[alt='The Easter Shop']")).size() > 0;
		 if (isPresent==true){
		wd.findElement(By.cssSelector("#navSwmHoliday")).click();
		System.out.println("Easter logo found");
		//wd.navigate().back();
		
		//click search DD, select Baby, 
		Thread.sleep(2000);
		wd.findElement(By.cssSelector("#searchDropdownBox")).click();
		wd.findElement(By.cssSelector("option[value='search-alias=baby-products']")).click();
		Thread.sleep(2000);
		
		
		//Click Departments
		wd.findElement(By.cssSelector("#nav-link-shopall")).click();
		
		//Click Baby
		Thread.sleep(2000);
		wd.findElement(By.cssSelector("a[href*='ref=sd_allcat_ba?ie=UTF8&']")).click();
		Thread.sleep(2000);
		//wd.navigate().back();
		
		//Click LOGO 4moms
		wd.findElement(By.cssSelector("img[alt='4moms']")).click();
		
		 }
		 
		 else {
			 System.out.println("Easter logo not found");
			 
			//Click Departments, nav back 
			wd.findElement(By.cssSelector("#nav-link-shopall")).click();
			//Select 'ToysKidsBabyPanel'
			wd.findElement(By.cssSelector("a[href*='ref=sd_allcat_ba?ie=UTF8&']")).click();
		 }
	}
	

}
