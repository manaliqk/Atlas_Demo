@APITest
Feature: firstcry feature
  

    @demo @Dev
  Scenario: Verify if boy is selected
     Given launch First Cry App
     When Select Boy and years
     And Select DOB Child Name
     And Click Submit
     Then Check the child name added
   
