@api
Feature:AddBook

  @Nurbiye
  Scenario:student can not add books.
    Given as a student
    #send a request as a student to create a new book.
    When send a post request and create a new book:
      | name             | Moon       |
      | isbn             | 23904      |
      | year             | 2020       |
      | author           | Nur        |
      | book_category_id | 32         |
      | description      | nonfiction |
     Then content type is json
     And  status code is 403
     And  verify response body:
         | error   |  Unauthorized Access  |
         | details |  /add_book |



  @Dilyar
  Scenario:librarian can add books.
    Given send a request as a "librarian" to create a new book
#    Then verify status code 201
#    And verify content type json
    And verify response contain "message": "The book has been created."
    And verify response contains book_id
    And Book_id must a numeric string



#@Elv
#  Scenario:
#    Given send a request as a librarian to create a new book
#    Then verify status code 200
#    And extract the book_id
#    And get the information using the get_book_by_id endpoint.
#    And verify that book information is correct in the response payload
#    And verify that book information is correct in database