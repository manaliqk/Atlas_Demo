$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/E-guru.feature");
formatter.feature({
  "line": 2,
  "name": "E-guru feature",
  "description": "",
  "id": "e-guru-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@APITest"
    }
  ]
});
formatter.scenario({
  "line": 6,
  "name": "Verify if e-guru is able to login",
  "description": "",
  "id": "e-guru-feature;verify-if-e-guru-is-able-to-login",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@demo"
    },
    {
      "line": 5,
      "name": "@Dev"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "launch your app",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "click on userid and pw",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "click on login",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "Click OK",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "ClickNavigation",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "click Logout",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "clickContacts",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "Enter Basic Details",
  "keyword": "And "
});
formatter.match({
  "location": "EguruStepdef.Mainpage()"
});
formatter.result({
  "duration": 35741872800,
  "status": "passed"
});
formatter.match({
  "location": "EguruStepdef.enteruserid()"
});
formatter.result({
  "duration": 10922561700,
  "status": "passed"
});
formatter.match({
  "location": "EguruStepdef.clicklogin()"
});
formatter.result({
  "duration": 10080273400,
  "status": "passed"
});
formatter.match({
  "location": "EguruStepdef.ClickOK()"
});
formatter.result({
  "duration": 23954880500,
  "error_message": "org.openqa.selenium.NoSuchElementException: Unable to detect element: OK (By.xpath: //android.widget.Button[@text\u003d\u0027OK\u0027])\r\n\tat com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement.doAction(ExtendedWebElement.java:1391)\r\n\tat com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement.doAction(ExtendedWebElement.java:1345)\r\n\tat com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement.click(ExtendedWebElement.java:493)\r\n\tat com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement.click(ExtendedWebElement.java:481)\r\n\tat com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement.click(ExtendedWebElement.java:472)\r\n\tat com.qaprosoft.carina.demo.mobile.gui.pages.android.EguruLoginPage.ClickOK(EguruLoginPage.java:66)\r\n\tat com.qaprosoft.carina.demo.cucumber.steps.manali.EguruStepdef.ClickOK(EguruStepdef.java:45)\r\n\tat ✽.And Click OK(src/test/resources/features/E-guru.feature:10)\r\nCaused by: org.openqa.selenium.NoSuchElementException: An element could not be located on the page using the given search parameters.\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027QKNBK296\u0027, ip: \u0027192.168.106.97\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_231\u0027\nDriver info: io.appium.java_client.android.AndroidDriver\nCapabilities {appActivity: com.tatamotors.eguruhybrid...., appPackage: com.tatamotors.eguruhybrid, automationName: uiautomator2, carinaTestRunId: ea6c0a56-25f9-4f31-8a77-94c..., databaseEnabled: false, desired: {appActivity: com.tatamotors.eguruhybrid...., appPackage: com.tatamotors.eguruhybrid, automationName: uiautomator2, carinaTestRunId: ea6c0a56-25f9-4f31-8a77-94c..., deviceName: redmiy2, deviceType: phone, platformName: android, platformVersion: 9, udid: 94eacea3}, deviceApiLevel: 28, deviceManufacturer: Xiaomi, deviceModel: Redmi Y2, deviceName: 94eacea3, deviceScreenDensity: 320, deviceScreenSize: 720x1440, deviceType: phone, deviceUDID: 94eacea3, javascriptEnabled: true, locationContextEnabled: false, networkConnectionEnabled: true, pixelRatio: 2, platform: LINUX, platformName: ANDROID, platformVersion: 9, statBarHeight: 48, takesScreenshot: true, udid: 94eacea3, viewportRect: {height: 1296, left: 0, top: 48, width: 720}, warnings: {}, webStorageEnabled: false}\nSession ID: 5aec400f-db0f-49a9-9308-7d16ed684902\n*** Element info: {Using\u003dxpath, value\u003d//android.widget.Button[@text\u003d\u0027OK\u0027]}\r\n\tat sun.reflect.GeneratedConstructorAccessor19.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat com.qaprosoft.carina.core.foundation.webdriver.listener.EventFiringAppiumCommandExecutor.execute(EventFiringAppiumCommandExecutor.java:150)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.execute(DefaultGenericMobileDriver.java:41)\r\n\tat io.appium.java_client.AppiumDriver.execute(AppiumDriver.java:1)\r\n\tat io.appium.java_client.android.AndroidDriver.execute(AndroidDriver.java:1)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElement(DefaultGenericMobileDriver.java:61)\r\n\tat io.appium.java_client.AppiumDriver.findElement(AppiumDriver.java:1)\r\n\tat io.appium.java_client.android.AndroidDriver.findElement(AndroidDriver.java:1)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElementByXPath(DefaultGenericMobileDriver.java:151)\r\n\tat io.appium.java_client.AppiumDriver.findElementByXPath(AppiumDriver.java:1)\r\n\tat io.appium.java_client.android.AndroidDriver.findElementByXPath(AndroidDriver.java:1)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElement(DefaultGenericMobileDriver.java:57)\r\n\tat io.appium.java_client.AppiumDriver.findElement(AppiumDriver.java:1)\r\n\tat io.appium.java_client.android.AndroidDriver.findElement(AndroidDriver.java:1)\r\n\tat com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement.refindElement(ExtendedWebElement.java:383)\r\n\tat com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement.doAction(ExtendedWebElement.java:1388)\r\n\tat com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement.doAction(ExtendedWebElement.java:1345)\r\n\tat com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement.click(ExtendedWebElement.java:493)\r\n\tat com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement.click(ExtendedWebElement.java:481)\r\n\tat com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement.click(ExtendedWebElement.java:472)\r\n\tat com.qaprosoft.carina.demo.mobile.gui.pages.android.EguruLoginPage.ClickOK(EguruLoginPage.java:66)\r\n\tat com.qaprosoft.carina.demo.cucumber.steps.manali.EguruStepdef.ClickOK(EguruStepdef.java:45)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\r\n\tat java.lang.reflect.Method.invoke(Unknown Source)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\r\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:38)\r\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\r\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:300)\r\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\r\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:44)\r\n\tat cucumber.runtime.model.CucumberFeature.run(CucumberFeature.java:165)\r\n\tat cucumber.api.testng.TestNGCucumberRunner.runCucumber(TestNGCucumberRunner.java:63)\r\n\tat com.qaprosoft.carina.core.foundation.cucumber.CucumberRunner.feature(CucumberRunner.java:56)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\r\n\tat java.lang.reflect.Method.invoke(Unknown Source)\r\n\tat org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:124)\r\n\tat org.testng.internal.Invoker.invokeMethod(Invoker.java:583)\r\n\tat org.testng.internal.Invoker.invokeTestMethod(Invoker.java:719)\r\n\tat org.testng.internal.Invoker.invokeTestMethods(Invoker.java:989)\r\n\tat org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:125)\r\n\tat org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:109)\r\n\tat org.testng.TestRunner.privateRun(TestRunner.java:648)\r\n\tat org.testng.TestRunner.run(TestRunner.java:505)\r\n\tat org.testng.SuiteRunner.runTest(SuiteRunner.java:455)\r\n\tat org.testng.SuiteRunner.runSequentially(SuiteRunner.java:450)\r\n\tat org.testng.SuiteRunner.privateRun(SuiteRunner.java:415)\r\n\tat org.testng.SuiteRunner.run(SuiteRunner.java:364)\r\n\tat org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)\r\n\tat org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:84)\r\n\tat org.testng.TestNG.runSuitesSequentially(TestNG.java:1208)\r\n\tat org.testng.TestNG.runSuitesLocally(TestNG.java:1137)\r\n\tat org.testng.TestNG.runSuites(TestNG.java:1049)\r\n\tat org.testng.TestNG.run(TestNG.java:1017)\r\n\tat org.testng.remote.AbstractRemoteTestNG.run(AbstractRemoteTestNG.java:115)\r\n\tat org.testng.remote.RemoteTestNG.initAndRun(RemoteTestNG.java:251)\r\n\tat org.testng.remote.RemoteTestNG.main(RemoteTestNG.java:77)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "EguruStepdef.Clicknavigation()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "EguruStepdef.Clicklogout()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "EguruStepdef.clickContacts()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "EguruStepdef.enterbasicdetails()"
});
formatter.result({
  "status": "skipped"
});
});