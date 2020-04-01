package com.qaprosoft.carina.demo.tatadigital;

import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.tatadigital.api.AddTxnCommonMethod;

public class AddTxn_CommonTest extends AbstractTest{

	String number="";
	String billing_time="";
	public void writeResponse(String Response) throws IOException {

		
		  DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss_"); 
		  Date date = new Date(); System.out.println(dateFormat.format(date)); // 2016/11/16
		  
		  File responseDir = new File("src/test/resources/api/TataDigitalApiResponses/"
		  + dateFormat.format(date) + getClass().getSimpleName());
		  
		  responseDir.mkdirs();
		  
		  File responseFile = new File(responseDir + "/Response.txt"); 
		  FileWriter wrResponse = new FileWriter(responseFile); 
		  BufferedWriter BW = new BufferedWriter(wrResponse);
		  
		  wrResponse.write(Response);
		  wrResponse.close();
		
	}

	public String RandomBillNumber() {
	String random5Digts = UUID.randomUUID().toString().substring(0, 5);
	String randomNumber="QK_"+random5Digts;
	StringBuilder sb = new StringBuilder(randomNumber);
	for (int index = 0; index < sb.length(); index++) {
		char c = sb.charAt(index);
		if (Character.isLowerCase(c)) {
			sb.setCharAt(index, Character.toUpperCase(c));
		}
	}
	System.out.println("Bill number is " + sb.toString());
	String number = sb.toString();
	System.out.println(number);
	return number;
}
	public String CurrentDate_billingtime() throws IOException{
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		String billing_time = sdfDate.format(now);
		System.out.println(billing_time);
		return billing_time;
		
	}
		public void writeBillNo(String number) throws IOException {
	
		File randomFile = new File("src/test/resources/api/tatadigital/BillNo.txt");
		FileWriter wrBillNo = new FileWriter(randomFile);
		//BufferedWriter BW = new BufferedWriter(wrBillNo);

		wrBillNo.write(number);
		wrBillNo.close();
	}
	
	public void writeBilltime(String billing_time) throws IOException{	
		File randomFile1 = new File("src/test/resources/api/tatadigital/BillingTime.txt");
		FileWriter wrBilltime = new FileWriter(randomFile1);
		//BufferedWriter BW1 = new BufferedWriter(wrBilltime);
        wrBilltime.write(billing_time);
		wrBilltime.close();
	}
	
	
	@Test(dataProvider = "DataProvider", description = "JIRA#DEMO-0001")
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
    
       		AddTxnCommonMethod api = new AddTxnCommonMethod();
       		number = RandomBillNumber();
            billing_time=CurrentDate_billingtime();
            		
			api.request.header("Authorization", "Basic Y3JvbWEuYWRtaW4uMTo3NTI2MjJkMTVkMzlmOTI4OGVkOTUwZWJiN2RkOTNjMA==");
			api.getProperties().replace("number", number);
			api.getProperties().replace("type", type);
			api.getProperties().replace("amount", amount);
			api.getProperties().replace("currency_code", currency_code);
			api.getProperties().replace("gross_amount", gross_amount);
			api.getProperties().replace("billing_time", billing_time);
			api.getProperties().replace("program_id", program_id);
			api.getProperties().replace("source", source);
			api.getProperties().replace("offer_id", offer_id);
			api.getProperties().replace("external_id", external_id);

			api.getProperties().replace("mode_cash", mode_cash);
			api.getProperties().replace("value_cash", value_cash);
			
			api.getProperties().replace("name", name);
			api.getProperties().replace("value", value);
			api.getProperties().replace("lineitem1_serial", lineitem1_serial);
			api.getProperties().replace("lineitem1_type", lineitem1_type);
			api.getProperties().replace("lineitem1_amount", lineitem1_amount);
			api.getProperties().replace("lineitem1_description", lineitem1_description);
			api.getProperties().replace("lineitem1_item_code", lineitem1_item_code);
			api.getProperties().replace("lineitem1_qty", lineitem1_qty);
			api.getProperties().replace("lineitem1_rate", lineitem1_rate);
			api.getProperties().replace("lineitem1_value", lineitem1_value);
			api.getProperties().replace("lineitem1_discount_value", lineitem1_discount_value);
			api.getProperties().replace("lineitem1_offer_id", lineitem1_offer_id);

			api.getProperties().replace("lineitem2_serial", lineitem2_serial);
			api.getProperties().replace("lineitem2_type", lineitem2_type);			
			api.getProperties().replace("lineitem2_amount", lineitem2_amount);
			api.getProperties().replace("lineitem2_description", lineitem2_description);
			api.getProperties().replace("lineitem2_item_code", lineitem2_item_code);
			api.getProperties().replace("lineitem2_qty", lineitem2_qty);
			api.getProperties().replace("lineitem2_rate", lineitem2_rate);
			api.getProperties().replace("lineitem2_value", lineitem2_value);
			api.getProperties().replace("lineitem2_discount_value", lineitem2_discount_value);
            api.getProperties().replace("lineitem2_offer_id", lineitem2_offer_id);
			
		
            
            Response rs=api.callAPI();
		/*
		 * String messageStr = rs.asString();
		 * 
		 * writeResponse(messageStr);
		 */
			long rsTime = rs.timeIn(TimeUnit.MILLISECONDS);
			System.out.println("Response time: " + rsTime);
			writeBillNo(number);
			writeBilltime(billing_time);
			
			
	}

}