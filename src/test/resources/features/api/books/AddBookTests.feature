Feature:AddBook

  @Nurbiye
  Scenario:student can't add books.
    Given send a request as a student to create a new book.
    Then verify content type json
    And verify status code 403
    And verify reponse body:
      | error   | Unauthorized Access  |
      | details | details: "/add_book" |


  @Dilayr
  Scenario:librarian can add books.
    Given send a request as a librarian to create a new book
    Then verify status code 201
    And verify content type json
    And verify response contain "message": "The book has been created."
    And verify response contains book_id.
    And Book_id must a numeric string

@Elv
  Scenario:
    Given send a request as a librarian to create a new book
    Then verify status code 200
    And extract the book_id
    And get the information using the get_book_by_id endpoint.
    And verify that book information is correct in the response payload
    And verify that book information is correct in database