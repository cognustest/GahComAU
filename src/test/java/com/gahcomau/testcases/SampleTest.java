/**
 * 
 */
package com.gahcomau.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.gahcomau.base.BaseClass;
import com.gahcomau.pageobjects.HomePage;
import com.gahcomau.utility.ExtentManager;

/**
 * @author Cognus Technology
 *
 */
public class SampleTest extends BaseClass implements ITestListener{
	
	HomePage homepage;
	ExtentReports extent;
	ExtentTest test;
	ExtentManager manager;

	@BeforeMethod
	public void setup() {
		launchApp(); 
	}
	
	
	//@AfterMethod
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test
	//Calling the method click on get free quote button
	public void clickOnBtn() throws Throwable {
		
		homepage = new HomePage();
		extent = new ExtentReports();
		
		
		test =ExtentManager.test.log(Status.PASS, "Passsssss: ");

		test =ExtentManager.test.log(Status.PASS, "Passsssss: ");
		test =ExtentManager.test.log(Status.FAIL,MarkupHelper.createLabel("Test Case Failed", ExtentColor.RED));
		test =ExtentManager.test.log(Status.PASS,MarkupHelper.createLabel("Test Case Failed", ExtentColor.GREEN));
		
		test =ExtentManager.test.log(Status.SKIP,MarkupHelper.createLabel("Test Case Failed", ExtentColor.BLUE));
		test =ExtentManager.test.log(Status.ERROR,MarkupHelper.createLabel("Test Case Failed", ExtentColor.INDIGO));
		test =ExtentManager.test.log(Status.FATAL,MarkupHelper.createLabel("Test Case Failed", ExtentColor.AMBER));
		test =ExtentManager.test.log(Status.WARNING,MarkupHelper.createLabel("Test Case Failed", ExtentColor.RED));
		
		test =ExtentManager.test.log(Status.INFO,MarkupHelper.createLabel("Test Case Failed", ExtentColor.BLUE));
		
		homepage.getTitle();
	}


	
	
	
	
}
