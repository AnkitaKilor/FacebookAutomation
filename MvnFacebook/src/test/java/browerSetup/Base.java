package browerSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base
{
    public static WebDriver openChromeBrowser()
    {
    	 System.setProperty("webdriver.chrome.driver","src\\test\\resources\\browserFile\\chromedriver.exe");	
    	 WebDriver driver = new ChromeDriver();
		return driver;
    }
    public static WebDriver openFirefoxBrowser()
    {
    	System.setProperty("webdriver.gecko.driver","src\\test\\resources\\browserFile\\geckodriver.exe");	
    	WebDriver driver = new FirefoxDriver();
		return driver;
    }

    
}
