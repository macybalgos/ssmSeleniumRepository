import java.util.Collections;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {
	  public WebDriver driver;
	  public String webdriver = "webdriver.chrome.driver";
	  public String setproperty = "C:\\Users\\JBLFMU\\Desktop\\newWorkspace\\chromedriver.exe";
	  public String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();


 @Test
  public void testLogin() throws Exception {
	 baseUrl = "http://172.16.0.133:8000/";
	 System.setProperty(webdriver, setproperty);
	 driver = new ChromeDriver();
	 ChromeOptions options = new ChromeOptions();
	 options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 driver.get(baseUrl + "satellite/user/login");
	 driver.findElement(By.xpath("//button[@type='submit']")).click();
	 driver.findElement(By.id("username")).clear();
	 driver.findElement(By.id("username")).sendKeys("rosbel.clc@gmail.com");
	 driver.findElement(By.id("password")).clear();
	 driver.findElement(By.id("password")).sendKeys("admin1");
   	 driver.findElement(By.xpath("//button[@type='submit']")).click();
  }

 @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
   
    }  
}