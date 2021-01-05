package com.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class VerifyNumberOfRecordsStepDefinition {


    @Given("I am at the Books Management page")
    public void i_am_at_the_books_management_page() {

    }



    @Given("user select view {int} records per page")
    public void user_select_view_records_per_page(Integer int1) {

    }
    @Then("only {int} records are displayed on page")
    public void only_records_are_displayed_on_page(Integer int1, io.cucumber.datatable.DataTable dataTable) {

    }



}
