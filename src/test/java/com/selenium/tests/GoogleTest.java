package com.selenium.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleTest {
	
	private WebDriver driver;
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
	
	@BeforeEach
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
		driver=new ChromeDriver();
		Thread.sleep(3000);
		driver.manage().window().setSize(new Dimension(1366,768));
	}
	

	
	@Test
	public void testKittenTitle(){
		driver.get("https://www.google.com");
//		driver.findElement(By.id("readAllBtn")).click();
//		WebElement result =driver.findElement(By.id("displayDivRead"));
//		boolean contains=result.isDisplayed();
		assertTrue(driver.getTitle().equals("Google"));
	}
	
	@AfterEach
	public void close() {
		driver.quit();
	}

}
