package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Module.SignUpPopUP;
import Page.LoginPage;

public class Test3 
{
     public static void main(String[] args) throws InterruptedException 
     {
    	 System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Documents\\Automation\\Selenium\\chromedriver_win32\\chromedriver.exe");	
		   WebDriver driver = new ChromeDriver();
		   driver.get("https://www.facebook.com/");
		   Thread.sleep(3000);
		   
		   LoginPage loginPage= new LoginPage(driver);
		   loginPage.clickOnCreateNewAcc();
		   Thread.sleep(3000);

		   SignUpPopUP signUpPopUP= new SignUpPopUP(driver);
		   signUpPopUP.sendFirstName();
		   signUpPopUP.sendLastName();
		   signUpPopUP.sendMailId();
		   signUpPopUP.sendReMailId();
		   signUpPopUP.sendPassword();
		   signUpPopUP.seletDayDOB();
		   signUpPopUP.seletMonthDOB();
	       signUpPopUP.seletYearDOB();
	       signUpPopUP.seletFemale();
	       signUpPopUP.clickSubmit();
	       
	 }
}
