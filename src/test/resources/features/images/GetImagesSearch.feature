@BackEnd
Feature: Image Search endpoint

  Background:
    Given [GET /images/search] request specification is built

  Scenario Outline: I should be able to search image with [mime_types] parameter
    And I set queryParam "mime_types" as "<mime type>"
    And I send GET request
    Then Response status code is 200
    And Images mime_type is <mime type>
    Examples:
      | mime type |
      | jpg       |
      | png       |
      | gif       |

  Scenario Outline: I should be able to search image with [size] parameter
    When I set queryParam "size" as "<param value>"
    And I send GET request
    Then Response status code is 200

    Examples:
      | param value |
      | small       |
      | med         |
      | full        |
      | thumb       |

  Scenario Outline: I should be able to search image with [include_breeds] parameter
    When I set queryParam "include_breeds" as "<param value>"
    And I send GET request
    Then Response status code is 200
    And Response does/doesn't contains breeds in Response base on <param value>

    Examples:
      | param value |
      | true        |
      | false       |

  Scenario Outline: I should be able to search image with [format] parameter
    When I set queryParam "format" as "<param value>"
    And I send GET request
    Then Response status code is 200
    And Response Content Type is <content type>

    Examples:
      | param value | content type                    |
      | json        | application/json; charset=utf-8 |
      | src         | image/jpeg                      |