package com.stepDefinitions.Api;

import com.utils.ConfigurationReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.reset;

public class Hooks {

    @Before()
    public void setUpAPI() {
        System.out.println("Setting api");
        baseURI= ConfigurationReader.getProperty("qa2");
//        baseURI= "http://library2.cybertekschool.com";
//        basePath="/rest/v1";
    }
    @After()
    public void tearDownAPI(){
        reset();
    }
}
