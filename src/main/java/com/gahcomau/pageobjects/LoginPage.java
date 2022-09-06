/**
 * 
 */
package com.gahcomau.pageobjects;

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
public class LoginPage extends BaseClass {
	
	// not able to run with xpath so written method in one
	
	@FindBy(xpath = "//div/a[@class=\"login\"]") 
    WebElement loginSignupBtn;
	
	@FindBy(xpath = "//div[@class=\"fancybox-caption fancybox-caption--separate\"]") 
    WebElement loginSignupPopup;

	
	@FindBy(id = "popHeading") 
    WebElement formHeading;
	
	
	@FindBy(xpath = "//p[@class=\"showlogin\"]") 
    WebElement subHeading;
	
	@FindBy(id = "email") 
    WebElement emailBox;
	
	@FindBy(xpath = "//input[@id='password']") 
    WebElement passwordBox;
	
	@FindBy(xpath = "//*[@id=\"Path_173\"]") 
    WebElement eyeIcon;
	
	@FindBy(xpath = "//a[contains(text(),'Forgot Password?')]") 
    WebElement ForgotPassword;
	
	@FindBy(xpath = "//*[@id=\"continuelogin\"]") 
    WebElement LoginBtn;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String url() throws Throwable {
		String currentUrl = Action.getCurrentURL(driver);
		System.out.println(currentUrl);
		return currentUrl;
	}
	
	public void clicklogin() {

		driver.findElement(By.id("login_zopim_hide")).click();
		String heading = driver.findElement(By.id("popHeading")).getText();
		Log.info("The Heading of the Form on click login button: " + heading);
		Action.fluentWait(driver, loginSignupPopup, 05);
		
	}
	
	
	
	
	public void getSubHeading() {
		String b = driver.findElement(By.cssSelector(".showlogin:nth-child(2)")).getAttribute("textContent");	
		Log.info("This is sub-heading : " + b);
		
	}
	
	public void enterEmail(String emailId) {
		WebElement emailTextBox = driver.findElement(By.id("email"));
		Action.type(emailTextBox, emailId);
		Log.info("Email id entered by the user is : " + emailId);
		
	}

	
	public void clickContinueWithEmail() throws InterruptedException {

		driver.findElement(By.id("emailcheck")).click();
		Log.info("Clicked on the email");
		
	}
	
	public void GoogleBtn() {
		
		WebElement Google = driver.findElement(By.id("customBtn"));
		Log.info("Checking Google Signup button is dispalyed or not");
		Action.isDisplayed(driver, Google);
		
		
	}
	
	public void FacebookBtn() {
		
		WebElement Fb =  driver.findElement(By.linkText("Facebook"));
		Log.info("Checking fb Signup button is dispalyed or not");
		Action.isDisplayed(driver, Fb);

		
	}
	
	public void enterPassword(String password) {
		
		Action.type(passwordBox, password);
		
	}
	
	public void eyeIcon() {
		Log.info("Checking eye icon button is dispalyed or not");

		Action.isDisplayed(driver, eyeIcon);
		
	}
	
	public void ForgotPassword() {
		Log.info("Checking Forgot password button is dispalyed or not");
	
		Action.isDisplayed(driver, ForgotPassword);
		
	}
	
	public DashboardPage LoginBtn() {
		
		Action.JSClick(driver, LoginBtn);
		Log.info("Clicked on the login button");
		return new DashboardPage();
		
	}
	
	public void newUserName() {
		
		WebElement name1 = driver.findElement(By.id("name"));
		Action.type(name1, "Groot");
		String a = Action.getText(name1);
		

	}
	
	
	public void getHeadingSignup() {

		WebElement SignupHeading = driver.findElement(By.id("popHeading"));
		String signup =   SignupHeading.getAttribute("textContent");
		Action.isDisplayed(driver, SignupHeading);
		Log.info("This is  : " + signup);
		
		
	}
	
	public void changemailButton() {
		
		WebElement Change = driver.findElement(By.id("changeemail"));
		Action.isDisplayed(driver, Change);
	}
	
	public void selectCountry() {
		
		 WebElement dropdown = driver.findElement(By.cssSelector("#loginCountry .countrycode"));
	     dropdown.findElement(By.xpath("//*[@id=\"loginCountry\"]/span/select/option[2]")).click();
	     Log.info("The Country code is selected");
	}
	
	public void enterMobileNo() {
		
		driver.findElement(By.id("phone")).click();
	    driver.findElement(By.id("phone")).sendKeys("1234567890");
		
	}
	
	public void getTerms() {
		
		WebElement terms = driver.findElement(By.id("email_hide_register"));
		String signup =   terms.getAttribute("textContent");
		Action.isDisplayed(driver, terms);
		Log.info("Terms : " + signup);
		
		
	}
	
	public DashboardPage clickRegister() {
		
		WebElement registerBtn = driver.findElement(By.id("continueregister"));
		Log.info("Checking register button is dispalyed or not");
		Action.isDisplayed(driver, registerBtn);
		registerBtn.click();
		return new DashboardPage();
		
	}
	
	

	
	
	
	
}
