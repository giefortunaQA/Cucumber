package com.qa.cuke.stepdefs;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShoppingStepDef {
	private static RemoteWebDriver driver;
	
	@Given("I have access to the website")
	public void i_have_access_to_the_website() {
		driver=SeleniumDriver.getDriver();
		driver.get("http://automationpractice.com/index.php");
	}

	@When("I click the tab for dresses")
	public void i_click_the_tab_for_dresses() {
		driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(2) > a")).click();
	}


	@Then("I should see dresses in the results page")
	public void i_should_see_dresses_in_the_results_page() {

		WebElement results= driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul"));
		List<WebElement> images= results.findElements(By.tagName("img"));
		for (WebElement image:images) {
			assertTrue(image.getAttribute("title").contains("Dress"));
		}
	}
}
