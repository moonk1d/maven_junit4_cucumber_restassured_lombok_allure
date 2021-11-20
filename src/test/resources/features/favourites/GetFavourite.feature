@BackEnd
Feature: Get favourite by id endpoint

  Background:
    Given [GET /favourites/{favouriteId}] request specification is built

  Scenario: I should be able to get favourite by id
    When I set pathParam "favouriteId" as "2067037"
    And I send GET request
    Then Response status code is 200