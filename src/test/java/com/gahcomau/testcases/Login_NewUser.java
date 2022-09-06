/**
 * 
 */
package com.gahcomau.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.gahcomau.base.BaseClass;
import com.gahcomau.dataprovider.DataProviders;
import com.gahcomau.pageobjects.DashboardPage;
import com.gahcomau.pageobjects.HomePage;
import com.gahcomau.pageobjects.LoginPage;
import com.gahcomau.utility.ExtentManager;
import com.gahcomau.utility.Log;

/**
 * @author user
 *
 */
public class Login_NewUser extends BaseClass{
	
	LoginPage loginpage;
	DashboardPage dashboardpage;
	HomePage homepage;
	
	ExtentReports extent;
	ExtentTest test;
	ExtentManager manager;

	
	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod
	//@AfterMethod

	public void tearDown() {
		driver.quit();
	}

	@Test(dataProvider = "email", dataProviderClass = DataProviders.class
			,description = "Verify New User is Able to Sign-up or not ")
	public void LoginNewUsers(String emailId ) throws Throwable {
		
		
		loginpage = new LoginPage();
		dashboardpage = new DashboardPage();
		homepage = new HomePage();
		extent = new ExtentReports();
		
		
		test =ExtentManager.test.log(Status.PASS, "Verify New User is Able to Sign-up or not");

		
		loginpage.clicklogin();
		loginpage.getSubHeading();
		
		loginpage.GoogleBtn();
		loginpage.FacebookBtn();
		
		//********************************** please Change the random email id in the sheet ******** run once in week
		Log.info("User is entering email id");
		test =ExtentManager.test.log(Status.INFO, "User is entering email id");
		loginpage.enterEmail(emailId);		
		
		Log.info("User is clicking on the Continue with email btn");
		test =ExtentManager.test.log(Status.INFO, "User is clicking on the Continue with email btn");
		loginpage.clickContinueWithEmail();	
		loginpage.newUserName();	
		loginpage.getHeadingSignup();		
		loginpage.changemailButton();		
		loginpage.selectCountry();		
		loginpage.enterMobileNo();		
		loginpage.getTerms();	
		
		Log.info("User is redirecting to the DashboardPage");
		test =ExtentManager.test.log(Status.INFO, "User is redirecting to the DashboardPage");
		dashboardpage =loginpage.clickRegister();
		
		dashboardpage.url();	
		dashboardpage.myCart();
		dashboardpage.emptyCart();
		dashboardpage.profileDropdown();
		homepage = dashboardpage.clicklogout();
		homepage.getTitle();
		
	}
	
	
	
}
