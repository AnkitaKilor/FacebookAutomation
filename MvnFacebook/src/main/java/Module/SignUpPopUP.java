package Module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPopUP 
{
	@FindBy(xpath="//input[@name='firstname']") 
    private WebElement firstname;
    
    @FindBy(xpath="//input[@name='lastname']") 
    private WebElement lastname;
    
    @FindBy(xpath="//input[@name='reg_email__']") 
    private WebElement registerMailid;
    
    @FindBy(xpath="//input[@aria-label='Re-enter email address']") 
    private WebElement reMailid;
    
    @FindBy(xpath="//input[@name='reg_passwd__']") 
    private WebElement newPassword;
        
    @FindBy(xpath="//select[@aria-label='Day']") 
    private WebElement dayDOB;
    
    @FindBy(xpath="//select[@aria-label='Month']") 
    private WebElement monthDOB;
    
    @FindBy(xpath="//select[@aria-label='Year']") 
    private WebElement yearDOB;
    
    @FindBy(xpath="//input[@type='radio'][1]") 
    private WebElement female;
    
    @FindBy(xpath="//button[@name='websubmit']") 
    private WebElement submit;
    
    @FindBy(xpath="//div[text()='Please choose a gender. You can change who can see this later.']") 
    private WebElement genderErrorMsg;
    
    @FindBy(xpath="(//button[text()='Sign Up'])[1]") 
    private WebElement textSignUp;
    
    public SignUpPopUP(WebDriver driver) {
    	PageFactory.initElements(driver,this);
    }
    public String errorMsgGender() {
    	return genderErrorMsg.getText();
    }
    
     public String getTextButton() {
    	return textSignUp.getText();
    }
    
    
    public void sendFirstName() {
    	firstname.sendKeys("Aditi");
    }
    public void sendLastName() {
    	lastname.sendKeys("Sharma");
    }
    public void sendMailId() {
    	registerMailid.sendKeys("ankitakilor@gmail.com");
    }
    public void sendReMailId() {
    	reMailid.sendKeys("ankitakilor@gmail.com");
    }
    public void sendPassword() {
    	newPassword.sendKeys("Ankit@123");
    }
    
    public void seletDayDOB() {
    	Select select = new Select(dayDOB);
    	select.selectByValue("3");
    }
    public void seletMonthDOB() {  
		Select  select= new Select(monthDOB);
         select.selectByValue("6");
    }
    public void seletYearDOB() {     
    	Select  select= new Select(yearDOB);
        select.selectByVisibleText("1998");  
     }
    public void seletFemale() {     
    	female.click();
    }
    public void clickSubmit() {     
    	submit.click();
    }
}

    
    
