package com.stepDefinitions.Api;

import com.POJO.BorrowingBooks;
import com.stepDefinitions.Hooks;
import com.utils.LibraryUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class BorrowBooksTest1AC3StepDefinitions {

   static JsonPath jp ;
   private BorrowingBooks randomAvailableBook;
   List<BorrowingBooks>availableForBorrow;

    @Given("Get all books for borrowing using {string}")
    public void get_all_books_for_borrowing_using(String string) {
    jp=    Hooks
                .givenSpec.
        when()
                .get(string)
//                .prettyPeek()
                .jsonPath();

    }

    @When("Select any book_id of any book from the response where value of disabled is equal to {int}")
    public void select_any_book_id_of_any_book_from_the_response_where_value_of_disabled_is_equal_to(Integer int1) {

        List<BorrowingBooks> allBooks=jp.getList("",BorrowingBooks.class);
        availableForBorrow= new ArrayList<>(allBooks);
        availableForBorrow.removeIf(eachBook -> eachBook.getDisabled()!=int1);
        //availableForBorrow.forEach(System.out::println);
    }

    @Then("Save the book name")
    public void save_the_book_name() {
     randomAvailableBook = availableForBorrow.get(LibraryUtils.get_random_int(0,availableForBorrow.size()));
    }

    @Then("Borrow the book using that book and the student created above using {string}")
    public void borrow_the_book_using_that_book_and_the_student_created_above_using(String string) {
   Hooks.response= null;
        Hooks.response=
   Hooks
             .givenSpec
             .formParam("book_id",randomAvailableBook.getId())
             .formParam("user_id",BorrowBokks_stpeDefinition.user_id).
     when()
             .post(string);
    }

    @Then("Verify response contains  {string}: {string},")
    public void verify_response_contains(String string1, String string2) {
        Hooks.response.then().body(string1,is(string2));
       Hooks.response.then().log().body();
    }

    @Then("Verify response contains book_borrow_id with valid numeric string")
    public void verify_response_contains_book_borrow_id_with_valid_numeric_string() {
       String bookId = Hooks.response.then().extract().jsonPath().getString("book_borrow_id");
       System.out.println("json = " + bookId);

       for (char eachCar:bookId.toCharArray()){
           Assert.assertTrue(Character.isDigit(eachCar));
       }
    }
}
