Feature: Login page Swag labs

  @TDD
  Scenario: Success login
    Given user is on login page
    When user input username
    And user input password
    And user click button login
    Then user success to login

  @TDD
  Scenario: Failed to login
    Given user is on login page
    When user input username
    And user input wrong password
    And user click button login
    Then user will get error message
