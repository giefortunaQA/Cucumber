package com.qa.cuke.stepdefs;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShoppingStepDef {
	private static RemoteWebDriver driver;
	private ShoppingPage page;

	@Given("I have access to the website")
	public void i_have_access_to_the_website() {
		driver = SeleniumDriver.getDriver();
		page = PageFactory.initElements(driver, ShoppingPage.class);
		driver.get(ShoppingPage.URL);
	}

	@When("I click the tab for dresses")
	public void i_click_the_tab_for_dresses() {
		page.goToDresses();
	}

	@Then("I should see dresses in the results page")
	public void i_should_see_dresses_in_the_results_page() {
		page.assertAreDresses();
	}
}
