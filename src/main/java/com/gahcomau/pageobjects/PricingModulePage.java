/**
 * 
 */
package com.gahcomau.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.gahcomau.actiondriver.Action;
import com.gahcomau.base.BaseClass;
import com.gahcomau.utility.Log;

/**
 * @author user
 *
 */
public class PricingModulePage extends BaseClass {

	@FindBy(xpath = "//ul[@class=\"MyMenu\"]/li[5]")
	WebElement PricingMenu;

	@FindBy(xpath = "//*[@id=\"ass_group_list\"]")
	WebElement SelectServices;

	@FindBy(xpath = "//select[@id='assignment_subject']")
	WebElement SelectSubject;

	@FindBy(xpath = "//*[@id=\"pages_count\"]")
	WebElement SelectPages;

	@FindBy(xpath = "//select[@id='urgency']")
	WebElement SelectUrgency;

	@FindBy(xpath = "//button[contains(text(),'ORDER NOW')]")
	WebElement OrderNowPricingBtn;

	@FindBy(xpath = "//div[@class=\"pricebold offerPrice\"]")
	WebElement ServicePrice;

	public PricingModulePage() {
		PageFactory.initElements(driver, this);
	}

	// Get Title
	public String getTitle() {
		String actualTitle = driver.getTitle();
		Log.info("Actual Page Title is : " + actualTitle);
		return actualTitle;
	}

	public void PricingMenu() {

		Action.click(driver, PricingMenu);
		Log.info("Clicked on the pricing menu on the menu bar");

	}

	public void clickOnSelectServicesBtn() {
		Action.click(driver, SelectServices);

	}

	public void clickOnSelectSubjectBtn() {
		Action.click(driver, SelectSubject);
	}

	// Selecting the first value Assignment | Coursework | Term Paper
	public void selectServices(String selectservice) {
		Select drop = new Select(SelectServices);
		drop.selectByVisibleText(selectservice);
		Action.fluentWait(driver, SelectServices, 10);
		WebElement o = drop.getFirstSelectedOption();
		String selectedoption = o.getText();
		Action.fluentWait(driver, SelectServices, 10);
		Log.info("Selected Service Text:>>> " + selectedoption);
	}

	// Selecting Subject
	public void SelectSubject(String selectsubject) {
		Select drop2 = new Select(SelectSubject);
		drop2.selectByVisibleText(selectsubject);
		Action.fluentWait(driver, SelectSubject, 05);
		WebElement o = drop2.getFirstSelectedOption();
		String selectedoption = o.getText();
		Log.info("Selected Subject Text:>>> " + selectedoption);

	}

	// Getting text and verifying text with expected text
	public String SelectPages(String selectpages) {
		Select drop3 = new Select(SelectPages);
		drop3.selectByVisibleText(selectpages);
		WebElement o = drop3.getFirstSelectedOption();
		String selectedoption = o.getText();
		Log.info("Selected Pages Text:>>> " + selectedoption);
		return selectedoption;

	}

	// Checking the text select urgency

	public String SelectUrgencyText() {
		Select drop4 = new Select(SelectUrgency);
		WebElement o = drop4.getFirstSelectedOption();
		String selectedoption = o.getText();
		Log.info("Selected Urgency Text:>>> " + selectedoption);
		return selectedoption;

	}
	
	public String ServicePrice() {
		
		String price = ServicePrice.getText();
		Log.info("Price>> " + price);
		return price;
		
	}

	// Clicking on get Free Quote Button
	public OrderPage getQuoteBtn() {
		Action.click(driver, OrderNowPricingBtn);
		
		OrderPage orderpage = new OrderPage();
		Action.waitForVisible(driver,orderpage.OrderPageSummary);
		Log.info("Order Summary is present");

		String RedirectedPageURL = Action.getCurrentURL(driver);
		Log.info("Redirected URL >>>" + RedirectedPageURL);

		return new OrderPage();

	}

}
