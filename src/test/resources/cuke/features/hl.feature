@ignore
Feature: Exploring Hargreaves Lansdown

  Scenario Outline: Finding top "<category>"
    Given I have access to Hargreaves Lansdown website
    When I click the "<category>" tab
    Then I should see the top "<category>" is "<top>"
    
   Examples:
   |category|top|
   |risers|IAG|
   
   @ignore
   Examples:
   |category|top|
   |fallers|RMV|
