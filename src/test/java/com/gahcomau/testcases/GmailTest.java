/**
 * 
 */
package com.gahcomau.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gahcomau.base.BaseClass;
import com.gahcomau.pageobjects.GmailPage;

/**
 * @author user
 *
 */
public class GmailTest extends BaseClass{
	
	
	GmailPage gmailpage;
	

	@BeforeMethod
	public void setup() {
		launchGmail();
	}

	@AfterMethod

	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void GmailRegistrationMail() {
		
		gmailpage = new GmailPage();

		gmailpage.enterEmail(prop.getProperty("username"));
		
		gmailpage.enterPassword(prop.getProperty("gpassword"));
		
		// select email subject you want to click
		
		gmailpage.clickEmail("Login Credentials from");
		
		
	}
	
	
	

}
