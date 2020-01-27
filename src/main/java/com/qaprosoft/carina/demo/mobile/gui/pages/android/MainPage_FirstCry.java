package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MainPageBase_FirstCry;


	@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = MainPageBase_FirstCry.class)
	public class MainPage_FirstCry extends MainPageBase_FirstCry{
		
		//@FindBy(xpath="//android.widget.TextView[@text='All']")
		//private ExtendedWebElement ALL;
		
		@FindBy(xpath="//android.widget.TextView[@text='Boy']")
		private ExtendedWebElement Boy;

		/*@FindBy(xpath="//android.widget.TextView[@text='2 - 4 Years']")
		private ExtendedWebElement year;
*/
		/*@FindBy(xpath="//android.widget.TextView[@text='All']")
		private ExtendedWebElement checkchildname;
*/
		public MainPage_FirstCry(WebDriver driver) {
			super(driver);
		}
		
	/*@Override
		public void clickAll() {
			ALL.click();
		}
*/
		@Override
		public void clickonBoy() {
			Boy.click();
		}

		/*@Override
		public void clickyears() {
			pause(6);
			year.click();
			System.out.println("Clicked on years1");
			year.pause(10);
			System.out.println("Clicked on years2");
		}*/
		/*@Override
		public void checkname() {
			checkchildname.click();
		}*/
		/*@Override
	    public BoyDetailsPagebase_FirstCry clickonyears() {
			years.click();
	        return initPage(getDriver(), BoyDetailsPagebase_FirstCry.class);
	    }*/

	}


