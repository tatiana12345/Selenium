package EventListener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WEB_Listeners {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");
		
		String baseURL = "https://www.expedia.com/";
		WebDriver wd = new FirefoxDriver();
		
		EventFiringWebDriver eDriver = new EventFiringWebDriver(wd);
		HandleEvents_178 he = new HandleEvents_178();
		eDriver.register(he);

		eDriver.get(baseURL);
		eDriver.findElement(By.id("tab-flight-tab-hp")).click();
		
		wd.quit();
	}

}
