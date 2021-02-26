
Feature: Google search terms

  Scenario Outline: Google "<Animal>"
    Given I can access google.com
    When I search for "<Animal>"
    And I select images tab
    Then I should see images of "<Animal>" with titles containing "<keyword>"
    
   Examples:
	|Animal|keyword|
	|kitten| kitten|
	|puppy|pup|
	|duck|duck|
	|sloth|sloth|
	|panda|panda|
   
