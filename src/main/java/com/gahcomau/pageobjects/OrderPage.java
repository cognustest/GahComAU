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

/**
 * @author user
 *
 */
public class OrderPage extends BaseClass {

	@FindBy(xpath = "//select[@id='ass_group_list']")
	WebElement SelectServices;

	@FindBy(xpath = "//select[@id='assignment_subject']")
	WebElement SelectSubject;

	@FindBy(xpath = "//select[@id='urgency']")
	WebElement SelectUrgency;

	@FindBy(xpath = "//*[@id=\"pages_count\"]")
	WebElement SelectPages;

	@FindBy(xpath = "//input[@id='topic']")
	WebElement EnterTopic;
	
	@FindBy(xpath = "//textarea[@id='enter_req']")
	WebElement SpecifyRequirementHere;


	@FindBy(xpath = "//input[@id='file_blank']")
	WebElement UploadFile;

	@FindBy(xpath = "//div/input[@id=\"term\"]")//input[@id='term']

	WebElement CheckBox;

	@FindBy(xpath = "//h2[@class=\"heading\"]")
	WebElement OrderPageSummary;
	//Order Summary

	@FindBy(xpath = "//span[contains(text(),'Basic Price')]")
	WebElement LeftBasicPrice;
	

	@FindBy(xpath = "//span[@class=\"right bprice basePrice\"]")
	WebElement RightBasicPrice;
	

	@FindBy(xpath = "//span[@class=\"right dprice discountAmount\"]")
	WebElement DiscountPrice;

	@FindBy(xpath = "//b[@class=\"offerPrice\"]")
	WebElement TotalPrice;
	
	@FindBy(xpath = "//span[@class=\"bprice saveAmount\"]")
	WebElement SaveAmtMsg;
	
	@FindBy(xpath = "//span[contains(text(),'Secure Continue')]")
	WebElement SecureContinue ;
	
	
	
	public OrderPage() {
		PageFactory.initElements(driver, this);
	}


	public String getTitle() {
		String actualTitle = driver.getTitle();
		System.out.println("Actual Page Title is : " + actualTitle);
		return actualTitle;
	}

	public void url() {
		String currentUrl = Action.getCurrentURL(driver);
		System.out.println(currentUrl);
	}

	public void clickOnSelectServicesBtn() {
		Action.click(driver, SelectServices);

	}

	public CartPage selectServices(String selectservice) {
		Select drop = new Select(SelectServices);
		drop.selectByVisibleText(selectservice);

		WebElement o = drop.getFirstSelectedOption();
		String selectedoption = o.getText();
		Action.fluentWait(driver, SelectServices, 05);
		System.out.println("Selected Service Text: " + selectedoption);
		return new CartPage();
	}



	public void SelectServicesText() {

		Select drop = new Select(SelectServices);
		Action.fluentWait(driver, SelectServices, 10);

		WebElement o = drop.getFirstSelectedOption();
		String selectedoption = o.getText();
		System.out.println("Selected Service: " + selectedoption);
	}

	// ****************************************************************************************************************
	// Selecting Subject

	public void clickOnSelectSubjectBtn() {
		Action.click(driver, SelectSubject);

	}

	public String SelectSubject(String selectsubject) {
		Select drop2 = new Select(SelectSubject);

		drop2.selectByVisibleText(selectsubject);

		Action.fluentWait(driver, SelectSubject, 10);
		WebElement o = drop2.getFirstSelectedOption();
		String selectedoption = o.getText();
		System.out.println("Selected Subject Text: " + selectedoption);
		return selectsubject;

	}

	public void SelectSubjectText() {
		Select drop2 = new Select(SelectSubject);

		WebElement o = drop2.getFirstSelectedOption();
		String selectedoption = o.getText();
		System.out.println("Selected Subject Text: " + selectedoption);

	}

	// ****************************************************************************************************************

	public void clickOnSelectPagesBtn() {
		Action.click(driver, SelectPages);

	}

	public String SelectPages(String selectpages) {
		Select drop3 = new Select(SelectPages);
		drop3.selectByVisibleText(selectpages);
		// System.out.println(SelectPages);

		WebElement o = drop3.getFirstSelectedOption();
		String selectedoption = o.getText();
		System.out.println("Selected Pages Text: " + selectedoption);
		return selectpages;

	}

	// Getting text and verifying text with expected text
	public void SelectPagesText() {
		Select drop3 = new Select(SelectPages);
		WebElement o = drop3.getFirstSelectedOption();
		String selectedoption = o.getText();
		System.out.println("Selected Pages Text: " + selectedoption);

	}

	// **************************************************************************************************************

	public void clickOnSelectUrgencyBtn() {
		Action.click(driver, SelectUrgency);

	}

	public void SelectUrgency(String selecturgency) {
		Select drop4 = new Select(SelectUrgency);
		drop4.selectByVisibleText(selecturgency);
		// System.out.println(SelectUrgency);

		WebElement o = drop4.getFirstSelectedOption();
		String selectedoption = o.getText();
		System.out.println("Selected Pages Text: " + selectedoption);

	}

	public void SelectUrgencyText() {
		Select drop4 = new Select(SelectUrgency);
		WebElement o = drop4.getFirstSelectedOption();
		String selectedoption = o.getText();
		System.out.println("Selected Urgency Text: " + selectedoption);

	}

	// ****************************************************************************************************************
	// Enter Text in to the Enter Topic text box

	public String enterTopic(String entertopic) {
		Action.type(EnterTopic, entertopic);
		return entertopic;
	}

	// ****************************************************************************************************************

	public String requirement(String requirement) {
		Action.type(SpecifyRequirementHere, requirement);
		return requirement;
	}


	// ****************************************************************************************************************
	
	public void uploadFile() {
		UploadFile.sendKeys("/home/user/eclipse-workspace/GahCom/aUploadBtn/cognus.png");
		UploadFile.sendKeys("/home/user/eclipse-workspace/GahCom/aUploadBtn/cognusp.pdf");
		Action.fluentWait(driver, SecureContinue, 10);

		System.out.println("Uploaded file");
		
	}

	// ****************************************************************************************************************

	public void clickCheckBox() throws Throwable{
		
		Action.JSClick(driver,CheckBox);
		
	}
	
	// ****************************************************************************************************************

	public String OrderSummaryText() {
		
		String o = OrderPageSummary.getText();
		System.out.println("Text is : " + o);
		return o;
	}
	

	public boolean validateOrderSummaryText() throws Throwable {
		 return Action.isDisplayed(driver, OrderPageSummary);
	}
	
	public boolean basicPriceDisplayed() {
		
		return Action.isDisplayed(driver,LeftBasicPrice );
	}
	
	public String basicPrice() {
		
		String orderActBasicPrice = RightBasicPrice.getText();
		System.out.println("Basic Price on the Order Page : " + orderActBasicPrice);
		return orderActBasicPrice;
		
	}
	
	public String DiscountPrice() {
		
		String offerprice = DiscountPrice.getText();
		return offerprice;
	}
	
	public String TotalPrice() {
		
		String totalprice = TotalPrice.getText();
		return totalprice;
	}
	
	public String SaveAmtMsg() {
		
		String SaveAmtMsgt = SaveAmtMsg.getText();
		return SaveAmtMsgt;
	}
	
	
	
	
	// ****************************************************************************************************************

	public CartPage clickSecureContinue() {
		Action.fluentWait(driver, SecureContinue, 10);

		Action.JSClick(driver, SecureContinue);
		return new CartPage();
	}
	
	// ****************************************************************************************************************

	

}
