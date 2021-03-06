package com.qaprosoft.carina.demo.cucumber.steps.manali;

import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.qaprosoft.carina.core.foundation.cucumber.CucumberRunner;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.BoyDetailsPagebase_FirstCry;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MainPageBase_FirstCry;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.QtracLoginPageBase;
import com.qaprosoft.carina.demo.utils.M1CloudActivities;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FirstCryBoyStepdef extends CucumberRunner{
	MainPageBase_FirstCry Main = null;
	BoyDetailsPagebase_FirstCry Details;

	
	@Given("^launch First Cry App$")
	public void MainPage() throws Exception {
		//Main = initPage(getDriver(), MainPageBase_FirstCry.class);
		System.out.println("test started");
		M1CloudActivities mobile = new M1CloudActivities();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities = mobile.setCapabilities("OnePlus7.properties");
		Main = initPage(getDriver("DEFAULT", capabilities, R.CONFIG.get("selenium_host")), MainPageBase_FirstCry.class);
		System.out.println("Application launched");
//         pause(25);
//         System.out.println("Waited");
		
	}

	@When("^Select Boy and years$")
	public void Enterdetails() throws Throwable {
		
		/*Main.clickAll();
		Thread.sleep(5000);
		*/
		Main.clickonBoy();
		Thread.sleep(5000);
		//Details = initPage(Details.getDriver(), BoyDetailsPagebase_FirstCry.class);

		//Main.clickyears();
//		Details = Main.clickonyears();
		//Thread.sleep(5000);
		//System.out.println("Clicked on years");
		pause(6);

	}

	@And("^Select DOB Child Name$")
	public void selectDOB() throws Throwable {
		Details = initPage(getDriver(), BoyDetailsPagebase_FirstCry.class);
		Details.clickDOB();
		pause(5);

		Details.clickDOB_OK();
		pause(5);

		Details.clickonchildname();
		Details.Enterchildname("Rajo");
		pause(5);
		System.out.println("Entered details");

		
	}

	@Then("^Click Submit$")
	public void clicksubmit() throws Throwable {
		Details.clicksubmit();
		Thread.sleep(5000);
        System.out.println("Submitted");
	}

	/*@Then("^Check the child name added$")
	public void checkchildname() {
		Main.checkname();
		System.out.println("Came to Home page");
	}*/	
	
}


