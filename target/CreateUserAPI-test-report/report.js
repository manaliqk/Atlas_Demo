$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/CarinaDemo.feature");
formatter.feature({
  "line": 2,
  "name": "CarinaDemo feature",
  "description": "",
  "id": "carinademo-feature",
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
  "name": "Verify if carinademo opens",
  "description": "",
  "id": "carinademo-feature;verify-if-carinademo-opens",
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
  "name": "launch the app",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "click on Nextbutton",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Enter Name and Password",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "click on female and toggle",
  "keyword": "And "
});
formatter.match({
  "location": "CarinaDemoStepdef.MainPage()"
});
formatter.result({
  "duration": 14529317800,
  "status": "passed"
});
formatter.match({
  "location": "CarinaDemoStepdef.clicknextbutton()"
});
