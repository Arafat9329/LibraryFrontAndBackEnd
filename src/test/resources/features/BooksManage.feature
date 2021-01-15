@ui
Feature:  As an authorized user, I should able to access Books  page and and manage books information

  Background:
    Given I am at the Books Management page

  @select_one_category @AC1@Rene
  Scenario Outline: AC1 Select one of book category
    Then user select "<Categories>" from Book Category
    And The table should display only "<Categories>" books
    Examples:
      | Categories              |
#      | ALL                     |error
#      | Action and Adventure    |error
      | Anthology               |
      | Classic                 |
      | Comic and Graphic Novel |
      | Crime and Detective     |
      | Drama                   |
      | Fable                   |
      | Fairy Tale              |
      | Fan-Fiction             |
      | Fantasy                 |
      | Historical Fiction      |
      | Horror                  |
      | Science Fiction         |
      | Biography/Autobiography |
      | Humor                   |
      | Romance                 |
      | Short Story             |
      | Essay                   |
      | Memoir                  |
      | Poetry                  |

  @login @AC2 @Dawut
  Scenario Outline:AC2 Login as a librarian and verify the records are showing correctly with different set up
    And  user select view "<n_number>" of records per page
    Then only "<n_number>" of records are displayed on page
    Examples:
      |n_number|
      | 5   |
      | 10  |
      | 15  |
      | 50  |
      | 100 |
      | 200 |
      | 500 |

  @addBook @AC3 @Elvira
  Scenario: AC3: User should able to Add Book
    When user click "Add Book" button
    And user enters book information
      | Book Name   | The Moon and Sixpence |
      | ISBN        | 1234567890            |
      | Year        | 2001                  |
      | Author      | Somerset Maugham      |
      | Description | test                  |
    And user clicks on "Save changes" button
    Then confirmation message appears

#  @AC5@Gulhanim
#  Scenario: User should be change number of displayed records on the page
#    When user select  page number
#    Then should display only selected number of pages

  @AC6 @Bekir
  Scenario Outline: AC6: User should be able to Edit book
    When user search a book by "<name>" of it
    When user click "Edit Book" button
    And user updates the book information
      #| Book Name | The Moon and Sixpence |
      | ISBN        | 1234567898                     |
      | Year        | 1999                           |
      | Author      | Somerset Maugham               |
      | Description | This book is currently missing |
    And user clicks on "Save changes" button
    Then confirmation message appears
    Examples:
      | name                  |
      | The Moon and Sixpence |

#  @Search @AC6 @Roman
#  Scenario: AC6 User should able to sort records on Books page
#    When I click "ISBN"
#    Then "ISBN" column should be sort it