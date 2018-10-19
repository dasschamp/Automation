package coax.common.tools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import coax.common.util.ExcelUtil;

public class Element {

	static Logger log = LogManager.getLogger(Element.class.getName());

	public static boolean enterValue(WebDriver driver, WebElement element, String strValue) {
		boolean isValueEntered = false;
		try {
			strValue = ExcelUtil.getData(strValue);
			element.clear();
			element.click();
			element.sendKeys(strValue);

			isValueEntered = true;
		}

		catch (Exception e) {
			log.error(e);
		}

		return isValueEntered;
	}

	public static boolean click(WebElement element) {
		boolean isElementClicked = false;

		try {
			if (element.isDisplayed() && element.isEnabled()) {
				element.click();
				isElementClicked = true;
			}
		} catch (Exception e) {
			log.error(e);
		}

		return isElementClicked;
	}

	public static boolean mouseOver(WebDriver driver, WebElement element) {
		boolean isMouseOvered = false;

		try {
			if (element.isDisplayed() && element.isEnabled()) {
				Actions actions = new Actions(driver);
				actions.moveToElement(element).build().perform();
				isMouseOvered = true;
			}
		} catch (Exception e) {
			log.error(e);
		}

		return isMouseOvered;
	}

	public static boolean mouseClick(WebDriver driver, WebElement element) {
		boolean isElementClicked = false;

		try {
			if (element.isDisplayed() && element.isEnabled()) {
				Actions actions = new Actions(driver);
				actions.moveToElement(element).build().perform();
				Waits.waitForSeconds(1);
				actions.click(); 
				actions.build().perform();
				isElementClicked = true;
			}
		} catch (Exception e) {
			log.error(e);
		}

		return isElementClicked;
	}

	public static boolean verifyElement(WebElement element) {
		boolean isElementVerfied = false;

		try {
			if (element.isDisplayed()) {
				isElementVerfied = true;
			}
		} catch (Exception e) {
			log.error(e);
		}

		return isElementVerfied;
	}

}
