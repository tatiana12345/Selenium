package testPackage;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test1IDE {
  private WebDriver driver;
  private String baseUrl;

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.letskodeit.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test1IDE() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("DrpDwnMn05label")).click();
    driver.findElement(By.cssSelector("span.color_18 > span > span > span > span")).click();
  }

  @After
  public void tearDown() throws Exception {
	  Thread.sleep(3000);
    //driver.quit();

  }
}
