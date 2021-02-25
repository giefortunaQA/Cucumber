package com.selenium.tests;
//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SeleniumEasyTests {
	private static RemoteWebDriver driver;
	private static String URL = "https://www.seleniumeasy.com/test/dynamic-data-loading-demo.html";
	private static WebElement targ;
	private static ExtentReports report;
	private static ExtentTest test;

	@BeforeAll
	public static void setUp() {
		report = new ExtentReports(
				"C:\\Users\\Gie\\Downloads\\STS\\Workspace\\Selenium\\target\\reports\\extentreports\\waitReport.html",
				true); // true tells to replace the file everytime
	}

	@BeforeEach
	public  void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1366, 768));
	}

	@Test // testing all results have keyword Dress
	public void searchUsersTest() throws Exception {
		test=report.startTest("Search for user test");
		// GIVEN
		test.log(LogStatus.INFO, "Given - we can access selieniumeasy.com");
		driver.get(URL);

		// WHEN
		test.log(LogStatus.INFO, "When we click the search button");
		targ = driver.findElement(By.id("save"));
		targ.click();

		// WAIT
		new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"loading\"]/br[1]")));
		
		targ = driver.findElement(By.id("loading"));

		// THEN
		test.log(LogStatus.INFO, "Then - I should see a random user result");
		String result = targ.getText();
		boolean contains = result.contains("First Name :") && result.contains("Last Name :");
		if (contains) {
			test.log(LogStatus.PASS, "Found first and last name");
		}else {
			test.log(LogStatus.FAIL, "Found: "+ result);
		}
		
		if (result.equals("loading...")) {
			test.log(LogStatus.FAIL, "Element not populated");
		}else {
			test.log(LogStatus.PASS, "Details loaded");
		}
		assertNotEquals("loading...", result);
		assertTrue(contains);
	}

	@AfterEach
	public void close() {
		report.endTest(test);
	}
	
	@AfterAll
	public static void afterAll() {
		driver.quit();
		report.flush();
		report.close();
	}

}
