@activity5
Feature: Data driven test with Example

@SmokeTest
Scenario: Testing Login with Example
    Given the user is on the login page
    When the user enters "<Usernames>" and "<Passwords>"
    And clicks the submit button
    Then Read the page title and confirmation message on page
    Then get the confirmation text and verify message as "<Message>"
    And close the Web Browser now
    
Examples:
			| Usernames | Passwords | Message         |
      | admin     | password  | Login Success!  |
      | admin1    | password1 | Login Form      |