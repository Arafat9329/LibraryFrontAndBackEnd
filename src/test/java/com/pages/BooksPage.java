package com.pages;

import com.utils.BrowserUtilities;
import com.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BooksPage extends BasePage{

    protected String addBookBtn = "//a[contains(text(),'%s')]";
    protected String bookInfoInputBox = "//input[@placeholder='%s']";
    protected String descriptionTextArea = "//label[.='%s']/following-sibling::textarea";
    protected String saveChangesBtn = "//button[.='%s']";
    protected String bookRecordsOnCurrentPage1 = "//tbody//tr";
    protected String searchBox = "//input[@type='search']";
//    //bekir
//    protected String searchBox = "//input[@type='search']";
//    @FindBy(xpath ="//textarea[@id='description']" )
//    protected WebElement textDescription;
//    //bekir


    @FindBy(xpath = "//table[@id='tbl_books']//tbody/tr/td[5]")
    private List<WebElement> allBookCategoriesDisplayed;

    @FindBy(xpath = "//select[@name='tbl_books_length']")
    private WebElement showRecordsSelectDropdown;

    @FindBy(xpath = "//a[@title='Next']/..")
    private WebElement nextPageButton;

    @FindBy(xpath = "//select[@id='book_categories']")
    private WebElement categoryDropdownButton;

    @FindBy(xpath = "//table[@id='tbl_books']//tbody/tr/td/a")
    private List<WebElement> allBooksActionsDisplayed;

    @FindBy(xpath = "//div[@class='toast-message']")
    private WebElement confirmationMessage;

    @FindBy(xpath = "//tbody//tr")
    private List<WebElement> bookRecordsOnCurrentPage;

    public void selectCategory(String category) {

        Select select = BrowserUtilities.getSelectDropdown(categoryDropdownButton);
        select.selectByVisibleText(category);
    }

    /**
     * Clicks on the button "Next" if the button is enabled
     * @returns boolean true if the button was clicked or false if the button is not enabled
     */
    public boolean clickNextPageButton(){
        String value = wait.until(ExpectedConditions.visibilityOf(nextPageButton)).getAttribute("class");
        if (value.equals("page-item next")) {
            nextPageButton.click();
            return true;
        }
        return false;
    }

    /**
     * Selects the number of books that we want to display per page
     * @param optionValue is an Integer that represent the value of the number of books we
     * want to display. Inside the method, I used the String value of that Integer to choose from the
     * menu
     */
    public void selectNumberOfBooksToBeDisplay(Integer optionValue){
        Select select = BrowserUtilities.getSelectDropdown(showRecordsSelectDropdown);
        select.selectByVisibleText(String.valueOf(optionValue));
    }

    /**
     * Checks if all the books are from the category selected
     * @param category
     */
    public void booksDisplayCategoryIsCorrect(String category){
        if(category.equalsIgnoreCase("ALL")){
            Assert.assertTrue(true);
            return;
        }

        selectNumberOfBooksToBeDisplay(500);

        do {
            List<WebElement> categories = wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(allBookCategoriesDisplayed)));
            for (WebElement eachCategory : categories) {
                Assert.assertEquals(category, eachCategory.getText().trim());
            }
        } while (clickNextPageButton());
    }

    public void clickAddBtn(String btn){
        BrowserUtilities.waitClickOnElement(driver.findElement(By.xpath(String.format(addBookBtn, btn))));
    }

    public void enterBookInfo(String label, String text){
        driver.findElement(By.xpath(String.format(bookInfoInputBox,label))).sendKeys(text);
    }

    public void enterDescription(String label, String text){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(descriptionTextArea,label)))).clear();
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


    /**
     *  Getting number of book records showing on current page
     */

    public int getNumberOfBooksDisplayedInCurrentPage(String numberOfBooks ) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(bookRecordsOnCurrentPage1),Integer.parseInt(numberOfBooks)));
        return bookRecordsOnCurrentPage.size();

    }




    public void searchBook(String name){
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(String.format(searchBox,name)))).sendKeys(name);
        BrowserUtilities.wait(2);

    }


    public void updateBookInfo(String label, String bookInfo) {

        WebElement element =
                driver.findElement(By.xpath("//input[@placeholder='" + label + "']"));
        element.clear();
        BrowserUtilities.waitEnterTextWhenVisible(element,bookInfo);
    }






}
