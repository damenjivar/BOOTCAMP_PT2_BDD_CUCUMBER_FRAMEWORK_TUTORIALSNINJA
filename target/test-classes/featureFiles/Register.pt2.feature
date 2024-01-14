@TutorialsNinjaRegister
Feature: Register functionality of TutorialsNinja

  @MandatoryFields
  Scenario: Register with mandatory fields
    Given User navigates to RegisterPage
    When User enters below mandatory fields
      | firstname       | Selenium     |
      | lastname        | Panda        |
      | telephone       |   9876543210 |
      | password        | Selenium@123 |
      | confirmpassword | Selenium@123 |
    And User selects PrivacyPolicy checkbox
    When User clicks on Continue button
    Then User account gets created successfully

  @AllFields
  Scenario: Register with all fields
    Given User navigates to RegisterPage
    When User enters below all fields
      | firstname       | Selenium     |
      | lastname        | Panda        |
      | telephone       |   9876543210 |
      | password        | Selenium@123 |
      | confirmpassword | Selenium@123 |
    And User selects Yes for newsletter
    And User selects PrivacyPolicy checkbox
    When User clicks on Continue button
    Then User account gets created successfully

  @DuplicateEmail
  Scenario: Register with existing email
    Given User navigates to RegisterPage
    When User enters below all fields with existing email
      | firstname       | Selenium                |
      | lastname        | Panda                   |
      | email           | seleniumpanda@gmail.com |
      | telephone       |              9876543210 |
      | password        | Selenium@123            |
      | confirmpassword | Selenium@123            |
    And User selects Yes for newsletter
    And User selects PrivacyPolicy checkbox
    When User clicks on Continue button
    Then User gets duplicate email warning message

  @MismatchPassword
  Scenario: Register with mismatch password
    Given User navigates to RegisterPage
    When User enters below all fields with mismatch password
      | firstname       | Selenium        |
      | lastname        | Panda           |
      | telephone       |      9876543210 |
      | password        | Selenium@123    |
      | confirmpassword | invalidPassword |
    And User selects Yes for newsletter
    And User selects PrivacyPolicy checkbox
    And User clicks on Continue button
    Then User gets password mismatch warning message

  @NoFields
  Scenario: Register with no fields
    Given User navigates to RegisterPage
    When User clicks on Continue button
    Then User gets warning message for mandatory fields
