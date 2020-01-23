package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.BoyDetailsPagebase_FirstCry;


	@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = BoyDetailsPagebase_FirstCry.class)
	public class BoyDetailsPage_FirstCry extends BoyDetailsPagebase_FirstCry{
		
		@FindBy(xpath="//android.widget.TextView[@text='Date Of Birth']")
		private ExtendedWebElement DOB;
		
		@FindBy(xpath="//android.widget.Button[@text='OK']")
		private ExtendedWebElement ClickOk;

		@FindBy(xpath="//android.widget.TextView[@text='Child Name']")
		private ExtendedWebElement Childnameclick;

		@FindBy(xpath="(//android.widget.EditText[@clickable='true'])[2]\")")
		private ExtendedWebElement ChildnameEnter;

		@FindBy(xpath="(//android.widget.TextView[@text='SUBMIT']")
		private ExtendedWebElement clickSubmit;

		public BoyDetailsPage_FirstCry(WebDriver driver) {
			super(driver);
		}
		
		@Override
		public void clickDOB() {
			DOB.click();
		}

		@Override
		public void clickDOB_OK() {
			ClickOk.click();
		}

		@Override
		public void clickonchildname() {
			Childnameclick.click();
		}
		@Override
		public void Enterchildname(String name) {
			ChildnameEnter.type(name);
		}

		@Override
		public void clicksubmit() {
			clickSubmit.click();
		}
	}





