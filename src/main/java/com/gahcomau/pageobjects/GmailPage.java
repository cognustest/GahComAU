/**
 * 
 */
package com.gahcomau.pageobjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.gahcomau.actiondriver.Action;
import com.gahcomau.base.BaseClass;
import com.gahcomau.utility.Log;

/**
 * @author user
 *
 */
public class GmailPage extends BaseClass{
	
	
	
	@FindBy(xpath = "//a[contains(text(),'Sign in')]") 
    WebElement SignInBtn;
	
	@FindBy(xpath="//input[@id='identifierId']")
	WebElement emailField;
	
	@FindBy(xpath="//*[@id='password']/div[1]/div/div[1]/input")
	WebElement passwordField;
	
	@FindBy(how=How.XPATH, xpath="//span[@class='bog']")
	List<WebElement> emailThreads;
	
	@FindBy(how=How.XPATH, xpath="//span[@class='gb_bb gbii']")
	WebElement profileLogo;
	
	
	
	public GmailPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterEmail(String emailID)
	{
		Action.waitForVisible(driver, emailField);
		Actions actions=new Actions(driver);
		actions.moveToElement(emailField);
		actions.click();
		actions.sendKeys(emailID + Keys.ENTER);
		actions.build().perform();
		Log.info("Email entered");	
	}
	
	public void enterPassword(String password)
	{
		Action.waitForVisible(driver, passwordField);
		Actions actions=new Actions(driver);
		actions.moveToElement(passwordField);
		actions.click();
		actions.sendKeys(password + Keys.ENTER);
		actions.build().perform();
		Log.info("Password entered");
	}
	
	public void clickEmail(String emailSubject)
	{
		Action.waitForVisible(driver, profileLogo);

		for (int i = 0; i < emailThreads.size(); i++) {
			
			if (emailThreads.get(i).getText().contains(emailSubject)) {
				emailThreads.get(i).click();
				Log.info("email clicked");
				break;
			}
		}
	}
	
	
	

}
