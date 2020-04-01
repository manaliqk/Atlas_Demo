package com.qaprosoft.carina.demo.tatadigital;

import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.tatadigital.api.GetCustTxnMethod;

public class GetCustomerTxnTest extends AbstractTest {
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
	
	
	
	/*
	 * public void validateApiMessage(String messageStr, String ExpectedMssg) {
	 * JSONObject obj = new JSONObject(messageStr); JSONObject objresponse =
	 * obj.getJSONObject("response");
	 * 
	 * JSONObject objCustomer = objresponse.getJSONObject("customer");
	 * 
	 * JSONObject objRespTxns = objCustomer.getJSONObject("transactions");
	 * 
	 * //JSONObject objTransactions =objCustomer.getJSONObject("transactions");
	 * 
	 * JSONArray transactionArray = objCustomer.getJSONArray("transaction");
	 * 
	 * JSONObject objTransaction = transactionArray.getJSONObject(0);
	 * 
	 * JSONObject objItem_status = objTransaction.getJSONObject("item_status");
	 * 
	 * String ItemMessageValue = objItem_status.getString("message");
	 * 
	 * assertEquals(ItemMessageValue.contains(ExpectedMssg), true);
	 * 
	 * }
	 * 
	 * public void validateApiSuccess(String messageStr, Boolean ExpectedSuccess) {
	 * JSONObject json = new JSONObject(messageStr); JSONObject tokenobjResponse =
	 * json.getJSONObject("response");
	 * 
	 * 
	 * JSONObject objCustomer = tokenobjResponse.getJSONObject("customer");
	 * 
	 * JSONObject objResp = objCustomer.getJSONObject("transactions");
	 * 
	 * //JSONObject objTransactions =
	 * tokenobjResponse.getJSONObject("transactions");
	 * 
	 * JSONArray transactionArray = objResp.getJSONArray("transaction");
	 * 
	 * JSONObject objTransaction = transactionArray.getJSONObject(0);
	 * 
	 * JSONObject objItem_status = tokenobjResponse.getJSONObject("item_status");
	 * 
	 * Boolean ItemSuccessValue = objItem_status.getBoolean("success");
	 * 
	 * assertEquals(ItemSuccessValue.equals(ExpectedSuccess), true);
	 * 
	 * }
	 * 
	 * public void validateApiSuccess(String messageStr, String ExpectedSuccess) {
	 * JSONObject json = new JSONObject(messageStr); JSONObject tokenobjResponse
	 * =json.getJSONObject("response");
	 * 
	 * JSONObject objStatus = tokenobjResponse.getJSONObject("status");
	 * 
	 * String successValue = objStatus.getString("success");
	 * 
	 * assertEquals(successValue.equalsIgnoreCase("true"), true);
	 * 
	 * 
	 * JSONObject objTransactions = tokenobjResponse.getJSONObject("transactions");
	 * 
	 * JSONArray transactionArray = objTransactions.getJSONArray("transaction");
	 * 
	 * JSONObject objTransaction = transactionArray.getJSONObject(0);
	 * 
	 * JSONObject objItem_status = tokenobjResponse.getJSONObject("item_status");
	 * 
	 * String ItemSuccessValue = objItem_status.getString("success");
	 * 
	 * assertEquals(ItemSuccessValue.contains(ExpectedSuccess), true);
	 * System.out.println(); }
	 */ 
	 
	
	@Test(dataProvider = "DataProvider", description = "JIRA#DEMO-0001")
	@XlsDataSourceParameters(path = "xls/TataDigital.xlsx", sheet = "GetCustTxns", dsArgs = "TC_Desc,external_id", dsUid = "TestCaseID", executeValue = "Y")
	public void getcusttxns(String TC_Desc, String external_id) throws Exception {
		GetCustTxnMethod api = new GetCustTxnMethod(external_id);

		api.replaceUrlPlaceholder("external_id", external_id);

		api.request.header("Authorization", "Basic Y3JvbWEuYWRtaW4uMTo3NTI2MjJkMTVkMzlmOTI4OGVkOTUwZWJiN2RkOTNjMA==");

		System.out.println("Authorized");
		System.out.println("Validated");

		Response rs = api.callAPI();
		long rsTime = rs.timeIn(TimeUnit.MILLISECONDS);

		System.out.println("Response time: " + rsTime);
		String messageStr = rs.asString();
		writeResponse(messageStr);
		
		
		/*
		 * validateApiMessage(messageStr, "Transaction fetched successfully");
		 * 
		 * validateApiSuccess(messageStr, "true");
		 */
		 
		api.getResponse();
		
		System.out.println("Response recieved");

	}
}