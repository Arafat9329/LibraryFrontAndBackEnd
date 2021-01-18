package com.stepDefinitions.Api;

import com.POJO.BookCategoryPojo;
import com.utils.DB_Utils;
import com.utils.LibraryUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BookCategoryPojo_StepDefinitions {
    public static Response response;
    public String librarianToken;
   public static JsonPath jsonPath;
   public static List<BookCategoryPojo> allCategoriesList;


    @Given("pojo librarian sends a GET request to end point {string}")
    public void pojoLibrarianSendsAGETRequestToEndPoint(String getCategories) {
        librarianToken = LibraryUtils.getTokenDefault_Env();
        //givenRequestSpecs =
        response =
                given()
                             .header("x-library-token", librarianToken)
                             .log().all().
                 when()
                             .get(getCategories).
                 then()
                            .extract().response();
    }

    @Then("pojo verify status code {int}")
    public void pojoVerifyStatusCode(int expectedStatusCode) {
      int actualStatusCode =  response.getStatusCode();
        System.out.println("Actual status code = " + response.getStatusCode());
        Assert.assertEquals("FAILED!!!--Status code did not match!!!",expectedStatusCode,actualStatusCode);
    }

    @And("pojo verify content type json")
    public void pojoVerifyContentTypeJson() {

        System.out.println("response.getContentType() = " + response.getContentType());
        String actualContentType = response.getContentType();
        String expectedContentType = "application/json; charset=utf-8";

        Assert.assertEquals("FAILED!!! ContentTypes mismatched!!!",expectedContentType,actualContentType);

    }

    @And("pojo  verify each object in the response array contains id and name")
    public void pojoVerifyEachObjectInTheResponseArrayContainsIdAndName() {


       jsonPath = response.jsonPath();

        allCategoriesList = jsonPath.getList("", BookCategoryPojo.class);

        for (BookCategoryPojo eachCategory : allCategoriesList){
            System.out.println("ID-> " +eachCategory.getId()+ " Name-> "+eachCategory.getName());

            Assert.assertFalse("ID Value is empty",eachCategory.getId().isEmpty());
            Assert.assertFalse("ID Value is empty",eachCategory.getName().isEmpty());

        }

    }

    @And("pojo verify ids are numeric strings")
    public void pojoVerifyIdsAreNumericStrings() {

        List<Integer> idList = jsonPath.getList("id",Integer.class);
        for (Integer eachId : idList){
            System.out.println("eachId = " + eachId);
        }

    }

    @And("pojo verify that book categories are same in database")
    public void pojoVerifyThatBookCategoriesAreSameInDatabase() {

        DB_Utils.createDBConnectionLibrary();
        DB_Utils.runQuery("select id, name From book_categories");
        List<Map<String, String>> allDataAsListOfMap = DB_Utils.getAllDataAsListOfMap();
        System.out.println("allDataAsListOfMap = " + allDataAsListOfMap);

        allCategoriesList = response.jsonPath().getList("",BookCategoryPojo.class);
        System.out.println("bookCategoryPojo = " + allCategoriesList);

        for (int i = 0; i < allDataAsListOfMap.size(); i++) {

            String id = allDataAsListOfMap.get(i).get("id");
            String name = allDataAsListOfMap.get(i).get("name");

            String id1 = allCategoriesList.get(i).getId();
            String name1 = allCategoriesList.get(i).getName();
            assertThat(id,is(id1));
            assertThat(name,is(name1));

        }

    }
}
