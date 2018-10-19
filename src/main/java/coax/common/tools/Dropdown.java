package coax.common.tools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	static Logger log = LogManager.getLogger(Dropdown.class.getName());

	public static boolean selectByText(WebDriver driver, WebElement element, String strText) {
		boolean isTextSelected = false;

		try {
			Select sel = new Select(element);
			sel.selectByVisibleText(strText);
			isTextSelected = true;
		} catch (Exception e) {
			log.error(e);
		}

		return isTextSelected;
	}

	public static boolean selectByValue(WebDriver driver, WebElement element, String strText) {
		boolean isValueSelected = false;

		try {
			Select sel = new Select(element);
			sel.selectByValue(strText);
			isValueSelected = true;
		} catch (Exception e) {
			log.error(e);
		}

		return isValueSelected;
	}

	public static boolean selectByIndex(WebDriver driver, WebElement element, int index) {
		boolean isSelected = false;

		try {
			Select sel = new Select(element);
			sel.selectByIndex(index);
			isSelected = true;
		} catch (Exception e) {
			log.error(e);
		}

		return isSelected;
	}

	public static boolean selectMultipleText(WebDriver driver, WebElement element, String... strings) {
		boolean isSelected = false;

		try {
			Select sel = new Select(element);
			if (sel.isMultiple()) {
				for (String strText : strings) {
					sel.selectByVisibleText(strText);
				}
			}
			isSelected = true;
		} catch (Exception e) {
			log.error(e);
		}

		return isSelected;
	}
}
