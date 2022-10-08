Feature: Search product by name
  This feature is used to search a specific product and purchase it

  Scenario: Search product and Add to Cart
    Given User Launch Chrome browser and open url
    And User Clicks on SignIn
    And User enters email as "szafiroski@gmail.com" and Password as "01101995sale" and clicks login
    Then User checks if Login is successful
    When User enters product name as "Dress" in search box
    Then User clicks on Search button
    And User clicks on list view of all products
    Then User selects product between min and max price range
    When User verifies if product by given price is added to cart
    And User verifies every step of checkout page is opened successfully
    Then User confirms order is complete
    And close browser
