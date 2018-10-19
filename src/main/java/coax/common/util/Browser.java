package coax.common.util;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Browser {
	
	static Logger log = LogManager.getLogger(Browser.class.getName());

	private static String strExecutionConfig = new StringBuilder().append(Constants.RESOURCES_FOLDER)
			.append(File.separator).append(Constants.CONFIG_FOLDER).append(File.separator)
			.append(Constants.EXECUTION_FILE).toString();

	static {
		ConfigLoader.loadConfig(strExecutionConfig);	
	}

	public static WebDriver getLocalBrowser() {
		WebDriver driver = null;

		try {
			String strbrowser = ConfigLoader.getValue("browser");

			if (strbrowser.equalsIgnoreCase(Constants.CHROME)) {
				System.setProperty("webdriver.chrome.driver", getBrowserDriverPath("chrome"));
				driver = new ChromeDriver();
			} else if (strbrowser.equalsIgnoreCase(Constants.EDGE)) {
				System.setProperty("webdriver.edge.driver", getBrowserDriverPath("edge"));
				driver = new EdgeDriver();
			} else if (strbrowser.equalsIgnoreCase(Constants.FIREFOX)) {
				System.setProperty("webdriver.gecko.driver", getBrowserDriverPath("firefox"));
				driver = new FirefoxDriver();
			}

			
			long lngPageLoad = Long.parseLong(ConfigLoader.getValue("pageLoadTime"));
			long lngScriptLoad = Long.parseLong(ConfigLoader.getValue("scriptLoadTime"));
			long lngImplicitLoad = Long.parseLong(ConfigLoader.getValue("implicitWaitTime"));
			
			driver.manage().timeouts().pageLoadTimeout(lngPageLoad, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(lngScriptLoad, TimeUnit.SECONDS);
			
			driver.manage().window().maximize();
			driver.get(getEnviroment());
			
			driver.manage().timeouts().implicitlyWait(lngImplicitLoad, TimeUnit.SECONDS);
		}

		catch (Exception e) {
			log.error(e);
		}

		return driver;

	}

	private static String getBrowserDriverPath(String strBrowser) {
		String strDriverPath = null;

		try {
			if (strBrowser.equalsIgnoreCase("chrome")) {
				strDriverPath = Constants.CHROME_WINDOWS_DRIVER;
			} else if (strBrowser.equalsIgnoreCase("Edge")) {
				strDriverPath = Constants.EDGE_DRIVER;
			} else if (strBrowser.equalsIgnoreCase("firefox")) {
				strDriverPath = Constants.GECKO_DRIVER;
			}
		} catch (Exception e) {
			log.error(e);
		}

		return new StringBuilder().append(Constants.RESOURCES_FOLDER).append(File.separator)
				.append(Constants.DRIVERS_FOLDER).append(File.separator).append(strDriverPath).toString();
	}

	public static String getEnviroment() {

		String strURL = null;
		try {

			String strEnv = ConfigLoader.getValue("ENV");

			if (strEnv.equalsIgnoreCase("PROD")) {
				strURL = Constants.URL_PROD;
			} else if (strEnv.equalsIgnoreCase("DEV")) {
				strURL = Constants.URL_DEV;
			} else if (strEnv.equalsIgnoreCase("QA")) {
				strURL = Constants.URL_QA;
			}

		} catch (Exception e) {
			log.error(e);
		}
		return strURL;
	}

}
