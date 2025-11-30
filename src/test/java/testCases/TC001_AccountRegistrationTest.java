package testCases;



import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {


	
	
	
	@Test(groups= {"Regression","Master"})
	public void verify_account_registration() throws InterruptedException
	{
		logger.info("*****starting TC001_AccountRegistrationTest****");		
		try
		{
		 HomePage	hp=new HomePage(driver);
		 hp.ClickMyAccount();
		 logger.info("*** Clicked on my account link ***");
		 
		 hp.ClickRegister();
		 logger.info("*** Clicked on Register link ***");
		 
		 
		 
		 AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		 logger.info("*** providing customer details***");
		 
		 
		 regpage.setFirstName(randomeString().toUpperCase());
		 regpage.setLastName(randomeString().toUpperCase());	
		
		 regpage.setEmail(randomeString()+"@gmail.com");
		 regpage.setTele(randomeNumber());
		 
		String	Password= 	randomeAlphaNumeric();
		 
		 regpage.SetPassword(Password);
		 regpage.SetConPassword(Password);
		 
		 Thread.sleep(1000);
		 regpage.setPolicy();
		 regpage.ClickContinue();
		 
		 
		 logger.info("*** validating expected message***");	 
		String confmsg=	 regpage.getConfirmationMsg();
			 
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		
		else
		{
			logger.error("test failed...");
			logger.debug("debug logs...");
			Assert.assertTrue(false);
		}
		
		Assert.assertEquals(confmsg,"Your Account Has Been Created!");
		}
		catch(Exception e)	 
			{
			logger.error("test failed");
			logger.debug("Debug logs..");
			e.printStackTrace();
			Assert.fail();
			}
		
		logger.info("*****Finished TC0001_AccountRegistrationTest *****");
	
	}
	



}
