Feature: Google search terms

  Scenario: Google kittens
    Given I can access google.com
    When I search for kittens
    And I select images tab
    Then I should see images of kittens


