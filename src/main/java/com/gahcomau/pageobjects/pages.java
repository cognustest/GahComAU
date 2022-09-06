/**
 * 
 */
package com.gahcomau.pageobjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.gahcomau.actiondriver.Action;
import com.gahcomau.base.BaseClass;
import com.gahcomau.utility.Log;

/**
 * @author user
 *
 */
public class pages extends BaseClass{
	
	

	
	
	
	public pages() {
		PageFactory.initElements(driver, this);
	}
	
	public String url() throws Throwable {
		
		String currentUrl = Action.getCurrentURL(driver);
		System.out.println(currentUrl);
		return currentUrl;
	}
	
	public void getTurnitin() {
		
		String redirectedUrl = Action.getCurrentURL(driver);
		//System.out.println("Redirected URL >>>" + redirectedUrl);
		
		boolean abc = driver.getPageSource().contains("turnitin");
		
	
		if(abc == true ) {
			
			
			System.out.println(redirectedUrl + " - Found in small");
			
		}else {
			
			System.out.print("Not Found");
			
		}
		
		boolean bbc =driver.getPageSource().contains("Turnitin");

		if(bbc == true) {
			
			System.out.println(redirectedUrl + " - Found in capital");
			
		}else {
			
			System.out.println("Not Found");
			
		}
		
		boolean cbc =driver.getPageSource().contains("TURNITIN");

		if(cbc == true) {
			
			System.out.println(redirectedUrl + " - Found in FULL capital");
			
		}else {
			
			System.out.println("Not Found");
			
		}
		
	}
	
	
	public void back() {
		
		driver.navigate().back();
		
		
	}
	
	
	public void adturniClickonsitemap(String Links) {
		
		WebElement Urls = driver
				.findElement(By.xpath("//a[contains(text()," + "'" + Links + "'" + ")]"));
		
		Urls.click();
	
		
		
		
	}
	
}
