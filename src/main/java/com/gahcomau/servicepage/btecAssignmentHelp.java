/**
 * 
 */
package com.gahcomau.servicepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gahcomau.actiondriver.Action;
import com.gahcomau.base.BaseClass;
import com.gahcomau.utility.Log;

/**
 * @author user
 *
 */
public class btecAssignmentHelp extends BaseClass {
	
	
	@FindBy(xpath = "//h1[@class=\"heading\"]")
	WebElement Heading;
	

	@FindBy(xpath = "//h2[@class=\"subheading\"]")
	WebElement subheading;
	
	
	
	public btecAssignmentHelp() {
		PageFactory.initElements(driver, this);
	}
	
	public String url() throws Throwable {	
		String currentUrl = Action.getCurrentURL(driver);
		System.out.println(currentUrl);
		return currentUrl;

	}
	
	public String HeadingText() {
		
		String headingText = Heading.getText();
		Log.info("Heading Text is : " + headingText);
		return headingText;
	}
	
public String SubHeadingText() {
		
		String subheadingText = subheading.getText();
		Log.info("Sub-Heading Text is : " + subheadingText);
		return subheadingText;
	}
	
	

}
