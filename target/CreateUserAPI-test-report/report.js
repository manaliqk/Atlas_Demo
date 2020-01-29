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
  "duration": 23204507399,
  "status": "passed"
});
formatter.match({
  "location": "EguruStepdef.enteruserid()"
});
formatter.result({
  "duration": 9362043601,
  "status": "passed"
});
formatter.match({
  "location": "EguruStepdef.clicklogin()"
});
formatter.result({
  "duration": 9685203500,
  "status": "passed"
});
formatter.match({
  "location": "EguruStepdef.ClickOK()"
});
formatter.result({
  "duration": 1389825800,
  "status": "passed"
});
formatter.match({
  "location": "EguruStepdef.Clicknavigation()"
});
formatter.result({
  "duration": 1888682900,
  "status": "passed"
});
formatter.match({
  "location": "EguruStepdef.Clicklogout()"
});
formatter.result({
  "duration": 40919405200,
  "status": "passed"
});
formatter.match({
  "location": "EguruStepdef.clickContacts()"
});
formatter.result({
  "duration": 18151885000,
  "status": "passed"
});
formatter.match({
  "location": "EguruStepdef.enterbasicdetails()"
});
formatter.result({
  "duration": 11210591100,
  "error_message": "org.openqa.selenium.NoSuchElementException: An element could not be located on the page using the given search parameters.\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027T440P\u0027, ip: \u0027192.168.216.94\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_144\u0027\nDriver info: io.appium.java_client.android.AndroidDriver\nCapabilities {appActivity: com.tatamotors.eguruhybrid...., appPackage: com.tatamotors.eguruhybrid, automationName: uiautomator2, carinaTestRunId: 1e8fb4a5-ca98-4ba4-b84c-ae9..., databaseEnabled: false, desired: {appActivity: com.tatamotors.eguruhybrid...., appPackage: com.tatamotors.eguruhybrid, automationName: uiautomator2, carinaTestRunId: 1e8fb4a5-ca98-4ba4-b84c-ae9..., deviceName: redmiy2, deviceType: phone, platformName: android, platformVersion: 9, udid: 94eacea3}, deviceApiLevel: 28, deviceManufacturer: Xiaomi, deviceModel: Redmi Y2, deviceName: 94eacea3, deviceScreenDensity: 320, deviceScreenSize: 720x1440, deviceType: phone, deviceUDID: 94eacea3, javascriptEnabled: true, locationContextEnabled: false, networkConnectionEnabled: true, pixelRatio: 2, platform: LINUX, platformName: ANDROID, platformVersion: 9, statBarHeight: 48, takesScreenshot: true, udid: 94eacea3, viewportRect: {height: 1296, left: 0, top: 48, width: 720}, warnings: {}, webStorageEnabled: false}\nSession ID: 14fc7188-8f71-468f-8e14-2e0fbc79490c\n*** Element info: {Using\u003dxpath, value\u003d//android.widget.EditText[@text\u003d\u0027Enter Last Name\u0027]}\r\n\tat sun.reflect.GeneratedConstructorAccessor18.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat com.qaprosoft.carina.core.foundation.webdriver.listener.EventFiringAppiumCommandExecutor.execute(EventFiringAppiumCommandExecutor.java:150)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.execute(DefaultGenericMobileDriver.java:41)\r\n\tat io.appium.java_client.AppiumDriver.execute(AppiumDriver.java:1)\r\n\tat io.appium.java_client.android.AndroidDriver.execute(AndroidDriver.java:1)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElement(DefaultGenericMobileDriver.java:61)\r\n\tat io.appium.java_client.AppiumDriver.findElement(AppiumDriver.java:1)\r\n\tat io.appium.java_client.android.AndroidDriver.findElement(AndroidDriver.java:1)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElementByXPath(DefaultGenericMobileDriver.java:151)\r\n\tat io.appium.java_client.AppiumDriver.findElementByXPath(AppiumDriver.java:1)\r\n\tat io.appium.java_client.android.AndroidDriver.findElementByXPath(AndroidDriver.java:1)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElement(DefaultGenericMobileDriver.java:57)\r\n\tat io.appium.java_client.AppiumDriver.findElement(AppiumDriver.java:1)\r\n\tat io.appium.java_client.android.AndroidDriver.findElement(AndroidDriver.java:1)\r\n\tat com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement.refindElement(ExtendedWebElement.java:383)\r\n\tat com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement.doAction(ExtendedWebElement.java:1382)\r\n\tat com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement.type(ExtendedWebElement.java:661)\r\n\tat com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement.type(ExtendedWebElement.java:649)\r\n\tat com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement.type(ExtendedWebElement.java:639)\r\n\tat com.qaprosoft.carina.demo.mobile.gui.pages.android.EguruMainPage.enterbasicdetails(EguruMainPage.java:50)\r\n\tat com.qaprosoft.carina.demo.cucumber.steps.manali.EguruStepdef.enterbasicdetails(EguruStepdef.java:66)\r\n\tat ✽.And Enter Basic Details(src/test/resources/features/E-guru.feature:14)\r\n",
  "status": "failed"
});
});