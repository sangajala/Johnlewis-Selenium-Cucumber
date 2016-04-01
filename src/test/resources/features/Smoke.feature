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


      @temp
      Scenario: Check item can be added to the basket

        Given user is in home page
        When I search for "Computers"
        And added an item to the basket with title "Buy HP Envy 15-AE002NA Laptop PC, Intel Core i7, 12GB RAM, 256GB,15.6"
        Then an item should be available in basket



 @temp
      Scenario: Check item can be added to the basket

        Given user is in home page
        When I search for "Computers"
        And added an item to the basket with title "Buy HP Envy 15-AE002NA Laptop PC, Intel Core i7, 12GB RAM, 256GB,15.6"
        Then an item should be available in basket









