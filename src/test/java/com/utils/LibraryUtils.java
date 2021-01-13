package com.utils;


import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class LibraryUtils {


    public static String getTokenBy_Env(String environment, String email, String password){
        return   given()
                .log().all()
                .contentType(ContentType.URLENC)
                .formParam("email" , ConfigurationReader.getProperty(email))
                .formParam("password", ConfigurationReader.getProperty(password)).
        when()
                .post(environment+"/login").
        then()
                .extract()
                .jsonPath().getString("Token");
    }


    public static String getTokenDefault_Env(){
        return
                given()
                        //.log().all()
                        .contentType( ContentType.URLENC  )
                        .formParam("email", ConfigurationReader.getProperty("Librarian2Username"))
                        .formParam("password",ConfigurationReader.getProperty("Librarian2Password")).
                        when()
                        .post("/v1/login").
                        then()
                        //.log().all()
                        .assertThat()
                        .statusCode( is(200))
                        .contentType(ContentType.JSON)
                        .body("token", is( not( emptyString() ) )  )
                        .extract()
                        .jsonPath()
                        .getString("token");

    }


    public static String getStudentTokenDefault_Env(){
        return
                given()
//                        .log().all()
                        .contentType( ContentType.URLENC  )
                        .formParam("email", ConfigurationReader.getProperty("Student2Username"))
                        .formParam("password",ConfigurationReader.getProperty("Student2Password")).
                        when()
                        .post("/login").
                        then()
//                        .log().all()
                        .assertThat()
                        .statusCode( is(200))
                        .contentType(ContentType.JSON)
                        .body("token", is( not( emptyString() ) )  )
                        .extract()
                        .jsonPath()
                        .getString("token");

    }

    /**
     * min inclusive, max exclusive
     */
    public static int get_random_int(int Min, int Max) {
        return (int) (Math.random()*(Max-Min))+Min;
    }




}
