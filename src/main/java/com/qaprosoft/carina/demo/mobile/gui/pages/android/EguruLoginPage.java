package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.android.AndroidUtils;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.EguruLoginPageBase;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = EguruLoginPageBase.class)

public class EguruLoginPage extends EguruLoginPageBase{

	@FindBy(xpath="//android.widget.EditText[@text='User ID']")
	private ExtendedWebElement UserID;
	
	@FindBy(xpath="//android.widget.EditText[@text='Password']")
	private ExtendedWebElement Password;

	@FindBy(xpath="//android.widget.Button[@text='LOGIN']")
	private ExtendedWebElement Login;
    
	@FindBy(xpath="//android.widget.Button[@text='OK']")
	private ExtendedWebElement OK;
	
	@FindBy(xpath="//android.widget.ImageButton[@content-desc='Open navigation drawer']")
	private ExtendedWebElement clicknavigation;

	@FindBy(id="com.tatamotors.eguruhybrid:id/nav_view")
	private ExtendedWebElement container;
	
	@FindBy(xpath="//android.widget.CheckedTextView[@text='Logout']")
	private ExtendedWebElement Logout;

	/*@FindBy(xpath="//android.widget.Button[@text='YES']")
	private ExtendedWebElement Logout_Yes;*/

	@FindBy(xpath="//android.widget.Button[@text='NO']")
	private ExtendedWebElement Logout_No;

	public EguruLoginPage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public void EnterUserid(String userid) {
		UserID.type(userid);
        System.out.println("Entered userid");
	}

	@Override
	public void EnterPassword(String pw) {
		Password.type(pw);
        System.out.println("Entered pw");

	}
	@Override
	public void ClickLogin() {
		Login.click();
		System.out.println("Logged in");
}
	@Override
	public void ClickOK() {
		OK.click();
		System.out.println("Clicked OK");
}
	@Override
	public void Clicknavigation() {
		clicknavigation.click();
		System.out.println("Clicked navigation");
}
	@Override
	public void Clicklogout()
	{
		pause(8);
		AndroidUtils.swipe(Logout);
		pause(8);
		Logout.click();
		pause(5);
		Logout_No.click();
		/*Logout_Yes.click();
		pause(6);	
		System.out.println("Logged out");*/
		System.out.println("Back to Main Page");

	}
	
}
