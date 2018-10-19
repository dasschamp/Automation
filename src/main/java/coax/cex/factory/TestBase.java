package coax.cex.factory;

import org.openqa.selenium.WebDriver;

import coax.cex.pages.FlipkartPage;
import coax.cex.pages.LoginPage;

public class TestBase extends WebdriverFactory{

	public LoginPage loginPage;
	public FlipkartPage flipkart;
	
	protected static WebDriver instance;
	
	
	public TestBase() {
		getInstance();
		initPages();
	}

	// Lazy Initialization (If required then only)
	public static WebDriver getInstance() {

		if (instance == null) {
			// Thread Safe. Might be costly operation in some case
			synchronized (TestBase.class) {
				if (instance == null) {
					instance = WebdriverFactory.createDriver();
				}
			}
		}
		return instance;
	}
	
	private void initPages() {
		//loginPageAction = new LoginPageAction(driver);
		loginPage = new LoginPage(driver);
		flipkart = new FlipkartPage(driver);
		
	}
	
	

}
