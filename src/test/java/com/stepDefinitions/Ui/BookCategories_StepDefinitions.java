package com.stepDefinitions.Ui;

import com.pages.BooksPage;
import io.cucumber.java.en.*;

public class BookCategories_StepDefinitions {

    private BooksPage booksPage = new BooksPage();

    @Then("user select {string} from Book Category")
    public void user_select_from_book_category(String category) {
        booksPage.selectCategory(category);
    }

    @Then("The table should display only {string} books")
    public void the_table_should_display_only_books(String category) {
        booksPage.booksDisplayCategoryIsCorrect(category);

    }

}
