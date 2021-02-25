package com.qa.cuke.stepdefs;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleStepDef {
	private static RemoteWebDriver driver;
	public static ChromeOptions chromeCfg() {
		Map<String, Object> prefs = new HashMap<String, Object>();
		ChromeOptions cOptions = new ChromeOptions();

		// Settings
		prefs.put("profile.default_content_setting_values.cookies", 2);
		prefs.put("network.cookie.cookieBehavior", 2);
		prefs.put("profile.block_third_party_cookies", true);

		// Create ChromeOptions to disable Cookies pop-up
		cOptions.setExperimentalOption("prefs", prefs);

		return cOptions;
	}
	
	@Before
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
		driver=new ChromeDriver(chromeCfg());
		driver.manage().window().setSize(new Dimension(1366,768));
	}
	
	@Given("I can access google.com")
	public void i_can_access_google_com() {
		driver.get("https://www.google.com");
	}

	@When("I search for kittens")
	public void i_search_for_kittens() {
	    driver.findElement(By.name("q")).sendKeys("kittens\n");
	}

	@And("I select images tab")
	public void i_select_images_tab() {
	    driver.findElement(By.xpath("//*[@id=\"hdtb-msb\"]/div[1]/div/div[2]/a")).click();
	}

	@Then("I should see images of kittens")
	public void i_should_see_images_of_kittens() {
	    WebElement img=driver.findElement(By.cssSelector("#islrg > div.islrc > div:nth-child(1) > a.wXeWr.islib.nfEiy.mM5pbd > div.bRMDJf.islir > img"));
	    List<String> keyWords= new ArrayList<String>(Arrays.asList("Kitten","kitten","kittens","Kittens"));
	 assertTrue(img.isDisplayed());
	}
	
	@After
	public void after() {
	driver.quit();}
}
