package com.qa.cuke.stepdefs;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ToursStepDef {
private static RemoteWebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();;
	}
	@After
	public void close() {
		driver.quit();
	}
	@Given("I have access to mercury tours website")
	public void i_hac_ve_access_to_mercury_tours_website() {
	    driver.get("http://demo.guru99.com/test/newtours/");
	}

	@When("I click the register button")
	public void i_click_the_register_button() {
		driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a")).click();
	}

	@And("I input my details and submit")
	public void i_input_my_details_and_submit() {
	    driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/input"))
	    .sendKeys("Gie\tFortuna\t01111111111\tgf@qa.com\tSome Adress\tSome City\tSome State\tP0STC0D3\tPHIL\tgfqatrainee\tpassword123\tpassword123\t\n");
	}
	@When("I go to the sign in page")
	public void i_go_to_the_sign_in_page() {
		driver.get("http://demo.guru99.com/test/newtours/");
	}

	@And("I use the same details to sign in")
	public void i_use_the_same_details_to_sign_in() {
	   driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input"))
	   .sendKeys("gfqatrainee\tpassword123\t\n");
	}

	@Then("I should see a successful login message")
	public void i_should_see_a_successful_login_message() {
		WebElement result=driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3"));
	    assertTrue(result.getText().contains("Login Successfully"));
	}

}
