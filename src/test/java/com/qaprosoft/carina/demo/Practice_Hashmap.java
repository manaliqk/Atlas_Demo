package com.qaprosoft.carina.demo;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.Login_Gmail;

public class Practice_Hashmap extends AbstractTest 
{
	@Test(dataProvider = "DataProvider")
	@MethodOwner(owner = "qpsdemo")
	@TestPriority(Priority.P1)
   // @XlsDataSourceParameters(path = "xls/demo.xlsx", sheet = "GSMArena", dsUid = "TUID")

	@XlsDataSourceParameters(path = "xls/demo.xlsx", sheet = "logindetails", dsUid = "TUID")

		public void testModelSpecs(HashMap<String, String> testDetails) {
			// Open GSM Arena home page and verify page is opened
			//setUp("testModelSpecs");
			//System.out.println(testDetails);

		System.out.println("**********TestDetails are *******" + testDetails);
			
		/*
		 * for(int i=1;i<=3;i++) {
		 * 
		 * }
		 */
		Login_Gmail login= new Login_Gmail(getDriver());
		login.open();
		System.out.println("Link openend");
}
}