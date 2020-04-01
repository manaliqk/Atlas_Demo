package com.qaprosoft.carina.demo.tatadigital;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.report.testrail.TestRailCases;
import com.tatadigital.api.GetCustomerLoyaltyDetailsMethod;
import com.tatadigital.api.RedeemPointsMethod;

public class Post_RedeemPointsTest extends AbstractTest {

	String billing_time="";
	Integer loyaltyPoints;
	public void writeResponse(String Response) throws IOException {


		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss_"); 
		Date date = new Date(); System.out.println(dateFormat.format(date)); // 2016/11/16

		File responseDir = new File("src/test/resources/api/TataDigitalApiResponses/"
				+ dateFormat.format(date) + getClass().getSimpleName());

		responseDir.mkdirs();

		File responseFile = new File(responseDir + "/Response.txt"); 
		FileWriter wrResponse = new FileWriter(responseFile); 
		// BufferedWriter BW = new BufferedWriter(wrResponse);

		wrResponse.write(Response);
		wrResponse.close();

	}
	public String CurrentDate_billingtime() throws IOException{
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		String billing_time = sdfDate.format(now);
		System.out.println(billing_time);
		return billing_time;

	}
	public void writeBilltime(String billing_time) throws IOException{	
		File randomFile1 = new File("src/test/resources/api/tatadigital/BillingTime.txt");
		FileWriter wrBilltime = new FileWriter(randomFile1);
		//BufferedWriter BW1 = new BufferedWriter(wrBilltime);
		wrBilltime.write(billing_time);
		wrBilltime.close();
	}
	public String readBillTime() throws IOException {

		File randomFile1 = new File("src/test/resources/api/tatadigital/BillingTime.txt");
		FileReader FR1 = new FileReader(randomFile1); 
		BufferedReader BR1 = new BufferedReader(FR1); 
		String billing_time = BR1.readLine(); 
		BR1.close(); 
		return billing_time;
	}
	public String readBillNo() throws IOException {
		  
		  File randomFile = new File("src/test/resources/api/tatadigital/BillNo.txt");
		  FileReader FR = new FileReader(randomFile);
		  BufferedReader BR = new BufferedReader(FR); 
		  String number = BR.readLine(); 
		  BR.close(); 
		  return number;
		  
		  }
	public String RandomBillNumber() { 
		String random5Digts =
				UUID.randomUUID().toString().substring(0, 5); String
				randomNumber="QK_"+random5Digts; StringBuilder sb = new
				StringBuilder(randomNumber);
				for (int index = 0; index < sb.length();index++) 
				{ char c = sb.charAt(index); if (Character.isLowerCase(c)) {
					sb.setCharAt(index, Character.toUpperCase(c)); } }
				System.out.println("Bill number is " + sb.toString());
				String number = sb.toString(); 
				System.out.println(number);
				return number;
	}
	@Test(dataProvider = "DataProvider", description = "JIRA#DEMO-0001",testName = "TC_001",priority=1)
	@XlsDataSourceParameters(path = "xls/TataDigital.xlsx", sheet = "RedeemPoints",dsArgs = "TC_Desc,points_redeemed,transaction_number,external_id,redemption_time,program_id", executeValue = "TC_001")
	@TestRailCases(testCasesId = "TC_001,TC_002")
	public void redeempoints(String TC_Desc,String points_redeemed,String transaction_number,String external_id,String redemption_time,String program_id) throws Exception {

		RedeemPointsMethod api= new RedeemPointsMethod();

		api.request.header("Authorization","Basic Y3JvbWEuYWRtaW4uMTo3NTI2MjJkMTVkMzlmOTI4OGVkOTUwZWJiN2RkOTNjMA==");

		System.out.println("Authorized");
		System.out.println("Validated"); 

		api.getProperties().replace("points_redeemed", points_redeemed);
		api.getProperties().replace("transaction_number", transaction_number);
		api.getProperties().replace("external_id", external_id);
		api.getProperties().replace("redemption_time", CurrentDate_billingtime());
		api.getProperties().replace("program_id", program_id);


		//api.expectResponseStatus(HttpResponseStatusType.OK_200);
		Response rs=api.callAPI();
		String messageStr = rs.asString();
		writeResponse(messageStr);

		long rsTime = rs.timeIn(TimeUnit.MILLISECONDS);
		System.out.println("Response time: " + rsTime);
	}

