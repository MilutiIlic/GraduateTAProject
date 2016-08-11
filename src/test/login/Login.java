package test.login;

import org.testng.annotations.Test;

import lib.data.Property;
import lib.pages.CDDPage;
import lib.pages.HomePage;
import lib.pages.LoginPage;
import lib.pages.SearchResultPage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.annotations.AfterClass;

public class Login {

	private static WebDriver driver;

	boolean b = false;
	boolean isChecked = false;

	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchResultPage;
	CDDPage cddPage;
	String message;

	@Test
	public void f() {
		loginPage.typeUsername(Property.username).typePassword(Property.password);
		homePage = loginPage.clickOnLoginButton();
		
		message = homePage.getTextFromLogInfoLabel();

		// da pokupi sav tekst koji se nadje u njemu
		// mora da skladistimo informaciju i pravimo promenljivu string
		// kada je pokupimo mora da je ispisemo
		System.out.println(message);

		assert message.contains("You are logged in as") : "You are not logged in.";
		homePage.typeSearchValueIntoSearchField("career");
		searchResultPage = homePage.clickOnGoButton();
		cddPage = searchResultPage.clickOnCddLink();
		assert cddPage.isFirstCheckBoxSelected() : "Check box should be selected.";
		loginPage = cddPage.clickOnLogOutLink();
	
		cddPage.checkFirstCheckBox();
		isChecked = true;
		loginPage = cddPage.clickOnLogOutLink();
		System.out.println("Test passed");
	}

	@BeforeClass
	public void beforeClass() {
		// inicijalizacija drajvera
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		loginPage = new LoginPage(driver);
	}

	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
		if(isChecked){
		driver = new FirefoxDriver();
		loginPage = new LoginPage(driver);
		homePage = loginPage.clickOnLoginButton();
		/**
		message = homePage.getTextFromLoginInfoLabel();

		// da pokupi sav tekst koji se nadje u njemu
		// mora da skladistimo informaciju i pravimo promenljivu string
		// kada je pokupimo mora da je ispisemo
		System.out.println(message);
	*/
		assert message.contains("You are logged in as") : "You are not logged in.";
		homePage.typeSearchValueIntoSearchField("career");
		searchResultPage = homePage.clickOnGoButton();
		cddPage = searchResultPage.clickOnCddLink();
		assert cddPage.isFirstCheckBoxSelected() : "Check box should be selected.";
		cddPage.checkFirstCheckBox();
		loginPage = cddPage.clickOnLogOutLink();
		driver.quit();
		
		
		}
	}

}
