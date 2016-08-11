package lib.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CDDPage {

	@FindBy(xpath = "//input[contains(@title,'CDD Animation Scripts')]")
	private WebElement firstCheckBox;
	
	@FindBy(linkText= "Log Out")
	private WebElement LogOutLink;
	
	private WebDriver driver;
	//konstruktor
	public CDDPage(WebDriver driver){
		this.driver = driver;
		Sleeper.sleepTightInSeconds(5);
		PageFactory.initElements(driver,this);
	}
	
	/**
	 * Check on first check box
	 * @return {CDDPage}
	 */
	public CDDPage checkFirstCheckBox(){
		if(!isFirstCheckBoxSelected()){
		firstCheckBox.click();
		}
		Sleeper.sleepTightInSeconds(2);
		return this;
	}
	
	public CDDPage uncheckFirstCheckBox(){
		if(isFirstCheckBoxSelected()){
		firstCheckBox.click();
		}
		Sleeper.sleepTightInSeconds(2);
		return this;
	}
	/**
	 * Is first box selected
	 * @return boolean
	 */
	public boolean isFirstCheckBoxSelected(){
		String attributeValue = firstCheckBox.getAttribute("title");
		if(attributeValue.contains("Mark as not complete")){
			return true;
		}else return false;
	}
	
	/**
	 * Click on Log Out link to logout
	 * @return {LogIn}
	 */
	public LoginPage clickOnLogOutLink(){
		LogOutLink.click();
		Sleeper .sleepTightInSeconds(3);
		return new LoginPage(driver);
	}
	
	
}
