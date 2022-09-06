/**
 * 
 */
package com.gahcomau.pageobjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.gahcomau.actiondriver.Action;
import com.gahcomau.base.BaseClass;
import com.gahcomau.servicepage.btecAssignmentHelp;
import com.gahcomau.utility.ExtentManager;
import com.gahcomau.utility.ListenerClass;
import com.gahcomau.utility.Log;

/**
 * @author Cognus Technology
 *
 */
public class HomePage extends BaseClass implements ITestListener{

	ExtentReports extent;
	ExtentTest test;
	ExtentManager manager;
	ListenerClass ls;

	@FindBy(xpath = "//li[@class=\"order_btn\"]")
	WebElement OrderBtnGAH;

	@FindBy(xpath = "//*[@id=\"ass_group_list\"]")
	WebElement SelectServices;

	@FindBy(xpath = "//select[@id='assignment_subject']")
	WebElement SelectSubject;

	@FindBy(xpath = "//*[@id=\"pages_count\"]")
	WebElement SelectPages;

	@FindBy(xpath = "//select[@id='urgency']")
	WebElement SelectUrgency;

	@FindBy(xpath = "//button[contains(text(),'Get Free Quote')]")
	WebElement getQuoteBtn;

	// Home Page other element
	// main menu
	@FindBy(xpath = "//ul/li/a[@class=\"services-link toggle_sm\"]")
	WebElement Services;

	// div[@class="feature-content"]/span
	@FindBy(xpath = "//div[@class=\"feature-content\"]/span")
	WebElement bannerElement;

	@FindBy(xpath = "//h1[@class=\"heading\"]")
	WebElement Heading;

	@FindBy(xpath = "//h2[@class=\"subheading\"]")
	WebElement subheading;

	@FindBy(xpath = "//*[@id=\"serv-menu\"]/li/div/ul/li")
	WebElement sublist;

	@FindBy(xpath = "//span[contains(text(),'Price Calculator')]")
	WebElement priceCalculater;

	@FindBy(xpath = "//div[@class=\"banner-samples\"]")
	WebElement bannerOrderSample;

	@FindBy(xpath = "//div/a[@class=\"button-order-now\"]")
	WebElement bannerOrderBtn;

	@FindBy(xpath = "//div/a[@class=\"button-view-samples\"]")
	WebElement bannerSampleBtn;

	// div[@class="card tool"]
	@FindBy(xpath = "//div[@class=\"card tool\"]")
	WebElement toolsSection;

	@FindBy(xpath = "//span[contains(text(),'Free Paraphrasing Tool')]")
	WebElement FreeParaphrasingTool;

	@FindBy(xpath = "//span[contains(text(),'Grammer Checker Tool')]")
	WebElement GrammerCheckerTool;

	@FindBy(xpath = "//span[contains(text(),'Essay Typer Tool')]")
	WebElement EssayTyperTool;

	@FindBy(xpath = "//span[contains(text(),'Plagiarism Checker Tool')]")
	WebElement PlagiarismCheckerTool;

	@FindBy(xpath = "//button[contains(text(),'Get Price Quote')]")
	WebElement GetPriceQuote;

	@FindBy(xpath = "//div[@class=\"card writer\"]")
	WebElement writerSection;

	@FindBy(xpath = "//div[@class=\"feature card\"]")
	WebElement featureSection;

	@FindBy(xpath = "//a[contains(text(),'Try it for FREE')]")
	WebElement tryFreeButton;

	@FindBy(xpath = "//div[@class=\"card service\"]")
	WebElement serviceSection;

	@FindBy(xpath = "//div[@class=\"best-deal card sticky\"]")
	WebElement dealsSection;

	@FindBy(xpath = "//div[@class=\"strip-call-us\"]")
	WebElement callUsStrip;

	@FindBy(xpath = "//div[@class=\"button-click\"]/a[1]")
	WebElement requestCallBackBtnCallStrip;

	@FindBy(xpath = "//div[@class=\"button-click\"]/a[2]")
	WebElement orderBtnCallStrip;

	@FindBy(xpath = "//div[@class=\"populr-search-slider slick-initialized slick-slider slick-dotted\"]")
	WebElement reviewsSection;

	// Services

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Get Title
	public String getTitle() {
		String actualTitle = driver.getTitle();
		Log.info("Actual Page Title is : " + actualTitle);
		return actualTitle;
	}

	public OrderPage clickOnOrderNowBtnGAH() {
		Action.click(driver, OrderBtnGAH);
		Action.fluentWait(driver, OrderBtnGAH, 5);

		// System.out.println("Clicking on Order Now Button");
		return new OrderPage();

	}

	// Click On the Select Service Button
	public void clickOnSelectServicesBtn() {
		Action.click(driver, SelectServices);
		// System.out.println("Clicking on select service");

	}
	// Click On the Select Subjct Button

	public void clickOnSelectSubjectBtn() {
		Action.click(driver, SelectSubject);
		// System.out.println("Clicking on select Subject");

	}

	// Selecting the first value Assignment | Coursework | Term Paper
	public void selectServices(String selectservice) {
		Select drop = new Select(SelectServices);
		// drop.selectByIndex(selectservice);
		drop.selectByVisibleText(selectservice);

		Action.fluentWait(driver, SelectServices, 10);

		WebElement o = drop.getFirstSelectedOption();
		String selectedoption = o.getText();
		Action.fluentWait(driver, SelectServices, 10);
		Log.info("Selected Service Text: " + selectedoption);
	}

	// Selecting Subject
	public void SelectSubject(String selectsubject) {
		Select drop2 = new Select(SelectSubject);

		// drop.selectByIndex(2);
		drop2.selectByVisibleText(selectsubject);

		Action.fluentWait(driver, SelectSubject, 05);

		// System.out.println("Selecting subject");
		WebElement o = drop2.getFirstSelectedOption();
		String selectedoption = o.getText();
		Log.info("Selected Subject Text: " + selectedoption);

	}

