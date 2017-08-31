package Browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome {

	public static void main(String[] args) {
		// Chrome
		String baseURL = "http://www.google.com";
		WebDriver wd;
		System.setProperty("webdriver.chrome.driver", "/Users/tatianakesler/Desktop/Selenium/installation/chromedriver");
		wd = new ChromeDriver();
		wd.get(baseURL);

	}
}
