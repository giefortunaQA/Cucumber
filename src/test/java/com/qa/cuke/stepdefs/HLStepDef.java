package com.qa.cuke.stepdefs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HLStepDef {
	private static RemoteWebDriver driver;
	private static JavascriptExecutor js=(JavascriptExecutor) driver;
	
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
	@Given("I have access to Hargreaves Lansdown website")
	public void i_have_access_to_Hargreaves_Lansdown_website() {
		driver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100/risers");
	}

	@When("I click the risers tab")
	public void i_click_the_risers_tab() {
		driver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100/risers");
	}

	@Then("I should see the highest riser is IAG")
	public void i_should_see_the_highest_riser_is_IAG() {
		List<WebElement> risers= driver.findElements(By.xpath("/html/body/main/div/div/div[3]/div[4]/div[1]/div[2]/table/tbody/tr"));
		WebElement first=risers.get(0);
		assertEquals("ls-row-BP.-L",first.getAttribute("id"));
	}

}
