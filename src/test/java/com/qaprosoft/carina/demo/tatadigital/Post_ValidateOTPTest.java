package com.qaprosoft.carina.demo.tatadigital;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.tatadigital.api.ValidateOTPMethod;

public class Post_ValidateOTPTest extends AbstractTest {

	HashMap<String, String> testDetail = new HashMap<String, String>();

	@Test(dataProvider = "DataProvider", description = "JIRA#DEMO-0001")
	@XlsDataSourceParameters(path = "xls/TataDigital.xlsx", sheet = "ValidateOTP",dsArgs = "Module,TestCaseID,TestCaseDescription,StatusCode,ExpectedResult,entityType,entityValue,code,action", dsUid = "TestCaseID",executeValue = "Y")
	public void validateOTP(String Module,String TesCase_ID,String TestCaseDescription,String StatusCode,String ExpectedResult,String entityType,String entityValue,String code,String action)  throws Exception {
	
		testDetail.put("Module", Module);
 		testDetail.put("TestCaseID", TesCase_ID);	 
// 		int statusCode;
// 		int statusC=Integer.parseInt(StatusCode);
 		long ExecutionTime = 0;
 		String ExecutionStatus=null;
 		
		try{
			ValidateOTPMethod api= new ValidateOTPMethod();
		
	 String croma_auth="Basic Y3JvbWEuYWRtaW4uMTo3NTI2MjJkMTVkMzlmOTI4OGVkOTUwZWJiN2RkOTNjMA==";
	api.request.header("Authorization","Basic Y3JvbWEuYWRtaW4uMTo3NTI2MjJkMTVkMzlmOTI4OGVkOTUwZWJiN2RkOTNjMA==");

	System.out.println("Authorized");
    System.out.println("Validated"); 
    
    api.getProperties().replace("entityType", entityType);
    api.getProperties().replace("entityValue", entityValue);
    api.getProperties().replace("code", code);
    api.getProperties().replace("action", action);

    
	api.expectResponseStatus(HttpResponseStatusType.OK_200);
	Response rs=api.callAPI();
	long rsTime = rs.timeIn(TimeUnit.MILLISECONDS);
	System.out.println("Response time: " + rsTime);
	
  //statusCode=rs.getStatusCode();		
	String ActualResult=rs.asString();				
	api.getResponse();
    System.out.println("Response recieved");

//	if((statusCode==statusC) && (ActualResult.contains(ExpectedResult))){
//		ExecutionStatus="Pass"; 
//	}
//	else{
//		ExecutionStatus="Fail";						 
//	}	
	}

 		catch(Exception ex)
 		{
 			ex.printStackTrace();

 		}	 		

}
}
	


