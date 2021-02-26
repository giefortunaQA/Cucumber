package com.qa.cuke;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/cuke/features",
	tags="not @ignore",
	glue="com.qa.cuke.stepdefs",
	plugin={"pretty","html:target/reports/cuke/CucumberReport.html"},
	monochrome=true,
	strict=true)
public class CukeRunner {

}
