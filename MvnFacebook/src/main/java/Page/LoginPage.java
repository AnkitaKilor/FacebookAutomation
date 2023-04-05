package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
        @FindBy(xpath="//input[@name='email']") 
        private WebElement userName;
        
        @FindBy(xpath="//input[@type='password']") 
        private WebElement password;
        
        @FindBy(xpath="//button[@name='login']") 
        private WebElement logIn;
        
        @FindBy(xpath="//a[text()='Forgotten password?']") 
        private WebElement forgotpass;
        
        @FindBy(xpath="//a[text()='Create new account']") 
        private WebElement createNewAcc;
        
        public LoginPage(WebDriver driver) {
        	PageFactory.initElements(driver,this);
        }
        
        public void sendUserName() {
        	userName.sendKeys("9764019362");
        }
        public void sendPassword() {
        	password.sendKeys("supriya13895");
        }
        
        public void clickOnLoginButton() {
        	logIn.click();
        }
        
        public void clickOnForgotPasswoed() {
        	forgotpass.click();
        }
        
        public void clickOnCreateNewAcc() {
        	createNewAcc.click();
        }

    }
