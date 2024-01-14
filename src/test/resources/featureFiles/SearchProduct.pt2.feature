@TutorialsNinjaSearchProduct
Feature: Search Product functionality of TutorialsNinja

 @ValidProduct
 Scenario: Search with valid product
 Given User opens the application
 When User enters the valid product 'HP'
 And User clicks on the search button
 Then User gets valid product info display in SearchPage
 
  @InvalidProduct
 Scenario: Search with invalid product
 Given User opens the application
 When User enters the invalid product 'DELL'
 And User clicks on the search button
 Then User gets no product match warning message
 
  @NoProduct
 Scenario: Search with no product
 Given User opens the application
 And User clicks on the search button
 Then User gets no product match warning message