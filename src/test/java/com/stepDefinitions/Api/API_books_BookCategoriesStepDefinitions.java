package com.stepDefinitions.Api;

import com.utils.LibraryUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class API_books_BookCategoriesStepDefinitions {

    public String librarianToken;
    Response response;

    @Given("make a request as a librarian, use a valid id {int}")
    public void librarian_can_get_book_by_id(int bookID) {

        librarianToken = LibraryUtils.getTokenDefault_Env();
    response =    given()
                .header("x-library-token", librarianToken).
        when()
                .get("/get_book_by_id/{bookID}",bookID);
    }

    @Then("arp.verify status code {int}")
    public void verify_status_code(Integer expectedStatusCode) {
        response.then().statusCode(is(expectedStatusCode));
    }

    @Then("arp.verify content type json")
    public void verify_content_type_json2() {

        response.then().contentType(ContentType.JSON);
    }

    @Then("based on the sample below, verify that response contains all following field with with values not empty or null")
    public void based_on_the_sample_below_verify_that_response_contains_all_following_field_with_with_values_not_empty_or_null(Map<String,String> dataTable) {
//        System.out.println(dataTable.toString());
//        for (String each:dataTable.keySet()) {
//            System.out.println("each = " + each);
//            System.out.println("value = "+dataTable.get(each));
//        }


        for (String each:dataTable.keySet()) {
            response.then().body(each,is(dataTable.get(each)));
        }


    }

}
