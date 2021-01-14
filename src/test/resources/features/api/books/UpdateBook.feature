Feature: UpdateBook

  @Dawud
  Scenario:as a librarian I should be able to update books
    Given as a librarian
    When send a post request to create a new book
    And  send a patch request to update year
    Then status code should be 200
    And json response should be {  "message": "The book has been updated."  }
    And sending get request should show updated year
    And other fields should stay same


