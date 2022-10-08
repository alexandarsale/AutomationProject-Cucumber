Feature: Create new Account feature
  This feature deals with the create account functionality of the page

  Scenario: Create new Account
    Given User Launch Chrome browser and open url
    And User Clicks on SignIn
    Then User enters random email in create account text field
    And User verifies valid email is entered
    And User enters personal data information
    Then User verifies if account is successfully created
    And close browser