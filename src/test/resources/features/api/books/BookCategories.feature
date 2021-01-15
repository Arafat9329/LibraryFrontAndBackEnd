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

#@Bekir
#Scenario:
#  Given category types
# # repeat the same test but do it utilizing category pojo
