package com.stepDefinitions.Api;

import com.POJO.BookPayLoad;
import com.utils.ConfigurationReader;
import com.utils.LibraryUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UpdateBookStepDefinitions {

    private static String token;
    private static Response response;
    BookPayLoad bookPayLoad;

    @Given("as a librarian")
    public void as_a_librarian() {
       token =  LibraryUtils.getTokenBy_Env(ConfigurationReader.getProperty("qa2"),
                "Librarian2UserName",
                "Librarian2Password");

    }


//    @Test
//    public void test() {
//
////       token =   given()
////                .log().all()
////                .contentType(ContentType.URLENC)
////                .formParam("email" , ConfigurationReader.getProperty("Librarian1UserName"))
////                .formParam("password", ConfigurationReader.getProperty("Librarian1Password")).
////                        when()
////                .post("http://library1.cybertekschool.com/rest/v1/login").
////                        then().log().all()
////                .extract()
////                .jsonPath().getString("token");
//        token =  LibraryUtils.getTokenBy_Env(ConfigurationReader.getProperty("qa1"),
//                ConfigurationReader.getProperty("Librarian1UserName"),
//                ConfigurationReader.getProperty("Librarian1Password"));
//        book_id = given()
//                .header("x-library-token", token).body(payLoad)
//                .when().post("add_book").then().extract().jsonPath().getString("book_id");
//        System.out.println(book_id);

//    }

    @When("send a post request to create a new book")
    public void send_a_post_request_to_create_a_new_book(Map<String,String> payLoad) {
        System.out.println(payLoad);

        JsonPath jsonPath =
        given().contentType(ContentType.JSON)
                .header("x-library-token", token).body(payLoad).log().all()
                .when().post("add_book").jsonPath();

        String book_id = jsonPath.getString("book_id");

        bookPayLoad =
        given().
                header("x-library-token", token).
                pathParam("id", book_id).
                when().
                get("/get_book_by_id/{id}").jsonPath().getObject("",BookPayLoad.class);



         //bookPayLoad = jsonPath.getObject("",BookPayLoad.class);
       System.out.println(bookPayLoad);


    }
    @When("send a patch request to update year")
    public void send_a_patch_request_to_update_year(String year) {
        bookPayLoad.setYear(year);
        Map<String, String> dataToPatch = new HashMap<>();
        dataToPatch.put("year",bookPayLoad.getYear() );
        dataToPatch.put("id", bookPayLoad.getId());
        System.out.println("dataToPatch = " + dataToPatch);

        response = given().header("x-library-token", token).
                contentType(ContentType.JSON).
                           body(dataToPatch).log().all().
                   when().
                           patch("/update_book").prettyPeek();




    }
    @Then("status code should be {int}")
    public void status_code_should_be(Integer int1) {

        assertThat(response.statusCode(), is(int1));



    }
    @Then("json response should be")
    public void json_response_should_be(String expectedJsonResponse) {

       assertThat(response.body().jsonPath().getString("message"), is(expectedJsonResponse));




    }
    @Then("sending get request should show updated year")
    public void sending_get_request_should_show_updated_year() {
        given().header("x-library-token", token).
                pathParam("id", bookPayLoad.getId()).
                when().get("/get_book_by_id/{id}")
                .then().log().all().body("year", is(bookPayLoad.getYear()));


    }
    @Then("other fields should stay same")
    public void other_fields_should_stay_same() {

        given().header("x-library-token", token).
                pathParam("id", bookPayLoad.getId()).
                when().get("/get_book_by_id/{id}")
                .then().log().all().body("name", is(bookPayLoad.getName()))
        .body("isbn", is(bookPayLoad.getIsbn()))
        .body("author",is(bookPayLoad.getAuthor()))
        .body("book_category_id", is(bookPayLoad.getBook_category_id()))
        .body("description", is (bookPayLoad.getDescription()));



    }



}
