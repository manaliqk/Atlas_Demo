package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public  abstract class BoyDetailsPagebase_FirstCry extends AbstractPage{

		public BoyDetailsPagebase_FirstCry(WebDriver driver) {
			super(driver);
		}

		public abstract void clickDOB();

		public abstract void clickDOB_OK();

		public abstract void clickonchildname();

		public abstract void Enterchildname(String name);
		
		public abstract void clicksubmit();

		
		

	}


