package com.qa.cuke.stepdefs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class HLPage {
	protected static String URL="https://www.hl.co.uk/shares/stock-market-summary/ftse-100/";
	@FindBys(
			@FindBy(xpath="/html/body/main/div/div/div[3]/div[4]/div[1]/div[2]/table/tbody/tr")
			)
	private List<WebElement> list;
	
	public void verifyTop(String string) {
		WebElement first=list.get(0);
		assertEquals("ls-row-"+string+"-L",first.getAttribute("id"));
	}
}
