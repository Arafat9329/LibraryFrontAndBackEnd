package com.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "rerun:target/rerun.txt",
                "json:target/cucumberAPi_BorrowingBookRunner.json"
        },
        features = "src/test/resources/features",
        glue = "com/stepDefinitions",
        dryRun = false,
        tags = "@Nurbiye"


)

public class ApiRunner {
}
