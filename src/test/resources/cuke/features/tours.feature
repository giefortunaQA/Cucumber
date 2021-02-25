@ignore
Feature: Mercury Tours sign up and log in

  Scenario: Creating an account and logging in
    Given I have access to mercury tours website
    When I click the register button
    And I input my details and submit
    And I go to the sign in page
    And I use the same details to sign in
    Then I should see a successful login message

