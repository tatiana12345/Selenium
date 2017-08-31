package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Xpath_extended {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");
		
		WebDriver wd= new FirefoxDriver();
		String baseURL="https://www.amazon.com/";
		
		wd.get(baseURL);
		
		//Click Departments
				wd.findElement(By.cssSelector("#nav-link-shopall")).click();
				Thread.sleep(3000);
				
		//Click Baby
				wd.findElement(By.cssSelector("a[href*='ref=sd_allcat_ba?ie=UTF8&']")).click();
				Thread.sleep(2000);
				
		// Click all brands
				wd.findElement(By.xpath("//div[@id='a-page']//li/a[contains (text(),'All Brands')]")).click();
				Thread.sleep(3000);
				
		//find Medela products
				wd.findElement(By.xpath("//div[@id='merchandised-content']//a[contains(text(),'Medela')]")).click();
				Thread.sleep(3000);
				
		//Click on cooler set
				wd.findElement(By.xpath("//ul[@id='s-results-list-atf']//h2[contains(@class,'s-access-title') and contains(text(),'Cooler Set')]")).click();
				Thread.sleep(3000);
				
		//Get the price and print it out
				String price1 = wd.findElement(By.xpath("//span[@id='priceblock_ourprice']")).getText();
				System.out.println("The price of the item is: " + price1);
		
		//Find xpath with "starts with" / it will work with xpath: //span[@class='nav-a-content'][text()='Strollers'] / //span[@class='nav-a-content'][contains(text(),'Strollers')]
				wd.findElement(By.xpath("//div[@id='nav-subnav']//span[starts-with(@class,'nav')and contains(text(),'Stroll')]")).click();
				
				wd.findElement(By.partialLinkText("")).click();
				
		//Mouser over 'Activity & Gear'		
		//		WebElement dropD = wd.findElement(By.xpath("//span[@class='nav-a-content'][text()='Activity & Gear']"));
				
				
				
				
				
		//	Find xpath by //div[@id='attribute']//a[contains(@class,'attribute') and contains(@href,'attribute')]
		//  Find xpath by  //div[@id='navbar']//a[contains(text(),'Login')]
				//wd.findElement(By.xpath("//div[@id='anonCarousel2']//div[contains(@class,'p13n-sc-truncated') and contains(text(),'Cooler Set')]"));

	}

}