	// Getting text and verifying text with expected text
	public String SelectPages(String selectpages) {
		Select drop3 = new Select(SelectPages);
		drop3.selectByVisibleText(selectpages);
		Log.info("Selected Page :>>" + SelectPages);

		WebElement o = drop3.getFirstSelectedOption();
		String selectedoption = o.getText();
		Log.info("Selected Pages Text: " + selectedoption);
		return selectedoption;

	}

	// Checking the text select urgency

	public String SelectUrgencyText() {
		Select drop4 = new Select(SelectUrgency);
		WebElement o = drop4.getFirstSelectedOption();
		String selectedoption = o.getText();
		Log.info("Selected Urgency Text: " + selectedoption);
		return selectedoption;

	}

	// Clicking on get Free Quote Button
	public OrderPage getQuoteBtn() {
		Action.click(driver, getQuoteBtn);
		Action.fluentWait(driver, getQuoteBtn, 10);

		String RedirectedPageURL = Action.getCurrentURL(driver);
		Log.info("User is Redirected to this URL" + RedirectedPageURL);

		return new OrderPage();

	}

	// ***********************************************************************************************************

	public void hoverService() {

		Actions actions = new Actions(driver);
		actions.moveToElement(Services).perform();
		String a = Services.getText();
		Log.info("Service is " + a);

	}

	/*
	 * public void hoverMainService0() { Action.hoverElement(AssignmentServices);
	 * String b = AssignmentServices.getText(); Log.info("Main Service is " + b);
	 * 
	 * }
	 * 
	 * public void hoverSubService1() { Action.hoverElement(AcademicWritingService);
	 * String b = AcademicWritingService.getText();
	 * Log.info("(Home Page)Sub- Service is " + b);
	 * 
	 * 
	 * }
	 * 
	 * public btecAssignmentHelp ClickSubject() {
	 * 
	 * Action.fluentWait(driver, BTECAssignmentHelp, 10); Action.JSClick(driver,
	 * BTECAssignmentHelp); //Action.click(driver, BTECAssignmentHelp); return new
	 * btecAssignmentHelp(); }
	 */

	// ****************************************** Excel
	// *****************************************************************

	public void excelDemoServiceHover() {

		try {

			WebElement ServicesExcel = driver.findElement(By.xpath("//span[contains(text(),'Services')]"));

			Action.hoverElement(ServicesExcel);
			String b = ServicesExcel.getText();
			Log.info("User is Hovered on :>> " + b);

			test = ExtentManager.test.log(Status.PASS, "User is Hovered on :>> " + b);

		} catch (Exception e) {
			Log.info("--------<<<<<<<<<<<<<<Test is fail >>>>>>>>>>>>>>>>>>>>>>>>--------------");

			test = ExtentManager.test.log(Status.FAIL,
					MarkupHelper.createLabel("Unable to hover on service - Test Failed", ExtentColor.RED));
		
			ExtentManager.test.fail(e);
			Assert.fail();
		}

	}

	public void excelDemoService(String mainservice) {

		try {
			// *[@id="serv-menu"]/li[1]/a[contains(text(),'Assignment Subjects ')]
			WebElement AssignmentServicesExcel = driver.findElement(
					By.xpath("//*[@id=\"serv-menu\"]/li[*]/a[contains(text()," + "'" + mainservice + "'" + ")]"));
			Action.hoverElement(AssignmentServicesExcel);
			String b = AssignmentServicesExcel.getText();
			Log.info("Hovered on main Service :>>  " + b);
			test = ExtentManager.test.log(Status.PASS, "Hovered on main Service :>>  " + b);

		} catch (Exception e) {
			Log.info("--------<<<<<<<<<<<<<<Test is fail >>>>>>>>>>>>>>>>>>>>>>>>--------------");

			test = ExtentManager.test.log(Status.FAIL,
					MarkupHelper.createLabel("Unable to hover on Main Service - Test Failed", ExtentColor.RED));
		
			ExtentManager.test.fail(e);
			Assert.fail();
		
		}

	}

	public void excelDemoSubject(String servicesubject) {

		try {
			WebElement AcademicWritingServiceExcel = driver
					.findElement(By.xpath("//div/ul/li/a[contains(text()," + "'" + servicesubject + "'" + ")]"));

			Action.hoverElement(AcademicWritingServiceExcel);
			String b = AcademicWritingServiceExcel.getText();
			Log.info("Hovered on Subject :>> " + b);
			test = ExtentManager.test.log(Status.PASS, "Hovered on Subject :>> " + b);

		} catch (Exception e) {
			Log.info("--------<<<<<<<<<<<<<<Test is fail >>>>>>>>>>>>>>>>>>>>>>>>--------------");

			test = ExtentManager.test.log(Status.FAIL,
					MarkupHelper.createLabel("Unable to hover on Subject - Test Failed", ExtentColor.RED));
			ExtentManager.test.fail(e);
			Assert.fail();
		
		}

	}

