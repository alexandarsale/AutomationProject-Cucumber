Feature: Add products to wishlist
  This feature is used to add products marked as specials to wishlist

  Scenario: Add Items To WishList
    Given User Launch Chrome browser and open url
    And User Clicks on SignIn
    And User enters email as "szafiroski@gmail.com" and Password as "01101995sale" and clicks login
    Then User checks if Login is successful
    When User clicks on T-Shirt section
    And verifies T-Shirt section is opened
    Then User clicks on Specials button
    Then User verifies Specials page is opened
    Then User clicks on list view of all products
    Then User adds first product to wishlist
    And User verifies pop-up message is displayed
    Then User closes pop-up message
    And User adds second product to wishlist
    Then User closes pop-up message
    Then User opens account menu and clicks on My Wishlist
    And User verifies my wishlist is opened
    Then User clicks on wishlist products
    And User verifies that added products to wishlist are "Printed Chiffon Dress" and "Printed Summer Dress"
    And close browser