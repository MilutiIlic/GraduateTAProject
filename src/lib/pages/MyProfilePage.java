package lib.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage {

	

	@FindBy(css = "a[href*='mailto']")
	private WebElement myemail;
	
	//@FindBy(xpath="//a[contains(@href,'mailto')]")
	//private WebElement MyEmail;
	
	@FindBy(linkText = "Career Development Discussion")
	private WebElement myarea;
	
	@FindBy(linkText= "Log Out")
	private WebElement LogOutLink;
	
	private WebDriver driver;
	
	public MyProfilePage(WebDriver driver) {
	
		this.driver = driver;
		Sleeper.sleepTightInSeconds(5);
		PageFactory.initElements(driver, this);
	}
	
	public String getTextForEmail(){
		myemail.getText();
		return myemail.getText();
	}
	
	public String getTextforMyArea(){
		myarea.getText();
		return myarea.getText();
	}
	
	public LoginPage clickOnLogOutLink(){
		LogOutLink.click();
		Sleeper .sleepTightInSeconds(3);
		return new LoginPage(driver);
	}
	
}
