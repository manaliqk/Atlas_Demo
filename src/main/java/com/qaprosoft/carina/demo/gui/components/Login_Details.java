package com.qaprosoft.carina.demo.gui.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class Login_Details extends AbstractUIObject{

	 @FindBy(xpath="//*[@id=':a.mn']")
	    public ExtendedWebElement titleLink;
	   
	public Login_Details(WebDriver driver) {
		super(driver);
		
	}
	public String readTitle() {
        return titleLink.getElement().getText();
    }
}
