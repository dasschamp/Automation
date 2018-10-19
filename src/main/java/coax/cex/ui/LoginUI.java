package coax.cex.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginUI {
	protected final WebDriver driver;

	public LoginUI(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	     this.driver = driver;
	}
	
	@FindBy(how = How.ID, using = "search")
    protected static WebElement btnSearch;
	
	@FindBy(how = How.XPATH, using = "/descendant::input[@name='searchTerm'][last()]")
	protected static WebElement txtSearch;
	
	//https://toolkit.financialexpress.net/plusdigital
	@FindBy(how = How.XPATH, using = "//th[@id='GridColumn_1_42_42']/descendant::span[1]")
	protected static WebElement eleOneYrUpArrow;
	
	@FindBy(how = How.XPATH, using = "//th[@id='GridColumn_1_42_42']/descendant::span[2]")
	protected static WebElement eleOneYrDpwnArrow;
	
	
	@FindBy(how = How.ID, using = "PortfolioMasterTab")
	protected static WebElement tabPortfolioMaster;


}
