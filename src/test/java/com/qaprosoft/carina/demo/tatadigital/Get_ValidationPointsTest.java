package com.qaprosoft.carina.demo.tatadigital;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.tatadigital.api.ValidationPointMethod;

public class Get_ValidationPointsTest extends AbstractTest{

	HashMap<String, String> testDetail = new HashMap<String, String>();

	@Test(dataProvider = "DataProvider", description = "JIRA#DEMO-0001")
	@XlsDataSourceParameters(path = "xls/TataDigital.xlsx", sheet = "ValidationPoint",dsArgs="Module,TestCaseID,TestCaseDescription,StatusCode,ExpectedResult,points,issue_otp,mobile",dsUid = "TestCaseID",executeValue = "Y")
	public void validationpoint(String Module,String TesCaseID,String TestCaseDescription,String StatusCode,String ExpectedResult,String points,String issue_otp,String mobile) throws Exception 
	{
		testDetail.put("Module", Module);
 		testDetail.put("TestCaseID", TesCaseID);
		int statusCode;
 		int statusC=Integer.parseInt(StatusCode);
 		long ExecutionTime = 0;
 		String ExecutionStatus=null;
 		
		try{
			
			ValidationPointMethod api= new ValidationPointMethod(points, issue_otp, mobile);
			
			api.replaceUrlPlaceholder("points",points);
			api.replaceUrlPlaceholder("issue_otp",issue_otp);
			api.replaceUrlPlaceholder("mobile",mobile);


			 String croma_auth="Basic Y3JvbWEuYWRtaW4uMTo3NTI2MjJkMTVkMzlmOTI4OGVkOTUwZWJiN2RkOTNjMA==";
			api.request.header("Authorization","Basic Y3JvbWEuYWRtaW4uMTo3NTI2MjJkMTVkMzlmOTI4OGVkOTUwZWJiN2RkOTNjMA==");

			System.out.println("Authorized");
		    System.out.println("Validated"); 
		    
		    
			api.expectResponseStatus(HttpResponseStatusType.OK_200);
			Response rs=api.callAPI();
			long rsTime = rs.timeIn(TimeUnit.MILLISECONDS);
			System.out.println("Response time: " + rsTime);
			
		    statusCode=rs.getStatusCode();		
			String ActualResult=rs.asString();				
			api.getResponse();
		    System.out.println("Response recieved");

			if((statusCode==statusC) && (ActualResult.contains(ExpectedResult))){
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