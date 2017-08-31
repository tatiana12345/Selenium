package JUnit_tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationBTWNpages {

	WebDriver wd;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		// Firefox driver should be set in method
		System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");

		wd = new FirefoxDriver();
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		baseURL = "http://letskodeit.teachable.com/";
	}

	@Test
	public void test() throws InterruptedException {
		wd.get(baseURL);
		// Print the title of the page
		String title = wd.getTitle();
		System.out.println("Page Title: " + title);

		// Print the URL of the page
		String URL = wd.getCurrentUrl();
		System.out.println("URL1: " + URL);

		// Navigate to URL stored in String variable
		String NavToURL = "https://sso.teachable.com/secure/42299/users/sign_in?clean_login=true&reset_purchase_session=1";
		wd.navigate().to(NavToURL);
		Thread.sleep(2000);

		// print out current URL
		URL = wd.getCurrentUrl();
		System.out.println("URL2: " + URL);
		Thread.sleep(2000);

		// Navigate back
		wd.navigate().back();
		System.out.println("Navigate back");
		URL = wd.getCurrentUrl();
		System.out.println("URL3: " + URL);
		Thread.sleep(2000);

		// Navigate FWd
		wd.navigate().forward();
		System.out.println("Navigate forward");
		URL = wd.getCurrentUrl();
		System.out.println("URL4: " + URL);
		Thread.sleep(2000);

		// Navigate back
		wd.navigate().back();
		System.out.println("Navigate back");
		URL = wd.getCurrentUrl();
		System.out.println("URL5: " + URL);
		Thread.sleep(2000);

		wd.navigate().refresh();
		System.out.println("Navigate refresh-1");
		Thread.sleep(2000);
		wd.get(URL);
		System.out.println("Navigate refresh-get current URL");

		// Page Source
		String pageSource = wd.getPageSource();
		System.out.println(pageSource);
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		wd.quit();
	}

}
