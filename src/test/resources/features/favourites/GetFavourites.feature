@BackEnd
Feature: Get favourites endpoint

  Background:
    Given [GET /favourites] request specification is built

  Scenario Outline: I should be able to search favourite with [limit] parameter
    And I set queryParam "limit" as "<limit>"
    And I send GET request
    Then Response status code is 200
    And Response size is equal to <limit>
    Examples:
      | limit |
      | 1     |
      | 10    |