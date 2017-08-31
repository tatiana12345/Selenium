package FILE_UPLOAD;

import java.awt.AWTException;
//import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.FileUpload_UT;
//import utilities.ScreenShot;

import utilities.reportPathName;

public class FileUpload {
	private WebDriver wd;
	String URL; 
	ExtentTest test;
	ExtentReports report;
	FileUpload_UT UT;
	
	  @BeforeClass
	  public void beforeClass() {
		  
		  report = reportPathName.getInstance();
		  test = report.startTest("Upload file test");
	  
		  System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");
	
		  wd = new FirefoxDriver();
		  UT = new FileUpload_UT(wd, test);
		  
		  URL = "https://www.gmail.com/";
		  
		  wd.manage().window().maximize();
		  wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		  wd.get(URL);
		  test.log(LogStatus.INFO, "Browser started");
		  test.log(LogStatus.INFO, "Browser maximized");
	  }
	  
	  
  @Test
  public void Test() throws AWTException, InterruptedException {
	  UT.typeUsername("kesler01test@gmail.com");
	  UT.typePassword("Sophiegirl0807!");
	  UT.clickLoginButton();
	  UT.clickComposeButton();
	  UT.typeEmailAdressee("kesler01test@gmail.com");
	  UT.typeSubject("test upload");
	  UT.clickFileInput();
	  
	  String filePath = "/Users/tatianakesler/Desktop/testfile.txt";
	  StringSelection stringselection = new StringSelection(filePath);
	  
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
	  
	  UT.UPLOADfileRobot();
	  UT.clickSendButton();
	  
	  boolean result = UT.ifFilePresent();
	  Assert.assertTrue(result);
	  test.log(LogStatus.PASS, "Test passed, file uploaded");
  
  }
  
	@AfterMethod
	public void tearDown(ITestResult testResult) throws IOException{
		if (testResult.getStatus()==ITestResult.FAILURE){
			String path = utilities.ScreenShot.NewScreenshotMethod
					.takeScreenshot(wd, testResult.getName());
			String imgPath = test.addScreenCapture(path);
			test.log(LogStatus.FAIL, "Verification of login with invalid credentials failed ", imgPath);
		}
		
	}
	
@AfterClass
public void afterClass() throws Exception {
	  Thread.sleep(2000);
	  wd.quit();
	  report.endTest(test);
	  report.flush();
}

}