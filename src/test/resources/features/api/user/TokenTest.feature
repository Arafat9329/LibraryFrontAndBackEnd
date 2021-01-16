@api
Feature: student token test

  @dawud
  Scenario: student token should work properly
    Given basePath add_user
    When create a new student
    And get the token for the student
    Then response payload should contain "token" and "redirect_uri" with strings values

  @dawud
  Scenario: verify Convert JWT token to object data working properly
    Given basePath decode
    When user convert the JWT token to object data
    Then response payload should have correct values