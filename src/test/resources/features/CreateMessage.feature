Feature: This is to send a new message


  Scenario: Create a message and send message and verify the results
    Given I open the url
    When I input my user name and password
    And Click on new message
    And enter details
    Then validate result


    @new
  Scenario Outline: Create and send a message and verify that the message sent

    Given I am logged in user
    When I want to create a message with type "<Message Type>"
    And full the receipt field To "<To>" label "<Label>" Subject "<Subject>"
    And enter the body of the message as "<Body>"
    And send the message
    Then the Subject should be "<Subject>"

  Examples:

    | Message Type | To   | Label | Subject | Body      |
    | Mobile       | Test | Test  | Test    | Test Test |


