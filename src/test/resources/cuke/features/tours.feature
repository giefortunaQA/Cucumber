
Feature: Mercury Tours sign up and log in

  Scenario Outline: Creating an account for "<first>" "<last>" and logging in
    Given I have access to mercury tours website
    When I click the register button
    And I input my details and submit:
    |FirstName|<first>|
    |LastName|<last>|
    |Phone|<phone>|
    |Email|<email>|
    |Address|<address>|
    |City|<city>|
    |State|<state>|
    |PostCode|<postcode>|
    |Country|<country>|
    |UserName|<uname>|
    |Password|<pword>|
    And I go to the sign in page
    And I use the "<uname>" and "<pword>" to login
    Then I should see a successful login message
		
		Examples:
		|first|last|phone|email|address|city|state|postcode|country|uname|pword|
		|Gie|Fortuna|01234567899|gf@qa.com|Some Address|Some City|Some State|P0STC0D3|Some Country|gfqa|pword123|