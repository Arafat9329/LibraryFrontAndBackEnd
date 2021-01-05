package com.pages;

import com.utils.BrowserUtilities;
import com.utils.Driver;
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


    /**
     * not used , look for =findHeaderElement(String string) method instead
     */
    @FindBy(xpath = "//th[contains(@aria-label,'ISBN')]")
    public WebElement headerElement_ISBN;

    /**
     * use this method to find elements in the header on Books page
     * @param string ISBN, Name, Author, Category, Year, Borrowed By
     * @return webelement
     */
    public WebElement findHeaderElement(String string){
        String headerElementXpath = "//th[contains(@aria-label, '"+string+"')]";
        WebElement webElement  = Driver.getDriver().findElement(By.xpath(headerElementXpath));
        return webElement;
    }


    /**
     * @param string ISBM, Name, Author, Category, Year, Borrowed By
     */
    public void clickOnHeaderElement(String string){
        String headerElementXpath = "//th[contains(@aria-label, '"+ string + "')]";
        WebElement element =Driver.getDriver().findElement(By.xpath(headerElementXpath));
        BrowserUtilities.waitClickOnElement(element);
    }

    /**
     * checking sorted order by property "aria-lable" of param at current request
     * @param string ISBM, Name, Author, Category..
     * @return string (ascending or descending)
     */

    public String currentSortedOrderOfHeaderElement(String string) {
        String currentSortOrder = "";
        BrowserUtilities.waitVisibilityOfElement(findHeaderElement(string));
        String strFromAttribute = findHeaderElement(string).getAttribute("aria-label");
        if (strFromAttribute.contains("ascending")) {
            return currentSortOrder = "descending";
        } else {
            return currentSortOrder = "ascending";
        }
    }










}
