package CSStest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CSS_Class {

	public static void main(String[] args) throws InterruptedException {
		//S65
		
		System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");
		
		WebDriver wd = new FirefoxDriver();
		String baseURL = "https://letskodeit.teachable.com/p/practice";
		
		wd.get(baseURL);
		
		wd.findElement(By.cssSelector(".btn-style.class2[value='Show']")).click();
		Thread.sleep(2000);
		wd.findElement(By.cssSelector(".btn-style.class2[value='Hide']")).click();
		
//		wd.findElement(By.cssSelector(".btn-style.class1.class2")).click();
//		Thread.sleep(2000);

		//Sibling / parent practice:
		
		String task1 = wd.findElement(By.xpath(".//table[@id='product']//td[text()='Python Programming Language']//following-sibling::td")).getText();
		System.out.println("Task1: " + task1);
		
		String task2 = wd.findElement(By.xpath("//tr//td[contains(text(),'Selenium')]//following-sibling::td")).getText();
		System.out.println("Task2: " + task2);
		
		String task3 = wd.findElement(By.xpath("//tr//td[contains(text(),'Selenium')]//following-sibling::td//preceding-sibling::td[1]")).getText();
		System.out.println("Task3: " + task3);

	}

}
