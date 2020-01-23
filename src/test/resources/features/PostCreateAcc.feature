@APITest
Feature: Create Account feature
  

  @demo @Dev
  Scenario: Verify Account Creation
     Given Post ur endpoint
     When APIPosted and set authorization
    And Get the Responses