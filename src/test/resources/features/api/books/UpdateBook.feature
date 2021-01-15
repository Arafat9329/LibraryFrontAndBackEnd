@api
Feature: UpdateBook

  @Dawud
  Scenario:as a librarian I should be able to update books
    Given as a librarian
    When send a post request to create a new book
      | name             | IntelliJ     |
      | isbn             | 2222         |
      | year             | 4444         |
      | author           | dawud        |
      | book_category_id | 1            |
      | description      | this is test |

    And  send a patch request to update year
      | 5555 |
    Then status code should be 200
    And json response should be
      | The book has been updated. |
    And sending get request should show updated year
    And other fields should stay same


