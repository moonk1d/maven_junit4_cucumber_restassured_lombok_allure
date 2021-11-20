@BackEnd
Feature: Get breeds endpoint

  Background:
    Given [GET /breeds] request specification is built

  Scenario: List breeds
    And I send GET request
    Then Response status code is 200

  Scenario: List breeds with "limit" param
    And I set queryParam "limit" as "5"
    And I send GET request
    Then Response status code is 200
    And Response size is equal to 5