	public void excelDemoTopic(String servicetopic) {

		try {
			WebElement serviceTopic = driver.findElement(By.xpath(
					"//*[@id=\"serv-menu\"]/li[*]/div/ul/li/a[contains(text()," + "'" + servicetopic + "'" + ")]"));
			Action.hoverElement(serviceTopic);
			String b = serviceTopic.getText();
			Log.info("Hovered on Topic :>>  " + b);

			Action.JSClick(driver, serviceTopic);

			// h1[contains(text(),'"++"Assignment Help')]

			try {
				// Printing heading
				String headingText = Heading.getText();
				Log.info("Heading Text is :>> " + headingText);

				test = ExtentManager.test.log(Status.PASS, "Heading Text is :>> " + headingText);

			} catch (Exception e) {
				test = ExtentManager.test.log(Status.FAIL,
						MarkupHelper.createLabel("Unable to Find Heading Text - Test Failed", ExtentColor.RED));
			
				ExtentManager.test.fail(e);
				Assert.fail();
			
			}

			try {

				// Printing Sub heading
				String subheadingText = subheading.getText();
				Log.info("Sub-Heading Text is :>> " + subheadingText);

			} catch (Exception e) {
				test = ExtentManager.test.log(Status.FAIL,
						MarkupHelper.createLabel("Unable to Find Sub-Heading - Test Failed", ExtentColor.RED));
			
				ExtentManager.test.fail(e);
				Assert.fail();
			}

		} catch (Exception e) {

			Log.info("--------<<<<<<<<<<<<<<Test is fail >>>>>>>>>>>>>>>>>>>>>>>>--------------");

			test = ExtentManager.test.log(Status.FAIL,
					MarkupHelper.createLabel("Unable to hover on Topic - Test Failed", ExtentColor.RED));
		
			ExtentManager.test.fail(e);
			Assert.fail();
		
		}

	}

	public void getServiceList() {

		try {
			List<WebElement> service_main_list = driver
					.findElements(By.xpath("//div[@class=\"service-inner\"]/ul/li/a"));

			for (int i = 0; i < service_main_list.size(); i++) {

				String pageFound = service_main_list.get(i).getText();
				Log.info(" Main Service Found : " + pageFound);
				test = ExtentManager.test.log(Status.PASS, " Main Service Found : " + pageFound );
			}

			int a = service_main_list.size();
			Log.info("Total Main Subject found : " + a);

			test = ExtentManager.test.log(Status.PASS, MarkupHelper.createLabel("Total Main Subject found : " + a ,ExtentColor.AMBER ));

			Log.info("--------Test is passed----------");
			Log.info("");

		} catch (Exception e) {

			Log.info("--------<<<<<<<<<<<<<<Test is fail >>>>>>>>>>>>>>>>>>>>>>>>--------------");

			test = ExtentManager.test.log(Status.FAIL,
					MarkupHelper.createLabel("Unable to Get Main Service List - Test Failed", ExtentColor.RED));
		
			ExtentManager.test.fail(e);
			Assert.fail();
		
		}

	}

	public void getServiceSubjectList() {

		try {

			List<WebElement> service_sub_list = driver.findElements(By.xpath("//*[@id=\"serv-menu\"]/li/div/ul/li/a"));

			for (int i = 0; i < service_sub_list.size(); i++) {

				String pageFound = service_sub_list.get(i).getText();

				Log.info(" Subject Found : " + pageFound);
				// System.out.println(pageFound);

			}

			int a = service_sub_list.size();
			Log.info("Total subject found : " + a);

			Log.info("Test is passed");
			Log.info("");

		} catch (Exception e) {

			Log.info("--------<<<<<<<<<<<<<<Test is fail >>>>>>>>>>>>>>>>>>>>>>>>--------------");

			test = ExtentManager.test.log(Status.FAIL,
					MarkupHelper.createLabel("Unable to Get Service Subjects List - Test Failed", ExtentColor.RED));
		
			ExtentManager.test.fail(e);
			Assert.fail();
		
		}

	}

	public void getServiceAssignmentSubjects() {

		try {

			List<WebElement> service_sub_list = driver
					.findElements(By.xpath("//*[@id=\"serv-menu\"]/li[1]/div/ul/li/a"));

			for (int i = 0; i < service_sub_list.size(); i++) {

				String pageFound = service_sub_list.get(i).getText();

				Log.info(" Subject Found : " + pageFound);
				// System.out.println(pageFound);

			}

			int a = service_sub_list.size();
			Log.info("Total subject found : " + a);
			
			test = ExtentManager.test.log(Status.INFO, MarkupHelper
					.createLabel( "Total subject found : " + a , ExtentColor.AMBER ));

			Log.info("Test is passed");
			Log.info("");

		} catch (Exception e) {

			Log.info("--------<<<<<<<<<<<<<<Test is fail >>>>>>>>>>>>>>>>>>>>>>>>--------------");

			test = ExtentManager.test.log(Status.FAIL, MarkupHelper
					.createLabel("Unable to Get Assignment Service Subjects List - Test Failed", ExtentColor.RED));
		
			ExtentManager.test.fail(e);
			Assert.fail();
			
		
		}

	}

	public void getServiceEngineeringSubjects() {

		try {

			List<WebElement> enggservice_sub_list = driver
					.findElements(By.xpath("//*[@id=\"serv-menu\"]/li[2]/div/ul/li/a"));

			for (int i = 0; i < enggservice_sub_list.size(); i++) {

				String ennpageFound = enggservice_sub_list.get(i).getText();

				// Log.info(" Subject Found : " + ennpageFound);
				// System.out.println(ennpageFound);

				String a = enggservice_sub_list.get(i).getAttribute("textContent");
				// Log.info("Subject Found : " + a);
				System.out.println(a);
				// Log.info("");

			}

			int a = enggservice_sub_list.size();
			Log.info("Total subject found : " + a);

			Log.info("Test is passed");
			Log.info("");

		} catch (Exception e) {

			Log.info("--------<<<<<<<<<<<<<<Test is fail >>>>>>>>>>>>>>>>>>>>>>>>--------------");

			test = ExtentManager.test.log(Status.FAIL, MarkupHelper
					.createLabel("Unable to Get Engineering Subjects Service List - Test Failed", ExtentColor.RED));
		
			ExtentManager.test.fail(e);
			Assert.fail();
		
		}

	}

