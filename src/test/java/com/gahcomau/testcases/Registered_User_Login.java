/**
 * 
 */
package com.gahcomau.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gahcomau.base.BaseClass;
import com.gahcomau.pageobjects.DashboardPage;
import com.gahcomau.pageobjects.HomePage;
import com.gahcomau.pageobjects.LoginPage;

/**
 * @author user
 *
 */
public class Registered_User_Login extends BaseClass{
	
	HomePage homepage;
	LoginPage loginpage;
	DashboardPage dashboardpage;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod

	public void tearDown() {
		driver.quit();
	}

	@Test
	public void RegisteredUsersLogin() throws Throwable {
		
		loginpage = new LoginPage();
		dashboardpage = new DashboardPage();
		homepage = new HomePage();
		
		
		loginpage.clicklogin();
		loginpage.getSubHeading();
		loginpage.GoogleBtn();
		loginpage.FacebookBtn();
		loginpage.enterEmail(prop.getProperty("username"));
		
		loginpage.clickContinueWithEmail();	
		
		loginpage.enterPassword(prop.getProperty("password"));
		
		loginpage.eyeIcon();
		
		loginpage.ForgotPassword();
		dashboardpage=loginpage.LoginBtn();
		dashboardpage.url();
		dashboardpage.myCart();
		Assert.assertEquals("https://customerpanel.globalassignmenthelp.com/dashboard", dashboardpage.url());
	}
	
	

}
