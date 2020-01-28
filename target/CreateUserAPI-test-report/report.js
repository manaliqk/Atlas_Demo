$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/EmployeeCreation.feature");
formatter.feature({
  "line": 2,
  "name": "employeeCreation feature",
  "description": "",
  "id": "employeecreation-feature",
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
  "name": "Verify if employee gets added",
  "description": "",
  "id": "employeecreation-feature;verify-if-employee-gets-added",
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
  "name": "post endpoint",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Enter details",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "take api",
  "keyword": "Then "
});
formatter.match({
  "location": "PostCreateEmpStepdef.startmethod()"
});
formatter.result({
  "duration": 816073500,
  "status": "passed"
});
formatter.match({
  "location": "PostCreateEmpStepdef.enterthedetails()"
});
formatter.result({
  "duration": 3531646700,
  "status": "passed"
});
formatter.match({
  "location": "PostCreateEmpStepdef.postAPI()"
});
formatter.result({
  "duration": 1072041000,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Verify if employee details are viewed",
  "description": "",
  "id": "employeecreation-feature;verify-if-employee-details-are-viewed",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 12,
  "name": "get api",
  "keyword": "When "
});
formatter.match({
  "location": "PostCreateEmpStepdef.getApi()"
});
