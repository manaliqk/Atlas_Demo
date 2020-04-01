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
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.demo.tatadigital.ExchangeItemsTest.reqBody;
import com.tatadigital.api.AddTxnCommonMethod;
import com.tatadigital.api.GetCustomerLoyaltyDetailsMethod;
import com.tatadigital.api.RedeemPointsMethod;

public class Earn_BurnPoints_Simultaenously extends AbstractTest{
	reqBody reqbody;

	String billing_time="";
	Integer loyaltyPoints;
	Integer redeemPoints;
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
	public String readBillNo() throws IOException {
		  
		  File randomFile = new File("src/test/resources/api/tatadigital/BillNo.txt");
		  FileReader FR = new FileReader(randomFile);
		  BufferedReader BR = new BufferedReader(FR); 
		  String number = BR.readLine(); 
		  BR.close(); 
		  return number;
		  
		  }
	public void writeBillNo(String number) throws IOException {
		
		File randomFile = new File("src/test/resources/api/tatadigital/BillNo.txt");
		FileWriter wrBillNo = new FileWriter(randomFile);
		BufferedWriter BW = new BufferedWriter(wrBillNo);

		wrBillNo.write(number);
		wrBillNo.close();
	}

	
	  public String RandomBillNumber() { String random5Digts =
	  UUID.randomUUID().toString().substring(0, 5); String
	  randomNumber="QK_"+random5Digts; StringBuilder sb = new
	  StringBuilder(randomNumber); for (int index = 0; index < sb.length();
	  index++) { char c = sb.charAt(index); if (Character.isLowerCase(c)) {
	  sb.setCharAt(index, Character.toUpperCase(c)); } }
	  System.out.println("Bill number is " + sb.toString()); String number =
	  sb.toString(); System.out.println(number); return number; }
	 
	public String CurrentDate_billingtime() throws IOException{
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		String billing_time = sdfDate.format(now);
		System.out.println(billing_time);
		return billing_time;

	}
	
		
	@Test(dataProvider = "DataProvider", description = "JIRA#DEMO-0001",priority=1)
	@XlsDataSourceParameters(path = "xls/TataDigital.xlsx", sheet = "AddTxn_Common",dsArgs="TC_Desc,type,number,amount,currency_code,gross_amount,billing_time,program_id,source,offer_id,external_id,mode_cash,value_cash,name,value,"
			+ "lineitem1_serial,lineitem1_type,lineitem1_amount,lineitem1_description,lineitem1_item_code,lineitem1_qty,lineitem1_rate,lineitem1_value,lineitem1_discount_value,lineitem1_offer_id,"
			+ "lineitem2_serial,lineitem2_type,lineitem2_amount,lineitem2_description,lineitem2_item_code,lineitem2_qty,lineitem2_rate,lineitem2_value,lineitem2_discount_value,lineitem2_offer_id",dsUid = "TestCaseID",executeValue = "Y")
	public void addtxn_common(String TC_Desc,String type, String number, String amount, String currency_code, String gross_amount,
			String billing_time, String program_id, String source, String offer_id, String external_id,
			String mode_cash, String value_cash, String name, String value, String lineitem1_serial, String lineitem1_type,
			String lineitem1_amount, String lineitem1_description, String lineitem1_item_code, String lineitem1_qty,
			String lineitem1_rate, String lineitem1_value, String lineitem1_discount_value, String lineitem1_offer_id,
			String lineitem2_serial, String lineitem2_type, String lineitem2_amount, String lineitem2_description, String lineitem2_item_code,
			String lineitem2_qty, String lineitem2_rate, String lineitem2_value, String lineitem2_discount_value,String lineitem2_offer_id) throws Exception {

		reqbody = new reqBody(TC_Desc, type, number, amount, currency_code, gross_amount, billing_time, program_id, source, offer_id, external_id, mode_cash, value_cash, name, value, lineitem1_serial, lineitem1_type, lineitem1_amount, lineitem1_description, lineitem1_item_code, lineitem1_qty, lineitem1_rate, lineitem1_value, lineitem1_discount_value, lineitem1_offer_id, lineitem2_serial, lineitem2_type, lineitem2_amount, lineitem2_description, lineitem2_item_code, lineitem2_qty, lineitem2_rate, lineitem2_value, lineitem2_discount_value, lineitem2_offer_id);
	}

	@Test(dataProvider = "DataProvider", description = "JIRA#DEMO-0002",testName = "TC_001",priority=2)
	@XlsDataSourceParameters(path = "xls/TataDigital.xlsx", sheet = "GetCustloyalty",dsArgs="TC_Desc,customer_id",executeColumn="TestCaseID",executeValue = "TC_001")
	public void getcustloyaltydetails_beforeRedeem(String TC_Desc,String customer_id) throws Exception 
	{
		new AddTxn_CommonTest().addtxn_common(reqbody.TC_Desc,reqbody.type, reqbody.number, reqbody.amount, reqbody.currency_code, reqbody.gross_amount,
				reqbody.billing_time, reqbody.program_id, reqbody.source, reqbody.offer_id, reqbody.external_id,
				reqbody.mode_cash, reqbody.value_cash, reqbody.name, reqbody.value, reqbody.lineitem1_serial, reqbody.lineitem1_type,
				reqbody.lineitem1_amount, reqbody.lineitem1_description, reqbody.lineitem1_item_code, reqbody.lineitem1_qty,
				reqbody.lineitem1_rate, reqbody.lineitem1_value, reqbody.lineitem1_discount_value, reqbody.lineitem1_offer_id,
				reqbody.lineitem2_serial, reqbody.lineitem2_type, reqbody.lineitem2_amount, reqbody.lineitem2_description, reqbody.lineitem2_item_code,
				reqbody.lineitem2_qty, reqbody.lineitem2_rate, reqbody.lineitem2_value, reqbody.lineitem2_discount_value,reqbody.lineitem2_offer_id);

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
		redeemPoints= getRedeemedValue(messageStr);
	}
	public Integer getloyaltyPointsValue(String messageStr) throws IOException {
		JSONObject json = new JSONObject(messageStr);
		
		JSONArray dataArray = json.getJSONArray("data");

		JSONObject dataObj = dataArray.getJSONObject(1);

		Integer loyaltyPoints = dataObj.getInt("loyaltyPoints");
		System.out.println(loyaltyPoints);
		return loyaltyPoints;

	}
	public Integer getRedeemedValue(String messageStr) throws IOException {
JSONObject json = new JSONObject(messageStr);
		
		JSONArray dataArray = json.getJSONArray("data");

		JSONObject dataObj = dataArray.getJSONObject(1);

		Integer redeemPoints = dataObj.getInt("redeemed");
		System.out.println(redeemPoints);

		return redeemPoints;

           }
	
