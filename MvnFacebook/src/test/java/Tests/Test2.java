package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Page.ForgotPassPage;
import Page.LoginPage;

public class Test2
{
      public static void main(String[] args) throws InterruptedException 
      {
	   System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Documents\\Automation\\Selenium\\chromedriver_win32\\chromedriver.exe");	
	   WebDriver driver = new ChromeDriver();
	   driver.get("https://www.facebook.com/");
	   Thread.sleep(3000);
	   
	   LoginPage loginPage= new LoginPage(driver);
	   loginPage.clickOnForgotPasswoed();

	   ForgotPassPage forgotPassPage= new ForgotPassPage(driver);
	   forgotPassPage.sendMail();
	   forgotPassPage.clickOnSarchButton();
	   
}
}