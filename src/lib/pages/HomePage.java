package lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	
	@FindBy(className = "shortsearchbox")
	private WebElement searhInputField;
	
	//@FindBy(css = "input[type = 'submit'][value='Go']")
	@FindBy(xpath="//input[contains(@value,'Go') and contains(@type,'submit')]")
	private WebElement goButton; 
	
	@FindBy(xpath="//a[contains(@title,'My Account')]")
	private WebElement MyAccount; 
	
	@FindBy(xpath="//a[contains(@title,'My Profile')]")
	private WebElement MyProfile; 
	
	@FindBy(xpath="//a[contains(@title,'Endava University')]")
	private WebElement EndavaUniversity; 
	
	@FindBy(xpath="//a[contains(@title,'Internal systems self help')]")
	private WebElement InternaSystemsSelfHelp; 
	
	//private By goBtn = new By.ByXPath("//input[contains(@value,'Go') and contains(@type,'submit')]");
	
	@FindBy(className = "logininfo")
	private WebElement loginInfoLabel;
	
	private WebDriver driver;

	
	
	//konstruktor nikada ne vraca
	public HomePage (WebDriver driver){
		this.driver = driver;
		Sleeper.sleepTightInSeconds(5);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Career Development Discussion")
	private WebElement cddLink;
	
	
	/**
	 * Type search value into searh field
	 * @param value string
	 * @return HomePage
	 */
	public HomePage typeSearchValueIntoSearchField(String value){
		searhInputField.sendKeys(value);
		return this;
	}
	
	public SearchResultPage clickOnGoButton(){
		//goButton.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", goButton);
		return new SearchResultPage(driver);
		
	}
	public String getTextFromLogInfoLabel(){
		loginInfoLabel.getText();
		return loginInfoLabel.getText();
	}
	
	public HomePage clickOnMyAccount(){
		MyAccount.click();
		return this;
	}
	
	
	public MyProfilePage clickOnMyProfile(){
		MyProfile.click();
		return new MyProfilePage(driver);
	}
	
	public HomePage clickOnEndavaUniversity(){
		EndavaUniversity.click();
		return this;
	}
	
	public HomePage clickOnInternal(){
		InternaSystemsSelfHelp.click();
		return this;
	}
}
