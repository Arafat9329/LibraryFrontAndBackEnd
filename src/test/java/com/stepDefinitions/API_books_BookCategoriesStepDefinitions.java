package com.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class API_books_BookCategoriesStepDefinitions {

    @Given("librarian can get book by id {int}.")
    public void librarian_can_get_book_by_id() {

    }


    @When("make a request as a student, use a valid id \\(to make sure that you always use valid id, you may have to create  new book)")
    public void make_a_request_as_a_student_use_a_valid_id_to_make_sure_that_you_always_use_valid_id_you_may_have_to_create_new_book() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("verify content type json")
    public void verify_content_type_json() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("verify status code {int}")
    public void verify_status_code(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("based on the sample below, verify that response contains all following field with with values not empty or null")
    public void based_on_the_sample_below_verify_that_response_contains_all_following_field_with_with_values_not_empty_or_null(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }

}
