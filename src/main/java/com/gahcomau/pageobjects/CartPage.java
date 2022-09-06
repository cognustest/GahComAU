/**
 * 
 */
package com.gahcomau.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gahcomau.actiondriver.Action;
import com.gahcomau.base.BaseClass;
import com.gahcomau.utility.Log;

/**
 * @author user
 *
 */
public class CartPage extends BaseClass {

	@FindBy(xpath = "")
	WebElement CartToolTipCount;

	@FindBy(xpath = "//p[@class=\"common-txt\"]")
	WebElement Topic;
	
	
	
// Please find xpath below in the methods

	public String url() throws Throwable {
		Action.fluentWait(driver, Topic, 05);

		String currentUrl = Action.getCurrentURL(driver);
		Log.info(currentUrl);
		return currentUrl;

	}
	
	

	// **************************************************************************************************************
	// the value is null
	public String CartCount() {

		String count = CartToolTipCount.getText().toString();
		Log.info("Cart Count is  : " + count);
		return count;
	}

	public String ActTopicText() {

		// Action.fluentWait(driver, Topic, 10);
		// String innerHTML =
		// driver.findElement(By.xpath("//p[@class=\"common-txt\"]")).getAttribute("innerHTML");
		// //Inner Html <strong>Topic :</strong> ExcelTest
		String textContent = driver.findElement(By.xpath("//p[@class=\"common-txt\"]")).getAttribute("textContent");
		// String innerText =
		// driver.findElement(By.xpath("//p[@class=\"common-txt\"]")).getAttribute("innerText");

		// System.out.println("Inner Html " + innerHTML);
		Log.info("Text Content " + textContent);
		// System.out.println("Inner Text " + innerText);
		// String actTopic = Topic.getText();

		Log.info("Topic Text is : " + textContent);
		return textContent;
	}

	public String ActDiscriptionText() {

		String discription = driver.findElement(By.xpath("//p[@class=\"common-txt pb-4 pt-2\"]"))
				.getAttribute("textContent");
		Log.info("Discription Text " + discription);
		return discription;

	}

	public String amountToPayActAmt() {

		String amountToPayActAmount = driver.findElement(By.xpath("//p[@class=\"common-txt pt-3\"]"))
				.getAttribute("textContent");
		Log.info("Amount to Pay Text " + amountToPayActAmount);
		return amountToPayActAmount;

	}

	
	
	
}
