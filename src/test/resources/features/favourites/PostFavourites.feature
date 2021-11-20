@BackEnd
Feature: Get favourites endpoint

  Background:
    Given [POST /favourites] request specification is built

  Scenario: I should be able to add image to favourites
    When  I create favourites request
      | image_id  |
      | 3KG57GfMW |
    And I send POST request
    Then Response status code is 200
    And Response message is SUCCESS