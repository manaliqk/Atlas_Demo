package com.qaprosoft.carina.demo.cucumber.steps.manali;

import org.openqa.selenium.interactions.touch.TouchActions;

import com.qaprosoft.carina.core.foundation.cucumber.CucumberRunner;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.EguruLoginPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.EguruMainPageBase;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EguruStepdef extends CucumberRunner{

	EguruLoginPageBase login=null;
	EguruMainPageBase Main=null;
	
	@Given("^launch your app$")
	public void Mainpage()
	{
		login = initPage(getDriver(), EguruLoginPageBase.class);
        System.out.println("Application launched");
pause(8);
	}
	@When("^click on userid and pw$")
	public void enteruserid()
	{
		login.EnterUserid("PV10_SPMA");
		System.out.println("Entered userid");
		
		login.EnterPassword("Tata@2019");
        }
	
	@Then("^click on login$")
	public void clicklogin()
	{
		login.ClickLogin();
		System.out.println("clicked login button");
        pause(8);
	}

	@And("^Click OK$")
	public void ClickOK()
	{
        login.ClickOK();
        }
	@And("^ClickNavigation$")
	public void Clicknavigation()
	{
        login.Clicknavigation();
        }
	@And("^click Logout$")
	public void Clicklogout()
	{
		login.Clicklogout();
		//System.out.println("Logged");
	}
	 @Then("^clickContacts$")
	public void clickContacts() {
			Main = initPage(getDriver(), EguruMainPageBase.class);
            Main.clickContacts();
	}
     @And("^Enter Basic Details$")
     public void enterbasicdetails()
     {
    	 Main.enterbasicdetails("qktest","test","8888888888","qktest@gmail.com");
     }
}
