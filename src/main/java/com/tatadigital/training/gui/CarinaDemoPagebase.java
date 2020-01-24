package com.tatadigital.training.gui;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public abstract class CarinaDemoPagebase extends AbstractPage{
	
	 public CarinaDemoPagebase(WebDriver driver) {
	        super(driver);
	    }
	    public abstract void ClickNext();
	    
		public abstract void TypeName(String name);

		public abstract void TypePw(String pw);

		public abstract void Clickfemale();

		public abstract void Clicktoggle();


	    
}
