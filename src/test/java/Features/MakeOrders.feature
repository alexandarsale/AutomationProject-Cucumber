Feature: Ordering products successfully
  This feature deals with ordering products functionality of the page

  Scenario: Make an Order
    Given User Launch Chrome browser and open url
    And User Clicks on SignIn
    And User enters email as "szafiroski@gmail.com" and Password as "01101995sale" and clicks login
    Then User checks if Login is successful
    When User clicks on T-Shirt section
    And verifies T-Shirt section is opened
    Then User adds product to cart
    And User verifies if product is added to cart
    And User finishes order
    Then User verifies order is completed successfully
    And close browser

  Scenario: Make Order as Guest
    Given User Launch Chrome browser and open url
    When User clicks on T-Shirt section
    And verifies T-Shirt section is opened
    Then User adds product to cart
    And User verifies if product is added to cart
    Then User tries to purchase order
    Then User is asked to login to continue the purchase
    When User is logged in continues to finish the order
    Then User confirms order is complete
    And close browser

  Scenario: Make Order with increased Quantity
    Given User Launch Chrome browser and open url
    And User Clicks on SignIn
    And User enters email as "szafiroski@gmail.com" and Password as "01101995sale" and clicks login
    Then User checks if Login is successful
    When User clicks on T-Shirt section
    And verifies T-Shirt section is opened
    Then User adds product to cart
    And User verifies if product is added to cart
    Then User goes to checkout to increase quantity of product by "2" and finish order
    Then User confirms order is complete
    And close browser