package coax.common.tools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Window {
	
	static Logger log = LogManager.getLogger(Window.class.getName());
	
    public static boolean focusWindow(WebDriver driver){
        boolean isSwitchedToWindow=false;
        
        try{
        	for (String winHandle : driver.getWindowHandles()) {
        	    driver.switchTo().window(winHandle);
        	}
        	
        	isSwitchedToWindow=true;
        }
        catch(Exception e){
        	log.error(e);
        }
        return isSwitchedToWindow;
    }
    
    public static boolean closeWindow(WebDriver driver){
        boolean isSwitchedToWindow=false;
        
        try{   	
        	driver.close();
        	focusWindow(driver);      	
        	isSwitchedToWindow=true;
        }
        catch(Exception e){
        	log.error(e);
        }
        return isSwitchedToWindow;
    }
    
    public static boolean switchToParentWindow(WebDriver driver){
        boolean isSwitchedToWindow=false;
        
        try{   	
        	String strWindowHandle=driver.getWindowHandles().toArray()[0].toString();
        	driver.switchTo().window(strWindowHandle);
        	isSwitchedToWindow=true;
        }
        catch(Exception e){
        	log.error(e);
        }
        return isSwitchedToWindow;
    }

    public static boolean switchToFrame(WebDriver driver,WebElement element){
        boolean isSwitchedToWindow=false;
        
        try{   	
        	WebDriverWait wait = new WebDriverWait(driver, 5);
        	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        	isSwitchedToWindow=true;
        }
        catch(Exception e){
        	log.error(e);
        }
        return isSwitchedToWindow;
    }
    
    

}
