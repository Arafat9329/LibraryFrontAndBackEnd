@api
Feature: Book Categories

  #dont use POJO
  @RG @librarian
  Scenario: Test GET request to end point "/get_book_categories"
    Given librarian sends a GET request to end point "/get_book_categories"
    Then verify status code 200
    And verify content type json
    And verify each object in the response array contains id and name
    And verify ids are numeric strings
    And verify that book categories are same in database

@Bekir @api @pojo
 # repeat the same test but do it utilizing category pojo
  Scenario: pojo Test GET request to end point "/get_book_categories"
    Given pojo librarian sends a GET request to end point "/get_book_categories"
    Then pojo verify status code 200
    And pojo verify content type json
    And pojo  verify each object in the response array contains id and name
    And pojo verify ids are numeric strings
    And pojo verify that book categories are same in database
