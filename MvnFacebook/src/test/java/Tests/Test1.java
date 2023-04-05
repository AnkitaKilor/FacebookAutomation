package Tests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Page.LoginPage;

public class Test1
{
      public static void main(String[] args) throws InterruptedException
      {
    	  System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Documents\\Automation\\Selenium\\chromedriver_win32\\chromedriver.exe");	
		   WebDriver driver = new ChromeDriver();
		   driver.manage().timeouts().implicitlyWait(20000,TimeUnit.MILLISECONDS);
		   driver.get("https://www.facebook.com/");
		   Thread.sleep(3000);
		   
		   LoginPage loginPage= new LoginPage(driver);
		   loginPage.sendUserName();
		   loginPage.sendPassword();
		   loginPage.clickOnLoginButton();
	  }
}
