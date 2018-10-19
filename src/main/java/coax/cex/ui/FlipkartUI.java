package coax.cex.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FlipkartUI {
	protected final WebDriver driver;

	public FlipkartUI(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	     this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//button[not(@type)]")
	protected static WebElement eleCloseSignInModal;
	
	@FindBy(how = How.XPATH, using = "//a[@title='Men']")
	protected static WebElement tabMen;

	@FindBy(how = How.XPATH, using = "//a[@title='T-Shirts']")
	protected static WebElement eleTShirts;
	
	@FindBy(how = How.XPATH, using = "//a[@title='Tripr Printed Men V-neck Multicolor T-Shirt']")
	protected static WebElement eleTriprShirt;
}
