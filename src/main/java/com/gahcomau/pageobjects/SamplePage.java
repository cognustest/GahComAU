/**
 * 
 */
package com.gahcomau.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
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
public class SamplePage extends BaseClass {
	
	
	@FindBy(xpath = "//div[@class=\"sample_paper_subject_wrap sample_page_ajax\"]/div/span")
	WebElement abcdCat;
	
	@FindBy(xpath = "//li/a[contains(text(),'Samples')]")
	WebElement SampleMenu;
	
	// Services

	public SamplePage() {
		PageFactory.initElements(driver, this);
	}

	// Get Title
	public String getTitle() {
		String actualTitle = driver.getTitle();
		Log.info("Actual Page Title is : " + actualTitle);
		return actualTitle;
	}
	
	
	public void clickSampleMenu() {
		Log.info("Clicking on sample menu");
		Action.JSClick(driver, SampleMenu);
		
	}
	
	public void getabcdCatCount() {
		
		List<WebElement> abcdsize = driver.findElements(By.xpath("//div[@class=\"sample_paper_subject_wrap sample_page_ajax\"]/div/span"));
		
		for (int i = 0; i < abcdsize.size(); i++) {

			String pageFound = abcdsize.get(i).getText();
			
			Log.info(" Banner Element Found : " + pageFound);
			//System.out.println(pageFound);
			

		}
	
		int a = abcdsize.size();
		Log.info(" Sample Category Found : " + a);
	
	}
	
	//ul[@class="course_btm_bdr filter_sample_search"]/li
	
	public void getTotalSampleMainCatHeading() {
		
		List<WebElement> abcdsize = driver.findElements(By.xpath("//ul[@class=\"course_btm_bdr filter_sample_search\"]/li/a"));
		
		for (int i = 0; i < abcdsize.size(); i++) {

			String pageFound = abcdsize.get(i).getAttribute("textContent");
			
			
			String pageFound1 = abcdsize.get(i).getAttribute("innerText");

			
			String pageFound2 = abcdsize.get(i).getAttribute("innerHTML"); //.replaceAll("//span{Cntrl}", "").trim();
			
			//Log.info(" Main Category Found : " + pageFound);
			//System.out.println(pageFound);
			//Log.info(" Main Category Found : " + pageFound2);
			System.out.println(pageFound1);
		}
	
		int a = abcdsize.size();
		Log.info(" Main Category Found : " + a);
		
	}
		
	
	
	
	public void sampleFlowTest(String sample_heading ) {
		
		//ul[@class="course_btm_bdr filter_sample_search"]/li/a[contains(text(),'Accounting')]
		
		//div[@class="allsamples"]
		
		//div[@class="banner-samples"]
		
		//div[@class="leftblur"]
		
		
		List<WebElement> service_sub_list = driver.findElements(By.xpath
				("//ul[@class=\"course_btm_bdr filter_sample_search\"]/li/a[contains(text(),"+"'"+sample_heading+"'"+")]")) ;

		for (int i = 0; i < service_sub_list.size(); i++) {

			String SubjectFound = service_sub_list.get(i).getText();
			
			
			
			Log.info(" Subject Found : " + SubjectFound);
			
			service_sub_list.get(i).click();
			Log.info("Clicking on subjet");
			
			
			List<WebElement> SampleListPage = driver.findElements(By.xpath("//*[@id=\"allsamples\"]/a"));

			for (int j = 0; j < SampleListPage.size(); j++) {

				String pageFound = SampleListPage.get(j).getText();
				
				Log.info(" Banner Element Found : " + pageFound);
				//System.out.println(pageFound);
				
				//SampleListPage.get(j).click();
				
				//String a = driver.getCurrentUrl();
				//Log.info(a);
				
				//driver.navigate().back();

			}
					
			

		}

		
		
		
	}

	
	
	public void sampletest3() {
		
		WebElement service_sub_list = driver.findElement(By.xpath
				("//ul[@class=\"course_btm_bdr filter_sample_search\"]/li/a[contains(text(),'Accounting')]")) ;

		
		
		
		Action.scrollByVisibilityOfElement(driver ,service_sub_list );
		Action.JSClick(driver, service_sub_list);
		
		
		List<WebElement> SampleListPage = driver.findElements(By.xpath("//*[@id=\"allsamples\"]/a"));
		
		String a1 = SampleListPage.get(3).getText();
		Log.info(a1);
	
		SampleListPage.get(3).click();
		
		String url = driver.getCurrentUrl();
		Log.info(url);
		
		//ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		// switch to new tab
		//driver.switchTo().window(newTb.get(1));
		//Log.info("Page title of new tab:>>> " + driver.getTitle());
		
		//driver.get(url);
		
		
		
		//String a2 = SampleListPage.get(4).getText();
	//	Log.info(a2);
		
		//SampleListPage.get(5).click();
		
		//String url2 = driver.getCurrentUrl();
		//Log.info(url2);
		
		//driver.navigate().back();
		
		
		
		
	}
	
	
	


}
