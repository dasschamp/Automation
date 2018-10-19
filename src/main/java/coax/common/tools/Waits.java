package coax.common.tools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coax.common.util.ConfigLoader;

public class Waits {
	
	static Logger log = LogManager.getLogger(Waits.class.getName());

	private static long lngWaitTime = Long.parseLong(ConfigLoader.getValue("objectWaitTime"));

	public static WebElement waitForElement(WebDriver driver, WebElement element) {

		return element = new WebDriverWait(driver, lngWaitTime).until(ExpectedConditions.visibilityOf(element));

	}

	public static boolean waitForElementDisappear(WebDriver driver, WebElement element) {

		boolean isElementDisappear = false;
		try {
			new WebDriverWait(driver, lngWaitTime).until(ExpectedConditions.invisibilityOf(element));
			isElementDisappear = true;
		} catch (Exception e) {
			log.error(e);
		}

		return isElementDisappear;

	}

	public static void waitForSeconds(long lngSeconds) {
		try {
			Thread.sleep(lngSeconds * 1000);
		} catch (Exception e) {
			log.error(e);
		}
	}
}
