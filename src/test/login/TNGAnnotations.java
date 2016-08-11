package test.login;

import org.testng.annotations.Test;

import lib.data.Property;
import lib.pages.HomePage;
import lib.pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterClass;


public class TNGAnnotations {

	private static WebDriver driver;

	LoginPage loginPage;
	HomePage homePage;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		System.out.println("Before Class");
		driver = new FirefoxDriver();
		loginPage = new LoginPage(driver);
	}

	@BeforeMethod
	public void clearFields() {
		System.out.println("Before Method");
		loginPage.clearUsernameAndPasswordField();
	}

	@Test(dependsOnMethods = "NeuspesnoLogovanje", groups = "Login")
	public void NeuspesnoLogovanje1() {
		System.out.println("Test: NeuspesnoLogovanje1()");
		loginPage.typeUsername(Property.username);
		loginPage.typePassword("fdsffs");
		loginPage.clickOnLoginButtonInvalidData();
		String errorMessage = loginPage.getErrorMessage();
		System.out.println(errorMessage);
		assert errorMessage.contains("Invalid login") : "ERROR: You are logged in";
		System.out.println("Test passed");
	}

	@Test()
	public void NeuspesnoLogovanje() {
		System.out.println("Test: NeuspesnoLogovanje()");
		loginPage.typeUsername("nenad");
		loginPage.typePassword(Property.password);
		loginPage.clickOnLoginButtonInvalidData();
		String errorMessage = loginPage.getErrorMessage();
		System.out.println(errorMessage);
		assert errorMessage.contains("Invalid login") : "ERROR: You are logged in";
		System.out.println("Test passed");
	}

	@Test(dependsOnMethods = "NeuspesnoLogovanje1")
	public void UspesnoLogovanje() {
		System.out.println("Test: UspesnoLogovanje");
		loginPage.typeUsername(Property.username).typePassword(Property.password);
		
		homePage = loginPage.clickOnLoginButton();
		String message = homePage.getTextFromLogInfoLabel();
		System.out.println(message);
		assert message.contains("You are logged in as") : "You are not logged in. Test Failed.";
		
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		System.out.println("Usao u after class");
		driver.quit();
	}

}