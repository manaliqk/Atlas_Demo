package com.qaprosoft.carina.demo.manali;

import com.qaprosoft.carina.core.foundation.cucumber.CucumberBaseTest;

import cucumber.api.CucumberOptions;

	@CucumberOptions(features = "src/test/resources/features/PostAuthenticate.feature",
	        glue = "com.qaprosoft.carina.demo.cucumber.steps.manali",
	        		format={"pretty",
	                "html:target/CreateUserAPI-test-report",
	                "pretty:target/CreateUserAPI-test-report.txt",
	                "json:target/CreateUserAPI-test-report.json",
	                "junit:target/CreateUserAPI-test-report.xml"}
	        )

	public class API_PostAuthenticateCucumberTest extends CucumberBaseTest {

		}
  

