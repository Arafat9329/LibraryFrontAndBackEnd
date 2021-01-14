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
        features = "src/test/resources/features/api/books",
        glue = "com/stepDefinitions/Api",
        dryRun = false,
        tags = "@Dawud and @api"

)

public class Api_BooksRunner {
}
