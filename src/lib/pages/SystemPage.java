package lib.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SystemPage {

	@FindBy(linkText= "Log Out")
	private WebElement LogOutLink;
	
	@FindBy(xpath="//p[contains(@id,'This category contains help materials')]")
	private WebElement Description;
	
	WebDriver driver;
	
	public SystemPage(WebDriver driver) {
		this.driver = driver;
		Sleeper.sleepTightInSeconds(5);
		PageFactory.initElements(driver, this);
	}
	
	public String getDescription(){
		Description.getText();
		return Description.getText();
		
	}
	
}
