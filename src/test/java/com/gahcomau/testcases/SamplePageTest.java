/**
 * 
 */
package com.gahcomau.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gahcomau.base.BaseClass;
import com.gahcomau.dataprovider.DataProviders;
import com.gahcomau.pageobjects.SamplePage;

/**
 * @author user
 *
 */
public class SamplePageTest extends BaseClass{
	SamplePage sp;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod

	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void getabcdcounts() {
		sp= new SamplePage();
		
		sp.clickSampleMenu();
		sp.getabcdCatCount();
		sp.getTotalSampleMainCatHeading();
				
	}
	
	@Test(priority=2 , dataProvider = "sample", dataProviderClass = DataProviders.class
			, description = "Sample >> SampleListPage >>Sample Details Page ")
	public void SampleFlowTest(String sample_heading) {
		
		sp= new SamplePage();
		
		sp.clickSampleMenu();
		sp.sampleFlowTest(sample_heading);
		
	}
	
	@Test(priority=3 )
	public void SampleFlowTest3() {
		
		sp= new SamplePage();
		
		sp.clickSampleMenu();
		sp.sampletest3();
		
	}
	

}
