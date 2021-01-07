package com.stepDefinitions;

import com.pages.BooksPage;
import com.pages.LoginPage;
import com.utils.BrowserUtilities;
import com.utils.ConfigurationReader;
import com.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class VerifyNumberOfRecordsStepDefinition {
    LoginPage loginPage = new LoginPage();
    BooksPage booksPage = new BooksPage();

    @Given("I am at the Books Management page")
    public void i_am_at_the_books_management_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("libraryUrl"));

        loginPage.logIn("librarian");

        loginPage.click_menu_books();

        Assert.assertEquals(loginPage.getPageTitle(),"Book Management");

    }



    @Given("user select view {string} of records per page")
    public void user_select_view_of_records_per_page(String numberOfBooks) {
        booksPage.selectNumberOfBooksToBeDisplay(Integer.parseInt(numberOfBooks));



    }


    @Then("only {string} of records are displayed on page")
    public void only_of_records_are_displayed_on_page(String numberOfBooks) {


        int actualNumberOfBookRecords = booksPage.getNumberOfBooksDisplayedInCurrentPage(numberOfBooks);
        int expectedNumberOfBooksRecords = Integer.valueOf(numberOfBooks);

        Assert.assertEquals("Expected number of books doesn't match with actual books displayed on current page!!!",expectedNumberOfBooksRecords,actualNumberOfBookRecords);



    }






}
