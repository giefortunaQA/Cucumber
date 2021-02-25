package com.qa.cuke.stepdefs;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePage {
	protected String URL = "https://www.google.com";

	@FindBy(name="q")
	private WebElement searchBar;
	@FindBy(xpath = "//*[@id=\"hdtb-msb\"]/div[1]/div/div[2]/a")
	private WebElement imagesTab;
	@FindBy(xpath="//*[@id=\"islrg\"]/div[1]/div[1]/a[2]")
	private WebElement firstResult;

	public void searchFor(String string) {
		this.searchBar.sendKeys(string + "\n");
	}
	public void clickImages() {
		this.imagesTab.click();
	}

	public void verifyResultContains(String string) {
		assertTrue(firstResult.getAttribute("title").toLowerCase().contains(string));
	}
}
