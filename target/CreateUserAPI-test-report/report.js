$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/FirstCry_Mobile.feature");
formatter.feature({
  "line": 2,
  "name": "firstcry feature",
  "description": "",
  "id": "firstcry-feature",
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
  "name": "Verify if boy is selected",
  "description": "",
  "id": "firstcry-feature;verify-if-boy-is-selected",
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
  "name": "launch First Cry App",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Select Boy and years",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Select DOB Child Name",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Click Submit",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Check the child name added",
  "keyword": "Then "
});
formatter.match({
  "location": "FirstCryBoyStepdef.MainPage()"
});
formatter.result({
  "duration": 41578890300,
  "status": "passed"
});
formatter.match({
  "location": "FirstCryBoyStepdef.Enterdetails()"
});
formatter.result({
  "duration": 2383501,
  "error_message": "java.lang.NullPointerException\r\n\tat com.qaprosoft.carina.demo.cucumber.steps.manali.FirstCryBoyStepdef.Enterdetails(FirstCryBoyStepdef.java:40)\r\n\tat ✽.When Select Boy and years(src/test/resources/features/FirstCry_Mobile.feature:8)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "FirstCryBoyStepdef.selectDOB()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "FirstCryBoyStepdef.clicksubmit()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "FirstCryBoyStepdef.checkchildname()"
});
formatter.result({
  "status": "skipped"
});
});