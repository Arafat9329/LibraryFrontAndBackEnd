@api
Feature: BorrowBokks

@Nurshat
Scenario:
  Given Create a new student.
  When Save id of that student in class variable
  Then Get token for that student and save it class variable.


#  @Roman
#  Scenario:
#    Given Borrow a book with using /get_borrowed_books_by_user/{user_id}
#  # Verify response 200
#  # Verify empty array/body

  @borrowingBooksAC3@student
  Scenario: TEST TWO
    Given Get all books for borrowing using "/get_book_list_for_borrowing"
    When Select any book_id of any book from the response where value of disabled is equal to 1
    Then Save the book name
    And Borrow the book using that book and the student created above using "/book_borrow"
    Then verify status code 200
    And Verify response contains  "message": "The book has been borrowed...",
    And Verify response contains book_borrow_id with valid numeric string

#  /**
#  TEST THREE
#  Get borrowed books using /get_borrowed_books_by_user/{user_id}
#  Verify response 200
#  Verify response contains 1 object.
#  Verify book name, book id, user_id (borrower’s id)
#  Verify borrowed date contains todays date
#  Verify returned_date = ‘null’
#  Verify is_returned = 0
#
#  Get all books for borrowing using /get_book_list_for_borrowing.
#  Verify that the book object with book id used earlier has disabled = 1
#  **/
#
#  /**
#  TEST FOUR
#
#  Get id of another book available for borrowing using /get_book_list_for_borrowing.
#  Borrow the book /book_borrow
#  Get borrowed books using /get_borrowed_books_by_user/{user_id}
#  Verify that response now contains 2 objects
#  Verify values for book name, book id, user_id (borrower’s id), borrowed_date, returned_date,  is_returned fields for both objects
#  **/
#
#  /**
#  TEST FIVE
#
#  Get borrowed books using /get_borrowed_books_by_user/{user_id}
#  Get the borrow id of the first book (in response it just says id)
#  Return the book by giving the borrow_id using /return_book
#  Verify code 200
#  Verify following json response:
#  {
#  "message": "The book has been returned.."
#  }
#
#  Get borrowed books using /get_borrowed_books_by_user/{user_id}
#  Verify that response still shows 2 objects
#  Verify the book that is returned has returned_date that contains todays date
#  Verify the book that is returned has is_returned = 1
#
#  Verify the book that is NOT returned has returned_date = ‘null’
#  Verify the book that is returned has is_returned = 0
#
#  Get all books for borrowing using /get_book_list_for_borrowing.
#  Verify that returned book has is_disabled = 0
#  Verify that book path is not returned has is_disabled = 1
#  **/
#
#  /**
#
#  TEST SIX
#
#  Return the second book  using /return_book
#  Get borrowed books using /get_borrowed_books_by_user/{user_id}
#  Verify that response contains 2 object
#  Verify that both objects have returned_date that contains todays date
#  Verify that both objects have is_returned = 1
#  Get all books for borrowing using /get_book_list_for_borrowing.
#  Verify that both of the books has is_disabled = 0
#  **/