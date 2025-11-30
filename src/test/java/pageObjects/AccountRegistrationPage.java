	package pageObjects;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
@FindBy(xpath="//input[@id='input-firstname']")	
WebElement txtFirstname;	
	
@FindBy(xpath="//input[@id='input-lastname']")	
WebElement	txtLastname;

@FindBy(xpath="//input[@id='input-email']")	
WebElement txtEmail;

@FindBy(xpath="//input[@id='input-telephone']")
WebElement	txtPhone;

@FindBy(xpath="//input[@id='input-password']")
WebElement	txtPassword;

@FindBy(xpath="//input[@id='input-confirm']")
WebElement	txtconPassword;

@FindBy(xpath="//input[@name='agree']")
WebElement	chkPolicy;

@FindBy(xpath="//input[@value='Continue']")
WebElement	btnContinue;

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement	msgConfirmation;


public void	setFirstName(String fname)
	{
		txtFirstname.sendKeys(fname);
	}

public void setLastName(String lname)
	{
		txtLastname.sendKeys(lname);
	}

public void setEmail(String Email)
	{
		txtEmail.sendKeys(Email);
	}

public void setTele(String Phone)
	{
		txtPhone.sendKeys(Phone);
	}

public void SetPassword(String	pwd)
	{
		txtPassword.sendKeys(pwd);
	}

public void SetConPassword(String	Conpwd)
	{
		txtconPassword.sendKeys(Conpwd);
	}

public void setPolicy()
	{
		chkPolicy.click();
	}

public void ClickContinue()
	{
		//	sol.1
		btnContinue.click();
	
		
		//	sol.2
		//btnContinue.submit();

		
		//sol.3
		//Actions act=new Actions(driver);
		//act.moveToElement(btnContinue).click().perform();
		
		//sol.4
		//JavaScriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click;", btnContinue)	
		
		//sol.5
		//btnContinue.sendkeys(Keys.RETURN);

		//sol.6
		//WebDriverWait mywait=new WebDriverWait(Duration.of Seconds(10));
		//mywait.until(ExpectedConditions.ElementsToBeClickable(btnContinue)).click;

	}

public String getConfirmationMsg()
	{
	try {
		return	msgConfirmation.getText();
		}
	catch	(Exception e)
		{
			return e.getMessage();
		}
		
	
}









}	
