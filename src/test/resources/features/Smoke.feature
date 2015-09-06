@smoke
Feature: Smoke test pack for motortrack


  Scenario: Check various websites and its content matchs as expected

    Given user open a browser
    And opens the url for "Armstrong Auto" brand
    Then the page should be opened
    And the brand name should be shown as "Armstrong Auto"
    And a header with name "Armstrong Auto"
    And a button with name "Send message" is shown