	public void getServiceManagemenetSubjects() {

		try {

			List<WebElement> enggservice_sub_list = driver
					.findElements(By.xpath("//*[@id=\"serv-menu\"]/li[3]/div/ul/li/a"));

			for (int i = 0; i < enggservice_sub_list.size(); i++) {

				String ennpageFound = enggservice_sub_list.get(i).getText();

				// Log.info(" Subject Found : " + ennpageFound);
				// System.out.println(ennpageFound);

				String a = enggservice_sub_list.get(i).getAttribute("textContent");
				// Log.info("Subject Found : " + a);
				System.out.println(a);
				// Log.info("");

			}

			int a = enggservice_sub_list.size();
			Log.info("Total subject found : " + a);

			Log.info("Test is passed");
			Log.info("");

		} catch (Exception e) {

			Log.info("--------<<<<<<<<<<<<<<Test is fail >>>>>>>>>>>>>>>>>>>>>>>>--------------");

			test = ExtentManager.test.log(Status.FAIL, MarkupHelper
					.createLabel("Unable to Get Managemenet Subjects Service List - Test Failed", ExtentColor.RED));
		
			ExtentManager.test.fail(e);
			Assert.fail();
		
		}

	}

	public void getServiceDissertationHelp() {

		try {

			List<WebElement> enggservice_sub_list = driver
					.findElements(By.xpath("//*[@id=\"serv-menu\"]/li[4]/div/ul/li/a"));

			for (int i = 0; i < enggservice_sub_list.size(); i++) {

				String ennpageFound = enggservice_sub_list.get(i).getText();

				// Log.info(" Subject Found : " + ennpageFound);
				// System.out.println(ennpageFound);

				String a = enggservice_sub_list.get(i).getAttribute("textContent");
				// Log.info("Subject Found : " + a);
				System.out.println(a);
				// Log.info("");

			}

			int a = enggservice_sub_list.size();
			Log.info("Total subject found : " + a);

			Log.info("Test is passed");
			Log.info("");

		} catch (Exception e) {

			Log.info("--------<<<<<<<<<<<<<<Test is fail >>>>>>>>>>>>>>>>>>>>>>>>--------------");

			test = ExtentManager.test.log(Status.FAIL, MarkupHelper
					.createLabel("Unable to Get Dissertation Help Service List - Test Failed", ExtentColor.RED));
		
			ExtentManager.test.fail(e);
			Assert.fail();
		
		}

	}

	public void getServiceLawSubjects() {

		try {

			List<WebElement> enggservice_sub_list = driver
					.findElements(By.xpath("//*[@id=\"serv-menu\"]/li[5]/div/ul/li/a"));

			for (int i = 0; i < enggservice_sub_list.size(); i++) {

				String ennpageFound = enggservice_sub_list.get(i).getText();

				// Log.info(" Subject Found : " + ennpageFound);
				// System.out.println(ennpageFound);

				String a = enggservice_sub_list.get(i).getAttribute("textContent");
				// Log.info("Subject Found : " + a);
				System.out.println(a);
				// Log.info("");

			}

			int a = enggservice_sub_list.size();
			Log.info("Total subject found : " + a);

			Log.info("Test is passed");
			Log.info("");

		} catch (Exception e) {

			Log.info("--------<<<<<<<<<<<<<<Test is fail >>>>>>>>>>>>>>>>>>>>>>>>--------------");

			test = ExtentManager.test.log(Status.FAIL,
					MarkupHelper.createLabel("Unable to Get Law Subjects Service List - Test Failed", ExtentColor.RED));
		
			ExtentManager.test.fail(e);
			Assert.fail();
		
		}

	}

	public void getServiceCourseworkHelp() {

		try {

			List<WebElement> enggservice_sub_list = driver
					.findElements(By.xpath("//*[@id=\"serv-menu\"]/li[6]/div/ul/li/a"));

			for (int i = 0; i < enggservice_sub_list.size(); i++) {

				String ennpageFound = enggservice_sub_list.get(i).getText();

				// Log.info(" Subject Found : " + ennpageFound);
				// System.out.println(ennpageFound);

				String a = enggservice_sub_list.get(i).getAttribute("textContent");
				// Log.info("Subject Found : " + a);
				System.out.println(a);
				// Log.info("");

			}

			int a = enggservice_sub_list.size();
			Log.info("Total subject found : " + a);

			Log.info("Test is passed");
			Log.info("");

		} catch (Exception e) {

			Log.info("--------<<<<<<<<<<<<<<Test is fail >>>>>>>>>>>>>>>>>>>>>>>>--------------");

			test = ExtentManager.test.log(Status.FAIL, MarkupHelper
					.createLabel("Unable to Get Coursework Help Service List - Test Failed", ExtentColor.RED));
		
			ExtentManager.test.fail(e);
			Assert.fail();
		
		}

	}

	public void getServiceAssignmentByCities() {

		try {

			List<WebElement> enggservice_sub_list = driver
					.findElements(By.xpath("//*[@id=\"serv-menu\"]/li[7]/div/ul/li/a"));

			for (int i = 0; i < enggservice_sub_list.size(); i++) {

				String ennpageFound = enggservice_sub_list.get(i).getText();

				// Log.info(" Subject Found : " + ennpageFound);
				// System.out.println(ennpageFound);

				String a = enggservice_sub_list.get(i).getAttribute("textContent");
				// Log.info("Subject Found : " + a);
				System.out.println(a);
				// Log.info("");

			}

			int a = enggservice_sub_list.size();
			Log.info("Total subject found : " + a);

			Log.info("Test is passed");
			Log.info("");

		} catch (Exception e) {

			Log.info("--------<<<<<<<<<<<<<<Test is fail >>>>>>>>>>>>>>>>>>>>>>>>--------------");

			test = ExtentManager.test.log(Status.FAIL, MarkupHelper
					.createLabel("Unable to Get Assignment By Cities Service List - Test Failed", ExtentColor.RED));
		
			ExtentManager.test.fail(e);
			Assert.fail();
		
		}

	}

