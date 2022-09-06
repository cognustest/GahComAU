/**
 * 
 */
package com.gahcomau.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gahcomau.base.BaseClass;
import com.gahcomau.dataprovider.DataProviders;
import com.gahcomau.pageobjects.pages;

/**
 * @author user
 *
 */
public class turnitinad extends BaseClass{
	
	
	pages pg;

	
	@BeforeMethod
	public void setup() {
		launchApp();
		
		
	}

	@AfterMethod

	public void tearDown() {
		driver.quit();
	}
	
	
	
	@Test(dataProvider = "turnitin", dataProviderClass = DataProviders.class
			, description = "xyz")
	
	public void getTurnitinAd(String Links) {
		
		pg = new pages();
		
		pg.adturniClickonsitemap(Links);
		pg.getTurnitin();
		pg.back();
	}

}
