package TestNGPack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Page.ForgotPassPage;
import Page.LoginPage;
import Utils.Utility;
import browerSetup.Base;

public class VerifyForgotPasswodPage extends Base
{
	   WebDriver driver;
	   String testID;
	   ForgotPassPage forgotPassPage;
	   LoginPage loginPage;
	   SoftAssert soft;
	  
	   @Parameters ("browser")
	   @BeforeTest
	   public void  openBrowser( String browserName){
		   if (browserName.equals("Chrome"))
		   {
		   driver = openChromeBrowser();
		   }
		   if (browserName.equals("Firefox"))
		   {
			driver = openFirefoxBrowser();
		   }
		   if (browserName.equals("Opera"))
		   {
			driver = openFirefoxBrowser();
		   }
		   
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(20000,TimeUnit.MILLISECONDS);
		   
		    driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(20000,TimeUnit.MILLISECONDS);
		   
		    driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(20000,TimeUnit.MILLISECONDS);
	   }
	   @BeforeClass
	   public void beforeclass() {
		   System.out.println("Before Class");
		   loginPage = new LoginPage(driver);
		   loginPage.clickOnForgotPasswoed();
		   forgotPassPage = new ForgotPassPage(driver);
		   
		  
	   }
	  	   @BeforeMethod
	   public void goToForgotPasswodPage() {
		   System.out.println("Before Method");
		   driver.get("https://www.facebook.com/");
		   soft= new SoftAssert();
	   }
	   
	   @Test (priority=1 )

	   public void verifyMessageOnForgotPasswordPage() 
	   {
		   testID="T101";
		   System.out.println("Test1");
           String actualMsg = forgotPassPage.getTextMessage();
           String expectedMsg = "Please enter your email address or mobile number to search for your account.";
           Assert.assertEquals(actualMsg, expectedMsg);
	   }
	   
	   @Test(priority = 2)
	   public void verifyCancleButtonForgotPasswardPage()
	   {
		   testID="T102";

		   System.out.println("Test2");
		    forgotPassPage.clickOnSarchButton();
		    String expectedURL="https://www.facebook.com/login.php";
		    String expectedTitle="Log in to Facebook";
           String actualURL =driver.getCurrentUrl();
           String actualTitle=driver.getTitle();
           soft.assertEquals(actualTitle, expectedTitle);
           soft.assertEquals(actualURL, expectedURL);

	   }
	   @Test(priority=3)
	   public void veriffySearchFunctionOnForgotPasswordPage()
	   {
		   testID="T103";
            System.out.println("Test3");
		    forgotPassPage.sendMail();
		    forgotPassPage.clickOnSarchButton();
		    String actualData="ankita";
		    String exectedData="ankita";
		    Assert.assertEquals(actualData, exectedData);
		}
	   
	   @AfterMethod
	   public void logoutFromApplicatiion(ITestResult result) throws IOException
	   {
		   if(ITestResult.FAILURE == result.getStatus())
		   {
			 Utility.captureScreenshot(driver,testID);
		   }
		   System.out.println("After Method");
	   }
	  
	   @AfterClass()
	   public void afterClass() {
		   System.out.println("After Class");
		   
	   }
	   @AfterTest
	   public void  closedBrowser() {
		   System.out.println("After Test");
		   driver.quit();
	   }
}

