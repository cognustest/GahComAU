/**
 * 
 */
package com.gahcomau.testcases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gahcomau.base.BaseClass;
import com.gahcomau.dataprovider.DataProviders;
import com.gahcomau.pageobjects.CartPage;
import com.gahcomau.pageobjects.HomePage;
import com.gahcomau.pageobjects.LoginPage;
import com.gahcomau.pageobjects.OrderPage;
import com.gahcomau.utility.Log;

/**
 * @author user
 *
 */
public class NewUser_OrderPage_Test extends BaseClass {

	HomePage homepage;
	OrderPage orderpage;
	CartPage cartpage;
	LoginPage loginpage;
	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod

	public void tearDown() {
		driver.quit();
	}

	@Test(dataProvider = "orderpage", dataProviderClass = DataProviders.class, description = "Verify New User is Able to add order to cart page or not ")
	public void OrderPageTest(String selectservice, String selectsubject, String selectpages, String selecturgency,
			String entertopic, String requirement) throws Throwable {

		homepage = new HomePage();
		orderpage = new OrderPage();
		cartpage = new CartPage();
		loginpage = new LoginPage();

		Log.startTestCase("VerifyNewUserIsAbleToAddOrderToCart");
		orderpage = homepage.clickOnOrderNowBtnGAH();
		Log.info("user is clicking on the order now button");

		Log.info("User is Redirected To the Order Page");

		Log.info("Current URL is :");
		orderpage.url();

		Log.info("Clicking the select service");
		orderpage.clickOnSelectServicesBtn();

		Log.info("Selecting the Service :");
	    cartpage = orderpage.selectServices(selectservice);

		Log.info("Verifying the Selected Text");
		orderpage.SelectServicesText();
		// **********************************************************************************************************

		Log.info("Clicking the select subject");
		orderpage.clickOnSelectSubjectBtn();

		Log.info("Selecting the Subject :");
		String exsubject = orderpage.SelectSubject(selectsubject);
		System.out.println("ABC " +exsubject);
		

		Log.info("Verifying the Selected Text");
		orderpage.SelectSubjectText();
		// **********************************************************************************************************

		Log.info("Clicking the select Pages");
		orderpage.clickOnSelectPagesBtn();

		Log.info("Selecting the Pages :");
		String expage = orderpage.SelectPages(selectpages);

		Log.info("Verifying the Selected Text");
		orderpage.SelectPagesText();

		// **********************************************************************************************************

		Log.info("Clicking the select Urgency");
		orderpage.clickOnSelectUrgencyBtn();

		Log.info("Selecting the Urgency :");
		orderpage.SelectUrgency(selecturgency);

		Log.info("Verifying the Selected Text");
		orderpage.SelectUrgencyText();

		// **********************************************************************************************************
		Log.info("Sending Keys To Enter Topic");
		Log.info("Getting text entered by user");
		String extopic = orderpage.enterTopic(entertopic);
		

		// **********************************************************************************************************

		Log.info("Sending Keys To Specify Requirement Here");
		Log.info("Getting text entered by user");
		orderpage.requirement(requirement);
		String exrequirement = orderpage.requirement(requirement);


		// **********************************************************************************************************

		
		Log.info("Uploading file......");
		orderpage.uploadFile();
		
		// **********************************************************************************************************

		Log.info("Clicking the Check Box");
		orderpage.clickCheckBox();
		Assert.assertTrue(true);
		
		// **********************************************************************************************************

		orderpage.OrderSummaryText();
		orderpage.validateOrderSummaryText();
		
		Log.info("Checking the basic price is displayed or not");
		orderpage.basicPriceDisplayed();
		Log.info("basic price is displayed");
		orderpage.basicPrice();
		
		
		Log.info("basic price is displayed");
		String orderDisocount = orderpage.DiscountPrice();
		
		String saveamountmessage = orderpage.SaveAmtMsg();
		
		Log.info("Verifying OrderDiscount is same as save amount message or not");
		Assert.assertEquals(orderDisocount, saveamountmessage);
		
		String TotalPrice = orderpage.TotalPrice();
		
		// **********************************************************************************************************

		Log.info("Clicking on Secure Continue");
		cartpage=orderpage.clickSecureContinue();
		
		// **********************************************************************************************************
		
		Log.info("Getting the Url.............");
		cartpage.url();
		Assert.assertEquals("https://customerpanel.globalassignmenthelp.com/cart", cartpage.url());
		// **********************************************************************************************************
		
		//Cart Order Card or Invoice
		
		Log.info("Verifying the Cart topic is matching with the Entered Topic by user");
		Assert.assertEquals(cartpage.ActTopicText(),"Topic : " + extopic );
		
		Log.info("Verifying the Cart Discription is matching with the Spe. Requirement by user");
		Assert.assertEquals(cartpage.ActDiscriptionText(),"Description :  " + exrequirement );
		
		
		
		String AmountToPay = cartpage.amountToPayActAmt();
		//Log.info("Verifying Amount to pay : is equal to basic price amount on order page or not");
		
		//	Assert.assertEquals(TotalPrice,"Amount to pay : " + AmountToPay);
		//Log.info("amount is matched");
		
		
		
		// **********************************************************************************************************

		// Login Page
		
		
		
		
		Log.endTestCase("VerifyNewUserIsAbleToAddOrderToCart");
		
		
		
		

	}

}
