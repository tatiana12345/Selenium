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

public class ListOfElements_test1 {
	WebDriver wd;
	String baseURL1;
	String baseURL2;

	@Before
	public void setUp() throws Exception {
		//Firefox driver should be set in method
		System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");
		wd = new FirefoxDriver();
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		baseURL1="https://letskodeit.teachable.com/p/practice";
		baseURL2="https://www.expedia.com/";

	}
	
	@Test
	public void test_RBs() throws InterruptedException {
		wd.get(baseURL1);
		
		//Create a boolean to check if RB is checked
				boolean isChecked = false;
				
		//Locate WebElements on the page
		List<WebElement> RBs = wd.findElements(By.xpath("//input[contains(@type,'radio') and contains(@name,'cars')]"));
		
		//Find out how many buttons we are going to click, using .size() command and print out the size of the list
		int arSize = RBs.size();
		System.out.println("The size of the list is: " + arSize);
		
		//Create for loop that will click all RBs one by one 
		for (int i=0; i<arSize; i++){
			isChecked = RBs.get(i).isSelected();
		
			//Clicks RBs are checked, if no (isChecked boolean not equals fails (!isChecked)), then click RBs (i- one by one)
			if (!isChecked){
				RBs.get(i).click();
				Thread.sleep(2000);				
			}	
		}	
	}

	@Test
	public void test2_AllButtons() throws InterruptedException {
		wd.get(baseURL1);
		
		//Create a boolean to check if RB is checked
		boolean isChecked = false;
		
		//Locate WebElements on the page
		List<WebElement> allRBs = wd.findElements(By.name("cars"));
		
		//Find out how many buttons we are going to click, using .size() command and print out the size of the list		
		int arSize2 = allRBs.size();
		System.out.println("all RBs: " + arSize2);
		
		//ALL RBs: Create for loop that will click all RBs one by one 
		for (int i2=0; i2<arSize2; i2++){
			isChecked = allRBs.get(i2).isSelected();
			
	//ALL RBs: Clicks RBs are checked, if no (isChecked boolean not equals fails (!isChecked)), then click RBs (i- one by one)
			if (!isChecked){
				allRBs.get(i2).click();
				Thread.sleep(2000);
			}
		}
	}
	
	@Test
	public void test_expedia() throws InterruptedException {
		wd.get(baseURL2);
		//wd.findElement(By.xpath("//ul[@class='tabs cf col']//li[contains(@class,'tab')][1]//button[@type='button']")).click();
		
		//Create boolean to check if button is deselected
		boolean isSelected = true;
		
		//Locate WebElements on the page
		List<WebElement> Radio = wd.findElements(By.xpath("//ul[@class='tabs cf col']//li[contains(@class,'tab')]//button[@type='button']"));
		
		//Find out how many buttons we are going to click, using .size() command and print out the size of the list	
		int arSize = Radio.size();
		System.out.println(arSize + " Radio buttons found on the page");
				
		//Create for loop that will click all RBs one by one 
		for (int i=0; i<arSize; i++){
			isSelected = Radio.get(i).isSelected();
			
		// Clicks all deselected Radio buttons (by xpath for "Radio")	
			if (!isSelected){
				Radio.get(i).click();
				Thread.sleep(2000);
				}
		}
		for(int number=0; number<arSize; number++){
			System.out.println("Tab number: " + number + " clicked");
		}
	}
    
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		wd.quit();
	}
}
