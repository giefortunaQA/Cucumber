package com.selenium.tests;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ShoppingTest {
	private WebDriver driver;
	@BeforeEach
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1366,768));
	}
	

	
	@Test //testing all results have keyword Dress
	public void testDressResults() {
		driver.get("http://automationpractice.com/index.php");
		WebElement results= driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul"));
		List<WebElement> images= results.findElements(By.tagName("img"));
		for (WebElement image:images) {
			assertTrue(image.getAttribute("title").contains("Dress"));
		}
	}
	
	
	@AfterEach
	public void close() {
		driver.quit();
	}

}
