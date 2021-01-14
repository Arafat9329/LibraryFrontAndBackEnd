package com.stepDefinitions.Api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.File;

import static com.utils.LibraryUtils.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class BooksEndPointsStepDefinition {

    public String token;
    public JsonPath jp;

    @Given("send a request as a {string} to create a new book")
    public void sendARequestAsAToCreateANewBook(String role) {

        token = getTokenDefault_Env();

        File file = new File("book.json");
        jp =
                            given()
                                    .contentType(ContentType.JSON)
                                    .header("x-library-token",token)
                                    .body(file).
                            when()
                                    .post("http://library2.cybertekschool.com/rest/v1/add_book")
                                    .prettyPeek().
                            then()
                                    .statusCode(200)
                                    .contentType(ContentType.JSON)
                                    .extract().response().jsonPath();
    }

    @And("verify response contain {string}: {string}")
    public void verifyResponseContain(String key, String value) {
        assertThat(jp.getString(key),is("The book has been created."));
    }

    @And("verify response contains book_id")
    public void verifyResponseContainsBook_id() {
        assertThat(jp.getString("book_id"),is(notNullValue()));
    }

    @And("Book_id must a numeric string")
    public void book_idMustANumericString() {

        String bookId = jp.getString("book_id");

        boolean notNum = false;
        for (char each: bookId.toCharArray()){
            if (!Character.isDigit(each)){
                notNum = true;
                break;
            }
        }

        assertThat(notNum,is(false));
    }
}
