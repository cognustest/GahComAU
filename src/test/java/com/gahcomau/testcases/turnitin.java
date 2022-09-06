/**
 * 
 */
package com.gahcomau.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gahcomau.actiondriver.Action;
import com.gahcomau.base.BaseClass;
import com.gahcomau.dataprovider.DataProviders;
import com.gahcomau.pageobjects.pages;
import com.gahcomau.utility.ExtentManager;
import com.gahcomau.utility.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author user
 *
 */
public class turnitin extends BaseClass{
	
	pages pg;
	
	@BeforeMethod
	public void setup() {
		//launchApp();
		
		
	}

	@AfterMethod

	public void tearDown() {
		driver.quit();
	}
	
	
	
	@Test(dataProvider = "turnitin", dataProviderClass = DataProviders.class
			, description = "xyz")
	
	public void getTurnitin(String Links) {
		
		pg = new pages();
		
		ExtentManager.setExtent();
		
		//DOMConfigurator.configure("log4j.xml");
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
			System.getProperty("user.dir") + "/Configuration/Config.properties");
			//System.getProperty("\\Configuration\\config.properties"));
			prop.load(ip);
			
			System.out.println(ip);
		

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String browserName = prop.getProperty("browser");
		Log.info("Launching in browser"+ " " +browserName);
		
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			// Set Browser to ThreadLocalMap
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		
		driver.manage().window().maximize();
		
		Action.implicitWait(driver , 10);
		Action.pageLoadTimeOut(driver , 30);
		
		driver.get(Links);	
		
		
		//pg.clickurl(Links);
		pg.getTurnitin();
		
	}
	

}
