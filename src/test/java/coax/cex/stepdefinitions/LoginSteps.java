package coax.cex.stepdefinitions;

import coax.cex.factory.TestBase;
import coax.common.util.ExcelUtil;

import static org.junit.Assert.assertTrue;

import cucumber.api.java.Before;
import cucumber.api.java.en.*;

public class LoginSteps {

	private TestBase singleBase;

	public LoginSteps(TestBase singleBase) {
		this.singleBase = singleBase;
	}

	@Before("@Login")
	public void beforeScenario() {
		ExcelUtil.setExcelFile("Book.xlsx", "Login");
	}

	@Given("^As a user I want to see the login page$")
	public void as_a_user_I_want_to_see_the_login_page() {
		assertTrue(singleBase.loginPage.clickSearch());

	}

	@Given("^I enter the (.*) in the search box$")
	public void i_enter_the_in_the_search_box(String strProduct) {
		System.out.println(strProduct);
		assertTrue(singleBase.loginPage.enterProduct(strProduct));
	}

	@Given("^As a user I want to see the Toolkit page$")
	public void as_a_user_i_want_to_see_the_toolkit_page() {
		singleBase.loginPage.verfiyToolKitHomepage();
	}

	@When("^I download the funds$")
	public void i_download_the_funds()  {
		
	}

	@Then("^I see the funds downloaded in specified path$")
	public void i_see_the_funds_downloaded_in_specified_path()  {

	}

	@And("^I sort the Fund table$")
	public void i_sort_the_fund_table()  {
		assertTrue(singleBase.loginPage.SortFundByOneYr());
	}

	@And("^I export the funds$")
	public void i_export_the_funds() {
		
	}

}
