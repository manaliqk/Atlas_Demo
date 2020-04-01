package com.qaprosoft.carina.demo.tatadigital;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.tatadigital.api.GenerateOTPMethod;
import com.tatadigital.api.ValidateOTPMethod;

public class Post_GenerateOTPTest extends AbstractTest {

	public void writeResponse(String Response) throws IOException {


		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss_"); 
		Date date = new Date(); System.out.println(dateFormat.format(date)); // 2016/11/16

		File responseDir = new File("src/test/resources/api/TataDigitalApiResponses/"+ dateFormat.format(date) + getClass().getSimpleName());

		responseDir.mkdirs();

		File responseFile = new File(responseDir + "/Response.txt"); 
		FileWriter wrResponse = new FileWriter(responseFile); 
		//BufferedWriter BW = new BufferedWriter(wrResponse);

		wrResponse.write(Response); wrResponse.close();
	}

	@Test(dataProvider = "DataProvider", description = "JIRA#DEMO-0001")
	@XlsDataSourceParameters(path = "xls/TataDigital.xlsx", sheet = "GenerateOTP",dsArgs = "TC_Desc,entityType,entityValue,action,template,EmailTemplateSUbject,"+
	"EmailTemplatebody,smstype,smsvalue,emailtype,emailvalue", dsUid = "TestCaseID",executeValue = "Y")
	public void generateOTP(String TC_Desc,String entityType,String entityValue,String action,String template,String EmailTemplateSUbject,
			String EmailTemplatebody,String smstype,String smsvalue,String emailtype,String emailvalue) throws Exception 
	{
	
		 	
	GenerateOTPMethod api= new GenerateOTPMethod();
		
	api.request.header("Authorization","Basic Y3JvbWEuYWRtaW4uMTo3NTI2MjJkMTVkMzlmOTI4OGVkOTUwZWJiN2RkOTNjMA==");

	System.out.println("Authorized");
    System.out.println("Validated"); 
    
    api.getProperties().replace("entityType", entityType);
    api.getProperties().replace("entityValue", entityValue);
    api.getProperties().replace("action", action);
    api.getProperties().replace("template", template);
    api.getProperties().replace("EmailTemplateSUbject", EmailTemplateSUbject);
    api.getProperties().replace("EmailTemplatebody", EmailTemplatebody);
    api.getProperties().replace("smstype", smstype);
    api.getProperties().replace("smsvalue", smsvalue);
    api.getProperties().replace("emailtype", emailtype);
    api.getProperties().replace("emailvalue", emailvalue);

    Response rs=api.callAPI();
	long rsTime = rs.timeIn(TimeUnit.MILLISECONDS);
	System.out.println("Response time: " + rsTime);

	api.getResponse();
	System.out.println("Response recieved");

	 		

}
}
	


