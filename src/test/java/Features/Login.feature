Feature: LoginFeature
  This feature deals with the login functionality of the application

  Scenario: Successful Login with Valid Credentials
    Given User Launch Chrome browser and open url
    And User Clicks on SignIn
    And User enters email as "szafiroski@gmail.com" and Password as "01101995sale" and clicks login
    Then User checks if Login is successful
    And close browser
