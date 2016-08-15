package test1;

import org.testng.annotations.Test;

import lib.data.Property;
import lib.pages.CDDPage;
import lib.pages.HomePage;
import lib.pages.InternalSystemPage;
import lib.pages.LoginPage;
import lib.pages.MyProfilePage;
import lib.pages.SearchResultPage;
import lib.util.Prepare;
import lib.util.Verification;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class DescriptionTest {

	private WebDriver driver;
	
	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchResult;
	CDDPage cddPage;
	MyProfilePage myProfilePage;
	InternalSystemPage internalSystemPage;
	
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
		} catch (Exception e) {
			throw e;
		}
	}

	@Test
	public void descriptionCheck() {
		try {
			System.out.println("---Test: endavaUniversity");
			System.out.println("---Step: Go to internal system page");
			homePage.clickOnEndavaUniversity();
			internalSystemPage = homePage.clickOnInternalSystemSelfHelpLink();
			message = internalSystemPage.getParagraphDescription();
			Verification.verifyString(Property.description, message, "Verify description");
			System.out.println("---Test passed");
		} catch (Exception e) {
			throw e;
		}
	}

	@AfterClass
	public void afterClass() {
		System.out.println("---After Class");
		driver.quit();
	}

}