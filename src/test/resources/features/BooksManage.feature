Feature:  As an authorized user, I should able to access Books  page and and manage books information


  Background:
    #Arpat
    Given I am at the Books Management page

  @select_one_category @AC1@Rene
  Scenario Outline: AC1 Select one of book category

    Then user select "<Categories>" from Book Category
    And The table should display only "<Category>" books
    Examples:
      | Categories              | Category                |
      | ALL                     | Action and Adventure    |
      | Action and Adventure    | Action and Adventure    |
      | Anthology               | Anthology               |
      | Classic                 | Classic                 |
      | Comic and Graphic Novel | Comic and Graphic Novel |
      | Crime and Detective     | Crime and Detective     |
      | Drama                   | Drama                   |
      | Fable                   | Fable                   |
      | Fairy Tale              | Fairy Tale              |
      | Fan-Fiction             | Fan-Fiction             |
      | Fantasy                 | Fantasy                 |
      | Historical Fiction      | Historical Fiction      |
      | Horror                  | Horror                  |
      | Science Fiction         | Science Fiction         |
      | Biography/Autobiography | Biography/Autobiography |
      | Humor                   | Humor                   |
      | Romance                 | Romance                 |
      | Short Story             | Short Story             |
      | Essay                   | Essay                   |
      | Memoir                  | Memoir                  |
      | Poetry                  | Poetry                  |


  @login @AC2 @Dawut
  Scenario:AC2 Login as a librarian and verify the records are showing correctly with different set up
    #Given user is on the login page
    #When user logs in
    #Then user should see Library
    #When user click on the Book tab

    And  user select view 5 records per page
    Then only 5 records are displayed on page
      | 5   |
      | 10  |
      | 15  |
      | 50  |
      | 100 |
      | 200 |
      | 500 |

  @AC3@Elvira
  Scenario: AC3: User should able to Add Book
    #Given I am at the Books page
    When user click "Add Book" button
    Then The "Add Book" form is displayed

  @AC5@Gulhanim
  Scenario: User should be change number of displayed records on the page
    When user select  page number
    Then should display only selected number of pages

  @AC6@Bekir
  Scenario: AC6: User should be able to Edit book
    Given I am at the Books Management page
    When user click "Edit Book" button
    Then The "Edit Book Information" form is displayed

  @AC6@Roman
  Scenario: AC4: User should able to sort records on Books page
    Given I am at the Books Management page
    When I click "ISBM"
    Then "ISBM" coulm should be sort it