package lib.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

	
	@FindBy(linkText = "Career Development Discussion")
	private WebElement cddLink;
	
	private WebDriver driver;
	public SearchResultPage(WebDriver driver){
		this.driver = driver;
		Sleeper.sleepTightInSeconds(5);
		PageFactory.initElements(driver, this);
	}
	public CDDPage clickOnCddLink(){
		cddLink.click();
		return new CDDPage(driver);
	}
}
