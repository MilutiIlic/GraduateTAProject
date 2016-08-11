package lib.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lib.util.Wait;

public class Page {

	

	@FindBy(className = "logininfo")
	private WebElement loginInfoLabel;
	
	private WebDriver driver;
	
	public Page(WebDriver driver){
		this.driver = driver;
		waitForPageToBeLoaded(driver,loginInfoLabel,5);
		PageFactory.initElements(driver, this);
	}
	
	//get ne uzima parametre
		/** Get text form login info label
		 * @return {String}
		 */
		public String getTextFromLoginInfoLabel(){
			return loginInfoLabel.getText();
		
		}
		
		private void waitForPageToBeLoaded(WebDriver driver,WebElement element, int time){
		Wait.untilWebElementVisible(driver, loginInfoLabel, time);
		}
		
		
}
