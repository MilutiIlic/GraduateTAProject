package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterClass;

public class TestJedan {
	// instanca za driver
	private static WebDriver driver;
	private String URL;
	
	
  
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  URL = "http://www.google.com";
	  
  }
  
  @Test
  public void f() {
	  driver.get(URL);
	  driver.manage().window().maximize();
	  Sleeper.sleepTightInSeconds(10);
  }

  @AfterClass
  public void afterClass() {
  driver.close();
  }
  	
}
