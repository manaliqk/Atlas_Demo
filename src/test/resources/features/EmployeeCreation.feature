@APITest
Feature: employeeCreation feature
  

    @demo @Dev
  Scenario: Verify if employee gets added
     Given post endpoint
     When Enter details
     Then take api
     
     Scenario: Verify if employee details are viewed
     When get api
  
      

