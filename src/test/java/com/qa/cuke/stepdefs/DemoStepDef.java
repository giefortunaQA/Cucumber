package com.qa.cuke.stepdefs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DemoStepDef {

private static RemoteWebDriver driver;

	@Given("I have access to the demo site's sign up page")
	public void i_have_access_to_the_demo_site() {
		driver=SeleniumDriver.getDriver();
		driver.get("http://thedemosite.co.uk/addauser.php");
	}

	@When("I put in my details to sign up")
	public void i_put_in_my_details_to_sign_up() {
		driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"))
				.sendKeys("guest\t");
		driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"))
				.sendKeys("guest\t\n");
	}

	@And("I go to the log in page")
	public void i_go_to_the_log_in_page() {
		driver.get("http://thedemosite.co.uk/login.php");
	}

	@And("I use the same details to login")
	public void i_use_the_same_details_to_login() {
		driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"))
				.sendKeys("guest\t");
		driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"))
				.sendKeys("guest\t\n");
	}

	@Then("I should see a success message")
	public void i_should_see_a_success_message() {
		String expected=driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText();
		assertEquals("**Successful Login**", expected);
	}

}
