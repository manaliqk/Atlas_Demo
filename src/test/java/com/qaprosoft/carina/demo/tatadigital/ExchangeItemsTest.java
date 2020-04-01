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

import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.tatadigital.api.ExchangeItemsMethod;

public class ExchangeItemsTest extends AbstractTest {
	reqBody reqbody;

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

	
	  public String readBillNo() throws IOException {
	  
	  File randomFile = new File("src/test/resources/api/tatadigital/BillNo.txt");
	  FileReader FR = new FileReader(randomFile);
	  BufferedReader BR = new BufferedReader(FR); 
	  String number = BR.readLine(); 
	  BR.close(); 
	  return number;
	  
	  }
	 
	
	public String readBillTime() throws IOException {
		  
		  File randomFile1 = new File("src/test/resources/api/tatadigital/BillingTime.txt");
		  FileReader FR1 = new FileReader(randomFile1); 
		  BufferedReader BR1 = new BufferedReader(FR1); 
		  String billing_time = BR1.readLine(); 
		  BR1.close(); 
		  return billing_time;
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


	@Test(dataProvider = "DataProvider", description = "JIRA#DEMO-0001",priority=2)
	@XlsDataSourceParameters(path = "xls/TataDigital.xlsx", sheet = "ExchangeItems",dsArgs="TC_Desc,type,number,amount,gross_amount,billing_time,mobile,external_id,mode_cash,value_cash,mode_credit,value_credit,"+
	"lineitem1_serial,lineitem1_type,lineitem1_amount,lineitem1_description,lineitem1_item_code,lineitem1_qty,lineitem1_rate,lineitem1_value,transaction_number2,transaction_date2,"+
	"lineitem2_serial,lineitem2_type,lineitem2_amount,lineitem2_description,lineitem2_item_code,lineitem2_qty,lineitem2_rate,lineitem2_value,transaction_number3,transaction_date3,"+ 
	"lineitem3_serial,lineitem3_type,lineitem3_amount,lineitem3_description,lineitem3_item_code,lineitem3_qty,lineitem3_rate,lineitem3_value",dsUid = "TestCaseID",executeValue = "Y")
	public void exchangeitems(String TC_Desc,String type,String number,String amount,String gross_amount,String billing_time,String mobile,String external_id,String mode_cash, String value_cash, 
	    String mode_credit, String value_credit, String lineitem1_serial, String lineitem1_type,String lineitem1_amount, String lineitem1_description, String lineitem1_item_code, String lineitem1_qty,
		String lineitem1_rate, String lineitem1_value, String transaction_number2,String transaction_date2,String lineitem2_serial,String lineitem2_type,String lineitem2_amount,String lineitem2_description,
		String lineitem2_item_code,String lineitem2_qty,String lineitem2_rate,String lineitem2_value,String transaction_number3,
		String transaction_date3,String lineitem3_serial,String lineitem3_type,String lineitem3_amount,String lineitem3_description,String lineitem3_item_code,String lineitem3_qty,String lineitem3_rate,String lineitem3_value) throws Exception {
		
		System.out.println("reached here 1");

		new AddTxn_CommonTest().addtxn_common(reqbody.TC_Desc,reqbody.type, reqbody.number, reqbody.amount, reqbody.currency_code, reqbody.gross_amount,
				reqbody.billing_time, reqbody.program_id, reqbody.source, reqbody.offer_id, reqbody.external_id,
				reqbody.mode_cash, reqbody.value_cash, reqbody.name, reqbody.value, reqbody.lineitem1_serial, reqbody.lineitem1_type,
				reqbody.lineitem1_amount, reqbody.lineitem1_description, reqbody.lineitem1_item_code, reqbody.lineitem1_qty,
				reqbody.lineitem1_rate, reqbody.lineitem1_value, reqbody.lineitem1_discount_value, reqbody.lineitem1_offer_id,
				reqbody.lineitem2_serial, reqbody.lineitem2_type, reqbody.lineitem2_amount, reqbody.lineitem2_description, reqbody.lineitem2_item_code,
				reqbody.lineitem2_qty, reqbody.lineitem2_rate, reqbody.lineitem2_value, reqbody.lineitem2_discount_value,reqbody.lineitem2_offer_id);
				
		
		ExchangeItemsMethod exchapi= new ExchangeItemsMethod();
		exchapi.request.header("Authorization","Basic Y3JvbWEuYWRtaW4uMTo3NTI2MjJkMTVkMzlmOTI4OGVkOTUwZWJiN2RkOTNjMA==");

		System.out.println("Authorized");
		System.out.println("Validated"); 
		
		exchapi.getProperties().replace("type", type);
		exchapi.getProperties().replace("number",RandomBillNumber());
		exchapi.getProperties().replace("amount", amount);
		exchapi.getProperties().replace("gross_amount", gross_amount);
		exchapi.getProperties().replace("billing_time", CurrentDate_billingtime());
		exchapi.getProperties().replace("mobile", mobile);
        exchapi.getProperties().replace("external_id", external_id);
		exchapi.getProperties().replace("mode_cash", mode_cash);
		exchapi.getProperties().replace("value_cash", value_cash);
		exchapi.getProperties().replace("mode_credit", mode_credit);
		exchapi.getProperties().replace("value_credit", value_credit);

		exchapi.getProperties().replace("lineitem1_serial", lineitem1_serial);
		exchapi.getProperties().replace("lineitem1_type", lineitem1_type);
		exchapi.getProperties().replace("lineitem1_amount", lineitem1_amount);
		exchapi.getProperties().replace("lineitem1_description", lineitem1_description);
		exchapi.getProperties().replace("lineitem1_item_code", lineitem1_item_code);
		exchapi.getProperties().replace("lineitem1_qty", lineitem1_qty);
		exchapi.getProperties().replace("lineitem1_rate", lineitem1_rate);
		exchapi.getProperties().replace("lineitem1_value", lineitem1_value);
		
		exchapi.getProperties().replace("transaction_number2", readBillNo());
		exchapi.getProperties().replace("transaction_date2", readBillTime());
		exchapi.getProperties().replace("lineitem2_serial", lineitem2_serial);
		exchapi.getProperties().replace("lineitem2_type", lineitem2_type);
		exchapi.getProperties().replace("lineitem2_amount", lineitem2_amount);
		exchapi.getProperties().replace("lineitem2_description", lineitem2_description);
		exchapi.getProperties().replace("lineitem2_item_code", lineitem2_item_code);
		exchapi.getProperties().replace("lineitem2_qty", lineitem2_qty);
		exchapi.getProperties().replace("lineitem2_rate", lineitem2_rate);
		exchapi.getProperties().replace("lineitem2_value", lineitem2_value);
		
		exchapi.getProperties().replace("transaction_number3", readBillNo());
		exchapi.getProperties().replace("transaction_date3", readBillTime());
		exchapi.getProperties().replace("lineitem3_serial", lineitem3_serial);
		exchapi.getProperties().replace("lineitem3_type", lineitem3_type);
		exchapi.getProperties().replace("lineitem3_amount", lineitem3_amount);
		exchapi.getProperties().replace("lineitem3_description", lineitem3_description);
		exchapi.getProperties().replace("lineitem3_item_code", lineitem3_item_code);
		exchapi.getProperties().replace("lineitem3_qty", lineitem3_qty);
		exchapi.getProperties().replace("lineitem3_rate", lineitem3_rate);
		exchapi.getProperties().replace("lineitem3_value", lineitem3_value);

		//returnapi.expectResponseStatus(HttpResponseStatusType.OK_200);
		Response rs=exchapi.callAPI();
		long rsTime = rs.timeIn(TimeUnit.MILLISECONDS);
		System.out.println("Response time: " + rsTime);

		exchapi.getResponse();
		System.out.println("Response recieved");


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
			/*
			 * this.lineitem3_serial = lineitem3_serial; this.lineitem3_type =
			 * lineitem3_type; this.lineitem3_amount = lineitem3_amount;
			 * this.lineitem3_description = lineitem3_description; this.lineitem3_item_code
			 * = lineitem3_item_code; this.lineitem3_qty = lineitem3_qty;
			 * this.lineitem3_rate = lineitem3_rate; this.lineitem3_value = lineitem3_value;
			 * this.lineitem3_discount_value = lineitem3_discount_value;
			 * this.lineitem3_offer_id = lineitem3_offer_id;
			 */
		}




	}
}




