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
public class DashboardPage extends BaseClass{
	
	
	
	
	@FindBy(xpath = "//a[@id=\"myCart_tab\"]") 
    WebElement myCart;
	
	@FindBy(xpath = "//*[@id=\"current_no_order\"]") 
    WebElement emptyCart;
	
	@FindBy(xpath = "//*[@id=\"dropdownMenuButton\"]") 
    WebElement profileDropdown;
	
	@FindBy(xpath = "//li/a[@href=\"/users/profile\"]") 
    WebElement Profile;
	
	@FindBy(xpath = "//li/a[@href=\"/users/changepassword\"]") 
    WebElement ChangePassword;
	
	@FindBy(xpath = "/html/body/header/div[1]/div[2]/div[3]/ul/li[3]/a") 
	WebElement logout;
	
	
	@FindBy(xpath = "//ul[@class=\"dropdown-menu show\"]") 
	WebElement showProfileDropdown;
	
	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String url() throws Throwable {
		
		String currentUrl = Action.getCurrentURL(driver);
		System.out.println(currentUrl);
		return currentUrl;
	}
	
	public void myCart() {
		Action.waitForVisible(driver, myCart);
		Log.info("Checking my cart menu is displyed or not");
		Action.isDisplayed(driver, myCart);
		
	}
	
	public void emptyCart() {
		Log.info("Checking my cart empty cart is displyed or not");
		Action.isDisplayed(driver, emptyCart);
	}
	
	public void profileDropdown() {
		
		Log.info("Checking my cart profile dropdown is displyed or not");
		Action.isDisplayed(driver, profileDropdown);
		
		Action.JSClick(driver, profileDropdown);
		Action.fluentWait(driver, showProfileDropdown, 5);
		Action.fluentWait(driver, logout, 5);

		
	}
	
	public HomePage clicklogout() {
		
		//Select drop = new Select(profileDropdown);
		// drop.selectByIndex(selectservice);
		//drop.selectByVisibleText("Logout");
		Action.fluentWait(driver, showProfileDropdown, 5);
		Action.JSClick(driver, logout);	
		Log.info("Cliked on logout button");
		return new HomePage();


		
	}
	

}
