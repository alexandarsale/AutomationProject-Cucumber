Feature: Adding specials products to cart and making purchase

  Scenario: Add Specials To Cart
    Given User Launch Chrome browser and open url
    And User Clicks on SignIn
    And User enters email as "szafiroski@gmail.com" and Password as "01101995sale" and clicks login
    Then User checks if Login is successful
    When User clicks on T-Shirt section
    And verifies T-Shirt section is opened
    Then User clicks on Specials button
    Then User verifies Specials page is opened
    Then User adds first special product to cart
    Then User adds second special product and purchase the order
    Then User confirms order is complete
    And close browser