package test1;

import org.testng.annotations.Test;

import lib.data.Property;
import lib.pages.CDDPage;
import lib.pages.HomePage;
import lib.pages.LoginPage;
import lib.pages.MyProfilePage;
import lib.pages.SearchResultPage;
import lib.util.Prepare;
import lib.util.Verification;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class MyAccountTest {
	
	private WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchResult;
	CDDPage cddPage;
	MyProfilePage myProfilePage;
	String message;

	@BeforeClass
	public void beforeClass() {	
		try {
			System.out.println("---Before Class");
			driver = Prepare.chromeDriver();
			
			System.out.println("---Step: Open login page");
			loginPage = new LoginPage(driver);
			
			System.out.println("---Step: Login");
			loginPage.typeUsername(Property.username).typePassword(Property.password);
			homePage = loginPage.clickOnLoginButton();
			  
			System.out.println("---Step: Verify successful login");
			message = homePage.getTextFromLoginInfoLabel();
			Verification.verifyString(Property.loginMessage, message, "Verify login");
			
			System.out.println("---Step: Go to my profile page");
			homePage.clickOnMyAccount();
			myProfilePage = homePage.clickOnMyProfile();
		} catch (Exception e) {
			throw e;
		}		
	}

	@Test(dependsOnMethods = "verifyArea")
	public void verifyProfileAccount() {		
		try {
			System.out.println("--Test: verifyProfileAccount");		
			message = myProfilePage.getEmailAdress();
			Verification.verifyString(Property.area, message, "Verify area of expertise");
			System.out.println("--Test passed");
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Test
	public void verifyArea(){		
		try {
			System.out.println("---Test: verifyDescription");	
			message = myProfilePage.getAreaLabel();
			Verification.verifyString(Property.area, message, "Verify category description");
			System.out.println("---Test passed");
		} catch (Exception e) {
			throw e;
		}
	}

	@AfterClass
	public void afterClass() {	
		
		System.out.println("---After Class");	
		System.out.println("---Step: Log out");
		loginPage = myProfilePage.clickOnLogOutLink();
		
		System.out.println("---Step: Kill driver");
		driver.quit();	
	}
}