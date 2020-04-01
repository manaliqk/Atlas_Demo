package com.qaprosoft.carina.demo.tatadigital;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import com.jayway.restassured.response.Response;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.tatadigital.api.RegisterCustMethod;

public class Post_RegisterCustomerTest extends AbstractTest {

	public void writeResponse(String Response) throws IOException {


		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss_"); 
		Date date = new Date(); 
		System.out.println(dateFormat.format(date)); // 2016/11/16

		File responseDir = new File("src/test/resources/api/TataDigitalApiResponses/"+ dateFormat.format(date) + getClass().getSimpleName());

		responseDir.mkdirs();

		File responseFile = new File(responseDir + "/Response.txt"); 
		FileWriter wrResponse = new FileWriter(responseFile); 
		//BufferedWriter BW = new BufferedWriter(wrResponse);

		wrResponse.write(Response); wrResponse.close();
	}

	@Test(dataProvider = "DataProvider", description = "JIRA#DEMO-0001")
	@XlsDataSourceParameters(path = "xls/TataDigital.xlsx", sheet = "RegisterCust",dsArgs = "TC_Desc,mobile,email,external_id,firstname,lastname,registered_on", dsUid = "TestCaseID",executeValue = "Y")
	public void registercustomer(String TC_Desc,String mobile,String email,String external_id,String firstname,String lastname,String registered_on) throws Exception 
	{
	
		 	
		RegisterCustMethod api= new RegisterCustMethod();
		
	api.request.header("Authorization","Basic Y3JvbWEuYWRtaW4uMTo3NTI2MjJkMTVkMzlmOTI4OGVkOTUwZWJiN2RkOTNjMA==");

	System.out.println("Authorized");
    System.out.println("Validated"); 
    
    api.getProperties().replace("mobile", mobile);
    api.getProperties().replace("email", email);
    api.getProperties().replace("external_id", external_id);
    api.getProperties().replace("firstname", firstname);
    api.getProperties().replace("lastname", lastname);
    api.getProperties().replace("registered_on", registered_on);
    Response rs=api.callAPI();
	long rsTime = rs.timeIn(TimeUnit.MILLISECONDS);
	System.out.println("Response time: " + rsTime);

	api.getResponse();
	System.out.println("Response recieved");

	 		

}
}
	


