package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public abstract class EguruLoginPageBase extends AbstractPage {

	public EguruLoginPageBase(WebDriver driver) {
		super(driver);
	}
	
	public abstract void EnterUserid(String userid);
	
	public abstract void EnterPassword(String pw);
	
	public abstract void ClickLogin();
	
	public abstract void ClickOK();
	
	public abstract void Clicknavigation();
	
	public abstract void Clicklogout();
	
	

}
