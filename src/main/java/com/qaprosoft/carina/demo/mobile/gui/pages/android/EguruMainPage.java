package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.android.AndroidUtils;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.EguruLoginPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.EguruMainPageBase;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = EguruMainPageBase.class)

public class EguruMainPage extends EguruMainPageBase {

	@FindBy(xpath="//android.widget.TextView[@text='Contact']")
	private ExtendedWebElement Contacts;
	
	@FindBy(xpath="//android.widget.EditText[@text='Enter First Name']")
	private ExtendedWebElement FirstName;
	
	@FindBy(xpath="//android.widget.EditText[@text='Enter Last Name']")
	private ExtendedWebElement Lastname ;
	
	@FindBy(xpath="//android.widget.EditText[@text='Enter Mobile Number']")
	private ExtendedWebElement MobileNumber;
	
	@FindBy(xpath="//android.widget.EditText[@text='Enter E-mail']")
	private ExtendedWebElement Email;
	
	public EguruMainPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void clickContacts() {
		pause(6);
		AndroidUtils.swipe(Contacts);
		pause(6);
        Contacts.click();
		System.out.println("Clicked Contacts");
	}
	@Override
	public void enterbasicdetails(String firstname, String lastname,String mob,String email) {
    FirstName.type(firstname);
    System.out.println("Entered firstname");
     pause(5);
     
    Lastname.type(lastname);
    System.out.println("Entered lastname");
    pause(5);
    
    MobileNumber.type(mob);
    System.out.println("Entered mobileno");
    pause(5);

    Email.type(email);
    System.out.println("Enter Email");
	}

	
}
