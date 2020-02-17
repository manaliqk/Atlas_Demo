package com.tatadigital.tcpapp.gui.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class SignupPage extends AbstractPage {

	Logger LOGGER = Logger.getLogger(HomePage.class);
	
	@FindBy(xpath = "//input[@list='countrycodes']")
    private List<ExtendedWebElement> countryCodes;
	
    @FindBy(xpath = "//input[@name='mobile']")
    private ExtendedWebElement mobileNo;
    
    @FindBy(xpath = "//button[text()='Get OTP']")
    private ExtendedWebElement getOTPbtn;
    
    @FindBy(xpath = "//input[@placeholder='Enter OTP here']")
    private ExtendedWebElement enterOTP;
    
    @FindBy(xpath = "//label[text()='Submit OTP']")
    private ExtendedWebElement SubmitOTP;
  
    @FindBy(xpath = "//input[@name='firstName']")
    private ExtendedWebElement FirstName;
  
    @FindBy(xpath = "//input[@name='lastName']")
    private ExtendedWebElement LastName;
  
    @FindBy(xpath = "//input[@name='emailId']")
    private ExtendedWebElement Email;
    
    @FindBy(xpath = "//input[@name='dob']")
    private ExtendedWebElement DOB;
    
    @FindBy(xpath = "//button[text()='Done']")
    private ExtendedWebElement doneBtn;
    
  

	
	public SignupPage(WebDriver driver) {
		super(driver);
	}

	//signup with otp method
	public void signupWithOTP(String countryCode, String mobileNo){
//		if(!countryCode.isEmpty()){
//			LOGGER.info("selecting '" + countryCode + "' countryCode...");
//	        for (ExtendedWebElement countryc : countryCodes) {
//	            if (countryc.getText().equalsIgnoreCase(countryCode)) {
//	            	countryc.click();
//	            }
//	        }
//		}
		this.mobileNo.type(mobileNo);
		getOTPbtn.click();
		enterOTP.type("1234");
		SubmitOTP.click();
	}
	
	//verify otp
	public void newuserReg(String FN, String LN, String semail, String dob){
		FirstName.type(FN);
		LastName.type(FN);
		Email.type(semail);
		DOB.type(dob);
		doneBtn.click();
	}
	
	
	
}
