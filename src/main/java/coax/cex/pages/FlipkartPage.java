package coax.cex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import coax.cex.ui.FlipkartUI;
import coax.common.tools.Dropdown;
import coax.common.tools.Element;
import coax.common.tools.Waits;
import coax.common.tools.Window;

public class FlipkartPage extends FlipkartUI{

	public FlipkartPage(WebDriver driver) {
		super(driver);
	}

	public boolean VerifyFlipkartHomepage() {
		boolean isVerified = false;
		try {
			Waits.waitForSeconds(3);
			//isVerified=Waits.waitForElementDisappear(driver, eleCloseSignInModal);
			Element.click(eleCloseSignInModal);
			isVerified=Element.verifyElement(tabMen);
		} catch (Exception e) {
		    e.printStackTrace();
		}	
		System.out.println(isVerified);
		return isVerified;
	}

	public boolean mouseOverOnMenTab() {		
		return Element.mouseClick(driver, tabMen);
	}

	public boolean clickOnTshirts() {
		return Element.mouseClick(driver, eleTShirts);
	}
	
	public boolean verifyTShirt() {
		Waits.waitForElement(driver, eleTriprShirt);
		return  Element.verifyElement(eleTriprShirt);
	}
	
	public boolean performTShirt() {
		boolean isTshirtPerformed=false;
		try {
			Element.click(eleTriprShirt);
			Window.focusWindow(driver);
			mouseOverOnMenTab();
			clickOnTshirts();
			Waits.waitForElement(driver, eleTriprShirt);
			Element.click(eleTriprShirt);
			Window.focusWindow(driver);
			Waits.waitForSeconds(3);
			Window.closeWindow(driver);
			Waits.waitForSeconds(3);
			Window.closeWindow(driver);
			Waits.waitForSeconds(5);
		    isTshirtPerformed=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isTshirtPerformed;
	}

	public boolean checkSelectKeyword() {
		driver.navigate().to("http://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		Waits.waitForSeconds(3);
		WebElement selMulti=driver.findElement(By.id("multi-select"));
		Dropdown.selectMultipleText(driver, selMulti, "Florida","New Jersey");
		Waits.waitForSeconds(3);
		return true;
	}
	


}
