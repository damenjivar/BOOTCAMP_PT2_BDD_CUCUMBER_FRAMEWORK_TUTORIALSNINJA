@TutorialsNinjaAddToCart
Feature: Add to Cart functionality of TutorialsNinja

  @ValidProductAddToCart
  Scenario: User searches for a valid product and adds it to the cart
    Given the user opens the application
    When the user enters valid product 'HP' in the search bar
    And clicks on the search button
    Then the user gets valid product info display in SearchPage
    When the user clicks on the valid product
    And clicks the add to cart button