	@Test(dataProvider = "DataProvider", description = "JIRA#DEMO-0003",testName = "TC_004",priority=3)
	@XlsDataSourceParameters(path = "xls/TataDigital.xlsx", sheet = "RedeemPoints",dsArgs = "TC_Desc,points_redeemed,transaction_number,external_id,redemption_time,program_id",executeValue = "TC_004")
	public void redeempoints_TC004(String TC_Desc,String points_redeemed,String transaction_number,String external_id,String redemption_time,String program_id) throws Exception {

		
		RedeemPointsMethod api= new RedeemPointsMethod();

		api.request.header("Authorization","Basic Y3JvbWEuYWRtaW4uMTo3NTI2MjJkMTVkMzlmOTI4OGVkOTUwZWJiN2RkOTNjMA==");

		System.out.println("Authorized");
		System.out.println("Validated"); 


		api.getProperties().replace("points_redeemed",points_redeemed);
		api.getProperties().replace("transaction_number", readBillNo());
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

	@Test(dataProvider = "DataProvider", description = "JIRA#DEMO-0002",testName = "TC_001",priority=4)
	@XlsDataSourceParameters(path = "xls/TataDigital.xlsx", sheet = "GetCustloyalty",dsArgs="TC_Desc,customer_id",executeColumn="TestCaseID",executeValue = "TC_001")
	public void getcustloyaltydetails_afterRedeem(String TC_Desc,String customer_id) throws Exception 
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
		redeemPoints= getRedeemedValue(messageStr);
	}
	public class reqBody{
		String TC_Desc;String type; String number; String amount; String currency_code; String gross_amount;
		String billing_time; String program_id; String source; String offer_id; String external_id;
		String mode_cash; String value_cash; String name; String value; String lineitem1_serial; String lineitem1_type;
		String lineitem1_amount; String lineitem1_description; String lineitem1_item_code; String lineitem1_qty;
		String lineitem1_rate; String lineitem1_value; String lineitem1_discount_value; String lineitem1_offer_id;
		String lineitem2_serial; String lineitem2_type; String lineitem2_amount; String lineitem2_description; String lineitem2_item_code;
		String lineitem2_qty; String lineitem2_rate; String lineitem2_value; String lineitem2_discount_value;String lineitem2_offer_id;


		public reqBody(String tC_Desc, String type, String number, String amount, String currency_code,
				String gross_amount, String billing_time, String program_id, String source, String offer_id,
				String external_id, String mode_cash, String value_cash, String name, String value,
				String lineitem1_serial, String lineitem1_type, String lineitem1_amount,
				String lineitem1_description, String lineitem1_item_code, String lineitem1_qty,
				String lineitem1_rate, String lineitem1_value, String lineitem1_discount_value,
				String lineitem1_offer_id, String lineitem2_serial, String lineitem2_type, String lineitem2_amount,
				String lineitem2_description, String lineitem2_item_code, String lineitem2_qty,
				String lineitem2_rate, String lineitem2_value, String lineitem2_discount_value,
				String lineitem2_offer_id) {

			super();
			this.TC_Desc = tC_Desc;
			this.type = type;
			this.number = number;
			this.amount = amount;
			this.currency_code = currency_code;
			this.gross_amount = gross_amount;
			this.billing_time = billing_time;
			this.program_id = program_id;
			this.source = source;
			this.offer_id = offer_id;
			this.external_id = external_id;
			this.mode_cash = mode_cash;
			this.value_cash = value_cash;
			this.name = name;
			this.value = value;
			this.lineitem1_serial = lineitem1_serial;
			this.lineitem1_type = lineitem1_type;
			this.lineitem1_amount = lineitem1_amount;
			this.lineitem1_description = lineitem1_description;
			this.lineitem1_item_code = lineitem1_item_code;
			this.lineitem1_qty = lineitem1_qty;
			this.lineitem1_rate = lineitem1_rate;
			this.lineitem1_value = lineitem1_value;
			this.lineitem1_discount_value = lineitem1_discount_value;
			this.lineitem1_offer_id = lineitem1_offer_id;
			this.lineitem2_serial = lineitem2_serial;
			this.lineitem2_type = lineitem2_type;
			this.lineitem2_amount = lineitem2_amount;
			this.lineitem2_description = lineitem2_description;
			this.lineitem2_item_code = lineitem2_item_code;
			this.lineitem2_qty = lineitem2_qty;
			this.lineitem2_rate = lineitem2_rate;
			this.lineitem2_value = lineitem2_value;
			this.lineitem2_discount_value = lineitem2_discount_value;
			this.lineitem2_offer_id = lineitem2_offer_id;
}
}
}