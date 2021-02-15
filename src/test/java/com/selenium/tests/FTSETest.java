package com.selenium.tests;

import static org.junit.Assert.assertEquals;

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

public class FTSETest {
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
	public void testRiser() {
		driver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100/risers");
		List<WebElement> risers= driver.findElements(By.xpath("/html/body/main/div/div/div[3]/div[4]/div[1]/div[2]/table/tbody/tr"));

		WebElement first=risers.get(0);
		assertEquals("ls-row-WTB-L",first.getAttribute("id"));
	}
	
	
	@Test
	public void testFaller() {
		driver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100/fallers");
		List<WebElement> fallers= driver.findElements(By.xpath("/html/body/main/div/div/div[3]/div[4]/div[1]/div[2]/table/tbody/tr"));
		WebElement first=fallers.get(0);
		assertEquals("ls-row-JET-L",first.getAttribute("id"));
	}
	
	@After
	public void close() {
		driver.quit();
	}

}
