package tutorial_selenium;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import page_classes.SearchPage;


public class FindLinks {
	private WebDriver wd;
	private String baseURL;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");
		
		wd = new FirefoxDriver();
		baseURL = "https://www.expedia.com/";
		
		//manage window
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		wd.get(baseURL);
		
		SearchPage.navigateToFlightsTab(wd);
		
		List<WebElement> linksList = clickableLinks(wd);
		for (WebElement link : linksList){
			String href = link.getAttribute("href");
			try {
				System.out.println("URL " + href + " returned " + linkStatus(new URL(href)));
			}
			catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
		
	}
	
	public static List<WebElement> clickableLinks(WebDriver wd){
		List<WebElement> linksToClick = new ArrayList<WebElement>();
		List<WebElement> elements =wd.findElements(By.tagName("a"));
		elements.addAll(wd.findElements(By.tagName("img")));
		
		for (WebElement e : elements){
			if (e.getAttribute("href") !=null){
				linksToClick.add(e);
			}
		}	
		return linksToClick;	
	}
	
	public static String linkStatus(URL url){
		try{
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.connect();
			String responseMessage = http.getResponseMessage();
			http.disconnect();
			return responseMessage;
		}
		catch (Exception e){
			return e.getMessage();
		}
		
	}

	
	@After
	public void tearDown() throws Exception {
	}

}
