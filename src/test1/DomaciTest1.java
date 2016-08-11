package test1;

import org.testng.annotations.Test;

import lib.data.Property;
import lib.pages.HomePage;
import lib.pages.LoginPage;
import lib.pages.MyProfilePage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class DomaciTest1 {
	
	private WebDriver driver;
	LoginPage loginPage;
	HomePage homepage;
	MyProfilePage myProfilePage;
	String message;
	
	
	  @BeforeClass
	  public void beforeClass() {
		  
		  System.out.println("Usao u before class");
			driver = new FirefoxDriver();
			loginPage = new LoginPage(driver);
			driver.manage().window().maximize();

			loginPage.typeUsername(Property.username);
			loginPage.typePassword(Property.password);
			homepage = loginPage.clickOnLoginButton();

			message = homepage.getTextFromLogInfoLabel();
			System.out.println(message);

			assert message.contains("You are logged in as") : "You are not logged in. Test Failed.";

			homepage.clickOnMyAccount();
			homepage.clickOnMyProfile();

			System.out.println("Test passed");
		  
		  
	  }	
	
	
  @Test(dependsOnMethods = "test1")
  public void test() {
	  
	  	System.out.println("Usao u test verify email");

		message = myProfilePage.getTextForEmail();

		assert message.contains(Property.email) : "Test failed";
		System.out.println("Test passed");
	  
  }
  
  @Test
  public void test1(){
	  
	  System.out.println("Usao u test verify career");

		message = myProfilePage.getTextforMyArea();

		assert message.contains(Property.textCareer) : "Test failed";
		System.out.println("Test passed");
	  
  }
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }



  @AfterClass
  public void afterClass() {
	  System.out.println("Usao u after class");
		myProfilePage.clickOnLogOutLink();
		System.out.println("Test passed");
		driver.quit();
	  
  }

}
