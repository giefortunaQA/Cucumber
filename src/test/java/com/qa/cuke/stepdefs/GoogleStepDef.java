package com.qa.cuke.stepdefs;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleStepDef {
	
	private RemoteWebDriver driver;
	private GooglePage page;
	
	@Given("I can access google.com")
	public void i_can_access_google_com() {
		driver=SeleniumDriver.getDriver();
		page=PageFactory.initElements(driver, GooglePage.class);
		driver.get(page.URL);
	}

	@When("I search for {string}")
	public void i_search_for(String string) {
		page.searchFor(string);
	}
	@And("I select images tab")
	public void i_select_images_tab() {
	    page.clickImages();
	}
	@Then("I should see images of {string} with titles containing {string}")
	public void i_should_see_images_of_with_titles_containing(String string, String string2) {
		page.verifyResultContains(string2);
	}
	
}
