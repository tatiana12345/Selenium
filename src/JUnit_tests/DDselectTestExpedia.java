package JUnit_tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DDselectTestExpedia {
	WebDriver wd;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");
		
		wd = new FirefoxDriver();
		baseURL = "https://www.expedia.com/";
		
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {
		wd.get(baseURL);
		wd.findElement(By.id("tab-flight-tab-hp")).click();
		WebElement element = wd.findElement(By.id("flight-adults-hp-flight"));
		
		Select sel = new Select(element);
		
		System.out.println("Select by value");
		sel.selectByValue("1");
		
		Thread.sleep(2000);
		System.out.println("Select by visible text");
		sel.selectByVisibleText("2");
		
		Thread.sleep(2000);
		System.out.println("Select by index, should print out '3'");
		sel.selectByIndex(2);

		Thread.sleep(2000);
		System.out.println("Select all options and pint out");
		
		
		List<WebElement> options = sel.getOptions();
		//print out all options from the DD
		int size = options.size();
		
		for (int i=0; i<size; i++){
			String optionName = options.get(i).getText();
			System.out.println(optionName);
		}
		
////////////////	
		
		System.out.println("Select all options and pint out  - child DD");
		
		WebElement elementChild = wd.findElement(By.id("flight-children-hp-flight"));
		Select selChild = new Select(elementChild);
		
	List<WebElement> optionsChild = selChild.getOptions();
	int size2 = optionsChild.size();
	
	for (int I=0; I<size2; I++){
		String optionsNameChild = optionsChild.get(I).getText();
		System.out.println(optionsNameChild);
		}	
	
	
/////////////////
	wd.findElement(By.id("tab-package-tab-hp")).click();
	System.out.println("Select all options and pint out  - bundle deal ROOMS");
	
	//Locate needed elements (drop down) - create web element for the DD
	WebElement elemRooms = wd.findElement(By.id("package-rooms-hp-package"));
	
	//create Select variable for the elements in the DD
	Select selRooms = new Select(elemRooms);
	
	//create list of web-elements and get all options stored in the list
	List<WebElement> optionsRooms = selRooms.getOptions();
	
	//create integer for array of all elements found in the DD, get the size of the array
	int size3 = optionsRooms.size();
	
	//create for loop for the array 
	for (int i3=0; i3<size3; i3++){
		
		//Get text of all elements in the DD and print those out
		String options3 = optionsRooms.get(i3).getText();
		System.out.println(options3);
	}
	
	}
	
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		wd.quit();
	}
}
