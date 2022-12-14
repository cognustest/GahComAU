/**
 * 
 */
package com.gahcomau.utility;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


/**
 * @author user
 *
 */
public class ExtentManager {
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void setExtent() {
		//htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport_"+BaseClass.getCurrentTime()+".html");
		htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"TestReport.html");
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		//htmlReporter.config().setDocumentTitle("Automation Test Report");
		//htmlReporter.config().setReportName(" Test Automation Report");
		//htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		//extent.setSystemInfo("HostName", "MyHost");
		extent.setSystemInfo("ProjectName", "Global Assignment Help Australia");
		extent.setSystemInfo("Tester", "Shubham");
		extent.setSystemInfo("OS", "ubuntu");
		extent.setSystemInfo("Browser", "Chrome");
	
	}
	public static void endReport() {
		extent.flush();
	}

}
