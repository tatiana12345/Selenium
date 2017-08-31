package UsefulMethods;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethods {
	WebDriver wd;
	
	public GenericMethods(WebDriver wd) {
		//"this" keyword/reference makes "wd" to refer to the class instance (so as below in the script)
		this.wd = wd;
	}
	
	public WebElement getElement (String locator, String type){
		type = type.toLowerCase();
		if (type.equals("id")){
			System.out.println("Element found with id: " + locator);
			return this.wd.findElement(By.id(locator));
		}
		else if (type.equals("xpath")){
			System.out.println("Element found with xpath: " + locator);
			return this.wd.findElement(By.xpath(locator));
		}
		else if (type.equals("name")){
			System.out.println("Element found with name: " + locator);
			return this.wd.findElement(By.name(locator));
		}
		else if (type.equals("css")){
			System.out.println("Element found with css: " + locator);
			return this.wd.findElement(By.cssSelector(locator));
		}
		else if (type.equals("classname")){
			System.out.println("Element found with calss name: " + locator);
			return this.wd.findElement(By.className(locator));
		}
		else if (type.equals("tagname")){
			System.out.println("Element found with tag name: " + locator);
			return this.wd.findElement(By.tagName(locator));
		}
		else if (type.equals("linktext")){
			System.out.println("Element found with linktext: " + locator);
			return this.wd.findElement(By.linkText(locator));
		}
		else if (type.equals("partiallinktext")){
			System.out.println("Element found with partial text link: " + locator);
			return this.wd.findElement(By.partialLinkText(locator));
		}
		else {
			System.out.println("Provided locator type is not supported: " + type);
			return null;
		}
	}

	
	public List<WebElement> getElementList(String locator, String type){
		type = type.toLowerCase();
		List<WebElement> elementList = new ArrayList<WebElement>();
		if (type.equals("id")){
			System.out.println("Element found with id: " + locator);
			elementList =  this.wd.findElements(By.id(locator));
		}
		else if(type.equals("xpath")){
			System.out.println("Element found with xpath: " +locator);
			elementList =  this.wd.findElements(By.xpath("locator"));
		}
		else if (type.equals("name")){
			System.out.println("Element found with name: " + locator);
			elementList =  this.wd.findElements(By.name(locator));
		}
		else if (type.equals("css")){
			System.out.println("Element found with css: " + locator);
			elementList =  this.wd.findElements(By.cssSelector(locator));
		}
		else if (type.equals("classname")){
			System.out.println("Element found with calss name: " + locator);
			elementList =  this.wd.findElements(By.className(locator));
		}
		else if (type.equals("tagname")){
			System.out.println("Element found with tag name: " + locator);
			elementList =  this.wd.findElements(By.tagName(locator));
		}
		else if (type.equals("linktext")){
			System.out.println("Element found with linktext: " + locator);
			elementList =  this.wd.findElements(By.linkText(locator));
		}
		else if (type.equals("partiallinktext")){
			System.out.println("Element found with partial text link: " + locator);
			elementList =  this.wd.findElements(By.partialLinkText(locator));
		}
		else{
			System.out.println("Selected locator is invalid: " + type);
		}
		return elementList;
	
	}
	
	public boolean isElementPresent(String locator, String type){

		List<WebElement> elementList = getElementList(locator, type);
		
		int size = elementList.size();
		
		if (size > 0){
			return true;
		}
		else return false;
	}
    
	public WebElement waitForElement(By locator, int timeout){
		WebElement element = null;
		try{
			System.out.println("Waiting allowed is: " + timeout + " Seconds for element to be available");
			
			WebDriverWait wait = new WebDriverWait(wd, 3);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			System.out.println("Element appeared on the webpage in expected time frame");
			
			
		} catch (Exception e){
			System.out.println("Element has not appeared on "
					+ "the web page in expected timeout");
		}
		return element;
	}
	
	public void clickWhenReady (By locator, int timeout){

		try{
			WebElement element = null;
			System.out.println("Waiting allowed is: " + timeout + " Seconds for element to be clickable");
			
			WebDriverWait wait = new WebDriverWait(wd, 3);
			element = wait.until(
					ExpectedConditions.elementToBeClickable(locator));
			element.click();
			System.out.println("Element clicked in expected time frame");
			
			
		} catch (Exception e){
			System.out.println("Element has not appeared on "
					+ "the web page in expected timeout");
		}
	}

}


