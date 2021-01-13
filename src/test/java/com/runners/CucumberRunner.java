package com.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "rerun:target/rerun.txt",
                "json:target/cucumber.json"
        }
        ,features = "src/test/resources/features"
        ,glue = "com/stepDefinitions"
       // ,dryRun = true
        ,tags = "@RG and @api"

)

public class CucumberRunner {
}
