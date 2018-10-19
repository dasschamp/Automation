package coax.flipkart.stepdefinitions;

import coax.cex.factory.TestBase;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import static org.junit.Assert.*;

public class FlipkartSteps {
	
private TestBase singleBase;
	
	public FlipkartSteps(TestBase singleBase) {
		this.singleBase=singleBase;
	}
	
	 @Given("^As I user able to see Flipkart home page$")
	    public void as_i_user_able_to_see_flipkart_home_page() throws Throwable {
	       assertTrue(singleBase.flipkart.VerifyFlipkartHomepage());
		      //assertTrue(singleBase.flipkart.checkSelectKeyword());
		      
	    }

	    @And("^I mouse over on Mens tab$")
	    public void i_mouse_over_on_mens_tab() {
	    	assertTrue(singleBase.flipkart.mouseOverOnMenTab());
	    }

	    @And("^I click on Tshirts$")
	    public void i_click_on_tshirts() {
	    	assertTrue(singleBase.flipkart.clickOnTshirts());
	    	assertTrue(singleBase.flipkart.verifyTShirt());
	    	assertTrue(singleBase.flipkart.performTShirt());
	    }

}
