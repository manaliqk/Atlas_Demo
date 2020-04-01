package com.qaprosoft.carina.demo.tatadigital;

import static org.testng.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBodyData;
import com.jayway.restassured.specification.RequestSpecification;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qk.common.function.RandomBillNumberGenerator;
import com.tatadigital.api.AddTxnMethod;

import okhttp3.ResponseBody;

public class Post_AddTxnTest extends AbstractTest{
        
	String number="";
	public void writeResponse(String Response) throws IOException {

		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss_");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); // 2016/11/16 12:08:43

		File responseDir = new File("src/test/resources/api/TataDigitalApiResponses/" + dateFormat.format(date)
				+ getClass().getSimpleName());

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
		@Test(dataProvider = "DataProvider", description = "JIRA#DEMO-0001,invocationCount = 20")
		@XlsDataSourceParameters(path = "xls/TataDigital.xlsx", sheet = "AddTxn",dsArgs="TC_Desc,type,number,amount,currency_code,gross_amount,billing_time,program_id,source,offer_id,external_id,mode_cash,value_cash,mode_credit,value_credit,name,value,"
		+ "lineitem1_serial,lineitem1_type,lineitem1_amount,lineitem1_description,lineitem1_item_code,lineitem1_qty,lineitem1_rate,lineitem1_value,lineitem1_discount_value,lineitem1_offer_id,"
		+ "lineitem2_serial,lineitem2_type,lineitem2_amount,lineitem2_description,lineitem2_item_code,lineitem2_qty,lineitem2_rate,lineitem2_value,lineitem2_discount_value,lineitem2_offer_id,"
		+"lineitem3_serial,lineitem3_type,lineitem3_amount,lineitem3_description,lineitem3_item_code,lineitem3_qty,lineitem3_rate,lineitem3_value,lineitem3_discount_value,lineitem3_offer_id",dsUid = "TestCaseID",executeValue = "Y")
		
		public void addtxn(String TC_Desc,String type, String number, String amount, String currency_code, String gross_amount,
				String billing_time, String program_id, String source, String offer_id, String external_id,
				String mode_cash, String value_cash, String mode_credit, String value_credit, String name, String value, String lineitem1_serial, String lineitem1_type,
				String lineitem1_amount, String lineitem1_description, String lineitem1_item_code, String lineitem1_qty,
				String lineitem1_rate, String lineitem1_value, String lineitem1_discount_value, String lineitem1_offer_id,
				String lineitem2_serial, String lineitem2_type, String lineitem2_amount, String lineitem2_description, String lineitem2_item_code,
				String lineitem2_qty, String lineitem2_rate, String lineitem2_value, String lineitem2_discount_value,String lineitem2_offer_id,
				String lineitem3_serial, String lineitem3_type,String lineitem3_amount, String lineitem3_description, String lineitem3_item_code,
				String lineitem3_qty, String lineitem3_rate, String lineitem3_value, String lineitem3_discount_value,String lineitem3_offer_id) throws Exception {

	       		//new Thread().start();
	       		AddTxnMethod api = new AddTxnMethod();
	       		number = RandomBillNumber();

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
				api.getProperties().replace("mode_credit", mode_credit);
				api.getProperties().replace("value_credit", value_credit);
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
//				api.getProperties().replace("Exch_returntype", Exch_returntype);
//				api.getProperties().replace("Exch_Txnno", Exch_Txnno);
//				api.getProperties().replace("Exch_TxnDate", Exch_TxnDate);
				api.getProperties().replace("lineitem2_amount", lineitem2_amount);
				api.getProperties().replace("lineitem2_description", lineitem2_description);
				api.getProperties().replace("lineitem2_item_code", lineitem2_item_code);
				api.getProperties().replace("lineitem2_qty", lineitem2_qty);
				api.getProperties().replace("lineitem2_rate", lineitem2_rate);
				api.getProperties().replace("lineitem2_value", lineitem2_value);
				api.getProperties().replace("lineitem2_discount_value", lineitem2_discount_value);
                api.getProperties().replace("lineitem2_offer_id", lineitem2_offer_id);
				
				api.getProperties().replace("lineitem3_serial", lineitem3_serial);
				api.getProperties().replace("lineitem3_type", lineitem3_type);
				api.getProperties().replace("lineitem3_amount", lineitem3_amount);
				api.getProperties().replace("lineitem3_description", lineitem3_description);
				api.getProperties().replace("lineitem3_item_code", lineitem3_item_code);
				api.getProperties().replace("lineitem3_qty", lineitem3_qty);
				api.getProperties().replace("lineitem3_rate", lineitem3_rate);
				api.getProperties().replace("lineitem3_value", lineitem3_value);
				api.getProperties().replace("lineitem3_discount_value", lineitem3_discount_value);
                api.getProperties().replace("lineitem3_offer_id", lineitem3_offer_id);
                
                Response rs=api.callAPI();
    			long rsTime = rs.timeIn(TimeUnit.MILLISECONDS);
    			System.out.println("Response time: " + rsTime);
		}
//    			String messageStr = rs.asString();
//    			writeResponse(messageStr);
	/*
	 * public String getfields() throws IOException { JSONObject json = new
	 * JSONObject(); JSONObject tokenobjResponse = json.getJSONObject("response");
	 * 
	 * JSONObject objTransactions = tokenobjResponse.getJSONObject("transactions");
	 * 
	 * JSONArray transactionArray = objTransactions.getJSONArray("transaction");
	 * 
	 * JSONObject objTransaction = transactionArray.getJSONObject(0);
	 * 
	 * JSONObject objItem_status = objTransaction.getJSONObject("item_status");
	 * 
	 * String ItemSuccessValue = objItem_status.getString("success");
	 * 
	 * String message=objItem_status.getString("message"); return message; }
	 */		/*
		 * File randomFile = new File("xls/TataDigital.xlsx"); FileWriter fields = new
		 * FileWriter(randomFile); BufferedWriter BW = new BufferedWriter(fields);
		 * fields.write(ItemSuccessValue); fields.write(message); fields.close(); */
	/*
	 * public void filewriter() { HSSFWorkbook workbook = new HSSFWorkbook();
	 * HSSFSheet sheet = workbook.createSheet();
	 * 
	 * Map<String, Object[]> data = new HashMap<String, Object[]>(); data.put("1",
	 * new Object[] {"message", "success"}); data.put("2", new Object[] {"message",
	 * "ItemSuccessValue"});
	 * 
	 * 
	 * Set<String> keyset = data.keySet(); int rownum = 0; for (String key : keyset)
	 * { Row row = sheet.createRow(rownum++); Object [] objArr = data.get(key); int
	 * cellnum = 0; for (Object obj : objArr) { Cell cell =
	 * row.createCell(cellnum++); if(obj instanceof Date)
	 * cell.setCellValue((Date)obj); else if(obj instanceof Boolean)
	 * cell.setCellValue((Boolean)obj); else if(obj instanceof String)
	 * cell.setCellValue((String)obj); else if(obj instanceof Double)
	 * cell.setCellValue((Double)obj); } }
	 * 
	 * try { FileOutputStream out = new FileOutputStream(new
	 * File("xls/fields.xlsx")); workbook.write(out); out.close();
	 * System.out.println("Excel written successfully..");
	 * 
	 * } catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException
	 * e) { e.printStackTrace(); }
	 * 
	 * }
	 */
/*    			validateApiMessage(messageStr, "Invalid transaction type passed");

    			validateApiSuccess(messageStr, false);

    			api.expectResponseStatus(HttpResponseStatusType.OK_200);

		}

		public void validateApiMessage(String messageStr, String ExpectedMssg) {
			JSONObject json = new JSONObject(messageStr);
			JSONObject tokenobjResponse = json.getJSONObject("response");

			JSONObject objTransactions = tokenobjResponse.getJSONObject("transactions");

			JSONArray transactionArray = objTransactions.getJSONArray("transaction");

			JSONObject objTransaction = transactionArray.getJSONObject(0);

			JSONObject objItem_status = objTransaction.getJSONObject("item_status");

			String ItemMessageValue = objItem_status.getString("message");

			assertEquals(ItemMessageValue.contains(ExpectedMssg), true);

		}

		public void validateApiSuccess(String messageStr, Boolean ExpectedSuccess) {
			JSONObject json = new JSONObject(messageStr);
			JSONObject tokenobjResponse = json.getJSONObject("response");

			JSONObject objTransactions = tokenobjResponse.getJSONObject("transactions");

			JSONArray transactionArray = objTransactions.getJSONArray("transaction");

			JSONObject objTransaction = transactionArray.getJSONObject(0);

			JSONObject objItem_status = objTransaction.getJSONObject("item_status");

			Boolean ItemSuccessValue = objItem_status.getBoolean("success");

			assertEquals(ItemSuccessValue.equals(ExpectedSuccess), true);
            
		}

		public void validateApiSuccess(String messageStr, String ExpectedSuccess) {
			JSONObject json = new JSONObject(messageStr);
			JSONObject tokenobjResponse = json.getJSONObject("response");

			JSONObject objStatus = tokenobjResponse.getJSONObject("status");

			String successValue = objStatus.getString("success");
        
			assertEquals(successValue.equalsIgnoreCase("true"), true);

			JSONObject objTransactions = tokenobjResponse.getJSONObject("transactions");

			JSONArray transactionArray = objTransactions.getJSONArray("transaction");

			JSONObject objTransaction = transactionArray.getJSONObject(0);

			JSONObject objItem_status = objTransaction.getJSONObject("item_status");

			String ItemSuccessValue = objItem_status.getString("success");
           
			assertEquals(ItemSuccessValue.contains(ExpectedSuccess), true);

		}*/
	/*
	 * public void attachBody(AddTxnMethod api, String type, String number, String
	 * amount, String currency_code, String gross_amount, String billing_time,
	 * String program_id, String source, String offer_id, String external_id, String
	 * mode_cash, String value_cash, String mode_credit, String value_credit, String
	 * name, String value, String lineitem1_serial,String lineitem1_type, String
	 * lineitem1_amount, String lineitem1_description, String
	 * lineitem1_item_code,String lineitem1_qty, String lineitem1_rate, String
	 * lineitem1_value, String lineitem1_discount_value,String lineitem1_offer_id,
	 * String lineitem2_serial, String lineitem2_type, String lineitem2_amount,
	 * String lineitem2_description, String lineitem2_item_code, String
	 * lineitem2_qty, String lineitem2_rate, String lineitem2_value,String
	 * lineitem2_discount_value, String lineitem2_offer_id, String
	 * lineitem3_serial,String lineitem3_type, String lineitem3_amount, String
	 * lineitem3_description, String lineitem3_item_code, String lineitem3_qty,
	 * String lineitem3_rate, String lineitem3_value,String
	 * lineitem3_discount_value, String lineitem3_offer_id) {
	 */
			    		
	    		/*attachBody(api,type, number, amount, currency_code, gross_amount, billing_time, program_id, source, offer_id,
    				external_id, mode_cash, value_cash, mode_credit, value_credit, name, value,
    				lineitem1_serial, lineitem1_type, lineitem1_amount, lineitem1_description, lineitem1_item_code,
    				lineitem1_qty, lineitem1_rate, lineitem1_value, lineitem1_discount_value, lineitem1_offer_id,
    				lineitem2_serial, lineitem2_type, lineitem2_amount,lineitem2_description, lineitem2_item_code, lineitem2_qty, lineitem2_rate, lineitem2_value,lineitem1_discount_value,
    				lineitem2_offer_id, lineitem3_serial, lineitem3_type,lineitem3_amount, lineitem3_description, lineitem3_item_code,
    				lineitem3_qty, lineitem3_rate, lineitem3_value,lineitem3_discount_value,lineitem3_offer_id);
*/
	   
			
		}
		
		





