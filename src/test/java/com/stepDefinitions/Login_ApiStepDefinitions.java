package com.stepDefinitions;

import com.utils.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.* ;
import static org.hamcrest.Matchers.* ;

public class Login_ApiStepDefinitions {
   static Response  response;

    @Given("i login in with user name and password")
    public void i_login_in_with_user_name_and_password() {
    response = given()
                .log().all()
                .contentType(ContentType.URLENC) //contenType=text
                .formParam("email", ConfigurationReader.getProperty("Librarian2Username"))
                .formParam("password",ConfigurationReader.getProperty("Librarian2Password")).
              when()
                .post("/login");
    }

    @Then("i should get response with HTTP status code {int}")
    public void i_should_get_response_with_http_status_code(Integer int1) {
     response.
             then()
                .log().all()
                .assertThat()
                .statusCode( is(int1))//validation happen here
                .contentType(ContentType.JSON);

    }
    @Then("response should contain the API token")
    public void response_should_contain_the_api_token() {

     String token = response.path("token") ;
        Assert.assertFalse(token.isEmpty());
    }

}
