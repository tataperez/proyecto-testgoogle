Feature: login home page

  Scenario: Successful loginn
    Given I am on the home page
    When I type the user and password
    Then I can see the init page

