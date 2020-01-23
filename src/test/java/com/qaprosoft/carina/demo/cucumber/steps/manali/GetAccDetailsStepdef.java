package com.qaprosoft.carina.demo.cucumber.steps.manali;

import java.util.concurrent.TimeUnit;

import com.jayway.restassured.response.Response;
import com.qaprosoft.carina.core.foundation.cucumber.CucumberRunner;
import com.qaprosoft.carina.demo.api.PostUserCreationMethod;
import com.qaprosoft.carina.demo.manali.pages.GetAccountDetailsMethod_Cucumber;
import com.qaprosoft.carina.demo.manali.pages.PostAccountCreationMethod_Cucumber;
import com.qaprosoft.carina.demo.manali.pages.PostAuthenticateMethod_Cucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/*public class GetAccDetailsStepdef extends CucumberRunner {
	GetAccountDetailsMethod_Cucumber user = null;
	Response rs = null;

	@Given("^Get ur endpoint$")
	public void startMethod() throws Exception {
		user = new GetAccountDetailsMethod_Cucumber();
	}

	@When("^set the authorization$")
	public void setauthorization() {
		
	}

	@Then("^Get_Api$")
	public void getAPI() {
		rs = user.callAPI();
	}

	@And("^check the Response$")
	public void getResponseTime() {
		long rsTime = rs.timeIn(TimeUnit.MILLISECONDS);
		System.out.println("Response time: " + rsTime);
	}

}
*/


