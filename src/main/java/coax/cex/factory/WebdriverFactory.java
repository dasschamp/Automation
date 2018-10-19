package coax.cex.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import coax.common.util.Browser;


public class WebdriverFactory {
	
	protected static WebDriver driver;

	public static WebDriver createDriver() {
		
	    try {
	    	driver=Browser.getLocalBrowser();
		}

		catch (WebDriverException e) {
			System.out.println("WebDriverException: " + e.getMessage());
		}

		finally {
			Runtime.getRuntime().addShutdownHook(new Thread(new cleanUp()));			
		}
		return driver;
		
	}
	
	private static class cleanUp implements Runnable {
		public void run() {
			System.out.println("Cleaning up the browser");
			try {
				driver.quit();
			} catch (NullPointerException e) {
				System.out.println("Browser already shut down.");
			}
		}
	}
	

}
