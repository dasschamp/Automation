package coax.flipkart;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		  features = "test/resources/features/flipkart/Flipkart.feature"
		  )

public class FlipkartCukesTest {
	

}
