package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassPage
{
	
	 @FindBy(xpath="//table//div") 
     private WebElement textMessage;
     
     @FindBy(xpath="(//input[@name='email'])[2]") 
     private WebElement emailOrPhoneNuber;
     
     @FindBy(xpath="//button[text()='Search']") 
     private WebElement searchButton;
     
     @FindBy(xpath="//div[text()='Please enter your email address or mobile number to search for your account.']") 
     private WebElement getMessage;
     
     WebDriver driver;
     public ForgotPassPage(WebDriver driver) {
     	PageFactory.initElements(driver,this);
     }
     
     public void getattributeName() {
    	 textMessage.getText();
     }
     public void sendMail() {
    emailOrPhoneNuber.sendKeys("ankigmail.com");
     }
     
     public void clickOnSarchButton() {
    	 searchButton.click();
     }
     public String getTextMessage() {
    	String text= getMessage.getText();
		return text;
     }
}
