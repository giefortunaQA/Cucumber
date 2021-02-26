package com.qa.cuke.stepdefs;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ToursStepDef {
	private static RemoteWebDriver driver;
	private ToursPage page;

	@Given("I have access to mercury tours website")
	public void i_hac_ve_access_to_mercury_tours_website() {
		driver = SeleniumDriver.getDriver();
		page = PageFactory.initElements(driver, ToursPage.class);
		driver.get(ToursPage.URL);
	}

	@When("I click the register button")
	public void i_click_the_register_button() {
		page.goToRegister();
	}

	@When("I input my details and submit:")
	public void i_input_my_details_and_submit(DataTable dataTable) {
		page.register(driver, dataTable);
	}

	@When("I go to the sign in page")
	public void i_go_to_the_sign_in_page() {
		page.goToLogin();
	}

	@When("I use the {string} and {string} to login")
	public void i_use_the_and_to_login(String string, String string2) {
		page.login(string, string2);
	}

	@Then("I should see a successful login message")
	public void i_should_see_a_successful_login_message() {
		page.verifyResult();

	}

}
