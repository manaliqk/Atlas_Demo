package com.qaprosoft.carina.demo.cucumber.steps.manali;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.qaprosoft.carina.core.foundation.cucumber.CucumberRunner;
import com.qaprosoft.carina.demo.api.PostUserCreationMethod;
import com.qaprosoft.carina.demo.manali.pages.PostAccountCreationMethod_Cucumber;
import com.qaprosoft.carina.demo.manali.pages.PostAuthenticateMethod_Cucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PostAccCreateStepdef extends CucumberRunner {
	PostAccountCreationMethod_Cucumber user = null;
	Response rs = null;

/*	@Given("^Post ur endpoint$")
	public void startMethod() throws Exception {
		user = new PostAccountCreationMethod_Cucumber();
	}
*/
	/*@When("^set authorization$")
	public void setauthorization() {
        
	}
*/
	@When("^APIPosted and set authorization$")
	public void postApi() throws IOException {
		/*String accessToken=PostAuthenticateStepdef.getResponseTime();
        System.out.println("Id token is : " + accessToken);
        PostAccountCreationMethod_Cucumber api = new PostAccountCreationMethod_Cucumber();
		user.setAuth(accessToken);
        user.setHeaders("Authorization = Bearer"+ " " + accessToken);
		String response=user.callAPI().asString();

       System.out.println("Response is " + response);*/
		//user.addParameter("id_token", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOiJST0xFX0FETUlOLFJPTEVfVVNFUiIsImV4cCI6MTU3OTc3ODIwN30.iz6cl3iZ7AfxzwVXp2P9NfgbK6Lx0O01attoCxzv2qrRz9-c_OE1FFPLeGVHkiPiM30uo3ShX6hcUjpleMLcbA");
        

	}

	@And("^Get the Responses$")
	public void getResponseTime() {
		long rsTime = rs.timeIn(TimeUnit.MILLISECONDS);
		System.out.println("Response time: " + rsTime);
	}

}



