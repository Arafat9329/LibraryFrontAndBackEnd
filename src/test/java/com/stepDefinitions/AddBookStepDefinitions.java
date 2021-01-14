package com.stepDefinitions;

import com.pages.BooksPage;
import com.utils.BrowserUtilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class AddBookStepDefinitions {

    BooksPage booksPage = new BooksPage();

    @When("user click {string} button")
    public void user_click_button(String string) {
        booksPage.clickAddBtn(string);
        //BrowserUtilities.wait(3);

    }

    @And("user enters book information")
    public void user_enters_book_information(Map<String,String> map) {
        for(Map.Entry<String, String> entry: map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", value: " + entry.getValue());
            if (entry.getKey().equals("Description")) {
                booksPage.enterDescription(entry.getKey(), entry.getValue());
            } else {
                booksPage.enterBookInfo(entry.getKey(), entry.getValue());
            }

        }
    }

    @And("user clicks on {string} button")
    public void user_clicks_on_button(String string) {
       booksPage.clickSaveChangesBtn(string);
    }

    @Then("confirmation message appears")
    public void confirmation_message_appears() {
        booksPage.confirmationMessageIsDisplayed();

    }
}
