Feature: Access the Whispir and login 


  Scenario: Login and Print url and title
     Given I open the url
     When I input my user name and password 
     Then I should go to the home page
