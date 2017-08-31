package testPackage;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesCapabilitiesDemo {

	public static void main(String[] args) throws Exception {
		//Desired capabilities
		
		System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");
		
		String baseURL = "https://letskodeit.teachable.com/pages/practice";
		
		WebDriver wd;
		
		DesiredCapabilities caps = DesiredCapabilities.firefox();
		caps.setBrowserName("firefox");
		caps.setPlatform(Platform.MAC);
		//caps.setVersion("Captain");
		
		wd = new FirefoxDriver(caps);
		
		//Driver bug(!)
//		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		wd.manage().window().maximize();
		wd.get(baseURL);
	
	}
}