package coax.cex.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import coax.cex.ui.LoginUI;
import coax.common.tools.Element;
import coax.common.tools.Waits;



public class LoginPage extends LoginUI {

	//static WebDriver driver = TestBase.getInstance();
	  
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	
	
	public boolean clickSearch() {
		
		boolean isSearchedClicked=false;
		try {
			Thread.sleep(5000);
			btnSearch.click();
			System.out.println(driver.getCurrentUrl());
			isSearchedClicked = true;
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return isSearchedClicked;
		
	}
	
	public boolean enterProduct(String strProduct) {
		
		try {
			Element.enterValue(driver, txtSearch, strProduct);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return true;
		
	}



	public boolean verfiyToolKitHomepage() {
		boolean isverfiyToolKitHomepage=false;
		
		Waits.waitForSeconds(5);
		Waits.waitForElement(driver, eleOneYrUpArrow);
		isverfiyToolKitHomepage=true;
		return isverfiyToolKitHomepage;
	}



	public boolean SortFundByOneYr() {
		boolean isSortFundByOneYr=false;
		String[] fundName = {"Aberdeen Capital", "ACS US Equity", "Aberforth UK Small Companies"};
		System.out.println(fundName.length);
		
		List<Float> sortFund = new ArrayList<Float>();
		for(int i=0;i<fundName.length;i++){
			
			WebElement btnDrop=driver.findElement(By.xpath("//td[contains(.,'"+fundName[i]+"')]/following::button[1]"));
			Element.mouseClick(driver, btnDrop);
			Waits.waitForSeconds(1);
			WebElement btnAdd=driver.findElement(By.xpath("//td[contains(.,'"+fundName[i]+"')]/following::a[@title='Add to My Funds'][1]"));
			Element.mouseClick(driver, btnAdd);
				
		}
		Waits.waitForSeconds(10);
		for(int i=0;i<fundName.length;i++){
		WebElement columnOneYr = driver.findElement(By.xpath("//td[contains(.,'"+fundName[i]+"')]/following::td[3][contains(@class,'1y')]"));
		
		  String temp;
		  temp=columnOneYr.getText().trim();
		  System.out.println(temp);
		  sortFund.add(Float.parseFloat(temp));
		}
		
		//Element.click(tabPortfolioMaster);
	
		//tr/descendant::button
		  //td[contains(.,'Aberdeen Capital')]/following::button[1]
		//td[contains(.,'Aberdeen Capital')]/following::a[@title='Add to My Funds'][1]
		
		//tr/descendant::td[5][contains(@class,"1y")]
		 
		
		  Collections.sort(sortFund);
		  
		  Element.click( eleOneYrUpArrow);
		  Waits.waitForSeconds(10);
		  List<WebElement> currentFundAsc = driver.findElements(By.xpath("//tr/descendant::td[5][contains(@class,'1y')]"));
		  
		  
		  for(int i=0;i<sortFund.size();i++){
			  
			  String strFundAsc=currentFundAsc.get(i).getText();
			  Float FundAsc=Float.parseFloat(strFundAsc);
			  System.out.println(FundAsc);
			  System.out.println(sortFund.get(i));
			  
	    	   if(FundAsc.equals(sortFund.get(i)))
	    			   {
	    		   
					System.out.println("Pass");
				}else{
					System.err.println("Fail");
				}
	    	   
	       }
		  
		     
		  Collections.sort(sortFund, Collections.reverseOrder());
		  
		  Element.mouseClick(driver, eleOneYrDpwnArrow);
		  List<WebElement> currentFundDsc = driver.findElements(By.xpath("//tr/descendant::td[5][contains(@class,'1y')]"));
		  
		  for(int i=0;i<sortFund.size();i++){
			  
			  String strFundAsc=currentFundDsc.get(i).getText();
			  Float FundDsc=Float.parseFloat(strFundAsc);
			  System.out.println(FundDsc);
			  System.out.println(sortFund.get(i));
			  
	    	   if(FundDsc.equals(sortFund.get(i)))
	    			   {
	    		   
					System.out.println("Pass");
				}else{
					System.err.println("Fail");
				}
	    	   
	       }
		  
	
		  isSortFundByOneYr=true;
		return isSortFundByOneYr;
	}

}
