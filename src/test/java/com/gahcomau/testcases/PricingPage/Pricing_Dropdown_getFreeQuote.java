/**
 * 
 */
package com.gahcomau.testcases.PricingPage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gahcomau.actiondriver.Action;
import com.gahcomau.base.BaseClass;
import com.gahcomau.dataprovider.DataProviders;
import com.gahcomau.pageobjects.HomePage;
import com.gahcomau.pageobjects.OrderPage;
import com.gahcomau.pageobjects.PricingModulePage;
import com.gahcomau.utility.Log;


/**
 * @author user
 *
 */
public class Pricing_Dropdown_getFreeQuote extends BaseClass{
	
	PricingModulePage pricingpage;
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

	// Data Provider ---> TestData
	//@Test(dataProvider = "management", dataProviderClass = DataProviders.class ,
			//description = "(Service - Assignment , Subject Cat - Management) verify user is able to order ")
	public void Service_assignment_sub_management(String selectsubject, String selectservice , String selectpages) {
		Log.startTestCase("Pricing >> Get Free Quote Dropdown >>Service-Assignment >> Subject_Cat-management");
		pricingpage = new PricingModulePage();
		orderpage = new OrderPage();
		Log.info("Getting the Title ");
		pricingpage.getTitle();	
		pricingpage.PricingMenu();
		Log.info("Clicking on the service Button");
		pricingpage.clickOnSelectServicesBtn();
		// Change Number for selecting service here
		Log.info("User is selecting the service");
		pricingpage.selectServices(selectservice);
		Log.info("user is clicking on the subject ");
		pricingpage.clickOnSelectSubjectBtn();
		Log.info("user is selecting the subject from the excel sheet ");
		// homepage.SelectSubject(prop.getProperty("selectsubject"));
		pricingpage.SelectSubject(selectsubject);
		Log.info("verifying the text of select pages and words ");
		String Pages =pricingpage.SelectPages(selectpages);
		Log.info("verifying the text of select urgency ");
		String urgency =pricingpage.SelectUrgencyText();
		String price = pricingpage.ServicePrice();
		Log.info("user is clicking on the order button ");
		pricingpage.getQuoteBtn();
		String RedirectedPageURL = Action.getCurrentURL(driver);
		//validating redirected URL is as expected 
		Assert.assertEquals("https://customerpanel.globalassignmenthelp.com/order", RedirectedPageURL);

		
		
		
		Log.info("********** Test Result Start **********");
		
		Log.info("");
		Log.info("");

		Log.info("Selected Service >>> " + selectservice);
		Log.info("Selected Subject >>> " + selectsubject);
		Log.info("Selected Urgency >>> " + urgency);
		Log.info("Selected Pages/words >>> "+Pages);
		Log.info("Current market value of INR >>> " );
		Log.info("Total Calculate Price >>> " + price  );
		Log.info("Redirected URL >>> "+ RedirectedPageURL);
		
		Log.info("");
		Log.info("");
		Log.info("**********  Test Result End ********** ");
		

		Log.endTestCase("<<<< Pricing >> Get Free Quote Dropdown >>Service-Assignment >> Subject_Cat-management >>>>");

	}
	
	
	
	//@Test(dataProvider = "finance", dataProviderClass = DataProviders.class ,
		//	description = "(Service - Assignment , Subject Cat - Finance) verify user is able to order ")
	public void Service_assignment_sub_finance(String selectsubject, String selectservice , String selectpages) {
		Log.startTestCase("Pricing >> Get Free Quote Dropdown >>Service-Assignment >> Subject_Cat-Finance");
		pricingpage = new PricingModulePage();
		orderpage = new OrderPage();
		Log.info("Getting the Title ");
		pricingpage.getTitle();
		pricingpage.PricingMenu();
		Log.info("Clicking on the service Button");
		pricingpage.clickOnSelectServicesBtn();
		// Change Number for selecting service here
		Log.info("User is selecting the service");
		pricingpage.selectServices(selectservice);
		Log.info("user is clicking on the subject ");
		pricingpage.clickOnSelectSubjectBtn();
		Log.info("user is selecting the subject from the excel sheet ");
		// homepage.SelectSubject(prop.getProperty("selectsubject"));
		pricingpage.SelectSubject(selectsubject);	
		Log.info("verifying the text of select pages and words ");
		String Pages =pricingpage.SelectPages(selectpages);
		Log.info("verifying the text of select urgency ");
		String urgency =pricingpage.SelectUrgencyText();
		String price = pricingpage.ServicePrice();	
		Log.info("user is clicking on the order button ");
		pricingpage.getQuoteBtn();	
		String RedirectedPageURL = Action.getCurrentURL(driver);
		//validating redirected URL is as expected 
		Assert.assertEquals("https://customerpanel.globalassignmenthelp.com/order", RedirectedPageURL);

		Log.info("********** Test Result Start **********");
		
		Log.info("");
		Log.info("");

		Log.info("Selected Service >>> " + selectservice);
		Log.info("Selected Subject >>> " + selectsubject);
		Log.info("Selected Urgency >>> " + urgency);
		Log.info("Selected Pages/words >>> "+Pages);
		Log.info("Current market value of INR >>> " );
		Log.info("Total Calculate Price >>> " + price  );
		Log.info("Redirected URL >>> "+ RedirectedPageURL);
		
		Log.info("");
		Log.info("");
		Log.info("**********  Test Result End ********** ");
		

		Log.endTestCase("<<<< Pricing >> Get Free Quote Dropdown >>Service-Assignment >> Subject_Cat-Finance >>>>");

	}
	
	
	
	
	
