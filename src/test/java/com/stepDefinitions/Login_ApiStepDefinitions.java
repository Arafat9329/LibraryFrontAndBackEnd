package com.stepDefinitions;

import com.utils.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.* ;
import static org.hamcrest.Matchers.* ;

public class Login_ApiStepDefinitions {

    @Given("i login in with user name and password")
    public void i_login_in_with_user_name_and_password() {
        given()
                .log().all()
                .contentType(ContentType.URLENC) //contenType=text
                .formParam("email", ConfigurationReader.getProperty("Librarian2Username"))
                .formParam("password",ConfigurationReader.getProperty("Librarian2Password"));
    }

    @When("i request POST request")
    public void i_request_post_request() {
        when()
                .post("/login");
    }
    @Then("i should get response with HTTP status code {int}")
    public void i_should_get_response_with_http_status_code(Integer int1) {
//        then()
//                .log().all()
//                .assertThat()
//                .statusCode( is(200))
//                .contentType(ContentType.JSON);

    }
    @Then("response should contain the API token")
    public void response_should_contain_the_api_token() {

    }

}
