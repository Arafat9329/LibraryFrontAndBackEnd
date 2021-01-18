package com.stepDefinitions.Api;

import com.POJO.BookPayLoad;
import com.utils.LibraryUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddBookStepDefinitions {
    private String token;
  private Response response;


    @Given("as a student")
    public void asAStudent() {
        token = LibraryUtils.getStudentTokenDefault_Env();
    }

    @When("send a post request and create a new book:")
    public void sendAPostRequestAndCreateANewBook(Map<String,String> payLoad) {
        System.out.println(payLoad);

        response = given().header("x-library-token",token).body(payLoad).
                      when().post("/add_book").prettyPeek();

    }

    @Then("content type is json")
    public void contentTypeIsJson() {
   response.then().contentType(ContentType.JSON);
 // assertThat(response.getContentType(),is("application/json; charset=utf-8"));

        //application/json
    }

    @And("status code is {int}")
    public void statusCodeIs(int n1) {
        assertThat(response.getStatusCode(), is(n1) ) ;

    }

    @And("verify response body:")
    public void verifyResponseBody(Map<String, String> message) {

        //System.out.println(message.get("error"));
       JsonPath jp = response.jsonPath();
       Map<String, String> map = jp.getMap("");
        System.out.println(map);
        assertThat(map, is(message));

        /*   "error": "Unauthorized Access",
             "details": "/add_book"*/


    }



}
