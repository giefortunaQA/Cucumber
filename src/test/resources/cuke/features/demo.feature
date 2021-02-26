
Feature: Demo site tests

  Scenario: Sign up and log in 
    Given I have access to the demo site's sign up page
    And I put in my details to sign up
    And I go to the log in page
    And I use the same details to login
    Then I should see a success message

 
