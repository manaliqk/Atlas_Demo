package com.qaprosoft.carina.demo.cucumber.steps;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.qaprosoft.carina.core.foundation.cucumber.CucumberRunner;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.QtracHomePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.QtracLoginPageBase;
import com.qaprosoft.carina.demo.utils.M1CloudActivities;
import com.tatadigital.training.gui.CarinaDemoPagebase;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CarinaStepdef extends CucumberRunner {

	QtracLoginPageBase Login = null;
	QtracHomePageBase Home = null;
	
	CarinaDemoPagebase carina = null;

	@Given("^launch the app$")
	public void lauchApp() throws Exception {
		System.out.println("launch the app");
		/*M1CloudActivities mobile = new M1CloudActivities();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities = mobile.setCapabilities("Samsung_Galaxy_J4_Plus.properties");*/
		//getDriver("DEFAULT", capabilities, R.CONFIG.get("selenium_host"));
		//Login = initPage(getDriver("DEFAULT", capabilities, R.CONFIG.get("selenium_host")), QtracLoginPageBase.class);
		carina = initPage(getDriver(), CarinaDemoPagebase.class);
	}

	@When("^Enter Username and Password$")
	public void enterdetails() {
		System.out.println("test start");
		Login.clickonSignin();
		Login.login("testqk", "Quality@123");
	}

	@Then("^click on login$")
	public void ClickOnLoginBtn() {
		Login.clickonLoginBtn();
	}

	@And("^click on speedometer dashboard$")
	public void clickonspeedometerdashboard() {
		Home = initPage(Login.getDriver(), QtracHomePageBase.class);
		Home.clickSpeedometerDashbord();
	}

	@And("^click on Pagebucket dashboard$")
	public void clickonPagebucketdashboard() {
		Home.clickPageBucketDashborad();
	}

}
