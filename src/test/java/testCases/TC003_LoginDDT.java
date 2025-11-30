package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*Data is valid - Login success - test pass - logout
 * data is valid - login failed - test failed 
 * 
 * Data is invalid - login success - test failed - logout
 * data is invalid - login failed - test passed
 */


public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="loginData" , dataProviderClass=DataProviders.class , groups="Datadriven")	//getting data from data provider methods
	public void Verify_loginDDT(String email , String pwd ,String exp)
	{
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.ClickMyAccount();
		hp.ClickLogin();
		
		//Login
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		//MyAccount
		MyAccountPage	macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
	
		
		/*Data is valid - Login success - test pass - logout
		 * data is valid - login failed - test failed 
		 * 
		 * Data is invalid - login success - test failed - logout
		 * data is invalid - login failed - test passed
		 */
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{
				Assert.assertTrue(true);
				macc.clickLogout();
			}
			else
			{
				Assert.assertTrue(false);
			}
		
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false); 
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
	}
		 
	
}
