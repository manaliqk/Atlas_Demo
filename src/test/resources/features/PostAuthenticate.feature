@APITest
Feature: Login feature
  

    @demo @Dev
  Scenario: Verify after login token is generated or not
     Given Post endpoint given
     When Enter Username and Password
     Then Post the api
   
    Scenario: Create Account
    When enter id_token and set header
    Then retrieve specific user
