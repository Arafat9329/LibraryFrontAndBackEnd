package com.stepDefinitions.Api;

import com.utils.ConfigurationReader;
import com.utils.LibraryUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import org.slf4j.Logger;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

public class BooksCategoryAPI_StepDefinitions {


    public String librarianToken;
    Response response;



    @Given("librarian sends a GET request to end point {string}")
    public void librarian_sends_a_get_request_to_end_point(String getCategories) {
        librarianToken = LibraryUtils.getTokenDefault_Env();
        //givenRequestSpecs =
         response = given()
                        .header("x-library-token", librarianToken).
                    when()
                        .get(getCategories).prettyPeek();


    }

    @Then("verify status code {int}")
    public void verify_status_code(Integer expectedStatusCode) {
        response.then().statusCode(is(expectedStatusCode));
    }

    @Then("verify content type json")
    public void verify_content_type_json() {
       response.then().contentType(ContentType.JSON);
    }

    @Then("verify each object in the response array contains id and name")
    public void verify_each_object_in_the_response_array_contains_id_and_name() {
        JsonPath jsonData = response.jsonPath();
        List<Map<String, String>> list = jsonData.getList("");

        System.out.println(list.get(0));

        for(Map<String, String> eachMap : list){
            for (Map.Entry<String, String> s: eachMap.entrySet()) {
                    Assert.assertTrue(s.getValue()!=null && !s.getValue().equals(""));
            }
        }

    }

    @Then("verify ids are numeric strings")
    public void verify_ids_are_numeric_strings() {
        JsonPath jsonData = response.jsonPath();
        try {
            List<Integer> ids = jsonData.getList("id", Integer.class);
        }catch (RuntimeException e){
            Assert.fail();
        }


    }

    @Then("verify that book categories are same in database")
    public void verify_that_book_categories_are_same_in_database() {
        System.out.println("pending step");
    }








}
