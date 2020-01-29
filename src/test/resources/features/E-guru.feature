@APITest
Feature: E-guru feature
  

    @demo @Dev
  Scenario: Verify if e-guru is able to login
     Given launch your app
     When click on userid and pw
     Then click on login
     And Click OK
     And ClickNavigation
     And click Logout
     Then clickContacts
     And Enter Basic Details
     