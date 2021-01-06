package com.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/stepDefinitions",
        dryRun = false,
        tags = "@Dawut"
)

public class CucumberRunner {
}
