package com.qa.cuke.stepdefs;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HLStepDef {
	private static RemoteWebDriver driver;
	private HLPage page;

	@Given("I have access to Hargreaves Lansdown website")
	public void i_have_access_to_Hargreaves_Lansdown_website() {
		driver=SeleniumDriver.getDriver();
		page=PageFactory.initElements(driver, HLPage.class);
		driver.get(HLPage.URL);
	}
	@When("I click the {string} tab")
	public void i_click_the_tab(String string) {
		driver.get(HLPage.URL+"/"+string);
	}

	@Then("I should see the top {string} is {string}")
	public void i_should_see_the_top_is(String string, String string2) {
		page.verifyTop(string2);
	}
}
