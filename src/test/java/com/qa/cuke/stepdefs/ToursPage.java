package com.qa.cuke.stepdefs;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.cucumber.datatable.DataTable;

public class ToursPage {

	protected static String URL="http://demo.guru99.com/test/newtours/";
	@FindBy(xpath="/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a")
	private WebElement registerTab;
	@FindBy(css="body > div:nth-child(5) > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(2) > td:nth-child(2) > input")
	private WebElement entryForm;
	@FindBy(xpath="/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[17]/td/input")
	private WebElement registerBtn;
	@FindBy(xpath="/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a")
	private WebElement loginTab;
	@FindBy(name="userName")
	private WebElement loginForm;
	@FindBy(xpath="/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3")
	private WebElement result;
	public void goToRegister() {
		registerTab.click();
	}
	
	public void goToLogin() {
		loginTab.click();
		
	}
	
	
	public void register(WebDriver driver,DataTable dataTable) {
		List<String> data=dataTable.column(1);
		String allData="";
		for (int i=0;i<data.size();i++) {
			allData+=data.get(i);
			allData+=Keys.TAB;
		}
		allData+=data.get(data.size()-1);
		allData+=Keys.TAB;
		allData+=Keys.ENTER;
		entryForm.sendKeys(allData);
	}
	
	public void login(String uname,String pword) {
		loginForm.sendKeys(uname+Keys.TAB+pword+Keys.ENTER);
	}
	
	public void verifyResult() {
		assertTrue(result.getText().contains("Login Successfully"));
	}
	
}