	public void getServiceThesisHelp() {

		try {

			List<WebElement> enggservice_sub_list = driver
					.findElements(By.xpath("//*[@id=\"serv-menu\"]/li[8]/div/ul/li/a"));

			for (int i = 0; i < enggservice_sub_list.size(); i++) {

				String ennpageFound = enggservice_sub_list.get(i).getText();

				// Log.info(" Subject Found : " + ennpageFound);
				// System.out.println(ennpageFound);

				String a = enggservice_sub_list.get(i).getAttribute("textContent");
				// Log.info("Subject Found : " + a);
				System.out.println(a);
				// Log.info("");

			}

			int a = enggservice_sub_list.size();
			Log.info("Total subject found : " + a);

			Log.info("Test is passed");
			Log.info("");

		} catch (Exception e) {

			Log.info("--------<<<<<<<<<<<<<<Test is fail >>>>>>>>>>>>>>>>>>>>>>>>--------------");

			test = ExtentManager.test.log(Status.FAIL,
					MarkupHelper.createLabel("Unable to Get Thesis Help Service List - Test Failed", ExtentColor.RED));
		
			ExtentManager.test.fail(e);
			Assert.fail();
		
		}
	}

	public void getServiceHomeworkServices() {

		try {

			List<WebElement> enggservice_sub_list = driver
					.findElements(By.xpath("//*[@id=\"serv-menu\"]/li[9]/div/ul/li/a"));

			for (int i = 0; i < enggservice_sub_list.size(); i++) {

				String ennpageFound = enggservice_sub_list.get(i).getText();

				// Log.info(" Subject Found : " + ennpageFound);
				// System.out.println(ennpageFound);

				String a = enggservice_sub_list.get(i).getAttribute("textContent");
				// Log.info("Subject Found : " + a);
				System.out.println(a);
				// Log.info("");

			}

			int a = enggservice_sub_list.size();
			Log.info("Total subject found : " + a);

			Log.info("Test is passed");
			Log.info("");

		} catch (Exception e) {

			Log.info("--------<<<<<<<<<<<<<<Test is fail >>>>>>>>>>>>>>>>>>>>>>>>--------------");

			test = ExtentManager.test.log(Status.FAIL, MarkupHelper
					.createLabel("Unable to Get Homework Services Service List - Test Failed", ExtentColor.RED));
		
			ExtentManager.test.fail(e);
			Assert.fail();
		
		}

	}

	public void getServiceEssaySubjects() {

		try {

			List<WebElement> enggservice_sub_list = driver
					.findElements(By.xpath("//*[@id=\"serv-menu\"]/li[10]/div/ul/li/a"));

			for (int i = 0; i < enggservice_sub_list.size(); i++) {

				String ennpageFound = enggservice_sub_list.get(i).getText();

				// Log.info(" Subject Found : " + ennpageFound);
				// System.out.println(ennpageFound);

				String a = enggservice_sub_list.get(i).getAttribute("textContent");
				// Log.info("Subject Found : " + a);
				System.out.println(a);
				// Log.info("");

			}

			int a = enggservice_sub_list.size();
			Log.info("Total subject found : " + a);

			Log.info("Test is passed");
			Log.info("");

		} catch (Exception e) {

			Log.info("--------<<<<<<<<<<<<<<Test is fail >>>>>>>>>>>>>>>>>>>>>>>>--------------");

			test = ExtentManager.test.log(Status.FAIL, MarkupHelper
					.createLabel("Unable to Get Essay Subjects Service List - Test Failed", ExtentColor.RED));
		
			ExtentManager.test.fail(e);
			Assert.fail();
		
		}

	}

	public void getBannerFeatureContentElement() {

		try {

			List<WebElement> banner_element = driver.findElements(By.xpath("//div[@class=\"feature-content\"]/span"));

			for (int i = 0; i < banner_element.size(); i++) {

				String pageFound = banner_element.get(i).getText();

				Log.info(" Banner Element Found : " + pageFound);
				// System.out.println(pageFound);

			}

			int a = banner_element.size();
			Log.info(" Banner Element Found : " + a);

			Log.info("");

			Log.info("Test is passed");
			Log.info("");

		} catch (Exception e) {

			Log.info("--------<<<<<<<<<<<<<<Test is fail >>>>>>>>>>>>>>>>>>>>>>>>--------------");

			test = ExtentManager.test.log(Status.FAIL, MarkupHelper
					.createLabel("Unable to Get Main Banner on top Content  - Test Failed", ExtentColor.RED));
		
			ExtentManager.test.fail(e);
			Assert.fail();
		
		}

	}

	public void priceCalculator() {

		try {

			Log.info("Verifying price calculator is dispayed or not");
			test = ExtentManager.test.log(Status.INFO,
					MarkupHelper.createLabel("Verifying price calculator is dispayed or not", ExtentColor.BLUE));
			Action.isDisplayed(driver, priceCalculater);
			Log.info("");

			Log.info("Test is passed");
			Log.info("");

		} catch (Exception e) {

			Log.info("--------<<<<<<<<<<<<<<Test is fail >>>>>>>>>>>>>>>>>>>>>>>>--------------");

			test = ExtentManager.test.log(Status.FAIL,
					MarkupHelper.createLabel(" Price calculator is not Dispayed - Test Failed", ExtentColor.RED));
		
			ExtentManager.test.fail(e);
			Assert.fail();
		
		}
	}

