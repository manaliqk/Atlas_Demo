package com.qaprosoft.carina.demo.gui.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.NewsItem;

public class Login_Gmail extends AbstractPage{

	 Logger LOGGER = Logger.getLogger(Login_Gmail.class);

	 @FindBy(linkText="Sign in")
	    private ExtendedWebElement signinbutton;
	 
    @FindBy(xpath="//input[@type='email']")
    private ExtendedWebElement Emailid;
    
    @FindBy(linkText="Next")
    private ExtendedWebElement nextbutton;
    
    @FindBy(xpath="//input[@type='password']")
    private ExtendedWebElement password;

  
	public Login_Gmail(WebDriver driver) {
		super(driver);
	}
	public void login(String emailid,String pwd) {
		
		signinbutton.click();
		Emailid.type(emailid);
		nextbutton.click();
		password.type(pwd);
		nextbutton.click();

		
		
	}
	
}
