package test1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import lib.data.Property;
import lib.pages.HomePage;
import lib.pages.SystemPage;
import lib.pages.LoginPage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterClass;

public class DomaciTest2 {

	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	SystemPage systemPage;
	String message;

	
	
  @Test
  public void f() {
	  
	  System.out.println("Usao u test");
		homePage.clickOnEndavaUniversity();
		
		homePage.clickOnInternal();
		message = systemPage.getDescription();
		System.out.println(message);
		assert message.contains("This category contains help") : "Test failed";
		System.out.println("Test passed");
	
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before class  ");
	    driver = new FirefoxDriver();
		driver.manage().window().maximize();
		loginPage = new LoginPage(driver);
		
		loginPage.typeUsername(Property.username).typePassword(Property.password);
		Sleeper.sleepTightInSeconds(4);
	
		homePage = loginPage.clickOnLoginButton();
		message = homePage.getTextFromLogInfoLabel();
		System.out.println(message);

		assert message.contains("You are logged in as") : "You are not logged in. Test Failed";

	  	
	  
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("After class");
	  driver.quit();

	  
  }

}
