package com.qaprosoft.carina.demo.cucumber.steps.manali;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;

import org.testng.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.http.HttpStatusCodes;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.cucumber.CucumberRunner;
import com.qaprosoft.carina.demo.api.PostUserCreationMethod;
import com.qaprosoft.carina.demo.manali.pages.GetAccountDetailsMethod_Cucumber;
import com.qaprosoft.carina.demo.manali.pages.GetEmpMethod_Cucumber;
import com.qaprosoft.carina.demo.manali.pages.PostAccountCreationMethod_Cucumber;
import com.qaprosoft.carina.demo.manali.pages.PostAuthenticateMethod_Cucumber;
import com.qaprosoft.carina.demo.manali.pages.PostCreateEmpMethod_Cucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PostCreateEmpStepdef extends CucumberRunner {
	private static final String Id = null;
	static PostCreateEmpMethod_Cucumber user=null;
	Response rs = null;
	GetEmpMethod_Cucumber getid=null;
	JSONObject obj = new JSONObject();		

	@Given("^post endpoint$")
	public void startmethod() throws Exception {
		user = new PostCreateEmpMethod_Cucumber();
	}

	@When("^Enter details$")
	public static int enterthedetails() {
		
		//JSONObject obj = new JSONObject();		
		
		/*obj.put("name", "manali");
		obj.put("salary", "1000");
		obj.put("age", "25");
		*/
        user.expectResponseStatus(HttpResponseStatusType.OK_200);
        String response=user.callAPI().asString();
        Assert.assertTrue(HttpStatusCodes.isSuccess(200));  
        System.out.println("Entered Details");
        JSONObject obj = new JSONObject(response);
        JSONObject obj1=obj.getJSONObject("data");
        int Id =(int) obj1.get("id");
       user.getResponse();
   	   //int Id1 = new JsonPath(response).getInt("id");

        System.out.println(" Id is " + Id);
		return Id;

        
 /*       JSONArray employeeList = new JSONArray();
        employeeList.add(employeeObject);
        try (FileWriter file = new FileWriter("postrs.json")) {
        	 
            file.write(employeeList.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }*/  
       //user.getResponse();

//        user.validateResponse();
        //System.out.println("response validated");
	}

	@Then("^take api$")
	public void postAPI() {
		 rs = user.callAPI();
		//user.callAPI().asString();
		   
		 System.out.println("Emp created");
        
	}
	
	@When("^get api$")
	public void getApi()
	{
		getid=new GetEmpMethod_Cucumber();
		int empid=enterthedetails();
		System.out.println("Get user Response  :***************"+empid);
		//GetEmpMethod_Cucumber getid = new GetAccountDetailsMethod_Cucumber(empid);
		System.out.println(" Emp Id @@@@@@@@@@@@@" + empid);
		getid.setMethodPath(getid.getMethodPath()+"/"+Id);
	    System.out.println("Path is " + getid.getMethodPath());
	    getid.expectResponseStatus(HttpResponseStatusType.OK_200);
	    getid.callAPI();
	    getid.getResponse();
	    //getid.validateResponse();
	   System.out.println("Got specific employeee");	    

	}
}
	