package com.qa.cuke.stepdefs;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class ShoppingPage {

	protected static String URL="http://automationpractice.com/index.php";
	@FindBy(css = "#block_top_menu > ul > li:nth-child(2) > a")
	private WebElement dressesTab;
	@FindBys(
			@FindBy(css="#center_column > ul > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.left-block > div > a.product_img_link > img")
			)
	private List<WebElement> images;
	public void goToDresses() {
		dressesTab.click();
	}
	
	public void assertAreDresses() {
		for (WebElement image:images) {
			assertTrue(image.getAttribute("title").contains("Dress"));
		}
	}
}
