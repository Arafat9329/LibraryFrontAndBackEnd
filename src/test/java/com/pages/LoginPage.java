package com.pages;

import com.utils.BrowserUtilities;
import com.utils.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LoginPage extends BasePage {

    @FindBy(id = "inputEmail")
    private WebElement emailAddress;

    @FindBy(id= "inputPassword")
    private WebElement passWord;

    @FindBy(xpath = "//span[.='Books']")
    private WebElement menu_books;

    @FindBy(xpath = "//h3")
    private WebElement pageTitle;

    public void logIn(){
        emailAddress.sendKeys(ConfigurationReader.getProperty("librarianEmail"));
        passWord.sendKeys(ConfigurationReader.getProperty("librarianPassword"), Keys.ENTER);
    }
    public void logIn(String librarianOrStudent){
        if (librarianOrStudent.equalsIgnoreCase("student")) {
            emailAddress.sendKeys("student18@library");
            passWord.sendKeys("nK83Q8Be", Keys.ENTER);
        }else if (librarianOrStudent.equalsIgnoreCase("librarian")){
            emailAddress.sendKeys("librarian13@library");
            passWord.sendKeys("9rf6axdD", Keys.ENTER);
        }else {
            System.out.println("plz enter student or librarian");
        }
    }
    public void logIn(String userName,String password){
        emailAddress.sendKeys(userName);
        passWord.sendKeys(password, Keys.ENTER);
    }

    public void click_menu_books(){
        BrowserUtilities.waitClickOnElement(menu_books);
    }

    public String getPageTitle(){

       return wait.until(ExpectedConditions.visibilityOf(pageTitle)).getText();

    }


}
