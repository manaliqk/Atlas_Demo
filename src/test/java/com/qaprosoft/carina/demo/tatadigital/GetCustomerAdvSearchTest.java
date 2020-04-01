package com.qaprosoft.carina.demo.tatadigital;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.tatadigital.api.GetCustomerAdvSearchMethod;


public class GetCustomerAdvSearchTest extends AbstractTest {

	HashMap<String, String> testDetail = new HashMap<String, String>();

	@Test(dataProvider = "DataProvider", description = "JIRA#DEMO-0001")
	@XlsDataSourceParameters(path = "xls/TataDigital.xlsx", sheet = "GetCustAdvSearch",dsArgs="Module,TestCaseID,TestCaseDescription,StatusCode,ExpectedResult,q",dsUid = "TestCaseID",executeValue = "Y")
	public void getcustadvsearch(String Module,String TesCaseID,String TestCaseDescription,String StatusCode,String ExpectedResult,String q) throws Exception 
	{
		testDetail.put("Module", Module);
		testDetail.put("TestCaseID", TesCaseID);
		//int statusCode;
		//int statusC=Integer.parseInt(StatusCode);
		long ExecutionTime = 0;
		String ExecutionStatus=null;

		try{

			GetCustomerAdvSearchMethod api= new GetCustomerAdvSearchMethod(q);
            api.replaceUrlPlaceholder("q", q);
            
			String croma_auth="Basic Y3JvbWEuYWRtaW4uMTo3NTI2MjJkMTVkMzlmOTI4OGVkOTUwZWJiN2RkOTNjMA==";
			api.request.header("Authorization","Basic Y3JvbWEuYWRtaW4uMTo3NTI2MjJkMTVkMzlmOTI4OGVkOTUwZWJiN2RkOTNjMA==");

			System.out.println("Authorized");
			System.out.println("Validated"); 


			Response rs=api.callAPI();
			long rsTime = rs.timeIn(TimeUnit.MILLISECONDS);
			System.out.println("Response time: " + rsTime);

			//statusCode=rs.getStatusCode();		
			String ActualResult=rs.asString();				
			api.getResponse();
			System.out.println("Response recieved");

			if(ActualResult.contains(ExpectedResult)){
				ExecutionStatus="Pass"; 

			}
			else{
				ExecutionStatus="Fail";						 
			}	
			//cond.writeReport(executionReport, testDetail, ActualResult, statusCode, ExecutionStatus,ExecutionTime);
		}

		catch(Exception ex)
		{
			ex.printStackTrace();
			//cond.handleException(executionReport, testDetail, ex, ExecutionTime);

		}	 		

	}
}