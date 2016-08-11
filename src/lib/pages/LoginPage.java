package lib.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lib.data.Property;

public class LoginPage{
	
@FindBy(id = "username" )
private WebElement usernameInputField;

@FindBy(id = "password" )
private WebElement passwordInputField;

@FindBy(id = "loginbtn" )
private WebElement loginButton;


@FindBy(className = "error")
private WebElement errorLabel;



private WebDriver driver;


public LoginPage(WebDriver driver){		
	this.driver = driver;
	driver.manage().window().maximize();
	driver.get(Property.URL);
	PageFactory.initElements(driver, this);		
}

/**
 * Type username into username input field
 * @param username {String}
 * @return {LoginPage}
 */
public LoginPage typeUsername(String username){
	usernameInputField.sendKeys(username);
	return this;
}
/**
 * Type password into password input field
 * @param password {String}
 * @return {LoginPage}
 */
public LoginPage typePassword(String password){
	passwordInputField.sendKeys(password);
	return this;
}
/** Click on Login button
 * @return {HomePage}
 */
public HomePage clickOnLoginButton(){
	loginButton.click();
	return new HomePage(driver);
}
/**
 * Get text from error label
 * @return {String}
 */
public String getErrorMessage(){
	return errorLabel.getText();
}
/**
 * Click on login button when invalid data provided
 * @return {LoginPage}
 */
public LoginPage clickOnLoginButtonInvalidData(){
	loginButton.click();
	return this;
}
/**
 * Clear username and password fields
 * @return {LoginPage}
 */
public LoginPage clearUsernameAndPasswordField(){
	usernameInputField.clear();
	passwordInputField.clear();
	return this;
}

}
