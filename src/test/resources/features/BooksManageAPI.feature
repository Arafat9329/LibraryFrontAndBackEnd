Feature:Books page functionality with API

  @api @LoginApi
  Scenario: Login as student
    Given i login in with user name and password
    When i request POST request
    Then i should get response with HTTP status code 200
    And response should contain the API token
