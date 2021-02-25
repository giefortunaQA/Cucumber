package com.qa.cuke;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/com/qa/cuke/features",strict=true)
public class CukeRunner {

}
