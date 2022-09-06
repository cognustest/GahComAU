/**
 * 
 */
package com.gahcomau.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gahcomau.actiondriver.Action;
import com.gahcomau.base.BaseClass;
import com.gahcomau.dataprovider.DataProviders;
import com.gahcomau.pageobjects.HomePage;
import com.gahcomau.servicepage.btecAssignmentHelp;
import com.gahcomau.utility.Log;

/**
 * @author user
 *
 */
public class ServicesMain_Topic extends BaseClass{
	
	HomePage homeservice;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod

	public void tearDown() {
		driver.quit();
	}
	
	@Test(dataProvider = "homepage1", dataProviderClass = DataProviders.class
			, description = "Verify all services >> Main>> Topic Topic are availble or not as per requirement ")
	public void ExcelHomePageMenuTest(String menuservice ,String mainservice , String servicetopic) throws Throwable {
		Log.info("Excel- User is trying to hover on the services");
		homeservice = new HomePage();
	
		homeservice.excelDemoServiceHover();
		Log.info("Retriving data from the Excel sheet");
		homeservice.excelDemoService(mainservice);
		//homeservice.excelDemoSubject(servicesubject);
		homeservice.excelDemoTopic(servicetopic);
		String currentUrl = Action.getCurrentURL(driver);
		System.out.println(currentUrl);
		
		
	}
	

}
