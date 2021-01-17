package com.stepDefinitions;

import com.utils.ConfigurationReader;
import com.utils.Driver;
import com.utils.LibraryUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;

public class Hooks {
    public static RequestSpecification givenSpec ;
    public static Response response;

    @Before(value = "@api")
    public void setUpAPI(Scenario scenario) {
        System.out.println(scenario.getSourceTagNames());
        System.out.println("@BeforeAPI");
        baseURI= ConfigurationReader.getProperty("qa2");
        if(scenario.getSourceTagNames().contains("@student")){
            String studentToken = LibraryUtils.getStudentTokenDefault_Env();
            givenSpec =
                    given()
                            .header("x-library-token", studentToken);
        }else {
            String librarianToken = LibraryUtils.getTokenDefault_Env();
            givenSpec =
                    given()
                            .header("x-library-token", librarianToken);
        }

    }


    @After(value = "@api")
    public void tearDownAPI(){
        reset();
    }

    @Before(value = "not @api")
    public void setup(Scenario scenario) {
        System.out.println(":::(*_*) Starting Automation (*_*) :::");
        System.out.println("scenario.getName() = " + scenario.getName());
        System.out.println("scenario.getSourceTagNames() = " + scenario.getSourceTagNames());
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After(value = "not @api")
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
