@activity4
Feature: Data driven test without Example

@SmokeTest
Scenario: Testing Login without Examples
    Given New User is on Login page
    When New User enters "admin" and "password"
    Then New Read the page title and confirmation message
    And New Close the Web Browser