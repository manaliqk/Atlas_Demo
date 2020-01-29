package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public abstract class EguruMainPageBase extends AbstractPage {

	public abstract void clickContacts();
	
	public abstract void enterbasicdetails(String firstname, String lastname,String mob,String email);
	
	public EguruMainPageBase(WebDriver driver) {
		super(driver);
	

	 
		
	}

}