	//@Test(dataProvider = "tourism", dataProviderClass = DataProviders.class ,
			//description = "(Service - Assignment , Subject Cat - Tourism) verify user is able to order ")
	public void Service_assignment_sub_tourism(String selectsubject, String selectservice , String selectpages) {
		Log.startTestCase("Pricing >> Get Free Quote Dropdown >>Service-Assignment >> Subject_Cat-Tourism");
		pricingpage = new PricingModulePage();
		orderpage = new OrderPage();
		Log.info("Getting the Title ");
		pricingpage.getTitle();
		pricingpage.PricingMenu();
		Log.info("Clicking on the service Button");
		pricingpage.clickOnSelectServicesBtn();
		// Change Number for selecting service here
		Log.info("User is selecting the service");
		pricingpage.selectServices(selectservice);
		Log.info("user is clicking on the subject ");
		pricingpage.clickOnSelectSubjectBtn();
		Log.info("user is selecting the subject from the excel sheet ");
		// homepage.SelectSubject(prop.getProperty("selectsubject"));
		pricingpage.SelectSubject(selectsubject);	
		Log.info("verifying the text of select pages and words ");
		String Pages =pricingpage.SelectPages(selectpages);
		Log.info("verifying the text of select urgency ");
		String urgency =pricingpage.SelectUrgencyText();
		String price = pricingpage.ServicePrice();	
		Log.info("user is clicking on the order button ");
		pricingpage.getQuoteBtn();	
		String RedirectedPageURL = Action.getCurrentURL(driver);
		//validating redirected URL is as expected 
		Assert.assertEquals("https://customerpanel.globalassignmenthelp.com/order", RedirectedPageURL);

		Log.info("********** Test Result Start **********");
		
		Log.info("");
		Log.info("");

		Log.info("Selected Service >>> " + selectservice);
		Log.info("Selected Subject >>> " + selectsubject);
		Log.info("Selected Urgency >>> " + urgency);
		Log.info("Selected Pages/words >>> "+Pages);
		Log.info("Current market value of INR >>> " );
		Log.info("Total Calculate Price >>> " + price  );
		Log.info("Redirected URL >>> "+ RedirectedPageURL);
		
		Log.info("");
		Log.info("");
		Log.info("**********  Test Result End ********** ");
		

		Log.endTestCase("<<<< Pricing >> Get Free Quote Dropdown >>Service-Assignment >> Subject_Cat-Tourism >>>>");

	}
	
	
	
	
	@Test(dataProvider = "law", dataProviderClass = DataProviders.class ,
			description = "(Service - Assignment , Subject Cat - Law) verify user is able to order ")
	public void Service_assignment_sub_law(String selectsubject, String selectservice , String selectpages) {
		
		
		Log.startTestCase("Pricing >> Get Free Quote Dropdown >>Service-Assignment >> Subject_Cat-Law");
		
		
		pricingpage = new PricingModulePage();
		orderpage = new OrderPage();
		Log.info("Getting the Title ");
		pricingpage.getTitle();
		pricingpage.PricingMenu();
		Log.info("Clicking on the service Button");
		pricingpage.clickOnSelectServicesBtn();
		// Change Number for selecting service here
		Log.info("User is selecting the service");
		pricingpage.selectServices(selectservice);
		Log.info("user is clicking on the subject ");
		pricingpage.clickOnSelectSubjectBtn();
		Log.info("user is selecting the subject from the excel sheet ");
		// homepage.SelectSubject(prop.getProperty("selectsubject"));
		pricingpage.SelectSubject(selectsubject);	
		Log.info("verifying the text of select pages and words ");
		String Pages =pricingpage.SelectPages(selectpages);
		Log.info("verifying the text of select urgency ");
		String urgency =pricingpage.SelectUrgencyText();
		String price = pricingpage.ServicePrice();	
		Log.info("user is clicking on the order button ");
		pricingpage.getQuoteBtn();	
		String RedirectedPageURL = Action.getCurrentURL(driver);
		//validating redirected URL is as expected 
		Assert.assertEquals("https://customerpanel.globalassignmenthelp.com/order", RedirectedPageURL);

		Log.info("********** Test Result Start **********");
		
		Log.info("");
		Log.info("");

		Log.info("Selected Service >>> " + selectservice);
		
		Log.info("Selected Subject >>> " + selectsubject);
		Log.info("Selected Urgency >>> " + urgency);
		Log.info("Selected Pages/words >>> "+Pages);
		Log.info("Current market value of INR >>> " );
		Log.info("Total Calculate Price >>> " + price  );
		Log.info("Redirected URL >>> "+ RedirectedPageURL);
		
		Log.info("");
		Log.info("");
		Log.info("**********  Test Result End ********** ");
		

		Log.endTestCase("<<<< Pricing >> Get Free Quote Dropdown >>Service-Assignment >> Subject_Cat-Law >>>>");

	}

}
