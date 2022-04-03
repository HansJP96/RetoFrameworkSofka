# new feature
# Tags: optional
@FeatureName:ShoppingProcessByUser
Feature: Shopping process by user
  As a user who want to buy products on Your Logo web page
  I should be able to add products in the shopping cart
  To buy them

  @ScenarioName:ProductSuccessfullyAddedToCart
  Scenario: Product successfully added to cart
    Given the user is on the home page
    And goes to Dresses section
    When he add some product to the cart
    Then he watches a message of successfully product added and his product in the cart

  @ScenarioName:SuccessfulPurchaseProcess
  Scenario: Successful purchase process
    Given the user already has an account
    When the user has some products in the shopping cart
    And he complete all check out basic process with a check payment method
    Then the prices are correct and successful process message appears