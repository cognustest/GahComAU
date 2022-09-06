/**
 * 
 */
package com.gahcomau.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.gahcomau.actiondriver.Action;
import com.gahcomau.utility.ExtentManager;
import com.gahcomau.utility.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author user
 *
 */
public class BaseClass {
	
	public Properties prop;

	public static WebDriver driver;
	
	@BeforeSuite
	public void loadConfig() {
		//for report
		ExtentManager.setExtent();
		
		DOMConfigurator.configure("log4j.xml");
		
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
	}

	
	
	/*@BeforeTest
	public void loadConfig() {
	//cut and pasted code try in before suit
		
	}
	*/
	
   
	public void launchApp() {
	
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
		//driver.manage().window().minimize();
		Action.implicitWait(driver , 10);
		Action.pageLoadTimeOut(driver , 30);
		
		driver.get(prop.getProperty("url"));	
		
	}
	
	public void launchGmail() {
		
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
		
		driver.get(prop.getProperty("gmailurl"));
		
		
		
	}
	
	
	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}
	
	
}
