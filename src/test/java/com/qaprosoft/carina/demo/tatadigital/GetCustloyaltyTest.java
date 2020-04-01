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
import com.tatadigital.api.GetCustomerLoyaltyDetailsMethod;


public class GetCustloyaltyTest extends AbstractTest {


	@Test(dataProvider = "DataProvider", description = "JIRA#DEMO-0001")
	@XlsDataSourceParameters(path = "xls/TataDigital.xlsx", sheet = "GetCustloyalty",dsArgs="TC_Desc,customer_id",dsUid = "TestCaseID",executeValue = "Y")
	public void getcustloyaltydetails(String TC_Desc,String customer_id) throws Exception 
	{
		GetCustomerLoyaltyDetailsMethod api= new GetCustomerLoyaltyDetailsMethod(customer_id);

		api.replaceUrlPlaceholder("customer_id",customer_id);

		api.request.header("Authorization","Basic Y3JvbWEuYWRtaW4uMTo3NTI2MjJkMTVkMzlmOTI4OGVkOTUwZWJiN2RkOTNjMA==");

		System.out.println("Authorized");
		System.out.println("Validated"); 


		Response rs=api.callAPI();
		long rsTime = rs.timeIn(TimeUnit.MILLISECONDS);
		System.out.println("Response time: " + rsTime);

		api.getResponse();
		System.out.println("Response recieved");


	}
}