	@Test(dataProvider = "DataProvider", description = "JIRA#DEMO-0002",testName = "TC_001",priority=2)
	@XlsDataSourceParameters(path = "xls/TataDigital.xlsx", sheet = "GetCustloyalty",dsArgs="TC_Desc,customer_id",executeColumn="TestCaseID",executeValue = "TC_001")
	//@TestRailCases(testCasesId = "TC_001")
	public void getcustloyaltydetails(String TC_Desc,String customer_id) throws Exception 
	{
		GetCustomerLoyaltyDetailsMethod api= new GetCustomerLoyaltyDetailsMethod(customer_id);

		api.replaceUrlPlaceholder("customer_id",customer_id);

		api.request.header("Authorization","Basic Y3JvbWEuYWRtaW4uMTo3NTI2MjJkMTVkMzlmOTI4OGVkOTUwZWJiN2RkOTNjMA==");

		System.out.println("Authorized");
		System.out.println("Validated"); 


		Response rs=api.callAPI();
		String messageStr = rs.asString();
		writeResponse(messageStr);

		long rsTime = rs.timeIn(TimeUnit.MILLISECONDS);
		System.out.println("Response time: " + rsTime);

		api.getResponse();
		System.out.println("Response recieved");

		loyaltyPoints = getloyaltyPointsValue(messageStr);

	}
	public Integer getloyaltyPointsValue(String messageStr) throws IOException {
		JSONObject json = new JSONObject(messageStr);
		
		JSONArray dataArray = json.getJSONArray("data");

		JSONObject dataObj = dataArray.getJSONObject(1);

		Integer loyaltyPoints = dataObj.getInt("loyaltyPoints");

		return loyaltyPoints;

		/*
		 * File randomFile = new
		 * File("src/test/resources/api/tatadigital/loyaltyPoints.txt"); FileWriter
		 * wrloyaltypts = new FileWriter(randomFile); BufferedWriter BW = new
		 * BufferedWriter(wrloyaltypts);
		 * 
		 * wrloyaltypts.write(loyaltyPoints); wrloyaltypts.close();
		 */

	}
	/*
	 * public String readLoyaltyPoints() throws IOException {
	 * 
	 * File randomFile = new File("src/test/resources/api/users/loyaltyPoints.txt");
	 * FileReader FR = new FileReader(randomFile); BufferedReader BR = new
	 * BufferedReader(FR);
	 * 
	 * String loyaltypts = BR.readLine(); BR.close();
	 * 
	 * return loyaltypts;
	 * 
	 * }
	 */


	@Test(dataProvider = "DataProvider", description = "JIRA#DEMO-0003",testName = "TC_003",priority=3)
	@XlsDataSourceParameters(path = "xls/TataDigital.xlsx", sheet = "RedeemPoints",dsArgs = "TC_Desc,points_redeemed,transaction_number,external_id,redemption_time,program_id",executeValue = "TC_003")
	//@TestRailCases(testCasesId = "TC_003")
	public void redeempoints_TC003(String TC_Desc,String points_redeemed,String transaction_number,String external_id,String redemption_time,String program_id) throws Exception {

		RedeemPointsMethod api= new RedeemPointsMethod();

		api.request.header("Authorization","Basic Y3JvbWEuYWRtaW4uMTo3NTI2MjJkMTVkMzlmOTI4OGVkOTUwZWJiN2RkOTNjMA==");

		System.out.println("Authorized");
		System.out.println("Validated"); 


		api.getProperties().replace("points_redeemed",String.valueOf(loyaltyPoints+1));
		api.getProperties().replace("transaction_number", RandomBillNumber());
		api.getProperties().replace("external_id", external_id);
		api.getProperties().replace("redemption_time", CurrentDate_billingtime());
		api.getProperties().replace("program_id", program_id);


		//api.expectResponseStatus(HttpResponseStatusType.OK_200);
		Response rs=api.callAPI();
		String messageStr = rs.asString();
		writeResponse(messageStr);

		long rsTime = rs.timeIn(TimeUnit.MILLISECONDS);
		System.out.println("Response time: " + rsTime);
	}

}


