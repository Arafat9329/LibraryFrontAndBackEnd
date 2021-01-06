package com.stepDefinitions;

import com.pages.BooksPage;
import io.cucumber.java.en.When;

import java.util.Map;
import java.util.Set;

public class EditBook_StepDefinitions {
    BooksPage booksPage = new BooksPage();


    @When("user search a book by {string} of it")
    public void userSearchABookByOfIt(String bookName) {
       // BrowserUtilities.wait(4);
        booksPage.searchBook(bookName);

    }


    @When("user updates the book information")
    public void user_updates_the_book_information(Map<String,String> dataTable) {
        Set<Map.Entry<String, String>> entries = dataTable.entrySet();


        for (Map.Entry<String, String> each : entries){

            System.out.println(each.getKey()+" -> "+ each.getValue());

            if (each.getKey().equals("Description")) {
                booksPage.enterDescription(each.getKey(), each.getValue());
            } else {
                booksPage.updateBookInfo(each.getKey(),each.getValue());
            }

        }


    }




    //end
}
