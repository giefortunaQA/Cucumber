# Cucumber-Gherkin with Selenium

Refactored Selenium tests from https://github.com/giefortunaQA/Selenium. We used Cucumber features to generate scenarios and their user acceptance criteria.
The feature files are readable to non-technical users and provide a clear outline of the criteria for passing. 

# Google search Example:
```
<-- google.feature -->
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
 ```
 
 As we run this feature file "as Cucumber", step definitions are generated in the console. We simply copy and paste them and provide the corresponding logic/assertions needed to realise each stage.

```
<--StepDefExample-->
	@Given("I can access google.com")
	public void i_can_access_google_com() {
    //logic here
	}

	@When("I search for {string}")
	public void i_search_for(String string) {
		//logic here
	}
	@And("I select images tab")
	public void i_select_images_tab() {
	    //logic here
	}
	@Then("I should see images of {string} with titles containing {string}")
	public void i_should_see_images_of_with_titles_containing(String string, String string2) {
		//assertions here
	}
 ```
