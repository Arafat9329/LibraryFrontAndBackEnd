package com.stepDefinitions;

import com.pages.BooksPage;
import com.pages.LoginPage;
import com.utils.BrowserUtilities;
import com.utils.ConfigurationReader;
import com.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SortByHeader_BooksPage_StepDefinition {

    BooksPage booksPage = new BooksPage();


    @When("I click {string}")
    public void i_click(String string) {
        booksPage.clickOnHeaderElement(string);

     }

    @Then("{string} column should be sort it")
    public void column_should_be_sort_it(String string) {
        String actualSortOrder = booksPage.currentSortedOrderOfHeaderElement(string);
        String expectedOrder = "ascending";
        Assert.assertEquals(expectedOrder,actualSortOrder);

    }



}