	public void bannerOrderSample() {

		Log.info("Verifying Order Banner is dispayed or not");

		test = ExtentManager.test.log(Status.INFO,
				MarkupHelper.createLabel("Verifying Order Banner is dispayed or not", ExtentColor.BLUE));

		// Action.isDisplayed(driver, bannerOrderSample);

		try {
			if (bannerOrderSample.isDisplayed()) {
				Action.scrollByVisibilityOfElement(driver, bannerOrderSample);
				Log.info("");

				Log.info("Clicking on order button on order strip");
				Action.scrollByVisibilityOfElement(driver, bannerOrderBtn);
				Action.JSClick(driver, bannerOrderBtn);
				String RedirectedURLOrder = Action.getCurrentURL(driver);
				Assert.assertEquals(RedirectedURLOrder, "https://customerpanel.globalassignmenthelp.com.au/order");
				driver.navigate().back();
				Log.info("");

				Log.info("Clicking on View Sample on order strip");
				Action.scrollByVisibilityOfElement(driver, bannerSampleBtn);
				Action.JSClick(driver, bannerSampleBtn);
				String RedirectedURLSample = Action.getCurrentURL(driver);
				Assert.assertEquals(RedirectedURLSample, "https://www.globalassignmenthelp.com.au/free-samples");
				driver.navigate().back();
				Log.info("");

				Log.info("Test is passed");
				Log.info("");

			}
		} catch (Exception e) {

			Log.info("--------<<<<<<<<<<<<<<Test is fail >>>>>>>>>>>>>>>>>>>>>>>>--------------");

			test = ExtentManager.test.log(Status.INFO,
					MarkupHelper.createLabel(" Order Banner is not Dispalyed", ExtentColor.RED));
		
			ExtentManager.test.fail(e);
			Assert.fail();
		
		}

	}

	public void toolsSection() {

		Log.info("Verifying Tool section is present or not");

		try {

			test = ExtentManager.test.log(Status.INFO,
					MarkupHelper.createLabel("Verifying Tool section is present or not", ExtentColor.BLUE));
			Action.isDisplayed(driver, toolsSection);
			Action.scrollByVisibilityOfElement(driver, toolsSection);
			Log.info("");
		} catch (Exception e) {

			Log.info("--------<<<<<<<<<<<<<<Test is fail >>>>>>>>>>>>>>>>>>>>>>>>--------------");

			test = ExtentManager.test.log(Status.FAIL,
					MarkupHelper.createLabel(" Tool section is not Dispalyed", ExtentColor.RED));
		
			ExtentManager.test.fail(e);
			Assert.fail();
		
		}

		try {

			Log.info("Clicking on tool paraphrasing-tool");
			test = ExtentManager.test.log(Status.INFO, "Clicking on tool paraphrasing-tool");

			Action.scrollByVisibilityOfElement(driver, FreeParaphrasingTool);
			Action.JSClick(driver, FreeParaphrasingTool);
			String RedirectedURL1 = driver.getCurrentUrl();
			Log.info("RedirectedURL >>> " + RedirectedURL1);
			Assert.assertEquals(RedirectedURL1, "https://www.globalassignmenthelp.com.au/paraphrasing-tool");
			driver.navigate().back();
			Log.info("");

		} catch (Exception e) {

			Log.info("--------<<<<<<<<<<<<<<Test is fail >>>>>>>>>>>>>>>>>>>>>>>>--------------");

			test = ExtentManager.test.log(Status.FAIL,
					MarkupHelper.createLabel("Clicking on tool paraphrasing-tool - Test Failed ", ExtentColor.RED));
		
			ExtentManager.test.fail(e);
			Assert.fail();
		
		}

		try {

			Log.info("Clicking on tool grammar-checker");

			test = ExtentManager.test.log(Status.INFO, "Clicking on tool grammar-checker");

			Action.scrollByVisibilityOfElement(driver, GrammerCheckerTool);
			Action.JSClick(driver, GrammerCheckerTool);
			String RedirectedURL2 = driver.getCurrentUrl();
			Log.info("RedirectedURL >>> " + RedirectedURL2);
			Assert.assertEquals(RedirectedURL2, "https://www.globalassignmenthelp.com.au/grammar-checker");
			driver.navigate().back();
			Log.info("");
		} catch (Exception e) {

			Log.info("--------<<<<<<<<<<<<<<Test is fail >>>>>>>>>>>>>>>>>>>>>>>>--------------");

			test = ExtentManager.test.log(Status.FAIL,
					MarkupHelper.createLabel("Clicking on tool grammar-checker - Test Failed ", ExtentColor.RED));
		
			ExtentManager.test.fail(e);
			Assert.fail();
		
		}

		try {

			Log.info("Clicking on tool Essay Typer Tool");
			test = ExtentManager.test.log(Status.INFO, "Clicking on tool Essay Typer Tool");

			Action.scrollByVisibilityOfElement(driver, EssayTyperTool);
			Action.JSClick(driver, EssayTyperTool);
			String RedirectedURL3 = driver.getCurrentUrl();
			Log.info("RedirectedURL >>> " + RedirectedURL3);
			Assert.assertEquals(RedirectedURL3, "https://www.globalassignmenthelp.com.au/essay-typer");
			driver.navigate().back();
			Log.info("");
		} catch (Exception e) {

			Log.info("--------<<<<<<<<<<<<<<Test is fail >>>>>>>>>>>>>>>>>>>>>>>>--------------");

			test = ExtentManager.test.log(Status.FAIL,
					MarkupHelper.createLabel("Clicking on tool Essay Typer Tool - Test Failed ", ExtentColor.RED));
		
			ExtentManager.test.fail(e);
			Assert.fail();
		
		}

		try {

			Log.info("Clicking on tool Plagiarism Checker Tool");

			test = ExtentManager.test.log(Status.INFO, "Clicking on tool Plagiarism Checker Tool");

			Action.scrollByVisibilityOfElement(driver, PlagiarismCheckerTool);
			Action.JSClick(driver, PlagiarismCheckerTool);
			String RedirectedURL4 = driver.getCurrentUrl();
			Log.info("RedirectedURL >>> " + RedirectedURL4);
			Assert.assertEquals(RedirectedURL4, "https://www.globalassignmenthelp.com.au/plagiarism-checker");
			driver.navigate().back();
			Log.info("");

			Log.info("Test is passed");
			Log.info("");

		} catch (Exception e) {

			Log.info("--------<<<<<<<<<<<<<<Test is fail >>>>>>>>>>>>>>>>>>>>>>>>--------------");

			test = ExtentManager.test.log(Status.FAIL, MarkupHelper
					.createLabel("Clicking on tool Plagiarism Checker Tool- Test Failed ", ExtentColor.RED));
		
			ExtentManager.test.fail(e);
			Assert.fail();
		}

	}

