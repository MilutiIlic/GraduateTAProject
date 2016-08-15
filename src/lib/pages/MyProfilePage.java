package lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import lib.data.Property;

public class MyProfilePage extends Page{
	
	@FindBy(xpath = "//a[contains(@href, 'mailto')]")
	private WebElement emailLabel;
	
	@FindBy (linkText = "Career Development Discussion")
	private WebElement areaLabel;
	
	private By byEmailLabel = new By.ByXPath("//a[contains(@href, 'mailto')]");
	
	public MyProfilePage(WebDriver driver){
		super(driver);
		waitForPageToBeLoaded(driver, byEmailLabel, Property.TIME_SHORT);
	}
	
	/**
	 * Get text from email label
	 * @return {String}
	 */
	public String getEmailAdress(){		
		return emailLabel.getText();

	}
	/**
	 * Get text from area label
	 * @return{String}
	 */
	public String getAreaLabel(){		
		return areaLabel.getText();
	}
	
}