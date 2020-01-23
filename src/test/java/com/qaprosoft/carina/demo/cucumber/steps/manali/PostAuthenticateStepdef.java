package com.qaprosoft.carina.demo.cucumber.steps.manali;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.json.JSONException;
import org.json.simple.JSONArray;
import org.testng.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.http.HttpStatusCodes;
import com.jayway.restassured.path.json.JsonPath;
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

public class PostAuthenticateStepdef extends CucumberRunner {
	/*static PostAccountCreationMethod_Cucumber user = null;
	static Response rs = null;

	@Given("^Post end_point$")
	public void startMethod() throws Exception {
		user = new PostAuthenticateMethod_Cucumber();
	}

	@When("^Enter uID and password$")
	public void enterthedetails() {
		user.addParameter("username", "admin");
		user.addParameter("password", "admin");
		JSONObject obj = new JSONObject();
		obj.put("username", "admin");
		obj.put("password", "admin");
		user.setBodyContent(obj.toString());
		

	}

	@Then("^PostedAPI$")
	public void postAPI() {
		 rs = user.callAPI();
		  
        
	}

	@And("^Get the Response$")
	public static String getResponseTime() throws IOException {
		long rsTime = rs.timeIn(TimeUnit.MILLISECONDS);
		System.out.println("Response time: " + rsTime);
		String response=user.callAPI().asString();
        Assert.assertTrue(HttpStatusCodes.isSuccess(200));
		System.out.println("Response**********************:" + response);

        String accessToken= new JsonPath(response).get("id_token");
        System.out.println("Id token is : " + accessToken);
		return accessToken;
        
	}
		JSONObject obj = new JSONObject();
		obj.put("id_token", accessToken);
		
 
		// try-with-resources statement based on post comment below :)
		FileWriter file = new FileWriter("D:\\Man_softwares\\Myworkspace\\Atlas_Demo\\StoreID.json");
		
			file.write(obj.toJSONString());

			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + obj);
		
	    ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("/Atlas_Demo/src/test/resources/api/manali/bankccounts/cucumber/StoreID.json"), obj );

		
	@Given("^Post ur endpoint$")
	public void startMethod1() throws Exception {
		user = new PostAccountCreationMethod_Cucumber();
	}

		@When("^APIPosted and set authorization$")
		public void postApi() throws IOException {
			String accessToken=PostAuthenticateStepdef.getResponseTime();
	        System.out.println("Id token is : " + accessToken);
	        PostAccountCreationMethod_Cucumber postApi = new PostAccountCreationMethod_Cucumber();
			user.setAuth(accessToken);
	        user.setHeaders("Authorization = Bearer"+ " " + accessToken);
			String response=postApi.callAPI().asString();
            System.out.println("Response is " + response);


	}
*/
	
	//Token Generation
	static PostAuthenticateMethod_Cucumber postuser = null;
	  Response rs = null;


	@Given("^Post endpoint given$")
	public void startMethod() throws Exception {
	postuser = new PostAuthenticateMethod_Cucumber();
	}

	@When("^Enter Username and Password$")
	public void enterdetails() throws JSONException {
	JSONObject object = new JSONObject();
	object.put("username", "admin");
	object.put("password", "admin");
	postuser.setBodyContent(object.toString());
	}

	@Then("^Post the api$")
	public static  String postAPI() {
	//rs = postuser.callAPI();
	//System.out.println("Response:" + rs);
	String response = postuser.callAPI().asString();
	System.out.println("Response**********************:" + response);
	String id_token = new JsonPath(response).get("id_token");
	System.out.println("ID" + id_token);
	return id_token;
	}

	@When("^enter id_token and set header$")
	public static int createUser()
	{
	String id_token=PostAuthenticateStepdef.postAPI();
	System.out.println("Id_Token :" +id_token);
	PostAccountCreationMethod_Cucumber createuser=new PostAccountCreationMethod_Cucumber(id_token);
	createuser.setAuth(id_token);
	createuser.setHeaders("Authorization=" + "Bearer" + " "+id_token);
	String response1 = createuser.callAPI().asString();
	System.out.println("Create Account Response ****************** " + response1);

	int id = new JsonPath(response1).getInt("id");
	System.out.println("Id :" + id);
	return id;
	}


	@Then("^retrieve specific user$")
	public void getUser()
	{
		String id_token=PostAuthenticateStepdef.postAPI();
	int userId=createUser();
	System.out.println("Get user Response  :***************"+userId);
	GetAccountDetailsMethod_Cucumber getid = new GetAccountDetailsMethod_Cucumber(userId);
	System.out.println(" User Id @@@@@@@@@@@@@" + getid);
	getid.setHeaders("Authorization=" + "Bearer" + " " + userId);
	getid.setMethodPath(getid.getMethodPath() + "/" + getid);
	getid.callAPI().asString();
	}



	}




