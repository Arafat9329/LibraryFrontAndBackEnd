package com.stepDefinitions.Ui;

import com.utils.LibraryUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetBookByID_StepDefinitions {

    private static String token;
    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;
    private static ResponseSpecBuilder resSpecBuilder;
    private static Integer bookID;

    @Given("make a request as a student_full_test")
    public void make_a_request_as_a_student_full_test() {
        String token = LibraryUtils.getStudentTokenDefault_Env();
        System.out.println("token = " + token);
        int bookID = 1;
        List<Integer> listOfBookID =
            given()
//                    .log().all()
                    .header("x-library-token", token).
            when()
                    .get("/get_book_list_for_borrowing").
            then()
//                    .log().all()
                    .contentType(ContentType.JSON)
                    .statusCode(200)
                    .extract()
                    .jsonPath().getList("id");
        System.out.println("listOfBookID = " + listOfBookID);
        System.out.println(listOfBookID.size());

        List<Integer> listOfBookID_noDup = new ArrayList<>(new HashSet<>(listOfBookID));
        System.out.println("listOfBookID_noDup = " + listOfBookID_noDup);
        System.out.println(listOfBookID_noDup.size());

//        Collections.sort(listOfBookID_noDup);
//        System.out.println("listOfBookID_noDup = " + listOfBookID_noDup);
//        System.out.println(listOfBookID_noDup.size());

        given()
//                .log().all()
                .header("x-library-token", token).
        when()
                .get("get_book_by_id/{id}",bookID).
        then()
                .log().all()
                .contentType(ContentType.JSON)
                .statusCode(is(403))
                .body("error",is("Unauthorized Access"))
                .body("details", is("/get_book_by_id/@id:[0-9]+"));
    }

    @Given("make a request as a student")
    public void make_a_request_as_a_student() {
        token = LibraryUtils.getStudentTokenDefault_Env();
        System.out.println("token = " + token);

        requestSpec =
                given()
//                    .log().all()
                    .header("x-library-token", token);

        List<Integer> listOfBookID =
                given()
                        .spec(requestSpec).
                when()
                        .get("/get_book_list_for_borrowing").
                then()
//                      .log().all()
                        .contentType(ContentType.JSON)
                        .statusCode(200)
                        .extract()
                        .jsonPath().getList("id");


        System.out.println("listOfBookID = " + listOfBookID);
        System.out.println(listOfBookID.size());

        List<Integer> listOfBookID_noDup = new ArrayList<>(new HashSet<>(listOfBookID));
        System.out.println("listOfBookID_noDup = " + listOfBookID_noDup);
        System.out.println(listOfBookID_noDup.size());

        int randomIndex = LibraryUtils.get_random_int(0,listOfBookID_noDup.size());
        System.out.println("randomIndex = " + randomIndex);

//        bookID = listOfBookID_noDup.get(0);

        bookID = Integer.parseInt(String.valueOf(listOfBookID_noDup.get(randomIndex)));
        System.out.println("bookID = " + bookID);
    }

//    @Then("verify content type json")
//    public void verify_content_type_json() {
//        resSpecBuilder = new ResponseSpecBuilder();
//        responseSpec = resSpecBuilder
//                .expectContentType(ContentType.JSON)
//                .build();
//
//
//        given()
//                .spec(requestSpec).
//        when()
//                .get("get_book_by_id/{id}",bookID).
//        then()
//                .spec(responseSpec);
//    }

//    @And("verify status code {int}")
//    public void verify_status_code(Integer int1) {
//        resSpecBuilder = new ResponseSpecBuilder();
//        responseSpec = resSpecBuilder
//                .expectStatusCode(int1)
//                .build();
//
//
//        given()
//                .spec(requestSpec).
//        when()
//                .get("get_book_by_id/{id}",bookID).
//        then()
//                .spec(responseSpec);
//    }

    @And("verify response body in get book by ID")
    public void verify_response_body_in_get_book_by_id() {
        resSpecBuilder = new ResponseSpecBuilder();
        responseSpec = resSpecBuilder
                .expectBody("error",is("Unauthorized Access"))
                .expectBody("details", is("/get_book_by_id/@id:[0-9]+"))
                .build();


        given()
                .spec(requestSpec).
        when()
                .get("get_book_by_id/{id}",bookID).
        then()
                .spec(responseSpec);
    }









}
