package com.selenium.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebElement;


public class ShoppingTest {
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
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
		driver=new ChromeDriver(chromeCfg());
		driver.manage().window().setSize(new Dimension(1366,768));
	}
	

	
	@Test
	public void testDressResults() {
		driver.get("http://automationpractice.com/index.php");
		WebElement results= driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul"));
		List<WebElement> images= results.findElements(By.tagName("img"));
		for (WebElement image:images) {
			assertTrue(image.getAttribute("title").contains("Dress"));
		}
		
	}
	
	@After
	public void close() {
		driver.quit();
	}

}
