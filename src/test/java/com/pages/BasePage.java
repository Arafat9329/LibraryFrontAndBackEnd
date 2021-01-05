package com.pages;

import com.utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

   public BasePage(){
       PageFactory.initElements(Driver.getDriver(),this);
    }
    protected WebDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),8);
}

