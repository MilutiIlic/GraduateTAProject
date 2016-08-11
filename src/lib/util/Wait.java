package lib.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	/**
	 * Wait until web element become visible.
	 * 
	 * @param driver
	 *            {WebDriver}
	 * @param webElement
	 *            {WebElement}
	 * @param time
	 *            {int}
	 */
	public static void untilWebElementVisible(WebDriver driver, WebElement webElement, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}

	/**
	 * Wait until web element become clickable.
	 * 
	 * @param driver
	 *            {WebDriver}
	 * @param webElement
	 *            {WebElement}
	 * @param time
	 *            {int}
	 */
	public static void untilWebElementClickable(WebDriver driver, WebElement webElement, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
	}
}
