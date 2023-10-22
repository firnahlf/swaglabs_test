Feature: checkout product

  Scenario: success checkout product
    Given user success to login and go to cart page
    When user click checkout
    And user fill all form
    And user click continue
    And user view detail checkout overview
    And user click finish
    Then user success to checkout product

  Scenario: failed checkout product
    Given user success to login
    Given user is on add to cart page
    When user click checkout
    And user click continue
    Then system will show error message
