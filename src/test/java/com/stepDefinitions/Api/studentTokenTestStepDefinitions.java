package com.stepDefinitions.Api;

import com.POJO.StudentUserPayLoad;
import com.utils.ConfigurationReader;
import com.utils.JavaFakerUtil;
import com.utils.LibraryUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.* ;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.is;

public class studentTokenTestStepDefinitions {


    private static String librarianToken;
    private static Response studentResponse;
    private static Response decodeResponse;
    private static StudentUserPayLoad studentUserPayLoad;



    @Given("basePath add_user")
    public void base_path_add_user() {
        librarianToken = LibraryUtils.getTokenBy_Env(ConfigurationReader.getProperty("qa2"),
                "Librarian2UserName",
                "Librarian2Password");
    }

    @When("create a new student")
    public void create_a_new_student() {

        studentUserPayLoad =JavaFakerUtil.createRandomStudentPOJO();

        studentUserPayLoad.setId(given().
                contentType(ContentType.JSON).
                body(studentUserPayLoad).
                header("x-library-token", librarianToken).log().all().
                when().
                post("add_user").
                then().
                log().all().extract().jsonPath().prettyPeek().getString("user_id"));

    }
    @When("get the token for the student")
    public void get_the_token_for_the_student() {


        studentResponse = given().
                formParam("email", studentUserPayLoad.getEmail()).
                formParam("password", studentUserPayLoad.getPassword()).
                contentType(ContentType.URLENC).
                when().
                post("login").prettyPeek();

        studentUserPayLoad.setToken( studentResponse.body().jsonPath().getString("token"));



    }
    @Then("response payload should contain {string} and {string} with strings values")
    public void response_payload_should_contain_and_with_strings_values(String token, String redirect_uri) {


        Map<String, String> result = studentResponse.jsonPath().getMap("");

        assertThat(result, hasKey("token"));
        assertThat(result, hasKey("redirect_uri"));

    }


    @Given("basePath decode")
    public void base_path_decode() {

        basePath = "decode";
    }

    @When("user convert the JWT token to object data")
    public void user_convert_the_jwt_token_to_object_data() {

        decodeResponse = given().
                accept("application/json").
                contentType(ContentType.URLENC).
                formParam("token",studentUserPayLoad.getToken()).

                // header("x-library-token",librarianToken).
                        log().all().
                        when().
                        post().prettyPeek();

    }
    @Then("response payload should have correct values")
    public void response_payload_should_have_correct_values() {

        assertThat(decodeResponse.body().jsonPath().getString("id"), is (studentUserPayLoad.getId()));
        assertThat(decodeResponse.body().jsonPath().getString("full_name"), is (studentUserPayLoad.getFull_name()));
        assertThat(decodeResponse.body().jsonPath().getString("email"), is (studentUserPayLoad.getEmail()));
        assertThat(decodeResponse.body().jsonPath().getString("user_group_id"), is (studentUserPayLoad.getUser_group_id()));
        assertThat(decodeResponse.body().jsonPath().getString("token"), is (studentUserPayLoad.getToken()));

    }



}
