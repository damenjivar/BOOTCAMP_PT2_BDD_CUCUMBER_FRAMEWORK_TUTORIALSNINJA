@TutorialsNinjaLogout
Feature: Logout functionality of TutorialsNinja

  @SuccessfulLogout
  Scenario: User logs out successfully
    Given the user is logged into the application
    When the user clicks on the Logout button
    Then the user should be redirected to the logout page

  @LogoutConfirmationPrompt
  Scenario: Verify logout confirmation message
    Given the user is logged into the application
    When the user clicks on the Logout button
    Then a confirmation message should be displayed
    Then the user should be redirected to the logout page

    @LogoutRedirect
    Scenario: User redirected to homepage after clicking on continue button in logout page
    Given the user is logged into the application
    When the user clicks on the Logout button
    Then the user should be redirected to the logout page
    When the user clicks on the Continue button
    Then the user should be redirected to the home page