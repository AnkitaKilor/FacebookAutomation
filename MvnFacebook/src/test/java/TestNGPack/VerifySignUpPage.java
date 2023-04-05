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



import Module.SignUpPopUP;

import Page.LoginPage;
import Utils.Utility;
import browerSetup.Base;

public class VerifySignUpPage extends Base
{
	   WebDriver driver;
	   String testID;
	   LoginPage loginPage;
	   SignUpPopUP signUpPopUP;
	   
	  @Parameters("browser")
	  @BeforeTest
	  public void openBrowser(String browserName) {
		 
			  if (browserName.equals("Chrome"))
			   {
			   driver = openChromeBrowser();
			   }
			   if (browserName.equals("Firefox"))
			   {
				driver = openFirefoxBrowser();
			   }
			   
		  
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(20000,TimeUnit.MILLISECONDS);
	   }
	  
	 @BeforeClass
	   public void beforeClass() {
		   System.out.println("Before Class");
		
	   }
	 
	   @BeforeMethod
	   public void goToSignUpPage() {
		   System.out.println("Before Method");
		   driver.get("https://www.facebook.com/");
		   loginPage = new LoginPage(driver);
		   loginPage.clickOnCreateNewAcc();
		   signUpPopUP = new SignUpPopUP(driver);
		   
	   }
	   @Test(priority=1)
	   public void verifySignInFunctionality() {
		   testID="T301";
		   System.out.println("Test A");
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
	       String actualData=signUpPopUP.getTextButton();
	       String expectedData="Sign Up";
	       Assert.assertEquals(actualData, expectedData);
	   }
	   @Test(priority=2)
	   public void verifyErrorMessagePresentonSignUpPopUp() {
		  testID="T302";
		   System.out.println("Test B");
		   signUpPopUP.sendFirstName();
		   signUpPopUP.sendLastName();
		   signUpPopUP.sendMailId();
		   signUpPopUP.sendReMailId();
		   signUpPopUP.sendPassword();
		   signUpPopUP.seletDayDOB();
		   signUpPopUP.seletMonthDOB();
		   signUpPopUP.seletYearDOB();
		   signUpPopUP.clickSubmit();
	       String xpectedData="Please choose a gender. You can change who can see this later.";
	       String actualData=signUpPopUP.errorMsgGender();
	       boolean result= actualData.equals(xpectedData);
	       Assert.assertTrue(result);
	   }
	   @AfterMethod
	   public void logoutFromApplicatiion(ITestResult result) throws IOException {
		   if(ITestResult.FAILURE == result.getStatus())
		   {
			 Utility.captureScreenshot(driver ,testID);
		   }
		   
		  System.out.println("After Method");
	   }
	   @AfterClass()
	   public void afterClass() {
		   System.out.println("After Class");
	   }
	   @AfterTest()
		   public void closedBrowser() {
		   System.out.println("After Test");
		   driver.quit();
	   }
}
