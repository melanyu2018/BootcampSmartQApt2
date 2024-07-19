package com.smartclic.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features", //path feature
        glue = "com.smartclic.steps",
        plugin = {"pretty","summary",
                "html:target/test-report.html",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml"},
        monochrome = false,
        publish = true,
        dryRun = false,
        tags = "@scenario2"
)


public class TestRunner extends AbstractTestNGCucumberTests {

}