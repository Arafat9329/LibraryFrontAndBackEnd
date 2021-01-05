package com.pages;

import com.utils.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BooksPage extends BasePage{
    protected String addBookBtn = "//a[contains(text(),'%s')]";
    protected String bookInfoInputBox = "//input[@placeholder='%s']";
    protected String descriptionTextArea = "//label[.='%s']/following-sibling::textarea";
    protected String saveChangesBtn = "//button[.='%s']";

    @FindBy(xpath = "//div[@class='toast-message']")
    private WebElement confirmationMessage;

    public void clickAddBtn(String btn){
        BrowserUtilities.waitClickOnElement(driver.findElement(By.xpath(String.format(addBookBtn, btn))));
    }

    public void enterBookInfo(String label, String text){
        driver.findElement(By.xpath(String.format(bookInfoInputBox,label))).sendKeys(text);
    }

    public void enterDescription(String label, String text){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(descriptionTextArea,label)))).sendKeys(text);
    }

    public void clickSaveChangesBtn(String label){
        BrowserUtilities.waitClickOnElement(driver.findElement(By.xpath(String.format(saveChangesBtn,label))));

    }

    public boolean confirmationMessageIsDisplayed(){
        BrowserUtilities.wait(2);
        return confirmationMessage.isDisplayed();
    }


}
