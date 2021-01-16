package com.stepDefinitions;

import com.utils.ConfigurationReader;
import com.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.* ;
import static org.hamcrest.Matchers.* ;

import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before(value = "@api")
    public void setUpAPI() {
        System.out.println("@BeforeAPI");
        baseURI= ConfigurationReader.getProperty("qa2");
//        baseURI= "http://library2.cybertekschool.com";
//        basePath="/rest/v1";
    }

    @After(value = "@api")
    public void tearDownAPI(){
        reset();
    }

    @Before(value = "@ui")
    public void setup(Scenario scenario) {
        System.out.println(":::(*_*) Starting Automation (*_*) :::");
        System.out.println("scenario.getName() = " + scenario.getName());
        System.out.println("scenario.getSourceTagNames() = " + scenario.getSourceTagNames());
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After(value = "@ui")
    public void tearDown(Scenario scenario ) {
        System.out.println("scenario.isFailed() = " + scenario.isFailed());

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        Driver.closeDriver();
        System.out.println(":::(^_^) End of test execution (^_^):::");
    }

}
