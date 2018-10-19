package coax.cex;


import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import coax.common.util.Constants;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(
		  features = "test/resources/features/cex/Login.feature",
		  tags = "@FundSort",
		  plugin = { "com.cucumber.listener.ExtentCucumberFormatter:test-output/report.html"}
		  )

public class LoginCukesTest {
	
	private static String strExtentConfig = new StringBuilder().append(Constants.RESOURCES_FOLDER)
			.append(File.separator).append(Constants.CONFIG_FOLDER).append(File.separator)
			.append(Constants.EXTENT_CONFIG).toString();
	
	@AfterClass
	public static void writeExtentReport(){
		Reporter.loadXMLConfig(strExtentConfig);
	}
	

}
