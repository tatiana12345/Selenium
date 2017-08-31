package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
//import java.awt.Toolkit;
//import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FileUpload_UT {
	WebDriver wd = null;
	ExtentTest test;

	public FileUpload_UT(WebDriver wd, ExtentTest test) {
		this.wd = wd;
		this.test = test;		
	}
	
	public static WebElement element = null;

	public void typeUsername(String username){
		WebElement emailFiled = wd.findElement(By.id("identifierId"));
		emailFiled.sendKeys(username);
		test.log(LogStatus.INFO, "Login email typed" + username);
	}
	public void typePassword(String password){
		WebElement passwordField = wd.findElement(By.xpath("//div[@id='password']//div[text()='Enter your password']"));
		passwordField.sendKeys(password);
		test.log(LogStatus.INFO, "Password typed" + password);
	}
	public void clickLoginButton (){
		WebElement loginButton = wd.findElement(By.id("passwordNext"));
		loginButton.click();
		test.log(LogStatus.INFO, "Login Button clicked");
	}
	public void clickComposeButton(){
		WebElement compose = wd.findElement(By.xpath("//div[@id=':7l']//div[text()='COMPOSE']"));
		compose.click();
		test.log(LogStatus.INFO, "Compose button clicked");
	}
	public void typeEmailAdressee(String addressee){
		WebElement emailField2 = wd.findElement(By.id(":cz"));
		emailField2.sendKeys(addressee);
		test.log(LogStatus.INFO, "Typed addressee email");
	}
	public void typeSubject(String subject){
		WebElement subjectField = wd.findElement(By.id(":cj"));
		subjectField.sendKeys(subject);
		test.log(LogStatus.INFO, "Subject typed");
	}
	public void typeEmailText(String textBody){
		WebElement subjectField = wd.findElement(By.id(":dm"));
		subjectField.sendKeys(textBody);
		test.log(LogStatus.INFO, "TextBody typed");
	}
	public void clickFileInput(){
		WebElement inputFile= wd.findElement(By.id(":ec"));
		inputFile.click();
		test.log(LogStatus.INFO, "Clicked 'Upload file' button");	
	}
	public void UPLOADfileRobot() throws AWTException, InterruptedException{
		  
		String filePath = "/Users/tatianakesler/Desktop/testfile.txt";
		  StringSelection stringselection = new StringSelection(filePath);
		  
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
		  
		Robot robot = new Robot();
		//CMD +Tab
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(2000);
		//Go to window
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_G);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_G);
		//paste the clipboard value
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_V);
		//hit enter key
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(2000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		test.log(LogStatus.INFO, "File attached");
	}
	
	public void clickSendButton(){
		WebElement sendButton = wd.findElement(By.id(":ce"));
		sendButton.click();
		test.log(LogStatus.INFO, "'Send' button clicked");
	}
	public void viewMessae(){
		WebElement viewMess = wd.findElement(By.id("link_vsm"));
		viewMess.click();
		test.log(LogStatus.INFO, "Clicked 'View message'");
	}
	public boolean ifFilePresent(){
		WebElement filePresent = null;
		try{
			filePresent = wd.findElement(By.xpath("//span[@id=':cu'][text()='testfile.txt']"));
			if (filePresent !=null){
				return true;
			}
		} catch (NoSuchElementException e){
			System.out.println(e.getMessage());
		}
		return false;
		
	}
	
	
}
