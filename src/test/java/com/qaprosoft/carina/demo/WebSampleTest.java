/*
 * Copyright 2013-2018 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.demo;


import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.tatadigital.tcpapp.gui.pages.HomePage;
import com.tatadigital.tcpapp.gui.pages.SignupPage;

/**
 * This sample shows how create Web test.
 * 
 * @author qpsdemo
 */
public class WebSampleTest extends AbstractTest {
	@Test
    @MethodOwner(owner = "nilesh")
    @TestPriority(Priority.P1)
    public void testModelSpecs() {
        // Open GSM Arena home page and verify page is opened
//        HomePage homePage = new HomePage(getDriver());
    	SignupPage signupPage = new SignupPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        signupPage.open();
        Assert.assertTrue(signupPage.isPageOpened(), "Signup page is not opened");       
        signupPage.signupWithOTP("", "8823219736");
        signupPage.newuserReg("Test", "Test", "test@qk.com", "01011991");
        String userDetails = homePage.viewUserProfileDetails();
        homePage.viewUserAddressDetails();
        homePage.browserback();
        homePage.viewUserLoyaltyDetails();
        homePage.browserback();
        homePage.viewUserOffersDetails();
        homePage.browserback();
        homePage.signout();   
    }
}
