package com.tatadigital.training.gui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = CarinaDemoPagebase.class)
	public class CarinaDemoPage extends CarinaDemoPagebase {
		
		@FindBy(id="com.solvd.carinademoapplication:id/next_button")
		private ExtendedWebElement NextButton;
		
		@FindBy(xpath="//android.widget.EditText[@text='Name']")
		private ExtendedWebElement Name;

		@FindBy(xpath="//android.widget.EditText[@text='Password']")
		private ExtendedWebElement Password;
        
		@FindBy(xpath="//android.widget.RadioButton[@text='Female']")
		private ExtendedWebElement FemaleRadioButton;

		@FindBy(xpath="//android.widget.Switch[@text='I agree to the Privacy Policy OFF']")
		private ExtendedWebElement ToggleButton;

	public CarinaDemoPage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public void ClickNext() {
		NextButton.click();
        System.out.println("clicked on next");
	}

	@Override
	public void TypeName(String name) {
		Name.click();
		Name.type(name);
	}
	@Override
	public void TypePw(String pw) {
		Password.type(pw);
	}
	@Override
	public void Clickfemale() {
		FemaleRadioButton.click();
	}
	@Override
	public void Clicktoggle() {
		ToggleButton.click();
	}
	}
	