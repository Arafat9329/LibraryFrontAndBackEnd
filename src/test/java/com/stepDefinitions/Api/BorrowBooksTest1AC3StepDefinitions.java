package com.stepDefinitions.Api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BorrowBooksTest1AC3StepDefinitions {


    @Given("Get all books for borrowing using {string}")
    public void get_all_books_for_borrowing_using(String string) {

    }

    @When("Select any book_id of any book from the response where value of disabled is equal to {int}")
    public void select_any_book_id_of_any_book_from_the_response_where_value_of_disabled_is_equal_to(Integer int1, io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }

    @Then("Save the book name")
    public void save_the_book_name() {

    }

    @Then("Borrow the book using that book and the student created above using {string}")
    public void borrow_the_book_using_that_book_and_the_student_created_above_using(String string) {

    }

    @Then("Verify response contains  {string}: {string},")
    public void verify_response_contains(String string1, String string2) {

    }

    @Then("Verify response contains book_borrow_id with valid numeric string")
    public void verify_response_contains_book_borrow_id_with_valid_numeric_string() {

    }
}
