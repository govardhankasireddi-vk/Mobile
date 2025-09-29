Feature: This feature is to test the swag app

  Scenario: Login to the app
    Given the app name "Swag"
    And login to the app
    Then logged in sucessfully.
    And check the products and prices
    When user added the product to the cart
    Then product should be display in the cart
