/**
 * 
 */
package com.gahcomau.testcases.HomePage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gahcomau.base.BaseClass;
import com.gahcomau.dataprovider.DataProviders;
import com.gahcomau.pageobjects.HomePage;
import com.gahcomau.pageobjects.OrderPage;
import com.gahcomau.utility.Log;

/**
 * @author user
 *
 */
public class GetFreeQuote_HomePage extends BaseClass {

	HomePage homepage;
	OrderPage orderpage;

	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod

	public void tearDown() {
		driver.quit();
	}

	// providing data with the help of the excel sheet

	@Test(dataProvider = "management", dataProviderClass = DataProviders.class ,
			description = "Verify New User is Able to add order from get free quote section or not ")
	public void dropdowntest(String selectsubject, String selectservice , String selectpages) {
		Log.startTestCase("dropdowntest");
		homepage = new HomePage();
		orderpage = new OrderPage();
		Log.info("Getting the Title ");
		homepage.getTitle();

		Log.info("Clicking on the service Button");
		homepage.clickOnSelectServicesBtn();

		// Change Number for selecting service here
		Log.info("User is selecting the service");
		homepage.selectServices(selectservice);

		Log.info("user is clicking on the subject ");
		homepage.clickOnSelectSubjectBtn();

		Log.info("user is selecting the subject from the excel sheet ");
		// homepage.SelectSubject(prop.getProperty("selectsubject"));
		homepage.SelectSubject(selectsubject);
		Log.info("verifying the text of select urgency ");
		
		Log.info("verifying the text of select pages and words ");
		String Pages =homepage.SelectPages(selectpages);

		String urgency = homepage.SelectUrgencyText();
		Log.info("user is clicking on the order button ");
		
		
		Log.info("========= Test Result Start =========");
		Log.info("Selected Service >>> " + selectservice);
		Log.info("Selected Subject >>> " + selectsubject);
		Log.info("Selected Urgency >>> " + urgency);
		Log.info("Selected Pages/words >>> "+Pages);
		Log.info("Current market value of INR >>> " );
		Log.info("Webstore Price >>> "  );
		Log.info("====== Test Result End =======");
		


		Log.endTestCase("dropdowntest");

	}

}