	public void writerSection() {

		try {

			Log.info("Verifying Writer Section is Present or not");

			test = ExtentManager.test.log(Status.INFO,
					MarkupHelper.createLabel("Verifying Writer Section is Present or not", ExtentColor.BLUE));

			Action.scrollByVisibilityOfElement(driver, writerSection);
			Action.isDisplayed(driver, writerSection);
			Log.info("");

			// div[@class="card writer"]/div[@class="card-contain"]/a[2]
			// div[@class="card writer"]/div[@class="card-contain"]/a

			List<WebElement> writer = driver
					.findElements(By.xpath("//div[@class=\"card writer\"]/div[@class=\"card-contain\"]/a"));

			for (int i = 0; i < writer.size(); i++) {

				String writerFound = writer.get(i).getText();

				Log.info(" Writer Card Found : " + writerFound);
				// System.out.println(pageFound);

			}

			Log.info("Clicking on First Writer Card");

			WebElement writerHireBtn = driver
					.findElement(By.xpath("//div[@class=\"card writer\"]/div[@class=\"card-contain\"]/a[2]"));
			Action.scrollByVisibilityOfElement(driver, writerHireBtn);
			Action.JSClick(driver, writerHireBtn);

			String RedirectedURL = driver.getCurrentUrl();
			Log.info("Redirected URL >>> " + RedirectedURL);

			WebElement writerNameonOrderPage = driver.findElement(By.xpath("//div[@class=\"writername\"]"));

			Action.isDisplayed(driver, writerNameonOrderPage);
			driver.navigate().back();
			Log.info("");

			Log.info("Test is passed");
			Log.info("");

		} catch (Exception e) {

			Log.info("--------<<<<<<<<<<<<<<Test is fail >>>>>>>>>>>>>>>>>>>>>>>>--------------");

			test = ExtentManager.test.log(Status.FAIL,
					MarkupHelper.createLabel("Writer Section is Not present ", ExtentColor.RED));
		
			ExtentManager.test.fail(e);
			Assert.fail();
		
		}
	}

	public void featureSection() {

		try {

			Log.info("Verifying Free Feature is Present or not");
			test = ExtentManager.test.log(Status.INFO,
					MarkupHelper.createLabel("Verifying Free Feature is Present or not ", ExtentColor.BLUE));

			Action.isDisplayed(driver, featureSection);

			Log.info("Clicking on button try it free");

			Action.JSClick(driver, tryFreeButton);
			String RedirectedURL = driver.getCurrentUrl();
			Log.info("RedirectedURL >>> " + RedirectedURL);

			Assert.assertEquals(RedirectedURL, "https://customerpanel.globalassignmenthelp.com.au/order");
			driver.navigate().back();
			Log.info("");

			Log.info("Test is passed");
			Log.info("");

		} catch (Exception e) {

			Log.info("--------<<<<<<<<<<<<<<Test is fail >>>>>>>>>>>>>>>>>>>>>>>>--------------");

			test = ExtentManager.test.log(Status.FAIL,
					MarkupHelper.createLabel("Free Feature in side vertical section is Not present ", ExtentColor.RED));
		
			ExtentManager.test.fail(e);
			Assert.fail();
		
		}

	}

	public void serviceSection() {

		try {

			Log.info("Verifying Other Services From us is present or not");
			
			test = ExtentManager.test.log(Status.INFO,
					MarkupHelper.createLabel("Other Services From us in side vertical section is present or not", ExtentColor.BLUE));
		

			
			Action.isDisplayed(driver, serviceSection);
			
			Action.scrollByVisibilityOfElement(driver, serviceSection);

			// div[@class="card service"]/ul/li[*]

			WebElement serviceLinkList = driver.findElement(By.xpath("//div[@class=\"card service\"]/ul/li[*]"));

			String a = serviceLinkList.getAttribute("herf");
			Log.info(a);

			Log.info("");
			Log.info("Test is passed");
			Log.info("");

		} catch (Exception e) {

			Log.info("--------<<<<<<<<<<<<<<Test is fail >>>>>>>>>>>>>>>>>>>>>>>>--------------");
		
			test = ExtentManager.test.log(Status.FAIL, MarkupHelper
					.createLabel("Other Services From us Not present ", ExtentColor.RED));
		
			ExtentManager.test.fail(e);
			Assert.fail();
		
		}
	}

