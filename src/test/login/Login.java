package test.login;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.annotations.AfterClass;

public class Login {
	
	public static String username = "ivecluj1";
	public static String password = "IveParola2";
	
	public static String username1 = "ivecluj2";
	public static String password2 = "IveParola2";
	
	public static final String URL = "https://www.endavauniversity.com";
	
	private static WebDriver driver;
	
  @Test
  public void f() {
	  
	driver.findElement(By.id("username")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.id("loginbtn")).click();
	
	Sleeper.sleepTightInSeconds(5);
	String message = driver.findElement(By.className("logininfo")).getText();
	//da pokupi sav tekst koji se nadje u njemu
	// mora da skladistimo informaciju i pravimo promenljivu string
	//kada je pokupimo mora da je ispisemo
	System.out.println(message);
	
	assert message.contains("You are logged in as") : "You are not logged in.";
	System.out.println("Test passed");
  }
  @BeforeClass
  public void beforeClass() {
	  
	  driver = new FirefoxDriver();
	  driver.get(URL);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
