/**
 * 
 */
package com.gahcomau.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.ITestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.gahcomau.actiondriver.Action;
import com.gahcomau.base.BaseClass;
import com.gahcomau.dataprovider.DataProviders;
import com.gahcomau.pageobjects.HomePage;
import com.gahcomau.servicepage.btecAssignmentHelp;
import com.gahcomau.utility.ExtentManager;
import com.gahcomau.utility.Log;

/**
 * @author user
 *
 */
public class Services_Main_Subject_Topic extends BaseClass implements ITestListener{
	
	HomePage homeservice;
	btecAssignmentHelp btecAssignmentHelp1;
	
	ExtentReports extent;
	ExtentTest test;
	ExtentManager manager;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}

	//@AfterMethod
	//@AfterMethod
	@AfterMethod

	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	@Test(priority=1)
	public void getListServices() {
		
		homeservice = new HomePage();
		extent = new ExtentReports();
		
		test =ExtentManager.test.log(Status.INFO,MarkupHelper.createLabel("Getting All Main Services Present", ExtentColor.BLUE));
	
		homeservice.excelDemoServiceHover();
		homeservice.getServiceList();
		
		
		
		
	}

	
	
	 //  @Test(priority=2) public void getServiceSubjectList() {
	  
	 // homeservice = new HomePage(); homeservice.excelDemoServiceHover();
	 // homeservice.getServiceSubjectList();
	  
	  
	 // }
	  
	  @Test(priority=3 ) public void getServiceAssignmentSubjectList() {
	  
	 homeservice = new HomePage(); homeservice.excelDemoServiceHover();
	  homeservice.getServiceAssignmentSubjects();
	  
	  
	  }
	  
	  
	  
	  @Test(priority=4 ,dataProvider = "assignmentsubject", dataProviderClass =
	  DataProviders.class , description =
	  "Verify all services>> Main >> Topic are availble or not as per requirement "
	  ) public void ExcelHomePageMenuTest(String menuservice ,String mainservice ,
	  String servicetopic) throws Throwable {
	  Log.info("Excel user is trying to hover on the services"); homeservice = new
	  HomePage();
	  
	  
	  homeservice.excelDemoServiceHover();
	  Log.info("Retriving data from the Excel sheet");
	  homeservice.excelDemoService(mainservice);
	  
	  homeservice.excelDemoTopic(servicetopic);
	  
	  
	  homeservice.getBannerFeatureContentElement(); homeservice.priceCalculator();
	  
	  
	  homeservice.toolsSection();
	  
	  homeservice.writerSection(); homeservice.featureSection();
	  homeservice.serviceSection(); homeservice.dealsSection();
	  
	  
	  
	  homeservice.reviewsSection();
	  
	  homeservice.bannerOrderSample(); homeservice.callUsStrip(); String currentUrl
	  = Action.getCurrentURL(driver); Log.info("Redirected URL >>>"+currentUrl);
	  
	  Log.info("");
	  
	  Log.info("---------------------Test Passed--------------------------");
	  
	  }
	  
		/*
		 * @Test(priority=5 ) public void getServiceEngineeringSubjectList() {
		 * 
		 * homeservice = new HomePage(); homeservice.excelDemoServiceHover();
		 * homeservice.getServiceEngineeringSubjects();
		 * 
		 * 
		 * }
		 * 
		 * @Test(priority=6 ,dataProvider = "engineeringsubjects", dataProviderClass =
		 * DataProviders.class , description =
		 * "Verify all services>> Main >> Topic are availble or not as per requirement "
		 * ) public void ServiceTestEngineeringSubject(String menuservice ,String
		 * mainservice , String servicetopic) {
		 * 
		 * Log.info("Excel user is trying to hover on the services"); homeservice = new
		 * HomePage();
		 * 
		 * 
		 * homeservice.excelDemoServiceHover();
		 * Log.info("Retriving data from the Excel sheet");
		 * homeservice.excelDemoService(mainservice);
		 * 
		 * homeservice.excelDemoTopic(servicetopic);
		 * 
		 * 
		 * homeservice.getBannerFeatureContentElement(); homeservice.priceCalculator();
		 * 
		 * 
		 * homeservice.toolsSection();
		 * 
		 * homeservice.writerSection(); homeservice.featureSection();
		 * homeservice.serviceSection(); homeservice.dealsSection();
		 * 
		 * homeservice.reviewsSection();
		 * 
		 * //strips homeservice.bannerOrderSample(); homeservice.callUsStrip(); String
		 * String currentUrl = Action.getCurrentURL(driver);
		 * Log.info("Redirected URL >>>"+currentUrl);
		 * 
		 * Log.info("");
		 * 
		 * Log.info("---------------------Test Passed--------------------------");
		 * 
		 * 
		 * 
		 * }
		 * 
		 * @Test(priority=7 ) public void getServiceManagementSubjectList() {
		 * 
		 * homeservice = new HomePage(); homeservice.excelDemoServiceHover();
		 * homeservice.getServiceManagemenetSubjects();
		 * 
		 * 
		 * }
		 * 
		 * 
		 * @Test(priority=8 ,dataProvider = "managementsubject", dataProviderClass =
		 * DataProviders.class , description =
		 * "Verify all services>> Main >> Topic are availble or not as per requirement "
		 * ) public void ServiceTestManagemnetSubject(String menuservice ,String
		 * mainservice , String servicetopic) {
		 * 
		 * Log.info("Excel user is trying to hover on the services"); homeservice = new
		 * HomePage();
		 * 
		 * 
		 * homeservice.excelDemoServiceHover();
		 * Log.info("Retriving data from the Excel sheet");
		 * homeservice.excelDemoService(mainservice);
		 * 
		 * homeservice.excelDemoTopic(servicetopic);
		 * 
		 * 
		 * homeservice.getBannerFeatureContentElement(); homeservice.priceCalculator();
		 * 
		 * 
		 * homeservice.toolsSection();
		 * 
		 * homeservice.writerSection(); homeservice.featureSection();
		 * homeservice.serviceSection(); homeservice.dealsSection();
		 * 
		 * homeservice.reviewsSection();
		 * 
		 * //strips homeservice.bannerOrderSample(); homeservice.callUsStrip(); String
		 * String currentUrl = Action.getCurrentURL(driver);
		 * Log.info("Redirected URL >>>"+currentUrl);
		 * 
		 * Log.info("");
		 * 
		 * Log.info("---------------------Test Passed--------------------------");
		 * 
		 * 
		 * 
		 * }
		 * 
		 * @Test(priority=9) public void getServiceDissertationHelpList() {
		 * 
		 * homeservice = new HomePage(); homeservice.excelDemoServiceHover();
		 * homeservice.getServiceDissertationHelp();
		 * 
		 * 
		 * }
		 * 
		 * @Test(priority=10 ,dataProvider = "dissertationhelp", dataProviderClass =
		 * DataProviders.class , description =
		 * "Verify all services>> Main >> Topic are availble or not as per requirement "
		 * ) public void ServiceTestDissertationHelp(String menuservice ,String
		 * mainservice , String servicetopic) {
		 * 
		 * Log.info("Excel user is trying to hover on the services"); homeservice = new
		 * HomePage();
		 * 
		 * 
		 * homeservice.excelDemoServiceHover();
		 * Log.info("Retriving data from the Excel sheet");
		 * homeservice.excelDemoService(mainservice);
		 * 
		 * homeservice.excelDemoTopic(servicetopic);
		 * 
		 * 
		 * homeservice.getBannerFeatureContentElement(); homeservice.priceCalculator();
		 * 
		 * 
		 * homeservice.toolsSection();
		 * 
		 * homeservice.writerSection(); homeservice.featureSection();
		 * homeservice.serviceSection(); homeservice.dealsSection();
		 * 
		 * homeservice.reviewsSection();
		 * 
		 * //strips homeservice.bannerOrderSample(); homeservice.callUsStrip(); String
		 * String currentUrl = Action.getCurrentURL(driver);
		 * Log.info("Redirected URL >>>"+currentUrl);
		 * 
		 * Log.info("");
		 * 
		 * Log.info("---------------------Test Passed--------------------------");
		 * 
		 * 
		 * 
		 * }
		 * 
		 * @Test(priority=11) public void getServiceLawSubjectsList() {
		 * 
		 * homeservice = new HomePage(); homeservice.excelDemoServiceHover();
		 * homeservice.getServiceLawSubjects();
		 * 
		 * 
		 * }
		 * 
		 * @Test(priority=12 ,dataProvider = "lawsubjects", dataProviderClass =
		 * DataProviders.class , description =
		 * "Verify all services>> Main >> Topic are availble or not as per requirement "
		 * ) public void ServiceTestLawSubjects(String menuservice ,String mainservice ,
		 * String servicetopic) {
		 * 
		 * Log.info("Excel user is trying to hover on the services"); homeservice = new
		 * HomePage();
		 * 
		 * 
		 * homeservice.excelDemoServiceHover();
		 * Log.info("Retriving data from the Excel sheet");
		 * homeservice.excelDemoService(mainservice);
		 * 
		 * homeservice.excelDemoTopic(servicetopic);
		 * 
		 * 
		 * homeservice.getBannerFeatureContentElement(); homeservice.priceCalculator();
		 * 
		 * 
		 * homeservice.toolsSection();
		 * 
		 * homeservice.writerSection(); homeservice.featureSection();
		 * homeservice.serviceSection(); homeservice.dealsSection();
		 * 
		 * homeservice.reviewsSection();
		 * 
		 * //strips homeservice.bannerOrderSample(); homeservice.callUsStrip(); String
		 * String currentUrl = Action.getCurrentURL(driver);
		 * Log.info("Redirected URL >>>"+currentUrl);
		 * 
		 * Log.info("");
		 * 
		 * Log.info("---------------------Test Passed--------------------------");
		 * 
		 * 
		 * 
		 * }
		 * 
		 * 
		 * @Test(priority=13) public void getServiceCourseworkHelpList() {
		 * 
		 * homeservice = new HomePage(); homeservice.excelDemoServiceHover();
		 * homeservice.getServiceCourseworkHelp();
		 * 
		 * 
		 * }
		 * 
		 * @Test(priority=14 ,dataProvider = "courseworkhelp", dataProviderClass =
		 * DataProviders.class , description =
		 * "Verify all services>> Main >> Topic are availble or not as per requirement "
		 * ) public void ServiceTestCourseworkHelp(String menuservice ,String
		 * mainservice , String servicetopic) {
		 * 
		 * Log.info("Excel user is trying to hover on the services"); homeservice = new
		 * HomePage();
		 * 
		 * 
		 * homeservice.excelDemoServiceHover();
		 * Log.info("Retriving data from the Excel sheet");
		 * homeservice.excelDemoService(mainservice);
		 * 
		 * homeservice.excelDemoTopic(servicetopic);
		 * 
		 * 
		 * homeservice.getBannerFeatureContentElement(); homeservice.priceCalculator();
		 * 
		 * 
		 * homeservice.toolsSection();
		 * 
		 * homeservice.writerSection(); homeservice.featureSection();
		 * homeservice.serviceSection(); homeservice.dealsSection();
		 * 
		 * homeservice.reviewsSection();
		 * 
		 * //strips homeservice.bannerOrderSample(); homeservice.callUsStrip(); String
		 * String currentUrl = Action.getCurrentURL(driver);
		 * Log.info("Redirected URL >>>"+currentUrl);
		 * 
		 * Log.info("");
		 * 
		 * Log.info("---------------------Test Passed--------------------------");
		 * 
		 * 
		 * 
		 * }
		 * 
		 * @Test(priority=15) public void getServiceAssignmentByCitiesList() {
		 * 
		 * homeservice = new HomePage(); homeservice.excelDemoServiceHover();
		 * homeservice.getServiceAssignmentByCities();
		 * 
		 * 
		 * }
		 * 
		 * 
		 * 
		 * @Test(priority=16 ,dataProvider = "assignmentcities", dataProviderClass =
		 * DataProviders.class , description =
		 * "Verify all services>> Main >> Topic are availble or not as per requirement "
		 * ) public void ServiceTestAssignmentByCities(String menuservice ,String
		 * mainservice , String servicetopic) {
		 * 
		 * Log.info("Excel user is trying to hover on the services"); homeservice = new
		 * HomePage();
		 * 
		 * 
		 * homeservice.excelDemoServiceHover();
		 * Log.info("Retriving data from the Excel sheet");
		 * homeservice.excelDemoService(mainservice);
		 * 
		 * homeservice.excelDemoTopic(servicetopic);
		 * 
		 * 
		 * homeservice.getBannerFeatureContentElement(); homeservice.priceCalculator();
		 * 
		 * 
		 * homeservice.toolsSection();
		 * 
		 * homeservice.writerSection(); homeservice.featureSection();
		 * homeservice.serviceSection(); homeservice.dealsSection();
		 * 
		 * homeservice.reviewsSection();
		 * 
		 * //strips homeservice.bannerOrderSample(); homeservice.callUsStrip(); String
		 * String currentUrl = Action.getCurrentURL(driver);
		 * Log.info("Redirected URL >>>"+currentUrl);
		 * 
		 * Log.info("");
		 * 
		 * Log.info("---------------------Test Passed--------------------------");
		 * 
		 * 
		 * 
		 * }
		 * 
		 * @Test(priority=17) public void getServiceThesisHelpList() {
		 * 
		 * homeservice = new HomePage(); homeservice.excelDemoServiceHover();
		 * homeservice.getServiceThesisHelp();
		 * 
		 * 
		 * }
		 * 
		 * @Test(priority=18 ,dataProvider = "thesishelp", dataProviderClass =
		 * DataProviders.class , description =
		 * "Verify all services>> Main >> Topic are availble or not as per requirement "
		 * ) public void ServiceTestThesisHelp (String menuservice ,String mainservice ,
		 * String servicetopic) {
		 * 
		 * Log.info("Excel user is trying to hover on the services"); homeservice = new
		 * HomePage();
		 * 
		 * 
		 * homeservice.excelDemoServiceHover();
		 * Log.info("Retriving data from the Excel sheet");
		 * homeservice.excelDemoService(mainservice);
		 * 
		 * homeservice.excelDemoTopic(servicetopic);
		 * 
		 * 
		 * homeservice.getBannerFeatureContentElement(); homeservice.priceCalculator();
		 * 
		 * 
		 * homeservice.toolsSection();
		 * 
		 * homeservice.writerSection(); homeservice.featureSection();
		 * homeservice.serviceSection(); homeservice.dealsSection();
		 * 
		 * homeservice.reviewsSection();
		 * 
		 * //strips homeservice.bannerOrderSample(); homeservice.callUsStrip(); String
		 * String currentUrl = Action.getCurrentURL(driver);
		 * Log.info("Redirected URL >>>"+currentUrl);
		 * 
		 * Log.info("");
		 * 
		 * Log.info("---------------------Test Passed--------------------------");
		 * 
		 * 
		 * 
		 * }
		 * 
		 * 
		 * @Test(priority=19) public void getServiceHomeworkServicesList() {
		 * 
		 * homeservice = new HomePage(); homeservice.excelDemoServiceHover();
		 * homeservice.getServiceHomeworkServices();
		 * 
		 * 
		 * }
		 * 
		 * 
		 * 
		 * @Test(priority=20 ,dataProvider = "homeworkservices", dataProviderClass =
		 * DataProviders.class , description =
		 * "Verify all services>> Main >> Topic are availble or not as per requirement "
		 * ) public void ServiceTestHomeworkServices (String menuservice ,String
		 * mainservice , String servicetopic) {
		 * 
		 * Log.info("Excel user is trying to hover on the services"); homeservice = new
		 * HomePage();
		 * 
		 * 
		 * homeservice.excelDemoServiceHover();
		 * Log.info("Retriving data from the Excel sheet");
		 * homeservice.excelDemoService(mainservice);
		 * 
		 * homeservice.excelDemoTopic(servicetopic);
		 * 
		 * 
		 * homeservice.getBannerFeatureContentElement(); homeservice.priceCalculator();
		 * 
		 * 
		 * homeservice.toolsSection();
		 * 
		 * homeservice.writerSection(); homeservice.featureSection();
		 * homeservice.serviceSection(); homeservice.dealsSection();
		 * 
		 * homeservice.reviewsSection();
		 * 
		 * //strips homeservice.bannerOrderSample(); homeservice.callUsStrip(); String
		 * String currentUrl = Action.getCurrentURL(driver);
		 * Log.info("Redirected URL >>>"+currentUrl);
		 * 
		 * Log.info("");
		 * 
		 * Log.info("---------------------Test Passed--------------------------");
		 * 
		 * 
		 * 
		 * }
		 * 
		 * 
		 * 
		 * @Test(priority=21) public void getServiceEssaySubjectsList() {
		 * 
		 * homeservice = new HomePage(); homeservice.excelDemoServiceHover();
		 * homeservice.getServiceEssaySubjects();
		 * 
		 * 
		 * }
		 * 
		 * 
		 * @Test(priority=22 ,dataProvider = "essaysubject", dataProviderClass =
		 * DataProviders.class , description =
		 * "Verify all services>> Main >> Topic are availble or not as per requirement "
		 * ) public void ServiceTestEssaySubjects (String menuservice ,String
		 * mainservice , String servicetopic) {
		 * 
		 * Log.info("Excel user is trying to hover on the services"); homeservice = new
		 * HomePage();
		 * 
		 * 
		 * homeservice.excelDemoServiceHover();
		 * Log.info("Retriving data from the Excel sheet");
		 * homeservice.excelDemoService(mainservice);
		 * 
		 * homeservice.excelDemoTopic(servicetopic);
		 * 
		 * 
		 * homeservice.getBannerFeatureContentElement(); homeservice.priceCalculator();
		 * 
		 * 
		 * homeservice.toolsSection();
		 * 
		 * homeservice.writerSection(); homeservice.featureSection();
		 * homeservice.serviceSection(); homeservice.dealsSection();
		 * 
		 * homeservice.reviewsSection();
		 * 
		 * //strips homeservice.bannerOrderSample(); homeservice.callUsStrip(); String
		 * String currentUrl = Action.getCurrentURL(driver);
		 * Log.info("Redirected URL >>>"+currentUrl);
		 * 
		 * Log.info("");
		 * 
		 * Log.info("---------------------Test Passed--------------------------");
		 * 
		 * 
		 * 
		 * }
		 * 
		 * 
		 * 
		 * 
		 */
	
	
}