	public void dealsSection() {

		try {

			Log.info("Verifying deals Section is as per requirement or not");
			test = ExtentManager.test.log(Status.INFO,  MarkupHelper
					.createLabel("Other Services From us in side vertical section is Not present ", ExtentColor.BLUE));

			test = ExtentManager.test.log(Status.INFO, "Verifying NEWCUST22");

			WebElement FirstOffer = driver
					.findElement(By.xpath("//label[@class=\"deal-left\"]/span[contains(text(),'NEWCUST22')]"));

			Action.scrollByVisibilityOfElement(driver, FirstOffer);
			Log.info("Clicking on First Offer");
			Action.JSClick(driver, FirstOffer);

			WebElement codeText = driver.findElement(By.xpath("//input[@name=\"code\"]"));

			String a = codeText.getAttribute("value");
			Log.info("Coupon code Value applied : " + a);

			Assert.assertEquals(a, "NEWCUST22");

			driver.navigate().back();
			Log.info("");

		} catch (Exception e) {

			Log.info("--------<<<<<<<<<<<<<<Test is fail >>>>>>>>>>>>>>>>>>>>>>>>--------------");

			test = ExtentManager.test.log(Status.FAIL,
					MarkupHelper.createLabel("NEWCUST22 - Test Failed ", ExtentColor.RED));
		
			ExtentManager.test.fail(e);
			Assert.fail();
		
		}

		try {

			test = ExtentManager.test.log(Status.INFO, "Verifying OFF10");

			WebElement SecoundOffer = driver
					.findElement(By.xpath("//label[@class=\"deal-left\"]/span[contains(text(),'OFF10')]"));
			Action.scrollByVisibilityOfElement(driver, SecoundOffer);
			Log.info("Clicking on Secound Offer");
			Action.JSClick(driver, SecoundOffer);

			WebElement codeText2 = driver.findElement(By.xpath("//input[@name=\"code\"]"));

			Action.waitForVisible(driver, codeText2);

			String b = codeText2.getAttribute("value");
			Log.info("Coupon Value Status : " + b);

			Assert.assertEquals(b, "OFF10");

			driver.navigate().back();
			Log.info("");

		} catch (Exception e) {

			Log.info("--------<<<<<<<<<<<<<<Test is fail >>>>>>>>>>>>>>>>>>>>>>>>--------------");

			test = ExtentManager.test.log(Status.FAIL,
					MarkupHelper.createLabel("OFF10 - Test Failed ", ExtentColor.RED));
		
			ExtentManager.test.fail(e);
			Assert.fail();
		
		}

		try {

			test = ExtentManager.test.log(Status.INFO, "Verifying 5IN4");

			WebElement ThirdOffer = driver
					.findElement(By.xpath("//label[@class=\"deal-left\"]/span[contains(text(),'5IN4')]"));
			Action.scrollByVisibilityOfElement(driver, ThirdOffer);
			Log.info("Clicking on Third Offer");
			Action.JSClick(driver, ThirdOffer);

			WebElement codeText3 = driver.findElement(By.xpath("//input[@name=\"code\"]"));

			Action.waitForVisible(driver, codeText3);

			String c = codeText3.getAttribute("value");
			Log.info("Coupon Value Status : " + c);

			Assert.assertEquals(c, "5IN4");

			driver.navigate().back();
			Log.info("");

			Log.info("Test is passed");
			Log.info("");

		} catch (Exception e) {

			Log.info("--------<<<<<<<<<<<<<<Test is fail >>>>>>>>>>>>>>>>>>>>>>>>--------------");

			test = ExtentManager.test.log(Status.FAIL,
					MarkupHelper.createLabel("5IN4 - Test Failed ", ExtentColor.RED));
		
		
			ExtentManager.test.fail(e);
			Assert.fail();
		}

	}

	public void callUsStrip() {

		Log.info("Verifying Request Call Back Strip is Present or not");

		// Action.isDisplayed(driver, callUsStrip);

		test = ExtentManager.test.log(Status.INFO, "Verifying Request Call Back Strip is Present or not");

		try {
			if (callUsStrip.isDisplayed()) {
				Action.scrollByVisibilityOfElement(driver, callUsStrip);
				Log.info("");

				Log.info("Clicking on Request Call Back Button");
				Action.JSClick(driver, requestCallBackBtnCallStrip);
				String redirectedURL = driver.getCurrentUrl();
				Log.info("RedirectedURL >>> " + redirectedURL);
				Assert.assertEquals(redirectedURL, "https://www.globalassignmenthelp.com.au/contact-us");
				driver.navigate().back();
				Log.info("");

				Log.info("Clicking on Order Now Button on call us strip");
				Action.JSClick(driver, orderBtnCallStrip);
				String redirectedURL2 = driver.getCurrentUrl();
				Log.info("RedirectedURL >>> " + redirectedURL2);
				Assert.assertEquals(redirectedURL2, "https://customerpanel.globalassignmenthelp.com.au/order");
				driver.navigate().back();
				Log.info("");
			}
		} catch (Exception e) {

			Log.info("--------<<<<<<<<<<<<<<Test is fail >>>>>>>>>>>>>>>>>>>>>>>>--------------");

			test = ExtentManager.test.log(Status.INFO,
					MarkupHelper.createLabel("Request Call Back Strip is not Present - Test Failed ", ExtentColor.RED));
		
			ExtentManager.test.fail(e);
			Assert.fail();
		}

	}

	public void reviewsSection() {

		try {

			Log.info("Verifying Review Section is Present or not");
			test = ExtentManager.test.log(Status.INFO,
					MarkupHelper.createLabel("Verifying Review Section is Present or not", ExtentColor.BLUE));
			
			Action.scrollByVisibilityOfElement(driver, reviewsSection);
			Action.isDisplayed(driver, reviewsSection);
			Log.info("");
			Log.info("Test is passed");
			Log.info("");
		} catch (Exception e) {

			Log.info("--------<<<<<<<<<<<<<<Test is fail >>>>>>>>>>>>>>>>>>>>>>>>--------------");

			test = ExtentManager.test.log(Status.FAIL,
					MarkupHelper.createLabel("Review Section is not Present - Test Failed ", ExtentColor.RED));
			ExtentManager.test.fail(e);
			Assert.fail();
			
		}

	}

}
