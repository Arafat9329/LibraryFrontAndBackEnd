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
                        .post("http://library2.cybertekschool.com/rest/v1/login").
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






}
