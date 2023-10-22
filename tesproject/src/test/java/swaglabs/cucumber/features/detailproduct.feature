Feature: View detail product

  @TDD
  Scenario: view detail product
    Given user login and direct to homepage
    When user click one of product
    Then system direct to detail product
