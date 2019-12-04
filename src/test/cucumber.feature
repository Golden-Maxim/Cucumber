Feature: As a user
  I need to find "телевизор" open the first product from list and make sure that in field type equals "Телевизоры"

  Scenario: Search for "Телевизор" and check field Type
    Given User in the main page
    When put "Телевизор" in a search line
    And click on the button Search
    Then See list of products