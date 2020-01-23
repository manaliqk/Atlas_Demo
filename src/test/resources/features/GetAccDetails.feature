@APITest
Feature: Get Accounts feature
  

  @demo @Dev
  Scenario: Verify Get Account
     Given Get ur endpoint
    When set the authorization
    Then Get_Api
    And check the Response