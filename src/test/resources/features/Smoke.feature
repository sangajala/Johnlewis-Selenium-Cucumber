@smoke
Feature: Smoke test pack for john lewis


  Scenario: check the home page is displayed with options

    Given user open a browser
    When open the ham burger menu
    Then I should see the following option
      | link | Home                 |
      | link | Browse by Department |
      | link | Partnership Card     |
      | link | Download our App     |
      | link | Contact Us           |
    When close the ham burger menu
    Then I should see the following option
    |button|Sign up               |


    Scenario Outline: User can find store

      Given user open a browser
      When he open an all the shops
      Then the branch "<Branch>" should be shown
      And he opens the branch
      Then the details of the branch should be shown

      Examples:
      |Branch|
      |Glasgow|









